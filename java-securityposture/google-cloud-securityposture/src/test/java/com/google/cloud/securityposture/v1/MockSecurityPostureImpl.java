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

package com.google.cloud.securityposture.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.securityposture.v1.SecurityPostureGrpc.SecurityPostureImplBase;
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
public class MockSecurityPostureImpl extends SecurityPostureImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSecurityPostureImpl() {
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
  public void listPostures(
      ListPosturesRequest request, StreamObserver<ListPosturesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPosturesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPosturesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPostures, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPosturesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPostureRevisions(
      ListPostureRevisionsRequest request,
      StreamObserver<ListPostureRevisionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPostureRevisionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPostureRevisionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPostureRevisions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPostureRevisionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPosture(GetPostureRequest request, StreamObserver<Posture> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Posture) {
      requests.add(request);
      responseObserver.onNext(((Posture) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPosture, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Posture.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPosture(
      CreatePostureRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreatePosture, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePosture(
      UpdatePostureRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdatePosture, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePosture(
      DeletePostureRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePosture, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void extractPosture(
      ExtractPostureRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ExtractPosture, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPostureDeployments(
      ListPostureDeploymentsRequest request,
      StreamObserver<ListPostureDeploymentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPostureDeploymentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPostureDeploymentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPostureDeployments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPostureDeploymentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPostureDeployment(
      GetPostureDeploymentRequest request, StreamObserver<PostureDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PostureDeployment) {
      requests.add(request);
      responseObserver.onNext(((PostureDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPostureDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PostureDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPostureDeployment(
      CreatePostureDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreatePostureDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePostureDeployment(
      UpdatePostureDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdatePostureDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePostureDeployment(
      DeletePostureDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePostureDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPostureTemplates(
      ListPostureTemplatesRequest request,
      StreamObserver<ListPostureTemplatesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPostureTemplatesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPostureTemplatesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPostureTemplates, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPostureTemplatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPostureTemplate(
      GetPostureTemplateRequest request, StreamObserver<PostureTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PostureTemplate) {
      requests.add(request);
      responseObserver.onNext(((PostureTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPostureTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PostureTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }
}
