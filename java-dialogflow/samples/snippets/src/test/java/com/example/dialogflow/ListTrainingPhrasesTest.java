/*
 * Copyright 2021 Google LLC
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListTrainingPhrasesTest {
  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String intentID = "875138fa-991f-4c2b-b58c-dcbad1638556";

  private ByteArrayOutputStream stdOut;

  @Before
  public void setUp() throws IOException {
    stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));
  }

  @After
  public void tearDown() throws IOException {
    stdOut = null;
    System.setOut(null);
  }

  @Test
  public void testListTrainingPhrases() throws IOException {
    ListTrainingPhrases.listTrainingPhrases(PROJECT_ID, intentID);
    assertThat(stdOut.toString()).contains("What date?");
  }
}
