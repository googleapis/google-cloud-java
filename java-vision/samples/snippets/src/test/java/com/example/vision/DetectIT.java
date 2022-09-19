/*
 * Copyright 2017 Google Inc.
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
import com.google.cloud.testing.junit4.MultipleAttemptsRule;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for vision "Detect" sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DetectIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;
  private static final String ASSET_BUCKET = "cloud-samples-data";
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String OUTPUT_BUCKET = PROJECT_ID;
  private static final String OUTPUT_PREFIX = "OCR_PDF_TEST_OUTPUT_" + UUID.randomUUID().toString();

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
  }

  @Rule public MultipleAttemptsRule multipleAttemptsRule = new MultipleAttemptsRule(3);

  @Test
  public void testDocumentText() throws Exception {
    // Act
    Detect.detectDocumentText("./resources/text.jpg");

    // Assert
    String got = bout.toString();
    assertThat(got).contains("After preparation is complete, the ");
    assertThat(got).contains("37%");
    assertThat(got).contains("Word text: class (confidence:");
  }

  @Test
  public void testDocumentTextGcs() throws Exception {
    // Act
    Detect.detectDocumentTextGcs("gs://" + ASSET_BUCKET + "/vision/text/screen.jpg");

    // Assert
    String got = bout.toString();
    assertThat(got).contains("After preparation is complete, the ");
    assertThat(got).contains("37%");
    assertThat(got).contains("Word text: class (confidence:");
  }

  @Test
  public void testDetectDocumentsGcs() throws Exception {
    // Act
    Detect.detectDocumentsGcs(
        "gs://" + ASSET_BUCKET + "/vision/document/custom_0773375000.pdf",
        "gs://" + OUTPUT_BUCKET + "/" + OUTPUT_PREFIX + "/");

    // Assert
    String got = bout.toString();

    assertThat(got).contains("OIL, GAS AND MINERAL LEASE");

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

  @Test
  public void testDetectLocalizedObjects() throws Exception {
    // Act
    Detect.detectLocalizedObjects("./resources/puppies.jpg");

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("dog");
  }

  @Test
  public void testDetectLocalizedObjectsGcs() throws Exception {
    // Act
    Detect.detectLocalizedObjectsGcs(
        "gs://cloud-samples-data/vision/object_localization/puppies.jpg");

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("dog");
  }
}
