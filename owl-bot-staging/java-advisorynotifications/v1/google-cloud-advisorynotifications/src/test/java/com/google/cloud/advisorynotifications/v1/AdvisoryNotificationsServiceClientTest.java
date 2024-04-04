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

package com.google.cloud.advisorynotifications.v1;

import static com.google.cloud.advisorynotifications.v1.AdvisoryNotificationsServiceClient.ListNotificationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
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
public class AdvisoryNotificationsServiceClientTest {
  private static MockAdvisoryNotificationsService mockAdvisoryNotificationsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AdvisoryNotificationsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAdvisoryNotificationsService = new MockAdvisoryNotificationsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAdvisoryNotificationsService));
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
    AdvisoryNotificationsServiceSettings settings =
        AdvisoryNotificationsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AdvisoryNotificationsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listNotificationsTest() throws Exception {
    Notification responsesElement = Notification.newBuilder().build();
    ListNotificationsResponse expectedResponse =
        ListNotificationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotifications(Arrays.asList(responsesElement))
            .build();
    mockAdvisoryNotificationsService.addResponse(expectedResponse);

    LocationName parent = LocationName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");

    ListNotificationsPagedResponse pagedListResponse = client.listNotifications(parent);

    List<Notification> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotificationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAdvisoryNotificationsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationsRequest actualRequest = ((ListNotificationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdvisoryNotificationsService.addException(exception);

    try {
      LocationName parent = LocationName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");
      client.listNotifications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationsTest2() throws Exception {
    Notification responsesElement = Notification.newBuilder().build();
    ListNotificationsResponse expectedResponse =
        ListNotificationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotifications(Arrays.asList(responsesElement))
            .build();
    mockAdvisoryNotificationsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNotificationsPagedResponse pagedListResponse = client.listNotifications(parent);

    List<Notification> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotificationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAdvisoryNotificationsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationsRequest actualRequest = ((ListNotificationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdvisoryNotificationsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNotifications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationTest() throws Exception {
    Notification expectedResponse =
        Notification.newBuilder()
            .setName(
                NotificationName.ofOrganizationLocationNotificationName(
                        "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION]")
                    .toString())
            .setSubject(Subject.newBuilder().build())
            .addAllMessages(new ArrayList<Message>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setNotificationType(NotificationType.forNumber(0))
            .build();
    mockAdvisoryNotificationsService.addResponse(expectedResponse);

    NotificationName name =
        NotificationName.ofOrganizationLocationNotificationName(
            "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION]");

    Notification actualResponse = client.getNotification(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdvisoryNotificationsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationRequest actualRequest = ((GetNotificationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotificationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdvisoryNotificationsService.addException(exception);

    try {
      NotificationName name =
          NotificationName.ofOrganizationLocationNotificationName(
              "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION]");
      client.getNotification(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationTest2() throws Exception {
    Notification expectedResponse =
        Notification.newBuilder()
            .setName(
                NotificationName.ofOrganizationLocationNotificationName(
                        "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION]")
                    .toString())
            .setSubject(Subject.newBuilder().build())
            .addAllMessages(new ArrayList<Message>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setNotificationType(NotificationType.forNumber(0))
            .build();
    mockAdvisoryNotificationsService.addResponse(expectedResponse);

    String name = "name3373707";

    Notification actualResponse = client.getNotification(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdvisoryNotificationsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationRequest actualRequest = ((GetNotificationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotificationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdvisoryNotificationsService.addException(exception);

    try {
      String name = "name3373707";
      client.getNotification(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSettingsTest() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(
                SettingsName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]").toString())
            .putAllNotificationSettings(new HashMap<String, NotificationSettings>())
            .setEtag("etag3123477")
            .build();
    mockAdvisoryNotificationsService.addResponse(expectedResponse);

    SettingsName name = SettingsName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");

    Settings actualResponse = client.getSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdvisoryNotificationsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSettingsRequest actualRequest = ((GetSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdvisoryNotificationsService.addException(exception);

    try {
      SettingsName name = SettingsName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");
      client.getSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSettingsTest2() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(
                SettingsName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]").toString())
            .putAllNotificationSettings(new HashMap<String, NotificationSettings>())
            .setEtag("etag3123477")
            .build();
    mockAdvisoryNotificationsService.addResponse(expectedResponse);

    String name = "name3373707";

    Settings actualResponse = client.getSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdvisoryNotificationsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSettingsRequest actualRequest = ((GetSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdvisoryNotificationsService.addException(exception);

    try {
      String name = "name3373707";
      client.getSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSettingsTest() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(
                SettingsName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]").toString())
            .putAllNotificationSettings(new HashMap<String, NotificationSettings>())
            .setEtag("etag3123477")
            .build();
    mockAdvisoryNotificationsService.addResponse(expectedResponse);

    Settings settings = Settings.newBuilder().build();

    Settings actualResponse = client.updateSettings(settings);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdvisoryNotificationsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSettingsRequest actualRequest = ((UpdateSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(settings, actualRequest.getSettings());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdvisoryNotificationsService.addException(exception);

    try {
      Settings settings = Settings.newBuilder().build();
      client.updateSettings(settings);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
