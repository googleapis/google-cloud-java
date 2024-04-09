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

package com.google.maps.places.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.maps.places.v1.stub.PlacesStub;
import com.google.maps.places.v1.stub.PlacesStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service definition for the Places API. Note: every request (except for
 * Autocomplete requests) requires a field mask set outside of the request proto (`all/&#42;`, is
 * not assumed). The field mask can be set via the HTTP header `X-Goog-FieldMask`. See:
 * https://developers.google.com/maps/documentation/places/web-service/choose-fields
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
 * try (PlacesClient placesClient = PlacesClient.create()) {
 *   SearchNearbyRequest request =
 *       SearchNearbyRequest.newBuilder()
 *           .setLanguageCode("languageCode-2092349083")
 *           .setRegionCode("regionCode-1991004415")
 *           .addAllIncludedTypes(new ArrayList<String>())
 *           .addAllExcludedTypes(new ArrayList<String>())
 *           .addAllIncludedPrimaryTypes(new ArrayList<String>())
 *           .addAllExcludedPrimaryTypes(new ArrayList<String>())
 *           .setMaxResultCount(-1736124056)
 *           .setLocationRestriction(SearchNearbyRequest.LocationRestriction.newBuilder().build())
 *           .build();
 *   SearchNearbyResponse response = placesClient.searchNearby(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PlacesClient object to clean up resources such as
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
 *      <td><p> SearchNearby</td>
 *      <td><p> Search for places near locations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchNearby(SearchNearbyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchNearbyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchText</td>
 *      <td><p> Text query based place search.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchText(SearchTextRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchTextCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPhotoMedia</td>
 *      <td><p> Get a photo media with a photo reference string.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPhotoMedia(GetPhotoMediaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPhotoMedia(PhotoMediaName name)
 *           <li><p> getPhotoMedia(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPhotoMediaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPlace</td>
 *      <td><p> Get the details of a place based on its resource name, which is a string in the `places/{place_id}` format.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPlace(GetPlaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPlace(PlaceName name)
 *           <li><p> getPlace(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPlaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AutocompletePlaces</td>
 *      <td><p> Returns predictions for the given input.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> autocompletePlaces(AutocompletePlacesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> autocompletePlacesCallable()
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
 * <p>This class can be customized by passing in a custom instance of PlacesSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PlacesSettings placesSettings =
 *     PlacesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PlacesClient placesClient = PlacesClient.create(placesSettings);
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
 * PlacesSettings placesSettings = PlacesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PlacesClient placesClient = PlacesClient.create(placesSettings);
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
 * PlacesSettings placesSettings = PlacesSettings.newHttpJsonBuilder().build();
 * PlacesClient placesClient = PlacesClient.create(placesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PlacesClient implements BackgroundResource {
  private final PlacesSettings settings;
  private final PlacesStub stub;

  /** Constructs an instance of PlacesClient with default settings. */
  public static final PlacesClient create() throws IOException {
    return create(PlacesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PlacesClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PlacesClient create(PlacesSettings settings) throws IOException {
    return new PlacesClient(settings);
  }

  /**
   * Constructs an instance of PlacesClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(PlacesSettings).
   */
  public static final PlacesClient create(PlacesStub stub) {
    return new PlacesClient(stub);
  }

  /**
   * Constructs an instance of PlacesClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected PlacesClient(PlacesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PlacesStubSettings) settings.getStubSettings()).createStub();
  }

  protected PlacesClient(PlacesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PlacesSettings getSettings() {
    return settings;
  }

  public PlacesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search for places near locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacesClient placesClient = PlacesClient.create()) {
   *   SearchNearbyRequest request =
   *       SearchNearbyRequest.newBuilder()
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .addAllIncludedTypes(new ArrayList<String>())
   *           .addAllExcludedTypes(new ArrayList<String>())
   *           .addAllIncludedPrimaryTypes(new ArrayList<String>())
   *           .addAllExcludedPrimaryTypes(new ArrayList<String>())
   *           .setMaxResultCount(-1736124056)
   *           .setLocationRestriction(SearchNearbyRequest.LocationRestriction.newBuilder().build())
   *           .build();
   *   SearchNearbyResponse response = placesClient.searchNearby(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchNearbyResponse searchNearby(SearchNearbyRequest request) {
    return searchNearbyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search for places near locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacesClient placesClient = PlacesClient.create()) {
   *   SearchNearbyRequest request =
   *       SearchNearbyRequest.newBuilder()
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .addAllIncludedTypes(new ArrayList<String>())
   *           .addAllExcludedTypes(new ArrayList<String>())
   *           .addAllIncludedPrimaryTypes(new ArrayList<String>())
   *           .addAllExcludedPrimaryTypes(new ArrayList<String>())
   *           .setMaxResultCount(-1736124056)
   *           .setLocationRestriction(SearchNearbyRequest.LocationRestriction.newBuilder().build())
   *           .build();
   *   ApiFuture<SearchNearbyResponse> future =
   *       placesClient.searchNearbyCallable().futureCall(request);
   *   // Do something.
   *   SearchNearbyResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchNearbyRequest, SearchNearbyResponse> searchNearbyCallable() {
    return stub.searchNearbyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Text query based place search.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacesClient placesClient = PlacesClient.create()) {
   *   SearchTextRequest request =
   *       SearchTextRequest.newBuilder()
   *           .setTextQuery("textQuery-1050470501")
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .setIncludedType("includedType-45971946")
   *           .setOpenNow(true)
   *           .setMinRating(-543315926)
   *           .setMaxResultCount(-1736124056)
   *           .addAllPriceLevels(new ArrayList<PriceLevel>())
   *           .setStrictTypeFiltering(true)
   *           .setLocationBias(SearchTextRequest.LocationBias.newBuilder().build())
   *           .setLocationRestriction(SearchTextRequest.LocationRestriction.newBuilder().build())
   *           .setEvOptions(SearchTextRequest.EVOptions.newBuilder().build())
   *           .build();
   *   SearchTextResponse response = placesClient.searchText(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchTextResponse searchText(SearchTextRequest request) {
    return searchTextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Text query based place search.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacesClient placesClient = PlacesClient.create()) {
   *   SearchTextRequest request =
   *       SearchTextRequest.newBuilder()
   *           .setTextQuery("textQuery-1050470501")
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .setIncludedType("includedType-45971946")
   *           .setOpenNow(true)
   *           .setMinRating(-543315926)
   *           .setMaxResultCount(-1736124056)
   *           .addAllPriceLevels(new ArrayList<PriceLevel>())
   *           .setStrictTypeFiltering(true)
   *           .setLocationBias(SearchTextRequest.LocationBias.newBuilder().build())
   *           .setLocationRestriction(SearchTextRequest.LocationRestriction.newBuilder().build())
   *           .setEvOptions(SearchTextRequest.EVOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<SearchTextResponse> future = placesClient.searchTextCallable().futureCall(request);
   *   // Do something.
   *   SearchTextResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchTextRequest, SearchTextResponse> searchTextCallable() {
    return stub.searchTextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a photo media with a photo reference string.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacesClient placesClient = PlacesClient.create()) {
   *   PhotoMediaName name = PhotoMediaName.of("[PLACE_ID]", "[PHOTO_REFERENCE]");
   *   PhotoMedia response = placesClient.getPhotoMedia(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of a photo media in the format:
   *     `places/{place_id}/photos/{photo_reference}/media`.
   *     <p>The resource name of a photo as returned in a Place object's `photos.name` field comes
   *     with the format `places/{place_id}/photos/{photo_reference}`. You need to append `/media`
   *     at the end of the photo resource to get the photo media resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhotoMedia getPhotoMedia(PhotoMediaName name) {
    GetPhotoMediaRequest request =
        GetPhotoMediaRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPhotoMedia(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a photo media with a photo reference string.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacesClient placesClient = PlacesClient.create()) {
   *   String name = PhotoMediaName.of("[PLACE_ID]", "[PHOTO_REFERENCE]").toString();
   *   PhotoMedia response = placesClient.getPhotoMedia(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of a photo media in the format:
   *     `places/{place_id}/photos/{photo_reference}/media`.
   *     <p>The resource name of a photo as returned in a Place object's `photos.name` field comes
   *     with the format `places/{place_id}/photos/{photo_reference}`. You need to append `/media`
   *     at the end of the photo resource to get the photo media resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhotoMedia getPhotoMedia(String name) {
    GetPhotoMediaRequest request = GetPhotoMediaRequest.newBuilder().setName(name).build();
    return getPhotoMedia(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a photo media with a photo reference string.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacesClient placesClient = PlacesClient.create()) {
   *   GetPhotoMediaRequest request =
   *       GetPhotoMediaRequest.newBuilder()
   *           .setName(PhotoMediaName.of("[PLACE_ID]", "[PHOTO_REFERENCE]").toString())
   *           .setMaxWidthPx(-428899428)
   *           .setMaxHeightPx(-1974259963)
   *           .setSkipHttpRedirect(true)
   *           .build();
   *   PhotoMedia response = placesClient.getPhotoMedia(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhotoMedia getPhotoMedia(GetPhotoMediaRequest request) {
    return getPhotoMediaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a photo media with a photo reference string.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacesClient placesClient = PlacesClient.create()) {
   *   GetPhotoMediaRequest request =
   *       GetPhotoMediaRequest.newBuilder()
   *           .setName(PhotoMediaName.of("[PLACE_ID]", "[PHOTO_REFERENCE]").toString())
   *           .setMaxWidthPx(-428899428)
   *           .setMaxHeightPx(-1974259963)
   *           .setSkipHttpRedirect(true)
   *           .build();
   *   ApiFuture<PhotoMedia> future = placesClient.getPhotoMediaCallable().futureCall(request);
   *   // Do something.
   *   PhotoMedia response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPhotoMediaRequest, PhotoMedia> getPhotoMediaCallable() {
    return stub.getPhotoMediaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the details of a place based on its resource name, which is a string in the
   * `places/{place_id}` format.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacesClient placesClient = PlacesClient.create()) {
   *   PlaceName name = PlaceName.of("[PLACE_ID]");
   *   Place response = placesClient.getPlace(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of a place, in the `places/{place_id}` format.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Place getPlace(PlaceName name) {
    GetPlaceRequest request =
        GetPlaceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPlace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the details of a place based on its resource name, which is a string in the
   * `places/{place_id}` format.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacesClient placesClient = PlacesClient.create()) {
   *   String name = PlaceName.of("[PLACE_ID]").toString();
   *   Place response = placesClient.getPlace(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of a place, in the `places/{place_id}` format.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Place getPlace(String name) {
    GetPlaceRequest request = GetPlaceRequest.newBuilder().setName(name).build();
    return getPlace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the details of a place based on its resource name, which is a string in the
   * `places/{place_id}` format.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacesClient placesClient = PlacesClient.create()) {
   *   GetPlaceRequest request =
   *       GetPlaceRequest.newBuilder()
   *           .setName(PlaceName.of("[PLACE_ID]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .setSessionToken("sessionToken-696552189")
   *           .build();
   *   Place response = placesClient.getPlace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Place getPlace(GetPlaceRequest request) {
    return getPlaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the details of a place based on its resource name, which is a string in the
   * `places/{place_id}` format.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacesClient placesClient = PlacesClient.create()) {
   *   GetPlaceRequest request =
   *       GetPlaceRequest.newBuilder()
   *           .setName(PlaceName.of("[PLACE_ID]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .setSessionToken("sessionToken-696552189")
   *           .build();
   *   ApiFuture<Place> future = placesClient.getPlaceCallable().futureCall(request);
   *   // Do something.
   *   Place response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPlaceRequest, Place> getPlaceCallable() {
    return stub.getPlaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns predictions for the given input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacesClient placesClient = PlacesClient.create()) {
   *   AutocompletePlacesRequest request =
   *       AutocompletePlacesRequest.newBuilder()
   *           .setInput("input100358090")
   *           .setLocationBias(AutocompletePlacesRequest.LocationBias.newBuilder().build())
   *           .setLocationRestriction(
   *               AutocompletePlacesRequest.LocationRestriction.newBuilder().build())
   *           .addAllIncludedPrimaryTypes(new ArrayList<String>())
   *           .addAllIncludedRegionCodes(new ArrayList<String>())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .setOrigin(LatLng.newBuilder().build())
   *           .setInputOffset(1010406056)
   *           .setIncludeQueryPredictions(true)
   *           .setSessionToken("sessionToken-696552189")
   *           .build();
   *   AutocompletePlacesResponse response = placesClient.autocompletePlaces(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutocompletePlacesResponse autocompletePlaces(AutocompletePlacesRequest request) {
    return autocompletePlacesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns predictions for the given input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacesClient placesClient = PlacesClient.create()) {
   *   AutocompletePlacesRequest request =
   *       AutocompletePlacesRequest.newBuilder()
   *           .setInput("input100358090")
   *           .setLocationBias(AutocompletePlacesRequest.LocationBias.newBuilder().build())
   *           .setLocationRestriction(
   *               AutocompletePlacesRequest.LocationRestriction.newBuilder().build())
   *           .addAllIncludedPrimaryTypes(new ArrayList<String>())
   *           .addAllIncludedRegionCodes(new ArrayList<String>())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setRegionCode("regionCode-1991004415")
   *           .setOrigin(LatLng.newBuilder().build())
   *           .setInputOffset(1010406056)
   *           .setIncludeQueryPredictions(true)
   *           .setSessionToken("sessionToken-696552189")
   *           .build();
   *   ApiFuture<AutocompletePlacesResponse> future =
   *       placesClient.autocompletePlacesCallable().futureCall(request);
   *   // Do something.
   *   AutocompletePlacesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AutocompletePlacesRequest, AutocompletePlacesResponse>
      autocompletePlacesCallable() {
    return stub.autocompletePlacesCallable();
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
