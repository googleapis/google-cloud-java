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

package beta.video;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.testing.junit4.MultipleAttemptsRule;
import com.google.cloud.videointelligence.v1p2beta1.ObjectTrackingAnnotation;
import com.google.cloud.videointelligence.v1p2beta1.TextAnnotation;
import com.google.cloud.videointelligence.v1p2beta1.VideoAnnotationResults;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for video analysis sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DetectIT {

  static final String FILE_LOCATION = "gs://java-docs-samples-testing/video/googlework_short.mp4";
  private static final List<String> POSSIBLE_TEXTS =
      Arrays.asList(
          "Google",
          "SUR",
          "SUR",
          "ROTO",
          "Vice President",
          "58oo9",
          "LONDRES",
          "OMAR",
          "PARIS",
          "METRO",
          "RUE",
          "CARLO");
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  @Rule public MultipleAttemptsRule multipleAttemptsRule = new MultipleAttemptsRule(3);

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
  public void testSpeechTranscription() throws Exception {
    String[] args = {"speech-transcription", FILE_LOCATION};
    Detect.argsHelper(args);
    String got = bout.toString();

    assertThat(got).contains("cultural");
  }

  @Test
  public void testTrackObjects() throws Exception {
    TrackObjects.trackObjects("resources/googlework_short.mp4");

    String got = bout.toString();

    assertThat(got).contains("Entity id");
  }

  @Test
  public void testTrackObjectsGcs() throws Exception {
    VideoAnnotationResults result =
        TrackObjects.trackObjectsGcs("gs://cloud-samples-data/video/cat.mp4");

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
    try {
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

    } catch (TimeoutException ex) {
      Assert.assertTrue(ex.getMessage().contains("Waited"));
    }
  }

  @Test
  public void testTextDetectionGcs() throws Exception {
    VideoAnnotationResults result = TextDetection.detectTextGcs(FILE_LOCATION);

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
