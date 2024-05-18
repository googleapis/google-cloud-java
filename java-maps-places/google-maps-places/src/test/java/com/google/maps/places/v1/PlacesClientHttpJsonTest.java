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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.geo.type.Viewport;
import com.google.maps.places.v1.stub.HttpJsonPlacesStub;
import com.google.type.LatLng;
import com.google.type.LocalizedText;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class PlacesClientHttpJsonTest {
  private static MockHttpService mockService;
  private static PlacesClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPlacesStub.getMethodDescriptors(), PlacesSettings.getDefaultEndpoint());
    PlacesSettings settings =
        PlacesSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                PlacesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PlacesClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void searchNearbyTest() throws Exception {
    SearchNearbyResponse expectedResponse =
        SearchNearbyResponse.newBuilder().addAllPlaces(new ArrayList<Place>()).build();
    mockService.addResponse(expectedResponse);

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
            .build();

    SearchNearbyResponse actualResponse = client.searchNearby(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void searchNearbyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .addAllContextualContents(new ArrayList<ContextualContent>())
            .build();
    mockService.addResponse(expectedResponse);

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
            .build();

    SearchTextResponse actualResponse = client.searchText(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void searchTextExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    PhotoMediaName name = PhotoMediaName.of("[PLACE_ID]", "[PHOTO_REFERENCE]");

    PhotoMedia actualResponse = client.getPhotoMedia(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getPhotoMediaExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "places/place-3694/photos/photo-3694/media";

    PhotoMedia actualResponse = client.getPhotoMedia(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getPhotoMediaExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "places/place-3694/photos/photo-3694/media";
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
            .build();
    mockService.addResponse(expectedResponse);

    PlaceName name = PlaceName.of("[PLACE_ID]");

    Place actualResponse = client.getPlace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getPlaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .build();
    mockService.addResponse(expectedResponse);

    String name = "places/place-6606";

    Place actualResponse = client.getPlace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getPlaceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "places/place-6606";
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
    mockService.addResponse(expectedResponse);

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
            .build();

    AutocompletePlacesResponse actualResponse = client.autocompletePlaces(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void autocompletePlacesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
              .build();
      client.autocompletePlaces(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
