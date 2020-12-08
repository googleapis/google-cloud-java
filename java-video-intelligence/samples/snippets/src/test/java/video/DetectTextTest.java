/*
 * Copyright 2020 Google Inc.
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

import com.google.cloud.videointelligence.v1.TextAnnotation;
import com.google.cloud.videointelligence.v1.VideoAnnotationResults;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class DetectTextTest {
  static final String SPEECH_GCS_LOCATION =
      "gs://java-docs-samples-testing/video/googlework_short.mp4";
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
  @Rule public Retry retry = new Retry(3);
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
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
