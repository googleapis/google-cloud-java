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

import static org.junit.Assert.assertEquals;

import com.google.cloud.dialogflow.cx.v3beta1.QueryResult;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link DetectIntent}. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DetectIntentIT {

  private static String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static String LOCATION_GLOBAL = "global";
  private static String LOCATION_REGIONAL = "us-central1";
  private static String AGENT_ID_GLOBAL =
      System.getenv()
          .getOrDefault("DIALOGFLOW_CX_AGENT_ID_GLOBAL", "b8d0e85d-0741-4e6d-a66a-3671184b7b93");
  private static String AGENT_ID_REGIONAL =
      System.getenv()
          .getOrDefault("DIALOGFLOW_CX_AGENT_ID_REGIONAL", "1ea2bf10-d5ef-4442-b93f-a917d1991014");
  private static String SESSION_ID = UUID.randomUUID().toString();
  private static String LANGUAGE_CODE = "en-US";
  private static List<String> TEXTS = Arrays.asList("hello", "book a meeting room");

  @After
  public void tearDown() throws InterruptedException {
    // Small delay to prevent reaching quota limit of requests per minute
    Thread.sleep(250);
  }

  @Test
  public void testDetectIntentGlobal() throws Exception {
    Map<String, QueryResult> queryResults =
        DetectIntent.detectIntent(
            PROJECT_ID, LOCATION_GLOBAL, AGENT_ID_GLOBAL, SESSION_ID, TEXTS, LANGUAGE_CODE);
    assertEquals(queryResults.size(), TEXTS.size());
    for (int i = 0; i < TEXTS.size(); i++) {
      String text = TEXTS.get(i);
      assertEquals(queryResults.get(text).getText(), text);
    }
  }

  @Test
  public void testDetectIntentRegional() throws Exception {
    Map<String, QueryResult> queryResults =
        DetectIntent.detectIntent(
            PROJECT_ID, LOCATION_REGIONAL, AGENT_ID_REGIONAL, SESSION_ID, TEXTS, LANGUAGE_CODE);
    assertEquals(queryResults.size(), TEXTS.size());
    for (int i = 0; i < TEXTS.size(); i++) {
      String text = TEXTS.get(i);
      assertEquals(queryResults.get(text).getText(), text);
    }
  }
}
