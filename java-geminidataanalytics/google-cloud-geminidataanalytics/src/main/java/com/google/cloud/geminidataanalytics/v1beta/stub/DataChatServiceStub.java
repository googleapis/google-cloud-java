/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.geminidataanalytics.v1beta.stub;

import static com.google.cloud.geminidataanalytics.v1beta.DataChatServiceClient.ListConversationsPagedResponse;
import static com.google.cloud.geminidataanalytics.v1beta.DataChatServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.geminidataanalytics.v1beta.DataChatServiceClient.ListMessagesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.geminidataanalytics.v1beta.ChatRequest;
import com.google.cloud.geminidataanalytics.v1beta.Conversation;
import com.google.cloud.geminidataanalytics.v1beta.CreateConversationRequest;
import com.google.cloud.geminidataanalytics.v1beta.GetConversationRequest;
import com.google.cloud.geminidataanalytics.v1beta.ListConversationsRequest;
import com.google.cloud.geminidataanalytics.v1beta.ListConversationsResponse;
import com.google.cloud.geminidataanalytics.v1beta.ListMessagesRequest;
import com.google.cloud.geminidataanalytics.v1beta.ListMessagesResponse;
import com.google.cloud.geminidataanalytics.v1beta.Message;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataChatService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DataChatServiceStub implements BackgroundResource {

  public ServerStreamingCallable<ChatRequest, Message> chatCallable() {
    throw new UnsupportedOperationException("Not implemented: chatCallable()");
  }

  public UnaryCallable<CreateConversationRequest, Conversation> createConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: createConversationCallable()");
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

  public UnaryCallable<ListMessagesRequest, ListMessagesPagedResponse> listMessagesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMessagesPagedCallable()");
  }

  public UnaryCallable<ListMessagesRequest, ListMessagesResponse> listMessagesCallable() {
    throw new UnsupportedOperationException("Not implemented: listMessagesCallable()");
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
