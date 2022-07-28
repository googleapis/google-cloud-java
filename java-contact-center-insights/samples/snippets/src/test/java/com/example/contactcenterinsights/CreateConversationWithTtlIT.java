/*
 * Copyright 2021 Google Inc.
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

package com.example.contactcenterinsights;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient;
import com.google.cloud.contactcenterinsights.v1.Conversation;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CreateConversationWithTtlIT {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String TRANSCRIPT_URI = "gs://cloud-samples-data/ccai/chat_sample.json";
  private static final String AUDIO_URI = "gs://cloud-samples-data/ccai/voice_6912.txt";
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private String conversationName;

  private static void requireEnvVar(String varName) {
    assertNotNull(String.format(varName), String.format(varName));
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
    try (ContactCenterInsightsClient client = ContactCenterInsightsClient.create()) {
      client.deleteConversation(conversationName);
    }
    System.setOut(null);
  }

  @Test
  public void testCreateConversationWithTtl() throws IOException {
    Conversation conversation =
        CreateConversationWithTtl.createConversationWithTtl(PROJECT_ID, TRANSCRIPT_URI, AUDIO_URI);
    conversationName = conversation.getName();
    assertThat(bout.toString()).contains(conversationName);
  }
}
