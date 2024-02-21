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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.pubsub.v1.stub.HttpJsonSubscriberStub;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.pubsub.v1.BigQueryConfig;
import com.google.pubsub.v1.CloudStorageConfig;
import com.google.pubsub.v1.DeadLetterPolicy;
import com.google.pubsub.v1.ExpirationPolicy;
import com.google.pubsub.v1.ListSnapshotsResponse;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.ReceivedMessage;
import com.google.pubsub.v1.RetryPolicy;
import com.google.pubsub.v1.SchemaName;
import com.google.pubsub.v1.SeekRequest;
import com.google.pubsub.v1.SeekResponse;
import com.google.pubsub.v1.Snapshot;
import com.google.pubsub.v1.SnapshotName;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.TopicName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SubscriptionAdminClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SubscriptionAdminClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSubscriberStub.getMethodDescriptors(),
            SubscriptionAdminSettings.getDefaultEndpoint());
    SubscriptionAdminSettings settings =
        SubscriptionAdminSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SubscriptionAdminSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SubscriptionAdminClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
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
    mockService.addResponse(expectedResponse);

    SubscriptionName name = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
    TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
    PushConfig pushConfig = PushConfig.newBuilder().build();
    int ackDeadlineSeconds = 2135351438;

    Subscription actualResponse =
        client.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    SubscriptionName name = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
    String topic = "topic110546223";
    PushConfig pushConfig = PushConfig.newBuilder().build();
    int ackDeadlineSeconds = 2135351438;

    Subscription actualResponse =
        client.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSubscriptionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7298/subscriptions/subscription-7298";
    TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
    PushConfig pushConfig = PushConfig.newBuilder().build();
    int ackDeadlineSeconds = 2135351438;

    Subscription actualResponse =
        client.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSubscriptionExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7298/subscriptions/subscription-7298";
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7298/subscriptions/subscription-7298";
    String topic = "topic110546223";
    PushConfig pushConfig = PushConfig.newBuilder().build();
    int ackDeadlineSeconds = 2135351438;

    Subscription actualResponse =
        client.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSubscriptionExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7298/subscriptions/subscription-7298";
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
    mockService.addResponse(expectedResponse);

    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");

    Subscription actualResponse = client.getSubscription(subscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String subscription = "projects/project-1980/subscriptions/subscription-1980";

    Subscription actualResponse = client.getSubscription(subscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSubscriptionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String subscription = "projects/project-1980/subscriptions/subscription-1980";
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
    mockService.addResponse(expectedResponse);

    Subscription subscription =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Subscription actualResponse = client.updateSubscription(subscription, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Subscription subscription =
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
    mockService.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    ListSubscriptionsPagedResponse pagedListResponse = client.listSubscriptions(project);

    List<Subscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscriptionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSubscriptionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String project = "projects/project-7934";

    ListSubscriptionsPagedResponse pagedListResponse = client.listSubscriptions(project);

    List<Subscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscriptionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSubscriptionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "projects/project-7934";
      client.listSubscriptions(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSubscriptionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");

    client.deleteSubscription(subscription);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String subscription = "projects/project-1980/subscriptions/subscription-1980";

    client.deleteSubscription(subscription);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSubscriptionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String subscription = "projects/project-1980/subscriptions/subscription-1980";
      client.deleteSubscription(subscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void modifyAckDeadlineTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
    List<String> ackIds = new ArrayList<>();
    int ackDeadlineSeconds = 2135351438;

    client.modifyAckDeadline(subscription, ackIds, ackDeadlineSeconds);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void modifyAckDeadlineExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String subscription = "projects/project-1980/subscriptions/subscription-1980";
    List<String> ackIds = new ArrayList<>();
    int ackDeadlineSeconds = 2135351438;

    client.modifyAckDeadline(subscription, ackIds, ackDeadlineSeconds);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void modifyAckDeadlineExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String subscription = "projects/project-1980/subscriptions/subscription-1980";
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
    mockService.addResponse(expectedResponse);

    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
    List<String> ackIds = new ArrayList<>();

    client.acknowledge(subscription, ackIds);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void acknowledgeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String subscription = "projects/project-1980/subscriptions/subscription-1980";
    List<String> ackIds = new ArrayList<>();

    client.acknowledge(subscription, ackIds);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void acknowledgeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String subscription = "projects/project-1980/subscriptions/subscription-1980";
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
    mockService.addResponse(expectedResponse);

    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
    int maxMessages = 496131527;

    PullResponse actualResponse = client.pull(subscription, maxMessages);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void pullExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String subscription = "projects/project-1980/subscriptions/subscription-1980";
    int maxMessages = 496131527;

    PullResponse actualResponse = client.pull(subscription, maxMessages);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void pullExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String subscription = "projects/project-1980/subscriptions/subscription-1980";
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
    mockService.addResponse(expectedResponse);

    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
    boolean returnImmediately = true;
    int maxMessages = 496131527;

    PullResponse actualResponse = client.pull(subscription, returnImmediately, maxMessages);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void pullExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String subscription = "projects/project-1980/subscriptions/subscription-1980";
    boolean returnImmediately = true;
    int maxMessages = 496131527;

    PullResponse actualResponse = client.pull(subscription, returnImmediately, maxMessages);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void pullExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String subscription = "projects/project-1980/subscriptions/subscription-1980";
      boolean returnImmediately = true;
      int maxMessages = 496131527;
      client.pull(subscription, returnImmediately, maxMessages);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void streamingPullUnsupportedMethodTest() throws Exception {
    // The streamingPull() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void modifyPushConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
    PushConfig pushConfig = PushConfig.newBuilder().build();

    client.modifyPushConfig(subscription, pushConfig);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void modifyPushConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String subscription = "projects/project-1980/subscriptions/subscription-1980";
    PushConfig pushConfig = PushConfig.newBuilder().build();

    client.modifyPushConfig(subscription, pushConfig);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void modifyPushConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String subscription = "projects/project-1980/subscriptions/subscription-1980";
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
    mockService.addResponse(expectedResponse);

    SnapshotName snapshot = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");

    Snapshot actualResponse = client.getSnapshot(snapshot);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSnapshotExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String snapshot = "projects/project-2020/snapshots/snapshot-2020";

    Snapshot actualResponse = client.getSnapshot(snapshot);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSnapshotExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String snapshot = "projects/project-2020/snapshots/snapshot-2020";
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
    mockService.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    ListSnapshotsPagedResponse pagedListResponse = client.listSnapshots(project);

    List<Snapshot> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSnapshotsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSnapshotsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String project = "projects/project-7934";

    ListSnapshotsPagedResponse pagedListResponse = client.listSnapshots(project);

    List<Snapshot> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSnapshotsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSnapshotsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "projects/project-7934";
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
    mockService.addResponse(expectedResponse);

    SnapshotName name = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");
    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");

    Snapshot actualResponse = client.createSnapshot(name, subscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSnapshotExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    SnapshotName name = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");
    String subscription = "subscription341203229";

    Snapshot actualResponse = client.createSnapshot(name, subscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSnapshotExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4389/snapshots/snapshot-4389";
    SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");

    Snapshot actualResponse = client.createSnapshot(name, subscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSnapshotExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4389/snapshots/snapshot-4389";
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4389/snapshots/snapshot-4389";
    String subscription = "subscription341203229";

    Snapshot actualResponse = client.createSnapshot(name, subscription);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSnapshotExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4389/snapshots/snapshot-4389";
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
    mockService.addResponse(expectedResponse);

    Snapshot snapshot =
        Snapshot.newBuilder()
            .setName(SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString())
            .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Snapshot actualResponse = client.updateSnapshot(snapshot, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateSnapshotExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Snapshot snapshot =
          Snapshot.newBuilder()
              .setName(SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString())
              .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
              .setExpireTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .build();
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
    mockService.addResponse(expectedResponse);

    SnapshotName snapshot = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");

    client.deleteSnapshot(snapshot);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSnapshotExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String snapshot = "projects/project-2020/snapshots/snapshot-2020";

    client.deleteSnapshot(snapshot);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSnapshotExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String snapshot = "projects/project-2020/snapshots/snapshot-2020";
      client.deleteSnapshot(snapshot);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void seekTest() throws Exception {
    SeekResponse expectedResponse = SeekResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SeekRequest request =
        SeekRequest.newBuilder()
            .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
            .build();

    SeekResponse actualResponse = client.seek(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void seekExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
