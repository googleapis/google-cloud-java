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

import com.google.ads.admanager.v1.stub.LinkedDeviceServiceStub;
import com.google.ads.admanager.v1.stub.LinkedDeviceServiceStubSettings;
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
 * Service Description: Provides methods for handling `LinkedDevice` objects.
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
 * try (LinkedDeviceServiceClient linkedDeviceServiceClient = LinkedDeviceServiceClient.create()) {
 *   LinkedDeviceName name = LinkedDeviceName.of("[NETWORK_CODE]", "[LINKED_DEVICE]");
 *   LinkedDevice response = linkedDeviceServiceClient.getLinkedDevice(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LinkedDeviceServiceClient object to clean up resources
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
 *      <td><p> GetLinkedDevice</td>
 *      <td><p> Gets a `LinkedDevice`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLinkedDevice(GetLinkedDeviceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLinkedDevice(LinkedDeviceName name)
 *           <li><p> getLinkedDevice(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLinkedDeviceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLinkedDevices</td>
 *      <td><p> Lists `LinkedDevice` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLinkedDevices(ListLinkedDevicesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLinkedDevices(NetworkName parent)
 *           <li><p> listLinkedDevices(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLinkedDevicesPagedCallable()
 *           <li><p> listLinkedDevicesCallable()
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
 * <p>This class can be customized by passing in a custom instance of LinkedDeviceServiceSettings to
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
 * LinkedDeviceServiceSettings linkedDeviceServiceSettings =
 *     LinkedDeviceServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LinkedDeviceServiceClient linkedDeviceServiceClient =
 *     LinkedDeviceServiceClient.create(linkedDeviceServiceSettings);
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
 * LinkedDeviceServiceSettings linkedDeviceServiceSettings =
 *     LinkedDeviceServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LinkedDeviceServiceClient linkedDeviceServiceClient =
 *     LinkedDeviceServiceClient.create(linkedDeviceServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class LinkedDeviceServiceClient implements BackgroundResource {
  private final LinkedDeviceServiceSettings settings;
  private final LinkedDeviceServiceStub stub;

  /** Constructs an instance of LinkedDeviceServiceClient with default settings. */
  public static final LinkedDeviceServiceClient create() throws IOException {
    return create(LinkedDeviceServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LinkedDeviceServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LinkedDeviceServiceClient create(LinkedDeviceServiceSettings settings)
      throws IOException {
    return new LinkedDeviceServiceClient(settings);
  }

  /**
   * Constructs an instance of LinkedDeviceServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(LinkedDeviceServiceSettings).
   */
  public static final LinkedDeviceServiceClient create(LinkedDeviceServiceStub stub) {
    return new LinkedDeviceServiceClient(stub);
  }

  /**
   * Constructs an instance of LinkedDeviceServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected LinkedDeviceServiceClient(LinkedDeviceServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LinkedDeviceServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LinkedDeviceServiceClient(LinkedDeviceServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LinkedDeviceServiceSettings getSettings() {
    return settings;
  }

  public LinkedDeviceServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a `LinkedDevice`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LinkedDeviceServiceClient linkedDeviceServiceClient = LinkedDeviceServiceClient.create()) {
   *   LinkedDeviceName name = LinkedDeviceName.of("[NETWORK_CODE]", "[LINKED_DEVICE]");
   *   LinkedDevice response = linkedDeviceServiceClient.getLinkedDevice(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the LinkedDevice. Format:
   *     `networks/{network_code}/linkedDevices/{linked_device_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LinkedDevice getLinkedDevice(LinkedDeviceName name) {
    GetLinkedDeviceRequest request =
        GetLinkedDeviceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLinkedDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a `LinkedDevice`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LinkedDeviceServiceClient linkedDeviceServiceClient = LinkedDeviceServiceClient.create()) {
   *   String name = LinkedDeviceName.of("[NETWORK_CODE]", "[LINKED_DEVICE]").toString();
   *   LinkedDevice response = linkedDeviceServiceClient.getLinkedDevice(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the LinkedDevice. Format:
   *     `networks/{network_code}/linkedDevices/{linked_device_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LinkedDevice getLinkedDevice(String name) {
    GetLinkedDeviceRequest request = GetLinkedDeviceRequest.newBuilder().setName(name).build();
    return getLinkedDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a `LinkedDevice`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LinkedDeviceServiceClient linkedDeviceServiceClient = LinkedDeviceServiceClient.create()) {
   *   GetLinkedDeviceRequest request =
   *       GetLinkedDeviceRequest.newBuilder()
   *           .setName(LinkedDeviceName.of("[NETWORK_CODE]", "[LINKED_DEVICE]").toString())
   *           .build();
   *   LinkedDevice response = linkedDeviceServiceClient.getLinkedDevice(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LinkedDevice getLinkedDevice(GetLinkedDeviceRequest request) {
    return getLinkedDeviceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a `LinkedDevice`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LinkedDeviceServiceClient linkedDeviceServiceClient = LinkedDeviceServiceClient.create()) {
   *   GetLinkedDeviceRequest request =
   *       GetLinkedDeviceRequest.newBuilder()
   *           .setName(LinkedDeviceName.of("[NETWORK_CODE]", "[LINKED_DEVICE]").toString())
   *           .build();
   *   ApiFuture<LinkedDevice> future =
   *       linkedDeviceServiceClient.getLinkedDeviceCallable().futureCall(request);
   *   // Do something.
   *   LinkedDevice response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLinkedDeviceRequest, LinkedDevice> getLinkedDeviceCallable() {
    return stub.getLinkedDeviceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LinkedDevice` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LinkedDeviceServiceClient linkedDeviceServiceClient = LinkedDeviceServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (LinkedDevice element :
   *       linkedDeviceServiceClient.listLinkedDevices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of LinkedDevices. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLinkedDevicesPagedResponse listLinkedDevices(NetworkName parent) {
    ListLinkedDevicesRequest request =
        ListLinkedDevicesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLinkedDevices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LinkedDevice` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LinkedDeviceServiceClient linkedDeviceServiceClient = LinkedDeviceServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (LinkedDevice element :
   *       linkedDeviceServiceClient.listLinkedDevices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of LinkedDevices. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLinkedDevicesPagedResponse listLinkedDevices(String parent) {
    ListLinkedDevicesRequest request =
        ListLinkedDevicesRequest.newBuilder().setParent(parent).build();
    return listLinkedDevices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LinkedDevice` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LinkedDeviceServiceClient linkedDeviceServiceClient = LinkedDeviceServiceClient.create()) {
   *   ListLinkedDevicesRequest request =
   *       ListLinkedDevicesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (LinkedDevice element :
   *       linkedDeviceServiceClient.listLinkedDevices(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLinkedDevicesPagedResponse listLinkedDevices(ListLinkedDevicesRequest request) {
    return listLinkedDevicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LinkedDevice` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LinkedDeviceServiceClient linkedDeviceServiceClient = LinkedDeviceServiceClient.create()) {
   *   ListLinkedDevicesRequest request =
   *       ListLinkedDevicesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<LinkedDevice> future =
   *       linkedDeviceServiceClient.listLinkedDevicesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LinkedDevice element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLinkedDevicesRequest, ListLinkedDevicesPagedResponse>
      listLinkedDevicesPagedCallable() {
    return stub.listLinkedDevicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LinkedDevice` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LinkedDeviceServiceClient linkedDeviceServiceClient = LinkedDeviceServiceClient.create()) {
   *   ListLinkedDevicesRequest request =
   *       ListLinkedDevicesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListLinkedDevicesResponse response =
   *         linkedDeviceServiceClient.listLinkedDevicesCallable().call(request);
   *     for (LinkedDevice element : response.getLinkedDevicesList()) {
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
  public final UnaryCallable<ListLinkedDevicesRequest, ListLinkedDevicesResponse>
      listLinkedDevicesCallable() {
    return stub.listLinkedDevicesCallable();
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

  public static class ListLinkedDevicesPagedResponse
      extends AbstractPagedListResponse<
          ListLinkedDevicesRequest,
          ListLinkedDevicesResponse,
          LinkedDevice,
          ListLinkedDevicesPage,
          ListLinkedDevicesFixedSizeCollection> {

    public static ApiFuture<ListLinkedDevicesPagedResponse> createAsync(
        PageContext<ListLinkedDevicesRequest, ListLinkedDevicesResponse, LinkedDevice> context,
        ApiFuture<ListLinkedDevicesResponse> futureResponse) {
      ApiFuture<ListLinkedDevicesPage> futurePage =
          ListLinkedDevicesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLinkedDevicesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLinkedDevicesPagedResponse(ListLinkedDevicesPage page) {
      super(page, ListLinkedDevicesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLinkedDevicesPage
      extends AbstractPage<
          ListLinkedDevicesRequest,
          ListLinkedDevicesResponse,
          LinkedDevice,
          ListLinkedDevicesPage> {

    private ListLinkedDevicesPage(
        PageContext<ListLinkedDevicesRequest, ListLinkedDevicesResponse, LinkedDevice> context,
        ListLinkedDevicesResponse response) {
      super(context, response);
    }

    private static ListLinkedDevicesPage createEmptyPage() {
      return new ListLinkedDevicesPage(null, null);
    }

    @Override
    protected ListLinkedDevicesPage createPage(
        PageContext<ListLinkedDevicesRequest, ListLinkedDevicesResponse, LinkedDevice> context,
        ListLinkedDevicesResponse response) {
      return new ListLinkedDevicesPage(context, response);
    }

    @Override
    public ApiFuture<ListLinkedDevicesPage> createPageAsync(
        PageContext<ListLinkedDevicesRequest, ListLinkedDevicesResponse, LinkedDevice> context,
        ApiFuture<ListLinkedDevicesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLinkedDevicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLinkedDevicesRequest,
          ListLinkedDevicesResponse,
          LinkedDevice,
          ListLinkedDevicesPage,
          ListLinkedDevicesFixedSizeCollection> {

    private ListLinkedDevicesFixedSizeCollection(
        List<ListLinkedDevicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLinkedDevicesFixedSizeCollection createEmptyCollection() {
      return new ListLinkedDevicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLinkedDevicesFixedSizeCollection createCollection(
        List<ListLinkedDevicesPage> pages, int collectionSize) {
      return new ListLinkedDevicesFixedSizeCollection(pages, collectionSize);
    }
  }
}
