/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pubsub;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.ServiceOptions;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.TopicName;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utilities.PublishOperations;

public class NativeImagePubSubSampleIT {

  private static String TOPIC_ID = "native-pubsub-test-" + UUID.randomUUID();
  private static String PULL_SUB_ID = "native-pubsub-test-sub" + UUID.randomUUID();
  private static String PUSH_SUB_ID = "native-pubsub-test-sub" + UUID.randomUUID();
  private static String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final TopicName TOPIC_NAME = TopicName.of(PROJECT_ID, TOPIC_ID);
  private static final SubscriptionName PULL_SUBSCRIPTION_NAME =
      SubscriptionName.of(PROJECT_ID, PULL_SUB_ID);
  private static final SubscriptionName PUSH_SUBSCRIPTION_NAME =
      SubscriptionName.of(PROJECT_ID, PUSH_SUB_ID);

  private ByteArrayOutputStream bout;
  private PrintStream out;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void cleanUp() throws IOException {
    NativeImagePubSubSample.deleteTopic(PROJECT_ID, TOPIC_ID);
    NativeImagePubSubSample.deleteSubscription(PROJECT_ID, PULL_SUB_ID);
    NativeImagePubSubSample.deleteSubscription(PROJECT_ID, PUSH_SUB_ID);
  }

  @Test
  public void testRunTopicManagementOperations() throws IOException {
    // Topic management operations
    NativeImagePubSubSample.createTopic(PROJECT_ID, TOPIC_ID);
    NativeImagePubSubSample.createPullSubscription(PROJECT_ID, PULL_SUB_ID, TOPIC_ID);
    NativeImagePubSubSample.createPushSubscription(PROJECT_ID, PUSH_SUB_ID, TOPIC_ID);
    NativeImagePubSubSample.detachSubscription(PROJECT_ID, PUSH_SUB_ID);
    NativeImagePubSubSample.getTopicPolicy(PROJECT_ID, TOPIC_ID);
    NativeImagePubSubSample.getSubscriptionPolicy(PROJECT_ID, PULL_SUB_ID);
    NativeImagePubSubSample.listSubscriptionInProject(PROJECT_ID);
    NativeImagePubSubSample.listSubscriptionInTopic(PROJECT_ID, TOPIC_ID);
    NativeImagePubSubSample.listTopics(PROJECT_ID);
    NativeImagePubSubSample.updateSubscriptionDeadLetterTopic(
        PROJECT_ID, PUSH_SUB_ID, TOPIC_ID, TOPIC_ID);
    NativeImagePubSubSample.testTopicPermissions(PROJECT_ID, TOPIC_ID);
    NativeImagePubSubSample.testSubscriptionPermissions(PROJECT_ID, PUSH_SUB_ID);

    // Verify create topic and subscriptions
    assertThat(bout.toString())
        .contains("Created topic: " + TOPIC_NAME.toString() + " under project: " + PROJECT_ID);
    assertThat(bout.toString())
        .contains("Created pull subscription: " + PULL_SUBSCRIPTION_NAME.toString());
    assertThat(bout.toString())
        .contains("Created push subscription: " + PUSH_SUBSCRIPTION_NAME.toString());

    // Verify detach subscription
    assertThat(bout.toString()).contains("Subscription is detached");

    // Verify topic and subscription IAM policy
    assertThat(bout.toString()).contains("Topic policy: etag: \"\\000 \\001");
    assertThat(bout.toString()).contains("Subscription policy: etag: \"\\000 \\001\"");

    // Verify listing of subscriptions and topics
    assertThat(bout.toString()).contains("Subscriptions in project count:");
    assertThat(bout.toString()).contains("Subscriptions under topic:");
    assertThat(bout.toString()).contains("Topic count under project:");

    // Verify update of subscription
    assertThat(bout.toString()).contains("Updated subscription " + PUSH_SUBSCRIPTION_NAME);

    // Verify topic permissions
    assertThat(bout.toString()).contains("Tested topic permissions");
    assertThat(bout.toString()).contains("permissions: \"pubsub.topics.attachSubscription\"");
    assertThat(bout.toString()).contains("permissions: \"pubsub.topics.publish\"");
    assertThat(bout.toString()).contains("permissions: \"pubsub.topics.update\"");

    // Verify subscription permissions
    assertThat(bout.toString()).contains("Tested PubSub subscription permissions");
    assertThat(bout.toString()).contains("permissions: \"pubsub.subscriptions.consume\"");
    assertThat(bout.toString()).contains("permissions: \"pubsub.subscriptions.update\"");
  }

  @Test
  public void testPublishAndSubscribe() throws Exception {
    NativeImagePubSubSample.createTopic(PROJECT_ID, TOPIC_ID);
    NativeImagePubSubSample.createPullSubscription(PROJECT_ID, PULL_SUB_ID, TOPIC_ID);

    bout.reset();

    // Publish
    PublishOperations.publishMessage(PROJECT_ID, TOPIC_ID);
    PublishOperations.publishWithBatchSettings(PROJECT_ID, TOPIC_ID);
    PublishOperations.publishWithCustomAttributes(PROJECT_ID, TOPIC_ID);
    PublishOperations.publishWithErrorHandler(PROJECT_ID, TOPIC_ID);

    // Subscribe
    NativeImagePubSubSample.subscribeSync(PROJECT_ID, PULL_SUB_ID);
    NativeImagePubSubSample.receiveMessagesWithDeliveryAttempts(PROJECT_ID, PULL_SUB_ID);

    assertThat(bout.toString()).contains("Published message with ID");
    assertThat(bout.toString()).contains("Published 100 messages with batch settings.");
    assertThat(bout.toString()).contains("Published a message with custom attributes");
    assertThat(bout.toString()).contains("Success Callback: Published message");
    assertThat(bout.toString()).contains("Success Callback: Published message");
    assertThat(bout.toString()).contains("Received Payload");
    assertThat(bout.toString()).contains("Successfully started an async message receiver");
  }
}
