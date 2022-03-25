/*
 * Copyright 2020 Google LLC
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
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.dialogflow.v2.DeleteKnowledgeBaseRequest;
import com.google.cloud.dialogflow.v2.KnowledgeBasesClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class CreateKnowledgeBaseTest {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String LOCATION = "global";
  private static final String ID_PREFIX_IN_OUTPUT = "Name: ";
  private static String KNOWLEDGE_DISPLAY_NAME = UUID.randomUUID().toString();
  private String knowledgeBaseName;
  private ByteArrayOutputStream bout;
  private PrintStream newOutputStream;
  private PrintStream originalOutputStream;

  private static void requireEnvVar(String varName) {
    assertNotNull(System.getenv(varName));
  }

  // Extract the name of created resource from "Name: %s\n" in sample code output
  private static String getResourceNameFromOutputString(String output) {
    return output.substring(
        output.lastIndexOf(ID_PREFIX_IN_OUTPUT) + ID_PREFIX_IN_OUTPUT.length(),
        output.length() - 1);
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    newOutputStream = new PrintStream(bout);
    System.setOut(newOutputStream);
  }

  @After
  public void tearDown() throws IOException {
    if (knowledgeBaseName == null) {
      return;
    }

    // Delete the created knowledge base
    try (KnowledgeBasesClient client = KnowledgeBasesClient.create()) {
      DeleteKnowledgeBaseRequest request =
          DeleteKnowledgeBaseRequest.newBuilder().setName(knowledgeBaseName).setForce(true).build();
      client.deleteKnowledgeBase(request);
    }
    System.setOut(originalOutputStream);
  }

  @Test
  public void testCreateKnowledgeBase() throws Exception {
    KnowledgeBaseManagement.createKnowledgeBase(PROJECT_ID, LOCATION, KNOWLEDGE_DISPLAY_NAME);
    String output = bout.toString();
    assertThat(output).contains(KNOWLEDGE_DISPLAY_NAME);
    knowledgeBaseName = getResourceNameFromOutputString(output);
  }
}
