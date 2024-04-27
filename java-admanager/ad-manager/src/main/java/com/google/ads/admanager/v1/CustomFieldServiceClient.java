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

import com.google.ads.admanager.v1.stub.CustomFieldServiceStub;
import com.google.ads.admanager.v1.stub.CustomFieldServiceStubSettings;
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
 * Service Description: Provides methods for handling `CustomField` objects.
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
 * try (CustomFieldServiceClient customFieldServiceClient = CustomFieldServiceClient.create()) {
 *   CustomFieldName name = CustomFieldName.of("[NETWORK_CODE]", "[CUSTOM_FIELD]");
 *   CustomField response = customFieldServiceClient.getCustomField(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CustomFieldServiceClient object to clean up resources
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
 *      <td><p> GetCustomField</td>
 *      <td><p> API to retrieve a `CustomField` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCustomField(GetCustomFieldRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCustomField(CustomFieldName name)
 *           <li><p> getCustomField(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCustomFieldCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCustomFields</td>
 *      <td><p> API to retrieve a list of `CustomField` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCustomFields(ListCustomFieldsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCustomFields(NetworkName parent)
 *           <li><p> listCustomFields(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCustomFieldsPagedCallable()
 *           <li><p> listCustomFieldsCallable()
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
 * <p>This class can be customized by passing in a custom instance of CustomFieldServiceSettings to
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
 * CustomFieldServiceSettings customFieldServiceSettings =
 *     CustomFieldServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CustomFieldServiceClient customFieldServiceClient =
 *     CustomFieldServiceClient.create(customFieldServiceSettings);
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
 * CustomFieldServiceSettings customFieldServiceSettings =
 *     CustomFieldServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CustomFieldServiceClient customFieldServiceClient =
 *     CustomFieldServiceClient.create(customFieldServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CustomFieldServiceClient implements BackgroundResource {
  private final CustomFieldServiceSettings settings;
  private final CustomFieldServiceStub stub;

  /** Constructs an instance of CustomFieldServiceClient with default settings. */
  public static final CustomFieldServiceClient create() throws IOException {
    return create(CustomFieldServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CustomFieldServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CustomFieldServiceClient create(CustomFieldServiceSettings settings)
      throws IOException {
    return new CustomFieldServiceClient(settings);
  }

  /**
   * Constructs an instance of CustomFieldServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(CustomFieldServiceSettings).
   */
  public static final CustomFieldServiceClient create(CustomFieldServiceStub stub) {
    return new CustomFieldServiceClient(stub);
  }

  /**
   * Constructs an instance of CustomFieldServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CustomFieldServiceClient(CustomFieldServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CustomFieldServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CustomFieldServiceClient(CustomFieldServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CustomFieldServiceSettings getSettings() {
    return settings;
  }

  public CustomFieldServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomField` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomFieldServiceClient customFieldServiceClient = CustomFieldServiceClient.create()) {
   *   CustomFieldName name = CustomFieldName.of("[NETWORK_CODE]", "[CUSTOM_FIELD]");
   *   CustomField response = customFieldServiceClient.getCustomField(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomField. Format:
   *     `networks/{network_code}/customFields/{custom_field_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomField getCustomField(CustomFieldName name) {
    GetCustomFieldRequest request =
        GetCustomFieldRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCustomField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomField` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomFieldServiceClient customFieldServiceClient = CustomFieldServiceClient.create()) {
   *   String name = CustomFieldName.of("[NETWORK_CODE]", "[CUSTOM_FIELD]").toString();
   *   CustomField response = customFieldServiceClient.getCustomField(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomField. Format:
   *     `networks/{network_code}/customFields/{custom_field_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomField getCustomField(String name) {
    GetCustomFieldRequest request = GetCustomFieldRequest.newBuilder().setName(name).build();
    return getCustomField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomField` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomFieldServiceClient customFieldServiceClient = CustomFieldServiceClient.create()) {
   *   GetCustomFieldRequest request =
   *       GetCustomFieldRequest.newBuilder()
   *           .setName(CustomFieldName.of("[NETWORK_CODE]", "[CUSTOM_FIELD]").toString())
   *           .build();
   *   CustomField response = customFieldServiceClient.getCustomField(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomField getCustomField(GetCustomFieldRequest request) {
    return getCustomFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomField` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomFieldServiceClient customFieldServiceClient = CustomFieldServiceClient.create()) {
   *   GetCustomFieldRequest request =
   *       GetCustomFieldRequest.newBuilder()
   *           .setName(CustomFieldName.of("[NETWORK_CODE]", "[CUSTOM_FIELD]").toString())
   *           .build();
   *   ApiFuture<CustomField> future =
   *       customFieldServiceClient.getCustomFieldCallable().futureCall(request);
   *   // Do something.
   *   CustomField response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCustomFieldRequest, CustomField> getCustomFieldCallable() {
    return stub.getCustomFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomField` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomFieldServiceClient customFieldServiceClient = CustomFieldServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (CustomField element : customFieldServiceClient.listCustomFields(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomFields. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomFieldsPagedResponse listCustomFields(NetworkName parent) {
    ListCustomFieldsRequest request =
        ListCustomFieldsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCustomFields(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomField` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomFieldServiceClient customFieldServiceClient = CustomFieldServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (CustomField element : customFieldServiceClient.listCustomFields(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomFields. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomFieldsPagedResponse listCustomFields(String parent) {
    ListCustomFieldsRequest request =
        ListCustomFieldsRequest.newBuilder().setParent(parent).build();
    return listCustomFields(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomField` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomFieldServiceClient customFieldServiceClient = CustomFieldServiceClient.create()) {
   *   ListCustomFieldsRequest request =
   *       ListCustomFieldsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (CustomField element : customFieldServiceClient.listCustomFields(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomFieldsPagedResponse listCustomFields(ListCustomFieldsRequest request) {
    return listCustomFieldsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomField` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomFieldServiceClient customFieldServiceClient = CustomFieldServiceClient.create()) {
   *   ListCustomFieldsRequest request =
   *       ListCustomFieldsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<CustomField> future =
   *       customFieldServiceClient.listCustomFieldsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CustomField element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCustomFieldsRequest, ListCustomFieldsPagedResponse>
      listCustomFieldsPagedCallable() {
    return stub.listCustomFieldsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomField` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomFieldServiceClient customFieldServiceClient = CustomFieldServiceClient.create()) {
   *   ListCustomFieldsRequest request =
   *       ListCustomFieldsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListCustomFieldsResponse response =
   *         customFieldServiceClient.listCustomFieldsCallable().call(request);
   *     for (CustomField element : response.getCustomFieldsList()) {
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
  public final UnaryCallable<ListCustomFieldsRequest, ListCustomFieldsResponse>
      listCustomFieldsCallable() {
    return stub.listCustomFieldsCallable();
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

  public static class ListCustomFieldsPagedResponse
      extends AbstractPagedListResponse<
          ListCustomFieldsRequest,
          ListCustomFieldsResponse,
          CustomField,
          ListCustomFieldsPage,
          ListCustomFieldsFixedSizeCollection> {

    public static ApiFuture<ListCustomFieldsPagedResponse> createAsync(
        PageContext<ListCustomFieldsRequest, ListCustomFieldsResponse, CustomField> context,
        ApiFuture<ListCustomFieldsResponse> futureResponse) {
      ApiFuture<ListCustomFieldsPage> futurePage =
          ListCustomFieldsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCustomFieldsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCustomFieldsPagedResponse(ListCustomFieldsPage page) {
      super(page, ListCustomFieldsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCustomFieldsPage
      extends AbstractPage<
          ListCustomFieldsRequest, ListCustomFieldsResponse, CustomField, ListCustomFieldsPage> {

    private ListCustomFieldsPage(
        PageContext<ListCustomFieldsRequest, ListCustomFieldsResponse, CustomField> context,
        ListCustomFieldsResponse response) {
      super(context, response);
    }

    private static ListCustomFieldsPage createEmptyPage() {
      return new ListCustomFieldsPage(null, null);
    }

    @Override
    protected ListCustomFieldsPage createPage(
        PageContext<ListCustomFieldsRequest, ListCustomFieldsResponse, CustomField> context,
        ListCustomFieldsResponse response) {
      return new ListCustomFieldsPage(context, response);
    }

    @Override
    public ApiFuture<ListCustomFieldsPage> createPageAsync(
        PageContext<ListCustomFieldsRequest, ListCustomFieldsResponse, CustomField> context,
        ApiFuture<ListCustomFieldsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCustomFieldsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCustomFieldsRequest,
          ListCustomFieldsResponse,
          CustomField,
          ListCustomFieldsPage,
          ListCustomFieldsFixedSizeCollection> {

    private ListCustomFieldsFixedSizeCollection(
        List<ListCustomFieldsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCustomFieldsFixedSizeCollection createEmptyCollection() {
      return new ListCustomFieldsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCustomFieldsFixedSizeCollection createCollection(
        List<ListCustomFieldsPage> pages, int collectionSize) {
      return new ListCustomFieldsFixedSizeCollection(pages, collectionSize);
    }
  }
}
