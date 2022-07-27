/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
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
import org.junit.Ignore;
import org.junit.Test;

public class CreateBatchPredictionJobVideoActionRecognitionSampleTest {
  private static final String PROJECT = System.getenv("UCAIP_PROJECT_ID");
  private static final String MODEL_ID =
      System.getenv("BATCH_PREDICTION_VIDEO_ACTION_RECOGNITION_MODEL_ID");
  private static final String GCS_SOURCE_URI =
      "gs://ucaip-samples-test-output/inputs/icn_batch_prediction_input.jsonl";
  private static final String GCS_OUTPUT_URI = "gs://ucaip-samples-test-output/";
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;
  private String batchPredictionJobId;

  private static void requireEnvVar(String varName) {
    String errorMessage =
        String.format("Environment variable '%s' is required to perform these tests.", varName);
    assertNotNull(errorMessage, System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("UCAIP_PROJECT_ID");
    requireEnvVar("BATCH_PREDICTION_VIDEO_ACTION_RECOGNITION_MODEL_ID");
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
    CancelBatchPredictionJobSample.cancelBatchPredictionJobSample(PROJECT, batchPredictionJobId);

    // Assert
    String cancelResponse = bout.toString();
    assertThat(cancelResponse).contains("Cancelled the Batch Prediction Job");
    TimeUnit.MINUTES.sleep(2);

    // Delete the Batch Prediction Job
    DeleteBatchPredictionJobSample.deleteBatchPredictionJobSample(PROJECT, batchPredictionJobId);

    // Assert
    String deleteResponse = bout.toString();
    assertThat(deleteResponse).contains("Deleted Batch");
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  @Ignore("https://github.com/googleapis/java-aiplatform/issues/420")
  public void testCreateBatchPredictionJobVideoActionRecognitionSample() throws IOException {
    // Act
    String batchPredictionDisplayName =
        String.format(
            "batch_prediction_video_action_recognition_display_name_%s",
            UUID.randomUUID().toString().replaceAll("-", "_").substring(0, 26));

    CreateBatchPredictionJobVideoActionRecognitionSample
        .createBatchPredictionJobVideoActionRecognitionSample(
            PROJECT, batchPredictionDisplayName, MODEL_ID, GCS_SOURCE_URI, GCS_OUTPUT_URI);

    // Assert
    String got = bout.toString();
    assertThat(got).contains(batchPredictionDisplayName);
    assertThat(got).contains("response:");
    batchPredictionJobId = got.split("Name: ")[1].split("batchPredictionJobs/")[1].split("\n")[0];
  }
}
