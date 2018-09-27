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

import com.google.cloud.dialogflow.v2.Context;
import com.google.cloud.dialogflow.v2.ContextName;
import com.google.cloud.dialogflow.v2.ContextsClient;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

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
  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String SESSION_ID = "fake_session_for_testing";
  private static String CONTEXT_ID = "fake_context_for_testing";

  @Before
  public void setUp() {
    System.setOut(new PrintStream(new ByteArrayOutputStream()));
  }

  @After
  public void tearDown() throws Exception {
    try (ContextsClient contextsClient = ContextsClient.create()) {
      // If the Context still exists, delete it.
      try {
        ContextName contextName = ContextName.of(PROJECT_ID, SESSION_ID, CONTEXT_ID);
        Context existing = contextsClient.getContext(contextName);
        contextsClient.deleteContext(existing.getName());
      } catch (Exception e) {
        // Context doesn't exist, nothing to do.
      }
    }
    System.setOut(null);
  }

  @Test
  public void testCreateDeleteContext() throws Exception {
    // Create the context
    Context context = ContextManagement.createContext(CONTEXT_ID, SESSION_ID, PROJECT_ID, 1);
    assertThat(context.getName()).contains(CONTEXT_ID);
    assertEquals(1, context.getLifespanCount());

    List<Context> contexts = ContextManagement.listContexts(SESSION_ID, PROJECT_ID);
    assertTrue(contexts.size() > 0);
    assertTrue(contexts.stream().anyMatch(c -> c.getName().contains(SESSION_ID)
        && c.getName().contains(CONTEXT_ID)));

    // Delete the context
    ContextManagement.deleteContext(CONTEXT_ID, SESSION_ID, PROJECT_ID);
    int numContexts = contexts.size();
    contexts = ContextManagement.listContexts(SESSION_ID, PROJECT_ID);
    assertEquals(numContexts - 1, contexts.size());
  }
}
