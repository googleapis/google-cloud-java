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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.ParticipantsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2.ParticipantsClient.ListParticipantsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.AnalyzeContentRequest;
import com.google.cloud.dialogflow.v2.AnalyzeContentResponse;
import com.google.cloud.dialogflow.v2.CreateParticipantRequest;
import com.google.cloud.dialogflow.v2.GetParticipantRequest;
import com.google.cloud.dialogflow.v2.ListParticipantsRequest;
import com.google.cloud.dialogflow.v2.ListParticipantsResponse;
import com.google.cloud.dialogflow.v2.Participant;
import com.google.cloud.dialogflow.v2.StreamingAnalyzeContentRequest;
import com.google.cloud.dialogflow.v2.StreamingAnalyzeContentResponse;
import com.google.cloud.dialogflow.v2.SuggestArticlesRequest;
import com.google.cloud.dialogflow.v2.SuggestArticlesResponse;
import com.google.cloud.dialogflow.v2.SuggestFaqAnswersRequest;
import com.google.cloud.dialogflow.v2.SuggestFaqAnswersResponse;
import com.google.cloud.dialogflow.v2.SuggestSmartRepliesRequest;
import com.google.cloud.dialogflow.v2.SuggestSmartRepliesResponse;
import com.google.cloud.dialogflow.v2.UpdateParticipantRequest;
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
