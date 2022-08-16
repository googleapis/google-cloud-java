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

import com.google.cloud.dialogflow.v2.ConversationProfilesClient;
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
public class CreateConversationProfileTest {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String LOCATION = "global";
  private static final String NAME_PREFIX_IN_OUTPUT = "Name: ";
  private static String conversationProfileNameToDelete = null;
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

  private static void deleteConversationProfile(String conversationProfileName) throws IOException {
    try (ConversationProfilesClient conversationProfilesClient =
        ConversationProfilesClient.create()) {
      conversationProfilesClient.deleteConversationProfile(conversationProfileName);
    }
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() {
    originalOutputStream = System.out;
    bout = new ByteArrayOutputStream();
    newOutputStream = new PrintStream(bout);
    System.setOut(newOutputStream);
  }

  @After
  public void tearDown() throws IOException {
    if (conversationProfileNameToDelete != null) {
      deleteConversationProfile(conversationProfileNameToDelete);
      conversationProfileNameToDelete = null;
    }

    System.setOut(originalOutputStream);
  }

  @Test
  public void testCreateConversationProfileArticleSuggestion() throws IOException {
    String conversationProfileDisplayName = UUID.randomUUID().toString();

    // Create a conversation profile
    String articleSuggestionKnowledgeBaseId = UUID.randomUUID().toString();
    ConversationProfileManagement.createConversationProfileArticleSuggestion(
        PROJECT_ID,
        conversationProfileDisplayName,
        LOCATION,
        Optional.of(articleSuggestionKnowledgeBaseId));

    String output = bout.toString();
    conversationProfileNameToDelete = getResourceNameFromOutputString(output);
    assertThat(output).contains(conversationProfileDisplayName);

    // Delete the conversation profile
    deleteConversationProfile(conversationProfileNameToDelete);
    conversationProfileNameToDelete = null;
  }
}
