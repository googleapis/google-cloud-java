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

// [START dialogflow_create_conversation]

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.dialogflow.v2.Conversation;
import com.google.cloud.dialogflow.v2.ConversationProfileName;
import com.google.cloud.dialogflow.v2.ConversationsClient;
import com.google.cloud.dialogflow.v2.LocationName;
import java.io.IOException;

public class ConversationManagement {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String location = "my-location";

    // Set conversation profile id for the new conversation.
    // See com.example.dialogflow.ConversationProfileManagement sample code for how to create a
    // conversation profile. You can also create a conversation profile using Agent Assist console,
    // https://cloud.google.com/agent-assist/docs/conversation-profile.
    String conversationProfileId = "my-conversation-profile-id";

    // Create a conversation
    createConversation(projectId, location, conversationProfileId);
  }

  public static void createConversation(
      String projectId, String location, String conversationProfileId)
      throws ApiException, IOException {
    try (ConversationsClient conversationsClient = ConversationsClient.create()) {
      LocationName locationName = LocationName.of(projectId, location);
      ConversationProfileName conversationProfileName =
          ConversationProfileName.ofProjectLocationConversationProfileName(
              projectId, location, conversationProfileId);
      Conversation conversation =
          Conversation.newBuilder()
              .setConversationProfile(conversationProfileName.toString())
              .build();
      Conversation newConversation =
          conversationsClient.createConversation(locationName, conversation);
      System.out.println("====================");
      System.out.println("Conversation Created:");
      System.out.format("Life Cycle State: %s\n", newConversation.getLifecycleState());
      System.out.format(
          "Conversation Profile Name: %s\n", newConversation.getConversationProfile());
      System.out.format("Name: %s\n", newConversation.getName());
    }
  }
}
// [END dialogflow_create_conversation]
