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

import com.google.cloud.dialogflow.v2beta1.DeleteKnowledgeBaseRequest;
import com.google.cloud.dialogflow.v2beta1.KnowledgeBase;
import com.google.cloud.dialogflow.v2beta1.KnowledgeBasesClient;
import com.google.cloud.dialogflow.v2beta1.ProjectName;
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
public class CreateDocumentTest {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static String KNOWLEDGE_DISPLAY_NAME = UUID.randomUUID().toString();
  private static String DOCUMENT_DISPLAY_NAME = UUID.randomUUID().toString();
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private String knowledgeBaseName;

  private static void requireEnvVar(String varName) {
    assertNotNull(String.format(varName), String.format(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() throws IOException {
    // Create a knowledge base for the document
    try (KnowledgeBasesClient client = KnowledgeBasesClient.create()) {
      KnowledgeBase knowledgeBase =
          KnowledgeBase.newBuilder().setDisplayName(KNOWLEDGE_DISPLAY_NAME).build();
      ProjectName projectName = ProjectName.of(PROJECT_ID);
      KnowledgeBase response = client.createKnowledgeBase(projectName, knowledgeBase);
      // Save the full name for deletion
      knowledgeBaseName = response.getName();
    }

    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() throws IOException {
    // Delete the created knowledge base
    try (KnowledgeBasesClient client = KnowledgeBasesClient.create()) {
      DeleteKnowledgeBaseRequest request =
          DeleteKnowledgeBaseRequest.newBuilder().setName(knowledgeBaseName).setForce(true).build();
      client.deleteKnowledgeBase(request);
    }

    System.setOut(null);
  }

  @Test
  public void testCreateDocument() throws Exception {
    DocumentManagement.createDocument(
        knowledgeBaseName,
        DOCUMENT_DISPLAY_NAME,
        "text/html",
        "FAQ",
        "https://cloud.google.com/storage/docs/faq");
    String got = bout.toString();
    assertThat(got).contains(DOCUMENT_DISPLAY_NAME);
  }
}
