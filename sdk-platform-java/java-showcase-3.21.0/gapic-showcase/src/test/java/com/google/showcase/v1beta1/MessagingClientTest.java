/*
 * Copyright 2025 Google LLC
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

package com.google.showcase.v1beta1;

import static com.google.showcase.v1beta1.MessagingClient.ListBlurbsPagedResponse;
import static com.google.showcase.v1beta1.MessagingClient.ListLocationsPagedResponse;
import static com.google.showcase.v1beta1.MessagingClient.ListRoomsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class MessagingClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockMessaging mockMessaging;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MessagingClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMessaging = new MockMessaging();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockMessaging, mockLocations, mockIAMPolicy));
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
    MessagingSettings settings =
        MessagingSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MessagingClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createRoomTest() throws Exception {
    Room expectedResponse =
        Room.newBuilder()
            .setName(RoomName.of("[ROOM]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    String displayName = "displayName1714148973";
    String description = "description-1724546052";

    Room actualResponse = client.createRoom(displayName, description);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRoomRequest actualRequest = ((CreateRoomRequest) actualRequests.get(0));

    Assert.assertEquals(displayName, actualRequest.getRoom().getDisplayName());
    Assert.assertEquals(description, actualRequest.getRoom().getDescription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRoomExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      String displayName = "displayName1714148973";
      String description = "description-1724546052";
      client.createRoom(displayName, description);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRoomTest() throws Exception {
    Room expectedResponse =
        Room.newBuilder()
            .setName(RoomName.of("[ROOM]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    RoomName name = RoomName.of("[ROOM]");

    Room actualResponse = client.getRoom(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRoomRequest actualRequest = ((GetRoomRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRoomExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      RoomName name = RoomName.of("[ROOM]");
      client.getRoom(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRoomTest2() throws Exception {
    Room expectedResponse =
        Room.newBuilder()
            .setName(RoomName.of("[ROOM]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    String name = "name3373707";

    Room actualResponse = client.getRoom(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRoomRequest actualRequest = ((GetRoomRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRoomExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      String name = "name3373707";
      client.getRoom(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRoomTest() throws Exception {
    Room expectedResponse =
        Room.newBuilder()
            .setName(RoomName.of("[ROOM]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    UpdateRoomRequest request =
        UpdateRoomRequest.newBuilder()
            .setRoom(Room.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Room actualResponse = client.updateRoom(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRoomRequest actualRequest = ((UpdateRoomRequest) actualRequests.get(0));

    Assert.assertEquals(request.getRoom(), actualRequest.getRoom());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRoomExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      UpdateRoomRequest request =
          UpdateRoomRequest.newBuilder()
              .setRoom(Room.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateRoom(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRoomTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMessaging.addResponse(expectedResponse);

    RoomName name = RoomName.of("[ROOM]");

    client.deleteRoom(name);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRoomRequest actualRequest = ((DeleteRoomRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRoomExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      RoomName name = RoomName.of("[ROOM]");
      client.deleteRoom(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRoomTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMessaging.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteRoom(name);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRoomRequest actualRequest = ((DeleteRoomRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRoomExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRoom(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRoomsTest() throws Exception {
    Room responsesElement = Room.newBuilder().build();
    ListRoomsResponse expectedResponse =
        ListRoomsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRooms(Arrays.asList(responsesElement))
            .build();
    mockMessaging.addResponse(expectedResponse);

    ListRoomsRequest request =
        ListRoomsRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListRoomsPagedResponse pagedListResponse = client.listRooms(request);

    List<Room> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRoomsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRoomsRequest actualRequest = ((ListRoomsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRoomsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      ListRoomsRequest request =
          ListRoomsRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listRooms(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBlurbTest() throws Exception {
    Blurb expectedResponse =
        Blurb.newBuilder()
            .setName(
                BlurbName.ofUserLegacyUserBlurbName("[USER]", "[LEGACY_USER]", "[BLURB]")
                    .toString())
            .setUser(UserName.of("[USER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    ProfileName parent = ProfileName.of("[USER]");
    UserName user = UserName.of("[USER]");
    ByteString image = ByteString.EMPTY;

    Blurb actualResponse = client.createBlurb(parent, user, image);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBlurbRequest actualRequest = ((CreateBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(user.toString(), actualRequest.getBlurb().getUser());
    Assert.assertEquals(image, actualRequest.getBlurb().getImage());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBlurbExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      ProfileName parent = ProfileName.of("[USER]");
      UserName user = UserName.of("[USER]");
      ByteString image = ByteString.EMPTY;
      client.createBlurb(parent, user, image);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBlurbTest2() throws Exception {
    Blurb expectedResponse =
        Blurb.newBuilder()
            .setName(
                BlurbName.ofUserLegacyUserBlurbName("[USER]", "[LEGACY_USER]", "[BLURB]")
                    .toString())
            .setUser(UserName.of("[USER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    ProfileName parent = ProfileName.of("[USER]");
    UserName user = UserName.of("[USER]");
    String text = "text3556653";

    Blurb actualResponse = client.createBlurb(parent, user, text);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBlurbRequest actualRequest = ((CreateBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(user.toString(), actualRequest.getBlurb().getUser());
    Assert.assertEquals(text, actualRequest.getBlurb().getText());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBlurbExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      ProfileName parent = ProfileName.of("[USER]");
      UserName user = UserName.of("[USER]");
      String text = "text3556653";
      client.createBlurb(parent, user, text);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBlurbTest3() throws Exception {
    Blurb expectedResponse =
        Blurb.newBuilder()
            .setName(
                BlurbName.ofUserLegacyUserBlurbName("[USER]", "[LEGACY_USER]", "[BLURB]")
                    .toString())
            .setUser(UserName.of("[USER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    ProfileName parent = ProfileName.of("[USER]");
    String user = "user3599307";
    ByteString image = ByteString.EMPTY;

    Blurb actualResponse = client.createBlurb(parent, user, image);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBlurbRequest actualRequest = ((CreateBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(user, actualRequest.getBlurb().getUser());
    Assert.assertEquals(image, actualRequest.getBlurb().getImage());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBlurbExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      ProfileName parent = ProfileName.of("[USER]");
      String user = "user3599307";
      ByteString image = ByteString.EMPTY;
      client.createBlurb(parent, user, image);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBlurbTest4() throws Exception {
    Blurb expectedResponse =
        Blurb.newBuilder()
            .setName(
                BlurbName.ofUserLegacyUserBlurbName("[USER]", "[LEGACY_USER]", "[BLURB]")
                    .toString())
            .setUser(UserName.of("[USER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    ProfileName parent = ProfileName.of("[USER]");
    String user = "user3599307";
    String text = "text3556653";

    Blurb actualResponse = client.createBlurb(parent, user, text);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBlurbRequest actualRequest = ((CreateBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(user, actualRequest.getBlurb().getUser());
    Assert.assertEquals(text, actualRequest.getBlurb().getText());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBlurbExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      ProfileName parent = ProfileName.of("[USER]");
      String user = "user3599307";
      String text = "text3556653";
      client.createBlurb(parent, user, text);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBlurbTest5() throws Exception {
    Blurb expectedResponse =
        Blurb.newBuilder()
            .setName(
                BlurbName.ofUserLegacyUserBlurbName("[USER]", "[LEGACY_USER]", "[BLURB]")
                    .toString())
            .setUser(UserName.of("[USER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    RoomName parent = RoomName.of("[ROOM]");
    UserName user = UserName.of("[USER]");
    ByteString image = ByteString.EMPTY;

    Blurb actualResponse = client.createBlurb(parent, user, image);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBlurbRequest actualRequest = ((CreateBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(user.toString(), actualRequest.getBlurb().getUser());
    Assert.assertEquals(image, actualRequest.getBlurb().getImage());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBlurbExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      RoomName parent = RoomName.of("[ROOM]");
      UserName user = UserName.of("[USER]");
      ByteString image = ByteString.EMPTY;
      client.createBlurb(parent, user, image);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBlurbTest6() throws Exception {
    Blurb expectedResponse =
        Blurb.newBuilder()
            .setName(
                BlurbName.ofUserLegacyUserBlurbName("[USER]", "[LEGACY_USER]", "[BLURB]")
                    .toString())
            .setUser(UserName.of("[USER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    RoomName parent = RoomName.of("[ROOM]");
    UserName user = UserName.of("[USER]");
    String text = "text3556653";

    Blurb actualResponse = client.createBlurb(parent, user, text);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBlurbRequest actualRequest = ((CreateBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(user.toString(), actualRequest.getBlurb().getUser());
    Assert.assertEquals(text, actualRequest.getBlurb().getText());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBlurbExceptionTest6() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      RoomName parent = RoomName.of("[ROOM]");
      UserName user = UserName.of("[USER]");
      String text = "text3556653";
      client.createBlurb(parent, user, text);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBlurbTest7() throws Exception {
    Blurb expectedResponse =
        Blurb.newBuilder()
            .setName(
                BlurbName.ofUserLegacyUserBlurbName("[USER]", "[LEGACY_USER]", "[BLURB]")
                    .toString())
            .setUser(UserName.of("[USER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    RoomName parent = RoomName.of("[ROOM]");
    String user = "user3599307";
    ByteString image = ByteString.EMPTY;

    Blurb actualResponse = client.createBlurb(parent, user, image);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBlurbRequest actualRequest = ((CreateBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(user, actualRequest.getBlurb().getUser());
    Assert.assertEquals(image, actualRequest.getBlurb().getImage());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBlurbExceptionTest7() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      RoomName parent = RoomName.of("[ROOM]");
      String user = "user3599307";
      ByteString image = ByteString.EMPTY;
      client.createBlurb(parent, user, image);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBlurbTest8() throws Exception {
    Blurb expectedResponse =
        Blurb.newBuilder()
            .setName(
                BlurbName.ofUserLegacyUserBlurbName("[USER]", "[LEGACY_USER]", "[BLURB]")
                    .toString())
            .setUser(UserName.of("[USER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    RoomName parent = RoomName.of("[ROOM]");
    String user = "user3599307";
    String text = "text3556653";

    Blurb actualResponse = client.createBlurb(parent, user, text);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBlurbRequest actualRequest = ((CreateBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(user, actualRequest.getBlurb().getUser());
    Assert.assertEquals(text, actualRequest.getBlurb().getText());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBlurbExceptionTest8() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      RoomName parent = RoomName.of("[ROOM]");
      String user = "user3599307";
      String text = "text3556653";
      client.createBlurb(parent, user, text);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBlurbTest9() throws Exception {
    Blurb expectedResponse =
        Blurb.newBuilder()
            .setName(
                BlurbName.ofUserLegacyUserBlurbName("[USER]", "[LEGACY_USER]", "[BLURB]")
                    .toString())
            .setUser(UserName.of("[USER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    String parent = "parent-995424086";
    UserName user = UserName.of("[USER]");
    ByteString image = ByteString.EMPTY;

    Blurb actualResponse = client.createBlurb(parent, user, image);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBlurbRequest actualRequest = ((CreateBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(user.toString(), actualRequest.getBlurb().getUser());
    Assert.assertEquals(image, actualRequest.getBlurb().getImage());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBlurbExceptionTest9() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      String parent = "parent-995424086";
      UserName user = UserName.of("[USER]");
      ByteString image = ByteString.EMPTY;
      client.createBlurb(parent, user, image);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBlurbTest10() throws Exception {
    Blurb expectedResponse =
        Blurb.newBuilder()
            .setName(
                BlurbName.ofUserLegacyUserBlurbName("[USER]", "[LEGACY_USER]", "[BLURB]")
                    .toString())
            .setUser(UserName.of("[USER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    String parent = "parent-995424086";
    UserName user = UserName.of("[USER]");
    String text = "text3556653";

    Blurb actualResponse = client.createBlurb(parent, user, text);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBlurbRequest actualRequest = ((CreateBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(user.toString(), actualRequest.getBlurb().getUser());
    Assert.assertEquals(text, actualRequest.getBlurb().getText());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBlurbExceptionTest10() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      String parent = "parent-995424086";
      UserName user = UserName.of("[USER]");
      String text = "text3556653";
      client.createBlurb(parent, user, text);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBlurbTest11() throws Exception {
    Blurb expectedResponse =
        Blurb.newBuilder()
            .setName(
                BlurbName.ofUserLegacyUserBlurbName("[USER]", "[LEGACY_USER]", "[BLURB]")
                    .toString())
            .setUser(UserName.of("[USER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String user = "user3599307";
    ByteString image = ByteString.EMPTY;

    Blurb actualResponse = client.createBlurb(parent, user, image);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBlurbRequest actualRequest = ((CreateBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(user, actualRequest.getBlurb().getUser());
    Assert.assertEquals(image, actualRequest.getBlurb().getImage());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBlurbExceptionTest11() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      String parent = "parent-995424086";
      String user = "user3599307";
      ByteString image = ByteString.EMPTY;
      client.createBlurb(parent, user, image);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBlurbTest12() throws Exception {
    Blurb expectedResponse =
        Blurb.newBuilder()
            .setName(
                BlurbName.ofUserLegacyUserBlurbName("[USER]", "[LEGACY_USER]", "[BLURB]")
                    .toString())
            .setUser(UserName.of("[USER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String user = "user3599307";
    String text = "text3556653";

    Blurb actualResponse = client.createBlurb(parent, user, text);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBlurbRequest actualRequest = ((CreateBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(user, actualRequest.getBlurb().getUser());
    Assert.assertEquals(text, actualRequest.getBlurb().getText());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBlurbExceptionTest12() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      String parent = "parent-995424086";
      String user = "user3599307";
      String text = "text3556653";
      client.createBlurb(parent, user, text);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBlurbTest() throws Exception {
    Blurb expectedResponse =
        Blurb.newBuilder()
            .setName(BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]").toString())
            .setUser(UserName.of("[USER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    BlurbName name = BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]");

    Blurb actualResponse = client.getBlurb(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBlurbRequest actualRequest = ((GetBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBlurbExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      BlurbName name = BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]");
      client.getBlurb(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBlurbTest2() throws Exception {
    Blurb expectedResponse =
        Blurb.newBuilder()
            .setName(BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]").toString())
            .setUser(UserName.of("[USER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    String name = "name3373707";

    Blurb actualResponse = client.getBlurb(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBlurbRequest actualRequest = ((GetBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBlurbExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      String name = "name3373707";
      client.getBlurb(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBlurbTest() throws Exception {
    Blurb expectedResponse =
        Blurb.newBuilder()
            .setName(BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]").toString())
            .setUser(UserName.of("[USER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMessaging.addResponse(expectedResponse);

    UpdateBlurbRequest request =
        UpdateBlurbRequest.newBuilder()
            .setBlurb(Blurb.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Blurb actualResponse = client.updateBlurb(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBlurbRequest actualRequest = ((UpdateBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(request.getBlurb(), actualRequest.getBlurb());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBlurbExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      UpdateBlurbRequest request =
          UpdateBlurbRequest.newBuilder()
              .setBlurb(Blurb.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateBlurb(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBlurbTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMessaging.addResponse(expectedResponse);

    BlurbName name = BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]");

    client.deleteBlurb(name);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBlurbRequest actualRequest = ((DeleteBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBlurbExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      BlurbName name = BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]");
      client.deleteBlurb(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBlurbTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMessaging.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteBlurb(name);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBlurbRequest actualRequest = ((DeleteBlurbRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBlurbExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBlurb(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBlurbsTest() throws Exception {
    Blurb responsesElement = Blurb.newBuilder().build();
    ListBlurbsResponse expectedResponse =
        ListBlurbsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBlurbs(Arrays.asList(responsesElement))
            .build();
    mockMessaging.addResponse(expectedResponse);

    ProfileName parent = ProfileName.of("[USER]");

    ListBlurbsPagedResponse pagedListResponse = client.listBlurbs(parent);

    List<Blurb> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBlurbsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBlurbsRequest actualRequest = ((ListBlurbsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBlurbsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      ProfileName parent = ProfileName.of("[USER]");
      client.listBlurbs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBlurbsTest2() throws Exception {
    Blurb responsesElement = Blurb.newBuilder().build();
    ListBlurbsResponse expectedResponse =
        ListBlurbsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBlurbs(Arrays.asList(responsesElement))
            .build();
    mockMessaging.addResponse(expectedResponse);

    RoomName parent = RoomName.of("[ROOM]");

    ListBlurbsPagedResponse pagedListResponse = client.listBlurbs(parent);

    List<Blurb> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBlurbsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBlurbsRequest actualRequest = ((ListBlurbsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBlurbsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      RoomName parent = RoomName.of("[ROOM]");
      client.listBlurbs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBlurbsTest3() throws Exception {
    Blurb responsesElement = Blurb.newBuilder().build();
    ListBlurbsResponse expectedResponse =
        ListBlurbsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBlurbs(Arrays.asList(responsesElement))
            .build();
    mockMessaging.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBlurbsPagedResponse pagedListResponse = client.listBlurbs(parent);

    List<Blurb> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBlurbsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBlurbsRequest actualRequest = ((ListBlurbsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBlurbsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBlurbs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchBlurbsTest() throws Exception {
    SearchBlurbsResponse expectedResponse =
        SearchBlurbsResponse.newBuilder()
            .addAllBlurbs(new ArrayList<Blurb>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("searchBlurbsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMessaging.addResponse(resultOperation);

    ProfileName parent = ProfileName.of("[USER]");
    String query = "query107944136";

    SearchBlurbsResponse actualResponse = client.searchBlurbsAsync(parent, query).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchBlurbsRequest actualRequest = ((SearchBlurbsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchBlurbsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      ProfileName parent = ProfileName.of("[USER]");
      String query = "query107944136";
      client.searchBlurbsAsync(parent, query).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void searchBlurbsTest2() throws Exception {
    SearchBlurbsResponse expectedResponse =
        SearchBlurbsResponse.newBuilder()
            .addAllBlurbs(new ArrayList<Blurb>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("searchBlurbsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMessaging.addResponse(resultOperation);

    RoomName parent = RoomName.of("[ROOM]");
    String query = "query107944136";

    SearchBlurbsResponse actualResponse = client.searchBlurbsAsync(parent, query).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchBlurbsRequest actualRequest = ((SearchBlurbsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchBlurbsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      RoomName parent = RoomName.of("[ROOM]");
      String query = "query107944136";
      client.searchBlurbsAsync(parent, query).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void searchBlurbsTest3() throws Exception {
    SearchBlurbsResponse expectedResponse =
        SearchBlurbsResponse.newBuilder()
            .addAllBlurbs(new ArrayList<Blurb>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("searchBlurbsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMessaging.addResponse(resultOperation);

    String parent = "parent-995424086";
    String query = "query107944136";

    SearchBlurbsResponse actualResponse = client.searchBlurbsAsync(parent, query).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMessaging.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchBlurbsRequest actualRequest = ((SearchBlurbsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchBlurbsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);

    try {
      String parent = "parent-995424086";
      String query = "query107944136";
      client.searchBlurbsAsync(parent, query).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void streamBlurbsTest() throws Exception {
    StreamBlurbsResponse expectedResponse =
        StreamBlurbsResponse.newBuilder().setBlurb(Blurb.newBuilder().build()).build();
    mockMessaging.addResponse(expectedResponse);
    StreamBlurbsRequest request =
        StreamBlurbsRequest.newBuilder()
            .setName(ProfileName.of("[USER]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();

    MockStreamObserver<StreamBlurbsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<StreamBlurbsRequest, StreamBlurbsResponse> callable =
        client.streamBlurbsCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<StreamBlurbsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamBlurbsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);
    StreamBlurbsRequest request =
        StreamBlurbsRequest.newBuilder()
            .setName(ProfileName.of("[USER]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();

    MockStreamObserver<StreamBlurbsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<StreamBlurbsRequest, StreamBlurbsResponse> callable =
        client.streamBlurbsCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<StreamBlurbsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void sendBlurbsTest() throws Exception {
    SendBlurbsResponse expectedResponse =
        SendBlurbsResponse.newBuilder().addAllNames(new ArrayList<String>()).build();
    mockMessaging.addResponse(expectedResponse);
    CreateBlurbRequest request =
        CreateBlurbRequest.newBuilder()
            .setParent(ProfileName.of("[USER]").toString())
            .setBlurb(Blurb.newBuilder().build())
            .build();

    MockStreamObserver<SendBlurbsResponse> responseObserver = new MockStreamObserver<>();

    ClientStreamingCallable<CreateBlurbRequest, SendBlurbsResponse> callable =
        client.sendBlurbsCallable();
    ApiStreamObserver<CreateBlurbRequest> requestObserver =
        callable.clientStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<SendBlurbsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void sendBlurbsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);
    CreateBlurbRequest request =
        CreateBlurbRequest.newBuilder()
            .setParent(ProfileName.of("[USER]").toString())
            .setBlurb(Blurb.newBuilder().build())
            .build();

    MockStreamObserver<SendBlurbsResponse> responseObserver = new MockStreamObserver<>();

    ClientStreamingCallable<CreateBlurbRequest, SendBlurbsResponse> callable =
        client.sendBlurbsCallable();
    ApiStreamObserver<CreateBlurbRequest> requestObserver =
        callable.clientStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<SendBlurbsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void connectTest() throws Exception {
    StreamBlurbsResponse expectedResponse =
        StreamBlurbsResponse.newBuilder().setBlurb(Blurb.newBuilder().build()).build();
    mockMessaging.addResponse(expectedResponse);
    ConnectRequest request = ConnectRequest.newBuilder().build();

    MockStreamObserver<StreamBlurbsResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<ConnectRequest, StreamBlurbsResponse> callable = client.connectCallable();
    ApiStreamObserver<ConnectRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<StreamBlurbsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void connectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessaging.addException(exception);
    ConnectRequest request = ConnectRequest.newBuilder().build();

    MockStreamObserver<StreamBlurbsResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<ConnectRequest, StreamBlurbsResponse> callable = client.connectCallable();
    ApiStreamObserver<ConnectRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<StreamBlurbsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]").toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
