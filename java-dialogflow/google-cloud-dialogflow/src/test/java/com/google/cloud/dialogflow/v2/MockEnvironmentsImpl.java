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

package com.google.cloud.dialogflow.v2;

import com.google.api.core.BetaApi;
import com.google.cloud.dialogflow.v2.EnvironmentsGrpc.EnvironmentsImplBase;
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
public class MockEnvironmentsImpl extends EnvironmentsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockEnvironmentsImpl() {
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
  public void listEnvironments(
      ListEnvironmentsRequest request, StreamObserver<ListEnvironmentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEnvironmentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEnvironmentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEnvironments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEnvironmentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEnvironment(
      GetEnvironmentRequest request, StreamObserver<Environment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Environment) {
      requests.add(request);
      responseObserver.onNext(((Environment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEnvironment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Environment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEnvironment(
      CreateEnvironmentRequest request, StreamObserver<Environment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Environment) {
      requests.add(request);
      responseObserver.onNext(((Environment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateEnvironment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Environment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEnvironment(
      UpdateEnvironmentRequest request, StreamObserver<Environment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Environment) {
      requests.add(request);
      responseObserver.onNext(((Environment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateEnvironment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Environment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEnvironment(
      DeleteEnvironmentRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEnvironment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEnvironmentHistory(
      GetEnvironmentHistoryRequest request, StreamObserver<EnvironmentHistory> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EnvironmentHistory) {
      requests.add(request);
      responseObserver.onNext(((EnvironmentHistory) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEnvironmentHistory, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EnvironmentHistory.class.getName(),
                  Exception.class.getName())));
    }
  }
}
