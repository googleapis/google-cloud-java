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
public class GeocodeServiceClientTest {
  private static MockGeocodeService mockGeocodeService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GeocodeServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGeocodeService = new MockGeocodeService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockGeocodeService));
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
    GeocodeServiceSettings settings =
        GeocodeServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GeocodeServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void geocodeAddressTest() throws Exception {
    GeocodeAddressResponse expectedResponse =
        GeocodeAddressResponse.newBuilder().addAllResults(new ArrayList<GeocodeResult>()).build();
    mockGeocodeService.addResponse(expectedResponse);

    GeocodeAddressRequest request =
        GeocodeAddressRequest.newBuilder()
            .setLocationBias(GeocodeAddressRequest.LocationBias.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setRegionCode("regionCode-1991004415")
            .build();

    GeocodeAddressResponse actualResponse = client.geocodeAddress(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGeocodeService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GeocodeAddressRequest actualRequest = ((GeocodeAddressRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAddressQuery(), actualRequest.getAddressQuery());
    Assert.assertEquals(request.getAddress(), actualRequest.getAddress());
    Assert.assertEquals(request.getLocationBias(), actualRequest.getLocationBias());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertEquals(request.getRegionCode(), actualRequest.getRegionCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void geocodeAddressExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGeocodeService.addException(exception);

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
    mockGeocodeService.addResponse(expectedResponse);

    GeocodeLocationRequest request =
        GeocodeLocationRequest.newBuilder()
            .setLanguageCode("languageCode-2092349083")
            .setRegionCode("regionCode-1991004415")
            .addAllTypes(new ArrayList<String>())
            .addAllGranularity(new ArrayList<GeocodeResult.Granularity>())
            .build();

    GeocodeLocationResponse actualResponse = client.geocodeLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGeocodeService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GeocodeLocationRequest actualRequest = ((GeocodeLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getLocationQuery(), actualRequest.getLocationQuery());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertEquals(request.getRegionCode(), actualRequest.getRegionCode());
    Assert.assertEquals(request.getTypesList(), actualRequest.getTypesList());
    Assert.assertEquals(request.getGranularityList(), actualRequest.getGranularityList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void geocodeLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGeocodeService.addException(exception);

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
    mockGeocodeService.addResponse(expectedResponse);

    GeocodePlaceRequest request =
        GeocodePlaceRequest.newBuilder()
            .setPlace("place106748167")
            .setLanguageCode("languageCode-2092349083")
            .setRegionCode("regionCode-1991004415")
            .build();

    GeocodeResult actualResponse = client.geocodePlace(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGeocodeService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GeocodePlaceRequest actualRequest = ((GeocodePlaceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPlace(), actualRequest.getPlace());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertEquals(request.getRegionCode(), actualRequest.getRegionCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void geocodePlaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGeocodeService.addException(exception);

    try {
      GeocodePlaceRequest request =
          GeocodePlaceRequest.newBuilder()
              .setPlace("place106748167")
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
