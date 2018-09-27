/*
 * Copyright 2018 Google LLC
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

package com.example.dialogflow;

// Imports the Google Cloud client library

import com.google.cloud.dialogflow.v2.Context;
import com.google.cloud.dialogflow.v2.Intent;
import com.google.cloud.dialogflow.v2.Intent.Message;
import com.google.cloud.dialogflow.v2.Intent.Message.Text;
import com.google.cloud.dialogflow.v2.Intent.TrainingPhrase;
import com.google.cloud.dialogflow.v2.Intent.TrainingPhrase.Part;
import com.google.cloud.dialogflow.v2.IntentName;
import com.google.cloud.dialogflow.v2.IntentsClient;
import com.google.cloud.dialogflow.v2.ProjectAgentName;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * DialogFlow API Intent sample.
 */
public class IntentManagement {
  // [START dialogflow_list_intents]

  /**
   * List intents
   *
   * @param projectId Project/Agent Id.
   * @return Intents found.
   */
  public static List<Intent> listIntents(String projectId) throws Exception {
    List<Intent> intents = Lists.newArrayList();
    // Instantiates a client
    try (IntentsClient intentsClient = IntentsClient.create()) {
      // Set the project agent name using the projectID (my-project-id)
      ProjectAgentName parent = ProjectAgentName.of(projectId);

      // Performs the list intents request
      for (Intent intent : intentsClient.listIntents(parent).iterateAll()) {
        System.out.println("====================");
        System.out.format("Intent name: '%s'\n", intent.getName());
        System.out.format("Intent display name: '%s'\n", intent.getDisplayName());
        System.out.format("Action: '%s'\n", intent.getAction());
        System.out.format("Root followup intent: '%s'\n", intent.getRootFollowupIntentName());
        System.out.format("Parent followup intent: '%s'\n", intent.getParentFollowupIntentName());

        System.out.format("Input contexts:\n");
        for (String inputContextName : intent.getInputContextNamesList()) {
          System.out.format("\tName: %s\n", inputContextName);
        }
        System.out.format("Output contexts:\n");
        for (Context outputContext : intent.getOutputContextsList()) {
          System.out.format("\tName: %s\n", outputContext.getName());
        }

        intents.add(intent);
      }
    }
    return intents;
  }
  // [END dialogflow_list_intents]

  // [START dialogflow_create_intent]

  /**
   * Create an intent of the given intent type
   *
   * @param displayName          The display name of the intent.
   * @param projectId            Project/Agent Id.
   * @param trainingPhrasesParts Training phrases.
   * @param messageTexts         Message texts for the agent's response when the intent is detected.
   * @return The created Intent.
   */
  public static Intent createIntent(
      String displayName,
      String projectId,
      List<String> trainingPhrasesParts,
      List<String> messageTexts) throws Exception {
    // Instantiates a client
    try (IntentsClient intentsClient = IntentsClient.create()) {
      // Set the project agent name using the projectID (my-project-id)
      ProjectAgentName parent = ProjectAgentName.of(projectId);

      // Build the trainingPhrases from the trainingPhrasesParts
      List<TrainingPhrase> trainingPhrases = new ArrayList<>();
      for (String trainingPhrase : trainingPhrasesParts) {
        trainingPhrases.add(
            TrainingPhrase.newBuilder().addParts(
                Part.newBuilder().setText(trainingPhrase).build())
                .build());
      }

      // Build the message texts for the agent's response
      Message message = Message.newBuilder()
          .setText(
              Text.newBuilder()
                  .addAllText(messageTexts).build()
          ).build();

      // Build the intent
      Intent intent = Intent.newBuilder()
          .setDisplayName(displayName)
          .addMessages(message)
          .addAllTrainingPhrases(trainingPhrases)
          .build();

      // Performs the create intent request
      Intent response = intentsClient.createIntent(parent, intent);
      System.out.format("Intent created: %s\n", response);

      return response;
    }
  }
  // [END dialogflow_create_intent]

  // [START dialogflow_delete_intent]

  /**
   * Delete intent with the given intent type and intent value
   *
   * @param intentId  The id of the intent.
   * @param projectId Project/Agent Id.
   */
  public static void deleteIntent(String intentId, String projectId) throws Exception {
    // Instantiates a client
    try (IntentsClient intentsClient = IntentsClient.create()) {
      IntentName name = IntentName.of(projectId, intentId);
      // Performs the delete intent request
      intentsClient.deleteIntent(name);
    }
  }
  // [END dialogflow_delete_intent]

  /**
   * Helper method for testing to get intentIds from displayName.
   */
  public static List<String> getIntentIds(String displayName, String projectId) throws Exception {
    List<String> intentIds = new ArrayList<>();

    // Instantiates a client
    try (IntentsClient intentsClient = IntentsClient.create()) {
      ProjectAgentName parent = ProjectAgentName.of(projectId);
      for (Intent intent : intentsClient.listIntents(parent).iterateAll()) {
        if (intent.getDisplayName().equals(displayName)) {
          String[] splitName = intent.getName().split("/");
          intentIds.add(splitName[splitName.length - 1]);
        }
      }
    }

    return intentIds;
  }
}
