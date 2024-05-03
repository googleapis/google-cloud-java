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

import com.google.ads.admanager.v1.stub.CustomTargetingValueServiceStub;
import com.google.ads.admanager.v1.stub.CustomTargetingValueServiceStubSettings;
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
 * Service Description: Provides methods for handling `CustomTargetingValue` objects.
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
 * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
 *     CustomTargetingValueServiceClient.create()) {
 *   CustomTargetingValueName name =
 *       CustomTargetingValueName.of(
 *           "[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]", "[CUSTOM_TARGETING_VALUE]");
 *   CustomTargetingValue response =
 *       customTargetingValueServiceClient.getCustomTargetingValue(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CustomTargetingValueServiceClient object to clean up
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
 *      <td><p> GetCustomTargetingValue</td>
 *      <td><p> API to retrieve a `CustomTargetingValue` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCustomTargetingValue(GetCustomTargetingValueRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCustomTargetingValue(CustomTargetingValueName name)
 *           <li><p> getCustomTargetingValue(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCustomTargetingValueCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCustomTargetingValues</td>
 *      <td><p> API to retrieve a list of `CustomTargetingValue` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCustomTargetingValues(ListCustomTargetingValuesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCustomTargetingValues(CustomTargetingKeyName parent)
 *           <li><p> listCustomTargetingValues(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCustomTargetingValuesPagedCallable()
 *           <li><p> listCustomTargetingValuesCallable()
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
 * CustomTargetingValueServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CustomTargetingValueServiceSettings customTargetingValueServiceSettings =
 *     CustomTargetingValueServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CustomTargetingValueServiceClient customTargetingValueServiceClient =
 *     CustomTargetingValueServiceClient.create(customTargetingValueServiceSettings);
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
 * CustomTargetingValueServiceSettings customTargetingValueServiceSettings =
 *     CustomTargetingValueServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CustomTargetingValueServiceClient customTargetingValueServiceClient =
 *     CustomTargetingValueServiceClient.create(customTargetingValueServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CustomTargetingValueServiceClient implements BackgroundResource {
  private final CustomTargetingValueServiceSettings settings;
  private final CustomTargetingValueServiceStub stub;

  /** Constructs an instance of CustomTargetingValueServiceClient with default settings. */
  public static final CustomTargetingValueServiceClient create() throws IOException {
    return create(CustomTargetingValueServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CustomTargetingValueServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final CustomTargetingValueServiceClient create(
      CustomTargetingValueServiceSettings settings) throws IOException {
    return new CustomTargetingValueServiceClient(settings);
  }

  /**
   * Constructs an instance of CustomTargetingValueServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(CustomTargetingValueServiceSettings).
   */
  public static final CustomTargetingValueServiceClient create(
      CustomTargetingValueServiceStub stub) {
    return new CustomTargetingValueServiceClient(stub);
  }

  /**
   * Constructs an instance of CustomTargetingValueServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CustomTargetingValueServiceClient(CustomTargetingValueServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((CustomTargetingValueServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CustomTargetingValueServiceClient(CustomTargetingValueServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CustomTargetingValueServiceSettings getSettings() {
    return settings;
  }

  public CustomTargetingValueServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomTargetingValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   CustomTargetingValueName name =
   *       CustomTargetingValueName.of(
   *           "[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]", "[CUSTOM_TARGETING_VALUE]");
   *   CustomTargetingValue response =
   *       customTargetingValueServiceClient.getCustomTargetingValue(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomTargetingValue. Format:
   *     `networks/{network_code}/customTargetingKeys/{custom_targeting_key_id}/customTargetingValues/{custom_targeting_value_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingValue getCustomTargetingValue(CustomTargetingValueName name) {
    GetCustomTargetingValueRequest request =
        GetCustomTargetingValueRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCustomTargetingValue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomTargetingValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   String name =
   *       CustomTargetingValueName.of(
   *               "[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]", "[CUSTOM_TARGETING_VALUE]")
   *           .toString();
   *   CustomTargetingValue response =
   *       customTargetingValueServiceClient.getCustomTargetingValue(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomTargetingValue. Format:
   *     `networks/{network_code}/customTargetingKeys/{custom_targeting_key_id}/customTargetingValues/{custom_targeting_value_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingValue getCustomTargetingValue(String name) {
    GetCustomTargetingValueRequest request =
        GetCustomTargetingValueRequest.newBuilder().setName(name).build();
    return getCustomTargetingValue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomTargetingValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   GetCustomTargetingValueRequest request =
   *       GetCustomTargetingValueRequest.newBuilder()
   *           .setName(
   *               CustomTargetingValueName.of(
   *                       "[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]", "[CUSTOM_TARGETING_VALUE]")
   *                   .toString())
   *           .build();
   *   CustomTargetingValue response =
   *       customTargetingValueServiceClient.getCustomTargetingValue(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingValue getCustomTargetingValue(
      GetCustomTargetingValueRequest request) {
    return getCustomTargetingValueCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomTargetingValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   GetCustomTargetingValueRequest request =
   *       GetCustomTargetingValueRequest.newBuilder()
   *           .setName(
   *               CustomTargetingValueName.of(
   *                       "[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]", "[CUSTOM_TARGETING_VALUE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CustomTargetingValue> future =
   *       customTargetingValueServiceClient.getCustomTargetingValueCallable().futureCall(request);
   *   // Do something.
   *   CustomTargetingValue response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCustomTargetingValueRequest, CustomTargetingValue>
      getCustomTargetingValueCallable() {
    return stub.getCustomTargetingValueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   CustomTargetingKeyName parent =
   *       CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]");
   *   for (CustomTargetingValue element :
   *       customTargetingValueServiceClient.listCustomTargetingValues(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingValues.
   *     Format: `networks/{network_code}/customTargetingKeys/{custom_targeting_key_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomTargetingValuesPagedResponse listCustomTargetingValues(
      CustomTargetingKeyName parent) {
    ListCustomTargetingValuesRequest request =
        ListCustomTargetingValuesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCustomTargetingValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   String parent =
   *       CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString();
   *   for (CustomTargetingValue element :
   *       customTargetingValueServiceClient.listCustomTargetingValues(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingValues.
   *     Format: `networks/{network_code}/customTargetingKeys/{custom_targeting_key_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomTargetingValuesPagedResponse listCustomTargetingValues(String parent) {
    ListCustomTargetingValuesRequest request =
        ListCustomTargetingValuesRequest.newBuilder().setParent(parent).build();
    return listCustomTargetingValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   ListCustomTargetingValuesRequest request =
   *       ListCustomTargetingValuesRequest.newBuilder()
   *           .setParent(
   *               CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (CustomTargetingValue element :
   *       customTargetingValueServiceClient.listCustomTargetingValues(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomTargetingValuesPagedResponse listCustomTargetingValues(
      ListCustomTargetingValuesRequest request) {
    return listCustomTargetingValuesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   ListCustomTargetingValuesRequest request =
   *       ListCustomTargetingValuesRequest.newBuilder()
   *           .setParent(
   *               CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<CustomTargetingValue> future =
   *       customTargetingValueServiceClient
   *           .listCustomTargetingValuesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (CustomTargetingValue element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListCustomTargetingValuesRequest, ListCustomTargetingValuesPagedResponse>
      listCustomTargetingValuesPagedCallable() {
    return stub.listCustomTargetingValuesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   ListCustomTargetingValuesRequest request =
   *       ListCustomTargetingValuesRequest.newBuilder()
   *           .setParent(
   *               CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListCustomTargetingValuesResponse response =
   *         customTargetingValueServiceClient.listCustomTargetingValuesCallable().call(request);
   *     for (CustomTargetingValue element : response.getCustomTargetingValuesList()) {
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
  public final UnaryCallable<ListCustomTargetingValuesRequest, ListCustomTargetingValuesResponse>
      listCustomTargetingValuesCallable() {
    return stub.listCustomTargetingValuesCallable();
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

  public static class ListCustomTargetingValuesPagedResponse
      extends AbstractPagedListResponse<
          ListCustomTargetingValuesRequest,
          ListCustomTargetingValuesResponse,
          CustomTargetingValue,
          ListCustomTargetingValuesPage,
          ListCustomTargetingValuesFixedSizeCollection> {

    public static ApiFuture<ListCustomTargetingValuesPagedResponse> createAsync(
        PageContext<
                ListCustomTargetingValuesRequest,
                ListCustomTargetingValuesResponse,
                CustomTargetingValue>
            context,
        ApiFuture<ListCustomTargetingValuesResponse> futureResponse) {
      ApiFuture<ListCustomTargetingValuesPage> futurePage =
          ListCustomTargetingValuesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCustomTargetingValuesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCustomTargetingValuesPagedResponse(ListCustomTargetingValuesPage page) {
      super(page, ListCustomTargetingValuesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCustomTargetingValuesPage
      extends AbstractPage<
          ListCustomTargetingValuesRequest,
          ListCustomTargetingValuesResponse,
          CustomTargetingValue,
          ListCustomTargetingValuesPage> {

    private ListCustomTargetingValuesPage(
        PageContext<
                ListCustomTargetingValuesRequest,
                ListCustomTargetingValuesResponse,
                CustomTargetingValue>
            context,
        ListCustomTargetingValuesResponse response) {
      super(context, response);
    }

    private static ListCustomTargetingValuesPage createEmptyPage() {
      return new ListCustomTargetingValuesPage(null, null);
    }

    @Override
    protected ListCustomTargetingValuesPage createPage(
        PageContext<
                ListCustomTargetingValuesRequest,
                ListCustomTargetingValuesResponse,
                CustomTargetingValue>
            context,
        ListCustomTargetingValuesResponse response) {
      return new ListCustomTargetingValuesPage(context, response);
    }

    @Override
    public ApiFuture<ListCustomTargetingValuesPage> createPageAsync(
        PageContext<
                ListCustomTargetingValuesRequest,
                ListCustomTargetingValuesResponse,
                CustomTargetingValue>
            context,
        ApiFuture<ListCustomTargetingValuesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCustomTargetingValuesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCustomTargetingValuesRequest,
          ListCustomTargetingValuesResponse,
          CustomTargetingValue,
          ListCustomTargetingValuesPage,
          ListCustomTargetingValuesFixedSizeCollection> {

    private ListCustomTargetingValuesFixedSizeCollection(
        List<ListCustomTargetingValuesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCustomTargetingValuesFixedSizeCollection createEmptyCollection() {
      return new ListCustomTargetingValuesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCustomTargetingValuesFixedSizeCollection createCollection(
        List<ListCustomTargetingValuesPage> pages, int collectionSize) {
      return new ListCustomTargetingValuesFixedSizeCollection(pages, collectionSize);
    }
  }
}
