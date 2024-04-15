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

package com.google.cloud.cloudcontrolspartner.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudcontrolspartner.v1.stub.CloudControlsPartnerMonitoringStub;
import com.google.cloud.cloudcontrolspartner.v1.stub.CloudControlsPartnerMonitoringStubSettings;
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
 * try (CloudControlsPartnerMonitoringClient cloudControlsPartnerMonitoringClient =
 *     CloudControlsPartnerMonitoringClient.create()) {
 *   ViolationName name =
 *       ViolationName.of(
 *           "[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]", "[VIOLATION]");
 *   Violation response = cloudControlsPartnerMonitoringClient.getViolation(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CloudControlsPartnerMonitoringClient object to clean
 * up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListViolations</td>
 *      <td><p> Lists Violations for a workload Callers may also choose to read across multiple Customers or for a single customer as per [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash character) as a wildcard character instead of {customer} &amp; {workload}. Format: `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listViolations(ListViolationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listViolations(WorkloadName parent)
 *           <li><p> listViolations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listViolationsPagedCallable()
 *           <li><p> listViolationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetViolation</td>
 *      <td><p> Gets details of a single Violation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getViolation(GetViolationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getViolation(ViolationName name)
 *           <li><p> getViolation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getViolationCallable()
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
 * CloudControlsPartnerMonitoringSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudControlsPartnerMonitoringSettings cloudControlsPartnerMonitoringSettings =
 *     CloudControlsPartnerMonitoringSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudControlsPartnerMonitoringClient cloudControlsPartnerMonitoringClient =
 *     CloudControlsPartnerMonitoringClient.create(cloudControlsPartnerMonitoringSettings);
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
 * CloudControlsPartnerMonitoringSettings cloudControlsPartnerMonitoringSettings =
 *     CloudControlsPartnerMonitoringSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudControlsPartnerMonitoringClient cloudControlsPartnerMonitoringClient =
 *     CloudControlsPartnerMonitoringClient.create(cloudControlsPartnerMonitoringSettings);
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
 * CloudControlsPartnerMonitoringSettings cloudControlsPartnerMonitoringSettings =
 *     CloudControlsPartnerMonitoringSettings.newHttpJsonBuilder().build();
 * CloudControlsPartnerMonitoringClient cloudControlsPartnerMonitoringClient =
 *     CloudControlsPartnerMonitoringClient.create(cloudControlsPartnerMonitoringSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CloudControlsPartnerMonitoringClient implements BackgroundResource {
  private final CloudControlsPartnerMonitoringSettings settings;
  private final CloudControlsPartnerMonitoringStub stub;

  /** Constructs an instance of CloudControlsPartnerMonitoringClient with default settings. */
  public static final CloudControlsPartnerMonitoringClient create() throws IOException {
    return create(CloudControlsPartnerMonitoringSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudControlsPartnerMonitoringClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final CloudControlsPartnerMonitoringClient create(
      CloudControlsPartnerMonitoringSettings settings) throws IOException {
    return new CloudControlsPartnerMonitoringClient(settings);
  }

  /**
   * Constructs an instance of CloudControlsPartnerMonitoringClient, using the given stub for making
   * calls. This is for advanced usage - prefer using
   * create(CloudControlsPartnerMonitoringSettings).
   */
  public static final CloudControlsPartnerMonitoringClient create(
      CloudControlsPartnerMonitoringStub stub) {
    return new CloudControlsPartnerMonitoringClient(stub);
  }

  /**
   * Constructs an instance of CloudControlsPartnerMonitoringClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CloudControlsPartnerMonitoringClient(CloudControlsPartnerMonitoringSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((CloudControlsPartnerMonitoringStubSettings) settings.getStubSettings()).createStub();
  }

  protected CloudControlsPartnerMonitoringClient(CloudControlsPartnerMonitoringStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CloudControlsPartnerMonitoringSettings getSettings() {
    return settings;
  }

  public CloudControlsPartnerMonitoringStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Violations for a workload Callers may also choose to read across multiple Customers or
   * for a single customer as per [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or
   * dash character) as a wildcard character instead of {customer} &amp; {workload}. Format:
   * `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerMonitoringClient cloudControlsPartnerMonitoringClient =
   *     CloudControlsPartnerMonitoringClient.create()) {
   *   WorkloadName parent =
   *       WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");
   *   for (Violation element :
   *       cloudControlsPartnerMonitoringClient.listViolations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource Format
   *     `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViolationsPagedResponse listViolations(WorkloadName parent) {
    ListViolationsRequest request =
        ListViolationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listViolations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Violations for a workload Callers may also choose to read across multiple Customers or
   * for a single customer as per [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or
   * dash character) as a wildcard character instead of {customer} &amp; {workload}. Format:
   * `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerMonitoringClient cloudControlsPartnerMonitoringClient =
   *     CloudControlsPartnerMonitoringClient.create()) {
   *   String parent =
   *       WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]").toString();
   *   for (Violation element :
   *       cloudControlsPartnerMonitoringClient.listViolations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource Format
   *     `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViolationsPagedResponse listViolations(String parent) {
    ListViolationsRequest request = ListViolationsRequest.newBuilder().setParent(parent).build();
    return listViolations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Violations for a workload Callers may also choose to read across multiple Customers or
   * for a single customer as per [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or
   * dash character) as a wildcard character instead of {customer} &amp; {workload}. Format:
   * `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerMonitoringClient cloudControlsPartnerMonitoringClient =
   *     CloudControlsPartnerMonitoringClient.create()) {
   *   ListViolationsRequest request =
   *       ListViolationsRequest.newBuilder()
   *           .setParent(
   *               WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setInterval(Interval.newBuilder().build())
   *           .build();
   *   for (Violation element :
   *       cloudControlsPartnerMonitoringClient.listViolations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViolationsPagedResponse listViolations(ListViolationsRequest request) {
    return listViolationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Violations for a workload Callers may also choose to read across multiple Customers or
   * for a single customer as per [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or
   * dash character) as a wildcard character instead of {customer} &amp; {workload}. Format:
   * `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerMonitoringClient cloudControlsPartnerMonitoringClient =
   *     CloudControlsPartnerMonitoringClient.create()) {
   *   ListViolationsRequest request =
   *       ListViolationsRequest.newBuilder()
   *           .setParent(
   *               WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setInterval(Interval.newBuilder().build())
   *           .build();
   *   ApiFuture<Violation> future =
   *       cloudControlsPartnerMonitoringClient.listViolationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Violation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListViolationsRequest, ListViolationsPagedResponse>
      listViolationsPagedCallable() {
    return stub.listViolationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Violations for a workload Callers may also choose to read across multiple Customers or
   * for a single customer as per [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or
   * dash character) as a wildcard character instead of {customer} &amp; {workload}. Format:
   * `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerMonitoringClient cloudControlsPartnerMonitoringClient =
   *     CloudControlsPartnerMonitoringClient.create()) {
   *   ListViolationsRequest request =
   *       ListViolationsRequest.newBuilder()
   *           .setParent(
   *               WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setInterval(Interval.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListViolationsResponse response =
   *         cloudControlsPartnerMonitoringClient.listViolationsCallable().call(request);
   *     for (Violation element : response.getViolationsList()) {
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
  public final UnaryCallable<ListViolationsRequest, ListViolationsResponse>
      listViolationsCallable() {
    return stub.listViolationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Violation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerMonitoringClient cloudControlsPartnerMonitoringClient =
   *     CloudControlsPartnerMonitoringClient.create()) {
   *   ViolationName name =
   *       ViolationName.of(
   *           "[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]", "[VIOLATION]");
   *   Violation response = cloudControlsPartnerMonitoringClient.getViolation(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}/violations/{violation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Violation getViolation(ViolationName name) {
    GetViolationRequest request =
        GetViolationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getViolation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Violation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerMonitoringClient cloudControlsPartnerMonitoringClient =
   *     CloudControlsPartnerMonitoringClient.create()) {
   *   String name =
   *       ViolationName.of(
   *               "[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]", "[VIOLATION]")
   *           .toString();
   *   Violation response = cloudControlsPartnerMonitoringClient.getViolation(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}/violations/{violation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Violation getViolation(String name) {
    GetViolationRequest request = GetViolationRequest.newBuilder().setName(name).build();
    return getViolation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Violation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerMonitoringClient cloudControlsPartnerMonitoringClient =
   *     CloudControlsPartnerMonitoringClient.create()) {
   *   GetViolationRequest request =
   *       GetViolationRequest.newBuilder()
   *           .setName(
   *               ViolationName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]", "[VIOLATION]")
   *                   .toString())
   *           .build();
   *   Violation response = cloudControlsPartnerMonitoringClient.getViolation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Violation getViolation(GetViolationRequest request) {
    return getViolationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Violation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudControlsPartnerMonitoringClient cloudControlsPartnerMonitoringClient =
   *     CloudControlsPartnerMonitoringClient.create()) {
   *   GetViolationRequest request =
   *       GetViolationRequest.newBuilder()
   *           .setName(
   *               ViolationName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]", "[VIOLATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Violation> future =
   *       cloudControlsPartnerMonitoringClient.getViolationCallable().futureCall(request);
   *   // Do something.
   *   Violation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetViolationRequest, Violation> getViolationCallable() {
    return stub.getViolationCallable();
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

  public static class ListViolationsPagedResponse
      extends AbstractPagedListResponse<
          ListViolationsRequest,
          ListViolationsResponse,
          Violation,
          ListViolationsPage,
          ListViolationsFixedSizeCollection> {

    public static ApiFuture<ListViolationsPagedResponse> createAsync(
        PageContext<ListViolationsRequest, ListViolationsResponse, Violation> context,
        ApiFuture<ListViolationsResponse> futureResponse) {
      ApiFuture<ListViolationsPage> futurePage =
          ListViolationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListViolationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListViolationsPagedResponse(ListViolationsPage page) {
      super(page, ListViolationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListViolationsPage
      extends AbstractPage<
          ListViolationsRequest, ListViolationsResponse, Violation, ListViolationsPage> {

    private ListViolationsPage(
        PageContext<ListViolationsRequest, ListViolationsResponse, Violation> context,
        ListViolationsResponse response) {
      super(context, response);
    }

    private static ListViolationsPage createEmptyPage() {
      return new ListViolationsPage(null, null);
    }

    @Override
    protected ListViolationsPage createPage(
        PageContext<ListViolationsRequest, ListViolationsResponse, Violation> context,
        ListViolationsResponse response) {
      return new ListViolationsPage(context, response);
    }

    @Override
    public ApiFuture<ListViolationsPage> createPageAsync(
        PageContext<ListViolationsRequest, ListViolationsResponse, Violation> context,
        ApiFuture<ListViolationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListViolationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListViolationsRequest,
          ListViolationsResponse,
          Violation,
          ListViolationsPage,
          ListViolationsFixedSizeCollection> {

    private ListViolationsFixedSizeCollection(List<ListViolationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListViolationsFixedSizeCollection createEmptyCollection() {
      return new ListViolationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListViolationsFixedSizeCollection createCollection(
        List<ListViolationsPage> pages, int collectionSize) {
      return new ListViolationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
