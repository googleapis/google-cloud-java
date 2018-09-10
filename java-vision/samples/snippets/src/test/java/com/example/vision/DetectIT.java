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
  private Detect app;
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  //private static final String BUCKET = PROJECT_ID;
  private static final String BUCKET = "java-docs-samples-testing";
  private static final  String OUTPUT_PREFIX = "OCR_PDF_TEST_OUTPUT";

  @Before
  public void setUp() throws IOException {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    app = new Detect();
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testDetectLocalizedObjects() throws Exception {
    // Act
    String[] args = {"object-localization", "./resources/puppies.jpg"};
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Dog");
  }

  @Test
  public void testDetectHandwrittenOcr() throws Exception {
    // Act
    String[] args = {"handwritten-ocr", "./resources/handwritten.jpg"};
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Google Cloud Platform");
  }

  @Test
  public void testDetectLocalizedObjectsGcs() throws Exception {
    // Act
    String[] args = {"object-localization", "gs://cloud-samples-data/vision/puppies.jpg"};
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Dog");
  }

  @Test
  public void testDetectHandwrittenOcrGcs() throws Exception {
    // Act
    String[] args = {
        "handwritten-ocr",
        "gs://cloud-samples-data/vision/handwritten.jpg",
    };
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Google Cloud Platform");

  }
}
