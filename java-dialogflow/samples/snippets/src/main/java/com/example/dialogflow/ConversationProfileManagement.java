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

package com.example.dialogflow;

// [START dialogflow_create_conversation_profile_article_suggestion]

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.dialogflow.v2.ConversationProfile;
import com.google.cloud.dialogflow.v2.ConversationProfilesClient;
import com.google.cloud.dialogflow.v2.CreateConversationProfileRequest;
import com.google.cloud.dialogflow.v2.HumanAgentAssistantConfig;
import com.google.cloud.dialogflow.v2.HumanAgentAssistantConfig.SuggestionConfig;
import com.google.cloud.dialogflow.v2.HumanAgentAssistantConfig.SuggestionFeatureConfig;
import com.google.cloud.dialogflow.v2.HumanAgentAssistantConfig.SuggestionQueryConfig;
import com.google.cloud.dialogflow.v2.HumanAgentAssistantConfig.SuggestionQueryConfig.KnowledgeBaseQuerySource;
import com.google.cloud.dialogflow.v2.HumanAgentAssistantConfig.SuggestionTriggerSettings;
import com.google.cloud.dialogflow.v2.KnowledgeBaseName;
import com.google.cloud.dialogflow.v2.LocationName;
import com.google.cloud.dialogflow.v2.SuggestionFeature;
import com.google.cloud.dialogflow.v2.SuggestionFeature.Type;
import java.io.IOException;
import java.util.Optional;

public class ConversationProfileManagement {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String location = "my-location";

    // Set display name of the new conversation profile
    String conversationProfileDisplayName = "my-conversation-profile-display-name";

    // Set knowledge base id for Article Suggestion feature.
    // See details about how to create a knowledge base here,
    // https://cloud.google.com/agent-assist/docs/article-suggestion.
    String articleSuggestionKnowledgeBaseId = "my-article-suggestion-knowledge-base-id";

    // Create a conversation profile
    createConversationProfileArticleSuggestion(
        projectId,
        conversationProfileDisplayName,
        location,
        Optional.of(articleSuggestionKnowledgeBaseId));
  }

  // Set suggestion trigger with no_smalltalk and only_send_user both true, which means that
  // the suggestion is not triggered if last utterance is small talk and is only triggered
  // if participant role of last utterance is END_USER.
  public static SuggestionTriggerSettings buildSuggestionTriggerSettings() {
    return SuggestionTriggerSettings.newBuilder().setNoSmalltalk(true).setOnlyEndUser(true).build();
  }

  // Set the configuration for suggestion query, including the knowledge base query source
  // and maximum number of results to return.
  public static SuggestionQueryConfig buildSuggestionQueryConfig(
      KnowledgeBaseName knowledgeBaseName) {
    return SuggestionQueryConfig.newBuilder()
        .setKnowledgeBaseQuerySource(
            KnowledgeBaseQuerySource.newBuilder().addKnowledgeBases(knowledgeBaseName.toString()))
        .setMaxResults(3)
        .build();
  }

  // Create a conversation profile with given values about Article Suggestion.
  public static void createConversationProfileArticleSuggestion(
      String projectId,
      String displayName,
      String location,
      Optional<String> articleSuggestionKnowledgeBaseId)
      throws ApiException, IOException {
    try (ConversationProfilesClient conversationProfilesClient =
        ConversationProfilesClient.create()) {
      // Create a builder for agent assistance configuration
      SuggestionConfig.Builder suggestionConfigBuilder = SuggestionConfig.newBuilder();

      // Add knowledge base for Article Suggestion feature
      if (articleSuggestionKnowledgeBaseId.isPresent()) {
        KnowledgeBaseName articleSuggestionKbName =
            KnowledgeBaseName.of(projectId, articleSuggestionKnowledgeBaseId.get());

        // Build configuration for Article Suggestion feature
        SuggestionFeatureConfig articleSuggestionFeatureConfig =
            SuggestionFeatureConfig.newBuilder()
                .setSuggestionFeature(
                    SuggestionFeature.newBuilder().setType(Type.ARTICLE_SUGGESTION).build())
                .setSuggestionTriggerSettings(buildSuggestionTriggerSettings())
                .setQueryConfig(buildSuggestionQueryConfig(articleSuggestionKbName))
                .build();

        // Add Article Suggestion feature to agent assistance configuration
        suggestionConfigBuilder.addFeatureConfigs(articleSuggestionFeatureConfig);
      }

      LocationName locationName = LocationName.of(projectId, location);
      // Set a conversation profile with target configurations
      ConversationProfile targetConversationProfile =
          ConversationProfile.newBuilder()
              .setDisplayName(displayName)
              .setLanguageCode("en-US")
              .setHumanAgentAssistantConfig(
                  HumanAgentAssistantConfig.newBuilder()
                      .setHumanAgentSuggestionConfig(suggestionConfigBuilder.build()))
              .build();

      // Create a conversation profile
      ConversationProfile createdConversationProfile =
          conversationProfilesClient.createConversationProfile(
              CreateConversationProfileRequest.newBuilder()
                  .setParent(locationName.toString())
                  .setConversationProfile(targetConversationProfile)
                  .build());
      System.out.println("====================");
      System.out.println("Conversation Profile created:\n");
      System.out.format("Display name: %s\n", createdConversationProfile.getDisplayName());
      System.out.format("Name: %s\n", createdConversationProfile.getName());
    }
  }
}
// [END dialogflow_create_conversation_profile_article_suggestion]
