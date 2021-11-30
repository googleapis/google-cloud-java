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

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.pubsub.v1.SubscriptionName;
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

public class AdminIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static final String projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String _suffix = UUID.randomUUID().toString();
  private static final String topicId = "iam-topic-" + _suffix;
  private static final String pullSubscriptionId = "iam-pull-subscription-" + _suffix;
  private static final String pushSubscriptionId = "iam-push-subscription-" + _suffix;
  private static final String orderedSubscriptionId = "iam-ordered-subscription-" + _suffix;
  private static final String pushEndpoint = "https://my-test-project.appspot.com/push";

  private static final TopicName topicName = TopicName.of(projectId, topicId);
  private static final SubscriptionName pullSubscriptionName =
      SubscriptionName.of(projectId, pullSubscriptionId);
  private static final SubscriptionName pushSubscriptionName =
      SubscriptionName.of(projectId, pushSubscriptionId);
  private static final SubscriptionName orderedSubscriptionName =
      SubscriptionName.of(projectId, orderedSubscriptionId);

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
  }

  @Rule public Timeout globalTimeout = Timeout.seconds(300); // 5 minute timeout

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() throws Exception {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() throws Exception {
    // Delete the subscriptions if they have not been cleaned.
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      try {
        subscriptionAdminClient.deleteSubscription(pullSubscriptionName);
        subscriptionAdminClient.deleteSubscription(pushSubscriptionName);
        subscriptionAdminClient.deleteSubscription(orderedSubscriptionName);
      } catch (NotFoundException ignored) {
        // ignore this as resources may not have been created
      }
    }

    // Delete the topic if it has not been cleaned.
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      topicAdminClient.deleteTopic(topicName.toString());
    } catch (NotFoundException ignored) {
      // ignore this as resources may not have been created
    }
    System.setOut(null);
  }

  @Test
  public void testAdmin() throws Exception {
    // Test create topic.
    CreateTopicExample.createTopicExample(projectId, topicId);
    assertThat(bout.toString()).contains("Created topic: " + topicName.toString());

    bout.reset();
    // Test create pull subscription.
    CreatePullSubscriptionExample.createPullSubscriptionExample(
        projectId, pullSubscriptionId, topicId);
    assertThat(bout.toString())
        .contains("Created pull subscription: " + pullSubscriptionName.toString());

    bout.reset();
    // Test create push subscription.
    CreatePushSubscriptionExample.createPushSubscriptionExample(
        projectId, pushSubscriptionId, topicId, pushEndpoint);
    assertThat(bout.toString())
        .contains("Created push subscription: " + pushSubscriptionName.toString());

    bout.reset();
    // Test list topics in project.
    ListTopicsExample.listTopicsExample(projectId);
    assertThat(bout.toString()).contains("Listed all topics.");

    bout.reset();
    // Test list subscriptions in topic.
    ListSubscriptionsInTopicExample.listSubscriptionInTopicExample(projectId, topicId);
    assertThat(bout.toString()).contains("Listed all the subscriptions in the topic.");

    bout.reset();
    ListSubscriptionsInProjectExample.listSubscriptionInProjectExample(projectId);
    // Test list subscriptions in project.
    assertThat(bout.toString()).contains("Listed all the subscriptions in the project");

    bout.reset();
    // Test update push configuration.
    UpdatePushConfigurationExample.updatePushConfigurationExample(
        projectId, pullSubscriptionId, pushEndpoint);
    assertThat(bout.toString()).contains("Updated push endpoint to: " + pushEndpoint);

    bout.reset();
    // Test get topic IAM policy.
    GetTopicPolicyExample.getTopicPolicyExample(projectId, topicId);
    assertThat(bout.toString()).contains("Topic policy:");

    bout.reset();
    // Test get subscription IAM policy.
    GetSubscriptionPolicyExample.getSubscriptionPolicyExample(projectId, pullSubscriptionId);
    assertThat(bout.toString()).contains("Subscription policy:");

    bout.reset();
    // Test set topic IAM policy.
    SetTopicPolicyExample.setTopicPolicyExample(projectId, topicId);
    assertThat(bout.toString()).contains("New topic policy:");

    bout.reset();
    // Test set subscription IAM policy.
    SetSubscriptionPolicyExample.setSubscriptionPolicyExample(projectId, pullSubscriptionId);
    assertThat(bout.toString()).contains("New subscription policy:");

    bout.reset();
    // Test topic permissions.
    TestTopicPermissionsExample.testTopicPermissionsExample(projectId, topicId);
    assertThat(bout.toString()).contains("permissions: \"pubsub.topics.attachSubscription\"");
    assertThat(bout.toString()).contains("permissions: \"pubsub.topics.publish\"");
    assertThat(bout.toString()).contains("permissions: \"pubsub.topics.update\"");

    bout.reset();
    TestSubscriptionPermissionsExample.testSubscriptionPermissionsExample(
        projectId, pullSubscriptionId);
    // Test subscription permissions.
    assertThat(bout.toString()).contains("permissions: \"pubsub.subscriptions.consume\"");
    assertThat(bout.toString()).contains("permissions: \"pubsub.subscriptions.update\"");

    bout.reset();
    // Test subscription detachment.
    DetachSubscriptionExample.detachSubscriptionExample(projectId, pullSubscriptionId);
    assertThat(bout.toString()).contains("Subscription is detached.");

    bout.reset();
    // Test create a subscription with ordering
    CreateSubscriptionWithOrdering.createSubscriptionWithOrderingExample(
        projectId, topicId, orderedSubscriptionId);
    assertThat(bout.toString()).contains("Created a subscription with ordering");
    assertThat(bout.toString()).contains("enable_message_ordering=true");

    bout.reset();
    // Test delete subscription. Run twice to delete both pull and push subscriptions.
    DeleteSubscriptionExample.deleteSubscriptionExample(projectId, pullSubscriptionId);
    DeleteSubscriptionExample.deleteSubscriptionExample(projectId, pushSubscriptionId);
    DeleteSubscriptionExample.deleteSubscriptionExample(projectId, orderedSubscriptionId);
    assertThat(bout.toString()).contains("Deleted subscription.");

    bout.reset();
    // Test delete topic.
    DeleteTopicExample.deleteTopicExample(projectId, topicId);
    assertThat(bout.toString()).contains("Deleted topic.");
  }
}
