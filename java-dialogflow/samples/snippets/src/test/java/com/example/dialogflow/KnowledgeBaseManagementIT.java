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

import com.google.cloud.dialogflow.v2beta1.Document;
import com.google.cloud.dialogflow.v2beta1.DocumentName;
import com.google.cloud.dialogflow.v2beta1.KnowledgeAnswers;
import com.google.cloud.dialogflow.v2beta1.KnowledgeAnswers.Answer;
import com.google.cloud.dialogflow.v2beta1.KnowledgeBase;
import com.google.cloud.dialogflow.v2beta1.KnowledgeBaseName;
import com.google.common.collect.ImmutableList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String TEST_KNOWLEDGE_BASE_ID = "MTA4MzE0ODY5NTczMTQzNzU2ODA";
  private static String TEST_DOCUMENT_ID = "MTUwNjk0ODg1NTU4NzkzMDExMg";
  private static String SESSION_ID = UUID.randomUUID().toString();
  private static String LANGUAGE_CODE = "en-US";
  private static String KNOWLEDGE_BASE_NAME = UUID.randomUUID().toString();
  private static String DOCUMENT_BASE_NAME = UUID.randomUUID().toString();

  private static List<String> TEXTS = ImmutableList
          .of("How do I sign up?", "Is my data redundant?", "Where can I find pricing information?",
                  "Where is my data stored?", "What are my support options?",
                  "How can I maximize the availability of my data?");

  @Before
  public void setUp() {
    System.setOut(new PrintStream(new ByteArrayOutputStream()));
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testKnowledgeBase() throws Exception {
    // Create a Knowledge Base
    KnowledgeBase knowledgeBase =
            KnowledgeBaseManagement.createKnowledgeBase(PROJECT_ID, KNOWLEDGE_BASE_NAME);
    assertThat(knowledgeBase.getDisplayName()).contains(KNOWLEDGE_BASE_NAME);

    // Get KnowledgeBase
    knowledgeBase = KnowledgeBaseManagement.getKnowledgeBase(knowledgeBase.getName());
    assertThat(knowledgeBase.getDisplayName()).contains(KNOWLEDGE_BASE_NAME);

    // List Knowledge Bases
    List<KnowledgeBase> knowledgeBases = KnowledgeBaseManagement.listKnowledgeBases(PROJECT_ID);
    assertThat(knowledgeBases.size()).isAtLeast(2);

    int found = 0;
    for (KnowledgeBase knowledgeBase1 : knowledgeBases) {
      if (knowledgeBase1.getDisplayName().equals(KNOWLEDGE_BASE_NAME)) {
        found += 1;
      }
    }
    assertThat(found).isEqualTo(1);

    // Delete the Knowledge Base
    KnowledgeBaseManagement.deleteKnowledgeBase(knowledgeBase.getName());
  }

  @Test
  public void testDocumentManagement() throws Exception {
    // Create a Knowledge Base
    KnowledgeBase knowledgeBase =
            KnowledgeBaseManagement.createKnowledgeBase(PROJECT_ID, KNOWLEDGE_BASE_NAME);
    String knowledgeBaseName = knowledgeBase.getName();

    // Create a Document
    Document document = DocumentManagement.createDocument(
            knowledgeBaseName,
            DOCUMENT_BASE_NAME,
            "text/html",
            "FAQ",
            "https://cloud.google.com/storage/docs/faq");
    assertThat(document.getDisplayName()).contains(DOCUMENT_BASE_NAME);

    // List the Documents
    List<Document> documents = DocumentManagement.listDocuments(knowledgeBaseName);
    assertThat(documents.size()).isEqualTo(1);
    assertThat(documents.get(0).getDisplayName()).contains(DOCUMENT_BASE_NAME);

    // Get the Document
    document = DocumentManagement.getDocument(document.getName());
    assertThat(document.getDisplayName()).contains(DOCUMENT_BASE_NAME);

    // Delete the Document
    DocumentManagement.deleteDocument(document.getName());

    // Delete the Knowledge Base
    KnowledgeBaseManagement.deleteKnowledgeBase(knowledgeBase.getName());
  }

  @Test
  public void testDetectIntentKnowledge() throws Exception {
    KnowledgeBaseName knowledgeBaseName =  KnowledgeBaseName.newBuilder()
            .setProject(PROJECT_ID).setKnowledgeBase(TEST_KNOWLEDGE_BASE_ID).build();

    DocumentName documentName = DocumentName.newBuilder()
            .setProject(PROJECT_ID)
            .setKnowledgeBase(TEST_KNOWLEDGE_BASE_ID)
            .setDocument(TEST_DOCUMENT_ID)
            .build();

    Map<String, KnowledgeAnswers> allAnswers = DetectIntentKnowledge.detectIntentKnowledge(
            PROJECT_ID, knowledgeBaseName.toString(), SESSION_ID, LANGUAGE_CODE, TEXTS);
    assertEquals(TEXTS.size(), allAnswers.size());
    int answersFound = 0;
    for (String text : TEXTS) {
      KnowledgeAnswers knowledgeAnswers = allAnswers.get(text);
      if (knowledgeAnswers.getAnswersCount() > 0) {
        Answer answer = knowledgeAnswers.getAnswers(0);
        if (text.equals(answer.getFaqQuestion())
                && documentName.toString().equals(answer.getSource())) {
          answersFound++;
        }
      }
    }
    // To make the test less flaky, check that half of the texts got a result.
    assertThat(answersFound).isGreaterThan(TEXTS.size() / 2);
  }
}
