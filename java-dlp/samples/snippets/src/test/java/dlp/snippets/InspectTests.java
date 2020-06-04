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

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertNotNull;

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.CancelDlpJobRequest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class InspectTests {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String GCS_PATH = System.getenv("GCS_PATH");
  private static final String TOPIC_ID = System.getenv("PUB_SUB_TOPIC");
  private static final String SUBSCRIPTION_ID = System.getenv("PUB_SUB_SUBSCRIPTION");
  private static final String DATASET_ID = System.getenv("BIGQUERY_DATASET");
  private static final String TABLE_ID = System.getenv("BIGQUERY_TABLE");
  // TODO: Update as ENV_VARs
  private static final String datastoreNamespace = "";
  private static final String datastoreKind = "dlp";
  private ByteArrayOutputStream bout;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        String.format("Environment variable '%s' must be set to perform these tests.", varName),
        System.getenv(varName));
  }

  @Before
  public void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
    requireEnvVar("GCS_PATH");
    requireEnvVar("PUB_SUB_TOPIC");
    requireEnvVar("PUB_SUB_SUBSCRIPTION");
    requireEnvVar("BIGQUERY_DATASET");
    requireEnvVar("BIGQUERY_TABLE");
  }

  @Before
  public void captureOut() {
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));
  }

  @After
  public void releaseOut() {
    System.setOut(null);
    bout.reset();
  }

  @Test
  public void testInspectPhoneNumber() {
    InspectString.inspectString(PROJECT_ID, "My phone number is (415) 555-0890");

    String output = bout.toString();
    assertThat(output, containsString("Info type: PHONE_NUMBER"));
  }

  @Test
  public void testInspectString() {
    InspectString.inspectString(PROJECT_ID, "I'm Gary and my email is gary@example.com");

    String output = bout.toString();
    assertThat(output, containsString("Info type: EMAIL_ADDRESS"));
  }


  @Test
  public void testInspectStringWithExclusionDict() {
    InspectStringWithExclusionDict.inspectStringWithExclusionDict(PROJECT_ID,
        "Some email addresses: gary@example.com, example@example.com",
        Arrays.asList("example@example.com"));

    String output = bout.toString();
    assertThat(output, containsString("gary@example.com"));
    assertThat(output, not(containsString("example@example.com")));
  }

  @Test
  public void testInspectStringWithExclusionDictSubstring() {
    InspectStringWithExclusionDictSubstring.inspectStringWithExclusionDictSubstring(PROJECT_ID,
        "Some email addresses: gary@example.com, TEST@example.com",
        Arrays.asList("TEST"));

    String output = bout.toString();
    assertThat(output, containsString("gary@example.com"));
    assertThat(output, not(containsString("TEST@example.com")));
  }

  @Test
  public void testInspectStringWithExclusionRegex() {
    InspectStringWithExclusionRegex.inspectStringWithExclusionRegex(PROJECT_ID,
        "Some email addresses: gary@example.com, bob@example.org",
        ".+@example.com");

    String output = bout.toString();
    assertThat(output, containsString("bob@example.org"));
    assertThat(output, not(containsString("gary@example.com")));
  }

  @Test
  public void testInspectStringCustomExcludingSubstring() {
    InspectStringCustomExcludingSubstring.inspectStringCustomExcludingSubstring(PROJECT_ID,
        "Name: Doe, John. Name: Example, Jimmy",
        "[A-Z][a-z]{1,15}, [A-Z][a-z]{1,15}",
        Arrays.asList("Jimmy"));

    String output = bout.toString();
    assertThat(output, containsString("Doe, John"));
    assertThat(output, not(containsString("Example, Jimmy")));
  }

  @Test
  public void textInspectTestFile() {
    InspectTextFile.inspectTextFile(PROJECT_ID, "src/test/resources/test.txt");
    String output = bout.toString();
    assertThat(output, containsString("Info type: PHONE_NUMBER"));
    assertThat(output, containsString("Info type: EMAIL_ADDRESS"));
  }

  @Test
  public void testInspectImageFile() {
    InspectImageFile.inspectImageFile(PROJECT_ID, "src/test/resources/test.png");

    String output = bout.toString();
    assertThat(output, containsString("Info type: PHONE_NUMBER"));
    assertThat(output, containsString("Info type: EMAIL_ADDRESS"));
  }

  @Test
  public void testInspectGcsFile() throws Exception {
    InspectGcsFile.inspectGcsFile(PROJECT_ID, GCS_PATH, TOPIC_ID, SUBSCRIPTION_ID);

    String output = bout.toString();
    assertThat(output, containsString("Job status: DONE"));
  }

  @Test
  public void testInspectDatastoreEntity() throws Exception {

    InspectDatastoreEntity.insepctDatastoreEntity(
        PROJECT_ID, datastoreNamespace, datastoreKind, TOPIC_ID, SUBSCRIPTION_ID);

    String output = bout.toString();
    assertThat(output, containsString("Job status: DONE"));
  }

  @Test
  public void testInspectBigQueryTable() throws Exception {

    InspectBigQueryTable
        .inspectBigQueryTable(PROJECT_ID, DATASET_ID, TABLE_ID, TOPIC_ID, SUBSCRIPTION_ID);

    String output = bout.toString();
    assertThat(output, containsString("Job status: DONE"));
  }
}
