/*
 * Copyright 2025 Google LLC
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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.geo.type.Viewport;
import com.google.protobuf.AbstractMessage;
import com.google.type.LatLng;
import com.google.type.LocalizedText;
import com.google.type.PostalAddress;
import com.google.type.TimeZone;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class PlacesClientTest {
  private static MockPlaces mockPlaces;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PlacesClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPlaces = new MockPlaces();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockPlaces));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    PlacesSettings settings =
        PlacesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PlacesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void searchNearbyTest() throws Exception {
    SearchNearbyResponse expectedResponse =
        SearchNearbyResponse.newBuilder()
            .addAllPlaces(new ArrayList<Place>())
            .addAllRoutingSummaries(new ArrayList<RoutingSummary>())
            .build();
    mockPlaces.addResponse(expectedResponse);

    SearchNearbyRequest request =
        SearchNearbyRequest.newBuilder()
            .setLanguageCode("languageCode-2092349083")
            .setRegionCode("regionCode-1991004415")
            .addAllIncludedTypes(new ArrayList<String>())
            .addAllExcludedTypes(new ArrayList<String>())
            .addAllIncludedPrimaryTypes(new ArrayList<String>())
            .addAllExcludedPrimaryTypes(new ArrayList<String>())
            .setMaxResultCount(-1736124056)
            .setLocationRestriction(SearchNearbyRequest.LocationRestriction.newBuilder().build())
            .setRoutingParameters(RoutingParameters.newBuilder().build())
            .build();

    SearchNearbyResponse actualResponse = client.searchNearby(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaces.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchNearbyRequest actualRequest = ((SearchNearbyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertEquals(request.getRegionCode(), actualRequest.getRegionCode());
    Assert.assertEquals(request.getIncludedTypesList(), actualRequest.getIncludedTypesList());
    Assert.assertEquals(request.getExcludedTypesList(), actualRequest.getExcludedTypesList());
    Assert.assertEquals(
        request.getIncludedPrimaryTypesList(), actualRequest.getIncludedPrimaryTypesList());
    Assert.assertEquals(
        request.getExcludedPrimaryTypesList(), actualRequest.getExcludedPrimaryTypesList());
    Assert.assertEquals(request.getMaxResultCount(), actualRequest.getMaxResultCount());
    Assert.assertEquals(request.getLocationRestriction(), actualRequest.getLocationRestriction());
    Assert.assertEquals(request.getRankPreference(), actualRequest.getRankPreference());
    Assert.assertEquals(request.getRoutingParameters(), actualRequest.getRoutingParameters());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchNearbyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaces.addException(exception);

    try {
      SearchNearbyRequest request =
          SearchNearbyRequest.newBuilder()
              .setLanguageCode("languageCode-2092349083")
              .setRegionCode("regionCode-1991004415")
              .addAllIncludedTypes(new ArrayList<String>())
              .addAllExcludedTypes(new ArrayList<String>())
              .addAllIncludedPrimaryTypes(new ArrayList<String>())
              .addAllExcludedPrimaryTypes(new ArrayList<String>())
              .setMaxResultCount(-1736124056)
              .setLocationRestriction(SearchNearbyRequest.LocationRestriction.newBuilder().build())
              .setRoutingParameters(RoutingParameters.newBuilder().build())
              .build();
      client.searchNearby(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchTextTest() throws Exception {
    SearchTextResponse expectedResponse =
        SearchTextResponse.newBuilder()
            .addAllPlaces(new ArrayList<Place>())
            .addAllRoutingSummaries(new ArrayList<RoutingSummary>())
            .addAllContextualContents(new ArrayList<ContextualContent>())
            .build();
    mockPlaces.addResponse(expectedResponse);

    SearchTextRequest request =
        SearchTextRequest.newBuilder()
            .setTextQuery("textQuery-1050470501")
            .setLanguageCode("languageCode-2092349083")
            .setRegionCode("regionCode-1991004415")
            .setIncludedType("includedType-45971946")
            .setOpenNow(true)
            .setMinRating(-543315926)
            .setMaxResultCount(-1736124056)
            .addAllPriceLevels(new ArrayList<PriceLevel>())
            .setStrictTypeFiltering(true)
            .setLocationBias(SearchTextRequest.LocationBias.newBuilder().build())
            .setLocationRestriction(SearchTextRequest.LocationRestriction.newBuilder().build())
            .setEvOptions(SearchTextRequest.EVOptions.newBuilder().build())
            .setRoutingParameters(RoutingParameters.newBuilder().build())
            .setSearchAlongRouteParameters(
                SearchTextRequest.SearchAlongRouteParameters.newBuilder().build())
            .setIncludePureServiceAreaBusinesses(true)
            .build();

    SearchTextResponse actualResponse = client.searchText(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaces.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchTextRequest actualRequest = ((SearchTextRequest) actualRequests.get(0));

    Assert.assertEquals(request.getTextQuery(), actualRequest.getTextQuery());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertEquals(request.getRegionCode(), actualRequest.getRegionCode());
    Assert.assertEquals(request.getRankPreference(), actualRequest.getRankPreference());
    Assert.assertEquals(request.getIncludedType(), actualRequest.getIncludedType());
    Assert.assertEquals(request.getOpenNow(), actualRequest.getOpenNow());
    Assert.assertEquals(request.getMinRating(), actualRequest.getMinRating(), 0.0001);
    Assert.assertEquals(request.getMaxResultCount(), actualRequest.getMaxResultCount());
    Assert.assertEquals(request.getPriceLevelsList(), actualRequest.getPriceLevelsList());
    Assert.assertEquals(request.getStrictTypeFiltering(), actualRequest.getStrictTypeFiltering());
    Assert.assertEquals(request.getLocationBias(), actualRequest.getLocationBias());
    Assert.assertEquals(request.getLocationRestriction(), actualRequest.getLocationRestriction());
    Assert.assertEquals(request.getEvOptions(), actualRequest.getEvOptions());
    Assert.assertEquals(request.getRoutingParameters(), actualRequest.getRoutingParameters());
    Assert.assertEquals(
        request.getSearchAlongRouteParameters(), actualRequest.getSearchAlongRouteParameters());
    Assert.assertEquals(
        request.getIncludePureServiceAreaBusinesses(),
        actualRequest.getIncludePureServiceAreaBusinesses());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchTextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaces.addException(exception);

    try {
      SearchTextRequest request =
          SearchTextRequest.newBuilder()
              .setTextQuery("textQuery-1050470501")
              .setLanguageCode("languageCode-2092349083")
              .setRegionCode("regionCode-1991004415")
              .setIncludedType("includedType-45971946")
              .setOpenNow(true)
              .setMinRating(-543315926)
              .setMaxResultCount(-1736124056)
              .addAllPriceLevels(new ArrayList<PriceLevel>())
              .setStrictTypeFiltering(true)
              .setLocationBias(SearchTextRequest.LocationBias.newBuilder().build())
              .setLocationRestriction(SearchTextRequest.LocationRestriction.newBuilder().build())
              .setEvOptions(SearchTextRequest.EVOptions.newBuilder().build())
              .setRoutingParameters(RoutingParameters.newBuilder().build())
              .setSearchAlongRouteParameters(
                  SearchTextRequest.SearchAlongRouteParameters.newBuilder().build())
              .setIncludePureServiceAreaBusinesses(true)
              .build();
      client.searchText(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPhotoMediaTest() throws Exception {
    PhotoMedia expectedResponse =
        PhotoMedia.newBuilder()
            .setName(PhotoMediaName.of("[PLACE_ID]", "[PHOTO_REFERENCE]").toString())
            .setPhotoUri("photoUri-1274279462")
            .build();
    mockPlaces.addResponse(expectedResponse);

    PhotoMediaName name = PhotoMediaName.of("[PLACE_ID]", "[PHOTO_REFERENCE]");

    PhotoMedia actualResponse = client.getPhotoMedia(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaces.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPhotoMediaRequest actualRequest = ((GetPhotoMediaRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPhotoMediaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaces.addException(exception);

    try {
      PhotoMediaName name = PhotoMediaName.of("[PLACE_ID]", "[PHOTO_REFERENCE]");
      client.getPhotoMedia(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPhotoMediaTest2() throws Exception {
    PhotoMedia expectedResponse =
        PhotoMedia.newBuilder()
            .setName(PhotoMediaName.of("[PLACE_ID]", "[PHOTO_REFERENCE]").toString())
            .setPhotoUri("photoUri-1274279462")
            .build();
    mockPlaces.addResponse(expectedResponse);

    String name = "name3373707";

    PhotoMedia actualResponse = client.getPhotoMedia(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaces.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPhotoMediaRequest actualRequest = ((GetPhotoMediaRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPhotoMediaExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaces.addException(exception);

    try {
      String name = "name3373707";
      client.getPhotoMedia(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPlaceTest() throws Exception {
    Place expectedResponse =
        Place.newBuilder()
            .setName(PlaceName.of("[PLACE_ID]").toString())
            .setId("id3355")
            .setDisplayName(LocalizedText.newBuilder().build())
            .addAllTypes(new ArrayList<String>())
            .setPrimaryType("primaryType-867549092")
            .setPrimaryTypeDisplayName(LocalizedText.newBuilder().build())
            .setNationalPhoneNumber("nationalPhoneNumber-1432446651")
            .setInternationalPhoneNumber("internationalPhoneNumber-74125591")
            .setFormattedAddress("formattedAddress1036810136")
            .setShortFormattedAddress("shortFormattedAddress282445876")
            .setPostalAddress(PostalAddress.newBuilder().build())
            .addAllAddressComponents(new ArrayList<Place.AddressComponent>())
            .setPlusCode(Place.PlusCode.newBuilder().build())
            .setLocation(LatLng.newBuilder().build())
            .setViewport(Viewport.newBuilder().build())
            .setRating(-938102371)
            .setGoogleMapsUri("googleMapsUri1129292508")
            .setWebsiteUri("websiteUri1317135057")
            .addAllReviews(new ArrayList<Review>())
            .setRegularOpeningHours(Place.OpeningHours.newBuilder().build())
            .setUtcOffsetMinutes(1046614318)
            .setTimeZone(TimeZone.newBuilder().build())
            .addAllPhotos(new ArrayList<Photo>())
            .setAdrFormatAddress("adrFormatAddress1685861262")
            .setPriceLevel(PriceLevel.forNumber(0))
            .addAllAttributions(new ArrayList<Place.Attribution>())
            .setUserRatingCount(-1453311007)
            .setIconMaskBaseUri("iconMaskBaseUri-1698247146")
            .setIconBackgroundColor("iconBackgroundColor1458295068")
            .setTakeout(true)
            .setDelivery(true)
            .setDineIn(true)
            .setCurbsidePickup(true)
            .setReservable(true)
            .setServesBreakfast(true)
            .setServesLunch(true)
            .setServesDinner(true)
            .setServesBeer(true)
            .setServesWine(true)
            .setServesBrunch(true)
            .setServesVegetarianFood(true)
            .setCurrentOpeningHours(Place.OpeningHours.newBuilder().build())
            .addAllCurrentSecondaryOpeningHours(new ArrayList<Place.OpeningHours>())
            .addAllRegularSecondaryOpeningHours(new ArrayList<Place.OpeningHours>())
            .setEditorialSummary(LocalizedText.newBuilder().build())
            .setOutdoorSeating(true)
            .setLiveMusic(true)
            .setMenuForChildren(true)
            .setServesCocktails(true)
            .setServesDessert(true)
            .setServesCoffee(true)
            .setGoodForChildren(true)
            .setAllowsDogs(true)
            .setRestroom(true)
            .setGoodForGroups(true)
            .setGoodForWatchingSports(true)
            .setPaymentOptions(Place.PaymentOptions.newBuilder().build())
            .setParkingOptions(Place.ParkingOptions.newBuilder().build())
            .addAllSubDestinations(new ArrayList<Place.SubDestination>())
            .setAccessibilityOptions(Place.AccessibilityOptions.newBuilder().build())
            .setFuelOptions(FuelOptions.newBuilder().build())
            .setEvChargeOptions(EVChargeOptions.newBuilder().build())
            .setGenerativeSummary(Place.GenerativeSummary.newBuilder().build())
            .setAreaSummary(Place.AreaSummary.newBuilder().build())
            .addAllContainingPlaces(new ArrayList<Place.ContainingPlace>())
            .setPureServiceAreaBusiness(true)
            .setPriceRange(PriceRange.newBuilder().build())
            .build();
    mockPlaces.addResponse(expectedResponse);

    PlaceName name = PlaceName.of("[PLACE_ID]");

    Place actualResponse = client.getPlace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaces.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPlaceRequest actualRequest = ((GetPlaceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPlaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaces.addException(exception);

    try {
      PlaceName name = PlaceName.of("[PLACE_ID]");
      client.getPlace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPlaceTest2() throws Exception {
    Place expectedResponse =
        Place.newBuilder()
            .setName(PlaceName.of("[PLACE_ID]").toString())
            .setId("id3355")
            .setDisplayName(LocalizedText.newBuilder().build())
            .addAllTypes(new ArrayList<String>())
            .setPrimaryType("primaryType-867549092")
            .setPrimaryTypeDisplayName(LocalizedText.newBuilder().build())
            .setNationalPhoneNumber("nationalPhoneNumber-1432446651")
            .setInternationalPhoneNumber("internationalPhoneNumber-74125591")
            .setFormattedAddress("formattedAddress1036810136")
            .setShortFormattedAddress("shortFormattedAddress282445876")
            .setPostalAddress(PostalAddress.newBuilder().build())
            .addAllAddressComponents(new ArrayList<Place.AddressComponent>())
            .setPlusCode(Place.PlusCode.newBuilder().build())
            .setLocation(LatLng.newBuilder().build())
            .setViewport(Viewport.newBuilder().build())
            .setRating(-938102371)
            .setGoogleMapsUri("googleMapsUri1129292508")
            .setWebsiteUri("websiteUri1317135057")
            .addAllReviews(new ArrayList<Review>())
            .setRegularOpeningHours(Place.OpeningHours.newBuilder().build())
            .setUtcOffsetMinutes(1046614318)
            .setTimeZone(TimeZone.newBuilder().build())
            .addAllPhotos(new ArrayList<Photo>())
            .setAdrFormatAddress("adrFormatAddress1685861262")
            .setPriceLevel(PriceLevel.forNumber(0))
            .addAllAttributions(new ArrayList<Place.Attribution>())
            .setUserRatingCount(-1453311007)
            .setIconMaskBaseUri("iconMaskBaseUri-1698247146")
            .setIconBackgroundColor("iconBackgroundColor1458295068")
            .setTakeout(true)
            .setDelivery(true)
            .setDineIn(true)
            .setCurbsidePickup(true)
            .setReservable(true)
            .setServesBreakfast(true)
            .setServesLunch(true)
            .setServesDinner(true)
            .setServesBeer(true)
            .setServesWine(true)
            .setServesBrunch(true)
            .setServesVegetarianFood(true)
            .setCurrentOpeningHours(Place.OpeningHours.newBuilder().build())
            .addAllCurrentSecondaryOpeningHours(new ArrayList<Place.OpeningHours>())
            .addAllRegularSecondaryOpeningHours(new ArrayList<Place.OpeningHours>())
            .setEditorialSummary(LocalizedText.newBuilder().build())
            .setOutdoorSeating(true)
            .setLiveMusic(true)
            .setMenuForChildren(true)
            .setServesCocktails(true)
            .setServesDessert(true)
            .setServesCoffee(true)
            .setGoodForChildren(true)
            .setAllowsDogs(true)
            .setRestroom(true)
            .setGoodForGroups(true)
            .setGoodForWatchingSports(true)
            .setPaymentOptions(Place.PaymentOptions.newBuilder().build())
            .setParkingOptions(Place.ParkingOptions.newBuilder().build())
            .addAllSubDestinations(new ArrayList<Place.SubDestination>())
            .setAccessibilityOptions(Place.AccessibilityOptions.newBuilder().build())
            .setFuelOptions(FuelOptions.newBuilder().build())
            .setEvChargeOptions(EVChargeOptions.newBuilder().build())
            .setGenerativeSummary(Place.GenerativeSummary.newBuilder().build())
            .setAreaSummary(Place.AreaSummary.newBuilder().build())
            .addAllContainingPlaces(new ArrayList<Place.ContainingPlace>())
            .setPureServiceAreaBusiness(true)
            .setPriceRange(PriceRange.newBuilder().build())
            .build();
    mockPlaces.addResponse(expectedResponse);

    String name = "name3373707";

    Place actualResponse = client.getPlace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaces.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPlaceRequest actualRequest = ((GetPlaceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPlaceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaces.addException(exception);

    try {
      String name = "name3373707";
      client.getPlace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void autocompletePlacesTest() throws Exception {
    AutocompletePlacesResponse expectedResponse =
        AutocompletePlacesResponse.newBuilder()
            .addAllSuggestions(new ArrayList<AutocompletePlacesResponse.Suggestion>())
            .build();
    mockPlaces.addResponse(expectedResponse);

    AutocompletePlacesRequest request =
        AutocompletePlacesRequest.newBuilder()
            .setInput("input100358090")
            .setLocationBias(AutocompletePlacesRequest.LocationBias.newBuilder().build())
            .setLocationRestriction(
                AutocompletePlacesRequest.LocationRestriction.newBuilder().build())
            .addAllIncludedPrimaryTypes(new ArrayList<String>())
            .addAllIncludedRegionCodes(new ArrayList<String>())
            .setLanguageCode("languageCode-2092349083")
            .setRegionCode("regionCode-1991004415")
            .setOrigin(LatLng.newBuilder().build())
            .setInputOffset(1010406056)
            .setIncludeQueryPredictions(true)
            .setSessionToken("sessionToken-696552189")
            .setIncludePureServiceAreaBusinesses(true)
            .build();

    AutocompletePlacesResponse actualResponse = client.autocompletePlaces(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaces.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AutocompletePlacesRequest actualRequest = ((AutocompletePlacesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInput(), actualRequest.getInput());
    Assert.assertEquals(request.getLocationBias(), actualRequest.getLocationBias());
    Assert.assertEquals(request.getLocationRestriction(), actualRequest.getLocationRestriction());
    Assert.assertEquals(
        request.getIncludedPrimaryTypesList(), actualRequest.getIncludedPrimaryTypesList());
    Assert.assertEquals(
        request.getIncludedRegionCodesList(), actualRequest.getIncludedRegionCodesList());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertEquals(request.getRegionCode(), actualRequest.getRegionCode());
    Assert.assertEquals(request.getOrigin(), actualRequest.getOrigin());
    Assert.assertEquals(request.getInputOffset(), actualRequest.getInputOffset());
    Assert.assertEquals(
        request.getIncludeQueryPredictions(), actualRequest.getIncludeQueryPredictions());
    Assert.assertEquals(request.getSessionToken(), actualRequest.getSessionToken());
    Assert.assertEquals(
        request.getIncludePureServiceAreaBusinesses(),
        actualRequest.getIncludePureServiceAreaBusinesses());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void autocompletePlacesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaces.addException(exception);

    try {
      AutocompletePlacesRequest request =
          AutocompletePlacesRequest.newBuilder()
              .setInput("input100358090")
              .setLocationBias(AutocompletePlacesRequest.LocationBias.newBuilder().build())
              .setLocationRestriction(
                  AutocompletePlacesRequest.LocationRestriction.newBuilder().build())
              .addAllIncludedPrimaryTypes(new ArrayList<String>())
              .addAllIncludedRegionCodes(new ArrayList<String>())
              .setLanguageCode("languageCode-2092349083")
              .setRegionCode("regionCode-1991004415")
              .setOrigin(LatLng.newBuilder().build())
              .setInputOffset(1010406056)
              .setIncludeQueryPredictions(true)
              .setSessionToken("sessionToken-696552189")
              .setIncludePureServiceAreaBusinesses(true)
              .build();
      client.autocompletePlaces(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
