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

package com.google.maps.navconnect.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class NavConnectServiceClientTest {
  private static MockNavConnectService mockNavConnectService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private NavConnectServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockNavConnectService = new MockNavConnectService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockNavConnectService));
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
    NavConnectServiceSettings settings =
        NavConnectServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = NavConnectServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createTripTest() throws Exception {
    Trip expectedResponse =
        Trip.newBuilder()
            .setName(TripName.of("[PROJECT]", "[TRIP]").toString())
            .setConfig(TripConfig.newBuilder().build())
            .setAndroidAppId("androidAppId-1019476499")
            .setIosAppId("iosAppId1395980047")
            .setAuthToken(AuthToken.newBuilder().build())
            .setExecution(TripExecution.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockNavConnectService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Trip trip = Trip.newBuilder().build();
    String tripId = "tripId-865466336";

    Trip actualResponse = client.createTrip(parent, trip, tripId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNavConnectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTripRequest actualRequest = ((CreateTripRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(trip, actualRequest.getTrip());
    Assert.assertEquals(tripId, actualRequest.getTripId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTripExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNavConnectService.addException(exception);

    try {
      String parent = "parent-995424086";
      Trip trip = Trip.newBuilder().build();
      String tripId = "tripId-865466336";
      client.createTrip(parent, trip, tripId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTripTest() throws Exception {
    Trip expectedResponse =
        Trip.newBuilder()
            .setName(TripName.of("[PROJECT]", "[TRIP]").toString())
            .setConfig(TripConfig.newBuilder().build())
            .setAndroidAppId("androidAppId-1019476499")
            .setIosAppId("iosAppId1395980047")
            .setAuthToken(AuthToken.newBuilder().build())
            .setExecution(TripExecution.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockNavConnectService.addResponse(expectedResponse);

    TripName name = TripName.of("[PROJECT]", "[TRIP]");

    Trip actualResponse = client.getTrip(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNavConnectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTripRequest actualRequest = ((GetTripRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTripExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNavConnectService.addException(exception);

    try {
      TripName name = TripName.of("[PROJECT]", "[TRIP]");
      client.getTrip(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTripTest2() throws Exception {
    Trip expectedResponse =
        Trip.newBuilder()
            .setName(TripName.of("[PROJECT]", "[TRIP]").toString())
            .setConfig(TripConfig.newBuilder().build())
            .setAndroidAppId("androidAppId-1019476499")
            .setIosAppId("iosAppId1395980047")
            .setAuthToken(AuthToken.newBuilder().build())
            .setExecution(TripExecution.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockNavConnectService.addResponse(expectedResponse);

    String name = "name3373707";

    Trip actualResponse = client.getTrip(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNavConnectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTripRequest actualRequest = ((GetTripRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTripExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNavConnectService.addException(exception);

    try {
      String name = "name3373707";
      client.getTrip(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
