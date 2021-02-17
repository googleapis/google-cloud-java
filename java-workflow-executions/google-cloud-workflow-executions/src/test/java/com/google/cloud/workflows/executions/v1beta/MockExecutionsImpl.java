/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.workflows.executions.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.workflows.executions.v1beta.ExecutionsGrpc.ExecutionsImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockExecutionsImpl extends ExecutionsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockExecutionsImpl() {
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
  public void listExecutions(
      ListExecutionsRequest request, StreamObserver<ListExecutionsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListExecutionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListExecutionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListExecutions, expected %s or %s",
                  response.getClass().getName(),
                  ListExecutionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createExecution(
      CreateExecutionRequest request, StreamObserver<Execution> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Execution) {
      requests.add(request);
      responseObserver.onNext(((Execution) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateExecution, expected %s or %s",
                  response.getClass().getName(),
                  Execution.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getExecution(
      GetExecutionRequest request, StreamObserver<Execution> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Execution) {
      requests.add(request);
      responseObserver.onNext(((Execution) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetExecution, expected %s or %s",
                  response.getClass().getName(),
                  Execution.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelExecution(
      CancelExecutionRequest request, StreamObserver<Execution> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Execution) {
      requests.add(request);
      responseObserver.onNext(((Execution) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CancelExecution, expected %s or %s",
                  response.getClass().getName(),
                  Execution.class.getName(),
                  Exception.class.getName())));
    }
  }
}
