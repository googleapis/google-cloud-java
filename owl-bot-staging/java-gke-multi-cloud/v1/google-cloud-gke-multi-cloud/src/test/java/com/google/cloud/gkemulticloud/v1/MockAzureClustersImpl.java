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

package com.google.cloud.gkemulticloud.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.gkemulticloud.v1.AzureClustersGrpc.AzureClustersImplBase;
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
public class MockAzureClustersImpl extends AzureClustersImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAzureClustersImpl() {
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
  public void createAzureClient(
      CreateAzureClientRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateAzureClient, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAzureClient(
      GetAzureClientRequest request, StreamObserver<AzureClient> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AzureClient) {
      requests.add(request);
      responseObserver.onNext(((AzureClient) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAzureClient, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AzureClient.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAzureClients(
      ListAzureClientsRequest request, StreamObserver<ListAzureClientsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAzureClientsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAzureClientsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAzureClients, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAzureClientsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAzureClient(
      DeleteAzureClientRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAzureClient, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAzureCluster(
      CreateAzureClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateAzureCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAzureCluster(
      UpdateAzureClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateAzureCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAzureCluster(
      GetAzureClusterRequest request, StreamObserver<AzureCluster> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AzureCluster) {
      requests.add(request);
      responseObserver.onNext(((AzureCluster) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAzureCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AzureCluster.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAzureClusters(
      ListAzureClustersRequest request,
      StreamObserver<ListAzureClustersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAzureClustersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAzureClustersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAzureClusters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAzureClustersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAzureCluster(
      DeleteAzureClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAzureCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateAzureAccessToken(
      GenerateAzureAccessTokenRequest request,
      StreamObserver<GenerateAzureAccessTokenResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateAzureAccessTokenResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateAzureAccessTokenResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateAzureAccessToken, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateAzureAccessTokenResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAzureNodePool(
      CreateAzureNodePoolRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateAzureNodePool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAzureNodePool(
      UpdateAzureNodePoolRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateAzureNodePool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAzureNodePool(
      GetAzureNodePoolRequest request, StreamObserver<AzureNodePool> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AzureNodePool) {
      requests.add(request);
      responseObserver.onNext(((AzureNodePool) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAzureNodePool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AzureNodePool.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAzureNodePools(
      ListAzureNodePoolsRequest request,
      StreamObserver<ListAzureNodePoolsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAzureNodePoolsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAzureNodePoolsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAzureNodePools, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAzureNodePoolsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAzureNodePool(
      DeleteAzureNodePoolRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAzureNodePool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAzureServerConfig(
      GetAzureServerConfigRequest request, StreamObserver<AzureServerConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AzureServerConfig) {
      requests.add(request);
      responseObserver.onNext(((AzureServerConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAzureServerConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AzureServerConfig.class.getName(),
                  Exception.class.getName())));
    }
  }
}
