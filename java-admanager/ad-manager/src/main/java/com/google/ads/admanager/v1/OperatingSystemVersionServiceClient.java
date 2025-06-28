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

import com.google.ads.admanager.v1.stub.OperatingSystemVersionServiceStub;
import com.google.ads.admanager.v1.stub.OperatingSystemVersionServiceStubSettings;
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
 * Service Description: Provides methods for handling `OperatingSystemVersion` objects.
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
 * try (OperatingSystemVersionServiceClient operatingSystemVersionServiceClient =
 *     OperatingSystemVersionServiceClient.create()) {
 *   OperatingSystemVersionName name =
 *       OperatingSystemVersionName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM_VERSION]");
 *   OperatingSystemVersion response =
 *       operatingSystemVersionServiceClient.getOperatingSystemVersion(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OperatingSystemVersionServiceClient object to clean up
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
 *      <td><p> GetOperatingSystemVersion</td>
 *      <td><p> API to retrieve a `OperatingSystemVersion` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOperatingSystemVersion(GetOperatingSystemVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOperatingSystemVersion(OperatingSystemVersionName name)
 *           <li><p> getOperatingSystemVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOperatingSystemVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListOperatingSystemVersions</td>
 *      <td><p> API to retrieve a list of `OperatingSystemVersion` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOperatingSystemVersions(ListOperatingSystemVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOperatingSystemVersions(NetworkName parent)
 *           <li><p> listOperatingSystemVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOperatingSystemVersionsPagedCallable()
 *           <li><p> listOperatingSystemVersionsCallable()
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
 * OperatingSystemVersionServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OperatingSystemVersionServiceSettings operatingSystemVersionServiceSettings =
 *     OperatingSystemVersionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OperatingSystemVersionServiceClient operatingSystemVersionServiceClient =
 *     OperatingSystemVersionServiceClient.create(operatingSystemVersionServiceSettings);
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
 * OperatingSystemVersionServiceSettings operatingSystemVersionServiceSettings =
 *     OperatingSystemVersionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OperatingSystemVersionServiceClient operatingSystemVersionServiceClient =
 *     OperatingSystemVersionServiceClient.create(operatingSystemVersionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class OperatingSystemVersionServiceClient implements BackgroundResource {
  private final OperatingSystemVersionServiceSettings settings;
  private final OperatingSystemVersionServiceStub stub;

  /** Constructs an instance of OperatingSystemVersionServiceClient with default settings. */
  public static final OperatingSystemVersionServiceClient create() throws IOException {
    return create(OperatingSystemVersionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OperatingSystemVersionServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final OperatingSystemVersionServiceClient create(
      OperatingSystemVersionServiceSettings settings) throws IOException {
    return new OperatingSystemVersionServiceClient(settings);
  }

  /**
   * Constructs an instance of OperatingSystemVersionServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(OperatingSystemVersionServiceSettings).
   */
  public static final OperatingSystemVersionServiceClient create(
      OperatingSystemVersionServiceStub stub) {
    return new OperatingSystemVersionServiceClient(stub);
  }

  /**
   * Constructs an instance of OperatingSystemVersionServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected OperatingSystemVersionServiceClient(OperatingSystemVersionServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((OperatingSystemVersionServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected OperatingSystemVersionServiceClient(OperatingSystemVersionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final OperatingSystemVersionServiceSettings getSettings() {
    return settings;
  }

  public OperatingSystemVersionServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `OperatingSystemVersion` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemVersionServiceClient operatingSystemVersionServiceClient =
   *     OperatingSystemVersionServiceClient.create()) {
   *   OperatingSystemVersionName name =
   *       OperatingSystemVersionName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM_VERSION]");
   *   OperatingSystemVersion response =
   *       operatingSystemVersionServiceClient.getOperatingSystemVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the OperatingSystemVersion. Format:
   *     `networks/{network_code}/operatingSystemVersions/{operating_system_version_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperatingSystemVersion getOperatingSystemVersion(OperatingSystemVersionName name) {
    GetOperatingSystemVersionRequest request =
        GetOperatingSystemVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getOperatingSystemVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `OperatingSystemVersion` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemVersionServiceClient operatingSystemVersionServiceClient =
   *     OperatingSystemVersionServiceClient.create()) {
   *   String name =
   *       OperatingSystemVersionName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM_VERSION]").toString();
   *   OperatingSystemVersion response =
   *       operatingSystemVersionServiceClient.getOperatingSystemVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the OperatingSystemVersion. Format:
   *     `networks/{network_code}/operatingSystemVersions/{operating_system_version_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperatingSystemVersion getOperatingSystemVersion(String name) {
    GetOperatingSystemVersionRequest request =
        GetOperatingSystemVersionRequest.newBuilder().setName(name).build();
    return getOperatingSystemVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `OperatingSystemVersion` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemVersionServiceClient operatingSystemVersionServiceClient =
   *     OperatingSystemVersionServiceClient.create()) {
   *   GetOperatingSystemVersionRequest request =
   *       GetOperatingSystemVersionRequest.newBuilder()
   *           .setName(
   *               OperatingSystemVersionName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM_VERSION]")
   *                   .toString())
   *           .build();
   *   OperatingSystemVersion response =
   *       operatingSystemVersionServiceClient.getOperatingSystemVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperatingSystemVersion getOperatingSystemVersion(
      GetOperatingSystemVersionRequest request) {
    return getOperatingSystemVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `OperatingSystemVersion` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemVersionServiceClient operatingSystemVersionServiceClient =
   *     OperatingSystemVersionServiceClient.create()) {
   *   GetOperatingSystemVersionRequest request =
   *       GetOperatingSystemVersionRequest.newBuilder()
   *           .setName(
   *               OperatingSystemVersionName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<OperatingSystemVersion> future =
   *       operatingSystemVersionServiceClient
   *           .getOperatingSystemVersionCallable()
   *           .futureCall(request);
   *   // Do something.
   *   OperatingSystemVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOperatingSystemVersionRequest, OperatingSystemVersion>
      getOperatingSystemVersionCallable() {
    return stub.getOperatingSystemVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `OperatingSystemVersion` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemVersionServiceClient operatingSystemVersionServiceClient =
   *     OperatingSystemVersionServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (OperatingSystemVersion element :
   *       operatingSystemVersionServiceClient.listOperatingSystemVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of OperatingSystemVersions.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperatingSystemVersionsPagedResponse listOperatingSystemVersions(
      NetworkName parent) {
    ListOperatingSystemVersionsRequest request =
        ListOperatingSystemVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOperatingSystemVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `OperatingSystemVersion` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemVersionServiceClient operatingSystemVersionServiceClient =
   *     OperatingSystemVersionServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (OperatingSystemVersion element :
   *       operatingSystemVersionServiceClient.listOperatingSystemVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of OperatingSystemVersions.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperatingSystemVersionsPagedResponse listOperatingSystemVersions(String parent) {
    ListOperatingSystemVersionsRequest request =
        ListOperatingSystemVersionsRequest.newBuilder().setParent(parent).build();
    return listOperatingSystemVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `OperatingSystemVersion` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemVersionServiceClient operatingSystemVersionServiceClient =
   *     OperatingSystemVersionServiceClient.create()) {
   *   ListOperatingSystemVersionsRequest request =
   *       ListOperatingSystemVersionsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (OperatingSystemVersion element :
   *       operatingSystemVersionServiceClient.listOperatingSystemVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperatingSystemVersionsPagedResponse listOperatingSystemVersions(
      ListOperatingSystemVersionsRequest request) {
    return listOperatingSystemVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `OperatingSystemVersion` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemVersionServiceClient operatingSystemVersionServiceClient =
   *     OperatingSystemVersionServiceClient.create()) {
   *   ListOperatingSystemVersionsRequest request =
   *       ListOperatingSystemVersionsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<OperatingSystemVersion> future =
   *       operatingSystemVersionServiceClient
   *           .listOperatingSystemVersionsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (OperatingSystemVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListOperatingSystemVersionsRequest, ListOperatingSystemVersionsPagedResponse>
      listOperatingSystemVersionsPagedCallable() {
    return stub.listOperatingSystemVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `OperatingSystemVersion` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OperatingSystemVersionServiceClient operatingSystemVersionServiceClient =
   *     OperatingSystemVersionServiceClient.create()) {
   *   ListOperatingSystemVersionsRequest request =
   *       ListOperatingSystemVersionsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListOperatingSystemVersionsResponse response =
   *         operatingSystemVersionServiceClient.listOperatingSystemVersionsCallable().call(request);
   *     for (OperatingSystemVersion element : response.getOperatingSystemVersionsList()) {
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
  public final UnaryCallable<
          ListOperatingSystemVersionsRequest, ListOperatingSystemVersionsResponse>
      listOperatingSystemVersionsCallable() {
    return stub.listOperatingSystemVersionsCallable();
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

  public static class ListOperatingSystemVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListOperatingSystemVersionsRequest,
          ListOperatingSystemVersionsResponse,
          OperatingSystemVersion,
          ListOperatingSystemVersionsPage,
          ListOperatingSystemVersionsFixedSizeCollection> {

    public static ApiFuture<ListOperatingSystemVersionsPagedResponse> createAsync(
        PageContext<
                ListOperatingSystemVersionsRequest,
                ListOperatingSystemVersionsResponse,
                OperatingSystemVersion>
            context,
        ApiFuture<ListOperatingSystemVersionsResponse> futureResponse) {
      ApiFuture<ListOperatingSystemVersionsPage> futurePage =
          ListOperatingSystemVersionsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOperatingSystemVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOperatingSystemVersionsPagedResponse(ListOperatingSystemVersionsPage page) {
      super(page, ListOperatingSystemVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOperatingSystemVersionsPage
      extends AbstractPage<
          ListOperatingSystemVersionsRequest,
          ListOperatingSystemVersionsResponse,
          OperatingSystemVersion,
          ListOperatingSystemVersionsPage> {

    private ListOperatingSystemVersionsPage(
        PageContext<
                ListOperatingSystemVersionsRequest,
                ListOperatingSystemVersionsResponse,
                OperatingSystemVersion>
            context,
        ListOperatingSystemVersionsResponse response) {
      super(context, response);
    }

    private static ListOperatingSystemVersionsPage createEmptyPage() {
      return new ListOperatingSystemVersionsPage(null, null);
    }

    @Override
    protected ListOperatingSystemVersionsPage createPage(
        PageContext<
                ListOperatingSystemVersionsRequest,
                ListOperatingSystemVersionsResponse,
                OperatingSystemVersion>
            context,
        ListOperatingSystemVersionsResponse response) {
      return new ListOperatingSystemVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListOperatingSystemVersionsPage> createPageAsync(
        PageContext<
                ListOperatingSystemVersionsRequest,
                ListOperatingSystemVersionsResponse,
                OperatingSystemVersion>
            context,
        ApiFuture<ListOperatingSystemVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOperatingSystemVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOperatingSystemVersionsRequest,
          ListOperatingSystemVersionsResponse,
          OperatingSystemVersion,
          ListOperatingSystemVersionsPage,
          ListOperatingSystemVersionsFixedSizeCollection> {

    private ListOperatingSystemVersionsFixedSizeCollection(
        List<ListOperatingSystemVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOperatingSystemVersionsFixedSizeCollection createEmptyCollection() {
      return new ListOperatingSystemVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOperatingSystemVersionsFixedSizeCollection createCollection(
        List<ListOperatingSystemVersionsPage> pages, int collectionSize) {
      return new ListOperatingSystemVersionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
