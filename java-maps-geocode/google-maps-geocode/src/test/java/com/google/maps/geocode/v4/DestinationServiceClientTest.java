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
public class DestinationServiceClientTest {
  private static MockDestinationService mockDestinationService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DestinationServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDestinationService = new MockDestinationService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDestinationService));
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
    DestinationServiceSettings settings =
        DestinationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DestinationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void searchDestinationsTest() throws Exception {
    SearchDestinationsResponse expectedResponse =
        SearchDestinationsResponse.newBuilder()
            .addAllDestinations(new ArrayList<Destination>())
            .build();
    mockDestinationService.addResponse(expectedResponse);

    SearchDestinationsRequest request =
        SearchDestinationsRequest.newBuilder()
            .addAllTravelModes(new ArrayList<NavigationPoint.TravelMode>())
            .setLanguageCode("languageCode-2092349083")
            .setRegionCode("regionCode-1991004415")
            .build();

    SearchDestinationsResponse actualResponse = client.searchDestinations(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDestinationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchDestinationsRequest actualRequest = ((SearchDestinationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPlace(), actualRequest.getPlace());
    Assert.assertEquals(request.getAddressQuery(), actualRequest.getAddressQuery());
    Assert.assertEquals(request.getLocationQuery(), actualRequest.getLocationQuery());
    Assert.assertEquals(request.getTravelModesList(), actualRequest.getTravelModesList());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertEquals(request.getRegionCode(), actualRequest.getRegionCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchDestinationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDestinationService.addException(exception);

    try {
      SearchDestinationsRequest request =
          SearchDestinationsRequest.newBuilder()
              .addAllTravelModes(new ArrayList<NavigationPoint.TravelMode>())
              .setLanguageCode("languageCode-2092349083")
              .setRegionCode("regionCode-1991004415")
              .build();
      client.searchDestinations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
