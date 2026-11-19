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

package com.google.cloud.chronicle.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.stub.SearchServiceStub;
import com.google.cloud.chronicle.v1.stub.SearchServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.type.Interval;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: SearchService provides methods for searching data in Chronicle.
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
 * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
 *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   String query = "query107944136";
 *   Interval timeRange = Interval.newBuilder().build();
 *   SearchSession response = searchServiceClient.searchAsync(parent, query, timeRange).get();
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SearchServiceClient object to clean up resources such
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
 *      <td><p> Initiates a long-running search operation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchAsync(SearchRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> searchAsync(InstanceName parent, String query, Interval timeRange)
 *           <li><p> searchAsync(String parent, String query, Interval timeRange)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchOperationCallable()
 *           <li><p> searchCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSearchedResults</td>
 *      <td><p> Retrieves results from a completed Search operation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSearchedResults(ListSearchedResultsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSearchedResults(SearchSessionName parent)
 *           <li><p> listSearchedResults(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSearchedResultsPagedCallable()
 *           <li><p> listSearchedResultsCallable()
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
 * <p>This class can be customized by passing in a custom instance of SearchServiceSettings to
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
 * SearchServiceSettings searchServiceSettings =
 *     SearchServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SearchServiceClient searchServiceClient = SearchServiceClient.create(searchServiceSettings);
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
 * SearchServiceSettings searchServiceSettings =
 *     SearchServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SearchServiceClient searchServiceClient = SearchServiceClient.create(searchServiceSettings);
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
 * SearchServiceSettings searchServiceSettings =
 *     SearchServiceSettings.newHttpJsonBuilder().build();
 * SearchServiceClient searchServiceClient = SearchServiceClient.create(searchServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class SearchServiceClient implements BackgroundResource {
  private final @Nullable SearchServiceSettings settings;
  private final SearchServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of SearchServiceClient with default settings. */
  public static final SearchServiceClient create() throws IOException {
    return create(SearchServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SearchServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SearchServiceClient create(SearchServiceSettings settings)
      throws IOException {
    return new SearchServiceClient(settings);
  }

  /**
   * Constructs an instance of SearchServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SearchServiceSettings).
   */
  public static final SearchServiceClient create(SearchServiceStub stub) {
    return new SearchServiceClient(stub);
  }

  /**
   * Constructs an instance of SearchServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SearchServiceClient(SearchServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SearchServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected SearchServiceClient(SearchServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final @Nullable SearchServiceSettings getSettings() {
    return settings;
  }

  public SearchServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a long-running search operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   String query = "query107944136";
   *   Interval timeRange = Interval.newBuilder().build();
   *   SearchSession response = searchServiceClient.searchAsync(parent, query, timeRange).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the instance on which to perform the search.
   *     Format: projects/{project}/locations/{location}/instances/{instance}
   * @param query Required. The search query, in the dialect set in `dialect`. Example:
   *     'ip=/172.&#42;/ AND metadata.event_type!="NETWORK_CONNECTION" AND ( target.ip =
   *     "3.225.179.73" OR target.ip = "23.47.48.70")'
   * @param timeRange Required. Time range to search for [Inclusive start time, exclusive end time).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SearchSession, SearchOperationMetadata> searchAsync(
      @Nullable InstanceName parent, String query, Interval timeRange) {
    SearchRequest request =
        SearchRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setQuery(query)
            .setTimeRange(timeRange)
            .build();
    return searchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a long-running search operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   String query = "query107944136";
   *   Interval timeRange = Interval.newBuilder().build();
   *   SearchSession response = searchServiceClient.searchAsync(parent, query, timeRange).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the instance on which to perform the search.
   *     Format: projects/{project}/locations/{location}/instances/{instance}
   * @param query Required. The search query, in the dialect set in `dialect`. Example:
   *     'ip=/172.&#42;/ AND metadata.event_type!="NETWORK_CONNECTION" AND ( target.ip =
   *     "3.225.179.73" OR target.ip = "23.47.48.70")'
   * @param timeRange Required. Time range to search for [Inclusive start time, exclusive end time).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SearchSession, SearchOperationMetadata> searchAsync(
      String parent, String query, Interval timeRange) {
    SearchRequest request =
        SearchRequest.newBuilder()
            .setParent(parent)
            .setQuery(query)
            .setTimeRange(timeRange)
            .build();
    return searchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a long-running search operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   SearchRequest request =
   *       SearchRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setQuery("query107944136")
   *           .setTimeRange(Interval.newBuilder().build())
   *           .setDialect(QueryDialect.forNumber(0))
   *           .setDraftDataAccessScope(DataAccessScope.newBuilder().build())
   *           .setResultLimit(522988825)
   *           .setSimulatedDataVisibility(SimulatedDataVisibility.forNumber(0))
   *           .build();
   *   SearchSession response = searchServiceClient.searchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SearchSession, SearchOperationMetadata> searchAsync(
      SearchRequest request) {
    return searchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a long-running search operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   SearchRequest request =
   *       SearchRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setQuery("query107944136")
   *           .setTimeRange(Interval.newBuilder().build())
   *           .setDialect(QueryDialect.forNumber(0))
   *           .setDraftDataAccessScope(DataAccessScope.newBuilder().build())
   *           .setResultLimit(522988825)
   *           .setSimulatedDataVisibility(SimulatedDataVisibility.forNumber(0))
   *           .build();
   *   OperationFuture<SearchSession, SearchOperationMetadata> future =
   *       searchServiceClient.searchOperationCallable().futureCall(request);
   *   // Do something.
   *   SearchSession response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SearchRequest, SearchSession, SearchOperationMetadata>
      searchOperationCallable() {
    return stub.searchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a long-running search operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   SearchRequest request =
   *       SearchRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setQuery("query107944136")
   *           .setTimeRange(Interval.newBuilder().build())
   *           .setDialect(QueryDialect.forNumber(0))
   *           .setDraftDataAccessScope(DataAccessScope.newBuilder().build())
   *           .setResultLimit(522988825)
   *           .setSimulatedDataVisibility(SimulatedDataVisibility.forNumber(0))
   *           .build();
   *   ApiFuture<Operation> future = searchServiceClient.searchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchRequest, Operation> searchCallable() {
    return stub.searchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves results from a completed Search operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   SearchSessionName parent =
   *       SearchSessionName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[SEARCH_SESSION]");
   *   for (SearchedResult element : searchServiceClient.listSearchedResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent SearchSession resource name. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/searchSessions/{search_session}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSearchedResultsPagedResponse listSearchedResults(
      @Nullable SearchSessionName parent) {
    ListSearchedResultsRequest request =
        ListSearchedResultsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSearchedResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves results from a completed Search operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   String parent =
   *       SearchSessionName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[SEARCH_SESSION]")
   *           .toString();
   *   for (SearchedResult element : searchServiceClient.listSearchedResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent SearchSession resource name. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/searchSessions/{search_session}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSearchedResultsPagedResponse listSearchedResults(String parent) {
    ListSearchedResultsRequest request =
        ListSearchedResultsRequest.newBuilder().setParent(parent).build();
    return listSearchedResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves results from a completed Search operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   ListSearchedResultsRequest request =
   *       ListSearchedResultsRequest.newBuilder()
   *           .setParent(
   *               SearchSessionName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[SEARCH_SESSION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (SearchedResult element : searchServiceClient.listSearchedResults(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSearchedResultsPagedResponse listSearchedResults(
      ListSearchedResultsRequest request) {
    return listSearchedResultsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves results from a completed Search operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   ListSearchedResultsRequest request =
   *       ListSearchedResultsRequest.newBuilder()
   *           .setParent(
   *               SearchSessionName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[SEARCH_SESSION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<SearchedResult> future =
   *       searchServiceClient.listSearchedResultsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchedResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSearchedResultsRequest, ListSearchedResultsPagedResponse>
      listSearchedResultsPagedCallable() {
    return stub.listSearchedResultsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves results from a completed Search operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   ListSearchedResultsRequest request =
   *       ListSearchedResultsRequest.newBuilder()
   *           .setParent(
   *               SearchSessionName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[SEARCH_SESSION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListSearchedResultsResponse response =
   *         searchServiceClient.listSearchedResultsCallable().call(request);
   *     for (SearchedResult element : response.getSearchedResultsList()) {
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
  public final UnaryCallable<ListSearchedResultsRequest, ListSearchedResultsResponse>
      listSearchedResultsCallable() {
    return stub.listSearchedResultsCallable();
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

  public static class ListSearchedResultsPagedResponse
      extends AbstractPagedListResponse<
          ListSearchedResultsRequest,
          ListSearchedResultsResponse,
          SearchedResult,
          ListSearchedResultsPage,
          ListSearchedResultsFixedSizeCollection> {

    public static ApiFuture<ListSearchedResultsPagedResponse> createAsync(
        PageContext<ListSearchedResultsRequest, ListSearchedResultsResponse, SearchedResult>
            context,
        ApiFuture<ListSearchedResultsResponse> futureResponse) {
      ApiFuture<ListSearchedResultsPage> futurePage =
          ListSearchedResultsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSearchedResultsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSearchedResultsPagedResponse(ListSearchedResultsPage page) {
      super(page, ListSearchedResultsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSearchedResultsPage
      extends AbstractPage<
          ListSearchedResultsRequest,
          ListSearchedResultsResponse,
          SearchedResult,
          ListSearchedResultsPage> {

    private ListSearchedResultsPage(
        @Nullable
            PageContext<ListSearchedResultsRequest, ListSearchedResultsResponse, SearchedResult>
            context,
        @Nullable ListSearchedResultsResponse response) {
      super(context, response);
    }

    private static ListSearchedResultsPage createEmptyPage() {
      return new ListSearchedResultsPage(null, null);
    }

    @Override
    protected ListSearchedResultsPage createPage(
        @Nullable
            PageContext<ListSearchedResultsRequest, ListSearchedResultsResponse, SearchedResult>
            context,
        @Nullable ListSearchedResultsResponse response) {
      return new ListSearchedResultsPage(context, response);
    }

    @Override
    public ApiFuture<ListSearchedResultsPage> createPageAsync(
        @Nullable
            PageContext<ListSearchedResultsRequest, ListSearchedResultsResponse, SearchedResult>
            context,
        ApiFuture<ListSearchedResultsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSearchedResultsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSearchedResultsRequest,
          ListSearchedResultsResponse,
          SearchedResult,
          ListSearchedResultsPage,
          ListSearchedResultsFixedSizeCollection> {

    private ListSearchedResultsFixedSizeCollection(
        @Nullable List<ListSearchedResultsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSearchedResultsFixedSizeCollection createEmptyCollection() {
      return new ListSearchedResultsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSearchedResultsFixedSizeCollection createCollection(
        @Nullable List<ListSearchedResultsPage> pages, int collectionSize) {
      return new ListSearchedResultsFixedSizeCollection(pages, collectionSize);
    }
  }
}
