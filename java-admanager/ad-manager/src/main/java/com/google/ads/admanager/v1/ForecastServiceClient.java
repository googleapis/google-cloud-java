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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.ForecastServiceStub;
import com.google.ads.admanager.v1.stub.ForecastServiceStubSettings;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling forecasting actions.
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
 * try (ForecastServiceClient forecastServiceClient = ForecastServiceClient.create()) {
 *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
 *   RunAvailabilityForecastResponse response =
 *       forecastServiceClient.runAvailabilityForecast(parent);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ForecastServiceClient object to clean up resources
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
 *      <td><p> RunAvailabilityForecast</td>
 *      <td><p> Gets the availability forecast for a [ProposalLineItem][] or [LineItem][google.ads.admanager.v1.LineItem]. An availability forecast reports the maximum number of available units that the line item can book, and the total number of units matching the line item's targeting.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runAvailabilityForecast(RunAvailabilityForecastRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> runAvailabilityForecast(NetworkName parent)
 *           <li><p> runAvailabilityForecast(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runAvailabilityForecastCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RunDeliveryForecast</td>
 *      <td><p> Runs a delivery simulation forecast for existing or prospective line items. A delivery forecast reports the number of units that will be delivered to each line item given the line item goals. The simulation considers contentions from other line items, including the other prospective line items in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runDeliveryForecast(RunDeliveryForecastRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> runDeliveryForecast(NetworkName parent)
 *           <li><p> runDeliveryForecast(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runDeliveryForecastCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RunTrafficData</td>
 *      <td><p> Gets forecasted and historical traffic data for the segment of traffic specified by the provided request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runTrafficData(RunTrafficDataRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> runTrafficData(NetworkName parent)
 *           <li><p> runTrafficData(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runTrafficDataCallable()
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
 * <p>This class can be customized by passing in a custom instance of ForecastServiceSettings to
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
 * ForecastServiceSettings forecastServiceSettings =
 *     ForecastServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ForecastServiceClient forecastServiceClient =
 *     ForecastServiceClient.create(forecastServiceSettings);
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
 * ForecastServiceSettings forecastServiceSettings =
 *     ForecastServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ForecastServiceClient forecastServiceClient =
 *     ForecastServiceClient.create(forecastServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ForecastServiceClient implements BackgroundResource {
  private final @Nullable ForecastServiceSettings settings;
  private final ForecastServiceStub stub;

  /** Constructs an instance of ForecastServiceClient with default settings. */
  public static final ForecastServiceClient create() throws IOException {
    return create(ForecastServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ForecastServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ForecastServiceClient create(ForecastServiceSettings settings)
      throws IOException {
    return new ForecastServiceClient(settings);
  }

  /**
   * Constructs an instance of ForecastServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ForecastServiceSettings).
   */
  public static final ForecastServiceClient create(ForecastServiceStub stub) {
    return new ForecastServiceClient(stub);
  }

  /**
   * Constructs an instance of ForecastServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ForecastServiceClient(ForecastServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ForecastServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ForecastServiceClient(ForecastServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable ForecastServiceSettings getSettings() {
    return settings;
  }

  public ForecastServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the availability forecast for a [ProposalLineItem][] or
   * [LineItem][google.ads.admanager.v1.LineItem]. An availability forecast reports the maximum
   * number of available units that the line item can book, and the total number of units matching
   * the line item's targeting.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastServiceClient forecastServiceClient = ForecastServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   RunAvailabilityForecastResponse response =
   *       forecastServiceClient.runAvailabilityForecast(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunAvailabilityForecastResponse runAvailabilityForecast(
      @Nullable NetworkName parent) {
    RunAvailabilityForecastRequest request =
        RunAvailabilityForecastRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return runAvailabilityForecast(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the availability forecast for a [ProposalLineItem][] or
   * [LineItem][google.ads.admanager.v1.LineItem]. An availability forecast reports the maximum
   * number of available units that the line item can book, and the total number of units matching
   * the line item's targeting.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastServiceClient forecastServiceClient = ForecastServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   RunAvailabilityForecastResponse response =
   *       forecastServiceClient.runAvailabilityForecast(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunAvailabilityForecastResponse runAvailabilityForecast(String parent) {
    RunAvailabilityForecastRequest request =
        RunAvailabilityForecastRequest.newBuilder().setParent(parent).build();
    return runAvailabilityForecast(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the availability forecast for a [ProposalLineItem][] or
   * [LineItem][google.ads.admanager.v1.LineItem]. An availability forecast reports the maximum
   * number of available units that the line item can book, and the total number of units matching
   * the line item's targeting.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastServiceClient forecastServiceClient = ForecastServiceClient.create()) {
   *   RunAvailabilityForecastRequest request =
   *       RunAvailabilityForecastRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setAvailabilityForecastOptions(AvailabilityForecastOptions.newBuilder().build())
   *           .build();
   *   RunAvailabilityForecastResponse response =
   *       forecastServiceClient.runAvailabilityForecast(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunAvailabilityForecastResponse runAvailabilityForecast(
      RunAvailabilityForecastRequest request) {
    return runAvailabilityForecastCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the availability forecast for a [ProposalLineItem][] or
   * [LineItem][google.ads.admanager.v1.LineItem]. An availability forecast reports the maximum
   * number of available units that the line item can book, and the total number of units matching
   * the line item's targeting.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastServiceClient forecastServiceClient = ForecastServiceClient.create()) {
   *   RunAvailabilityForecastRequest request =
   *       RunAvailabilityForecastRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setAvailabilityForecastOptions(AvailabilityForecastOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<RunAvailabilityForecastResponse> future =
   *       forecastServiceClient.runAvailabilityForecastCallable().futureCall(request);
   *   // Do something.
   *   RunAvailabilityForecastResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunAvailabilityForecastRequest, RunAvailabilityForecastResponse>
      runAvailabilityForecastCallable() {
    return stub.runAvailabilityForecastCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs a delivery simulation forecast for existing or prospective line items. A delivery forecast
   * reports the number of units that will be delivered to each line item given the line item goals.
   * The simulation considers contentions from other line items, including the other prospective
   * line items in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastServiceClient forecastServiceClient = ForecastServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   RunDeliveryForecastResponse response = forecastServiceClient.runDeliveryForecast(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunDeliveryForecastResponse runDeliveryForecast(@Nullable NetworkName parent) {
    RunDeliveryForecastRequest request =
        RunDeliveryForecastRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return runDeliveryForecast(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs a delivery simulation forecast for existing or prospective line items. A delivery forecast
   * reports the number of units that will be delivered to each line item given the line item goals.
   * The simulation considers contentions from other line items, including the other prospective
   * line items in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastServiceClient forecastServiceClient = ForecastServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   RunDeliveryForecastResponse response = forecastServiceClient.runDeliveryForecast(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunDeliveryForecastResponse runDeliveryForecast(String parent) {
    RunDeliveryForecastRequest request =
        RunDeliveryForecastRequest.newBuilder().setParent(parent).build();
    return runDeliveryForecast(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs a delivery simulation forecast for existing or prospective line items. A delivery forecast
   * reports the number of units that will be delivered to each line item given the line item goals.
   * The simulation considers contentions from other line items, including the other prospective
   * line items in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastServiceClient forecastServiceClient = ForecastServiceClient.create()) {
   *   RunDeliveryForecastRequest request =
   *       RunDeliveryForecastRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setDeliveryForecastOptions(DeliveryForecastOptions.newBuilder().build())
   *           .build();
   *   RunDeliveryForecastResponse response = forecastServiceClient.runDeliveryForecast(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunDeliveryForecastResponse runDeliveryForecast(RunDeliveryForecastRequest request) {
    return runDeliveryForecastCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs a delivery simulation forecast for existing or prospective line items. A delivery forecast
   * reports the number of units that will be delivered to each line item given the line item goals.
   * The simulation considers contentions from other line items, including the other prospective
   * line items in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastServiceClient forecastServiceClient = ForecastServiceClient.create()) {
   *   RunDeliveryForecastRequest request =
   *       RunDeliveryForecastRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setDeliveryForecastOptions(DeliveryForecastOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<RunDeliveryForecastResponse> future =
   *       forecastServiceClient.runDeliveryForecastCallable().futureCall(request);
   *   // Do something.
   *   RunDeliveryForecastResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunDeliveryForecastRequest, RunDeliveryForecastResponse>
      runDeliveryForecastCallable() {
    return stub.runDeliveryForecastCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets forecasted and historical traffic data for the segment of traffic specified by the
   * provided request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastServiceClient forecastServiceClient = ForecastServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   RunTrafficDataResponse response = forecastServiceClient.runTrafficData(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunTrafficDataResponse runTrafficData(@Nullable NetworkName parent) {
    RunTrafficDataRequest request =
        RunTrafficDataRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return runTrafficData(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets forecasted and historical traffic data for the segment of traffic specified by the
   * provided request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastServiceClient forecastServiceClient = ForecastServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   RunTrafficDataResponse response = forecastServiceClient.runTrafficData(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunTrafficDataResponse runTrafficData(String parent) {
    RunTrafficDataRequest request = RunTrafficDataRequest.newBuilder().setParent(parent).build();
    return runTrafficData(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets forecasted and historical traffic data for the segment of traffic specified by the
   * provided request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastServiceClient forecastServiceClient = ForecastServiceClient.create()) {
   *   RunTrafficDataRequest request =
   *       RunTrafficDataRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setTargeting(Targeting.newBuilder().build())
   *           .setRequestedDateRange(DateRange.newBuilder().build())
   *           .build();
   *   RunTrafficDataResponse response = forecastServiceClient.runTrafficData(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunTrafficDataResponse runTrafficData(RunTrafficDataRequest request) {
    return runTrafficDataCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets forecasted and historical traffic data for the segment of traffic specified by the
   * provided request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastServiceClient forecastServiceClient = ForecastServiceClient.create()) {
   *   RunTrafficDataRequest request =
   *       RunTrafficDataRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setTargeting(Targeting.newBuilder().build())
   *           .setRequestedDateRange(DateRange.newBuilder().build())
   *           .build();
   *   ApiFuture<RunTrafficDataResponse> future =
   *       forecastServiceClient.runTrafficDataCallable().futureCall(request);
   *   // Do something.
   *   RunTrafficDataResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunTrafficDataRequest, RunTrafficDataResponse>
      runTrafficDataCallable() {
    return stub.runTrafficDataCallable();
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
