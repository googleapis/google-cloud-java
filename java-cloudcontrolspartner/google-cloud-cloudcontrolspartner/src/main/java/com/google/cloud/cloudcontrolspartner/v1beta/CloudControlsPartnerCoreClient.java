/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.cloudcontrolspartner.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudcontrolspartner.v1beta.stub.CloudControlsPartnerCoreStub;
import com.google.cloud.cloudcontrolspartner.v1beta.stub.CloudControlsPartnerCoreStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources
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
 * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
 *     CloudControlsPartnerCoreClient.create()) {
 *   WorkloadName name =
 *       WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");
 *   Workload response = cloudControlsPartnerCoreClient.getWorkload(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CloudControlsPartnerCoreClient object to clean up
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
 *      <td><p> GetWorkload</td>
 *      <td><p> Gets details of a single workload</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getWorkload(GetWorkloadRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getWorkload(WorkloadName name)
 *           <li><p> getWorkload(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getWorkloadCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListWorkloads</td>
 *      <td><p> Lists customer workloads for a given customer org id</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listWorkloads(ListWorkloadsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listWorkloads(CustomerName parent)
 *           <li><p> listWorkloads(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listWorkloadsPagedCallable()
 *           <li><p> listWorkloadsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCustomer</td>
 *      <td><p> Gets details of a single customer</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCustomer(GetCustomerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCustomer(CustomerName name)
 *           <li><p> getCustomer(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCustomerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCustomers</td>
 *      <td><p> Lists customers of a partner identified by its Google Cloud organization ID</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCustomers(ListCustomersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCustomers(OrganizationLocationName parent)
 *           <li><p> listCustomers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCustomersPagedCallable()
 *           <li><p> listCustomersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEkmConnections</td>
 *      <td><p> Gets the EKM connections associated with a workload</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEkmConnections(GetEkmConnectionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEkmConnections(EkmConnectionsName name)
 *           <li><p> getEkmConnections(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEkmConnectionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPartnerPermissions</td>
 *      <td><p> Gets the partner permissions granted for a workload</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPartnerPermissions(GetPartnerPermissionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPartnerPermissions(PartnerPermissionsName name)
 *           <li><p> getPartnerPermissions(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPartnerPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAccessApprovalRequests</td>
 *      <td><p> Lists access requests associated with a workload</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAccessApprovalRequests(ListAccessApprovalRequestsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAccessApprovalRequests(WorkloadName parent)
 *           <li><p> listAccessApprovalRequests(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAccessApprovalRequestsPagedCallable()
 *           <li><p> listAccessApprovalRequestsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPartner</td>
 *      <td><p> Get details of a Partner.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPartner(GetPartnerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPartner(PartnerName name)
 *           <li><p> getPartner(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPartnerCallable()
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
 * CloudControlsPartnerCoreSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudControlsPartnerCoreSettings cloudControlsPartnerCoreSettings =
 *     CloudControlsPartnerCoreSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
 *     CloudControlsPartnerCoreClient.create(cloudControlsPartnerCoreSettings);
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
 * CloudControlsPartnerCoreSettings cloudControlsPartnerCoreSettings =
 *     CloudControlsPartnerCoreSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
 *     CloudControlsPartnerCoreClient.create(cloudControlsPartnerCoreSettings);
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
 * CloudControlsPartnerCoreSettings cloudControlsPartnerCoreSettings =
 *     CloudControlsPartnerCoreSettings.newHttpJsonBuilder().build();
 * CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
 *     CloudControlsPartnerCoreClient.create(cloudControlsPartnerCoreSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CloudControlsPartnerCoreClient implements BackgroundResource {
  private final CloudControlsPartnerCoreSettings settings;
  private final CloudControlsPartnerCoreStub stub;

  /** Constructs an instance of CloudControlsPartnerCoreClient with default settings. */
  public static final CloudControlsPartnerCoreClient create() throws IOException {
    return create(CloudControlsPartnerCoreSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudControlsPartnerCoreClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final CloudControlsPartnerCoreClient create(
      CloudControlsPartnerCoreSettings settings) throws IOException {
    return new CloudControlsPartnerCoreClient(settings);
  }

  /**
   * Constructs an instance of CloudControlsPartnerCoreClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(CloudControlsPartnerCoreSettings).
   */
  public static final CloudControlsPartnerCoreClient create(CloudControlsPartnerCoreStub stub) {
    return new CloudControlsPartnerCoreClient(stub);
  }

  /**
   * Constructs an instance of CloudControlsPartnerCoreClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CloudControlsPartnerCoreClient(CloudControlsPartnerCoreSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((CloudControlsPartnerCoreStubSettings) settings.getStubSettings()).createStub();
  }

  protected CloudControlsPartnerCoreClient(CloudControlsPartnerCoreStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CloudControlsPartnerCoreSettings getSettings() {
    return settings;
  }

  public CloudControlsPartnerCoreStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   WorkloadName name =
   *       WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");
   *   Workload response = cloudControlsPartnerCoreClient.getWorkload(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workload getWorkload(WorkloadName name) {
    GetWorkloadRequest request =
        GetWorkloadRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getWorkload(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   String name =
   *       WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]").toString();
   *   Workload response = cloudControlsPartnerCoreClient.getWorkload(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workload getWorkload(String name) {
    GetWorkloadRequest request = GetWorkloadRequest.newBuilder().setName(name).build();
    return getWorkload(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   GetWorkloadRequest request =
   *       GetWorkloadRequest.newBuilder()
   *           .setName(
   *               WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
   *                   .toString())
   *           .build();
   *   Workload response = cloudControlsPartnerCoreClient.getWorkload(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workload getWorkload(GetWorkloadRequest request) {
    return getWorkloadCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   GetWorkloadRequest request =
   *       GetWorkloadRequest.newBuilder()
   *           .setName(
   *               WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Workload> future =
   *       cloudControlsPartnerCoreClient.getWorkloadCallable().futureCall(request);
   *   // Do something.
   *   Workload response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWorkloadRequest, Workload> getWorkloadCallable() {
    return stub.getWorkloadCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists customer workloads for a given customer org id
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   CustomerName parent = CustomerName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]");
   *   for (Workload element : cloudControlsPartnerCoreClient.listWorkloads(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource Format:
   *     organizations/{organization}/locations/{location}/customers/{customer}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkloadsPagedResponse listWorkloads(CustomerName parent) {
    ListWorkloadsRequest request =
        ListWorkloadsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWorkloads(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists customer workloads for a given customer org id
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   String parent = CustomerName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]").toString();
   *   for (Workload element : cloudControlsPartnerCoreClient.listWorkloads(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource Format:
   *     organizations/{organization}/locations/{location}/customers/{customer}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkloadsPagedResponse listWorkloads(String parent) {
    ListWorkloadsRequest request = ListWorkloadsRequest.newBuilder().setParent(parent).build();
    return listWorkloads(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists customer workloads for a given customer org id
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   ListWorkloadsRequest request =
   *       ListWorkloadsRequest.newBuilder()
   *           .setParent(CustomerName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Workload element : cloudControlsPartnerCoreClient.listWorkloads(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkloadsPagedResponse listWorkloads(ListWorkloadsRequest request) {
    return listWorkloadsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists customer workloads for a given customer org id
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   ListWorkloadsRequest request =
   *       ListWorkloadsRequest.newBuilder()
   *           .setParent(CustomerName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Workload> future =
   *       cloudControlsPartnerCoreClient.listWorkloadsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Workload element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWorkloadsRequest, ListWorkloadsPagedResponse>
      listWorkloadsPagedCallable() {
    return stub.listWorkloadsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists customer workloads for a given customer org id
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   ListWorkloadsRequest request =
   *       ListWorkloadsRequest.newBuilder()
   *           .setParent(CustomerName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListWorkloadsResponse response =
   *         cloudControlsPartnerCoreClient.listWorkloadsCallable().call(request);
   *     for (Workload element : response.getWorkloadsList()) {
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
  public final UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsCallable() {
    return stub.listWorkloadsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single customer
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   CustomerName name = CustomerName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]");
   *   Customer response = cloudControlsPartnerCoreClient.getCustomer(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     organizations/{organization}/locations/{location}/customers/{customer}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Customer getCustomer(CustomerName name) {
    GetCustomerRequest request =
        GetCustomerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCustomer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single customer
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   String name = CustomerName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]").toString();
   *   Customer response = cloudControlsPartnerCoreClient.getCustomer(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     organizations/{organization}/locations/{location}/customers/{customer}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Customer getCustomer(String name) {
    GetCustomerRequest request = GetCustomerRequest.newBuilder().setName(name).build();
    return getCustomer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single customer
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   GetCustomerRequest request =
   *       GetCustomerRequest.newBuilder()
   *           .setName(CustomerName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]").toString())
   *           .build();
   *   Customer response = cloudControlsPartnerCoreClient.getCustomer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Customer getCustomer(GetCustomerRequest request) {
    return getCustomerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single customer
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   GetCustomerRequest request =
   *       GetCustomerRequest.newBuilder()
   *           .setName(CustomerName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]").toString())
   *           .build();
   *   ApiFuture<Customer> future =
   *       cloudControlsPartnerCoreClient.getCustomerCallable().futureCall(request);
   *   // Do something.
   *   Customer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCustomerRequest, Customer> getCustomerCallable() {
    return stub.getCustomerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists customers of a partner identified by its Google Cloud organization ID
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (Customer element : cloudControlsPartnerCoreClient.listCustomers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource Format:
   *     organizations/{organization}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomersPagedResponse listCustomers(OrganizationLocationName parent) {
    ListCustomersRequest request =
        ListCustomersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCustomers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists customers of a partner identified by its Google Cloud organization ID
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (Customer element : cloudControlsPartnerCoreClient.listCustomers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource Format:
   *     organizations/{organization}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomersPagedResponse listCustomers(String parent) {
    ListCustomersRequest request = ListCustomersRequest.newBuilder().setParent(parent).build();
    return listCustomers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists customers of a partner identified by its Google Cloud organization ID
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   ListCustomersRequest request =
   *       ListCustomersRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Customer element : cloudControlsPartnerCoreClient.listCustomers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomersPagedResponse listCustomers(ListCustomersRequest request) {
    return listCustomersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists customers of a partner identified by its Google Cloud organization ID
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   ListCustomersRequest request =
   *       ListCustomersRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Customer> future =
   *       cloudControlsPartnerCoreClient.listCustomersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Customer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCustomersRequest, ListCustomersPagedResponse>
      listCustomersPagedCallable() {
    return stub.listCustomersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists customers of a partner identified by its Google Cloud organization ID
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   ListCustomersRequest request =
   *       ListCustomersRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCustomersResponse response =
   *         cloudControlsPartnerCoreClient.listCustomersCallable().call(request);
   *     for (Customer element : response.getCustomersList()) {
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
  public final UnaryCallable<ListCustomersRequest, ListCustomersResponse> listCustomersCallable() {
    return stub.listCustomersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the EKM connections associated with a workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   EkmConnectionsName name =
   *       EkmConnectionsName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");
   *   EkmConnections response = cloudControlsPartnerCoreClient.getEkmConnections(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}/ekmConnections
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EkmConnections getEkmConnections(EkmConnectionsName name) {
    GetEkmConnectionsRequest request =
        GetEkmConnectionsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEkmConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the EKM connections associated with a workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   String name =
   *       EkmConnectionsName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
   *           .toString();
   *   EkmConnections response = cloudControlsPartnerCoreClient.getEkmConnections(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}/ekmConnections
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EkmConnections getEkmConnections(String name) {
    GetEkmConnectionsRequest request = GetEkmConnectionsRequest.newBuilder().setName(name).build();
    return getEkmConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the EKM connections associated with a workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   GetEkmConnectionsRequest request =
   *       GetEkmConnectionsRequest.newBuilder()
   *           .setName(
   *               EkmConnectionsName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
   *                   .toString())
   *           .build();
   *   EkmConnections response = cloudControlsPartnerCoreClient.getEkmConnections(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EkmConnections getEkmConnections(GetEkmConnectionsRequest request) {
    return getEkmConnectionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the EKM connections associated with a workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   GetEkmConnectionsRequest request =
   *       GetEkmConnectionsRequest.newBuilder()
   *           .setName(
   *               EkmConnectionsName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
   *                   .toString())
   *           .build();
   *   ApiFuture<EkmConnections> future =
   *       cloudControlsPartnerCoreClient.getEkmConnectionsCallable().futureCall(request);
   *   // Do something.
   *   EkmConnections response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEkmConnectionsRequest, EkmConnections> getEkmConnectionsCallable() {
    return stub.getEkmConnectionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the partner permissions granted for a workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   PartnerPermissionsName name =
   *       PartnerPermissionsName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");
   *   PartnerPermissions response = cloudControlsPartnerCoreClient.getPartnerPermissions(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource to get in the format:
   *     organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}/partnerPermissions
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PartnerPermissions getPartnerPermissions(PartnerPermissionsName name) {
    GetPartnerPermissionsRequest request =
        GetPartnerPermissionsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPartnerPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the partner permissions granted for a workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   String name =
   *       PartnerPermissionsName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
   *           .toString();
   *   PartnerPermissions response = cloudControlsPartnerCoreClient.getPartnerPermissions(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource to get in the format:
   *     organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}/partnerPermissions
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PartnerPermissions getPartnerPermissions(String name) {
    GetPartnerPermissionsRequest request =
        GetPartnerPermissionsRequest.newBuilder().setName(name).build();
    return getPartnerPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the partner permissions granted for a workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   GetPartnerPermissionsRequest request =
   *       GetPartnerPermissionsRequest.newBuilder()
   *           .setName(
   *               PartnerPermissionsName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
   *                   .toString())
   *           .build();
   *   PartnerPermissions response = cloudControlsPartnerCoreClient.getPartnerPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PartnerPermissions getPartnerPermissions(GetPartnerPermissionsRequest request) {
    return getPartnerPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the partner permissions granted for a workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   GetPartnerPermissionsRequest request =
   *       GetPartnerPermissionsRequest.newBuilder()
   *           .setName(
   *               PartnerPermissionsName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PartnerPermissions> future =
   *       cloudControlsPartnerCoreClient.getPartnerPermissionsCallable().futureCall(request);
   *   // Do something.
   *   PartnerPermissions response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPartnerPermissionsRequest, PartnerPermissions>
      getPartnerPermissionsCallable() {
    return stub.getPartnerPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists access requests associated with a workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   WorkloadName parent =
   *       WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");
   *   for (AccessApprovalRequest element :
   *       cloudControlsPartnerCoreClient.listAccessApprovalRequests(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource Format:
   *     organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessApprovalRequestsPagedResponse listAccessApprovalRequests(
      WorkloadName parent) {
    ListAccessApprovalRequestsRequest request =
        ListAccessApprovalRequestsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAccessApprovalRequests(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists access requests associated with a workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   String parent =
   *       WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]").toString();
   *   for (AccessApprovalRequest element :
   *       cloudControlsPartnerCoreClient.listAccessApprovalRequests(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource Format:
   *     organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessApprovalRequestsPagedResponse listAccessApprovalRequests(String parent) {
    ListAccessApprovalRequestsRequest request =
        ListAccessApprovalRequestsRequest.newBuilder().setParent(parent).build();
    return listAccessApprovalRequests(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists access requests associated with a workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   ListAccessApprovalRequestsRequest request =
   *       ListAccessApprovalRequestsRequest.newBuilder()
   *           .setParent(
   *               WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (AccessApprovalRequest element :
   *       cloudControlsPartnerCoreClient.listAccessApprovalRequests(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessApprovalRequestsPagedResponse listAccessApprovalRequests(
      ListAccessApprovalRequestsRequest request) {
    return listAccessApprovalRequestsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists access requests associated with a workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   ListAccessApprovalRequestsRequest request =
   *       ListAccessApprovalRequestsRequest.newBuilder()
   *           .setParent(
   *               WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<AccessApprovalRequest> future =
   *       cloudControlsPartnerCoreClient
   *           .listAccessApprovalRequestsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (AccessApprovalRequest element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsPagedResponse>
      listAccessApprovalRequestsPagedCallable() {
    return stub.listAccessApprovalRequestsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists access requests associated with a workload
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   ListAccessApprovalRequestsRequest request =
   *       ListAccessApprovalRequestsRequest.newBuilder()
   *           .setParent(
   *               WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAccessApprovalRequestsResponse response =
   *         cloudControlsPartnerCoreClient.listAccessApprovalRequestsCallable().call(request);
   *     for (AccessApprovalRequest element : response.getAccessApprovalRequestsList()) {
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
  public final UnaryCallable<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsResponse>
      listAccessApprovalRequestsCallable() {
    return stub.listAccessApprovalRequestsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a Partner.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   PartnerName name = PartnerName.of("[ORGANIZATION]", "[LOCATION]");
   *   Partner response = cloudControlsPartnerCoreClient.getPartner(name);
   * }
   * }</pre>
   *
   * @param name Required. Format: organizations/{organization}/locations/{location}/partner
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Partner getPartner(PartnerName name) {
    GetPartnerRequest request =
        GetPartnerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPartner(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a Partner.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   String name = PartnerName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   Partner response = cloudControlsPartnerCoreClient.getPartner(name);
   * }
   * }</pre>
   *
   * @param name Required. Format: organizations/{organization}/locations/{location}/partner
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Partner getPartner(String name) {
    GetPartnerRequest request = GetPartnerRequest.newBuilder().setName(name).build();
    return getPartner(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a Partner.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   GetPartnerRequest request =
   *       GetPartnerRequest.newBuilder()
   *           .setName(PartnerName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .build();
   *   Partner response = cloudControlsPartnerCoreClient.getPartner(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Partner getPartner(GetPartnerRequest request) {
    return getPartnerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a Partner.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
   *     CloudControlsPartnerCoreClient.create()) {
   *   GetPartnerRequest request =
   *       GetPartnerRequest.newBuilder()
   *           .setName(PartnerName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<Partner> future =
   *       cloudControlsPartnerCoreClient.getPartnerCallable().futureCall(request);
   *   // Do something.
   *   Partner response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPartnerRequest, Partner> getPartnerCallable() {
    return stub.getPartnerCallable();
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

  public static class ListWorkloadsPagedResponse
      extends AbstractPagedListResponse<
          ListWorkloadsRequest,
          ListWorkloadsResponse,
          Workload,
          ListWorkloadsPage,
          ListWorkloadsFixedSizeCollection> {

    public static ApiFuture<ListWorkloadsPagedResponse> createAsync(
        PageContext<ListWorkloadsRequest, ListWorkloadsResponse, Workload> context,
        ApiFuture<ListWorkloadsResponse> futureResponse) {
      ApiFuture<ListWorkloadsPage> futurePage =
          ListWorkloadsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWorkloadsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWorkloadsPagedResponse(ListWorkloadsPage page) {
      super(page, ListWorkloadsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWorkloadsPage
      extends AbstractPage<
          ListWorkloadsRequest, ListWorkloadsResponse, Workload, ListWorkloadsPage> {

    private ListWorkloadsPage(
        PageContext<ListWorkloadsRequest, ListWorkloadsResponse, Workload> context,
        ListWorkloadsResponse response) {
      super(context, response);
    }

    private static ListWorkloadsPage createEmptyPage() {
      return new ListWorkloadsPage(null, null);
    }

    @Override
    protected ListWorkloadsPage createPage(
        PageContext<ListWorkloadsRequest, ListWorkloadsResponse, Workload> context,
        ListWorkloadsResponse response) {
      return new ListWorkloadsPage(context, response);
    }

    @Override
    public ApiFuture<ListWorkloadsPage> createPageAsync(
        PageContext<ListWorkloadsRequest, ListWorkloadsResponse, Workload> context,
        ApiFuture<ListWorkloadsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWorkloadsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWorkloadsRequest,
          ListWorkloadsResponse,
          Workload,
          ListWorkloadsPage,
          ListWorkloadsFixedSizeCollection> {

    private ListWorkloadsFixedSizeCollection(List<ListWorkloadsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWorkloadsFixedSizeCollection createEmptyCollection() {
      return new ListWorkloadsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWorkloadsFixedSizeCollection createCollection(
        List<ListWorkloadsPage> pages, int collectionSize) {
      return new ListWorkloadsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCustomersPagedResponse
      extends AbstractPagedListResponse<
          ListCustomersRequest,
          ListCustomersResponse,
          Customer,
          ListCustomersPage,
          ListCustomersFixedSizeCollection> {

    public static ApiFuture<ListCustomersPagedResponse> createAsync(
        PageContext<ListCustomersRequest, ListCustomersResponse, Customer> context,
        ApiFuture<ListCustomersResponse> futureResponse) {
      ApiFuture<ListCustomersPage> futurePage =
          ListCustomersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCustomersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCustomersPagedResponse(ListCustomersPage page) {
      super(page, ListCustomersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCustomersPage
      extends AbstractPage<
          ListCustomersRequest, ListCustomersResponse, Customer, ListCustomersPage> {

    private ListCustomersPage(
        PageContext<ListCustomersRequest, ListCustomersResponse, Customer> context,
        ListCustomersResponse response) {
      super(context, response);
    }

    private static ListCustomersPage createEmptyPage() {
      return new ListCustomersPage(null, null);
    }

    @Override
    protected ListCustomersPage createPage(
        PageContext<ListCustomersRequest, ListCustomersResponse, Customer> context,
        ListCustomersResponse response) {
      return new ListCustomersPage(context, response);
    }

    @Override
    public ApiFuture<ListCustomersPage> createPageAsync(
        PageContext<ListCustomersRequest, ListCustomersResponse, Customer> context,
        ApiFuture<ListCustomersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCustomersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCustomersRequest,
          ListCustomersResponse,
          Customer,
          ListCustomersPage,
          ListCustomersFixedSizeCollection> {

    private ListCustomersFixedSizeCollection(List<ListCustomersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCustomersFixedSizeCollection createEmptyCollection() {
      return new ListCustomersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCustomersFixedSizeCollection createCollection(
        List<ListCustomersPage> pages, int collectionSize) {
      return new ListCustomersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAccessApprovalRequestsPagedResponse
      extends AbstractPagedListResponse<
          ListAccessApprovalRequestsRequest,
          ListAccessApprovalRequestsResponse,
          AccessApprovalRequest,
          ListAccessApprovalRequestsPage,
          ListAccessApprovalRequestsFixedSizeCollection> {

    public static ApiFuture<ListAccessApprovalRequestsPagedResponse> createAsync(
        PageContext<
                ListAccessApprovalRequestsRequest,
                ListAccessApprovalRequestsResponse,
                AccessApprovalRequest>
            context,
        ApiFuture<ListAccessApprovalRequestsResponse> futureResponse) {
      ApiFuture<ListAccessApprovalRequestsPage> futurePage =
          ListAccessApprovalRequestsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAccessApprovalRequestsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAccessApprovalRequestsPagedResponse(ListAccessApprovalRequestsPage page) {
      super(page, ListAccessApprovalRequestsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAccessApprovalRequestsPage
      extends AbstractPage<
          ListAccessApprovalRequestsRequest,
          ListAccessApprovalRequestsResponse,
          AccessApprovalRequest,
          ListAccessApprovalRequestsPage> {

    private ListAccessApprovalRequestsPage(
        PageContext<
                ListAccessApprovalRequestsRequest,
                ListAccessApprovalRequestsResponse,
                AccessApprovalRequest>
            context,
        ListAccessApprovalRequestsResponse response) {
      super(context, response);
    }

    private static ListAccessApprovalRequestsPage createEmptyPage() {
      return new ListAccessApprovalRequestsPage(null, null);
    }

    @Override
    protected ListAccessApprovalRequestsPage createPage(
        PageContext<
                ListAccessApprovalRequestsRequest,
                ListAccessApprovalRequestsResponse,
                AccessApprovalRequest>
            context,
        ListAccessApprovalRequestsResponse response) {
      return new ListAccessApprovalRequestsPage(context, response);
    }

    @Override
    public ApiFuture<ListAccessApprovalRequestsPage> createPageAsync(
        PageContext<
                ListAccessApprovalRequestsRequest,
                ListAccessApprovalRequestsResponse,
                AccessApprovalRequest>
            context,
        ApiFuture<ListAccessApprovalRequestsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAccessApprovalRequestsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAccessApprovalRequestsRequest,
          ListAccessApprovalRequestsResponse,
          AccessApprovalRequest,
          ListAccessApprovalRequestsPage,
          ListAccessApprovalRequestsFixedSizeCollection> {

    private ListAccessApprovalRequestsFixedSizeCollection(
        List<ListAccessApprovalRequestsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAccessApprovalRequestsFixedSizeCollection createEmptyCollection() {
      return new ListAccessApprovalRequestsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAccessApprovalRequestsFixedSizeCollection createCollection(
        List<ListAccessApprovalRequestsPage> pages, int collectionSize) {
      return new ListAccessApprovalRequestsFixedSizeCollection(pages, collectionSize);
    }
  }
}
