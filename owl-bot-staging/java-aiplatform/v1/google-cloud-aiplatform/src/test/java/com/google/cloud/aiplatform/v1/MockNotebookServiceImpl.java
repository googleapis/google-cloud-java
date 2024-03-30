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

package com.google.cloud.aiplatform.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.aiplatform.v1.NotebookServiceGrpc.NotebookServiceImplBase;
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
public class MockNotebookServiceImpl extends NotebookServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockNotebookServiceImpl() {
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
  public void createNotebookRuntimeTemplate(
      CreateNotebookRuntimeTemplateRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateNotebookRuntimeTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getNotebookRuntimeTemplate(
      GetNotebookRuntimeTemplateRequest request,
      StreamObserver<NotebookRuntimeTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof NotebookRuntimeTemplate) {
      requests.add(request);
      responseObserver.onNext(((NotebookRuntimeTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetNotebookRuntimeTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  NotebookRuntimeTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNotebookRuntimeTemplates(
      ListNotebookRuntimeTemplatesRequest request,
      StreamObserver<ListNotebookRuntimeTemplatesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListNotebookRuntimeTemplatesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNotebookRuntimeTemplatesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNotebookRuntimeTemplates, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListNotebookRuntimeTemplatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteNotebookRuntimeTemplate(
      DeleteNotebookRuntimeTemplateRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteNotebookRuntimeTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void assignNotebookRuntime(
      AssignNotebookRuntimeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method AssignNotebookRuntime, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getNotebookRuntime(
      GetNotebookRuntimeRequest request, StreamObserver<NotebookRuntime> responseObserver) {
    Object response = responses.poll();
    if (response instanceof NotebookRuntime) {
      requests.add(request);
      responseObserver.onNext(((NotebookRuntime) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetNotebookRuntime, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  NotebookRuntime.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNotebookRuntimes(
      ListNotebookRuntimesRequest request,
      StreamObserver<ListNotebookRuntimesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListNotebookRuntimesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNotebookRuntimesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNotebookRuntimes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListNotebookRuntimesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteNotebookRuntime(
      DeleteNotebookRuntimeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteNotebookRuntime, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void upgradeNotebookRuntime(
      UpgradeNotebookRuntimeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpgradeNotebookRuntime, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void startNotebookRuntime(
      StartNotebookRuntimeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method StartNotebookRuntime, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
