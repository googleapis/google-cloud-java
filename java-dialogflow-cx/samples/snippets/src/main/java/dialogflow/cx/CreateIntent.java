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

// [START dialogflow_cx_create_intent]

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.dialogflow.cx.v3beta1.AgentName;
import com.google.cloud.dialogflow.cx.v3beta1.Intent;
import com.google.cloud.dialogflow.cx.v3beta1.Intent.TrainingPhrase;
import com.google.cloud.dialogflow.cx.v3beta1.Intent.TrainingPhrase.Part;
import com.google.cloud.dialogflow.cx.v3beta1.IntentsClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateIntent {

  // Create an intent of the given intent type.
  public static Intent createIntent(
      String displayName,
      String projectId,
      String locationId,
      String agentId,
      List<String> trainingPhrasesParts)
      throws IOException, ApiException {
    // Instantiates a client
    try (IntentsClient intentsClient = IntentsClient.create()) {
      // Set the project agent name using the projectID (my-project-id), locationID (global), and
      // agentID (UUID).
      AgentName parent = AgentName.of(projectId, locationId, agentId);

      // Build the trainingPhrases from the trainingPhrasesParts.
      List<TrainingPhrase> trainingPhrases = new ArrayList<>();
      for (String trainingPhrase : trainingPhrasesParts) {
        trainingPhrases.add(
            TrainingPhrase.newBuilder()
                .addParts(Part.newBuilder().setText(trainingPhrase).build())
                .setRepeatCount(1)
                .build());
      }

      // Build the intent.
      Intent intent =
          Intent.newBuilder()
              .setDisplayName(displayName)
              .addAllTrainingPhrases(trainingPhrases)
              .build();

      // Performs the create intent request.
      Intent response = intentsClient.createIntent(parent, intent);
      System.out.format("Intent created: %s\n", response);

      return response;
    }
  }
}
// [END dialogflow_cx_create_intent]
