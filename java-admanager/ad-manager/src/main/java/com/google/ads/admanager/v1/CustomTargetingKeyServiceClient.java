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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.CustomTargetingKeyServiceStub;
import com.google.ads.admanager.v1.stub.CustomTargetingKeyServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `CustomTargetingKey` objects.
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
 * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
 *     CustomTargetingKeyServiceClient.create()) {
 *   CustomTargetingKeyName name =
 *       CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]");
 *   CustomTargetingKey response = customTargetingKeyServiceClient.getCustomTargetingKey(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CustomTargetingKeyServiceClient object to clean up
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
 *      <td><p> GetCustomTargetingKey</td>
 *      <td><p> API to retrieve a `CustomTargetingKey` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCustomTargetingKey(GetCustomTargetingKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCustomTargetingKey(CustomTargetingKeyName name)
 *           <li><p> getCustomTargetingKey(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCustomTargetingKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCustomTargetingKeys</td>
 *      <td><p> API to retrieve a list of `CustomTargetingKey` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCustomTargetingKeys(ListCustomTargetingKeysRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCustomTargetingKeys(NetworkName parent)
 *           <li><p> listCustomTargetingKeys(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCustomTargetingKeysPagedCallable()
 *           <li><p> listCustomTargetingKeysCallable()
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
 * CustomTargetingKeyServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CustomTargetingKeyServiceSettings customTargetingKeyServiceSettings =
 *     CustomTargetingKeyServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
 *     CustomTargetingKeyServiceClient.create(customTargetingKeyServiceSettings);
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
 * CustomTargetingKeyServiceSettings customTargetingKeyServiceSettings =
 *     CustomTargetingKeyServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
 *     CustomTargetingKeyServiceClient.create(customTargetingKeyServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CustomTargetingKeyServiceClient implements BackgroundResource {
  private final CustomTargetingKeyServiceSettings settings;
  private final CustomTargetingKeyServiceStub stub;

  /** Constructs an instance of CustomTargetingKeyServiceClient with default settings. */
  public static final CustomTargetingKeyServiceClient create() throws IOException {
    return create(CustomTargetingKeyServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CustomTargetingKeyServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final CustomTargetingKeyServiceClient create(
      CustomTargetingKeyServiceSettings settings) throws IOException {
    return new CustomTargetingKeyServiceClient(settings);
  }

  /**
   * Constructs an instance of CustomTargetingKeyServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(CustomTargetingKeyServiceSettings).
   */
  public static final CustomTargetingKeyServiceClient create(CustomTargetingKeyServiceStub stub) {
    return new CustomTargetingKeyServiceClient(stub);
  }

  /**
   * Constructs an instance of CustomTargetingKeyServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CustomTargetingKeyServiceClient(CustomTargetingKeyServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((CustomTargetingKeyServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CustomTargetingKeyServiceClient(CustomTargetingKeyServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CustomTargetingKeyServiceSettings getSettings() {
    return settings;
  }

  public CustomTargetingKeyServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomTargetingKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   CustomTargetingKeyName name =
   *       CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]");
   *   CustomTargetingKey response = customTargetingKeyServiceClient.getCustomTargetingKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomTargetingKey. Format:
   *     `networks/{network_code}/customTargetingKeys/{custom_targeting_key_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingKey getCustomTargetingKey(CustomTargetingKeyName name) {
    GetCustomTargetingKeyRequest request =
        GetCustomTargetingKeyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCustomTargetingKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomTargetingKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   String name =
   *       CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString();
   *   CustomTargetingKey response = customTargetingKeyServiceClient.getCustomTargetingKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomTargetingKey. Format:
   *     `networks/{network_code}/customTargetingKeys/{custom_targeting_key_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingKey getCustomTargetingKey(String name) {
    GetCustomTargetingKeyRequest request =
        GetCustomTargetingKeyRequest.newBuilder().setName(name).build();
    return getCustomTargetingKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomTargetingKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   GetCustomTargetingKeyRequest request =
   *       GetCustomTargetingKeyRequest.newBuilder()
   *           .setName(
   *               CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString())
   *           .build();
   *   CustomTargetingKey response = customTargetingKeyServiceClient.getCustomTargetingKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingKey getCustomTargetingKey(GetCustomTargetingKeyRequest request) {
    return getCustomTargetingKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomTargetingKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   GetCustomTargetingKeyRequest request =
   *       GetCustomTargetingKeyRequest.newBuilder()
   *           .setName(
   *               CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString())
   *           .build();
   *   ApiFuture<CustomTargetingKey> future =
   *       customTargetingKeyServiceClient.getCustomTargetingKeyCallable().futureCall(request);
   *   // Do something.
   *   CustomTargetingKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCustomTargetingKeyRequest, CustomTargetingKey>
      getCustomTargetingKeyCallable() {
    return stub.getCustomTargetingKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (CustomTargetingKey element :
   *       customTargetingKeyServiceClient.listCustomTargetingKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingKeys. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomTargetingKeysPagedResponse listCustomTargetingKeys(NetworkName parent) {
    ListCustomTargetingKeysRequest request =
        ListCustomTargetingKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCustomTargetingKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (CustomTargetingKey element :
   *       customTargetingKeyServiceClient.listCustomTargetingKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingKeys. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomTargetingKeysPagedResponse listCustomTargetingKeys(String parent) {
    ListCustomTargetingKeysRequest request =
        ListCustomTargetingKeysRequest.newBuilder().setParent(parent).build();
    return listCustomTargetingKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   ListCustomTargetingKeysRequest request =
   *       ListCustomTargetingKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (CustomTargetingKey element :
   *       customTargetingKeyServiceClient.listCustomTargetingKeys(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomTargetingKeysPagedResponse listCustomTargetingKeys(
      ListCustomTargetingKeysRequest request) {
    return listCustomTargetingKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   ListCustomTargetingKeysRequest request =
   *       ListCustomTargetingKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<CustomTargetingKey> future =
   *       customTargetingKeyServiceClient
   *           .listCustomTargetingKeysPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (CustomTargetingKey element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCustomTargetingKeysRequest, ListCustomTargetingKeysPagedResponse>
      listCustomTargetingKeysPagedCallable() {
    return stub.listCustomTargetingKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   ListCustomTargetingKeysRequest request =
   *       ListCustomTargetingKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListCustomTargetingKeysResponse response =
   *         customTargetingKeyServiceClient.listCustomTargetingKeysCallable().call(request);
   *     for (CustomTargetingKey element : response.getCustomTargetingKeysList()) {
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
  public final UnaryCallable<ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>
      listCustomTargetingKeysCallable() {
    return stub.listCustomTargetingKeysCallable();
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

  public static class ListCustomTargetingKeysPagedResponse
      extends AbstractPagedListResponse<
          ListCustomTargetingKeysRequest,
          ListCustomTargetingKeysResponse,
          CustomTargetingKey,
          ListCustomTargetingKeysPage,
          ListCustomTargetingKeysFixedSizeCollection> {

    public static ApiFuture<ListCustomTargetingKeysPagedResponse> createAsync(
        PageContext<
                ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse, CustomTargetingKey>
            context,
        ApiFuture<ListCustomTargetingKeysResponse> futureResponse) {
      ApiFuture<ListCustomTargetingKeysPage> futurePage =
          ListCustomTargetingKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCustomTargetingKeysPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCustomTargetingKeysPagedResponse(ListCustomTargetingKeysPage page) {
      super(page, ListCustomTargetingKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCustomTargetingKeysPage
      extends AbstractPage<
          ListCustomTargetingKeysRequest,
          ListCustomTargetingKeysResponse,
          CustomTargetingKey,
          ListCustomTargetingKeysPage> {

    private ListCustomTargetingKeysPage(
        PageContext<
                ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse, CustomTargetingKey>
            context,
        ListCustomTargetingKeysResponse response) {
      super(context, response);
    }

    private static ListCustomTargetingKeysPage createEmptyPage() {
      return new ListCustomTargetingKeysPage(null, null);
    }

    @Override
    protected ListCustomTargetingKeysPage createPage(
        PageContext<
                ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse, CustomTargetingKey>
            context,
        ListCustomTargetingKeysResponse response) {
      return new ListCustomTargetingKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListCustomTargetingKeysPage> createPageAsync(
        PageContext<
                ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse, CustomTargetingKey>
            context,
        ApiFuture<ListCustomTargetingKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCustomTargetingKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCustomTargetingKeysRequest,
          ListCustomTargetingKeysResponse,
          CustomTargetingKey,
          ListCustomTargetingKeysPage,
          ListCustomTargetingKeysFixedSizeCollection> {

    private ListCustomTargetingKeysFixedSizeCollection(
        List<ListCustomTargetingKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCustomTargetingKeysFixedSizeCollection createEmptyCollection() {
      return new ListCustomTargetingKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCustomTargetingKeysFixedSizeCollection createCollection(
        List<ListCustomTargetingKeysPage> pages, int collectionSize) {
      return new ListCustomTargetingKeysFixedSizeCollection(pages, collectionSize);
    }
  }
}
