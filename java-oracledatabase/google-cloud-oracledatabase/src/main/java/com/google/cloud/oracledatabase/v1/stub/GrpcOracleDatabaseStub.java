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
              .build();

  private static final MethodDescriptor<GetCloudVmClusterRequest, CloudVmCluster>
      getCloudVmClusterMethodDescriptor =
          MethodDescriptor.<GetCloudVmClusterRequest, CloudVmCluster>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/GetCloudVmCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCloudVmClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CloudVmCluster.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<ListDbNodesRequest, ListDbNodesResponse>
      listDbNodesMethodDescriptor =
          MethodDescriptor.<ListDbNodesRequest, ListDbNodesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListDbNodes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListDbNodesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDbNodesResponse.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
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
