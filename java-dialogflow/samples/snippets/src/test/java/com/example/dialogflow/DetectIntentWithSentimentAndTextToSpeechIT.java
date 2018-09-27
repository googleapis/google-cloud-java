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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.dialogflow.v2beta1.QueryResult;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration (system) tests for {@link DetectIntentWithSentimentAnalysis}.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DetectIntentWithSentimentAndTextToSpeechIT {

  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String SESSION_ID = "fake_session_for_testing";
  private static String LANGUAGE_CODE = "en-US";
  private static List<String> TEXTS = Arrays.asList(
      "hello",
      "book a meeting room",
      "Mountain View",
      "tomorrow",
      "10 am",
      "2 hours",
      "10 people",
      "A",
      "yes");

  @Before
  public void setUp() {
    System.setOut(new PrintStream(new ByteArrayOutputStream()));
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testDetectIntentTexts() throws Exception {
    Map<String, com.google.cloud.dialogflow.v2.QueryResult> queryResults =
        DetectIntentTexts.detectIntentTexts(PROJECT_ID, TEXTS, SESSION_ID, LANGUAGE_CODE);
    com.google.cloud.dialogflow.v2.QueryResult finalResult =
        queryResults.get(TEXTS.get(TEXTS.size() - 1));
    assertTrue(finalResult.getAllRequiredParamsPresent());
    assertEquals("All set!", finalResult.getFulfillmentText());
  }

  @Test
  public void testDetectIntentWithSentimentAnalysis() throws Exception {
    assertResults(DetectIntentWithSentimentAnalysis
        .detectIntentSentimentAnalysis(PROJECT_ID, TEXTS, SESSION_ID, LANGUAGE_CODE));
  }

  @Test
  public void testDetectIntentTextToSpeech() throws Exception {
    assertResults(DetectIntentWithTextToSpeechResponse
        .detectIntentWithTexttoSpeech(PROJECT_ID, TEXTS, SESSION_ID, LANGUAGE_CODE));
  }

  private void assertResults(Map<String, QueryResult> queryResults) {
    QueryResult finalResult = queryResults.get(TEXTS.get(TEXTS.size() - 1));
    assertTrue(finalResult.getAllRequiredParamsPresent());
    assertEquals("All set!", finalResult.getFulfillmentText());
  }
}