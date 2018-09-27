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

import com.google.cloud.dialogflow.v2beta1.DetectIntentRequest;
import com.google.cloud.dialogflow.v2beta1.DetectIntentResponse;
import com.google.cloud.dialogflow.v2beta1.OutputAudioConfig;
import com.google.cloud.dialogflow.v2beta1.OutputAudioEncoding;
import com.google.cloud.dialogflow.v2beta1.QueryInput;
import com.google.cloud.dialogflow.v2beta1.QueryResult;
import com.google.cloud.dialogflow.v2beta1.SessionName;
import com.google.cloud.dialogflow.v2beta1.SessionsClient;
import com.google.cloud.dialogflow.v2beta1.TextInput;
import com.google.cloud.dialogflow.v2beta1.TextInput.Builder;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class DetectIntentWithTextToSpeechResponse {
  //   [START dialogflow_detect_intent_with_texttospeech_response]

  /**
   * Returns the result of detect intent with texts as inputs.
   *
   * <p>Using the same `session_id` between requests allows continuation of the conversation.
   *
   * @param projectId    Project/Agent Id.
   * @param texts        The text intents to be detected based on what a user says.
   * @param sessionId    Identifier of the DetectIntent session.
   * @param languageCode Language code of the query.
   * @return The QueryResult for each input text.
   */
  public static Map<String, QueryResult> detectIntentWithTexttoSpeech(
      String projectId,
      List<String> texts,
      String sessionId,
      String languageCode) throws Exception {
    Map<String, QueryResult> queryResults = Maps.newHashMap();
    // Instantiates a client
    try (SessionsClient sessionsClient = SessionsClient.create()) {
      // Set the session name using the sessionId (UUID) and projectID (my-project-id)
      SessionName session = SessionName.of(projectId, sessionId);
      System.out.println("Session Path: " + session.toString());

      // Detect intents for each text input
      for (String text : texts) {
        // Set the text (hello) and language code (en-US) for the query
        Builder textInput = TextInput.newBuilder().setText(text).setLanguageCode(languageCode);

        // Build the query with the TextInput
        QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

        //
        OutputAudioEncoding audioEncoding = OutputAudioEncoding.OUTPUT_AUDIO_ENCODING_LINEAR_16;
        int sampleRateHertz = 16000;
        OutputAudioConfig outputAudioConfig =
            OutputAudioConfig.newBuilder()
                .setAudioEncoding(audioEncoding)
                .setSampleRateHertz(sampleRateHertz)
                .build();

        DetectIntentRequest dr =
            DetectIntentRequest.newBuilder()
                .setQueryInput(queryInput)
                .setOutputAudioConfig(outputAudioConfig)
                .setSession(session.toString())
                .build();

        // Performs the detect intent request
        DetectIntentResponse response = sessionsClient.detectIntent(dr);

        // Display the query result
        QueryResult queryResult = response.getQueryResult();

        System.out.println("====================");
        System.out.format("Query Text: '%s'\n", queryResult.getQueryText());
        System.out.format(
            "Detected Intent: %s (confidence: %f)\n",
            queryResult.getIntent().getDisplayName(), queryResult.getIntentDetectionConfidence());
        System.out.format("Fulfillment Text: '%s'\n", queryResult.getFulfillmentText());

        queryResults.put(text, queryResult);
      }
    }
    return queryResults;
  }
  // [END dialogflow_detect_intent_with_texttospeech_response]
}
