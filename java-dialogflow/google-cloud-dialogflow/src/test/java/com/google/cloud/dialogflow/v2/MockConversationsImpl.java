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

package com.google.cloud.dialogflow.v2;

import com.google.api.core.BetaApi;
import com.google.cloud.dialogflow.v2.ConversationsGrpc.ConversationsImplBase;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
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
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Conversation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listConversations(
      ListConversationsRequest request,
      StreamObserver<ListConversationsResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListConversationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConversation(
      GetConversationRequest request, StreamObserver<Conversation> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Conversation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void completeConversation(
      CompleteConversationRequest request, StreamObserver<Conversation> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Conversation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCallMatcher(
      CreateCallMatcherRequest request, StreamObserver<CallMatcher> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CallMatcher) {
      requests.add(request);
      responseObserver.onNext(((CallMatcher) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCallMatcher, expected %s or %s",
                  response.getClass().getName(),
                  CallMatcher.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCallMatchers(
      ListCallMatchersRequest request, StreamObserver<ListCallMatchersResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListCallMatchersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCallMatchersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCallMatchers, expected %s or %s",
                  response.getClass().getName(),
                  ListCallMatchersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCallMatcher(
      DeleteCallMatcherRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteCallMatcher, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMessages(
      ListMessagesRequest request, StreamObserver<ListMessagesResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListMessagesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
