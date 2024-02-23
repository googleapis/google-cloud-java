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

package com.google.apps.meet.v2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class SpacesServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockSpacesService mockSpacesService;
  private LocalChannelProvider channelProvider;
  private SpacesServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSpacesService = new MockSpacesService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSpacesService));
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
    SpacesServiceSettings settings =
        SpacesServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SpacesServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setMeetingUri("meetingUri802788657")
            .setMeetingCode("meetingCode-883894584")
            .setConfig(SpaceConfig.newBuilder().build())
            .setActiveConference(ActiveConference.newBuilder().build())
            .build();
    mockSpacesService.addResponse(expectedResponse);

    Space space = Space.newBuilder().build();

    Space actualResponse = client.createSpace(space);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSpaceRequest actualRequest = ((CreateSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(space, actualRequest.getSpace());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSpaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      Space space = Space.newBuilder().build();
      client.createSpace(space);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setMeetingUri("meetingUri802788657")
            .setMeetingCode("meetingCode-883894584")
            .setConfig(SpaceConfig.newBuilder().build())
            .setActiveConference(ActiveConference.newBuilder().build())
            .build();
    mockSpacesService.addResponse(expectedResponse);

    SpaceName name = SpaceName.of("[SPACE]");

    Space actualResponse = client.getSpace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpaceRequest actualRequest = ((GetSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      SpaceName name = SpaceName.of("[SPACE]");
      client.getSpace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpaceTest2() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setMeetingUri("meetingUri802788657")
            .setMeetingCode("meetingCode-883894584")
            .setConfig(SpaceConfig.newBuilder().build())
            .setActiveConference(ActiveConference.newBuilder().build())
            .build();
    mockSpacesService.addResponse(expectedResponse);

    String name = "name3373707";

    Space actualResponse = client.getSpace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpaceRequest actualRequest = ((GetSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpaceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      String name = "name3373707";
      client.getSpace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setMeetingUri("meetingUri802788657")
            .setMeetingCode("meetingCode-883894584")
            .setConfig(SpaceConfig.newBuilder().build())
            .setActiveConference(ActiveConference.newBuilder().build())
            .build();
    mockSpacesService.addResponse(expectedResponse);

    Space space = Space.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Space actualResponse = client.updateSpace(space, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSpaceRequest actualRequest = ((UpdateSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(space, actualRequest.getSpace());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSpaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      Space space = Space.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSpace(space, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void endActiveConferenceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSpacesService.addResponse(expectedResponse);

    SpaceName name = SpaceName.of("[SPACE]");

    client.endActiveConference(name);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EndActiveConferenceRequest actualRequest = ((EndActiveConferenceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void endActiveConferenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      SpaceName name = SpaceName.of("[SPACE]");
      client.endActiveConference(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void endActiveConferenceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSpacesService.addResponse(expectedResponse);

    String name = "name3373707";

    client.endActiveConference(name);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EndActiveConferenceRequest actualRequest = ((EndActiveConferenceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void endActiveConferenceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      String name = "name3373707";
      client.endActiveConference(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
