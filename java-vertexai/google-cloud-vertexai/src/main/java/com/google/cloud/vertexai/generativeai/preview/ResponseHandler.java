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

import com.google.cloud.vertexai.v1beta1.Candidate;
import com.google.cloud.vertexai.v1beta1.Candidate.FinishReason;
import com.google.cloud.vertexai.v1beta1.Content;
import com.google.cloud.vertexai.v1beta1.GenerateContentResponse;
import com.google.cloud.vertexai.v1beta1.Part;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Helper class to handle GenerateContentResponse. */
public class ResponseHandler {

  /** Get the text message in a GenerateContentResponse. */
  public static String getText(GenerateContentResponse response) {
    if (response.getCandidatesCount() != 1) {
      throw new IllegalArgumentException(
          String.format(
              "This response should have exactly 1 candidate, but it has %s.",
              response.getCandidatesCount()));
    }

    String text = "";
    List<Part> parts = response.getCandidates(0).getContent().getPartsList();
    for (Part part : parts) {
      text += part.getText();
    }

    return text;
  }

  /** Get the content in a GenerateContentResponse. */
  public static Content getContent(GenerateContentResponse response) {
    if (response.getCandidatesCount() != 1) {
      throw new IllegalArgumentException(
          String.format(
              "This response should have exactly 1 candidate, but it has %s.",
              response.getCandidatesCount()));
    }

    return response.getCandidates(0).getContent();
  }

  /** Aggregate a stream of responses into a single GenerateContentResponse. */
  static GenerateContentResponse aggregateStreamIntoResponse(
      ResponseStream<GenerateContentResponse> responseStream) {
    GenerateContentResponse res = GenerateContentResponse.getDefaultInstance();
    Map<Integer, List<Part>> aggregated = new HashMap<>();
    Map<Integer, Candidate> candidates = new HashMap<>();

    for (GenerateContentResponse response : responseStream) {
      res = response;
      for (Candidate candidate : response.getCandidatesList()) {
        int index = candidate.getIndex();
        List<Part> parts = candidate.getContent().getPartsList();
        candidates.put(index, candidate);

        List<Part> aggregatedParts =
            aggregated.containsKey(index) ? aggregated.get(index) : new ArrayList<>();
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
        aggregated.put(index, aggregatedParts);
      }
    }

    List<Candidate> aggregatedCandidates = new ArrayList<>();
    candidates.forEach(
        (index, candidate) ->
            aggregatedCandidates.add(
                candidate.toBuilder()
                    .setContent(
                        Content.newBuilder()
                            .setRole("model")
                            .clearParts()
                            .addAllParts(aggregated.get(index)))
                    .build()));
    res = res.toBuilder().clearCandidates().addAllCandidates(aggregatedCandidates).build();

    return res;
  }

  /** Get the finish reason in a GenerateContentResponse. */
  public static FinishReason getFinishReason(GenerateContentResponse response) {
    if (response.getCandidatesCount() != 1) {
      throw new IllegalArgumentException(
          String.format(
              "This response should have exactly 1 candidate, but it has %s.",
              response.getCandidatesCount()));
    }
    return response.getCandidates(0).getFinishReason();
  }
}
