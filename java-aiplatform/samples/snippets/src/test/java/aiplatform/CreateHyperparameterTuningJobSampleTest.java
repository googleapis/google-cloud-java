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

package aiplatform;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.aiplatform.v1beta1.JobServiceClient;
import com.google.cloud.aiplatform.v1beta1.JobServiceSettings;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreateHyperparameterTuningJobSampleTest {
  private static final String PROJECT = System.getenv("UCAIP_PROJECT_ID");
  private static final String CONTAINER_IMAGE_URI = "gcr.io/ucaip-test/ucaip-training-test:latest";
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;
  private String hyperparameterJobId;

  private static void requireEnvVar(String varName) {
    String errorMessage =
        String.format("Environment variable '%s' is required to perform these tests.", varName);
    assertNotNull(errorMessage, System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("UCAIP_PROJECT_ID");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown()
      throws InterruptedException, ExecutionException, IOException, TimeoutException {
    JobServiceSettings settings =
        JobServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    try (JobServiceClient client = JobServiceClient.create(settings)) {
      // Cancel hyper parameter job
      String hyperparameterJobName =
          String.format(
              "projects/%s/locations/us-central1/hyperparameterTuningJobs/%s",
              PROJECT, hyperparameterJobId);
      client.cancelHyperparameterTuningJob(hyperparameterJobName);

      TimeUnit.MINUTES.sleep(1);

      // Delete the created job
      client.deleteHyperparameterTuningJobAsync(hyperparameterJobName);
      System.out.flush();
      System.setOut(originalPrintStream);
    }
  }

  @Test
  public void testCreateHyperparameterTuningJobSample() throws IOException {
    String hyperparameterTuningJobDisplayName =
        String.format(
            "temp_hyperparameter_tuning_job_display_name_%s",
            UUID.randomUUID().toString().replaceAll("-", "_").substring(0, 26));

    CreateHyperparameterTuningJobSample.createHyperparameterTuningJobSample(
        PROJECT, hyperparameterTuningJobDisplayName, CONTAINER_IMAGE_URI);

    String got = bout.toString();
    assertThat(got).contains(hyperparameterTuningJobDisplayName);
    assertThat(got).contains("response:");
    hyperparameterJobId =
        got.split("Name: ")[1].split("hyperparameterTuningJobs/")[1].split("\n")[0];
  }
}
