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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CreateTrainingPipelineSampleTest {

  private static final String PROJECT_ID = System.getenv("UCAIP_PROJECT_ID");
  private static final String DATASET_ID = "1084241610289446912";
  private static final String TRAINING_TASK_DEFINITION =
      "gs://google-cloud-aiplatform/schema/trainingjob/definition/"
          + "automl_image_classification_1.0.0.yaml";
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;
  private String trainingPipelineId;

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
    // Cancel the Training Pipeline
    CancelTrainingPipelineSample.cancelTrainingPipelineSample(PROJECT_ID, trainingPipelineId);

    // Assert
    String cancelResponse = bout.toString();
    assertThat(cancelResponse).contains("Cancelled the Training Pipeline");
    TimeUnit.MINUTES.sleep(2);

    // Delete the Training Pipeline
    DeleteTrainingPipelineSample.deleteTrainingPipelineSample(PROJECT_ID, trainingPipelineId);

    // Assert
    String deleteResponse = bout.toString();
    assertThat(deleteResponse).contains("Deleted Training");
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testCreateTrainingPipelineSample()
      throws IOException, InterruptedException, ExecutionException {
    // Act
    String tempUuid = UUID.randomUUID().toString().replaceAll("-", "_").substring(0, 26);
    String trainingPipelineDisplayName =
        String.format("temp_create_training_pipeline_test_%s", tempUuid);

    String modelDisplayName =
        String.format("temp_create_training_pipeline_model_test_%s", tempUuid);

    CreateTrainingPipelineSample.createTrainingPipelineSample(
        PROJECT_ID,
        trainingPipelineDisplayName,
        DATASET_ID,
        TRAINING_TASK_DEFINITION,
        modelDisplayName);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Create Training Pipeline Response");
    trainingPipelineId = got.split("Name: ")[1].split("trainingPipelines/")[1].split("\n")[0];
  }
}
