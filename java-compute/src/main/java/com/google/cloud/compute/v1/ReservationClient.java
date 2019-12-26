/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.ReservationStub;
import com.google.cloud.compute.v1.stub.ReservationStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ReservationClient reservationClient = ReservationClient.create()) {
 *   ProjectZoneReservationName reservation = ProjectZoneReservationName.of("[PROJECT]", "[ZONE]", "[RESERVATION]");
 *   Operation response = reservationClient.deleteReservation(reservation);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the reservationClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of ReservationSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ReservationSettings reservationSettings =
 *     ReservationSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReservationClient reservationClient =
 *     ReservationClient.create(reservationSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ReservationSettings reservationSettings =
 *     ReservationSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ReservationClient reservationClient =
 *     ReservationClient.create(reservationSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ReservationClient implements BackgroundResource {
  private final ReservationSettings settings;
  private final ReservationStub stub;

  /** Constructs an instance of ReservationClient with default settings. */
  public static final ReservationClient create() throws IOException {
    return create(ReservationSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ReservationClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ReservationClient create(ReservationSettings settings) throws IOException {
    return new ReservationClient(settings);
  }

  /**
   * Constructs an instance of ReservationClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use ReservationSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ReservationClient create(ReservationStub stub) {
    return new ReservationClient(stub);
  }

  /**
   * Constructs an instance of ReservationClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ReservationClient(ReservationSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ReservationStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ReservationClient(ReservationStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ReservationSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ReservationStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of reservations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (ReservationsScopedList element : reservationClient.aggregatedListReservations(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListReservationsPagedResponse aggregatedListReservations(
      ProjectName project) {
    AggregatedListReservationsHttpRequest request =
        AggregatedListReservationsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListReservations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of reservations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (ReservationsScopedList element : reservationClient.aggregatedListReservations(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListReservationsPagedResponse aggregatedListReservations(String project) {
    AggregatedListReservationsHttpRequest request =
        AggregatedListReservationsHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListReservations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of reservations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListReservationsHttpRequest request = AggregatedListReservationsHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   for (ReservationsScopedList element : reservationClient.aggregatedListReservations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListReservationsPagedResponse aggregatedListReservations(
      AggregatedListReservationsHttpRequest request) {
    return aggregatedListReservationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of reservations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListReservationsHttpRequest request = AggregatedListReservationsHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;AggregatedListReservationsPagedResponse&gt; future = reservationClient.aggregatedListReservationsPagedCallable().futureCall(request);
   *   // Do something
   *   for (ReservationsScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListReservationsHttpRequest, AggregatedListReservationsPagedResponse>
      aggregatedListReservationsPagedCallable() {
    return stub.aggregatedListReservationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of reservations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListReservationsHttpRequest request = AggregatedListReservationsHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     ReservationAggregatedList response = reservationClient.aggregatedListReservationsCallable().call(request);
   *     for (ReservationsScopedList element : response.getItemsMap()) {
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
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<AggregatedListReservationsHttpRequest, ReservationAggregatedList>
      aggregatedListReservationsCallable() {
    return stub.aggregatedListReservationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneReservationName reservation = ProjectZoneReservationName.of("[PROJECT]", "[ZONE]", "[RESERVATION]");
   *   Operation response = reservationClient.deleteReservation(reservation);
   * }
   * </code></pre>
   *
   * @param reservation Name of the reservation to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteReservation(ProjectZoneReservationName reservation) {

    DeleteReservationHttpRequest request =
        DeleteReservationHttpRequest.newBuilder()
            .setReservation(reservation == null ? null : reservation.toString())
            .build();
    return deleteReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneReservationName reservation = ProjectZoneReservationName.of("[PROJECT]", "[ZONE]", "[RESERVATION]");
   *   Operation response = reservationClient.deleteReservation(reservation.toString());
   * }
   * </code></pre>
   *
   * @param reservation Name of the reservation to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteReservation(String reservation) {

    DeleteReservationHttpRequest request =
        DeleteReservationHttpRequest.newBuilder().setReservation(reservation).build();
    return deleteReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedReservation = ProjectZoneReservationName.format("[PROJECT]", "[ZONE]", "[RESERVATION]");
   *   DeleteReservationHttpRequest request = DeleteReservationHttpRequest.newBuilder()
   *     .setReservation(formattedReservation)
   *     .build();
   *   Operation response = reservationClient.deleteReservation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteReservation(DeleteReservationHttpRequest request) {
    return deleteReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedReservation = ProjectZoneReservationName.format("[PROJECT]", "[ZONE]", "[RESERVATION]");
   *   DeleteReservationHttpRequest request = DeleteReservationHttpRequest.newBuilder()
   *     .setReservation(formattedReservation)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = reservationClient.deleteReservationCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteReservationHttpRequest, Operation> deleteReservationCallable() {
    return stub.deleteReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves information about the specified reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneReservationName reservation = ProjectZoneReservationName.of("[PROJECT]", "[ZONE]", "[RESERVATION]");
   *   Reservation response = reservationClient.getReservation(reservation);
   * }
   * </code></pre>
   *
   * @param reservation Name of the reservation to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Reservation getReservation(ProjectZoneReservationName reservation) {

    GetReservationHttpRequest request =
        GetReservationHttpRequest.newBuilder()
            .setReservation(reservation == null ? null : reservation.toString())
            .build();
    return getReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves information about the specified reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneReservationName reservation = ProjectZoneReservationName.of("[PROJECT]", "[ZONE]", "[RESERVATION]");
   *   Reservation response = reservationClient.getReservation(reservation.toString());
   * }
   * </code></pre>
   *
   * @param reservation Name of the reservation to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Reservation getReservation(String reservation) {

    GetReservationHttpRequest request =
        GetReservationHttpRequest.newBuilder().setReservation(reservation).build();
    return getReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves information about the specified reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedReservation = ProjectZoneReservationName.format("[PROJECT]", "[ZONE]", "[RESERVATION]");
   *   GetReservationHttpRequest request = GetReservationHttpRequest.newBuilder()
   *     .setReservation(formattedReservation)
   *     .build();
   *   Reservation response = reservationClient.getReservation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Reservation getReservation(GetReservationHttpRequest request) {
    return getReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves information about the specified reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedReservation = ProjectZoneReservationName.format("[PROJECT]", "[ZONE]", "[RESERVATION]");
   *   GetReservationHttpRequest request = GetReservationHttpRequest.newBuilder()
   *     .setReservation(formattedReservation)
   *     .build();
   *   ApiFuture&lt;Reservation&gt; future = reservationClient.getReservationCallable().futureCall(request);
   *   // Do something
   *   Reservation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetReservationHttpRequest, Reservation> getReservationCallable() {
    return stub.getReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneReservationResourceName resource = ProjectZoneReservationResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   Policy response = reservationClient.getIamPolicyReservation(resource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicyReservation(ProjectZoneReservationResourceName resource) {

    GetIamPolicyReservationHttpRequest request =
        GetIamPolicyReservationHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicyReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneReservationResourceName resource = ProjectZoneReservationResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   Policy response = reservationClient.getIamPolicyReservation(resource.toString());
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicyReservation(String resource) {

    GetIamPolicyReservationHttpRequest request =
        GetIamPolicyReservationHttpRequest.newBuilder().setResource(resource).build();
    return getIamPolicyReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedResource = ProjectZoneReservationResourceName.format("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   GetIamPolicyReservationHttpRequest request = GetIamPolicyReservationHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   Policy response = reservationClient.getIamPolicyReservation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicyReservation(GetIamPolicyReservationHttpRequest request) {
    return getIamPolicyReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedResource = ProjectZoneReservationResourceName.format("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   GetIamPolicyReservationHttpRequest request = GetIamPolicyReservationHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = reservationClient.getIamPolicyReservationCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetIamPolicyReservationHttpRequest, Policy>
      getIamPolicyReservationCallable() {
    return stub.getIamPolicyReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new reservation. For more information, read Reserving zonal resources.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   Reservation reservationResource = Reservation.newBuilder().build();
   *   Operation response = reservationClient.insertReservation(zone, reservationResource);
   * }
   * </code></pre>
   *
   * @param zone Name of the zone for this request.
   * @param reservationResource Represents a reservation resource. A reservation ensures that
   *     capacity is held in a specific zone even if the reserved VMs are not running. For more
   *     information, read Reserving zonal resources. (== resource_for beta.reservations ==) (==
   *     resource_for v1.reservations ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertReservation(ProjectZoneName zone, Reservation reservationResource) {

    InsertReservationHttpRequest request =
        InsertReservationHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .setReservationResource(reservationResource)
            .build();
    return insertReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new reservation. For more information, read Reserving zonal resources.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   Reservation reservationResource = Reservation.newBuilder().build();
   *   Operation response = reservationClient.insertReservation(zone.toString(), reservationResource);
   * }
   * </code></pre>
   *
   * @param zone Name of the zone for this request.
   * @param reservationResource Represents a reservation resource. A reservation ensures that
   *     capacity is held in a specific zone even if the reserved VMs are not running. For more
   *     information, read Reserving zonal resources. (== resource_for beta.reservations ==) (==
   *     resource_for v1.reservations ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertReservation(String zone, Reservation reservationResource) {

    InsertReservationHttpRequest request =
        InsertReservationHttpRequest.newBuilder()
            .setZone(zone)
            .setReservationResource(reservationResource)
            .build();
    return insertReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new reservation. For more information, read Reserving zonal resources.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   Reservation reservationResource = Reservation.newBuilder().build();
   *   InsertReservationHttpRequest request = InsertReservationHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .setReservationResource(reservationResource)
   *     .build();
   *   Operation response = reservationClient.insertReservation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertReservation(InsertReservationHttpRequest request) {
    return insertReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new reservation. For more information, read Reserving zonal resources.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   Reservation reservationResource = Reservation.newBuilder().build();
   *   InsertReservationHttpRequest request = InsertReservationHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .setReservationResource(reservationResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = reservationClient.insertReservationCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertReservationHttpRequest, Operation> insertReservationCallable() {
    return stub.insertReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * A list of all the reservations that have been configured for the specified project in specified
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (Reservation element : reservationClient.listReservations(zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone Name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListReservationsPagedResponse listReservations(ProjectZoneName zone) {
    ListReservationsHttpRequest request =
        ListReservationsHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .build();
    return listReservations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * A list of all the reservations that have been configured for the specified project in specified
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (Reservation element : reservationClient.listReservations(zone.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone Name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListReservationsPagedResponse listReservations(String zone) {
    ListReservationsHttpRequest request =
        ListReservationsHttpRequest.newBuilder().setZone(zone).build();
    return listReservations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * A list of all the reservations that have been configured for the specified project in specified
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListReservationsHttpRequest request = ListReservationsHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   for (Reservation element : reservationClient.listReservations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListReservationsPagedResponse listReservations(ListReservationsHttpRequest request) {
    return listReservationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * A list of all the reservations that have been configured for the specified project in specified
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListReservationsHttpRequest request = ListReservationsHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   ApiFuture&lt;ListReservationsPagedResponse&gt; future = reservationClient.listReservationsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Reservation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListReservationsHttpRequest, ListReservationsPagedResponse>
      listReservationsPagedCallable() {
    return stub.listReservationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * A list of all the reservations that have been configured for the specified project in specified
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListReservationsHttpRequest request = ListReservationsHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   while (true) {
   *     ReservationList response = reservationClient.listReservationsCallable().call(request);
   *     for (Reservation element : response.getItemsList()) {
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
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListReservationsHttpRequest, ReservationList>
      listReservationsCallable() {
    return stub.listReservationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the reservation (applicable to standalone reservations only). For more information,
   * read Modifying reservations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneReservationName reservation = ProjectZoneReservationName.of("[PROJECT]", "[ZONE]", "[RESERVATION]");
   *   ReservationsResizeRequest reservationsResizeRequestResource = ReservationsResizeRequest.newBuilder().build();
   *   Operation response = reservationClient.resizeReservation(reservation, reservationsResizeRequestResource);
   * }
   * </code></pre>
   *
   * @param reservation Name of the reservation to update.
   * @param reservationsResizeRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeReservation(
      ProjectZoneReservationName reservation,
      ReservationsResizeRequest reservationsResizeRequestResource) {

    ResizeReservationHttpRequest request =
        ResizeReservationHttpRequest.newBuilder()
            .setReservation(reservation == null ? null : reservation.toString())
            .setReservationsResizeRequestResource(reservationsResizeRequestResource)
            .build();
    return resizeReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the reservation (applicable to standalone reservations only). For more information,
   * read Modifying reservations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneReservationName reservation = ProjectZoneReservationName.of("[PROJECT]", "[ZONE]", "[RESERVATION]");
   *   ReservationsResizeRequest reservationsResizeRequestResource = ReservationsResizeRequest.newBuilder().build();
   *   Operation response = reservationClient.resizeReservation(reservation.toString(), reservationsResizeRequestResource);
   * }
   * </code></pre>
   *
   * @param reservation Name of the reservation to update.
   * @param reservationsResizeRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeReservation(
      String reservation, ReservationsResizeRequest reservationsResizeRequestResource) {

    ResizeReservationHttpRequest request =
        ResizeReservationHttpRequest.newBuilder()
            .setReservation(reservation)
            .setReservationsResizeRequestResource(reservationsResizeRequestResource)
            .build();
    return resizeReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the reservation (applicable to standalone reservations only). For more information,
   * read Modifying reservations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedReservation = ProjectZoneReservationName.format("[PROJECT]", "[ZONE]", "[RESERVATION]");
   *   ReservationsResizeRequest reservationsResizeRequestResource = ReservationsResizeRequest.newBuilder().build();
   *   ResizeReservationHttpRequest request = ResizeReservationHttpRequest.newBuilder()
   *     .setReservation(formattedReservation)
   *     .setReservationsResizeRequestResource(reservationsResizeRequestResource)
   *     .build();
   *   Operation response = reservationClient.resizeReservation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeReservation(ResizeReservationHttpRequest request) {
    return resizeReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the reservation (applicable to standalone reservations only). For more information,
   * read Modifying reservations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedReservation = ProjectZoneReservationName.format("[PROJECT]", "[ZONE]", "[RESERVATION]");
   *   ReservationsResizeRequest reservationsResizeRequestResource = ReservationsResizeRequest.newBuilder().build();
   *   ResizeReservationHttpRequest request = ResizeReservationHttpRequest.newBuilder()
   *     .setReservation(formattedReservation)
   *     .setReservationsResizeRequestResource(reservationsResizeRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = reservationClient.resizeReservationCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ResizeReservationHttpRequest, Operation> resizeReservationCallable() {
    return stub.resizeReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneReservationResourceName resource = ProjectZoneReservationResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();
   *   Policy response = reservationClient.setIamPolicyReservation(resource, zoneSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param zoneSetPolicyRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicyReservation(
      ProjectZoneReservationResourceName resource,
      ZoneSetPolicyRequest zoneSetPolicyRequestResource) {

    SetIamPolicyReservationHttpRequest request =
        SetIamPolicyReservationHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setZoneSetPolicyRequestResource(zoneSetPolicyRequestResource)
            .build();
    return setIamPolicyReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneReservationResourceName resource = ProjectZoneReservationResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();
   *   Policy response = reservationClient.setIamPolicyReservation(resource.toString(), zoneSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param zoneSetPolicyRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicyReservation(
      String resource, ZoneSetPolicyRequest zoneSetPolicyRequestResource) {

    SetIamPolicyReservationHttpRequest request =
        SetIamPolicyReservationHttpRequest.newBuilder()
            .setResource(resource)
            .setZoneSetPolicyRequestResource(zoneSetPolicyRequestResource)
            .build();
    return setIamPolicyReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedResource = ProjectZoneReservationResourceName.format("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();
   *   SetIamPolicyReservationHttpRequest request = SetIamPolicyReservationHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setZoneSetPolicyRequestResource(zoneSetPolicyRequestResource)
   *     .build();
   *   Policy response = reservationClient.setIamPolicyReservation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicyReservation(SetIamPolicyReservationHttpRequest request) {
    return setIamPolicyReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedResource = ProjectZoneReservationResourceName.format("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();
   *   SetIamPolicyReservationHttpRequest request = SetIamPolicyReservationHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setZoneSetPolicyRequestResource(zoneSetPolicyRequestResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = reservationClient.setIamPolicyReservationCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetIamPolicyReservationHttpRequest, Policy>
      setIamPolicyReservationCallable() {
    return stub.setIamPolicyReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneReservationResourceName resource = ProjectZoneReservationResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = reservationClient.testIamPermissionsReservation(resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsReservation(
      ProjectZoneReservationResourceName resource,
      TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsReservationHttpRequest request =
        TestIamPermissionsReservationHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   ProjectZoneReservationResourceName resource = ProjectZoneReservationResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = reservationClient.testIamPermissionsReservation(resource.toString(), testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsReservation(
      String resource, TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsReservationHttpRequest request =
        TestIamPermissionsReservationHttpRequest.newBuilder()
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedResource = ProjectZoneReservationResourceName.format("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsReservationHttpRequest request = TestIamPermissionsReservationHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = reservationClient.testIamPermissionsReservation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsReservation(
      TestIamPermissionsReservationHttpRequest request) {
    return testIamPermissionsReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationClient reservationClient = ReservationClient.create()) {
   *   String formattedResource = ProjectZoneReservationResourceName.format("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsReservationHttpRequest request = TestIamPermissionsReservationHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = reservationClient.testIamPermissionsReservationCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<TestIamPermissionsReservationHttpRequest, TestPermissionsResponse>
      testIamPermissionsReservationCallable() {
    return stub.testIamPermissionsReservationCallable();
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

  public static class AggregatedListReservationsPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListReservationsHttpRequest,
          ReservationAggregatedList,
          ReservationsScopedList,
          AggregatedListReservationsPage,
          AggregatedListReservationsFixedSizeCollection> {

    public static ApiFuture<AggregatedListReservationsPagedResponse> createAsync(
        PageContext<
                AggregatedListReservationsHttpRequest,
                ReservationAggregatedList,
                ReservationsScopedList>
            context,
        ApiFuture<ReservationAggregatedList> futureResponse) {
      ApiFuture<AggregatedListReservationsPage> futurePage =
          AggregatedListReservationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListReservationsPage, AggregatedListReservationsPagedResponse>() {
            @Override
            public AggregatedListReservationsPagedResponse apply(
                AggregatedListReservationsPage input) {
              return new AggregatedListReservationsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListReservationsPagedResponse(AggregatedListReservationsPage page) {
      super(page, AggregatedListReservationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListReservationsPage
      extends AbstractPage<
          AggregatedListReservationsHttpRequest,
          ReservationAggregatedList,
          ReservationsScopedList,
          AggregatedListReservationsPage> {

    private AggregatedListReservationsPage(
        PageContext<
                AggregatedListReservationsHttpRequest,
                ReservationAggregatedList,
                ReservationsScopedList>
            context,
        ReservationAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListReservationsPage createEmptyPage() {
      return new AggregatedListReservationsPage(null, null);
    }

    @Override
    protected AggregatedListReservationsPage createPage(
        PageContext<
                AggregatedListReservationsHttpRequest,
                ReservationAggregatedList,
                ReservationsScopedList>
            context,
        ReservationAggregatedList response) {
      return new AggregatedListReservationsPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListReservationsPage> createPageAsync(
        PageContext<
                AggregatedListReservationsHttpRequest,
                ReservationAggregatedList,
                ReservationsScopedList>
            context,
        ApiFuture<ReservationAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListReservationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListReservationsHttpRequest,
          ReservationAggregatedList,
          ReservationsScopedList,
          AggregatedListReservationsPage,
          AggregatedListReservationsFixedSizeCollection> {

    private AggregatedListReservationsFixedSizeCollection(
        List<AggregatedListReservationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListReservationsFixedSizeCollection createEmptyCollection() {
      return new AggregatedListReservationsFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListReservationsFixedSizeCollection createCollection(
        List<AggregatedListReservationsPage> pages, int collectionSize) {
      return new AggregatedListReservationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReservationsPagedResponse
      extends AbstractPagedListResponse<
          ListReservationsHttpRequest,
          ReservationList,
          Reservation,
          ListReservationsPage,
          ListReservationsFixedSizeCollection> {

    public static ApiFuture<ListReservationsPagedResponse> createAsync(
        PageContext<ListReservationsHttpRequest, ReservationList, Reservation> context,
        ApiFuture<ReservationList> futureResponse) {
      ApiFuture<ListReservationsPage> futurePage =
          ListReservationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListReservationsPage, ListReservationsPagedResponse>() {
            @Override
            public ListReservationsPagedResponse apply(ListReservationsPage input) {
              return new ListReservationsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListReservationsPagedResponse(ListReservationsPage page) {
      super(page, ListReservationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReservationsPage
      extends AbstractPage<
          ListReservationsHttpRequest, ReservationList, Reservation, ListReservationsPage> {

    private ListReservationsPage(
        PageContext<ListReservationsHttpRequest, ReservationList, Reservation> context,
        ReservationList response) {
      super(context, response);
    }

    private static ListReservationsPage createEmptyPage() {
      return new ListReservationsPage(null, null);
    }

    @Override
    protected ListReservationsPage createPage(
        PageContext<ListReservationsHttpRequest, ReservationList, Reservation> context,
        ReservationList response) {
      return new ListReservationsPage(context, response);
    }

    @Override
    public ApiFuture<ListReservationsPage> createPageAsync(
        PageContext<ListReservationsHttpRequest, ReservationList, Reservation> context,
        ApiFuture<ReservationList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReservationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReservationsHttpRequest,
          ReservationList,
          Reservation,
          ListReservationsPage,
          ListReservationsFixedSizeCollection> {

    private ListReservationsFixedSizeCollection(
        List<ListReservationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReservationsFixedSizeCollection createEmptyCollection() {
      return new ListReservationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReservationsFixedSizeCollection createCollection(
        List<ListReservationsPage> pages, int collectionSize) {
      return new ListReservationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
