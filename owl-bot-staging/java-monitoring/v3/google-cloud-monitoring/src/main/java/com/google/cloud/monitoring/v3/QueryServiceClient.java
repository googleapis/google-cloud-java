/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.monitoring.v3;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.monitoring.v3.stub.QueryServiceStub;
import com.google.cloud.monitoring.v3.stub.QueryServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.monitoring.v3.QueryTimeSeriesRequest;
import com.google.monitoring.v3.QueryTimeSeriesResponse;
import com.google.monitoring.v3.TimeSeriesData;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The QueryService API is used to manage time series data in Stackdriver
 * Monitoring. Time series data is a collection of data points that describes the time-varying
 * values of a metric.
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
 * try (QueryServiceClient queryServiceClient = QueryServiceClient.create()) {
 *   QueryTimeSeriesRequest request =
 *       QueryTimeSeriesRequest.newBuilder()
 *           .setName("name3373707")
 *           .setQuery("query107944136")
 *           .setPageSize(883849137)
 *           .setPageToken("pageToken873572522")
 *           .build();
 *   for (TimeSeriesData element : queryServiceClient.queryTimeSeries(request).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the QueryServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of QueryServiceSettings to
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
 * QueryServiceSettings queryServiceSettings =
 *     QueryServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * QueryServiceClient queryServiceClient = QueryServiceClient.create(queryServiceSettings);
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
 * QueryServiceSettings queryServiceSettings =
 *     QueryServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * QueryServiceClient queryServiceClient = QueryServiceClient.create(queryServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class QueryServiceClient implements BackgroundResource {
  private final QueryServiceSettings settings;
  private final QueryServiceStub stub;

  /** Constructs an instance of QueryServiceClient with default settings. */
  public static final QueryServiceClient create() throws IOException {
    return create(QueryServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of QueryServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final QueryServiceClient create(QueryServiceSettings settings) throws IOException {
    return new QueryServiceClient(settings);
  }

  /**
   * Constructs an instance of QueryServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(QueryServiceSettings).
   */
  public static final QueryServiceClient create(QueryServiceStub stub) {
    return new QueryServiceClient(stub);
  }

  /**
   * Constructs an instance of QueryServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected QueryServiceClient(QueryServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((QueryServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected QueryServiceClient(QueryServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final QueryServiceSettings getSettings() {
    return settings;
  }

  public QueryServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries time series using Monitoring Query Language. This method does not require a Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QueryServiceClient queryServiceClient = QueryServiceClient.create()) {
   *   QueryTimeSeriesRequest request =
   *       QueryTimeSeriesRequest.newBuilder()
   *           .setName("name3373707")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TimeSeriesData element : queryServiceClient.queryTimeSeries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryTimeSeriesPagedResponse queryTimeSeries(QueryTimeSeriesRequest request) {
    return queryTimeSeriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries time series using Monitoring Query Language. This method does not require a Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QueryServiceClient queryServiceClient = QueryServiceClient.create()) {
   *   QueryTimeSeriesRequest request =
   *       QueryTimeSeriesRequest.newBuilder()
   *           .setName("name3373707")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TimeSeriesData> future =
   *       queryServiceClient.queryTimeSeriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TimeSeriesData element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryTimeSeriesRequest, QueryTimeSeriesPagedResponse>
      queryTimeSeriesPagedCallable() {
    return stub.queryTimeSeriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries time series using Monitoring Query Language. This method does not require a Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QueryServiceClient queryServiceClient = QueryServiceClient.create()) {
   *   QueryTimeSeriesRequest request =
   *       QueryTimeSeriesRequest.newBuilder()
   *           .setName("name3373707")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     QueryTimeSeriesResponse response =
   *         queryServiceClient.queryTimeSeriesCallable().call(request);
   *     for (TimeSeriesData element : response.getTimeSeriesDataList()) {
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
  public final UnaryCallable<QueryTimeSeriesRequest, QueryTimeSeriesResponse>
      queryTimeSeriesCallable() {
    return stub.queryTimeSeriesCallable();
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

  public static class QueryTimeSeriesPagedResponse
      extends AbstractPagedListResponse<
          QueryTimeSeriesRequest,
          QueryTimeSeriesResponse,
          TimeSeriesData,
          QueryTimeSeriesPage,
          QueryTimeSeriesFixedSizeCollection> {

    public static ApiFuture<QueryTimeSeriesPagedResponse> createAsync(
        PageContext<QueryTimeSeriesRequest, QueryTimeSeriesResponse, TimeSeriesData> context,
        ApiFuture<QueryTimeSeriesResponse> futureResponse) {
      ApiFuture<QueryTimeSeriesPage> futurePage =
          QueryTimeSeriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new QueryTimeSeriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private QueryTimeSeriesPagedResponse(QueryTimeSeriesPage page) {
      super(page, QueryTimeSeriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class QueryTimeSeriesPage
      extends AbstractPage<
          QueryTimeSeriesRequest, QueryTimeSeriesResponse, TimeSeriesData, QueryTimeSeriesPage> {

    private QueryTimeSeriesPage(
        PageContext<QueryTimeSeriesRequest, QueryTimeSeriesResponse, TimeSeriesData> context,
        QueryTimeSeriesResponse response) {
      super(context, response);
    }

    private static QueryTimeSeriesPage createEmptyPage() {
      return new QueryTimeSeriesPage(null, null);
    }

    @Override
    protected QueryTimeSeriesPage createPage(
        PageContext<QueryTimeSeriesRequest, QueryTimeSeriesResponse, TimeSeriesData> context,
        QueryTimeSeriesResponse response) {
      return new QueryTimeSeriesPage(context, response);
    }

    @Override
    public ApiFuture<QueryTimeSeriesPage> createPageAsync(
        PageContext<QueryTimeSeriesRequest, QueryTimeSeriesResponse, TimeSeriesData> context,
        ApiFuture<QueryTimeSeriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class QueryTimeSeriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          QueryTimeSeriesRequest,
          QueryTimeSeriesResponse,
          TimeSeriesData,
          QueryTimeSeriesPage,
          QueryTimeSeriesFixedSizeCollection> {

    private QueryTimeSeriesFixedSizeCollection(
        List<QueryTimeSeriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static QueryTimeSeriesFixedSizeCollection createEmptyCollection() {
      return new QueryTimeSeriesFixedSizeCollection(null, 0);
    }

    @Override
    protected QueryTimeSeriesFixedSizeCollection createCollection(
        List<QueryTimeSeriesPage> pages, int collectionSize) {
      return new QueryTimeSeriesFixedSizeCollection(pages, collectionSize);
    }
  }
}
