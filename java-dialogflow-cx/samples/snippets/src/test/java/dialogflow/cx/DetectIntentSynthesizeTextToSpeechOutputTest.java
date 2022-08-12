/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dialogflow.cx;

import static com.google.common.truth.Truth.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** Unit test for {@link DetectIntentSynthesizeTtSOutput}. */
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DetectIntentSynthesizeTextToSpeechOutputTest {

  private static String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static String LOCATION = "global";
  private static String AGENT_ID =
      System.getenv()
          .getOrDefault("DIALOGFLOW_CX_AGENT_ID_GLOBAL", "b8d0e85d-0741-4e6d-a66a-3671184b7b93");
  private static String AUDIO_FILE_NAME = "resources/book_a_room.wav";
  private static int SAMPLE_RATE_HERTZ = 16000;
  private static String SESSION_ID = UUID.randomUUID().toString();
  private static String LANGUAGE_CODE = "en";

  private ByteArrayOutputStream stdOut;

  @Before
  public void setUp() throws IOException {

    stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));
  }

  @After
  public void tearDown() throws IOException {
    stdOut = null;
    System.setOut(null);
  }

  @Test
  public void testDetectIntentSynthesizeTextToSpeechOutput() throws Exception {

    DetectIntentSynthesizeTextToSpeechOutput.detectIntent(
        PROJECT_ID,
        LOCATION,
        AGENT_ID,
        AUDIO_FILE_NAME,
        SAMPLE_RATE_HERTZ,
        SESSION_ID,
        LANGUAGE_CODE);
    System.out.println(stdOut.toString());
    assertThat(stdOut.toString()).contains("speaking_rate");
  }
}
