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

package com.google.cloud.capacityplanner.v1beta;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.capacityplanner.v1beta.stub.UsageServiceStub;
import com.google.cloud.capacityplanner.v1beta.stub.UsageServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides access to historical and forecasted usage data.
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
 * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
 *   QueryUsageHistoriesRequest request =
 *       QueryUsageHistoriesRequest.newBuilder()
 *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
 *           .setIsSpot(true)
 *           .setMachineFamily("machineFamily419822219")
 *           .setMachineShape(MachineShape.newBuilder().build())
 *           .setDiskType("diskType279771767")
 *           .setConfidentialMode(true)
 *           .setGpuType("gpuType240737798")
 *           .setTpuType("tpuType-1106616237")
 *           .setCloudResourceType("cloudResourceType-1446274243")
 *           .setStartDate(Date.newBuilder().build())
 *           .setEndDate(Date.newBuilder().build())
 *           .build();
 *   QueryUsageHistoriesResponse response = usageServiceClient.queryUsageHistories(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the UsageServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> QueryUsageHistories</td>
 *      <td><p> Returns a list of the usage histories that are in the parent parameter and match your specified filters.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryUsageHistories(QueryUsageHistoriesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryUsageHistoriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryForecasts</td>
 *      <td><p> Returns a list of the forecasts that are in the parent parameter and match your specified filters.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryForecasts(QueryForecastsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryForecastsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryReservations</td>
 *      <td><p> Returns a list of the reservations that are in the parent parameter and match your specified filters.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryReservations(QueryReservationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> queryReservations(LocationName parent)
 *           <li><p> queryReservations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryReservationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportUsageHistories</td>
 *      <td><p> Exports historical usage data requested by user into either an existing Cloud Storage bucket or a BigQuery table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportUsageHistoriesAsync(ExportUsageHistoriesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportUsageHistoriesOperationCallable()
 *           <li><p> exportUsageHistoriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportForecasts</td>
 *      <td><p> Exports forecasted usage data requested by user into either an existing Cloud Storage bucket or a BigQuery table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportForecastsAsync(ExportForecastsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportForecastsOperationCallable()
 *           <li><p> exportForecastsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportReservationsUsage</td>
 *      <td><p> Exports reservations usage data requested by user into either an existing Cloud Storage bucket or a new/existing BigQuery table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportReservationsUsageAsync(ExportReservationsUsageRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportReservationsUsageOperationCallable()
 *           <li><p> exportReservationsUsageCallable()
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
 * <p>This class can be customized by passing in a custom instance of UsageServiceSettings to
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
 * UsageServiceSettings usageServiceSettings =
 *     UsageServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * UsageServiceClient usageServiceClient = UsageServiceClient.create(usageServiceSettings);
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
 * UsageServiceSettings usageServiceSettings =
 *     UsageServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * UsageServiceClient usageServiceClient = UsageServiceClient.create(usageServiceSettings);
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
 * UsageServiceSettings usageServiceSettings = UsageServiceSettings.newHttpJsonBuilder().build();
 * UsageServiceClient usageServiceClient = UsageServiceClient.create(usageServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class UsageServiceClient implements BackgroundResource {
  private final UsageServiceSettings settings;
  private final UsageServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of UsageServiceClient with default settings. */
  public static final UsageServiceClient create() throws IOException {
    return create(UsageServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of UsageServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final UsageServiceClient create(UsageServiceSettings settings) throws IOException {
    return new UsageServiceClient(settings);
  }

  /**
   * Constructs an instance of UsageServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(UsageServiceSettings).
   */
  public static final UsageServiceClient create(UsageServiceStub stub) {
    return new UsageServiceClient(stub);
  }

  /**
   * Constructs an instance of UsageServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected UsageServiceClient(UsageServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((UsageServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected UsageServiceClient(UsageServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final UsageServiceSettings getSettings() {
    return settings;
  }

  public UsageServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of the usage histories that are in the parent parameter and match your specified
   * filters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   QueryUsageHistoriesRequest request =
   *       QueryUsageHistoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIsSpot(true)
   *           .setMachineFamily("machineFamily419822219")
   *           .setMachineShape(MachineShape.newBuilder().build())
   *           .setDiskType("diskType279771767")
   *           .setConfidentialMode(true)
   *           .setGpuType("gpuType240737798")
   *           .setTpuType("tpuType-1106616237")
   *           .setCloudResourceType("cloudResourceType-1446274243")
   *           .setStartDate(Date.newBuilder().build())
   *           .setEndDate(Date.newBuilder().build())
   *           .build();
   *   QueryUsageHistoriesResponse response = usageServiceClient.queryUsageHistories(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryUsageHistoriesResponse queryUsageHistories(QueryUsageHistoriesRequest request) {
    return queryUsageHistoriesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of the usage histories that are in the parent parameter and match your specified
   * filters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   QueryUsageHistoriesRequest request =
   *       QueryUsageHistoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIsSpot(true)
   *           .setMachineFamily("machineFamily419822219")
   *           .setMachineShape(MachineShape.newBuilder().build())
   *           .setDiskType("diskType279771767")
   *           .setConfidentialMode(true)
   *           .setGpuType("gpuType240737798")
   *           .setTpuType("tpuType-1106616237")
   *           .setCloudResourceType("cloudResourceType-1446274243")
   *           .setStartDate(Date.newBuilder().build())
   *           .setEndDate(Date.newBuilder().build())
   *           .build();
   *   ApiFuture<QueryUsageHistoriesResponse> future =
   *       usageServiceClient.queryUsageHistoriesCallable().futureCall(request);
   *   // Do something.
   *   QueryUsageHistoriesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>
      queryUsageHistoriesCallable() {
    return stub.queryUsageHistoriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of the forecasts that are in the parent parameter and match your specified
   * filters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   QueryForecastsRequest request =
   *       QueryForecastsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMachineFamily("machineFamily419822219")
   *           .setMachineShape(MachineShape.newBuilder().build())
   *           .setDiskType("diskType279771767")
   *           .setConfidentialMode(true)
   *           .setGpuType("gpuType240737798")
   *           .setTpuType("tpuType-1106616237")
   *           .setCloudResourceType("cloudResourceType-1446274243")
   *           .build();
   *   QueryForecastsResponse response = usageServiceClient.queryForecasts(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryForecastsResponse queryForecasts(QueryForecastsRequest request) {
    return queryForecastsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of the forecasts that are in the parent parameter and match your specified
   * filters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   QueryForecastsRequest request =
   *       QueryForecastsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMachineFamily("machineFamily419822219")
   *           .setMachineShape(MachineShape.newBuilder().build())
   *           .setDiskType("diskType279771767")
   *           .setConfidentialMode(true)
   *           .setGpuType("gpuType240737798")
   *           .setTpuType("tpuType-1106616237")
   *           .setCloudResourceType("cloudResourceType-1446274243")
   *           .build();
   *   ApiFuture<QueryForecastsResponse> future =
   *       usageServiceClient.queryForecastsCallable().futureCall(request);
   *   // Do something.
   *   QueryForecastsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryForecastsRequest, QueryForecastsResponse>
      queryForecastsCallable() {
    return stub.queryForecastsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of the reservations that are in the parent parameter and match your specified
   * filters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   QueryReservationsResponse response = usageServiceClient.queryReservations(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The compute engine resource and location for the time series values to
   *     return. The format is:
   *     <p>projects/{project}/locations/{location} or
   *     organizations/{organization}/locations/{location} or folders/{folder}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryReservationsResponse queryReservations(LocationName parent) {
    QueryReservationsRequest request =
        QueryReservationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return queryReservations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of the reservations that are in the parent parameter and match your specified
   * filters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   QueryReservationsResponse response = usageServiceClient.queryReservations(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The compute engine resource and location for the time series values to
   *     return. The format is:
   *     <p>projects/{project}/locations/{location} or
   *     organizations/{organization}/locations/{location} or folders/{folder}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryReservationsResponse queryReservations(String parent) {
    QueryReservationsRequest request =
        QueryReservationsRequest.newBuilder().setParent(parent).build();
    return queryReservations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of the reservations that are in the parent parameter and match your specified
   * filters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   QueryReservationsRequest request =
   *       QueryReservationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMachineFamily("machineFamily419822219")
   *           .setMachineShape(MachineShape.newBuilder().build())
   *           .setGpuType("gpuType240737798")
   *           .setCloudResourceType("cloudResourceType-1446274243")
   *           .setIncludeUnapprovedReservations(true)
   *           .setStartDate(Date.newBuilder().build())
   *           .setEndDate(Date.newBuilder().build())
   *           .build();
   *   QueryReservationsResponse response = usageServiceClient.queryReservations(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryReservationsResponse queryReservations(QueryReservationsRequest request) {
    return queryReservationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of the reservations that are in the parent parameter and match your specified
   * filters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   QueryReservationsRequest request =
   *       QueryReservationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMachineFamily("machineFamily419822219")
   *           .setMachineShape(MachineShape.newBuilder().build())
   *           .setGpuType("gpuType240737798")
   *           .setCloudResourceType("cloudResourceType-1446274243")
   *           .setIncludeUnapprovedReservations(true)
   *           .setStartDate(Date.newBuilder().build())
   *           .setEndDate(Date.newBuilder().build())
   *           .build();
   *   ApiFuture<QueryReservationsResponse> future =
   *       usageServiceClient.queryReservationsCallable().futureCall(request);
   *   // Do something.
   *   QueryReservationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryReservationsRequest, QueryReservationsResponse>
      queryReservationsCallable() {
    return stub.queryReservationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports historical usage data requested by user into either an existing Cloud Storage bucket or
   * a BigQuery table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   ExportUsageHistoriesRequest request =
   *       ExportUsageHistoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIsSpot(true)
   *           .setMachineFamily("machineFamily419822219")
   *           .setMachineShape(MachineShape.newBuilder().build())
   *           .setDiskType("diskType279771767")
   *           .setGpuType("gpuType240737798")
   *           .setTpuType("tpuType-1106616237")
   *           .setResourceType("resourceType-384364440")
   *           .setStartDate(Date.newBuilder().build())
   *           .setEndDate(Date.newBuilder().build())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .build();
   *   ExportUsageHistoriesResponse response =
   *       usageServiceClient.exportUsageHistoriesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportUsageHistoriesResponse, OperationMetadata>
      exportUsageHistoriesAsync(ExportUsageHistoriesRequest request) {
    return exportUsageHistoriesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports historical usage data requested by user into either an existing Cloud Storage bucket or
   * a BigQuery table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   ExportUsageHistoriesRequest request =
   *       ExportUsageHistoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIsSpot(true)
   *           .setMachineFamily("machineFamily419822219")
   *           .setMachineShape(MachineShape.newBuilder().build())
   *           .setDiskType("diskType279771767")
   *           .setGpuType("gpuType240737798")
   *           .setTpuType("tpuType-1106616237")
   *           .setResourceType("resourceType-384364440")
   *           .setStartDate(Date.newBuilder().build())
   *           .setEndDate(Date.newBuilder().build())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ExportUsageHistoriesResponse, OperationMetadata> future =
   *       usageServiceClient.exportUsageHistoriesOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportUsageHistoriesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportUsageHistoriesRequest, ExportUsageHistoriesResponse, OperationMetadata>
      exportUsageHistoriesOperationCallable() {
    return stub.exportUsageHistoriesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports historical usage data requested by user into either an existing Cloud Storage bucket or
   * a BigQuery table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   ExportUsageHistoriesRequest request =
   *       ExportUsageHistoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIsSpot(true)
   *           .setMachineFamily("machineFamily419822219")
   *           .setMachineShape(MachineShape.newBuilder().build())
   *           .setDiskType("diskType279771767")
   *           .setGpuType("gpuType240737798")
   *           .setTpuType("tpuType-1106616237")
   *           .setResourceType("resourceType-384364440")
   *           .setStartDate(Date.newBuilder().build())
   *           .setEndDate(Date.newBuilder().build())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       usageServiceClient.exportUsageHistoriesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportUsageHistoriesRequest, Operation>
      exportUsageHistoriesCallable() {
    return stub.exportUsageHistoriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports forecasted usage data requested by user into either an existing Cloud Storage bucket or
   * a BigQuery table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   ExportForecastsRequest request =
   *       ExportForecastsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMachineFamily("machineFamily419822219")
   *           .setMachineShape(MachineShape.newBuilder().build())
   *           .setDiskType("diskType279771767")
   *           .setGpuType("gpuType240737798")
   *           .setTpuType("tpuType-1106616237")
   *           .setResourceType("resourceType-384364440")
   *           .setStartDate(Date.newBuilder().build())
   *           .setEndDate(Date.newBuilder().build())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .build();
   *   ExportForecastsResponse response = usageServiceClient.exportForecastsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportForecastsResponse, OperationMetadata> exportForecastsAsync(
      ExportForecastsRequest request) {
    return exportForecastsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports forecasted usage data requested by user into either an existing Cloud Storage bucket or
   * a BigQuery table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   ExportForecastsRequest request =
   *       ExportForecastsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMachineFamily("machineFamily419822219")
   *           .setMachineShape(MachineShape.newBuilder().build())
   *           .setDiskType("diskType279771767")
   *           .setGpuType("gpuType240737798")
   *           .setTpuType("tpuType-1106616237")
   *           .setResourceType("resourceType-384364440")
   *           .setStartDate(Date.newBuilder().build())
   *           .setEndDate(Date.newBuilder().build())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ExportForecastsResponse, OperationMetadata> future =
   *       usageServiceClient.exportForecastsOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportForecastsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExportForecastsRequest, ExportForecastsResponse, OperationMetadata>
      exportForecastsOperationCallable() {
    return stub.exportForecastsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports forecasted usage data requested by user into either an existing Cloud Storage bucket or
   * a BigQuery table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   ExportForecastsRequest request =
   *       ExportForecastsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMachineFamily("machineFamily419822219")
   *           .setMachineShape(MachineShape.newBuilder().build())
   *           .setDiskType("diskType279771767")
   *           .setGpuType("gpuType240737798")
   *           .setTpuType("tpuType-1106616237")
   *           .setResourceType("resourceType-384364440")
   *           .setStartDate(Date.newBuilder().build())
   *           .setEndDate(Date.newBuilder().build())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       usageServiceClient.exportForecastsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportForecastsRequest, Operation> exportForecastsCallable() {
    return stub.exportForecastsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports reservations usage data requested by user into either an existing Cloud Storage bucket
   * or a new/existing BigQuery table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   ExportReservationsUsageRequest request =
   *       ExportReservationsUsageRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCloudResourceType("cloudResourceType-1446274243")
   *           .setStartDate(Date.newBuilder().build())
   *           .setEndDate(Date.newBuilder().build())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .build();
   *   ExportReservationsUsageResponse response =
   *       usageServiceClient.exportReservationsUsageAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportReservationsUsageResponse, OperationMetadata>
      exportReservationsUsageAsync(ExportReservationsUsageRequest request) {
    return exportReservationsUsageOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports reservations usage data requested by user into either an existing Cloud Storage bucket
   * or a new/existing BigQuery table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   ExportReservationsUsageRequest request =
   *       ExportReservationsUsageRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCloudResourceType("cloudResourceType-1446274243")
   *           .setStartDate(Date.newBuilder().build())
   *           .setEndDate(Date.newBuilder().build())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ExportReservationsUsageResponse, OperationMetadata> future =
   *       usageServiceClient.exportReservationsUsageOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportReservationsUsageResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportReservationsUsageRequest, ExportReservationsUsageResponse, OperationMetadata>
      exportReservationsUsageOperationCallable() {
    return stub.exportReservationsUsageOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports reservations usage data requested by user into either an existing Cloud Storage bucket
   * or a new/existing BigQuery table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
   *   ExportReservationsUsageRequest request =
   *       ExportReservationsUsageRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCloudResourceType("cloudResourceType-1446274243")
   *           .setStartDate(Date.newBuilder().build())
   *           .setEndDate(Date.newBuilder().build())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       usageServiceClient.exportReservationsUsageCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportReservationsUsageRequest, Operation>
      exportReservationsUsageCallable() {
    return stub.exportReservationsUsageCallable();
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
