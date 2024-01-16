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

package com.google.cloud.vertexai.generativeai.preview;

import com.google.cloud.vertexai.api.Candidate;
import com.google.cloud.vertexai.api.Candidate.Builder;
import com.google.cloud.vertexai.api.Candidate.FinishReason;
import com.google.cloud.vertexai.api.Citation;
import com.google.cloud.vertexai.api.CitationMetadata;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.Part;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Helper class to post-process GenerateContentResponse. */
public class ResponseHandler {

  /**
   * Get the text message in a GenerateContentResponse.
   *
   * @param response a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance
   * @return a String that aggregates all the text parts in the response
   * @throws IllegalArgumentException if the response has 0 or more than 1 candidates, or if the
   *     response is blocked by safety reason or unauthorized citations
   */
  public static String getText(GenerateContentResponse response) {
    FinishReason finishReason = getFinishReason(response);
    if (finishReason == FinishReason.SAFETY) {
      throw new IllegalArgumentException("The response is blocked due to safety reason.");
    } else if (finishReason == FinishReason.RECITATION) {
      throw new IllegalArgumentException("The response is blocked due to unauthorized citations.");
    }

    String text = "";
    List<Part> parts = response.getCandidates(0).getContent().getPartsList();
    for (Part part : parts) {
      text += part.getText();
    }

    return text;
  }

  /**
   * Get the content in a GenerateContentResponse.
   *
   * @param response a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance
   * @return the {@link com.google.cloud.vertexai.api.Content} in the response
   * @throws IllegalArgumentException if the response has 0 or more than 1 candidates, or if the
   *     response is blocked by safety reason or unauthorized citations
   */
  public static Content getContent(GenerateContentResponse response) {
    FinishReason finishReason = getFinishReason(response);
    if (finishReason == FinishReason.SAFETY) {
      throw new IllegalArgumentException("The response is blocked due to safety reason.");
    } else if (finishReason == FinishReason.RECITATION) {
      throw new IllegalArgumentException("The response is blocked due to unauthorized citations.");
    }

    return response.getCandidates(0).getContent();
  }

  /**
   * Get the finish reason in a GenerateContentResponse.
   *
   * @param response a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance
   * @return the {@link com.google.cloud.vertexai.api.FinishReason} in the response
   * @throws IllegalArgumentException if the response has 0 or more than 1 candidates
   */
  public static FinishReason getFinishReason(GenerateContentResponse response) {
    if (response.getCandidatesCount() != 1) {
      throw new IllegalArgumentException(
          String.format(
              "This response should have exactly 1 candidate, but it has %s.",
              response.getCandidatesCount()));
    }
    return response.getCandidates(0).getFinishReason();
  }

  /** Aggregate a stream of responses into a single GenerateContentResponse. */
  static GenerateContentResponse aggregateStreamIntoResponse(
      ResponseStream<GenerateContentResponse> responseStream) {
    GenerateContentResponse res = GenerateContentResponse.getDefaultInstance();
    Map<Integer, Candidate> candidates = new HashMap<>();
    Map<Integer, List<Part>> aggregatedContentParts = new HashMap<>();
    Map<Integer, List<Citation>> aggregatedCitationMetadata = new HashMap<>();

    for (GenerateContentResponse response : responseStream) {
      res = response;
      for (Candidate candidate : response.getCandidatesList()) {
        // Keep track of candidates by index
        int index = candidate.getIndex();
        candidates.put(index, candidate);

        // Aggregates parts
        if (candidate.hasContent()) {
          List<Part> parts = candidate.getContent().getPartsList();
          List<Part> aggregatedParts =
              aggregatedContentParts.containsKey(index)
                  ? aggregatedContentParts.get(index)
                  : new ArrayList<>();
          if (aggregatedParts.size() == 0 || parts.size() == 0) {
            aggregatedParts.addAll(parts);
          } else {
            Part aggregatedTailPart = aggregatedParts.get(aggregatedParts.size() - 1);
            Part currentResponseHeadPart = parts.get(0);
            if (!aggregatedTailPart.hasText() || !currentResponseHeadPart.hasText()) {
              aggregatedParts.addAll(parts);
            } else {
              aggregatedParts.remove(aggregatedParts.size() - 1);
              aggregatedParts.add(
                  Part.newBuilder()
                      .setText(aggregatedTailPart.getText() + currentResponseHeadPart.getText())
                      .build());
              aggregatedParts.addAll(parts.subList(1, parts.size()));
            }
          }
          aggregatedContentParts.put(index, aggregatedParts);
        }

        // Aggregates citations
        if (candidate.hasCitationMetadata()) {
          List<Citation> citations = candidate.getCitationMetadata().getCitationsList();
          List<Citation> aggregatedCitations =
              aggregatedCitationMetadata.containsKey(index)
                  ? aggregatedCitationMetadata.get(index)
                  : new ArrayList<>();
          aggregatedCitations.addAll(citations);
          aggregatedCitationMetadata.put(index, aggregatedCitations);
        }
      }
    }

    // Update candidates with aggregated data
    List<Candidate> aggregatedCandidates = new ArrayList<>();
    candidates.forEach(
        (index, candidate) -> {
          Builder candidateBuilder = candidate.toBuilder();
          if (aggregatedContentParts.containsKey(index)) {
            candidateBuilder.setContent(
                Content.newBuilder()
                    .setRole("model")
                    .addAllParts(aggregatedContentParts.get(index)));
          }
          if (aggregatedCitationMetadata.containsKey(index)) {
            candidateBuilder.setCitationMetadata(
                CitationMetadata.newBuilder()
                    .addAllCitations(aggregatedCitationMetadata.get(index)));
          }
          aggregatedCandidates.add(candidateBuilder.build());
        });

    res = res.toBuilder().clearCandidates().addAllCandidates(aggregatedCandidates).build();

    return res;
  }
}
