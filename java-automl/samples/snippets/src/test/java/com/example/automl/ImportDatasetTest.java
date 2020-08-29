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

package com.example.automl;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.api.core.ApiFuture;
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.CreateDatasetRequest;
import com.google.cloud.automl.v1beta1.Dataset;
import com.google.cloud.automl.v1beta1.LocationName;
import com.google.cloud.automl.v1beta1.TextExtractionDatasetMetadata;
import com.google.longrunning.Operation;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.CancellationException;
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
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class ImportDatasetTest {

  private static final String PROJECT_ID = System.getenv("AUTOML_PROJECT_ID");
  private static final String BUCKET_ID = PROJECT_ID + "-lcm";
  private static final String BUCKET = "gs://" + BUCKET_ID;
  private String datasetId;
  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        System.getenv(varName),
        "Environment variable '%s' is required to perform these tests.".format(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("AUTOML_PROJECT_ID");
  }

  @Before
  public void setUp()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // Create a fake dataset to be deleted
    // Create a random dataset name with a length of 32 characters (max allowed by AutoML)
    // To prevent name collisions when running tests in multiple java versions at once.
    // AutoML doesn't allow "-", but accepts "_"
    String datasetName =
        String.format("test_%s", UUID.randomUUID().toString().replace("-", "_").substring(0, 26));
    try (AutoMlClient client = AutoMlClient.create()) {

      LocationName projectLocation = LocationName.of(PROJECT_ID, "us-central1");
      TextExtractionDatasetMetadata metadata = TextExtractionDatasetMetadata.newBuilder().build();
      Dataset dataset =
          Dataset.newBuilder()
              .setDisplayName(datasetName)
              .setTextExtractionDatasetMetadata(metadata)
              .build();

      CreateDatasetRequest request =
          CreateDatasetRequest.newBuilder()
              .setParent(projectLocation.toString())
              .setDataset(dataset)
              .build();
      ApiFuture<Dataset> future = client.createDatasetCallable().futureCall(request);
      Dataset createdDataset = future.get(5, TimeUnit.MINUTES);
      String[] names = createdDataset.getName().split("/");
      datasetId = names[names.length - 1];
    }

    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() throws InterruptedException, ExecutionException, IOException {
    // Delete the created dataset
    DeleteDataset.deleteDataset(PROJECT_ID, datasetId);
    System.setOut(null);
  }

  @Test
  public void testImportDataset()
      throws InterruptedException, ExecutionException, TimeoutException, IOException {

    try {
      ImportDataset.importDataset(PROJECT_ID, datasetId, BUCKET + "/entity-extraction/dataset.csv");
    } catch (CancellationException ex) {
      // capture operation ID from output and wait for that operation to be finished.
      String fullOperationId = ex.getMessage().split("Operation name: ")[1].trim();
      AutoMlClient client = AutoMlClient.create();
      Operation importDatasetLro = client.getOperationsClient().getOperation(fullOperationId);
      while (!importDatasetLro.getDone()) {
        Thread.sleep(3000);
      }
      // retry the import.
      ImportDataset.importDataset(PROJECT_ID, datasetId, BUCKET + "/entity-extraction/dataset.csv");
    }
    String got = bout.toString();

    assertThat(got).contains("Dataset imported.");
  }
}
