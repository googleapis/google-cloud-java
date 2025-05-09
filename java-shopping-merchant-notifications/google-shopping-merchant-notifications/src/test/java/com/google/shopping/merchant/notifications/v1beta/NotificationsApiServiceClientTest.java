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

package com.google.shopping.merchant.notifications.v1beta;

import static com.google.shopping.merchant.notifications.v1beta.NotificationsApiServiceClient.ListNotificationSubscriptionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
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
public class NotificationsApiServiceClientTest {
  private static MockNotificationsApiService mockNotificationsApiService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private NotificationsApiServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockNotificationsApiService = new MockNotificationsApiService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockNotificationsApiService));
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
    NotificationsApiServiceSettings settings =
        NotificationsApiServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = NotificationsApiServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getNotificationSubscriptionTest() throws Exception {
    NotificationSubscription expectedResponse =
        NotificationSubscription.newBuilder()
            .setName(
                NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
                    .toString())
            .setCallBackUri("callBackUri-760667449")
            .build();
    mockNotificationsApiService.addResponse(expectedResponse);

    NotificationSubscriptionName name =
        NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]");

    NotificationSubscription actualResponse = client.getNotificationSubscription(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationsApiService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationSubscriptionRequest actualRequest =
        ((GetNotificationSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotificationSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationsApiService.addException(exception);

    try {
      NotificationSubscriptionName name =
          NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]");
      client.getNotificationSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationSubscriptionTest2() throws Exception {
    NotificationSubscription expectedResponse =
        NotificationSubscription.newBuilder()
            .setName(
                NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
                    .toString())
            .setCallBackUri("callBackUri-760667449")
            .build();
    mockNotificationsApiService.addResponse(expectedResponse);

    String name = "name3373707";

    NotificationSubscription actualResponse = client.getNotificationSubscription(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationsApiService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationSubscriptionRequest actualRequest =
        ((GetNotificationSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotificationSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationsApiService.addException(exception);

    try {
      String name = "name3373707";
      client.getNotificationSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNotificationSubscriptionTest() throws Exception {
    NotificationSubscription expectedResponse =
        NotificationSubscription.newBuilder()
            .setName(
                NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
                    .toString())
            .setCallBackUri("callBackUri-760667449")
            .build();
    mockNotificationsApiService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    NotificationSubscription notificationSubscription =
        NotificationSubscription.newBuilder().build();

    NotificationSubscription actualResponse =
        client.createNotificationSubscription(parent, notificationSubscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationsApiService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNotificationSubscriptionRequest actualRequest =
        ((CreateNotificationSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(notificationSubscription, actualRequest.getNotificationSubscription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNotificationSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationsApiService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      NotificationSubscription notificationSubscription =
          NotificationSubscription.newBuilder().build();
      client.createNotificationSubscription(parent, notificationSubscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNotificationSubscriptionTest2() throws Exception {
    NotificationSubscription expectedResponse =
        NotificationSubscription.newBuilder()
            .setName(
                NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
                    .toString())
            .setCallBackUri("callBackUri-760667449")
            .build();
    mockNotificationsApiService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    NotificationSubscription notificationSubscription =
        NotificationSubscription.newBuilder().build();

    NotificationSubscription actualResponse =
        client.createNotificationSubscription(parent, notificationSubscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationsApiService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNotificationSubscriptionRequest actualRequest =
        ((CreateNotificationSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(notificationSubscription, actualRequest.getNotificationSubscription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNotificationSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationsApiService.addException(exception);

    try {
      String parent = "parent-995424086";
      NotificationSubscription notificationSubscription =
          NotificationSubscription.newBuilder().build();
      client.createNotificationSubscription(parent, notificationSubscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateNotificationSubscriptionTest() throws Exception {
    NotificationSubscription expectedResponse =
        NotificationSubscription.newBuilder()
            .setName(
                NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
                    .toString())
            .setCallBackUri("callBackUri-760667449")
            .build();
    mockNotificationsApiService.addResponse(expectedResponse);

    NotificationSubscription notificationSubscription =
        NotificationSubscription.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    NotificationSubscription actualResponse =
        client.updateNotificationSubscription(notificationSubscription, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotificationsApiService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNotificationSubscriptionRequest actualRequest =
        ((UpdateNotificationSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(notificationSubscription, actualRequest.getNotificationSubscription());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateNotificationSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationsApiService.addException(exception);

    try {
      NotificationSubscription notificationSubscription =
          NotificationSubscription.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNotificationSubscription(notificationSubscription, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNotificationSubscriptionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockNotificationsApiService.addResponse(expectedResponse);

    NotificationSubscriptionName name =
        NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]");

    client.deleteNotificationSubscription(name);

    List<AbstractMessage> actualRequests = mockNotificationsApiService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNotificationSubscriptionRequest actualRequest =
        ((DeleteNotificationSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNotificationSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationsApiService.addException(exception);

    try {
      NotificationSubscriptionName name =
          NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]");
      client.deleteNotificationSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNotificationSubscriptionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockNotificationsApiService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteNotificationSubscription(name);

    List<AbstractMessage> actualRequests = mockNotificationsApiService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNotificationSubscriptionRequest actualRequest =
        ((DeleteNotificationSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNotificationSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationsApiService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteNotificationSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationSubscriptionsTest() throws Exception {
    NotificationSubscription responsesElement = NotificationSubscription.newBuilder().build();
    ListNotificationSubscriptionsResponse expectedResponse =
        ListNotificationSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotificationSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockNotificationsApiService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListNotificationSubscriptionsPagedResponse pagedListResponse =
        client.listNotificationSubscriptions(parent);

    List<NotificationSubscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getNotificationSubscriptionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotificationsApiService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationSubscriptionsRequest actualRequest =
        ((ListNotificationSubscriptionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationSubscriptionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationsApiService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listNotificationSubscriptions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationSubscriptionsTest2() throws Exception {
    NotificationSubscription responsesElement = NotificationSubscription.newBuilder().build();
    ListNotificationSubscriptionsResponse expectedResponse =
        ListNotificationSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotificationSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockNotificationsApiService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNotificationSubscriptionsPagedResponse pagedListResponse =
        client.listNotificationSubscriptions(parent);

    List<NotificationSubscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getNotificationSubscriptionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotificationsApiService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationSubscriptionsRequest actualRequest =
        ((ListNotificationSubscriptionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationSubscriptionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotificationsApiService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNotificationSubscriptions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
