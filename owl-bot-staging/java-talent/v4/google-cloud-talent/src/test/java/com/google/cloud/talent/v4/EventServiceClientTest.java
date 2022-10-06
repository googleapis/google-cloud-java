/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.talent.v4;

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
public class EventServiceClientTest {
  private static MockEventService mockEventService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EventServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEventService = new MockEventService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockEventService));
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
    EventServiceSettings settings =
        EventServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EventServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createClientEventTest() throws Exception {
    ClientEvent expectedResponse =
        ClientEvent.newBuilder()
            .setRequestId("requestId693933066")
            .setEventId("eventId-1376502443")
            .setCreateTime(Timestamp.newBuilder().build())
            .setEventNotes("eventNotes968522823")
            .build();
    mockEventService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    ClientEvent clientEvent = ClientEvent.newBuilder().build();

    ClientEvent actualResponse = client.createClientEvent(parent, clientEvent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClientEventRequest actualRequest = ((CreateClientEventRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(clientEvent, actualRequest.getClientEvent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createClientEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      ClientEvent clientEvent = ClientEvent.newBuilder().build();
      client.createClientEvent(parent, clientEvent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createClientEventTest2() throws Exception {
    ClientEvent expectedResponse =
        ClientEvent.newBuilder()
            .setRequestId("requestId693933066")
            .setEventId("eventId-1376502443")
            .setCreateTime(Timestamp.newBuilder().build())
            .setEventNotes("eventNotes968522823")
            .build();
    mockEventService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ClientEvent clientEvent = ClientEvent.newBuilder().build();

    ClientEvent actualResponse = client.createClientEvent(parent, clientEvent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEventService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClientEventRequest actualRequest = ((CreateClientEventRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(clientEvent, actualRequest.getClientEvent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createClientEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEventService.addException(exception);

    try {
      String parent = "parent-995424086";
      ClientEvent clientEvent = ClientEvent.newBuilder().build();
      client.createClientEvent(parent, clientEvent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
