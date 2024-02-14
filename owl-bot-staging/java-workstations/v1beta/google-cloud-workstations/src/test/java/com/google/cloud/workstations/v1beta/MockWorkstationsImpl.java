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

package com.google.cloud.workstations.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.workstations.v1beta.WorkstationsGrpc.WorkstationsImplBase;
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
public class MockWorkstationsImpl extends WorkstationsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockWorkstationsImpl() {
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
  public void getWorkstationCluster(
      GetWorkstationClusterRequest request, StreamObserver<WorkstationCluster> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WorkstationCluster) {
      requests.add(request);
      responseObserver.onNext(((WorkstationCluster) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWorkstationCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WorkstationCluster.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWorkstationClusters(
      ListWorkstationClustersRequest request,
      StreamObserver<ListWorkstationClustersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWorkstationClustersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWorkstationClustersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWorkstationClusters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWorkstationClustersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createWorkstationCluster(
      CreateWorkstationClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateWorkstationCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateWorkstationCluster(
      UpdateWorkstationClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateWorkstationCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteWorkstationCluster(
      DeleteWorkstationClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteWorkstationCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getWorkstationConfig(
      GetWorkstationConfigRequest request, StreamObserver<WorkstationConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WorkstationConfig) {
      requests.add(request);
      responseObserver.onNext(((WorkstationConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWorkstationConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WorkstationConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWorkstationConfigs(
      ListWorkstationConfigsRequest request,
      StreamObserver<ListWorkstationConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWorkstationConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWorkstationConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWorkstationConfigs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWorkstationConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listUsableWorkstationConfigs(
      ListUsableWorkstationConfigsRequest request,
      StreamObserver<ListUsableWorkstationConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListUsableWorkstationConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUsableWorkstationConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUsableWorkstationConfigs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListUsableWorkstationConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createWorkstationConfig(
      CreateWorkstationConfigRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateWorkstationConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateWorkstationConfig(
      UpdateWorkstationConfigRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateWorkstationConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteWorkstationConfig(
      DeleteWorkstationConfigRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteWorkstationConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getWorkstation(
      GetWorkstationRequest request, StreamObserver<Workstation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Workstation) {
      requests.add(request);
      responseObserver.onNext(((Workstation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWorkstation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Workstation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWorkstations(
      ListWorkstationsRequest request, StreamObserver<ListWorkstationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWorkstationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWorkstationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWorkstations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWorkstationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listUsableWorkstations(
      ListUsableWorkstationsRequest request,
      StreamObserver<ListUsableWorkstationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListUsableWorkstationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUsableWorkstationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUsableWorkstations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListUsableWorkstationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createWorkstation(
      CreateWorkstationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateWorkstation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateWorkstation(
      UpdateWorkstationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateWorkstation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteWorkstation(
      DeleteWorkstationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteWorkstation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void startWorkstation(
      StartWorkstationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method StartWorkstation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void stopWorkstation(
      StopWorkstationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method StopWorkstation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateAccessToken(
      GenerateAccessTokenRequest request,
      StreamObserver<GenerateAccessTokenResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateAccessTokenResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateAccessTokenResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateAccessToken, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateAccessTokenResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
