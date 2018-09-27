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
import static org.junit.Assert.assertTrue;

import com.google.cloud.dialogflow.v2beta1.QueryResult;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration (system) tests for {@link DetectIntentWithModelSelection}.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DetectIntentWithAudioAndModelSelectionIT {
  protected static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  protected static String SESSION_ID = "fake_session_for_testing";
  protected static String LANGUAGE_CODE = "en-US";
  protected static List<String> QUESTIONS = ImmutableList.of(
      "What date?",
      "What time will the meeting start?",
      "How long will it last?",
      "Thanks. How many people are attending?",
      "I can help with that. Where would you like to reserve a room?");
  protected static Map<String, String> ANSWERS = ImmutableMap.of(
      "I can help with that. Where would you like to reserve a room?",
      "resources/mountain_view.wav",
      "What date?", "resources/today.wav",
      "What time will the meeting start?", "resources/230pm.wav",
      "How long will it last?", "resources/half_an_hour.wav",
      "Thanks. How many people are attending?", "resources/two_people.wav");

  @Before
  public void setUp() {
    System.setOut(new PrintStream(new ByteArrayOutputStream()));
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testDetectIntentAudio() throws Exception {
    List<String> askedQuestions = Lists.newArrayList();
    com.google.cloud.dialogflow.v2.QueryResult result = DetectIntentAudio.detectIntentAudio(
        PROJECT_ID, "resources/book_a_room.wav", SESSION_ID, LANGUAGE_CODE);
    String fulfillmentText = result.getFulfillmentText();
    while (!result.getAllRequiredParamsPresent()
        && ANSWERS.containsKey(fulfillmentText)
        && !askedQuestions.contains(fulfillmentText)) {
      askedQuestions.add(result.getFulfillmentText());
      assertEquals("room.reservation", result.getAction());
      assertThat(QUESTIONS).contains(fulfillmentText);
      result = DetectIntentAudio.detectIntentAudio(
          PROJECT_ID, ANSWERS.get(fulfillmentText), SESSION_ID, LANGUAGE_CODE);
      fulfillmentText = result.getFulfillmentText();
    }
    assertTrue(result.getAllRequiredParamsPresent());
    assertEquals("Choose a room please.", fulfillmentText);
  }

  @Test
  public void testDetectIntentWithModelSelection() throws Exception {
    List<String> askedQuestions = Lists.newArrayList();
    QueryResult result = DetectIntentWithModelSelection.detectIntentWithModelSelection(
        PROJECT_ID, "resources/book_a_room.wav", SESSION_ID, LANGUAGE_CODE);
    String fulfillmentText = result.getFulfillmentText();
    while (!result.getAllRequiredParamsPresent()
        && ANSWERS.containsKey(fulfillmentText)
        && !askedQuestions.contains(fulfillmentText)) {
      askedQuestions.add(result.getFulfillmentText());
      assertEquals("room.reservation", result.getAction());
      assertThat(QUESTIONS).contains(fulfillmentText);
      result = DetectIntentWithModelSelection.detectIntentWithModelSelection(
          PROJECT_ID, ANSWERS.get(fulfillmentText), SESSION_ID, LANGUAGE_CODE);
      fulfillmentText = result.getFulfillmentText();
    }
    assertTrue(result.getAllRequiredParamsPresent());
    assertEquals("Choose a room please.", fulfillmentText);
  }
}
