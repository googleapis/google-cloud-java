/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.pubsub.v1;

import static com.google.cloud.pubsub.v1.TopicAdminClient.ListTopicSubscriptionsPagedResponse;
import static com.google.cloud.pubsub.v1.TopicAdminClient.ListTopicsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class TopicAdminClientTest {
  private static MockPublisher mockPublisher;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockSubscriber mockSubscriber;
  private static MockServiceHelper serviceHelper;
  private TopicAdminClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockPublisher = new MockPublisher();
    mockIAMPolicy = new MockIAMPolicy();
    mockSubscriber = new MockSubscriber();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(mockPublisher, mockIAMPolicy, mockSubscriber));
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
    TopicAdminSettings settings =
        TopicAdminSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TopicAdminClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createTopicTest() {
    TopicName name2 = TopicName.of("[PROJECT]", "[TOPIC]");
    Topic expectedResponse = Topic.newBuilder().setName(name2.toString()).build();
    mockPublisher.addResponse(expectedResponse);

    TopicName name = TopicName.of("[PROJECT]", "[TOPIC]");

    Topic actualResponse = client.createTopic(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Topic actualRequest = (Topic) actualRequests.get(0);

    Assert.assertEquals(name, TopicName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createTopicExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      TopicName name = TopicName.of("[PROJECT]", "[TOPIC]");

      client.createTopic(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void publishTest() {
    String messageIdsElement = "messageIdsElement-744837059";
    List<String> messageIds = Arrays.asList(messageIdsElement);
    PublishResponse expectedResponse =
        PublishResponse.newBuilder().addAllMessageIds(messageIds).build();
    mockPublisher.addResponse(expectedResponse);

    TopicName topic = TopicName.of("[PROJECT]", "[TOPIC]");
    ByteString data = ByteString.copyFromUtf8("-86");
    PubsubMessage messagesElement = PubsubMessage.newBuilder().setData(data).build();
    List<PubsubMessage> messages = Arrays.asList(messagesElement);

    PublishResponse actualResponse = client.publish(topic, messages);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PublishRequest actualRequest = (PublishRequest) actualRequests.get(0);

    Assert.assertEquals(topic, TopicName.parse(actualRequest.getTopic()));
    Assert.assertEquals(messages, actualRequest.getMessagesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void publishExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      TopicName topic = TopicName.of("[PROJECT]", "[TOPIC]");
      ByteString data = ByteString.copyFromUtf8("-86");
      PubsubMessage messagesElement = PubsubMessage.newBuilder().setData(data).build();
      List<PubsubMessage> messages = Arrays.asList(messagesElement);

      client.publish(topic, messages);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTopicTest() {
    TopicName name = TopicName.of("[PROJECT]", "[TOPIC]");
    Topic expectedResponse = Topic.newBuilder().setName(name.toString()).build();
    mockPublisher.addResponse(expectedResponse);

    TopicName topic = TopicName.of("[PROJECT]", "[TOPIC]");

    Topic actualResponse = client.getTopic(topic);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTopicRequest actualRequest = (GetTopicRequest) actualRequests.get(0);

    Assert.assertEquals(topic, TopicName.parse(actualRequest.getTopic()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getTopicExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      TopicName topic = TopicName.of("[PROJECT]", "[TOPIC]");

      client.getTopic(topic);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTopicsTest() {
    String nextPageToken = "";
    Topic topicsElement = Topic.newBuilder().build();
    List<Topic> topics = Arrays.asList(topicsElement);
    ListTopicsResponse expectedResponse =
        ListTopicsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllTopics(topics)
            .build();
    mockPublisher.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    ListTopicsPagedResponse pagedListResponse = client.listTopics(project);

    List<Topic> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTopicsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTopicsRequest actualRequest = (ListTopicsRequest) actualRequests.get(0);

    Assert.assertEquals(project, ProjectName.parse(actualRequest.getProject()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listTopicsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");

      client.listTopics(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTopicSubscriptionsTest() {
    String nextPageToken = "";
    SubscriptionName subscriptionsElement = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
    List<SubscriptionName> subscriptions = Arrays.asList(subscriptionsElement);
    ListTopicSubscriptionsResponse expectedResponse =
        ListTopicSubscriptionsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllSubscriptions(SubscriptionName.toStringList(subscriptions))
            .build();
    mockPublisher.addResponse(expectedResponse);

    TopicName topic = TopicName.of("[PROJECT]", "[TOPIC]");

    ListTopicSubscriptionsPagedResponse pagedListResponse = client.listTopicSubscriptions(topic);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscriptionsList().get(0), resources.get(0));
    List<SubscriptionName> resourceNames =
        Lists.newArrayList(pagedListResponse.iterateAllAsSubscriptionName());
    Assert.assertEquals(1, resourceNames.size());
    Assert.assertEquals(
        expectedResponse.getSubscriptionsListAsSubscriptionNameList().get(0), resourceNames.get(0));

    List<GeneratedMessageV3> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTopicSubscriptionsRequest actualRequest =
        (ListTopicSubscriptionsRequest) actualRequests.get(0);

    Assert.assertEquals(topic, TopicName.parse(actualRequest.getTopic()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listTopicSubscriptionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      TopicName topic = TopicName.of("[PROJECT]", "[TOPIC]");

      client.listTopicSubscriptions(topic);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTopicTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPublisher.addResponse(expectedResponse);

    TopicName topic = TopicName.of("[PROJECT]", "[TOPIC]");

    client.deleteTopic(topic);

    List<GeneratedMessageV3> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTopicRequest actualRequest = (DeleteTopicRequest) actualRequests.get(0);

    Assert.assertEquals(topic, TopicName.parse(actualRequest.getTopic()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTopicExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      TopicName topic = TopicName.of("[PROJECT]", "[TOPIC]");

      client.deleteTopic(topic);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockIAMPolicy.addResponse(expectedResponse);

    String formattedResource = TopicName.format("[PROJECT]", "[TOPIC]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(formattedResource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      String formattedResource = TopicName.format("[PROJECT]", "[TOPIC]");
      Policy policy = Policy.newBuilder().build();

      client.setIamPolicy(formattedResource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockIAMPolicy.addResponse(expectedResponse);

    String formattedResource = TopicName.format("[PROJECT]", "[TOPIC]");

    Policy actualResponse = client.getIamPolicy(formattedResource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      String formattedResource = TopicName.format("[PROJECT]", "[TOPIC]");

      client.getIamPolicy(formattedResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestIamPermissionsResponse expectedResponse = TestIamPermissionsResponse.newBuilder().build();
    mockIAMPolicy.addResponse(expectedResponse);

    String formattedResource = TopicName.format("[PROJECT]", "[TOPIC]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse =
        client.testIamPermissions(formattedResource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      String formattedResource = TopicName.format("[PROJECT]", "[TOPIC]");
      List<String> permissions = new ArrayList<>();

      client.testIamPermissions(formattedResource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
