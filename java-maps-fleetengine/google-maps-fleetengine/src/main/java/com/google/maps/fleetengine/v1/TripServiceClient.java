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

package google.maps.fleetengine.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import google.maps.fleetengine.v1.stub.TripServiceStub;
import google.maps.fleetengine.v1.stub.TripServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Trip management service.
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
 * try (TripServiceClient tripServiceClient = TripServiceClient.create()) {
 *   CreateTripRequest request =
 *       CreateTripRequest.newBuilder()
 *           .setHeader(RequestHeader.newBuilder().build())
 *           .setParent(TripName.of("[PROVIDER]", "[TRIP]").toString())
 *           .setTripId("tripId-865466336")
 *           .setTrip(Trip.newBuilder().build())
 *           .build();
 *   Trip response = tripServiceClient.createTrip(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TripServiceClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of TripServiceSettings to
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
 * TripServiceSettings tripServiceSettings =
 *     TripServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TripServiceClient tripServiceClient = TripServiceClient.create(tripServiceSettings);
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
 * TripServiceSettings tripServiceSettings =
 *     TripServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TripServiceClient tripServiceClient = TripServiceClient.create(tripServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TripServiceClient implements BackgroundResource {
  private final TripServiceSettings settings;
  private final TripServiceStub stub;

  /** Constructs an instance of TripServiceClient with default settings. */
  public static final TripServiceClient create() throws IOException {
    return create(TripServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TripServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TripServiceClient create(TripServiceSettings settings) throws IOException {
    return new TripServiceClient(settings);
  }

  /**
   * Constructs an instance of TripServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(TripServiceSettings).
   */
  public static final TripServiceClient create(TripServiceStub stub) {
    return new TripServiceClient(stub);
  }

  /**
   * Constructs an instance of TripServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TripServiceClient(TripServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TripServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected TripServiceClient(TripServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TripServiceSettings getSettings() {
    return settings;
  }

  public TripServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a trip in the Fleet Engine and returns the new trip.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TripServiceClient tripServiceClient = TripServiceClient.create()) {
   *   CreateTripRequest request =
   *       CreateTripRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setParent(TripName.of("[PROVIDER]", "[TRIP]").toString())
   *           .setTripId("tripId-865466336")
   *           .setTrip(Trip.newBuilder().build())
   *           .build();
   *   Trip response = tripServiceClient.createTrip(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trip createTrip(CreateTripRequest request) {
    return createTripCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a trip in the Fleet Engine and returns the new trip.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TripServiceClient tripServiceClient = TripServiceClient.create()) {
   *   CreateTripRequest request =
   *       CreateTripRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setParent(TripName.of("[PROVIDER]", "[TRIP]").toString())
   *           .setTripId("tripId-865466336")
   *           .setTrip(Trip.newBuilder().build())
   *           .build();
   *   ApiFuture<Trip> future = tripServiceClient.createTripCallable().futureCall(request);
   *   // Do something.
   *   Trip response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTripRequest, Trip> createTripCallable() {
    return stub.createTripCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get information about a single trip.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TripServiceClient tripServiceClient = TripServiceClient.create()) {
   *   GetTripRequest request =
   *       GetTripRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setName(TripName.of("[PROVIDER]", "[TRIP]").toString())
   *           .setView(TripView.forNumber(0))
   *           .setCurrentRouteSegmentVersion(Timestamp.newBuilder().build())
   *           .setRemainingWaypointsVersion(Timestamp.newBuilder().build())
   *           .setRouteFormatType(PolylineFormatType.forNumber(0))
   *           .setCurrentRouteSegmentTrafficVersion(Timestamp.newBuilder().build())
   *           .setRemainingWaypointsRouteVersion(Timestamp.newBuilder().build())
   *           .build();
   *   Trip response = tripServiceClient.getTrip(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trip getTrip(GetTripRequest request) {
    return getTripCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get information about a single trip.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TripServiceClient tripServiceClient = TripServiceClient.create()) {
   *   GetTripRequest request =
   *       GetTripRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setName(TripName.of("[PROVIDER]", "[TRIP]").toString())
   *           .setView(TripView.forNumber(0))
   *           .setCurrentRouteSegmentVersion(Timestamp.newBuilder().build())
   *           .setRemainingWaypointsVersion(Timestamp.newBuilder().build())
   *           .setRouteFormatType(PolylineFormatType.forNumber(0))
   *           .setCurrentRouteSegmentTrafficVersion(Timestamp.newBuilder().build())
   *           .setRemainingWaypointsRouteVersion(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<Trip> future = tripServiceClient.getTripCallable().futureCall(request);
   *   // Do something.
   *   Trip response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTripRequest, Trip> getTripCallable() {
    return stub.getTripCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report billable trip usage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TripServiceClient tripServiceClient = TripServiceClient.create()) {
   *   ReportBillableTripRequest request =
   *       ReportBillableTripRequest.newBuilder()
   *           .setName("name3373707")
   *           .setCountryCode("countryCode-1477067101")
   *           .setPlatform(BillingPlatformIdentifier.forNumber(0))
   *           .addAllRelatedIds(new ArrayList<String>())
   *           .build();
   *   tripServiceClient.reportBillableTrip(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void reportBillableTrip(ReportBillableTripRequest request) {
    reportBillableTripCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report billable trip usage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TripServiceClient tripServiceClient = TripServiceClient.create()) {
   *   ReportBillableTripRequest request =
   *       ReportBillableTripRequest.newBuilder()
   *           .setName("name3373707")
   *           .setCountryCode("countryCode-1477067101")
   *           .setPlatform(BillingPlatformIdentifier.forNumber(0))
   *           .addAllRelatedIds(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Empty> future = tripServiceClient.reportBillableTripCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReportBillableTripRequest, Empty> reportBillableTripCallable() {
    return stub.reportBillableTripCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get all the trips for a specific vehicle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TripServiceClient tripServiceClient = TripServiceClient.create()) {
   *   SearchTripsRequest request =
   *       SearchTripsRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setVehicleId("vehicleId-1984135833")
   *           .setActiveTripsOnly(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setMinimumStaleness(Duration.newBuilder().build())
   *           .build();
   *   for (Trip element : tripServiceClient.searchTrips(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchTripsPagedResponse searchTrips(SearchTripsRequest request) {
    return searchTripsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get all the trips for a specific vehicle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TripServiceClient tripServiceClient = TripServiceClient.create()) {
   *   SearchTripsRequest request =
   *       SearchTripsRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setVehicleId("vehicleId-1984135833")
   *           .setActiveTripsOnly(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setMinimumStaleness(Duration.newBuilder().build())
   *           .build();
   *   ApiFuture<Trip> future = tripServiceClient.searchTripsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Trip element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchTripsRequest, SearchTripsPagedResponse>
      searchTripsPagedCallable() {
    return stub.searchTripsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get all the trips for a specific vehicle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TripServiceClient tripServiceClient = TripServiceClient.create()) {
   *   SearchTripsRequest request =
   *       SearchTripsRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setVehicleId("vehicleId-1984135833")
   *           .setActiveTripsOnly(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setMinimumStaleness(Duration.newBuilder().build())
   *           .build();
   *   while (true) {
   *     SearchTripsResponse response = tripServiceClient.searchTripsCallable().call(request);
   *     for (Trip element : response.getTripsList()) {
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
  public final UnaryCallable<SearchTripsRequest, SearchTripsResponse> searchTripsCallable() {
    return stub.searchTripsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates trip data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TripServiceClient tripServiceClient = TripServiceClient.create()) {
   *   UpdateTripRequest request =
   *       UpdateTripRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setName("name3373707")
   *           .setTrip(Trip.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Trip response = tripServiceClient.updateTrip(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trip updateTrip(UpdateTripRequest request) {
    return updateTripCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates trip data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TripServiceClient tripServiceClient = TripServiceClient.create()) {
   *   UpdateTripRequest request =
   *       UpdateTripRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setName("name3373707")
   *           .setTrip(Trip.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Trip> future = tripServiceClient.updateTripCallable().futureCall(request);
   *   // Do something.
   *   Trip response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTripRequest, Trip> updateTripCallable() {
    return stub.updateTripCallable();
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

  public static class SearchTripsPagedResponse
      extends AbstractPagedListResponse<
          SearchTripsRequest,
          SearchTripsResponse,
          Trip,
          SearchTripsPage,
          SearchTripsFixedSizeCollection> {

    public static ApiFuture<SearchTripsPagedResponse> createAsync(
        PageContext<SearchTripsRequest, SearchTripsResponse, Trip> context,
        ApiFuture<SearchTripsResponse> futureResponse) {
      ApiFuture<SearchTripsPage> futurePage =
          SearchTripsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new SearchTripsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private SearchTripsPagedResponse(SearchTripsPage page) {
      super(page, SearchTripsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchTripsPage
      extends AbstractPage<SearchTripsRequest, SearchTripsResponse, Trip, SearchTripsPage> {

    private SearchTripsPage(
        PageContext<SearchTripsRequest, SearchTripsResponse, Trip> context,
        SearchTripsResponse response) {
      super(context, response);
    }

    private static SearchTripsPage createEmptyPage() {
      return new SearchTripsPage(null, null);
    }

    @Override
    protected SearchTripsPage createPage(
        PageContext<SearchTripsRequest, SearchTripsResponse, Trip> context,
        SearchTripsResponse response) {
      return new SearchTripsPage(context, response);
    }

    @Override
    public ApiFuture<SearchTripsPage> createPageAsync(
        PageContext<SearchTripsRequest, SearchTripsResponse, Trip> context,
        ApiFuture<SearchTripsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchTripsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchTripsRequest,
          SearchTripsResponse,
          Trip,
          SearchTripsPage,
          SearchTripsFixedSizeCollection> {

    private SearchTripsFixedSizeCollection(List<SearchTripsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchTripsFixedSizeCollection createEmptyCollection() {
      return new SearchTripsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchTripsFixedSizeCollection createCollection(
        List<SearchTripsPage> pages, int collectionSize) {
      return new SearchTripsFixedSizeCollection(pages, collectionSize);
    }
  }
}
