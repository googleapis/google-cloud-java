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
import com.google.cloud.chronicle.v1.stub.DashboardChartServiceStub;
import com.google.cloud.chronicle.v1.stub.DashboardChartServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service providing functionality for managing dashboards' charts.
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
 * try (DashboardChartServiceClient dashboardChartServiceClient =
 *     DashboardChartServiceClient.create()) {
 *   DashboardChartName name =
 *       DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]");
 *   DashboardChart response = dashboardChartServiceClient.getDashboardChart(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DashboardChartServiceClient object to clean up
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
 *      <td><p> GetDashboardChart</td>
 *      <td><p> Get a dashboard chart.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDashboardChart(GetDashboardChartRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDashboardChart(DashboardChartName name)
 *           <li><p> getDashboardChart(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDashboardChartCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchGetDashboardCharts</td>
 *      <td><p> Get dashboard charts in batches.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchGetDashboardCharts(BatchGetDashboardChartsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchGetDashboardCharts(InstanceName parent, List&lt;String&gt; names)
 *           <li><p> batchGetDashboardCharts(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchGetDashboardChartsCallable()
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
 * <p>This class can be customized by passing in a custom instance of DashboardChartServiceSettings
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
 * DashboardChartServiceSettings dashboardChartServiceSettings =
 *     DashboardChartServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DashboardChartServiceClient dashboardChartServiceClient =
 *     DashboardChartServiceClient.create(dashboardChartServiceSettings);
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
 * DashboardChartServiceSettings dashboardChartServiceSettings =
 *     DashboardChartServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DashboardChartServiceClient dashboardChartServiceClient =
 *     DashboardChartServiceClient.create(dashboardChartServiceSettings);
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
 * DashboardChartServiceSettings dashboardChartServiceSettings =
 *     DashboardChartServiceSettings.newHttpJsonBuilder().build();
 * DashboardChartServiceClient dashboardChartServiceClient =
 *     DashboardChartServiceClient.create(dashboardChartServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class DashboardChartServiceClient implements BackgroundResource {
  private final DashboardChartServiceSettings settings;
  private final DashboardChartServiceStub stub;

  /** Constructs an instance of DashboardChartServiceClient with default settings. */
  public static final DashboardChartServiceClient create() throws IOException {
    return create(DashboardChartServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DashboardChartServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DashboardChartServiceClient create(DashboardChartServiceSettings settings)
      throws IOException {
    return new DashboardChartServiceClient(settings);
  }

  /**
   * Constructs an instance of DashboardChartServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(DashboardChartServiceSettings).
   */
  public static final DashboardChartServiceClient create(DashboardChartServiceStub stub) {
    return new DashboardChartServiceClient(stub);
  }

  /**
   * Constructs an instance of DashboardChartServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DashboardChartServiceClient(DashboardChartServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DashboardChartServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DashboardChartServiceClient(DashboardChartServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DashboardChartServiceSettings getSettings() {
    return settings;
  }

  public DashboardChartServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dashboard chart.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardChartServiceClient dashboardChartServiceClient =
   *     DashboardChartServiceClient.create()) {
   *   DashboardChartName name =
   *       DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]");
   *   DashboardChart response = dashboardChartServiceClient.getDashboardChart(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the dashboardChart to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/dashboardCharts/{chart}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DashboardChart getDashboardChart(DashboardChartName name) {
    GetDashboardChartRequest request =
        GetDashboardChartRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDashboardChart(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dashboard chart.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardChartServiceClient dashboardChartServiceClient =
   *     DashboardChartServiceClient.create()) {
   *   String name =
   *       DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]").toString();
   *   DashboardChart response = dashboardChartServiceClient.getDashboardChart(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the dashboardChart to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/dashboardCharts/{chart}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DashboardChart getDashboardChart(String name) {
    GetDashboardChartRequest request = GetDashboardChartRequest.newBuilder().setName(name).build();
    return getDashboardChart(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dashboard chart.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardChartServiceClient dashboardChartServiceClient =
   *     DashboardChartServiceClient.create()) {
   *   GetDashboardChartRequest request =
   *       GetDashboardChartRequest.newBuilder()
   *           .setName(
   *               DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]")
   *                   .toString())
   *           .build();
   *   DashboardChart response = dashboardChartServiceClient.getDashboardChart(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DashboardChart getDashboardChart(GetDashboardChartRequest request) {
    return getDashboardChartCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dashboard chart.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardChartServiceClient dashboardChartServiceClient =
   *     DashboardChartServiceClient.create()) {
   *   GetDashboardChartRequest request =
   *       GetDashboardChartRequest.newBuilder()
   *           .setName(
   *               DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DashboardChart> future =
   *       dashboardChartServiceClient.getDashboardChartCallable().futureCall(request);
   *   // Do something.
   *   DashboardChart response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDashboardChartRequest, DashboardChart> getDashboardChartCallable() {
    return stub.getDashboardChartCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get dashboard charts in batches.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardChartServiceClient dashboardChartServiceClient =
   *     DashboardChartServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   List<String> names = new ArrayList<>();
   *   BatchGetDashboardChartsResponse response =
   *       dashboardChartServiceClient.batchGetDashboardCharts(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource shared by all dashboard charts being retrieved.
   *     Format: projects/{project}/locations/{location}/instances/{instance} If this is set, the
   *     parent of all of the dashboard charts specified in `names` must match this field.
   * @param names Required. The names of the dashboard charts to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetDashboardChartsResponse batchGetDashboardCharts(
      InstanceName parent, List<String> names) {
    BatchGetDashboardChartsRequest request =
        BatchGetDashboardChartsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchGetDashboardCharts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get dashboard charts in batches.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardChartServiceClient dashboardChartServiceClient =
   *     DashboardChartServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchGetDashboardChartsResponse response =
   *       dashboardChartServiceClient.batchGetDashboardCharts(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource shared by all dashboard charts being retrieved.
   *     Format: projects/{project}/locations/{location}/instances/{instance} If this is set, the
   *     parent of all of the dashboard charts specified in `names` must match this field.
   * @param names Required. The names of the dashboard charts to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetDashboardChartsResponse batchGetDashboardCharts(
      String parent, List<String> names) {
    BatchGetDashboardChartsRequest request =
        BatchGetDashboardChartsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchGetDashboardCharts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get dashboard charts in batches.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardChartServiceClient dashboardChartServiceClient =
   *     DashboardChartServiceClient.create()) {
   *   BatchGetDashboardChartsRequest request =
   *       BatchGetDashboardChartsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchGetDashboardChartsResponse response =
   *       dashboardChartServiceClient.batchGetDashboardCharts(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetDashboardChartsResponse batchGetDashboardCharts(
      BatchGetDashboardChartsRequest request) {
    return batchGetDashboardChartsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get dashboard charts in batches.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DashboardChartServiceClient dashboardChartServiceClient =
   *     DashboardChartServiceClient.create()) {
   *   BatchGetDashboardChartsRequest request =
   *       BatchGetDashboardChartsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchGetDashboardChartsResponse> future =
   *       dashboardChartServiceClient.batchGetDashboardChartsCallable().futureCall(request);
   *   // Do something.
   *   BatchGetDashboardChartsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchGetDashboardChartsRequest, BatchGetDashboardChartsResponse>
      batchGetDashboardChartsCallable() {
    return stub.batchGetDashboardChartsCallable();
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
