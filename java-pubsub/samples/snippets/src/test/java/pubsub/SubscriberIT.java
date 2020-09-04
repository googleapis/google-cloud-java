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
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
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
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class SubscriberIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static final String projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String _suffix = UUID.randomUUID().toString();
  private static final String topicId = "subscriber-test-topic-" + _suffix;
  private static final String subscriptionId = "subscriber-test-subscription-" + _suffix;
  private static final TopicName topicName = TopicName.of(projectId, topicId);
  private static final ProjectSubscriptionName subscriptionName =
      ProjectSubscriptionName.of(projectId, subscriptionId);
  private static final ExecutorProvider executorProvider =
      InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(4).build();

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
  }

  // Helper function to publish some messages.
  private static void publishSomeMessages(Integer numOfMessages) throws Exception {
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
    ApiFutures.allAsList(messageIdFutures).get();
  }

  @Rule public Timeout globalTimeout = Timeout.seconds(600); // 10 minute timeout

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() throws Exception {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      Topic topic = Topic.newBuilder().setName(topicName.toString()).build();
      topicAdminClient.createTopic(topic);
    }

    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      Subscription subscription =
          Subscription.newBuilder()
              .setName(subscriptionName.toString())
              .setTopic(topicName.toString())
              .build();
      subscriptionAdminClient.createSubscription(subscription);
    }
  }

  @After
  public void tearDown() throws Exception {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      subscriptionAdminClient.deleteSubscription(subscriptionName.toString());
    }

    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      topicAdminClient.deleteTopic(topicName.toString());
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
    SubscribeSyncExample.subscribeSyncExample(projectId, subscriptionId, 10);
    for (int i = 0; i < 3; i++) {
      assertThat(bout.toString()).contains("Hello " + i);
    }

    publishSomeMessages(3);
    bout.reset();
    // Test subscribe synchronously with lease management.
    SubscribeSyncWithLeaseExample.subscribeSyncWithLeaseExample(projectId, subscriptionId, 10);
    for (int i = 0; i < 3; i++) {
      assertThat(bout.toString()).contains("Hello " + i);
    }
  }
}
