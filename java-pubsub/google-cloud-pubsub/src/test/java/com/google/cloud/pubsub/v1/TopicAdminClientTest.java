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

import static com.google.cloud.pubsub.v1.TopicAdminClient.ListTopicSnapshotsPagedResponse;
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
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.DetachSubscriptionRequest;
import com.google.pubsub.v1.DetachSubscriptionResponse;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.IngestionDataSourceSettings;
import com.google.pubsub.v1.ListTopicSnapshotsRequest;
import com.google.pubsub.v1.ListTopicSnapshotsResponse;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.MessageStoragePolicy;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.SchemaName;
import com.google.pubsub.v1.SchemaSettings;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import com.google.pubsub.v1.UpdateTopicRequest;
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
public class TopicAdminClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockPublisher mockPublisher;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private TopicAdminClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPublisher = new MockPublisher();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockPublisher, mockIAMPolicy));
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
  public void createTopicTest() throws Exception {
    Topic expectedResponse =
        Topic.newBuilder()
            .setName(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setMessageStoragePolicy(MessageStoragePolicy.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .setSchemaSettings(SchemaSettings.newBuilder().build())
            .setSatisfiesPzs(true)
            .setMessageRetentionDuration(Duration.newBuilder().build())
            .setIngestionDataSourceSettings(IngestionDataSourceSettings.newBuilder().build())
            .build();
    mockPublisher.addResponse(expectedResponse);

    TopicName name = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");

    Topic actualResponse = client.createTopic(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Topic actualRequest = ((Topic) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTopicExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      TopicName name = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
      client.createTopic(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTopicTest2() throws Exception {
    Topic expectedResponse =
        Topic.newBuilder()
            .setName(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setMessageStoragePolicy(MessageStoragePolicy.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .setSchemaSettings(SchemaSettings.newBuilder().build())
            .setSatisfiesPzs(true)
            .setMessageRetentionDuration(Duration.newBuilder().build())
            .setIngestionDataSourceSettings(IngestionDataSourceSettings.newBuilder().build())
            .build();
    mockPublisher.addResponse(expectedResponse);

    String name = "name3373707";

    Topic actualResponse = client.createTopic(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Topic actualRequest = ((Topic) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTopicExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      String name = "name3373707";
      client.createTopic(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTopicTest() throws Exception {
    Topic expectedResponse =
        Topic.newBuilder()
            .setName(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setMessageStoragePolicy(MessageStoragePolicy.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .setSchemaSettings(SchemaSettings.newBuilder().build())
            .setSatisfiesPzs(true)
            .setMessageRetentionDuration(Duration.newBuilder().build())
            .setIngestionDataSourceSettings(IngestionDataSourceSettings.newBuilder().build())
            .build();
    mockPublisher.addResponse(expectedResponse);

    Topic topic = Topic.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Topic actualResponse = client.updateTopic(topic, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTopicRequest actualRequest = ((UpdateTopicRequest) actualRequests.get(0));

    Assert.assertEquals(topic, actualRequest.getTopic());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTopicExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      Topic topic = Topic.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTopic(topic, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void publishTest() throws Exception {
    PublishResponse expectedResponse =
        PublishResponse.newBuilder().addAllMessageIds(new ArrayList<String>()).build();
    mockPublisher.addResponse(expectedResponse);

    TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
    List<PubsubMessage> messages = new ArrayList<>();

    PublishResponse actualResponse = client.publish(topic, messages);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PublishRequest actualRequest = ((PublishRequest) actualRequests.get(0));

    Assert.assertEquals(topic.toString(), actualRequest.getTopic());
    Assert.assertEquals(messages, actualRequest.getMessagesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void publishExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
      List<PubsubMessage> messages = new ArrayList<>();
      client.publish(topic, messages);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void publishTest2() throws Exception {
    PublishResponse expectedResponse =
        PublishResponse.newBuilder().addAllMessageIds(new ArrayList<String>()).build();
    mockPublisher.addResponse(expectedResponse);

    String topic = "topic110546223";
    List<PubsubMessage> messages = new ArrayList<>();

    PublishResponse actualResponse = client.publish(topic, messages);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PublishRequest actualRequest = ((PublishRequest) actualRequests.get(0));

    Assert.assertEquals(topic, actualRequest.getTopic());
    Assert.assertEquals(messages, actualRequest.getMessagesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void publishExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      String topic = "topic110546223";
      List<PubsubMessage> messages = new ArrayList<>();
      client.publish(topic, messages);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTopicTest() throws Exception {
    Topic expectedResponse =
        Topic.newBuilder()
            .setName(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setMessageStoragePolicy(MessageStoragePolicy.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .setSchemaSettings(SchemaSettings.newBuilder().build())
            .setSatisfiesPzs(true)
            .setMessageRetentionDuration(Duration.newBuilder().build())
            .setIngestionDataSourceSettings(IngestionDataSourceSettings.newBuilder().build())
            .build();
    mockPublisher.addResponse(expectedResponse);

    TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");

    Topic actualResponse = client.getTopic(topic);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTopicRequest actualRequest = ((GetTopicRequest) actualRequests.get(0));

    Assert.assertEquals(topic.toString(), actualRequest.getTopic());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTopicExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
      client.getTopic(topic);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTopicTest2() throws Exception {
    Topic expectedResponse =
        Topic.newBuilder()
            .setName(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setMessageStoragePolicy(MessageStoragePolicy.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .setSchemaSettings(SchemaSettings.newBuilder().build())
            .setSatisfiesPzs(true)
            .setMessageRetentionDuration(Duration.newBuilder().build())
            .setIngestionDataSourceSettings(IngestionDataSourceSettings.newBuilder().build())
            .build();
    mockPublisher.addResponse(expectedResponse);

    String topic = "topic110546223";

    Topic actualResponse = client.getTopic(topic);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTopicRequest actualRequest = ((GetTopicRequest) actualRequests.get(0));

    Assert.assertEquals(topic, actualRequest.getTopic());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTopicExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      String topic = "topic110546223";
      client.getTopic(topic);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTopicsTest() throws Exception {
    Topic responsesElement = Topic.newBuilder().build();
    ListTopicsResponse expectedResponse =
        ListTopicsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTopics(Arrays.asList(responsesElement))
            .build();
    mockPublisher.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    ListTopicsPagedResponse pagedListResponse = client.listTopics(project);

    List<Topic> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTopicsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTopicsRequest actualRequest = ((ListTopicsRequest) actualRequests.get(0));

    Assert.assertEquals(project.toString(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTopicsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");
      client.listTopics(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTopicsTest2() throws Exception {
    Topic responsesElement = Topic.newBuilder().build();
    ListTopicsResponse expectedResponse =
        ListTopicsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTopics(Arrays.asList(responsesElement))
            .build();
    mockPublisher.addResponse(expectedResponse);

    String project = "project-309310695";

    ListTopicsPagedResponse pagedListResponse = client.listTopics(project);

    List<Topic> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTopicsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTopicsRequest actualRequest = ((ListTopicsRequest) actualRequests.get(0));

    Assert.assertEquals(project, actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTopicsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      String project = "project-309310695";
      client.listTopics(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTopicSubscriptionsTest() throws Exception {
    String responsesElement = "responsesElement-318365110";
    ListTopicSubscriptionsResponse expectedResponse =
        ListTopicSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockPublisher.addResponse(expectedResponse);

    TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");

    ListTopicSubscriptionsPagedResponse pagedListResponse = client.listTopicSubscriptions(topic);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscriptionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTopicSubscriptionsRequest actualRequest =
        ((ListTopicSubscriptionsRequest) actualRequests.get(0));

    Assert.assertEquals(topic.toString(), actualRequest.getTopic());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTopicSubscriptionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
      client.listTopicSubscriptions(topic);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTopicSubscriptionsTest2() throws Exception {
    String responsesElement = "responsesElement-318365110";
    ListTopicSubscriptionsResponse expectedResponse =
        ListTopicSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockPublisher.addResponse(expectedResponse);

    String topic = "topic110546223";

    ListTopicSubscriptionsPagedResponse pagedListResponse = client.listTopicSubscriptions(topic);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscriptionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTopicSubscriptionsRequest actualRequest =
        ((ListTopicSubscriptionsRequest) actualRequests.get(0));

    Assert.assertEquals(topic, actualRequest.getTopic());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTopicSubscriptionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      String topic = "topic110546223";
      client.listTopicSubscriptions(topic);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTopicSnapshotsTest() throws Exception {
    String responsesElement = "responsesElement-318365110";
    ListTopicSnapshotsResponse expectedResponse =
        ListTopicSnapshotsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSnapshots(Arrays.asList(responsesElement))
            .build();
    mockPublisher.addResponse(expectedResponse);

    TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");

    ListTopicSnapshotsPagedResponse pagedListResponse = client.listTopicSnapshots(topic);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSnapshotsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTopicSnapshotsRequest actualRequest = ((ListTopicSnapshotsRequest) actualRequests.get(0));

    Assert.assertEquals(topic.toString(), actualRequest.getTopic());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTopicSnapshotsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
      client.listTopicSnapshots(topic);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTopicSnapshotsTest2() throws Exception {
    String responsesElement = "responsesElement-318365110";
    ListTopicSnapshotsResponse expectedResponse =
        ListTopicSnapshotsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSnapshots(Arrays.asList(responsesElement))
            .build();
    mockPublisher.addResponse(expectedResponse);

    String topic = "topic110546223";

    ListTopicSnapshotsPagedResponse pagedListResponse = client.listTopicSnapshots(topic);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSnapshotsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTopicSnapshotsRequest actualRequest = ((ListTopicSnapshotsRequest) actualRequests.get(0));

    Assert.assertEquals(topic, actualRequest.getTopic());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTopicSnapshotsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      String topic = "topic110546223";
      client.listTopicSnapshots(topic);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTopicTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPublisher.addResponse(expectedResponse);

    TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");

    client.deleteTopic(topic);

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTopicRequest actualRequest = ((DeleteTopicRequest) actualRequests.get(0));

    Assert.assertEquals(topic.toString(), actualRequest.getTopic());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTopicExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
      client.deleteTopic(topic);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTopicTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPublisher.addResponse(expectedResponse);

    String topic = "topic110546223";

    client.deleteTopic(topic);

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTopicRequest actualRequest = ((DeleteTopicRequest) actualRequests.get(0));

    Assert.assertEquals(topic, actualRequest.getTopic());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTopicExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      String topic = "topic110546223";
      client.deleteTopic(topic);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void detachSubscriptionTest() throws Exception {
    DetachSubscriptionResponse expectedResponse = DetachSubscriptionResponse.newBuilder().build();
    mockPublisher.addResponse(expectedResponse);

    DetachSubscriptionRequest request =
        DetachSubscriptionRequest.newBuilder()
            .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
            .build();

    DetachSubscriptionResponse actualResponse = client.detachSubscription(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPublisher.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DetachSubscriptionRequest actualRequest = ((DetachSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSubscription(), actualRequest.getSubscription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void detachSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublisher.addException(exception);

    try {
      DetachSubscriptionRequest request =
          DetachSubscriptionRequest.newBuilder()
              .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
              .build();
      client.detachSubscription(request);
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
