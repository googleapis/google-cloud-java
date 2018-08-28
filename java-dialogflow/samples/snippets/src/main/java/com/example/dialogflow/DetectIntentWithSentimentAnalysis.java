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
import com.google.cloud.dialogflow.v2beta1.QueryInput;
import com.google.cloud.dialogflow.v2beta1.QueryParameters;
import com.google.cloud.dialogflow.v2beta1.QueryResult;
import com.google.cloud.dialogflow.v2beta1.SentimentAnalysisRequestConfig;
import com.google.cloud.dialogflow.v2beta1.SessionName;
import com.google.cloud.dialogflow.v2beta1.SessionsClient;
import com.google.cloud.dialogflow.v2beta1.TextInput;
import com.google.cloud.dialogflow.v2beta1.TextInput.Builder;

import java.util.List;
import java.util.UUID;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class DetectIntentWithSentimentAnalysis {

  // [START dialogflow_detect_intent_with_sentiment_analysis]
  /**
   * Returns the result of detect intent with texts as inputs.
   *
   * <p>Using the same `session_id` between requests allows continuation of the conversation.
   *
   * @param projectId Project/Agent Id.
   * @param texts The text intents to be detected based on what a user says.
   * @param sessionId Identifier of the DetectIntent session.
   * @param languageCode Language code of the query.
   */
  public static void detectIntentSentimentAnalysis(
      String projectId, List<String> texts, String sessionId, String languageCode)
      throws Exception {
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
        SentimentAnalysisRequestConfig sentimentAnalysisRequestConfig =
            SentimentAnalysisRequestConfig.newBuilder().setAnalyzeQueryTextSentiment(true).build();

        QueryParameters queryParameters =
            QueryParameters.newBuilder()
                .setSentimentAnalysisRequestConfig(sentimentAnalysisRequestConfig)
                .build();
        DetectIntentRequest detectIntentRequest =
            DetectIntentRequest.newBuilder()
                .setSession(session.toString())
                .setQueryInput(queryInput)
                .setQueryParams(queryParameters)
                .build();

        // Performs the detect intent request
        DetectIntentResponse response = sessionsClient.detectIntent(detectIntentRequest);

        // Display the query result
        QueryResult queryResult = response.getQueryResult();

        System.out.println("====================");
        System.out.format("Query Text: '%s'\n", queryResult.getQueryText());
        System.out.format(
            "Detected Intent: %s (confidence: %f)\n",
            queryResult.getIntent().getDisplayName(), queryResult.getIntentDetectionConfidence());
        System.out.format("Fulfillment Text: '%s'\n", queryResult.getFulfillmentText());
        System.out.format(
            "Sentiment Score: '%s'\n",
            queryResult.getSentimentAnalysisResult().getQueryTextSentiment().getScore());
      }
    }
  }
  // [END dialogflow_detect_intent_with_sentiment_analysis]


  public static void main(String[] args) throws Exception {
    ArgumentParser parser =
        ArgumentParsers.newFor("DetectIntentWithSentimentAnalysis")
            .build()
            .defaultHelp(true)
            .description("Returns the result of detect intent with text as input"
                + "Base.\n"
                + "mvn exec:java -DDetectIntentWithSentimentAnalysis -Dexec.args=\"--projectId "
                + "PROJECT_ID --sessionId SESSION_ID 'hello' 'book a meeting room' 'Mountain View' "
                + "'tomorrow' '10 am' '2 hours' '10 people' 'A' 'yes'\"\n");

    parser.addArgument("--projectId").help("Project/Agent Id").required(true);

    parser.addArgument("--sessionId")
        .help("Identifier of the DetectIntent session (Default: UUID.)")
        .setDefault(UUID.randomUUID().toString());

    parser.addArgument("--languageCode")
        .help("Language Code of the query (Default: en-US")
        .setDefault("en-US");

    parser.addArgument("texts")
        .nargs("+")
        .help("Text: 'Where can I find pricing information?'")
        .required(true);

    try {
      Namespace namespace = parser.parseArgs(args);

      detectIntentSentimentAnalysis(namespace.get("projectId"), namespace.get("texts"),
          namespace.get("sessionId"), namespace.get("languageCode"));
    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }


}
