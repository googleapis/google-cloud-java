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

import static org.junit.Assert.assertTrue;

import com.google.cloud.dialogflow.cx.v3.QueryResult;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.Test;

/** Unit test for {@link DetectIntentSentimentAnalysis}. */
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DetectIntentSentimentAnalysisTest {

  private static String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static String LOCATION = "global";
  private static String AGENT_ID =
      System.getenv()
          .getOrDefault("DIALOGFLOW_CX_AGENT_ID_GLOBAL", "b8d0e85d-0741-4e6d-a66a-3671184b7b93");
  private static String SESSION_ID = UUID.randomUUID().toString();
  private static String LANGUAGE_CODE = "en-US";
  private static List<String> TEXTS = Arrays.asList("hello", "unhappy");

  @Test
  public void testDetectIntentSentimentAnalysis() throws Exception {
    int min = -1;
    int max = 1;

    Map<String, QueryResult> queryResults =
        DetectIntentSentimentAnalysis.detectIntent(
            PROJECT_ID, LOCATION, AGENT_ID, SESSION_ID, TEXTS, LANGUAGE_CODE);

    for (int i = 0; i < TEXTS.size(); i++) {
      String text = TEXTS.get(i);
      float score = queryResults.get(text).getSentimentAnalysisResult().getScore();
      assertTrue(min <= score && score <= max);
    }
  }
}
