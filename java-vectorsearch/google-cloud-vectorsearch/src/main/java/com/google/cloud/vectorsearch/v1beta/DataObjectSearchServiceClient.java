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

package com.google.cloud.vectorsearch.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vectorsearch.v1beta.stub.DataObjectSearchServiceStub;
import com.google.cloud.vectorsearch.v1beta.stub.DataObjectSearchServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for searching data objects.
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
 * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
 *     DataObjectSearchServiceClient.create()) {
 *   AggregateDataObjectsRequest request =
 *       AggregateDataObjectsRequest.newBuilder()
 *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
 *           .setFilter(Struct.newBuilder().build())
 *           .setAggregate(AggregationMethod.forNumber(0))
 *           .build();
 *   AggregateDataObjectsResponse response =
 *       dataObjectSearchServiceClient.aggregateDataObjects(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataObjectSearchServiceClient object to clean up
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
 *      <td><p> SearchDataObjects</td>
 *      <td><p> Searches data objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchDataObjects(SearchDataObjectsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchDataObjectsPagedCallable()
 *           <li><p> searchDataObjectsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryDataObjects</td>
 *      <td><p> Queries data objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryDataObjects(QueryDataObjectsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryDataObjectsPagedCallable()
 *           <li><p> queryDataObjectsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AggregateDataObjects</td>
 *      <td><p> Aggregates data objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> aggregateDataObjects(AggregateDataObjectsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> aggregateDataObjectsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchSearchDataObjects</td>
 *      <td><p> Batch searches data objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchSearchDataObjects(BatchSearchDataObjectsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchSearchDataObjectsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
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
 * DataObjectSearchServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataObjectSearchServiceSettings dataObjectSearchServiceSettings =
 *     DataObjectSearchServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataObjectSearchServiceClient dataObjectSearchServiceClient =
 *     DataObjectSearchServiceClient.create(dataObjectSearchServiceSettings);
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
 * DataObjectSearchServiceSettings dataObjectSearchServiceSettings =
 *     DataObjectSearchServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataObjectSearchServiceClient dataObjectSearchServiceClient =
 *     DataObjectSearchServiceClient.create(dataObjectSearchServiceSettings);
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
 * DataObjectSearchServiceSettings dataObjectSearchServiceSettings =
 *     DataObjectSearchServiceSettings.newHttpJsonBuilder().build();
 * DataObjectSearchServiceClient dataObjectSearchServiceClient =
 *     DataObjectSearchServiceClient.create(dataObjectSearchServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataObjectSearchServiceClient implements BackgroundResource {
  private final DataObjectSearchServiceSettings settings;
  private final DataObjectSearchServiceStub stub;

  /** Constructs an instance of DataObjectSearchServiceClient with default settings. */
  public static final DataObjectSearchServiceClient create() throws IOException {
    return create(DataObjectSearchServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataObjectSearchServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataObjectSearchServiceClient create(DataObjectSearchServiceSettings settings)
      throws IOException {
    return new DataObjectSearchServiceClient(settings);
  }

  /**
   * Constructs an instance of DataObjectSearchServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(DataObjectSearchServiceSettings).
   */
  public static final DataObjectSearchServiceClient create(DataObjectSearchServiceStub stub) {
    return new DataObjectSearchServiceClient(stub);
  }

  /**
   * Constructs an instance of DataObjectSearchServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DataObjectSearchServiceClient(DataObjectSearchServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((DataObjectSearchServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DataObjectSearchServiceClient(DataObjectSearchServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DataObjectSearchServiceSettings getSettings() {
    return settings;
  }

  public DataObjectSearchServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches data objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
   *     DataObjectSearchServiceClient.create()) {
   *   SearchDataObjectsRequest request =
   *       SearchDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SearchResult element :
   *       dataObjectSearchServiceClient.searchDataObjects(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchDataObjectsPagedResponse searchDataObjects(SearchDataObjectsRequest request) {
    return searchDataObjectsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches data objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
   *     DataObjectSearchServiceClient.create()) {
   *   SearchDataObjectsRequest request =
   *       SearchDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SearchResult> future =
   *       dataObjectSearchServiceClient.searchDataObjectsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchDataObjectsRequest, SearchDataObjectsPagedResponse>
      searchDataObjectsPagedCallable() {
    return stub.searchDataObjectsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches data objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
   *     DataObjectSearchServiceClient.create()) {
   *   SearchDataObjectsRequest request =
   *       SearchDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchDataObjectsResponse response =
   *         dataObjectSearchServiceClient.searchDataObjectsCallable().call(request);
   *     for (SearchResult element : response.getResultsList()) {
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
  public final UnaryCallable<SearchDataObjectsRequest, SearchDataObjectsResponse>
      searchDataObjectsCallable() {
    return stub.searchDataObjectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries data objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
   *     DataObjectSearchServiceClient.create()) {
   *   QueryDataObjectsRequest request =
   *       QueryDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setFilter(Struct.newBuilder().build())
   *           .setOutputFields(OutputFields.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DataObject element :
   *       dataObjectSearchServiceClient.queryDataObjects(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryDataObjectsPagedResponse queryDataObjects(QueryDataObjectsRequest request) {
    return queryDataObjectsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries data objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
   *     DataObjectSearchServiceClient.create()) {
   *   QueryDataObjectsRequest request =
   *       QueryDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setFilter(Struct.newBuilder().build())
   *           .setOutputFields(OutputFields.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DataObject> future =
   *       dataObjectSearchServiceClient.queryDataObjectsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataObject element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryDataObjectsRequest, QueryDataObjectsPagedResponse>
      queryDataObjectsPagedCallable() {
    return stub.queryDataObjectsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries data objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
   *     DataObjectSearchServiceClient.create()) {
   *   QueryDataObjectsRequest request =
   *       QueryDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setFilter(Struct.newBuilder().build())
   *           .setOutputFields(OutputFields.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     QueryDataObjectsResponse response =
   *         dataObjectSearchServiceClient.queryDataObjectsCallable().call(request);
   *     for (DataObject element : response.getDataObjectsList()) {
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
  public final UnaryCallable<QueryDataObjectsRequest, QueryDataObjectsResponse>
      queryDataObjectsCallable() {
    return stub.queryDataObjectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Aggregates data objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
   *     DataObjectSearchServiceClient.create()) {
   *   AggregateDataObjectsRequest request =
   *       AggregateDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setFilter(Struct.newBuilder().build())
   *           .setAggregate(AggregationMethod.forNumber(0))
   *           .build();
   *   AggregateDataObjectsResponse response =
   *       dataObjectSearchServiceClient.aggregateDataObjects(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregateDataObjectsResponse aggregateDataObjects(
      AggregateDataObjectsRequest request) {
    return aggregateDataObjectsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Aggregates data objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
   *     DataObjectSearchServiceClient.create()) {
   *   AggregateDataObjectsRequest request =
   *       AggregateDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setFilter(Struct.newBuilder().build())
   *           .setAggregate(AggregationMethod.forNumber(0))
   *           .build();
   *   ApiFuture<AggregateDataObjectsResponse> future =
   *       dataObjectSearchServiceClient.aggregateDataObjectsCallable().futureCall(request);
   *   // Do something.
   *   AggregateDataObjectsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregateDataObjectsRequest, AggregateDataObjectsResponse>
      aggregateDataObjectsCallable() {
    return stub.aggregateDataObjectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch searches data objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
   *     DataObjectSearchServiceClient.create()) {
   *   BatchSearchDataObjectsRequest request =
   *       BatchSearchDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .addAllSearches(new ArrayList<Search>())
   *           .setCombine(BatchSearchDataObjectsRequest.CombineResultsOptions.newBuilder().build())
   *           .build();
   *   BatchSearchDataObjectsResponse response =
   *       dataObjectSearchServiceClient.batchSearchDataObjects(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchSearchDataObjectsResponse batchSearchDataObjects(
      BatchSearchDataObjectsRequest request) {
    return batchSearchDataObjectsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch searches data objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
   *     DataObjectSearchServiceClient.create()) {
   *   BatchSearchDataObjectsRequest request =
   *       BatchSearchDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .addAllSearches(new ArrayList<Search>())
   *           .setCombine(BatchSearchDataObjectsRequest.CombineResultsOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<BatchSearchDataObjectsResponse> future =
   *       dataObjectSearchServiceClient.batchSearchDataObjectsCallable().futureCall(request);
   *   // Do something.
   *   BatchSearchDataObjectsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchSearchDataObjectsRequest, BatchSearchDataObjectsResponse>
      batchSearchDataObjectsCallable() {
    return stub.batchSearchDataObjectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
   *     DataObjectSearchServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : dataObjectSearchServiceClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
   *     DataObjectSearchServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       dataObjectSearchServiceClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
   *     DataObjectSearchServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         dataObjectSearchServiceClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
   *     DataObjectSearchServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = dataObjectSearchServiceClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
   *     DataObjectSearchServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       dataObjectSearchServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class SearchDataObjectsPagedResponse
      extends AbstractPagedListResponse<
          SearchDataObjectsRequest,
          SearchDataObjectsResponse,
          SearchResult,
          SearchDataObjectsPage,
          SearchDataObjectsFixedSizeCollection> {

    public static ApiFuture<SearchDataObjectsPagedResponse> createAsync(
        PageContext<SearchDataObjectsRequest, SearchDataObjectsResponse, SearchResult> context,
        ApiFuture<SearchDataObjectsResponse> futureResponse) {
      ApiFuture<SearchDataObjectsPage> futurePage =
          SearchDataObjectsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchDataObjectsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchDataObjectsPagedResponse(SearchDataObjectsPage page) {
      super(page, SearchDataObjectsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchDataObjectsPage
      extends AbstractPage<
          SearchDataObjectsRequest,
          SearchDataObjectsResponse,
          SearchResult,
          SearchDataObjectsPage> {

    private SearchDataObjectsPage(
        PageContext<SearchDataObjectsRequest, SearchDataObjectsResponse, SearchResult> context,
        SearchDataObjectsResponse response) {
      super(context, response);
    }

    private static SearchDataObjectsPage createEmptyPage() {
      return new SearchDataObjectsPage(null, null);
    }

    @Override
    protected SearchDataObjectsPage createPage(
        PageContext<SearchDataObjectsRequest, SearchDataObjectsResponse, SearchResult> context,
        SearchDataObjectsResponse response) {
      return new SearchDataObjectsPage(context, response);
    }

    @Override
    public ApiFuture<SearchDataObjectsPage> createPageAsync(
        PageContext<SearchDataObjectsRequest, SearchDataObjectsResponse, SearchResult> context,
        ApiFuture<SearchDataObjectsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchDataObjectsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchDataObjectsRequest,
          SearchDataObjectsResponse,
          SearchResult,
          SearchDataObjectsPage,
          SearchDataObjectsFixedSizeCollection> {

    private SearchDataObjectsFixedSizeCollection(
        List<SearchDataObjectsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchDataObjectsFixedSizeCollection createEmptyCollection() {
      return new SearchDataObjectsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchDataObjectsFixedSizeCollection createCollection(
        List<SearchDataObjectsPage> pages, int collectionSize) {
      return new SearchDataObjectsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class QueryDataObjectsPagedResponse
      extends AbstractPagedListResponse<
          QueryDataObjectsRequest,
          QueryDataObjectsResponse,
          DataObject,
          QueryDataObjectsPage,
          QueryDataObjectsFixedSizeCollection> {

    public static ApiFuture<QueryDataObjectsPagedResponse> createAsync(
        PageContext<QueryDataObjectsRequest, QueryDataObjectsResponse, DataObject> context,
        ApiFuture<QueryDataObjectsResponse> futureResponse) {
      ApiFuture<QueryDataObjectsPage> futurePage =
          QueryDataObjectsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new QueryDataObjectsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private QueryDataObjectsPagedResponse(QueryDataObjectsPage page) {
      super(page, QueryDataObjectsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class QueryDataObjectsPage
      extends AbstractPage<
          QueryDataObjectsRequest, QueryDataObjectsResponse, DataObject, QueryDataObjectsPage> {

    private QueryDataObjectsPage(
        PageContext<QueryDataObjectsRequest, QueryDataObjectsResponse, DataObject> context,
        QueryDataObjectsResponse response) {
      super(context, response);
    }

    private static QueryDataObjectsPage createEmptyPage() {
      return new QueryDataObjectsPage(null, null);
    }

    @Override
    protected QueryDataObjectsPage createPage(
        PageContext<QueryDataObjectsRequest, QueryDataObjectsResponse, DataObject> context,
        QueryDataObjectsResponse response) {
      return new QueryDataObjectsPage(context, response);
    }

    @Override
    public ApiFuture<QueryDataObjectsPage> createPageAsync(
        PageContext<QueryDataObjectsRequest, QueryDataObjectsResponse, DataObject> context,
        ApiFuture<QueryDataObjectsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class QueryDataObjectsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          QueryDataObjectsRequest,
          QueryDataObjectsResponse,
          DataObject,
          QueryDataObjectsPage,
          QueryDataObjectsFixedSizeCollection> {

    private QueryDataObjectsFixedSizeCollection(
        List<QueryDataObjectsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static QueryDataObjectsFixedSizeCollection createEmptyCollection() {
      return new QueryDataObjectsFixedSizeCollection(null, 0);
    }

    @Override
    protected QueryDataObjectsFixedSizeCollection createCollection(
        List<QueryDataObjectsPage> pages, int collectionSize) {
      return new QueryDataObjectsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
