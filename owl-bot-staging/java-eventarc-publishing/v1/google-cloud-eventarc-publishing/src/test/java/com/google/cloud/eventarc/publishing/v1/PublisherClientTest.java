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

package com.google.cloud.eventarc.publishing.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
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
public class PublisherClientTest {
  private static MockPublisher mockPublisher;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PublisherClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPublisher = new MockPublisher();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockPublisher));
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
    PublisherSettings settings =
        PublisherSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PublisherClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void publishChannelConnectionEventsTest() throws Exception {
    PublishChannelConnectionEventsResponse expectedResponse =
        PublishChannelConnectionEventsResponse.newBuilder().build();
    mockPublisher.addResponse(expectedResponse);

    PublishChannelConnectionEventsRequest request =
        PublishChannelConnectionEventsRequest.newBuilder()
            .setChannelConnection("channelConnection-1932021695")
            .addAllEvents(new ArrayList<Any>())
            .addAllTextEvents(new ArrayList<String>())
            .build();

    PublishChannelConnectionEventsResponse actualResponse =
        client.publishChannelConnectionEvents(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PublishChannelConnectionEventsRequest actualRequest =
        ((PublishChannelConnectionEventsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getChannelConnection(), actualRequest.getChannelConnection());
    Assert.assertEquals(request.getEventsList(), actualRequest.getEventsList());
    Assert.assertEquals(request.getTextEventsList(), actualRequest.getTextEventsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void publishChannelConnectionEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      PublishChannelConnectionEventsRequest request =
          PublishChannelConnectionEventsRequest.newBuilder()
              .setChannelConnection("channelConnection-1932021695")
              .addAllEvents(new ArrayList<Any>())
              .addAllTextEvents(new ArrayList<String>())
              .build();
      client.publishChannelConnectionEvents(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void publishEventsTest() throws Exception {
    PublishEventsResponse expectedResponse = PublishEventsResponse.newBuilder().build();
    mockPublisher.addResponse(expectedResponse);

    PublishEventsRequest request =
        PublishEventsRequest.newBuilder()
            .setChannel("channel738950403")
            .addAllEvents(new ArrayList<Any>())
            .addAllTextEvents(new ArrayList<String>())
            .build();

    PublishEventsResponse actualResponse = client.publishEvents(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PublishEventsRequest actualRequest = ((PublishEventsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getChannel(), actualRequest.getChannel());
    Assert.assertEquals(request.getEventsList(), actualRequest.getEventsList());
    Assert.assertEquals(request.getTextEventsList(), actualRequest.getTextEventsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void publishEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      PublishEventsRequest request =
          PublishEventsRequest.newBuilder()
              .setChannel("channel738950403")
              .addAllEvents(new ArrayList<Any>())
              .addAllTextEvents(new ArrayList<String>())
              .build();
      client.publishEvents(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
