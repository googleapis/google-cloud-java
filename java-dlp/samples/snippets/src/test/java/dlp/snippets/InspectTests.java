/*
 * Copyright 2019 Google LLC
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
import com.google.privacy.dlp.v2.FieldId;
import com.google.privacy.dlp.v2.Table;
import com.google.privacy.dlp.v2.Table.Row;
import com.google.privacy.dlp.v2.Value;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.TopicName;
import java.util.Arrays;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class InspectTests extends TestBase {

  // TODO: Update as ENV_VARs
  private static final String datastoreNamespace = "";
  private static final String datastoreKind = "dlp";
  private static final String DOCUMENT_INPUT_FILE = "src/test/resources/sensitive-data-image.jpg";

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
        "GCS_PATH",
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
  public void testInspectPhoneNumber() throws Exception {
    InspectString.inspectString(PROJECT_ID, "My phone number is (415) 555-0890");

    String output = bout.toString();
    assertThat(output).contains("Info type: PHONE_NUMBER");
  }

  @Test
  public void testInspectString() throws Exception {
    InspectString.inspectString(PROJECT_ID, "I'm Gary and my email is gary@example.com");

    String output = bout.toString();
    assertThat(output).contains("Info type: EMAIL_ADDRESS");
  }

  @Test
  public void testInspectWithCustomRegex() throws Exception {
    InspectWithCustomRegex.inspectWithCustomRegex(
        PROJECT_ID, "Patients MRN 444-5-22222", "[1-9]{3}-[1-9]{1}-[1-9]{5}");

    String output = bout.toString();
    assertThat(output).contains("Info type: C_MRN");
  }

  @Test
  public void testInspectStringWithExclusionDict() throws Exception {
    InspectStringWithExclusionDict.inspectStringWithExclusionDict(
        PROJECT_ID,
        "Some email addresses: gary@example.com, example@example.com",
        Arrays.asList("example@example.com"));

    String output = bout.toString();
    assertThat(output).contains("gary@example.com");
    assertThat(output).doesNotContain("example@example.com");
  }

  @Test
  public void testInspectStringWithExclusionDictSubstring() throws Exception {
    InspectStringWithExclusionDictSubstring.inspectStringWithExclusionDictSubstring(
        PROJECT_ID,
        "Some email addresses: gary@example.com, TEST@example.com",
        Arrays.asList("TEST"));

    String output = bout.toString();
    assertThat(output).contains("gary@example.com");
    assertThat(output).doesNotContain("TEST@example.com");
  }

  @Test
  public void testInspectStringWithExclusionRegex() throws Exception {
    InspectStringWithExclusionRegex.inspectStringWithExclusionRegex(
        PROJECT_ID, "Some email addresses: gary@example.com, bob@example.org", ".+@example.com");

    String output = bout.toString();
    assertThat(output).contains("bob@example.org");
    assertThat(output).doesNotContain("gary@example.com");
  }

  @Test
  public void testInspectStringCustomExcludingSubstring() throws Exception {
    InspectStringCustomExcludingSubstring.inspectStringCustomExcludingSubstring(
        PROJECT_ID,
        "Name: Doe, John. Name: Example, Jimmy",
        "[A-Z][a-z]{1,15}, [A-Z][a-z]{1,15}",
        Arrays.asList("Jimmy"));

    String output = bout.toString();
    assertThat(output).contains("Doe, John");
    assertThat(output).doesNotContain("Example, Jimmy");
  }

  @Test
  public void testInspectStringCustomOmitOverlap() throws Exception {
    InspectStringCustomOmitOverlap.inspectStringCustomOmitOverlap(
        PROJECT_ID, "Name: Jane Doe. Name: Larry Page.");

    String output = bout.toString();
    assertThat(output).contains("Jane Doe");
    assertThat(output).doesNotContain("Larry Page");
  }

  @Test
  public void testInspectStringOmitOverlap() throws Exception {
    InspectStringOmitOverlap.inspectStringOmitOverlap(PROJECT_ID, "james@example.com");

    String output = bout.toString();
    assertThat(output).contains("EMAIL_ADDRESS");
    assertThat(output).doesNotContain("PERSON_NAME");
  }

  @Test
  public void testInspectStringWithoutOverlap() throws Exception {
    InspectStringWithoutOverlap.inspectStringWithoutOverlap(
        PROJECT_ID, "example.com is a domain, james@example.org is an email.");

    String output = bout.toString();
    assertThat(output).contains("example.com");
    assertThat(output).doesNotContain("example.org");
  }

  @Test
  public void testInspectTable() {
    Table tableToInspect =
        Table.newBuilder()
            .addHeaders(FieldId.newBuilder().setName("name").build())
            .addHeaders(FieldId.newBuilder().setName("phone").build())
            .addRows(
                Row.newBuilder()
                    .addValues(Value.newBuilder().setStringValue("John Doe").build())
                    .addValues(Value.newBuilder().setStringValue("(206) 555-0123").build()))
            .build();
    InspectTable.inspectTable(PROJECT_ID, tableToInspect);

    String output = bout.toString();
    assertThat(output).contains("Info type: PHONE_NUMBER");
  }

  @Test
  public void testInspectStringCustomHotword() throws Exception {
    InspectStringCustomHotword.inspectStringCustomHotword(
        PROJECT_ID, "patient name: John Doe", "patient");

    String output = bout.toString();
    assertThat(output).contains("John Doe");
  }

  @Test
  public void testInspectStringCustomHotwordNegativeExample() throws Exception {
    InspectStringCustomHotword.inspectStringCustomHotword(PROJECT_ID, "name: John Doe", "patient");

    String output = bout.toString();
    assertThat(output).doesNotContain("John Doe");
  }

  @Test
  public void testInspectStringMultipleRulesPatientRule() throws Exception {
    InspectStringMultipleRules.inspectStringMultipleRules(PROJECT_ID, "patient name: Jane Doe");

    String output = bout.toString();
    assertThat(output).contains("LIKELY");
  }

  @Test
  public void testInspectStringMultipleRulesDoctorRule() throws Exception {
    InspectStringMultipleRules.inspectStringMultipleRules(PROJECT_ID, "doctor: Jane Doe");

    String output = bout.toString();
    assertThat(output).contains("Findings: 0");
  }

  @Test
  public void testInspectStringMultipleRulesQuasimodoRule() throws Exception {
    InspectStringMultipleRules.inspectStringMultipleRules(PROJECT_ID, "patient: Quasimodo");

    String output = bout.toString();
    assertThat(output).contains("Findings: 0");
  }

  @Test
  public void testInspectStringMultipleRulesRedactedRule() throws Exception {
    InspectStringMultipleRules.inspectStringMultipleRules(PROJECT_ID, "name of patient: REDACTED");

    String output = bout.toString();
    assertThat(output).contains("Findings: 0");
  }

  @Test
  public void textInspectTestFile() throws Exception {
    InspectTextFile.inspectTextFile(PROJECT_ID, "src/test/resources/test.txt");
    String output = bout.toString();
    assertThat(output).contains("Info type: PHONE_NUMBER");
    assertThat(output).contains("Info type: EMAIL_ADDRESS");
  }

  @Test
  public void testInspectImageFile() throws Exception {
    InspectImageFile.inspectImageFile(PROJECT_ID, "src/test/resources/test.png");

    String output = bout.toString();
    assertThat(output).contains("Info type: PHONE_NUMBER");
    assertThat(output).contains("Info type: EMAIL_ADDRESS");
  }

  @Test
  public void testRedactImageAllInfoTypes() throws Exception {
    InspectImageFileAllInfoTypes.inspectImageFileAllInfoTypes(PROJECT_ID, DOCUMENT_INPUT_FILE);

    String output = bout.toString();
    assertThat(output).contains("Info type: PHONE_NUMBER");
    assertThat(output).contains("Info type: EMAIL_ADDRESS");
    assertThat(output).contains("Info type: DATE");
  }

  @Test
  public void testRedactImageListedInfoTypes() throws Exception {
    InspectImageFileListedInfoTypes.inspectImageFileListedInfoTypes(
        PROJECT_ID, DOCUMENT_INPUT_FILE);

    String output = bout.toString();
    assertThat(output).contains("Info type: PHONE_NUMBER");
    assertThat(output).contains("Info type: EMAIL_ADDRESS");
    assertThat(output).doesNotContain("Info type: DATE");
  }

  @Test
  public void testInspectGcsFile() throws Exception {
    InspectGcsFile.inspectGcsFile(
        PROJECT_ID, GCS_PATH, topicName.getTopic(), subscriptionName.getSubscription());

    String output = bout.toString();
    assertThat(output).contains("Job status: DONE");
  }

  @Test
  public void testInspectGcsFileWithSampling() throws Exception {
    InspectGcsFileWithSampling.inspectGcsFileWithSampling(
        PROJECT_ID, GCS_PATH, topicName.getTopic(), subscriptionName.getSubscription());

    String output = bout.toString();
    assertThat(output).contains("Job status: DONE");
  }

  @Test
  public void testInspectDatastoreEntity() throws Exception {
    InspectDatastoreEntity.insepctDatastoreEntity(
        PROJECT_ID,
        datastoreNamespace,
        datastoreKind,
        topicName.getTopic(),
        subscriptionName.getSubscription());

    String output = bout.toString();
    assertThat(output).contains("Job status: DONE");
  }

  @Test
  public void testInspectBigQueryTable() throws Exception {
    InspectBigQueryTable.inspectBigQueryTable(
        PROJECT_ID, DATASET_ID, TABLE_ID, topicName.getTopic(), subscriptionName.getSubscription());

    String output = bout.toString();
    assertThat(output).contains("Job status: DONE");
  }

  @Test
  public void testInspectBigQueryTableWithSampling() throws Exception {
    InspectBigQueryTableWithSampling.inspectBigQueryTableWithSampling(
        PROJECT_ID, topicName.getTopic(), subscriptionName.getSubscription());

    String output = bout.toString();
    assertThat(output).contains("Job status: DONE");
  }

  @Test
  public void testInspectWithHotwordRules() throws Exception {
    InspectWithHotwordRules.inspectWithHotwordRules(
        PROJECT_ID,
        "Patient's MRN 444-5-22222 and just a number 333-2-33333",
        "[1-9]{3}-[1-9]{1}-[1-9]{5}",
        "(?i)(mrn|medical)(?-i)");

    String output = bout.toString();
    assertThat(output).contains("Findings: 2");
    assertThat(output).contains("Info type: C_MRN");
  }
}
