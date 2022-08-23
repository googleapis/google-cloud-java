/*
 * Copyright 2022 Google LLC
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

package com.optimizationai;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** Tests for AsyncApi sample. */
public class AsyncApiTest {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String PROJECT_PARENT = String.format("projects/%s", PROJECT_ID);
  private static final String BUCKET_NAME =
      String.format("optimizationai-test-%s", UUID.randomUUID());
  private static final String INPUT_URI =
      "gs://cloud-samples-data/optimization-ai/async_request_model.json";
  private static final String BATCH_OUTPUT_URI =
      String.format("gs://%s/code_snippets_test_output.json", BUCKET_NAME);

  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static void cleanUpBucket() {
    Storage storage = StorageOptions.getDefaultInstance().getService();
    Page<Blob> blobs = storage.list(BUCKET_NAME, Storage.BlobListOption.currentDirectory());

    deleteDirectory(storage, blobs);
  }

  private static void deleteDirectory(Storage storage, Page<Blob> blobs) {
    for (Blob blob : blobs.iterateAll()) {
      if (!blob.delete()) {
        Page<Blob> subBlobs =
            storage.list(
                BUCKET_NAME,
                Storage.BlobListOption.currentDirectory(),
                Storage.BlobListOption.prefix(blob.getName()));

        deleteDirectory(storage, subBlobs);
      }
    }
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    Storage storage = StorageOptions.getDefaultInstance().getService();
    storage.create(BucketInfo.of(BUCKET_NAME));
  }

  @After
  public void tearDown() {
    cleanUpBucket();
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testAsyncApi() throws Exception {
    AsyncApi.callAsyncApi(PROJECT_PARENT, INPUT_URI, BATCH_OUTPUT_URI);
    String got = bout.toString();
    assertThat(got).contains("Job");
  }
}
