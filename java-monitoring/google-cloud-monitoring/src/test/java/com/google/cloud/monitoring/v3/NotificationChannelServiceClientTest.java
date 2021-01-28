/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.NotificationChannelServiceClient.ListNotificationChannelDescriptorsPagedResponse;
import static com.google.cloud.monitoring.v3.NotificationChannelServiceClient.ListNotificationChannelsPagedResponse;

import com.google.api.LabelDescriptor;
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
import com.google.monitoring.v3.FolderName;
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
import com.google.monitoring.v3.OrganizationName;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest;
import com.google.monitoring.v3.ServiceTier;
import com.google.monitoring.v3.UpdateNotificationChannelRequest;
import com.google.monitoring.v3.VerifyNotificationChannelRequest;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.BoolValue;
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
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class NotificationChannelServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockNotificationChannelService mockNotificationChannelService;
  private NotificationChannelServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockNotificationChannelService = new MockNotificationChannelService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockNotificationChannelService));
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
  public void listNotificationChannelDescriptorsTest() throws Exception {
    NotificationChannelDescriptor responsesElement =
        NotificationChannelDescriptor.newBuilder().build();
    ListNotificationChannelDescriptorsResponse expectedResponse =
        ListNotificationChannelDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChannelDescriptors(Arrays.asList(responsesElement))
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    FolderName name = FolderName.of("[FOLDER]");

    ListNotificationChannelDescriptorsPagedResponse pagedListResponse =
        client.listNotificationChannelDescriptors(name);

    List<NotificationChannelDescriptor> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChannelDescriptorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationChannelDescriptorsRequest actualRequest =
        ((ListNotificationChannelDescriptorsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationChannelDescriptorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      FolderName name = FolderName.of("[FOLDER]");
      client.listNotificationChannelDescriptors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationChannelDescriptorsTest2() throws Exception {
    NotificationChannelDescriptor responsesElement =
        NotificationChannelDescriptor.newBuilder().build();
    ListNotificationChannelDescriptorsResponse expectedResponse =
        ListNotificationChannelDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChannelDescriptors(Arrays.asList(responsesElement))
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    OrganizationName name = OrganizationName.of("[ORGANIZATION]");

    ListNotificationChannelDescriptorsPagedResponse pagedListResponse =
        client.listNotificationChannelDescriptors(name);

    List<NotificationChannelDescriptor> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChannelDescriptorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationChannelDescriptorsRequest actualRequest =
        ((ListNotificationChannelDescriptorsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationChannelDescriptorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      OrganizationName name = OrganizationName.of("[ORGANIZATION]");
      client.listNotificationChannelDescriptors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationChannelDescriptorsTest3() throws Exception {
    NotificationChannelDescriptor responsesElement =
        NotificationChannelDescriptor.newBuilder().build();
    ListNotificationChannelDescriptorsResponse expectedResponse =
        ListNotificationChannelDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChannelDescriptors(Arrays.asList(responsesElement))
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
        ((ListNotificationChannelDescriptorsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationChannelDescriptorsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      client.listNotificationChannelDescriptors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationChannelDescriptorsTest4() throws Exception {
    NotificationChannelDescriptor responsesElement =
        NotificationChannelDescriptor.newBuilder().build();
    ListNotificationChannelDescriptorsResponse expectedResponse =
        ListNotificationChannelDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChannelDescriptors(Arrays.asList(responsesElement))
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    String name = "name3373707";

    ListNotificationChannelDescriptorsPagedResponse pagedListResponse =
        client.listNotificationChannelDescriptors(name);

    List<NotificationChannelDescriptor> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChannelDescriptorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationChannelDescriptorsRequest actualRequest =
        ((ListNotificationChannelDescriptorsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationChannelDescriptorsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      String name = "name3373707";
      client.listNotificationChannelDescriptors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationChannelDescriptorTest() throws Exception {
    NotificationChannelDescriptor expectedResponse =
        NotificationChannelDescriptor.newBuilder()
            .setName(
                NotificationChannelDescriptorName.ofProjectChannelDescriptorName(
                        "[PROJECT]", "[CHANNEL_DESCRIPTOR]")
                    .toString())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllLabels(new ArrayList<LabelDescriptor>())
            .addAllSupportedTiers(new ArrayList<ServiceTier>())
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    NotificationChannelDescriptorName name =
        NotificationChannelDescriptorName.ofProjectChannelDescriptorName(
            "[PROJECT]", "[CHANNEL_DESCRIPTOR]");

    NotificationChannelDescriptor actualResponse = client.getNotificationChannelDescriptor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationChannelDescriptorRequest actualRequest =
        ((GetNotificationChannelDescriptorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotificationChannelDescriptorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      NotificationChannelDescriptorName name =
          NotificationChannelDescriptorName.ofProjectChannelDescriptorName(
              "[PROJECT]", "[CHANNEL_DESCRIPTOR]");
      client.getNotificationChannelDescriptor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationChannelDescriptorTest2() throws Exception {
    NotificationChannelDescriptor expectedResponse =
        NotificationChannelDescriptor.newBuilder()
            .setName(
                NotificationChannelDescriptorName.ofProjectChannelDescriptorName(
                        "[PROJECT]", "[CHANNEL_DESCRIPTOR]")
                    .toString())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllLabels(new ArrayList<LabelDescriptor>())
            .addAllSupportedTiers(new ArrayList<ServiceTier>())
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    String name = "name3373707";

    NotificationChannelDescriptor actualResponse = client.getNotificationChannelDescriptor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationChannelDescriptorRequest actualRequest =
        ((GetNotificationChannelDescriptorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotificationChannelDescriptorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      String name = "name3373707";
      client.getNotificationChannelDescriptor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationChannelsTest() throws Exception {
    NotificationChannel responsesElement = NotificationChannel.newBuilder().build();
    ListNotificationChannelsResponse expectedResponse =
        ListNotificationChannelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotificationChannels(Arrays.asList(responsesElement))
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    FolderName name = FolderName.of("[FOLDER]");

    ListNotificationChannelsPagedResponse pagedListResponse = client.listNotificationChannels(name);

    List<NotificationChannel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotificationChannelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationChannelsRequest actualRequest =
        ((ListNotificationChannelsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationChannelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      FolderName name = FolderName.of("[FOLDER]");
      client.listNotificationChannels(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationChannelsTest2() throws Exception {
    NotificationChannel responsesElement = NotificationChannel.newBuilder().build();
    ListNotificationChannelsResponse expectedResponse =
        ListNotificationChannelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotificationChannels(Arrays.asList(responsesElement))
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    OrganizationName name = OrganizationName.of("[ORGANIZATION]");

    ListNotificationChannelsPagedResponse pagedListResponse = client.listNotificationChannels(name);

    List<NotificationChannel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotificationChannelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationChannelsRequest actualRequest =
        ((ListNotificationChannelsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationChannelsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      OrganizationName name = OrganizationName.of("[ORGANIZATION]");
      client.listNotificationChannels(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationChannelsTest3() throws Exception {
    NotificationChannel responsesElement = NotificationChannel.newBuilder().build();
    ListNotificationChannelsResponse expectedResponse =
        ListNotificationChannelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotificationChannels(Arrays.asList(responsesElement))
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
        ((ListNotificationChannelsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationChannelsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      client.listNotificationChannels(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationChannelsTest4() throws Exception {
    NotificationChannel responsesElement = NotificationChannel.newBuilder().build();
    ListNotificationChannelsResponse expectedResponse =
        ListNotificationChannelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotificationChannels(Arrays.asList(responsesElement))
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    String name = "name3373707";

    ListNotificationChannelsPagedResponse pagedListResponse = client.listNotificationChannels(name);

    List<NotificationChannel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotificationChannelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationChannelsRequest actualRequest =
        ((ListNotificationChannelsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationChannelsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      String name = "name3373707";
      client.listNotificationChannels(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationChannelTest() throws Exception {
    NotificationChannel expectedResponse =
        NotificationChannel.newBuilder()
            .setType("type3575610")
            .setName(
                NotificationChannelName.ofProjectNotificationChannelName(
                        "[PROJECT]", "[NOTIFICATION_CHANNEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .putAllUserLabels(new HashMap<String, String>())
            .setEnabled(BoolValue.newBuilder().build())
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    NotificationChannelName name =
        NotificationChannelName.ofProjectNotificationChannelName(
            "[PROJECT]", "[NOTIFICATION_CHANNEL]");

    NotificationChannel actualResponse = client.getNotificationChannel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationChannelRequest actualRequest =
        ((GetNotificationChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotificationChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      NotificationChannelName name =
          NotificationChannelName.ofProjectNotificationChannelName(
              "[PROJECT]", "[NOTIFICATION_CHANNEL]");
      client.getNotificationChannel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationChannelTest2() throws Exception {
    NotificationChannel expectedResponse =
        NotificationChannel.newBuilder()
            .setType("type3575610")
            .setName(
                NotificationChannelName.ofProjectNotificationChannelName(
                        "[PROJECT]", "[NOTIFICATION_CHANNEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .putAllUserLabels(new HashMap<String, String>())
            .setEnabled(BoolValue.newBuilder().build())
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    String name = "name3373707";

    NotificationChannel actualResponse = client.getNotificationChannel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationChannelRequest actualRequest =
        ((GetNotificationChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotificationChannelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      String name = "name3373707";
      client.getNotificationChannel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNotificationChannelTest() throws Exception {
    NotificationChannel expectedResponse =
        NotificationChannel.newBuilder()
            .setType("type3575610")
            .setName(
                NotificationChannelName.ofProjectNotificationChannelName(
                        "[PROJECT]", "[NOTIFICATION_CHANNEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .putAllUserLabels(new HashMap<String, String>())
            .setEnabled(BoolValue.newBuilder().build())
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    FolderName name = FolderName.of("[FOLDER]");
    NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();

    NotificationChannel actualResponse =
        client.createNotificationChannel(name, notificationChannel);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNotificationChannelRequest actualRequest =
        ((CreateNotificationChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(notificationChannel, actualRequest.getNotificationChannel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNotificationChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      FolderName name = FolderName.of("[FOLDER]");
      NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();
      client.createNotificationChannel(name, notificationChannel);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNotificationChannelTest2() throws Exception {
    NotificationChannel expectedResponse =
        NotificationChannel.newBuilder()
            .setType("type3575610")
            .setName(
                NotificationChannelName.ofProjectNotificationChannelName(
                        "[PROJECT]", "[NOTIFICATION_CHANNEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .putAllUserLabels(new HashMap<String, String>())
            .setEnabled(BoolValue.newBuilder().build())
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    OrganizationName name = OrganizationName.of("[ORGANIZATION]");
    NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();

    NotificationChannel actualResponse =
        client.createNotificationChannel(name, notificationChannel);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNotificationChannelRequest actualRequest =
        ((CreateNotificationChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(notificationChannel, actualRequest.getNotificationChannel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNotificationChannelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      OrganizationName name = OrganizationName.of("[ORGANIZATION]");
      NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();
      client.createNotificationChannel(name, notificationChannel);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNotificationChannelTest3() throws Exception {
    NotificationChannel expectedResponse =
        NotificationChannel.newBuilder()
            .setType("type3575610")
            .setName(
                NotificationChannelName.ofProjectNotificationChannelName(
                        "[PROJECT]", "[NOTIFICATION_CHANNEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .putAllUserLabels(new HashMap<String, String>())
            .setEnabled(BoolValue.newBuilder().build())
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
        ((CreateNotificationChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(notificationChannel, actualRequest.getNotificationChannel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNotificationChannelExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();
      client.createNotificationChannel(name, notificationChannel);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNotificationChannelTest4() throws Exception {
    NotificationChannel expectedResponse =
        NotificationChannel.newBuilder()
            .setType("type3575610")
            .setName(
                NotificationChannelName.ofProjectNotificationChannelName(
                        "[PROJECT]", "[NOTIFICATION_CHANNEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .putAllUserLabels(new HashMap<String, String>())
            .setEnabled(BoolValue.newBuilder().build())
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    String name = "name3373707";
    NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();

    NotificationChannel actualResponse =
        client.createNotificationChannel(name, notificationChannel);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNotificationChannelRequest actualRequest =
        ((CreateNotificationChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(notificationChannel, actualRequest.getNotificationChannel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNotificationChannelExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      String name = "name3373707";
      NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();
      client.createNotificationChannel(name, notificationChannel);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateNotificationChannelTest() throws Exception {
    NotificationChannel expectedResponse =
        NotificationChannel.newBuilder()
            .setType("type3575610")
            .setName(
                NotificationChannelName.ofProjectNotificationChannelName(
                        "[PROJECT]", "[NOTIFICATION_CHANNEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .putAllUserLabels(new HashMap<String, String>())
            .setEnabled(BoolValue.newBuilder().build())
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
        ((UpdateNotificationChannelRequest) actualRequests.get(0));

    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertEquals(notificationChannel, actualRequest.getNotificationChannel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateNotificationChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      FieldMask updateMask = FieldMask.newBuilder().build();
      NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();
      client.updateNotificationChannel(updateMask, notificationChannel);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNotificationChannelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockNotificationChannelService.addResponse(expectedResponse);

    NotificationChannelName name =
        NotificationChannelName.ofProjectNotificationChannelName(
            "[PROJECT]", "[NOTIFICATION_CHANNEL]");
    boolean force = true;

    client.deleteNotificationChannel(name, force);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNotificationChannelRequest actualRequest =
        ((DeleteNotificationChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNotificationChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      NotificationChannelName name =
          NotificationChannelName.ofProjectNotificationChannelName(
              "[PROJECT]", "[NOTIFICATION_CHANNEL]");
      boolean force = true;
      client.deleteNotificationChannel(name, force);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNotificationChannelTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockNotificationChannelService.addResponse(expectedResponse);

    String name = "name3373707";
    boolean force = true;

    client.deleteNotificationChannel(name, force);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNotificationChannelRequest actualRequest =
        ((DeleteNotificationChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNotificationChannelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      String name = "name3373707";
      boolean force = true;
      client.deleteNotificationChannel(name, force);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void sendNotificationChannelVerificationCodeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockNotificationChannelService.addResponse(expectedResponse);

    NotificationChannelName name =
        NotificationChannelName.ofProjectNotificationChannelName(
            "[PROJECT]", "[NOTIFICATION_CHANNEL]");

    client.sendNotificationChannelVerificationCode(name);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SendNotificationChannelVerificationCodeRequest actualRequest =
        ((SendNotificationChannelVerificationCodeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void sendNotificationChannelVerificationCodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      NotificationChannelName name =
          NotificationChannelName.ofProjectNotificationChannelName(
              "[PROJECT]", "[NOTIFICATION_CHANNEL]");
      client.sendNotificationChannelVerificationCode(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void sendNotificationChannelVerificationCodeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockNotificationChannelService.addResponse(expectedResponse);

    String name = "name3373707";

    client.sendNotificationChannelVerificationCode(name);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SendNotificationChannelVerificationCodeRequest actualRequest =
        ((SendNotificationChannelVerificationCodeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void sendNotificationChannelVerificationCodeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      String name = "name3373707";
      client.sendNotificationChannelVerificationCode(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationChannelVerificationCodeTest() throws Exception {
    GetNotificationChannelVerificationCodeResponse expectedResponse =
        GetNotificationChannelVerificationCodeResponse.newBuilder()
            .setCode("code3059181")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    NotificationChannelName name =
        NotificationChannelName.ofProjectNotificationChannelName(
            "[PROJECT]", "[NOTIFICATION_CHANNEL]");

    GetNotificationChannelVerificationCodeResponse actualResponse =
        client.getNotificationChannelVerificationCode(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationChannelVerificationCodeRequest actualRequest =
        ((GetNotificationChannelVerificationCodeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotificationChannelVerificationCodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      NotificationChannelName name =
          NotificationChannelName.ofProjectNotificationChannelName(
              "[PROJECT]", "[NOTIFICATION_CHANNEL]");
      client.getNotificationChannelVerificationCode(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationChannelVerificationCodeTest2() throws Exception {
    GetNotificationChannelVerificationCodeResponse expectedResponse =
        GetNotificationChannelVerificationCodeResponse.newBuilder()
            .setCode("code3059181")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    String name = "name3373707";

    GetNotificationChannelVerificationCodeResponse actualResponse =
        client.getNotificationChannelVerificationCode(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationChannelVerificationCodeRequest actualRequest =
        ((GetNotificationChannelVerificationCodeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotificationChannelVerificationCodeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      String name = "name3373707";
      client.getNotificationChannelVerificationCode(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void verifyNotificationChannelTest() throws Exception {
    NotificationChannel expectedResponse =
        NotificationChannel.newBuilder()
            .setType("type3575610")
            .setName(
                NotificationChannelName.ofProjectNotificationChannelName(
                        "[PROJECT]", "[NOTIFICATION_CHANNEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .putAllUserLabels(new HashMap<String, String>())
            .setEnabled(BoolValue.newBuilder().build())
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    NotificationChannelName name =
        NotificationChannelName.ofProjectNotificationChannelName(
            "[PROJECT]", "[NOTIFICATION_CHANNEL]");
    String code = "code3059181";

    NotificationChannel actualResponse = client.verifyNotificationChannel(name, code);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    VerifyNotificationChannelRequest actualRequest =
        ((VerifyNotificationChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(code, actualRequest.getCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void verifyNotificationChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      NotificationChannelName name =
          NotificationChannelName.ofProjectNotificationChannelName(
              "[PROJECT]", "[NOTIFICATION_CHANNEL]");
      String code = "code3059181";
      client.verifyNotificationChannel(name, code);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void verifyNotificationChannelTest2() throws Exception {
    NotificationChannel expectedResponse =
        NotificationChannel.newBuilder()
            .setType("type3575610")
            .setName(
                NotificationChannelName.ofProjectNotificationChannelName(
                        "[PROJECT]", "[NOTIFICATION_CHANNEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .putAllUserLabels(new HashMap<String, String>())
            .setEnabled(BoolValue.newBuilder().build())
            .build();
    mockNotificationChannelService.addResponse(expectedResponse);

    String name = "name3373707";
    String code = "code3059181";

    NotificationChannel actualResponse = client.verifyNotificationChannel(name, code);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    VerifyNotificationChannelRequest actualRequest =
        ((VerifyNotificationChannelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(code, actualRequest.getCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void verifyNotificationChannelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationChannelService.addException(exception);

    try {
      String name = "name3373707";
      String code = "code3059181";
      client.verifyNotificationChannel(name, code);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
