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

package com.google.maps.geocode.v4;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.maps.geocode.v4.stub.DestinationServiceStub;
import com.google.maps.geocode.v4.stub.DestinationServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for retrieving destinations.
 *
 * <p>A destination provides hierarchical context about a place, which allows you to, for example,
 * find apartment buildings within a larger apartment complex and vice versa. It also provides
 * navigation points suitable for use cases such as ridesharing or delivery.
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
 * try (DestinationServiceClient destinationServiceClient = DestinationServiceClient.create()) {
 *   SearchDestinationsRequest request =
 *       SearchDestinationsRequest.newBuilder()
 *           .addAllTravelModes(new ArrayList<NavigationPoint.TravelMode>())
 *           .setLanguageCode("languageCode-2092349083")
 *           .setRegionCode("regionCode-1991004415")
 *           .build();
 *   SearchDestinationsResponse response = destinationServiceClient.searchDestinations(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DestinationServiceClient object to clean up resources
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
 *      <td><p> SearchDestinations</td>
 *      <td><p> This method performs a destination lookup and returns a list of destinations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchDestinations(SearchDestinationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchDestinationsCallable()
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
 * <p>This class can be customized by passing in a custom instance of DestinationServiceSettings to
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
 * DestinationServiceSettings destinationServiceSettings =
 *     DestinationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DestinationServiceClient destinationServiceClient =
 *     DestinationServiceClient.create(destinationServiceSettings);
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
 * DestinationServiceSettings destinationServiceSettings =
 *     DestinationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DestinationServiceClient destinationServiceClient =
 *     DestinationServiceClient.create(destinationServiceSettings);
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
 * DestinationServiceSettings destinationServiceSettings =
 *     DestinationServiceSettings.newHttpJsonBuilder().build();
 * DestinationServiceClient destinationServiceClient =
 *     DestinationServiceClient.create(destinationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DestinationServiceClient implements BackgroundResource {
  private final DestinationServiceSettings settings;
  private final DestinationServiceStub stub;

  /** Constructs an instance of DestinationServiceClient with default settings. */
  public static final DestinationServiceClient create() throws IOException {
    return create(DestinationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DestinationServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DestinationServiceClient create(DestinationServiceSettings settings)
      throws IOException {
    return new DestinationServiceClient(settings);
  }

  /**
   * Constructs an instance of DestinationServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(DestinationServiceSettings).
   */
  public static final DestinationServiceClient create(DestinationServiceStub stub) {
    return new DestinationServiceClient(stub);
  }

  /**
   * Constructs an instance of DestinationServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DestinationServiceClient(DestinationServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DestinationServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DestinationServiceClient(DestinationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DestinationServiceSettings getSettings() {
    return settings;
  }

  public DestinationServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method performs a destination lookup and returns a list of destinations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DestinationServiceClient destinationServiceClient = DestinationServiceClient.create()) {
   *   SearchDestinationsRequest request =
   *       SearchDestinationsRequest.newBuilder()
   *           .addAllTravelModes(new ArrayList<NavigationPoint.TravelMode>())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .build();
   *   SearchDestinationsResponse response = destinationServiceClient.searchDestinations(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchDestinationsResponse searchDestinations(SearchDestinationsRequest request) {
    return searchDestinationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method performs a destination lookup and returns a list of destinations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DestinationServiceClient destinationServiceClient = DestinationServiceClient.create()) {
   *   SearchDestinationsRequest request =
   *       SearchDestinationsRequest.newBuilder()
   *           .addAllTravelModes(new ArrayList<NavigationPoint.TravelMode>())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .build();
   *   ApiFuture<SearchDestinationsResponse> future =
   *       destinationServiceClient.searchDestinationsCallable().futureCall(request);
   *   // Do something.
   *   SearchDestinationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchDestinationsRequest, SearchDestinationsResponse>
      searchDestinationsCallable() {
    return stub.searchDestinationsCallable();
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
