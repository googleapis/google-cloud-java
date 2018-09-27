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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.dialogflow.v2.Intent;
import com.google.cloud.dialogflow.v2.IntentsClient;
import com.google.cloud.dialogflow.v2.ProjectAgentName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration (system) tests for {@link IntentManagement}.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class IntentManagementIT {
  private static String INTENT_DISPLAY_NAME = "fake_display_name_for_testing";
  private static List<String> MESSAGE_TEXTS = Arrays.asList(
      "fake_message_text_for_testing_1",
      "fake_message_text_for_testing_2");
  private static List<String> TRAINING_PHRASE_PARTS = Arrays.asList(
      "fake_training_phrase_part_1",
      "fake_training_phrase_part_2");
  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");

  @Before
  public void setUp() {
    System.setOut(new PrintStream(new ByteArrayOutputStream()));
  }

  @After
  public void tearDown() throws Exception {
    try (IntentsClient intentsClient = IntentsClient.create()) {
      // Set the project agent name using the projectID (my-project-id)
      ProjectAgentName parent = ProjectAgentName.of(PROJECT_ID);

      // Performs the list intents request
      for (Intent intent : intentsClient.listIntents(parent).iterateAll()) {
        if (intent.getDisplayName().equals(INTENT_DISPLAY_NAME)) {
          intentsClient.deleteIntent(intent.getName());
        }
      }
    }
    System.setOut(null);
  }

  @Test
  public void testCreateIntent() throws Exception {
    // Create the intent
    Intent intent = IntentManagement.createIntent(
        INTENT_DISPLAY_NAME, PROJECT_ID, TRAINING_PHRASE_PARTS, MESSAGE_TEXTS);
    assertNotNull(intent);

    List<String> intentIds = IntentManagement.getIntentIds(intent.getDisplayName(), PROJECT_ID);
    assertThat(intentIds.size()).isEqualTo(1);

    List<Intent> intents = IntentManagement.listIntents(PROJECT_ID);
    assertTrue(intents.size() > 0);
    assertThat(intents).contains(intent);
    for (String messageText : MESSAGE_TEXTS) {
      assertTrue(intent.getMessagesList()
          .stream().anyMatch(message -> message.getText().toString().contains(messageText)));
    }

    for (String intentId : intentIds) {
      IntentManagement.deleteIntent(intentId, PROJECT_ID);
    }

    int numIntents = intents.size();
    intents = IntentManagement.listIntents(PROJECT_ID);
    assertEquals(numIntents - 1, intents.size());
  }
}
