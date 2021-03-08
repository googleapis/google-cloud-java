/*
 * Copyright 2021 Google LLC
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

import static com.google.cloud.dialogflow.v2beta1.ConversationsClient.ListCallMatchersPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ConversationsClient.ListConversationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ConversationsClient.ListMessagesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.BatchCreateMessagesRequest;
import com.google.cloud.dialogflow.v2beta1.BatchCreateMessagesResponse;
import com.google.cloud.dialogflow.v2beta1.CallMatcher;
import com.google.cloud.dialogflow.v2beta1.CompleteConversationRequest;
import com.google.cloud.dialogflow.v2beta1.Conversation;
import com.google.cloud.dialogflow.v2beta1.CreateCallMatcherRequest;
import com.google.cloud.dialogflow.v2beta1.CreateConversationRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteCallMatcherRequest;
import com.google.cloud.dialogflow.v2beta1.GetConversationRequest;
import com.google.cloud.dialogflow.v2beta1.ListCallMatchersRequest;
import com.google.cloud.dialogflow.v2beta1.ListCallMatchersResponse;
import com.google.cloud.dialogflow.v2beta1.ListConversationsRequest;
import com.google.cloud.dialogflow.v2beta1.ListConversationsResponse;
import com.google.cloud.dialogflow.v2beta1.ListMessagesRequest;
import com.google.cloud.dialogflow.v2beta1.ListMessagesResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Conversations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ConversationsStub implements BackgroundResource {

  public UnaryCallable<CreateConversationRequest, Conversation> createConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: createConversationCallable()");
  }

  public UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listConversationsPagedCallable()");
  }

  public UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConversationsCallable()");
  }

  public UnaryCallable<GetConversationRequest, Conversation> getConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: getConversationCallable()");
  }

  public UnaryCallable<CompleteConversationRequest, Conversation> completeConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: completeConversationCallable()");
  }

  public UnaryCallable<CreateCallMatcherRequest, CallMatcher> createCallMatcherCallable() {
    throw new UnsupportedOperationException("Not implemented: createCallMatcherCallable()");
  }

  public UnaryCallable<ListCallMatchersRequest, ListCallMatchersPagedResponse>
      listCallMatchersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallMatchersPagedCallable()");
  }

  public UnaryCallable<ListCallMatchersRequest, ListCallMatchersResponse>
      listCallMatchersCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallMatchersCallable()");
  }

  public UnaryCallable<DeleteCallMatcherRequest, Empty> deleteCallMatcherCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallMatcherCallable()");
  }

  public UnaryCallable<BatchCreateMessagesRequest, BatchCreateMessagesResponse>
      batchCreateMessagesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateMessagesCallable()");
  }

  public UnaryCallable<ListMessagesRequest, ListMessagesPagedResponse> listMessagesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMessagesPagedCallable()");
  }

  public UnaryCallable<ListMessagesRequest, ListMessagesResponse> listMessagesCallable() {
    throw new UnsupportedOperationException("Not implemented: listMessagesCallable()");
  }

  @Override
  public abstract void close();
}
