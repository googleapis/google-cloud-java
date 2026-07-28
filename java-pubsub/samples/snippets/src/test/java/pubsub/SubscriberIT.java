/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pubsub;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class SubscriberIT {
  private static ByteArrayOutputStream bout;
  private static PrintStream out;

  private static final String projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String _suffix = UUID.randomUUID().toString();
  private static final String topicId = "subscriber-test-topic-" + _suffix;
  private static final String topicIdEod = "subscriber-test-topic-eod" + _suffix;
  private static final String subscriptionId = "subscriber-test-subscription-" + _suffix;
  // For a subscription with exactly once delivery enabled.
  private static final String subscriptionEodId = "subscriber-test-subscription-eod" + _suffix;
  private static final String subscriptionOptimisticId =
      "subscriber-test-subscription-optimistic" + _suffix;
  private static final TopicName topicName = TopicName.of(projectId, topicId);
  private static final TopicName topicNameEod = TopicName.of(projectId, topicIdEod);
  private static final ProjectSubscriptionName subscriptionName =
      ProjectSubscriptionName.of(projectId, subscriptionId);
  private static final ProjectSubscriptionName subscriptionEodName =
      ProjectSubscriptionName.of(projectId, subscriptionEodId);
  private static final ProjectSubscriptionName subscriptionOptimisticName =
      ProjectSubscriptionName.of(projectId, subscriptionOptimisticId);

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
  }

  private static List<String> publishSomeMessages(Integer numOfMessages) throws Exception {
    return publishSomeMessages(numOfMessages, topicId);
  }

  // Helper function to publish some messages.
  private static List<String> publishSomeMessages(Integer numOfMessages, String topicId)
      throws Exception {
    ProjectTopicName topicName = ProjectTopicName.of(projectId, topicId);
    Publisher publisher = Publisher.newBuilder(topicName).build();
    List<ApiFuture<String>> messageIdFutures = new ArrayList<>();
    for (int i = 0; i < numOfMessages; i++) {
      ByteString data = ByteString.copyFromUtf8("Hello " + i);
      PubsubMessage pubsubMessage =
          PubsubMessage.newBuilder()
              .setData(data)
              .putAllAttributes(ImmutableMap.of("year", "2020", "author", "unknown"))
              .build();
      ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
      messageIdFutures.add(messageIdFuture);
    }
    return ApiFutures.allAsList(messageIdFutures).get();
  }

  // Helper function to retry synchronous pull attempts until all outstanding messages are received.
  private void syncPullWithRetries(
      Integer numOfMessages, Integer maxRetries, CheckedRunnable syncPull) throws Exception {
    HashSet<String> outstandingMessages = new HashSet<>();
    for (int i = 0; i < numOfMessages; i++) {
      outstandingMessages.add("Hello " + i);
    }
    int attempt = 1;
    while ((outstandingMessages.size() > 0) && (attempt <= maxRetries)) {
      syncPull.run();
      HashSet<String> clone = (HashSet) outstandingMessages.clone();
      for (String message : clone) {
        if (bout.toString().contains(message)) {
          outstandingMessages.remove(message);
        }
      }
      attempt++;
    }
    assertThat(outstandingMessages).isEmpty();
  }

  @FunctionalInterface
  public interface CheckedRunnable {
    void run() throws Exception;
  }

  @Rule public Timeout globalTimeout = Timeout.seconds(600); // 10 minute timeout

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @BeforeClass
  public static void setUp() throws Exception {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      Topic topic = Topic.newBuilder().setName(topicName.toString()).build();
      topicAdminClient.createTopic(topic);

      Topic topicEod = Topic.newBuilder().setName(topicNameEod.toString()).build();
      topicAdminClient.createTopic(topicEod);
    }

    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      Subscription subscription =
          Subscription.newBuilder()
              .setName(subscriptionName.toString())
              .setTopic(topicName.toString())
              .build();
      subscriptionAdminClient.createSubscription(subscription);

      Subscription subscriptionEod =
          Subscription.newBuilder()
              .setName(subscriptionEodName.toString())
              .setTopic(topicNameEod.toString())
              // Enable exactly once delivery in the subscription.
              .setEnableExactlyOnceDelivery(true)
              .build();
      subscriptionAdminClient.createSubscription(subscriptionEod);
    }
  }

  @AfterClass
  public static void tearDown() throws Exception {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      subscriptionAdminClient.deleteSubscription(subscriptionName.toString());
      subscriptionAdminClient.deleteSubscription(subscriptionEodName.toString());
      try {
        subscriptionAdminClient.deleteSubscription(subscriptionOptimisticName.toString());
      } catch (Exception e) {
        // Ignore exception.
      }
    }

    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      topicAdminClient.deleteTopic(topicName.toString());
      topicAdminClient.deleteTopic(topicNameEod.toString());
    }

    System.setOut(null);
  }

  @Test
  public void testSubscriber() throws Exception {
    publishSomeMessages(1);
    // Test subscribe asynchronously.
    SubscribeAsyncExample.subscribeAsyncExample(projectId, subscriptionId);
    assertThat(bout.toString()).contains("Data: Hello 0");

    publishSomeMessages(1);
    bout.reset();
    // Test subscribe with custom attributes.
    SubscribeWithCustomAttributesExample.subscribeWithCustomAttributesExample(
        projectId, subscriptionId);
    assertThat(bout.toString()).contains("Data: Hello 0");
    assertThat(bout.toString()).contains("author = unknown");
    assertThat(bout.toString()).contains("year = 2020");

    publishSomeMessages(5);
    bout.reset();
    // Test subscribe with error listener.
    SubscribeWithErrorListenerExample.subscribeWithErrorListenerExample(projectId, subscriptionId);
    assertThat(bout.toString()).contains("Data: Hello 0");

    publishSomeMessages(200);
    bout.reset();
    // Test subscribe with flow control settings.
    SubscribeWithFlowControlSettingsExample.subscribeWithFlowControlSettingsExample(
        projectId, subscriptionId);
    for (int i = 0; i < 200; i++) {
      assertThat(bout.toString()).contains("Data: Hello " + i);
    }

    publishSomeMessages(100);
    bout.reset();
    // Test subscribe with concurrency control.
    SubscribeWithConcurrencyControlExample.subscribeWithConcurrencyControlExample(
        projectId, subscriptionId);
    for (int i = 0; i < 100; i++) {
      assertThat(bout.toString()).contains("Data: Hello " + i);
    }

    publishSomeMessages(3);
    bout.reset();
    // Test subscribe synchronously.
    syncPullWithRetries(
        3, 3, () -> SubscribeSyncExample.subscribeSyncExample(projectId, subscriptionId, 3));

    publishSomeMessages(3);
    bout.reset();
    // Test subscribe synchronously with lease management.
    syncPullWithRetries(
        3,
        3,
        () ->
            SubscribeSyncWithLeaseExample.subscribeSyncWithLeaseExample(
                projectId, subscriptionId, 10));
  }

  @Test
  public void testSubscriberExactlyOnceDelivery() throws Exception {
    List<String> messageIds = publishSomeMessages(10, topicIdEod);
    bout.reset();
    SubscribeWithExactlyOnceConsumerWithResponseExample
        .subscribeWithExactlyOnceConsumerWithResponseExample(projectId, subscriptionEodId);
    for (String messageId : messageIds) {
      assertThat(bout.toString()).contains("Message successfully acked: " + messageId);
    }
  }

  @Test
  public void testOptimisticSubscriber() throws Exception {
    bout.reset();
    OptimisticSubscribeExample.optimisticSubscribeExample(
        projectId, subscriptionOptimisticId, topicId);
    assertThat(
        bout.toString()
            .contains("Created pull subscription: " + subscriptionOptimisticName.toString()));
  }
}
