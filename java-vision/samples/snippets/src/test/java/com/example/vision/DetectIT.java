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
import java.io.PrintStream;
import java.util.UUID;
import java.util.regex.Pattern;
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
  private static final String OUTPUT_PREFIX = "OCR_PDF_TEST_OUTPUT_" + UUID.randomUUID().toString();

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
  public void testLandmarks() throws Exception {
    // Act
    Detect.detectLandmarks("./resources/landmark.jpg");

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("palace of fine arts");
  }

  @Test
  public void testLandmarksGcs() throws Exception {
    // Act
    Detect.detectLandmarksGcs("gs://" + ASSET_BUCKET + "/vision/landmark/pofa.jpg");

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("palace of fine arts");
  }

  @Test
  public void testLandmarksUrl() throws Exception {
    // Act
    String uri =
        "https://storage-download.googleapis.com/" + ASSET_BUCKET + "/vision/landmark/pofa.jpg";
    Detect.detectLandmarksUrl(uri);

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("palace of fine arts");
  }

  @Test
  public void testLogos() throws Exception {
    // Act
    Detect.detectLogos("./resources/logos.png");

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("google");
  }

  @Test
  public void testLogosGcs() throws Exception {
    // Act
    Detect.detectLogosGcs("gs://" + ASSET_BUCKET + "/vision/logo/logo_google.png");

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("google");
  }

  @Test
  public void testText() throws Exception {
    // Act
    Detect.detectText("./resources/text.jpg");

    // Assert
    String got = bout.toString();
    assertThat(got).contains("37%");
  }

  @Test
  public void testTextGcs() throws Exception {
    // Act
    Detect.detectTextGcs("gs://" + ASSET_BUCKET + "/vision/text/screen.jpg");

    // Assert
    String got = bout.toString();
    assertThat(got).contains("37%");
  }

  @Test
  public void testSafeSearch() throws Exception {
    // Act
    Detect.detectSafeSearch("./resources/wakeupcat.jpg");

    // Assert
    String got = bout.toString();
    assertThat(got).contains("adult:");
    assertThat(got).contains("racy:");
  }

  @Test
  public void testSafeSearchGcs() throws Exception {
    // Act
    Detect.detectSafeSearchGcs("gs://" + ASSET_BUCKET + "/vision/label/wakeupcat.jpg");

    // Assert
    String got = bout.toString();
    assertThat(got).contains("adult:");
    assertThat(got).contains("racy:");
  }

  @Test
  public void testProperties() throws Exception {
    // Act
    Detect.detectProperties("./resources/landmark.jpg");

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
    Detect.detectPropertiesGcs("gs://" + ASSET_BUCKET + "/vision/landmark/pofa.jpg");

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
    Detect.detectWebDetections("./resources/landmark.jpg");

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("entity:id:score");
    assertThat(got).contains("best guess label");
  }

  @Test
  public void detectWebAnnotationsGcs() throws Exception {
    // Act
    Detect.detectWebDetectionsGcs("gs://" + ASSET_BUCKET + "/vision/landmark/pofa.jpg");

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("entity:id:score");
    assertThat(got).contains("best guess label");
  }

  @Test
  public void testDetectWebEntities() throws Exception {
    // Act
    Detect.detectWebEntities("./resources/city.jpg");

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).doesNotContain("zepra");
  }

  @Test
  public void testDetectWebEntitiesGcs() throws Exception {
    // Act
    Detect.detectWebEntitiesGcs("gs://" + ASSET_BUCKET + "/vision/landmark/pofa.jpg");

    String got = bout.toString().toLowerCase();
    assertThat(got).contains("description");
  }

  @Test
  public void testDetectWebEntitiesIncludeGeoResults() throws Exception {
    // Act
    Detect.detectWebEntitiesIncludeGeoResults("./resources/city.jpg");

    // Assert
    String got = bout.toString().toLowerCase();
    // Note: entities and labels can change over time.
    assertThat(got).doesNotContain("error");
  }

  @Test
  public void testDetectWebEntitiesIncludeGeoResultsGcs() throws Exception {
    // Act
    Detect.detectWebEntitiesIncludeGeoResultsGcs(
        "gs://" + ASSET_BUCKET + "/vision/landmark/pofa.jpg");

    String got = bout.toString().toLowerCase();
    assertThat(got).contains("description");
  }

  @Test
  public void testCropHints() throws Exception {
    // Act
    Detect.detectCropHints("./resources/wakeupcat.jpg");

    // Assert
    String got = bout.toString();
    assertThat(got).contains("vertices {");
    assertThat(got).containsMatch(Pattern.compile("x: 2\\d{2}"));
    assertThat(got).containsMatch(Pattern.compile("y: 4\\d{2}"));
  }

  @Test
  public void testCropHintsGcs() throws Exception {
    // Act
    Detect.detectCropHintsGcs("gs://" + ASSET_BUCKET + "/vision/label/wakeupcat.jpg");

    // Assert
    String got = bout.toString();
    assertThat(got).contains("vertices {");
    assertThat(got).containsMatch(Pattern.compile("x: 2\\d{2}"));
    assertThat(got).containsMatch(Pattern.compile("y: 4\\d{2}"));
  }

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
