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

package com.google.maps.solar.v1;

import com.google.api.HttpBody;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.maps.solar.v1.stub.SolarStub;
import com.google.maps.solar.v1.stub.SolarStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service definition for the Solar API.
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
 * try (SolarClient solarClient = SolarClient.create()) {
 *   FindClosestBuildingInsightsRequest request =
 *       FindClosestBuildingInsightsRequest.newBuilder()
 *           .setLocation(LatLng.newBuilder().build())
 *           .setRequiredQuality(ImageryQuality.forNumber(0))
 *           .setExactQualityRequired(true)
 *           .build();
 *   BuildingInsights response = solarClient.findClosestBuildingInsights(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SolarClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> FindClosestBuildingInsights</td>
 *      <td><p> Locates the closest building to a query point. Returns an error with code `NOT_FOUND` if there are no buildings within approximately 50m of the query point.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> findClosestBuildingInsights(FindClosestBuildingInsightsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> findClosestBuildingInsightsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataLayers</td>
 *      <td><p> Gets solar information for a region surrounding a location. Returns an error with code `NOT_FOUND` if the location is outside the coverage area.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataLayers(GetDataLayersRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataLayersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGeoTiff</td>
 *      <td><p> Returns an image by its ID.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGeoTiff(GetGeoTiffRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGeoTiffCallable()
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
 * <p>This class can be customized by passing in a custom instance of SolarSettings to create(). For
 * example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SolarSettings solarSettings =
 *     SolarSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SolarClient solarClient = SolarClient.create(solarSettings);
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
 * SolarSettings solarSettings = SolarSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SolarClient solarClient = SolarClient.create(solarSettings);
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
 * SolarSettings solarSettings = SolarSettings.newHttpJsonBuilder().build();
 * SolarClient solarClient = SolarClient.create(solarSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SolarClient implements BackgroundResource {
  private final SolarSettings settings;
  private final SolarStub stub;

  /** Constructs an instance of SolarClient with default settings. */
  public static final SolarClient create() throws IOException {
    return create(SolarSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SolarClient, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SolarClient create(SolarSettings settings) throws IOException {
    return new SolarClient(settings);
  }

  /**
   * Constructs an instance of SolarClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(SolarSettings).
   */
  public static final SolarClient create(SolarStub stub) {
    return new SolarClient(stub);
  }

  /**
   * Constructs an instance of SolarClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected SolarClient(SolarSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SolarStubSettings) settings.getStubSettings()).createStub();
  }

  protected SolarClient(SolarStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SolarSettings getSettings() {
    return settings;
  }

  public SolarStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locates the closest building to a query point. Returns an error with code `NOT_FOUND` if there
   * are no buildings within approximately 50m of the query point.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SolarClient solarClient = SolarClient.create()) {
   *   FindClosestBuildingInsightsRequest request =
   *       FindClosestBuildingInsightsRequest.newBuilder()
   *           .setLocation(LatLng.newBuilder().build())
   *           .setRequiredQuality(ImageryQuality.forNumber(0))
   *           .setExactQualityRequired(true)
   *           .build();
   *   BuildingInsights response = solarClient.findClosestBuildingInsights(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BuildingInsights findClosestBuildingInsights(
      FindClosestBuildingInsightsRequest request) {
    return findClosestBuildingInsightsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locates the closest building to a query point. Returns an error with code `NOT_FOUND` if there
   * are no buildings within approximately 50m of the query point.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SolarClient solarClient = SolarClient.create()) {
   *   FindClosestBuildingInsightsRequest request =
   *       FindClosestBuildingInsightsRequest.newBuilder()
   *           .setLocation(LatLng.newBuilder().build())
   *           .setRequiredQuality(ImageryQuality.forNumber(0))
   *           .setExactQualityRequired(true)
   *           .build();
   *   ApiFuture<BuildingInsights> future =
   *       solarClient.findClosestBuildingInsightsCallable().futureCall(request);
   *   // Do something.
   *   BuildingInsights response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FindClosestBuildingInsightsRequest, BuildingInsights>
      findClosestBuildingInsightsCallable() {
    return stub.findClosestBuildingInsightsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets solar information for a region surrounding a location. Returns an error with code
   * `NOT_FOUND` if the location is outside the coverage area.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SolarClient solarClient = SolarClient.create()) {
   *   GetDataLayersRequest request =
   *       GetDataLayersRequest.newBuilder()
   *           .setLocation(LatLng.newBuilder().build())
   *           .setRadiusMeters(1254190679)
   *           .setView(DataLayerView.forNumber(0))
   *           .setRequiredQuality(ImageryQuality.forNumber(0))
   *           .setPixelSizeMeters(-1623742513)
   *           .setExactQualityRequired(true)
   *           .build();
   *   DataLayers response = solarClient.getDataLayers(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataLayers getDataLayers(GetDataLayersRequest request) {
    return getDataLayersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets solar information for a region surrounding a location. Returns an error with code
   * `NOT_FOUND` if the location is outside the coverage area.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SolarClient solarClient = SolarClient.create()) {
   *   GetDataLayersRequest request =
   *       GetDataLayersRequest.newBuilder()
   *           .setLocation(LatLng.newBuilder().build())
   *           .setRadiusMeters(1254190679)
   *           .setView(DataLayerView.forNumber(0))
   *           .setRequiredQuality(ImageryQuality.forNumber(0))
   *           .setPixelSizeMeters(-1623742513)
   *           .setExactQualityRequired(true)
   *           .build();
   *   ApiFuture<DataLayers> future = solarClient.getDataLayersCallable().futureCall(request);
   *   // Do something.
   *   DataLayers response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataLayersRequest, DataLayers> getDataLayersCallable() {
    return stub.getDataLayersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns an image by its ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SolarClient solarClient = SolarClient.create()) {
   *   GetGeoTiffRequest request = GetGeoTiffRequest.newBuilder().setId("id3355").build();
   *   HttpBody response = solarClient.getGeoTiff(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody getGeoTiff(GetGeoTiffRequest request) {
    return getGeoTiffCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns an image by its ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SolarClient solarClient = SolarClient.create()) {
   *   GetGeoTiffRequest request = GetGeoTiffRequest.newBuilder().setId("id3355").build();
   *   ApiFuture<HttpBody> future = solarClient.getGeoTiffCallable().futureCall(request);
   *   // Do something.
   *   HttpBody response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGeoTiffRequest, HttpBody> getGeoTiffCallable() {
    return stub.getGeoTiffCallable();
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
