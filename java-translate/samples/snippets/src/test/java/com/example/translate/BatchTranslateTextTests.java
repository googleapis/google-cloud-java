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

package com.example.translate;

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
import java.util.concurrent.TimeoutException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for Batch Translate Text sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class BatchTranslateTextTests {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String INPUT_URI = "gs://cloud-samples-data/translation/text.txt";

  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static void cleanUpBucket() {
    Storage storage = StorageOptions.getDefaultInstance().getService();
    Page<Blob> blobs =
        storage.list(
            PROJECT_ID,
            Storage.BlobListOption.currentDirectory(),
            Storage.BlobListOption.prefix("BATCH_TRANSLATION_OUTPUT/"));

    deleteDirectory(storage, blobs);
  }

  private static void deleteDirectory(Storage storage, Page<Blob> blobs) {
    for (Blob blob : blobs.iterateAll()) {
      System.out.println(blob.getBlobId());
      if (!blob.delete()) {
        Page<Blob> subBlobs =
            storage.list(
                PROJECT_ID,
                Storage.BlobListOption.currentDirectory(),
                Storage.BlobListOption.prefix(blob.getName()));

        deleteDirectory(storage, subBlobs);
      }
    }
  }

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable '%s' is required to perform these tests.".format(varName),
        System.getenv(varName));
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
    cleanUpBucket();
    System.setOut(null);
  }

  @Test
  public void testBatchTranslateText()
      throws InterruptedException, ExecutionException, IOException, TimeoutException {
    BatchTranslateText.batchTranslateText(
        PROJECT_ID, "en", "es", INPUT_URI, "gs://" + PROJECT_ID + "/BATCH_TRANSLATION_OUTPUT/");
    String got = bout.toString();
    assertThat(got).contains("Total Characters: 13");
  }
}
