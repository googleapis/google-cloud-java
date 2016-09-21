/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.pubsub.spi.v1;

import com.google.api.gax.core.PagedListResponse;
import com.google.api.gax.testing.MockGrpcService;
import com.google.api.gax.testing.MockServiceHelper;
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
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.Topic;
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
public class PublisherTest {
  private static MockPublisher mockPublisher;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockSubscriber mockSubscriber;
  private static MockServiceHelper serviceHelper;
  private PublisherApi api;

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
    PublisherSettings settings =
        PublisherSettings.defaultBuilder()
            .provideChannelWith(serviceHelper.createChannel(), true)
            .build();
    api = PublisherApi.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    api.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createTopicTest() {
    String formattedName2 = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
    Topic expectedResponse = Topic.newBuilder().setName(formattedName2).build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockPublisher.setResponses(expectedResponses);

    String formattedName = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");

    Topic actualResponse = api.createTopic(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Topic actualRequest = (Topic) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
  }

  @Test
  @SuppressWarnings("all")
  public void publishTest() {
    String messageIdsElement = "messageIdsElement-744837059";
    List<String> messageIds = Arrays.asList(messageIdsElement);
    PublishResponse expectedResponse =
        PublishResponse.newBuilder().addAllMessageIds(messageIds).build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockPublisher.setResponses(expectedResponses);

    String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
    ByteString data = ByteString.copyFromUtf8("-86");
    PubsubMessage messagesElement = PubsubMessage.newBuilder().setData(data).build();
    List<PubsubMessage> messages = Arrays.asList(messagesElement);

    PublishResponse actualResponse = api.publish(formattedTopic, messages);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PublishRequest actualRequest = (PublishRequest) actualRequests.get(0);

    Assert.assertEquals(formattedTopic, actualRequest.getTopic());
    Assert.assertEquals(messages, actualRequest.getMessagesList());
  }

  @Test
  @SuppressWarnings("all")
  public void getTopicTest() {
    String name = "name3373707";
    Topic expectedResponse = Topic.newBuilder().setName(name).build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockPublisher.setResponses(expectedResponses);

    String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");

    Topic actualResponse = api.getTopic(formattedTopic);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTopicRequest actualRequest = (GetTopicRequest) actualRequests.get(0);

    Assert.assertEquals(formattedTopic, actualRequest.getTopic());
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
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockPublisher.setResponses(expectedResponses);

    String formattedProject = PublisherApi.formatProjectName("[PROJECT]");

    PagedListResponse<ListTopicsRequest, ListTopicsResponse, Topic> pagedListResponse =
        api.listTopics(formattedProject);

    List<Topic> resources = Lists.newArrayList(pagedListResponse.iterateAllElements());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTopicsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTopicsRequest actualRequest = (ListTopicsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedProject, actualRequest.getProject());
  }

  @Test
  @SuppressWarnings("all")
  public void listTopicSubscriptionsTest() {
    String nextPageToken = "";
    String subscriptionsElement = "subscriptionsElement1698708147";
    List<String> subscriptions = Arrays.asList(subscriptionsElement);
    ListTopicSubscriptionsResponse expectedResponse =
        ListTopicSubscriptionsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllSubscriptions(subscriptions)
            .build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockPublisher.setResponses(expectedResponses);

    String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");

    PagedListResponse<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
        pagedListResponse = api.listTopicSubscriptions(formattedTopic);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAllElements());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscriptionsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTopicSubscriptionsRequest actualRequest =
        (ListTopicSubscriptionsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedTopic, actualRequest.getTopic());
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTopicTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockPublisher.setResponses(expectedResponses);

    String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");

    api.deleteTopic(formattedTopic);

    List<GeneratedMessageV3> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTopicRequest actualRequest = (DeleteTopicRequest) actualRequests.get(0);

    Assert.assertEquals(formattedTopic, actualRequest.getTopic());
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockIAMPolicy.setResponses(expectedResponses);

    String formattedResource = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = api.setIamPolicy(formattedResource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockIAMPolicy.setResponses(expectedResponses);

    String formattedResource = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");

    Policy actualResponse = api.getIamPolicy(formattedResource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestIamPermissionsResponse expectedResponse = TestIamPermissionsResponse.newBuilder().build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockIAMPolicy.setResponses(expectedResponses);

    String formattedResource = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse =
        api.testIamPermissions(formattedResource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
  }
}
