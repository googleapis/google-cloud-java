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

import com.example.vision.snippets.DetectLandmarksGcs;
import com.example.vision.snippets.DetectLandmarksUrl;
import com.google.cloud.testing.junit4.MultipleAttemptsRule;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DetectLandmarksGcsTest {

  private static final String ASSET_BUCKET = "cloud-samples-data";

  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

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
  public void testLandmarksUrl() throws Exception {
    // Act
    String uri =
        "https://storage-download.googleapis.com/" + ASSET_BUCKET + "/vision/landmark/pofa.jpg";
    DetectLandmarksUrl.detectLandmarksUrl(uri);

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("palace of fine arts");
  }

  @Test
  public void testLandmarksGcs() throws Exception {
    // Act
    DetectLandmarksGcs.detectLandmarksGcs("gs://" + ASSET_BUCKET + "/vision/landmark/pofa.jpg");

    // Assert
    String got = bout.toString().toLowerCase();
    assertThat(got).contains("palace of fine arts");
  }
}
