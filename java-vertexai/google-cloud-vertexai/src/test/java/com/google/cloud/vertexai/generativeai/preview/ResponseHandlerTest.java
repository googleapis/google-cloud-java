/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.vertexai.generativeai.preview;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.vertexai.v1beta1.Candidate;
import com.google.cloud.vertexai.v1beta1.Candidate.FinishReason;
import com.google.cloud.vertexai.v1beta1.Content;
import com.google.cloud.vertexai.v1beta1.GenerateContentResponse;
import com.google.cloud.vertexai.v1beta1.Part;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class ResponseHandlerTest {
  private static final String TEXT_1 = "test ";
  private static final String TEXT_2 = "response.";
  private static final Content CONTENT =
      Content.newBuilder()
          .setRole("model")
          .addParts(Part.newBuilder().setText(TEXT_1))
          .addParts(Part.newBuilder().setText(TEXT_2))
          .build();
  private static final Candidate CANDIDATE = Candidate.newBuilder().setContent(CONTENT).build();
  private static final GenerateContentResponse RESPONSE =
      GenerateContentResponse.newBuilder().addCandidates(CANDIDATE).build();
  private static final GenerateContentResponse INVALID_RESPONSE =
      GenerateContentResponse.newBuilder()
          .addCandidates(CANDIDATE)
          .addCandidates(CANDIDATE)
          .build();

  @Test
  public void testGetTextFromResponse() {
    String text = ResponseHandler.getText(RESPONSE);
    assertThat(text).isEqualTo(TEXT_1 + TEXT_2);
  }

  @Test
  public void testGetTextFromInvalidResponse() {
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class, () -> ResponseHandler.getText(INVALID_RESPONSE));
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo(
            String.format(
                "This response should have exactly 1 candidate, but it has %s.",
                INVALID_RESPONSE.getCandidatesCount()));
  }

  @Test
  public void testGetContentFromResponse() {
    Content content = ResponseHandler.getContent(RESPONSE);
    assertThat(content).isEqualTo(CONTENT);
  }

  @Test
  public void testGetContentFromInvalidResponse() {
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class, () -> ResponseHandler.getContent(INVALID_RESPONSE));
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo(
            String.format(
                "This response should have exactly 1 candidate, but it has %s.",
                INVALID_RESPONSE.getCandidatesCount()));
  }

  @Test
  public void getFinishReason_unspecified() {
    Content content =
        Content.newBuilder().addParts(Part.newBuilder().setText("replied message")).build();
    Candidate candidate = Candidate.newBuilder().setContent(content).build();
    GenerateContentResponse response =
        GenerateContentResponse.newBuilder().addCandidates(candidate).build();
    assertThat(ResponseHandler.getFinishReason(response))
        .isEqualTo(FinishReason.FINISH_REASON_UNSPECIFIED);
  }
}
