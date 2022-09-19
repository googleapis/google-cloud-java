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

package video;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.videointelligence.v1.VideoAnnotationResults;
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
  static final String LABEL_GCS_LOCATION = "gs://cloud-samples-data/video/cat.mp4";
  static final String LABEL_FILE_LOCATION = "./resources/googlework_short.mp4";
  static final String SHOTS_FILE_LOCATION = "gs://cloud-samples-data/video/gbikes_dinosaur.mp4";
  static final String EXPLICIT_CONTENT_LOCATION = "gs://cloud-samples-data/video/cat.mp4";
  static final String SPEECH_GCS_LOCATION =
      "gs://java-docs-samples-testing/video/googlework_short.mp4";

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
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testLabels() throws Exception {
    String[] args = {"labels", LABEL_GCS_LOCATION};
    Detect.argsHelper(args);
    String got = bout.toString();
    assertThat(got).contains("Video label");
  }

  @Test
  public void testLabelsFile() throws Exception {
    String[] args = {"labels-file", LABEL_FILE_LOCATION};
    Detect.argsHelper(args);
    String got = bout.toString();
    assertThat(got).contains("Video label");
  }

  @Test
  public void testExplicitContent() throws Exception {
    String[] args = {"explicit-content", EXPLICIT_CONTENT_LOCATION};
    Detect.argsHelper(args);
    String got = bout.toString();
    assertThat(got).contains("Adult:");
  }

  @Test
  public void testShots() throws Exception {
    String[] args = {"shots", SHOTS_FILE_LOCATION};
    Detect.argsHelper(args);
    String got = bout.toString();
    assertThat(got).contains("Shots:");
    assertThat(got).contains("Location:");
  }

  @Test
  public void testSpeechTranscription() throws Exception {
    String[] args = {"speech-transcription", SPEECH_GCS_LOCATION};
    Detect.argsHelper(args);
    String got = bout.toString();

    assertThat(got).contains("Transcript");
  }

  @Test
  public void testTrackObjects() throws Exception {
    TrackObjects.trackObjects("resources/googlework_short.mp4");

    String got = bout.toString();

    assertThat(got).contains("Entity id");
  }

  @Test
  public void testTrackObjectsGcs() throws Exception {
    VideoAnnotationResults result = TrackObjects.trackObjectsGcs(LABEL_GCS_LOCATION);

    String got = bout.toString();
    assertThat(got).contains("Entity id");
  }
}
