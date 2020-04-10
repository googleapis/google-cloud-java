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

import com.google.cloud.dialogflow.v2beta1.DocumentName;
import com.google.cloud.dialogflow.v2beta1.KnowledgeAnswers;
import com.google.cloud.dialogflow.v2beta1.KnowledgeAnswers.Answer;
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


@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DetectIntentKnowledgeTest {

  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String TEST_KNOWLEDGE_BASE_ID = "MTA4MzE0ODY5NTczMTQzNzU2ODA";
  private static String TEST_DOCUMENT_ID = "MTUwNjk0ODg1NTU4NzkzMDExMg";
  private static String SESSION_ID = UUID.randomUUID().toString();
  private static String LANGUAGE_CODE = "en-US";

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
