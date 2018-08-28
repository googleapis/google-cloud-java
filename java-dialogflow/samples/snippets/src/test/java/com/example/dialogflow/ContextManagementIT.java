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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration (system) tests for {@link ContextManagement}.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class ContextManagementIT {

  private ByteArrayOutputStream bout;
  private PrintStream out;

  private DetectIntentTexts detectIntentTexts;
  private ContextManagement contextManagement;
  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String SESSION_ID = "fake_session_for_testing";
  private static String CONTEXT_ID = "fake_context_for_testing";

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    detectIntentTexts = new DetectIntentTexts();
    contextManagement = new ContextManagement();
    PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testCreateDeleteContext() throws Exception {
    // Calling detect intent to create a session
    detectIntentTexts.detectIntentTexts(PROJECT_ID, Arrays.asList("hi"), SESSION_ID, "en-US");

    // Create the context
    contextManagement.createContext(CONTEXT_ID, SESSION_ID, PROJECT_ID, 1);
    contextManagement.listContexts(SESSION_ID, PROJECT_ID);

    String got = bout.toString();
    assertThat(got).contains(CONTEXT_ID);

    // Delete the context
    bout.reset();
    contextManagement.deleteContext(CONTEXT_ID, SESSION_ID, PROJECT_ID);
    contextManagement.listContexts(SESSION_ID, PROJECT_ID);

    got = bout.toString();
    assertThat(got).doesNotContain(CONTEXT_ID);
  }
}
