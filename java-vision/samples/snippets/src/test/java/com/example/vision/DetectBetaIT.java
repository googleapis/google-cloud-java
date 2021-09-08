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

package com.example.vision;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.StorageOptions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for vision "Detect" sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DetectBetaIT {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String BUCKET = "java-docs-samples-testing";
  private static final String OUTPUT_BUCKET = PROJECT_ID;
  private static final String OUTPUT_PREFIX = "OUTPUT_VISION_BETA_" + UUID.randomUUID().toString();
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;
  private DetectBeta app;

  @Before
  public void setUp() throws IOException {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
    app = new DetectBeta();
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testDetectLocalizedObjects() throws Exception {
    // Act
    String[] args = {"object-localization", "./resources/puppies.jpg"};
    DetectBeta.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Dog");
  }

  @Test
  public void testDetectHandwrittenOcr() throws Exception {
    // Act
    String[] args = {"handwritten-ocr", "./resources/handwritten.jpg"};
    DetectBeta.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Google");
    assertThat(got).contains("Cloud");
    assertThat(got).contains("Platform");
  }

  @Test
  public void testDetectLocalizedObjectsGcs() throws Exception {
    // Act
    String[] args = {"object-localization", "gs://cloud-samples-data/vision/puppies.jpg"};
    DetectBeta.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Dog");
  }

  @Test
  public void testDetectHandwrittenOcrGcs() throws Exception {
    // Act
    String[] args = {
      "handwritten-ocr", "gs://cloud-samples-data/vision/handwritten.jpg",
    };
    DetectBeta.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Google");
    assertThat(got).contains("Cloud");
    assertThat(got).contains("Platform");
  }

  @Test
  public void testDetectDocumentFeatures() {
    // Act
    DetectBatchAnnotateFiles.detectBatchAnnotateFiles("./resources/kafka.pdf");

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Samsa");
  }

  @Test
  public void testDetectDocumentFeaturesGcs() throws Exception {
    // Act
    DetectBatchAnnotateFilesGcs.detectBatchAnnotateFilesGcs(
        "gs://cloud-samples-data/video/kafka.pdf");

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Samsa");
  }

  @Test
  public void testAsyncBatchAnnotateImagesGcs() throws Exception {
    // Act
    AsyncBatchAnnotateImagesGcs.asyncBatchAnnotateImagesGcs(
        "gs://cloud-samples-data/vision/label/wakeupcat.jpg",
        "gs://" + OUTPUT_BUCKET + "/" + OUTPUT_PREFIX + "/");

    // Assert
    String got = bout.toString();
    assertThat(got).contains("red:");

    Storage storage = StorageOptions.getDefaultInstance().getService();

    Page<Blob> blobs =
        storage.list(
            OUTPUT_BUCKET,
            BlobListOption.currentDirectory(),
            BlobListOption.prefix(OUTPUT_PREFIX + "/"));
    for (Blob blob : blobs.iterateAll()) {
      blob.delete();
    }
  }
}
