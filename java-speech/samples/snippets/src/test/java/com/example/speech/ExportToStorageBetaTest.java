/*
 * Copyright 2021 Google LLC
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

package com.example.speech;

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

public class ExportToStorageBetaTest {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String AUDIO_STORAGE_URI =
      "gs://cloud-samples-data/speech/commercial_mono.wav";
  private static final String BUCKET_PREFIX = "EXPORT_TRANSCRIPT_OUTPUT";
  private static final String UNIQUE_ID =
      UUID.randomUUID().toString().replace("-", "").substring(0, 8);
  private static String BUCKET_NAME = String.format("speech-%s", UNIQUE_ID);
  private static final String OUTPUT_STORAGE_URI =
      String.format("gs://%s/%s/", BUCKET_NAME, BUCKET_PREFIX);
  private static final String ENCODING = "LINEAR16";
  private static final String LANGUAGE_CODE = "en-US";
  private static Storage storage = StorageOptions.getDefaultInstance().getService();

  private static final int SAMPLE_RATE_HERTZ = 8000;

  private ByteArrayOutputStream bout;
  private PrintStream originalPrintStream;
  private PrintStream out;

  private static void createBucket() {
    storage.create(BucketInfo.of(BUCKET_NAME));
  }

  private static void cleanUpBucket() {
    Page<Blob> blobs =
        storage.list(
            PROJECT_ID,
            Storage.BlobListOption.currentDirectory(),
            Storage.BlobListOption.prefix(BUCKET_PREFIX));

    deleteDirectory(storage, blobs);
  }

  private static void deleteDirectory(Storage storage, Page<Blob> blobs) {
    for (Blob blob : blobs.iterateAll()) {
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

  @Before
  public void setUp() {
    createBucket();
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    cleanUpBucket();
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testExportToStorageBeta() throws Exception {
    ExportToStorageBeta.exportToStorage(
        AUDIO_STORAGE_URI,
        OUTPUT_STORAGE_URI,
        ENCODING,
        SAMPLE_RATE_HERTZ,
        LANGUAGE_CODE,
        BUCKET_NAME,
        BUCKET_PREFIX);
    String got = bout.toString();
    assertThat(got).contains("Transcription:");
  }
}
