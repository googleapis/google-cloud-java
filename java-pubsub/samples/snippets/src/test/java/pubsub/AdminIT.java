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
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
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
  private static final String ingestionTopicId = "ingestion-topic-" + _suffix;
  private static final String pullSubscriptionId = "iam-pull-subscription-" + _suffix;
  private static final String pushSubscriptionId = "iam-push-subscription-" + _suffix;
  private static final String orderedSubscriptionId = "iam-ordered-subscription-" + _suffix;
  private static final String filteredSubscriptionId = "iam-filtered-subscription-" + _suffix;
  private static final String exactlyOnceSubscriptionId =
      "iam-exactly-once-subscription-" + _suffix;
  private static final String pushEndpoint = "https://my-test-project.appspot.com/push";
  private static final String bigqueryDatasetId =
      "java_samples_data_set" + _suffix.replace("-", "_");
  private static final String bigquerySubscriptionId = "iam-bigquery-subscription-" + _suffix;
  private static final String bigqueryTableId = "java_samples_table_" + _suffix;
  private static final String streamArn =
      "arn:aws:kinesis:us-west-2:111111111111:stream/fake-stream-name";
  private static final String consumerArn =
      "arn:aws:kinesis:us-west-2:111111111111:stream/fake-stream-name/"
          + "consumer/consumer-1:1111111111";
  private static final String consumerArn2 =
      "arn:aws:kinesis:us-west-2:111111111111:stream/fake-stream-name/"
          + "consumer/consumer-2:2222222222";
  private static final String awsRoleArn = "arn:aws:iam::111111111111:role/fake-role-name";
  private static final String gcpServiceAccount =
      "fake-service-account@fake-gcp-project.iam.gserviceaccount.com";

  private static final TopicName topicName = TopicName.of(projectId, topicId);
  private static final TopicName ingestionTopicName = TopicName.of(projectId, ingestionTopicId);
  private static final SubscriptionName pullSubscriptionName =
      SubscriptionName.of(projectId, pullSubscriptionId);
  private static final SubscriptionName pushSubscriptionName =
      SubscriptionName.of(projectId, pushSubscriptionId);
  private static final SubscriptionName orderedSubscriptionName =
      SubscriptionName.of(projectId, orderedSubscriptionId);
  private static final SubscriptionName filteredSubscriptionName =
      SubscriptionName.of(projectId, filteredSubscriptionId);
  private static final SubscriptionName exactlyOnceSubscriptionName =
      SubscriptionName.of(projectId, exactlyOnceSubscriptionId);

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

    // Create table for BigQuery subscription.
    createBigQueryTable();
  }

  @After
  public void tearDown() throws Exception {
    // Delete the subscriptions if they have not been cleaned.
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      try {
        subscriptionAdminClient.deleteSubscription(pullSubscriptionName);
        subscriptionAdminClient.deleteSubscription(pushSubscriptionName);
        subscriptionAdminClient.deleteSubscription(orderedSubscriptionName);
        subscriptionAdminClient.deleteSubscription(filteredSubscriptionName);
        subscriptionAdminClient.deleteSubscription(exactlyOnceSubscriptionName);
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

    // Delete BigQuery table.
    deleteBigQueryTable();

    System.setOut(null);
  }

  private void createBigQueryTable() throws Exception {
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    DatasetInfo datasetInfo = DatasetInfo.newBuilder(projectId, bigqueryDatasetId).build();
    bigquery.create(datasetInfo);

    Schema schema =
        Schema.of(
            Field.of("data", StandardSQLTypeName.STRING),
            Field.of("message_id", StandardSQLTypeName.STRING),
            Field.of("attributes", StandardSQLTypeName.STRING),
            Field.of("subscription_name", StandardSQLTypeName.STRING),
            Field.of("publish_time", StandardSQLTypeName.TIMESTAMP));

    TableId tableId = TableId.of(projectId, bigqueryDatasetId, bigqueryTableId);
    TableDefinition tableDefinition = StandardTableDefinition.of(schema);
    TableInfo tableInfo = TableInfo.newBuilder(tableId, tableDefinition).build();

    bigquery.create(tableInfo);
  }

  private void deleteBigQueryTable() throws Exception {
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    DatasetId datasetId = DatasetId.of(projectId, bigqueryDatasetId);
    bigquery.delete(datasetId, BigQuery.DatasetDeleteOption.deleteContents());
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
    // Test create a subscription with filtering enabled
    CreateSubscriptionWithFiltering.createSubscriptionWithFilteringExample(
        projectId, topicId, filteredSubscriptionId, "attributes.author=\"unknown\"");
    assertThat(bout.toString()).contains("Created a subscription with filtering enabled");
    assertThat(bout.toString())
        .contains("google.pubsub.v1.Subscription.filter=attributes.author=\"unknown\"");

    bout.reset();
    // Test create a subscription with exactly once delivery enabled
    CreateSubscriptionWithExactlyOnceDelivery.createSubscriptionWithExactlyOnceDeliveryExample(
        projectId, topicId, exactlyOnceSubscriptionId);
    assertThat(bout.toString())
        .contains("Created a subscription with exactly once delivery enabled:");
    assertThat(bout.toString()).contains("enable_exactly_once_delivery=true");

    bout.reset();
    // Test create a BigQuery subscription
    String bigqueryTablePath = String.join(".", projectId, bigqueryDatasetId, bigqueryTableId);
    CreateBigQuerySubscriptionExample.createBigQuerySubscription(
        projectId, topicId, bigquerySubscriptionId, bigqueryTablePath);
    assertThat(bout.toString()).contains("Created a BigQuery subscription:");
    assertThat(bout.toString()).contains(bigqueryTablePath);

    bout.reset();
    // Test delete subscription.
    DeleteSubscriptionExample.deleteSubscriptionExample(projectId, pullSubscriptionId);
    DeleteSubscriptionExample.deleteSubscriptionExample(projectId, pushSubscriptionId);
    DeleteSubscriptionExample.deleteSubscriptionExample(projectId, orderedSubscriptionId);
    DeleteSubscriptionExample.deleteSubscriptionExample(projectId, exactlyOnceSubscriptionId);
    DeleteSubscriptionExample.deleteSubscriptionExample(projectId, bigquerySubscriptionId);
    assertThat(bout.toString()).contains("Deleted subscription.");

    bout.reset();
    // Update topic type to Kinesis ingestion.
    UpdateTopicTypeExample.updateTopicTypeExample(
        projectId, topicId, streamArn, consumerArn, awsRoleArn, gcpServiceAccount);
    assertThat(bout.toString()).contains("google.pubsub.v1.Topic.name=" + topicName.toString());
    assertThat(bout.toString()).contains(streamArn);
    assertThat(bout.toString()).contains(consumerArn);
    assertThat(bout.toString()).contains(awsRoleArn);
    assertThat(bout.toString()).contains(gcpServiceAccount);

    bout.reset();
    // Test delete topic.
    DeleteTopicExample.deleteTopicExample(projectId, topicId);
    assertThat(bout.toString()).contains("Deleted topic.");

    bout.reset();
    // Test create topic with Kinesis ingestion settings.
    CreateTopicWithKinesisIngestionExample.createTopicWithKinesisIngestionExample(
        projectId, ingestionTopicId, streamArn, consumerArn, awsRoleArn, gcpServiceAccount);
    assertThat(bout.toString())
        .contains("google.pubsub.v1.Topic.name=" + ingestionTopicName.toString());
    assertThat(bout.toString()).contains(streamArn);
    assertThat(bout.toString()).contains(consumerArn);
    assertThat(bout.toString()).contains(awsRoleArn);
    assertThat(bout.toString()).contains(gcpServiceAccount);

    bout.reset();
    // Test update existing Kinesis ingestion settings.
    UpdateTopicTypeExample.updateTopicTypeExample(
        projectId, ingestionTopicId, streamArn, consumerArn2, awsRoleArn, gcpServiceAccount);
    assertThat(bout.toString())
        .contains("google.pubsub.v1.Topic.name=" + ingestionTopicName.toString());
    assertThat(bout.toString()).contains(streamArn);
    assertThat(bout.toString()).contains(consumerArn2);
    assertThat(bout.toString()).contains(awsRoleArn);
    assertThat(bout.toString()).contains(gcpServiceAccount);

    bout.reset();
    // Test delete Kinesis ingestion topic.
    DeleteTopicExample.deleteTopicExample(projectId, ingestionTopicId);
    assertThat(bout.toString()).contains("Deleted topic.");
  }
}
