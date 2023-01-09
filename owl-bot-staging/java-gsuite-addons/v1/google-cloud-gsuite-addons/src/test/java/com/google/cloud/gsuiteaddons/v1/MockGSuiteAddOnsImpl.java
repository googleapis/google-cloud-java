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

package com.google.cloud.gsuiteaddons.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.gsuiteaddons.v1.GSuiteAddOnsGrpc.GSuiteAddOnsImplBase;
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
public class MockGSuiteAddOnsImpl extends GSuiteAddOnsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockGSuiteAddOnsImpl() {
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
  public void getAuthorization(
      GetAuthorizationRequest request, StreamObserver<Authorization> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Authorization) {
      requests.add(request);
      responseObserver.onNext(((Authorization) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAuthorization, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Authorization.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDeployment(
      CreateDeploymentRequest request, StreamObserver<Deployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Deployment) {
      requests.add(request);
      responseObserver.onNext(((Deployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Deployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void replaceDeployment(
      ReplaceDeploymentRequest request, StreamObserver<Deployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Deployment) {
      requests.add(request);
      responseObserver.onNext(((Deployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReplaceDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Deployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDeployment(
      GetDeploymentRequest request, StreamObserver<Deployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Deployment) {
      requests.add(request);
      responseObserver.onNext(((Deployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Deployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDeployments(
      ListDeploymentsRequest request, StreamObserver<ListDeploymentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDeploymentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDeploymentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDeployments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDeploymentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDeployment(
      DeleteDeploymentRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void installDeployment(
      InstallDeploymentRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method InstallDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void uninstallDeployment(
      UninstallDeploymentRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method UninstallDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getInstallStatus(
      GetInstallStatusRequest request, StreamObserver<InstallStatus> responseObserver) {
    Object response = responses.poll();
    if (response instanceof InstallStatus) {
      requests.add(request);
      responseObserver.onNext(((InstallStatus) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetInstallStatus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  InstallStatus.class.getName(),
                  Exception.class.getName())));
    }
  }
}
