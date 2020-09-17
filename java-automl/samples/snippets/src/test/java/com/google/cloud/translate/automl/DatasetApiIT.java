/*
 * Copyright 2018 Google Inc.
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

package com.google.cloud.translate.automl;

import static com.google.common.truth.Truth.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for Automl translation "Dataset API" sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DatasetApiIT {

  private static final String PROJECT_ID = "java-docs-samples-testing";
  private static final String BUCKET = PROJECT_ID + "-vcm";
  private static final String COMPUTE_REGION = "us-central1";
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;
  private DatasetApi app;
  private String datasetId;
  private String getdatasetId = "TRL3946265060617537378";

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
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
    DatasetApi.createDataset(PROJECT_ID, COMPUTE_REGION, datasetName, "en", "ja");

    // Assert
    String got = bout.toString();
    datasetId =
        bout.toString()
            .split("\n")[0]
            .split("/")[(bout.toString().split("\n")[0]).split("/").length - 1];
    assertThat(got).contains("Dataset id:");

    // Act
    DatasetApi.importData(
        PROJECT_ID, COMPUTE_REGION, datasetId, "gs://" + BUCKET + "/en-ja-short.csv");

    // Assert
    got = bout.toString();
    assertThat(got).contains("Dataset id:");

    // Act
    DatasetApi.deleteDataset(PROJECT_ID, COMPUTE_REGION, datasetId);

    // Assert
    got = bout.toString();
    assertThat(got).contains("Dataset deleted.");
  }

  @Test
  public void testListDataset() throws IOException {
    // Act
    DatasetApi.listDatasets(PROJECT_ID, COMPUTE_REGION, "translation_dataset_metadata:*");

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Dataset id:");
  }

  @Test
  public void testGetDataset() throws IOException {

    // Act
    DatasetApi.getDataset(PROJECT_ID, COMPUTE_REGION, getdatasetId);

    // Assert
    String got = bout.toString();

    assertThat(got).contains("Dataset id:");
  }
}
