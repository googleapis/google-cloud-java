/*
 * Copyright 2017 Google Inc.
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

package dlp.snippets;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.common.collect.ImmutableList;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.TopicName;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
@RunWith(JUnit4.class)
public class RiskAnalysisTests extends TestBase {

  private UUID testRunUuid = UUID.randomUUID();
  private TopicName topicName =
      TopicName.of(PROJECT_ID, String.format("%s-%s", TOPIC_ID, testRunUuid.toString()));
  private ProjectSubscriptionName subscriptionName =
      ProjectSubscriptionName.of(
          PROJECT_ID, String.format("%s-%s", SUBSCRIPTION_ID, testRunUuid.toString()));

  @Override
  protected ImmutableList<String> requiredEnvVars() {
    return ImmutableList.of(
        "GOOGLE_APPLICATION_CREDENTIALS",
        "GOOGLE_CLOUD_PROJECT",
        "PUB_SUB_TOPIC",
        "PUB_SUB_SUBSCRIPTION",
        "BIGQUERY_DATASET",
        "BIGQUERY_TABLE");
  }

  @Before
  public void before() throws Exception {
    // Create a new topic
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      topicAdminClient.createTopic(topicName);
    }
    // Create a new subscription
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      subscriptionAdminClient.createSubscription(
          subscriptionName, topicName, PushConfig.getDefaultInstance(), 0);
    }
  }

  @After
  public void after() throws Exception {
    // Delete the test topic
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      topicAdminClient.deleteTopic(topicName);
    } catch (ApiException e) {
      System.err.println(String.format("Error deleting topic %s: %s", topicName.getTopic(), e));
      // Keep trying to clean up
    }

    // Delete the test subscription
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      subscriptionAdminClient.deleteSubscription(subscriptionName);
    } catch (ApiException e) {
      System.err.println(
          String.format(
              "Error deleting subscription %s: %s", subscriptionName.getSubscription(), e));
      // Keep trying to clean up
    }
  }

  @Test
  public void testNumericalStats() throws Exception {
    RiskAnalysisNumericalStats.numericalStatsAnalysis(
        PROJECT_ID, DATASET_ID, TABLE_ID, topicName.getTopic(), subscriptionName.getSubscription());
    String output = bout.toString();
    assertThat(output).contains("Value at ");
  }

  @Test
  public void testCategoricalStats() throws Exception {
    RiskAnalysisCategoricalStats.categoricalStatsAnalysis(
        PROJECT_ID, DATASET_ID, TABLE_ID, topicName.getTopic(), subscriptionName.getSubscription());

    String output = bout.toString();

    assertThat(output).containsMatch("Most common value occurs \\d time");
    assertThat(output).containsMatch("Least common value occurs \\d time");
  }

  @Test
  public void testKAnonymity() throws Exception {
    RiskAnalysisKAnonymity.calculateKAnonymity(
        PROJECT_ID, DATASET_ID, TABLE_ID, topicName.getTopic(), subscriptionName.getSubscription());
    String output = bout.toString();
    assertThat(output).containsMatch("Bucket size range: \\[\\d, \\d\\]");
    assertThat(output).contains("Quasi-ID values: integer_value: 19");
    assertThat(output).contains("Class size: 1");
  }

  @Test
  public void testLDiversity() throws Exception {
    RiskAnalysisLDiversity.calculateLDiversity(
        PROJECT_ID, DATASET_ID, TABLE_ID, topicName.getTopic(), subscriptionName.getSubscription());
    String output = bout.toString();
    assertThat(output).contains("Quasi-ID values: integer_value: 19");
    assertThat(output).contains("Class size: 1");
    assertThat(output).contains("Sensitive value string_value: \"James\"");
  }

  @Test
  public void testKMap() throws Exception {
    RiskAnalysisKMap.calculateKMap(
        PROJECT_ID, DATASET_ID, TABLE_ID, topicName.getTopic(), subscriptionName.getSubscription());

    String output = bout.toString();

    assertThat(output).containsMatch("Anonymity range: \\[\\d, \\d]");
    assertThat(output).containsMatch("Size: \\d");
    assertThat(output).containsMatch("Values: \\{\\d{2}, \"Female\"\\}");
  }
}
