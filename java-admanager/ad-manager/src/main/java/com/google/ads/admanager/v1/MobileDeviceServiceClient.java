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

import com.google.ads.admanager.v1.stub.MobileDeviceServiceStub;
import com.google.ads.admanager.v1.stub.MobileDeviceServiceStubSettings;
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
 * Service Description: Provides methods for handling `MobileDevice` objects.
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
 * try (MobileDeviceServiceClient mobileDeviceServiceClient = MobileDeviceServiceClient.create()) {
 *   MobileDeviceName name = MobileDeviceName.of("[NETWORK_CODE]", "[MOBILE_DEVICE]");
 *   MobileDevice response = mobileDeviceServiceClient.getMobileDevice(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MobileDeviceServiceClient object to clean up resources
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
 *      <td><p> GetMobileDevice</td>
 *      <td><p> API to retrieve a `MobileDevice` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMobileDevice(GetMobileDeviceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMobileDevice(MobileDeviceName name)
 *           <li><p> getMobileDevice(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMobileDeviceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMobileDevices</td>
 *      <td><p> API to retrieve a list of `MobileDevice` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMobileDevices(ListMobileDevicesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMobileDevices(NetworkName parent)
 *           <li><p> listMobileDevices(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMobileDevicesPagedCallable()
 *           <li><p> listMobileDevicesCallable()
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
 * <p>This class can be customized by passing in a custom instance of MobileDeviceServiceSettings to
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
 * MobileDeviceServiceSettings mobileDeviceServiceSettings =
 *     MobileDeviceServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MobileDeviceServiceClient mobileDeviceServiceClient =
 *     MobileDeviceServiceClient.create(mobileDeviceServiceSettings);
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
 * MobileDeviceServiceSettings mobileDeviceServiceSettings =
 *     MobileDeviceServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MobileDeviceServiceClient mobileDeviceServiceClient =
 *     MobileDeviceServiceClient.create(mobileDeviceServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class MobileDeviceServiceClient implements BackgroundResource {
  private final MobileDeviceServiceSettings settings;
  private final MobileDeviceServiceStub stub;

  /** Constructs an instance of MobileDeviceServiceClient with default settings. */
  public static final MobileDeviceServiceClient create() throws IOException {
    return create(MobileDeviceServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MobileDeviceServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MobileDeviceServiceClient create(MobileDeviceServiceSettings settings)
      throws IOException {
    return new MobileDeviceServiceClient(settings);
  }

  /**
   * Constructs an instance of MobileDeviceServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(MobileDeviceServiceSettings).
   */
  public static final MobileDeviceServiceClient create(MobileDeviceServiceStub stub) {
    return new MobileDeviceServiceClient(stub);
  }

  /**
   * Constructs an instance of MobileDeviceServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected MobileDeviceServiceClient(MobileDeviceServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MobileDeviceServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected MobileDeviceServiceClient(MobileDeviceServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MobileDeviceServiceSettings getSettings() {
    return settings;
  }

  public MobileDeviceServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `MobileDevice` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceServiceClient mobileDeviceServiceClient = MobileDeviceServiceClient.create()) {
   *   MobileDeviceName name = MobileDeviceName.of("[NETWORK_CODE]", "[MOBILE_DEVICE]");
   *   MobileDevice response = mobileDeviceServiceClient.getMobileDevice(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the MobileDevice. Format:
   *     `networks/{network_code}/mobileDevices/{mobile_device_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MobileDevice getMobileDevice(MobileDeviceName name) {
    GetMobileDeviceRequest request =
        GetMobileDeviceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMobileDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `MobileDevice` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceServiceClient mobileDeviceServiceClient = MobileDeviceServiceClient.create()) {
   *   String name = MobileDeviceName.of("[NETWORK_CODE]", "[MOBILE_DEVICE]").toString();
   *   MobileDevice response = mobileDeviceServiceClient.getMobileDevice(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the MobileDevice. Format:
   *     `networks/{network_code}/mobileDevices/{mobile_device_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MobileDevice getMobileDevice(String name) {
    GetMobileDeviceRequest request = GetMobileDeviceRequest.newBuilder().setName(name).build();
    return getMobileDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `MobileDevice` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceServiceClient mobileDeviceServiceClient = MobileDeviceServiceClient.create()) {
   *   GetMobileDeviceRequest request =
   *       GetMobileDeviceRequest.newBuilder()
   *           .setName(MobileDeviceName.of("[NETWORK_CODE]", "[MOBILE_DEVICE]").toString())
   *           .build();
   *   MobileDevice response = mobileDeviceServiceClient.getMobileDevice(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MobileDevice getMobileDevice(GetMobileDeviceRequest request) {
    return getMobileDeviceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `MobileDevice` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceServiceClient mobileDeviceServiceClient = MobileDeviceServiceClient.create()) {
   *   GetMobileDeviceRequest request =
   *       GetMobileDeviceRequest.newBuilder()
   *           .setName(MobileDeviceName.of("[NETWORK_CODE]", "[MOBILE_DEVICE]").toString())
   *           .build();
   *   ApiFuture<MobileDevice> future =
   *       mobileDeviceServiceClient.getMobileDeviceCallable().futureCall(request);
   *   // Do something.
   *   MobileDevice response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMobileDeviceRequest, MobileDevice> getMobileDeviceCallable() {
    return stub.getMobileDeviceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `MobileDevice` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceServiceClient mobileDeviceServiceClient = MobileDeviceServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (MobileDevice element :
   *       mobileDeviceServiceClient.listMobileDevices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of MobileDevices. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMobileDevicesPagedResponse listMobileDevices(NetworkName parent) {
    ListMobileDevicesRequest request =
        ListMobileDevicesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMobileDevices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `MobileDevice` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceServiceClient mobileDeviceServiceClient = MobileDeviceServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (MobileDevice element :
   *       mobileDeviceServiceClient.listMobileDevices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of MobileDevices. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMobileDevicesPagedResponse listMobileDevices(String parent) {
    ListMobileDevicesRequest request =
        ListMobileDevicesRequest.newBuilder().setParent(parent).build();
    return listMobileDevices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `MobileDevice` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceServiceClient mobileDeviceServiceClient = MobileDeviceServiceClient.create()) {
   *   ListMobileDevicesRequest request =
   *       ListMobileDevicesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (MobileDevice element :
   *       mobileDeviceServiceClient.listMobileDevices(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMobileDevicesPagedResponse listMobileDevices(ListMobileDevicesRequest request) {
    return listMobileDevicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `MobileDevice` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceServiceClient mobileDeviceServiceClient = MobileDeviceServiceClient.create()) {
   *   ListMobileDevicesRequest request =
   *       ListMobileDevicesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<MobileDevice> future =
   *       mobileDeviceServiceClient.listMobileDevicesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MobileDevice element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMobileDevicesRequest, ListMobileDevicesPagedResponse>
      listMobileDevicesPagedCallable() {
    return stub.listMobileDevicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `MobileDevice` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceServiceClient mobileDeviceServiceClient = MobileDeviceServiceClient.create()) {
   *   ListMobileDevicesRequest request =
   *       ListMobileDevicesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListMobileDevicesResponse response =
   *         mobileDeviceServiceClient.listMobileDevicesCallable().call(request);
   *     for (MobileDevice element : response.getMobileDevicesList()) {
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
  public final UnaryCallable<ListMobileDevicesRequest, ListMobileDevicesResponse>
      listMobileDevicesCallable() {
    return stub.listMobileDevicesCallable();
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

  public static class ListMobileDevicesPagedResponse
      extends AbstractPagedListResponse<
          ListMobileDevicesRequest,
          ListMobileDevicesResponse,
          MobileDevice,
          ListMobileDevicesPage,
          ListMobileDevicesFixedSizeCollection> {

    public static ApiFuture<ListMobileDevicesPagedResponse> createAsync(
        PageContext<ListMobileDevicesRequest, ListMobileDevicesResponse, MobileDevice> context,
        ApiFuture<ListMobileDevicesResponse> futureResponse) {
      ApiFuture<ListMobileDevicesPage> futurePage =
          ListMobileDevicesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMobileDevicesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMobileDevicesPagedResponse(ListMobileDevicesPage page) {
      super(page, ListMobileDevicesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMobileDevicesPage
      extends AbstractPage<
          ListMobileDevicesRequest,
          ListMobileDevicesResponse,
          MobileDevice,
          ListMobileDevicesPage> {

    private ListMobileDevicesPage(
        PageContext<ListMobileDevicesRequest, ListMobileDevicesResponse, MobileDevice> context,
        ListMobileDevicesResponse response) {
      super(context, response);
    }

    private static ListMobileDevicesPage createEmptyPage() {
      return new ListMobileDevicesPage(null, null);
    }

    @Override
    protected ListMobileDevicesPage createPage(
        PageContext<ListMobileDevicesRequest, ListMobileDevicesResponse, MobileDevice> context,
        ListMobileDevicesResponse response) {
      return new ListMobileDevicesPage(context, response);
    }

    @Override
    public ApiFuture<ListMobileDevicesPage> createPageAsync(
        PageContext<ListMobileDevicesRequest, ListMobileDevicesResponse, MobileDevice> context,
        ApiFuture<ListMobileDevicesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMobileDevicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMobileDevicesRequest,
          ListMobileDevicesResponse,
          MobileDevice,
          ListMobileDevicesPage,
          ListMobileDevicesFixedSizeCollection> {

    private ListMobileDevicesFixedSizeCollection(
        List<ListMobileDevicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMobileDevicesFixedSizeCollection createEmptyCollection() {
      return new ListMobileDevicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMobileDevicesFixedSizeCollection createCollection(
        List<ListMobileDevicesPage> pages, int collectionSize) {
      return new ListMobileDevicesFixedSizeCollection(pages, collectionSize);
    }
  }
}
