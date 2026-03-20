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
import com.google.cloud.ces.v1beta.EvaluationServiceGrpc.EvaluationServiceImplBase;
import com.google.longrunning.Operation;
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
  public void uploadEvaluationAudio(
      UploadEvaluationAudioRequest request,
      StreamObserver<UploadEvaluationAudioResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UploadEvaluationAudioResponse) {
      requests.add(request);
      responseObserver.onNext(((UploadEvaluationAudioResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UploadEvaluationAudio, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  UploadEvaluationAudioResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEvaluation(
      CreateEvaluationRequest request, StreamObserver<Evaluation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateEvaluation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Evaluation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateEvaluation(
      GenerateEvaluationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method GenerateEvaluation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importEvaluations(
      ImportEvaluationsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ImportEvaluations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEvaluationDataset(
      CreateEvaluationDatasetRequest request, StreamObserver<EvaluationDataset> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EvaluationDataset) {
      requests.add(request);
      responseObserver.onNext(((EvaluationDataset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateEvaluationDataset, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  EvaluationDataset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEvaluation(
      UpdateEvaluationRequest request, StreamObserver<Evaluation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateEvaluation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Evaluation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEvaluationDataset(
      UpdateEvaluationDatasetRequest request, StreamObserver<EvaluationDataset> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EvaluationDataset) {
      requests.add(request);
      responseObserver.onNext(((EvaluationDataset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateEvaluationDataset, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  EvaluationDataset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEvaluation(
      DeleteEvaluationRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEvaluation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEvaluationResult(
      DeleteEvaluationResultRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEvaluationResult, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEvaluationDataset(
      DeleteEvaluationDatasetRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEvaluationDataset, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEvaluationRun(
      DeleteEvaluationRunRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEvaluationRun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
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
  public void getEvaluationResult(
      GetEvaluationResultRequest request, StreamObserver<EvaluationResult> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EvaluationResult) {
      requests.add(request);
      responseObserver.onNext(((EvaluationResult) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEvaluationResult, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EvaluationResult.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEvaluationDataset(
      GetEvaluationDatasetRequest request, StreamObserver<EvaluationDataset> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EvaluationDataset) {
      requests.add(request);
      responseObserver.onNext(((EvaluationDataset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEvaluationDataset, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  EvaluationDataset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEvaluationRun(
      GetEvaluationRunRequest request, StreamObserver<EvaluationRun> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EvaluationRun) {
      requests.add(request);
      responseObserver.onNext(((EvaluationRun) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEvaluationRun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EvaluationRun.class.getName(),
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
                  "Unrecognized response type %s for method ListEvaluationResults, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEvaluationResultsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEvaluationDatasets(
      ListEvaluationDatasetsRequest request,
      StreamObserver<ListEvaluationDatasetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEvaluationDatasetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEvaluationDatasetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEvaluationDatasets, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEvaluationDatasetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEvaluationRuns(
      ListEvaluationRunsRequest request,
      StreamObserver<ListEvaluationRunsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEvaluationRunsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEvaluationRunsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEvaluationRuns, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEvaluationRunsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEvaluationExpectations(
      ListEvaluationExpectationsRequest request,
      StreamObserver<ListEvaluationExpectationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEvaluationExpectationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEvaluationExpectationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEvaluationExpectations, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEvaluationExpectationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEvaluationExpectation(
      GetEvaluationExpectationRequest request,
      StreamObserver<EvaluationExpectation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EvaluationExpectation) {
      requests.add(request);
      responseObserver.onNext(((EvaluationExpectation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEvaluationExpectation, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EvaluationExpectation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEvaluationExpectation(
      CreateEvaluationExpectationRequest request,
      StreamObserver<EvaluationExpectation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EvaluationExpectation) {
      requests.add(request);
      responseObserver.onNext(((EvaluationExpectation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateEvaluationExpectation, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EvaluationExpectation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEvaluationExpectation(
      UpdateEvaluationExpectationRequest request,
      StreamObserver<EvaluationExpectation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EvaluationExpectation) {
      requests.add(request);
      responseObserver.onNext(((EvaluationExpectation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateEvaluationExpectation, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EvaluationExpectation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEvaluationExpectation(
      DeleteEvaluationExpectationRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEvaluationExpectation, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createScheduledEvaluationRun(
      CreateScheduledEvaluationRunRequest request,
      StreamObserver<ScheduledEvaluationRun> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ScheduledEvaluationRun) {
      requests.add(request);
      responseObserver.onNext(((ScheduledEvaluationRun) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateScheduledEvaluationRun, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ScheduledEvaluationRun.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getScheduledEvaluationRun(
      GetScheduledEvaluationRunRequest request,
      StreamObserver<ScheduledEvaluationRun> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ScheduledEvaluationRun) {
      requests.add(request);
      responseObserver.onNext(((ScheduledEvaluationRun) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetScheduledEvaluationRun, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ScheduledEvaluationRun.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listScheduledEvaluationRuns(
      ListScheduledEvaluationRunsRequest request,
      StreamObserver<ListScheduledEvaluationRunsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListScheduledEvaluationRunsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListScheduledEvaluationRunsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListScheduledEvaluationRuns, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListScheduledEvaluationRunsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateScheduledEvaluationRun(
      UpdateScheduledEvaluationRunRequest request,
      StreamObserver<ScheduledEvaluationRun> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ScheduledEvaluationRun) {
      requests.add(request);
      responseObserver.onNext(((ScheduledEvaluationRun) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateScheduledEvaluationRun, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ScheduledEvaluationRun.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteScheduledEvaluationRun(
      DeleteScheduledEvaluationRunRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteScheduledEvaluationRun, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void testPersonaVoice(
      TestPersonaVoiceRequest request, StreamObserver<TestPersonaVoiceResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TestPersonaVoiceResponse) {
      requests.add(request);
      responseObserver.onNext(((TestPersonaVoiceResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TestPersonaVoice, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TestPersonaVoiceResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
