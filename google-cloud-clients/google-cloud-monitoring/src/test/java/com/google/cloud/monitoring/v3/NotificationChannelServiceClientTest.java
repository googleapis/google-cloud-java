/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.NotificationChannelServiceClient.ListNotificationChannelDescriptorsPagedResponse;
import static com.google.cloud.monitoring.v3.NotificationChannelServiceClient.ListNotificationChannelsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.monitoring.v3.CreateNotificationChannelRequest;
import com.google.monitoring.v3.DeleteNotificationChannelRequest;
import com.google.monitoring.v3.GetNotificationChannelDescriptorRequest;
import com.google.monitoring.v3.GetNotificationChannelRequest;
import com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest;
import com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse;
import com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest;
import com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse;
import com.google.monitoring.v3.ListNotificationChannelsRequest;
import com.google.monitoring.v3.ListNotificationChannelsResponse;
import com.google.monitoring.v3.NotificationChannel;
import com.google.monitoring.v3.NotificationChannelDescriptor;
import com.google.monitoring.v3.NotificationChannelDescriptorName;
import com.google.monitoring.v3.NotificationChannelName;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest;
import com.google.monitoring.v3.UpdateNotificationChannelRequest;
import com.google.monitoring.v3.VerifyNotificationChannelRequest;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class NotificationChannelServiceClientTest {
  private static MockAlertPolicyService mockAlertPolicyService;
  private static MockGroupService mockGroupService;
  private static MockMetricService mockMetricService;
  private static MockNotificationChannelService mockNotificationChannelService;
  private static MockUptimeCheckService mockUptimeCheckService;
  private static MockServiceHelper serviceHelper;
  private NotificationChannelServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAlertPolicyService = new MockAlertPolicyService();
    mockGroupService = new MockGroupService();
    mockMetricService = new MockMetricService();
    mockNotificationChannelService = new MockNotificationChannelService();
    mockUptimeCheckService = new MockUptimeCheckService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockAlertPolicyService,
                mockGroupService,
                mockMetricService,
                mockNotificationChannelService,
                mockUptimeCheckService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    NotificationChannelServiceSettings settings =
        NotificationChannelServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = NotificationChannelServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listNotificationChannelDescriptorsTest() {
    String nextPageToken = "";
    NotificationChannelDescriptor channelDescriptorsElement =
        NotificationChannelDescriptor.newBuilder().build();
    List<NotificationChannelDescriptor> channelDescriptors =
        Arrays.asList(channelDescriptorsElement);
    ListNotificationChannelDescriptorsResponse expectedResponse =
        ListNotificationChannelDescriptorsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllChannelDescriptors(channelDescriptors)
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");

    ListNotificationChannelDescriptorsPagedResponse pagedListResponse =
        client.listNotificationChannelDescriptors(name);

    List<NotificationChannelDescriptor> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChannelDescriptorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationChannelDescriptorsRequest actualRequest =
        (ListNotificationChannelDescriptorsRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProjectName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listNotificationChannelDescriptorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");

      client.listNotificationChannelDescriptors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getNotificationChannelDescriptorTest() {
    String name2 = "name2-1052831874";
    String type = "type3575610";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    NotificationChannelDescriptor expectedResponse =
        NotificationChannelDescriptor.newBuilder()
            .setName(name2)
            .setType(type)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    NotificationChannelDescriptorName name =
        NotificationChannelDescriptorName.of("[PROJECT]", "[CHANNEL_DESCRIPTOR]");

    NotificationChannelDescriptor actualResponse = client.getNotificationChannelDescriptor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationChannelDescriptorRequest actualRequest =
        (GetNotificationChannelDescriptorRequest) actualRequests.get(0);

    Assert.assertEquals(name, NotificationChannelDescriptorName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getNotificationChannelDescriptorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      NotificationChannelDescriptorName name =
          NotificationChannelDescriptorName.of("[PROJECT]", "[CHANNEL_DESCRIPTOR]");

      client.getNotificationChannelDescriptor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listNotificationChannelsTest() {
    String nextPageToken = "";
    NotificationChannel notificationChannelsElement = NotificationChannel.newBuilder().build();
    List<NotificationChannel> notificationChannels = Arrays.asList(notificationChannelsElement);
    ListNotificationChannelsResponse expectedResponse =
        ListNotificationChannelsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllNotificationChannels(notificationChannels)
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");

    ListNotificationChannelsPagedResponse pagedListResponse = client.listNotificationChannels(name);

    List<NotificationChannel> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotificationChannelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationChannelsRequest actualRequest =
        (ListNotificationChannelsRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProjectName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listNotificationChannelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");

      client.listNotificationChannels(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getNotificationChannelTest() {
    String type = "type3575610";
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    NotificationChannel expectedResponse =
        NotificationChannel.newBuilder()
            .setType(type)
            .setName(name2)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    NotificationChannelName name =
        NotificationChannelName.of("[PROJECT]", "[NOTIFICATION_CHANNEL]");

    NotificationChannel actualResponse = client.getNotificationChannel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationChannelRequest actualRequest =
        (GetNotificationChannelRequest) actualRequests.get(0);

    Assert.assertEquals(name, NotificationChannelName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getNotificationChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      NotificationChannelName name =
          NotificationChannelName.of("[PROJECT]", "[NOTIFICATION_CHANNEL]");

      client.getNotificationChannel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createNotificationChannelTest() {
    String type = "type3575610";
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    NotificationChannel expectedResponse =
        NotificationChannel.newBuilder()
            .setType(type)
            .setName(name2)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");
    NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();

    NotificationChannel actualResponse =
        client.createNotificationChannel(name, notificationChannel);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNotificationChannelRequest actualRequest =
        (CreateNotificationChannelRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProjectName.parse(actualRequest.getName()));
    Assert.assertEquals(notificationChannel, actualRequest.getNotificationChannel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createNotificationChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();

      client.createNotificationChannel(name, notificationChannel);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateNotificationChannelTest() {
    String type = "type3575610";
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    NotificationChannel expectedResponse =
        NotificationChannel.newBuilder()
            .setType(type)
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    FieldMask updateMask = FieldMask.newBuilder().build();
    NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();

    NotificationChannel actualResponse =
        client.updateNotificationChannel(updateMask, notificationChannel);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNotificationChannelRequest actualRequest =
        (UpdateNotificationChannelRequest) actualRequests.get(0);

    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertEquals(notificationChannel, actualRequest.getNotificationChannel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateNotificationChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      FieldMask updateMask = FieldMask.newBuilder().build();
      NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();

      client.updateNotificationChannel(updateMask, notificationChannel);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteNotificationChannelTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockNotificationChannelService.addResponse(expectedResponse);

    NotificationChannelName name =
        NotificationChannelName.of("[PROJECT]", "[NOTIFICATION_CHANNEL]");
    boolean force = false;

    client.deleteNotificationChannel(name, force);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNotificationChannelRequest actualRequest =
        (DeleteNotificationChannelRequest) actualRequests.get(0);

    Assert.assertEquals(name, NotificationChannelName.parse(actualRequest.getName()));
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteNotificationChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      NotificationChannelName name =
          NotificationChannelName.of("[PROJECT]", "[NOTIFICATION_CHANNEL]");
      boolean force = false;

      client.deleteNotificationChannel(name, force);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void sendNotificationChannelVerificationCodeTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockNotificationChannelService.addResponse(expectedResponse);

    NotificationChannelName name =
        NotificationChannelName.of("[PROJECT]", "[NOTIFICATION_CHANNEL]");

    client.sendNotificationChannelVerificationCode(name);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SendNotificationChannelVerificationCodeRequest actualRequest =
        (SendNotificationChannelVerificationCodeRequest) actualRequests.get(0);

    Assert.assertEquals(name, NotificationChannelName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void sendNotificationChannelVerificationCodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      NotificationChannelName name =
          NotificationChannelName.of("[PROJECT]", "[NOTIFICATION_CHANNEL]");

      client.sendNotificationChannelVerificationCode(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getNotificationChannelVerificationCodeTest() {
    String code = "code3059181";
    GetNotificationChannelVerificationCodeResponse expectedResponse =
        GetNotificationChannelVerificationCodeResponse.newBuilder().setCode(code).build();
    mockNotificationChannelService.addResponse(expectedResponse);

    NotificationChannelName name =
        NotificationChannelName.of("[PROJECT]", "[NOTIFICATION_CHANNEL]");

    GetNotificationChannelVerificationCodeResponse actualResponse =
        client.getNotificationChannelVerificationCode(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationChannelVerificationCodeRequest actualRequest =
        (GetNotificationChannelVerificationCodeRequest) actualRequests.get(0);

    Assert.assertEquals(name, NotificationChannelName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getNotificationChannelVerificationCodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      NotificationChannelName name =
          NotificationChannelName.of("[PROJECT]", "[NOTIFICATION_CHANNEL]");

      client.getNotificationChannelVerificationCode(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void verifyNotificationChannelTest() {
    String type = "type3575610";
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    NotificationChannel expectedResponse =
        NotificationChannel.newBuilder()
            .setType(type)
            .setName(name2)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    NotificationChannelName name =
        NotificationChannelName.of("[PROJECT]", "[NOTIFICATION_CHANNEL]");
    String code = "code3059181";

    NotificationChannel actualResponse = client.verifyNotificationChannel(name, code);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    VerifyNotificationChannelRequest actualRequest =
        (VerifyNotificationChannelRequest) actualRequests.get(0);

    Assert.assertEquals(name, NotificationChannelName.parse(actualRequest.getName()));
    Assert.assertEquals(code, actualRequest.getCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void verifyNotificationChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      NotificationChannelName name =
          NotificationChannelName.of("[PROJECT]", "[NOTIFICATION_CHANNEL]");
      String code = "code3059181";

      client.verifyNotificationChannel(name, code);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
