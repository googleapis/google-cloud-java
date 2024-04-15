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

package com.google.apps.events.subscriptions.v1;

import static com.google.apps.events.subscriptions.v1.SubscriptionsServiceClient.ListSubscriptionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class SubscriptionsServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockSubscriptionsService mockSubscriptionsService;
  private LocalChannelProvider channelProvider;
  private SubscriptionsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSubscriptionsService = new MockSubscriptionsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSubscriptionsService));
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
    SubscriptionsServiceSettings settings =
        SubscriptionsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SubscriptionsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createSubscriptionTest() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
            .setUid("uid115792")
            .setTargetResource("targetResource-1933150017")
            .addAllEventTypes(new ArrayList<String>())
            .setPayloadOptions(PayloadOptions.newBuilder().build())
            .setNotificationEndpoint(NotificationEndpoint.newBuilder().build())
            .setAuthority("authority1475610435")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSubscriptionsService.addResponse(resultOperation);

    Subscription subscription = Subscription.newBuilder().build();

    Subscription actualResponse = client.createSubscriptionAsync(subscription).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriptionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSubscriptionRequest actualRequest = ((CreateSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(subscription, actualRequest.getSubscription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriptionsService.addException(exception);

    try {
      Subscription subscription = Subscription.newBuilder().build();
      client.createSubscriptionAsync(subscription).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSubscriptionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSubscriptionsService.addResponse(resultOperation);

    SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");

    client.deleteSubscriptionAsync(name).get();

    List<AbstractMessage> actualRequests = mockSubscriptionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSubscriptionRequest actualRequest = ((DeleteSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriptionsService.addException(exception);

    try {
      SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");
      client.deleteSubscriptionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSubscriptionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSubscriptionsService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteSubscriptionAsync(name).get();

    List<AbstractMessage> actualRequests = mockSubscriptionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSubscriptionRequest actualRequest = ((DeleteSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriptionsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSubscriptionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getSubscriptionTest() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
            .setUid("uid115792")
            .setTargetResource("targetResource-1933150017")
            .addAllEventTypes(new ArrayList<String>())
            .setPayloadOptions(PayloadOptions.newBuilder().build())
            .setNotificationEndpoint(NotificationEndpoint.newBuilder().build())
            .setAuthority("authority1475610435")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    mockSubscriptionsService.addResponse(expectedResponse);

    SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");

    Subscription actualResponse = client.getSubscription(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriptionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSubscriptionRequest actualRequest = ((GetSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriptionsService.addException(exception);

    try {
      SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");
      client.getSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSubscriptionTest2() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
            .setUid("uid115792")
            .setTargetResource("targetResource-1933150017")
            .addAllEventTypes(new ArrayList<String>())
            .setPayloadOptions(PayloadOptions.newBuilder().build())
            .setNotificationEndpoint(NotificationEndpoint.newBuilder().build())
            .setAuthority("authority1475610435")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    mockSubscriptionsService.addResponse(expectedResponse);

    String name = "name3373707";

    Subscription actualResponse = client.getSubscription(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriptionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSubscriptionRequest actualRequest = ((GetSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriptionsService.addException(exception);

    try {
      String name = "name3373707";
      client.getSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubscriptionsTest() throws Exception {
    Subscription responsesElement = Subscription.newBuilder().build();
    ListSubscriptionsResponse expectedResponse =
        ListSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockSubscriptionsService.addResponse(expectedResponse);

    String filter = "filter-1274492040";

    ListSubscriptionsPagedResponse pagedListResponse = client.listSubscriptions(filter);

    List<Subscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscriptionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSubscriptionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSubscriptionsRequest actualRequest = ((ListSubscriptionsRequest) actualRequests.get(0));

    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSubscriptionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriptionsService.addException(exception);

    try {
      String filter = "filter-1274492040";
      client.listSubscriptions(filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSubscriptionTest() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
            .setUid("uid115792")
            .setTargetResource("targetResource-1933150017")
            .addAllEventTypes(new ArrayList<String>())
            .setPayloadOptions(PayloadOptions.newBuilder().build())
            .setNotificationEndpoint(NotificationEndpoint.newBuilder().build())
            .setAuthority("authority1475610435")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSubscriptionsService.addResponse(resultOperation);

    Subscription subscription = Subscription.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Subscription actualResponse = client.updateSubscriptionAsync(subscription, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriptionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSubscriptionRequest actualRequest = ((UpdateSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(subscription, actualRequest.getSubscription());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriptionsService.addException(exception);

    try {
      Subscription subscription = Subscription.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSubscriptionAsync(subscription, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reactivateSubscriptionTest() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
            .setUid("uid115792")
            .setTargetResource("targetResource-1933150017")
            .addAllEventTypes(new ArrayList<String>())
            .setPayloadOptions(PayloadOptions.newBuilder().build())
            .setNotificationEndpoint(NotificationEndpoint.newBuilder().build())
            .setAuthority("authority1475610435")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reactivateSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSubscriptionsService.addResponse(resultOperation);

    SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");

    Subscription actualResponse = client.reactivateSubscriptionAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriptionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReactivateSubscriptionRequest actualRequest =
        ((ReactivateSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reactivateSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriptionsService.addException(exception);

    try {
      SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");
      client.reactivateSubscriptionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reactivateSubscriptionTest2() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
            .setUid("uid115792")
            .setTargetResource("targetResource-1933150017")
            .addAllEventTypes(new ArrayList<String>())
            .setPayloadOptions(PayloadOptions.newBuilder().build())
            .setNotificationEndpoint(NotificationEndpoint.newBuilder().build())
            .setAuthority("authority1475610435")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reactivateSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSubscriptionsService.addResponse(resultOperation);

    String name = "name3373707";

    Subscription actualResponse = client.reactivateSubscriptionAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriptionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReactivateSubscriptionRequest actualRequest =
        ((ReactivateSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reactivateSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriptionsService.addException(exception);

    try {
      String name = "name3373707";
      client.reactivateSubscriptionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
