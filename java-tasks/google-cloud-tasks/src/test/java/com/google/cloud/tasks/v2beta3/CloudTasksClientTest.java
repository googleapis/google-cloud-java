/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.tasks.v2beta3;

import static com.google.cloud.tasks.v2beta3.CloudTasksClient.ListQueuesPagedResponse;
import static com.google.cloud.tasks.v2beta3.CloudTasksClient.ListTasksPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class CloudTasksClientTest {
  private static MockServiceHelper mockServiceHelper;
  private CloudTasksClient client;
  private static MockCloudTasks mockCloudTasks;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudTasks = new MockCloudTasks();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCloudTasks));
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
    CloudTasksSettings settings =
        CloudTasksSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudTasksClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listQueuesTest() throws Exception {
    Queue responsesElement = Queue.newBuilder().build();
    ListQueuesResponse expectedResponse =
        ListQueuesResponse.newBuilder()
            .setNextPageToken("")
            .addAllQueues(Arrays.asList(responsesElement))
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListQueuesPagedResponse pagedListResponse = client.listQueues(parent);

    List<Queue> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQueuesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQueuesRequest actualRequest = ((ListQueuesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQueuesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listQueues(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQueuesTest2() throws Exception {
    Queue responsesElement = Queue.newBuilder().build();
    ListQueuesResponse expectedResponse =
        ListQueuesResponse.newBuilder()
            .setNextPageToken("")
            .addAllQueues(Arrays.asList(responsesElement))
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListQueuesPagedResponse pagedListResponse = client.listQueues(parent);

    List<Queue> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQueuesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQueuesRequest actualRequest = ((ListQueuesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQueuesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listQueues(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQueueTest() throws Exception {
    Queue expectedResponse =
        Queue.newBuilder()
            .setName(QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]").toString())
            .setRateLimits(RateLimits.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setTaskTtl(Duration.newBuilder().build())
            .setTombstoneTtl(Duration.newBuilder().build())
            .setStackdriverLoggingConfig(StackdriverLoggingConfig.newBuilder().build())
            .setStats(QueueStats.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    QueueName name = QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]");

    Queue actualResponse = client.getQueue(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQueueRequest actualRequest = ((GetQueueRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQueueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      QueueName name = QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]");
      client.getQueue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQueueTest2() throws Exception {
    Queue expectedResponse =
        Queue.newBuilder()
            .setName(QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]").toString())
            .setRateLimits(RateLimits.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setTaskTtl(Duration.newBuilder().build())
            .setTombstoneTtl(Duration.newBuilder().build())
            .setStackdriverLoggingConfig(StackdriverLoggingConfig.newBuilder().build())
            .setStats(QueueStats.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    String name = "name3373707";

    Queue actualResponse = client.getQueue(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQueueRequest actualRequest = ((GetQueueRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQueueExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      String name = "name3373707";
      client.getQueue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQueueTest() throws Exception {
    Queue expectedResponse =
        Queue.newBuilder()
            .setName(QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]").toString())
            .setRateLimits(RateLimits.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setTaskTtl(Duration.newBuilder().build())
            .setTombstoneTtl(Duration.newBuilder().build())
            .setStackdriverLoggingConfig(StackdriverLoggingConfig.newBuilder().build())
            .setStats(QueueStats.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Queue queue = Queue.newBuilder().build();

    Queue actualResponse = client.createQueue(parent, queue);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateQueueRequest actualRequest = ((CreateQueueRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(queue, actualRequest.getQueue());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createQueueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Queue queue = Queue.newBuilder().build();
      client.createQueue(parent, queue);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQueueTest2() throws Exception {
    Queue expectedResponse =
        Queue.newBuilder()
            .setName(QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]").toString())
            .setRateLimits(RateLimits.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setTaskTtl(Duration.newBuilder().build())
            .setTombstoneTtl(Duration.newBuilder().build())
            .setStackdriverLoggingConfig(StackdriverLoggingConfig.newBuilder().build())
            .setStats(QueueStats.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Queue queue = Queue.newBuilder().build();

    Queue actualResponse = client.createQueue(parent, queue);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateQueueRequest actualRequest = ((CreateQueueRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(queue, actualRequest.getQueue());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createQueueExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      String parent = "parent-995424086";
      Queue queue = Queue.newBuilder().build();
      client.createQueue(parent, queue);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateQueueTest() throws Exception {
    Queue expectedResponse =
        Queue.newBuilder()
            .setName(QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]").toString())
            .setRateLimits(RateLimits.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setTaskTtl(Duration.newBuilder().build())
            .setTombstoneTtl(Duration.newBuilder().build())
            .setStackdriverLoggingConfig(StackdriverLoggingConfig.newBuilder().build())
            .setStats(QueueStats.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    Queue queue = Queue.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Queue actualResponse = client.updateQueue(queue, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateQueueRequest actualRequest = ((UpdateQueueRequest) actualRequests.get(0));

    Assert.assertEquals(queue, actualRequest.getQueue());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateQueueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      Queue queue = Queue.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateQueue(queue, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteQueueTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudTasks.addResponse(expectedResponse);

    QueueName name = QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]");

    client.deleteQueue(name);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteQueueRequest actualRequest = ((DeleteQueueRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteQueueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      QueueName name = QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]");
      client.deleteQueue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteQueueTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudTasks.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteQueue(name);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteQueueRequest actualRequest = ((DeleteQueueRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteQueueExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      String name = "name3373707";
      client.deleteQueue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void purgeQueueTest() throws Exception {
    Queue expectedResponse =
        Queue.newBuilder()
            .setName(QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]").toString())
            .setRateLimits(RateLimits.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setTaskTtl(Duration.newBuilder().build())
            .setTombstoneTtl(Duration.newBuilder().build())
            .setStackdriverLoggingConfig(StackdriverLoggingConfig.newBuilder().build())
            .setStats(QueueStats.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    QueueName name = QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]");

    Queue actualResponse = client.purgeQueue(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeQueueRequest actualRequest = ((PurgeQueueRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void purgeQueueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      QueueName name = QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]");
      client.purgeQueue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void purgeQueueTest2() throws Exception {
    Queue expectedResponse =
        Queue.newBuilder()
            .setName(QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]").toString())
            .setRateLimits(RateLimits.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setTaskTtl(Duration.newBuilder().build())
            .setTombstoneTtl(Duration.newBuilder().build())
            .setStackdriverLoggingConfig(StackdriverLoggingConfig.newBuilder().build())
            .setStats(QueueStats.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    String name = "name3373707";

    Queue actualResponse = client.purgeQueue(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeQueueRequest actualRequest = ((PurgeQueueRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void purgeQueueExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      String name = "name3373707";
      client.purgeQueue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseQueueTest() throws Exception {
    Queue expectedResponse =
        Queue.newBuilder()
            .setName(QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]").toString())
            .setRateLimits(RateLimits.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setTaskTtl(Duration.newBuilder().build())
            .setTombstoneTtl(Duration.newBuilder().build())
            .setStackdriverLoggingConfig(StackdriverLoggingConfig.newBuilder().build())
            .setStats(QueueStats.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    QueueName name = QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]");

    Queue actualResponse = client.pauseQueue(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PauseQueueRequest actualRequest = ((PauseQueueRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pauseQueueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      QueueName name = QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]");
      client.pauseQueue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseQueueTest2() throws Exception {
    Queue expectedResponse =
        Queue.newBuilder()
            .setName(QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]").toString())
            .setRateLimits(RateLimits.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setTaskTtl(Duration.newBuilder().build())
            .setTombstoneTtl(Duration.newBuilder().build())
            .setStackdriverLoggingConfig(StackdriverLoggingConfig.newBuilder().build())
            .setStats(QueueStats.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    String name = "name3373707";

    Queue actualResponse = client.pauseQueue(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PauseQueueRequest actualRequest = ((PauseQueueRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pauseQueueExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      String name = "name3373707";
      client.pauseQueue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeQueueTest() throws Exception {
    Queue expectedResponse =
        Queue.newBuilder()
            .setName(QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]").toString())
            .setRateLimits(RateLimits.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setTaskTtl(Duration.newBuilder().build())
            .setTombstoneTtl(Duration.newBuilder().build())
            .setStackdriverLoggingConfig(StackdriverLoggingConfig.newBuilder().build())
            .setStats(QueueStats.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    QueueName name = QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]");

    Queue actualResponse = client.resumeQueue(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeQueueRequest actualRequest = ((ResumeQueueRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeQueueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      QueueName name = QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]");
      client.resumeQueue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeQueueTest2() throws Exception {
    Queue expectedResponse =
        Queue.newBuilder()
            .setName(QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]").toString())
            .setRateLimits(RateLimits.newBuilder().build())
            .setRetryConfig(RetryConfig.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setTaskTtl(Duration.newBuilder().build())
            .setTombstoneTtl(Duration.newBuilder().build())
            .setStackdriverLoggingConfig(StackdriverLoggingConfig.newBuilder().build())
            .setStats(QueueStats.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    String name = "name3373707";

    Queue actualResponse = client.resumeQueue(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeQueueRequest actualRequest = ((ResumeQueueRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeQueueExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      String name = "name3373707";
      client.resumeQueue(name);
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
            .setEtag(ByteString.EMPTY)
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    ResourceName resource = LocationName.of("[PROJECT]", "[LOCATION]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      ResourceName resource = LocationName.of("[PROJECT]", "[LOCATION]");
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      String resource = "resource-341064690";
      client.getIamPolicy(resource);
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
            .setEtag(ByteString.EMPTY)
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    ResourceName resource = LocationName.of("[PROJECT]", "[LOCATION]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      ResourceName resource = LocationName.of("[PROJECT]", "[LOCATION]");
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    String resource = "resource-341064690";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      String resource = "resource-341064690";
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockCloudTasks.addResponse(expectedResponse);

    ResourceName resource = LocationName.of("[PROJECT]", "[LOCATION]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      ResourceName resource = LocationName.of("[PROJECT]", "[LOCATION]");
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest2() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockCloudTasks.addResponse(expectedResponse);

    String resource = "resource-341064690";
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      String resource = "resource-341064690";
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTasksTest() throws Exception {
    Task responsesElement = Task.newBuilder().build();
    ListTasksResponse expectedResponse =
        ListTasksResponse.newBuilder()
            .setNextPageToken("")
            .addAllTasks(Arrays.asList(responsesElement))
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    QueueName parent = QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]");

    ListTasksPagedResponse pagedListResponse = client.listTasks(parent);

    List<Task> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTasksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTasksRequest actualRequest = ((ListTasksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTasksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      QueueName parent = QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]");
      client.listTasks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTasksTest2() throws Exception {
    Task responsesElement = Task.newBuilder().build();
    ListTasksResponse expectedResponse =
        ListTasksResponse.newBuilder()
            .setNextPageToken("")
            .addAllTasks(Arrays.asList(responsesElement))
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTasksPagedResponse pagedListResponse = client.listTasks(parent);

    List<Task> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTasksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTasksRequest actualRequest = ((ListTasksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTasksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTasks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTaskTest() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[QUEUE]", "[TASK]").toString())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDispatchDeadline(Duration.newBuilder().build())
            .setDispatchCount(-1217252086)
            .setResponseCount(424727441)
            .setFirstAttempt(Attempt.newBuilder().build())
            .setLastAttempt(Attempt.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[QUEUE]", "[TASK]");

    Task actualResponse = client.getTask(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTaskRequest actualRequest = ((GetTaskRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTaskExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[QUEUE]", "[TASK]");
      client.getTask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTaskTest2() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[QUEUE]", "[TASK]").toString())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDispatchDeadline(Duration.newBuilder().build())
            .setDispatchCount(-1217252086)
            .setResponseCount(424727441)
            .setFirstAttempt(Attempt.newBuilder().build())
            .setLastAttempt(Attempt.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    String name = "name3373707";

    Task actualResponse = client.getTask(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTaskRequest actualRequest = ((GetTaskRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTaskExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      String name = "name3373707";
      client.getTask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTaskTest() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[QUEUE]", "[TASK]").toString())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDispatchDeadline(Duration.newBuilder().build())
            .setDispatchCount(-1217252086)
            .setResponseCount(424727441)
            .setFirstAttempt(Attempt.newBuilder().build())
            .setLastAttempt(Attempt.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    QueueName parent = QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]");
    Task task = Task.newBuilder().build();

    Task actualResponse = client.createTask(parent, task);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTaskRequest actualRequest = ((CreateTaskRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(task, actualRequest.getTask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTaskExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      QueueName parent = QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]");
      Task task = Task.newBuilder().build();
      client.createTask(parent, task);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTaskTest2() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[QUEUE]", "[TASK]").toString())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDispatchDeadline(Duration.newBuilder().build())
            .setDispatchCount(-1217252086)
            .setResponseCount(424727441)
            .setFirstAttempt(Attempt.newBuilder().build())
            .setLastAttempt(Attempt.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Task task = Task.newBuilder().build();

    Task actualResponse = client.createTask(parent, task);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTaskRequest actualRequest = ((CreateTaskRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(task, actualRequest.getTask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTaskExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      String parent = "parent-995424086";
      Task task = Task.newBuilder().build();
      client.createTask(parent, task);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTaskTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudTasks.addResponse(expectedResponse);

    TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[QUEUE]", "[TASK]");

    client.deleteTask(name);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTaskRequest actualRequest = ((DeleteTaskRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTaskExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[QUEUE]", "[TASK]");
      client.deleteTask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTaskTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudTasks.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTask(name);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTaskRequest actualRequest = ((DeleteTaskRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTaskExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runTaskTest() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[QUEUE]", "[TASK]").toString())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDispatchDeadline(Duration.newBuilder().build())
            .setDispatchCount(-1217252086)
            .setResponseCount(424727441)
            .setFirstAttempt(Attempt.newBuilder().build())
            .setLastAttempt(Attempt.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[QUEUE]", "[TASK]");

    Task actualResponse = client.runTask(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunTaskRequest actualRequest = ((RunTaskRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runTaskExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[QUEUE]", "[TASK]");
      client.runTask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runTaskTest2() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[QUEUE]", "[TASK]").toString())
            .setScheduleTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDispatchDeadline(Duration.newBuilder().build())
            .setDispatchCount(-1217252086)
            .setResponseCount(424727441)
            .setFirstAttempt(Attempt.newBuilder().build())
            .setLastAttempt(Attempt.newBuilder().build())
            .build();
    mockCloudTasks.addResponse(expectedResponse);

    String name = "name3373707";

    Task actualResponse = client.runTask(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudTasks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunTaskRequest actualRequest = ((RunTaskRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runTaskExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudTasks.addException(exception);

    try {
      String name = "name3373707";
      client.runTask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
