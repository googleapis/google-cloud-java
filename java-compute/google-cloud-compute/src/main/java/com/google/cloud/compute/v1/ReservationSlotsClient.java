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
import com.google.cloud.compute.v1.stub.ReservationSlotsStub;
import com.google.cloud.compute.v1.stub.ReservationSlotsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The ReservationSlots API.
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
 * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String parentName = "parentName-244870571";
 *   String reservationSlot = "reservationSlot-337781782";
 *   ReservationSlotsGetResponse response =
 *       reservationSlotsClient.get(project, zone, parentName, reservationSlot);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ReservationSlotsClient object to clean up resources
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
 *      <td><p> Retrieves information about the specified reservation slot.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetReservationSlotRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String zone, String parentName, String reservationSlot)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVersion</td>
 *      <td><p> Allows customers to get SBOM versions of a reservation slot.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVersionAsync(GetVersionReservationSlotRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> getVersionAsync(String project, String zone, String parentName, String reservationSlot, ReservationSlotsGetVersionRequest reservationSlotsGetVersionRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVersionOperationCallable()
 *           <li><p> getVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Retrieves a list of reservation slots under a single reservation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListReservationSlotsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project, String zone, String parentName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPagedCallable()
 *           <li><p> listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Update</td>
 *      <td><p> Update a reservation slot in the specified sub-block.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAsync(UpdateReservationSlotRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateAsync(String project, String zone, String parentName, String reservationSlot, ReservationSlot reservationSlotResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateOperationCallable()
 *           <li><p> updateCallable()
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
 * <p>This class can be customized by passing in a custom instance of ReservationSlotsSettings to
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
 * ReservationSlotsSettings reservationSlotsSettings =
 *     ReservationSlotsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReservationSlotsClient reservationSlotsClient =
 *     ReservationSlotsClient.create(reservationSlotsSettings);
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
 * ReservationSlotsSettings reservationSlotsSettings =
 *     ReservationSlotsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ReservationSlotsClient reservationSlotsClient =
 *     ReservationSlotsClient.create(reservationSlotsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ReservationSlotsClient implements BackgroundResource {
  private final ReservationSlotsSettings settings;
  private final ReservationSlotsStub stub;

  /** Constructs an instance of ReservationSlotsClient with default settings. */
  public static final ReservationSlotsClient create() throws IOException {
    return create(ReservationSlotsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ReservationSlotsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ReservationSlotsClient create(ReservationSlotsSettings settings)
      throws IOException {
    return new ReservationSlotsClient(settings);
  }

  /**
   * Constructs an instance of ReservationSlotsClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ReservationSlotsSettings).
   */
  public static final ReservationSlotsClient create(ReservationSlotsStub stub) {
    return new ReservationSlotsClient(stub);
  }

  /**
   * Constructs an instance of ReservationSlotsClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ReservationSlotsClient(ReservationSlotsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ReservationSlotsStubSettings) settings.getStubSettings()).createStub();
  }

  protected ReservationSlotsClient(ReservationSlotsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ReservationSlotsSettings getSettings() {
    return settings;
  }

  public ReservationSlotsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the specified reservation slot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String parentName = "parentName-244870571";
   *   String reservationSlot = "reservationSlot-337781782";
   *   ReservationSlotsGetResponse response =
   *       reservationSlotsClient.get(project, zone, parentName, reservationSlot);
   * }
   * }</pre>
   *
   * @param project The project ID for this request.
   * @param zone The name of the zone for this request, formatted as RFC1035.
   * @param parentName The name of the parent reservation and parent block, formatted as
   *     reservations/{reservation_name}/reservationBlocks/{reservation_block_name}/reservationSubBlocks/{reservation_sub_block_name}
   * @param reservationSlot The name of the reservation slot, formatted as RFC1035 or a resource ID
   *     number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReservationSlotsGetResponse get(
      String project, String zone, String parentName, String reservationSlot) {
    GetReservationSlotRequest request =
        GetReservationSlotRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setParentName(parentName)
            .setReservationSlot(reservationSlot)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the specified reservation slot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
   *   GetReservationSlotRequest request =
   *       GetReservationSlotRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setReservationSlot("reservationSlot-337781782")
   *           .setZone("zone3744684")
   *           .build();
   *   ReservationSlotsGetResponse response = reservationSlotsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReservationSlotsGetResponse get(GetReservationSlotRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the specified reservation slot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
   *   GetReservationSlotRequest request =
   *       GetReservationSlotRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setReservationSlot("reservationSlot-337781782")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<ReservationSlotsGetResponse> future =
   *       reservationSlotsClient.getCallable().futureCall(request);
   *   // Do something.
   *   ReservationSlotsGetResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReservationSlotRequest, ReservationSlotsGetResponse> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to get SBOM versions of a reservation slot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String parentName = "parentName-244870571";
   *   String reservationSlot = "reservationSlot-337781782";
   *   ReservationSlotsGetVersionRequest reservationSlotsGetVersionRequestResource =
   *       ReservationSlotsGetVersionRequest.newBuilder().build();
   *   Operation response =
   *       reservationSlotsClient
   *           .getVersionAsync(
   *               project,
   *               zone,
   *               parentName,
   *               reservationSlot,
   *               reservationSlotsGetVersionRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request. Zone name should conform to RFC1035.
   * @param parentName The name of the parent reservation and parent block. In the format of
   *     reservations/{reservation_name}/reservationBlocks/{reservation_block_name}/reservationSubBlocks/{reservation_sub_block_name}
   * @param reservationSlot The name of the reservation slot. Name should conform to RFC1035 or be a
   *     resource ID.
   * @param reservationSlotsGetVersionRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> getVersionAsync(
      String project,
      String zone,
      String parentName,
      String reservationSlot,
      ReservationSlotsGetVersionRequest reservationSlotsGetVersionRequestResource) {
    GetVersionReservationSlotRequest request =
        GetVersionReservationSlotRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setParentName(parentName)
            .setReservationSlot(reservationSlot)
            .setReservationSlotsGetVersionRequestResource(reservationSlotsGetVersionRequestResource)
            .build();
    return getVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to get SBOM versions of a reservation slot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
   *   GetVersionReservationSlotRequest request =
   *       GetVersionReservationSlotRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservationSlot("reservationSlot-337781782")
   *           .setReservationSlotsGetVersionRequestResource(
   *               ReservationSlotsGetVersionRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = reservationSlotsClient.getVersionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> getVersionAsync(
      GetVersionReservationSlotRequest request) {
    return getVersionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to get SBOM versions of a reservation slot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
   *   GetVersionReservationSlotRequest request =
   *       GetVersionReservationSlotRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservationSlot("reservationSlot-337781782")
   *           .setReservationSlotsGetVersionRequestResource(
   *               ReservationSlotsGetVersionRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       reservationSlotsClient.getVersionOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<GetVersionReservationSlotRequest, Operation, Operation>
      getVersionOperationCallable() {
    return stub.getVersionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to get SBOM versions of a reservation slot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
   *   GetVersionReservationSlotRequest request =
   *       GetVersionReservationSlotRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservationSlot("reservationSlot-337781782")
   *           .setReservationSlotsGetVersionRequestResource(
   *               ReservationSlotsGetVersionRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = reservationSlotsClient.getVersionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVersionReservationSlotRequest, Operation> getVersionCallable() {
    return stub.getVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of reservation slots under a single reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String parentName = "parentName-244870571";
   *   for (ReservationSlot element :
   *       reservationSlotsClient.list(project, zone, parentName).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project The project ID for this request.
   * @param zone The name of the zone for this request, formatted as RFC1035.
   * @param parentName The name of the parent reservation and parent block, formatted as
   *     reservations/{reservation_name}/reservationBlocks/{reservation_block_name}/reservationSubBlocks/{reservation_sub_block_name}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone, String parentName) {
    ListReservationSlotsRequest request =
        ListReservationSlotsRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setParentName(parentName)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of reservation slots under a single reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
   *   ListReservationSlotsRequest request =
   *       ListReservationSlotsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (ReservationSlot element : reservationSlotsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListReservationSlotsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of reservation slots under a single reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
   *   ListReservationSlotsRequest request =
   *       ListReservationSlotsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<ReservationSlot> future =
   *       reservationSlotsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReservationSlot element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReservationSlotsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of reservation slots under a single reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
   *   ListReservationSlotsRequest request =
   *       ListReservationSlotsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     ReservationSlotsListResponse response = reservationSlotsClient.listCallable().call(request);
   *     for (ReservationSlot element : response.getItemsList()) {
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
  public final UnaryCallable<ListReservationSlotsRequest, ReservationSlotsListResponse>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a reservation slot in the specified sub-block.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String parentName = "parentName-244870571";
   *   String reservationSlot = "reservationSlot-337781782";
   *   ReservationSlot reservationSlotResource = ReservationSlot.newBuilder().build();
   *   Operation response =
   *       reservationSlotsClient
   *           .updateAsync(project, zone, parentName, reservationSlot, reservationSlotResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project The project ID for this request.
   * @param zone The name of the zone for this request, formatted as RFC1035.
   * @param parentName The name of the sub-block resource.
   * @param reservationSlot The name of the slot resource.
   * @param reservationSlotResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      String project,
      String zone,
      String parentName,
      String reservationSlot,
      ReservationSlot reservationSlotResource) {
    UpdateReservationSlotRequest request =
        UpdateReservationSlotRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setParentName(parentName)
            .setReservationSlot(reservationSlot)
            .setReservationSlotResource(reservationSlotResource)
            .build();
    return updateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a reservation slot in the specified sub-block.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
   *   UpdateReservationSlotRequest request =
   *       UpdateReservationSlotRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setReservationSlot("reservationSlot-337781782")
   *           .setReservationSlotResource(ReservationSlot.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = reservationSlotsClient.updateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      UpdateReservationSlotRequest request) {
    return updateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a reservation slot in the specified sub-block.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
   *   UpdateReservationSlotRequest request =
   *       UpdateReservationSlotRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setReservationSlot("reservationSlot-337781782")
   *           .setReservationSlotResource(ReservationSlot.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       reservationSlotsClient.updateOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateReservationSlotRequest, Operation, Operation>
      updateOperationCallable() {
    return stub.updateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a reservation slot in the specified sub-block.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSlotsClient reservationSlotsClient = ReservationSlotsClient.create()) {
   *   UpdateReservationSlotRequest request =
   *       UpdateReservationSlotRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setReservationSlot("reservationSlot-337781782")
   *           .setReservationSlotResource(ReservationSlot.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = reservationSlotsClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateReservationSlotRequest, Operation> updateCallable() {
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListReservationSlotsRequest,
          ReservationSlotsListResponse,
          ReservationSlot,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListReservationSlotsRequest, ReservationSlotsListResponse, ReservationSlot>
            context,
        ApiFuture<ReservationSlotsListResponse> futureResponse) {
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
          ListReservationSlotsRequest, ReservationSlotsListResponse, ReservationSlot, ListPage> {

    private ListPage(
        PageContext<ListReservationSlotsRequest, ReservationSlotsListResponse, ReservationSlot>
            context,
        ReservationSlotsListResponse response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListReservationSlotsRequest, ReservationSlotsListResponse, ReservationSlot>
            context,
        ReservationSlotsListResponse response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListReservationSlotsRequest, ReservationSlotsListResponse, ReservationSlot>
            context,
        ApiFuture<ReservationSlotsListResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReservationSlotsRequest,
          ReservationSlotsListResponse,
          ReservationSlot,
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
