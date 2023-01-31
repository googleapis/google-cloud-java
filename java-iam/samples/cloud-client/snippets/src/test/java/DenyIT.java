/*
 * Copyright 2022 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.iam.v2.PoliciesClient;
import com.google.iam.v2.Policy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DenyIT {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String GOOGLE_APPLICATION_CREDENTIALS =
      System.getenv("GOOGLE_APPLICATION_CREDENTIALS");
  private static String POLICY_ID;

  private ByteArrayOutputStream stdOut;

  // Check if the required environment variables are set.
  public static void requireEnvVar(String envVarName) {
    assertWithMessage(String.format("Missing environment variable '%s' ", envVarName))
        .that(System.getenv(envVarName))
        .isNotEmpty();
  }

  @BeforeClass
  public static void setUp()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    final PrintStream out = System.out;
    ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");

    POLICY_ID = "limit-project-deletion" + UUID.randomUUID();

    CreateDenyPolicy.createDenyPolicy(PROJECT_ID, POLICY_ID);
    assertThat(stdOut.toString()).contains(String.format("Created the deny policy: %s", POLICY_ID));

    stdOut.close();
    System.setOut(out);
  }

  @AfterClass
  public static void cleanup()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    final PrintStream out = System.out;
    ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));

    DeleteDenyPolicy.deleteDenyPolicy(PROJECT_ID, POLICY_ID);
    assertThat(stdOut.toString()).contains(String.format("Deleted the deny policy: %s", POLICY_ID));

    stdOut.close();
    System.setOut(out);
  }

  @Before
  public void beforeEach() {
    stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));
  }

  @After
  public void afterEach() {
    stdOut = null;
    System.setOut(null);
  }

  @Test
  public void testListDenyPolicies() throws IOException {
    ListDenyPolicies.listDenyPolicies(PROJECT_ID);
    assertThat(stdOut.toString()).contains("Listed all deny policies");
  }

  @Test
  public void testGetDenyPolicy() throws IOException {
    GetDenyPolicy.getDenyPolicy(PROJECT_ID, POLICY_ID);
    assertThat(stdOut.toString())
        .contains(String.format("Retrieved the deny policy: %s", POLICY_ID));
    assertThat(stdOut.toString()).contains(POLICY_ID);
  }

  @Test
  public void testUpdateDenyPolicy()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {

    try (PoliciesClient policiesClient = PoliciesClient.create()) {
      // Get the etag from the Deny policy.
      String attachmentPoint =
          String.format("cloudresourcemanager.googleapis.com/projects/%s", PROJECT_ID)
              .replaceAll("/", "%2F");
      String policyParent =
          String.format("policies/%s/denypolicies/%s", attachmentPoint, POLICY_ID);
      Policy policy = policiesClient.getPolicy(policyParent);

      // Test policy update.
      UpdateDenyPolicy.updateDenyPolicy(PROJECT_ID, POLICY_ID, policy.getEtag());
      assertThat(stdOut.toString())
          .contains(String.format("Updated the deny policy: %s", POLICY_ID));
    }
  }
}
