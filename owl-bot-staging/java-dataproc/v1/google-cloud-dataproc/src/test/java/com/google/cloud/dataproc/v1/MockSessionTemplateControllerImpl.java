/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.dataproc.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.dataproc.v1.SessionTemplateControllerGrpc.SessionTemplateControllerImplBase;
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
public class MockSessionTemplateControllerImpl extends SessionTemplateControllerImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSessionTemplateControllerImpl() {
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
  public void createSessionTemplate(
      CreateSessionTemplateRequest request, StreamObserver<SessionTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SessionTemplate) {
      requests.add(request);
      responseObserver.onNext(((SessionTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSessionTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SessionTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSessionTemplate(
      UpdateSessionTemplateRequest request, StreamObserver<SessionTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SessionTemplate) {
      requests.add(request);
      responseObserver.onNext(((SessionTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSessionTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SessionTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSessionTemplate(
      GetSessionTemplateRequest request, StreamObserver<SessionTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SessionTemplate) {
      requests.add(request);
      responseObserver.onNext(((SessionTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSessionTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SessionTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSessionTemplates(
      ListSessionTemplatesRequest request,
      StreamObserver<ListSessionTemplatesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSessionTemplatesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSessionTemplatesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSessionTemplates, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSessionTemplatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSessionTemplate(
      DeleteSessionTemplateRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSessionTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
