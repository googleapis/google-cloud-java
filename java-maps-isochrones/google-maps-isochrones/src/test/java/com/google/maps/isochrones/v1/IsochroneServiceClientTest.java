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

package com.google.maps.isochrones.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
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
public class IsochroneServiceClientTest {
  private static MockIsochroneService mockIsochroneService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private IsochroneServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockIsochroneService = new MockIsochroneService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockIsochroneService));
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
    IsochroneServiceSettings settings =
        IsochroneServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IsochroneServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void generateIsochroneTest() throws Exception {
    GenerateIsochroneResponse expectedResponse =
        GenerateIsochroneResponse.newBuilder().setIsochrone(Isochrone.newBuilder().build()).build();
    mockIsochroneService.addResponse(expectedResponse);

    GenerateIsochroneRequest request =
        GenerateIsochroneRequest.newBuilder()
            .setTravelDuration(Duration.newBuilder().build())
            .setEnableSmoothing(true)
            .build();

    GenerateIsochroneResponse actualResponse = client.generateIsochrone(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIsochroneService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateIsochroneRequest actualRequest = ((GenerateIsochroneRequest) actualRequests.get(0));

    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertEquals(request.getPlace(), actualRequest.getPlace());
    Assert.assertEquals(request.getTravelDuration(), actualRequest.getTravelDuration());
    Assert.assertEquals(request.getTravelMode(), actualRequest.getTravelMode());
    Assert.assertEquals(request.getTravelDirection(), actualRequest.getTravelDirection());
    Assert.assertEquals(request.getRoutingPreference(), actualRequest.getRoutingPreference());
    Assert.assertEquals(request.getEnableSmoothing(), actualRequest.getEnableSmoothing());
    Assert.assertEquals(request.getPolygonFidelity(), actualRequest.getPolygonFidelity());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateIsochroneExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIsochroneService.addException(exception);

    try {
      GenerateIsochroneRequest request =
          GenerateIsochroneRequest.newBuilder()
              .setTravelDuration(Duration.newBuilder().build())
              .setEnableSmoothing(true)
              .build();
      client.generateIsochrone(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
