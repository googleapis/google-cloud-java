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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.discoveryengine.v1beta.AssistantServiceGrpc.AssistantServiceImplBase;
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
  public void streamAssist(
      StreamAssistRequest request, StreamObserver<StreamAssistResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StreamAssistResponse) {
      requests.add(request);
      responseObserver.onNext(((StreamAssistResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method StreamAssist, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StreamAssistResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAssistant(
      CreateAssistantRequest request, StreamObserver<Assistant> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Assistant) {
      requests.add(request);
      responseObserver.onNext(((Assistant) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAssistant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Assistant.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAssistant(
      DeleteAssistantRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAssistant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAssistant(
      UpdateAssistantRequest request, StreamObserver<Assistant> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Assistant) {
      requests.add(request);
      responseObserver.onNext(((Assistant) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAssistant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Assistant.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAssistant(
      GetAssistantRequest request, StreamObserver<Assistant> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Assistant) {
      requests.add(request);
      responseObserver.onNext(((Assistant) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAssistant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Assistant.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAssistants(
      ListAssistantsRequest request, StreamObserver<ListAssistantsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAssistantsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAssistantsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAssistants, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAssistantsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
