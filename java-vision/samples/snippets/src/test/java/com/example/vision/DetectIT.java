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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for vision "Detect" sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DetectIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String ASSET_BUCKET = "cloud-samples-data";
  private static final String OUTPUT_BUCKET = PROJECT_ID;
  private static final String OUTPUT_PREFIX = "OCR_PDF_TEST_OUTPUT";

  @Before
  public void setUp() throws IOException {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testFaces() throws Exception {
    // Act
    String[] args = { "faces", "./resources/face_no_surprise.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("anger: POSSIBLE");
    assertThat(got).contains("joy: POSSIBLE");
    assertThat(got).contains("surprise: LIKELY");
  }

  @Test
  public void testFacesGcs() throws Exception {
    // Act
    String[] args = { "faces", "gs://" + ASSET_BUCKET + "/vision/face/face_no_surprise.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("anger: POSSIBLE");
    assertThat(got).contains("joy: POSSIBLE");
    assertThat(got).contains("surprise: LIKELY");
  }

  @Test
  public void testLabels() throws Exception {
    // Act
    String[] args = { "labels", "./resources/wakeupcat.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("whiskers");
  }

  @Test
  public void testLabelsGcs() throws Exception {
    // Act
    String[] args = { "labels", "gs://" + ASSET_BUCKET + "/vision/label/wakeupcat.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("whiskers");
  }

  @Test
  public void testLandmarks() throws Exception {
    // Act
    String[] args = { "landmarks", "./resources/landmark.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("palace of fine arts");
  }

  @Test
  public void testLandmarksGcs() throws Exception {
    // Act
    String[] args = { "landmarks", "gs://" + ASSET_BUCKET + "/vision/landmark/pofa.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("palace of fine arts");
  }

  @Test
  public void testLandmarksUrl() throws Exception {
    // Act
    String uri = "https://storage-download.googleapis.com/" + ASSET_BUCKET + "/vision/landmark/pofa.jpg";
    String[] args = { "landmarks", uri };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("palace of fine arts");
  }

  @Test
  public void testLogos() throws Exception {
    // Act
    String[] args = { "logos", "./resources/logos.png" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("google");
  }

  @Test
  public void testLogosGcs() throws Exception {
    // Act
    String[] args = { "logos", "gs://" + ASSET_BUCKET + "/vision/logo/logo_google.png" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("google");
  }

  @Test
  public void testText() throws Exception {
    // Act
    String[] args = { "text", "./resources/text.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("37%");
  }

  @Test
  public void testTextGcs() throws Exception {
    // Act
    String[] args = { "text", "gs://" + ASSET_BUCKET + "/vision/text/screen.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("37%");
  }

  @Test
  public void testSafeSearch() throws Exception {
    // Act
    String[] args = { "safe-search", "./resources/wakeupcat.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("adult: VERY_UNLIKELY");
    assertThat(got).contains("racy: UNLIKELY");
  }

  @Test
  public void testSafeSearchGcs() throws Exception {
    // Act
    String[] args = { "safe-search", "gs://" + ASSET_BUCKET + "/vision/label/wakeupcat.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("adult: VERY_UNLIKELY");
    assertThat(got).contains("racy: UNLIKELY");
  }

  @Test
  public void testProperties() throws Exception {
    // Act
    String[] args = { "properties", "./resources/landmark.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("fraction:");
    assertThat(got).contains("r:");
    assertThat(got).contains("g:");
    assertThat(got).contains("b:");
  }

  @Test
  public void testPropertiesGcs() throws Exception {
    // Act
    String[] args = { "properties", "gs://" + ASSET_BUCKET + "/vision/landmark/pofa.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("fraction:");
    assertThat(got).contains("r:");
    assertThat(got).contains("g:");
    assertThat(got).contains("b:");
  }

  @Test
  public void detectWebAnnotations() throws Exception {
    // Act
    String[] args = { "web", "./resources/landmark.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("history");
    assertThat(got).contains("best guess label: palace of fine arts");
  }

  @Test
  public void detectWebAnnotationsGcs() throws Exception {
    // Act
    String[] args = { "web", "gs://" + ASSET_BUCKET + "/vision/landmark/pofa.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("history");
    assertThat(got).contains("best guess label: palace of fine arts");
  }

  @Test
  public void testDetectWebEntities() throws Exception {
    // Act
    String[] args = { "web-entities", "./resources/city.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).doesNotContain("zepra");
  }

  @Test
  public void testDetectWebEntitiesGcs() throws Exception {
    // Act
    String[] args = { "web-entities", "gs://" + ASSET_BUCKET + "/vision/landmark/pofa.jpg" };
    Detect.argsHelper(args, out);

    String got = bout.toString().toLowerCase();
    assertThat(got).contains("description");
  }

  @Test
  public void testDetectWebEntitiesIncludeGeoResults() throws Exception {
    // Act
    String[] args = { "web-entities-include-geo", "./resources/city.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString().toLowerCase();
    // Note: entities and labels can change over time.
    assertThat(got).doesNotContain("error");
  }

  @Test
  public void testDetectWebEntitiesIncludeGeoResultsGcs() throws Exception {
    // Act
    String[] args = { "web-entities-include-geo", 
        "gs://" + ASSET_BUCKET + "/vision/landmark/pofa.jpg" };
    Detect.argsHelper(args, out);

    String got = bout.toString().toLowerCase();
    assertThat(got).contains("description");
  }

  @Test
  public void testCropHints() throws Exception {
    // Act
    String[] args = { "crop", "./resources/wakeupcat.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("vertices {");
    assertThat(got).contains("x: 599");
    assertThat(got).contains("y: 475");
  }

  @Test
  public void testCropHintsGcs() throws Exception {
    // Act
    String[] args = { "crop", "gs://" + ASSET_BUCKET + "/vision/label/wakeupcat.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("vertices {");
    assertThat(got).contains("x: 599");
    assertThat(got).contains("y: 475");
  }

  @Test
  public void testDocumentText() throws Exception {
    // Act
    String[] args = { "fulltext", "./resources/text.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("After preparation is complete, the ");
    assertThat(got).contains("37%");
    assertThat(got).contains("Word text: class (confidence:");
  }

  @Test
  public void testDocumentTextGcs() throws Exception {
    // Act
    String[] args = { "fulltext", "gs://" + ASSET_BUCKET + "/vision/text/screen.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("After preparation is complete, the ");
    assertThat(got).contains("37%");
    assertThat(got).contains("Word text: class (confidence:");
  }

  @Test
  public void testDetectDocumentsGcs() throws Exception {
    // Act
    String[] args = { "ocr", "gs://" + ASSET_BUCKET + "/vision/document/custom_0773375000.pdf",
        "gs://" + OUTPUT_BUCKET + "/" + OUTPUT_PREFIX + "/" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("OIL, GAS AND MINERAL LEASE");

    Storage storage = StorageOptions.getDefaultInstance().getService();

    Page<Blob> blobs = storage.list(OUTPUT_BUCKET, BlobListOption.currentDirectory(),
        BlobListOption.prefix(OUTPUT_PREFIX + "/"));

    for (Blob blob : blobs.iterateAll()) {
      blob.delete();
    }
  }

  @Test
  public void testDetectLocalizedObjects() throws Exception {
    // Act
    String[] args = { "object-localization", "./resources/puppies.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("dog");
  }

  @Test
  public void testDetectLocalizedObjectsGcs() throws Exception {
    // Act
    String[] args = { "object-localization", 
        "gs://cloud-samples-data/vision/object_localization/puppies.jpg" };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("dog");
  }
}