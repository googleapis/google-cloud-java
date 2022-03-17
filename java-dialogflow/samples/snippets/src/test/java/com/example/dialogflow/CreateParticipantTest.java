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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNotNull;

import com.google.cloud.dialogflow.v2.ConversationName;
import com.google.cloud.dialogflow.v2.ConversationProfileName;
import com.google.cloud.dialogflow.v2.ConversationProfilesClient;
import com.google.cloud.dialogflow.v2.Participant.Role;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Optional;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class CreateParticipantTest {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String CONVERSATION_PROFILE_DISPLAY_NAME = UUID.randomUUID().toString();
  private static final String LOCATION = "global";
  private static final String NAME_PREFIX_IN_OUTPUT = "Name: ";
  private ConversationProfileName conversationProfileName;
  private ByteArrayOutputStream bout;
  private PrintStream newOutputStream;
  private PrintStream originalOutputStream;

  private static void requireEnvVar(String varName) {
    assertNotNull(System.getenv(varName));
  }

  // Extract the name of a newly created resource from latest "Name: %s\n" in sample code output
  private static String getResourceNameFromOutputString(String output) {
    return output.substring(
        output.lastIndexOf(NAME_PREFIX_IN_OUTPUT) + NAME_PREFIX_IN_OUTPUT.length(),
        output.length() - 1);
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() throws IOException {
    originalOutputStream = System.out;
    bout = new ByteArrayOutputStream();
    newOutputStream = new PrintStream(bout);
    System.setOut(newOutputStream);

    // Create a conversation profile
    ConversationProfileManagement.createConversationProfileArticleSuggestion(
        PROJECT_ID, CONVERSATION_PROFILE_DISPLAY_NAME, LOCATION, Optional.empty());
    String output = bout.toString();
    assertThat(output).contains(NAME_PREFIX_IN_OUTPUT);
    conversationProfileName =
        ConversationProfileName.parse(getResourceNameFromOutputString(output));
  }

  @After
  public void tearDown() throws IOException {
    // Delete the created conversation profile
    try (ConversationProfilesClient conversationProfilesClient =
        ConversationProfilesClient.create()) {
      conversationProfilesClient.deleteConversationProfile(conversationProfileName.toString());
    }

    System.setOut(originalOutputStream);
  }

  @Test
  public void testCreateParticipant() throws IOException {
    // Create a conversation
    ConversationManagement.createConversation(
        PROJECT_ID, LOCATION, conversationProfileName.getConversationProfile());
    ConversationName conversationName =
        ConversationName.parse(getResourceNameFromOutputString(bout.toString()));

    // Create a participant
    ParticipantManagement.createParticipant(
        PROJECT_ID, LOCATION, conversationName.getConversation(), Role.END_USER);
    assertThat(bout.toString()).contains("Role: END_USER");
  }
}
