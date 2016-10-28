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

import static com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListSubscriptionsPagedResponse;

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
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.DeleteSubscriptionRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.ModifyPushConfigRequest;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.Subscription;
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
public class SubscriberTest {
  private static MockPublisher mockPublisher;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockSubscriber mockSubscriber;
  private static MockServiceHelper serviceHelper;
  private SubscriberApi api;

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
    SubscriberSettings settings =
        SubscriberSettings.defaultBuilder()
            .provideChannelWith(serviceHelper.createChannel(), true)
            .build();
    api = SubscriberApi.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    api.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createSubscriptionTest() {
    String formattedName2 = SubscriberApi.formatSubscriptionName("[PROJECT]", "[SUBSCRIPTION]");
    String formattedTopic2 = SubscriberApi.formatTopicName("[PROJECT]", "[TOPIC]");
    int ackDeadlineSeconds2 = -921632575;
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(formattedName2)
            .setTopic(formattedTopic2)
            .setAckDeadlineSeconds(ackDeadlineSeconds2)
            .build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockSubscriber.setResponses(expectedResponses);

    String formattedName = SubscriberApi.formatSubscriptionName("[PROJECT]", "[SUBSCRIPTION]");
    String formattedTopic = SubscriberApi.formatTopicName("[PROJECT]", "[TOPIC]");
    PushConfig pushConfig = PushConfig.newBuilder().build();
    int ackDeadlineSeconds = 2135351438;

    Subscription actualResponse =
        api.createSubscription(formattedName, formattedTopic, pushConfig, ackDeadlineSeconds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Subscription actualRequest = (Subscription) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(formattedTopic, actualRequest.getTopic());
    Assert.assertEquals(pushConfig, actualRequest.getPushConfig());
    Assert.assertEquals(ackDeadlineSeconds, actualRequest.getAckDeadlineSeconds());
  }

  @Test
  @SuppressWarnings("all")
  public void getSubscriptionTest() {
    String name = "name3373707";
    String topic = "topic110546223";
    int ackDeadlineSeconds = 2135351438;
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(name)
            .setTopic(topic)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockSubscriber.setResponses(expectedResponses);

    String formattedSubscription =
        SubscriberApi.formatSubscriptionName("[PROJECT]", "[SUBSCRIPTION]");

    Subscription actualResponse = api.getSubscription(formattedSubscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSubscriptionRequest actualRequest = (GetSubscriptionRequest) actualRequests.get(0);

    Assert.assertEquals(formattedSubscription, actualRequest.getSubscription());
  }

  @Test
  @SuppressWarnings("all")
  public void listSubscriptionsTest() {
    String nextPageToken = "";
    Subscription subscriptionsElement = Subscription.newBuilder().build();
    List<Subscription> subscriptions = Arrays.asList(subscriptionsElement);
    ListSubscriptionsResponse expectedResponse =
        ListSubscriptionsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllSubscriptions(subscriptions)
            .build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockSubscriber.setResponses(expectedResponses);

    String formattedProject = SubscriberApi.formatProjectName("[PROJECT]");

    ListSubscriptionsPagedResponse pagedListResponse = api.listSubscriptions(formattedProject);

    List<Subscription> resources = Lists.newArrayList(pagedListResponse.iterateAllElements());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscriptionsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSubscriptionsRequest actualRequest = (ListSubscriptionsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedProject, actualRequest.getProject());
  }

  @Test
  @SuppressWarnings("all")
  public void deleteSubscriptionTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockSubscriber.setResponses(expectedResponses);

    String formattedSubscription =
        SubscriberApi.formatSubscriptionName("[PROJECT]", "[SUBSCRIPTION]");

    api.deleteSubscription(formattedSubscription);

    List<GeneratedMessageV3> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSubscriptionRequest actualRequest = (DeleteSubscriptionRequest) actualRequests.get(0);

    Assert.assertEquals(formattedSubscription, actualRequest.getSubscription());
  }

  @Test
  @SuppressWarnings("all")
  public void modifyAckDeadlineTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockSubscriber.setResponses(expectedResponses);

    String formattedSubscription =
        SubscriberApi.formatSubscriptionName("[PROJECT]", "[SUBSCRIPTION]");
    List<String> ackIds = new ArrayList<>();
    int ackDeadlineSeconds = 2135351438;

    api.modifyAckDeadline(formattedSubscription, ackIds, ackDeadlineSeconds);

    List<GeneratedMessageV3> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ModifyAckDeadlineRequest actualRequest = (ModifyAckDeadlineRequest) actualRequests.get(0);

    Assert.assertEquals(formattedSubscription, actualRequest.getSubscription());
    Assert.assertEquals(ackIds, actualRequest.getAckIdsList());
    Assert.assertEquals(ackDeadlineSeconds, actualRequest.getAckDeadlineSeconds());
  }

  @Test
  @SuppressWarnings("all")
  public void acknowledgeTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockSubscriber.setResponses(expectedResponses);

    String formattedSubscription =
        SubscriberApi.formatSubscriptionName("[PROJECT]", "[SUBSCRIPTION]");
    List<String> ackIds = new ArrayList<>();

    api.acknowledge(formattedSubscription, ackIds);

    List<GeneratedMessageV3> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AcknowledgeRequest actualRequest = (AcknowledgeRequest) actualRequests.get(0);

    Assert.assertEquals(formattedSubscription, actualRequest.getSubscription());
    Assert.assertEquals(ackIds, actualRequest.getAckIdsList());
  }

  @Test
  @SuppressWarnings("all")
  public void pullTest() {
    PullResponse expectedResponse = PullResponse.newBuilder().build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockSubscriber.setResponses(expectedResponses);

    String formattedSubscription =
        SubscriberApi.formatSubscriptionName("[PROJECT]", "[SUBSCRIPTION]");
    boolean returnImmediately = false;
    int maxMessages = 496131527;

    PullResponse actualResponse = api.pull(formattedSubscription, returnImmediately, maxMessages);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PullRequest actualRequest = (PullRequest) actualRequests.get(0);

    Assert.assertEquals(formattedSubscription, actualRequest.getSubscription());
    Assert.assertEquals(returnImmediately, actualRequest.getReturnImmediately());
    Assert.assertEquals(maxMessages, actualRequest.getMaxMessages());
  }

  @Test
  @SuppressWarnings("all")
  public void modifyPushConfigTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockSubscriber.setResponses(expectedResponses);

    String formattedSubscription =
        SubscriberApi.formatSubscriptionName("[PROJECT]", "[SUBSCRIPTION]");
    PushConfig pushConfig = PushConfig.newBuilder().build();

    api.modifyPushConfig(formattedSubscription, pushConfig);

    List<GeneratedMessageV3> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ModifyPushConfigRequest actualRequest = (ModifyPushConfigRequest) actualRequests.get(0);

    Assert.assertEquals(formattedSubscription, actualRequest.getSubscription());
    Assert.assertEquals(pushConfig, actualRequest.getPushConfig());
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

    String formattedResource = SubscriberApi.formatSubscriptionName("[PROJECT]", "[SUBSCRIPTION]");
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

    String formattedResource = SubscriberApi.formatSubscriptionName("[PROJECT]", "[SUBSCRIPTION]");

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

    String formattedResource = SubscriberApi.formatSubscriptionName("[PROJECT]", "[SUBSCRIPTION]");
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
