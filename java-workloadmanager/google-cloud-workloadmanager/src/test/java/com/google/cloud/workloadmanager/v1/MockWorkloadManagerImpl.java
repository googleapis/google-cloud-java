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

package com.google.cloud.workloadmanager.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.workloadmanager.v1.WorkloadManagerGrpc.WorkloadManagerImplBase;
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
public class MockWorkloadManagerImpl extends WorkloadManagerImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockWorkloadManagerImpl() {
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
  public void updateEvaluation(
      UpdateEvaluationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateEvaluation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEvaluation(
      DeleteEvaluationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEvaluation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listExecutions(
      ListExecutionsRequest request, StreamObserver<ListExecutionsResponse> responseObserver) {
    Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  ListExecutionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getExecution(
      GetExecutionRequest request, StreamObserver<Execution> responseObserver) {
    Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Execution.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void runEvaluation(
      RunEvaluationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RunEvaluation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteExecution(
      DeleteExecutionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteExecution, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listExecutionResults(
      ListExecutionResultsRequest request,
      StreamObserver<ListExecutionResultsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListExecutionResultsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListExecutionResultsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListExecutionResults, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListExecutionResultsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRules(
      ListRulesRequest request, StreamObserver<ListRulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRulesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listScannedResources(
      ListScannedResourcesRequest request,
      StreamObserver<ListScannedResourcesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListScannedResourcesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListScannedResourcesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListScannedResources, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListScannedResourcesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
