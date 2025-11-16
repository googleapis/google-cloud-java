/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.quota.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.shopping.merchant.quota.v1.stub.AccountLimitsServiceStub;
import com.google.shopping.merchant.quota.v1.stub.AccountLimitsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to retrieve account limits.
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
 * try (AccountLimitsServiceClient accountLimitsServiceClient =
 *     AccountLimitsServiceClient.create()) {
 *   AccountLimitName name = AccountLimitName.of("[ACCOUNT]", "[LIMIT]");
 *   AccountLimit response = accountLimitsServiceClient.getAccountLimit(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AccountLimitsServiceClient object to clean up
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
 *      <td><p> GetAccountLimit</td>
 *      <td><p> Retrieves an account limit.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAccountLimit(GetAccountLimitRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAccountLimit(AccountLimitName name)
 *           <li><p> getAccountLimit(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAccountLimitCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAccountLimits</td>
 *      <td><p> Lists the limits of an account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAccountLimits(ListAccountLimitsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAccountLimits(AccountName parent)
 *           <li><p> listAccountLimits(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAccountLimitsPagedCallable()
 *           <li><p> listAccountLimitsCallable()
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
 * <p>This class can be customized by passing in a custom instance of AccountLimitsServiceSettings
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
 * AccountLimitsServiceSettings accountLimitsServiceSettings =
 *     AccountLimitsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AccountLimitsServiceClient accountLimitsServiceClient =
 *     AccountLimitsServiceClient.create(accountLimitsServiceSettings);
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
 * AccountLimitsServiceSettings accountLimitsServiceSettings =
 *     AccountLimitsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AccountLimitsServiceClient accountLimitsServiceClient =
 *     AccountLimitsServiceClient.create(accountLimitsServiceSettings);
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
 * AccountLimitsServiceSettings accountLimitsServiceSettings =
 *     AccountLimitsServiceSettings.newHttpJsonBuilder().build();
 * AccountLimitsServiceClient accountLimitsServiceClient =
 *     AccountLimitsServiceClient.create(accountLimitsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AccountLimitsServiceClient implements BackgroundResource {
  private final AccountLimitsServiceSettings settings;
  private final AccountLimitsServiceStub stub;

  /** Constructs an instance of AccountLimitsServiceClient with default settings. */
  public static final AccountLimitsServiceClient create() throws IOException {
    return create(AccountLimitsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AccountLimitsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AccountLimitsServiceClient create(AccountLimitsServiceSettings settings)
      throws IOException {
    return new AccountLimitsServiceClient(settings);
  }

  /**
   * Constructs an instance of AccountLimitsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AccountLimitsServiceSettings).
   */
  public static final AccountLimitsServiceClient create(AccountLimitsServiceStub stub) {
    return new AccountLimitsServiceClient(stub);
  }

  /**
   * Constructs an instance of AccountLimitsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AccountLimitsServiceClient(AccountLimitsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AccountLimitsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AccountLimitsServiceClient(AccountLimitsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AccountLimitsServiceSettings getSettings() {
    return settings;
  }

  public AccountLimitsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an account limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLimitsServiceClient accountLimitsServiceClient =
   *     AccountLimitsServiceClient.create()) {
   *   AccountLimitName name = AccountLimitName.of("[ACCOUNT]", "[LIMIT]");
   *   AccountLimit response = accountLimitsServiceClient.getAccountLimit(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the limit to retrieve. Format:
   *     `accounts/{account}/limits/{limit}` For example: `accounts/123/limits/products~ADS_NON_EEA`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountLimit getAccountLimit(AccountLimitName name) {
    GetAccountLimitRequest request =
        GetAccountLimitRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAccountLimit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an account limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLimitsServiceClient accountLimitsServiceClient =
   *     AccountLimitsServiceClient.create()) {
   *   String name = AccountLimitName.of("[ACCOUNT]", "[LIMIT]").toString();
   *   AccountLimit response = accountLimitsServiceClient.getAccountLimit(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the limit to retrieve. Format:
   *     `accounts/{account}/limits/{limit}` For example: `accounts/123/limits/products~ADS_NON_EEA`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountLimit getAccountLimit(String name) {
    GetAccountLimitRequest request = GetAccountLimitRequest.newBuilder().setName(name).build();
    return getAccountLimit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an account limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLimitsServiceClient accountLimitsServiceClient =
   *     AccountLimitsServiceClient.create()) {
   *   GetAccountLimitRequest request =
   *       GetAccountLimitRequest.newBuilder()
   *           .setName(AccountLimitName.of("[ACCOUNT]", "[LIMIT]").toString())
   *           .build();
   *   AccountLimit response = accountLimitsServiceClient.getAccountLimit(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountLimit getAccountLimit(GetAccountLimitRequest request) {
    return getAccountLimitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an account limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLimitsServiceClient accountLimitsServiceClient =
   *     AccountLimitsServiceClient.create()) {
   *   GetAccountLimitRequest request =
   *       GetAccountLimitRequest.newBuilder()
   *           .setName(AccountLimitName.of("[ACCOUNT]", "[LIMIT]").toString())
   *           .build();
   *   ApiFuture<AccountLimit> future =
   *       accountLimitsServiceClient.getAccountLimitCallable().futureCall(request);
   *   // Do something.
   *   AccountLimit response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAccountLimitRequest, AccountLimit> getAccountLimitCallable() {
    return stub.getAccountLimitCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the limits of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLimitsServiceClient accountLimitsServiceClient =
   *     AccountLimitsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (AccountLimit element :
   *       accountLimitsServiceClient.listAccountLimits(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent account. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountLimitsPagedResponse listAccountLimits(AccountName parent) {
    ListAccountLimitsRequest request =
        ListAccountLimitsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAccountLimits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the limits of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLimitsServiceClient accountLimitsServiceClient =
   *     AccountLimitsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (AccountLimit element :
   *       accountLimitsServiceClient.listAccountLimits(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent account. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountLimitsPagedResponse listAccountLimits(String parent) {
    ListAccountLimitsRequest request =
        ListAccountLimitsRequest.newBuilder().setParent(parent).build();
    return listAccountLimits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the limits of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLimitsServiceClient accountLimitsServiceClient =
   *     AccountLimitsServiceClient.create()) {
   *   ListAccountLimitsRequest request =
   *       ListAccountLimitsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (AccountLimit element :
   *       accountLimitsServiceClient.listAccountLimits(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountLimitsPagedResponse listAccountLimits(ListAccountLimitsRequest request) {
    return listAccountLimitsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the limits of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLimitsServiceClient accountLimitsServiceClient =
   *     AccountLimitsServiceClient.create()) {
   *   ListAccountLimitsRequest request =
   *       ListAccountLimitsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<AccountLimit> future =
   *       accountLimitsServiceClient.listAccountLimitsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AccountLimit element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAccountLimitsRequest, ListAccountLimitsPagedResponse>
      listAccountLimitsPagedCallable() {
    return stub.listAccountLimitsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the limits of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLimitsServiceClient accountLimitsServiceClient =
   *     AccountLimitsServiceClient.create()) {
   *   ListAccountLimitsRequest request =
   *       ListAccountLimitsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListAccountLimitsResponse response =
   *         accountLimitsServiceClient.listAccountLimitsCallable().call(request);
   *     for (AccountLimit element : response.getAccountLimitsList()) {
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
  public final UnaryCallable<ListAccountLimitsRequest, ListAccountLimitsResponse>
      listAccountLimitsCallable() {
    return stub.listAccountLimitsCallable();
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

  public static class ListAccountLimitsPagedResponse
      extends AbstractPagedListResponse<
          ListAccountLimitsRequest,
          ListAccountLimitsResponse,
          AccountLimit,
          ListAccountLimitsPage,
          ListAccountLimitsFixedSizeCollection> {

    public static ApiFuture<ListAccountLimitsPagedResponse> createAsync(
        PageContext<ListAccountLimitsRequest, ListAccountLimitsResponse, AccountLimit> context,
        ApiFuture<ListAccountLimitsResponse> futureResponse) {
      ApiFuture<ListAccountLimitsPage> futurePage =
          ListAccountLimitsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAccountLimitsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAccountLimitsPagedResponse(ListAccountLimitsPage page) {
      super(page, ListAccountLimitsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAccountLimitsPage
      extends AbstractPage<
          ListAccountLimitsRequest,
          ListAccountLimitsResponse,
          AccountLimit,
          ListAccountLimitsPage> {

    private ListAccountLimitsPage(
        PageContext<ListAccountLimitsRequest, ListAccountLimitsResponse, AccountLimit> context,
        ListAccountLimitsResponse response) {
      super(context, response);
    }

    private static ListAccountLimitsPage createEmptyPage() {
      return new ListAccountLimitsPage(null, null);
    }

    @Override
    protected ListAccountLimitsPage createPage(
        PageContext<ListAccountLimitsRequest, ListAccountLimitsResponse, AccountLimit> context,
        ListAccountLimitsResponse response) {
      return new ListAccountLimitsPage(context, response);
    }

    @Override
    public ApiFuture<ListAccountLimitsPage> createPageAsync(
        PageContext<ListAccountLimitsRequest, ListAccountLimitsResponse, AccountLimit> context,
        ApiFuture<ListAccountLimitsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAccountLimitsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAccountLimitsRequest,
          ListAccountLimitsResponse,
          AccountLimit,
          ListAccountLimitsPage,
          ListAccountLimitsFixedSizeCollection> {

    private ListAccountLimitsFixedSizeCollection(
        List<ListAccountLimitsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAccountLimitsFixedSizeCollection createEmptyCollection() {
      return new ListAccountLimitsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAccountLimitsFixedSizeCollection createCollection(
        List<ListAccountLimitsPage> pages, int collectionSize) {
      return new ListAccountLimitsFixedSizeCollection(pages, collectionSize);
    }
  }
}
