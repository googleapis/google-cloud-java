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
import com.google.shopping.merchant.accounts.v1beta.stub.AccountIssueServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.AccountIssueServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to support `AccountIssueService` API.
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
 * try (AccountIssueServiceClient accountIssueServiceClient = AccountIssueServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT]");
 *   for (AccountIssue element :
 *       accountIssueServiceClient.listAccountIssues(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AccountIssueServiceClient object to clean up resources
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
 *      <td><p> ListAccountIssues</td>
 *      <td><p> Lists all account issues of a Merchant Center account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAccountIssues(ListAccountIssuesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAccountIssues(AccountName parent)
 *           <li><p> listAccountIssues(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAccountIssuesPagedCallable()
 *           <li><p> listAccountIssuesCallable()
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
 * <p>This class can be customized by passing in a custom instance of AccountIssueServiceSettings to
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
 * AccountIssueServiceSettings accountIssueServiceSettings =
 *     AccountIssueServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AccountIssueServiceClient accountIssueServiceClient =
 *     AccountIssueServiceClient.create(accountIssueServiceSettings);
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
 * AccountIssueServiceSettings accountIssueServiceSettings =
 *     AccountIssueServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AccountIssueServiceClient accountIssueServiceClient =
 *     AccountIssueServiceClient.create(accountIssueServiceSettings);
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
 * AccountIssueServiceSettings accountIssueServiceSettings =
 *     AccountIssueServiceSettings.newHttpJsonBuilder().build();
 * AccountIssueServiceClient accountIssueServiceClient =
 *     AccountIssueServiceClient.create(accountIssueServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AccountIssueServiceClient implements BackgroundResource {
  private final AccountIssueServiceSettings settings;
  private final AccountIssueServiceStub stub;

  /** Constructs an instance of AccountIssueServiceClient with default settings. */
  public static final AccountIssueServiceClient create() throws IOException {
    return create(AccountIssueServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AccountIssueServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AccountIssueServiceClient create(AccountIssueServiceSettings settings)
      throws IOException {
    return new AccountIssueServiceClient(settings);
  }

  /**
   * Constructs an instance of AccountIssueServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AccountIssueServiceSettings).
   */
  public static final AccountIssueServiceClient create(AccountIssueServiceStub stub) {
    return new AccountIssueServiceClient(stub);
  }

  /**
   * Constructs an instance of AccountIssueServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AccountIssueServiceClient(AccountIssueServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AccountIssueServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AccountIssueServiceClient(AccountIssueServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AccountIssueServiceSettings getSettings() {
    return settings;
  }

  public AccountIssueServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all account issues of a Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountIssueServiceClient accountIssueServiceClient = AccountIssueServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (AccountIssue element :
   *       accountIssueServiceClient.listAccountIssues(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of issues. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountIssuesPagedResponse listAccountIssues(AccountName parent) {
    ListAccountIssuesRequest request =
        ListAccountIssuesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAccountIssues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all account issues of a Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountIssueServiceClient accountIssueServiceClient = AccountIssueServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (AccountIssue element :
   *       accountIssueServiceClient.listAccountIssues(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of issues. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountIssuesPagedResponse listAccountIssues(String parent) {
    ListAccountIssuesRequest request =
        ListAccountIssuesRequest.newBuilder().setParent(parent).build();
    return listAccountIssues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all account issues of a Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountIssueServiceClient accountIssueServiceClient = AccountIssueServiceClient.create()) {
   *   ListAccountIssuesRequest request =
   *       ListAccountIssuesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .setTimeZone(TimeZone.newBuilder().build())
   *           .build();
   *   for (AccountIssue element :
   *       accountIssueServiceClient.listAccountIssues(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountIssuesPagedResponse listAccountIssues(ListAccountIssuesRequest request) {
    return listAccountIssuesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all account issues of a Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountIssueServiceClient accountIssueServiceClient = AccountIssueServiceClient.create()) {
   *   ListAccountIssuesRequest request =
   *       ListAccountIssuesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .setTimeZone(TimeZone.newBuilder().build())
   *           .build();
   *   ApiFuture<AccountIssue> future =
   *       accountIssueServiceClient.listAccountIssuesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AccountIssue element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAccountIssuesRequest, ListAccountIssuesPagedResponse>
      listAccountIssuesPagedCallable() {
    return stub.listAccountIssuesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all account issues of a Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountIssueServiceClient accountIssueServiceClient = AccountIssueServiceClient.create()) {
   *   ListAccountIssuesRequest request =
   *       ListAccountIssuesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .setTimeZone(TimeZone.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListAccountIssuesResponse response =
   *         accountIssueServiceClient.listAccountIssuesCallable().call(request);
   *     for (AccountIssue element : response.getAccountIssuesList()) {
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
  public final UnaryCallable<ListAccountIssuesRequest, ListAccountIssuesResponse>
      listAccountIssuesCallable() {
    return stub.listAccountIssuesCallable();
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

  public static class ListAccountIssuesPagedResponse
      extends AbstractPagedListResponse<
          ListAccountIssuesRequest,
          ListAccountIssuesResponse,
          AccountIssue,
          ListAccountIssuesPage,
          ListAccountIssuesFixedSizeCollection> {

    public static ApiFuture<ListAccountIssuesPagedResponse> createAsync(
        PageContext<ListAccountIssuesRequest, ListAccountIssuesResponse, AccountIssue> context,
        ApiFuture<ListAccountIssuesResponse> futureResponse) {
      ApiFuture<ListAccountIssuesPage> futurePage =
          ListAccountIssuesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAccountIssuesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAccountIssuesPagedResponse(ListAccountIssuesPage page) {
      super(page, ListAccountIssuesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAccountIssuesPage
      extends AbstractPage<
          ListAccountIssuesRequest,
          ListAccountIssuesResponse,
          AccountIssue,
          ListAccountIssuesPage> {

    private ListAccountIssuesPage(
        PageContext<ListAccountIssuesRequest, ListAccountIssuesResponse, AccountIssue> context,
        ListAccountIssuesResponse response) {
      super(context, response);
    }

    private static ListAccountIssuesPage createEmptyPage() {
      return new ListAccountIssuesPage(null, null);
    }

    @Override
    protected ListAccountIssuesPage createPage(
        PageContext<ListAccountIssuesRequest, ListAccountIssuesResponse, AccountIssue> context,
        ListAccountIssuesResponse response) {
      return new ListAccountIssuesPage(context, response);
    }

    @Override
    public ApiFuture<ListAccountIssuesPage> createPageAsync(
        PageContext<ListAccountIssuesRequest, ListAccountIssuesResponse, AccountIssue> context,
        ApiFuture<ListAccountIssuesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAccountIssuesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAccountIssuesRequest,
          ListAccountIssuesResponse,
          AccountIssue,
          ListAccountIssuesPage,
          ListAccountIssuesFixedSizeCollection> {

    private ListAccountIssuesFixedSizeCollection(
        List<ListAccountIssuesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAccountIssuesFixedSizeCollection createEmptyCollection() {
      return new ListAccountIssuesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAccountIssuesFixedSizeCollection createCollection(
        List<ListAccountIssuesPage> pages, int collectionSize) {
      return new ListAccountIssuesFixedSizeCollection(pages, collectionSize);
    }
  }
}
