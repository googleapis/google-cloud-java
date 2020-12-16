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

public class CreateTrainingPipelineTabularRegressionSampleTest {

  private static final String PROJECT = System.getenv("UCAIP_PROJECT_ID");
  private static final String DATASET_ID =
      System.getenv("TRAINING_PIPELINE_TABLES_REGRESSION_DATASET_ID");
  private static final String TARGET_COLUMN = "Amount";
  private static final String TRANSFORMATION =
      "[{\"categorical\":{\"columnName\":\"SC_Group_Desc\"}},"
          + "{\"categorical\":{\"columnName\":\"SC_GroupCommod_ID\"}},"
          + "{\"categorical\":{\"columnName\":\"SC_GroupCommod_Desc\"}},"
          + "{\"numeric\":{\"columnName\":\"SortOrder\",\"invalidValuesAllowed\":false}},"
          + "{\"text\":{\"columnName\":\"SC_GeographyIndented_Desc\"}},"
          + "{\"numeric\":{\"columnName\":\"SC_Commodity_ID\",\"invalidValuesAllowed\":false}},"
          + "{\"text\":{\"columnName\":\"SC_Commodity_Desc\"}},"
          + "{\"numeric\":{\"columnName\":\"SC_Attribute_ID\",\"invalidValuesAllowed\":false}},"
          + "{\"text\":{\"columnName\":\"SC_Attribute_Desc\"}},"
          + "{\"numeric\":{\"columnName\":\"SC_Unit_ID\",\"invalidValuesAllowed\":false}},"
          + "{\"numeric\":{\"columnName\":\"Year_ID\",\"invalidValuesAllowed\":false}},"
          + "{\"categorical\":{\"columnName\":\"SC_Frequency_Desc\"}},"
          + "{\"numeric\":{\"columnName\":\"Timeperiod_ID\",\"invalidValuesAllowed\":false}},"
          + "{\"text\":{\"columnName\":\"Timeperiod_Desc\"}}]";
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
    requireEnvVar("TRAINING_PIPELINE_TABLES_REGRESSION_DATASET_ID");
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
    CancelTrainingPipelineSample.cancelTrainingPipelineSample(PROJECT, trainingPipelineId);

    // Assert
    String cancelResponse = bout.toString();
    assertThat(cancelResponse).contains("Cancelled the Training Pipeline");
    TimeUnit.MINUTES.sleep(2);

    // Delete the Training Pipeline
    DeleteTrainingPipelineSample.deleteTrainingPipelineSample(PROJECT, trainingPipelineId);

    // Assert
    String deleteResponse = bout.toString();
    assertThat(deleteResponse).contains("Deleted Training Pipeline.");
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void createTrainingPipelineTabularRegression() throws IOException {
    // Act
    String modelDisplayName =
        String.format(
            "temp_create_training_pipelinetabularregression_model_test_%s",
            UUID.randomUUID().toString().replaceAll("-", "_").substring(0, 26));

    CreateTrainingPipelineTabularRegressionSample.createTrainingPipelineTableRegression(
        PROJECT, modelDisplayName, DATASET_ID, TARGET_COLUMN, TRANSFORMATION);

    // Assert
    String got = bout.toString();
    assertThat(got).contains(DATASET_ID);
    assertThat(got).contains("Create Training Pipeline Tabular Regression Response");
    trainingPipelineId = got.split("Name: ")[1].split("trainingPipelines/")[1].split("\n")[0];
  }
}
