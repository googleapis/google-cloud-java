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
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private IntentManagement intentManagement;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    intentManagement = new IntentManagement();
  }


  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testCreateIntent() throws Exception {
    // Create the intent
    intentManagement.createIntent(INTENT_DISPLAY_NAME, PROJECT_ID, TRAINING_PHRASE_PARTS,
        MESSAGE_TEXTS);

    List<String> intentIds = intentManagement.getIntentIds(INTENT_DISPLAY_NAME, PROJECT_ID);

    assertThat(intentIds.size()).isEqualTo(1);

    intentManagement.listIntents(PROJECT_ID);

    String got = bout.toString();
    assertThat(got).contains(INTENT_DISPLAY_NAME);
    for (String messageText : MESSAGE_TEXTS) {
      assertThat(got).contains(messageText);
    }

    // Delete the intent
    bout.reset();
    intentIds = intentManagement.getIntentIds(INTENT_DISPLAY_NAME, PROJECT_ID);

    for (String intentId : intentIds) {
      intentManagement.deleteIntent(intentId, PROJECT_ID);
    }

    intentManagement.listIntents(PROJECT_ID);

    got = bout.toString();
    assertThat(got).doesNotContain(INTENT_DISPLAY_NAME);

    intentIds = intentManagement.getIntentIds(INTENT_DISPLAY_NAME, PROJECT_ID);

    assertThat(intentIds.size()).isEqualTo(0);
  }

}
