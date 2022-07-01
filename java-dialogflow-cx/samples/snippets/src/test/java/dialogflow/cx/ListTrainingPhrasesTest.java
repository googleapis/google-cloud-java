/*
 * Copyright 2021 Google LLC
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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListTrainingPhrasesTest {
  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String LOCATION = "global";
  private static String AGENT_ID = "b8d0e85d-0741-4e6d-a66a-3671184b7b93";
  private static String INTENT_ID = "e2d688a6-c8b4-448e-a7d6-208f147ae689";

  private ByteArrayOutputStream stdOut;

  @Before
  public void setUp() throws IOException {
    stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));
  }

  @After
  public void tearDown() throws IOException, InterruptedException {
    stdOut = null;
    System.setOut(null);

    // Small delay to prevent reaching quota limit of requests per minute
    Thread.sleep(250);
  }

  @Test
  public void testListTrainingPhrases() throws IOException {
    ListTrainingPhrases.listTrainingPhrases(PROJECT_ID, LOCATION, AGENT_ID, INTENT_ID);
    assertThat(stdOut.toString()).contains("green");
  }
}
