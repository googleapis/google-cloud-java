/*
 * Copyright 2023 Google LLC
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
import com.google.protobuf.AbstractMessage;
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
  public void searchTextTest() throws Exception {
    SearchTextResponse expectedResponse =
        SearchTextResponse.newBuilder().addAllPlaces(new ArrayList<Place>()).build();
    mockPlaces.addResponse(expectedResponse);

    SearchTextRequest request =
        SearchTextRequest.newBuilder()
            .setTextQuery("textQuery-1050470501")
            .setLanguageCode("languageCode-2092349083")
            .setRegionCode("regionCode-1991004415")
            .setLocation(SearchTextRequest.Location.newBuilder().build())
            .setIncludedType("includedType-45971946")
            .setOpenNow(true)
            .setPriceRange(Int32Range.newBuilder().build())
            .setMinRating(-543315926)
            .setMaxResultCount(-1736124056)
            .addAllPriceLevels(new ArrayList<PriceLevel>())
            .setStrictTypeFiltering(true)
            .setLocationBias(SearchTextRequest.LocationBias.newBuilder().build())
            .setLocationRestriction(SearchTextRequest.LocationRestriction.newBuilder().build())
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
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertEquals(request.getIncludedType(), actualRequest.getIncludedType());
    Assert.assertEquals(request.getOpenNow(), actualRequest.getOpenNow());
    Assert.assertEquals(request.getPriceRange(), actualRequest.getPriceRange());
    Assert.assertEquals(request.getMinRating(), actualRequest.getMinRating(), 0.0001);
    Assert.assertEquals(request.getMaxResultCount(), actualRequest.getMaxResultCount());
    Assert.assertEquals(request.getPriceLevelsList(), actualRequest.getPriceLevelsList());
    Assert.assertEquals(request.getStrictTypeFiltering(), actualRequest.getStrictTypeFiltering());
    Assert.assertEquals(request.getLocationBias(), actualRequest.getLocationBias());
    Assert.assertEquals(request.getLocationRestriction(), actualRequest.getLocationRestriction());
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
              .setLocation(SearchTextRequest.Location.newBuilder().build())
              .setIncludedType("includedType-45971946")
              .setOpenNow(true)
              .setPriceRange(Int32Range.newBuilder().build())
              .setMinRating(-543315926)
              .setMaxResultCount(-1736124056)
              .addAllPriceLevels(new ArrayList<PriceLevel>())
              .setStrictTypeFiltering(true)
              .setLocationBias(SearchTextRequest.LocationBias.newBuilder().build())
              .setLocationRestriction(SearchTextRequest.LocationRestriction.newBuilder().build())
              .build();
      client.searchText(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
