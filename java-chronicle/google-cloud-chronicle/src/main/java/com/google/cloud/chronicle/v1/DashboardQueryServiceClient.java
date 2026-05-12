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

package com.google.cloud.chronicle.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.stub.DashboardQueryServiceStub;
import com.google.cloud.chronicle.v1.stub.DashboardQueryServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service providing functionality for managing dashboards' queries.
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
 * try (DashboardQueryServiceClient dashboardQueryServiceClient =
 *     DashboardQueryServiceClient.create()) {
 *   DashboardQueryName name =
 *       DashboardQueryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[QUERY]");
 *   DashboardQuery response = dashboardQueryServiceClient.getDashboardQuery(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DashboardQueryServiceClient object to clean up
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
 *      <td><p> GetDashboardQuery</td>
 *      <td><p> Get a dashboard query.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDashboardQuery(GetDashboardQueryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDashboardQuery(DashboardQueryName name)
 *           <li><p> getDashboardQuery(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDashboardQueryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExecuteDashboardQuery</td>
 *      <td><p> Execute a query and return the data.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> executeDashboardQuery(ExecuteDashboardQueryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> executeDashboardQuery(InstanceName parent, DashboardQuery query)
 *           <li><p> executeDashboardQuery(String parent, DashboardQuery query)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> executeDashboardQueryCallable()
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
 * <p>This class can be customized by passing in a custom instance of DashboardQueryServiceSettings
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
 * DashboardQueryServiceSettings dashboardQueryServiceSettings =
 *     DashboardQueryServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DashboardQueryServiceClient dashboardQueryServiceClient =
 *     DashboardQueryServiceClient.create(dashboardQueryServiceSettings);
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
 * DashboardQueryServiceSettings dashboardQueryServiceSettings =
 *     DashboardQueryServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DashboardQueryServiceClient dashboardQueryServiceClient =
 *     DashboardQueryServiceClient.create(dashboardQueryServiceSettings);
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
 * DashboardQueryServiceSettings dashboardQueryServiceSettings =
 *     DashboardQueryServiceSettings.newHttpJsonBuilder().build();
 * DashboardQueryServiceClient dashboardQueryServiceClient =
 *     DashboardQueryServiceClient.create(dashboardQueryServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DashboardQueryServiceClient implements BackgroundResource {
  private final DashboardQueryServiceSettings settings;
  private final DashboardQueryServiceStub stub;

  /** Constructs an instance of DashboardQueryServiceClient with default settings. */
  public static final DashboardQueryServiceClient create() throws IOException {
    return create(DashboardQueryServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DashboardQueryServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DashboardQueryServiceClient create(DashboardQueryServiceSettings settings)
      throws IOException {
    return new DashboardQueryServiceClient(settings);
  }

  /**
   * Constructs an instance of DashboardQueryServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(DashboardQueryServiceSettings).
   */
  public static final DashboardQueryServiceClient create(DashboardQueryServiceStub stub) {
    return new DashboardQueryServiceClient(stub);
  }

  /**
   * Constructs an instance of DashboardQueryServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DashboardQueryServiceClient(DashboardQueryServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DashboardQueryServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DashboardQueryServiceClient(DashboardQueryServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DashboardQueryServiceSettings getSettings() {
    return settings;
  }

  public DashboardQueryServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dashboard query.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardQueryServiceClient dashboardQueryServiceClient =
   *     DashboardQueryServiceClient.create()) {
   *   DashboardQueryName name =
   *       DashboardQueryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[QUERY]");
   *   DashboardQuery response = dashboardQueryServiceClient.getDashboardQuery(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the dashboardQuery to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/dashboardQueries/{query}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DashboardQuery getDashboardQuery(DashboardQueryName name) {
    GetDashboardQueryRequest request =
        GetDashboardQueryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDashboardQuery(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dashboard query.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardQueryServiceClient dashboardQueryServiceClient =
   *     DashboardQueryServiceClient.create()) {
   *   String name =
   *       DashboardQueryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[QUERY]").toString();
   *   DashboardQuery response = dashboardQueryServiceClient.getDashboardQuery(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the dashboardQuery to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/dashboardQueries/{query}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DashboardQuery getDashboardQuery(String name) {
    GetDashboardQueryRequest request = GetDashboardQueryRequest.newBuilder().setName(name).build();
    return getDashboardQuery(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dashboard query.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardQueryServiceClient dashboardQueryServiceClient =
   *     DashboardQueryServiceClient.create()) {
   *   GetDashboardQueryRequest request =
   *       GetDashboardQueryRequest.newBuilder()
   *           .setName(
   *               DashboardQueryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[QUERY]")
   *                   .toString())
   *           .build();
   *   DashboardQuery response = dashboardQueryServiceClient.getDashboardQuery(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DashboardQuery getDashboardQuery(GetDashboardQueryRequest request) {
    return getDashboardQueryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dashboard query.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardQueryServiceClient dashboardQueryServiceClient =
   *     DashboardQueryServiceClient.create()) {
   *   GetDashboardQueryRequest request =
   *       GetDashboardQueryRequest.newBuilder()
   *           .setName(
   *               DashboardQueryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[QUERY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DashboardQuery> future =
   *       dashboardQueryServiceClient.getDashboardQueryCallable().futureCall(request);
   *   // Do something.
   *   DashboardQuery response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDashboardQueryRequest, DashboardQuery> getDashboardQueryCallable() {
    return stub.getDashboardQueryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Execute a query and return the data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardQueryServiceClient dashboardQueryServiceClient =
   *     DashboardQueryServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   DashboardQuery query = DashboardQuery.newBuilder().build();
   *   ExecuteDashboardQueryResponse response =
   *       dashboardQueryServiceClient.executeDashboardQuery(parent, query);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, under which to run this dashboardQuery. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param query Required. The query to execute and get results back for. QueryID or 'query',
   *     'input.time_window' fields will be used. Use 'native_dashboard' and 'dashboard_chart'
   *     fields if it is an in-dashboard query.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExecuteDashboardQueryResponse executeDashboardQuery(
      InstanceName parent, DashboardQuery query) {
    ExecuteDashboardQueryRequest request =
        ExecuteDashboardQueryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setQuery(query)
            .build();
    return executeDashboardQuery(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Execute a query and return the data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardQueryServiceClient dashboardQueryServiceClient =
   *     DashboardQueryServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   DashboardQuery query = DashboardQuery.newBuilder().build();
   *   ExecuteDashboardQueryResponse response =
   *       dashboardQueryServiceClient.executeDashboardQuery(parent, query);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, under which to run this dashboardQuery. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param query Required. The query to execute and get results back for. QueryID or 'query',
   *     'input.time_window' fields will be used. Use 'native_dashboard' and 'dashboard_chart'
   *     fields if it is an in-dashboard query.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExecuteDashboardQueryResponse executeDashboardQuery(
      String parent, DashboardQuery query) {
    ExecuteDashboardQueryRequest request =
        ExecuteDashboardQueryRequest.newBuilder().setParent(parent).setQuery(query).build();
    return executeDashboardQuery(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Execute a query and return the data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardQueryServiceClient dashboardQueryServiceClient =
   *     DashboardQueryServiceClient.create()) {
   *   ExecuteDashboardQueryRequest request =
   *       ExecuteDashboardQueryRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setQuery(DashboardQuery.newBuilder().build())
   *           .addAllFilters(new ArrayList<DashboardFilter>())
   *           .setClearCache(true)
   *           .setUsePreviousTimeRange(true)
   *           .build();
   *   ExecuteDashboardQueryResponse response =
   *       dashboardQueryServiceClient.executeDashboardQuery(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExecuteDashboardQueryResponse executeDashboardQuery(
      ExecuteDashboardQueryRequest request) {
    return executeDashboardQueryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Execute a query and return the data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardQueryServiceClient dashboardQueryServiceClient =
   *     DashboardQueryServiceClient.create()) {
   *   ExecuteDashboardQueryRequest request =
   *       ExecuteDashboardQueryRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setQuery(DashboardQuery.newBuilder().build())
   *           .addAllFilters(new ArrayList<DashboardFilter>())
   *           .setClearCache(true)
   *           .setUsePreviousTimeRange(true)
   *           .build();
   *   ApiFuture<ExecuteDashboardQueryResponse> future =
   *       dashboardQueryServiceClient.executeDashboardQueryCallable().futureCall(request);
   *   // Do something.
   *   ExecuteDashboardQueryResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExecuteDashboardQueryRequest, ExecuteDashboardQueryResponse>
      executeDashboardQueryCallable() {
    return stub.executeDashboardQueryCallable();
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
