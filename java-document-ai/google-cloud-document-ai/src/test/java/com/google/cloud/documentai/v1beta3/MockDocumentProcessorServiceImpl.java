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

package com.google.cloud.documentai.v1beta3;

import com.google.api.core.BetaApi;
import com.google.cloud.documentai.v1beta3.DocumentProcessorServiceGrpc.DocumentProcessorServiceImplBase;
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
public class MockDocumentProcessorServiceImpl extends DocumentProcessorServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDocumentProcessorServiceImpl() {
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
  public void processDocument(
      ProcessRequest request, StreamObserver<ProcessResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ProcessResponse) {
      requests.add(request);
      responseObserver.onNext(((ProcessResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ProcessDocument, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ProcessResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchProcessDocuments(
      BatchProcessRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method BatchProcessDocuments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchProcessorTypes(
      FetchProcessorTypesRequest request,
      StreamObserver<FetchProcessorTypesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchProcessorTypesResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchProcessorTypesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchProcessorTypes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchProcessorTypesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listProcessorTypes(
      ListProcessorTypesRequest request,
      StreamObserver<ListProcessorTypesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListProcessorTypesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListProcessorTypesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListProcessorTypes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListProcessorTypesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listProcessors(
      ListProcessorsRequest request, StreamObserver<ListProcessorsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListProcessorsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListProcessorsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListProcessors, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListProcessorsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getProcessor(
      GetProcessorRequest request, StreamObserver<Processor> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Processor) {
      requests.add(request);
      responseObserver.onNext(((Processor) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetProcessor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Processor.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void trainProcessorVersion(
      TrainProcessorVersionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method TrainProcessorVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getProcessorVersion(
      GetProcessorVersionRequest request, StreamObserver<ProcessorVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ProcessorVersion) {
      requests.add(request);
      responseObserver.onNext(((ProcessorVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetProcessorVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ProcessorVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listProcessorVersions(
      ListProcessorVersionsRequest request,
      StreamObserver<ListProcessorVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListProcessorVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListProcessorVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListProcessorVersions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListProcessorVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteProcessorVersion(
      DeleteProcessorVersionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteProcessorVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deployProcessorVersion(
      DeployProcessorVersionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeployProcessorVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void undeployProcessorVersion(
      UndeployProcessorVersionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UndeployProcessorVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createProcessor(
      CreateProcessorRequest request, StreamObserver<Processor> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Processor) {
      requests.add(request);
      responseObserver.onNext(((Processor) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateProcessor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Processor.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteProcessor(
      DeleteProcessorRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteProcessor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void enableProcessor(
      EnableProcessorRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method EnableProcessor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void disableProcessor(
      DisableProcessorRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DisableProcessor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setDefaultProcessorVersion(
      SetDefaultProcessorVersionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method SetDefaultProcessorVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void reviewDocument(
      ReviewDocumentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ReviewDocument, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void evaluateProcessorVersion(
      EvaluateProcessorVersionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method EvaluateProcessorVersion, expected %s or %s",
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
}
