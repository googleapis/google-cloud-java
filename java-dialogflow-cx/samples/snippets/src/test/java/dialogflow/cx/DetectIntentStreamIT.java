/*
 * Copyright 2020 Google LLC
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
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link DetectIntentStream}. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DetectIntentStreamIT {

  private static String AUDIO_FILE_PATH = "resources/book_a_room.wav";
  private static String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static String LOCATION = "global";
  private static String AGENT_ID =
      System.getenv()
          .getOrDefault("DIALOGFLOW_CX_AGENT_ID", "b8d0e85d-0741-4e6d-a66a-3671184b7b93");
  private static String SESSION_ID = UUID.randomUUID().toString();
  private ByteArrayOutputStream bout;
  private PrintStream original;

  @Before
  public void setUp() {
    original = System.out;
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));
  }

  @After
  public void tearDown() {
    System.setOut(original);
    bout.reset();
  }

  @Test
  public void testDetectIntentStream() throws IOException {
    DetectIntentStream.detectIntentStream(
        PROJECT_ID, LOCATION, AGENT_ID, SESSION_ID, AUDIO_FILE_PATH);

    String output = bout.toString();

    assertThat(output).contains("Detected Intent");
    assertThat(output).contains("book");
  }
}
