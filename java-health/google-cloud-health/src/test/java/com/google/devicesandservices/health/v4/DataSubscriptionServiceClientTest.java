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

package com.google.devicesandservices.health.v4;

import static com.google.devicesandservices.health.v4.DataSubscriptionServiceClient.ListSubscribersPagedResponse;

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
public class DataSubscriptionServiceClientTest {
  private static MockDataSubscriptionService mockDataSubscriptionService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataSubscriptionServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataSubscriptionService = new MockDataSubscriptionService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataSubscriptionService));
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
    DataSubscriptionServiceSettings settings =
        DataSubscriptionServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataSubscriptionServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createSubscriberTest() throws Exception {
    Subscriber expectedResponse =
        Subscriber.newBuilder()
            .setName(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
            .setEndpointUri("endpointUri-1135817833")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSubscriberConfigs(new ArrayList<SubscriberConfig>())
            .setEndpointAuthorization(EndpointAuthorization.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSubscriberTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataSubscriptionService.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");
    CreateSubscriberPayload subscriber = CreateSubscriberPayload.newBuilder().build();
    String subscriberId = "subscriberId327834531";

    Subscriber actualResponse =
        client.createSubscriberAsync(parent, subscriber, subscriberId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSubscriberRequest actualRequest = ((CreateSubscriberRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(subscriber, actualRequest.getSubscriber());
    Assert.assertEquals(subscriberId, actualRequest.getSubscriberId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSubscriberExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSubscriptionService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      CreateSubscriberPayload subscriber = CreateSubscriberPayload.newBuilder().build();
      String subscriberId = "subscriberId327834531";
      client.createSubscriberAsync(parent, subscriber, subscriberId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createSubscriberTest2() throws Exception {
    Subscriber expectedResponse =
        Subscriber.newBuilder()
            .setName(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
            .setEndpointUri("endpointUri-1135817833")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSubscriberConfigs(new ArrayList<SubscriberConfig>())
            .setEndpointAuthorization(EndpointAuthorization.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSubscriberTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataSubscriptionService.addResponse(resultOperation);

    String parent = "parent-995424086";
    CreateSubscriberPayload subscriber = CreateSubscriberPayload.newBuilder().build();
    String subscriberId = "subscriberId327834531";

    Subscriber actualResponse =
        client.createSubscriberAsync(parent, subscriber, subscriberId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSubscriberRequest actualRequest = ((CreateSubscriberRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(subscriber, actualRequest.getSubscriber());
    Assert.assertEquals(subscriberId, actualRequest.getSubscriberId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSubscriberExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSubscriptionService.addException(exception);

    try {
      String parent = "parent-995424086";
      CreateSubscriberPayload subscriber = CreateSubscriberPayload.newBuilder().build();
      String subscriberId = "subscriberId327834531";
      client.createSubscriberAsync(parent, subscriber, subscriberId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listSubscribersTest() throws Exception {
    Subscriber responsesElement = Subscriber.newBuilder().build();
    ListSubscribersResponse expectedResponse =
        ListSubscribersResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubscribers(Arrays.asList(responsesElement))
            .build();
    mockDataSubscriptionService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListSubscribersPagedResponse pagedListResponse = client.listSubscribers(parent);

    List<Subscriber> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscribersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSubscribersRequest actualRequest = ((ListSubscribersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSubscribersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSubscriptionService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listSubscribers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubscribersTest2() throws Exception {
    Subscriber responsesElement = Subscriber.newBuilder().build();
    ListSubscribersResponse expectedResponse =
        ListSubscribersResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubscribers(Arrays.asList(responsesElement))
            .build();
    mockDataSubscriptionService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSubscribersPagedResponse pagedListResponse = client.listSubscribers(parent);

    List<Subscriber> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscribersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSubscribersRequest actualRequest = ((ListSubscribersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSubscribersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSubscriptionService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSubscribers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSubscriberTest() throws Exception {
    Subscriber expectedResponse =
        Subscriber.newBuilder()
            .setName(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
            .setEndpointUri("endpointUri-1135817833")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSubscriberConfigs(new ArrayList<SubscriberConfig>())
            .setEndpointAuthorization(EndpointAuthorization.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSubscriberTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataSubscriptionService.addResponse(resultOperation);

    Subscriber subscriber = Subscriber.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Subscriber actualResponse = client.updateSubscriberAsync(subscriber, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSubscriberRequest actualRequest = ((UpdateSubscriberRequest) actualRequests.get(0));

    Assert.assertEquals(subscriber, actualRequest.getSubscriber());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSubscriberExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSubscriptionService.addException(exception);

    try {
      Subscriber subscriber = Subscriber.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSubscriberAsync(subscriber, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSubscriberTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSubscriberTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataSubscriptionService.addResponse(resultOperation);

    SubscriberName name = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]");

    client.deleteSubscriberAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSubscriberRequest actualRequest = ((DeleteSubscriberRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSubscriberExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSubscriptionService.addException(exception);

    try {
      SubscriberName name = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]");
      client.deleteSubscriberAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSubscriberTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSubscriberTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataSubscriptionService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteSubscriberAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSubscriberRequest actualRequest = ((DeleteSubscriberRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSubscriberExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSubscriptionService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSubscriberAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
