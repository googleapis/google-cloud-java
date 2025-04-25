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

package com.google.cloud.dialogflow.v2beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.dialogflow.v2beta1.ConversationsGrpc.ConversationsImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockConversationsImpl extends ConversationsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockConversationsImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void createConversation(
      CreateConversationRequest request, StreamObserver<Conversation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Conversation) {
      requests.add(request);
      responseObserver.onNext(((Conversation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateConversation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Conversation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listConversations(
      ListConversationsRequest request,
      StreamObserver<ListConversationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConversationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConversationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConversations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConversationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConversation(
      GetConversationRequest request, StreamObserver<Conversation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Conversation) {
      requests.add(request);
      responseObserver.onNext(((Conversation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConversation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Conversation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void completeConversation(
      CompleteConversationRequest request, StreamObserver<Conversation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Conversation) {
      requests.add(request);
      responseObserver.onNext(((Conversation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CompleteConversation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Conversation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void ingestContextReferences(
      IngestContextReferencesRequest request,
      StreamObserver<IngestContextReferencesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IngestContextReferencesResponse) {
      requests.add(request);
      responseObserver.onNext(((IngestContextReferencesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method IngestContextReferences, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IngestContextReferencesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchCreateMessages(
      BatchCreateMessagesRequest request,
      StreamObserver<BatchCreateMessagesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchCreateMessagesResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchCreateMessagesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchCreateMessages, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchCreateMessagesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMessages(
      ListMessagesRequest request, StreamObserver<ListMessagesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMessagesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMessagesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMessages, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMessagesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void suggestConversationSummary(
      SuggestConversationSummaryRequest request,
      StreamObserver<SuggestConversationSummaryResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SuggestConversationSummaryResponse) {
      requests.add(request);
      responseObserver.onNext(((SuggestConversationSummaryResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SuggestConversationSummary, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SuggestConversationSummaryResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateStatelessSummary(
      GenerateStatelessSummaryRequest request,
      StreamObserver<GenerateStatelessSummaryResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateStatelessSummaryResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateStatelessSummaryResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateStatelessSummary, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateStatelessSummaryResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateStatelessSuggestion(
      GenerateStatelessSuggestionRequest request,
      StreamObserver<GenerateStatelessSuggestionResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateStatelessSuggestionResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateStatelessSuggestionResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateStatelessSuggestion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateStatelessSuggestionResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchKnowledge(
      SearchKnowledgeRequest request, StreamObserver<SearchKnowledgeResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchKnowledgeResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchKnowledgeResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchKnowledge, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchKnowledgeResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateSuggestions(
      GenerateSuggestionsRequest request,
      StreamObserver<GenerateSuggestionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateSuggestionsResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateSuggestionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateSuggestions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateSuggestionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
