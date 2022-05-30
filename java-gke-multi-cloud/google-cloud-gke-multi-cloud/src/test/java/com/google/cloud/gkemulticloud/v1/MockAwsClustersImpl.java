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
import com.google.cloud.gkemulticloud.v1.AwsClustersGrpc.AwsClustersImplBase;
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
public class MockAwsClustersImpl extends AwsClustersImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAwsClustersImpl() {
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
  public void createAwsCluster(
      CreateAwsClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateAwsCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAwsCluster(
      UpdateAwsClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateAwsCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAwsCluster(
      GetAwsClusterRequest request, StreamObserver<AwsCluster> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AwsCluster) {
      requests.add(request);
      responseObserver.onNext(((AwsCluster) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAwsCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AwsCluster.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAwsClusters(
      ListAwsClustersRequest request, StreamObserver<ListAwsClustersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAwsClustersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAwsClustersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAwsClusters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAwsClustersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAwsCluster(
      DeleteAwsClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAwsCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateAwsAccessToken(
      GenerateAwsAccessTokenRequest request,
      StreamObserver<GenerateAwsAccessTokenResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateAwsAccessTokenResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateAwsAccessTokenResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateAwsAccessToken, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateAwsAccessTokenResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAwsNodePool(
      CreateAwsNodePoolRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateAwsNodePool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAwsNodePool(
      UpdateAwsNodePoolRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateAwsNodePool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAwsNodePool(
      GetAwsNodePoolRequest request, StreamObserver<AwsNodePool> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AwsNodePool) {
      requests.add(request);
      responseObserver.onNext(((AwsNodePool) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAwsNodePool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AwsNodePool.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAwsNodePools(
      ListAwsNodePoolsRequest request, StreamObserver<ListAwsNodePoolsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAwsNodePoolsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAwsNodePoolsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAwsNodePools, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAwsNodePoolsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAwsNodePool(
      DeleteAwsNodePoolRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAwsNodePool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAwsServerConfig(
      GetAwsServerConfigRequest request, StreamObserver<AwsServerConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AwsServerConfig) {
      requests.add(request);
      responseObserver.onNext(((AwsServerConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAwsServerConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AwsServerConfig.class.getName(),
                  Exception.class.getName())));
    }
  }
}
