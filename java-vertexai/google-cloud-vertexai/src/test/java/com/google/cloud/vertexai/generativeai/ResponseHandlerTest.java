/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.vertexai.generativeai;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.cloud.vertexai.api.Candidate;
import com.google.cloud.vertexai.api.Candidate.FinishReason;
import com.google.cloud.vertexai.api.Citation;
import com.google.cloud.vertexai.api.CitationMetadata;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.FunctionCall;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.Part;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

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
  private static final Content CONTENT_WITH_FNCTION_CALL =
      Content.newBuilder()
          .addParts(Part.newBuilder().setText(TEXT_1))
          .addParts(Part.newBuilder().setFunctionCall(FunctionCall.getDefaultInstance()))
          .addParts(Part.newBuilder().setText(TEXT_2))
          .addParts(Part.newBuilder().setFunctionCall(FunctionCall.getDefaultInstance()))
          .build();
  private static final Citation CITATION_1 =
      Citation.newBuilder().setUri("gs://citation1").setStartIndex(1).setEndIndex(2).build();
  private static final Citation CITATION_2 =
      Citation.newBuilder().setUri("gs://citation2").setStartIndex(10).setEndIndex(11).build();
  private static final Candidate CANDIDATE_1 =
      Candidate.newBuilder()
          .setContent(CONTENT)
          .setCitationMetadata(CitationMetadata.newBuilder().addCitations(CITATION_1))
          .build();
  private static final Candidate CANDIDATE_2 =
      Candidate.newBuilder()
          .setContent(CONTENT)
          .setCitationMetadata(CitationMetadata.newBuilder().addCitations(CITATION_2))
          .build();
  private static final Candidate CANDIDATE_3 =
      Candidate.newBuilder().setContent(CONTENT_WITH_FNCTION_CALL).build();
  private static final GenerateContentResponse RESPONSE_1 =
      GenerateContentResponse.newBuilder().addCandidates(CANDIDATE_1).build();
  private static final GenerateContentResponse RESPONSE_2 =
      GenerateContentResponse.newBuilder().addCandidates(CANDIDATE_2).build();
  private static final GenerateContentResponse RESPONSE_3 =
      GenerateContentResponse.newBuilder().addCandidates(CANDIDATE_3).build();
  private static final GenerateContentResponse INVALID_RESPONSE =
      GenerateContentResponse.newBuilder()
          .addCandidates(CANDIDATE_1)
          .addCandidates(CANDIDATE_2)
          .build();
  private static final class ExampleDto {
    public String name;
    public int count;

    // Default constructor for Jackson
    public ExampleDto() {
    }

    ExampleDto(String name, int count) {
      this.name = name;
      this.count = count;
    }
  }

  private static final String DTO_JSON = "{\"name\":\"vertex\",\"count\":42}";
  private static final GenerateContentResponse DTO_RESPONSE =
          GenerateContentResponse.newBuilder()
                  .addCandidates(
                          Candidate.newBuilder()
                                  .setContent(
                                          Content.newBuilder()
                                                  .addParts(Part.newBuilder().setText(DTO_JSON))))
                  .build();

  @Rule public final MockitoRule mocksRule = MockitoJUnit.rule();

  @Mock private Iterator<GenerateContentResponse> mockServerStreamIterator;

  @Test
  public void testGetTextFromResponse() {
    String text = ResponseHandler.getText(RESPONSE_1);
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
  public void testGetFunctionCallsFromResponse() {
    ImmutableList<FunctionCall> functionCalls = ResponseHandler.getFunctionCalls(RESPONSE_3);
    assertThat(functionCalls.size()).isEqualTo(2);
    assertThat(functionCalls.get(0)).isEqualTo(FunctionCall.getDefaultInstance());
    assertThat(functionCalls.get(1)).isEqualTo(FunctionCall.getDefaultInstance());
  }

  @Test
  public void testGetFunctionCallsFromInvalidResponse() {
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> ResponseHandler.getFunctionCalls(INVALID_RESPONSE));
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo(
            String.format(
                "This response should have exactly 1 candidate, but it has %s.",
                INVALID_RESPONSE.getCandidatesCount()));
  }

  @Test
  public void testGetContentFromResponse() {
    Content content = ResponseHandler.getContent(RESPONSE_1);
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
    FinishReason finishReason = ResponseHandler.getFinishReason(RESPONSE_1);
    assertThat(finishReason).isEqualTo(FinishReason.FINISH_REASON_UNSPECIFIED);
  }

  @Test
  public void testAggregateStreamIntoResponse() {
    ResponseStream<GenerateContentResponse> responseStream =
        new ResponseStream(new ResponseStreamIteratorWithHistory(mockServerStreamIterator));
    when(mockServerStreamIterator.hasNext()).thenReturn(true, true, false);
    when(mockServerStreamIterator.next()).thenReturn(RESPONSE_1, RESPONSE_2);

    GenerateContentResponse response = ResponseHandler.aggregateStreamIntoResponse(responseStream);
    assertThat(ResponseHandler.getText(response)).isEqualTo(TEXT_1 + TEXT_2 + TEXT_1 + TEXT_2);
    assertThat(response.getCandidates(0).getCitationMetadata().getCitationsList())
        .isEqualTo(Arrays.asList(CITATION_1, CITATION_2));
  }

  @Test
  public void testGetStructuredResponseWithCustomMapper() {
    JsonMapper strictMapper =
            JsonMapper.builder()
                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    .build();

    ExampleDto dto =
            ResponseHandler.getStructuredResponse(
                    DTO_RESPONSE, ExampleDto.class, Optional.of(strictMapper));

    assertThat(dto.name).isEqualTo("vertex");
    assertThat(dto.count).isEqualTo(42);
  }

  @Test
  public void testGetStructuredResponseWithDefaultMapper() {
    ExampleDto dto =
            ResponseHandler.getStructuredResponse(
                    DTO_RESPONSE, ExampleDto.class, Optional.empty());

    assertThat(dto.name).isEqualTo("vertex");
    assertThat(dto.count).isEqualTo(42);
  }
}
