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

package com.google.cloud.cloudsecuritycompliance.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.cloudsecuritycompliance.v1.DeploymentGrpc.DeploymentImplBase;
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
public class MockDeploymentImpl extends DeploymentImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDeploymentImpl() {
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
  public void createFrameworkDeployment(
      CreateFrameworkDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateFrameworkDeployment, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFrameworkDeployment(
      DeleteFrameworkDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteFrameworkDeployment, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFrameworkDeployment(
      GetFrameworkDeploymentRequest request, StreamObserver<FrameworkDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FrameworkDeployment) {
      requests.add(request);
      responseObserver.onNext(((FrameworkDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFrameworkDeployment, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  FrameworkDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFrameworkDeployments(
      ListFrameworkDeploymentsRequest request,
      StreamObserver<ListFrameworkDeploymentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFrameworkDeploymentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFrameworkDeploymentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFrameworkDeployments, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFrameworkDeploymentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCloudControlDeployment(
      GetCloudControlDeploymentRequest request,
      StreamObserver<CloudControlDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CloudControlDeployment) {
      requests.add(request);
      responseObserver.onNext(((CloudControlDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCloudControlDeployment, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CloudControlDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCloudControlDeployments(
      ListCloudControlDeploymentsRequest request,
      StreamObserver<ListCloudControlDeploymentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCloudControlDeploymentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCloudControlDeploymentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCloudControlDeployments, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCloudControlDeploymentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
