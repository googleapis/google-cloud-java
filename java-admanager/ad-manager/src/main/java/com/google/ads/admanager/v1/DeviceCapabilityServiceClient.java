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

import com.google.ads.admanager.v1.stub.DeviceCapabilityServiceStub;
import com.google.ads.admanager.v1.stub.DeviceCapabilityServiceStubSettings;
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
 * Service Description: Provides methods for handling `DeviceCapability` objects.
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
 * try (DeviceCapabilityServiceClient deviceCapabilityServiceClient =
 *     DeviceCapabilityServiceClient.create()) {
 *   DeviceCapabilityName name = DeviceCapabilityName.of("[NETWORK_CODE]", "[DEVICE_CAPABILITY]");
 *   DeviceCapability response = deviceCapabilityServiceClient.getDeviceCapability(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DeviceCapabilityServiceClient object to clean up
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
 *      <td><p> GetDeviceCapability</td>
 *      <td><p> API to retrieve a `DeviceCapability` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDeviceCapability(GetDeviceCapabilityRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDeviceCapability(DeviceCapabilityName name)
 *           <li><p> getDeviceCapability(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDeviceCapabilityCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDeviceCapabilities</td>
 *      <td><p> API to retrieve a list of `DeviceCapability` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDeviceCapabilities(ListDeviceCapabilitiesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDeviceCapabilities(NetworkName parent)
 *           <li><p> listDeviceCapabilities(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDeviceCapabilitiesPagedCallable()
 *           <li><p> listDeviceCapabilitiesCallable()
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
 * DeviceCapabilityServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeviceCapabilityServiceSettings deviceCapabilityServiceSettings =
 *     DeviceCapabilityServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DeviceCapabilityServiceClient deviceCapabilityServiceClient =
 *     DeviceCapabilityServiceClient.create(deviceCapabilityServiceSettings);
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
 * DeviceCapabilityServiceSettings deviceCapabilityServiceSettings =
 *     DeviceCapabilityServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DeviceCapabilityServiceClient deviceCapabilityServiceClient =
 *     DeviceCapabilityServiceClient.create(deviceCapabilityServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DeviceCapabilityServiceClient implements BackgroundResource {
  private final DeviceCapabilityServiceSettings settings;
  private final DeviceCapabilityServiceStub stub;

  /** Constructs an instance of DeviceCapabilityServiceClient with default settings. */
  public static final DeviceCapabilityServiceClient create() throws IOException {
    return create(DeviceCapabilityServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DeviceCapabilityServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DeviceCapabilityServiceClient create(DeviceCapabilityServiceSettings settings)
      throws IOException {
    return new DeviceCapabilityServiceClient(settings);
  }

  /**
   * Constructs an instance of DeviceCapabilityServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(DeviceCapabilityServiceSettings).
   */
  public static final DeviceCapabilityServiceClient create(DeviceCapabilityServiceStub stub) {
    return new DeviceCapabilityServiceClient(stub);
  }

  /**
   * Constructs an instance of DeviceCapabilityServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DeviceCapabilityServiceClient(DeviceCapabilityServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((DeviceCapabilityServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DeviceCapabilityServiceClient(DeviceCapabilityServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DeviceCapabilityServiceSettings getSettings() {
    return settings;
  }

  public DeviceCapabilityServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `DeviceCapability` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCapabilityServiceClient deviceCapabilityServiceClient =
   *     DeviceCapabilityServiceClient.create()) {
   *   DeviceCapabilityName name = DeviceCapabilityName.of("[NETWORK_CODE]", "[DEVICE_CAPABILITY]");
   *   DeviceCapability response = deviceCapabilityServiceClient.getDeviceCapability(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DeviceCapability. Format:
   *     `networks/{network_code}/deviceCapabilities/{device_capability_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceCapability getDeviceCapability(DeviceCapabilityName name) {
    GetDeviceCapabilityRequest request =
        GetDeviceCapabilityRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDeviceCapability(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `DeviceCapability` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCapabilityServiceClient deviceCapabilityServiceClient =
   *     DeviceCapabilityServiceClient.create()) {
   *   String name = DeviceCapabilityName.of("[NETWORK_CODE]", "[DEVICE_CAPABILITY]").toString();
   *   DeviceCapability response = deviceCapabilityServiceClient.getDeviceCapability(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DeviceCapability. Format:
   *     `networks/{network_code}/deviceCapabilities/{device_capability_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceCapability getDeviceCapability(String name) {
    GetDeviceCapabilityRequest request =
        GetDeviceCapabilityRequest.newBuilder().setName(name).build();
    return getDeviceCapability(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `DeviceCapability` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCapabilityServiceClient deviceCapabilityServiceClient =
   *     DeviceCapabilityServiceClient.create()) {
   *   GetDeviceCapabilityRequest request =
   *       GetDeviceCapabilityRequest.newBuilder()
   *           .setName(DeviceCapabilityName.of("[NETWORK_CODE]", "[DEVICE_CAPABILITY]").toString())
   *           .build();
   *   DeviceCapability response = deviceCapabilityServiceClient.getDeviceCapability(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceCapability getDeviceCapability(GetDeviceCapabilityRequest request) {
    return getDeviceCapabilityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `DeviceCapability` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCapabilityServiceClient deviceCapabilityServiceClient =
   *     DeviceCapabilityServiceClient.create()) {
   *   GetDeviceCapabilityRequest request =
   *       GetDeviceCapabilityRequest.newBuilder()
   *           .setName(DeviceCapabilityName.of("[NETWORK_CODE]", "[DEVICE_CAPABILITY]").toString())
   *           .build();
   *   ApiFuture<DeviceCapability> future =
   *       deviceCapabilityServiceClient.getDeviceCapabilityCallable().futureCall(request);
   *   // Do something.
   *   DeviceCapability response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDeviceCapabilityRequest, DeviceCapability>
      getDeviceCapabilityCallable() {
    return stub.getDeviceCapabilityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `DeviceCapability` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCapabilityServiceClient deviceCapabilityServiceClient =
   *     DeviceCapabilityServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (DeviceCapability element :
   *       deviceCapabilityServiceClient.listDeviceCapabilities(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of DeviceCapabilities. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceCapabilitiesPagedResponse listDeviceCapabilities(NetworkName parent) {
    ListDeviceCapabilitiesRequest request =
        ListDeviceCapabilitiesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeviceCapabilities(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `DeviceCapability` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCapabilityServiceClient deviceCapabilityServiceClient =
   *     DeviceCapabilityServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (DeviceCapability element :
   *       deviceCapabilityServiceClient.listDeviceCapabilities(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of DeviceCapabilities. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceCapabilitiesPagedResponse listDeviceCapabilities(String parent) {
    ListDeviceCapabilitiesRequest request =
        ListDeviceCapabilitiesRequest.newBuilder().setParent(parent).build();
    return listDeviceCapabilities(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `DeviceCapability` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCapabilityServiceClient deviceCapabilityServiceClient =
   *     DeviceCapabilityServiceClient.create()) {
   *   ListDeviceCapabilitiesRequest request =
   *       ListDeviceCapabilitiesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (DeviceCapability element :
   *       deviceCapabilityServiceClient.listDeviceCapabilities(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceCapabilitiesPagedResponse listDeviceCapabilities(
      ListDeviceCapabilitiesRequest request) {
    return listDeviceCapabilitiesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `DeviceCapability` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCapabilityServiceClient deviceCapabilityServiceClient =
   *     DeviceCapabilityServiceClient.create()) {
   *   ListDeviceCapabilitiesRequest request =
   *       ListDeviceCapabilitiesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<DeviceCapability> future =
   *       deviceCapabilityServiceClient.listDeviceCapabilitiesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DeviceCapability element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDeviceCapabilitiesRequest, ListDeviceCapabilitiesPagedResponse>
      listDeviceCapabilitiesPagedCallable() {
    return stub.listDeviceCapabilitiesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `DeviceCapability` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCapabilityServiceClient deviceCapabilityServiceClient =
   *     DeviceCapabilityServiceClient.create()) {
   *   ListDeviceCapabilitiesRequest request =
   *       ListDeviceCapabilitiesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListDeviceCapabilitiesResponse response =
   *         deviceCapabilityServiceClient.listDeviceCapabilitiesCallable().call(request);
   *     for (DeviceCapability element : response.getDeviceCapabilitiesList()) {
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
  public final UnaryCallable<ListDeviceCapabilitiesRequest, ListDeviceCapabilitiesResponse>
      listDeviceCapabilitiesCallable() {
    return stub.listDeviceCapabilitiesCallable();
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

  public static class ListDeviceCapabilitiesPagedResponse
      extends AbstractPagedListResponse<
          ListDeviceCapabilitiesRequest,
          ListDeviceCapabilitiesResponse,
          DeviceCapability,
          ListDeviceCapabilitiesPage,
          ListDeviceCapabilitiesFixedSizeCollection> {

    public static ApiFuture<ListDeviceCapabilitiesPagedResponse> createAsync(
        PageContext<ListDeviceCapabilitiesRequest, ListDeviceCapabilitiesResponse, DeviceCapability>
            context,
        ApiFuture<ListDeviceCapabilitiesResponse> futureResponse) {
      ApiFuture<ListDeviceCapabilitiesPage> futurePage =
          ListDeviceCapabilitiesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDeviceCapabilitiesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDeviceCapabilitiesPagedResponse(ListDeviceCapabilitiesPage page) {
      super(page, ListDeviceCapabilitiesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeviceCapabilitiesPage
      extends AbstractPage<
          ListDeviceCapabilitiesRequest,
          ListDeviceCapabilitiesResponse,
          DeviceCapability,
          ListDeviceCapabilitiesPage> {

    private ListDeviceCapabilitiesPage(
        PageContext<ListDeviceCapabilitiesRequest, ListDeviceCapabilitiesResponse, DeviceCapability>
            context,
        ListDeviceCapabilitiesResponse response) {
      super(context, response);
    }

    private static ListDeviceCapabilitiesPage createEmptyPage() {
      return new ListDeviceCapabilitiesPage(null, null);
    }

    @Override
    protected ListDeviceCapabilitiesPage createPage(
        PageContext<ListDeviceCapabilitiesRequest, ListDeviceCapabilitiesResponse, DeviceCapability>
            context,
        ListDeviceCapabilitiesResponse response) {
      return new ListDeviceCapabilitiesPage(context, response);
    }

    @Override
    public ApiFuture<ListDeviceCapabilitiesPage> createPageAsync(
        PageContext<ListDeviceCapabilitiesRequest, ListDeviceCapabilitiesResponse, DeviceCapability>
            context,
        ApiFuture<ListDeviceCapabilitiesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeviceCapabilitiesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeviceCapabilitiesRequest,
          ListDeviceCapabilitiesResponse,
          DeviceCapability,
          ListDeviceCapabilitiesPage,
          ListDeviceCapabilitiesFixedSizeCollection> {

    private ListDeviceCapabilitiesFixedSizeCollection(
        List<ListDeviceCapabilitiesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeviceCapabilitiesFixedSizeCollection createEmptyCollection() {
      return new ListDeviceCapabilitiesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeviceCapabilitiesFixedSizeCollection createCollection(
        List<ListDeviceCapabilitiesPage> pages, int collectionSize) {
      return new ListDeviceCapabilitiesFixedSizeCollection(pages, collectionSize);
    }
  }
}
