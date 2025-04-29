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

package com.google.cloud.managedkafka.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.managedkafka.v1.ManagedKafkaConnectGrpc.ManagedKafkaConnectImplBase;
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
public class MockManagedKafkaConnectImpl extends ManagedKafkaConnectImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockManagedKafkaConnectImpl() {
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
  public void listConnectClusters(
      ListConnectClustersRequest request,
      StreamObserver<ListConnectClustersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConnectClustersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConnectClustersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConnectClusters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConnectClustersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConnectCluster(
      GetConnectClusterRequest request, StreamObserver<ConnectCluster> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConnectCluster) {
      requests.add(request);
      responseObserver.onNext(((ConnectCluster) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConnectCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConnectCluster.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createConnectCluster(
      CreateConnectClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateConnectCluster, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateConnectCluster(
      UpdateConnectClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateConnectCluster, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteConnectCluster(
      DeleteConnectClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteConnectCluster, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listConnectors(
      ListConnectorsRequest request, StreamObserver<ListConnectorsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConnectorsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConnectorsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConnectors, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConnectorsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConnector(
      GetConnectorRequest request, StreamObserver<Connector> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Connector) {
      requests.add(request);
      responseObserver.onNext(((Connector) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConnector, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Connector.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createConnector(
      CreateConnectorRequest request, StreamObserver<Connector> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Connector) {
      requests.add(request);
      responseObserver.onNext(((Connector) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateConnector, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Connector.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateConnector(
      UpdateConnectorRequest request, StreamObserver<Connector> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Connector) {
      requests.add(request);
      responseObserver.onNext(((Connector) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateConnector, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Connector.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteConnector(
      DeleteConnectorRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteConnector, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void pauseConnector(
      PauseConnectorRequest request, StreamObserver<PauseConnectorResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PauseConnectorResponse) {
      requests.add(request);
      responseObserver.onNext(((PauseConnectorResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method PauseConnector, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PauseConnectorResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void resumeConnector(
      ResumeConnectorRequest request, StreamObserver<ResumeConnectorResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ResumeConnectorResponse) {
      requests.add(request);
      responseObserver.onNext(((ResumeConnectorResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ResumeConnector, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ResumeConnectorResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void restartConnector(
      RestartConnectorRequest request, StreamObserver<RestartConnectorResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RestartConnectorResponse) {
      requests.add(request);
      responseObserver.onNext(((RestartConnectorResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RestartConnector, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RestartConnectorResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void stopConnector(
      StopConnectorRequest request, StreamObserver<StopConnectorResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StopConnectorResponse) {
      requests.add(request);
      responseObserver.onNext(((StopConnectorResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method StopConnector, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StopConnectorResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
