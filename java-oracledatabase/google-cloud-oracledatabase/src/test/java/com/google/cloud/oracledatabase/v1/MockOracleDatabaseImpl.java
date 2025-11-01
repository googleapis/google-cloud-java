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
  public void listMinorVersions(
      ListMinorVersionsRequest request,
      StreamObserver<ListMinorVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMinorVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMinorVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMinorVersions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMinorVersionsResponse.class.getName(),
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
  public void updateAutonomousDatabase(
      UpdateAutonomousDatabaseRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateAutonomousDatabase, expected %s"
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

  @Override
  public void switchoverAutonomousDatabase(
      SwitchoverAutonomousDatabaseRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method SwitchoverAutonomousDatabase, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void failoverAutonomousDatabase(
      FailoverAutonomousDatabaseRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method FailoverAutonomousDatabase, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listOdbNetworks(
      ListOdbNetworksRequest request, StreamObserver<ListOdbNetworksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListOdbNetworksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListOdbNetworksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListOdbNetworks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListOdbNetworksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getOdbNetwork(
      GetOdbNetworkRequest request, StreamObserver<OdbNetwork> responseObserver) {
    Object response = responses.poll();
    if (response instanceof OdbNetwork) {
      requests.add(request);
      responseObserver.onNext(((OdbNetwork) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetOdbNetwork, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  OdbNetwork.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createOdbNetwork(
      CreateOdbNetworkRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateOdbNetwork, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteOdbNetwork(
      DeleteOdbNetworkRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteOdbNetwork, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listOdbSubnets(
      ListOdbSubnetsRequest request, StreamObserver<ListOdbSubnetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListOdbSubnetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListOdbSubnetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListOdbSubnets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListOdbSubnetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getOdbSubnet(
      GetOdbSubnetRequest request, StreamObserver<OdbSubnet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof OdbSubnet) {
      requests.add(request);
      responseObserver.onNext(((OdbSubnet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetOdbSubnet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  OdbSubnet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createOdbSubnet(
      CreateOdbSubnetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateOdbSubnet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteOdbSubnet(
      DeleteOdbSubnetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteOdbSubnet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listExadbVmClusters(
      ListExadbVmClustersRequest request,
      StreamObserver<ListExadbVmClustersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListExadbVmClustersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListExadbVmClustersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListExadbVmClusters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListExadbVmClustersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getExadbVmCluster(
      GetExadbVmClusterRequest request, StreamObserver<ExadbVmCluster> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExadbVmCluster) {
      requests.add(request);
      responseObserver.onNext(((ExadbVmCluster) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetExadbVmCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExadbVmCluster.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createExadbVmCluster(
      CreateExadbVmClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateExadbVmCluster, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteExadbVmCluster(
      DeleteExadbVmClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteExadbVmCluster, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateExadbVmCluster(
      UpdateExadbVmClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateExadbVmCluster, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeVirtualMachineExadbVmCluster(
      RemoveVirtualMachineExadbVmClusterRequest request,
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
                  "Unrecognized response type %s for method RemoveVirtualMachineExadbVmCluster,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listExascaleDbStorageVaults(
      ListExascaleDbStorageVaultsRequest request,
      StreamObserver<ListExascaleDbStorageVaultsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListExascaleDbStorageVaultsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListExascaleDbStorageVaultsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListExascaleDbStorageVaults, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListExascaleDbStorageVaultsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getExascaleDbStorageVault(
      GetExascaleDbStorageVaultRequest request,
      StreamObserver<ExascaleDbStorageVault> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExascaleDbStorageVault) {
      requests.add(request);
      responseObserver.onNext(((ExascaleDbStorageVault) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetExascaleDbStorageVault, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExascaleDbStorageVault.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createExascaleDbStorageVault(
      CreateExascaleDbStorageVaultRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateExascaleDbStorageVault, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteExascaleDbStorageVault(
      DeleteExascaleDbStorageVaultRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteExascaleDbStorageVault, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDbSystemInitialStorageSizes(
      ListDbSystemInitialStorageSizesRequest request,
      StreamObserver<ListDbSystemInitialStorageSizesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDbSystemInitialStorageSizesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDbSystemInitialStorageSizesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDbSystemInitialStorageSizes,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDbSystemInitialStorageSizesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDatabases(
      ListDatabasesRequest request, StreamObserver<ListDatabasesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDatabasesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDatabasesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDatabases, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDatabasesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDatabase(GetDatabaseRequest request, StreamObserver<Database> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Database) {
      requests.add(request);
      responseObserver.onNext(((Database) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDatabase, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Database.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPluggableDatabases(
      ListPluggableDatabasesRequest request,
      StreamObserver<ListPluggableDatabasesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPluggableDatabasesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPluggableDatabasesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPluggableDatabases, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPluggableDatabasesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPluggableDatabase(
      GetPluggableDatabaseRequest request, StreamObserver<PluggableDatabase> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PluggableDatabase) {
      requests.add(request);
      responseObserver.onNext(((PluggableDatabase) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPluggableDatabase, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  PluggableDatabase.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDbSystems(
      ListDbSystemsRequest request, StreamObserver<ListDbSystemsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDbSystemsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDbSystemsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDbSystems, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDbSystemsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDbSystem(GetDbSystemRequest request, StreamObserver<DbSystem> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DbSystem) {
      requests.add(request);
      responseObserver.onNext(((DbSystem) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDbSystem, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DbSystem.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDbSystem(
      CreateDbSystemRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateDbSystem, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDbSystem(
      DeleteDbSystemRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDbSystem, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDbVersions(
      ListDbVersionsRequest request, StreamObserver<ListDbVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDbVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDbVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDbVersions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDbVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDatabaseCharacterSets(
      ListDatabaseCharacterSetsRequest request,
      StreamObserver<ListDatabaseCharacterSetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDatabaseCharacterSetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDatabaseCharacterSetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDatabaseCharacterSets, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDatabaseCharacterSetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
