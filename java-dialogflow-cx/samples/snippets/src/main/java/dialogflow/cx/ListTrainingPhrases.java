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

// [START dialogflow_list_training_phrases]
import com.google.cloud.dialogflow.cx.v3.GetIntentRequest;
import com.google.cloud.dialogflow.cx.v3.Intent;
import com.google.cloud.dialogflow.cx.v3.IntentName;
import com.google.cloud.dialogflow.cx.v3.IntentsClient;
import java.io.IOException;
import java.util.List;

public class ListTrainingPhrases {
  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String location = "location";
    String agentId = "my-agent-id";
    String intentId = "my-intent-id";

    listTrainingPhrases(projectId, location, agentId, intentId);
  }

  // DialogFlow API List Training Phrases sample.
  public static void listTrainingPhrases(
      String projectId, String location, String agentId, String intentId) throws IOException {
    try (IntentsClient client = IntentsClient.create()) {
      // Set the intent name
      IntentName name = IntentName.of(projectId, location, agentId, intentId);

      // Compose the get-intent request
      GetIntentRequest request = GetIntentRequest.newBuilder().setName(name.toString()).build();

      // Make API request to get intent
      Intent response = client.getIntent(request);

      // Loop through the results
      for (Intent.TrainingPhrase phrase : response.getTrainingPhrasesList()) {
        System.out.println("***********************************************");
        List<Intent.TrainingPhrase.Part> parts = phrase.getPartsList();
        for (Intent.TrainingPhrase.Part part : parts) {
          System.out.println(String.format("Training Phrase: %s", part.getText()));
        }
      }
    }
  }
}
// [END dialogflow_list_training_phrases]
