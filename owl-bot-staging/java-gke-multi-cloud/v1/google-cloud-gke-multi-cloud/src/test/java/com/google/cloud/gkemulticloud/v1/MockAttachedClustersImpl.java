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
import com.google.cloud.gkemulticloud.v1.AttachedClustersGrpc.AttachedClustersImplBase;
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
public class MockAttachedClustersImpl extends AttachedClustersImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAttachedClustersImpl() {
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
  public void createAttachedCluster(
      CreateAttachedClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateAttachedCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAttachedCluster(
      UpdateAttachedClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateAttachedCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importAttachedCluster(
      ImportAttachedClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ImportAttachedCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAttachedCluster(
      GetAttachedClusterRequest request, StreamObserver<AttachedCluster> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AttachedCluster) {
      requests.add(request);
      responseObserver.onNext(((AttachedCluster) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAttachedCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AttachedCluster.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAttachedClusters(
      ListAttachedClustersRequest request,
      StreamObserver<ListAttachedClustersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAttachedClustersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAttachedClustersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAttachedClusters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAttachedClustersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAttachedCluster(
      DeleteAttachedClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAttachedCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAttachedServerConfig(
      GetAttachedServerConfigRequest request,
      StreamObserver<AttachedServerConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AttachedServerConfig) {
      requests.add(request);
      responseObserver.onNext(((AttachedServerConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAttachedServerConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AttachedServerConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateAttachedClusterInstallManifest(
      GenerateAttachedClusterInstallManifestRequest request,
      StreamObserver<GenerateAttachedClusterInstallManifestResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateAttachedClusterInstallManifestResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateAttachedClusterInstallManifestResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateAttachedClusterInstallManifest, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateAttachedClusterInstallManifestResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
