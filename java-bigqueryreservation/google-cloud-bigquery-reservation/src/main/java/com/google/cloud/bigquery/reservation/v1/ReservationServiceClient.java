/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigquery.reservation.v1;

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
import com.google.cloud.bigquery.reservation.v1.stub.ReservationServiceStub;
import com.google.cloud.bigquery.reservation.v1.stub.ReservationServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: This API allows users to manage their flat-rate BigQuery reservations.
 *
 * <p>A reservation provides computational resource guarantees, in the form of
 * [slots](https://cloud.google.com/bigquery/docs/slots), to users. A slot is a unit of
 * computational power in BigQuery, and serves as the basic unit of parallelism. In a scan of a
 * multi-partitioned table, a single slot operates on a single partition of the table. A reservation
 * resource exists as a child resource of the admin project and location, e.g.:
 * projects/myproject/locations/US/reservations/reservationName.
 *
 * <p>A capacity commitment is a way to purchase compute capacity for BigQuery jobs (in the form of
 * slots) with some committed period of usage. A capacity commitment resource exists as a child
 * resource of the admin project and location, e.g.:
 * projects/myproject/locations/US/capacityCommitments/id.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
 *   ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
 *   reservationServiceClient.deleteReservation(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the reservationServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of ReservationServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ReservationServiceSettings reservationServiceSettings =
 *     ReservationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReservationServiceClient reservationServiceClient =
 *     ReservationServiceClient.create(reservationServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ReservationServiceSettings reservationServiceSettings =
 *     ReservationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ReservationServiceClient reservationServiceClient =
 *     ReservationServiceClient.create(reservationServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ReservationServiceClient implements BackgroundResource {
  private final ReservationServiceSettings settings;
  private final ReservationServiceStub stub;

  /** Constructs an instance of ReservationServiceClient with default settings. */
  public static final ReservationServiceClient create() throws IOException {
    return create(ReservationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ReservationServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ReservationServiceClient create(ReservationServiceSettings settings)
      throws IOException {
    return new ReservationServiceClient(settings);
  }

  /**
   * Constructs an instance of ReservationServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use ReservationServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ReservationServiceClient create(ReservationServiceStub stub) {
    return new ReservationServiceClient(stub);
  }

  /**
   * Constructs an instance of ReservationServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ReservationServiceClient(ReservationServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ReservationServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ReservationServiceClient(ReservationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ReservationServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ReservationServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
   * assignments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   reservationServiceClient.deleteReservation(name);
   * }
   * </code></pre>
   *
   * @param name Required. Resource name of the reservation to retrieve. E.g.,
   *     projects/myproject/locations/US/reservations/team1-prod
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReservation(ReservationName name) {
    DeleteReservationRequest request =
        DeleteReservationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
   * assignments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   reservationServiceClient.deleteReservation(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. Resource name of the reservation to retrieve. E.g.,
   *     projects/myproject/locations/US/reservations/team1-prod
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReservation(String name) {
    DeleteReservationRequest request = DeleteReservationRequest.newBuilder().setName(name).build();
    deleteReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
   * assignments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   DeleteReservationRequest request = DeleteReservationRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   reservationServiceClient.deleteReservation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReservation(DeleteReservationRequest request) {
    deleteReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
   * assignments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   DeleteReservationRequest request = DeleteReservationRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = reservationServiceClient.deleteReservationCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteReservationRequest, Empty> deleteReservationCallable() {
    return stub.deleteReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a capacity commitment. Attempting to delete capacity commitment before its
   * commitment_end_time will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitmentName name = CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
   *   reservationServiceClient.deleteCapacityCommitment(name);
   * }
   * </code></pre>
   *
   * @param name Required. Resource name of the capacity commitment to delete. E.g.,
   *     projects/myproject/locations/US/capacityCommitments/123
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCapacityCommitment(CapacityCommitmentName name) {
    DeleteCapacityCommitmentRequest request =
        DeleteCapacityCommitmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a capacity commitment. Attempting to delete capacity commitment before its
   * commitment_end_time will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitmentName name = CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
   *   reservationServiceClient.deleteCapacityCommitment(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. Resource name of the capacity commitment to delete. E.g.,
   *     projects/myproject/locations/US/capacityCommitments/123
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCapacityCommitment(String name) {
    DeleteCapacityCommitmentRequest request =
        DeleteCapacityCommitmentRequest.newBuilder().setName(name).build();
    deleteCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a capacity commitment. Attempting to delete capacity commitment before its
   * commitment_end_time will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitmentName name = CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
   *   DeleteCapacityCommitmentRequest request = DeleteCapacityCommitmentRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   reservationServiceClient.deleteCapacityCommitment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCapacityCommitment(DeleteCapacityCommitmentRequest request) {
    deleteCapacityCommitmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a capacity commitment. Attempting to delete capacity commitment before its
   * commitment_end_time will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitmentName name = CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
   *   DeleteCapacityCommitmentRequest request = DeleteCapacityCommitmentRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = reservationServiceClient.deleteCapacityCommitmentCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteCapacityCommitmentRequest, Empty>
      deleteCapacityCommitmentCallable() {
    return stub.deleteCapacityCommitmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a assignment. No expansion will happen. E.g: organizationA contains project1 and
   * project2. Reservation res1 exists. CreateAssignment was invoked previously and following
   * assignments were created explicitly: &lt;organizationA, res1&gt; &lt;project1, res1&gt; Then
   * deletion of &lt;organizationA, res1&gt; won't affect &lt;project1, res1&gt;. After deletion of
   * &lt;organizationA, res1&gt;, queries from project1 will still use res1, while queries from
   * project2 will use on-demand mode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   AssignmentName name = AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
   *   reservationServiceClient.deleteAssignment(name);
   * }
   * </code></pre>
   *
   * @param name Required. Name of the resource, e.g.:
   *     projects/myproject/locations/US/reservations/team1-prod/assignments/123
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAssignment(AssignmentName name) {
    DeleteAssignmentRequest request =
        DeleteAssignmentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a assignment. No expansion will happen. E.g: organizationA contains project1 and
   * project2. Reservation res1 exists. CreateAssignment was invoked previously and following
   * assignments were created explicitly: &lt;organizationA, res1&gt; &lt;project1, res1&gt; Then
   * deletion of &lt;organizationA, res1&gt; won't affect &lt;project1, res1&gt;. After deletion of
   * &lt;organizationA, res1&gt;, queries from project1 will still use res1, while queries from
   * project2 will use on-demand mode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   AssignmentName name = AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
   *   reservationServiceClient.deleteAssignment(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. Name of the resource, e.g.:
   *     projects/myproject/locations/US/reservations/team1-prod/assignments/123
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAssignment(String name) {
    DeleteAssignmentRequest request = DeleteAssignmentRequest.newBuilder().setName(name).build();
    deleteAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a assignment. No expansion will happen. E.g: organizationA contains project1 and
   * project2. Reservation res1 exists. CreateAssignment was invoked previously and following
   * assignments were created explicitly: &lt;organizationA, res1&gt; &lt;project1, res1&gt; Then
   * deletion of &lt;organizationA, res1&gt; won't affect &lt;project1, res1&gt;. After deletion of
   * &lt;organizationA, res1&gt;, queries from project1 will still use res1, while queries from
   * project2 will use on-demand mode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   AssignmentName name = AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
   *   DeleteAssignmentRequest request = DeleteAssignmentRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   reservationServiceClient.deleteAssignment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAssignment(DeleteAssignmentRequest request) {
    deleteAssignmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a assignment. No expansion will happen. E.g: organizationA contains project1 and
   * project2. Reservation res1 exists. CreateAssignment was invoked previously and following
   * assignments were created explicitly: &lt;organizationA, res1&gt; &lt;project1, res1&gt; Then
   * deletion of &lt;organizationA, res1&gt; won't affect &lt;project1, res1&gt;. After deletion of
   * &lt;organizationA, res1&gt;, queries from project1 will still use res1, while queries from
   * project2 will use on-demand mode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   AssignmentName name = AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
   *   DeleteAssignmentRequest request = DeleteAssignmentRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = reservationServiceClient.deleteAssignmentCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteAssignmentRequest, Empty> deleteAssignmentCallable() {
    return stub.deleteAssignmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new reservation resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Reservation reservation = Reservation.newBuilder().build();
   *   String reservationId = "";
   *   Reservation response = reservationServiceClient.createReservation(parent, reservation, reservationId);
   * }
   * </code></pre>
   *
   * @param parent Required. Project, location. E.g., projects/myproject/locations/US
   * @param reservation Content of the new reservation to create.
   * @param reservationId The reservation ID. This field must only contain lower case alphanumeric
   *     characters or dash. Max length is 64 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation createReservation(
      LocationName parent, Reservation reservation, String reservationId) {
    CreateReservationRequest request =
        CreateReservationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setReservation(reservation)
            .setReservationId(reservationId)
            .build();
    return createReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new reservation resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Reservation reservation = Reservation.newBuilder().build();
   *   String reservationId = "";
   *   Reservation response = reservationServiceClient.createReservation(parent.toString(), reservation, reservationId);
   * }
   * </code></pre>
   *
   * @param parent Required. Project, location. E.g., projects/myproject/locations/US
   * @param reservation Content of the new reservation to create.
   * @param reservationId The reservation ID. This field must only contain lower case alphanumeric
   *     characters or dash. Max length is 64 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation createReservation(
      String parent, Reservation reservation, String reservationId) {
    CreateReservationRequest request =
        CreateReservationRequest.newBuilder()
            .setParent(parent)
            .setReservation(reservation)
            .setReservationId(reservationId)
            .build();
    return createReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new reservation resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CreateReservationRequest request = CreateReservationRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   Reservation response = reservationServiceClient.createReservation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation createReservation(CreateReservationRequest request) {
    return createReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new reservation resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CreateReservationRequest request = CreateReservationRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;Reservation&gt; future = reservationServiceClient.createReservationCallable().futureCall(request);
   *   // Do something
   *   Reservation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateReservationRequest, Reservation> createReservationCallable() {
    return stub.createReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the reservations for the project in the specified location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Reservation element : reservationServiceClient.listReservations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name containing project and location, e.g.:
   *     "projects/myproject/locations/US"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReservationsPagedResponse listReservations(LocationName parent) {
    ListReservationsRequest request =
        ListReservationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReservations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the reservations for the project in the specified location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Reservation element : reservationServiceClient.listReservations(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name containing project and location, e.g.:
   *     "projects/myproject/locations/US"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReservationsPagedResponse listReservations(String parent) {
    ListReservationsRequest request =
        ListReservationsRequest.newBuilder().setParent(parent).build();
    return listReservations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the reservations for the project in the specified location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListReservationsRequest request = ListReservationsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Reservation element : reservationServiceClient.listReservations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReservationsPagedResponse listReservations(ListReservationsRequest request) {
    return listReservationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the reservations for the project in the specified location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListReservationsRequest request = ListReservationsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListReservationsPagedResponse&gt; future = reservationServiceClient.listReservationsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Reservation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListReservationsRequest, ListReservationsPagedResponse>
      listReservationsPagedCallable() {
    return stub.listReservationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the reservations for the project in the specified location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListReservationsRequest request = ListReservationsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListReservationsResponse response = reservationServiceClient.listReservationsCallable().call(request);
   *     for (Reservation element : response.getReservationsList()) {
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
  public final UnaryCallable<ListReservationsRequest, ListReservationsResponse>
      listReservationsCallable() {
    return stub.listReservationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about the reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   Reservation response = reservationServiceClient.getReservation(name);
   * }
   * </code></pre>
   *
   * @param name Required. Resource name of the reservation to retrieve. E.g.,
   *     projects/myproject/locations/US/reservations/team1-prod
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation getReservation(ReservationName name) {
    GetReservationRequest request =
        GetReservationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about the reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   Reservation response = reservationServiceClient.getReservation(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. Resource name of the reservation to retrieve. E.g.,
   *     projects/myproject/locations/US/reservations/team1-prod
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation getReservation(String name) {
    GetReservationRequest request = GetReservationRequest.newBuilder().setName(name).build();
    return getReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about the reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   GetReservationRequest request = GetReservationRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Reservation response = reservationServiceClient.getReservation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation getReservation(GetReservationRequest request) {
    return getReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about the reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   GetReservationRequest request = GetReservationRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Reservation&gt; future = reservationServiceClient.getReservationCallable().futureCall(request);
   *   // Do something
   *   Reservation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetReservationRequest, Reservation> getReservationCallable() {
    return stub.getReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing reservation resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   Reservation reservation = Reservation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Reservation response = reservationServiceClient.updateReservation(reservation, updateMask);
   * }
   * </code></pre>
   *
   * @param reservation Content of the reservation to update.
   * @param updateMask Standard field mask for the set of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation updateReservation(Reservation reservation, FieldMask updateMask) {
    UpdateReservationRequest request =
        UpdateReservationRequest.newBuilder()
            .setReservation(reservation)
            .setUpdateMask(updateMask)
            .build();
    return updateReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing reservation resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   UpdateReservationRequest request = UpdateReservationRequest.newBuilder().build();
   *   Reservation response = reservationServiceClient.updateReservation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation updateReservation(UpdateReservationRequest request) {
    return updateReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing reservation resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   UpdateReservationRequest request = UpdateReservationRequest.newBuilder().build();
   *   ApiFuture&lt;Reservation&gt; future = reservationServiceClient.updateReservationCallable().futureCall(request);
   *   // Do something
   *   Reservation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateReservationRequest, Reservation> updateReservationCallable() {
    return stub.updateReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the capacity commitments for the admin project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CapacityCommitment element : reservationServiceClient.listCapacityCommitments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. Resource name of the parent reservation. E.g.,
   *     projects/myproject/locations/US
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCapacityCommitmentsPagedResponse listCapacityCommitments(LocationName parent) {
    ListCapacityCommitmentsRequest request =
        ListCapacityCommitmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCapacityCommitments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the capacity commitments for the admin project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CapacityCommitment element : reservationServiceClient.listCapacityCommitments(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. Resource name of the parent reservation. E.g.,
   *     projects/myproject/locations/US
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCapacityCommitmentsPagedResponse listCapacityCommitments(String parent) {
    ListCapacityCommitmentsRequest request =
        ListCapacityCommitmentsRequest.newBuilder().setParent(parent).build();
    return listCapacityCommitments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the capacity commitments for the admin project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListCapacityCommitmentsRequest request = ListCapacityCommitmentsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (CapacityCommitment element : reservationServiceClient.listCapacityCommitments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCapacityCommitmentsPagedResponse listCapacityCommitments(
      ListCapacityCommitmentsRequest request) {
    return listCapacityCommitmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the capacity commitments for the admin project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListCapacityCommitmentsRequest request = ListCapacityCommitmentsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListCapacityCommitmentsPagedResponse&gt; future = reservationServiceClient.listCapacityCommitmentsPagedCallable().futureCall(request);
   *   // Do something
   *   for (CapacityCommitment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListCapacityCommitmentsRequest, ListCapacityCommitmentsPagedResponse>
      listCapacityCommitmentsPagedCallable() {
    return stub.listCapacityCommitmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the capacity commitments for the admin project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListCapacityCommitmentsRequest request = ListCapacityCommitmentsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListCapacityCommitmentsResponse response = reservationServiceClient.listCapacityCommitmentsCallable().call(request);
   *     for (CapacityCommitment element : response.getCapacityCommitmentsList()) {
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
  public final UnaryCallable<ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse>
      listCapacityCommitmentsCallable() {
    return stub.listCapacityCommitmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about the capacity commitment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitmentName name = CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
   *   CapacityCommitment response = reservationServiceClient.getCapacityCommitment(name);
   * }
   * </code></pre>
   *
   * @param name Required. Resource name of the capacity commitment to retrieve. E.g.,
   *     projects/myproject/locations/US/capacityCommitments/123
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment getCapacityCommitment(CapacityCommitmentName name) {
    GetCapacityCommitmentRequest request =
        GetCapacityCommitmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about the capacity commitment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitmentName name = CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
   *   CapacityCommitment response = reservationServiceClient.getCapacityCommitment(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. Resource name of the capacity commitment to retrieve. E.g.,
   *     projects/myproject/locations/US/capacityCommitments/123
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment getCapacityCommitment(String name) {
    GetCapacityCommitmentRequest request =
        GetCapacityCommitmentRequest.newBuilder().setName(name).build();
    return getCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about the capacity commitment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitmentName name = CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
   *   GetCapacityCommitmentRequest request = GetCapacityCommitmentRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   CapacityCommitment response = reservationServiceClient.getCapacityCommitment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment getCapacityCommitment(GetCapacityCommitmentRequest request) {
    return getCapacityCommitmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about the capacity commitment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitmentName name = CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
   *   GetCapacityCommitmentRequest request = GetCapacityCommitmentRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;CapacityCommitment&gt; future = reservationServiceClient.getCapacityCommitmentCallable().futureCall(request);
   *   // Do something
   *   CapacityCommitment response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetCapacityCommitmentRequest, CapacityCommitment>
      getCapacityCommitmentCallable() {
    return stub.getCapacityCommitmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing capacity commitment.
   *
   * <p>Only plan and renewal_plan fields can be updated. Plan can only be changed to a plan of a
   * longer commitment period. Attempting to change to a plan with shorter commitment period will
   * fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitment capacityCommitment = CapacityCommitment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CapacityCommitment response = reservationServiceClient.updateCapacityCommitment(capacityCommitment, updateMask);
   * }
   * </code></pre>
   *
   * @param capacityCommitment Content of the capacity commitment to update.
   * @param updateMask Standard field mask for the set of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment updateCapacityCommitment(
      CapacityCommitment capacityCommitment, FieldMask updateMask) {
    UpdateCapacityCommitmentRequest request =
        UpdateCapacityCommitmentRequest.newBuilder()
            .setCapacityCommitment(capacityCommitment)
            .setUpdateMask(updateMask)
            .build();
    return updateCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing capacity commitment.
   *
   * <p>Only plan and renewal_plan fields can be updated. Plan can only be changed to a plan of a
   * longer commitment period. Attempting to change to a plan with shorter commitment period will
   * fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   UpdateCapacityCommitmentRequest request = UpdateCapacityCommitmentRequest.newBuilder().build();
   *   CapacityCommitment response = reservationServiceClient.updateCapacityCommitment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment updateCapacityCommitment(
      UpdateCapacityCommitmentRequest request) {
    return updateCapacityCommitmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing capacity commitment.
   *
   * <p>Only plan and renewal_plan fields can be updated. Plan can only be changed to a plan of a
   * longer commitment period. Attempting to change to a plan with shorter commitment period will
   * fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   UpdateCapacityCommitmentRequest request = UpdateCapacityCommitmentRequest.newBuilder().build();
   *   ApiFuture&lt;CapacityCommitment&gt; future = reservationServiceClient.updateCapacityCommitmentCallable().futureCall(request);
   *   // Do something
   *   CapacityCommitment response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateCapacityCommitmentRequest, CapacityCommitment>
      updateCapacityCommitmentCallable() {
    return stub.updateCapacityCommitmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Splits capacity commitment to two commitments of the same plan and commitment_end_time. A
   * common use case to do that is to perform a downgrade e.g., in order to downgrade from 10000
   * slots to 8000, one might split 10000 capacity commitment to 2000 and 8000, change the plan of
   * the first one to flex and then delete it.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitmentName name = CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
   *   long slotCount = 0L;
   *   SplitCapacityCommitmentResponse response = reservationServiceClient.splitCapacityCommitment(name, slotCount);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name e.g.,:
   *     projects/myproject/locations/US/capacityCommitments/123
   * @param slotCount Number of slots in the capacity commitment after the split.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SplitCapacityCommitmentResponse splitCapacityCommitment(
      CapacityCommitmentName name, long slotCount) {
    SplitCapacityCommitmentRequest request =
        SplitCapacityCommitmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSlotCount(slotCount)
            .build();
    return splitCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Splits capacity commitment to two commitments of the same plan and commitment_end_time. A
   * common use case to do that is to perform a downgrade e.g., in order to downgrade from 10000
   * slots to 8000, one might split 10000 capacity commitment to 2000 and 8000, change the plan of
   * the first one to flex and then delete it.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitmentName name = CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
   *   long slotCount = 0L;
   *   SplitCapacityCommitmentResponse response = reservationServiceClient.splitCapacityCommitment(name.toString(), slotCount);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name e.g.,:
   *     projects/myproject/locations/US/capacityCommitments/123
   * @param slotCount Number of slots in the capacity commitment after the split.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SplitCapacityCommitmentResponse splitCapacityCommitment(
      String name, long slotCount) {
    SplitCapacityCommitmentRequest request =
        SplitCapacityCommitmentRequest.newBuilder().setName(name).setSlotCount(slotCount).build();
    return splitCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Splits capacity commitment to two commitments of the same plan and commitment_end_time. A
   * common use case to do that is to perform a downgrade e.g., in order to downgrade from 10000
   * slots to 8000, one might split 10000 capacity commitment to 2000 and 8000, change the plan of
   * the first one to flex and then delete it.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitmentName name = CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
   *   SplitCapacityCommitmentRequest request = SplitCapacityCommitmentRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   SplitCapacityCommitmentResponse response = reservationServiceClient.splitCapacityCommitment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SplitCapacityCommitmentResponse splitCapacityCommitment(
      SplitCapacityCommitmentRequest request) {
    return splitCapacityCommitmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Splits capacity commitment to two commitments of the same plan and commitment_end_time. A
   * common use case to do that is to perform a downgrade e.g., in order to downgrade from 10000
   * slots to 8000, one might split 10000 capacity commitment to 2000 and 8000, change the plan of
   * the first one to flex and then delete it.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitmentName name = CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
   *   SplitCapacityCommitmentRequest request = SplitCapacityCommitmentRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;SplitCapacityCommitmentResponse&gt; future = reservationServiceClient.splitCapacityCommitmentCallable().futureCall(request);
   *   // Do something
   *   SplitCapacityCommitmentResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>
      splitCapacityCommitmentCallable() {
    return stub.splitCapacityCommitmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Merges capacity commitments of the same plan into one. Resulting capacity commitment has the
   * longer commitment_end_time out of the two. Attempting to merge capacity commitments of
   * different plan will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   List&lt;String&gt; capacityCommitmentIds = new ArrayList&lt;&gt;();
   *   CapacityCommitment response = reservationServiceClient.mergeCapacityCommitments(parent, capacityCommitmentIds);
   * }
   * </code></pre>
   *
   * @param parent Parent resource that identifies admin project and location e.g.,
   *     projects/myproject/locations/us
   * @param capacityCommitmentIds Ids of capacity commitments to merge. These capacity commitments
   *     must exist under admin project and location specified in the parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment mergeCapacityCommitments(
      LocationName parent, List<String> capacityCommitmentIds) {
    MergeCapacityCommitmentsRequest request =
        MergeCapacityCommitmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllCapacityCommitmentIds(capacityCommitmentIds)
            .build();
    return mergeCapacityCommitments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Merges capacity commitments of the same plan into one. Resulting capacity commitment has the
   * longer commitment_end_time out of the two. Attempting to merge capacity commitments of
   * different plan will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   List&lt;String&gt; capacityCommitmentIds = new ArrayList&lt;&gt;();
   *   CapacityCommitment response = reservationServiceClient.mergeCapacityCommitments(parent.toString(), capacityCommitmentIds);
   * }
   * </code></pre>
   *
   * @param parent Parent resource that identifies admin project and location e.g.,
   *     projects/myproject/locations/us
   * @param capacityCommitmentIds Ids of capacity commitments to merge. These capacity commitments
   *     must exist under admin project and location specified in the parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment mergeCapacityCommitments(
      String parent, List<String> capacityCommitmentIds) {
    MergeCapacityCommitmentsRequest request =
        MergeCapacityCommitmentsRequest.newBuilder()
            .setParent(parent)
            .addAllCapacityCommitmentIds(capacityCommitmentIds)
            .build();
    return mergeCapacityCommitments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Merges capacity commitments of the same plan into one. Resulting capacity commitment has the
   * longer commitment_end_time out of the two. Attempting to merge capacity commitments of
   * different plan will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   MergeCapacityCommitmentsRequest request = MergeCapacityCommitmentsRequest.newBuilder().build();
   *   CapacityCommitment response = reservationServiceClient.mergeCapacityCommitments(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment mergeCapacityCommitments(
      MergeCapacityCommitmentsRequest request) {
    return mergeCapacityCommitmentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Merges capacity commitments of the same plan into one. Resulting capacity commitment has the
   * longer commitment_end_time out of the two. Attempting to merge capacity commitments of
   * different plan will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   MergeCapacityCommitmentsRequest request = MergeCapacityCommitmentsRequest.newBuilder().build();
   *   ApiFuture&lt;CapacityCommitment&gt; future = reservationServiceClient.mergeCapacityCommitmentsCallable().futureCall(request);
   *   // Do something
   *   CapacityCommitment response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<MergeCapacityCommitmentsRequest, CapacityCommitment>
      mergeCapacityCommitmentsCallable() {
    return stub.mergeCapacityCommitmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an object which allows the given project to submit jobs of a certain type using slots
   * from the specified reservation. Currently a resource (project, folder, organization) can only
   * have one assignment per {job_type, location}, and that reservation will be used for all jobs of
   * the matching type. Within the organization, different assignments can be created on projects,
   * folders or organization level. During query execution, the assignment is looked up at the
   * project, folder and organization levels in that order. The first assignment found is applied to
   * the query. When creating assignments, it does not matter if other assignments exist at higher
   * levels. E.g: organizationA contains project1, project2. Assignments for organizationA, project1
   * and project2 could all be created, mapping to the same or different reservations. Returns
   * `google.rpc.Code.PERMISSION_DENIED` if user does not have 'bigquery.admin' permissions on the
   * project using the reservation and the project that owns this reservation. Returns
   * `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment does not match location of
   * the reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   Assignment assignment = Assignment.newBuilder().build();
   *   Assignment response = reservationServiceClient.createAssignment(parent, assignment);
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name of the assignment E.g.:
   *     projects/myproject/locations/US/reservations/team1-prod
   * @param assignment Assignment resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment createAssignment(ReservationName parent, Assignment assignment) {
    CreateAssignmentRequest request =
        CreateAssignmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAssignment(assignment)
            .build();
    return createAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an object which allows the given project to submit jobs of a certain type using slots
   * from the specified reservation. Currently a resource (project, folder, organization) can only
   * have one assignment per {job_type, location}, and that reservation will be used for all jobs of
   * the matching type. Within the organization, different assignments can be created on projects,
   * folders or organization level. During query execution, the assignment is looked up at the
   * project, folder and organization levels in that order. The first assignment found is applied to
   * the query. When creating assignments, it does not matter if other assignments exist at higher
   * levels. E.g: organizationA contains project1, project2. Assignments for organizationA, project1
   * and project2 could all be created, mapping to the same or different reservations. Returns
   * `google.rpc.Code.PERMISSION_DENIED` if user does not have 'bigquery.admin' permissions on the
   * project using the reservation and the project that owns this reservation. Returns
   * `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment does not match location of
   * the reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   Assignment assignment = Assignment.newBuilder().build();
   *   Assignment response = reservationServiceClient.createAssignment(parent.toString(), assignment);
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name of the assignment E.g.:
   *     projects/myproject/locations/US/reservations/team1-prod
   * @param assignment Assignment resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment createAssignment(String parent, Assignment assignment) {
    CreateAssignmentRequest request =
        CreateAssignmentRequest.newBuilder().setParent(parent).setAssignment(assignment).build();
    return createAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an object which allows the given project to submit jobs of a certain type using slots
   * from the specified reservation. Currently a resource (project, folder, organization) can only
   * have one assignment per {job_type, location}, and that reservation will be used for all jobs of
   * the matching type. Within the organization, different assignments can be created on projects,
   * folders or organization level. During query execution, the assignment is looked up at the
   * project, folder and organization levels in that order. The first assignment found is applied to
   * the query. When creating assignments, it does not matter if other assignments exist at higher
   * levels. E.g: organizationA contains project1, project2. Assignments for organizationA, project1
   * and project2 could all be created, mapping to the same or different reservations. Returns
   * `google.rpc.Code.PERMISSION_DENIED` if user does not have 'bigquery.admin' permissions on the
   * project using the reservation and the project that owns this reservation. Returns
   * `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment does not match location of
   * the reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   CreateAssignmentRequest request = CreateAssignmentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   Assignment response = reservationServiceClient.createAssignment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment createAssignment(CreateAssignmentRequest request) {
    return createAssignmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an object which allows the given project to submit jobs of a certain type using slots
   * from the specified reservation. Currently a resource (project, folder, organization) can only
   * have one assignment per {job_type, location}, and that reservation will be used for all jobs of
   * the matching type. Within the organization, different assignments can be created on projects,
   * folders or organization level. During query execution, the assignment is looked up at the
   * project, folder and organization levels in that order. The first assignment found is applied to
   * the query. When creating assignments, it does not matter if other assignments exist at higher
   * levels. E.g: organizationA contains project1, project2. Assignments for organizationA, project1
   * and project2 could all be created, mapping to the same or different reservations. Returns
   * `google.rpc.Code.PERMISSION_DENIED` if user does not have 'bigquery.admin' permissions on the
   * project using the reservation and the project that owns this reservation. Returns
   * `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment does not match location of
   * the reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   CreateAssignmentRequest request = CreateAssignmentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;Assignment&gt; future = reservationServiceClient.createAssignmentCallable().futureCall(request);
   *   // Do something
   *   Assignment response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateAssignmentRequest, Assignment> createAssignmentCallable() {
    return stub.createAssignmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists assignments. Only explicitly created assignments will be returned. E.g: organizationA
   * contains project1 and project2. Reservation res1 exists. CreateAssignment was invoked
   * previously and following assignments were created explicitly: &lt;organizationA, res1&gt;
   * &lt;project1, res1&gt; Then this API will just return the above two assignments for reservation
   * res1, and no expansion/merge will happen. Wildcard "-" can be used for reservations in the
   * request. In that case all assignments belongs to the specified project and location will be
   * listed. Note "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   for (Assignment element : reservationServiceClient.listAssignments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name e.g.:
   *     projects/myproject/locations/US/reservations/team1-prod Or:
   *     projects/myproject/locations/US/reservations/-
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssignmentsPagedResponse listAssignments(ReservationName parent) {
    ListAssignmentsRequest request =
        ListAssignmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAssignments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists assignments. Only explicitly created assignments will be returned. E.g: organizationA
   * contains project1 and project2. Reservation res1 exists. CreateAssignment was invoked
   * previously and following assignments were created explicitly: &lt;organizationA, res1&gt;
   * &lt;project1, res1&gt; Then this API will just return the above two assignments for reservation
   * res1, and no expansion/merge will happen. Wildcard "-" can be used for reservations in the
   * request. In that case all assignments belongs to the specified project and location will be
   * listed. Note "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   for (Assignment element : reservationServiceClient.listAssignments(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name e.g.:
   *     projects/myproject/locations/US/reservations/team1-prod Or:
   *     projects/myproject/locations/US/reservations/-
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssignmentsPagedResponse listAssignments(String parent) {
    ListAssignmentsRequest request = ListAssignmentsRequest.newBuilder().setParent(parent).build();
    return listAssignments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists assignments. Only explicitly created assignments will be returned. E.g: organizationA
   * contains project1 and project2. Reservation res1 exists. CreateAssignment was invoked
   * previously and following assignments were created explicitly: &lt;organizationA, res1&gt;
   * &lt;project1, res1&gt; Then this API will just return the above two assignments for reservation
   * res1, and no expansion/merge will happen. Wildcard "-" can be used for reservations in the
   * request. In that case all assignments belongs to the specified project and location will be
   * listed. Note "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   ListAssignmentsRequest request = ListAssignmentsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Assignment element : reservationServiceClient.listAssignments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssignmentsPagedResponse listAssignments(ListAssignmentsRequest request) {
    return listAssignmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists assignments. Only explicitly created assignments will be returned. E.g: organizationA
   * contains project1 and project2. Reservation res1 exists. CreateAssignment was invoked
   * previously and following assignments were created explicitly: &lt;organizationA, res1&gt;
   * &lt;project1, res1&gt; Then this API will just return the above two assignments for reservation
   * res1, and no expansion/merge will happen. Wildcard "-" can be used for reservations in the
   * request. In that case all assignments belongs to the specified project and location will be
   * listed. Note "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   ListAssignmentsRequest request = ListAssignmentsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListAssignmentsPagedResponse&gt; future = reservationServiceClient.listAssignmentsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Assignment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListAssignmentsRequest, ListAssignmentsPagedResponse>
      listAssignmentsPagedCallable() {
    return stub.listAssignmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists assignments. Only explicitly created assignments will be returned. E.g: organizationA
   * contains project1 and project2. Reservation res1 exists. CreateAssignment was invoked
   * previously and following assignments were created explicitly: &lt;organizationA, res1&gt;
   * &lt;project1, res1&gt; Then this API will just return the above two assignments for reservation
   * res1, and no expansion/merge will happen. Wildcard "-" can be used for reservations in the
   * request. In that case all assignments belongs to the specified project and location will be
   * listed. Note "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   ListAssignmentsRequest request = ListAssignmentsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListAssignmentsResponse response = reservationServiceClient.listAssignmentsCallable().call(request);
   *     for (Assignment element : response.getAssignmentsList()) {
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
  public final UnaryCallable<ListAssignmentsRequest, ListAssignmentsResponse>
      listAssignmentsCallable() {
    return stub.listAssignmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Looks up assignments for a specified resource for a particular region. If the request is about
   * a project: 1) Assignments created on the project will be returned if they exist. 2) Otherwise
   * assignments created on the closest ancestor will be returned. 3) Assignments for different
   * JobTypes will all be returned. Same logic applies if the request is about a folder. If the
   * request is about an organization, then assignments created on the organization will be returned
   * (organization doesn't have ancestors). Comparing to ListAssignments, there are some behavior
   * differences: 1) permission on the assignee will be verified in this API. 2) Hierarchy lookup
   * (project-&gt;folder-&gt;organization) happens in this API. 3) Parent here is
   * projects/&#42;/locations/&#42;, instead of projects/&#42;/locations/&#42;reservations/&#42;.
   * Note "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   String query = "";
   *   for (Assignment element : reservationServiceClient.searchAssignments(parent, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the admin project(containing project and
   *     location), e.g.: "projects/myproject/locations/US".
   * @param query Please specify resource name as assignee in the query. e.g.,
   *     "assignee=projects/myproject" "assignee=folders/123" "assignee=organizations/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAssignmentsPagedResponse searchAssignments(
      ReservationName parent, String query) {
    SearchAssignmentsRequest request =
        SearchAssignmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setQuery(query)
            .build();
    return searchAssignments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Looks up assignments for a specified resource for a particular region. If the request is about
   * a project: 1) Assignments created on the project will be returned if they exist. 2) Otherwise
   * assignments created on the closest ancestor will be returned. 3) Assignments for different
   * JobTypes will all be returned. Same logic applies if the request is about a folder. If the
   * request is about an organization, then assignments created on the organization will be returned
   * (organization doesn't have ancestors). Comparing to ListAssignments, there are some behavior
   * differences: 1) permission on the assignee will be verified in this API. 2) Hierarchy lookup
   * (project-&gt;folder-&gt;organization) happens in this API. 3) Parent here is
   * projects/&#42;/locations/&#42;, instead of projects/&#42;/locations/&#42;reservations/&#42;.
   * Note "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   String query = "";
   *   for (Assignment element : reservationServiceClient.searchAssignments(parent.toString(), query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the admin project(containing project and
   *     location), e.g.: "projects/myproject/locations/US".
   * @param query Please specify resource name as assignee in the query. e.g.,
   *     "assignee=projects/myproject" "assignee=folders/123" "assignee=organizations/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAssignmentsPagedResponse searchAssignments(String parent, String query) {
    SearchAssignmentsRequest request =
        SearchAssignmentsRequest.newBuilder().setParent(parent).setQuery(query).build();
    return searchAssignments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Looks up assignments for a specified resource for a particular region. If the request is about
   * a project: 1) Assignments created on the project will be returned if they exist. 2) Otherwise
   * assignments created on the closest ancestor will be returned. 3) Assignments for different
   * JobTypes will all be returned. Same logic applies if the request is about a folder. If the
   * request is about an organization, then assignments created on the organization will be returned
   * (organization doesn't have ancestors). Comparing to ListAssignments, there are some behavior
   * differences: 1) permission on the assignee will be verified in this API. 2) Hierarchy lookup
   * (project-&gt;folder-&gt;organization) happens in this API. 3) Parent here is
   * projects/&#42;/locations/&#42;, instead of projects/&#42;/locations/&#42;reservations/&#42;.
   * Note "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   SearchAssignmentsRequest request = SearchAssignmentsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Assignment element : reservationServiceClient.searchAssignments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAssignmentsPagedResponse searchAssignments(SearchAssignmentsRequest request) {
    return searchAssignmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Looks up assignments for a specified resource for a particular region. If the request is about
   * a project: 1) Assignments created on the project will be returned if they exist. 2) Otherwise
   * assignments created on the closest ancestor will be returned. 3) Assignments for different
   * JobTypes will all be returned. Same logic applies if the request is about a folder. If the
   * request is about an organization, then assignments created on the organization will be returned
   * (organization doesn't have ancestors). Comparing to ListAssignments, there are some behavior
   * differences: 1) permission on the assignee will be verified in this API. 2) Hierarchy lookup
   * (project-&gt;folder-&gt;organization) happens in this API. 3) Parent here is
   * projects/&#42;/locations/&#42;, instead of projects/&#42;/locations/&#42;reservations/&#42;.
   * Note "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   SearchAssignmentsRequest request = SearchAssignmentsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;SearchAssignmentsPagedResponse&gt; future = reservationServiceClient.searchAssignmentsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Assignment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<SearchAssignmentsRequest, SearchAssignmentsPagedResponse>
      searchAssignmentsPagedCallable() {
    return stub.searchAssignmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Looks up assignments for a specified resource for a particular region. If the request is about
   * a project: 1) Assignments created on the project will be returned if they exist. 2) Otherwise
   * assignments created on the closest ancestor will be returned. 3) Assignments for different
   * JobTypes will all be returned. Same logic applies if the request is about a folder. If the
   * request is about an organization, then assignments created on the organization will be returned
   * (organization doesn't have ancestors). Comparing to ListAssignments, there are some behavior
   * differences: 1) permission on the assignee will be verified in this API. 2) Hierarchy lookup
   * (project-&gt;folder-&gt;organization) happens in this API. 3) Parent here is
   * projects/&#42;/locations/&#42;, instead of projects/&#42;/locations/&#42;reservations/&#42;.
   * Note "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   SearchAssignmentsRequest request = SearchAssignmentsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     SearchAssignmentsResponse response = reservationServiceClient.searchAssignmentsCallable().call(request);
   *     for (Assignment element : response.getAssignmentsList()) {
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
  public final UnaryCallable<SearchAssignmentsRequest, SearchAssignmentsResponse>
      searchAssignmentsCallable() {
    return stub.searchAssignmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves a assignment under a new reservation. Customers can do this by deleting the existing
   * assignment followed by creating another assignment under the new reservation, but this method
   * provides a transactional way to do so, to make sure the assignee always has an associated
   * reservation. Without the method customers might see some queries run on-demand which might be
   * unexpected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   AssignmentName name = AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
   *   String destinationId = "";
   *   Assignment response = reservationServiceClient.moveAssignment(name, destinationId);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the assignment, e.g.:
   *     projects/myproject/locations/US/reservations/team1-prod/assignments/123
   * @param destinationId The new reservation ID, e.g.:
   *     projects/myotherproject/locations/US/reservations/team2-prod
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment moveAssignment(AssignmentName name, String destinationId) {
    MoveAssignmentRequest request =
        MoveAssignmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDestinationId(destinationId)
            .build();
    return moveAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves a assignment under a new reservation. Customers can do this by deleting the existing
   * assignment followed by creating another assignment under the new reservation, but this method
   * provides a transactional way to do so, to make sure the assignee always has an associated
   * reservation. Without the method customers might see some queries run on-demand which might be
   * unexpected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   AssignmentName name = AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
   *   String destinationId = "";
   *   Assignment response = reservationServiceClient.moveAssignment(name.toString(), destinationId);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the assignment, e.g.:
   *     projects/myproject/locations/US/reservations/team1-prod/assignments/123
   * @param destinationId The new reservation ID, e.g.:
   *     projects/myotherproject/locations/US/reservations/team2-prod
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment moveAssignment(String name, String destinationId) {
    MoveAssignmentRequest request =
        MoveAssignmentRequest.newBuilder().setName(name).setDestinationId(destinationId).build();
    return moveAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves a assignment under a new reservation. Customers can do this by deleting the existing
   * assignment followed by creating another assignment under the new reservation, but this method
   * provides a transactional way to do so, to make sure the assignee always has an associated
   * reservation. Without the method customers might see some queries run on-demand which might be
   * unexpected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   AssignmentName name = AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
   *   MoveAssignmentRequest request = MoveAssignmentRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Assignment response = reservationServiceClient.moveAssignment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment moveAssignment(MoveAssignmentRequest request) {
    return moveAssignmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves a assignment under a new reservation. Customers can do this by deleting the existing
   * assignment followed by creating another assignment under the new reservation, but this method
   * provides a transactional way to do so, to make sure the assignee always has an associated
   * reservation. Without the method customers might see some queries run on-demand which might be
   * unexpected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   AssignmentName name = AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
   *   MoveAssignmentRequest request = MoveAssignmentRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Assignment&gt; future = reservationServiceClient.moveAssignmentCallable().futureCall(request);
   *   // Do something
   *   Assignment response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<MoveAssignmentRequest, Assignment> moveAssignmentCallable() {
    return stub.moveAssignmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a BI reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   BiReservationName name = BiReservationName.of("[PROJECT]", "[LOCATION]");
   *   BiReservation response = reservationServiceClient.getBiReservation(name);
   * }
   * </code></pre>
   *
   * @param name Required. Name of the requested reservation, for example:
   *     `projects/{project_id}/locations/{location_id}/bireservation`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BiReservation getBiReservation(BiReservationName name) {
    GetBiReservationRequest request =
        GetBiReservationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBiReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a BI reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   BiReservationName name = BiReservationName.of("[PROJECT]", "[LOCATION]");
   *   BiReservation response = reservationServiceClient.getBiReservation(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. Name of the requested reservation, for example:
   *     `projects/{project_id}/locations/{location_id}/bireservation`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BiReservation getBiReservation(String name) {
    GetBiReservationRequest request = GetBiReservationRequest.newBuilder().setName(name).build();
    return getBiReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a BI reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   BiReservationName name = BiReservationName.of("[PROJECT]", "[LOCATION]");
   *   GetBiReservationRequest request = GetBiReservationRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   BiReservation response = reservationServiceClient.getBiReservation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BiReservation getBiReservation(GetBiReservationRequest request) {
    return getBiReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a BI reservation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   BiReservationName name = BiReservationName.of("[PROJECT]", "[LOCATION]");
   *   GetBiReservationRequest request = GetBiReservationRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;BiReservation&gt; future = reservationServiceClient.getBiReservationCallable().futureCall(request);
   *   // Do something
   *   BiReservation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetBiReservationRequest, BiReservation> getBiReservationCallable() {
    return stub.getBiReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a BI reservation. Only fields specified in the field_mask are updated. Singleton BI
   * reservation always exists with default size 0. In order to reserve BI capacity it needs to be
   * updated to an amount greater than 0. In order to release BI capacity reservation size must be
   * set to 0.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   BiReservation biReservation = BiReservation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BiReservation response = reservationServiceClient.updateBiReservation(biReservation, updateMask);
   * }
   * </code></pre>
   *
   * @param biReservation A reservation to update.
   * @param updateMask A list of fields to be updated in this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BiReservation updateBiReservation(
      BiReservation biReservation, FieldMask updateMask) {
    UpdateBiReservationRequest request =
        UpdateBiReservationRequest.newBuilder()
            .setBiReservation(biReservation)
            .setUpdateMask(updateMask)
            .build();
    return updateBiReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a BI reservation. Only fields specified in the field_mask are updated. Singleton BI
   * reservation always exists with default size 0. In order to reserve BI capacity it needs to be
   * updated to an amount greater than 0. In order to release BI capacity reservation size must be
   * set to 0.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   UpdateBiReservationRequest request = UpdateBiReservationRequest.newBuilder().build();
   *   BiReservation response = reservationServiceClient.updateBiReservation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BiReservation updateBiReservation(UpdateBiReservationRequest request) {
    return updateBiReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a BI reservation. Only fields specified in the field_mask are updated. Singleton BI
   * reservation always exists with default size 0. In order to reserve BI capacity it needs to be
   * updated to an amount greater than 0. In order to release BI capacity reservation size must be
   * set to 0.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   UpdateBiReservationRequest request = UpdateBiReservationRequest.newBuilder().build();
   *   ApiFuture&lt;BiReservation&gt; future = reservationServiceClient.updateBiReservationCallable().futureCall(request);
   *   // Do something
   *   BiReservation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateBiReservationRequest, BiReservation>
      updateBiReservationCallable() {
    return stub.updateBiReservationCallable();
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

  public static class ListReservationsPagedResponse
      extends AbstractPagedListResponse<
          ListReservationsRequest,
          ListReservationsResponse,
          Reservation,
          ListReservationsPage,
          ListReservationsFixedSizeCollection> {

    public static ApiFuture<ListReservationsPagedResponse> createAsync(
        PageContext<ListReservationsRequest, ListReservationsResponse, Reservation> context,
        ApiFuture<ListReservationsResponse> futureResponse) {
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
          ListReservationsRequest, ListReservationsResponse, Reservation, ListReservationsPage> {

    private ListReservationsPage(
        PageContext<ListReservationsRequest, ListReservationsResponse, Reservation> context,
        ListReservationsResponse response) {
      super(context, response);
    }

    private static ListReservationsPage createEmptyPage() {
      return new ListReservationsPage(null, null);
    }

    @Override
    protected ListReservationsPage createPage(
        PageContext<ListReservationsRequest, ListReservationsResponse, Reservation> context,
        ListReservationsResponse response) {
      return new ListReservationsPage(context, response);
    }

    @Override
    public ApiFuture<ListReservationsPage> createPageAsync(
        PageContext<ListReservationsRequest, ListReservationsResponse, Reservation> context,
        ApiFuture<ListReservationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReservationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReservationsRequest,
          ListReservationsResponse,
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

  public static class ListCapacityCommitmentsPagedResponse
      extends AbstractPagedListResponse<
          ListCapacityCommitmentsRequest,
          ListCapacityCommitmentsResponse,
          CapacityCommitment,
          ListCapacityCommitmentsPage,
          ListCapacityCommitmentsFixedSizeCollection> {

    public static ApiFuture<ListCapacityCommitmentsPagedResponse> createAsync(
        PageContext<
                ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse, CapacityCommitment>
            context,
        ApiFuture<ListCapacityCommitmentsResponse> futureResponse) {
      ApiFuture<ListCapacityCommitmentsPage> futurePage =
          ListCapacityCommitmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListCapacityCommitmentsPage, ListCapacityCommitmentsPagedResponse>() {
            @Override
            public ListCapacityCommitmentsPagedResponse apply(ListCapacityCommitmentsPage input) {
              return new ListCapacityCommitmentsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListCapacityCommitmentsPagedResponse(ListCapacityCommitmentsPage page) {
      super(page, ListCapacityCommitmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCapacityCommitmentsPage
      extends AbstractPage<
          ListCapacityCommitmentsRequest,
          ListCapacityCommitmentsResponse,
          CapacityCommitment,
          ListCapacityCommitmentsPage> {

    private ListCapacityCommitmentsPage(
        PageContext<
                ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse, CapacityCommitment>
            context,
        ListCapacityCommitmentsResponse response) {
      super(context, response);
    }

    private static ListCapacityCommitmentsPage createEmptyPage() {
      return new ListCapacityCommitmentsPage(null, null);
    }

    @Override
    protected ListCapacityCommitmentsPage createPage(
        PageContext<
                ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse, CapacityCommitment>
            context,
        ListCapacityCommitmentsResponse response) {
      return new ListCapacityCommitmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListCapacityCommitmentsPage> createPageAsync(
        PageContext<
                ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse, CapacityCommitment>
            context,
        ApiFuture<ListCapacityCommitmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCapacityCommitmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCapacityCommitmentsRequest,
          ListCapacityCommitmentsResponse,
          CapacityCommitment,
          ListCapacityCommitmentsPage,
          ListCapacityCommitmentsFixedSizeCollection> {

    private ListCapacityCommitmentsFixedSizeCollection(
        List<ListCapacityCommitmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCapacityCommitmentsFixedSizeCollection createEmptyCollection() {
      return new ListCapacityCommitmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCapacityCommitmentsFixedSizeCollection createCollection(
        List<ListCapacityCommitmentsPage> pages, int collectionSize) {
      return new ListCapacityCommitmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAssignmentsPagedResponse
      extends AbstractPagedListResponse<
          ListAssignmentsRequest,
          ListAssignmentsResponse,
          Assignment,
          ListAssignmentsPage,
          ListAssignmentsFixedSizeCollection> {

    public static ApiFuture<ListAssignmentsPagedResponse> createAsync(
        PageContext<ListAssignmentsRequest, ListAssignmentsResponse, Assignment> context,
        ApiFuture<ListAssignmentsResponse> futureResponse) {
      ApiFuture<ListAssignmentsPage> futurePage =
          ListAssignmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListAssignmentsPage, ListAssignmentsPagedResponse>() {
            @Override
            public ListAssignmentsPagedResponse apply(ListAssignmentsPage input) {
              return new ListAssignmentsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListAssignmentsPagedResponse(ListAssignmentsPage page) {
      super(page, ListAssignmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAssignmentsPage
      extends AbstractPage<
          ListAssignmentsRequest, ListAssignmentsResponse, Assignment, ListAssignmentsPage> {

    private ListAssignmentsPage(
        PageContext<ListAssignmentsRequest, ListAssignmentsResponse, Assignment> context,
        ListAssignmentsResponse response) {
      super(context, response);
    }

    private static ListAssignmentsPage createEmptyPage() {
      return new ListAssignmentsPage(null, null);
    }

    @Override
    protected ListAssignmentsPage createPage(
        PageContext<ListAssignmentsRequest, ListAssignmentsResponse, Assignment> context,
        ListAssignmentsResponse response) {
      return new ListAssignmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListAssignmentsPage> createPageAsync(
        PageContext<ListAssignmentsRequest, ListAssignmentsResponse, Assignment> context,
        ApiFuture<ListAssignmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAssignmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAssignmentsRequest,
          ListAssignmentsResponse,
          Assignment,
          ListAssignmentsPage,
          ListAssignmentsFixedSizeCollection> {

    private ListAssignmentsFixedSizeCollection(
        List<ListAssignmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAssignmentsFixedSizeCollection createEmptyCollection() {
      return new ListAssignmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAssignmentsFixedSizeCollection createCollection(
        List<ListAssignmentsPage> pages, int collectionSize) {
      return new ListAssignmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchAssignmentsPagedResponse
      extends AbstractPagedListResponse<
          SearchAssignmentsRequest,
          SearchAssignmentsResponse,
          Assignment,
          SearchAssignmentsPage,
          SearchAssignmentsFixedSizeCollection> {

    public static ApiFuture<SearchAssignmentsPagedResponse> createAsync(
        PageContext<SearchAssignmentsRequest, SearchAssignmentsResponse, Assignment> context,
        ApiFuture<SearchAssignmentsResponse> futureResponse) {
      ApiFuture<SearchAssignmentsPage> futurePage =
          SearchAssignmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchAssignmentsPage, SearchAssignmentsPagedResponse>() {
            @Override
            public SearchAssignmentsPagedResponse apply(SearchAssignmentsPage input) {
              return new SearchAssignmentsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private SearchAssignmentsPagedResponse(SearchAssignmentsPage page) {
      super(page, SearchAssignmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchAssignmentsPage
      extends AbstractPage<
          SearchAssignmentsRequest, SearchAssignmentsResponse, Assignment, SearchAssignmentsPage> {

    private SearchAssignmentsPage(
        PageContext<SearchAssignmentsRequest, SearchAssignmentsResponse, Assignment> context,
        SearchAssignmentsResponse response) {
      super(context, response);
    }

    private static SearchAssignmentsPage createEmptyPage() {
      return new SearchAssignmentsPage(null, null);
    }

    @Override
    protected SearchAssignmentsPage createPage(
        PageContext<SearchAssignmentsRequest, SearchAssignmentsResponse, Assignment> context,
        SearchAssignmentsResponse response) {
      return new SearchAssignmentsPage(context, response);
    }

    @Override
    public ApiFuture<SearchAssignmentsPage> createPageAsync(
        PageContext<SearchAssignmentsRequest, SearchAssignmentsResponse, Assignment> context,
        ApiFuture<SearchAssignmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchAssignmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchAssignmentsRequest,
          SearchAssignmentsResponse,
          Assignment,
          SearchAssignmentsPage,
          SearchAssignmentsFixedSizeCollection> {

    private SearchAssignmentsFixedSizeCollection(
        List<SearchAssignmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchAssignmentsFixedSizeCollection createEmptyCollection() {
      return new SearchAssignmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchAssignmentsFixedSizeCollection createCollection(
        List<SearchAssignmentsPage> pages, int collectionSize) {
      return new SearchAssignmentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
