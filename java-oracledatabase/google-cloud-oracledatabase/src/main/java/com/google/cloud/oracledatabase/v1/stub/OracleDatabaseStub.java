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

package com.google.cloud.oracledatabase.v1.stub;

import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDatabaseBackupsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDatabaseCharacterSetsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDatabasesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDbVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListCloudExadataInfrastructuresPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListCloudVmClustersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbNodesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbServersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemShapesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListEntitlementsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListGiVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.oracledatabase.v1.AutonomousDatabase;
import com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure;
import com.google.cloud.oracledatabase.v1.CloudVmCluster;
import com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest;
import com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest;
import com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest;
import com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest;
import com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest;
import com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse;
import com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest;
import com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsResponse;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsRequest;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsResponse;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse;
import com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest;
import com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse;
import com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest;
import com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresResponse;
import com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest;
import com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse;
import com.google.cloud.oracledatabase.v1.ListDbNodesRequest;
import com.google.cloud.oracledatabase.v1.ListDbNodesResponse;
import com.google.cloud.oracledatabase.v1.ListDbServersRequest;
import com.google.cloud.oracledatabase.v1.ListDbServersResponse;
import com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest;
import com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse;
import com.google.cloud.oracledatabase.v1.ListEntitlementsRequest;
import com.google.cloud.oracledatabase.v1.ListEntitlementsResponse;
import com.google.cloud.oracledatabase.v1.ListGiVersionsRequest;
import com.google.cloud.oracledatabase.v1.ListGiVersionsResponse;
import com.google.cloud.oracledatabase.v1.OperationMetadata;
import com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the OracleDatabase service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class OracleDatabaseStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<
          ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresPagedResponse>
      listCloudExadataInfrastructuresPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCloudExadataInfrastructuresPagedCallable()");
  }

  public UnaryCallable<
          ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresResponse>
      listCloudExadataInfrastructuresCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCloudExadataInfrastructuresCallable()");
  }

  public UnaryCallable<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
      getCloudExadataInfrastructureCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getCloudExadataInfrastructureCallable()");
  }

  public OperationCallable<
          CreateCloudExadataInfrastructureRequest, CloudExadataInfrastructure, OperationMetadata>
      createCloudExadataInfrastructureOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createCloudExadataInfrastructureOperationCallable()");
  }

  public UnaryCallable<CreateCloudExadataInfrastructureRequest, Operation>
      createCloudExadataInfrastructureCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createCloudExadataInfrastructureCallable()");
  }

  public OperationCallable<DeleteCloudExadataInfrastructureRequest, Empty, OperationMetadata>
      deleteCloudExadataInfrastructureOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteCloudExadataInfrastructureOperationCallable()");
  }

  public UnaryCallable<DeleteCloudExadataInfrastructureRequest, Operation>
      deleteCloudExadataInfrastructureCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteCloudExadataInfrastructureCallable()");
  }

  public UnaryCallable<ListCloudVmClustersRequest, ListCloudVmClustersPagedResponse>
      listCloudVmClustersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCloudVmClustersPagedCallable()");
  }

  public UnaryCallable<ListCloudVmClustersRequest, ListCloudVmClustersResponse>
      listCloudVmClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listCloudVmClustersCallable()");
  }

  public UnaryCallable<GetCloudVmClusterRequest, CloudVmCluster> getCloudVmClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getCloudVmClusterCallable()");
  }

  public OperationCallable<CreateCloudVmClusterRequest, CloudVmCluster, OperationMetadata>
      createCloudVmClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createCloudVmClusterOperationCallable()");
  }

  public UnaryCallable<CreateCloudVmClusterRequest, Operation> createCloudVmClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createCloudVmClusterCallable()");
  }

  public OperationCallable<DeleteCloudVmClusterRequest, Empty, OperationMetadata>
      deleteCloudVmClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteCloudVmClusterOperationCallable()");
  }

  public UnaryCallable<DeleteCloudVmClusterRequest, Operation> deleteCloudVmClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCloudVmClusterCallable()");
  }

  public UnaryCallable<ListEntitlementsRequest, ListEntitlementsPagedResponse>
      listEntitlementsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntitlementsPagedCallable()");
  }

  public UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntitlementsCallable()");
  }

  public UnaryCallable<ListDbServersRequest, ListDbServersPagedResponse>
      listDbServersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDbServersPagedCallable()");
  }

  public UnaryCallable<ListDbServersRequest, ListDbServersResponse> listDbServersCallable() {
    throw new UnsupportedOperationException("Not implemented: listDbServersCallable()");
  }

  public UnaryCallable<ListDbNodesRequest, ListDbNodesPagedResponse> listDbNodesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDbNodesPagedCallable()");
  }

  public UnaryCallable<ListDbNodesRequest, ListDbNodesResponse> listDbNodesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDbNodesCallable()");
  }

  public UnaryCallable<ListGiVersionsRequest, ListGiVersionsPagedResponse>
      listGiVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGiVersionsPagedCallable()");
  }

  public UnaryCallable<ListGiVersionsRequest, ListGiVersionsResponse> listGiVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listGiVersionsCallable()");
  }

  public UnaryCallable<ListDbSystemShapesRequest, ListDbSystemShapesPagedResponse>
      listDbSystemShapesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDbSystemShapesPagedCallable()");
  }

  public UnaryCallable<ListDbSystemShapesRequest, ListDbSystemShapesResponse>
      listDbSystemShapesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDbSystemShapesCallable()");
  }

  public UnaryCallable<ListAutonomousDatabasesRequest, ListAutonomousDatabasesPagedResponse>
      listAutonomousDatabasesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAutonomousDatabasesPagedCallable()");
  }

  public UnaryCallable<ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse>
      listAutonomousDatabasesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAutonomousDatabasesCallable()");
  }

  public UnaryCallable<GetAutonomousDatabaseRequest, AutonomousDatabase>
      getAutonomousDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: getAutonomousDatabaseCallable()");
  }

  public OperationCallable<CreateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      createAutonomousDatabaseOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAutonomousDatabaseOperationCallable()");
  }

  public UnaryCallable<CreateAutonomousDatabaseRequest, Operation>
      createAutonomousDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: createAutonomousDatabaseCallable()");
  }

  public OperationCallable<DeleteAutonomousDatabaseRequest, Empty, OperationMetadata>
      deleteAutonomousDatabaseOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAutonomousDatabaseOperationCallable()");
  }

  public UnaryCallable<DeleteAutonomousDatabaseRequest, Operation>
      deleteAutonomousDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAutonomousDatabaseCallable()");
  }

  public OperationCallable<RestoreAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restoreAutonomousDatabaseOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: restoreAutonomousDatabaseOperationCallable()");
  }

  public UnaryCallable<RestoreAutonomousDatabaseRequest, Operation>
      restoreAutonomousDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreAutonomousDatabaseCallable()");
  }

  public UnaryCallable<
          GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
      generateAutonomousDatabaseWalletCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateAutonomousDatabaseWalletCallable()");
  }

  public UnaryCallable<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsPagedResponse>
      listAutonomousDbVersionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAutonomousDbVersionsPagedCallable()");
  }

  public UnaryCallable<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse>
      listAutonomousDbVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAutonomousDbVersionsCallable()");
  }

  public UnaryCallable<
          ListAutonomousDatabaseCharacterSetsRequest,
          ListAutonomousDatabaseCharacterSetsPagedResponse>
      listAutonomousDatabaseCharacterSetsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAutonomousDatabaseCharacterSetsPagedCallable()");
  }

  public UnaryCallable<
          ListAutonomousDatabaseCharacterSetsRequest, ListAutonomousDatabaseCharacterSetsResponse>
      listAutonomousDatabaseCharacterSetsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAutonomousDatabaseCharacterSetsCallable()");
  }

  public UnaryCallable<
          ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsPagedResponse>
      listAutonomousDatabaseBackupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAutonomousDatabaseBackupsPagedCallable()");
  }

  public UnaryCallable<ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsResponse>
      listAutonomousDatabaseBackupsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAutonomousDatabaseBackupsCallable()");
  }

  public OperationCallable<StopAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      stopAutonomousDatabaseOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: stopAutonomousDatabaseOperationCallable()");
  }

  public UnaryCallable<StopAutonomousDatabaseRequest, Operation> stopAutonomousDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: stopAutonomousDatabaseCallable()");
  }

  public OperationCallable<StartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      startAutonomousDatabaseOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: startAutonomousDatabaseOperationCallable()");
  }

  public UnaryCallable<StartAutonomousDatabaseRequest, Operation>
      startAutonomousDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: startAutonomousDatabaseCallable()");
  }

  public OperationCallable<RestartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restartAutonomousDatabaseOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: restartAutonomousDatabaseOperationCallable()");
  }

  public UnaryCallable<RestartAutonomousDatabaseRequest, Operation>
      restartAutonomousDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: restartAutonomousDatabaseCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
