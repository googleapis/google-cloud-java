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

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class ExportDatasetTest {

  private static final String PROJECT_ID = System.getenv("AUTOML_PROJECT_ID");
  private static final String DATASET_ID = System.getenv("ENTITY_EXTRACTION_DATASET_ID");
  private static final String BUCKET_ID = PROJECT_ID + "-lcm";
  private static final String BUCKET = "gs://" + BUCKET_ID;
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
    requireEnvVar("ENTITY_EXTRACTION_DATASET_ID");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // Delete the created files from GCS
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

    System.setOut(null);
  }

  @Test
  public void testExportDataset() throws IOException, ExecutionException, InterruptedException {
    ExportDataset.exportDataset(PROJECT_ID, DATASET_ID, BUCKET + "/TEST_EXPORT_OUTPUT/");
    String got = bout.toString();
    assertThat(got).contains("Dataset exported.");
  }
}
