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

package com.google.cloud.compute.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.ReservationsStub;
import com.google.cloud.compute.v1.stub.ReservationsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Reservations API.
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
 * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String reservation = "reservation-1563081780";
 *   Reservation response = reservationsClient.get(project, zone, reservation);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ReservationsClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of ReservationsSettings to
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
 * ReservationsSettings reservationsSettings =
 *     ReservationsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReservationsClient reservationsClient = ReservationsClient.create(reservationsSettings);
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
 * ReservationsSettings reservationsSettings =
 *     ReservationsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ReservationsClient reservationsClient = ReservationsClient.create(reservationsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ReservationsClient implements BackgroundResource {
  private final ReservationsSettings settings;
  private final ReservationsStub stub;

  /** Constructs an instance of ReservationsClient with default settings. */
  public static final ReservationsClient create() throws IOException {
    return create(ReservationsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ReservationsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ReservationsClient create(ReservationsSettings settings) throws IOException {
    return new ReservationsClient(settings);
  }

  /**
   * Constructs an instance of ReservationsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ReservationsSettings).
   */
  public static final ReservationsClient create(ReservationsStub stub) {
    return new ReservationsClient(stub);
  }

  /**
   * Constructs an instance of ReservationsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ReservationsClient(ReservationsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ReservationsStubSettings) settings.getStubSettings()).createStub();
  }

  protected ReservationsClient(ReservationsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ReservationsSettings getSettings() {
    return settings;
  }

  public ReservationsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, ReservationsScopedList> element :
   *       reservationsClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListReservationsRequest request =
        AggregatedListReservationsRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   AggregatedListReservationsRequest request =
   *       AggregatedListReservationsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Map.Entry<String, ReservationsScopedList> element :
   *       reservationsClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListReservationsRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   AggregatedListReservationsRequest request =
   *       AggregatedListReservationsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Map.Entry<String, ReservationsScopedList>> future =
   *       reservationsClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, ReservationsScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregatedListReservationsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   AggregatedListReservationsRequest request =
   *       AggregatedListReservationsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     ReservationAggregatedList response =
   *         reservationsClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, ReservationsScopedList> element : response.getItemsList()) {
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
  public final UnaryCallable<AggregatedListReservationsRequest, ReservationAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String reservation = "reservation-1563081780";
   *   Operation response = reservationsClient.deleteAsync(project, zone, reservation).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @param reservation Name of the reservation to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String zone, String reservation) {
    DeleteReservationRequest request =
        DeleteReservationRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setReservation(reservation)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   DeleteReservationRequest request =
   *       DeleteReservationRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservation("reservation-1563081780")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = reservationsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(DeleteReservationRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   DeleteReservationRequest request =
   *       DeleteReservationRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservation("reservation-1563081780")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       reservationsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteReservationRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   DeleteReservationRequest request =
   *       DeleteReservationRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservation("reservation-1563081780")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = reservationsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteReservationRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the specified reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String reservation = "reservation-1563081780";
   *   Reservation response = reservationsClient.get(project, zone, reservation);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @param reservation Name of the reservation to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation get(String project, String zone, String reservation) {
    GetReservationRequest request =
        GetReservationRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setReservation(reservation)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the specified reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   GetReservationRequest request =
   *       GetReservationRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setReservation("reservation-1563081780")
   *           .setZone("zone3744684")
   *           .build();
   *   Reservation response = reservationsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation get(GetReservationRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the specified reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   GetReservationRequest request =
   *       GetReservationRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setReservation("reservation-1563081780")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Reservation> future = reservationsClient.getCallable().futureCall(request);
   *   // Do something.
   *   Reservation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReservationRequest, Reservation> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String resource = "resource-341064690";
   *   Policy response = reservationsClient.getIamPolicy(project, zone, resource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String zone, String resource) {
    GetIamPolicyReservationRequest request =
        GetIamPolicyReservationRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setResource(resource)
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   GetIamPolicyReservationRequest request =
   *       GetIamPolicyReservationRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .build();
   *   Policy response = reservationsClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyReservationRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   GetIamPolicyReservationRequest request =
   *       GetIamPolicyReservationRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Policy> future = reservationsClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyReservationRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reservation. For more information, read Reserving zonal resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   Reservation reservationResource = Reservation.newBuilder().build();
   *   Operation response = reservationsClient.insertAsync(project, zone, reservationResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @param reservationResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String zone, Reservation reservationResource) {
    InsertReservationRequest request =
        InsertReservationRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setReservationResource(reservationResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reservation. For more information, read Reserving zonal resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   InsertReservationRequest request =
   *       InsertReservationRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservationResource(Reservation.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = reservationsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(InsertReservationRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reservation. For more information, read Reserving zonal resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   InsertReservationRequest request =
   *       InsertReservationRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservationResource(Reservation.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       reservationsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertReservationRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reservation. For more information, read Reserving zonal resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   InsertReservationRequest request =
   *       InsertReservationRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservationResource(Reservation.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = reservationsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertReservationRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A list of all the reservations that have been configured for the specified project in specified
   * zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   for (Reservation element : reservationsClient.list(project, zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone) {
    ListReservationsRequest request =
        ListReservationsRequest.newBuilder().setProject(project).setZone(zone).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A list of all the reservations that have been configured for the specified project in specified
   * zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   ListReservationsRequest request =
   *       ListReservationsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (Reservation element : reservationsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListReservationsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A list of all the reservations that have been configured for the specified project in specified
   * zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   ListReservationsRequest request =
   *       ListReservationsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Reservation> future = reservationsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Reservation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReservationsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A list of all the reservations that have been configured for the specified project in specified
   * zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   ListReservationsRequest request =
   *       ListReservationsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     ReservationList response = reservationsClient.listCallable().call(request);
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
   * }</pre>
   */
  public final UnaryCallable<ListReservationsRequest, ReservationList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resizes the reservation (applicable to standalone reservations only). For more information,
   * read Modifying reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String reservation = "reservation-1563081780";
   *   ReservationsResizeRequest reservationsResizeRequestResource =
   *       ReservationsResizeRequest.newBuilder().build();
   *   Operation response =
   *       reservationsClient
   *           .resizeAsync(project, zone, reservation, reservationsResizeRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @param reservation Name of the reservation to update.
   * @param reservationsResizeRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> resizeAsync(
      String project,
      String zone,
      String reservation,
      ReservationsResizeRequest reservationsResizeRequestResource) {
    ResizeReservationRequest request =
        ResizeReservationRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setReservation(reservation)
            .setReservationsResizeRequestResource(reservationsResizeRequestResource)
            .build();
    return resizeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resizes the reservation (applicable to standalone reservations only). For more information,
   * read Modifying reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   ResizeReservationRequest request =
   *       ResizeReservationRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservation("reservation-1563081780")
   *           .setReservationsResizeRequestResource(ReservationsResizeRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = reservationsClient.resizeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> resizeAsync(ResizeReservationRequest request) {
    return resizeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resizes the reservation (applicable to standalone reservations only). For more information,
   * read Modifying reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   ResizeReservationRequest request =
   *       ResizeReservationRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservation("reservation-1563081780")
   *           .setReservationsResizeRequestResource(ReservationsResizeRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       reservationsClient.resizeOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResizeReservationRequest, Operation, Operation>
      resizeOperationCallable() {
    return stub.resizeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resizes the reservation (applicable to standalone reservations only). For more information,
   * read Modifying reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   ResizeReservationRequest request =
   *       ResizeReservationRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservation("reservation-1563081780")
   *           .setReservationsResizeRequestResource(ReservationsResizeRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = reservationsClient.resizeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResizeReservationRequest, Operation> resizeCallable() {
    return stub.resizeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String resource = "resource-341064690";
   *   ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();
   *   Policy response =
   *       reservationsClient.setIamPolicy(project, zone, resource, zoneSetPolicyRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param resource Name or id of the resource for this request.
   * @param zoneSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project,
      String zone,
      String resource,
      ZoneSetPolicyRequest zoneSetPolicyRequestResource) {
    SetIamPolicyReservationRequest request =
        SetIamPolicyReservationRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setResource(resource)
            .setZoneSetPolicyRequestResource(zoneSetPolicyRequestResource)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   SetIamPolicyReservationRequest request =
   *       SetIamPolicyReservationRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .setZoneSetPolicyRequestResource(ZoneSetPolicyRequest.newBuilder().build())
   *           .build();
   *   Policy response = reservationsClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyReservationRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   SetIamPolicyReservationRequest request =
   *       SetIamPolicyReservationRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .setZoneSetPolicyRequestResource(ZoneSetPolicyRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = reservationsClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyReservationRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       reservationsClient.testIamPermissions(
   *           project, zone, resource, testPermissionsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project,
      String zone,
      String resource,
      TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsReservationRequest request =
        TestIamPermissionsReservationRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   TestIamPermissionsReservationRequest request =
   *       TestIamPermissionsReservationRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   TestPermissionsResponse response = reservationsClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsReservationRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   TestIamPermissionsReservationRequest request =
   *       TestIamPermissionsReservationRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       reservationsClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsReservationRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update share settings of the reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String reservation = "reservation-1563081780";
   *   Reservation reservationResource = Reservation.newBuilder().build();
   *   Operation response =
   *       reservationsClient.updateAsync(project, zone, reservation, reservationResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @param reservation Name of the reservation to update.
   * @param reservationResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      String project, String zone, String reservation, Reservation reservationResource) {
    UpdateReservationRequest request =
        UpdateReservationRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setReservation(reservation)
            .setReservationResource(reservationResource)
            .build();
    return updateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update share settings of the reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   UpdateReservationRequest request =
   *       UpdateReservationRequest.newBuilder()
   *           .setPaths("paths106438894")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservation("reservation-1563081780")
   *           .setReservationResource(Reservation.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = reservationsClient.updateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> updateAsync(UpdateReservationRequest request) {
    return updateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update share settings of the reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   UpdateReservationRequest request =
   *       UpdateReservationRequest.newBuilder()
   *           .setPaths("paths106438894")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservation("reservation-1563081780")
   *           .setReservationResource(Reservation.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       reservationsClient.updateOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateReservationRequest, Operation, Operation>
      updateOperationCallable() {
    return stub.updateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update share settings of the reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
   *   UpdateReservationRequest request =
   *       UpdateReservationRequest.newBuilder()
   *           .setPaths("paths106438894")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservation("reservation-1563081780")
   *           .setReservationResource(Reservation.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = reservationsClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateReservationRequest, Operation> updateCallable() {
    return stub.updateCallable();
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListReservationsRequest,
          ReservationAggregatedList,
          Map.Entry<String, ReservationsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListReservationsRequest,
                ReservationAggregatedList,
                Map.Entry<String, ReservationsScopedList>>
            context,
        ApiFuture<ReservationAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AggregatedListPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListReservationsRequest,
          ReservationAggregatedList,
          Map.Entry<String, ReservationsScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListReservationsRequest,
                ReservationAggregatedList,
                Map.Entry<String, ReservationsScopedList>>
            context,
        ReservationAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListReservationsRequest,
                ReservationAggregatedList,
                Map.Entry<String, ReservationsScopedList>>
            context,
        ReservationAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListReservationsRequest,
                ReservationAggregatedList,
                Map.Entry<String, ReservationsScopedList>>
            context,
        ApiFuture<ReservationAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListReservationsRequest,
          ReservationAggregatedList,
          Map.Entry<String, ReservationsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    private AggregatedListFixedSizeCollection(List<AggregatedListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListFixedSizeCollection createEmptyCollection() {
      return new AggregatedListFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListFixedSizeCollection createCollection(
        List<AggregatedListPage> pages, int collectionSize) {
      return new AggregatedListFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListReservationsRequest,
          ReservationList,
          Reservation,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListReservationsRequest, ReservationList, Reservation> context,
        ApiFuture<ReservationList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<ListReservationsRequest, ReservationList, Reservation, ListPage> {

    private ListPage(
        PageContext<ListReservationsRequest, ReservationList, Reservation> context,
        ReservationList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListReservationsRequest, ReservationList, Reservation> context,
        ReservationList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListReservationsRequest, ReservationList, Reservation> context,
        ApiFuture<ReservationList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReservationsRequest,
          ReservationList,
          Reservation,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
