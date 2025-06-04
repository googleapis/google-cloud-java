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

package com.google.cloud.discoveryengine.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.stub.UserLicenseServiceStub;
import com.google.cloud.discoveryengine.v1.stub.UserLicenseServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing User Licenses.
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
 * try (UserLicenseServiceClient userLicenseServiceClient = UserLicenseServiceClient.create()) {
 *   UserStoreName parent = UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]");
 *   for (UserLicense element : userLicenseServiceClient.listUserLicenses(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the UserLicenseServiceClient object to clean up resources
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
 *      <td><p> ListUserLicenses</td>
 *      <td><p> Lists the User Licenses.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUserLicenses(ListUserLicensesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listUserLicenses(UserStoreName parent)
 *           <li><p> listUserLicenses(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUserLicensesPagedCallable()
 *           <li><p> listUserLicensesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateUserLicenses</td>
 *      <td><p> Updates the User License. This method is used for batch assign/unassign licenses to users.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateUserLicensesAsync(BatchUpdateUserLicensesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateUserLicensesOperationCallable()
 *           <li><p> batchUpdateUserLicensesCallable()
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
 * <p>This class can be customized by passing in a custom instance of UserLicenseServiceSettings to
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
 * UserLicenseServiceSettings userLicenseServiceSettings =
 *     UserLicenseServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * UserLicenseServiceClient userLicenseServiceClient =
 *     UserLicenseServiceClient.create(userLicenseServiceSettings);
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
 * UserLicenseServiceSettings userLicenseServiceSettings =
 *     UserLicenseServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * UserLicenseServiceClient userLicenseServiceClient =
 *     UserLicenseServiceClient.create(userLicenseServiceSettings);
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
 * UserLicenseServiceSettings userLicenseServiceSettings =
 *     UserLicenseServiceSettings.newHttpJsonBuilder().build();
 * UserLicenseServiceClient userLicenseServiceClient =
 *     UserLicenseServiceClient.create(userLicenseServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class UserLicenseServiceClient implements BackgroundResource {
  private final UserLicenseServiceSettings settings;
  private final UserLicenseServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of UserLicenseServiceClient with default settings. */
  public static final UserLicenseServiceClient create() throws IOException {
    return create(UserLicenseServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of UserLicenseServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final UserLicenseServiceClient create(UserLicenseServiceSettings settings)
      throws IOException {
    return new UserLicenseServiceClient(settings);
  }

  /**
   * Constructs an instance of UserLicenseServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(UserLicenseServiceSettings).
   */
  public static final UserLicenseServiceClient create(UserLicenseServiceStub stub) {
    return new UserLicenseServiceClient(stub);
  }

  /**
   * Constructs an instance of UserLicenseServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected UserLicenseServiceClient(UserLicenseServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((UserLicenseServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected UserLicenseServiceClient(UserLicenseServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final UserLicenseServiceSettings getSettings() {
    return settings;
  }

  public UserLicenseServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the User Licenses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserLicenseServiceClient userLicenseServiceClient = UserLicenseServiceClient.create()) {
   *   UserStoreName parent = UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]");
   *   for (UserLicense element : userLicenseServiceClient.listUserLicenses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent [UserStore][] resource name, format:
   *     `projects/{project}/locations/{location}/userStores/{user_store_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserLicensesPagedResponse listUserLicenses(UserStoreName parent) {
    ListUserLicensesRequest request =
        ListUserLicensesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUserLicenses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the User Licenses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserLicenseServiceClient userLicenseServiceClient = UserLicenseServiceClient.create()) {
   *   String parent = UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString();
   *   for (UserLicense element : userLicenseServiceClient.listUserLicenses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent [UserStore][] resource name, format:
   *     `projects/{project}/locations/{location}/userStores/{user_store_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserLicensesPagedResponse listUserLicenses(String parent) {
    ListUserLicensesRequest request =
        ListUserLicensesRequest.newBuilder().setParent(parent).build();
    return listUserLicenses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the User Licenses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserLicenseServiceClient userLicenseServiceClient = UserLicenseServiceClient.create()) {
   *   ListUserLicensesRequest request =
   *       ListUserLicensesRequest.newBuilder()
   *           .setParent(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (UserLicense element : userLicenseServiceClient.listUserLicenses(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserLicensesPagedResponse listUserLicenses(ListUserLicensesRequest request) {
    return listUserLicensesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the User Licenses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserLicenseServiceClient userLicenseServiceClient = UserLicenseServiceClient.create()) {
   *   ListUserLicensesRequest request =
   *       ListUserLicensesRequest.newBuilder()
   *           .setParent(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<UserLicense> future =
   *       userLicenseServiceClient.listUserLicensesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (UserLicense element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUserLicensesRequest, ListUserLicensesPagedResponse>
      listUserLicensesPagedCallable() {
    return stub.listUserLicensesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the User Licenses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserLicenseServiceClient userLicenseServiceClient = UserLicenseServiceClient.create()) {
   *   ListUserLicensesRequest request =
   *       ListUserLicensesRequest.newBuilder()
   *           .setParent(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListUserLicensesResponse response =
   *         userLicenseServiceClient.listUserLicensesCallable().call(request);
   *     for (UserLicense element : response.getUserLicensesList()) {
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
  public final UnaryCallable<ListUserLicensesRequest, ListUserLicensesResponse>
      listUserLicensesCallable() {
    return stub.listUserLicensesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the User License. This method is used for batch assign/unassign licenses to users.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserLicenseServiceClient userLicenseServiceClient = UserLicenseServiceClient.create()) {
   *   BatchUpdateUserLicensesRequest request =
   *       BatchUpdateUserLicensesRequest.newBuilder()
   *           .setParent(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
   *           .setDeleteUnassignedUserLicenses(true)
   *           .build();
   *   BatchUpdateUserLicensesResponse response =
   *       userLicenseServiceClient.batchUpdateUserLicensesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchUpdateUserLicensesResponse, BatchUpdateUserLicensesMetadata>
      batchUpdateUserLicensesAsync(BatchUpdateUserLicensesRequest request) {
    return batchUpdateUserLicensesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the User License. This method is used for batch assign/unassign licenses to users.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserLicenseServiceClient userLicenseServiceClient = UserLicenseServiceClient.create()) {
   *   BatchUpdateUserLicensesRequest request =
   *       BatchUpdateUserLicensesRequest.newBuilder()
   *           .setParent(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
   *           .setDeleteUnassignedUserLicenses(true)
   *           .build();
   *   OperationFuture<BatchUpdateUserLicensesResponse, BatchUpdateUserLicensesMetadata> future =
   *       userLicenseServiceClient.batchUpdateUserLicensesOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateUserLicensesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchUpdateUserLicensesRequest,
          BatchUpdateUserLicensesResponse,
          BatchUpdateUserLicensesMetadata>
      batchUpdateUserLicensesOperationCallable() {
    return stub.batchUpdateUserLicensesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the User License. This method is used for batch assign/unassign licenses to users.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserLicenseServiceClient userLicenseServiceClient = UserLicenseServiceClient.create()) {
   *   BatchUpdateUserLicensesRequest request =
   *       BatchUpdateUserLicensesRequest.newBuilder()
   *           .setParent(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
   *           .setDeleteUnassignedUserLicenses(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       userLicenseServiceClient.batchUpdateUserLicensesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateUserLicensesRequest, Operation>
      batchUpdateUserLicensesCallable() {
    return stub.batchUpdateUserLicensesCallable();
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

  public static class ListUserLicensesPagedResponse
      extends AbstractPagedListResponse<
          ListUserLicensesRequest,
          ListUserLicensesResponse,
          UserLicense,
          ListUserLicensesPage,
          ListUserLicensesFixedSizeCollection> {

    public static ApiFuture<ListUserLicensesPagedResponse> createAsync(
        PageContext<ListUserLicensesRequest, ListUserLicensesResponse, UserLicense> context,
        ApiFuture<ListUserLicensesResponse> futureResponse) {
      ApiFuture<ListUserLicensesPage> futurePage =
          ListUserLicensesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUserLicensesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUserLicensesPagedResponse(ListUserLicensesPage page) {
      super(page, ListUserLicensesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUserLicensesPage
      extends AbstractPage<
          ListUserLicensesRequest, ListUserLicensesResponse, UserLicense, ListUserLicensesPage> {

    private ListUserLicensesPage(
        PageContext<ListUserLicensesRequest, ListUserLicensesResponse, UserLicense> context,
        ListUserLicensesResponse response) {
      super(context, response);
    }

    private static ListUserLicensesPage createEmptyPage() {
      return new ListUserLicensesPage(null, null);
    }

    @Override
    protected ListUserLicensesPage createPage(
        PageContext<ListUserLicensesRequest, ListUserLicensesResponse, UserLicense> context,
        ListUserLicensesResponse response) {
      return new ListUserLicensesPage(context, response);
    }

    @Override
    public ApiFuture<ListUserLicensesPage> createPageAsync(
        PageContext<ListUserLicensesRequest, ListUserLicensesResponse, UserLicense> context,
        ApiFuture<ListUserLicensesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUserLicensesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUserLicensesRequest,
          ListUserLicensesResponse,
          UserLicense,
          ListUserLicensesPage,
          ListUserLicensesFixedSizeCollection> {

    private ListUserLicensesFixedSizeCollection(
        List<ListUserLicensesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUserLicensesFixedSizeCollection createEmptyCollection() {
      return new ListUserLicensesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUserLicensesFixedSizeCollection createCollection(
        List<ListUserLicensesPage> pages, int collectionSize) {
      return new ListUserLicensesFixedSizeCollection(pages, collectionSize);
    }
  }
}
