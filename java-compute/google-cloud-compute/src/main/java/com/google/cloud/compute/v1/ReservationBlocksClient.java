/*
 * Copyright 2025 Google LLC
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
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.ReservationBlocksStub;
import com.google.cloud.compute.v1.stub.ReservationBlocksStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The ReservationBlocks API.
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
 * try (ReservationBlocksClient reservationBlocksClient = ReservationBlocksClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String reservation = "reservation-1563081780";
 *   String reservationBlock = "reservationBlock-1897000927";
 *   ReservationBlocksGetResponse response =
 *       reservationBlocksClient.get(project, zone, reservation, reservationBlock);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ReservationBlocksClient object to clean up resources
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
 *      <td><p> Get</td>
 *      <td><p> Retrieves information about the specified reservation block.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetReservationBlockRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String zone, String reservation, String reservationBlock)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Retrieves a list of reservation blocks under a single reservation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListReservationBlocksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project, String zone, String reservation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPagedCallable()
 *           <li><p> listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PerformMaintenance</td>
 *      <td><p> Allows customers to perform maintenance on a reservation block</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> performMaintenanceAsync(PerformMaintenanceReservationBlockRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> performMaintenanceAsync(String project, String zone, String reservation, String reservationBlock, ReservationsBlocksPerformMaintenanceRequest reservationsBlocksPerformMaintenanceRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> performMaintenanceOperationCallable()
 *           <li><p> performMaintenanceCallable()
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
 * <p>This class can be customized by passing in a custom instance of ReservationBlocksSettings to
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
 * ReservationBlocksSettings reservationBlocksSettings =
 *     ReservationBlocksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReservationBlocksClient reservationBlocksClient =
 *     ReservationBlocksClient.create(reservationBlocksSettings);
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
 * ReservationBlocksSettings reservationBlocksSettings =
 *     ReservationBlocksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ReservationBlocksClient reservationBlocksClient =
 *     ReservationBlocksClient.create(reservationBlocksSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ReservationBlocksClient implements BackgroundResource {
  private final ReservationBlocksSettings settings;
  private final ReservationBlocksStub stub;

  /** Constructs an instance of ReservationBlocksClient with default settings. */
  public static final ReservationBlocksClient create() throws IOException {
    return create(ReservationBlocksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ReservationBlocksClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ReservationBlocksClient create(ReservationBlocksSettings settings)
      throws IOException {
    return new ReservationBlocksClient(settings);
  }

  /**
   * Constructs an instance of ReservationBlocksClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ReservationBlocksSettings).
   */
  public static final ReservationBlocksClient create(ReservationBlocksStub stub) {
    return new ReservationBlocksClient(stub);
  }

  /**
   * Constructs an instance of ReservationBlocksClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ReservationBlocksClient(ReservationBlocksSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ReservationBlocksStubSettings) settings.getStubSettings()).createStub();
  }

  protected ReservationBlocksClient(ReservationBlocksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ReservationBlocksSettings getSettings() {
    return settings;
  }

  public ReservationBlocksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the specified reservation block.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationBlocksClient reservationBlocksClient = ReservationBlocksClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String reservation = "reservation-1563081780";
   *   String reservationBlock = "reservationBlock-1897000927";
   *   ReservationBlocksGetResponse response =
   *       reservationBlocksClient.get(project, zone, reservation, reservationBlock);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request. Zone name should conform to RFC1035.
   * @param reservation The name of the reservation. Name should conform to RFC1035 or be a resource
   *     ID.
   * @param reservationBlock The name of the reservation block. Name should conform to RFC1035 or be
   *     a resource ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReservationBlocksGetResponse get(
      String project, String zone, String reservation, String reservationBlock) {
    GetReservationBlockRequest request =
        GetReservationBlockRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setReservation(reservation)
            .setReservationBlock(reservationBlock)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the specified reservation block.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationBlocksClient reservationBlocksClient = ReservationBlocksClient.create()) {
   *   GetReservationBlockRequest request =
   *       GetReservationBlockRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setReservation("reservation-1563081780")
   *           .setReservationBlock("reservationBlock-1897000927")
   *           .setView("view3619493")
   *           .setZone("zone3744684")
   *           .build();
   *   ReservationBlocksGetResponse response = reservationBlocksClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReservationBlocksGetResponse get(GetReservationBlockRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the specified reservation block.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationBlocksClient reservationBlocksClient = ReservationBlocksClient.create()) {
   *   GetReservationBlockRequest request =
   *       GetReservationBlockRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setReservation("reservation-1563081780")
   *           .setReservationBlock("reservationBlock-1897000927")
   *           .setView("view3619493")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<ReservationBlocksGetResponse> future =
   *       reservationBlocksClient.getCallable().futureCall(request);
   *   // Do something.
   *   ReservationBlocksGetResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReservationBlockRequest, ReservationBlocksGetResponse>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of reservation blocks under a single reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationBlocksClient reservationBlocksClient = ReservationBlocksClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String reservation = "reservation-1563081780";
   *   for (ReservationBlock element :
   *       reservationBlocksClient.list(project, zone, reservation).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request. Zone name should conform to RFC1035.
   * @param reservation The name of the reservation. Name should conform to RFC1035 or be a resource
   *     ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone, String reservation) {
    ListReservationBlocksRequest request =
        ListReservationBlocksRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setReservation(reservation)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of reservation blocks under a single reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationBlocksClient reservationBlocksClient = ReservationBlocksClient.create()) {
   *   ListReservationBlocksRequest request =
   *       ListReservationBlocksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReservation("reservation-1563081780")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (ReservationBlock element : reservationBlocksClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListReservationBlocksRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of reservation blocks under a single reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationBlocksClient reservationBlocksClient = ReservationBlocksClient.create()) {
   *   ListReservationBlocksRequest request =
   *       ListReservationBlocksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReservation("reservation-1563081780")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<ReservationBlock> future =
   *       reservationBlocksClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReservationBlock element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReservationBlocksRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of reservation blocks under a single reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationBlocksClient reservationBlocksClient = ReservationBlocksClient.create()) {
   *   ListReservationBlocksRequest request =
   *       ListReservationBlocksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReservation("reservation-1563081780")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     ReservationBlocksListResponse response =
   *         reservationBlocksClient.listCallable().call(request);
   *     for (ReservationBlock element : response.getItemsList()) {
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
  public final UnaryCallable<ListReservationBlocksRequest, ReservationBlocksListResponse>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to perform maintenance on a reservation block
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationBlocksClient reservationBlocksClient = ReservationBlocksClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String reservation = "reservation-1563081780";
   *   String reservationBlock = "reservationBlock-1897000927";
   *   ReservationsBlocksPerformMaintenanceRequest
   *       reservationsBlocksPerformMaintenanceRequestResource =
   *           ReservationsBlocksPerformMaintenanceRequest.newBuilder().build();
   *   Operation response =
   *       reservationBlocksClient
   *           .performMaintenanceAsync(
   *               project,
   *               zone,
   *               reservation,
   *               reservationBlock,
   *               reservationsBlocksPerformMaintenanceRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request. Zone name should conform to RFC1035.
   * @param reservation The name of the reservation. Name should conform to RFC1035 or be a resource
   *     ID.
   * @param reservationBlock The name of the reservation block. Name should conform to RFC1035 or be
   *     a resource ID.
   * @param reservationsBlocksPerformMaintenanceRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> performMaintenanceAsync(
      String project,
      String zone,
      String reservation,
      String reservationBlock,
      ReservationsBlocksPerformMaintenanceRequest
          reservationsBlocksPerformMaintenanceRequestResource) {
    PerformMaintenanceReservationBlockRequest request =
        PerformMaintenanceReservationBlockRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setReservation(reservation)
            .setReservationBlock(reservationBlock)
            .setReservationsBlocksPerformMaintenanceRequestResource(
                reservationsBlocksPerformMaintenanceRequestResource)
            .build();
    return performMaintenanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to perform maintenance on a reservation block
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationBlocksClient reservationBlocksClient = ReservationBlocksClient.create()) {
   *   PerformMaintenanceReservationBlockRequest request =
   *       PerformMaintenanceReservationBlockRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservation("reservation-1563081780")
   *           .setReservationBlock("reservationBlock-1897000927")
   *           .setReservationsBlocksPerformMaintenanceRequestResource(
   *               ReservationsBlocksPerformMaintenanceRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = reservationBlocksClient.performMaintenanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> performMaintenanceAsync(
      PerformMaintenanceReservationBlockRequest request) {
    return performMaintenanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to perform maintenance on a reservation block
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationBlocksClient reservationBlocksClient = ReservationBlocksClient.create()) {
   *   PerformMaintenanceReservationBlockRequest request =
   *       PerformMaintenanceReservationBlockRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservation("reservation-1563081780")
   *           .setReservationBlock("reservationBlock-1897000927")
   *           .setReservationsBlocksPerformMaintenanceRequestResource(
   *               ReservationsBlocksPerformMaintenanceRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       reservationBlocksClient.performMaintenanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PerformMaintenanceReservationBlockRequest, Operation, Operation>
      performMaintenanceOperationCallable() {
    return stub.performMaintenanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to perform maintenance on a reservation block
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationBlocksClient reservationBlocksClient = ReservationBlocksClient.create()) {
   *   PerformMaintenanceReservationBlockRequest request =
   *       PerformMaintenanceReservationBlockRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservation("reservation-1563081780")
   *           .setReservationBlock("reservationBlock-1897000927")
   *           .setReservationsBlocksPerformMaintenanceRequestResource(
   *               ReservationsBlocksPerformMaintenanceRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       reservationBlocksClient.performMaintenanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PerformMaintenanceReservationBlockRequest, Operation>
      performMaintenanceCallable() {
    return stub.performMaintenanceCallable();
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListReservationBlocksRequest,
          ReservationBlocksListResponse,
          ReservationBlock,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListReservationBlocksRequest, ReservationBlocksListResponse, ReservationBlock>
            context,
        ApiFuture<ReservationBlocksListResponse> futureResponse) {
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
      extends AbstractPage<
          ListReservationBlocksRequest, ReservationBlocksListResponse, ReservationBlock, ListPage> {

    private ListPage(
        PageContext<ListReservationBlocksRequest, ReservationBlocksListResponse, ReservationBlock>
            context,
        ReservationBlocksListResponse response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListReservationBlocksRequest, ReservationBlocksListResponse, ReservationBlock>
            context,
        ReservationBlocksListResponse response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListReservationBlocksRequest, ReservationBlocksListResponse, ReservationBlock>
            context,
        ApiFuture<ReservationBlocksListResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReservationBlocksRequest,
          ReservationBlocksListResponse,
          ReservationBlock,
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
