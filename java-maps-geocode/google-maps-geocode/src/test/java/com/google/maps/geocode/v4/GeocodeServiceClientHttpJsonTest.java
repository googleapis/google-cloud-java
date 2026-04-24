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
import com.google.maps.geocode.v4.stub.HttpJsonGeocodeServiceStub;
import com.google.type.LatLng;
import com.google.type.LocalizedText;
import com.google.type.PostalAddress;
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
public class GeocodeServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static GeocodeServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonGeocodeServiceStub.getMethodDescriptors(),
            GeocodeServiceSettings.getDefaultEndpoint());
    GeocodeServiceSettings settings =
        GeocodeServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                GeocodeServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GeocodeServiceClient.create(settings);
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
  public void geocodeAddressTest() throws Exception {
    GeocodeAddressResponse expectedResponse =
        GeocodeAddressResponse.newBuilder().addAllResults(new ArrayList<GeocodeResult>()).build();
    mockService.addResponse(expectedResponse);

    GeocodeAddressRequest request =
        GeocodeAddressRequest.newBuilder()
            .setLocationBias(GeocodeAddressRequest.LocationBias.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setRegionCode("regionCode-1991004415")
            .build();

    GeocodeAddressResponse actualResponse = client.geocodeAddress(request);
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
  public void geocodeAddressExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GeocodeAddressRequest request =
          GeocodeAddressRequest.newBuilder()
              .setLocationBias(GeocodeAddressRequest.LocationBias.newBuilder().build())
              .setLanguageCode("languageCode-2092349083")
              .setRegionCode("regionCode-1991004415")
              .build();
      client.geocodeAddress(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void geocodeLocationTest() throws Exception {
    GeocodeLocationResponse expectedResponse =
        GeocodeLocationResponse.newBuilder()
            .addAllResults(new ArrayList<GeocodeResult>())
            .setPlusCode(PlusCode.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GeocodeLocationRequest request =
        GeocodeLocationRequest.newBuilder()
            .setLanguageCode("languageCode-2092349083")
            .setRegionCode("regionCode-1991004415")
            .addAllTypes(new ArrayList<String>())
            .addAllGranularity(new ArrayList<GeocodeResult.Granularity>())
            .build();

    GeocodeLocationResponse actualResponse = client.geocodeLocation(request);
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
  public void geocodeLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GeocodeLocationRequest request =
          GeocodeLocationRequest.newBuilder()
              .setLanguageCode("languageCode-2092349083")
              .setRegionCode("regionCode-1991004415")
              .addAllTypes(new ArrayList<String>())
              .addAllGranularity(new ArrayList<GeocodeResult.Granularity>())
              .build();
      client.geocodeLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void geocodePlaceTest() throws Exception {
    GeocodeResult expectedResponse =
        GeocodeResult.newBuilder()
            .setPlace("place106748167")
            .setPlaceId("placeId-494224254")
            .setLocation(LatLng.newBuilder().build())
            .setViewport(Viewport.newBuilder().build())
            .setBounds(Viewport.newBuilder().build())
            .setFormattedAddress("formattedAddress1036810136")
            .setPostalAddress(PostalAddress.newBuilder().build())
            .addAllAddressComponents(new ArrayList<GeocodeResult.AddressComponent>())
            .addAllPostalCodeLocalities(new ArrayList<LocalizedText>())
            .addAllTypes(new ArrayList<String>())
            .setPlusCode(PlusCode.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GeocodePlaceRequest request =
        GeocodePlaceRequest.newBuilder()
            .setPlace("places/place-4590")
            .setLanguageCode("languageCode-2092349083")
            .setRegionCode("regionCode-1991004415")
            .build();

    GeocodeResult actualResponse = client.geocodePlace(request);
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
  public void geocodePlaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GeocodePlaceRequest request =
          GeocodePlaceRequest.newBuilder()
              .setPlace("places/place-4590")
              .setLanguageCode("languageCode-2092349083")
              .setRegionCode("regionCode-1991004415")
              .build();
      client.geocodePlace(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
