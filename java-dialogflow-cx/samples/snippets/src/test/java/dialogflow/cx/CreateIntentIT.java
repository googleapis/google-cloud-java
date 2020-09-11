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
import static org.junit.Assert.assertTrue;

import com.google.cloud.dialogflow.cx.v3beta1.Intent;
import com.google.cloud.dialogflow.cx.v3beta1.Intent.TrainingPhrase;
import com.google.cloud.dialogflow.cx.v3beta1.IntentsClient;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link CreateIntent}. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class CreateIntentIT {

  private static String DISPLAY_NAME = "intent-" + UUID.randomUUID().toString();
  private static String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static String LOCATION = "global";
  private static String AGENT_ID =
      System.getenv()
          .getOrDefault("DIALOGFLOW_CX_AGENT_ID", "b8d0e85d-0741-4e6d-a66a-3671184b7b93");
  private static List<String> TRAINING_PHRASES_PARTS = Arrays.asList("red", "blue", "green");
  private static String newIntentName;

  @After
  public void tearDown() throws Exception {
    // Delete the newly created Intent.
    if (newIntentName != null) {
      try (IntentsClient intentsClient = IntentsClient.create()) {
        intentsClient.deleteIntent(newIntentName);
      }
    }
  }

  @Test
  public void testCreateIntent() throws Exception {
    Intent result =
        CreateIntent.createIntent(
            DISPLAY_NAME, PROJECT_ID, LOCATION, AGENT_ID, TRAINING_PHRASES_PARTS);
    newIntentName = result.getName();

    assertEquals(result.getTrainingPhrasesCount(), TRAINING_PHRASES_PARTS.size());
    for (TrainingPhrase trainingPhrase : result.getTrainingPhrasesList()) {
      assertEquals(trainingPhrase.getPartsCount(), 1);
      String partText = trainingPhrase.getParts(0).getText();
      assertTrue(partText.equals("red") || partText.equals("blue") || partText.equals("green"));
    }
  }
}
