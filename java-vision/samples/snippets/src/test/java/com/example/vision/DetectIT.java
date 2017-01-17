/*
  Copyright 2016, Google, Inc.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.example.vision;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.vision.spi.v1.ImageAnnotatorClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Tests for vision "Detect" sample.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DetectIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private Detect app;

  @Before
  public void setUp() throws IOException {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    app = new Detect(ImageAnnotatorClient.create());
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testDetectEmptyArgs() throws Exception {
    // Act
    String[] args = {};
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("all-local | faces | labels | landmarks |"
        + " logos | text | safe-search | properties");
  }

  @Test
  public void testFaces() throws Exception {
    // Act
    String[] args = {"faces", "./resources/face_no_surprise.jpg"};
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("anger: POSSIBLE");
    assertThat(got).contains("joy: POSSIBLE");
    assertThat(got).contains("surprise: UNLIKELY");
  }

  @Test
  public void testLabels() throws Exception {
    // Act
    String[] args = {"labels", "./resources/wakeupcat.jpg"};
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("whiskers");
  }

  @Test
  public void testLandmarks() throws Exception {
    // Act
    String[] args = {"landmarks", "./resources/landmark.jpg"};
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Palace of Fine Arts");
  }

  @Test
  public void testLogos() throws Exception {
    // Act
    String[] args = {"logos", "./resources/logos.png"};
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Google");
  }

  @Test
  public void testText() throws Exception {
    // Act
    String[] args = {"text", "./resources/text.jpg"};
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("37%");
  }

  @Test
  public void testSafeSearch() throws Exception {
    // Act
    String[] args = {"safe-search", "./resources/wakeupcat.jpg"};
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("adult: VERY_UNLIKELY");
  }

  @Test
  public void testProperties() throws Exception {
    // Act
    String[] args = {"properties", "./resources/landmark.jpg"};
    Detect.argsHelper(args, out);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("fraction:");
    assertThat(got).contains("r:");
    assertThat(got).contains("g:");
    assertThat(got).contains("b:");
  }
}
