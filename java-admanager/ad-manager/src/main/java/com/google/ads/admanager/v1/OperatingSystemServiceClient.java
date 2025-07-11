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

import com.google.ads.admanager.v1.stub.OperatingSystemServiceStub;
import com.google.ads.admanager.v1.stub.OperatingSystemServiceStubSettings;
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
 * Service Description: Provides methods for handling `OperatingSystem` objects.
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
 * try (OperatingSystemServiceClient operatingSystemServiceClient =
 *     OperatingSystemServiceClient.create()) {
 *   OperatingSystemName name = OperatingSystemName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM]");
 *   OperatingSystem response = operatingSystemServiceClient.getOperatingSystem(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OperatingSystemServiceClient object to clean up
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
 *      <td><p> GetOperatingSystem</td>
 *      <td><p> API to retrieve a `OperatingSystem` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOperatingSystem(GetOperatingSystemRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOperatingSystem(OperatingSystemName name)
 *           <li><p> getOperatingSystem(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOperatingSystemCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListOperatingSystems</td>
 *      <td><p> API to retrieve a list of `OperatingSystem` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOperatingSystems(ListOperatingSystemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOperatingSystems(NetworkName parent)
 *           <li><p> listOperatingSystems(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOperatingSystemsPagedCallable()
 *           <li><p> listOperatingSystemsCallable()
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
 * <p>This class can be customized by passing in a custom instance of OperatingSystemServiceSettings
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
 * OperatingSystemServiceSettings operatingSystemServiceSettings =
 *     OperatingSystemServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OperatingSystemServiceClient operatingSystemServiceClient =
 *     OperatingSystemServiceClient.create(operatingSystemServiceSettings);
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
 * OperatingSystemServiceSettings operatingSystemServiceSettings =
 *     OperatingSystemServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OperatingSystemServiceClient operatingSystemServiceClient =
 *     OperatingSystemServiceClient.create(operatingSystemServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class OperatingSystemServiceClient implements BackgroundResource {
  private final OperatingSystemServiceSettings settings;
  private final OperatingSystemServiceStub stub;

  /** Constructs an instance of OperatingSystemServiceClient with default settings. */
  public static final OperatingSystemServiceClient create() throws IOException {
    return create(OperatingSystemServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OperatingSystemServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final OperatingSystemServiceClient create(OperatingSystemServiceSettings settings)
      throws IOException {
    return new OperatingSystemServiceClient(settings);
  }

  /**
   * Constructs an instance of OperatingSystemServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(OperatingSystemServiceSettings).
   */
  public static final OperatingSystemServiceClient create(OperatingSystemServiceStub stub) {
    return new OperatingSystemServiceClient(stub);
  }

  /**
   * Constructs an instance of OperatingSystemServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected OperatingSystemServiceClient(OperatingSystemServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((OperatingSystemServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected OperatingSystemServiceClient(OperatingSystemServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final OperatingSystemServiceSettings getSettings() {
    return settings;
  }

  public OperatingSystemServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `OperatingSystem` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemServiceClient operatingSystemServiceClient =
   *     OperatingSystemServiceClient.create()) {
   *   OperatingSystemName name = OperatingSystemName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM]");
   *   OperatingSystem response = operatingSystemServiceClient.getOperatingSystem(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the OperatingSystem. Format:
   *     `networks/{network_code}/operatingSystems/{operating_system_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperatingSystem getOperatingSystem(OperatingSystemName name) {
    GetOperatingSystemRequest request =
        GetOperatingSystemRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getOperatingSystem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `OperatingSystem` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemServiceClient operatingSystemServiceClient =
   *     OperatingSystemServiceClient.create()) {
   *   String name = OperatingSystemName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM]").toString();
   *   OperatingSystem response = operatingSystemServiceClient.getOperatingSystem(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the OperatingSystem. Format:
   *     `networks/{network_code}/operatingSystems/{operating_system_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperatingSystem getOperatingSystem(String name) {
    GetOperatingSystemRequest request =
        GetOperatingSystemRequest.newBuilder().setName(name).build();
    return getOperatingSystem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `OperatingSystem` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemServiceClient operatingSystemServiceClient =
   *     OperatingSystemServiceClient.create()) {
   *   GetOperatingSystemRequest request =
   *       GetOperatingSystemRequest.newBuilder()
   *           .setName(OperatingSystemName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM]").toString())
   *           .build();
   *   OperatingSystem response = operatingSystemServiceClient.getOperatingSystem(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperatingSystem getOperatingSystem(GetOperatingSystemRequest request) {
    return getOperatingSystemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `OperatingSystem` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemServiceClient operatingSystemServiceClient =
   *     OperatingSystemServiceClient.create()) {
   *   GetOperatingSystemRequest request =
   *       GetOperatingSystemRequest.newBuilder()
   *           .setName(OperatingSystemName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM]").toString())
   *           .build();
   *   ApiFuture<OperatingSystem> future =
   *       operatingSystemServiceClient.getOperatingSystemCallable().futureCall(request);
   *   // Do something.
   *   OperatingSystem response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOperatingSystemRequest, OperatingSystem>
      getOperatingSystemCallable() {
    return stub.getOperatingSystemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `OperatingSystem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemServiceClient operatingSystemServiceClient =
   *     OperatingSystemServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (OperatingSystem element :
   *       operatingSystemServiceClient.listOperatingSystems(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of OperatingSystems. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperatingSystemsPagedResponse listOperatingSystems(NetworkName parent) {
    ListOperatingSystemsRequest request =
        ListOperatingSystemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOperatingSystems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `OperatingSystem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemServiceClient operatingSystemServiceClient =
   *     OperatingSystemServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (OperatingSystem element :
   *       operatingSystemServiceClient.listOperatingSystems(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of OperatingSystems. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperatingSystemsPagedResponse listOperatingSystems(String parent) {
    ListOperatingSystemsRequest request =
        ListOperatingSystemsRequest.newBuilder().setParent(parent).build();
    return listOperatingSystems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `OperatingSystem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemServiceClient operatingSystemServiceClient =
   *     OperatingSystemServiceClient.create()) {
   *   ListOperatingSystemsRequest request =
   *       ListOperatingSystemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (OperatingSystem element :
   *       operatingSystemServiceClient.listOperatingSystems(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperatingSystemsPagedResponse listOperatingSystems(
      ListOperatingSystemsRequest request) {
    return listOperatingSystemsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `OperatingSystem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemServiceClient operatingSystemServiceClient =
   *     OperatingSystemServiceClient.create()) {
   *   ListOperatingSystemsRequest request =
   *       ListOperatingSystemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<OperatingSystem> future =
   *       operatingSystemServiceClient.listOperatingSystemsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (OperatingSystem element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOperatingSystemsRequest, ListOperatingSystemsPagedResponse>
      listOperatingSystemsPagedCallable() {
    return stub.listOperatingSystemsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `OperatingSystem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemServiceClient operatingSystemServiceClient =
   *     OperatingSystemServiceClient.create()) {
   *   ListOperatingSystemsRequest request =
   *       ListOperatingSystemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListOperatingSystemsResponse response =
   *         operatingSystemServiceClient.listOperatingSystemsCallable().call(request);
   *     for (OperatingSystem element : response.getOperatingSystemsList()) {
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
  public final UnaryCallable<ListOperatingSystemsRequest, ListOperatingSystemsResponse>
      listOperatingSystemsCallable() {
    return stub.listOperatingSystemsCallable();
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

  public static class ListOperatingSystemsPagedResponse
      extends AbstractPagedListResponse<
          ListOperatingSystemsRequest,
          ListOperatingSystemsResponse,
          OperatingSystem,
          ListOperatingSystemsPage,
          ListOperatingSystemsFixedSizeCollection> {

    public static ApiFuture<ListOperatingSystemsPagedResponse> createAsync(
        PageContext<ListOperatingSystemsRequest, ListOperatingSystemsResponse, OperatingSystem>
            context,
        ApiFuture<ListOperatingSystemsResponse> futureResponse) {
      ApiFuture<ListOperatingSystemsPage> futurePage =
          ListOperatingSystemsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOperatingSystemsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOperatingSystemsPagedResponse(ListOperatingSystemsPage page) {
      super(page, ListOperatingSystemsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOperatingSystemsPage
      extends AbstractPage<
          ListOperatingSystemsRequest,
          ListOperatingSystemsResponse,
          OperatingSystem,
          ListOperatingSystemsPage> {

    private ListOperatingSystemsPage(
        PageContext<ListOperatingSystemsRequest, ListOperatingSystemsResponse, OperatingSystem>
            context,
        ListOperatingSystemsResponse response) {
      super(context, response);
    }

    private static ListOperatingSystemsPage createEmptyPage() {
      return new ListOperatingSystemsPage(null, null);
    }

    @Override
    protected ListOperatingSystemsPage createPage(
        PageContext<ListOperatingSystemsRequest, ListOperatingSystemsResponse, OperatingSystem>
            context,
        ListOperatingSystemsResponse response) {
      return new ListOperatingSystemsPage(context, response);
    }

    @Override
    public ApiFuture<ListOperatingSystemsPage> createPageAsync(
        PageContext<ListOperatingSystemsRequest, ListOperatingSystemsResponse, OperatingSystem>
            context,
        ApiFuture<ListOperatingSystemsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOperatingSystemsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOperatingSystemsRequest,
          ListOperatingSystemsResponse,
          OperatingSystem,
          ListOperatingSystemsPage,
          ListOperatingSystemsFixedSizeCollection> {

    private ListOperatingSystemsFixedSizeCollection(
        List<ListOperatingSystemsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOperatingSystemsFixedSizeCollection createEmptyCollection() {
      return new ListOperatingSystemsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOperatingSystemsFixedSizeCollection createCollection(
        List<ListOperatingSystemsPage> pages, int collectionSize) {
      return new ListOperatingSystemsFixedSizeCollection(pages, collectionSize);
    }
  }
}
