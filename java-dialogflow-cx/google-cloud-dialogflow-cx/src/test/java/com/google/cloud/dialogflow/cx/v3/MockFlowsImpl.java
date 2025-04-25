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

package com.google.cloud.dialogflow.cx.v3;

import com.google.api.core.BetaApi;
import com.google.cloud.dialogflow.cx.v3.FlowsGrpc.FlowsImplBase;
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
public class MockFlowsImpl extends FlowsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockFlowsImpl() {
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
  public void createFlow(CreateFlowRequest request, StreamObserver<Flow> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Flow) {
      requests.add(request);
      responseObserver.onNext(((Flow) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateFlow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Flow.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFlow(DeleteFlowRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteFlow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFlows(
      ListFlowsRequest request, StreamObserver<ListFlowsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFlowsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFlowsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFlows, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFlowsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFlow(GetFlowRequest request, StreamObserver<Flow> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Flow) {
      requests.add(request);
      responseObserver.onNext(((Flow) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFlow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Flow.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFlow(UpdateFlowRequest request, StreamObserver<Flow> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Flow) {
      requests.add(request);
      responseObserver.onNext(((Flow) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateFlow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Flow.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void trainFlow(TrainFlowRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method TrainFlow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void validateFlow(
      ValidateFlowRequest request, StreamObserver<FlowValidationResult> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FlowValidationResult) {
      requests.add(request);
      responseObserver.onNext(((FlowValidationResult) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ValidateFlow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FlowValidationResult.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFlowValidationResult(
      GetFlowValidationResultRequest request,
      StreamObserver<FlowValidationResult> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FlowValidationResult) {
      requests.add(request);
      responseObserver.onNext(((FlowValidationResult) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFlowValidationResult, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FlowValidationResult.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importFlow(ImportFlowRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ImportFlow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportFlow(ExportFlowRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ExportFlow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
