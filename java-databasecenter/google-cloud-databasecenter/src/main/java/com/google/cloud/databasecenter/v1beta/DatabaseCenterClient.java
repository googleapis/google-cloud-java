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

package com.google.cloud.databasecenter.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.databasecenter.v1beta.stub.DatabaseCenterStub;
import com.google.cloud.databasecenter.v1beta.stub.DatabaseCenterStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: DatabaseCenter contains methods to query fleet view for database resources.
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
 * try (DatabaseCenterClient databaseCenterClient = DatabaseCenterClient.create()) {
 *   QueryProductsRequest request =
 *       QueryProductsRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setPageSize(883849137)
 *           .setPageToken("pageToken873572522")
 *           .build();
 *   for (Product element : databaseCenterClient.queryProducts(request).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DatabaseCenterClient object to clean up resources such
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
 *      <td><p> QueryProducts</td>
 *      <td><p> QueryProducts provides a list of all possible products which can be used to filter database resources.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryProducts(QueryProductsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryProductsPagedCallable()
 *           <li><p> queryProductsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AggregateFleet</td>
 *      <td><p> AggregateFleet provides statistics about the fleet grouped by various fields.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> aggregateFleet(AggregateFleetRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> aggregateFleetPagedCallable()
 *           <li><p> aggregateFleetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryDatabaseResourceGroups</td>
 *      <td><p> QueryDatabaseResourceGroups returns paginated results of database groups.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryDatabaseResourceGroups(QueryDatabaseResourceGroupsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryDatabaseResourceGroupsPagedCallable()
 *           <li><p> queryDatabaseResourceGroupsCallable()
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
 * <p>This class can be customized by passing in a custom instance of DatabaseCenterSettings to
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
 * DatabaseCenterSettings databaseCenterSettings =
 *     DatabaseCenterSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DatabaseCenterClient databaseCenterClient = DatabaseCenterClient.create(databaseCenterSettings);
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
 * DatabaseCenterSettings databaseCenterSettings =
 *     DatabaseCenterSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DatabaseCenterClient databaseCenterClient = DatabaseCenterClient.create(databaseCenterSettings);
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
 * DatabaseCenterSettings databaseCenterSettings =
 *     DatabaseCenterSettings.newHttpJsonBuilder().build();
 * DatabaseCenterClient databaseCenterClient = DatabaseCenterClient.create(databaseCenterSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DatabaseCenterClient implements BackgroundResource {
  private final DatabaseCenterSettings settings;
  private final DatabaseCenterStub stub;

  /** Constructs an instance of DatabaseCenterClient with default settings. */
  public static final DatabaseCenterClient create() throws IOException {
    return create(DatabaseCenterSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DatabaseCenterClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DatabaseCenterClient create(DatabaseCenterSettings settings)
      throws IOException {
    return new DatabaseCenterClient(settings);
  }

  /**
   * Constructs an instance of DatabaseCenterClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(DatabaseCenterSettings).
   */
  public static final DatabaseCenterClient create(DatabaseCenterStub stub) {
    return new DatabaseCenterClient(stub);
  }

  /**
   * Constructs an instance of DatabaseCenterClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DatabaseCenterClient(DatabaseCenterSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DatabaseCenterStubSettings) settings.getStubSettings()).createStub();
  }

  protected DatabaseCenterClient(DatabaseCenterStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DatabaseCenterSettings getSettings() {
    return settings;
  }

  public DatabaseCenterStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * QueryProducts provides a list of all possible products which can be used to filter database
   * resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseCenterClient databaseCenterClient = DatabaseCenterClient.create()) {
   *   QueryProductsRequest request =
   *       QueryProductsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Product element : databaseCenterClient.queryProducts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryProductsPagedResponse queryProducts(QueryProductsRequest request) {
    return queryProductsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * QueryProducts provides a list of all possible products which can be used to filter database
   * resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseCenterClient databaseCenterClient = DatabaseCenterClient.create()) {
   *   QueryProductsRequest request =
   *       QueryProductsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Product> future =
   *       databaseCenterClient.queryProductsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Product element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryProductsRequest, QueryProductsPagedResponse>
      queryProductsPagedCallable() {
    return stub.queryProductsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * QueryProducts provides a list of all possible products which can be used to filter database
   * resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseCenterClient databaseCenterClient = DatabaseCenterClient.create()) {
   *   QueryProductsRequest request =
   *       QueryProductsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     QueryProductsResponse response = databaseCenterClient.queryProductsCallable().call(request);
   *     for (Product element : response.getProductsList()) {
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
  public final UnaryCallable<QueryProductsRequest, QueryProductsResponse> queryProductsCallable() {
    return stub.queryProductsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * AggregateFleet provides statistics about the fleet grouped by various fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseCenterClient databaseCenterClient = DatabaseCenterClient.create()) {
   *   AggregateFleetRequest request =
   *       AggregateFleetRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setGroupBy("groupBy293428022")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setBaselineDate(Date.newBuilder().build())
   *           .build();
   *   for (AggregateFleetRow element : databaseCenterClient.aggregateFleet(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregateFleetPagedResponse aggregateFleet(AggregateFleetRequest request) {
    return aggregateFleetPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * AggregateFleet provides statistics about the fleet grouped by various fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseCenterClient databaseCenterClient = DatabaseCenterClient.create()) {
   *   AggregateFleetRequest request =
   *       AggregateFleetRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setGroupBy("groupBy293428022")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setBaselineDate(Date.newBuilder().build())
   *           .build();
   *   ApiFuture<AggregateFleetRow> future =
   *       databaseCenterClient.aggregateFleetPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AggregateFleetRow element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregateFleetRequest, AggregateFleetPagedResponse>
      aggregateFleetPagedCallable() {
    return stub.aggregateFleetPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * AggregateFleet provides statistics about the fleet grouped by various fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseCenterClient databaseCenterClient = DatabaseCenterClient.create()) {
   *   AggregateFleetRequest request =
   *       AggregateFleetRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setGroupBy("groupBy293428022")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setBaselineDate(Date.newBuilder().build())
   *           .build();
   *   while (true) {
   *     AggregateFleetResponse response =
   *         databaseCenterClient.aggregateFleetCallable().call(request);
   *     for (AggregateFleetRow element : response.getRowsList()) {
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
  public final UnaryCallable<AggregateFleetRequest, AggregateFleetResponse>
      aggregateFleetCallable() {
    return stub.aggregateFleetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * QueryDatabaseResourceGroups returns paginated results of database groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseCenterClient databaseCenterClient = DatabaseCenterClient.create()) {
   *   QueryDatabaseResourceGroupsRequest request =
   *       QueryDatabaseResourceGroupsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .addAllSignalTypeGroups(new ArrayList<SignalTypeGroup>())
   *           .addAllSignalFilters(new ArrayList<SignalFilter>())
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DatabaseResourceGroup element :
   *       databaseCenterClient.queryDatabaseResourceGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryDatabaseResourceGroupsPagedResponse queryDatabaseResourceGroups(
      QueryDatabaseResourceGroupsRequest request) {
    return queryDatabaseResourceGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * QueryDatabaseResourceGroups returns paginated results of database groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseCenterClient databaseCenterClient = DatabaseCenterClient.create()) {
   *   QueryDatabaseResourceGroupsRequest request =
   *       QueryDatabaseResourceGroupsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .addAllSignalTypeGroups(new ArrayList<SignalTypeGroup>())
   *           .addAllSignalFilters(new ArrayList<SignalFilter>())
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DatabaseResourceGroup> future =
   *       databaseCenterClient.queryDatabaseResourceGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DatabaseResourceGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          QueryDatabaseResourceGroupsRequest, QueryDatabaseResourceGroupsPagedResponse>
      queryDatabaseResourceGroupsPagedCallable() {
    return stub.queryDatabaseResourceGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * QueryDatabaseResourceGroups returns paginated results of database groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseCenterClient databaseCenterClient = DatabaseCenterClient.create()) {
   *   QueryDatabaseResourceGroupsRequest request =
   *       QueryDatabaseResourceGroupsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .addAllSignalTypeGroups(new ArrayList<SignalTypeGroup>())
   *           .addAllSignalFilters(new ArrayList<SignalFilter>())
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     QueryDatabaseResourceGroupsResponse response =
   *         databaseCenterClient.queryDatabaseResourceGroupsCallable().call(request);
   *     for (DatabaseResourceGroup element : response.getResourceGroupsList()) {
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
          QueryDatabaseResourceGroupsRequest, QueryDatabaseResourceGroupsResponse>
      queryDatabaseResourceGroupsCallable() {
    return stub.queryDatabaseResourceGroupsCallable();
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

  public static class QueryProductsPagedResponse
      extends AbstractPagedListResponse<
          QueryProductsRequest,
          QueryProductsResponse,
          Product,
          QueryProductsPage,
          QueryProductsFixedSizeCollection> {

    public static ApiFuture<QueryProductsPagedResponse> createAsync(
        PageContext<QueryProductsRequest, QueryProductsResponse, Product> context,
        ApiFuture<QueryProductsResponse> futureResponse) {
      ApiFuture<QueryProductsPage> futurePage =
          QueryProductsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new QueryProductsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private QueryProductsPagedResponse(QueryProductsPage page) {
      super(page, QueryProductsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class QueryProductsPage
      extends AbstractPage<
          QueryProductsRequest, QueryProductsResponse, Product, QueryProductsPage> {

    private QueryProductsPage(
        PageContext<QueryProductsRequest, QueryProductsResponse, Product> context,
        QueryProductsResponse response) {
      super(context, response);
    }

    private static QueryProductsPage createEmptyPage() {
      return new QueryProductsPage(null, null);
    }

    @Override
    protected QueryProductsPage createPage(
        PageContext<QueryProductsRequest, QueryProductsResponse, Product> context,
        QueryProductsResponse response) {
      return new QueryProductsPage(context, response);
    }

    @Override
    public ApiFuture<QueryProductsPage> createPageAsync(
        PageContext<QueryProductsRequest, QueryProductsResponse, Product> context,
        ApiFuture<QueryProductsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class QueryProductsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          QueryProductsRequest,
          QueryProductsResponse,
          Product,
          QueryProductsPage,
          QueryProductsFixedSizeCollection> {

    private QueryProductsFixedSizeCollection(List<QueryProductsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static QueryProductsFixedSizeCollection createEmptyCollection() {
      return new QueryProductsFixedSizeCollection(null, 0);
    }

    @Override
    protected QueryProductsFixedSizeCollection createCollection(
        List<QueryProductsPage> pages, int collectionSize) {
      return new QueryProductsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class AggregateFleetPagedResponse
      extends AbstractPagedListResponse<
          AggregateFleetRequest,
          AggregateFleetResponse,
          AggregateFleetRow,
          AggregateFleetPage,
          AggregateFleetFixedSizeCollection> {

    public static ApiFuture<AggregateFleetPagedResponse> createAsync(
        PageContext<AggregateFleetRequest, AggregateFleetResponse, AggregateFleetRow> context,
        ApiFuture<AggregateFleetResponse> futureResponse) {
      ApiFuture<AggregateFleetPage> futurePage =
          AggregateFleetPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AggregateFleetPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private AggregateFleetPagedResponse(AggregateFleetPage page) {
      super(page, AggregateFleetFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregateFleetPage
      extends AbstractPage<
          AggregateFleetRequest, AggregateFleetResponse, AggregateFleetRow, AggregateFleetPage> {

    private AggregateFleetPage(
        PageContext<AggregateFleetRequest, AggregateFleetResponse, AggregateFleetRow> context,
        AggregateFleetResponse response) {
      super(context, response);
    }

    private static AggregateFleetPage createEmptyPage() {
      return new AggregateFleetPage(null, null);
    }

    @Override
    protected AggregateFleetPage createPage(
        PageContext<AggregateFleetRequest, AggregateFleetResponse, AggregateFleetRow> context,
        AggregateFleetResponse response) {
      return new AggregateFleetPage(context, response);
    }

    @Override
    public ApiFuture<AggregateFleetPage> createPageAsync(
        PageContext<AggregateFleetRequest, AggregateFleetResponse, AggregateFleetRow> context,
        ApiFuture<AggregateFleetResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregateFleetFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregateFleetRequest,
          AggregateFleetResponse,
          AggregateFleetRow,
          AggregateFleetPage,
          AggregateFleetFixedSizeCollection> {

    private AggregateFleetFixedSizeCollection(List<AggregateFleetPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregateFleetFixedSizeCollection createEmptyCollection() {
      return new AggregateFleetFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregateFleetFixedSizeCollection createCollection(
        List<AggregateFleetPage> pages, int collectionSize) {
      return new AggregateFleetFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class QueryDatabaseResourceGroupsPagedResponse
      extends AbstractPagedListResponse<
          QueryDatabaseResourceGroupsRequest,
          QueryDatabaseResourceGroupsResponse,
          DatabaseResourceGroup,
          QueryDatabaseResourceGroupsPage,
          QueryDatabaseResourceGroupsFixedSizeCollection> {

    public static ApiFuture<QueryDatabaseResourceGroupsPagedResponse> createAsync(
        PageContext<
                QueryDatabaseResourceGroupsRequest,
                QueryDatabaseResourceGroupsResponse,
                DatabaseResourceGroup>
            context,
        ApiFuture<QueryDatabaseResourceGroupsResponse> futureResponse) {
      ApiFuture<QueryDatabaseResourceGroupsPage> futurePage =
          QueryDatabaseResourceGroupsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new QueryDatabaseResourceGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private QueryDatabaseResourceGroupsPagedResponse(QueryDatabaseResourceGroupsPage page) {
      super(page, QueryDatabaseResourceGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class QueryDatabaseResourceGroupsPage
      extends AbstractPage<
          QueryDatabaseResourceGroupsRequest,
          QueryDatabaseResourceGroupsResponse,
          DatabaseResourceGroup,
          QueryDatabaseResourceGroupsPage> {

    private QueryDatabaseResourceGroupsPage(
        PageContext<
                QueryDatabaseResourceGroupsRequest,
                QueryDatabaseResourceGroupsResponse,
                DatabaseResourceGroup>
            context,
        QueryDatabaseResourceGroupsResponse response) {
      super(context, response);
    }

    private static QueryDatabaseResourceGroupsPage createEmptyPage() {
      return new QueryDatabaseResourceGroupsPage(null, null);
    }

    @Override
    protected QueryDatabaseResourceGroupsPage createPage(
        PageContext<
                QueryDatabaseResourceGroupsRequest,
                QueryDatabaseResourceGroupsResponse,
                DatabaseResourceGroup>
            context,
        QueryDatabaseResourceGroupsResponse response) {
      return new QueryDatabaseResourceGroupsPage(context, response);
    }

    @Override
    public ApiFuture<QueryDatabaseResourceGroupsPage> createPageAsync(
        PageContext<
                QueryDatabaseResourceGroupsRequest,
                QueryDatabaseResourceGroupsResponse,
                DatabaseResourceGroup>
            context,
        ApiFuture<QueryDatabaseResourceGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class QueryDatabaseResourceGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          QueryDatabaseResourceGroupsRequest,
          QueryDatabaseResourceGroupsResponse,
          DatabaseResourceGroup,
          QueryDatabaseResourceGroupsPage,
          QueryDatabaseResourceGroupsFixedSizeCollection> {

    private QueryDatabaseResourceGroupsFixedSizeCollection(
        List<QueryDatabaseResourceGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static QueryDatabaseResourceGroupsFixedSizeCollection createEmptyCollection() {
      return new QueryDatabaseResourceGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected QueryDatabaseResourceGroupsFixedSizeCollection createCollection(
        List<QueryDatabaseResourceGroupsPage> pages, int collectionSize) {
      return new QueryDatabaseResourceGroupsFixedSizeCollection(pages, collectionSize);
    }
  }
}
