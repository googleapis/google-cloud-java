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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.DeviceCategoryServiceStub;
import com.google.ads.admanager.v1.stub.DeviceCategoryServiceStubSettings;
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
 * Service Description: Provides methods for handling `DeviceCategory` objects.
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
 * try (DeviceCategoryServiceClient deviceCategoryServiceClient =
 *     DeviceCategoryServiceClient.create()) {
 *   DeviceCategoryName name = DeviceCategoryName.of("[NETWORK_CODE]", "[DEVICE_CATEGORY]");
 *   DeviceCategory response = deviceCategoryServiceClient.getDeviceCategory(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DeviceCategoryServiceClient object to clean up
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
 *      <td><p> GetDeviceCategory</td>
 *      <td><p> API to retrieve a `DeviceCategory` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDeviceCategory(GetDeviceCategoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDeviceCategory(DeviceCategoryName name)
 *           <li><p> getDeviceCategory(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDeviceCategoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDeviceCategories</td>
 *      <td><p> API to retrieve a list of `DeviceCategory` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDeviceCategories(ListDeviceCategoriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDeviceCategories(NetworkName parent)
 *           <li><p> listDeviceCategories(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDeviceCategoriesPagedCallable()
 *           <li><p> listDeviceCategoriesCallable()
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
 * <p>This class can be customized by passing in a custom instance of DeviceCategoryServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeviceCategoryServiceSettings deviceCategoryServiceSettings =
 *     DeviceCategoryServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DeviceCategoryServiceClient deviceCategoryServiceClient =
 *     DeviceCategoryServiceClient.create(deviceCategoryServiceSettings);
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
 * DeviceCategoryServiceSettings deviceCategoryServiceSettings =
 *     DeviceCategoryServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DeviceCategoryServiceClient deviceCategoryServiceClient =
 *     DeviceCategoryServiceClient.create(deviceCategoryServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DeviceCategoryServiceClient implements BackgroundResource {
  private final DeviceCategoryServiceSettings settings;
  private final DeviceCategoryServiceStub stub;

  /** Constructs an instance of DeviceCategoryServiceClient with default settings. */
  public static final DeviceCategoryServiceClient create() throws IOException {
    return create(DeviceCategoryServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DeviceCategoryServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DeviceCategoryServiceClient create(DeviceCategoryServiceSettings settings)
      throws IOException {
    return new DeviceCategoryServiceClient(settings);
  }

  /**
   * Constructs an instance of DeviceCategoryServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(DeviceCategoryServiceSettings).
   */
  public static final DeviceCategoryServiceClient create(DeviceCategoryServiceStub stub) {
    return new DeviceCategoryServiceClient(stub);
  }

  /**
   * Constructs an instance of DeviceCategoryServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DeviceCategoryServiceClient(DeviceCategoryServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DeviceCategoryServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DeviceCategoryServiceClient(DeviceCategoryServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DeviceCategoryServiceSettings getSettings() {
    return settings;
  }

  public DeviceCategoryServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `DeviceCategory` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCategoryServiceClient deviceCategoryServiceClient =
   *     DeviceCategoryServiceClient.create()) {
   *   DeviceCategoryName name = DeviceCategoryName.of("[NETWORK_CODE]", "[DEVICE_CATEGORY]");
   *   DeviceCategory response = deviceCategoryServiceClient.getDeviceCategory(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DeviceCategory. Format:
   *     `networks/{network_code}/deviceCategories/{device_category_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceCategory getDeviceCategory(DeviceCategoryName name) {
    GetDeviceCategoryRequest request =
        GetDeviceCategoryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDeviceCategory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `DeviceCategory` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCategoryServiceClient deviceCategoryServiceClient =
   *     DeviceCategoryServiceClient.create()) {
   *   String name = DeviceCategoryName.of("[NETWORK_CODE]", "[DEVICE_CATEGORY]").toString();
   *   DeviceCategory response = deviceCategoryServiceClient.getDeviceCategory(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DeviceCategory. Format:
   *     `networks/{network_code}/deviceCategories/{device_category_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceCategory getDeviceCategory(String name) {
    GetDeviceCategoryRequest request = GetDeviceCategoryRequest.newBuilder().setName(name).build();
    return getDeviceCategory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `DeviceCategory` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCategoryServiceClient deviceCategoryServiceClient =
   *     DeviceCategoryServiceClient.create()) {
   *   GetDeviceCategoryRequest request =
   *       GetDeviceCategoryRequest.newBuilder()
   *           .setName(DeviceCategoryName.of("[NETWORK_CODE]", "[DEVICE_CATEGORY]").toString())
   *           .build();
   *   DeviceCategory response = deviceCategoryServiceClient.getDeviceCategory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceCategory getDeviceCategory(GetDeviceCategoryRequest request) {
    return getDeviceCategoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `DeviceCategory` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCategoryServiceClient deviceCategoryServiceClient =
   *     DeviceCategoryServiceClient.create()) {
   *   GetDeviceCategoryRequest request =
   *       GetDeviceCategoryRequest.newBuilder()
   *           .setName(DeviceCategoryName.of("[NETWORK_CODE]", "[DEVICE_CATEGORY]").toString())
   *           .build();
   *   ApiFuture<DeviceCategory> future =
   *       deviceCategoryServiceClient.getDeviceCategoryCallable().futureCall(request);
   *   // Do something.
   *   DeviceCategory response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDeviceCategoryRequest, DeviceCategory> getDeviceCategoryCallable() {
    return stub.getDeviceCategoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `DeviceCategory` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCategoryServiceClient deviceCategoryServiceClient =
   *     DeviceCategoryServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (DeviceCategory element :
   *       deviceCategoryServiceClient.listDeviceCategories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of DeviceCategories. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceCategoriesPagedResponse listDeviceCategories(NetworkName parent) {
    ListDeviceCategoriesRequest request =
        ListDeviceCategoriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeviceCategories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `DeviceCategory` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCategoryServiceClient deviceCategoryServiceClient =
   *     DeviceCategoryServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (DeviceCategory element :
   *       deviceCategoryServiceClient.listDeviceCategories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of DeviceCategories. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceCategoriesPagedResponse listDeviceCategories(String parent) {
    ListDeviceCategoriesRequest request =
        ListDeviceCategoriesRequest.newBuilder().setParent(parent).build();
    return listDeviceCategories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `DeviceCategory` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCategoryServiceClient deviceCategoryServiceClient =
   *     DeviceCategoryServiceClient.create()) {
   *   ListDeviceCategoriesRequest request =
   *       ListDeviceCategoriesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (DeviceCategory element :
   *       deviceCategoryServiceClient.listDeviceCategories(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceCategoriesPagedResponse listDeviceCategories(
      ListDeviceCategoriesRequest request) {
    return listDeviceCategoriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `DeviceCategory` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCategoryServiceClient deviceCategoryServiceClient =
   *     DeviceCategoryServiceClient.create()) {
   *   ListDeviceCategoriesRequest request =
   *       ListDeviceCategoriesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<DeviceCategory> future =
   *       deviceCategoryServiceClient.listDeviceCategoriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DeviceCategory element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDeviceCategoriesRequest, ListDeviceCategoriesPagedResponse>
      listDeviceCategoriesPagedCallable() {
    return stub.listDeviceCategoriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `DeviceCategory` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeviceCategoryServiceClient deviceCategoryServiceClient =
   *     DeviceCategoryServiceClient.create()) {
   *   ListDeviceCategoriesRequest request =
   *       ListDeviceCategoriesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListDeviceCategoriesResponse response =
   *         deviceCategoryServiceClient.listDeviceCategoriesCallable().call(request);
   *     for (DeviceCategory element : response.getDeviceCategoriesList()) {
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
  public final UnaryCallable<ListDeviceCategoriesRequest, ListDeviceCategoriesResponse>
      listDeviceCategoriesCallable() {
    return stub.listDeviceCategoriesCallable();
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

  public static class ListDeviceCategoriesPagedResponse
      extends AbstractPagedListResponse<
          ListDeviceCategoriesRequest,
          ListDeviceCategoriesResponse,
          DeviceCategory,
          ListDeviceCategoriesPage,
          ListDeviceCategoriesFixedSizeCollection> {

    public static ApiFuture<ListDeviceCategoriesPagedResponse> createAsync(
        PageContext<ListDeviceCategoriesRequest, ListDeviceCategoriesResponse, DeviceCategory>
            context,
        ApiFuture<ListDeviceCategoriesResponse> futureResponse) {
      ApiFuture<ListDeviceCategoriesPage> futurePage =
          ListDeviceCategoriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDeviceCategoriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDeviceCategoriesPagedResponse(ListDeviceCategoriesPage page) {
      super(page, ListDeviceCategoriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeviceCategoriesPage
      extends AbstractPage<
          ListDeviceCategoriesRequest,
          ListDeviceCategoriesResponse,
          DeviceCategory,
          ListDeviceCategoriesPage> {

    private ListDeviceCategoriesPage(
        PageContext<ListDeviceCategoriesRequest, ListDeviceCategoriesResponse, DeviceCategory>
            context,
        ListDeviceCategoriesResponse response) {
      super(context, response);
    }

    private static ListDeviceCategoriesPage createEmptyPage() {
      return new ListDeviceCategoriesPage(null, null);
    }

    @Override
    protected ListDeviceCategoriesPage createPage(
        PageContext<ListDeviceCategoriesRequest, ListDeviceCategoriesResponse, DeviceCategory>
            context,
        ListDeviceCategoriesResponse response) {
      return new ListDeviceCategoriesPage(context, response);
    }

    @Override
    public ApiFuture<ListDeviceCategoriesPage> createPageAsync(
        PageContext<ListDeviceCategoriesRequest, ListDeviceCategoriesResponse, DeviceCategory>
            context,
        ApiFuture<ListDeviceCategoriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeviceCategoriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeviceCategoriesRequest,
          ListDeviceCategoriesResponse,
          DeviceCategory,
          ListDeviceCategoriesPage,
          ListDeviceCategoriesFixedSizeCollection> {

    private ListDeviceCategoriesFixedSizeCollection(
        List<ListDeviceCategoriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeviceCategoriesFixedSizeCollection createEmptyCollection() {
      return new ListDeviceCategoriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeviceCategoriesFixedSizeCollection createCollection(
        List<ListDeviceCategoriesPage> pages, int collectionSize) {
      return new ListDeviceCategoriesFixedSizeCollection(pages, collectionSize);
    }
  }
}
