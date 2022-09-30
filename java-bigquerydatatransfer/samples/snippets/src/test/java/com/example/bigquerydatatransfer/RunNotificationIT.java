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

package com.example.bigquerydatatransfer;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.datatransfer.v1.TransferConfig;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.Subscription;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RunNotificationIT {

  private static final Logger LOG = Logger.getLogger(RunNotificationIT.class.getName());
  private BigQuery bigquery;
  private ByteArrayOutputStream bout;
  private String name;
  private String displayName;
  private String datasetName;
  private String topicName;
  private String formattedTopicName;
  private String subscriberName;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static final String PROJECT_ID = requireEnvVar("GOOGLE_CLOUD_PROJECT");

  private static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
    return value;
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() throws IOException {
    String id = UUID.randomUUID().toString().substring(0, 8);
    displayName = "MY_SCHEDULE_NAME_TEST_" + id;
    datasetName = "MY_DATASET_NAME_TEST_" + id;
    topicName = "MY_TOPIC_TEST_" + id;
    formattedTopicName = String.format("projects/%s/topics/%s", PROJECT_ID, topicName);
    subscriberName = "MY_SUBSCRIBER_TEST_" + id;
    // create a temporary dataset
    bigquery = BigQueryOptions.getDefaultInstance().getService();
    bigquery.create(DatasetInfo.of(datasetName));
    // create a temporary pubsub topic
    try (TopicAdminClient client = TopicAdminClient.create()) {
      client.createTopic(formattedTopicName);
    }
    // create a temporary subscriber
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      ProjectTopicName projectTopicName = ProjectTopicName.of(PROJECT_ID, topicName);
      ProjectSubscriptionName subscriptionName =
          ProjectSubscriptionName.of(PROJECT_ID, subscriberName);
      subscriptionAdminClient.createSubscription(
          Subscription.newBuilder()
              .setName(subscriptionName.toString())
              .setTopic(projectTopicName.toString())
              .setEnableMessageOrdering(true)
              .build());
    }
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() throws IOException {
    // Clean up
    // delete a temporary subscriber
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      String formatSubscriberName =
          String.format("projects/%s/subscriptions/%s", PROJECT_ID, subscriberName);
      subscriptionAdminClient.deleteSubscription(formatSubscriberName);
    }
    // delete a temporary pubsub topic
    try (TopicAdminClient client = TopicAdminClient.create()) {
      client.deleteTopic(formattedTopicName);
    }
    DeleteScheduledQuery.deleteScheduledQuery(name);
    // delete a temporary dataset
    bigquery.delete(datasetName, BigQuery.DatasetDeleteOption.deleteContents());
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
    LOG.log(Level.INFO, bout.toString());
  }

  @Test
  public void testRunNotification() throws IOException {
    String query =
        "SELECT CURRENT_TIMESTAMP() as current_time, @run_time as intended_run_time, "
            + "@run_date as intended_run_date, 17 as some_integer";
    String destinationTableName =
        "MY_DESTINATION_TABLE_" + UUID.randomUUID().toString().substring(0, 8) + "_{run_date}";
    Map<String, Value> params = new HashMap<>();
    params.put("query", Value.newBuilder().setStringValue(query).build());
    params.put(
        "destination_table_name_template",
        Value.newBuilder().setStringValue(destinationTableName).build());
    params.put("write_disposition", Value.newBuilder().setStringValue("WRITE_TRUNCATE").build());
    params.put("partitioning_field", Value.newBuilder().setStringValue("").build());
    TransferConfig transferConfig =
        TransferConfig.newBuilder()
            .setDestinationDatasetId(datasetName)
            .setDisplayName(displayName)
            .setDataSourceId("scheduled_query")
            .setParams(Struct.newBuilder().putAllFields(params).build())
            .setSchedule("every 24 hours")
            .setNotificationPubsubTopic(formattedTopicName)
            .build();
    RunNotification.runNotification(PROJECT_ID, transferConfig);
    String result = bout.toString();
    name = result.substring(result.indexOf(":") + 1, result.length() - 1);
    assertThat(result).contains("Scheduled query with run notification created successfully");
    assertThat(bout.toString()).contains(name);
  }
}
