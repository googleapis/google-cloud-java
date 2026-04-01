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
import com.google.maps.geocode.v4.stub.GeocodeServiceStub;
import com.google.maps.geocode.v4.stub.GeocodeServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for performing geocoding.
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
 * try (GeocodeServiceClient geocodeServiceClient = GeocodeServiceClient.create()) {
 *   GeocodeAddressRequest request =
 *       GeocodeAddressRequest.newBuilder()
 *           .setLocationBias(GeocodeAddressRequest.LocationBias.newBuilder().build())
 *           .setLanguageCode("languageCode-2092349083")
 *           .setRegionCode("regionCode-1991004415")
 *           .build();
 *   GeocodeAddressResponse response = geocodeServiceClient.geocodeAddress(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GeocodeServiceClient object to clean up resources such
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
 *      <td><p> GeocodeAddress</td>
 *      <td><p> This method performs an address geocode, which maps an address to a LatLng. It also provides structured information about the address.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> geocodeAddress(GeocodeAddressRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> geocodeAddressCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GeocodeLocation</td>
 *      <td><p> This method performs a location geocode, which maps a LatLng to an address. It also provides structured information about the address.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> geocodeLocation(GeocodeLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> geocodeLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GeocodePlace</td>
 *      <td><p> This method performs a geocode lookup using a place ID.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> geocodePlace(GeocodePlaceRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> geocodePlaceCallable()
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
 * <p>This class can be customized by passing in a custom instance of GeocodeServiceSettings to
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
 * GeocodeServiceSettings geocodeServiceSettings =
 *     GeocodeServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GeocodeServiceClient geocodeServiceClient = GeocodeServiceClient.create(geocodeServiceSettings);
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
 * GeocodeServiceSettings geocodeServiceSettings =
 *     GeocodeServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GeocodeServiceClient geocodeServiceClient = GeocodeServiceClient.create(geocodeServiceSettings);
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
 * GeocodeServiceSettings geocodeServiceSettings =
 *     GeocodeServiceSettings.newHttpJsonBuilder().build();
 * GeocodeServiceClient geocodeServiceClient = GeocodeServiceClient.create(geocodeServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class GeocodeServiceClient implements BackgroundResource {
  private final GeocodeServiceSettings settings;
  private final GeocodeServiceStub stub;

  /** Constructs an instance of GeocodeServiceClient with default settings. */
  public static final GeocodeServiceClient create() throws IOException {
    return create(GeocodeServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GeocodeServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GeocodeServiceClient create(GeocodeServiceSettings settings)
      throws IOException {
    return new GeocodeServiceClient(settings);
  }

  /**
   * Constructs an instance of GeocodeServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(GeocodeServiceSettings).
   */
  public static final GeocodeServiceClient create(GeocodeServiceStub stub) {
    return new GeocodeServiceClient(stub);
  }

  /**
   * Constructs an instance of GeocodeServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GeocodeServiceClient(GeocodeServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GeocodeServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected GeocodeServiceClient(GeocodeServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GeocodeServiceSettings getSettings() {
    return settings;
  }

  public GeocodeServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method performs an address geocode, which maps an address to a LatLng. It also provides
   * structured information about the address.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeocodeServiceClient geocodeServiceClient = GeocodeServiceClient.create()) {
   *   GeocodeAddressRequest request =
   *       GeocodeAddressRequest.newBuilder()
   *           .setLocationBias(GeocodeAddressRequest.LocationBias.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .build();
   *   GeocodeAddressResponse response = geocodeServiceClient.geocodeAddress(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GeocodeAddressResponse geocodeAddress(GeocodeAddressRequest request) {
    return geocodeAddressCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method performs an address geocode, which maps an address to a LatLng. It also provides
   * structured information about the address.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeocodeServiceClient geocodeServiceClient = GeocodeServiceClient.create()) {
   *   GeocodeAddressRequest request =
   *       GeocodeAddressRequest.newBuilder()
   *           .setLocationBias(GeocodeAddressRequest.LocationBias.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .build();
   *   ApiFuture<GeocodeAddressResponse> future =
   *       geocodeServiceClient.geocodeAddressCallable().futureCall(request);
   *   // Do something.
   *   GeocodeAddressResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GeocodeAddressRequest, GeocodeAddressResponse>
      geocodeAddressCallable() {
    return stub.geocodeAddressCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method performs a location geocode, which maps a LatLng to an address. It also provides
   * structured information about the address.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeocodeServiceClient geocodeServiceClient = GeocodeServiceClient.create()) {
   *   GeocodeLocationRequest request =
   *       GeocodeLocationRequest.newBuilder()
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .addAllTypes(new ArrayList<String>())
   *           .addAllGranularity(new ArrayList<GeocodeResult.Granularity>())
   *           .build();
   *   GeocodeLocationResponse response = geocodeServiceClient.geocodeLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GeocodeLocationResponse geocodeLocation(GeocodeLocationRequest request) {
    return geocodeLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method performs a location geocode, which maps a LatLng to an address. It also provides
   * structured information about the address.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeocodeServiceClient geocodeServiceClient = GeocodeServiceClient.create()) {
   *   GeocodeLocationRequest request =
   *       GeocodeLocationRequest.newBuilder()
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .addAllTypes(new ArrayList<String>())
   *           .addAllGranularity(new ArrayList<GeocodeResult.Granularity>())
   *           .build();
   *   ApiFuture<GeocodeLocationResponse> future =
   *       geocodeServiceClient.geocodeLocationCallable().futureCall(request);
   *   // Do something.
   *   GeocodeLocationResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GeocodeLocationRequest, GeocodeLocationResponse>
      geocodeLocationCallable() {
    return stub.geocodeLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method performs a geocode lookup using a place ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeocodeServiceClient geocodeServiceClient = GeocodeServiceClient.create()) {
   *   GeocodePlaceRequest request =
   *       GeocodePlaceRequest.newBuilder()
   *           .setPlace("place106748167")
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .build();
   *   GeocodeResult response = geocodeServiceClient.geocodePlace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GeocodeResult geocodePlace(GeocodePlaceRequest request) {
    return geocodePlaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method performs a geocode lookup using a place ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeocodeServiceClient geocodeServiceClient = GeocodeServiceClient.create()) {
   *   GeocodePlaceRequest request =
   *       GeocodePlaceRequest.newBuilder()
   *           .setPlace("place106748167")
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .build();
   *   ApiFuture<GeocodeResult> future =
   *       geocodeServiceClient.geocodePlaceCallable().futureCall(request);
   *   // Do something.
   *   GeocodeResult response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GeocodePlaceRequest, GeocodeResult> geocodePlaceCallable() {
    return stub.geocodePlaceCallable();
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
