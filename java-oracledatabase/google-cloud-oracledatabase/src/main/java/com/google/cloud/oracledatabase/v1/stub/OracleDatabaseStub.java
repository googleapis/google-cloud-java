/*
 * Copyright 2026 Google LLC
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
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDatabaseCharacterSetsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDatabasesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbNodesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbServersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemInitialStorageSizesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemShapesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListEntitlementsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListExadbVmClustersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListExascaleDbStorageVaultsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListGiVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListLocationsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListMinorVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListOdbNetworksPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListOdbSubnetsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListPluggableDatabasesPagedResponse;

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
import com.google.cloud.oracledatabase.v1.CreateDbSystemRequest;
import com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest;
import com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest;
import com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest;
import com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest;
import com.google.cloud.oracledatabase.v1.Database;
import com.google.cloud.oracledatabase.v1.DbSystem;
import com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest;
import com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest;
import com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest;
import com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest;
import com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest;
import com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest;
import com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest;
import com.google.cloud.oracledatabase.v1.ExadbVmCluster;
import com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault;
import com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest;
import com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse;
import com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest;
import com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest;
import com.google.cloud.oracledatabase.v1.GetDatabaseRequest;
import com.google.cloud.oracledatabase.v1.GetDbSystemRequest;
import com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest;
import com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest;
import com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest;
import com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest;
import com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest;
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
import com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest;
import com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse;
import com.google.cloud.oracledatabase.v1.ListDatabasesRequest;
import com.google.cloud.oracledatabase.v1.ListDatabasesResponse;
import com.google.cloud.oracledatabase.v1.ListDbNodesRequest;
import com.google.cloud.oracledatabase.v1.ListDbNodesResponse;
import com.google.cloud.oracledatabase.v1.ListDbServersRequest;
import com.google.cloud.oracledatabase.v1.ListDbServersResponse;
import com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesRequest;
import com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesResponse;
import com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest;
import com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse;
import com.google.cloud.oracledatabase.v1.ListDbSystemsRequest;
import com.google.cloud.oracledatabase.v1.ListDbSystemsResponse;
import com.google.cloud.oracledatabase.v1.ListDbVersionsRequest;
import com.google.cloud.oracledatabase.v1.ListDbVersionsResponse;
import com.google.cloud.oracledatabase.v1.ListEntitlementsRequest;
import com.google.cloud.oracledatabase.v1.ListEntitlementsResponse;
import com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest;
import com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse;
import com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest;
import com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse;
import com.google.cloud.oracledatabase.v1.ListGiVersionsRequest;
import com.google.cloud.oracledatabase.v1.ListGiVersionsResponse;
import com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest;
import com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse;
import com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest;
import com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse;
import com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest;
import com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse;
import com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest;
import com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse;
import com.google.cloud.oracledatabase.v1.OdbNetwork;
import com.google.cloud.oracledatabase.v1.OdbSubnet;
import com.google.cloud.oracledatabase.v1.OperationMetadata;
import com.google.cloud.oracledatabase.v1.PluggableDatabase;
import com.google.cloud.oracledatabase.v1.RemoveVirtualMachineExadbVmClusterRequest;
import com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest;
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

  public UnaryCallable<ListMinorVersionsRequest, ListMinorVersionsPagedResponse>
      listMinorVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMinorVersionsPagedCallable()");
  }

  public UnaryCallable<ListMinorVersionsRequest, ListMinorVersionsResponse>
      listMinorVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMinorVersionsCallable()");
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

  public OperationCallable<UpdateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      updateAutonomousDatabaseOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAutonomousDatabaseOperationCallable()");
  }

  public UnaryCallable<UpdateAutonomousDatabaseRequest, Operation>
      updateAutonomousDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAutonomousDatabaseCallable()");
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

  public OperationCallable<
          SwitchoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      switchoverAutonomousDatabaseOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: switchoverAutonomousDatabaseOperationCallable()");
  }

  public UnaryCallable<SwitchoverAutonomousDatabaseRequest, Operation>
      switchoverAutonomousDatabaseCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: switchoverAutonomousDatabaseCallable()");
  }

  public OperationCallable<FailoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      failoverAutonomousDatabaseOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: failoverAutonomousDatabaseOperationCallable()");
  }

  public UnaryCallable<FailoverAutonomousDatabaseRequest, Operation>
      failoverAutonomousDatabaseCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: failoverAutonomousDatabaseCallable()");
  }

  public UnaryCallable<ListOdbNetworksRequest, ListOdbNetworksPagedResponse>
      listOdbNetworksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listOdbNetworksPagedCallable()");
  }

  public UnaryCallable<ListOdbNetworksRequest, ListOdbNetworksResponse> listOdbNetworksCallable() {
    throw new UnsupportedOperationException("Not implemented: listOdbNetworksCallable()");
  }

  public UnaryCallable<GetOdbNetworkRequest, OdbNetwork> getOdbNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: getOdbNetworkCallable()");
  }

  public OperationCallable<CreateOdbNetworkRequest, OdbNetwork, OperationMetadata>
      createOdbNetworkOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createOdbNetworkOperationCallable()");
  }

  public UnaryCallable<CreateOdbNetworkRequest, Operation> createOdbNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: createOdbNetworkCallable()");
  }

  public OperationCallable<DeleteOdbNetworkRequest, Empty, OperationMetadata>
      deleteOdbNetworkOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOdbNetworkOperationCallable()");
  }

  public UnaryCallable<DeleteOdbNetworkRequest, Operation> deleteOdbNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOdbNetworkCallable()");
  }

  public UnaryCallable<ListOdbSubnetsRequest, ListOdbSubnetsPagedResponse>
      listOdbSubnetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listOdbSubnetsPagedCallable()");
  }

  public UnaryCallable<ListOdbSubnetsRequest, ListOdbSubnetsResponse> listOdbSubnetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listOdbSubnetsCallable()");
  }

  public UnaryCallable<GetOdbSubnetRequest, OdbSubnet> getOdbSubnetCallable() {
    throw new UnsupportedOperationException("Not implemented: getOdbSubnetCallable()");
  }

  public OperationCallable<CreateOdbSubnetRequest, OdbSubnet, OperationMetadata>
      createOdbSubnetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createOdbSubnetOperationCallable()");
  }

  public UnaryCallable<CreateOdbSubnetRequest, Operation> createOdbSubnetCallable() {
    throw new UnsupportedOperationException("Not implemented: createOdbSubnetCallable()");
  }

  public OperationCallable<DeleteOdbSubnetRequest, Empty, OperationMetadata>
      deleteOdbSubnetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOdbSubnetOperationCallable()");
  }

  public UnaryCallable<DeleteOdbSubnetRequest, Operation> deleteOdbSubnetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOdbSubnetCallable()");
  }

  public UnaryCallable<ListExadbVmClustersRequest, ListExadbVmClustersPagedResponse>
      listExadbVmClustersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listExadbVmClustersPagedCallable()");
  }

  public UnaryCallable<ListExadbVmClustersRequest, ListExadbVmClustersResponse>
      listExadbVmClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listExadbVmClustersCallable()");
  }

  public UnaryCallable<GetExadbVmClusterRequest, ExadbVmCluster> getExadbVmClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getExadbVmClusterCallable()");
  }

  public OperationCallable<CreateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      createExadbVmClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createExadbVmClusterOperationCallable()");
  }

  public UnaryCallable<CreateExadbVmClusterRequest, Operation> createExadbVmClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createExadbVmClusterCallable()");
  }

  public OperationCallable<DeleteExadbVmClusterRequest, Empty, OperationMetadata>
      deleteExadbVmClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteExadbVmClusterOperationCallable()");
  }

  public UnaryCallable<DeleteExadbVmClusterRequest, Operation> deleteExadbVmClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExadbVmClusterCallable()");
  }

  public OperationCallable<UpdateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      updateExadbVmClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateExadbVmClusterOperationCallable()");
  }

  public UnaryCallable<UpdateExadbVmClusterRequest, Operation> updateExadbVmClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateExadbVmClusterCallable()");
  }

  public OperationCallable<
          RemoveVirtualMachineExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      removeVirtualMachineExadbVmClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeVirtualMachineExadbVmClusterOperationCallable()");
  }

  public UnaryCallable<RemoveVirtualMachineExadbVmClusterRequest, Operation>
      removeVirtualMachineExadbVmClusterCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeVirtualMachineExadbVmClusterCallable()");
  }

  public UnaryCallable<ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsPagedResponse>
      listExascaleDbStorageVaultsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listExascaleDbStorageVaultsPagedCallable()");
  }

  public UnaryCallable<ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsResponse>
      listExascaleDbStorageVaultsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listExascaleDbStorageVaultsCallable()");
  }

  public UnaryCallable<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
      getExascaleDbStorageVaultCallable() {
    throw new UnsupportedOperationException("Not implemented: getExascaleDbStorageVaultCallable()");
  }

  public OperationCallable<
          CreateExascaleDbStorageVaultRequest, ExascaleDbStorageVault, OperationMetadata>
      createExascaleDbStorageVaultOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createExascaleDbStorageVaultOperationCallable()");
  }

  public UnaryCallable<CreateExascaleDbStorageVaultRequest, Operation>
      createExascaleDbStorageVaultCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createExascaleDbStorageVaultCallable()");
  }

  public OperationCallable<DeleteExascaleDbStorageVaultRequest, Empty, OperationMetadata>
      deleteExascaleDbStorageVaultOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteExascaleDbStorageVaultOperationCallable()");
  }

  public UnaryCallable<DeleteExascaleDbStorageVaultRequest, Operation>
      deleteExascaleDbStorageVaultCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteExascaleDbStorageVaultCallable()");
  }

  public UnaryCallable<
          ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesPagedResponse>
      listDbSystemInitialStorageSizesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDbSystemInitialStorageSizesPagedCallable()");
  }

  public UnaryCallable<
          ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesResponse>
      listDbSystemInitialStorageSizesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDbSystemInitialStorageSizesCallable()");
  }

  public UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatabasesPagedCallable()");
  }

  public UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatabasesCallable()");
  }

  public UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: getDatabaseCallable()");
  }

  public UnaryCallable<ListPluggableDatabasesRequest, ListPluggableDatabasesPagedResponse>
      listPluggableDatabasesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPluggableDatabasesPagedCallable()");
  }

  public UnaryCallable<ListPluggableDatabasesRequest, ListPluggableDatabasesResponse>
      listPluggableDatabasesCallable() {
    throw new UnsupportedOperationException("Not implemented: listPluggableDatabasesCallable()");
  }

  public UnaryCallable<GetPluggableDatabaseRequest, PluggableDatabase>
      getPluggableDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: getPluggableDatabaseCallable()");
  }

  public UnaryCallable<ListDbSystemsRequest, ListDbSystemsPagedResponse>
      listDbSystemsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDbSystemsPagedCallable()");
  }

  public UnaryCallable<ListDbSystemsRequest, ListDbSystemsResponse> listDbSystemsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDbSystemsCallable()");
  }

  public UnaryCallable<GetDbSystemRequest, DbSystem> getDbSystemCallable() {
    throw new UnsupportedOperationException("Not implemented: getDbSystemCallable()");
  }

  public OperationCallable<CreateDbSystemRequest, DbSystem, OperationMetadata>
      createDbSystemOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createDbSystemOperationCallable()");
  }

  public UnaryCallable<CreateDbSystemRequest, Operation> createDbSystemCallable() {
    throw new UnsupportedOperationException("Not implemented: createDbSystemCallable()");
  }

  public OperationCallable<DeleteDbSystemRequest, Empty, OperationMetadata>
      deleteDbSystemOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDbSystemOperationCallable()");
  }

  public UnaryCallable<DeleteDbSystemRequest, Operation> deleteDbSystemCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDbSystemCallable()");
  }

  public UnaryCallable<ListDbVersionsRequest, ListDbVersionsPagedResponse>
      listDbVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDbVersionsPagedCallable()");
  }

  public UnaryCallable<ListDbVersionsRequest, ListDbVersionsResponse> listDbVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDbVersionsCallable()");
  }

  public UnaryCallable<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsPagedResponse>
      listDatabaseCharacterSetsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDatabaseCharacterSetsPagedCallable()");
  }

  public UnaryCallable<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse>
      listDatabaseCharacterSetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatabaseCharacterSetsCallable()");
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
