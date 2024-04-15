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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.ConversationalSearchServiceClient.ListConversationsPagedResponse;
import static com.google.cloud.discoveryengine.v1beta.ConversationalSearchServiceClient.ListSessionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.Answer;
import com.google.cloud.discoveryengine.v1beta.AnswerQueryRequest;
import com.google.cloud.discoveryengine.v1beta.AnswerQueryResponse;
import com.google.cloud.discoveryengine.v1beta.Conversation;
import com.google.cloud.discoveryengine.v1beta.ConverseConversationRequest;
import com.google.cloud.discoveryengine.v1beta.ConverseConversationResponse;
import com.google.cloud.discoveryengine.v1beta.CreateConversationRequest;
import com.google.cloud.discoveryengine.v1beta.CreateSessionRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteConversationRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteSessionRequest;
import com.google.cloud.discoveryengine.v1beta.GetAnswerRequest;
import com.google.cloud.discoveryengine.v1beta.GetConversationRequest;
import com.google.cloud.discoveryengine.v1beta.GetSessionRequest;
import com.google.cloud.discoveryengine.v1beta.ListConversationsRequest;
import com.google.cloud.discoveryengine.v1beta.ListConversationsResponse;
import com.google.cloud.discoveryengine.v1beta.ListSessionsRequest;
import com.google.cloud.discoveryengine.v1beta.ListSessionsResponse;
import com.google.cloud.discoveryengine.v1beta.Session;
import com.google.cloud.discoveryengine.v1beta.UpdateConversationRequest;
import com.google.cloud.discoveryengine.v1beta.UpdateSessionRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ConversationalSearchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ConversationalSearchServiceStub implements BackgroundResource {

  public UnaryCallable<ConverseConversationRequest, ConverseConversationResponse>
      converseConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: converseConversationCallable()");
  }

  public UnaryCallable<CreateConversationRequest, Conversation> createConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: createConversationCallable()");
  }

  public UnaryCallable<DeleteConversationRequest, Empty> deleteConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConversationCallable()");
  }

  public UnaryCallable<UpdateConversationRequest, Conversation> updateConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConversationCallable()");
  }

  public UnaryCallable<GetConversationRequest, Conversation> getConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: getConversationCallable()");
  }

  public UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listConversationsPagedCallable()");
  }

  public UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConversationsCallable()");
  }

  public UnaryCallable<AnswerQueryRequest, AnswerQueryResponse> answerQueryCallable() {
    throw new UnsupportedOperationException("Not implemented: answerQueryCallable()");
  }

  public UnaryCallable<GetAnswerRequest, Answer> getAnswerCallable() {
    throw new UnsupportedOperationException("Not implemented: getAnswerCallable()");
  }

  public UnaryCallable<CreateSessionRequest, Session> createSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: createSessionCallable()");
  }

  public UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSessionCallable()");
  }

  public UnaryCallable<UpdateSessionRequest, Session> updateSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSessionCallable()");
  }

  public UnaryCallable<GetSessionRequest, Session> getSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: getSessionCallable()");
  }

  public UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse> listSessionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSessionsPagedCallable()");
  }

  public UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSessionsCallable()");
  }

  @Override
  public abstract void close();
}
