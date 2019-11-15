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

package com.example.automl;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

// Tests for Automl vision image classification datasets.
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class VisionClassificationDatasetManagementIT {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String BUCKET_ID = PROJECT_ID + "-vcm";
  private static final String BUCKET = "gs://" + BUCKET_ID;
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private String getdatasetId = "ICN3876092572857648864";

  private static void requireEnvVar(String varName) {
    assertNotNull(
            System.getenv(varName),
            "Environment variable '%s' is required to perform these tests.".format(varName)
    );
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testCreateImportDeleteDataset()
      throws IOException, ExecutionException, InterruptedException {
    // Create a random dataset name with a length of 32 characters (max allowed by AutoML)
    // To prevent name collisions when running tests in multiple java versions at once.
    // AutoML doesn't allow "-", but accepts "_"
    String datasetName =
        String.format("test_%s", UUID.randomUUID().toString().replace("-", "_").substring(0, 26));

    // Act
    VisionClassificationCreateDataset.createDataset(PROJECT_ID, datasetName);

    // Assert
    String got = bout.toString();
    String datasetId = got.split("Dataset id: ")[1].split("\n")[0];

    // Act
    ImportDataset.importDataset(PROJECT_ID, datasetId, BUCKET + "/flower_traindata.csv");

    // Assert
    got = bout.toString();
    assertThat(got).contains("Dataset id:");

    // Act
    DeleteDataset.deleteDataset(PROJECT_ID, datasetId);

    // Assert
    got = bout.toString();
    assertThat(got).contains("Dataset deleted.");
  }

  @Test
  public void testListDataset() throws IOException {
    // Act
    ListDatasets.listDatasets(PROJECT_ID);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Dataset id:");
  }

  @Test
  public void testGetDataset() throws IOException {
    // Act
    GetDataset.getDataset(PROJECT_ID, getdatasetId);

    // Assert
    String got = bout.toString();

    assertThat(got).contains("Dataset id:");
  }

  @Test
  public void testExportDataset() throws IOException, ExecutionException, InterruptedException {
    ExportDataset.exportDataset(PROJECT_ID, getdatasetId, BUCKET + "/TEST_EXPORT_OUTPUT/");

    String got = bout.toString();
    assertThat(got).contains("Dataset exported.");

    Storage storage = StorageOptions.getDefaultInstance().getService();
    Page<Blob> blobs =
        storage.list(
            BUCKET_ID,
            Storage.BlobListOption.currentDirectory(),
            Storage.BlobListOption.prefix("TEST_EXPORT_OUTPUT/"));

    for (Blob blob : blobs.iterateAll()) {
      Page<Blob> fileBlobs =
          storage.list(
              BUCKET_ID,
              Storage.BlobListOption.currentDirectory(),
              Storage.BlobListOption.prefix(blob.getName()));
      for (Blob fileBlob : fileBlobs.iterateAll()) {
        if (!fileBlob.isDirectory()) {
          fileBlob.delete();
        }
      }
    }
  }
}
