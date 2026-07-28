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

package com.google.cloud.support.v2;

import static com.google.cloud.support.v2.SupportEventSubscriptionServiceClient.ListSupportEventSubscriptionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
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
public class SupportEventSubscriptionServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockSupportEventSubscriptionService mockSupportEventSubscriptionService;
  private LocalChannelProvider channelProvider;
  private SupportEventSubscriptionServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSupportEventSubscriptionService = new MockSupportEventSubscriptionService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSupportEventSubscriptionService));
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
    SupportEventSubscriptionServiceSettings settings =
        SupportEventSubscriptionServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SupportEventSubscriptionServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createSupportEventSubscriptionTest() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockSupportEventSubscriptionService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    SupportEventSubscription supportEventSubscription =
        SupportEventSubscription.newBuilder().build();

    SupportEventSubscription actualResponse =
        client.createSupportEventSubscription(parent, supportEventSubscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSupportEventSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSupportEventSubscriptionRequest actualRequest =
        ((CreateSupportEventSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(supportEventSubscription, actualRequest.getSupportEventSubscription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSupportEventSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSupportEventSubscriptionService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      SupportEventSubscription supportEventSubscription =
          SupportEventSubscription.newBuilder().build();
      client.createSupportEventSubscription(parent, supportEventSubscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSupportEventSubscriptionTest2() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockSupportEventSubscriptionService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    SupportEventSubscription supportEventSubscription =
        SupportEventSubscription.newBuilder().build();

    SupportEventSubscription actualResponse =
        client.createSupportEventSubscription(parent, supportEventSubscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSupportEventSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSupportEventSubscriptionRequest actualRequest =
        ((CreateSupportEventSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(supportEventSubscription, actualRequest.getSupportEventSubscription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSupportEventSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSupportEventSubscriptionService.addException(exception);

    try {
      String parent = "parent-995424086";
      SupportEventSubscription supportEventSubscription =
          SupportEventSubscription.newBuilder().build();
      client.createSupportEventSubscription(parent, supportEventSubscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSupportEventSubscriptionTest() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockSupportEventSubscriptionService.addResponse(expectedResponse);

    SupportEventSubscriptionName name =
        SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]");

    SupportEventSubscription actualResponse = client.getSupportEventSubscription(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSupportEventSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSupportEventSubscriptionRequest actualRequest =
        ((GetSupportEventSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSupportEventSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSupportEventSubscriptionService.addException(exception);

    try {
      SupportEventSubscriptionName name =
          SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]");
      client.getSupportEventSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSupportEventSubscriptionTest2() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockSupportEventSubscriptionService.addResponse(expectedResponse);

    String name = "name3373707";

    SupportEventSubscription actualResponse = client.getSupportEventSubscription(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSupportEventSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSupportEventSubscriptionRequest actualRequest =
        ((GetSupportEventSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSupportEventSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSupportEventSubscriptionService.addException(exception);

    try {
      String name = "name3373707";
      client.getSupportEventSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSupportEventSubscriptionsTest() throws Exception {
    SupportEventSubscription responsesElement = SupportEventSubscription.newBuilder().build();
    ListSupportEventSubscriptionsResponse expectedResponse =
        ListSupportEventSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSupportEventSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockSupportEventSubscriptionService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListSupportEventSubscriptionsPagedResponse pagedListResponse =
        client.listSupportEventSubscriptions(parent);

    List<SupportEventSubscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSupportEventSubscriptionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSupportEventSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSupportEventSubscriptionsRequest actualRequest =
        ((ListSupportEventSubscriptionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSupportEventSubscriptionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSupportEventSubscriptionService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listSupportEventSubscriptions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSupportEventSubscriptionsTest2() throws Exception {
    SupportEventSubscription responsesElement = SupportEventSubscription.newBuilder().build();
    ListSupportEventSubscriptionsResponse expectedResponse =
        ListSupportEventSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSupportEventSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockSupportEventSubscriptionService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSupportEventSubscriptionsPagedResponse pagedListResponse =
        client.listSupportEventSubscriptions(parent);

    List<SupportEventSubscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSupportEventSubscriptionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSupportEventSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSupportEventSubscriptionsRequest actualRequest =
        ((ListSupportEventSubscriptionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSupportEventSubscriptionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSupportEventSubscriptionService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSupportEventSubscriptions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSupportEventSubscriptionTest() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockSupportEventSubscriptionService.addResponse(expectedResponse);

    SupportEventSubscription supportEventSubscription =
        SupportEventSubscription.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SupportEventSubscription actualResponse =
        client.updateSupportEventSubscription(supportEventSubscription, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSupportEventSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSupportEventSubscriptionRequest actualRequest =
        ((UpdateSupportEventSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(supportEventSubscription, actualRequest.getSupportEventSubscription());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSupportEventSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSupportEventSubscriptionService.addException(exception);

    try {
      SupportEventSubscription supportEventSubscription =
          SupportEventSubscription.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSupportEventSubscription(supportEventSubscription, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSupportEventSubscriptionTest() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockSupportEventSubscriptionService.addResponse(expectedResponse);

    SupportEventSubscriptionName name =
        SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]");

    SupportEventSubscription actualResponse = client.deleteSupportEventSubscription(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSupportEventSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSupportEventSubscriptionRequest actualRequest =
        ((DeleteSupportEventSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSupportEventSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSupportEventSubscriptionService.addException(exception);

    try {
      SupportEventSubscriptionName name =
          SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]");
      client.deleteSupportEventSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSupportEventSubscriptionTest2() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockSupportEventSubscriptionService.addResponse(expectedResponse);

    String name = "name3373707";

    SupportEventSubscription actualResponse = client.deleteSupportEventSubscription(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSupportEventSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSupportEventSubscriptionRequest actualRequest =
        ((DeleteSupportEventSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSupportEventSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSupportEventSubscriptionService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSupportEventSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void undeleteSupportEventSubscriptionTest() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockSupportEventSubscriptionService.addResponse(expectedResponse);

    UndeleteSupportEventSubscriptionRequest request =
        UndeleteSupportEventSubscriptionRequest.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .build();

    SupportEventSubscription actualResponse = client.undeleteSupportEventSubscription(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSupportEventSubscriptionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteSupportEventSubscriptionRequest actualRequest =
        ((UndeleteSupportEventSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteSupportEventSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSupportEventSubscriptionService.addException(exception);

    try {
      UndeleteSupportEventSubscriptionRequest request =
          UndeleteSupportEventSubscriptionRequest.newBuilder()
              .setName(
                  SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                      .toString())
              .build();
      client.undeleteSupportEventSubscription(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
