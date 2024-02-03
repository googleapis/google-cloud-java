/*
 * Copyright 2023 Google LLC
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

package com.google.shopping.merchant.reports.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.shopping.merchant.reports.v1beta.stub.ReportServiceStub;
import com.google.shopping.merchant.reports.v1beta.stub.ReportServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for retrieving reports and insights about your products, their
 * performance, and their competitive environment on Google.
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
 * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
 *   String parent = "parent-995424086";
 *   for (ReportRow element : reportServiceClient.search(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ReportServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> Search</td>
 *      <td><p> Retrieves a report defined by a search query. The response might contain fewer rows than specified by `page_size`. Rely on `next_page_token` to determine if there are more rows to be requested.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> search(SearchRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> search(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchPagedCallable()
 *           <li><p> searchCallable()
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
 * <p>This class can be customized by passing in a custom instance of ReportServiceSettings to
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
 * ReportServiceSettings reportServiceSettings =
 *     ReportServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReportServiceClient reportServiceClient = ReportServiceClient.create(reportServiceSettings);
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
 * ReportServiceSettings reportServiceSettings =
 *     ReportServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ReportServiceClient reportServiceClient = ReportServiceClient.create(reportServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReportServiceSettings reportServiceSettings =
 *     ReportServiceSettings.newHttpJsonBuilder().build();
 * ReportServiceClient reportServiceClient = ReportServiceClient.create(reportServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ReportServiceClient implements BackgroundResource {
  private final ReportServiceSettings settings;
  private final ReportServiceStub stub;

  /** Constructs an instance of ReportServiceClient with default settings. */
  public static final ReportServiceClient create() throws IOException {
    return create(ReportServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ReportServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ReportServiceClient create(ReportServiceSettings settings)
      throws IOException {
    return new ReportServiceClient(settings);
  }

  /**
   * Constructs an instance of ReportServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ReportServiceSettings).
   */
  public static final ReportServiceClient create(ReportServiceStub stub) {
    return new ReportServiceClient(stub);
  }

  /**
   * Constructs an instance of ReportServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ReportServiceClient(ReportServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ReportServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ReportServiceClient(ReportServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ReportServiceSettings getSettings() {
    return settings;
  }

  public ReportServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a report defined by a search query. The response might contain fewer rows than
   * specified by `page_size`. Rely on `next_page_token` to determine if there are more rows to be
   * requested.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   for (ReportRow element : reportServiceClient.search(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Id of the account making the call. Must be a standalone account or an
   *     MCA subaccount. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchPagedResponse search(String parent) {
    SearchRequest request = SearchRequest.newBuilder().setParent(parent).build();
    return search(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a report defined by a search query. The response might contain fewer rows than
   * specified by `page_size`. Rely on `next_page_token` to determine if there are more rows to be
   * requested.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   SearchRequest request =
   *       SearchRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ReportRow element : reportServiceClient.search(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchPagedResponse search(SearchRequest request) {
    return searchPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a report defined by a search query. The response might contain fewer rows than
   * specified by `page_size`. Rely on `next_page_token` to determine if there are more rows to be
   * requested.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   SearchRequest request =
   *       SearchRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ReportRow> future = reportServiceClient.searchPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReportRow element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchRequest, SearchPagedResponse> searchPagedCallable() {
    return stub.searchPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a report defined by a search query. The response might contain fewer rows than
   * specified by `page_size`. Rely on `next_page_token` to determine if there are more rows to be
   * requested.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   SearchRequest request =
   *       SearchRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchResponse response = reportServiceClient.searchCallable().call(request);
   *     for (ReportRow element : response.getResultsList()) {
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
  public final UnaryCallable<SearchRequest, SearchResponse> searchCallable() {
    return stub.searchCallable();
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

  public static class SearchPagedResponse
      extends AbstractPagedListResponse<
          SearchRequest, SearchResponse, ReportRow, SearchPage, SearchFixedSizeCollection> {

    public static ApiFuture<SearchPagedResponse> createAsync(
        PageContext<SearchRequest, SearchResponse, ReportRow> context,
        ApiFuture<SearchResponse> futureResponse) {
      ApiFuture<SearchPage> futurePage =
          SearchPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new SearchPagedResponse(input), MoreExecutors.directExecutor());
    }

    private SearchPagedResponse(SearchPage page) {
      super(page, SearchFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchPage
      extends AbstractPage<SearchRequest, SearchResponse, ReportRow, SearchPage> {

    private SearchPage(
        PageContext<SearchRequest, SearchResponse, ReportRow> context, SearchResponse response) {
      super(context, response);
    }

    private static SearchPage createEmptyPage() {
      return new SearchPage(null, null);
    }

    @Override
    protected SearchPage createPage(
        PageContext<SearchRequest, SearchResponse, ReportRow> context, SearchResponse response) {
      return new SearchPage(context, response);
    }

    @Override
    public ApiFuture<SearchPage> createPageAsync(
        PageContext<SearchRequest, SearchResponse, ReportRow> context,
        ApiFuture<SearchResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchRequest, SearchResponse, ReportRow, SearchPage, SearchFixedSizeCollection> {

    private SearchFixedSizeCollection(List<SearchPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchFixedSizeCollection createEmptyCollection() {
      return new SearchFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchFixedSizeCollection createCollection(
        List<SearchPage> pages, int collectionSize) {
      return new SearchFixedSizeCollection(pages, collectionSize);
    }
  }
}
