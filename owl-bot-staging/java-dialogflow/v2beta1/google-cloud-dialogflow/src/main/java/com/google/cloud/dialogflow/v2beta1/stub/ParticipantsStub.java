/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.ParticipantsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ParticipantsClient.ListParticipantsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ParticipantsClient.ListSuggestionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.AnalyzeContentRequest;
import com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse;
import com.google.cloud.dialogflow.v2beta1.CompileSuggestionRequest;
import com.google.cloud.dialogflow.v2beta1.CompileSuggestionResponse;
import com.google.cloud.dialogflow.v2beta1.CreateParticipantRequest;
import com.google.cloud.dialogflow.v2beta1.GetParticipantRequest;
import com.google.cloud.dialogflow.v2beta1.ListParticipantsRequest;
import com.google.cloud.dialogflow.v2beta1.ListParticipantsResponse;
import com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest;
import com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse;
import com.google.cloud.dialogflow.v2beta1.Participant;
import com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentRequest;
import com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentResponse;
import com.google.cloud.dialogflow.v2beta1.SuggestArticlesRequest;
import com.google.cloud.dialogflow.v2beta1.SuggestArticlesResponse;
import com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersRequest;
import com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersResponse;
import com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesRequest;
import com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesResponse;
import com.google.cloud.dialogflow.v2beta1.UpdateParticipantRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Participants service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ParticipantsStub implements BackgroundResource {

  public UnaryCallable<CreateParticipantRequest, Participant> createParticipantCallable() {
    throw new UnsupportedOperationException("Not implemented: createParticipantCallable()");
  }

  public UnaryCallable<GetParticipantRequest, Participant> getParticipantCallable() {
    throw new UnsupportedOperationException("Not implemented: getParticipantCallable()");
  }

  public UnaryCallable<ListParticipantsRequest, ListParticipantsPagedResponse>
      listParticipantsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listParticipantsPagedCallable()");
  }

  public UnaryCallable<ListParticipantsRequest, ListParticipantsResponse>
      listParticipantsCallable() {
    throw new UnsupportedOperationException("Not implemented: listParticipantsCallable()");
  }

  public UnaryCallable<UpdateParticipantRequest, Participant> updateParticipantCallable() {
    throw new UnsupportedOperationException("Not implemented: updateParticipantCallable()");
  }

  public UnaryCallable<AnalyzeContentRequest, AnalyzeContentResponse> analyzeContentCallable() {
    throw new UnsupportedOperationException("Not implemented: analyzeContentCallable()");
  }

  public BidiStreamingCallable<StreamingAnalyzeContentRequest, StreamingAnalyzeContentResponse>
      streamingAnalyzeContentCallable() {
    throw new UnsupportedOperationException("Not implemented: streamingAnalyzeContentCallable()");
  }

  public UnaryCallable<SuggestArticlesRequest, SuggestArticlesResponse> suggestArticlesCallable() {
    throw new UnsupportedOperationException("Not implemented: suggestArticlesCallable()");
  }

  public UnaryCallable<SuggestFaqAnswersRequest, SuggestFaqAnswersResponse>
      suggestFaqAnswersCallable() {
    throw new UnsupportedOperationException("Not implemented: suggestFaqAnswersCallable()");
  }

  public UnaryCallable<SuggestSmartRepliesRequest, SuggestSmartRepliesResponse>
      suggestSmartRepliesCallable() {
    throw new UnsupportedOperationException("Not implemented: suggestSmartRepliesCallable()");
  }

  @Deprecated
  public UnaryCallable<ListSuggestionsRequest, ListSuggestionsPagedResponse>
      listSuggestionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSuggestionsPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<ListSuggestionsRequest, ListSuggestionsResponse> listSuggestionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSuggestionsCallable()");
  }

  @Deprecated
  public UnaryCallable<CompileSuggestionRequest, CompileSuggestionResponse>
      compileSuggestionCallable() {
    throw new UnsupportedOperationException("Not implemented: compileSuggestionCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
