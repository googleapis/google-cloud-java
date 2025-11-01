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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the OracleDatabase service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcOracleDatabaseStub extends OracleDatabaseStub {
  private static final MethodDescriptor<
          ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresResponse>
      listCloudExadataInfrastructuresMethodDescriptor =
          MethodDescriptor
              .<ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListCloudExadataInfrastructures")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListCloudExadataInfrastructuresRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListCloudExadataInfrastructuresResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
      getCloudExadataInfrastructureMethodDescriptor =
          MethodDescriptor
              .<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/GetCloudExadataInfrastructure")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCloudExadataInfrastructureRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CloudExadataInfrastructure.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateCloudExadataInfrastructureRequest, Operation>
      createCloudExadataInfrastructureMethodDescriptor =
          MethodDescriptor.<CreateCloudExadataInfrastructureRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/CreateCloudExadataInfrastructure")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateCloudExadataInfrastructureRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteCloudExadataInfrastructureRequest, Operation>
      deleteCloudExadataInfrastructureMethodDescriptor =
          MethodDescriptor.<DeleteCloudExadataInfrastructureRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/DeleteCloudExadataInfrastructure")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteCloudExadataInfrastructureRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListCloudVmClustersRequest, ListCloudVmClustersResponse>
      listCloudVmClustersMethodDescriptor =
          MethodDescriptor.<ListCloudVmClustersRequest, ListCloudVmClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListCloudVmClusters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCloudVmClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCloudVmClustersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetCloudVmClusterRequest, CloudVmCluster>
      getCloudVmClusterMethodDescriptor =
          MethodDescriptor.<GetCloudVmClusterRequest, CloudVmCluster>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/GetCloudVmCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCloudVmClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CloudVmCluster.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateCloudVmClusterRequest, Operation>
      createCloudVmClusterMethodDescriptor =
          MethodDescriptor.<CreateCloudVmClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/CreateCloudVmCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCloudVmClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteCloudVmClusterRequest, Operation>
      deleteCloudVmClusterMethodDescriptor =
          MethodDescriptor.<DeleteCloudVmClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/DeleteCloudVmCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCloudVmClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsMethodDescriptor =
          MethodDescriptor.<ListEntitlementsRequest, ListEntitlementsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListEntitlements")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEntitlementsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEntitlementsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDbServersRequest, ListDbServersResponse>
      listDbServersMethodDescriptor =
          MethodDescriptor.<ListDbServersRequest, ListDbServersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListDbServers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDbServersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDbServersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDbNodesRequest, ListDbNodesResponse>
      listDbNodesMethodDescriptor =
          MethodDescriptor.<ListDbNodesRequest, ListDbNodesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListDbNodes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListDbNodesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDbNodesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListGiVersionsRequest, ListGiVersionsResponse>
      listGiVersionsMethodDescriptor =
          MethodDescriptor.<ListGiVersionsRequest, ListGiVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListGiVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGiVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGiVersionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListMinorVersionsRequest, ListMinorVersionsResponse>
      listMinorVersionsMethodDescriptor =
          MethodDescriptor.<ListMinorVersionsRequest, ListMinorVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListMinorVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMinorVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMinorVersionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDbSystemShapesRequest, ListDbSystemShapesResponse>
      listDbSystemShapesMethodDescriptor =
          MethodDescriptor.<ListDbSystemShapesRequest, ListDbSystemShapesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListDbSystemShapes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDbSystemShapesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDbSystemShapesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse>
      listAutonomousDatabasesMethodDescriptor =
          MethodDescriptor
              .<ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListAutonomousDatabases")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAutonomousDatabasesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAutonomousDatabasesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAutonomousDatabaseRequest, AutonomousDatabase>
      getAutonomousDatabaseMethodDescriptor =
          MethodDescriptor.<GetAutonomousDatabaseRequest, AutonomousDatabase>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/GetAutonomousDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAutonomousDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AutonomousDatabase.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAutonomousDatabaseRequest, Operation>
      createAutonomousDatabaseMethodDescriptor =
          MethodDescriptor.<CreateAutonomousDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/CreateAutonomousDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAutonomousDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateAutonomousDatabaseRequest, Operation>
      updateAutonomousDatabaseMethodDescriptor =
          MethodDescriptor.<UpdateAutonomousDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/UpdateAutonomousDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAutonomousDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAutonomousDatabaseRequest, Operation>
      deleteAutonomousDatabaseMethodDescriptor =
          MethodDescriptor.<DeleteAutonomousDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/DeleteAutonomousDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAutonomousDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RestoreAutonomousDatabaseRequest, Operation>
      restoreAutonomousDatabaseMethodDescriptor =
          MethodDescriptor.<RestoreAutonomousDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/RestoreAutonomousDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestoreAutonomousDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
      generateAutonomousDatabaseWalletMethodDescriptor =
          MethodDescriptor
              .<GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/GenerateAutonomousDatabaseWallet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GenerateAutonomousDatabaseWalletRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      GenerateAutonomousDatabaseWalletResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse>
      listAutonomousDbVersionsMethodDescriptor =
          MethodDescriptor
              .<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListAutonomousDbVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAutonomousDbVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAutonomousDbVersionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAutonomousDatabaseCharacterSetsRequest, ListAutonomousDatabaseCharacterSetsResponse>
      listAutonomousDatabaseCharacterSetsMethodDescriptor =
          MethodDescriptor
              .<ListAutonomousDatabaseCharacterSetsRequest,
                  ListAutonomousDatabaseCharacterSetsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListAutonomousDatabaseCharacterSets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListAutonomousDatabaseCharacterSetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListAutonomousDatabaseCharacterSetsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsResponse>
      listAutonomousDatabaseBackupsMethodDescriptor =
          MethodDescriptor
              .<ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListAutonomousDatabaseBackups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAutonomousDatabaseBackupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAutonomousDatabaseBackupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<StopAutonomousDatabaseRequest, Operation>
      stopAutonomousDatabaseMethodDescriptor =
          MethodDescriptor.<StopAutonomousDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/StopAutonomousDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StopAutonomousDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<StartAutonomousDatabaseRequest, Operation>
      startAutonomousDatabaseMethodDescriptor =
          MethodDescriptor.<StartAutonomousDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/StartAutonomousDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartAutonomousDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RestartAutonomousDatabaseRequest, Operation>
      restartAutonomousDatabaseMethodDescriptor =
          MethodDescriptor.<RestartAutonomousDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/RestartAutonomousDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestartAutonomousDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SwitchoverAutonomousDatabaseRequest, Operation>
      switchoverAutonomousDatabaseMethodDescriptor =
          MethodDescriptor.<SwitchoverAutonomousDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/SwitchoverAutonomousDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SwitchoverAutonomousDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<FailoverAutonomousDatabaseRequest, Operation>
      failoverAutonomousDatabaseMethodDescriptor =
          MethodDescriptor.<FailoverAutonomousDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/FailoverAutonomousDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FailoverAutonomousDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListOdbNetworksRequest, ListOdbNetworksResponse>
      listOdbNetworksMethodDescriptor =
          MethodDescriptor.<ListOdbNetworksRequest, ListOdbNetworksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListOdbNetworks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOdbNetworksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOdbNetworksResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetOdbNetworkRequest, OdbNetwork>
      getOdbNetworkMethodDescriptor =
          MethodDescriptor.<GetOdbNetworkRequest, OdbNetwork>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/GetOdbNetwork")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOdbNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(OdbNetwork.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateOdbNetworkRequest, Operation>
      createOdbNetworkMethodDescriptor =
          MethodDescriptor.<CreateOdbNetworkRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/CreateOdbNetwork")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateOdbNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteOdbNetworkRequest, Operation>
      deleteOdbNetworkMethodDescriptor =
          MethodDescriptor.<DeleteOdbNetworkRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/DeleteOdbNetwork")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteOdbNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListOdbSubnetsRequest, ListOdbSubnetsResponse>
      listOdbSubnetsMethodDescriptor =
          MethodDescriptor.<ListOdbSubnetsRequest, ListOdbSubnetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListOdbSubnets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOdbSubnetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOdbSubnetsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetOdbSubnetRequest, OdbSubnet>
      getOdbSubnetMethodDescriptor =
          MethodDescriptor.<GetOdbSubnetRequest, OdbSubnet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/GetOdbSubnet")
              .setRequestMarshaller(ProtoUtils.marshaller(GetOdbSubnetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(OdbSubnet.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateOdbSubnetRequest, Operation>
      createOdbSubnetMethodDescriptor =
          MethodDescriptor.<CreateOdbSubnetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/CreateOdbSubnet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateOdbSubnetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteOdbSubnetRequest, Operation>
      deleteOdbSubnetMethodDescriptor =
          MethodDescriptor.<DeleteOdbSubnetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/DeleteOdbSubnet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteOdbSubnetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListExadbVmClustersRequest, ListExadbVmClustersResponse>
      listExadbVmClustersMethodDescriptor =
          MethodDescriptor.<ListExadbVmClustersRequest, ListExadbVmClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListExadbVmClusters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExadbVmClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExadbVmClustersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetExadbVmClusterRequest, ExadbVmCluster>
      getExadbVmClusterMethodDescriptor =
          MethodDescriptor.<GetExadbVmClusterRequest, ExadbVmCluster>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/GetExadbVmCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetExadbVmClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ExadbVmCluster.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateExadbVmClusterRequest, Operation>
      createExadbVmClusterMethodDescriptor =
          MethodDescriptor.<CreateExadbVmClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/CreateExadbVmCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateExadbVmClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteExadbVmClusterRequest, Operation>
      deleteExadbVmClusterMethodDescriptor =
          MethodDescriptor.<DeleteExadbVmClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/DeleteExadbVmCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteExadbVmClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateExadbVmClusterRequest, Operation>
      updateExadbVmClusterMethodDescriptor =
          MethodDescriptor.<UpdateExadbVmClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/UpdateExadbVmCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateExadbVmClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RemoveVirtualMachineExadbVmClusterRequest, Operation>
      removeVirtualMachineExadbVmClusterMethodDescriptor =
          MethodDescriptor.<RemoveVirtualMachineExadbVmClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/RemoveVirtualMachineExadbVmCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      RemoveVirtualMachineExadbVmClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsResponse>
      listExascaleDbStorageVaultsMethodDescriptor =
          MethodDescriptor
              .<ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListExascaleDbStorageVaults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExascaleDbStorageVaultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExascaleDbStorageVaultsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
      getExascaleDbStorageVaultMethodDescriptor =
          MethodDescriptor.<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/GetExascaleDbStorageVault")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetExascaleDbStorageVaultRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ExascaleDbStorageVault.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateExascaleDbStorageVaultRequest, Operation>
      createExascaleDbStorageVaultMethodDescriptor =
          MethodDescriptor.<CreateExascaleDbStorageVaultRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/CreateExascaleDbStorageVault")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateExascaleDbStorageVaultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteExascaleDbStorageVaultRequest, Operation>
      deleteExascaleDbStorageVaultMethodDescriptor =
          MethodDescriptor.<DeleteExascaleDbStorageVaultRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/DeleteExascaleDbStorageVault")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteExascaleDbStorageVaultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesResponse>
      listDbSystemInitialStorageSizesMethodDescriptor =
          MethodDescriptor
              .<ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListDbSystemInitialStorageSizes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListDbSystemInitialStorageSizesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListDbSystemInitialStorageSizesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDatabasesRequest, ListDatabasesResponse>
      listDatabasesMethodDescriptor =
          MethodDescriptor.<ListDatabasesRequest, ListDatabasesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListDatabases")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDatabasesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatabasesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDatabaseRequest, Database> getDatabaseMethodDescriptor =
      MethodDescriptor.<GetDatabaseRequest, Database>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/GetDatabase")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDatabaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Database.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<
          ListPluggableDatabasesRequest, ListPluggableDatabasesResponse>
      listPluggableDatabasesMethodDescriptor =
          MethodDescriptor
              .<ListPluggableDatabasesRequest, ListPluggableDatabasesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListPluggableDatabases")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPluggableDatabasesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPluggableDatabasesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetPluggableDatabaseRequest, PluggableDatabase>
      getPluggableDatabaseMethodDescriptor =
          MethodDescriptor.<GetPluggableDatabaseRequest, PluggableDatabase>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/GetPluggableDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPluggableDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PluggableDatabase.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDbSystemsRequest, ListDbSystemsResponse>
      listDbSystemsMethodDescriptor =
          MethodDescriptor.<ListDbSystemsRequest, ListDbSystemsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListDbSystems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDbSystemsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDbSystemsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDbSystemRequest, DbSystem> getDbSystemMethodDescriptor =
      MethodDescriptor.<GetDbSystemRequest, DbSystem>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/GetDbSystem")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDbSystemRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(DbSystem.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateDbSystemRequest, Operation>
      createDbSystemMethodDescriptor =
          MethodDescriptor.<CreateDbSystemRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/CreateDbSystem")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDbSystemRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteDbSystemRequest, Operation>
      deleteDbSystemMethodDescriptor =
          MethodDescriptor.<DeleteDbSystemRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/DeleteDbSystem")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDbSystemRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDbVersionsRequest, ListDbVersionsResponse>
      listDbVersionsMethodDescriptor =
          MethodDescriptor.<ListDbVersionsRequest, ListDbVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListDbVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDbVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDbVersionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse>
      listDatabaseCharacterSetsMethodDescriptor =
          MethodDescriptor
              .<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListDatabaseCharacterSets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDatabaseCharacterSetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatabaseCharacterSetsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<
          ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresResponse>
      listCloudExadataInfrastructuresCallable;
  private final UnaryCallable<
          ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresPagedResponse>
      listCloudExadataInfrastructuresPagedCallable;
  private final UnaryCallable<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
      getCloudExadataInfrastructureCallable;
  private final UnaryCallable<CreateCloudExadataInfrastructureRequest, Operation>
      createCloudExadataInfrastructureCallable;
  private final OperationCallable<
          CreateCloudExadataInfrastructureRequest, CloudExadataInfrastructure, OperationMetadata>
      createCloudExadataInfrastructureOperationCallable;
  private final UnaryCallable<DeleteCloudExadataInfrastructureRequest, Operation>
      deleteCloudExadataInfrastructureCallable;
  private final OperationCallable<DeleteCloudExadataInfrastructureRequest, Empty, OperationMetadata>
      deleteCloudExadataInfrastructureOperationCallable;
  private final UnaryCallable<ListCloudVmClustersRequest, ListCloudVmClustersResponse>
      listCloudVmClustersCallable;
  private final UnaryCallable<ListCloudVmClustersRequest, ListCloudVmClustersPagedResponse>
      listCloudVmClustersPagedCallable;
  private final UnaryCallable<GetCloudVmClusterRequest, CloudVmCluster> getCloudVmClusterCallable;
  private final UnaryCallable<CreateCloudVmClusterRequest, Operation> createCloudVmClusterCallable;
  private final OperationCallable<CreateCloudVmClusterRequest, CloudVmCluster, OperationMetadata>
      createCloudVmClusterOperationCallable;
  private final UnaryCallable<DeleteCloudVmClusterRequest, Operation> deleteCloudVmClusterCallable;
  private final OperationCallable<DeleteCloudVmClusterRequest, Empty, OperationMetadata>
      deleteCloudVmClusterOperationCallable;
  private final UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsCallable;
  private final UnaryCallable<ListEntitlementsRequest, ListEntitlementsPagedResponse>
      listEntitlementsPagedCallable;
  private final UnaryCallable<ListDbServersRequest, ListDbServersResponse> listDbServersCallable;
  private final UnaryCallable<ListDbServersRequest, ListDbServersPagedResponse>
      listDbServersPagedCallable;
  private final UnaryCallable<ListDbNodesRequest, ListDbNodesResponse> listDbNodesCallable;
  private final UnaryCallable<ListDbNodesRequest, ListDbNodesPagedResponse>
      listDbNodesPagedCallable;
  private final UnaryCallable<ListGiVersionsRequest, ListGiVersionsResponse> listGiVersionsCallable;
  private final UnaryCallable<ListGiVersionsRequest, ListGiVersionsPagedResponse>
      listGiVersionsPagedCallable;
  private final UnaryCallable<ListMinorVersionsRequest, ListMinorVersionsResponse>
      listMinorVersionsCallable;
  private final UnaryCallable<ListMinorVersionsRequest, ListMinorVersionsPagedResponse>
      listMinorVersionsPagedCallable;
  private final UnaryCallable<ListDbSystemShapesRequest, ListDbSystemShapesResponse>
      listDbSystemShapesCallable;
  private final UnaryCallable<ListDbSystemShapesRequest, ListDbSystemShapesPagedResponse>
      listDbSystemShapesPagedCallable;
  private final UnaryCallable<ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse>
      listAutonomousDatabasesCallable;
  private final UnaryCallable<ListAutonomousDatabasesRequest, ListAutonomousDatabasesPagedResponse>
      listAutonomousDatabasesPagedCallable;
  private final UnaryCallable<GetAutonomousDatabaseRequest, AutonomousDatabase>
      getAutonomousDatabaseCallable;
  private final UnaryCallable<CreateAutonomousDatabaseRequest, Operation>
      createAutonomousDatabaseCallable;
  private final OperationCallable<
          CreateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      createAutonomousDatabaseOperationCallable;
  private final UnaryCallable<UpdateAutonomousDatabaseRequest, Operation>
      updateAutonomousDatabaseCallable;
  private final OperationCallable<
          UpdateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      updateAutonomousDatabaseOperationCallable;
  private final UnaryCallable<DeleteAutonomousDatabaseRequest, Operation>
      deleteAutonomousDatabaseCallable;
  private final OperationCallable<DeleteAutonomousDatabaseRequest, Empty, OperationMetadata>
      deleteAutonomousDatabaseOperationCallable;
  private final UnaryCallable<RestoreAutonomousDatabaseRequest, Operation>
      restoreAutonomousDatabaseCallable;
  private final OperationCallable<
          RestoreAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restoreAutonomousDatabaseOperationCallable;
  private final UnaryCallable<
          GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
      generateAutonomousDatabaseWalletCallable;
  private final UnaryCallable<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse>
      listAutonomousDbVersionsCallable;
  private final UnaryCallable<
          ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsPagedResponse>
      listAutonomousDbVersionsPagedCallable;
  private final UnaryCallable<
          ListAutonomousDatabaseCharacterSetsRequest, ListAutonomousDatabaseCharacterSetsResponse>
      listAutonomousDatabaseCharacterSetsCallable;
  private final UnaryCallable<
          ListAutonomousDatabaseCharacterSetsRequest,
          ListAutonomousDatabaseCharacterSetsPagedResponse>
      listAutonomousDatabaseCharacterSetsPagedCallable;
  private final UnaryCallable<
          ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsResponse>
      listAutonomousDatabaseBackupsCallable;
  private final UnaryCallable<
          ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsPagedResponse>
      listAutonomousDatabaseBackupsPagedCallable;
  private final UnaryCallable<StopAutonomousDatabaseRequest, Operation>
      stopAutonomousDatabaseCallable;
  private final OperationCallable<
          StopAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      stopAutonomousDatabaseOperationCallable;
  private final UnaryCallable<StartAutonomousDatabaseRequest, Operation>
      startAutonomousDatabaseCallable;
  private final OperationCallable<
          StartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      startAutonomousDatabaseOperationCallable;
  private final UnaryCallable<RestartAutonomousDatabaseRequest, Operation>
      restartAutonomousDatabaseCallable;
  private final OperationCallable<
          RestartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restartAutonomousDatabaseOperationCallable;
  private final UnaryCallable<SwitchoverAutonomousDatabaseRequest, Operation>
      switchoverAutonomousDatabaseCallable;
  private final OperationCallable<
          SwitchoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      switchoverAutonomousDatabaseOperationCallable;
  private final UnaryCallable<FailoverAutonomousDatabaseRequest, Operation>
      failoverAutonomousDatabaseCallable;
  private final OperationCallable<
          FailoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      failoverAutonomousDatabaseOperationCallable;
  private final UnaryCallable<ListOdbNetworksRequest, ListOdbNetworksResponse>
      listOdbNetworksCallable;
  private final UnaryCallable<ListOdbNetworksRequest, ListOdbNetworksPagedResponse>
      listOdbNetworksPagedCallable;
  private final UnaryCallable<GetOdbNetworkRequest, OdbNetwork> getOdbNetworkCallable;
  private final UnaryCallable<CreateOdbNetworkRequest, Operation> createOdbNetworkCallable;
  private final OperationCallable<CreateOdbNetworkRequest, OdbNetwork, OperationMetadata>
      createOdbNetworkOperationCallable;
  private final UnaryCallable<DeleteOdbNetworkRequest, Operation> deleteOdbNetworkCallable;
  private final OperationCallable<DeleteOdbNetworkRequest, Empty, OperationMetadata>
      deleteOdbNetworkOperationCallable;
  private final UnaryCallable<ListOdbSubnetsRequest, ListOdbSubnetsResponse> listOdbSubnetsCallable;
  private final UnaryCallable<ListOdbSubnetsRequest, ListOdbSubnetsPagedResponse>
      listOdbSubnetsPagedCallable;
  private final UnaryCallable<GetOdbSubnetRequest, OdbSubnet> getOdbSubnetCallable;
  private final UnaryCallable<CreateOdbSubnetRequest, Operation> createOdbSubnetCallable;
  private final OperationCallable<CreateOdbSubnetRequest, OdbSubnet, OperationMetadata>
      createOdbSubnetOperationCallable;
  private final UnaryCallable<DeleteOdbSubnetRequest, Operation> deleteOdbSubnetCallable;
  private final OperationCallable<DeleteOdbSubnetRequest, Empty, OperationMetadata>
      deleteOdbSubnetOperationCallable;
  private final UnaryCallable<ListExadbVmClustersRequest, ListExadbVmClustersResponse>
      listExadbVmClustersCallable;
  private final UnaryCallable<ListExadbVmClustersRequest, ListExadbVmClustersPagedResponse>
      listExadbVmClustersPagedCallable;
  private final UnaryCallable<GetExadbVmClusterRequest, ExadbVmCluster> getExadbVmClusterCallable;
  private final UnaryCallable<CreateExadbVmClusterRequest, Operation> createExadbVmClusterCallable;
  private final OperationCallable<CreateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      createExadbVmClusterOperationCallable;
  private final UnaryCallable<DeleteExadbVmClusterRequest, Operation> deleteExadbVmClusterCallable;
  private final OperationCallable<DeleteExadbVmClusterRequest, Empty, OperationMetadata>
      deleteExadbVmClusterOperationCallable;
  private final UnaryCallable<UpdateExadbVmClusterRequest, Operation> updateExadbVmClusterCallable;
  private final OperationCallable<UpdateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      updateExadbVmClusterOperationCallable;
  private final UnaryCallable<RemoveVirtualMachineExadbVmClusterRequest, Operation>
      removeVirtualMachineExadbVmClusterCallable;
  private final OperationCallable<
          RemoveVirtualMachineExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      removeVirtualMachineExadbVmClusterOperationCallable;
  private final UnaryCallable<
          ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsResponse>
      listExascaleDbStorageVaultsCallable;
  private final UnaryCallable<
          ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsPagedResponse>
      listExascaleDbStorageVaultsPagedCallable;
  private final UnaryCallable<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
      getExascaleDbStorageVaultCallable;
  private final UnaryCallable<CreateExascaleDbStorageVaultRequest, Operation>
      createExascaleDbStorageVaultCallable;
  private final OperationCallable<
          CreateExascaleDbStorageVaultRequest, ExascaleDbStorageVault, OperationMetadata>
      createExascaleDbStorageVaultOperationCallable;
  private final UnaryCallable<DeleteExascaleDbStorageVaultRequest, Operation>
      deleteExascaleDbStorageVaultCallable;
  private final OperationCallable<DeleteExascaleDbStorageVaultRequest, Empty, OperationMetadata>
      deleteExascaleDbStorageVaultOperationCallable;
  private final UnaryCallable<
          ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesResponse>
      listDbSystemInitialStorageSizesCallable;
  private final UnaryCallable<
          ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesPagedResponse>
      listDbSystemInitialStorageSizesPagedCallable;
  private final UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable;
  private final UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable;
  private final UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable;
  private final UnaryCallable<ListPluggableDatabasesRequest, ListPluggableDatabasesResponse>
      listPluggableDatabasesCallable;
  private final UnaryCallable<ListPluggableDatabasesRequest, ListPluggableDatabasesPagedResponse>
      listPluggableDatabasesPagedCallable;
  private final UnaryCallable<GetPluggableDatabaseRequest, PluggableDatabase>
      getPluggableDatabaseCallable;
  private final UnaryCallable<ListDbSystemsRequest, ListDbSystemsResponse> listDbSystemsCallable;
  private final UnaryCallable<ListDbSystemsRequest, ListDbSystemsPagedResponse>
      listDbSystemsPagedCallable;
  private final UnaryCallable<GetDbSystemRequest, DbSystem> getDbSystemCallable;
  private final UnaryCallable<CreateDbSystemRequest, Operation> createDbSystemCallable;
  private final OperationCallable<CreateDbSystemRequest, DbSystem, OperationMetadata>
      createDbSystemOperationCallable;
  private final UnaryCallable<DeleteDbSystemRequest, Operation> deleteDbSystemCallable;
  private final OperationCallable<DeleteDbSystemRequest, Empty, OperationMetadata>
      deleteDbSystemOperationCallable;
  private final UnaryCallable<ListDbVersionsRequest, ListDbVersionsResponse> listDbVersionsCallable;
  private final UnaryCallable<ListDbVersionsRequest, ListDbVersionsPagedResponse>
      listDbVersionsPagedCallable;
  private final UnaryCallable<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse>
      listDatabaseCharacterSetsCallable;
  private final UnaryCallable<
          ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsPagedResponse>
      listDatabaseCharacterSetsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcOracleDatabaseStub create(OracleDatabaseStubSettings settings)
      throws IOException {
    return new GrpcOracleDatabaseStub(settings, ClientContext.create(settings));
  }

  public static final GrpcOracleDatabaseStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcOracleDatabaseStub(
        OracleDatabaseStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcOracleDatabaseStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcOracleDatabaseStub(
        OracleDatabaseStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcOracleDatabaseStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcOracleDatabaseStub(OracleDatabaseStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcOracleDatabaseCallableFactory());
  }

  /**
   * Constructs an instance of GrpcOracleDatabaseStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcOracleDatabaseStub(
      OracleDatabaseStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<
            ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresResponse>
        listCloudExadataInfrastructuresTransportSettings =
            GrpcCallSettings
                .<ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresResponse>
                    newBuilder()
                .setMethodDescriptor(listCloudExadataInfrastructuresMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
        getCloudExadataInfrastructureTransportSettings =
            GrpcCallSettings
                .<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>newBuilder()
                .setMethodDescriptor(getCloudExadataInfrastructureMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateCloudExadataInfrastructureRequest, Operation>
        createCloudExadataInfrastructureTransportSettings =
            GrpcCallSettings.<CreateCloudExadataInfrastructureRequest, Operation>newBuilder()
                .setMethodDescriptor(createCloudExadataInfrastructureMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteCloudExadataInfrastructureRequest, Operation>
        deleteCloudExadataInfrastructureTransportSettings =
            GrpcCallSettings.<DeleteCloudExadataInfrastructureRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteCloudExadataInfrastructureMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListCloudVmClustersRequest, ListCloudVmClustersResponse>
        listCloudVmClustersTransportSettings =
            GrpcCallSettings.<ListCloudVmClustersRequest, ListCloudVmClustersResponse>newBuilder()
                .setMethodDescriptor(listCloudVmClustersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetCloudVmClusterRequest, CloudVmCluster> getCloudVmClusterTransportSettings =
        GrpcCallSettings.<GetCloudVmClusterRequest, CloudVmCluster>newBuilder()
            .setMethodDescriptor(getCloudVmClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateCloudVmClusterRequest, Operation> createCloudVmClusterTransportSettings =
        GrpcCallSettings.<CreateCloudVmClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createCloudVmClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteCloudVmClusterRequest, Operation> deleteCloudVmClusterTransportSettings =
        GrpcCallSettings.<DeleteCloudVmClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCloudVmClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListEntitlementsRequest, ListEntitlementsResponse>
        listEntitlementsTransportSettings =
            GrpcCallSettings.<ListEntitlementsRequest, ListEntitlementsResponse>newBuilder()
                .setMethodDescriptor(listEntitlementsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDbServersRequest, ListDbServersResponse> listDbServersTransportSettings =
        GrpcCallSettings.<ListDbServersRequest, ListDbServersResponse>newBuilder()
            .setMethodDescriptor(listDbServersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDbNodesRequest, ListDbNodesResponse> listDbNodesTransportSettings =
        GrpcCallSettings.<ListDbNodesRequest, ListDbNodesResponse>newBuilder()
            .setMethodDescriptor(listDbNodesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListGiVersionsRequest, ListGiVersionsResponse>
        listGiVersionsTransportSettings =
            GrpcCallSettings.<ListGiVersionsRequest, ListGiVersionsResponse>newBuilder()
                .setMethodDescriptor(listGiVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListMinorVersionsRequest, ListMinorVersionsResponse>
        listMinorVersionsTransportSettings =
            GrpcCallSettings.<ListMinorVersionsRequest, ListMinorVersionsResponse>newBuilder()
                .setMethodDescriptor(listMinorVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDbSystemShapesRequest, ListDbSystemShapesResponse>
        listDbSystemShapesTransportSettings =
            GrpcCallSettings.<ListDbSystemShapesRequest, ListDbSystemShapesResponse>newBuilder()
                .setMethodDescriptor(listDbSystemShapesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse>
        listAutonomousDatabasesTransportSettings =
            GrpcCallSettings
                .<ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse>newBuilder()
                .setMethodDescriptor(listAutonomousDatabasesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetAutonomousDatabaseRequest, AutonomousDatabase>
        getAutonomousDatabaseTransportSettings =
            GrpcCallSettings.<GetAutonomousDatabaseRequest, AutonomousDatabase>newBuilder()
                .setMethodDescriptor(getAutonomousDatabaseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateAutonomousDatabaseRequest, Operation>
        createAutonomousDatabaseTransportSettings =
            GrpcCallSettings.<CreateAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(createAutonomousDatabaseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateAutonomousDatabaseRequest, Operation>
        updateAutonomousDatabaseTransportSettings =
            GrpcCallSettings.<UpdateAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(updateAutonomousDatabaseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "autonomous_database.name",
                          String.valueOf(request.getAutonomousDatabase().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteAutonomousDatabaseRequest, Operation>
        deleteAutonomousDatabaseTransportSettings =
            GrpcCallSettings.<DeleteAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteAutonomousDatabaseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RestoreAutonomousDatabaseRequest, Operation>
        restoreAutonomousDatabaseTransportSettings =
            GrpcCallSettings.<RestoreAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(restoreAutonomousDatabaseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
        generateAutonomousDatabaseWalletTransportSettings =
            GrpcCallSettings
                .<GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
                    newBuilder()
                .setMethodDescriptor(generateAutonomousDatabaseWalletMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse>
        listAutonomousDbVersionsTransportSettings =
            GrpcCallSettings
                .<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse>newBuilder()
                .setMethodDescriptor(listAutonomousDbVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListAutonomousDatabaseCharacterSetsRequest, ListAutonomousDatabaseCharacterSetsResponse>
        listAutonomousDatabaseCharacterSetsTransportSettings =
            GrpcCallSettings
                .<ListAutonomousDatabaseCharacterSetsRequest,
                    ListAutonomousDatabaseCharacterSetsResponse>
                    newBuilder()
                .setMethodDescriptor(listAutonomousDatabaseCharacterSetsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsResponse>
        listAutonomousDatabaseBackupsTransportSettings =
            GrpcCallSettings
                .<ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsResponse>
                    newBuilder()
                .setMethodDescriptor(listAutonomousDatabaseBackupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<StopAutonomousDatabaseRequest, Operation>
        stopAutonomousDatabaseTransportSettings =
            GrpcCallSettings.<StopAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(stopAutonomousDatabaseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<StartAutonomousDatabaseRequest, Operation>
        startAutonomousDatabaseTransportSettings =
            GrpcCallSettings.<StartAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(startAutonomousDatabaseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RestartAutonomousDatabaseRequest, Operation>
        restartAutonomousDatabaseTransportSettings =
            GrpcCallSettings.<RestartAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(restartAutonomousDatabaseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SwitchoverAutonomousDatabaseRequest, Operation>
        switchoverAutonomousDatabaseTransportSettings =
            GrpcCallSettings.<SwitchoverAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(switchoverAutonomousDatabaseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FailoverAutonomousDatabaseRequest, Operation>
        failoverAutonomousDatabaseTransportSettings =
            GrpcCallSettings.<FailoverAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(failoverAutonomousDatabaseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListOdbNetworksRequest, ListOdbNetworksResponse>
        listOdbNetworksTransportSettings =
            GrpcCallSettings.<ListOdbNetworksRequest, ListOdbNetworksResponse>newBuilder()
                .setMethodDescriptor(listOdbNetworksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetOdbNetworkRequest, OdbNetwork> getOdbNetworkTransportSettings =
        GrpcCallSettings.<GetOdbNetworkRequest, OdbNetwork>newBuilder()
            .setMethodDescriptor(getOdbNetworkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateOdbNetworkRequest, Operation> createOdbNetworkTransportSettings =
        GrpcCallSettings.<CreateOdbNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(createOdbNetworkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteOdbNetworkRequest, Operation> deleteOdbNetworkTransportSettings =
        GrpcCallSettings.<DeleteOdbNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteOdbNetworkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListOdbSubnetsRequest, ListOdbSubnetsResponse>
        listOdbSubnetsTransportSettings =
            GrpcCallSettings.<ListOdbSubnetsRequest, ListOdbSubnetsResponse>newBuilder()
                .setMethodDescriptor(listOdbSubnetsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetOdbSubnetRequest, OdbSubnet> getOdbSubnetTransportSettings =
        GrpcCallSettings.<GetOdbSubnetRequest, OdbSubnet>newBuilder()
            .setMethodDescriptor(getOdbSubnetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateOdbSubnetRequest, Operation> createOdbSubnetTransportSettings =
        GrpcCallSettings.<CreateOdbSubnetRequest, Operation>newBuilder()
            .setMethodDescriptor(createOdbSubnetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteOdbSubnetRequest, Operation> deleteOdbSubnetTransportSettings =
        GrpcCallSettings.<DeleteOdbSubnetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteOdbSubnetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListExadbVmClustersRequest, ListExadbVmClustersResponse>
        listExadbVmClustersTransportSettings =
            GrpcCallSettings.<ListExadbVmClustersRequest, ListExadbVmClustersResponse>newBuilder()
                .setMethodDescriptor(listExadbVmClustersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetExadbVmClusterRequest, ExadbVmCluster> getExadbVmClusterTransportSettings =
        GrpcCallSettings.<GetExadbVmClusterRequest, ExadbVmCluster>newBuilder()
            .setMethodDescriptor(getExadbVmClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateExadbVmClusterRequest, Operation> createExadbVmClusterTransportSettings =
        GrpcCallSettings.<CreateExadbVmClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createExadbVmClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteExadbVmClusterRequest, Operation> deleteExadbVmClusterTransportSettings =
        GrpcCallSettings.<DeleteExadbVmClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteExadbVmClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateExadbVmClusterRequest, Operation> updateExadbVmClusterTransportSettings =
        GrpcCallSettings.<UpdateExadbVmClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateExadbVmClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "exadb_vm_cluster.name",
                      String.valueOf(request.getExadbVmCluster().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RemoveVirtualMachineExadbVmClusterRequest, Operation>
        removeVirtualMachineExadbVmClusterTransportSettings =
            GrpcCallSettings.<RemoveVirtualMachineExadbVmClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(removeVirtualMachineExadbVmClusterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsResponse>
        listExascaleDbStorageVaultsTransportSettings =
            GrpcCallSettings
                .<ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsResponse>
                    newBuilder()
                .setMethodDescriptor(listExascaleDbStorageVaultsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
        getExascaleDbStorageVaultTransportSettings =
            GrpcCallSettings.<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>newBuilder()
                .setMethodDescriptor(getExascaleDbStorageVaultMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateExascaleDbStorageVaultRequest, Operation>
        createExascaleDbStorageVaultTransportSettings =
            GrpcCallSettings.<CreateExascaleDbStorageVaultRequest, Operation>newBuilder()
                .setMethodDescriptor(createExascaleDbStorageVaultMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteExascaleDbStorageVaultRequest, Operation>
        deleteExascaleDbStorageVaultTransportSettings =
            GrpcCallSettings.<DeleteExascaleDbStorageVaultRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteExascaleDbStorageVaultMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesResponse>
        listDbSystemInitialStorageSizesTransportSettings =
            GrpcCallSettings
                .<ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesResponse>
                    newBuilder()
                .setMethodDescriptor(listDbSystemInitialStorageSizesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDatabasesRequest, ListDatabasesResponse> listDatabasesTransportSettings =
        GrpcCallSettings.<ListDatabasesRequest, ListDatabasesResponse>newBuilder()
            .setMethodDescriptor(listDatabasesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDatabaseRequest, Database> getDatabaseTransportSettings =
        GrpcCallSettings.<GetDatabaseRequest, Database>newBuilder()
            .setMethodDescriptor(getDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPluggableDatabasesRequest, ListPluggableDatabasesResponse>
        listPluggableDatabasesTransportSettings =
            GrpcCallSettings
                .<ListPluggableDatabasesRequest, ListPluggableDatabasesResponse>newBuilder()
                .setMethodDescriptor(listPluggableDatabasesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPluggableDatabaseRequest, PluggableDatabase>
        getPluggableDatabaseTransportSettings =
            GrpcCallSettings.<GetPluggableDatabaseRequest, PluggableDatabase>newBuilder()
                .setMethodDescriptor(getPluggableDatabaseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDbSystemsRequest, ListDbSystemsResponse> listDbSystemsTransportSettings =
        GrpcCallSettings.<ListDbSystemsRequest, ListDbSystemsResponse>newBuilder()
            .setMethodDescriptor(listDbSystemsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDbSystemRequest, DbSystem> getDbSystemTransportSettings =
        GrpcCallSettings.<GetDbSystemRequest, DbSystem>newBuilder()
            .setMethodDescriptor(getDbSystemMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDbSystemRequest, Operation> createDbSystemTransportSettings =
        GrpcCallSettings.<CreateDbSystemRequest, Operation>newBuilder()
            .setMethodDescriptor(createDbSystemMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDbSystemRequest, Operation> deleteDbSystemTransportSettings =
        GrpcCallSettings.<DeleteDbSystemRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDbSystemMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDbVersionsRequest, ListDbVersionsResponse>
        listDbVersionsTransportSettings =
            GrpcCallSettings.<ListDbVersionsRequest, ListDbVersionsResponse>newBuilder()
                .setMethodDescriptor(listDbVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse>
        listDatabaseCharacterSetsTransportSettings =
            GrpcCallSettings
                .<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse>newBuilder()
                .setMethodDescriptor(listDatabaseCharacterSetsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listCloudExadataInfrastructuresCallable =
        callableFactory.createUnaryCallable(
            listCloudExadataInfrastructuresTransportSettings,
            settings.listCloudExadataInfrastructuresSettings(),
            clientContext);
    this.listCloudExadataInfrastructuresPagedCallable =
        callableFactory.createPagedCallable(
            listCloudExadataInfrastructuresTransportSettings,
            settings.listCloudExadataInfrastructuresSettings(),
            clientContext);
    this.getCloudExadataInfrastructureCallable =
        callableFactory.createUnaryCallable(
            getCloudExadataInfrastructureTransportSettings,
            settings.getCloudExadataInfrastructureSettings(),
            clientContext);
    this.createCloudExadataInfrastructureCallable =
        callableFactory.createUnaryCallable(
            createCloudExadataInfrastructureTransportSettings,
            settings.createCloudExadataInfrastructureSettings(),
            clientContext);
    this.createCloudExadataInfrastructureOperationCallable =
        callableFactory.createOperationCallable(
            createCloudExadataInfrastructureTransportSettings,
            settings.createCloudExadataInfrastructureOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteCloudExadataInfrastructureCallable =
        callableFactory.createUnaryCallable(
            deleteCloudExadataInfrastructureTransportSettings,
            settings.deleteCloudExadataInfrastructureSettings(),
            clientContext);
    this.deleteCloudExadataInfrastructureOperationCallable =
        callableFactory.createOperationCallable(
            deleteCloudExadataInfrastructureTransportSettings,
            settings.deleteCloudExadataInfrastructureOperationSettings(),
            clientContext,
            operationsStub);
    this.listCloudVmClustersCallable =
        callableFactory.createUnaryCallable(
            listCloudVmClustersTransportSettings,
            settings.listCloudVmClustersSettings(),
            clientContext);
    this.listCloudVmClustersPagedCallable =
        callableFactory.createPagedCallable(
            listCloudVmClustersTransportSettings,
            settings.listCloudVmClustersSettings(),
            clientContext);
    this.getCloudVmClusterCallable =
        callableFactory.createUnaryCallable(
            getCloudVmClusterTransportSettings,
            settings.getCloudVmClusterSettings(),
            clientContext);
    this.createCloudVmClusterCallable =
        callableFactory.createUnaryCallable(
            createCloudVmClusterTransportSettings,
            settings.createCloudVmClusterSettings(),
            clientContext);
    this.createCloudVmClusterOperationCallable =
        callableFactory.createOperationCallable(
            createCloudVmClusterTransportSettings,
            settings.createCloudVmClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteCloudVmClusterCallable =
        callableFactory.createUnaryCallable(
            deleteCloudVmClusterTransportSettings,
            settings.deleteCloudVmClusterSettings(),
            clientContext);
    this.deleteCloudVmClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteCloudVmClusterTransportSettings,
            settings.deleteCloudVmClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.listEntitlementsCallable =
        callableFactory.createUnaryCallable(
            listEntitlementsTransportSettings, settings.listEntitlementsSettings(), clientContext);
    this.listEntitlementsPagedCallable =
        callableFactory.createPagedCallable(
            listEntitlementsTransportSettings, settings.listEntitlementsSettings(), clientContext);
    this.listDbServersCallable =
        callableFactory.createUnaryCallable(
            listDbServersTransportSettings, settings.listDbServersSettings(), clientContext);
    this.listDbServersPagedCallable =
        callableFactory.createPagedCallable(
            listDbServersTransportSettings, settings.listDbServersSettings(), clientContext);
    this.listDbNodesCallable =
        callableFactory.createUnaryCallable(
            listDbNodesTransportSettings, settings.listDbNodesSettings(), clientContext);
    this.listDbNodesPagedCallable =
        callableFactory.createPagedCallable(
            listDbNodesTransportSettings, settings.listDbNodesSettings(), clientContext);
    this.listGiVersionsCallable =
        callableFactory.createUnaryCallable(
            listGiVersionsTransportSettings, settings.listGiVersionsSettings(), clientContext);
    this.listGiVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listGiVersionsTransportSettings, settings.listGiVersionsSettings(), clientContext);
    this.listMinorVersionsCallable =
        callableFactory.createUnaryCallable(
            listMinorVersionsTransportSettings,
            settings.listMinorVersionsSettings(),
            clientContext);
    this.listMinorVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listMinorVersionsTransportSettings,
            settings.listMinorVersionsSettings(),
            clientContext);
    this.listDbSystemShapesCallable =
        callableFactory.createUnaryCallable(
            listDbSystemShapesTransportSettings,
            settings.listDbSystemShapesSettings(),
            clientContext);
    this.listDbSystemShapesPagedCallable =
        callableFactory.createPagedCallable(
            listDbSystemShapesTransportSettings,
            settings.listDbSystemShapesSettings(),
            clientContext);
    this.listAutonomousDatabasesCallable =
        callableFactory.createUnaryCallable(
            listAutonomousDatabasesTransportSettings,
            settings.listAutonomousDatabasesSettings(),
            clientContext);
    this.listAutonomousDatabasesPagedCallable =
        callableFactory.createPagedCallable(
            listAutonomousDatabasesTransportSettings,
            settings.listAutonomousDatabasesSettings(),
            clientContext);
    this.getAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            getAutonomousDatabaseTransportSettings,
            settings.getAutonomousDatabaseSettings(),
            clientContext);
    this.createAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            createAutonomousDatabaseTransportSettings,
            settings.createAutonomousDatabaseSettings(),
            clientContext);
    this.createAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            createAutonomousDatabaseTransportSettings,
            settings.createAutonomousDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            updateAutonomousDatabaseTransportSettings,
            settings.updateAutonomousDatabaseSettings(),
            clientContext);
    this.updateAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            updateAutonomousDatabaseTransportSettings,
            settings.updateAutonomousDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            deleteAutonomousDatabaseTransportSettings,
            settings.deleteAutonomousDatabaseSettings(),
            clientContext);
    this.deleteAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            deleteAutonomousDatabaseTransportSettings,
            settings.deleteAutonomousDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.restoreAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            restoreAutonomousDatabaseTransportSettings,
            settings.restoreAutonomousDatabaseSettings(),
            clientContext);
    this.restoreAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            restoreAutonomousDatabaseTransportSettings,
            settings.restoreAutonomousDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.generateAutonomousDatabaseWalletCallable =
        callableFactory.createUnaryCallable(
            generateAutonomousDatabaseWalletTransportSettings,
            settings.generateAutonomousDatabaseWalletSettings(),
            clientContext);
    this.listAutonomousDbVersionsCallable =
        callableFactory.createUnaryCallable(
            listAutonomousDbVersionsTransportSettings,
            settings.listAutonomousDbVersionsSettings(),
            clientContext);
    this.listAutonomousDbVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listAutonomousDbVersionsTransportSettings,
            settings.listAutonomousDbVersionsSettings(),
            clientContext);
    this.listAutonomousDatabaseCharacterSetsCallable =
        callableFactory.createUnaryCallable(
            listAutonomousDatabaseCharacterSetsTransportSettings,
            settings.listAutonomousDatabaseCharacterSetsSettings(),
            clientContext);
    this.listAutonomousDatabaseCharacterSetsPagedCallable =
        callableFactory.createPagedCallable(
            listAutonomousDatabaseCharacterSetsTransportSettings,
            settings.listAutonomousDatabaseCharacterSetsSettings(),
            clientContext);
    this.listAutonomousDatabaseBackupsCallable =
        callableFactory.createUnaryCallable(
            listAutonomousDatabaseBackupsTransportSettings,
            settings.listAutonomousDatabaseBackupsSettings(),
            clientContext);
    this.listAutonomousDatabaseBackupsPagedCallable =
        callableFactory.createPagedCallable(
            listAutonomousDatabaseBackupsTransportSettings,
            settings.listAutonomousDatabaseBackupsSettings(),
            clientContext);
    this.stopAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            stopAutonomousDatabaseTransportSettings,
            settings.stopAutonomousDatabaseSettings(),
            clientContext);
    this.stopAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            stopAutonomousDatabaseTransportSettings,
            settings.stopAutonomousDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.startAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            startAutonomousDatabaseTransportSettings,
            settings.startAutonomousDatabaseSettings(),
            clientContext);
    this.startAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            startAutonomousDatabaseTransportSettings,
            settings.startAutonomousDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.restartAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            restartAutonomousDatabaseTransportSettings,
            settings.restartAutonomousDatabaseSettings(),
            clientContext);
    this.restartAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            restartAutonomousDatabaseTransportSettings,
            settings.restartAutonomousDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.switchoverAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            switchoverAutonomousDatabaseTransportSettings,
            settings.switchoverAutonomousDatabaseSettings(),
            clientContext);
    this.switchoverAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            switchoverAutonomousDatabaseTransportSettings,
            settings.switchoverAutonomousDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.failoverAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            failoverAutonomousDatabaseTransportSettings,
            settings.failoverAutonomousDatabaseSettings(),
            clientContext);
    this.failoverAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            failoverAutonomousDatabaseTransportSettings,
            settings.failoverAutonomousDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.listOdbNetworksCallable =
        callableFactory.createUnaryCallable(
            listOdbNetworksTransportSettings, settings.listOdbNetworksSettings(), clientContext);
    this.listOdbNetworksPagedCallable =
        callableFactory.createPagedCallable(
            listOdbNetworksTransportSettings, settings.listOdbNetworksSettings(), clientContext);
    this.getOdbNetworkCallable =
        callableFactory.createUnaryCallable(
            getOdbNetworkTransportSettings, settings.getOdbNetworkSettings(), clientContext);
    this.createOdbNetworkCallable =
        callableFactory.createUnaryCallable(
            createOdbNetworkTransportSettings, settings.createOdbNetworkSettings(), clientContext);
    this.createOdbNetworkOperationCallable =
        callableFactory.createOperationCallable(
            createOdbNetworkTransportSettings,
            settings.createOdbNetworkOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteOdbNetworkCallable =
        callableFactory.createUnaryCallable(
            deleteOdbNetworkTransportSettings, settings.deleteOdbNetworkSettings(), clientContext);
    this.deleteOdbNetworkOperationCallable =
        callableFactory.createOperationCallable(
            deleteOdbNetworkTransportSettings,
            settings.deleteOdbNetworkOperationSettings(),
            clientContext,
            operationsStub);
    this.listOdbSubnetsCallable =
        callableFactory.createUnaryCallable(
            listOdbSubnetsTransportSettings, settings.listOdbSubnetsSettings(), clientContext);
    this.listOdbSubnetsPagedCallable =
        callableFactory.createPagedCallable(
            listOdbSubnetsTransportSettings, settings.listOdbSubnetsSettings(), clientContext);
    this.getOdbSubnetCallable =
        callableFactory.createUnaryCallable(
            getOdbSubnetTransportSettings, settings.getOdbSubnetSettings(), clientContext);
    this.createOdbSubnetCallable =
        callableFactory.createUnaryCallable(
            createOdbSubnetTransportSettings, settings.createOdbSubnetSettings(), clientContext);
    this.createOdbSubnetOperationCallable =
        callableFactory.createOperationCallable(
            createOdbSubnetTransportSettings,
            settings.createOdbSubnetOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteOdbSubnetCallable =
        callableFactory.createUnaryCallable(
            deleteOdbSubnetTransportSettings, settings.deleteOdbSubnetSettings(), clientContext);
    this.deleteOdbSubnetOperationCallable =
        callableFactory.createOperationCallable(
            deleteOdbSubnetTransportSettings,
            settings.deleteOdbSubnetOperationSettings(),
            clientContext,
            operationsStub);
    this.listExadbVmClustersCallable =
        callableFactory.createUnaryCallable(
            listExadbVmClustersTransportSettings,
            settings.listExadbVmClustersSettings(),
            clientContext);
    this.listExadbVmClustersPagedCallable =
        callableFactory.createPagedCallable(
            listExadbVmClustersTransportSettings,
            settings.listExadbVmClustersSettings(),
            clientContext);
    this.getExadbVmClusterCallable =
        callableFactory.createUnaryCallable(
            getExadbVmClusterTransportSettings,
            settings.getExadbVmClusterSettings(),
            clientContext);
    this.createExadbVmClusterCallable =
        callableFactory.createUnaryCallable(
            createExadbVmClusterTransportSettings,
            settings.createExadbVmClusterSettings(),
            clientContext);
    this.createExadbVmClusterOperationCallable =
        callableFactory.createOperationCallable(
            createExadbVmClusterTransportSettings,
            settings.createExadbVmClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteExadbVmClusterCallable =
        callableFactory.createUnaryCallable(
            deleteExadbVmClusterTransportSettings,
            settings.deleteExadbVmClusterSettings(),
            clientContext);
    this.deleteExadbVmClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteExadbVmClusterTransportSettings,
            settings.deleteExadbVmClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.updateExadbVmClusterCallable =
        callableFactory.createUnaryCallable(
            updateExadbVmClusterTransportSettings,
            settings.updateExadbVmClusterSettings(),
            clientContext);
    this.updateExadbVmClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateExadbVmClusterTransportSettings,
            settings.updateExadbVmClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.removeVirtualMachineExadbVmClusterCallable =
        callableFactory.createUnaryCallable(
            removeVirtualMachineExadbVmClusterTransportSettings,
            settings.removeVirtualMachineExadbVmClusterSettings(),
            clientContext);
    this.removeVirtualMachineExadbVmClusterOperationCallable =
        callableFactory.createOperationCallable(
            removeVirtualMachineExadbVmClusterTransportSettings,
            settings.removeVirtualMachineExadbVmClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.listExascaleDbStorageVaultsCallable =
        callableFactory.createUnaryCallable(
            listExascaleDbStorageVaultsTransportSettings,
            settings.listExascaleDbStorageVaultsSettings(),
            clientContext);
    this.listExascaleDbStorageVaultsPagedCallable =
        callableFactory.createPagedCallable(
            listExascaleDbStorageVaultsTransportSettings,
            settings.listExascaleDbStorageVaultsSettings(),
            clientContext);
    this.getExascaleDbStorageVaultCallable =
        callableFactory.createUnaryCallable(
            getExascaleDbStorageVaultTransportSettings,
            settings.getExascaleDbStorageVaultSettings(),
            clientContext);
    this.createExascaleDbStorageVaultCallable =
        callableFactory.createUnaryCallable(
            createExascaleDbStorageVaultTransportSettings,
            settings.createExascaleDbStorageVaultSettings(),
            clientContext);
    this.createExascaleDbStorageVaultOperationCallable =
        callableFactory.createOperationCallable(
            createExascaleDbStorageVaultTransportSettings,
            settings.createExascaleDbStorageVaultOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteExascaleDbStorageVaultCallable =
        callableFactory.createUnaryCallable(
            deleteExascaleDbStorageVaultTransportSettings,
            settings.deleteExascaleDbStorageVaultSettings(),
            clientContext);
    this.deleteExascaleDbStorageVaultOperationCallable =
        callableFactory.createOperationCallable(
            deleteExascaleDbStorageVaultTransportSettings,
            settings.deleteExascaleDbStorageVaultOperationSettings(),
            clientContext,
            operationsStub);
    this.listDbSystemInitialStorageSizesCallable =
        callableFactory.createUnaryCallable(
            listDbSystemInitialStorageSizesTransportSettings,
            settings.listDbSystemInitialStorageSizesSettings(),
            clientContext);
    this.listDbSystemInitialStorageSizesPagedCallable =
        callableFactory.createPagedCallable(
            listDbSystemInitialStorageSizesTransportSettings,
            settings.listDbSystemInitialStorageSizesSettings(),
            clientContext);
    this.listDatabasesCallable =
        callableFactory.createUnaryCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
    this.listDatabasesPagedCallable =
        callableFactory.createPagedCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
    this.getDatabaseCallable =
        callableFactory.createUnaryCallable(
            getDatabaseTransportSettings, settings.getDatabaseSettings(), clientContext);
    this.listPluggableDatabasesCallable =
        callableFactory.createUnaryCallable(
            listPluggableDatabasesTransportSettings,
            settings.listPluggableDatabasesSettings(),
            clientContext);
    this.listPluggableDatabasesPagedCallable =
        callableFactory.createPagedCallable(
            listPluggableDatabasesTransportSettings,
            settings.listPluggableDatabasesSettings(),
            clientContext);
    this.getPluggableDatabaseCallable =
        callableFactory.createUnaryCallable(
            getPluggableDatabaseTransportSettings,
            settings.getPluggableDatabaseSettings(),
            clientContext);
    this.listDbSystemsCallable =
        callableFactory.createUnaryCallable(
            listDbSystemsTransportSettings, settings.listDbSystemsSettings(), clientContext);
    this.listDbSystemsPagedCallable =
        callableFactory.createPagedCallable(
            listDbSystemsTransportSettings, settings.listDbSystemsSettings(), clientContext);
    this.getDbSystemCallable =
        callableFactory.createUnaryCallable(
            getDbSystemTransportSettings, settings.getDbSystemSettings(), clientContext);
    this.createDbSystemCallable =
        callableFactory.createUnaryCallable(
            createDbSystemTransportSettings, settings.createDbSystemSettings(), clientContext);
    this.createDbSystemOperationCallable =
        callableFactory.createOperationCallable(
            createDbSystemTransportSettings,
            settings.createDbSystemOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDbSystemCallable =
        callableFactory.createUnaryCallable(
            deleteDbSystemTransportSettings, settings.deleteDbSystemSettings(), clientContext);
    this.deleteDbSystemOperationCallable =
        callableFactory.createOperationCallable(
            deleteDbSystemTransportSettings,
            settings.deleteDbSystemOperationSettings(),
            clientContext,
            operationsStub);
    this.listDbVersionsCallable =
        callableFactory.createUnaryCallable(
            listDbVersionsTransportSettings, settings.listDbVersionsSettings(), clientContext);
    this.listDbVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listDbVersionsTransportSettings, settings.listDbVersionsSettings(), clientContext);
    this.listDatabaseCharacterSetsCallable =
        callableFactory.createUnaryCallable(
            listDatabaseCharacterSetsTransportSettings,
            settings.listDatabaseCharacterSetsSettings(),
            clientContext);
    this.listDatabaseCharacterSetsPagedCallable =
        callableFactory.createPagedCallable(
            listDatabaseCharacterSetsTransportSettings,
            settings.listDatabaseCharacterSetsSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<
          ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresResponse>
      listCloudExadataInfrastructuresCallable() {
    return listCloudExadataInfrastructuresCallable;
  }

  @Override
  public UnaryCallable<
          ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresPagedResponse>
      listCloudExadataInfrastructuresPagedCallable() {
    return listCloudExadataInfrastructuresPagedCallable;
  }

  @Override
  public UnaryCallable<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
      getCloudExadataInfrastructureCallable() {
    return getCloudExadataInfrastructureCallable;
  }

  @Override
  public UnaryCallable<CreateCloudExadataInfrastructureRequest, Operation>
      createCloudExadataInfrastructureCallable() {
    return createCloudExadataInfrastructureCallable;
  }

  @Override
  public OperationCallable<
          CreateCloudExadataInfrastructureRequest, CloudExadataInfrastructure, OperationMetadata>
      createCloudExadataInfrastructureOperationCallable() {
    return createCloudExadataInfrastructureOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCloudExadataInfrastructureRequest, Operation>
      deleteCloudExadataInfrastructureCallable() {
    return deleteCloudExadataInfrastructureCallable;
  }

  @Override
  public OperationCallable<DeleteCloudExadataInfrastructureRequest, Empty, OperationMetadata>
      deleteCloudExadataInfrastructureOperationCallable() {
    return deleteCloudExadataInfrastructureOperationCallable;
  }

  @Override
  public UnaryCallable<ListCloudVmClustersRequest, ListCloudVmClustersResponse>
      listCloudVmClustersCallable() {
    return listCloudVmClustersCallable;
  }

  @Override
  public UnaryCallable<ListCloudVmClustersRequest, ListCloudVmClustersPagedResponse>
      listCloudVmClustersPagedCallable() {
    return listCloudVmClustersPagedCallable;
  }

  @Override
  public UnaryCallable<GetCloudVmClusterRequest, CloudVmCluster> getCloudVmClusterCallable() {
    return getCloudVmClusterCallable;
  }

  @Override
  public UnaryCallable<CreateCloudVmClusterRequest, Operation> createCloudVmClusterCallable() {
    return createCloudVmClusterCallable;
  }

  @Override
  public OperationCallable<CreateCloudVmClusterRequest, CloudVmCluster, OperationMetadata>
      createCloudVmClusterOperationCallable() {
    return createCloudVmClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCloudVmClusterRequest, Operation> deleteCloudVmClusterCallable() {
    return deleteCloudVmClusterCallable;
  }

  @Override
  public OperationCallable<DeleteCloudVmClusterRequest, Empty, OperationMetadata>
      deleteCloudVmClusterOperationCallable() {
    return deleteCloudVmClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsCallable() {
    return listEntitlementsCallable;
  }

  @Override
  public UnaryCallable<ListEntitlementsRequest, ListEntitlementsPagedResponse>
      listEntitlementsPagedCallable() {
    return listEntitlementsPagedCallable;
  }

  @Override
  public UnaryCallable<ListDbServersRequest, ListDbServersResponse> listDbServersCallable() {
    return listDbServersCallable;
  }

  @Override
  public UnaryCallable<ListDbServersRequest, ListDbServersPagedResponse>
      listDbServersPagedCallable() {
    return listDbServersPagedCallable;
  }

  @Override
  public UnaryCallable<ListDbNodesRequest, ListDbNodesResponse> listDbNodesCallable() {
    return listDbNodesCallable;
  }

  @Override
  public UnaryCallable<ListDbNodesRequest, ListDbNodesPagedResponse> listDbNodesPagedCallable() {
    return listDbNodesPagedCallable;
  }

  @Override
  public UnaryCallable<ListGiVersionsRequest, ListGiVersionsResponse> listGiVersionsCallable() {
    return listGiVersionsCallable;
  }

  @Override
  public UnaryCallable<ListGiVersionsRequest, ListGiVersionsPagedResponse>
      listGiVersionsPagedCallable() {
    return listGiVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<ListMinorVersionsRequest, ListMinorVersionsResponse>
      listMinorVersionsCallable() {
    return listMinorVersionsCallable;
  }

  @Override
  public UnaryCallable<ListMinorVersionsRequest, ListMinorVersionsPagedResponse>
      listMinorVersionsPagedCallable() {
    return listMinorVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<ListDbSystemShapesRequest, ListDbSystemShapesResponse>
      listDbSystemShapesCallable() {
    return listDbSystemShapesCallable;
  }

  @Override
  public UnaryCallable<ListDbSystemShapesRequest, ListDbSystemShapesPagedResponse>
      listDbSystemShapesPagedCallable() {
    return listDbSystemShapesPagedCallable;
  }

  @Override
  public UnaryCallable<ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse>
      listAutonomousDatabasesCallable() {
    return listAutonomousDatabasesCallable;
  }

  @Override
  public UnaryCallable<ListAutonomousDatabasesRequest, ListAutonomousDatabasesPagedResponse>
      listAutonomousDatabasesPagedCallable() {
    return listAutonomousDatabasesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAutonomousDatabaseRequest, AutonomousDatabase>
      getAutonomousDatabaseCallable() {
    return getAutonomousDatabaseCallable;
  }

  @Override
  public UnaryCallable<CreateAutonomousDatabaseRequest, Operation>
      createAutonomousDatabaseCallable() {
    return createAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<CreateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      createAutonomousDatabaseOperationCallable() {
    return createAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAutonomousDatabaseRequest, Operation>
      updateAutonomousDatabaseCallable() {
    return updateAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<UpdateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      updateAutonomousDatabaseOperationCallable() {
    return updateAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAutonomousDatabaseRequest, Operation>
      deleteAutonomousDatabaseCallable() {
    return deleteAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<DeleteAutonomousDatabaseRequest, Empty, OperationMetadata>
      deleteAutonomousDatabaseOperationCallable() {
    return deleteAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<RestoreAutonomousDatabaseRequest, Operation>
      restoreAutonomousDatabaseCallable() {
    return restoreAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<RestoreAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restoreAutonomousDatabaseOperationCallable() {
    return restoreAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<
          GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
      generateAutonomousDatabaseWalletCallable() {
    return generateAutonomousDatabaseWalletCallable;
  }

  @Override
  public UnaryCallable<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse>
      listAutonomousDbVersionsCallable() {
    return listAutonomousDbVersionsCallable;
  }

  @Override
  public UnaryCallable<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsPagedResponse>
      listAutonomousDbVersionsPagedCallable() {
    return listAutonomousDbVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListAutonomousDatabaseCharacterSetsRequest, ListAutonomousDatabaseCharacterSetsResponse>
      listAutonomousDatabaseCharacterSetsCallable() {
    return listAutonomousDatabaseCharacterSetsCallable;
  }

  @Override
  public UnaryCallable<
          ListAutonomousDatabaseCharacterSetsRequest,
          ListAutonomousDatabaseCharacterSetsPagedResponse>
      listAutonomousDatabaseCharacterSetsPagedCallable() {
    return listAutonomousDatabaseCharacterSetsPagedCallable;
  }

  @Override
  public UnaryCallable<ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsResponse>
      listAutonomousDatabaseBackupsCallable() {
    return listAutonomousDatabaseBackupsCallable;
  }

  @Override
  public UnaryCallable<
          ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsPagedResponse>
      listAutonomousDatabaseBackupsPagedCallable() {
    return listAutonomousDatabaseBackupsPagedCallable;
  }

  @Override
  public UnaryCallable<StopAutonomousDatabaseRequest, Operation> stopAutonomousDatabaseCallable() {
    return stopAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<StopAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      stopAutonomousDatabaseOperationCallable() {
    return stopAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<StartAutonomousDatabaseRequest, Operation>
      startAutonomousDatabaseCallable() {
    return startAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<StartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      startAutonomousDatabaseOperationCallable() {
    return startAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<RestartAutonomousDatabaseRequest, Operation>
      restartAutonomousDatabaseCallable() {
    return restartAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<RestartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restartAutonomousDatabaseOperationCallable() {
    return restartAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<SwitchoverAutonomousDatabaseRequest, Operation>
      switchoverAutonomousDatabaseCallable() {
    return switchoverAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<
          SwitchoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      switchoverAutonomousDatabaseOperationCallable() {
    return switchoverAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<FailoverAutonomousDatabaseRequest, Operation>
      failoverAutonomousDatabaseCallable() {
    return failoverAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<FailoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      failoverAutonomousDatabaseOperationCallable() {
    return failoverAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<ListOdbNetworksRequest, ListOdbNetworksResponse> listOdbNetworksCallable() {
    return listOdbNetworksCallable;
  }

  @Override
  public UnaryCallable<ListOdbNetworksRequest, ListOdbNetworksPagedResponse>
      listOdbNetworksPagedCallable() {
    return listOdbNetworksPagedCallable;
  }

  @Override
  public UnaryCallable<GetOdbNetworkRequest, OdbNetwork> getOdbNetworkCallable() {
    return getOdbNetworkCallable;
  }

  @Override
  public UnaryCallable<CreateOdbNetworkRequest, Operation> createOdbNetworkCallable() {
    return createOdbNetworkCallable;
  }

  @Override
  public OperationCallable<CreateOdbNetworkRequest, OdbNetwork, OperationMetadata>
      createOdbNetworkOperationCallable() {
    return createOdbNetworkOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteOdbNetworkRequest, Operation> deleteOdbNetworkCallable() {
    return deleteOdbNetworkCallable;
  }

  @Override
  public OperationCallable<DeleteOdbNetworkRequest, Empty, OperationMetadata>
      deleteOdbNetworkOperationCallable() {
    return deleteOdbNetworkOperationCallable;
  }

  @Override
  public UnaryCallable<ListOdbSubnetsRequest, ListOdbSubnetsResponse> listOdbSubnetsCallable() {
    return listOdbSubnetsCallable;
  }

  @Override
  public UnaryCallable<ListOdbSubnetsRequest, ListOdbSubnetsPagedResponse>
      listOdbSubnetsPagedCallable() {
    return listOdbSubnetsPagedCallable;
  }

  @Override
  public UnaryCallable<GetOdbSubnetRequest, OdbSubnet> getOdbSubnetCallable() {
    return getOdbSubnetCallable;
  }

  @Override
  public UnaryCallable<CreateOdbSubnetRequest, Operation> createOdbSubnetCallable() {
    return createOdbSubnetCallable;
  }

  @Override
  public OperationCallable<CreateOdbSubnetRequest, OdbSubnet, OperationMetadata>
      createOdbSubnetOperationCallable() {
    return createOdbSubnetOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteOdbSubnetRequest, Operation> deleteOdbSubnetCallable() {
    return deleteOdbSubnetCallable;
  }

  @Override
  public OperationCallable<DeleteOdbSubnetRequest, Empty, OperationMetadata>
      deleteOdbSubnetOperationCallable() {
    return deleteOdbSubnetOperationCallable;
  }

  @Override
  public UnaryCallable<ListExadbVmClustersRequest, ListExadbVmClustersResponse>
      listExadbVmClustersCallable() {
    return listExadbVmClustersCallable;
  }

  @Override
  public UnaryCallable<ListExadbVmClustersRequest, ListExadbVmClustersPagedResponse>
      listExadbVmClustersPagedCallable() {
    return listExadbVmClustersPagedCallable;
  }

  @Override
  public UnaryCallable<GetExadbVmClusterRequest, ExadbVmCluster> getExadbVmClusterCallable() {
    return getExadbVmClusterCallable;
  }

  @Override
  public UnaryCallable<CreateExadbVmClusterRequest, Operation> createExadbVmClusterCallable() {
    return createExadbVmClusterCallable;
  }

  @Override
  public OperationCallable<CreateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      createExadbVmClusterOperationCallable() {
    return createExadbVmClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteExadbVmClusterRequest, Operation> deleteExadbVmClusterCallable() {
    return deleteExadbVmClusterCallable;
  }

  @Override
  public OperationCallable<DeleteExadbVmClusterRequest, Empty, OperationMetadata>
      deleteExadbVmClusterOperationCallable() {
    return deleteExadbVmClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateExadbVmClusterRequest, Operation> updateExadbVmClusterCallable() {
    return updateExadbVmClusterCallable;
  }

  @Override
  public OperationCallable<UpdateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      updateExadbVmClusterOperationCallable() {
    return updateExadbVmClusterOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveVirtualMachineExadbVmClusterRequest, Operation>
      removeVirtualMachineExadbVmClusterCallable() {
    return removeVirtualMachineExadbVmClusterCallable;
  }

  @Override
  public OperationCallable<
          RemoveVirtualMachineExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      removeVirtualMachineExadbVmClusterOperationCallable() {
    return removeVirtualMachineExadbVmClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsResponse>
      listExascaleDbStorageVaultsCallable() {
    return listExascaleDbStorageVaultsCallable;
  }

  @Override
  public UnaryCallable<ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsPagedResponse>
      listExascaleDbStorageVaultsPagedCallable() {
    return listExascaleDbStorageVaultsPagedCallable;
  }

  @Override
  public UnaryCallable<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
      getExascaleDbStorageVaultCallable() {
    return getExascaleDbStorageVaultCallable;
  }

  @Override
  public UnaryCallable<CreateExascaleDbStorageVaultRequest, Operation>
      createExascaleDbStorageVaultCallable() {
    return createExascaleDbStorageVaultCallable;
  }

  @Override
  public OperationCallable<
          CreateExascaleDbStorageVaultRequest, ExascaleDbStorageVault, OperationMetadata>
      createExascaleDbStorageVaultOperationCallable() {
    return createExascaleDbStorageVaultOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteExascaleDbStorageVaultRequest, Operation>
      deleteExascaleDbStorageVaultCallable() {
    return deleteExascaleDbStorageVaultCallable;
  }

  @Override
  public OperationCallable<DeleteExascaleDbStorageVaultRequest, Empty, OperationMetadata>
      deleteExascaleDbStorageVaultOperationCallable() {
    return deleteExascaleDbStorageVaultOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesResponse>
      listDbSystemInitialStorageSizesCallable() {
    return listDbSystemInitialStorageSizesCallable;
  }

  @Override
  public UnaryCallable<
          ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesPagedResponse>
      listDbSystemInitialStorageSizesPagedCallable() {
    return listDbSystemInitialStorageSizesPagedCallable;
  }

  @Override
  public UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable() {
    return listDatabasesCallable;
  }

  @Override
  public UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable() {
    return listDatabasesPagedCallable;
  }

  @Override
  public UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable() {
    return getDatabaseCallable;
  }

  @Override
  public UnaryCallable<ListPluggableDatabasesRequest, ListPluggableDatabasesResponse>
      listPluggableDatabasesCallable() {
    return listPluggableDatabasesCallable;
  }

  @Override
  public UnaryCallable<ListPluggableDatabasesRequest, ListPluggableDatabasesPagedResponse>
      listPluggableDatabasesPagedCallable() {
    return listPluggableDatabasesPagedCallable;
  }

  @Override
  public UnaryCallable<GetPluggableDatabaseRequest, PluggableDatabase>
      getPluggableDatabaseCallable() {
    return getPluggableDatabaseCallable;
  }

  @Override
  public UnaryCallable<ListDbSystemsRequest, ListDbSystemsResponse> listDbSystemsCallable() {
    return listDbSystemsCallable;
  }

  @Override
  public UnaryCallable<ListDbSystemsRequest, ListDbSystemsPagedResponse>
      listDbSystemsPagedCallable() {
    return listDbSystemsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDbSystemRequest, DbSystem> getDbSystemCallable() {
    return getDbSystemCallable;
  }

  @Override
  public UnaryCallable<CreateDbSystemRequest, Operation> createDbSystemCallable() {
    return createDbSystemCallable;
  }

  @Override
  public OperationCallable<CreateDbSystemRequest, DbSystem, OperationMetadata>
      createDbSystemOperationCallable() {
    return createDbSystemOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDbSystemRequest, Operation> deleteDbSystemCallable() {
    return deleteDbSystemCallable;
  }

  @Override
  public OperationCallable<DeleteDbSystemRequest, Empty, OperationMetadata>
      deleteDbSystemOperationCallable() {
    return deleteDbSystemOperationCallable;
  }

  @Override
  public UnaryCallable<ListDbVersionsRequest, ListDbVersionsResponse> listDbVersionsCallable() {
    return listDbVersionsCallable;
  }

  @Override
  public UnaryCallable<ListDbVersionsRequest, ListDbVersionsPagedResponse>
      listDbVersionsPagedCallable() {
    return listDbVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse>
      listDatabaseCharacterSetsCallable() {
    return listDatabaseCharacterSetsCallable;
  }

  @Override
  public UnaryCallable<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsPagedResponse>
      listDatabaseCharacterSetsPagedCallable() {
    return listDatabaseCharacterSetsPagedCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
