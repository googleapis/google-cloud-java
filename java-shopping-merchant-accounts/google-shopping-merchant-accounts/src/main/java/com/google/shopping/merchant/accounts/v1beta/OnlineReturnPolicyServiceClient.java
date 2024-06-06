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
import com.google.shopping.merchant.accounts.v1beta.stub.OnlineReturnPolicyServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.OnlineReturnPolicyServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The service facilitates the management of a merchant's remorse return policy
 * configuration, encompassing return policies for both ads and free listings ## programs. This API
 * defines the following resource model:
 *
 * <p>[OnlineReturnPolicy][google.shopping.merchant.accounts.v1.OnlineReturnPolicy]
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
 * try (OnlineReturnPolicyServiceClient onlineReturnPolicyServiceClient =
 *     OnlineReturnPolicyServiceClient.create()) {
 *   OnlineReturnPolicyName name = OnlineReturnPolicyName.of("[ACCOUNT]", "[RETURN_POLICY]");
 *   OnlineReturnPolicy response = onlineReturnPolicyServiceClient.getOnlineReturnPolicy(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OnlineReturnPolicyServiceClient object to clean up
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
 *      <td><p> GetOnlineReturnPolicy</td>
 *      <td><p> Gets an existing return policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOnlineReturnPolicy(GetOnlineReturnPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOnlineReturnPolicy(OnlineReturnPolicyName name)
 *           <li><p> getOnlineReturnPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOnlineReturnPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListOnlineReturnPolicies</td>
 *      <td><p> Lists all existing return policies.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOnlineReturnPolicies(ListOnlineReturnPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOnlineReturnPolicies(AccountName parent)
 *           <li><p> listOnlineReturnPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOnlineReturnPoliciesPagedCallable()
 *           <li><p> listOnlineReturnPoliciesCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * OnlineReturnPolicyServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OnlineReturnPolicyServiceSettings onlineReturnPolicyServiceSettings =
 *     OnlineReturnPolicyServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OnlineReturnPolicyServiceClient onlineReturnPolicyServiceClient =
 *     OnlineReturnPolicyServiceClient.create(onlineReturnPolicyServiceSettings);
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
 * OnlineReturnPolicyServiceSettings onlineReturnPolicyServiceSettings =
 *     OnlineReturnPolicyServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OnlineReturnPolicyServiceClient onlineReturnPolicyServiceClient =
 *     OnlineReturnPolicyServiceClient.create(onlineReturnPolicyServiceSettings);
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
 * OnlineReturnPolicyServiceSettings onlineReturnPolicyServiceSettings =
 *     OnlineReturnPolicyServiceSettings.newHttpJsonBuilder().build();
 * OnlineReturnPolicyServiceClient onlineReturnPolicyServiceClient =
 *     OnlineReturnPolicyServiceClient.create(onlineReturnPolicyServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class OnlineReturnPolicyServiceClient implements BackgroundResource {
  private final OnlineReturnPolicyServiceSettings settings;
  private final OnlineReturnPolicyServiceStub stub;

  /** Constructs an instance of OnlineReturnPolicyServiceClient with default settings. */
  public static final OnlineReturnPolicyServiceClient create() throws IOException {
    return create(OnlineReturnPolicyServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OnlineReturnPolicyServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final OnlineReturnPolicyServiceClient create(
      OnlineReturnPolicyServiceSettings settings) throws IOException {
    return new OnlineReturnPolicyServiceClient(settings);
  }

  /**
   * Constructs an instance of OnlineReturnPolicyServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(OnlineReturnPolicyServiceSettings).
   */
  public static final OnlineReturnPolicyServiceClient create(OnlineReturnPolicyServiceStub stub) {
    return new OnlineReturnPolicyServiceClient(stub);
  }

  /**
   * Constructs an instance of OnlineReturnPolicyServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected OnlineReturnPolicyServiceClient(OnlineReturnPolicyServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((OnlineReturnPolicyServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected OnlineReturnPolicyServiceClient(OnlineReturnPolicyServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final OnlineReturnPolicyServiceSettings getSettings() {
    return settings;
  }

  public OnlineReturnPolicyServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an existing return policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OnlineReturnPolicyServiceClient onlineReturnPolicyServiceClient =
   *     OnlineReturnPolicyServiceClient.create()) {
   *   OnlineReturnPolicyName name = OnlineReturnPolicyName.of("[ACCOUNT]", "[RETURN_POLICY]");
   *   OnlineReturnPolicy response = onlineReturnPolicyServiceClient.getOnlineReturnPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the return policy to retrieve. Format:
   *     `accounts/{account}/onlineReturnPolicies/{return_policy}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OnlineReturnPolicy getOnlineReturnPolicy(OnlineReturnPolicyName name) {
    GetOnlineReturnPolicyRequest request =
        GetOnlineReturnPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getOnlineReturnPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an existing return policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OnlineReturnPolicyServiceClient onlineReturnPolicyServiceClient =
   *     OnlineReturnPolicyServiceClient.create()) {
   *   String name = OnlineReturnPolicyName.of("[ACCOUNT]", "[RETURN_POLICY]").toString();
   *   OnlineReturnPolicy response = onlineReturnPolicyServiceClient.getOnlineReturnPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the return policy to retrieve. Format:
   *     `accounts/{account}/onlineReturnPolicies/{return_policy}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OnlineReturnPolicy getOnlineReturnPolicy(String name) {
    GetOnlineReturnPolicyRequest request =
        GetOnlineReturnPolicyRequest.newBuilder().setName(name).build();
    return getOnlineReturnPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an existing return policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OnlineReturnPolicyServiceClient onlineReturnPolicyServiceClient =
   *     OnlineReturnPolicyServiceClient.create()) {
   *   GetOnlineReturnPolicyRequest request =
   *       GetOnlineReturnPolicyRequest.newBuilder()
   *           .setName(OnlineReturnPolicyName.of("[ACCOUNT]", "[RETURN_POLICY]").toString())
   *           .build();
   *   OnlineReturnPolicy response = onlineReturnPolicyServiceClient.getOnlineReturnPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OnlineReturnPolicy getOnlineReturnPolicy(GetOnlineReturnPolicyRequest request) {
    return getOnlineReturnPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an existing return policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OnlineReturnPolicyServiceClient onlineReturnPolicyServiceClient =
   *     OnlineReturnPolicyServiceClient.create()) {
   *   GetOnlineReturnPolicyRequest request =
   *       GetOnlineReturnPolicyRequest.newBuilder()
   *           .setName(OnlineReturnPolicyName.of("[ACCOUNT]", "[RETURN_POLICY]").toString())
   *           .build();
   *   ApiFuture<OnlineReturnPolicy> future =
   *       onlineReturnPolicyServiceClient.getOnlineReturnPolicyCallable().futureCall(request);
   *   // Do something.
   *   OnlineReturnPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOnlineReturnPolicyRequest, OnlineReturnPolicy>
      getOnlineReturnPolicyCallable() {
    return stub.getOnlineReturnPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all existing return policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OnlineReturnPolicyServiceClient onlineReturnPolicyServiceClient =
   *     OnlineReturnPolicyServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (OnlineReturnPolicy element :
   *       onlineReturnPolicyServiceClient.listOnlineReturnPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The merchant account for which to list return policies. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOnlineReturnPoliciesPagedResponse listOnlineReturnPolicies(AccountName parent) {
    ListOnlineReturnPoliciesRequest request =
        ListOnlineReturnPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOnlineReturnPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all existing return policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OnlineReturnPolicyServiceClient onlineReturnPolicyServiceClient =
   *     OnlineReturnPolicyServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (OnlineReturnPolicy element :
   *       onlineReturnPolicyServiceClient.listOnlineReturnPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The merchant account for which to list return policies. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOnlineReturnPoliciesPagedResponse listOnlineReturnPolicies(String parent) {
    ListOnlineReturnPoliciesRequest request =
        ListOnlineReturnPoliciesRequest.newBuilder().setParent(parent).build();
    return listOnlineReturnPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all existing return policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OnlineReturnPolicyServiceClient onlineReturnPolicyServiceClient =
   *     OnlineReturnPolicyServiceClient.create()) {
   *   ListOnlineReturnPoliciesRequest request =
   *       ListOnlineReturnPoliciesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (OnlineReturnPolicy element :
   *       onlineReturnPolicyServiceClient.listOnlineReturnPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOnlineReturnPoliciesPagedResponse listOnlineReturnPolicies(
      ListOnlineReturnPoliciesRequest request) {
    return listOnlineReturnPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all existing return policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OnlineReturnPolicyServiceClient onlineReturnPolicyServiceClient =
   *     OnlineReturnPolicyServiceClient.create()) {
   *   ListOnlineReturnPoliciesRequest request =
   *       ListOnlineReturnPoliciesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<OnlineReturnPolicy> future =
   *       onlineReturnPolicyServiceClient
   *           .listOnlineReturnPoliciesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (OnlineReturnPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesPagedResponse>
      listOnlineReturnPoliciesPagedCallable() {
    return stub.listOnlineReturnPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all existing return policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OnlineReturnPolicyServiceClient onlineReturnPolicyServiceClient =
   *     OnlineReturnPolicyServiceClient.create()) {
   *   ListOnlineReturnPoliciesRequest request =
   *       ListOnlineReturnPoliciesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListOnlineReturnPoliciesResponse response =
   *         onlineReturnPolicyServiceClient.listOnlineReturnPoliciesCallable().call(request);
   *     for (OnlineReturnPolicy element : response.getOnlineReturnPoliciesList()) {
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
  public final UnaryCallable<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesResponse>
      listOnlineReturnPoliciesCallable() {
    return stub.listOnlineReturnPoliciesCallable();
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

  public static class ListOnlineReturnPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListOnlineReturnPoliciesRequest,
          ListOnlineReturnPoliciesResponse,
          OnlineReturnPolicy,
          ListOnlineReturnPoliciesPage,
          ListOnlineReturnPoliciesFixedSizeCollection> {

    public static ApiFuture<ListOnlineReturnPoliciesPagedResponse> createAsync(
        PageContext<
                ListOnlineReturnPoliciesRequest,
                ListOnlineReturnPoliciesResponse,
                OnlineReturnPolicy>
            context,
        ApiFuture<ListOnlineReturnPoliciesResponse> futureResponse) {
      ApiFuture<ListOnlineReturnPoliciesPage> futurePage =
          ListOnlineReturnPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOnlineReturnPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOnlineReturnPoliciesPagedResponse(ListOnlineReturnPoliciesPage page) {
      super(page, ListOnlineReturnPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOnlineReturnPoliciesPage
      extends AbstractPage<
          ListOnlineReturnPoliciesRequest,
          ListOnlineReturnPoliciesResponse,
          OnlineReturnPolicy,
          ListOnlineReturnPoliciesPage> {

    private ListOnlineReturnPoliciesPage(
        PageContext<
                ListOnlineReturnPoliciesRequest,
                ListOnlineReturnPoliciesResponse,
                OnlineReturnPolicy>
            context,
        ListOnlineReturnPoliciesResponse response) {
      super(context, response);
    }

    private static ListOnlineReturnPoliciesPage createEmptyPage() {
      return new ListOnlineReturnPoliciesPage(null, null);
    }

    @Override
    protected ListOnlineReturnPoliciesPage createPage(
        PageContext<
                ListOnlineReturnPoliciesRequest,
                ListOnlineReturnPoliciesResponse,
                OnlineReturnPolicy>
            context,
        ListOnlineReturnPoliciesResponse response) {
      return new ListOnlineReturnPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListOnlineReturnPoliciesPage> createPageAsync(
        PageContext<
                ListOnlineReturnPoliciesRequest,
                ListOnlineReturnPoliciesResponse,
                OnlineReturnPolicy>
            context,
        ApiFuture<ListOnlineReturnPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOnlineReturnPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOnlineReturnPoliciesRequest,
          ListOnlineReturnPoliciesResponse,
          OnlineReturnPolicy,
          ListOnlineReturnPoliciesPage,
          ListOnlineReturnPoliciesFixedSizeCollection> {

    private ListOnlineReturnPoliciesFixedSizeCollection(
        List<ListOnlineReturnPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOnlineReturnPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListOnlineReturnPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOnlineReturnPoliciesFixedSizeCollection createCollection(
        List<ListOnlineReturnPoliciesPage> pages, int collectionSize) {
      return new ListOnlineReturnPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }
}
