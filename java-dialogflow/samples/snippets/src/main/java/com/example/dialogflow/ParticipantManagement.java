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

// [START dialogflow_create_participant]

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.dialogflow.v2.ConversationName;
import com.google.cloud.dialogflow.v2.Participant;
import com.google.cloud.dialogflow.v2.Participant.Role;
import com.google.cloud.dialogflow.v2.ParticipantsClient;
import java.io.IOException;

public class ParticipantManagement {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String location = "my-location";

    // Set conversation id for the new participant,
    // See com.example.dialogflow.ConversationManagement sample code
    // for how to create a conversation.
    String conversationId = "my-conversation-id";
    Role role = Role.END_USER;

    // Create a participant
    createParticipant(projectId, location, conversationId, role);
  }

  // Create a participant with given role
  public static void createParticipant(
      String projectId, String location, String conversationId, Role role)
      throws ApiException, IOException {
    try (ParticipantsClient participantsClient = ParticipantsClient.create()) {
      ConversationName conversationName =
          ConversationName.ofProjectLocationConversationName(projectId, location, conversationId);
      Participant participant = Participant.newBuilder().setRole(role).build();
      Participant newParticipant =
          participantsClient.createParticipant(conversationName, participant);
      System.out.println("====================");
      System.out.println("Participant Created:");
      System.out.format("Role: %s\n", newParticipant.getRole());
      System.out.format("Name: %s\n", newParticipant.getName());
    }
  }
}
// [END dialogflow_create_participant]
