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

package com.google.maps.navconnect.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.maps.navconnect.v1.stub.NavConnectServiceStub;
import com.google.maps.navconnect.v1.stub.NavConnectServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for NavConnect clients to create and get trips.
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
 * try (NavConnectServiceClient navConnectServiceClient = NavConnectServiceClient.create()) {
 *   String parent = "parent-995424086";
 *   Trip trip = Trip.newBuilder().build();
 *   String tripId = "tripId-865466336";
 *   Trip response = navConnectServiceClient.createTrip(parent, trip, tripId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NavConnectServiceClient object to clean up resources
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
 *      <td><p> CreateTrip</td>
 *      <td><p> Creates a trip. This must be called before the mobile application can start the trip. The returned trip will have the `auth_token` field set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTrip(CreateTripRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTrip(String parent, Trip trip, String tripId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTripCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTrip</td>
 *      <td><p> Gets a trip.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTrip(GetTripRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTrip(TripName name)
 *           <li><p> getTrip(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTripCallable()
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
 * <p>This class can be customized by passing in a custom instance of NavConnectServiceSettings to
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
 * NavConnectServiceSettings navConnectServiceSettings =
 *     NavConnectServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NavConnectServiceClient navConnectServiceClient =
 *     NavConnectServiceClient.create(navConnectServiceSettings);
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
 * NavConnectServiceSettings navConnectServiceSettings =
 *     NavConnectServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NavConnectServiceClient navConnectServiceClient =
 *     NavConnectServiceClient.create(navConnectServiceSettings);
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
 * NavConnectServiceSettings navConnectServiceSettings =
 *     NavConnectServiceSettings.newHttpJsonBuilder().build();
 * NavConnectServiceClient navConnectServiceClient =
 *     NavConnectServiceClient.create(navConnectServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class NavConnectServiceClient implements BackgroundResource {
  private final NavConnectServiceSettings settings;
  private final NavConnectServiceStub stub;

  /** Constructs an instance of NavConnectServiceClient with default settings. */
  public static final NavConnectServiceClient create() throws IOException {
    return create(NavConnectServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NavConnectServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NavConnectServiceClient create(NavConnectServiceSettings settings)
      throws IOException {
    return new NavConnectServiceClient(settings);
  }

  /**
   * Constructs an instance of NavConnectServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(NavConnectServiceSettings).
   */
  public static final NavConnectServiceClient create(NavConnectServiceStub stub) {
    return new NavConnectServiceClient(stub);
  }

  /**
   * Constructs an instance of NavConnectServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected NavConnectServiceClient(NavConnectServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NavConnectServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected NavConnectServiceClient(NavConnectServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NavConnectServiceSettings getSettings() {
    return settings;
  }

  public NavConnectServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a trip. This must be called before the mobile application can start the trip. The
   * returned trip will have the `auth_token` field set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NavConnectServiceClient navConnectServiceClient = NavConnectServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   Trip trip = Trip.newBuilder().build();
   *   String tripId = "tripId-865466336";
   *   Trip response = navConnectServiceClient.createTrip(parent, trip, tripId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource under which this trip will be created. Format:
   *     projects/{project_number}
   * @param trip Required. The trip to create.
   * @param tripId Required. The ID to use for the trip, which will become the final component of
   *     the trip's resource name.
   *     <p>This value must be a valid RFC-4122 UUID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trip createTrip(String parent, Trip trip, String tripId) {
    CreateTripRequest request =
        CreateTripRequest.newBuilder().setParent(parent).setTrip(trip).setTripId(tripId).build();
    return createTrip(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a trip. This must be called before the mobile application can start the trip. The
   * returned trip will have the `auth_token` field set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NavConnectServiceClient navConnectServiceClient = NavConnectServiceClient.create()) {
   *   CreateTripRequest request =
   *       CreateTripRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setTripId("tripId-865466336")
   *           .setTrip(Trip.newBuilder().build())
   *           .build();
   *   Trip response = navConnectServiceClient.createTrip(request);
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
   * Creates a trip. This must be called before the mobile application can start the trip. The
   * returned trip will have the `auth_token` field set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NavConnectServiceClient navConnectServiceClient = NavConnectServiceClient.create()) {
   *   CreateTripRequest request =
   *       CreateTripRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setTripId("tripId-865466336")
   *           .setTrip(Trip.newBuilder().build())
   *           .build();
   *   ApiFuture<Trip> future = navConnectServiceClient.createTripCallable().futureCall(request);
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
   * Gets a trip.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NavConnectServiceClient navConnectServiceClient = NavConnectServiceClient.create()) {
   *   TripName name = TripName.of("[PROJECT]", "[TRIP]");
   *   Trip response = navConnectServiceClient.getTrip(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the trip to get. Format:
   *     projects/{project}/trips/{trip_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trip getTrip(TripName name) {
    GetTripRequest request =
        GetTripRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTrip(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a trip.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NavConnectServiceClient navConnectServiceClient = NavConnectServiceClient.create()) {
   *   String name = TripName.of("[PROJECT]", "[TRIP]").toString();
   *   Trip response = navConnectServiceClient.getTrip(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the trip to get. Format:
   *     projects/{project}/trips/{trip_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trip getTrip(String name) {
    GetTripRequest request = GetTripRequest.newBuilder().setName(name).build();
    return getTrip(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a trip.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NavConnectServiceClient navConnectServiceClient = NavConnectServiceClient.create()) {
   *   GetTripRequest request =
   *       GetTripRequest.newBuilder()
   *           .setName(TripName.of("[PROJECT]", "[TRIP]").toString())
   *           .build();
   *   Trip response = navConnectServiceClient.getTrip(request);
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
   * Gets a trip.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NavConnectServiceClient navConnectServiceClient = NavConnectServiceClient.create()) {
   *   GetTripRequest request =
   *       GetTripRequest.newBuilder()
   *           .setName(TripName.of("[PROJECT]", "[TRIP]").toString())
   *           .build();
   *   ApiFuture<Trip> future = navConnectServiceClient.getTripCallable().futureCall(request);
   *   // Do something.
   *   Trip response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTripRequest, Trip> getTripCallable() {
    return stub.getTripCallable();
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
}
