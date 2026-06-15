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

import com.google.cloud.pubsub.v1.Publisher;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.cloud.testing.junit4.MultipleAttemptsRule;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class DeadLetterQueueIT {

  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static final String projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static String _suffix;
  private static String topicId;
  private static String subscriptionId;
  private static String deadLetterTopicId;
  private static TopicName topicName;
  private static TopicName deadLetterTopicName;
  private static SubscriptionName subscriptionName;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
  }

  // Helper function to publish a message.
  private static void publishSomeMessages() throws Exception {
    TopicName topicName = TopicName.of(projectId, topicId);
    Publisher publisher = Publisher.newBuilder(topicName).build();
    ByteString data = ByteString.copyFromUtf8("Hello");
    PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();
    publisher.publish(pubsubMessage).get();
  }

  @Rule public Timeout globalTimeout = Timeout.seconds(300); // 5 minute timeout
  @Rule public MultipleAttemptsRule retryRule = new MultipleAttemptsRule(/* maxAttemptCount= */ 3);

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
    _suffix = UUID.randomUUID().toString();
    topicId = "topic-" + _suffix;
    subscriptionId = "subscription-" + _suffix;
    deadLetterTopicId = "topic-dlq-" + _suffix;
    topicName = TopicName.of(projectId, topicId);
    deadLetterTopicName = TopicName.of(projectId, deadLetterTopicId);
    subscriptionName = SubscriptionName.of(projectId, subscriptionId);
  }

  @Before
  public void setUp() throws Exception {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

    // Create a topic to attach a subscription with dead letter policy, and a
    // dead letter topic for that subscription to forward dead letter messages to.
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      Topic topic = Topic.newBuilder().setName(topicName.toString()).build();
      Topic deadLetterTopic = Topic.newBuilder().setName(deadLetterTopicName.toString()).build();
      topicAdminClient.createTopic(topic);
      topicAdminClient.createTopic(deadLetterTopic);
    }
  }

  @After
  public void tearDown() throws Exception {
    // Delete the subscription with dead letter policy.
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      subscriptionAdminClient.deleteSubscription(subscriptionName);
    }

    // Delete the topic that the subscription with dead letter policy is attached
    // to, and the dead letter topic that the subscription forwards dead letter
    // messages to.
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      topicAdminClient.deleteTopic(topicName.toString());
      topicAdminClient.deleteTopic(deadLetterTopicName.toString());
    }

    System.setOut(null);
  }

  @Test
  public void testQuickstart() throws Exception {
    // Create a subscription with dead letter policy
    CreateSubscriptionWithDeadLetterPolicyExample.createSubscriptionWithDeadLetterPolicyExample(
        projectId, subscriptionId, topicId, deadLetterTopicId);
    assertThat(bout.toString()).contains("Created subscription: " + subscriptionName.toString());
    assertThat(bout.toString())
        .contains("It will forward dead letter messages to: " + deadLetterTopicName.toString());
    assertThat(bout.toString()).contains("After 10 delivery attempts.");

    publishSomeMessages();

    bout.reset();
    // Receive messages with delivery attempts.
    ReceiveMessagesWithDeliveryAttemptsExample.receiveMessagesWithDeliveryAttemptsExample(
        projectId, subscriptionId);
    assertThat(bout.toString()).contains("Listening for messages on");
    assertThat(bout.toString()).contains("Data: Hello");
    assertThat(bout.toString()).contains("Delivery Attempt: 1");

    bout.reset();
    // Update dead letter policy.
    UpdateDeadLetterPolicyExample.updateDeadLetterPolicyExample(
        projectId, subscriptionId, topicId, deadLetterTopicId);
    assertThat(bout.toString()).contains("Max delivery attempts is now 20");

    bout.reset();
    // Remove dead letter policy.
    RemoveDeadLetterPolicyExample.removeDeadLetterPolicyExample(projectId, subscriptionId, topicId);
    assertThat(bout.toString()).doesNotContain("dead_letter_policy");
  }
}
