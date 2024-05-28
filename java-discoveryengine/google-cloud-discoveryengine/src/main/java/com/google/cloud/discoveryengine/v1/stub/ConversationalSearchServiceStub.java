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

package com.google.cloud.discoveryengine.v1.stub;

import static com.google.cloud.discoveryengine.v1.ConversationalSearchServiceClient.ListConversationsPagedResponse;
import static com.google.cloud.discoveryengine.v1.ConversationalSearchServiceClient.ListSessionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.Answer;
import com.google.cloud.discoveryengine.v1.AnswerQueryRequest;
import com.google.cloud.discoveryengine.v1.AnswerQueryResponse;
import com.google.cloud.discoveryengine.v1.Conversation;
import com.google.cloud.discoveryengine.v1.ConverseConversationRequest;
import com.google.cloud.discoveryengine.v1.ConverseConversationResponse;
import com.google.cloud.discoveryengine.v1.CreateConversationRequest;
import com.google.cloud.discoveryengine.v1.CreateSessionRequest;
import com.google.cloud.discoveryengine.v1.DeleteConversationRequest;
import com.google.cloud.discoveryengine.v1.DeleteSessionRequest;
import com.google.cloud.discoveryengine.v1.GetAnswerRequest;
import com.google.cloud.discoveryengine.v1.GetConversationRequest;
import com.google.cloud.discoveryengine.v1.GetSessionRequest;
import com.google.cloud.discoveryengine.v1.ListConversationsRequest;
import com.google.cloud.discoveryengine.v1.ListConversationsResponse;
import com.google.cloud.discoveryengine.v1.ListSessionsRequest;
import com.google.cloud.discoveryengine.v1.ListSessionsResponse;
import com.google.cloud.discoveryengine.v1.Session;
import com.google.cloud.discoveryengine.v1.UpdateConversationRequest;
import com.google.cloud.discoveryengine.v1.UpdateSessionRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ConversationalSearchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
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
