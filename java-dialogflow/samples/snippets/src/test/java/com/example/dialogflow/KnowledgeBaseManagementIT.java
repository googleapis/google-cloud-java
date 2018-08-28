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
 * Integration (system) tests for {DetectIntentKnowledge, KnowledgeManagement, DocumentManagement}.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class KnowledgeBaseManagementIT {

  private ByteArrayOutputStream bout;
  private DetectIntentKnowledge detectIntentKnowledge;
  private KnowledgeBaseManagement knowledgeBaseManagement;
  private DocumentManagement documentManagement;
  private PrintStream out;
  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String SESSION_ID = "fake_session_for_testing";
  private static String LANGUAGE_CODE = "en-US";
  private static String KNOWLEDGE_BASE_NAME = "fake_knowledge_base_name";
  private static String DOCUMENT_BASE_NAME = "fake_document_name";
  private String knowledgeBaseId = "";
  private String documentId = "";

  private static List<String> TEXTS = Arrays.asList("Where is my data stored?");

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    detectIntentKnowledge = new DetectIntentKnowledge();
    knowledgeBaseManagement = new KnowledgeBaseManagement();
    documentManagement = new DocumentManagement();
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testKnowledgeBase() throws Exception {
    // Check the knowledge base does not yet exist
    knowledgeBaseManagement.listKnowledgeBases(PROJECT_ID);
    String got = bout.toString();
    assertThat(got).doesNotContain("Display Name: " + KNOWLEDGE_BASE_NAME);

    // Create a Knowledge Base
    knowledgeBaseManagement.createKnowledgeBase(PROJECT_ID,KNOWLEDGE_BASE_NAME);
    got = bout.toString();
    assertThat(got).contains("Display Name: " + KNOWLEDGE_BASE_NAME);

    // List Knowledge Bases
    knowledgeBaseManagement.listKnowledgeBases(PROJECT_ID);
    got = bout.toString();
    assertThat(got).contains("Display Name: " + KNOWLEDGE_BASE_NAME);
    knowledgeBaseId = got.split("/knowledgeBases/")[2].trim();

    // Get knowledge base
    knowledgeBaseManagement.getKnowledgeBase(PROJECT_ID,knowledgeBaseId);
    got = bout.toString();
    assertThat(got).contains("Display Name: " + KNOWLEDGE_BASE_NAME);

    // Create a Document
    documentManagement.createDocument(PROJECT_ID,knowledgeBaseId,DOCUMENT_BASE_NAME,"text/html","FAQ","https://cloud.google.com/storage/docs/faq");
    got = bout.toString();
    assertThat(got).contains("Display Name: " + DOCUMENT_BASE_NAME);

    // List the Document
    documentManagement.listDocuments(PROJECT_ID,knowledgeBaseId);
    got = bout.toString();
    assertThat(got).contains("Display Name: " + DOCUMENT_BASE_NAME);
    documentId = got.split("documents/")[1].split("- MIME Type")[0].trim();

    // Get the Document
    documentManagement.getDocument(PROJECT_ID,knowledgeBaseId,documentId);
    got = bout.toString();
    assertThat(got).contains("Display Name: " + DOCUMENT_BASE_NAME);

    // Detect Intent with Knowledge Base
    detectIntentKnowledge.detectIntentKnowledge(PROJECT_ID, knowledgeBaseId,SESSION_ID,
        LANGUAGE_CODE, TEXTS);
    got = bout.toString();
    assertThat(got).contains("Knowledge results");

    // Delete the Document
    bout.reset();
    documentManagement.deleteDocument(PROJECT_ID,knowledgeBaseId,documentId);
    got = bout.toString();
    assertThat(got).contains("The document has been deleted.");

    // List the Document
    documentManagement.listDocuments(PROJECT_ID,knowledgeBaseId);
    got = bout.toString();
    assertThat(got).doesNotContain("Display Name: " + DOCUMENT_BASE_NAME);

    // Delete the Knowledge Base
    knowledgeBaseManagement.deleteKnowledgeBase(PROJECT_ID,knowledgeBaseId);

    // List Knowledge Bases
    knowledgeBaseManagement.listKnowledgeBases(PROJECT_ID);
    got = bout.toString();
    assertThat(got).doesNotContain("Display Name: " + KNOWLEDGE_BASE_NAME);

  }

}