/*
 * Copyright 2022 Google LLC
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
 *     AnalyticsAdminServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             AnalyticsAdminServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
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
   * resources (eg: Properties, GoogleAdsLinks, Streams, UserLinks) will be permanently purged.
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
   * resources (eg: Properties, GoogleAdsLinks, Streams, UserLinks) will be permanently purged.
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
   * resources (eg: Properties, GoogleAdsLinks, Streams, UserLinks) will be permanently purged.
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
   * resources (eg: Properties, GoogleAdsLinks, Streams, UserLinks) will be permanently purged.
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
   *     (e.g., "field_to_update"). Omitted fields will not be updated. To replace the entire
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
   * resources (eg: GoogleAdsLinks, Streams, UserLinks) will be permanently purged.
   * https://support.google.com/analytics/answer/6154772
   *
   * <p>Returns an error if the target is not found, or is not an GA4 Property.
   *
   * <p>Sample code:
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
   * resources (eg: GoogleAdsLinks, Streams, UserLinks) will be permanently purged.
   * https://support.google.com/analytics/answer/6154772
   *
   * <p>Returns an error if the target is not found, or is not an GA4 Property.
   *
   * <p>Sample code:
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
   * resources (eg: GoogleAdsLinks, Streams, UserLinks) will be permanently purged.
   * https://support.google.com/analytics/answer/6154772
   *
   * <p>Returns an error if the target is not found, or is not an GA4 Property.
   *
   * <p>Sample code:
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
   * resources (eg: GoogleAdsLinks, Streams, UserLinks) will be permanently purged.
   * https://support.google.com/analytics/answer/6154772
   *
   * <p>Returns an error if the target is not found, or is not an GA4 Property.
   *
   * <p>Sample code:
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
   * Gets information about a user's link to an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UserLinkName name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]");
   *   UserLink response = analyticsAdminServiceClient.getUserLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Example format: accounts/1234/userLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserLink getUserLink(UserLinkName name) {
    GetUserLinkRequest request =
        GetUserLinkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getUserLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a user's link to an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString();
   *   UserLink response = analyticsAdminServiceClient.getUserLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Example format: accounts/1234/userLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserLink getUserLink(String name) {
    GetUserLinkRequest request = GetUserLinkRequest.newBuilder().setName(name).build();
    return getUserLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a user's link to an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetUserLinkRequest request =
   *       GetUserLinkRequest.newBuilder()
   *           .setName(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
   *           .build();
   *   UserLink response = analyticsAdminServiceClient.getUserLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserLink getUserLink(GetUserLinkRequest request) {
    return getUserLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a user's link to an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetUserLinkRequest request =
   *       GetUserLinkRequest.newBuilder()
   *           .setName(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
   *           .build();
   *   ApiFuture<UserLink> future =
   *       analyticsAdminServiceClient.getUserLinkCallable().futureCall(request);
   *   // Do something.
   *   UserLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUserLinkRequest, UserLink> getUserLinkCallable() {
    return stub.getUserLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about multiple users' links to an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchGetUserLinksRequest request =
   *       BatchGetUserLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchGetUserLinksResponse response = analyticsAdminServiceClient.batchGetUserLinks(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetUserLinksResponse batchGetUserLinks(BatchGetUserLinksRequest request) {
    return batchGetUserLinksCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about multiple users' links to an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchGetUserLinksRequest request =
   *       BatchGetUserLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchGetUserLinksResponse> future =
   *       analyticsAdminServiceClient.batchGetUserLinksCallable().futureCall(request);
   *   // Do something.
   *   BatchGetUserLinksResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchGetUserLinksRequest, BatchGetUserLinksResponse>
      batchGetUserLinksCallable() {
    return stub.batchGetUserLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user links on an account or property.
   *
   * <p>Sample code:
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
   *   for (UserLink element : analyticsAdminServiceClient.listUserLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: accounts/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserLinksPagedResponse listUserLinks(AccountName parent) {
    ListUserLinksRequest request =
        ListUserLinksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUserLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user links on an account or property.
   *
   * <p>Sample code:
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
   *   for (UserLink element : analyticsAdminServiceClient.listUserLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: accounts/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserLinksPagedResponse listUserLinks(PropertyName parent) {
    ListUserLinksRequest request =
        ListUserLinksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUserLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user links on an account or property.
   *
   * <p>Sample code:
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
   *   for (UserLink element : analyticsAdminServiceClient.listUserLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: accounts/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserLinksPagedResponse listUserLinks(String parent) {
    ListUserLinksRequest request = ListUserLinksRequest.newBuilder().setParent(parent).build();
    return listUserLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user links on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListUserLinksRequest request =
   *       ListUserLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (UserLink element : analyticsAdminServiceClient.listUserLinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserLinksPagedResponse listUserLinks(ListUserLinksRequest request) {
    return listUserLinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user links on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListUserLinksRequest request =
   *       ListUserLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<UserLink> future =
   *       analyticsAdminServiceClient.listUserLinksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (UserLink element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUserLinksRequest, ListUserLinksPagedResponse>
      listUserLinksPagedCallable() {
    return stub.listUserLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user links on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListUserLinksRequest request =
   *       ListUserLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListUserLinksResponse response =
   *         analyticsAdminServiceClient.listUserLinksCallable().call(request);
   *     for (UserLink element : response.getUserLinksList()) {
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
  public final UnaryCallable<ListUserLinksRequest, ListUserLinksResponse> listUserLinksCallable() {
    return stub.listUserLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user links on an account or property, including implicit ones that come from
   * effective permissions granted by groups or organization admin roles.
   *
   * <p>If a returned user link does not have direct permissions, they cannot be removed from the
   * account or property directly with the DeleteUserLink command. They have to be removed from the
   * group/etc that gives them permissions, which is currently only usable/discoverable in the GA or
   * GMP UIs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AuditUserLinksRequest request =
   *       AuditUserLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AuditUserLink element :
   *       analyticsAdminServiceClient.auditUserLinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuditUserLinksPagedResponse auditUserLinks(AuditUserLinksRequest request) {
    return auditUserLinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user links on an account or property, including implicit ones that come from
   * effective permissions granted by groups or organization admin roles.
   *
   * <p>If a returned user link does not have direct permissions, they cannot be removed from the
   * account or property directly with the DeleteUserLink command. They have to be removed from the
   * group/etc that gives them permissions, which is currently only usable/discoverable in the GA or
   * GMP UIs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AuditUserLinksRequest request =
   *       AuditUserLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AuditUserLink> future =
   *       analyticsAdminServiceClient.auditUserLinksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AuditUserLink element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AuditUserLinksRequest, AuditUserLinksPagedResponse>
      auditUserLinksPagedCallable() {
    return stub.auditUserLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user links on an account or property, including implicit ones that come from
   * effective permissions granted by groups or organization admin roles.
   *
   * <p>If a returned user link does not have direct permissions, they cannot be removed from the
   * account or property directly with the DeleteUserLink command. They have to be removed from the
   * group/etc that gives them permissions, which is currently only usable/discoverable in the GA or
   * GMP UIs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AuditUserLinksRequest request =
   *       AuditUserLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     AuditUserLinksResponse response =
   *         analyticsAdminServiceClient.auditUserLinksCallable().call(request);
   *     for (AuditUserLink element : response.getUserLinksList()) {
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
  public final UnaryCallable<AuditUserLinksRequest, AuditUserLinksResponse>
      auditUserLinksCallable() {
    return stub.auditUserLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user link on an account or property.
   *
   * <p>If the user with the specified email already has permissions on the account or property,
   * then the user's existing permissions will be unioned with the permissions specified in the new
   * UserLink.
   *
   * <p>Sample code:
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
   *   UserLink userLink = UserLink.newBuilder().build();
   *   UserLink response = analyticsAdminServiceClient.createUserLink(parent, userLink);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: accounts/1234
   * @param userLink Required. The user link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserLink createUserLink(AccountName parent, UserLink userLink) {
    CreateUserLinkRequest request =
        CreateUserLinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUserLink(userLink)
            .build();
    return createUserLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user link on an account or property.
   *
   * <p>If the user with the specified email already has permissions on the account or property,
   * then the user's existing permissions will be unioned with the permissions specified in the new
   * UserLink.
   *
   * <p>Sample code:
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
   *   UserLink userLink = UserLink.newBuilder().build();
   *   UserLink response = analyticsAdminServiceClient.createUserLink(parent, userLink);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: accounts/1234
   * @param userLink Required. The user link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserLink createUserLink(PropertyName parent, UserLink userLink) {
    CreateUserLinkRequest request =
        CreateUserLinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUserLink(userLink)
            .build();
    return createUserLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user link on an account or property.
   *
   * <p>If the user with the specified email already has permissions on the account or property,
   * then the user's existing permissions will be unioned with the permissions specified in the new
   * UserLink.
   *
   * <p>Sample code:
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
   *   UserLink userLink = UserLink.newBuilder().build();
   *   UserLink response = analyticsAdminServiceClient.createUserLink(parent, userLink);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: accounts/1234
   * @param userLink Required. The user link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserLink createUserLink(String parent, UserLink userLink) {
    CreateUserLinkRequest request =
        CreateUserLinkRequest.newBuilder().setParent(parent).setUserLink(userLink).build();
    return createUserLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user link on an account or property.
   *
   * <p>If the user with the specified email already has permissions on the account or property,
   * then the user's existing permissions will be unioned with the permissions specified in the new
   * UserLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateUserLinkRequest request =
   *       CreateUserLinkRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setNotifyNewUser(true)
   *           .setUserLink(UserLink.newBuilder().build())
   *           .build();
   *   UserLink response = analyticsAdminServiceClient.createUserLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserLink createUserLink(CreateUserLinkRequest request) {
    return createUserLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user link on an account or property.
   *
   * <p>If the user with the specified email already has permissions on the account or property,
   * then the user's existing permissions will be unioned with the permissions specified in the new
   * UserLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateUserLinkRequest request =
   *       CreateUserLinkRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setNotifyNewUser(true)
   *           .setUserLink(UserLink.newBuilder().build())
   *           .build();
   *   ApiFuture<UserLink> future =
   *       analyticsAdminServiceClient.createUserLinkCallable().futureCall(request);
   *   // Do something.
   *   UserLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateUserLinkRequest, UserLink> createUserLinkCallable() {
    return stub.createUserLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates information about multiple users' links to an account or property.
   *
   * <p>This method is transactional. If any UserLink cannot be created, none of the UserLinks will
   * be created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchCreateUserLinksRequest request =
   *       BatchCreateUserLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setNotifyNewUsers(true)
   *           .addAllRequests(new ArrayList<CreateUserLinkRequest>())
   *           .build();
   *   BatchCreateUserLinksResponse response =
   *       analyticsAdminServiceClient.batchCreateUserLinks(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateUserLinksResponse batchCreateUserLinks(
      BatchCreateUserLinksRequest request) {
    return batchCreateUserLinksCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates information about multiple users' links to an account or property.
   *
   * <p>This method is transactional. If any UserLink cannot be created, none of the UserLinks will
   * be created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchCreateUserLinksRequest request =
   *       BatchCreateUserLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setNotifyNewUsers(true)
   *           .addAllRequests(new ArrayList<CreateUserLinkRequest>())
   *           .build();
   *   ApiFuture<BatchCreateUserLinksResponse> future =
   *       analyticsAdminServiceClient.batchCreateUserLinksCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateUserLinksResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateUserLinksRequest, BatchCreateUserLinksResponse>
      batchCreateUserLinksCallable() {
    return stub.batchCreateUserLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user link on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UserLink userLink = UserLink.newBuilder().build();
   *   UserLink response = analyticsAdminServiceClient.updateUserLink(userLink);
   * }
   * }</pre>
   *
   * @param userLink Required. The user link to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserLink updateUserLink(UserLink userLink) {
    UpdateUserLinkRequest request =
        UpdateUserLinkRequest.newBuilder().setUserLink(userLink).build();
    return updateUserLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user link on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateUserLinkRequest request =
   *       UpdateUserLinkRequest.newBuilder().setUserLink(UserLink.newBuilder().build()).build();
   *   UserLink response = analyticsAdminServiceClient.updateUserLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserLink updateUserLink(UpdateUserLinkRequest request) {
    return updateUserLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user link on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateUserLinkRequest request =
   *       UpdateUserLinkRequest.newBuilder().setUserLink(UserLink.newBuilder().build()).build();
   *   ApiFuture<UserLink> future =
   *       analyticsAdminServiceClient.updateUserLinkCallable().futureCall(request);
   *   // Do something.
   *   UserLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateUserLinkRequest, UserLink> updateUserLinkCallable() {
    return stub.updateUserLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates information about multiple users' links to an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchUpdateUserLinksRequest request =
   *       BatchUpdateUserLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .addAllRequests(new ArrayList<UpdateUserLinkRequest>())
   *           .build();
   *   BatchUpdateUserLinksResponse response =
   *       analyticsAdminServiceClient.batchUpdateUserLinks(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateUserLinksResponse batchUpdateUserLinks(
      BatchUpdateUserLinksRequest request) {
    return batchUpdateUserLinksCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates information about multiple users' links to an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchUpdateUserLinksRequest request =
   *       BatchUpdateUserLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .addAllRequests(new ArrayList<UpdateUserLinkRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateUserLinksResponse> future =
   *       analyticsAdminServiceClient.batchUpdateUserLinksCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateUserLinksResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateUserLinksRequest, BatchUpdateUserLinksResponse>
      batchUpdateUserLinksCallable() {
    return stub.batchUpdateUserLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a user link on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UserLinkName name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]");
   *   analyticsAdminServiceClient.deleteUserLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Example format: accounts/1234/userLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUserLink(UserLinkName name) {
    DeleteUserLinkRequest request =
        DeleteUserLinkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteUserLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a user link on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString();
   *   analyticsAdminServiceClient.deleteUserLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Example format: accounts/1234/userLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUserLink(String name) {
    DeleteUserLinkRequest request = DeleteUserLinkRequest.newBuilder().setName(name).build();
    deleteUserLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a user link on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteUserLinkRequest request =
   *       DeleteUserLinkRequest.newBuilder()
   *           .setName(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteUserLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUserLink(DeleteUserLinkRequest request) {
    deleteUserLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a user link on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteUserLinkRequest request =
   *       DeleteUserLinkRequest.newBuilder()
   *           .setName(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteUserLinkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteUserLinkRequest, Empty> deleteUserLinkCallable() {
    return stub.deleteUserLinkCallable();
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
   *   BatchDeleteUserLinksRequest request =
   *       BatchDeleteUserLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .addAllRequests(new ArrayList<DeleteUserLinkRequest>())
   *           .build();
   *   analyticsAdminServiceClient.batchDeleteUserLinks(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteUserLinks(BatchDeleteUserLinksRequest request) {
    batchDeleteUserLinksCallable().call(request);
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
   *   BatchDeleteUserLinksRequest request =
   *       BatchDeleteUserLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .addAllRequests(new ArrayList<DeleteUserLinkRequest>())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.batchDeleteUserLinksCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteUserLinksRequest, Empty> batchDeleteUserLinksCallable() {
    return stub.batchDeleteUserLinksCallable();
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
   * @param updateMask The list of fields to be updated. Omitted fields will not be updated.
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
   * <p>This acknowledgement must be completed (either in the Google Analytics UI or via this API)
   * before MeasurementProtocolSecret resources may be created.
   *
   * <p>Sample code:
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
   * <p>This acknowledgement must be completed (either in the Google Analytics UI or via this API)
   * before MeasurementProtocolSecret resources may be created.
   *
   * <p>Sample code:
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
   * Lookup for a single Audience. Audiences created before 2020 may not be supported.
   *
   * <p>Sample code:
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
   * Lookup for a single Audience. Audiences created before 2020 may not be supported.
   *
   * <p>Sample code:
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
   * Lookup for a single Audience. Audiences created before 2020 may not be supported.
   *
   * <p>Sample code:
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
   * Lookup for a single Audience. Audiences created before 2020 may not be supported.
   *
   * <p>Sample code:
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
   * Lists Audiences on a property. Audiences created before 2020 may not be supported.
   *
   * <p>Sample code:
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
   * Lists Audiences on a property. Audiences created before 2020 may not be supported.
   *
   * <p>Sample code:
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
   * Lists Audiences on a property. Audiences created before 2020 may not be supported.
   *
   * <p>Sample code:
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
   * Lists Audiences on a property. Audiences created before 2020 may not be supported.
   *
   * <p>Sample code:
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
   * Lists Audiences on a property. Audiences created before 2020 may not be supported.
   *
   * <p>Sample code:
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
   * <p>Data Access Reports can be requested for a property. The property must be in Google
   * Analytics 360. This method is only available to Administrators.
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
   * <p>Data Access Reports can be requested for a property. The property must be in Google
   * Analytics 360. This method is only available to Administrators.
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

  public static class ListUserLinksPagedResponse
      extends AbstractPagedListResponse<
          ListUserLinksRequest,
          ListUserLinksResponse,
          UserLink,
          ListUserLinksPage,
          ListUserLinksFixedSizeCollection> {

    public static ApiFuture<ListUserLinksPagedResponse> createAsync(
        PageContext<ListUserLinksRequest, ListUserLinksResponse, UserLink> context,
        ApiFuture<ListUserLinksResponse> futureResponse) {
      ApiFuture<ListUserLinksPage> futurePage =
          ListUserLinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUserLinksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUserLinksPagedResponse(ListUserLinksPage page) {
      super(page, ListUserLinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUserLinksPage
      extends AbstractPage<
          ListUserLinksRequest, ListUserLinksResponse, UserLink, ListUserLinksPage> {

    private ListUserLinksPage(
        PageContext<ListUserLinksRequest, ListUserLinksResponse, UserLink> context,
        ListUserLinksResponse response) {
      super(context, response);
    }

    private static ListUserLinksPage createEmptyPage() {
      return new ListUserLinksPage(null, null);
    }

    @Override
    protected ListUserLinksPage createPage(
        PageContext<ListUserLinksRequest, ListUserLinksResponse, UserLink> context,
        ListUserLinksResponse response) {
      return new ListUserLinksPage(context, response);
    }

    @Override
    public ApiFuture<ListUserLinksPage> createPageAsync(
        PageContext<ListUserLinksRequest, ListUserLinksResponse, UserLink> context,
        ApiFuture<ListUserLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUserLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUserLinksRequest,
          ListUserLinksResponse,
          UserLink,
          ListUserLinksPage,
          ListUserLinksFixedSizeCollection> {

    private ListUserLinksFixedSizeCollection(List<ListUserLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUserLinksFixedSizeCollection createEmptyCollection() {
      return new ListUserLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUserLinksFixedSizeCollection createCollection(
        List<ListUserLinksPage> pages, int collectionSize) {
      return new ListUserLinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class AuditUserLinksPagedResponse
      extends AbstractPagedListResponse<
          AuditUserLinksRequest,
          AuditUserLinksResponse,
          AuditUserLink,
          AuditUserLinksPage,
          AuditUserLinksFixedSizeCollection> {

    public static ApiFuture<AuditUserLinksPagedResponse> createAsync(
        PageContext<AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLink> context,
        ApiFuture<AuditUserLinksResponse> futureResponse) {
      ApiFuture<AuditUserLinksPage> futurePage =
          AuditUserLinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AuditUserLinksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private AuditUserLinksPagedResponse(AuditUserLinksPage page) {
      super(page, AuditUserLinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AuditUserLinksPage
      extends AbstractPage<
          AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLink, AuditUserLinksPage> {

    private AuditUserLinksPage(
        PageContext<AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLink> context,
        AuditUserLinksResponse response) {
      super(context, response);
    }

    private static AuditUserLinksPage createEmptyPage() {
      return new AuditUserLinksPage(null, null);
    }

    @Override
    protected AuditUserLinksPage createPage(
        PageContext<AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLink> context,
        AuditUserLinksResponse response) {
      return new AuditUserLinksPage(context, response);
    }

    @Override
    public ApiFuture<AuditUserLinksPage> createPageAsync(
        PageContext<AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLink> context,
        ApiFuture<AuditUserLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AuditUserLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AuditUserLinksRequest,
          AuditUserLinksResponse,
          AuditUserLink,
          AuditUserLinksPage,
          AuditUserLinksFixedSizeCollection> {

    private AuditUserLinksFixedSizeCollection(List<AuditUserLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AuditUserLinksFixedSizeCollection createEmptyCollection() {
      return new AuditUserLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected AuditUserLinksFixedSizeCollection createCollection(
        List<AuditUserLinksPage> pages, int collectionSize) {
      return new AuditUserLinksFixedSizeCollection(pages, collectionSize);
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
}
