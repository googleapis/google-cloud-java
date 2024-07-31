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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.discoveryengine.v1beta.EvaluationServiceGrpc.EvaluationServiceImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockEvaluationServiceImpl extends EvaluationServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockEvaluationServiceImpl() {
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
  public void getEvaluation(
      GetEvaluationRequest request, StreamObserver<Evaluation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Evaluation) {
      requests.add(request);
      responseObserver.onNext(((Evaluation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEvaluation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Evaluation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEvaluations(
      ListEvaluationsRequest request, StreamObserver<ListEvaluationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEvaluationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEvaluationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEvaluations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEvaluationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEvaluation(
      CreateEvaluationRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateEvaluation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEvaluationResults(
      ListEvaluationResultsRequest request,
      StreamObserver<ListEvaluationResultsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEvaluationResultsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEvaluationResultsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEvaluationResults, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEvaluationResultsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
