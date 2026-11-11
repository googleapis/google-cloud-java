/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.ces.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.ces.v1beta.AssistantServiceGrpc.AssistantServiceImplBase;
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
public class MockAssistantServiceImpl extends AssistantServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAssistantServiceImpl() {
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
  public void listAssistantSessions(
      ListAssistantSessionsRequest request,
      StreamObserver<ListAssistantSessionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAssistantSessionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAssistantSessionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAssistantSessions, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAssistantSessionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAssistantSession(
      GetAssistantSessionRequest request, StreamObserver<AssistantSession> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AssistantSession) {
      requests.add(request);
      responseObserver.onNext(((AssistantSession) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAssistantSession, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AssistantSession.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAssistantSession(
      CreateAssistantSessionRequest request, StreamObserver<AssistantSession> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AssistantSession) {
      requests.add(request);
      responseObserver.onNext(((AssistantSession) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAssistantSession, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  AssistantSession.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAssistantSession(
      DeleteAssistantSessionRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
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
                  "Unrecognized response type %s for method DeleteAssistantSession, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void runAssistant(
      RunAssistantRequest request, StreamObserver<RunAssistantResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RunAssistantResponse) {
      requests.add(request);
      responseObserver.onNext(((RunAssistantResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RunAssistant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RunAssistantResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void chatAiAssistant(
      ChatAiAssistantRequest request, StreamObserver<ChatAiAssistantResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ChatAiAssistantResponse) {
      requests.add(request);
      responseObserver.onNext(((ChatAiAssistantResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ChatAiAssistant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ChatAiAssistantResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
