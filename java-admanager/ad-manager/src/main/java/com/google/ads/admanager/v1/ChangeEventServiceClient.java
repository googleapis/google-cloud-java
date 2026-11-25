/*
 * Copyright 2026 Google LLC
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

import com.google.ads.admanager.v1.stub.ChangeEventServiceStub;
import com.google.ads.admanager.v1.stub.ChangeEventServiceStubSettings;
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `ChangeEvent` objects.
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
 * try (ChangeEventServiceClient changeEventServiceClient = ChangeEventServiceClient.create()) {
 *   ChangeEventName name = ChangeEventName.of("[NETWORK_CODE]", "[CHANGE_EVENT]");
 *   ChangeEvent response = changeEventServiceClient.getChangeEvent(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ChangeEventServiceClient object to clean up resources
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
 *      <td><p> GetChangeEvent</td>
 *      <td><p> Retrieves a `ChangeEvent` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getChangeEvent(GetChangeEventRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getChangeEvent(ChangeEventName name)
 *           <li><p> getChangeEvent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getChangeEventCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListChangeEvents</td>
 *      <td><p> Lists `ChangeEvent` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listChangeEvents(ListChangeEventsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listChangeEvents(NetworkName parent)
 *           <li><p> listChangeEvents(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listChangeEventsPagedCallable()
 *           <li><p> listChangeEventsCallable()
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
 * <p>This class can be customized by passing in a custom instance of ChangeEventServiceSettings to
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
 * ChangeEventServiceSettings changeEventServiceSettings =
 *     ChangeEventServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ChangeEventServiceClient changeEventServiceClient =
 *     ChangeEventServiceClient.create(changeEventServiceSettings);
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
 * ChangeEventServiceSettings changeEventServiceSettings =
 *     ChangeEventServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ChangeEventServiceClient changeEventServiceClient =
 *     ChangeEventServiceClient.create(changeEventServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ChangeEventServiceClient implements BackgroundResource {
  private final @Nullable ChangeEventServiceSettings settings;
  private final ChangeEventServiceStub stub;

  /** Constructs an instance of ChangeEventServiceClient with default settings. */
  public static final ChangeEventServiceClient create() throws IOException {
    return create(ChangeEventServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ChangeEventServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ChangeEventServiceClient create(ChangeEventServiceSettings settings)
      throws IOException {
    return new ChangeEventServiceClient(settings);
  }

  /**
   * Constructs an instance of ChangeEventServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ChangeEventServiceSettings).
   */
  public static final ChangeEventServiceClient create(ChangeEventServiceStub stub) {
    return new ChangeEventServiceClient(stub);
  }

  /**
   * Constructs an instance of ChangeEventServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ChangeEventServiceClient(ChangeEventServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ChangeEventServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ChangeEventServiceClient(ChangeEventServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable ChangeEventServiceSettings getSettings() {
    return settings;
  }

  public ChangeEventServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `ChangeEvent` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangeEventServiceClient changeEventServiceClient = ChangeEventServiceClient.create()) {
   *   ChangeEventName name = ChangeEventName.of("[NETWORK_CODE]", "[CHANGE_EVENT]");
   *   ChangeEvent response = changeEventServiceClient.getChangeEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ChangeEvent. Format:
   *     `networks/{network_code}/changeEvents/{change_event_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChangeEvent getChangeEvent(@Nullable ChangeEventName name) {
    GetChangeEventRequest request =
        GetChangeEventRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getChangeEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `ChangeEvent` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangeEventServiceClient changeEventServiceClient = ChangeEventServiceClient.create()) {
   *   String name = ChangeEventName.of("[NETWORK_CODE]", "[CHANGE_EVENT]").toString();
   *   ChangeEvent response = changeEventServiceClient.getChangeEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ChangeEvent. Format:
   *     `networks/{network_code}/changeEvents/{change_event_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChangeEvent getChangeEvent(String name) {
    GetChangeEventRequest request = GetChangeEventRequest.newBuilder().setName(name).build();
    return getChangeEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `ChangeEvent` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangeEventServiceClient changeEventServiceClient = ChangeEventServiceClient.create()) {
   *   GetChangeEventRequest request =
   *       GetChangeEventRequest.newBuilder()
   *           .setName(ChangeEventName.of("[NETWORK_CODE]", "[CHANGE_EVENT]").toString())
   *           .build();
   *   ChangeEvent response = changeEventServiceClient.getChangeEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChangeEvent getChangeEvent(GetChangeEventRequest request) {
    return getChangeEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `ChangeEvent` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangeEventServiceClient changeEventServiceClient = ChangeEventServiceClient.create()) {
   *   GetChangeEventRequest request =
   *       GetChangeEventRequest.newBuilder()
   *           .setName(ChangeEventName.of("[NETWORK_CODE]", "[CHANGE_EVENT]").toString())
   *           .build();
   *   ApiFuture<ChangeEvent> future =
   *       changeEventServiceClient.getChangeEventCallable().futureCall(request);
   *   // Do something.
   *   ChangeEvent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetChangeEventRequest, ChangeEvent> getChangeEventCallable() {
    return stub.getChangeEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ChangeEvent` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangeEventServiceClient changeEventServiceClient = ChangeEventServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (ChangeEvent element : changeEventServiceClient.listChangeEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ChangeEvents. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChangeEventsPagedResponse listChangeEvents(@Nullable NetworkName parent) {
    ListChangeEventsRequest request =
        ListChangeEventsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listChangeEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ChangeEvent` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangeEventServiceClient changeEventServiceClient = ChangeEventServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (ChangeEvent element : changeEventServiceClient.listChangeEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ChangeEvents. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChangeEventsPagedResponse listChangeEvents(String parent) {
    ListChangeEventsRequest request =
        ListChangeEventsRequest.newBuilder().setParent(parent).build();
    return listChangeEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ChangeEvent` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangeEventServiceClient changeEventServiceClient = ChangeEventServiceClient.create()) {
   *   ListChangeEventsRequest request =
   *       ListChangeEventsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (ChangeEvent element : changeEventServiceClient.listChangeEvents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChangeEventsPagedResponse listChangeEvents(ListChangeEventsRequest request) {
    return listChangeEventsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ChangeEvent` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangeEventServiceClient changeEventServiceClient = ChangeEventServiceClient.create()) {
   *   ListChangeEventsRequest request =
   *       ListChangeEventsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<ChangeEvent> future =
   *       changeEventServiceClient.listChangeEventsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ChangeEvent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListChangeEventsRequest, ListChangeEventsPagedResponse>
      listChangeEventsPagedCallable() {
    return stub.listChangeEventsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ChangeEvent` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangeEventServiceClient changeEventServiceClient = ChangeEventServiceClient.create()) {
   *   ListChangeEventsRequest request =
   *       ListChangeEventsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListChangeEventsResponse response =
   *         changeEventServiceClient.listChangeEventsCallable().call(request);
   *     for (ChangeEvent element : response.getChangeEventsList()) {
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
  public final UnaryCallable<ListChangeEventsRequest, ListChangeEventsResponse>
      listChangeEventsCallable() {
    return stub.listChangeEventsCallable();
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

  public static class ListChangeEventsPagedResponse
      extends AbstractPagedListResponse<
          ListChangeEventsRequest,
          ListChangeEventsResponse,
          ChangeEvent,
          ListChangeEventsPage,
          ListChangeEventsFixedSizeCollection> {

    public static ApiFuture<ListChangeEventsPagedResponse> createAsync(
        PageContext<ListChangeEventsRequest, ListChangeEventsResponse, ChangeEvent> context,
        ApiFuture<ListChangeEventsResponse> futureResponse) {
      ApiFuture<ListChangeEventsPage> futurePage =
          ListChangeEventsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListChangeEventsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListChangeEventsPagedResponse(ListChangeEventsPage page) {
      super(page, ListChangeEventsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListChangeEventsPage
      extends AbstractPage<
          ListChangeEventsRequest, ListChangeEventsResponse, ChangeEvent, ListChangeEventsPage> {

    private ListChangeEventsPage(
        @Nullable PageContext<ListChangeEventsRequest, ListChangeEventsResponse, ChangeEvent>
            context,
        @Nullable ListChangeEventsResponse response) {
      super(context, response);
    }

    private static ListChangeEventsPage createEmptyPage() {
      return new ListChangeEventsPage(null, null);
    }

    @Override
    protected ListChangeEventsPage createPage(
        @Nullable PageContext<ListChangeEventsRequest, ListChangeEventsResponse, ChangeEvent>
            context,
        @Nullable ListChangeEventsResponse response) {
      return new ListChangeEventsPage(context, response);
    }

    @Override
    public ApiFuture<ListChangeEventsPage> createPageAsync(
        @Nullable PageContext<ListChangeEventsRequest, ListChangeEventsResponse, ChangeEvent>
            context,
        ApiFuture<ListChangeEventsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListChangeEventsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListChangeEventsRequest,
          ListChangeEventsResponse,
          ChangeEvent,
          ListChangeEventsPage,
          ListChangeEventsFixedSizeCollection> {

    private ListChangeEventsFixedSizeCollection(
        @Nullable List<ListChangeEventsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListChangeEventsFixedSizeCollection createEmptyCollection() {
      return new ListChangeEventsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListChangeEventsFixedSizeCollection createCollection(
        @Nullable List<ListChangeEventsPage> pages, int collectionSize) {
      return new ListChangeEventsFixedSizeCollection(pages, collectionSize);
    }
  }
}
