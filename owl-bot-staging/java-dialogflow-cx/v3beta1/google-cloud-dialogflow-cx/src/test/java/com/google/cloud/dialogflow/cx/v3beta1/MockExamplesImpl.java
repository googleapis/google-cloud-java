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

package com.google.cloud.dialogflow.cx.v3beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.dialogflow.cx.v3beta1.ExamplesGrpc.ExamplesImplBase;
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
public class MockExamplesImpl extends ExamplesImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockExamplesImpl() {
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
  public void createExample(
      CreateExampleRequest request, StreamObserver<Example> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Example) {
      requests.add(request);
      responseObserver.onNext(((Example) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateExample, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Example.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteExample(DeleteExampleRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteExample, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listExamples(
      ListExamplesRequest request, StreamObserver<ListExamplesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListExamplesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListExamplesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListExamples, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListExamplesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getExample(GetExampleRequest request, StreamObserver<Example> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Example) {
      requests.add(request);
      responseObserver.onNext(((Example) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetExample, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Example.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateExample(
      UpdateExampleRequest request, StreamObserver<Example> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Example) {
      requests.add(request);
      responseObserver.onNext(((Example) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateExample, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Example.class.getName(),
                  Exception.class.getName())));
    }
  }
}
