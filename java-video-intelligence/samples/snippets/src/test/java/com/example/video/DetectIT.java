/*
  Copyright 2017, Google, Inc.

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

package com.example.video;

import static com.google.common.truth.Truth.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for video analysis sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DetectIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;

  static final String FACES_FILE_LOCATION = "gs://demomaker/gbike.mp4";
  static final String LABEL_FILE_LOCATION = "gs://demomaker/cat.mp4";
  static final String SHOTS_FILE_LOCATION = "gs://demomaker/gbikes_dinosaur.mp4";
  static final String EXPLICIT_CONTENT_LOCATION =  "gs://demomaker/cat.mp4";

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
  public void testFaces() throws Exception {
    String[] args = {"faces", FACES_FILE_LOCATION};
    Detect.argsHelper(args);
    String got = bout.toString();
    // Model changes have caused the results from face detection to change to an
    // empty response (e.g. no faces detected) so we check either for an empty
    // response or that a response with face thumbnails was returned.
    if (got.indexOf("No faces detected") == -1) {
      assertThat(got).contains("Thumbnail size:");
    } else {
      // No faces detected, verify sample reports this.
      assertThat(got).contains("No faces detected in " + FACES_FILE_LOCATION);
    }
  }

  @Test
  public void testLabels() throws Exception {
    String[] args = {"labels", LABEL_FILE_LOCATION};
    Detect.argsHelper(args);
    String got = bout.toString();
    // Test that the video with a cat has the whiskers label (may change).
    assertThat(got.toUpperCase()).contains("WHISKERS");
  }

  @Test
  public void testExplicitContent() throws Exception {
    String[] args = {"explicit-content", EXPLICIT_CONTENT_LOCATION};
    Detect.argsHelper(args);
    String got = bout.toString();
    assertThat(got).contains("Adult: VERY_UNLIKELY");
  }

  @Test
  public void testShots() throws Exception {
    String[] args = {"shots", SHOTS_FILE_LOCATION};
    Detect.argsHelper(args);
    String got = bout.toString();
    assertThat(got).contains("Shots:");
    assertThat(got).contains("Location: 0");
  }
}
