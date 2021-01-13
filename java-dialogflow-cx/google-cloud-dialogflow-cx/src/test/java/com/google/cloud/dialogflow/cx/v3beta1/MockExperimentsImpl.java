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

package com.google.cloud.dialogflow.cx.v3beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.dialogflow.cx.v3beta1.ExperimentsGrpc.ExperimentsImplBase;
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
public class MockExperimentsImpl extends ExperimentsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockExperimentsImpl() {
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
  public void listExperiments(
      ListExperimentsRequest request, StreamObserver<ListExperimentsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListExperimentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListExperimentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getExperiment(
      GetExperimentRequest request, StreamObserver<Experiment> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Experiment) {
      requests.add(request);
      responseObserver.onNext(((Experiment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createExperiment(
      CreateExperimentRequest request, StreamObserver<Experiment> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Experiment) {
      requests.add(request);
      responseObserver.onNext(((Experiment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateExperiment(
      UpdateExperimentRequest request, StreamObserver<Experiment> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Experiment) {
      requests.add(request);
      responseObserver.onNext(((Experiment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteExperiment(
      DeleteExperimentRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void startExperiment(
      StartExperimentRequest request, StreamObserver<Experiment> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Experiment) {
      requests.add(request);
      responseObserver.onNext(((Experiment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void stopExperiment(
      StopExperimentRequest request, StreamObserver<Experiment> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Experiment) {
      requests.add(request);
      responseObserver.onNext(((Experiment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
