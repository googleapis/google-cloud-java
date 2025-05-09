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

package com.google.cloud.oracledatabase.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.oracledatabase.v1.OracleDatabaseGrpc.OracleDatabaseImplBase;
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
public class MockOracleDatabaseImpl extends OracleDatabaseImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockOracleDatabaseImpl() {
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
  public void listCloudExadataInfrastructures(
      ListCloudExadataInfrastructuresRequest request,
      StreamObserver<ListCloudExadataInfrastructuresResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCloudExadataInfrastructuresResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCloudExadataInfrastructuresResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCloudExadataInfrastructures,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCloudExadataInfrastructuresResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCloudExadataInfrastructure(
      GetCloudExadataInfrastructureRequest request,
      StreamObserver<CloudExadataInfrastructure> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CloudExadataInfrastructure) {
      requests.add(request);
      responseObserver.onNext(((CloudExadataInfrastructure) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCloudExadataInfrastructure, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CloudExadataInfrastructure.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCloudExadataInfrastructure(
      CreateCloudExadataInfrastructureRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateCloudExadataInfrastructure,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCloudExadataInfrastructure(
      DeleteCloudExadataInfrastructureRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCloudExadataInfrastructure,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCloudVmClusters(
      ListCloudVmClustersRequest request,
      StreamObserver<ListCloudVmClustersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCloudVmClustersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCloudVmClustersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCloudVmClusters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCloudVmClustersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCloudVmCluster(
      GetCloudVmClusterRequest request, StreamObserver<CloudVmCluster> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CloudVmCluster) {
      requests.add(request);
      responseObserver.onNext(((CloudVmCluster) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCloudVmCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CloudVmCluster.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCloudVmCluster(
      CreateCloudVmClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateCloudVmCluster, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCloudVmCluster(
      DeleteCloudVmClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCloudVmCluster, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEntitlements(
      ListEntitlementsRequest request, StreamObserver<ListEntitlementsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEntitlementsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEntitlementsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEntitlements, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEntitlementsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDbServers(
      ListDbServersRequest request, StreamObserver<ListDbServersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDbServersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDbServersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDbServers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDbServersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDbNodes(
      ListDbNodesRequest request, StreamObserver<ListDbNodesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDbNodesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDbNodesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDbNodes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDbNodesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGiVersions(
      ListGiVersionsRequest request, StreamObserver<ListGiVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGiVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGiVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGiVersions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGiVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDbSystemShapes(
      ListDbSystemShapesRequest request,
      StreamObserver<ListDbSystemShapesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDbSystemShapesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDbSystemShapesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDbSystemShapes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDbSystemShapesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAutonomousDatabases(
      ListAutonomousDatabasesRequest request,
      StreamObserver<ListAutonomousDatabasesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAutonomousDatabasesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAutonomousDatabasesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAutonomousDatabases, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAutonomousDatabasesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAutonomousDatabase(
      GetAutonomousDatabaseRequest request, StreamObserver<AutonomousDatabase> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AutonomousDatabase) {
      requests.add(request);
      responseObserver.onNext(((AutonomousDatabase) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAutonomousDatabase, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  AutonomousDatabase.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAutonomousDatabase(
      CreateAutonomousDatabaseRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateAutonomousDatabase, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAutonomousDatabase(
      DeleteAutonomousDatabaseRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAutonomousDatabase, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void restoreAutonomousDatabase(
      RestoreAutonomousDatabaseRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RestoreAutonomousDatabase, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateAutonomousDatabaseWallet(
      GenerateAutonomousDatabaseWalletRequest request,
      StreamObserver<GenerateAutonomousDatabaseWalletResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateAutonomousDatabaseWalletResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateAutonomousDatabaseWalletResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateAutonomousDatabaseWallet,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateAutonomousDatabaseWalletResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAutonomousDbVersions(
      ListAutonomousDbVersionsRequest request,
      StreamObserver<ListAutonomousDbVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAutonomousDbVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAutonomousDbVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAutonomousDbVersions, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAutonomousDbVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAutonomousDatabaseCharacterSets(
      ListAutonomousDatabaseCharacterSetsRequest request,
      StreamObserver<ListAutonomousDatabaseCharacterSetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAutonomousDatabaseCharacterSetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAutonomousDatabaseCharacterSetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAutonomousDatabaseCharacterSets,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAutonomousDatabaseCharacterSetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAutonomousDatabaseBackups(
      ListAutonomousDatabaseBackupsRequest request,
      StreamObserver<ListAutonomousDatabaseBackupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAutonomousDatabaseBackupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAutonomousDatabaseBackupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAutonomousDatabaseBackups, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAutonomousDatabaseBackupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void stopAutonomousDatabase(
      StopAutonomousDatabaseRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method StopAutonomousDatabase, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void startAutonomousDatabase(
      StartAutonomousDatabaseRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method StartAutonomousDatabase, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void restartAutonomousDatabase(
      RestartAutonomousDatabaseRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RestartAutonomousDatabase, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
