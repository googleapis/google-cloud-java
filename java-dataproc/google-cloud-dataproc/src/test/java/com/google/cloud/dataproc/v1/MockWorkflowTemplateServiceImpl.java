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

package com.google.cloud.dataproc.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.dataproc.v1.WorkflowTemplateServiceGrpc.WorkflowTemplateServiceImplBase;
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
public class MockWorkflowTemplateServiceImpl extends WorkflowTemplateServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockWorkflowTemplateServiceImpl() {
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
  public void createWorkflowTemplate(
      CreateWorkflowTemplateRequest request, StreamObserver<WorkflowTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WorkflowTemplate) {
      requests.add(request);
      responseObserver.onNext(((WorkflowTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateWorkflowTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WorkflowTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getWorkflowTemplate(
      GetWorkflowTemplateRequest request, StreamObserver<WorkflowTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WorkflowTemplate) {
      requests.add(request);
      responseObserver.onNext(((WorkflowTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWorkflowTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WorkflowTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void instantiateWorkflowTemplate(
      InstantiateWorkflowTemplateRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method InstantiateWorkflowTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void instantiateInlineWorkflowTemplate(
      InstantiateInlineWorkflowTemplateRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method InstantiateInlineWorkflowTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateWorkflowTemplate(
      UpdateWorkflowTemplateRequest request, StreamObserver<WorkflowTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WorkflowTemplate) {
      requests.add(request);
      responseObserver.onNext(((WorkflowTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateWorkflowTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WorkflowTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWorkflowTemplates(
      ListWorkflowTemplatesRequest request,
      StreamObserver<ListWorkflowTemplatesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWorkflowTemplatesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWorkflowTemplatesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWorkflowTemplates, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWorkflowTemplatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteWorkflowTemplate(
      DeleteWorkflowTemplateRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteWorkflowTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
