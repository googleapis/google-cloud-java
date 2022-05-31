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

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.contactcenterinsights.v1.Analysis;
import com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient;
import com.google.cloud.contactcenterinsights.v1.Conversation;
import com.google.cloud.contactcenterinsights.v1.ConversationDataSource;
import com.google.cloud.contactcenterinsights.v1.CreateConversationRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest;
import com.google.cloud.contactcenterinsights.v1.GcsSource;
import com.google.cloud.contactcenterinsights.v1.LocationName;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CreateAnalysisIT {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String TRANSCRIPT_URI = "gs://cloud-samples-data/ccai/chat_sample.json";
  private static final String AUDIO_URI = "gs://cloud-samples-data/ccai/voice_6912.txt";
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private String conversationName;

  private static void requireEnvVar(String varName) {
    assertNotNull(String.format(varName), String.format(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() throws IOException {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

    // Create a conversation.
    try (ContactCenterInsightsClient client = ContactCenterInsightsClient.create()) {
      LocationName parent = LocationName.of(PROJECT_ID, "us-central1");

      Conversation conversation =
          Conversation.newBuilder()
              .setDataSource(
                  ConversationDataSource.newBuilder()
                      .setGcsSource(
                          GcsSource.newBuilder()
                              .setTranscriptUri(TRANSCRIPT_URI)
                              .setAudioUri(AUDIO_URI)
                              .build())
                      .build())
              .setMedium(Conversation.Medium.CHAT)
              .build();

      CreateConversationRequest request =
          CreateConversationRequest.newBuilder()
              .setParent(parent.toString())
              .setConversation(conversation)
              .build();

      Conversation response = client.createConversation(request);
      conversationName = response.getName();
    }
  }

  @After
  public void tearDown() throws Exception, IOException {
    // Delete the conversation.
    try (ContactCenterInsightsClient client = ContactCenterInsightsClient.create()) {
      DeleteConversationRequest request =
          DeleteConversationRequest.newBuilder().setName(conversationName).setForce(true).build();
      client.deleteConversation(request);
    }
    System.setOut(null);
  }

  @Test
  public void testCreateAnalysis() throws Exception, IOException {
    Analysis analysis = CreateAnalysis.createAnalysis(conversationName);
    assertThat(bout.toString()).contains(analysis.getName());
  }
}
