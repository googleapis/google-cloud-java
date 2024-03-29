/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.vertexai.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.CountTokensResponse;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseStream;
import java.io.IOException;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ITGenerativeModelIntegrationTest {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String MODEL_NAME_TEXT = "gemini-pro";
  private static final String LOCATION = "us-central1";
  private static final String TEXT = "What do you think about Google Pixel?";
  private static final Logger logger =
      Logger.getLogger(ITGenerativeModelIntegrationTest.class.getName());
  private VertexAI vertexAi;
  private GenerativeModel model;

  @Before
  public void setUp() throws IOException {
    vertexAi = new VertexAI(PROJECT_ID, LOCATION);
    model = new GenerativeModel(MODEL_NAME_TEXT, vertexAi);
  }

  @After
  public void tearDown() throws IOException {
    vertexAi.close();
  }

  @Test
  public void generateContentStreamWithPlainText() throws IOException {
    logger.info(String.format("Generating response for question: %s", TEXT));

    ResponseStream<GenerateContentResponse> stream = model.generateContentStream(TEXT);

    logger.info("Print response: ");
    // GenAI output is flaky so we always print out the response.
    // For the same reason, we don't do assertions much.
    for (GenerateContentResponse resp : stream) {
      logger.info(String.format("Print response:\n%s", resp));
      assertThat(resp.getCandidatesList()).isNotEmpty();
    }
  }

  @Test
  public void generateContentWithPlainText() throws IOException {
    logger.info(String.format("Generating response for question: %s", TEXT));

    GenerateContentResponse response = model.generateContent(TEXT);

    logger.info(String.format("Print response:\n%s", response));
    // GenAI output is flaky so we always print out the response.
    // For the same reason, we don't do assertions much.
    assertThat(response.getCandidatesList()).isNotEmpty();
  }

  @Test
  public void countTokensWithPlainText() throws IOException {
    logger.info(String.format("Counting tokens for: %s", TEXT));

    CountTokensResponse tokens = model.countTokens(TEXT);
    // GenAI output is flaky so we always print out the response.
    // For the same reason, we don't do assertions much.
    logger.info(String.format("Print number of tokens:\n%s", tokens));
    assertThat(tokens.getTotalTokens()).isGreaterThan(0);
  }
}
