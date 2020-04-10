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
  private static String KNOWLEDGE_DISPLAY_NAME = UUID.randomUUID().toString();
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private String knowledgeBaseName;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable '%s' is required to perform these tests.".format(varName),
        String.format(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() {
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
  public void testCreateKnowledgeBase() throws Exception {
    KnowledgeBase knowledgeBase =
        KnowledgeBaseManagement.createKnowledgeBase(PROJECT_ID, KNOWLEDGE_DISPLAY_NAME);
    knowledgeBaseName = knowledgeBase.getName();
    String got = bout.toString();
    assertThat(got).contains(KNOWLEDGE_DISPLAY_NAME);
  }
}
