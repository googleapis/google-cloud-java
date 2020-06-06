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

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.TopicName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RiskAnalysisTests {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String TOPIC_ID = System.getenv("PUB_SUB_TOPIC");
  private static final String SUBSCRIPTION_ID = System.getenv("PUB_SUB_SUBSCRIPTION");
  private static final String DATASET_ID = System.getenv("BIGQUERY_DATASET");
  private static final String TABLE_ID = System.getenv("BIGQUERY_TABLE");

  private ByteArrayOutputStream bout;
  private UUID testRunUuid = UUID.randomUUID();
  private TopicName topicName = TopicName.of(
      PROJECT_ID,
      String.format("%s-%s", TOPIC_ID, testRunUuid.toString()));
  private ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of(
      PROJECT_ID,
      String.format("%s-%s", SUBSCRIPTION_ID, testRunUuid.toString()));
  private PrintStream originalOut = System.out;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        String.format("Environment variable '%s' must be set to perform these tests.", varName),
        System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
    requireEnvVar("PUB_SUB_TOPIC");
    requireEnvVar("PUB_SUB_SUBSCRIPTION");
    requireEnvVar("BIGQUERY_DATASET");
    requireEnvVar("BIGQUERY_TABLE");
  }

  @Before
  public void setUp() throws Exception {
    // Create a new topic
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      topicAdminClient.createTopic(topicName);
    }
    // Create a new subscription
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      subscriptionAdminClient
          .createSubscription(subscriptionName, topicName, PushConfig.getDefaultInstance(), 0);
    }

    // Capture stdout
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));
  }


  @After
  public void tearDown() throws Exception {
    // Restore stdout
    System.setOut(originalOut);
    bout.reset();

    // Delete the test topic
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      topicAdminClient.deleteTopic(topicName);
    } catch (ApiException e) {
      System.err.println(String.format("Error deleting topic %s: %s",
          topicName.getTopic(), e));
      // Keep trying to clean up
    }

    // Delete the test subscription
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      subscriptionAdminClient.deleteSubscription(subscriptionName);
    } catch (ApiException e) {
      System.err.println(String.format("Error deleting subscription %s: %s",
          subscriptionName.getSubscription(), e));
      // Keep trying to clean up
    }
  }

  @Test
  public void testNumericalStats() throws Exception {
    RiskAnalysisNumericalStats.numericalStatsAnalysis(
        PROJECT_ID, DATASET_ID, TABLE_ID, topicName.getTopic(), subscriptionName.getSubscription());
    String output = bout.toString();
    assertThat(output, containsString("Value at "));
  }

  @Test
  public void testCategoricalStats() throws Exception {
    RiskAnalysisCategoricalStats.categoricalStatsAnalysis(
        PROJECT_ID, DATASET_ID, TABLE_ID, topicName.getTopic(), subscriptionName.getSubscription());

    String output = bout.toString();

    assertTrue(Pattern.compile("Most common value occurs \\d time").matcher(output).find());
    assertTrue(Pattern.compile("Least common value occurs \\d time").matcher(output).find());
  }

  @Test
  public void testKAnonymity() throws Exception {
    RiskAnalysisKAnonymity.calculateKAnonymity(
        PROJECT_ID, DATASET_ID, TABLE_ID, topicName.getTopic(), subscriptionName.getSubscription());
    String output = bout.toString();
    assertTrue(Pattern.compile("Bucket size range: \\[\\d, \\d\\]").matcher(output).find());
    assertTrue(output.contains("Quasi-ID values: integer_value: 19"));
    assertTrue(output.contains("Class size: 1"));
  }

  @Test
  public void testLDiversity() throws Exception {
    RiskAnalysisLDiversity.calculateLDiversity(
        PROJECT_ID, DATASET_ID, TABLE_ID, topicName.getTopic(), subscriptionName.getSubscription());
    String output = bout.toString();
    assertTrue(output.contains("Quasi-ID values: integer_value: 19"));
    assertTrue(output.contains("Class size: 1"));
    assertTrue(output.contains("Sensitive value string_value: \"James\""));
  }

  @Test
  public void testKMap() throws Exception {
    RiskAnalysisKMap.calculateKMap(
        PROJECT_ID, DATASET_ID, TABLE_ID, topicName.getTopic(), subscriptionName.getSubscription());

    String output = bout.toString();

    assertTrue(Pattern.compile("Anonymity range: \\[\\d, \\d]").matcher(output).find());
    assertTrue(Pattern.compile("Size: \\d").matcher(output).find());
    assertTrue(Pattern.compile("Values: \\{\\d{2}, \"Female\"\\}").matcher(output).find());
  }
}
