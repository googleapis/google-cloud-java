/*
 * Copyright 2020 Google LLC
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
import com.google.api.core.ApiFunction;
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
 * AnalyticsAdminServiceSettings analyticsAdminServiceSettings =
 *     AnalyticsAdminServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
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
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AnalyticsAdminServiceClient(AnalyticsAdminServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AnalyticsAdminServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   while (true) {
   *     ListAccountsResponse response =
   *         analyticsAdminServiceClient.listAccountsCallable().call(request);
   *     for (Account element : response.getResponsesList()) {
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
   * @param updateMask Required. The list of fields to be updated. Omitted fields will not be
   *     updated. To replace the entire entity, use one path with the string "&#42;" to match all
   *     fields.
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   while (true) {
   *     ListAccountSummariesResponse response =
   *         analyticsAdminServiceClient.listAccountSummariesCallable().call(request);
   *     for (AccountSummary element : response.getResponsesList()) {
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   while (true) {
   *     ListPropertiesResponse response =
   *         analyticsAdminServiceClient.listPropertiesCallable().call(request);
   *     for (Property element : response.getResponsesList()) {
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName name = PropertyName.of("[PROPERTY]");
   *   analyticsAdminServiceClient.deleteProperty(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Property to soft-delete. Format: properties/{property_id}
   *     Example: "properties/1000"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProperty(PropertyName name) {
    DeletePropertyRequest request =
        DeletePropertyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteProperty(request);
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = PropertyName.of("[PROPERTY]").toString();
   *   analyticsAdminServiceClient.deleteProperty(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Property to soft-delete. Format: properties/{property_id}
   *     Example: "properties/1000"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProperty(String name) {
    DeletePropertyRequest request = DeletePropertyRequest.newBuilder().setName(name).build();
    deleteProperty(request);
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeletePropertyRequest request =
   *       DeletePropertyRequest.newBuilder()
   *           .setName(PropertyName.of("[PROPERTY]").toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteProperty(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProperty(DeletePropertyRequest request) {
    deletePropertyCallable().call(request);
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeletePropertyRequest request =
   *       DeletePropertyRequest.newBuilder()
   *           .setName(PropertyName.of("[PROPERTY]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deletePropertyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePropertyRequest, Empty> deletePropertyCallable() {
    return stub.deletePropertyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
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
   * @param updateMask Required. The list of fields to be updated. Omitted fields will not be
   *     updated. To replace the entire entity, use one path with the string "&#42;" to match all
   *     fields.
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchGetUserLinksRequest request =
   *       BatchGetUserLinksRequest.newBuilder()
   *           .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchGetUserLinksRequest request =
   *       BatchGetUserLinksRequest.newBuilder()
   *           .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString();
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListUserLinksRequest request =
   *       ListUserLinksRequest.newBuilder()
   *           .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListUserLinksRequest request =
   *       ListUserLinksRequest.newBuilder()
   *           .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   while (true) {
   *     ListUserLinksResponse response =
   *         analyticsAdminServiceClient.listUserLinksCallable().call(request);
   *     for (UserLink element : response.getResponsesList()) {
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AuditUserLinksRequest request =
   *       AuditUserLinksRequest.newBuilder()
   *           .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AuditUserLinksRequest request =
   *       AuditUserLinksRequest.newBuilder()
   *           .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   while (true) {
   *     AuditUserLinksResponse response =
   *         analyticsAdminServiceClient.auditUserLinksCallable().call(request);
   *     for (AuditUserLink element : response.getResponsesList()) {
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString();
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateUserLinkRequest request =
   *       CreateUserLinkRequest.newBuilder()
   *           .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateUserLinkRequest request =
   *       CreateUserLinkRequest.newBuilder()
   *           .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchCreateUserLinksRequest request =
   *       BatchCreateUserLinksRequest.newBuilder()
   *           .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchCreateUserLinksRequest request =
   *       BatchCreateUserLinksRequest.newBuilder()
   *           .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchUpdateUserLinksRequest request =
   *       BatchUpdateUserLinksRequest.newBuilder()
   *           .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchUpdateUserLinksRequest request =
   *       BatchUpdateUserLinksRequest.newBuilder()
   *           .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchDeleteUserLinksRequest request =
   *       BatchDeleteUserLinksRequest.newBuilder()
   *           .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchDeleteUserLinksRequest request =
   *       BatchDeleteUserLinksRequest.newBuilder()
   *           .setParent(UserLinkName.ofAccountUserLinkName("[ACCOUNT]", "[USER_LINK]").toString())
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
   * Lookup for a single WebDataStream
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   WebDataStreamName name = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]");
   *   WebDataStream response = analyticsAdminServiceClient.getWebDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the web data stream to lookup. Format:
   *     properties/{property_id}/webDataStreams/{stream_id} Example:
   *     "properties/123/webDataStreams/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WebDataStream getWebDataStream(WebDataStreamName name) {
    GetWebDataStreamRequest request =
        GetWebDataStreamRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getWebDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single WebDataStream
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString();
   *   WebDataStream response = analyticsAdminServiceClient.getWebDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the web data stream to lookup. Format:
   *     properties/{property_id}/webDataStreams/{stream_id} Example:
   *     "properties/123/webDataStreams/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WebDataStream getWebDataStream(String name) {
    GetWebDataStreamRequest request = GetWebDataStreamRequest.newBuilder().setName(name).build();
    return getWebDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single WebDataStream
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetWebDataStreamRequest request =
   *       GetWebDataStreamRequest.newBuilder()
   *           .setName(WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
   *           .build();
   *   WebDataStream response = analyticsAdminServiceClient.getWebDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WebDataStream getWebDataStream(GetWebDataStreamRequest request) {
    return getWebDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single WebDataStream
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetWebDataStreamRequest request =
   *       GetWebDataStreamRequest.newBuilder()
   *           .setName(WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
   *           .build();
   *   ApiFuture<WebDataStream> future =
   *       analyticsAdminServiceClient.getWebDataStreamCallable().futureCall(request);
   *   // Do something.
   *   WebDataStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWebDataStreamRequest, WebDataStream> getWebDataStreamCallable() {
    return stub.getWebDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a web stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   WebDataStreamName name = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]");
   *   analyticsAdminServiceClient.deleteWebDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the web data stream to delete. Format:
   *     properties/{property_id}/webDataStreams/{stream_id} Example:
   *     "properties/123/webDataStreams/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWebDataStream(WebDataStreamName name) {
    DeleteWebDataStreamRequest request =
        DeleteWebDataStreamRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteWebDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a web stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString();
   *   analyticsAdminServiceClient.deleteWebDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the web data stream to delete. Format:
   *     properties/{property_id}/webDataStreams/{stream_id} Example:
   *     "properties/123/webDataStreams/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWebDataStream(String name) {
    DeleteWebDataStreamRequest request =
        DeleteWebDataStreamRequest.newBuilder().setName(name).build();
    deleteWebDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a web stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteWebDataStreamRequest request =
   *       DeleteWebDataStreamRequest.newBuilder()
   *           .setName(WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteWebDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWebDataStream(DeleteWebDataStreamRequest request) {
    deleteWebDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a web stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteWebDataStreamRequest request =
   *       DeleteWebDataStreamRequest.newBuilder()
   *           .setName(WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteWebDataStreamCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWebDataStreamRequest, Empty> deleteWebDataStreamCallable() {
    return stub.deleteWebDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a web stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   WebDataStream webDataStream = WebDataStream.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   WebDataStream response =
   *       analyticsAdminServiceClient.updateWebDataStream(webDataStream, updateMask);
   * }
   * }</pre>
   *
   * @param webDataStream Required. The web stream to update. The `name` field is used to identify
   *     the web stream to be updated.
   * @param updateMask Required. The list of fields to be updated. Omitted fields will not be
   *     updated. To replace the entire entity, use one path with the string "&#42;" to match all
   *     fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WebDataStream updateWebDataStream(
      WebDataStream webDataStream, FieldMask updateMask) {
    UpdateWebDataStreamRequest request =
        UpdateWebDataStreamRequest.newBuilder()
            .setWebDataStream(webDataStream)
            .setUpdateMask(updateMask)
            .build();
    return updateWebDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a web stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateWebDataStreamRequest request =
   *       UpdateWebDataStreamRequest.newBuilder()
   *           .setWebDataStream(WebDataStream.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   WebDataStream response = analyticsAdminServiceClient.updateWebDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WebDataStream updateWebDataStream(UpdateWebDataStreamRequest request) {
    return updateWebDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a web stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateWebDataStreamRequest request =
   *       UpdateWebDataStreamRequest.newBuilder()
   *           .setWebDataStream(WebDataStream.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<WebDataStream> future =
   *       analyticsAdminServiceClient.updateWebDataStreamCallable().futureCall(request);
   *   // Do something.
   *   WebDataStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateWebDataStreamRequest, WebDataStream>
      updateWebDataStreamCallable() {
    return stub.updateWebDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a web stream with the specified location and attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   WebDataStream webDataStream = WebDataStream.newBuilder().build();
   *   WebDataStream response =
   *       analyticsAdminServiceClient.createWebDataStream(parent, webDataStream);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this web data stream will be created. Format:
   *     properties/123
   * @param webDataStream Required. The web stream to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WebDataStream createWebDataStream(PropertyName parent, WebDataStream webDataStream) {
    CreateWebDataStreamRequest request =
        CreateWebDataStreamRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWebDataStream(webDataStream)
            .build();
    return createWebDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a web stream with the specified location and attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString();
   *   WebDataStream webDataStream = WebDataStream.newBuilder().build();
   *   WebDataStream response =
   *       analyticsAdminServiceClient.createWebDataStream(parent, webDataStream);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this web data stream will be created. Format:
   *     properties/123
   * @param webDataStream Required. The web stream to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WebDataStream createWebDataStream(String parent, WebDataStream webDataStream) {
    CreateWebDataStreamRequest request =
        CreateWebDataStreamRequest.newBuilder()
            .setParent(parent)
            .setWebDataStream(webDataStream)
            .build();
    return createWebDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a web stream with the specified location and attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateWebDataStreamRequest request =
   *       CreateWebDataStreamRequest.newBuilder()
   *           .setWebDataStream(WebDataStream.newBuilder().build())
   *           .setParent(WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
   *           .build();
   *   WebDataStream response = analyticsAdminServiceClient.createWebDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WebDataStream createWebDataStream(CreateWebDataStreamRequest request) {
    return createWebDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a web stream with the specified location and attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateWebDataStreamRequest request =
   *       CreateWebDataStreamRequest.newBuilder()
   *           .setWebDataStream(WebDataStream.newBuilder().build())
   *           .setParent(WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
   *           .build();
   *   ApiFuture<WebDataStream> future =
   *       analyticsAdminServiceClient.createWebDataStreamCallable().futureCall(request);
   *   // Do something.
   *   WebDataStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWebDataStreamRequest, WebDataStream>
      createWebDataStreamCallable() {
    return stub.createWebDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child web data streams under the specified parent property.
   *
   * <p>Web data streams will be excluded if the caller does not have access. Returns an empty list
   * if no relevant web data streams are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (WebDataStream element :
   *       analyticsAdminServiceClient.listWebDataStreams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent property. For example, to list results of web
   *     streams under the property with Id 123: "properties/123"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWebDataStreamsPagedResponse listWebDataStreams(PropertyName parent) {
    ListWebDataStreamsRequest request =
        ListWebDataStreamsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWebDataStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child web data streams under the specified parent property.
   *
   * <p>Web data streams will be excluded if the caller does not have access. Returns an empty list
   * if no relevant web data streams are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString();
   *   for (WebDataStream element :
   *       analyticsAdminServiceClient.listWebDataStreams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent property. For example, to list results of web
   *     streams under the property with Id 123: "properties/123"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWebDataStreamsPagedResponse listWebDataStreams(String parent) {
    ListWebDataStreamsRequest request =
        ListWebDataStreamsRequest.newBuilder().setParent(parent).build();
    return listWebDataStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child web data streams under the specified parent property.
   *
   * <p>Web data streams will be excluded if the caller does not have access. Returns an empty list
   * if no relevant web data streams are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListWebDataStreamsRequest request =
   *       ListWebDataStreamsRequest.newBuilder()
   *           .setParent(WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (WebDataStream element :
   *       analyticsAdminServiceClient.listWebDataStreams(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWebDataStreamsPagedResponse listWebDataStreams(
      ListWebDataStreamsRequest request) {
    return listWebDataStreamsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child web data streams under the specified parent property.
   *
   * <p>Web data streams will be excluded if the caller does not have access. Returns an empty list
   * if no relevant web data streams are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListWebDataStreamsRequest request =
   *       ListWebDataStreamsRequest.newBuilder()
   *           .setParent(WebDataStreamName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<WebDataStream> future =
   *       analyticsAdminServiceClient.listWebDataStreamsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (WebDataStream element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWebDataStreamsRequest, ListWebDataStreamsPagedResponse>
      listWebDataStreamsPagedCallable() {
    return stub.listWebDataStreamsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child web data streams under the specified parent property.
   *
   * <p>Web data streams will be excluded if the caller does not have access. Returns an empty list
   * if no relevant web data streams are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   while (true) {
   *     ListWebDataStreamsResponse response =
   *         analyticsAdminServiceClient.listWebDataStreamsCallable().call(request);
   *     for (WebDataStream element : response.getResponsesList()) {
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
  public final UnaryCallable<ListWebDataStreamsRequest, ListWebDataStreamsResponse>
      listWebDataStreamsCallable() {
    return stub.listWebDataStreamsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single IosAppDataStream
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   IosAppDataStreamName name = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]");
   *   IosAppDataStream response = analyticsAdminServiceClient.getIosAppDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the iOS app data stream to lookup. Format:
   *     properties/{property_id}/iosAppDataStreams/{stream_id} Example:
   *     "properties/123/iosAppDataStreams/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IosAppDataStream getIosAppDataStream(IosAppDataStreamName name) {
    GetIosAppDataStreamRequest request =
        GetIosAppDataStreamRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getIosAppDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single IosAppDataStream
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString();
   *   IosAppDataStream response = analyticsAdminServiceClient.getIosAppDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the iOS app data stream to lookup. Format:
   *     properties/{property_id}/iosAppDataStreams/{stream_id} Example:
   *     "properties/123/iosAppDataStreams/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IosAppDataStream getIosAppDataStream(String name) {
    GetIosAppDataStreamRequest request =
        GetIosAppDataStreamRequest.newBuilder().setName(name).build();
    return getIosAppDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single IosAppDataStream
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetIosAppDataStreamRequest request =
   *       GetIosAppDataStreamRequest.newBuilder()
   *           .setName(IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString())
   *           .build();
   *   IosAppDataStream response = analyticsAdminServiceClient.getIosAppDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IosAppDataStream getIosAppDataStream(GetIosAppDataStreamRequest request) {
    return getIosAppDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single IosAppDataStream
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetIosAppDataStreamRequest request =
   *       GetIosAppDataStreamRequest.newBuilder()
   *           .setName(IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString())
   *           .build();
   *   ApiFuture<IosAppDataStream> future =
   *       analyticsAdminServiceClient.getIosAppDataStreamCallable().futureCall(request);
   *   // Do something.
   *   IosAppDataStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIosAppDataStreamRequest, IosAppDataStream>
      getIosAppDataStreamCallable() {
    return stub.getIosAppDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an iOS app stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   IosAppDataStreamName name = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]");
   *   analyticsAdminServiceClient.deleteIosAppDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the iOS app data stream to delete. Format:
   *     properties/{property_id}/iosAppDataStreams/{stream_id} Example:
   *     "properties/123/iosAppDataStreams/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIosAppDataStream(IosAppDataStreamName name) {
    DeleteIosAppDataStreamRequest request =
        DeleteIosAppDataStreamRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteIosAppDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an iOS app stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString();
   *   analyticsAdminServiceClient.deleteIosAppDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the iOS app data stream to delete. Format:
   *     properties/{property_id}/iosAppDataStreams/{stream_id} Example:
   *     "properties/123/iosAppDataStreams/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIosAppDataStream(String name) {
    DeleteIosAppDataStreamRequest request =
        DeleteIosAppDataStreamRequest.newBuilder().setName(name).build();
    deleteIosAppDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an iOS app stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteIosAppDataStreamRequest request =
   *       DeleteIosAppDataStreamRequest.newBuilder()
   *           .setName(IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteIosAppDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIosAppDataStream(DeleteIosAppDataStreamRequest request) {
    deleteIosAppDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an iOS app stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteIosAppDataStreamRequest request =
   *       DeleteIosAppDataStreamRequest.newBuilder()
   *           .setName(IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteIosAppDataStreamCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIosAppDataStreamRequest, Empty>
      deleteIosAppDataStreamCallable() {
    return stub.deleteIosAppDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an iOS app stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   IosAppDataStream iosAppDataStream = IosAppDataStream.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   IosAppDataStream response =
   *       analyticsAdminServiceClient.updateIosAppDataStream(iosAppDataStream, updateMask);
   * }
   * }</pre>
   *
   * @param iosAppDataStream Required. The iOS app stream to update. The `name` field is used to
   *     identify the iOS app stream to be updated.
   * @param updateMask Required. The list of fields to be updated. Omitted fields will not be
   *     updated. To replace the entire entity, use one path with the string "&#42;" to match all
   *     fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IosAppDataStream updateIosAppDataStream(
      IosAppDataStream iosAppDataStream, FieldMask updateMask) {
    UpdateIosAppDataStreamRequest request =
        UpdateIosAppDataStreamRequest.newBuilder()
            .setIosAppDataStream(iosAppDataStream)
            .setUpdateMask(updateMask)
            .build();
    return updateIosAppDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an iOS app stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateIosAppDataStreamRequest request =
   *       UpdateIosAppDataStreamRequest.newBuilder()
   *           .setIosAppDataStream(IosAppDataStream.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   IosAppDataStream response = analyticsAdminServiceClient.updateIosAppDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IosAppDataStream updateIosAppDataStream(UpdateIosAppDataStreamRequest request) {
    return updateIosAppDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an iOS app stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateIosAppDataStreamRequest request =
   *       UpdateIosAppDataStreamRequest.newBuilder()
   *           .setIosAppDataStream(IosAppDataStream.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<IosAppDataStream> future =
   *       analyticsAdminServiceClient.updateIosAppDataStreamCallable().futureCall(request);
   *   // Do something.
   *   IosAppDataStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIosAppDataStreamRequest, IosAppDataStream>
      updateIosAppDataStreamCallable() {
    return stub.updateIosAppDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an iOS app data stream with the specified location and attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   IosAppDataStream iosAppDataStream = IosAppDataStream.newBuilder().build();
   *   IosAppDataStream response =
   *       analyticsAdminServiceClient.createIosAppDataStream(parent, iosAppDataStream);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this ios app data stream will be created.
   *     Format: properties/123
   * @param iosAppDataStream Required. The iOS app data stream to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IosAppDataStream createIosAppDataStream(
      PropertyName parent, IosAppDataStream iosAppDataStream) {
    CreateIosAppDataStreamRequest request =
        CreateIosAppDataStreamRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setIosAppDataStream(iosAppDataStream)
            .build();
    return createIosAppDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an iOS app data stream with the specified location and attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString();
   *   IosAppDataStream iosAppDataStream = IosAppDataStream.newBuilder().build();
   *   IosAppDataStream response =
   *       analyticsAdminServiceClient.createIosAppDataStream(parent, iosAppDataStream);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this ios app data stream will be created.
   *     Format: properties/123
   * @param iosAppDataStream Required. The iOS app data stream to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IosAppDataStream createIosAppDataStream(
      String parent, IosAppDataStream iosAppDataStream) {
    CreateIosAppDataStreamRequest request =
        CreateIosAppDataStreamRequest.newBuilder()
            .setParent(parent)
            .setIosAppDataStream(iosAppDataStream)
            .build();
    return createIosAppDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an iOS app data stream with the specified location and attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateIosAppDataStreamRequest request =
   *       CreateIosAppDataStreamRequest.newBuilder()
   *           .setIosAppDataStream(IosAppDataStream.newBuilder().build())
   *           .setParent(IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString())
   *           .build();
   *   IosAppDataStream response = analyticsAdminServiceClient.createIosAppDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IosAppDataStream createIosAppDataStream(CreateIosAppDataStreamRequest request) {
    return createIosAppDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an iOS app data stream with the specified location and attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateIosAppDataStreamRequest request =
   *       CreateIosAppDataStreamRequest.newBuilder()
   *           .setIosAppDataStream(IosAppDataStream.newBuilder().build())
   *           .setParent(IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString())
   *           .build();
   *   ApiFuture<IosAppDataStream> future =
   *       analyticsAdminServiceClient.createIosAppDataStreamCallable().futureCall(request);
   *   // Do something.
   *   IosAppDataStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIosAppDataStreamRequest, IosAppDataStream>
      createIosAppDataStreamCallable() {
    return stub.createIosAppDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child iOS app data streams under the specified parent property.
   *
   * <p>iOS app data streams will be excluded if the caller does not have access. Returns an empty
   * list if no relevant iOS app data streams are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (IosAppDataStream element :
   *       analyticsAdminServiceClient.listIosAppDataStreams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent property. For example, to list results of app
   *     streams under the property with Id 123: "properties/123"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIosAppDataStreamsPagedResponse listIosAppDataStreams(PropertyName parent) {
    ListIosAppDataStreamsRequest request =
        ListIosAppDataStreamsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listIosAppDataStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child iOS app data streams under the specified parent property.
   *
   * <p>iOS app data streams will be excluded if the caller does not have access. Returns an empty
   * list if no relevant iOS app data streams are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString();
   *   for (IosAppDataStream element :
   *       analyticsAdminServiceClient.listIosAppDataStreams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent property. For example, to list results of app
   *     streams under the property with Id 123: "properties/123"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIosAppDataStreamsPagedResponse listIosAppDataStreams(String parent) {
    ListIosAppDataStreamsRequest request =
        ListIosAppDataStreamsRequest.newBuilder().setParent(parent).build();
    return listIosAppDataStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child iOS app data streams under the specified parent property.
   *
   * <p>iOS app data streams will be excluded if the caller does not have access. Returns an empty
   * list if no relevant iOS app data streams are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListIosAppDataStreamsRequest request =
   *       ListIosAppDataStreamsRequest.newBuilder()
   *           .setParent(IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (IosAppDataStream element :
   *       analyticsAdminServiceClient.listIosAppDataStreams(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIosAppDataStreamsPagedResponse listIosAppDataStreams(
      ListIosAppDataStreamsRequest request) {
    return listIosAppDataStreamsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child iOS app data streams under the specified parent property.
   *
   * <p>iOS app data streams will be excluded if the caller does not have access. Returns an empty
   * list if no relevant iOS app data streams are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListIosAppDataStreamsRequest request =
   *       ListIosAppDataStreamsRequest.newBuilder()
   *           .setParent(IosAppDataStreamName.of("[PROPERTY]", "[IOS_APP_DATA_STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<IosAppDataStream> future =
   *       analyticsAdminServiceClient.listIosAppDataStreamsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (IosAppDataStream element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIosAppDataStreamsRequest, ListIosAppDataStreamsPagedResponse>
      listIosAppDataStreamsPagedCallable() {
    return stub.listIosAppDataStreamsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child iOS app data streams under the specified parent property.
   *
   * <p>iOS app data streams will be excluded if the caller does not have access. Returns an empty
   * list if no relevant iOS app data streams are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   while (true) {
   *     ListIosAppDataStreamsResponse response =
   *         analyticsAdminServiceClient.listIosAppDataStreamsCallable().call(request);
   *     for (IosAppDataStream element : response.getResponsesList()) {
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
  public final UnaryCallable<ListIosAppDataStreamsRequest, ListIosAppDataStreamsResponse>
      listIosAppDataStreamsCallable() {
    return stub.listIosAppDataStreamsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single AndroidAppDataStream
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AndroidAppDataStreamName name =
   *       AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]");
   *   AndroidAppDataStream response = analyticsAdminServiceClient.getAndroidAppDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the android app data stream to lookup. Format:
   *     properties/{property_id}/androidAppDataStreams/{stream_id} Example:
   *     "properties/123/androidAppDataStreams/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AndroidAppDataStream getAndroidAppDataStream(AndroidAppDataStreamName name) {
    GetAndroidAppDataStreamRequest request =
        GetAndroidAppDataStreamRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAndroidAppDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single AndroidAppDataStream
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString();
   *   AndroidAppDataStream response = analyticsAdminServiceClient.getAndroidAppDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the android app data stream to lookup. Format:
   *     properties/{property_id}/androidAppDataStreams/{stream_id} Example:
   *     "properties/123/androidAppDataStreams/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AndroidAppDataStream getAndroidAppDataStream(String name) {
    GetAndroidAppDataStreamRequest request =
        GetAndroidAppDataStreamRequest.newBuilder().setName(name).build();
    return getAndroidAppDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single AndroidAppDataStream
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetAndroidAppDataStreamRequest request =
   *       GetAndroidAppDataStreamRequest.newBuilder()
   *           .setName(
   *               AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString())
   *           .build();
   *   AndroidAppDataStream response = analyticsAdminServiceClient.getAndroidAppDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AndroidAppDataStream getAndroidAppDataStream(
      GetAndroidAppDataStreamRequest request) {
    return getAndroidAppDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single AndroidAppDataStream
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetAndroidAppDataStreamRequest request =
   *       GetAndroidAppDataStreamRequest.newBuilder()
   *           .setName(
   *               AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString())
   *           .build();
   *   ApiFuture<AndroidAppDataStream> future =
   *       analyticsAdminServiceClient.getAndroidAppDataStreamCallable().futureCall(request);
   *   // Do something.
   *   AndroidAppDataStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAndroidAppDataStreamRequest, AndroidAppDataStream>
      getAndroidAppDataStreamCallable() {
    return stub.getAndroidAppDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an android app stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AndroidAppDataStreamName name =
   *       AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]");
   *   analyticsAdminServiceClient.deleteAndroidAppDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the android app data stream to delete. Format:
   *     properties/{property_id}/androidAppDataStreams/{stream_id} Example:
   *     "properties/123/androidAppDataStreams/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAndroidAppDataStream(AndroidAppDataStreamName name) {
    DeleteAndroidAppDataStreamRequest request =
        DeleteAndroidAppDataStreamRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAndroidAppDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an android app stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString();
   *   analyticsAdminServiceClient.deleteAndroidAppDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the android app data stream to delete. Format:
   *     properties/{property_id}/androidAppDataStreams/{stream_id} Example:
   *     "properties/123/androidAppDataStreams/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAndroidAppDataStream(String name) {
    DeleteAndroidAppDataStreamRequest request =
        DeleteAndroidAppDataStreamRequest.newBuilder().setName(name).build();
    deleteAndroidAppDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an android app stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteAndroidAppDataStreamRequest request =
   *       DeleteAndroidAppDataStreamRequest.newBuilder()
   *           .setName(
   *               AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteAndroidAppDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAndroidAppDataStream(DeleteAndroidAppDataStreamRequest request) {
    deleteAndroidAppDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an android app stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteAndroidAppDataStreamRequest request =
   *       DeleteAndroidAppDataStreamRequest.newBuilder()
   *           .setName(
   *               AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteAndroidAppDataStreamCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAndroidAppDataStreamRequest, Empty>
      deleteAndroidAppDataStreamCallable() {
    return stub.deleteAndroidAppDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an android app stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AndroidAppDataStream androidAppDataStream = AndroidAppDataStream.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AndroidAppDataStream response =
   *       analyticsAdminServiceClient.updateAndroidAppDataStream(androidAppDataStream, updateMask);
   * }
   * }</pre>
   *
   * @param androidAppDataStream Required. The android app stream to update. The `name` field is
   *     used to identify the android app stream to be updated.
   * @param updateMask Required. The list of fields to be updated. Omitted fields will not be
   *     updated. To replace the entire entity, use one path with the string "&#42;" to match all
   *     fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AndroidAppDataStream updateAndroidAppDataStream(
      AndroidAppDataStream androidAppDataStream, FieldMask updateMask) {
    UpdateAndroidAppDataStreamRequest request =
        UpdateAndroidAppDataStreamRequest.newBuilder()
            .setAndroidAppDataStream(androidAppDataStream)
            .setUpdateMask(updateMask)
            .build();
    return updateAndroidAppDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an android app stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateAndroidAppDataStreamRequest request =
   *       UpdateAndroidAppDataStreamRequest.newBuilder()
   *           .setAndroidAppDataStream(AndroidAppDataStream.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AndroidAppDataStream response =
   *       analyticsAdminServiceClient.updateAndroidAppDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AndroidAppDataStream updateAndroidAppDataStream(
      UpdateAndroidAppDataStreamRequest request) {
    return updateAndroidAppDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an android app stream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateAndroidAppDataStreamRequest request =
   *       UpdateAndroidAppDataStreamRequest.newBuilder()
   *           .setAndroidAppDataStream(AndroidAppDataStream.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AndroidAppDataStream> future =
   *       analyticsAdminServiceClient.updateAndroidAppDataStreamCallable().futureCall(request);
   *   // Do something.
   *   AndroidAppDataStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAndroidAppDataStreamRequest, AndroidAppDataStream>
      updateAndroidAppDataStreamCallable() {
    return stub.updateAndroidAppDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an android app stream with the specified location and attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   AndroidAppDataStream androidAppDataStream = AndroidAppDataStream.newBuilder().build();
   *   AndroidAppDataStream response =
   *       analyticsAdminServiceClient.createAndroidAppDataStream(parent, androidAppDataStream);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this android app data stream will be created.
   *     Format: properties/123
   * @param androidAppDataStream Required. The android app stream to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AndroidAppDataStream createAndroidAppDataStream(
      PropertyName parent, AndroidAppDataStream androidAppDataStream) {
    CreateAndroidAppDataStreamRequest request =
        CreateAndroidAppDataStreamRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAndroidAppDataStream(androidAppDataStream)
            .build();
    return createAndroidAppDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an android app stream with the specified location and attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent =
   *       AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString();
   *   AndroidAppDataStream androidAppDataStream = AndroidAppDataStream.newBuilder().build();
   *   AndroidAppDataStream response =
   *       analyticsAdminServiceClient.createAndroidAppDataStream(parent, androidAppDataStream);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this android app data stream will be created.
   *     Format: properties/123
   * @param androidAppDataStream Required. The android app stream to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AndroidAppDataStream createAndroidAppDataStream(
      String parent, AndroidAppDataStream androidAppDataStream) {
    CreateAndroidAppDataStreamRequest request =
        CreateAndroidAppDataStreamRequest.newBuilder()
            .setParent(parent)
            .setAndroidAppDataStream(androidAppDataStream)
            .build();
    return createAndroidAppDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an android app stream with the specified location and attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateAndroidAppDataStreamRequest request =
   *       CreateAndroidAppDataStreamRequest.newBuilder()
   *           .setAndroidAppDataStream(AndroidAppDataStream.newBuilder().build())
   *           .setParent(
   *               AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString())
   *           .build();
   *   AndroidAppDataStream response =
   *       analyticsAdminServiceClient.createAndroidAppDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AndroidAppDataStream createAndroidAppDataStream(
      CreateAndroidAppDataStreamRequest request) {
    return createAndroidAppDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an android app stream with the specified location and attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateAndroidAppDataStreamRequest request =
   *       CreateAndroidAppDataStreamRequest.newBuilder()
   *           .setAndroidAppDataStream(AndroidAppDataStream.newBuilder().build())
   *           .setParent(
   *               AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString())
   *           .build();
   *   ApiFuture<AndroidAppDataStream> future =
   *       analyticsAdminServiceClient.createAndroidAppDataStreamCallable().futureCall(request);
   *   // Do something.
   *   AndroidAppDataStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAndroidAppDataStreamRequest, AndroidAppDataStream>
      createAndroidAppDataStreamCallable() {
    return stub.createAndroidAppDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child android app streams under the specified parent property.
   *
   * <p>Android app streams will be excluded if the caller does not have access. Returns an empty
   * list if no relevant android app streams are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (AndroidAppDataStream element :
   *       analyticsAdminServiceClient.listAndroidAppDataStreams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent property. For example, to limit results to app
   *     streams under the property with Id 123: "properties/123"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAndroidAppDataStreamsPagedResponse listAndroidAppDataStreams(
      PropertyName parent) {
    ListAndroidAppDataStreamsRequest request =
        ListAndroidAppDataStreamsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAndroidAppDataStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child android app streams under the specified parent property.
   *
   * <p>Android app streams will be excluded if the caller does not have access. Returns an empty
   * list if no relevant android app streams are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent =
   *       AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString();
   *   for (AndroidAppDataStream element :
   *       analyticsAdminServiceClient.listAndroidAppDataStreams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent property. For example, to limit results to app
   *     streams under the property with Id 123: "properties/123"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAndroidAppDataStreamsPagedResponse listAndroidAppDataStreams(String parent) {
    ListAndroidAppDataStreamsRequest request =
        ListAndroidAppDataStreamsRequest.newBuilder().setParent(parent).build();
    return listAndroidAppDataStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child android app streams under the specified parent property.
   *
   * <p>Android app streams will be excluded if the caller does not have access. Returns an empty
   * list if no relevant android app streams are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAndroidAppDataStreamsRequest request =
   *       ListAndroidAppDataStreamsRequest.newBuilder()
   *           .setParent(
   *               AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AndroidAppDataStream element :
   *       analyticsAdminServiceClient.listAndroidAppDataStreams(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAndroidAppDataStreamsPagedResponse listAndroidAppDataStreams(
      ListAndroidAppDataStreamsRequest request) {
    return listAndroidAppDataStreamsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child android app streams under the specified parent property.
   *
   * <p>Android app streams will be excluded if the caller does not have access. Returns an empty
   * list if no relevant android app streams are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAndroidAppDataStreamsRequest request =
   *       ListAndroidAppDataStreamsRequest.newBuilder()
   *           .setParent(
   *               AndroidAppDataStreamName.of("[PROPERTY]", "[ANDROID_APP_DATA_STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AndroidAppDataStream> future =
   *       analyticsAdminServiceClient.listAndroidAppDataStreamsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AndroidAppDataStream element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAndroidAppDataStreamsRequest, ListAndroidAppDataStreamsPagedResponse>
      listAndroidAppDataStreamsPagedCallable() {
    return stub.listAndroidAppDataStreamsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child android app streams under the specified parent property.
   *
   * <p>Android app streams will be excluded if the caller does not have access. Returns an empty
   * list if no relevant android app streams are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   while (true) {
   *     ListAndroidAppDataStreamsResponse response =
   *         analyticsAdminServiceClient.listAndroidAppDataStreamsCallable().call(request);
   *     for (AndroidAppDataStream element : response.getResponsesList()) {
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
  public final UnaryCallable<ListAndroidAppDataStreamsRequest, ListAndroidAppDataStreamsResponse>
      listAndroidAppDataStreamsCallable() {
    return stub.listAndroidAppDataStreamsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the singleton enhanced measurement settings for this web stream. Note that the stream
   * must enable enhanced measurement for these settings to take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   EnhancedMeasurementSettingsName name =
   *       EnhancedMeasurementSettingsName.of("[PROPERTY]", "[WEB_DATA_STREAM]");
   *   EnhancedMeasurementSettings response =
   *       analyticsAdminServiceClient.getEnhancedMeasurementSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the settings to lookup. Format:
   *     properties/{property_id}/webDataStreams/{stream_id}/enhancedMeasurementSettings Example:
   *     "properties/1000/webDataStreams/2000/enhancedMeasurementSettings"
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
   * Returns the singleton enhanced measurement settings for this web stream. Note that the stream
   * must enable enhanced measurement for these settings to take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       EnhancedMeasurementSettingsName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString();
   *   EnhancedMeasurementSettings response =
   *       analyticsAdminServiceClient.getEnhancedMeasurementSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the settings to lookup. Format:
   *     properties/{property_id}/webDataStreams/{stream_id}/enhancedMeasurementSettings Example:
   *     "properties/1000/webDataStreams/2000/enhancedMeasurementSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EnhancedMeasurementSettings getEnhancedMeasurementSettings(String name) {
    GetEnhancedMeasurementSettingsRequest request =
        GetEnhancedMeasurementSettingsRequest.newBuilder().setName(name).build();
    return getEnhancedMeasurementSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the singleton enhanced measurement settings for this web stream. Note that the stream
   * must enable enhanced measurement for these settings to take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetEnhancedMeasurementSettingsRequest request =
   *       GetEnhancedMeasurementSettingsRequest.newBuilder()
   *           .setName(
   *               EnhancedMeasurementSettingsName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
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
   * Returns the singleton enhanced measurement settings for this web stream. Note that the stream
   * must enable enhanced measurement for these settings to take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetEnhancedMeasurementSettingsRequest request =
   *       GetEnhancedMeasurementSettingsRequest.newBuilder()
   *           .setName(
   *               EnhancedMeasurementSettingsName.of("[PROPERTY]", "[WEB_DATA_STREAM]").toString())
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
   * Updates the singleton enhanced measurement settings for this web stream. Note that the stream
   * must enable enhanced measurement for these settings to take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
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
   * @param updateMask Required. The list of fields to be updated. Omitted fields will not be
   *     updated. To replace the entire entity, use one path with the string "&#42;" to match all
   *     fields.
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
   * Updates the singleton enhanced measurement settings for this web stream. Note that the stream
   * must enable enhanced measurement for these settings to take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
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
   * Updates the singleton enhanced measurement settings for this web stream. Note that the stream
   * must enable enhanced measurement for these settings to take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
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
   * Creates a FirebaseLink.
   *
   * <p>Properties can have at most one FirebaseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]").toString();
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateFirebaseLinkRequest request =
   *       CreateFirebaseLinkRequest.newBuilder()
   *           .setParent(FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateFirebaseLinkRequest request =
   *       CreateFirebaseLinkRequest.newBuilder()
   *           .setParent(FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]").toString())
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
   * Updates a FirebaseLink on a property
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   FirebaseLink firebaseLink = FirebaseLink.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   FirebaseLink response =
   *       analyticsAdminServiceClient.updateFirebaseLink(firebaseLink, updateMask);
   * }
   * }</pre>
   *
   * @param firebaseLink Required. The Firebase link to update.
   * @param updateMask Required. The list of fields to be updated. Omitted fields will not be
   *     updated. To replace the entire entity, use one path with the string "&#42;" to match all
   *     fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirebaseLink updateFirebaseLink(FirebaseLink firebaseLink, FieldMask updateMask) {
    UpdateFirebaseLinkRequest request =
        UpdateFirebaseLinkRequest.newBuilder()
            .setFirebaseLink(firebaseLink)
            .setUpdateMask(updateMask)
            .build();
    return updateFirebaseLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a FirebaseLink on a property
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateFirebaseLinkRequest request =
   *       UpdateFirebaseLinkRequest.newBuilder()
   *           .setFirebaseLink(FirebaseLink.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   FirebaseLink response = analyticsAdminServiceClient.updateFirebaseLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirebaseLink updateFirebaseLink(UpdateFirebaseLinkRequest request) {
    return updateFirebaseLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a FirebaseLink on a property
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateFirebaseLinkRequest request =
   *       UpdateFirebaseLinkRequest.newBuilder()
   *           .setFirebaseLink(FirebaseLink.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<FirebaseLink> future =
   *       analyticsAdminServiceClient.updateFirebaseLinkCallable().futureCall(request);
   *   // Do something.
   *   FirebaseLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFirebaseLinkRequest, FirebaseLink> updateFirebaseLinkCallable() {
    return stub.updateFirebaseLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a FirebaseLink on a property
   *
   * <p>Sample code:
   *
   * <pre>{@code
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]").toString();
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListFirebaseLinksRequest request =
   *       ListFirebaseLinksRequest.newBuilder()
   *           .setParent(FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListFirebaseLinksRequest request =
   *       ListFirebaseLinksRequest.newBuilder()
   *           .setParent(FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   while (true) {
   *     ListFirebaseLinksResponse response =
   *         analyticsAdminServiceClient.listFirebaseLinksCallable().call(request);
   *     for (FirebaseLink element : response.getResponsesList()) {
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GlobalSiteTagName name = GlobalSiteTagName.of("[PROPERTY]");
   *   GlobalSiteTag response = analyticsAdminServiceClient.getGlobalSiteTag(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the site tag to lookup. Note that site tags are singletons
   *     and do not have unique IDs. Format:
   *     properties/{property_id}/webDataStreams/{stream_id}/globalSiteTag Example:
   *     "properties/123/webDataStreams/456/globalSiteTag"
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = GlobalSiteTagName.of("[PROPERTY]").toString();
   *   GlobalSiteTag response = analyticsAdminServiceClient.getGlobalSiteTag(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the site tag to lookup. Note that site tags are singletons
   *     and do not have unique IDs. Format:
   *     properties/{property_id}/webDataStreams/{stream_id}/globalSiteTag Example:
   *     "properties/123/webDataStreams/456/globalSiteTag"
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetGlobalSiteTagRequest request =
   *       GetGlobalSiteTagRequest.newBuilder()
   *           .setName(GlobalSiteTagName.of("[PROPERTY]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetGlobalSiteTagRequest request =
   *       GetGlobalSiteTagRequest.newBuilder()
   *           .setName(GlobalSiteTagName.of("[PROPERTY]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]").toString();
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateGoogleAdsLinkRequest request =
   *       CreateGoogleAdsLinkRequest.newBuilder()
   *           .setParent(GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateGoogleAdsLinkRequest request =
   *       CreateGoogleAdsLinkRequest.newBuilder()
   *           .setParent(GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]").toString())
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
   * @param updateMask Required. The list of fields to be updated. Omitted fields will not be
   *     updated. To replace the entire entity, use one path with the string "&#42;" to match all
   *     fields.
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]").toString();
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListGoogleAdsLinksRequest request =
   *       ListGoogleAdsLinksRequest.newBuilder()
   *           .setParent(GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListGoogleAdsLinksRequest request =
   *       ListGoogleAdsLinksRequest.newBuilder()
   *           .setParent(GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]").toString())
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
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   while (true) {
   *     ListGoogleAdsLinksResponse response =
   *         analyticsAdminServiceClient.listGoogleAdsLinksCallable().call(request);
   *     for (GoogleAdsLink element : response.getResponsesList()) {
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
          new ApiFunction<ListAccountsPage, ListAccountsPagedResponse>() {
            @Override
            public ListAccountsPagedResponse apply(ListAccountsPage input) {
              return new ListAccountsPagedResponse(input);
            }
          },
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
          new ApiFunction<ListAccountSummariesPage, ListAccountSummariesPagedResponse>() {
            @Override
            public ListAccountSummariesPagedResponse apply(ListAccountSummariesPage input) {
              return new ListAccountSummariesPagedResponse(input);
            }
          },
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
          new ApiFunction<ListPropertiesPage, ListPropertiesPagedResponse>() {
            @Override
            public ListPropertiesPagedResponse apply(ListPropertiesPage input) {
              return new ListPropertiesPagedResponse(input);
            }
          },
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
          new ApiFunction<ListUserLinksPage, ListUserLinksPagedResponse>() {
            @Override
            public ListUserLinksPagedResponse apply(ListUserLinksPage input) {
              return new ListUserLinksPagedResponse(input);
            }
          },
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
          new ApiFunction<AuditUserLinksPage, AuditUserLinksPagedResponse>() {
            @Override
            public AuditUserLinksPagedResponse apply(AuditUserLinksPage input) {
              return new AuditUserLinksPagedResponse(input);
            }
          },
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

  public static class ListWebDataStreamsPagedResponse
      extends AbstractPagedListResponse<
          ListWebDataStreamsRequest,
          ListWebDataStreamsResponse,
          WebDataStream,
          ListWebDataStreamsPage,
          ListWebDataStreamsFixedSizeCollection> {

    public static ApiFuture<ListWebDataStreamsPagedResponse> createAsync(
        PageContext<ListWebDataStreamsRequest, ListWebDataStreamsResponse, WebDataStream> context,
        ApiFuture<ListWebDataStreamsResponse> futureResponse) {
      ApiFuture<ListWebDataStreamsPage> futurePage =
          ListWebDataStreamsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListWebDataStreamsPage, ListWebDataStreamsPagedResponse>() {
            @Override
            public ListWebDataStreamsPagedResponse apply(ListWebDataStreamsPage input) {
              return new ListWebDataStreamsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListWebDataStreamsPagedResponse(ListWebDataStreamsPage page) {
      super(page, ListWebDataStreamsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWebDataStreamsPage
      extends AbstractPage<
          ListWebDataStreamsRequest,
          ListWebDataStreamsResponse,
          WebDataStream,
          ListWebDataStreamsPage> {

    private ListWebDataStreamsPage(
        PageContext<ListWebDataStreamsRequest, ListWebDataStreamsResponse, WebDataStream> context,
        ListWebDataStreamsResponse response) {
      super(context, response);
    }

    private static ListWebDataStreamsPage createEmptyPage() {
      return new ListWebDataStreamsPage(null, null);
    }

    @Override
    protected ListWebDataStreamsPage createPage(
        PageContext<ListWebDataStreamsRequest, ListWebDataStreamsResponse, WebDataStream> context,
        ListWebDataStreamsResponse response) {
      return new ListWebDataStreamsPage(context, response);
    }

    @Override
    public ApiFuture<ListWebDataStreamsPage> createPageAsync(
        PageContext<ListWebDataStreamsRequest, ListWebDataStreamsResponse, WebDataStream> context,
        ApiFuture<ListWebDataStreamsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWebDataStreamsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWebDataStreamsRequest,
          ListWebDataStreamsResponse,
          WebDataStream,
          ListWebDataStreamsPage,
          ListWebDataStreamsFixedSizeCollection> {

    private ListWebDataStreamsFixedSizeCollection(
        List<ListWebDataStreamsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWebDataStreamsFixedSizeCollection createEmptyCollection() {
      return new ListWebDataStreamsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWebDataStreamsFixedSizeCollection createCollection(
        List<ListWebDataStreamsPage> pages, int collectionSize) {
      return new ListWebDataStreamsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListIosAppDataStreamsPagedResponse
      extends AbstractPagedListResponse<
          ListIosAppDataStreamsRequest,
          ListIosAppDataStreamsResponse,
          IosAppDataStream,
          ListIosAppDataStreamsPage,
          ListIosAppDataStreamsFixedSizeCollection> {

    public static ApiFuture<ListIosAppDataStreamsPagedResponse> createAsync(
        PageContext<ListIosAppDataStreamsRequest, ListIosAppDataStreamsResponse, IosAppDataStream>
            context,
        ApiFuture<ListIosAppDataStreamsResponse> futureResponse) {
      ApiFuture<ListIosAppDataStreamsPage> futurePage =
          ListIosAppDataStreamsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListIosAppDataStreamsPage, ListIosAppDataStreamsPagedResponse>() {
            @Override
            public ListIosAppDataStreamsPagedResponse apply(ListIosAppDataStreamsPage input) {
              return new ListIosAppDataStreamsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListIosAppDataStreamsPagedResponse(ListIosAppDataStreamsPage page) {
      super(page, ListIosAppDataStreamsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIosAppDataStreamsPage
      extends AbstractPage<
          ListIosAppDataStreamsRequest,
          ListIosAppDataStreamsResponse,
          IosAppDataStream,
          ListIosAppDataStreamsPage> {

    private ListIosAppDataStreamsPage(
        PageContext<ListIosAppDataStreamsRequest, ListIosAppDataStreamsResponse, IosAppDataStream>
            context,
        ListIosAppDataStreamsResponse response) {
      super(context, response);
    }

    private static ListIosAppDataStreamsPage createEmptyPage() {
      return new ListIosAppDataStreamsPage(null, null);
    }

    @Override
    protected ListIosAppDataStreamsPage createPage(
        PageContext<ListIosAppDataStreamsRequest, ListIosAppDataStreamsResponse, IosAppDataStream>
            context,
        ListIosAppDataStreamsResponse response) {
      return new ListIosAppDataStreamsPage(context, response);
    }

    @Override
    public ApiFuture<ListIosAppDataStreamsPage> createPageAsync(
        PageContext<ListIosAppDataStreamsRequest, ListIosAppDataStreamsResponse, IosAppDataStream>
            context,
        ApiFuture<ListIosAppDataStreamsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIosAppDataStreamsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIosAppDataStreamsRequest,
          ListIosAppDataStreamsResponse,
          IosAppDataStream,
          ListIosAppDataStreamsPage,
          ListIosAppDataStreamsFixedSizeCollection> {

    private ListIosAppDataStreamsFixedSizeCollection(
        List<ListIosAppDataStreamsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIosAppDataStreamsFixedSizeCollection createEmptyCollection() {
      return new ListIosAppDataStreamsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIosAppDataStreamsFixedSizeCollection createCollection(
        List<ListIosAppDataStreamsPage> pages, int collectionSize) {
      return new ListIosAppDataStreamsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAndroidAppDataStreamsPagedResponse
      extends AbstractPagedListResponse<
          ListAndroidAppDataStreamsRequest,
          ListAndroidAppDataStreamsResponse,
          AndroidAppDataStream,
          ListAndroidAppDataStreamsPage,
          ListAndroidAppDataStreamsFixedSizeCollection> {

    public static ApiFuture<ListAndroidAppDataStreamsPagedResponse> createAsync(
        PageContext<
                ListAndroidAppDataStreamsRequest,
                ListAndroidAppDataStreamsResponse,
                AndroidAppDataStream>
            context,
        ApiFuture<ListAndroidAppDataStreamsResponse> futureResponse) {
      ApiFuture<ListAndroidAppDataStreamsPage> futurePage =
          ListAndroidAppDataStreamsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListAndroidAppDataStreamsPage, ListAndroidAppDataStreamsPagedResponse>() {
            @Override
            public ListAndroidAppDataStreamsPagedResponse apply(
                ListAndroidAppDataStreamsPage input) {
              return new ListAndroidAppDataStreamsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListAndroidAppDataStreamsPagedResponse(ListAndroidAppDataStreamsPage page) {
      super(page, ListAndroidAppDataStreamsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAndroidAppDataStreamsPage
      extends AbstractPage<
          ListAndroidAppDataStreamsRequest,
          ListAndroidAppDataStreamsResponse,
          AndroidAppDataStream,
          ListAndroidAppDataStreamsPage> {

    private ListAndroidAppDataStreamsPage(
        PageContext<
                ListAndroidAppDataStreamsRequest,
                ListAndroidAppDataStreamsResponse,
                AndroidAppDataStream>
            context,
        ListAndroidAppDataStreamsResponse response) {
      super(context, response);
    }

    private static ListAndroidAppDataStreamsPage createEmptyPage() {
      return new ListAndroidAppDataStreamsPage(null, null);
    }

    @Override
    protected ListAndroidAppDataStreamsPage createPage(
        PageContext<
                ListAndroidAppDataStreamsRequest,
                ListAndroidAppDataStreamsResponse,
                AndroidAppDataStream>
            context,
        ListAndroidAppDataStreamsResponse response) {
      return new ListAndroidAppDataStreamsPage(context, response);
    }

    @Override
    public ApiFuture<ListAndroidAppDataStreamsPage> createPageAsync(
        PageContext<
                ListAndroidAppDataStreamsRequest,
                ListAndroidAppDataStreamsResponse,
                AndroidAppDataStream>
            context,
        ApiFuture<ListAndroidAppDataStreamsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAndroidAppDataStreamsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAndroidAppDataStreamsRequest,
          ListAndroidAppDataStreamsResponse,
          AndroidAppDataStream,
          ListAndroidAppDataStreamsPage,
          ListAndroidAppDataStreamsFixedSizeCollection> {

    private ListAndroidAppDataStreamsFixedSizeCollection(
        List<ListAndroidAppDataStreamsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAndroidAppDataStreamsFixedSizeCollection createEmptyCollection() {
      return new ListAndroidAppDataStreamsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAndroidAppDataStreamsFixedSizeCollection createCollection(
        List<ListAndroidAppDataStreamsPage> pages, int collectionSize) {
      return new ListAndroidAppDataStreamsFixedSizeCollection(pages, collectionSize);
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
          new ApiFunction<ListFirebaseLinksPage, ListFirebaseLinksPagedResponse>() {
            @Override
            public ListFirebaseLinksPagedResponse apply(ListFirebaseLinksPage input) {
              return new ListFirebaseLinksPagedResponse(input);
            }
          },
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
          new ApiFunction<ListGoogleAdsLinksPage, ListGoogleAdsLinksPagedResponse>() {
            @Override
            public ListGoogleAdsLinksPagedResponse apply(ListGoogleAdsLinksPage input) {
              return new ListGoogleAdsLinksPagedResponse(input);
            }
          },
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
}
