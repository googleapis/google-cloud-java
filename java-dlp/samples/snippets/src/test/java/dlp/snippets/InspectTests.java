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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class InspectTests {

  private ByteArrayOutputStream bout;

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");

  // TODO: Update as ENV_VARs
  private static final String bucketName = PROJECT_ID + "/dlp";
  private static final String pubSubTopicId = "dlp-tests";
  private static final String pubSubSubscriptionId = "dlp-test";

  private static final String datastoreNamespace = "";
  private static final String datastoreKind = "dlp";

  private static final String BIGQUERY_DATASET = "integration_tests_dlp";

  private static void requireEnvVar(String varName) {
    assertNotNull(
        String.format("Environment variable '%s' must be set to perform these tests.", varName),
        System.getenv(varName));
  }

  @Before
  public void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
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
  public void testInspectString() {
    InspectString.inspectString(PROJECT_ID, "I'm Gary and my email is gary@example.com");

    String output = bout.toString();
    assertThat(output, containsString("Info type: EMAIL_ADDRESS"));
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
  public void testInspectGcsFile() throws InterruptedException, ExecutionException, IOException {
    String gcsUri = String.format("gs://%s/test.txt", bucketName);
    InspectGcsFile.inspectGcsFile(PROJECT_ID, gcsUri, pubSubTopicId, pubSubSubscriptionId);

    String output = bout.toString();
    assertThat(output, containsString("Info type: PHONE_NUMBER"));
    assertThat(output, containsString("Info type: EMAIL_ADDRESS"));
  }

  @Test
  public void testInspectDatastoreEntity()
      throws InterruptedException, ExecutionException, IOException {
    InspectDatastoreEntity.insepctDatastoreEntity(
        PROJECT_ID, datastoreNamespace, datastoreKind, pubSubTopicId, pubSubSubscriptionId);

    String output = bout.toString();
    assertThat(output, containsString("Info type: PHONE_NUMBER"));
    assertThat(output, containsString("Info type: EMAIL_ADDRESS"));
  }

  @Test
  public void testInspectBiqQueryTable()
      throws InterruptedException, ExecutionException, IOException {
    InspectBigQueryTable.inspectBigQueryTable(
        PROJECT_ID, BIGQUERY_DATASET, "harmful", pubSubTopicId, pubSubSubscriptionId);

    String output = bout.toString();
    assertThat(output, containsString("Info type: PHONE_NUMBER"));
  }
}
