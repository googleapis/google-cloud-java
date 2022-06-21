/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.aiplatform.v1beta1.VizierServiceGrpc.VizierServiceImplBase;
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
public class MockVizierServiceImpl extends VizierServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockVizierServiceImpl() {
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
  public void createStudy(CreateStudyRequest request, StreamObserver<Study> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Study) {
      requests.add(request);
      responseObserver.onNext(((Study) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateStudy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Study.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getStudy(GetStudyRequest request, StreamObserver<Study> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Study) {
      requests.add(request);
      responseObserver.onNext(((Study) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetStudy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Study.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listStudies(
      ListStudiesRequest request, StreamObserver<ListStudiesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListStudiesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListStudiesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListStudies, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListStudiesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteStudy(DeleteStudyRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteStudy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void lookupStudy(LookupStudyRequest request, StreamObserver<Study> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Study) {
      requests.add(request);
      responseObserver.onNext(((Study) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method LookupStudy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Study.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void suggestTrials(
      SuggestTrialsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method SuggestTrials, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTrial(CreateTrialRequest request, StreamObserver<Trial> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Trial) {
      requests.add(request);
      responseObserver.onNext(((Trial) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTrial, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Trial.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTrial(GetTrialRequest request, StreamObserver<Trial> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Trial) {
      requests.add(request);
      responseObserver.onNext(((Trial) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTrial, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Trial.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTrials(
      ListTrialsRequest request, StreamObserver<ListTrialsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTrialsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTrialsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTrials, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTrialsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void addTrialMeasurement(
      AddTrialMeasurementRequest request, StreamObserver<Trial> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Trial) {
      requests.add(request);
      responseObserver.onNext(((Trial) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AddTrialMeasurement, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Trial.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void completeTrial(CompleteTrialRequest request, StreamObserver<Trial> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Trial) {
      requests.add(request);
      responseObserver.onNext(((Trial) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CompleteTrial, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Trial.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTrial(DeleteTrialRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTrial, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void checkTrialEarlyStoppingState(
      CheckTrialEarlyStoppingStateRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CheckTrialEarlyStoppingState, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void stopTrial(StopTrialRequest request, StreamObserver<Trial> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Trial) {
      requests.add(request);
      responseObserver.onNext(((Trial) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method StopTrial, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Trial.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listOptimalTrials(
      ListOptimalTrialsRequest request,
      StreamObserver<ListOptimalTrialsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListOptimalTrialsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListOptimalTrialsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListOptimalTrials, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListOptimalTrialsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
