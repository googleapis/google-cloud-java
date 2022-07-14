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

package com.example.vision;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.example.vision.snippets.AsyncBatchAnnotateImages;
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

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class AsyncBatchAnnotateImagesTest {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String INPUT_URI = "gs://cloud-samples-data/vision/label/wakeupcat.jpg";
  private static final String PREFIX = String.format("vision/%s/", UUID.randomUUID().toString());
  private static final String OUTPUT_URI = String.format("gs://%s/%s", PROJECT_ID, PREFIX);

  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        System.getenv(varName),
        "Environment variable '%s' is required to perform these tests.".format(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
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
    System.out.flush();
    System.setOut(originalPrintStream);

    Storage storage = StorageOptions.getDefaultInstance().getService();

    Page<Blob> blobs =
        storage.list(
            PROJECT_ID,
            Storage.BlobListOption.currentDirectory(),
            Storage.BlobListOption.prefix(PREFIX));
    for (Blob blob : blobs.iterateAll()) {
      blob.delete();
    }
  }

  @Test
  public void testSetEndpoint() throws IOException, ExecutionException, InterruptedException {
    AsyncBatchAnnotateImages.asyncBatchAnnotateImages(INPUT_URI, OUTPUT_URI);
    String got = bout.toString();
    assertThat(got).contains("Output written to GCS with prefix");
  }
}
