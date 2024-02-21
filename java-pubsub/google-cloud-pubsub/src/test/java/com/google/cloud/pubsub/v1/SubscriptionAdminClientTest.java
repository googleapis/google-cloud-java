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

package com.google.cloud.pubsub.v1;

import static com.google.cloud.pubsub.v1.SubscriptionAdminClient.ListSnapshotsPagedResponse;
import static com.google.cloud.pubsub.v1.SubscriptionAdminClient.ListSubscriptionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.BigQueryConfig;
import com.google.pubsub.v1.CloudStorageConfig;
import com.google.pubsub.v1.CreateSnapshotRequest;
import com.google.pubsub.v1.DeadLetterPolicy;
import com.google.pubsub.v1.DeleteSnapshotRequest;
import com.google.pubsub.v1.DeleteSubscriptionRequest;
import com.google.pubsub.v1.ExpirationPolicy;
import com.google.pubsub.v1.GetSnapshotRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.ListSnapshotsRequest;
import com.google.pubsub.v1.ListSnapshotsResponse;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.ModifyPushConfigRequest;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.ReceivedMessage;
import com.google.pubsub.v1.RetryPolicy;
import com.google.pubsub.v1.SchemaName;
import com.google.pubsub.v1.SeekRequest;
import com.google.pubsub.v1.SeekResponse;
import com.google.pubsub.v1.Snapshot;
import com.google.pubsub.v1.SnapshotName;
import com.google.pubsub.v1.StreamingPullRequest;
import com.google.pubsub.v1.StreamingPullResponse;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.TopicName;
import com.google.pubsub.v1.UpdateSnapshotRequest;
import com.google.pubsub.v1.UpdateSubscriptionRequest;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class SubscriptionAdminClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockServiceHelper mockServiceHelper;
  private static MockSubscriber mockSubscriber;
  private LocalChannelProvider channelProvider;
  private SubscriptionAdminClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSubscriber = new MockSubscriber();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSubscriber, mockIAMPolicy));
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
    SubscriptionAdminSettings settings =
        SubscriptionAdminSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SubscriptionAdminClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createSubscriptionTest() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
            .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .setPushConfig(PushConfig.newBuilder().build())
            .setBigqueryConfig(BigQueryConfig.newBuilder().build())
            .setCloudStorageConfig(CloudStorageConfig.newBuilder().build())
            .setAckDeadlineSeconds(2135351438)
            .setRetainAckedMessages(true)
            .setMessageRetentionDuration(Duration.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEnableMessageOrdering(true)
            .setExpirationPolicy(ExpirationPolicy.newBuilder().build())
            .setFilter("filter-1274492040")
            .setDeadLetterPolicy(DeadLetterPolicy.newBuilder().build())
            .setRetryPolicy(RetryPolicy.newBuilder().build())
            .setDetached(true)
            .setEnableExactlyOnceDelivery(true)
            .setTopicMessageRetentionDuration(Duration.newBuilder().build())
            .build();
    mockSubscriber.addResponse(expectedResponse);

    SubscriptionName name = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
    TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
    PushConfig pushConfig = PushConfig.newBuilder().build();
    int ackDeadlineSeconds = 2135351438;

    Subscription actualResponse =
        client.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Subscription actualRequest = ((Subscription) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(topic.toString(), actualRequest.getTopic());
    Assert.assertEquals(pushConfig, actualRequest.getPushConfig());
    Assert.assertEquals(ackDeadlineSeconds, actualRequest.getAckDeadlineSeconds());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      SubscriptionName name = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
      TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
      PushConfig pushConfig = PushConfig.newBuilder().build();
      int ackDeadlineSeconds = 2135351438;
      client.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSubscriptionTest2() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
            .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .setPushConfig(PushConfig.newBuilder().build())
            .setBigqueryConfig(BigQueryConfig.newBuilder().build())
            .setCloudStorageConfig(CloudStorageConfig.newBuilder().build())
            .setAckDeadlineSeconds(2135351438)
            .setRetainAckedMessages(true)
            .setMessageRetentionDuration(Duration.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEnableMessageOrdering(true)
            .setExpirationPolicy(ExpirationPolicy.newBuilder().build())
            .setFilter("filter-1274492040")
            .setDeadLetterPolicy(DeadLetterPolicy.newBuilder().build())
            .setRetryPolicy(RetryPolicy.newBuilder().build())
            .setDetached(true)
            .setEnableExactlyOnceDelivery(true)
            .setTopicMessageRetentionDuration(Duration.newBuilder().build())
            .build();
    mockSubscriber.addResponse(expectedResponse);

    SubscriptionName name = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
    String topic = "topic110546223";
    PushConfig pushConfig = PushConfig.newBuilder().build();
    int ackDeadlineSeconds = 2135351438;

    Subscription actualResponse =
        client.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Subscription actualRequest = ((Subscription) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(topic, actualRequest.getTopic());
    Assert.assertEquals(pushConfig, actualRequest.getPushConfig());
    Assert.assertEquals(ackDeadlineSeconds, actualRequest.getAckDeadlineSeconds());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      SubscriptionName name = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
      String topic = "topic110546223";
      PushConfig pushConfig = PushConfig.newBuilder().build();
      int ackDeadlineSeconds = 2135351438;
      client.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSubscriptionTest3() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
            .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .setPushConfig(PushConfig.newBuilder().build())
            .setBigqueryConfig(BigQueryConfig.newBuilder().build())
            .setCloudStorageConfig(CloudStorageConfig.newBuilder().build())
            .setAckDeadlineSeconds(2135351438)
            .setRetainAckedMessages(true)
            .setMessageRetentionDuration(Duration.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEnableMessageOrdering(true)
            .setExpirationPolicy(ExpirationPolicy.newBuilder().build())
            .setFilter("filter-1274492040")
            .setDeadLetterPolicy(DeadLetterPolicy.newBuilder().build())
            .setRetryPolicy(RetryPolicy.newBuilder().build())
            .setDetached(true)
            .setEnableExactlyOnceDelivery(true)
            .setTopicMessageRetentionDuration(Duration.newBuilder().build())
            .build();
    mockSubscriber.addResponse(expectedResponse);

    String name = "name3373707";
    TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
    PushConfig pushConfig = PushConfig.newBuilder().build();
    int ackDeadlineSeconds = 2135351438;

    Subscription actualResponse =
        client.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Subscription actualRequest = ((Subscription) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(topic.toString(), actualRequest.getTopic());
    Assert.assertEquals(pushConfig, actualRequest.getPushConfig());
    Assert.assertEquals(ackDeadlineSeconds, actualRequest.getAckDeadlineSeconds());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSubscriptionExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      String name = "name3373707";
      TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
      PushConfig pushConfig = PushConfig.newBuilder().build();
      int ackDeadlineSeconds = 2135351438;
      client.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSubscriptionTest4() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
            .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .setPushConfig(PushConfig.newBuilder().build())
            .setBigqueryConfig(BigQueryConfig.newBuilder().build())
            .setCloudStorageConfig(CloudStorageConfig.newBuilder().build())
            .setAckDeadlineSeconds(2135351438)
            .setRetainAckedMessages(true)
            .setMessageRetentionDuration(Duration.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEnableMessageOrdering(true)
            .setExpirationPolicy(ExpirationPolicy.newBuilder().build())
            .setFilter("filter-1274492040")
            .setDeadLetterPolicy(DeadLetterPolicy.newBuilder().build())
            .setRetryPolicy(RetryPolicy.newBuilder().build())
            .setDetached(true)
            .setEnableExactlyOnceDelivery(true)
            .setTopicMessageRetentionDuration(Duration.newBuilder().build())
            .build();
    mockSubscriber.addResponse(expectedResponse);

    String name = "name3373707";
    String topic = "topic110546223";
    PushConfig pushConfig = PushConfig.newBuilder().build();
    int ackDeadlineSeconds = 2135351438;

    Subscription actualResponse =
        client.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Subscription actualRequest = ((Subscription) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(topic, actualRequest.getTopic());
    Assert.assertEquals(pushConfig, actualRequest.getPushConfig());
    Assert.assertEquals(ackDeadlineSeconds, actualRequest.getAckDeadlineSeconds());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSubscriptionExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      String name = "name3373707";
      String topic = "topic110546223";
      PushConfig pushConfig = PushConfig.newBuilder().build();
      int ackDeadlineSeconds = 2135351438;
      client.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSubscriptionTest() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
            .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .setPushConfig(PushConfig.newBuilder().build())
            .setBigqueryConfig(BigQueryConfig.newBuilder().build())
            .setCloudStorageConfig(CloudStorageConfig.newBuilder().build())
            .setAckDeadlineSeconds(2135351438)
            .setRetainAckedMessages(true)
            .setMessageRetentionDuration(Duration.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEnableMessageOrdering(true)
            .setExpirationPolicy(ExpirationPolicy.newBuilder().build())
            .setFilter("filter-1274492040")
            .setDeadLetterPolicy(DeadLetterPolicy.newBuilder().build())
            .setRetryPolicy(RetryPolicy.newBuilder().build())
            .setDetached(true)
            .setEnableExactlyOnceDelivery(true)
            .setTopicMessageRetentionDuration(Duration.newBuilder().build())
            .build();
    mockSubscriber.addResponse(expectedResponse);

    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");

    Subscription actualResponse = client.getSubscription(subscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSubscriptionRequest actualRequest = ((GetSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(subscription.toString(), actualRequest.getSubscription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
      client.getSubscription(subscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSubscriptionTest2() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
            .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .setPushConfig(PushConfig.newBuilder().build())
            .setBigqueryConfig(BigQueryConfig.newBuilder().build())
            .setCloudStorageConfig(CloudStorageConfig.newBuilder().build())
            .setAckDeadlineSeconds(2135351438)
            .setRetainAckedMessages(true)
            .setMessageRetentionDuration(Duration.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEnableMessageOrdering(true)
            .setExpirationPolicy(ExpirationPolicy.newBuilder().build())
            .setFilter("filter-1274492040")
            .setDeadLetterPolicy(DeadLetterPolicy.newBuilder().build())
            .setRetryPolicy(RetryPolicy.newBuilder().build())
            .setDetached(true)
            .setEnableExactlyOnceDelivery(true)
            .setTopicMessageRetentionDuration(Duration.newBuilder().build())
            .build();
    mockSubscriber.addResponse(expectedResponse);

    String subscription = "subscription341203229";

    Subscription actualResponse = client.getSubscription(subscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSubscriptionRequest actualRequest = ((GetSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(subscription, actualRequest.getSubscription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      String subscription = "subscription341203229";
      client.getSubscription(subscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSubscriptionTest() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
            .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .setPushConfig(PushConfig.newBuilder().build())
            .setBigqueryConfig(BigQueryConfig.newBuilder().build())
            .setCloudStorageConfig(CloudStorageConfig.newBuilder().build())
            .setAckDeadlineSeconds(2135351438)
            .setRetainAckedMessages(true)
            .setMessageRetentionDuration(Duration.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEnableMessageOrdering(true)
            .setExpirationPolicy(ExpirationPolicy.newBuilder().build())
            .setFilter("filter-1274492040")
            .setDeadLetterPolicy(DeadLetterPolicy.newBuilder().build())
            .setRetryPolicy(RetryPolicy.newBuilder().build())
            .setDetached(true)
            .setEnableExactlyOnceDelivery(true)
            .setTopicMessageRetentionDuration(Duration.newBuilder().build())
            .build();
    mockSubscriber.addResponse(expectedResponse);

    Subscription subscription = Subscription.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Subscription actualResponse = client.updateSubscription(subscription, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
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
    mockSubscriber.addException(exception);

    try {
      Subscription subscription = Subscription.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSubscription(subscription, updateMask);
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
    mockSubscriber.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    ListSubscriptionsPagedResponse pagedListResponse = client.listSubscriptions(project);

    List<Subscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscriptionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSubscriptionsRequest actualRequest = ((ListSubscriptionsRequest) actualRequests.get(0));

    Assert.assertEquals(project.toString(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSubscriptionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");
      client.listSubscriptions(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubscriptionsTest2() throws Exception {
    Subscription responsesElement = Subscription.newBuilder().build();
    ListSubscriptionsResponse expectedResponse =
        ListSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockSubscriber.addResponse(expectedResponse);

    String project = "project-309310695";

    ListSubscriptionsPagedResponse pagedListResponse = client.listSubscriptions(project);

    List<Subscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscriptionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSubscriptionsRequest actualRequest = ((ListSubscriptionsRequest) actualRequests.get(0));

    Assert.assertEquals(project, actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSubscriptionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      String project = "project-309310695";
      client.listSubscriptions(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSubscriptionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSubscriber.addResponse(expectedResponse);

    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");

    client.deleteSubscription(subscription);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSubscriptionRequest actualRequest = ((DeleteSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(subscription.toString(), actualRequest.getSubscription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
      client.deleteSubscription(subscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSubscriptionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSubscriber.addResponse(expectedResponse);

    String subscription = "subscription341203229";

    client.deleteSubscription(subscription);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSubscriptionRequest actualRequest = ((DeleteSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(subscription, actualRequest.getSubscription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      String subscription = "subscription341203229";
      client.deleteSubscription(subscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void modifyAckDeadlineTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSubscriber.addResponse(expectedResponse);

    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
    List<String> ackIds = new ArrayList<>();
    int ackDeadlineSeconds = 2135351438;

    client.modifyAckDeadline(subscription, ackIds, ackDeadlineSeconds);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ModifyAckDeadlineRequest actualRequest = ((ModifyAckDeadlineRequest) actualRequests.get(0));

    Assert.assertEquals(subscription.toString(), actualRequest.getSubscription());
    Assert.assertEquals(ackIds, actualRequest.getAckIdsList());
    Assert.assertEquals(ackDeadlineSeconds, actualRequest.getAckDeadlineSeconds());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void modifyAckDeadlineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
      List<String> ackIds = new ArrayList<>();
      int ackDeadlineSeconds = 2135351438;
      client.modifyAckDeadline(subscription, ackIds, ackDeadlineSeconds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void modifyAckDeadlineTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSubscriber.addResponse(expectedResponse);

    String subscription = "subscription341203229";
    List<String> ackIds = new ArrayList<>();
    int ackDeadlineSeconds = 2135351438;

    client.modifyAckDeadline(subscription, ackIds, ackDeadlineSeconds);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ModifyAckDeadlineRequest actualRequest = ((ModifyAckDeadlineRequest) actualRequests.get(0));

    Assert.assertEquals(subscription, actualRequest.getSubscription());
    Assert.assertEquals(ackIds, actualRequest.getAckIdsList());
    Assert.assertEquals(ackDeadlineSeconds, actualRequest.getAckDeadlineSeconds());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void modifyAckDeadlineExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      String subscription = "subscription341203229";
      List<String> ackIds = new ArrayList<>();
      int ackDeadlineSeconds = 2135351438;
      client.modifyAckDeadline(subscription, ackIds, ackDeadlineSeconds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void acknowledgeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSubscriber.addResponse(expectedResponse);

    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
    List<String> ackIds = new ArrayList<>();

    client.acknowledge(subscription, ackIds);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AcknowledgeRequest actualRequest = ((AcknowledgeRequest) actualRequests.get(0));

    Assert.assertEquals(subscription.toString(), actualRequest.getSubscription());
    Assert.assertEquals(ackIds, actualRequest.getAckIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void acknowledgeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
      List<String> ackIds = new ArrayList<>();
      client.acknowledge(subscription, ackIds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void acknowledgeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSubscriber.addResponse(expectedResponse);

    String subscription = "subscription341203229";
    List<String> ackIds = new ArrayList<>();

    client.acknowledge(subscription, ackIds);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AcknowledgeRequest actualRequest = ((AcknowledgeRequest) actualRequests.get(0));

    Assert.assertEquals(subscription, actualRequest.getSubscription());
    Assert.assertEquals(ackIds, actualRequest.getAckIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void acknowledgeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      String subscription = "subscription341203229";
      List<String> ackIds = new ArrayList<>();
      client.acknowledge(subscription, ackIds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pullTest() throws Exception {
    PullResponse expectedResponse =
        PullResponse.newBuilder().addAllReceivedMessages(new ArrayList<ReceivedMessage>()).build();
    mockSubscriber.addResponse(expectedResponse);

    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
    int maxMessages = 496131527;

    PullResponse actualResponse = client.pull(subscription, maxMessages);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PullRequest actualRequest = ((PullRequest) actualRequests.get(0));

    Assert.assertEquals(subscription.toString(), actualRequest.getSubscription());
    Assert.assertEquals(maxMessages, actualRequest.getMaxMessages());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pullExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
      int maxMessages = 496131527;
      client.pull(subscription, maxMessages);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pullTest2() throws Exception {
    PullResponse expectedResponse =
        PullResponse.newBuilder().addAllReceivedMessages(new ArrayList<ReceivedMessage>()).build();
    mockSubscriber.addResponse(expectedResponse);

    String subscription = "subscription341203229";
    int maxMessages = 496131527;

    PullResponse actualResponse = client.pull(subscription, maxMessages);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PullRequest actualRequest = ((PullRequest) actualRequests.get(0));

    Assert.assertEquals(subscription, actualRequest.getSubscription());
    Assert.assertEquals(maxMessages, actualRequest.getMaxMessages());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pullExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      String subscription = "subscription341203229";
      int maxMessages = 496131527;
      client.pull(subscription, maxMessages);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pullTest3() throws Exception {
    PullResponse expectedResponse =
        PullResponse.newBuilder().addAllReceivedMessages(new ArrayList<ReceivedMessage>()).build();
    mockSubscriber.addResponse(expectedResponse);

    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
    boolean returnImmediately = true;
    int maxMessages = 496131527;

    PullResponse actualResponse = client.pull(subscription, returnImmediately, maxMessages);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PullRequest actualRequest = ((PullRequest) actualRequests.get(0));

    Assert.assertEquals(subscription.toString(), actualRequest.getSubscription());
    Assert.assertEquals(returnImmediately, actualRequest.getReturnImmediately());
    Assert.assertEquals(maxMessages, actualRequest.getMaxMessages());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pullExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
      boolean returnImmediately = true;
      int maxMessages = 496131527;
      client.pull(subscription, returnImmediately, maxMessages);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pullTest4() throws Exception {
    PullResponse expectedResponse =
        PullResponse.newBuilder().addAllReceivedMessages(new ArrayList<ReceivedMessage>()).build();
    mockSubscriber.addResponse(expectedResponse);

    String subscription = "subscription341203229";
    boolean returnImmediately = true;
    int maxMessages = 496131527;

    PullResponse actualResponse = client.pull(subscription, returnImmediately, maxMessages);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PullRequest actualRequest = ((PullRequest) actualRequests.get(0));

    Assert.assertEquals(subscription, actualRequest.getSubscription());
    Assert.assertEquals(returnImmediately, actualRequest.getReturnImmediately());
    Assert.assertEquals(maxMessages, actualRequest.getMaxMessages());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pullExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      String subscription = "subscription341203229";
      boolean returnImmediately = true;
      int maxMessages = 496131527;
      client.pull(subscription, returnImmediately, maxMessages);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void streamingPullTest() throws Exception {
    StreamingPullResponse expectedResponse =
        StreamingPullResponse.newBuilder()
            .addAllReceivedMessages(new ArrayList<ReceivedMessage>())
            .setAcknowledgeConfirmation(
                StreamingPullResponse.AcknowledgeConfirmation.newBuilder().build())
            .setModifyAckDeadlineConfirmation(
                StreamingPullResponse.ModifyAckDeadlineConfirmation.newBuilder().build())
            .setSubscriptionProperties(
                StreamingPullResponse.SubscriptionProperties.newBuilder().build())
            .build();
    mockSubscriber.addResponse(expectedResponse);
    StreamingPullRequest request =
        StreamingPullRequest.newBuilder()
            .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
            .addAllAckIds(new ArrayList<String>())
            .addAllModifyDeadlineSeconds(new ArrayList<Integer>())
            .addAllModifyDeadlineAckIds(new ArrayList<String>())
            .setStreamAckDeadlineSeconds(1875467245)
            .setClientId("clientId908408390")
            .setMaxOutstandingMessages(-1315266996)
            .setMaxOutstandingBytes(-2103098517)
            .build();

    MockStreamObserver<StreamingPullResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<StreamingPullRequest, StreamingPullResponse> callable =
        client.streamingPullCallable();
    ApiStreamObserver<StreamingPullRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<StreamingPullResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamingPullExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);
    StreamingPullRequest request =
        StreamingPullRequest.newBuilder()
            .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
            .addAllAckIds(new ArrayList<String>())
            .addAllModifyDeadlineSeconds(new ArrayList<Integer>())
            .addAllModifyDeadlineAckIds(new ArrayList<String>())
            .setStreamAckDeadlineSeconds(1875467245)
            .setClientId("clientId908408390")
            .setMaxOutstandingMessages(-1315266996)
            .setMaxOutstandingBytes(-2103098517)
            .build();

    MockStreamObserver<StreamingPullResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<StreamingPullRequest, StreamingPullResponse> callable =
        client.streamingPullCallable();
    ApiStreamObserver<StreamingPullRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<StreamingPullResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void modifyPushConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSubscriber.addResponse(expectedResponse);

    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
    PushConfig pushConfig = PushConfig.newBuilder().build();

    client.modifyPushConfig(subscription, pushConfig);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ModifyPushConfigRequest actualRequest = ((ModifyPushConfigRequest) actualRequests.get(0));

    Assert.assertEquals(subscription.toString(), actualRequest.getSubscription());
    Assert.assertEquals(pushConfig, actualRequest.getPushConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void modifyPushConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
      PushConfig pushConfig = PushConfig.newBuilder().build();
      client.modifyPushConfig(subscription, pushConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void modifyPushConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSubscriber.addResponse(expectedResponse);

    String subscription = "subscription341203229";
    PushConfig pushConfig = PushConfig.newBuilder().build();

    client.modifyPushConfig(subscription, pushConfig);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ModifyPushConfigRequest actualRequest = ((ModifyPushConfigRequest) actualRequests.get(0));

    Assert.assertEquals(subscription, actualRequest.getSubscription());
    Assert.assertEquals(pushConfig, actualRequest.getPushConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void modifyPushConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      String subscription = "subscription341203229";
      PushConfig pushConfig = PushConfig.newBuilder().build();
      client.modifyPushConfig(subscription, pushConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSnapshotTest() throws Exception {
    Snapshot expectedResponse =
        Snapshot.newBuilder()
            .setName(SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString())
            .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockSubscriber.addResponse(expectedResponse);

    SnapshotName snapshot = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");

    Snapshot actualResponse = client.getSnapshot(snapshot);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSnapshotRequest actualRequest = ((GetSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(snapshot.toString(), actualRequest.getSnapshot());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSnapshotExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      SnapshotName snapshot = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");
      client.getSnapshot(snapshot);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSnapshotTest2() throws Exception {
    Snapshot expectedResponse =
        Snapshot.newBuilder()
            .setName(SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString())
            .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockSubscriber.addResponse(expectedResponse);

    String snapshot = "snapshot284874180";

    Snapshot actualResponse = client.getSnapshot(snapshot);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSnapshotRequest actualRequest = ((GetSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(snapshot, actualRequest.getSnapshot());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSnapshotExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      String snapshot = "snapshot284874180";
      client.getSnapshot(snapshot);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSnapshotsTest() throws Exception {
    Snapshot responsesElement = Snapshot.newBuilder().build();
    ListSnapshotsResponse expectedResponse =
        ListSnapshotsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSnapshots(Arrays.asList(responsesElement))
            .build();
    mockSubscriber.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    ListSnapshotsPagedResponse pagedListResponse = client.listSnapshots(project);

    List<Snapshot> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSnapshotsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSnapshotsRequest actualRequest = ((ListSnapshotsRequest) actualRequests.get(0));

    Assert.assertEquals(project.toString(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSnapshotsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");
      client.listSnapshots(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSnapshotsTest2() throws Exception {
    Snapshot responsesElement = Snapshot.newBuilder().build();
    ListSnapshotsResponse expectedResponse =
        ListSnapshotsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSnapshots(Arrays.asList(responsesElement))
            .build();
    mockSubscriber.addResponse(expectedResponse);

    String project = "project-309310695";

    ListSnapshotsPagedResponse pagedListResponse = client.listSnapshots(project);

    List<Snapshot> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSnapshotsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSnapshotsRequest actualRequest = ((ListSnapshotsRequest) actualRequests.get(0));

    Assert.assertEquals(project, actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSnapshotsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      String project = "project-309310695";
      client.listSnapshots(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSnapshotTest() throws Exception {
    Snapshot expectedResponse =
        Snapshot.newBuilder()
            .setName(SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString())
            .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockSubscriber.addResponse(expectedResponse);

    SnapshotName name = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");
    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");

    Snapshot actualResponse = client.createSnapshot(name, subscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSnapshotRequest actualRequest = ((CreateSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(subscription.toString(), actualRequest.getSubscription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSnapshotExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      SnapshotName name = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");
      SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
      client.createSnapshot(name, subscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSnapshotTest2() throws Exception {
    Snapshot expectedResponse =
        Snapshot.newBuilder()
            .setName(SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString())
            .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockSubscriber.addResponse(expectedResponse);

    SnapshotName name = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");
    String subscription = "subscription341203229";

    Snapshot actualResponse = client.createSnapshot(name, subscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSnapshotRequest actualRequest = ((CreateSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(subscription, actualRequest.getSubscription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSnapshotExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      SnapshotName name = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");
      String subscription = "subscription341203229";
      client.createSnapshot(name, subscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSnapshotTest3() throws Exception {
    Snapshot expectedResponse =
        Snapshot.newBuilder()
            .setName(SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString())
            .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockSubscriber.addResponse(expectedResponse);

    String name = "name3373707";
    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");

    Snapshot actualResponse = client.createSnapshot(name, subscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSnapshotRequest actualRequest = ((CreateSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(subscription.toString(), actualRequest.getSubscription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSnapshotExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      String name = "name3373707";
      SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
      client.createSnapshot(name, subscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSnapshotTest4() throws Exception {
    Snapshot expectedResponse =
        Snapshot.newBuilder()
            .setName(SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString())
            .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockSubscriber.addResponse(expectedResponse);

    String name = "name3373707";
    String subscription = "subscription341203229";

    Snapshot actualResponse = client.createSnapshot(name, subscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSnapshotRequest actualRequest = ((CreateSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(subscription, actualRequest.getSubscription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSnapshotExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      String name = "name3373707";
      String subscription = "subscription341203229";
      client.createSnapshot(name, subscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSnapshotTest() throws Exception {
    Snapshot expectedResponse =
        Snapshot.newBuilder()
            .setName(SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString())
            .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockSubscriber.addResponse(expectedResponse);

    Snapshot snapshot = Snapshot.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Snapshot actualResponse = client.updateSnapshot(snapshot, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSnapshotRequest actualRequest = ((UpdateSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(snapshot, actualRequest.getSnapshot());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSnapshotExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      Snapshot snapshot = Snapshot.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSnapshot(snapshot, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSnapshotTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSubscriber.addResponse(expectedResponse);

    SnapshotName snapshot = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");

    client.deleteSnapshot(snapshot);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSnapshotRequest actualRequest = ((DeleteSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(snapshot.toString(), actualRequest.getSnapshot());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSnapshotExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      SnapshotName snapshot = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");
      client.deleteSnapshot(snapshot);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSnapshotTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSubscriber.addResponse(expectedResponse);

    String snapshot = "snapshot284874180";

    client.deleteSnapshot(snapshot);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSnapshotRequest actualRequest = ((DeleteSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(snapshot, actualRequest.getSnapshot());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSnapshotExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      String snapshot = "snapshot284874180";
      client.deleteSnapshot(snapshot);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void seekTest() throws Exception {
    SeekResponse expectedResponse = SeekResponse.newBuilder().build();
    mockSubscriber.addResponse(expectedResponse);

    SeekRequest request =
        SeekRequest.newBuilder()
            .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
            .build();

    SeekResponse actualResponse = client.seek(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSubscriber.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SeekRequest actualRequest = ((SeekRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSubscription(), actualRequest.getSubscription());
    Assert.assertEquals(request.getTime(), actualRequest.getTime());
    Assert.assertEquals(request.getSnapshot(), actualRequest.getSnapshot());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void seekExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSubscriber.addException(exception);

    try {
      SeekRequest request =
          SeekRequest.newBuilder()
              .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
              .build();
      client.seek(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
