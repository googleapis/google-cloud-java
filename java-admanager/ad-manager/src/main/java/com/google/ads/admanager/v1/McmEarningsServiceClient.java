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

import com.google.ads.admanager.v1.stub.McmEarningsServiceStub;
import com.google.ads.admanager.v1.stub.McmEarningsServiceStubSettings;
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
 * Service Description: Provides methods for handling `McmEarnings` objects.
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
 * try (McmEarningsServiceClient mcmEarningsServiceClient = McmEarningsServiceClient.create()) {
 *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
 *   for (McmEarnings element : mcmEarningsServiceClient.fetchMcmEarnings(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the McmEarningsServiceClient object to clean up resources
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
 *      <td><p> FetchMcmEarnings</td>
 *      <td><p> Lists `McmEarnings` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchMcmEarnings(FetchMcmEarningsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchMcmEarnings(NetworkName parent)
 *           <li><p> fetchMcmEarnings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchMcmEarningsPagedCallable()
 *           <li><p> fetchMcmEarningsCallable()
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
 * <p>This class can be customized by passing in a custom instance of McmEarningsServiceSettings to
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
 * McmEarningsServiceSettings mcmEarningsServiceSettings =
 *     McmEarningsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * McmEarningsServiceClient mcmEarningsServiceClient =
 *     McmEarningsServiceClient.create(mcmEarningsServiceSettings);
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
 * McmEarningsServiceSettings mcmEarningsServiceSettings =
 *     McmEarningsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * McmEarningsServiceClient mcmEarningsServiceClient =
 *     McmEarningsServiceClient.create(mcmEarningsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class McmEarningsServiceClient implements BackgroundResource {
  private final @Nullable McmEarningsServiceSettings settings;
  private final McmEarningsServiceStub stub;

  /** Constructs an instance of McmEarningsServiceClient with default settings. */
  public static final McmEarningsServiceClient create() throws IOException {
    return create(McmEarningsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of McmEarningsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final McmEarningsServiceClient create(McmEarningsServiceSettings settings)
      throws IOException {
    return new McmEarningsServiceClient(settings);
  }

  /**
   * Constructs an instance of McmEarningsServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(McmEarningsServiceSettings).
   */
  public static final McmEarningsServiceClient create(McmEarningsServiceStub stub) {
    return new McmEarningsServiceClient(stub);
  }

  /**
   * Constructs an instance of McmEarningsServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected McmEarningsServiceClient(McmEarningsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((McmEarningsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected McmEarningsServiceClient(McmEarningsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable McmEarningsServiceSettings getSettings() {
    return settings;
  }

  public McmEarningsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `McmEarnings` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (McmEarningsServiceClient mcmEarningsServiceClient = McmEarningsServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (McmEarnings element : mcmEarningsServiceClient.fetchMcmEarnings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of McmEarnings. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchMcmEarningsPagedResponse fetchMcmEarnings(@Nullable NetworkName parent) {
    FetchMcmEarningsRequest request =
        FetchMcmEarningsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return fetchMcmEarnings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `McmEarnings` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (McmEarningsServiceClient mcmEarningsServiceClient = McmEarningsServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (McmEarnings element : mcmEarningsServiceClient.fetchMcmEarnings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of McmEarnings. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchMcmEarningsPagedResponse fetchMcmEarnings(String parent) {
    FetchMcmEarningsRequest request =
        FetchMcmEarningsRequest.newBuilder().setParent(parent).build();
    return fetchMcmEarnings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `McmEarnings` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (McmEarningsServiceClient mcmEarningsServiceClient = McmEarningsServiceClient.create()) {
   *   FetchMcmEarningsRequest request =
   *       FetchMcmEarningsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .setMonth(Date.newBuilder().build())
   *           .build();
   *   for (McmEarnings element : mcmEarningsServiceClient.fetchMcmEarnings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchMcmEarningsPagedResponse fetchMcmEarnings(FetchMcmEarningsRequest request) {
    return fetchMcmEarningsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `McmEarnings` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (McmEarningsServiceClient mcmEarningsServiceClient = McmEarningsServiceClient.create()) {
   *   FetchMcmEarningsRequest request =
   *       FetchMcmEarningsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .setMonth(Date.newBuilder().build())
   *           .build();
   *   ApiFuture<McmEarnings> future =
   *       mcmEarningsServiceClient.fetchMcmEarningsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (McmEarnings element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchMcmEarningsRequest, FetchMcmEarningsPagedResponse>
      fetchMcmEarningsPagedCallable() {
    return stub.fetchMcmEarningsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `McmEarnings` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (McmEarningsServiceClient mcmEarningsServiceClient = McmEarningsServiceClient.create()) {
   *   FetchMcmEarningsRequest request =
   *       FetchMcmEarningsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .setMonth(Date.newBuilder().build())
   *           .build();
   *   while (true) {
   *     FetchMcmEarningsResponse response =
   *         mcmEarningsServiceClient.fetchMcmEarningsCallable().call(request);
   *     for (McmEarnings element : response.getMcmEarningsList()) {
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
  public final UnaryCallable<FetchMcmEarningsRequest, FetchMcmEarningsResponse>
      fetchMcmEarningsCallable() {
    return stub.fetchMcmEarningsCallable();
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

  public static class FetchMcmEarningsPagedResponse
      extends AbstractPagedListResponse<
          FetchMcmEarningsRequest,
          FetchMcmEarningsResponse,
          McmEarnings,
          FetchMcmEarningsPage,
          FetchMcmEarningsFixedSizeCollection> {

    public static ApiFuture<FetchMcmEarningsPagedResponse> createAsync(
        PageContext<FetchMcmEarningsRequest, FetchMcmEarningsResponse, McmEarnings> context,
        ApiFuture<FetchMcmEarningsResponse> futureResponse) {
      ApiFuture<FetchMcmEarningsPage> futurePage =
          FetchMcmEarningsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchMcmEarningsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchMcmEarningsPagedResponse(FetchMcmEarningsPage page) {
      super(page, FetchMcmEarningsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchMcmEarningsPage
      extends AbstractPage<
          FetchMcmEarningsRequest, FetchMcmEarningsResponse, McmEarnings, FetchMcmEarningsPage> {

    private FetchMcmEarningsPage(
        @Nullable PageContext<FetchMcmEarningsRequest, FetchMcmEarningsResponse, McmEarnings>
            context,
        @Nullable FetchMcmEarningsResponse response) {
      super(context, response);
    }

    private static FetchMcmEarningsPage createEmptyPage() {
      return new FetchMcmEarningsPage(null, null);
    }

    @Override
    protected FetchMcmEarningsPage createPage(
        @Nullable PageContext<FetchMcmEarningsRequest, FetchMcmEarningsResponse, McmEarnings>
            context,
        @Nullable FetchMcmEarningsResponse response) {
      return new FetchMcmEarningsPage(context, response);
    }

    @Override
    public ApiFuture<FetchMcmEarningsPage> createPageAsync(
        @Nullable PageContext<FetchMcmEarningsRequest, FetchMcmEarningsResponse, McmEarnings>
            context,
        ApiFuture<FetchMcmEarningsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchMcmEarningsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchMcmEarningsRequest,
          FetchMcmEarningsResponse,
          McmEarnings,
          FetchMcmEarningsPage,
          FetchMcmEarningsFixedSizeCollection> {

    private FetchMcmEarningsFixedSizeCollection(
        @Nullable List<FetchMcmEarningsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchMcmEarningsFixedSizeCollection createEmptyCollection() {
      return new FetchMcmEarningsFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchMcmEarningsFixedSizeCollection createCollection(
        @Nullable List<FetchMcmEarningsPage> pages, int collectionSize) {
      return new FetchMcmEarningsFixedSizeCollection(pages, collectionSize);
    }
  }
}
