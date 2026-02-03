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
import com.google.cloud.compute.v1.stub.ReservationSubBlocksStub;
import com.google.cloud.compute.v1.stub.ReservationSubBlocksStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The ReservationSubBlocks API.
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
 * try (ReservationSubBlocksClient reservationSubBlocksClient =
 *     ReservationSubBlocksClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String parentName = "parentName-244870571";
 *   String reservationSubBlock = "reservationSubBlock-1816847847";
 *   ReservationSubBlocksGetResponse response =
 *       reservationSubBlocksClient.get(project, zone, parentName, reservationSubBlock);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ReservationSubBlocksClient object to clean up
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
 *      <td><p> Get</td>
 *      <td><p> Retrieves information about the specified reservation subBlock.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetReservationSubBlockRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String zone, String parentName, String reservationSubBlock)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. May be empty if no such policy or resource exists.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyReservationSubBlockRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIamPolicy(String project, String zone, String parentResource, String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Retrieves a list of reservation subBlocks under a single reservation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListReservationSubBlocksRequest request)
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
 *      <td><p> PerformMaintenance</td>
 *      <td><p> Allows customers to perform maintenance on a reservation subBlock</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> performMaintenanceAsync(PerformMaintenanceReservationSubBlockRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> performMaintenanceAsync(String project, String zone, String parentName, String reservationSubBlock)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> performMaintenanceOperationCallable()
 *           <li><p> performMaintenanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ReportFaulty</td>
 *      <td><p> Allows customers to report a faulty subBlock.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> reportFaultyAsync(ReportFaultyReservationSubBlockRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> reportFaultyAsync(String project, String zone, String parentName, String reservationSubBlock, ReservationSubBlocksReportFaultyRequest reservationSubBlocksReportFaultyRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> reportFaultyOperationCallable()
 *           <li><p> reportFaultyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replaces any existing policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyReservationSubBlockRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setIamPolicy(String project, String zone, String parentResource, String resource, ZoneSetNestedPolicyRequest zoneSetNestedPolicyRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsReservationSubBlockRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> testIamPermissions(String project, String zone, String parentResource, String resource, TestPermissionsRequest testPermissionsRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of ReservationSubBlocksSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReservationSubBlocksSettings reservationSubBlocksSettings =
 *     ReservationSubBlocksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReservationSubBlocksClient reservationSubBlocksClient =
 *     ReservationSubBlocksClient.create(reservationSubBlocksSettings);
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
 * ReservationSubBlocksSettings reservationSubBlocksSettings =
 *     ReservationSubBlocksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ReservationSubBlocksClient reservationSubBlocksClient =
 *     ReservationSubBlocksClient.create(reservationSubBlocksSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ReservationSubBlocksClient implements BackgroundResource {
  private final ReservationSubBlocksSettings settings;
  private final ReservationSubBlocksStub stub;

  /** Constructs an instance of ReservationSubBlocksClient with default settings. */
  public static final ReservationSubBlocksClient create() throws IOException {
    return create(ReservationSubBlocksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ReservationSubBlocksClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ReservationSubBlocksClient create(ReservationSubBlocksSettings settings)
      throws IOException {
    return new ReservationSubBlocksClient(settings);
  }

  /**
   * Constructs an instance of ReservationSubBlocksClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ReservationSubBlocksSettings).
   */
  public static final ReservationSubBlocksClient create(ReservationSubBlocksStub stub) {
    return new ReservationSubBlocksClient(stub);
  }

  /**
   * Constructs an instance of ReservationSubBlocksClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ReservationSubBlocksClient(ReservationSubBlocksSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ReservationSubBlocksStubSettings) settings.getStubSettings()).createStub();
  }

  protected ReservationSubBlocksClient(ReservationSubBlocksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ReservationSubBlocksSettings getSettings() {
    return settings;
  }

  public ReservationSubBlocksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the specified reservation subBlock.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String parentName = "parentName-244870571";
   *   String reservationSubBlock = "reservationSubBlock-1816847847";
   *   ReservationSubBlocksGetResponse response =
   *       reservationSubBlocksClient.get(project, zone, parentName, reservationSubBlock);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request. Zone name should conform to RFC1035.
   * @param parentName The name of the parent reservation and parent block. In the format of
   *     reservations/{reservation_name}/reservationBlocks/{reservation_block_name}
   * @param reservationSubBlock The name of the reservation subBlock. Name should conform to RFC1035
   *     or be a resource ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReservationSubBlocksGetResponse get(
      String project, String zone, String parentName, String reservationSubBlock) {
    GetReservationSubBlockRequest request =
        GetReservationSubBlockRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setParentName(parentName)
            .setReservationSubBlock(reservationSubBlock)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the specified reservation subBlock.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   GetReservationSubBlockRequest request =
   *       GetReservationSubBlockRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setReservationSubBlock("reservationSubBlock-1816847847")
   *           .setView("view3619493")
   *           .setZone("zone3744684")
   *           .build();
   *   ReservationSubBlocksGetResponse response = reservationSubBlocksClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReservationSubBlocksGetResponse get(GetReservationSubBlockRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the specified reservation subBlock.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   GetReservationSubBlockRequest request =
   *       GetReservationSubBlockRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setReservationSubBlock("reservationSubBlock-1816847847")
   *           .setView("view3619493")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<ReservationSubBlocksGetResponse> future =
   *       reservationSubBlocksClient.getCallable().futureCall(request);
   *   // Do something.
   *   ReservationSubBlocksGetResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReservationSubBlockRequest, ReservationSubBlocksGetResponse>
      getCallable() {
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
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String parentResource = "parentResource1914365656";
   *   String resource = "resource-341064690";
   *   Policy response =
   *       reservationSubBlocksClient.getIamPolicy(project, zone, parentResource, resource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param parentResource Name or id of parent resource of the resource for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(
      String project, String zone, String parentResource, String resource) {
    GetIamPolicyReservationSubBlockRequest request =
        GetIamPolicyReservationSubBlockRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setParentResource(parentResource)
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
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   GetIamPolicyReservationSubBlockRequest request =
   *       GetIamPolicyReservationSubBlockRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setParentResource("parentResource1914365656")
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .build();
   *   Policy response = reservationSubBlocksClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyReservationSubBlockRequest request) {
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
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   GetIamPolicyReservationSubBlockRequest request =
   *       GetIamPolicyReservationSubBlockRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setParentResource("parentResource1914365656")
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Policy> future =
   *       reservationSubBlocksClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyReservationSubBlockRequest, Policy>
      getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of reservation subBlocks under a single reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String parentName = "parentName-244870571";
   *   for (ReservationSubBlock element :
   *       reservationSubBlocksClient.list(project, zone, parentName).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request. Zone name should conform to RFC1035.
   * @param parentName The name of the parent reservation and parent block. In the format of
   *     reservations/{reservation_name}/reservationBlocks/{reservation_block_name}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone, String parentName) {
    ListReservationSubBlocksRequest request =
        ListReservationSubBlocksRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setParentName(parentName)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of reservation subBlocks under a single reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   ListReservationSubBlocksRequest request =
   *       ListReservationSubBlocksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (ReservationSubBlock element : reservationSubBlocksClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListReservationSubBlocksRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of reservation subBlocks under a single reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   ListReservationSubBlocksRequest request =
   *       ListReservationSubBlocksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<ReservationSubBlock> future =
   *       reservationSubBlocksClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReservationSubBlock element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReservationSubBlocksRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of reservation subBlocks under a single reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   ListReservationSubBlocksRequest request =
   *       ListReservationSubBlocksRequest.newBuilder()
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
   *     ReservationSubBlocksListResponse response =
   *         reservationSubBlocksClient.listCallable().call(request);
   *     for (ReservationSubBlock element : response.getItemsList()) {
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
  public final UnaryCallable<ListReservationSubBlocksRequest, ReservationSubBlocksListResponse>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to perform maintenance on a reservation subBlock
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String parentName = "parentName-244870571";
   *   String reservationSubBlock = "reservationSubBlock-1816847847";
   *   Operation response =
   *       reservationSubBlocksClient
   *           .performMaintenanceAsync(project, zone, parentName, reservationSubBlock)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request. Zone name should conform to RFC1035.
   * @param parentName The name of the parent reservation and parent block. In the format of
   *     reservations/{reservation_name}/reservationBlocks/{reservation_block_name}
   * @param reservationSubBlock The name of the reservation subBlock. Name should conform to RFC1035
   *     or be a resource ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> performMaintenanceAsync(
      String project, String zone, String parentName, String reservationSubBlock) {
    PerformMaintenanceReservationSubBlockRequest request =
        PerformMaintenanceReservationSubBlockRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setParentName(parentName)
            .setReservationSubBlock(reservationSubBlock)
            .build();
    return performMaintenanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to perform maintenance on a reservation subBlock
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   PerformMaintenanceReservationSubBlockRequest request =
   *       PerformMaintenanceReservationSubBlockRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservationSubBlock("reservationSubBlock-1816847847")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = reservationSubBlocksClient.performMaintenanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> performMaintenanceAsync(
      PerformMaintenanceReservationSubBlockRequest request) {
    return performMaintenanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to perform maintenance on a reservation subBlock
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   PerformMaintenanceReservationSubBlockRequest request =
   *       PerformMaintenanceReservationSubBlockRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservationSubBlock("reservationSubBlock-1816847847")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       reservationSubBlocksClient.performMaintenanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PerformMaintenanceReservationSubBlockRequest, Operation, Operation>
      performMaintenanceOperationCallable() {
    return stub.performMaintenanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to perform maintenance on a reservation subBlock
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   PerformMaintenanceReservationSubBlockRequest request =
   *       PerformMaintenanceReservationSubBlockRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservationSubBlock("reservationSubBlock-1816847847")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       reservationSubBlocksClient.performMaintenanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PerformMaintenanceReservationSubBlockRequest, Operation>
      performMaintenanceCallable() {
    return stub.performMaintenanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to report a faulty subBlock.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String parentName = "parentName-244870571";
   *   String reservationSubBlock = "reservationSubBlock-1816847847";
   *   ReservationSubBlocksReportFaultyRequest reservationSubBlocksReportFaultyRequestResource =
   *       ReservationSubBlocksReportFaultyRequest.newBuilder().build();
   *   Operation response =
   *       reservationSubBlocksClient
   *           .reportFaultyAsync(
   *               project,
   *               zone,
   *               parentName,
   *               reservationSubBlock,
   *               reservationSubBlocksReportFaultyRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request. Zone name should conform to RFC1035.
   * @param parentName The name of the parent reservation and parent block. In the format of
   *     reservations/{reservation_name}/reservationBlocks/{reservation_block_name}
   * @param reservationSubBlock The name of the reservation subBlock. Name should conform to RFC1035
   *     or be a resource ID.
   * @param reservationSubBlocksReportFaultyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> reportFaultyAsync(
      String project,
      String zone,
      String parentName,
      String reservationSubBlock,
      ReservationSubBlocksReportFaultyRequest reservationSubBlocksReportFaultyRequestResource) {
    ReportFaultyReservationSubBlockRequest request =
        ReportFaultyReservationSubBlockRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setParentName(parentName)
            .setReservationSubBlock(reservationSubBlock)
            .setReservationSubBlocksReportFaultyRequestResource(
                reservationSubBlocksReportFaultyRequestResource)
            .build();
    return reportFaultyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to report a faulty subBlock.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   ReportFaultyReservationSubBlockRequest request =
   *       ReportFaultyReservationSubBlockRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservationSubBlock("reservationSubBlock-1816847847")
   *           .setReservationSubBlocksReportFaultyRequestResource(
   *               ReservationSubBlocksReportFaultyRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = reservationSubBlocksClient.reportFaultyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> reportFaultyAsync(
      ReportFaultyReservationSubBlockRequest request) {
    return reportFaultyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to report a faulty subBlock.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   ReportFaultyReservationSubBlockRequest request =
   *       ReportFaultyReservationSubBlockRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservationSubBlock("reservationSubBlock-1816847847")
   *           .setReservationSubBlocksReportFaultyRequestResource(
   *               ReservationSubBlocksReportFaultyRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       reservationSubBlocksClient.reportFaultyOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ReportFaultyReservationSubBlockRequest, Operation, Operation>
      reportFaultyOperationCallable() {
    return stub.reportFaultyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to report a faulty subBlock.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   ReportFaultyReservationSubBlockRequest request =
   *       ReportFaultyReservationSubBlockRequest.newBuilder()
   *           .setParentName("parentName-244870571")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setReservationSubBlock("reservationSubBlock-1816847847")
   *           .setReservationSubBlocksReportFaultyRequestResource(
   *               ReservationSubBlocksReportFaultyRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       reservationSubBlocksClient.reportFaultyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReportFaultyReservationSubBlockRequest, Operation>
      reportFaultyCallable() {
    return stub.reportFaultyCallable();
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
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String parentResource = "parentResource1914365656";
   *   String resource = "resource-341064690";
   *   ZoneSetNestedPolicyRequest zoneSetNestedPolicyRequestResource =
   *       ZoneSetNestedPolicyRequest.newBuilder().build();
   *   Policy response =
   *       reservationSubBlocksClient.setIamPolicy(
   *           project, zone, parentResource, resource, zoneSetNestedPolicyRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param parentResource Name or id of parent resource of the resource for this request.
   * @param resource Name or id of the resource for this request.
   * @param zoneSetNestedPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project,
      String zone,
      String parentResource,
      String resource,
      ZoneSetNestedPolicyRequest zoneSetNestedPolicyRequestResource) {
    SetIamPolicyReservationSubBlockRequest request =
        SetIamPolicyReservationSubBlockRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setParentResource(parentResource)
            .setResource(resource)
            .setZoneSetNestedPolicyRequestResource(zoneSetNestedPolicyRequestResource)
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
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   SetIamPolicyReservationSubBlockRequest request =
   *       SetIamPolicyReservationSubBlockRequest.newBuilder()
   *           .setParentResource("parentResource1914365656")
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .setZoneSetNestedPolicyRequestResource(
   *               ZoneSetNestedPolicyRequest.newBuilder().build())
   *           .build();
   *   Policy response = reservationSubBlocksClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyReservationSubBlockRequest request) {
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
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   SetIamPolicyReservationSubBlockRequest request =
   *       SetIamPolicyReservationSubBlockRequest.newBuilder()
   *           .setParentResource("parentResource1914365656")
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .setZoneSetNestedPolicyRequestResource(
   *               ZoneSetNestedPolicyRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       reservationSubBlocksClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyReservationSubBlockRequest, Policy>
      setIamPolicyCallable() {
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
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String parentResource = "parentResource1914365656";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       reservationSubBlocksClient.testIamPermissions(
   *           project, zone, parentResource, resource, testPermissionsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param parentResource Name or id of parent resource of the resource for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project,
      String zone,
      String parentResource,
      String resource,
      TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsReservationSubBlockRequest request =
        TestIamPermissionsReservationSubBlockRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setParentResource(parentResource)
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
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   TestIamPermissionsReservationSubBlockRequest request =
   *       TestIamPermissionsReservationSubBlockRequest.newBuilder()
   *           .setParentResource("parentResource1914365656")
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   TestPermissionsResponse response = reservationSubBlocksClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsReservationSubBlockRequest request) {
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
   * try (ReservationSubBlocksClient reservationSubBlocksClient =
   *     ReservationSubBlocksClient.create()) {
   *   TestIamPermissionsReservationSubBlockRequest request =
   *       TestIamPermissionsReservationSubBlockRequest.newBuilder()
   *           .setParentResource("parentResource1914365656")
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       reservationSubBlocksClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsReservationSubBlockRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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
          ListReservationSubBlocksRequest,
          ReservationSubBlocksListResponse,
          ReservationSubBlock,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListReservationSubBlocksRequest,
                ReservationSubBlocksListResponse,
                ReservationSubBlock>
            context,
        ApiFuture<ReservationSubBlocksListResponse> futureResponse) {
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
          ListReservationSubBlocksRequest,
          ReservationSubBlocksListResponse,
          ReservationSubBlock,
          ListPage> {

    private ListPage(
        PageContext<
                ListReservationSubBlocksRequest,
                ReservationSubBlocksListResponse,
                ReservationSubBlock>
            context,
        ReservationSubBlocksListResponse response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListReservationSubBlocksRequest,
                ReservationSubBlocksListResponse,
                ReservationSubBlock>
            context,
        ReservationSubBlocksListResponse response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListReservationSubBlocksRequest,
                ReservationSubBlocksListResponse,
                ReservationSubBlock>
            context,
        ApiFuture<ReservationSubBlocksListResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReservationSubBlocksRequest,
          ReservationSubBlocksListResponse,
          ReservationSubBlock,
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
