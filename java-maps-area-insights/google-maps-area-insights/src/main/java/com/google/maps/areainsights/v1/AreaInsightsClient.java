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

package com.google.maps.areainsights.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.maps.areainsights.v1.stub.AreaInsightsStub;
import com.google.maps.areainsights.v1.stub.AreaInsightsStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service definition for the Places Insights API.
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
 * try (AreaInsightsClient areaInsightsClient = AreaInsightsClient.create()) {
 *   ComputeInsightsRequest request =
 *       ComputeInsightsRequest.newBuilder()
 *           .addAllInsights(new ArrayList<Insight>())
 *           .setFilter(Filter.newBuilder().build())
 *           .build();
 *   ComputeInsightsResponse response = areaInsightsClient.computeInsights(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AreaInsightsClient object to clean up resources such
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
 *      <td><p> ComputeInsights</td>
 *      <td><p> Compute Insights RPC
 * <p>  This method lets you retrieve insights about areas using a variaty of filter such as: area, place type, operating status, price level and ratings. Currently "count" and "places" insights are supported. With "count" insights you can answer questions such as "How many restaurant are located in California that are operational, are inexpensive and have an average rating of at least 4 stars" (see `insight` enum for more details). With "places" insights, you can determine which places match the requested filter. Clients can then use those place resource names to fetch more details about each individual place using the Places API.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> computeInsights(ComputeInsightsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> computeInsightsCallable()
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
 * <p>This class can be customized by passing in a custom instance of AreaInsightsSettings to
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
 * AreaInsightsSettings areaInsightsSettings =
 *     AreaInsightsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AreaInsightsClient areaInsightsClient = AreaInsightsClient.create(areaInsightsSettings);
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
 * AreaInsightsSettings areaInsightsSettings =
 *     AreaInsightsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AreaInsightsClient areaInsightsClient = AreaInsightsClient.create(areaInsightsSettings);
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
 * AreaInsightsSettings areaInsightsSettings = AreaInsightsSettings.newHttpJsonBuilder().build();
 * AreaInsightsClient areaInsightsClient = AreaInsightsClient.create(areaInsightsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AreaInsightsClient implements BackgroundResource {
  private final AreaInsightsSettings settings;
  private final AreaInsightsStub stub;

  /** Constructs an instance of AreaInsightsClient with default settings. */
  public static final AreaInsightsClient create() throws IOException {
    return create(AreaInsightsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AreaInsightsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AreaInsightsClient create(AreaInsightsSettings settings) throws IOException {
    return new AreaInsightsClient(settings);
  }

  /**
   * Constructs an instance of AreaInsightsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(AreaInsightsSettings).
   */
  public static final AreaInsightsClient create(AreaInsightsStub stub) {
    return new AreaInsightsClient(stub);
  }

  /**
   * Constructs an instance of AreaInsightsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AreaInsightsClient(AreaInsightsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AreaInsightsStubSettings) settings.getStubSettings()).createStub();
  }

  protected AreaInsightsClient(AreaInsightsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AreaInsightsSettings getSettings() {
    return settings;
  }

  public AreaInsightsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Compute Insights RPC
   *
   * <p>This method lets you retrieve insights about areas using a variaty of filter such as: area,
   * place type, operating status, price level and ratings. Currently "count" and "places" insights
   * are supported. With "count" insights you can answer questions such as "How many restaurant are
   * located in California that are operational, are inexpensive and have an average rating of at
   * least 4 stars" (see `insight` enum for more details). With "places" insights, you can determine
   * which places match the requested filter. Clients can then use those place resource names to
   * fetch more details about each individual place using the Places API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AreaInsightsClient areaInsightsClient = AreaInsightsClient.create()) {
   *   ComputeInsightsRequest request =
   *       ComputeInsightsRequest.newBuilder()
   *           .addAllInsights(new ArrayList<Insight>())
   *           .setFilter(Filter.newBuilder().build())
   *           .build();
   *   ComputeInsightsResponse response = areaInsightsClient.computeInsights(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComputeInsightsResponse computeInsights(ComputeInsightsRequest request) {
    return computeInsightsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Compute Insights RPC
   *
   * <p>This method lets you retrieve insights about areas using a variaty of filter such as: area,
   * place type, operating status, price level and ratings. Currently "count" and "places" insights
   * are supported. With "count" insights you can answer questions such as "How many restaurant are
   * located in California that are operational, are inexpensive and have an average rating of at
   * least 4 stars" (see `insight` enum for more details). With "places" insights, you can determine
   * which places match the requested filter. Clients can then use those place resource names to
   * fetch more details about each individual place using the Places API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AreaInsightsClient areaInsightsClient = AreaInsightsClient.create()) {
   *   ComputeInsightsRequest request =
   *       ComputeInsightsRequest.newBuilder()
   *           .addAllInsights(new ArrayList<Insight>())
   *           .setFilter(Filter.newBuilder().build())
   *           .build();
   *   ApiFuture<ComputeInsightsResponse> future =
   *       areaInsightsClient.computeInsightsCallable().futureCall(request);
   *   // Do something.
   *   ComputeInsightsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ComputeInsightsRequest, ComputeInsightsResponse>
      computeInsightsCallable() {
    return stub.computeInsightsCallable();
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
