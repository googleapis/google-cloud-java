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

import static org.junit.Assert.assertTrue;

import com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration (system) tests for {@link DetectIntentStream}.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DetectIntentStreamIT {

  private static String audioFilePath = "resources/book_a_room.wav";
  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String SESSION_ID = "fake_session_for_testing";
  private static String LANGUAGE_CODE = "en-US";

  @Before
  public void setUp() {
    System.setOut(new PrintStream(new ByteArrayOutputStream()));
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testStreamingDetectIntentCallable() throws Throwable {
    List<StreamingDetectIntentResponse> response = DetectIntentStream.detectIntentStream(
        PROJECT_ID, audioFilePath, SESSION_ID, LANGUAGE_CODE);
    assertTrue(response.size() > 0);
    assertTrue(response.stream().anyMatch(i -> i
        .getQueryResult()
        .getIntent()
        .getDisplayName().equals("room.reservation")));
    assertTrue(response.stream().anyMatch(i -> i
        .getRecognitionResult()
        .getTranscript().contains("book")));
  }
}
