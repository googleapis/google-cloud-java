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
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ExportModelVideoActionRecognitionSampleTest {
  private static final String PROJECT = System.getenv("UCAIP_PROJECT_ID");
  private static final String MODEL_ID =
      System.getenv("EXPORT_MODEL_VIDEO_ACTION_RECOGNITION_MODEL_ID");
  private static final String GCS_DESTINATION_URI_PREFIX =
      "gs://ucaip-samples-test-output/tmp/export_model_video_action_recognition_sample";
  private static final String EXPORT_FORMAT = "tf-saved-model";
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static void requireEnvVar(String varName) {
    String errorMessage =
        String.format("Environment variable '%s' is required to perform these tests.", varName);
    assertNotNull(errorMessage, System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("UCAIP_PROJECT_ID");
    requireEnvVar("EXPORT_MODEL_VIDEO_ACTION_RECOGNITION_MODEL_ID");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // Delete the export model
    String bucketName = GCS_DESTINATION_URI_PREFIX.split("/", 4)[2];
    String objectName = (GCS_DESTINATION_URI_PREFIX.split("/", 4)[3]).concat("model-" + MODEL_ID);
    DeleteExportModelSample.deleteExportModelSample(PROJECT, bucketName, objectName);

    // Assert
    String deleteResponse = bout.toString();
    assertThat(deleteResponse).contains("Export Model Deleted");
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  @Ignore("https://github.com/googleapis/java-aiplatform/issues/420")
  public void testExportModelVideoActionRecognitionSample()
      throws InterruptedException, ExecutionException, TimeoutException, IOException {
    // Act
    ExportModelVideoActionRecognitionSample.exportModelVideoActionRecognitionSample(
        PROJECT, MODEL_ID, GCS_DESTINATION_URI_PREFIX, EXPORT_FORMAT);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("exportModelResponse: ");
  }
}
