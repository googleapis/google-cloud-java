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

import com.google.ads.admanager.v1.stub.DeviceManufacturerServiceStub;
import com.google.ads.admanager.v1.stub.DeviceManufacturerServiceStubSettings;
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
 * Service Description: Provides methods for handling `DeviceManufacturer` objects.
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
 * try (DeviceManufacturerServiceClient deviceManufacturerServiceClient =
 *     DeviceManufacturerServiceClient.create()) {
 *   DeviceManufacturerName name =
 *       DeviceManufacturerName.of("[NETWORK_CODE]", "[DEVICE_MANUFACTURER]");
 *   DeviceManufacturer response = deviceManufacturerServiceClient.getDeviceManufacturer(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DeviceManufacturerServiceClient object to clean up
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
 *      <td><p> GetDeviceManufacturer</td>
 *      <td><p> API to retrieve a `DeviceManufacturer` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDeviceManufacturer(GetDeviceManufacturerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDeviceManufacturer(DeviceManufacturerName name)
 *           <li><p> getDeviceManufacturer(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDeviceManufacturerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDeviceManufacturers</td>
 *      <td><p> API to retrieve a list of `DeviceManufacturer` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDeviceManufacturers(ListDeviceManufacturersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDeviceManufacturers(NetworkName parent)
 *           <li><p> listDeviceManufacturers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDeviceManufacturersPagedCallable()
 *           <li><p> listDeviceManufacturersCallable()
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
 * DeviceManufacturerServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeviceManufacturerServiceSettings deviceManufacturerServiceSettings =
 *     DeviceManufacturerServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DeviceManufacturerServiceClient deviceManufacturerServiceClient =
 *     DeviceManufacturerServiceClient.create(deviceManufacturerServiceSettings);
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
 * DeviceManufacturerServiceSettings deviceManufacturerServiceSettings =
 *     DeviceManufacturerServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DeviceManufacturerServiceClient deviceManufacturerServiceClient =
 *     DeviceManufacturerServiceClient.create(deviceManufacturerServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DeviceManufacturerServiceClient implements BackgroundResource {
  private final DeviceManufacturerServiceSettings settings;
  private final DeviceManufacturerServiceStub stub;

  /** Constructs an instance of DeviceManufacturerServiceClient with default settings. */
  public static final DeviceManufacturerServiceClient create() throws IOException {
    return create(DeviceManufacturerServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DeviceManufacturerServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final DeviceManufacturerServiceClient create(
      DeviceManufacturerServiceSettings settings) throws IOException {
    return new DeviceManufacturerServiceClient(settings);
  }

  /**
   * Constructs an instance of DeviceManufacturerServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(DeviceManufacturerServiceSettings).
   */
  public static final DeviceManufacturerServiceClient create(DeviceManufacturerServiceStub stub) {
    return new DeviceManufacturerServiceClient(stub);
  }

  /**
   * Constructs an instance of DeviceManufacturerServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DeviceManufacturerServiceClient(DeviceManufacturerServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((DeviceManufacturerServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DeviceManufacturerServiceClient(DeviceManufacturerServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DeviceManufacturerServiceSettings getSettings() {
    return settings;
  }

  public DeviceManufacturerServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `DeviceManufacturer` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceManufacturerServiceClient deviceManufacturerServiceClient =
   *     DeviceManufacturerServiceClient.create()) {
   *   DeviceManufacturerName name =
   *       DeviceManufacturerName.of("[NETWORK_CODE]", "[DEVICE_MANUFACTURER]");
   *   DeviceManufacturer response = deviceManufacturerServiceClient.getDeviceManufacturer(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DeviceManufacturer. Format:
   *     `networks/{network_code}/deviceManufacturers/{device_manufacturer_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceManufacturer getDeviceManufacturer(DeviceManufacturerName name) {
    GetDeviceManufacturerRequest request =
        GetDeviceManufacturerRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDeviceManufacturer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `DeviceManufacturer` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceManufacturerServiceClient deviceManufacturerServiceClient =
   *     DeviceManufacturerServiceClient.create()) {
   *   String name = DeviceManufacturerName.of("[NETWORK_CODE]", "[DEVICE_MANUFACTURER]").toString();
   *   DeviceManufacturer response = deviceManufacturerServiceClient.getDeviceManufacturer(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DeviceManufacturer. Format:
   *     `networks/{network_code}/deviceManufacturers/{device_manufacturer_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceManufacturer getDeviceManufacturer(String name) {
    GetDeviceManufacturerRequest request =
        GetDeviceManufacturerRequest.newBuilder().setName(name).build();
    return getDeviceManufacturer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `DeviceManufacturer` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceManufacturerServiceClient deviceManufacturerServiceClient =
   *     DeviceManufacturerServiceClient.create()) {
   *   GetDeviceManufacturerRequest request =
   *       GetDeviceManufacturerRequest.newBuilder()
   *           .setName(
   *               DeviceManufacturerName.of("[NETWORK_CODE]", "[DEVICE_MANUFACTURER]").toString())
   *           .build();
   *   DeviceManufacturer response = deviceManufacturerServiceClient.getDeviceManufacturer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceManufacturer getDeviceManufacturer(GetDeviceManufacturerRequest request) {
    return getDeviceManufacturerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `DeviceManufacturer` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceManufacturerServiceClient deviceManufacturerServiceClient =
   *     DeviceManufacturerServiceClient.create()) {
   *   GetDeviceManufacturerRequest request =
   *       GetDeviceManufacturerRequest.newBuilder()
   *           .setName(
   *               DeviceManufacturerName.of("[NETWORK_CODE]", "[DEVICE_MANUFACTURER]").toString())
   *           .build();
   *   ApiFuture<DeviceManufacturer> future =
   *       deviceManufacturerServiceClient.getDeviceManufacturerCallable().futureCall(request);
   *   // Do something.
   *   DeviceManufacturer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDeviceManufacturerRequest, DeviceManufacturer>
      getDeviceManufacturerCallable() {
    return stub.getDeviceManufacturerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `DeviceManufacturer` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceManufacturerServiceClient deviceManufacturerServiceClient =
   *     DeviceManufacturerServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (DeviceManufacturer element :
   *       deviceManufacturerServiceClient.listDeviceManufacturers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of DeviceManufacturers. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceManufacturersPagedResponse listDeviceManufacturers(NetworkName parent) {
    ListDeviceManufacturersRequest request =
        ListDeviceManufacturersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeviceManufacturers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `DeviceManufacturer` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceManufacturerServiceClient deviceManufacturerServiceClient =
   *     DeviceManufacturerServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (DeviceManufacturer element :
   *       deviceManufacturerServiceClient.listDeviceManufacturers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of DeviceManufacturers. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceManufacturersPagedResponse listDeviceManufacturers(String parent) {
    ListDeviceManufacturersRequest request =
        ListDeviceManufacturersRequest.newBuilder().setParent(parent).build();
    return listDeviceManufacturers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `DeviceManufacturer` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceManufacturerServiceClient deviceManufacturerServiceClient =
   *     DeviceManufacturerServiceClient.create()) {
   *   ListDeviceManufacturersRequest request =
   *       ListDeviceManufacturersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (DeviceManufacturer element :
   *       deviceManufacturerServiceClient.listDeviceManufacturers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceManufacturersPagedResponse listDeviceManufacturers(
      ListDeviceManufacturersRequest request) {
    return listDeviceManufacturersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `DeviceManufacturer` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceManufacturerServiceClient deviceManufacturerServiceClient =
   *     DeviceManufacturerServiceClient.create()) {
   *   ListDeviceManufacturersRequest request =
   *       ListDeviceManufacturersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<DeviceManufacturer> future =
   *       deviceManufacturerServiceClient
   *           .listDeviceManufacturersPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (DeviceManufacturer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDeviceManufacturersRequest, ListDeviceManufacturersPagedResponse>
      listDeviceManufacturersPagedCallable() {
    return stub.listDeviceManufacturersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `DeviceManufacturer` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceManufacturerServiceClient deviceManufacturerServiceClient =
   *     DeviceManufacturerServiceClient.create()) {
   *   ListDeviceManufacturersRequest request =
   *       ListDeviceManufacturersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListDeviceManufacturersResponse response =
   *         deviceManufacturerServiceClient.listDeviceManufacturersCallable().call(request);
   *     for (DeviceManufacturer element : response.getDeviceManufacturersList()) {
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
  public final UnaryCallable<ListDeviceManufacturersRequest, ListDeviceManufacturersResponse>
      listDeviceManufacturersCallable() {
    return stub.listDeviceManufacturersCallable();
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

  public static class ListDeviceManufacturersPagedResponse
      extends AbstractPagedListResponse<
          ListDeviceManufacturersRequest,
          ListDeviceManufacturersResponse,
          DeviceManufacturer,
          ListDeviceManufacturersPage,
          ListDeviceManufacturersFixedSizeCollection> {

    public static ApiFuture<ListDeviceManufacturersPagedResponse> createAsync(
        PageContext<
                ListDeviceManufacturersRequest, ListDeviceManufacturersResponse, DeviceManufacturer>
            context,
        ApiFuture<ListDeviceManufacturersResponse> futureResponse) {
      ApiFuture<ListDeviceManufacturersPage> futurePage =
          ListDeviceManufacturersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDeviceManufacturersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDeviceManufacturersPagedResponse(ListDeviceManufacturersPage page) {
      super(page, ListDeviceManufacturersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeviceManufacturersPage
      extends AbstractPage<
          ListDeviceManufacturersRequest,
          ListDeviceManufacturersResponse,
          DeviceManufacturer,
          ListDeviceManufacturersPage> {

    private ListDeviceManufacturersPage(
        PageContext<
                ListDeviceManufacturersRequest, ListDeviceManufacturersResponse, DeviceManufacturer>
            context,
        ListDeviceManufacturersResponse response) {
      super(context, response);
    }

    private static ListDeviceManufacturersPage createEmptyPage() {
      return new ListDeviceManufacturersPage(null, null);
    }

    @Override
    protected ListDeviceManufacturersPage createPage(
        PageContext<
                ListDeviceManufacturersRequest, ListDeviceManufacturersResponse, DeviceManufacturer>
            context,
        ListDeviceManufacturersResponse response) {
      return new ListDeviceManufacturersPage(context, response);
    }

    @Override
    public ApiFuture<ListDeviceManufacturersPage> createPageAsync(
        PageContext<
                ListDeviceManufacturersRequest, ListDeviceManufacturersResponse, DeviceManufacturer>
            context,
        ApiFuture<ListDeviceManufacturersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeviceManufacturersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeviceManufacturersRequest,
          ListDeviceManufacturersResponse,
          DeviceManufacturer,
          ListDeviceManufacturersPage,
          ListDeviceManufacturersFixedSizeCollection> {

    private ListDeviceManufacturersFixedSizeCollection(
        List<ListDeviceManufacturersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeviceManufacturersFixedSizeCollection createEmptyCollection() {
      return new ListDeviceManufacturersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeviceManufacturersFixedSizeCollection createCollection(
        List<ListDeviceManufacturersPage> pages, int collectionSize) {
      return new ListDeviceManufacturersFixedSizeCollection(pages, collectionSize);
    }
  }
}
