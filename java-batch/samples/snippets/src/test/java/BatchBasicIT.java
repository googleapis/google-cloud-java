// Copyright 2022 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BatchBasicIT {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String REGION = "europe-north1";
  private static String SCRIPT_JOB_NAME;
  private static String CONTAINER_JOB_NAME;

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

    String uuid = String.valueOf(UUID.randomUUID());
    SCRIPT_JOB_NAME = "test-job-script-" + uuid;
    CONTAINER_JOB_NAME = "test-job-container-" + uuid;

    CreateWithContainerNoMounting.createContainerJob(PROJECT_ID, REGION, CONTAINER_JOB_NAME);
    assertThat(stdOut.toString())
        .contains(
            "Successfully created the job: "
                + String.format(
                    "projects/%s/locations/%s/jobs/%s", PROJECT_ID, REGION, CONTAINER_JOB_NAME));
    CreateWithScriptNoMounting.createScriptJob(PROJECT_ID, REGION, SCRIPT_JOB_NAME);
    assertThat(stdOut.toString())
        .contains(
            "Successfully created the job: "
                + String.format(
                    "projects/%s/locations/%s/jobs/%s", PROJECT_ID, REGION, SCRIPT_JOB_NAME));
    TimeUnit.SECONDS.sleep(10);

    stdOut.close();
    System.setOut(out);
  }

  @AfterClass
  public static void cleanup()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    final PrintStream out = System.out;
    ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));

    DeleteJob.deleteJob(PROJECT_ID, REGION, CONTAINER_JOB_NAME);
    DeleteJob.deleteJob(PROJECT_ID, REGION, SCRIPT_JOB_NAME);

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
  public void testGetJob() throws IOException {
    GetJob.getJob(PROJECT_ID, REGION, CONTAINER_JOB_NAME);
    assertThat(stdOut.toString()).contains("Retrieved the job");
  }

  @Test
  public void testListJobs() throws IOException {
    ListJobs.listJobs(PROJECT_ID, REGION);
    assertThat(stdOut.toString()).contains(CONTAINER_JOB_NAME);
    assertThat(stdOut.toString()).contains(SCRIPT_JOB_NAME);
  }
}
