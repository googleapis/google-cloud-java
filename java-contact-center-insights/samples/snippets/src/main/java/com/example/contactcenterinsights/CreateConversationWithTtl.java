/*
 * Copyright 2021 Google Inc.
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

package com.example.contactcenterinsights;

// [START contactcenterinsights_create_conversation_with_ttl]

import com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient;
import com.google.cloud.contactcenterinsights.v1.Conversation;
import com.google.cloud.contactcenterinsights.v1.ConversationDataSource;
import com.google.cloud.contactcenterinsights.v1.CreateConversationRequest;
import com.google.cloud.contactcenterinsights.v1.GcsSource;
import com.google.cloud.contactcenterinsights.v1.LocationName;
import com.google.protobuf.Duration;
import java.io.IOException;

public class CreateConversationWithTtl {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my_project_id";
    String transcriptUri = "gs://cloud-samples-data/ccai/chat_sample.json";
    String audioUri = "gs://cloud-samples-data/ccai/voice_6912.txt";

    createConversationWithTtl(projectId, transcriptUri, audioUri);
  }

  public static Conversation createConversationWithTtl(
      String projectId, String transcriptUri, String audioUri) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ContactCenterInsightsClient client = ContactCenterInsightsClient.create()) {
      // Construct a parent resource.
      LocationName parent = LocationName.of(projectId, "us-central1");

      // Construct a conversation.
      Conversation conversation =
          Conversation.newBuilder()
              .setDataSource(
                  ConversationDataSource.newBuilder()
                      .setGcsSource(
                          GcsSource.newBuilder()
                              .setTranscriptUri(transcriptUri)
                              .setAudioUri(audioUri)
                              .build())
                      .build())
              .setMedium(Conversation.Medium.CHAT)
              .setTtl(Duration.newBuilder().setSeconds(86400).build())
              .build();

      // Construct a request.
      CreateConversationRequest request =
          CreateConversationRequest.newBuilder()
              .setParent(parent.toString())
              .setConversation(conversation)
              .build();

      // Call the Insights client to create a conversation.
      Conversation response = client.createConversation(request);
      System.out.printf("Created %s%n", response.getName());
      return response;
    }
  }
}

// [END contactcenterinsights_create_conversation_with_ttl]
