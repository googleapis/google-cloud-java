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

import com.google.ads.admanager.v1.stub.CreativeServiceStub;
import com.google.ads.admanager.v1.stub.CreativeServiceStubSettings;
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
 * Service Description: Provides methods for handling Creative objects.
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
 * try (CreativeServiceClient creativeServiceClient = CreativeServiceClient.create()) {
 *   CreativeName name = CreativeName.of("[NETWORK_CODE]", "[CREATIVE]");
 *   Creative response = creativeServiceClient.getCreative(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CreativeServiceClient object to clean up resources
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
 *      <td><p> GetCreative</td>
 *      <td><p> API to retrieve a Creative object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCreative(GetCreativeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCreative(CreativeName name)
 *           <li><p> getCreative(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCreativeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCreatives</td>
 *      <td><p> API to retrieve a list of Creative objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCreatives(ListCreativesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCreatives(NetworkName parent)
 *           <li><p> listCreatives(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCreativesPagedCallable()
 *           <li><p> listCreativesCallable()
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
 * <p>This class can be customized by passing in a custom instance of CreativeServiceSettings to
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
 * CreativeServiceSettings creativeServiceSettings =
 *     CreativeServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CreativeServiceClient creativeServiceClient =
 *     CreativeServiceClient.create(creativeServiceSettings);
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
 * CreativeServiceSettings creativeServiceSettings =
 *     CreativeServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CreativeServiceClient creativeServiceClient =
 *     CreativeServiceClient.create(creativeServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CreativeServiceClient implements BackgroundResource {
  private final CreativeServiceSettings settings;
  private final CreativeServiceStub stub;

  /** Constructs an instance of CreativeServiceClient with default settings. */
  public static final CreativeServiceClient create() throws IOException {
    return create(CreativeServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CreativeServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CreativeServiceClient create(CreativeServiceSettings settings)
      throws IOException {
    return new CreativeServiceClient(settings);
  }

  /**
   * Constructs an instance of CreativeServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(CreativeServiceSettings).
   */
  public static final CreativeServiceClient create(CreativeServiceStub stub) {
    return new CreativeServiceClient(stub);
  }

  /**
   * Constructs an instance of CreativeServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CreativeServiceClient(CreativeServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CreativeServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CreativeServiceClient(CreativeServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CreativeServiceSettings getSettings() {
    return settings;
  }

  public CreativeServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Creative object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeServiceClient creativeServiceClient = CreativeServiceClient.create()) {
   *   CreativeName name = CreativeName.of("[NETWORK_CODE]", "[CREATIVE]");
   *   Creative response = creativeServiceClient.getCreative(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Creative. Format:
   *     `networks/{network_code}/creatives/{creative_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Creative getCreative(CreativeName name) {
    GetCreativeRequest request =
        GetCreativeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCreative(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Creative object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeServiceClient creativeServiceClient = CreativeServiceClient.create()) {
   *   String name = CreativeName.of("[NETWORK_CODE]", "[CREATIVE]").toString();
   *   Creative response = creativeServiceClient.getCreative(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Creative. Format:
   *     `networks/{network_code}/creatives/{creative_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Creative getCreative(String name) {
    GetCreativeRequest request = GetCreativeRequest.newBuilder().setName(name).build();
    return getCreative(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Creative object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeServiceClient creativeServiceClient = CreativeServiceClient.create()) {
   *   GetCreativeRequest request =
   *       GetCreativeRequest.newBuilder()
   *           .setName(CreativeName.of("[NETWORK_CODE]", "[CREATIVE]").toString())
   *           .build();
   *   Creative response = creativeServiceClient.getCreative(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Creative getCreative(GetCreativeRequest request) {
    return getCreativeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Creative object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeServiceClient creativeServiceClient = CreativeServiceClient.create()) {
   *   GetCreativeRequest request =
   *       GetCreativeRequest.newBuilder()
   *           .setName(CreativeName.of("[NETWORK_CODE]", "[CREATIVE]").toString())
   *           .build();
   *   ApiFuture<Creative> future = creativeServiceClient.getCreativeCallable().futureCall(request);
   *   // Do something.
   *   Creative response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCreativeRequest, Creative> getCreativeCallable() {
    return stub.getCreativeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Creative objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeServiceClient creativeServiceClient = CreativeServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Creative element : creativeServiceClient.listCreatives(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Creatives. Format:
   *     networks/{network_code}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCreativesPagedResponse listCreatives(NetworkName parent) {
    ListCreativesRequest request =
        ListCreativesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCreatives(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Creative objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeServiceClient creativeServiceClient = CreativeServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Creative element : creativeServiceClient.listCreatives(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Creatives. Format:
   *     networks/{network_code}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCreativesPagedResponse listCreatives(String parent) {
    ListCreativesRequest request = ListCreativesRequest.newBuilder().setParent(parent).build();
    return listCreatives(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Creative objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeServiceClient creativeServiceClient = CreativeServiceClient.create()) {
   *   ListCreativesRequest request =
   *       ListCreativesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Creative element : creativeServiceClient.listCreatives(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCreativesPagedResponse listCreatives(ListCreativesRequest request) {
    return listCreativesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Creative objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeServiceClient creativeServiceClient = CreativeServiceClient.create()) {
   *   ListCreativesRequest request =
   *       ListCreativesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Creative> future =
   *       creativeServiceClient.listCreativesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Creative element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCreativesRequest, ListCreativesPagedResponse>
      listCreativesPagedCallable() {
    return stub.listCreativesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Creative objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeServiceClient creativeServiceClient = CreativeServiceClient.create()) {
   *   ListCreativesRequest request =
   *       ListCreativesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListCreativesResponse response =
   *         creativeServiceClient.listCreativesCallable().call(request);
   *     for (Creative element : response.getCreativesList()) {
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
  public final UnaryCallable<ListCreativesRequest, ListCreativesResponse> listCreativesCallable() {
    return stub.listCreativesCallable();
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

  public static class ListCreativesPagedResponse
      extends AbstractPagedListResponse<
          ListCreativesRequest,
          ListCreativesResponse,
          Creative,
          ListCreativesPage,
          ListCreativesFixedSizeCollection> {

    public static ApiFuture<ListCreativesPagedResponse> createAsync(
        PageContext<ListCreativesRequest, ListCreativesResponse, Creative> context,
        ApiFuture<ListCreativesResponse> futureResponse) {
      ApiFuture<ListCreativesPage> futurePage =
          ListCreativesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCreativesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCreativesPagedResponse(ListCreativesPage page) {
      super(page, ListCreativesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCreativesPage
      extends AbstractPage<
          ListCreativesRequest, ListCreativesResponse, Creative, ListCreativesPage> {

    private ListCreativesPage(
        PageContext<ListCreativesRequest, ListCreativesResponse, Creative> context,
        ListCreativesResponse response) {
      super(context, response);
    }

    private static ListCreativesPage createEmptyPage() {
      return new ListCreativesPage(null, null);
    }

    @Override
    protected ListCreativesPage createPage(
        PageContext<ListCreativesRequest, ListCreativesResponse, Creative> context,
        ListCreativesResponse response) {
      return new ListCreativesPage(context, response);
    }

    @Override
    public ApiFuture<ListCreativesPage> createPageAsync(
        PageContext<ListCreativesRequest, ListCreativesResponse, Creative> context,
        ApiFuture<ListCreativesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCreativesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCreativesRequest,
          ListCreativesResponse,
          Creative,
          ListCreativesPage,
          ListCreativesFixedSizeCollection> {

    private ListCreativesFixedSizeCollection(List<ListCreativesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCreativesFixedSizeCollection createEmptyCollection() {
      return new ListCreativesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCreativesFixedSizeCollection createCollection(
        List<ListCreativesPage> pages, int collectionSize) {
      return new ListCreativesFixedSizeCollection(pages, collectionSize);
    }
  }
}
