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
import com.google.cloud.dialogflow.v2.AudioEncoding;
import com.google.cloud.dialogflow.v2.DetectIntentRequest;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.InputAudioConfig;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.protobuf.ByteString;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;


/**
 * DialogFlow API Detect Intent sample with audio files.
 */
public class DetectIntentAudio {

  // [START dialogflow_detect_intent_audio]
  /**
   * Returns the result of detect intent with an audio file as input.
   *
   * Using the same `session_id` between requests allows continuation of the conversation.
   * @param projectId Project/Agent Id.
   * @param audioFilePath Path to the audio file.
   * @param sessionId Identifier of the DetectIntent session.
   * @param languageCode Language code of the query.
   */
  public static void detectIntentAudio(String projectId, String audioFilePath, String sessionId,
      String languageCode)
      throws Exception {
    // Instantiates a client
    try (SessionsClient sessionsClient = SessionsClient.create()) {
      // Set the session name using the sessionId (UUID) and projectID (my-project-id)
      SessionName session = SessionName.of(projectId, sessionId);
      System.out.println("Session Path: " + session.toString());

      // Note: hard coding audioEncoding and sampleRateHertz for simplicity.
      // Audio encoding of the audio content sent in the query request.
      AudioEncoding audioEncoding = AudioEncoding.AUDIO_ENCODING_LINEAR_16;
      int sampleRateHertz = 16000;

      // Instructs the speech recognizer how to process the audio content.
      InputAudioConfig inputAudioConfig = InputAudioConfig.newBuilder()
          .setAudioEncoding(audioEncoding) // audioEncoding = AudioEncoding.AUDIO_ENCODING_LINEAR_16
          .setLanguageCode(languageCode) // languageCode = "en-US"
          .setSampleRateHertz(sampleRateHertz) // sampleRateHertz = 16000
          .build();

      // Build the query with the InputAudioConfig
      QueryInput queryInput = QueryInput.newBuilder().setAudioConfig(inputAudioConfig).build();

      // Read the bytes from the audio file
      byte[] inputAudio = Files.readAllBytes(Paths.get(audioFilePath));

      // Build the DetectIntentRequest
      DetectIntentRequest request = DetectIntentRequest.newBuilder()
          .setSession(session.toString())
          .setQueryInput(queryInput)
          .setInputAudio(ByteString.copyFrom(inputAudio))
          .build();

      // Performs the detect intent request
      DetectIntentResponse response = sessionsClient.detectIntent(request);

      // Display the query result
      QueryResult queryResult = response.getQueryResult();
      System.out.println("====================");
      System.out.format("Query Text: '%s'\n", queryResult.getQueryText());
      System.out.format("Detected Intent: %s (confidence: %f)\n",
          queryResult.getIntent().getDisplayName(), queryResult.getIntentDetectionConfidence());
      System.out.format("Fulfillment Text: '%s'\n", queryResult.getFulfillmentText());
    }
  }
  // [END dialogflow_detect_intent_audio]

  public static void main(String[] args) throws Exception {
    ArgumentParser parser =
        ArgumentParsers.newFor("DetectIntentAudio")
            .build()
            .defaultHelp(true)
            .description("Returns the result of detect intent with an audio file as input.\n"
                + "mvn exec:java -DDetectIntentAudio -Dexec.args='--projectId PROJECT_ID "
                + "--audioFilePath resources/book_a_room.wav --sessionId SESSION_ID'");

    parser.addArgument("--projectId").help("Project/Agent Id").required(true);

    parser.addArgument("--audioFilePath")
        .help("Path to the audio file")
        .required(true);

    parser.addArgument("--sessionId")
        .help("Identifier of the DetectIntent session (Default: UUID.)")
        .setDefault(UUID.randomUUID().toString());

    parser.addArgument("--languageCode")
        .help("Language Code of the query (Default: en-US")
        .setDefault("en-US");

    try {
      Namespace namespace = parser.parseArgs(args);

      detectIntentAudio(namespace.get("projectId"), namespace.get("audioFilePath"),
          namespace.get("sessionId"), namespace.get("languageCode"));
    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
