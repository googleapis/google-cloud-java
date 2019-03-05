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

package com.example.video;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.videointelligence.v1.ObjectTrackingAnnotation;
import com.google.cloud.videointelligence.v1.TextAnnotation;
import com.google.cloud.videointelligence.v1.VideoAnnotationResults;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
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

  static final String LABEL_GCS_LOCATION = "gs://demomaker/cat.mp4";
  static final String LABEL_FILE_LOCATION = "./resources/cat.mp4";
  static final String SHOTS_FILE_LOCATION = "gs://demomaker/gbikes_dinosaur.mp4";
  static final String EXPLICIT_CONTENT_LOCATION =  "gs://demomaker/cat.mp4";
  static final String SPEECH_GCS_LOCATION =
          "gs://java-docs-samples-testing/video/googlework_short.mp4";
  private static final List<String> POSSIBLE_TEXTS = Arrays.asList(
      "Google", "SUR", "SUR", "ROTO", "Vice President", "58oo9", "LONDRES", "OMAR", "PARIS",
      "METRO", "RUE", "CARLO");

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
  public void testLabels() throws Exception {
    String[] args = {"labels", LABEL_GCS_LOCATION};
    Detect.argsHelper(args);
    String got = bout.toString();
    // Test that the video with a cat has the whiskers label (may change).
    assertThat(got.toUpperCase()).contains("WHISKERS");
  }

  @Test
  public void testLabelsFile() throws Exception {
    String[] args = {"labels-file", LABEL_FILE_LOCATION};
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

  @Test
  public void testSpeechTranscription() throws Exception {
    String[] args = {"speech-transcription", SPEECH_GCS_LOCATION};
    Detect.argsHelper(args);
    String got = bout.toString();

    assertThat(got).contains("cultural");
  }

  @Test
  public void testTrackObjects() throws Exception {
    VideoAnnotationResults result = TrackObjects.trackObjects("resources/cat.mp4");

    boolean textExists = false;
    for (ObjectTrackingAnnotation objectTrackingAnnotation : result.getObjectAnnotationsList()) {
      if (objectTrackingAnnotation.getEntity().getDescription().toUpperCase().contains("CAT")) {
        textExists = true;
        break;
      }
    }

    assertThat(textExists).isTrue();
  }

  @Test
  public void testTrackObjectsGcs() throws Exception {
    VideoAnnotationResults result = TrackObjects.trackObjectsGcs("gs://demomaker/cat.mp4");

    boolean textExists = false;
    for (ObjectTrackingAnnotation objectTrackingAnnotation : result.getObjectAnnotationsList()) {
      if (objectTrackingAnnotation.getEntity().getDescription().toUpperCase().contains("CAT")) {
        textExists = true;
        break;
      }
    }

    assertThat(textExists).isTrue();
  }

  @Test
  public void testTextDetection() throws Exception {
    VideoAnnotationResults result = TextDetection.detectText("resources/googlework_short.mp4");

    boolean textExists = false;
    for (TextAnnotation textAnnotation : result.getTextAnnotationsList()) {
      for (String possibleText : POSSIBLE_TEXTS) {
        if (textAnnotation.getText().toUpperCase().contains(possibleText.toUpperCase())) {
          textExists = true;
          break;
        }
      }
    }

    assertThat(textExists).isTrue();
  }

  @Test
  public void testTextDetectionGcs() throws Exception {
    VideoAnnotationResults result = TextDetection.detectTextGcs(SPEECH_GCS_LOCATION);

    boolean textExists = false;
    for (TextAnnotation textAnnotation : result.getTextAnnotationsList()) {
      for (String possibleText : POSSIBLE_TEXTS) {
        if (textAnnotation.getText().toUpperCase().contains(possibleText.toUpperCase())) {
          textExists = true;
          break;
        }
      }
    }

    assertThat(textExists).isTrue();
  }
}
