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

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1beta1.CreateDatasetOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.Dataset;
import com.google.cloud.aiplatform.v1beta1.DatasetName;
import com.google.cloud.aiplatform.v1beta1.DatasetServiceClient;
import com.google.cloud.aiplatform.v1beta1.DatasetServiceSettings;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.LocationName;
import com.google.protobuf.Empty;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ImportDataImageClassificationSampleTest {
  private static final String PROJECT = System.getenv("UCAIP_PROJECT_ID");
  private static final String LOCATION = "us-central1";

  private static final String GCS_SOURCE_URI = "gs://ucaip-sample-resources/input.jsonl";
  private String datasetId;
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
  }

  @Before
  public void setUp()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    // create a temp dataset for importing data
    DatasetServiceSettings datasetServiceSettings =
        DatasetServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();
    try (DatasetServiceClient datasetServiceClient =
        DatasetServiceClient.create(datasetServiceSettings)) {

      String metadataSchemaUri =
          "gs://google-cloud-aiplatform/schema/dataset/metadata/image_1.0.0.yaml";
      LocationName locationName = LocationName.of(PROJECT, LOCATION);
      Dataset dataset =
          Dataset.newBuilder()
              .setDisplayName("test_dataset_display_name")
              .setMetadataSchemaUri(metadataSchemaUri)
              .build();

      OperationFuture<Dataset, CreateDatasetOperationMetadata> datasetFuture =
          datasetServiceClient.createDatasetAsync(locationName, dataset);
      Dataset datasetResponse = datasetFuture.get(120, TimeUnit.SECONDS);
      String[] datasetValues = datasetResponse.getName().split("/");
      datasetId = datasetValues[datasetValues.length - 1];
    }
  }

  @After
  public void tearDown() throws InterruptedException, ExecutionException, IOException {
    // delete the temp dataset
    DatasetServiceSettings datasetServiceSettings =
        DatasetServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();
    try (DatasetServiceClient datasetServiceClient =
        DatasetServiceClient.create(datasetServiceSettings)) {
      DatasetName datasetName = DatasetName.of(PROJECT, LOCATION, datasetId);

      OperationFuture<Empty, DeleteOperationMetadata> operationFuture =
          datasetServiceClient.deleteDatasetAsync(datasetName);
      operationFuture.get();
    }

    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  @Ignore("https://github.com/googleapis/java-aiplatform/issues/420")
  public void testImportDataSample()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // Act
    ImportDataImageClassificationSample.importDataImageClassificationSample(
        PROJECT, datasetId, GCS_SOURCE_URI);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Import Data Image Classification Response: ");
  }
}
