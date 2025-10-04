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

package com.google.cloud.alloydb.v1alpha.stub;

import static com.google.cloud.alloydb.v1alpha.AlloyDBAdminClient.ListBackupsPagedResponse;
import static com.google.cloud.alloydb.v1alpha.AlloyDBAdminClient.ListClustersPagedResponse;
import static com.google.cloud.alloydb.v1alpha.AlloyDBAdminClient.ListDatabasesPagedResponse;
import static com.google.cloud.alloydb.v1alpha.AlloyDBAdminClient.ListInstancesPagedResponse;
import static com.google.cloud.alloydb.v1alpha.AlloyDBAdminClient.ListLocationsPagedResponse;
import static com.google.cloud.alloydb.v1alpha.AlloyDBAdminClient.ListSupportedDatabaseFlagsPagedResponse;
import static com.google.cloud.alloydb.v1alpha.AlloyDBAdminClient.ListUsersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.alloydb.v1alpha.Backup;
import com.google.cloud.alloydb.v1alpha.BatchCreateInstancesRequest;
import com.google.cloud.alloydb.v1alpha.BatchCreateInstancesResponse;
import com.google.cloud.alloydb.v1alpha.Cluster;
import com.google.cloud.alloydb.v1alpha.ConnectionInfo;
import com.google.cloud.alloydb.v1alpha.CreateBackupRequest;
import com.google.cloud.alloydb.v1alpha.CreateClusterRequest;
import com.google.cloud.alloydb.v1alpha.CreateInstanceRequest;
import com.google.cloud.alloydb.v1alpha.CreateSecondaryClusterRequest;
import com.google.cloud.alloydb.v1alpha.CreateSecondaryInstanceRequest;
import com.google.cloud.alloydb.v1alpha.CreateUserRequest;
import com.google.cloud.alloydb.v1alpha.DeleteBackupRequest;
import com.google.cloud.alloydb.v1alpha.DeleteClusterRequest;
import com.google.cloud.alloydb.v1alpha.DeleteInstanceRequest;
import com.google.cloud.alloydb.v1alpha.DeleteUserRequest;
import com.google.cloud.alloydb.v1alpha.ExecuteSqlRequest;
import com.google.cloud.alloydb.v1alpha.ExecuteSqlResponse;
import com.google.cloud.alloydb.v1alpha.ExportClusterRequest;
import com.google.cloud.alloydb.v1alpha.ExportClusterResponse;
import com.google.cloud.alloydb.v1alpha.FailoverInstanceRequest;
import com.google.cloud.alloydb.v1alpha.GenerateClientCertificateRequest;
import com.google.cloud.alloydb.v1alpha.GenerateClientCertificateResponse;
import com.google.cloud.alloydb.v1alpha.GetBackupRequest;
import com.google.cloud.alloydb.v1alpha.GetClusterRequest;
import com.google.cloud.alloydb.v1alpha.GetConnectionInfoRequest;
import com.google.cloud.alloydb.v1alpha.GetInstanceRequest;
import com.google.cloud.alloydb.v1alpha.GetUserRequest;
import com.google.cloud.alloydb.v1alpha.ImportClusterRequest;
import com.google.cloud.alloydb.v1alpha.ImportClusterResponse;
import com.google.cloud.alloydb.v1alpha.InjectFaultRequest;
import com.google.cloud.alloydb.v1alpha.Instance;
import com.google.cloud.alloydb.v1alpha.ListBackupsRequest;
import com.google.cloud.alloydb.v1alpha.ListBackupsResponse;
import com.google.cloud.alloydb.v1alpha.ListClustersRequest;
import com.google.cloud.alloydb.v1alpha.ListClustersResponse;
import com.google.cloud.alloydb.v1alpha.ListDatabasesRequest;
import com.google.cloud.alloydb.v1alpha.ListDatabasesResponse;
import com.google.cloud.alloydb.v1alpha.ListInstancesRequest;
import com.google.cloud.alloydb.v1alpha.ListInstancesResponse;
import com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsRequest;
import com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsResponse;
import com.google.cloud.alloydb.v1alpha.ListUsersRequest;
import com.google.cloud.alloydb.v1alpha.ListUsersResponse;
import com.google.cloud.alloydb.v1alpha.OperationMetadata;
import com.google.cloud.alloydb.v1alpha.PromoteClusterRequest;
import com.google.cloud.alloydb.v1alpha.RestartInstanceRequest;
import com.google.cloud.alloydb.v1alpha.RestoreClusterRequest;
import com.google.cloud.alloydb.v1alpha.SwitchoverClusterRequest;
import com.google.cloud.alloydb.v1alpha.UpdateBackupRequest;
import com.google.cloud.alloydb.v1alpha.UpdateClusterRequest;
import com.google.cloud.alloydb.v1alpha.UpdateInstanceRequest;
import com.google.cloud.alloydb.v1alpha.UpdateUserRequest;
import com.google.cloud.alloydb.v1alpha.UpgradeClusterRequest;
import com.google.cloud.alloydb.v1alpha.UpgradeClusterResponse;
import com.google.cloud.alloydb.v1alpha.User;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * gRPC stub implementation for the AlloyDBAdmin service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAlloyDBAdminStub extends AlloyDBAdminStub {
  private static final MethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          MethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ListClusters")
              .setRequestMarshaller(ProtoUtils.marshaller(ListClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListClustersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetClusterRequest, Cluster> getClusterMethodDescriptor =
      MethodDescriptor.<GetClusterRequest, Cluster>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/GetCluster")
          .setRequestMarshaller(ProtoUtils.marshaller(GetClusterRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Cluster.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateClusterRequest, Operation>
      createClusterMethodDescriptor =
          MethodDescriptor.<CreateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/CreateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateClusterRequest, Operation>
      updateClusterMethodDescriptor =
          MethodDescriptor.<UpdateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/UpdateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportClusterRequest, Operation>
      exportClusterMethodDescriptor =
          MethodDescriptor.<ExportClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ExportCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ImportClusterRequest, Operation>
      importClusterMethodDescriptor =
          MethodDescriptor.<ImportClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ImportCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpgradeClusterRequest, Operation>
      upgradeClusterMethodDescriptor =
          MethodDescriptor.<UpgradeClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/UpgradeCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpgradeClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteClusterRequest, Operation>
      deleteClusterMethodDescriptor =
          MethodDescriptor.<DeleteClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/DeleteCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<PromoteClusterRequest, Operation>
      promoteClusterMethodDescriptor =
          MethodDescriptor.<PromoteClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/PromoteCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PromoteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SwitchoverClusterRequest, Operation>
      switchoverClusterMethodDescriptor =
          MethodDescriptor.<SwitchoverClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/SwitchoverCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SwitchoverClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RestoreClusterRequest, Operation>
      restoreClusterMethodDescriptor =
          MethodDescriptor.<RestoreClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/RestoreCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestoreClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateSecondaryClusterRequest, Operation>
      createSecondaryClusterMethodDescriptor =
          MethodDescriptor.<CreateSecondaryClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/CreateSecondaryCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSecondaryClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          MethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ListInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetInstanceRequest, Instance> getInstanceMethodDescriptor =
      MethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/GetInstance")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          MethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/CreateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateSecondaryInstanceRequest, Operation>
      createSecondaryInstanceMethodDescriptor =
          MethodDescriptor.<CreateSecondaryInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.alloydb.v1alpha.AlloyDBAdmin/CreateSecondaryInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSecondaryInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BatchCreateInstancesRequest, Operation>
      batchCreateInstancesMethodDescriptor =
          MethodDescriptor.<BatchCreateInstancesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/BatchCreateInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateInstanceRequest, Operation>
      updateInstanceMethodDescriptor =
          MethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/UpdateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          MethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/DeleteInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<FailoverInstanceRequest, Operation>
      failoverInstanceMethodDescriptor =
          MethodDescriptor.<FailoverInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/FailoverInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FailoverInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<InjectFaultRequest, Operation> injectFaultMethodDescriptor =
      MethodDescriptor.<InjectFaultRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/InjectFault")
          .setRequestMarshaller(ProtoUtils.marshaller(InjectFaultRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<RestartInstanceRequest, Operation>
      restartInstanceMethodDescriptor =
          MethodDescriptor.<RestartInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/RestartInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestartInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExecuteSqlRequest, ExecuteSqlResponse>
      executeSqlMethodDescriptor =
          MethodDescriptor.<ExecuteSqlRequest, ExecuteSqlResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ExecuteSql")
              .setRequestMarshaller(ProtoUtils.marshaller(ExecuteSqlRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ExecuteSqlResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          MethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ListBackups")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBackupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBackupRequest, Backup> getBackupMethodDescriptor =
      MethodDescriptor.<GetBackupRequest, Backup>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/GetBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Backup.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateBackupRequest, Operation>
      createBackupMethodDescriptor =
          MethodDescriptor.<CreateBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/CreateBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBackupRequest, Operation>
      updateBackupMethodDescriptor =
          MethodDescriptor.<UpdateBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/UpdateBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteBackupRequest, Operation>
      deleteBackupMethodDescriptor =
          MethodDescriptor.<DeleteBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/DeleteBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsResponse>
      listSupportedDatabaseFlagsMethodDescriptor =
          MethodDescriptor
              .<ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.alloydb.v1alpha.AlloyDBAdmin/ListSupportedDatabaseFlags")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSupportedDatabaseFlagsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSupportedDatabaseFlagsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GenerateClientCertificateRequest, GenerateClientCertificateResponse>
      generateClientCertificateMethodDescriptor =
          MethodDescriptor
              .<GenerateClientCertificateRequest, GenerateClientCertificateResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.alloydb.v1alpha.AlloyDBAdmin/GenerateClientCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateClientCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateClientCertificateResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetConnectionInfoRequest, ConnectionInfo>
      getConnectionInfoMethodDescriptor =
          MethodDescriptor.<GetConnectionInfoRequest, ConnectionInfo>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/GetConnectionInfo")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConnectionInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConnectionInfo.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListUsersRequest, ListUsersResponse>
      listUsersMethodDescriptor =
          MethodDescriptor.<ListUsersRequest, ListUsersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ListUsers")
              .setRequestMarshaller(ProtoUtils.marshaller(ListUsersRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListUsersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetUserRequest, User> getUserMethodDescriptor =
      MethodDescriptor.<GetUserRequest, User>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/GetUser")
          .setRequestMarshaller(ProtoUtils.marshaller(GetUserRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(User.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateUserRequest, User> createUserMethodDescriptor =
      MethodDescriptor.<CreateUserRequest, User>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/CreateUser")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateUserRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(User.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateUserRequest, User> updateUserMethodDescriptor =
      MethodDescriptor.<UpdateUserRequest, User>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/UpdateUser")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateUserRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(User.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteUserRequest, Empty> deleteUserMethodDescriptor =
      MethodDescriptor.<DeleteUserRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/DeleteUser")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteUserRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListDatabasesRequest, ListDatabasesResponse>
      listDatabasesMethodDescriptor =
          MethodDescriptor.<ListDatabasesRequest, ListDatabasesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ListDatabases")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDatabasesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatabasesResponse.getDefaultInstance()))
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

  private final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable;
  private final UnaryCallable<ListClustersRequest, ListClustersPagedResponse>
      listClustersPagedCallable;
  private final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable;
  private final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable;
  private final OperationCallable<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationCallable;
  private final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable;
  private final OperationCallable<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationCallable;
  private final UnaryCallable<ExportClusterRequest, Operation> exportClusterCallable;
  private final OperationCallable<ExportClusterRequest, ExportClusterResponse, OperationMetadata>
      exportClusterOperationCallable;
  private final UnaryCallable<ImportClusterRequest, Operation> importClusterCallable;
  private final OperationCallable<ImportClusterRequest, ImportClusterResponse, OperationMetadata>
      importClusterOperationCallable;
  private final UnaryCallable<UpgradeClusterRequest, Operation> upgradeClusterCallable;
  private final OperationCallable<UpgradeClusterRequest, UpgradeClusterResponse, OperationMetadata>
      upgradeClusterOperationCallable;
  private final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable;
  private final OperationCallable<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationCallable;
  private final UnaryCallable<PromoteClusterRequest, Operation> promoteClusterCallable;
  private final OperationCallable<PromoteClusterRequest, Cluster, OperationMetadata>
      promoteClusterOperationCallable;
  private final UnaryCallable<SwitchoverClusterRequest, Operation> switchoverClusterCallable;
  private final OperationCallable<SwitchoverClusterRequest, Cluster, OperationMetadata>
      switchoverClusterOperationCallable;
  private final UnaryCallable<RestoreClusterRequest, Operation> restoreClusterCallable;
  private final OperationCallable<RestoreClusterRequest, Cluster, OperationMetadata>
      restoreClusterOperationCallable;
  private final UnaryCallable<CreateSecondaryClusterRequest, Operation>
      createSecondaryClusterCallable;
  private final OperationCallable<CreateSecondaryClusterRequest, Cluster, OperationMetadata>
      createSecondaryClusterOperationCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable;
  private final UnaryCallable<CreateSecondaryInstanceRequest, Operation>
      createSecondaryInstanceCallable;
  private final OperationCallable<CreateSecondaryInstanceRequest, Instance, OperationMetadata>
      createSecondaryInstanceOperationCallable;
  private final UnaryCallable<BatchCreateInstancesRequest, Operation> batchCreateInstancesCallable;
  private final OperationCallable<
          BatchCreateInstancesRequest, BatchCreateInstancesResponse, OperationMetadata>
      batchCreateInstancesOperationCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable;
  private final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable;
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable;
  private final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable;
  private final UnaryCallable<FailoverInstanceRequest, Operation> failoverInstanceCallable;
  private final OperationCallable<FailoverInstanceRequest, Instance, OperationMetadata>
      failoverInstanceOperationCallable;
  private final UnaryCallable<InjectFaultRequest, Operation> injectFaultCallable;
  private final OperationCallable<InjectFaultRequest, Instance, OperationMetadata>
      injectFaultOperationCallable;
  private final UnaryCallable<RestartInstanceRequest, Operation> restartInstanceCallable;
  private final OperationCallable<RestartInstanceRequest, Instance, OperationMetadata>
      restartInstanceOperationCallable;
  private final UnaryCallable<ExecuteSqlRequest, ExecuteSqlResponse> executeSqlCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable;
  private final OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable;
  private final UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable;
  private final OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable;
  private final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable;
  private final OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable;
  private final UnaryCallable<ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsResponse>
      listSupportedDatabaseFlagsCallable;
  private final UnaryCallable<
          ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsPagedResponse>
      listSupportedDatabaseFlagsPagedCallable;
  private final UnaryCallable<GenerateClientCertificateRequest, GenerateClientCertificateResponse>
      generateClientCertificateCallable;
  private final UnaryCallable<GetConnectionInfoRequest, ConnectionInfo> getConnectionInfoCallable;
  private final UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable;
  private final UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable;
  private final UnaryCallable<GetUserRequest, User> getUserCallable;
  private final UnaryCallable<CreateUserRequest, User> createUserCallable;
  private final UnaryCallable<UpdateUserRequest, User> updateUserCallable;
  private final UnaryCallable<DeleteUserRequest, Empty> deleteUserCallable;
  private final UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable;
  private final UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAlloyDBAdminStub create(AlloyDBAdminStubSettings settings)
      throws IOException {
    return new GrpcAlloyDBAdminStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAlloyDBAdminStub create(ClientContext clientContext) throws IOException {
    return new GrpcAlloyDBAdminStub(AlloyDBAdminStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAlloyDBAdminStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAlloyDBAdminStub(
        AlloyDBAdminStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAlloyDBAdminStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAlloyDBAdminStub(AlloyDBAdminStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAlloyDBAdminCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAlloyDBAdminStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAlloyDBAdminStub(
      AlloyDBAdminStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListClustersRequest, ListClustersResponse> listClustersTransportSettings =
        GrpcCallSettings.<ListClustersRequest, ListClustersResponse>newBuilder()
            .setMethodDescriptor(listClustersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetClusterRequest, Cluster> getClusterTransportSettings =
        GrpcCallSettings.<GetClusterRequest, Cluster>newBuilder()
            .setMethodDescriptor(getClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateClusterRequest, Operation> createClusterTransportSettings =
        GrpcCallSettings.<CreateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateClusterRequest, Operation> updateClusterTransportSettings =
        GrpcCallSettings.<UpdateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster.name", String.valueOf(request.getCluster().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportClusterRequest, Operation> exportClusterTransportSettings =
        GrpcCallSettings.<ExportClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(exportClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportClusterRequest, Operation> importClusterTransportSettings =
        GrpcCallSettings.<ImportClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(importClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpgradeClusterRequest, Operation> upgradeClusterTransportSettings =
        GrpcCallSettings.<UpgradeClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(upgradeClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteClusterRequest, Operation> deleteClusterTransportSettings =
        GrpcCallSettings.<DeleteClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<PromoteClusterRequest, Operation> promoteClusterTransportSettings =
        GrpcCallSettings.<PromoteClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(promoteClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SwitchoverClusterRequest, Operation> switchoverClusterTransportSettings =
        GrpcCallSettings.<SwitchoverClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(switchoverClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RestoreClusterRequest, Operation> restoreClusterTransportSettings =
        GrpcCallSettings.<RestoreClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSecondaryClusterRequest, Operation>
        createSecondaryClusterTransportSettings =
            GrpcCallSettings.<CreateSecondaryClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(createSecondaryClusterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesTransportSettings =
        GrpcCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
            .setMethodDescriptor(listInstancesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        GrpcCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateInstanceRequest, Operation> createInstanceTransportSettings =
        GrpcCallSettings.<CreateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSecondaryInstanceRequest, Operation>
        createSecondaryInstanceTransportSettings =
            GrpcCallSettings.<CreateSecondaryInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(createSecondaryInstanceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BatchCreateInstancesRequest, Operation> batchCreateInstancesTransportSettings =
        GrpcCallSettings.<BatchCreateInstancesRequest, Operation>newBuilder()
            .setMethodDescriptor(batchCreateInstancesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateInstanceRequest, Operation> updateInstanceTransportSettings =
        GrpcCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance.name", String.valueOf(request.getInstance().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        GrpcCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<FailoverInstanceRequest, Operation> failoverInstanceTransportSettings =
        GrpcCallSettings.<FailoverInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(failoverInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<InjectFaultRequest, Operation> injectFaultTransportSettings =
        GrpcCallSettings.<InjectFaultRequest, Operation>newBuilder()
            .setMethodDescriptor(injectFaultMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RestartInstanceRequest, Operation> restartInstanceTransportSettings =
        GrpcCallSettings.<RestartInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(restartInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExecuteSqlRequest, ExecuteSqlResponse> executeSqlTransportSettings =
        GrpcCallSettings.<ExecuteSqlRequest, ExecuteSqlResponse>newBuilder()
            .setMethodDescriptor(executeSqlMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListBackupsRequest, ListBackupsResponse> listBackupsTransportSettings =
        GrpcCallSettings.<ListBackupsRequest, ListBackupsResponse>newBuilder()
            .setMethodDescriptor(listBackupsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetBackupRequest, Backup> getBackupTransportSettings =
        GrpcCallSettings.<GetBackupRequest, Backup>newBuilder()
            .setMethodDescriptor(getBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateBackupRequest, Operation> createBackupTransportSettings =
        GrpcCallSettings.<CreateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateBackupRequest, Operation> updateBackupTransportSettings =
        GrpcCallSettings.<UpdateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("backup.name", String.valueOf(request.getBackup().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteBackupRequest, Operation> deleteBackupTransportSettings =
        GrpcCallSettings.<DeleteBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsResponse>
        listSupportedDatabaseFlagsTransportSettings =
            GrpcCallSettings
                .<ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsResponse>newBuilder()
                .setMethodDescriptor(listSupportedDatabaseFlagsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GenerateClientCertificateRequest, GenerateClientCertificateResponse>
        generateClientCertificateTransportSettings =
            GrpcCallSettings
                .<GenerateClientCertificateRequest, GenerateClientCertificateResponse>newBuilder()
                .setMethodDescriptor(generateClientCertificateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetConnectionInfoRequest, ConnectionInfo> getConnectionInfoTransportSettings =
        GrpcCallSettings.<GetConnectionInfoRequest, ConnectionInfo>newBuilder()
            .setMethodDescriptor(getConnectionInfoMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListUsersRequest, ListUsersResponse> listUsersTransportSettings =
        GrpcCallSettings.<ListUsersRequest, ListUsersResponse>newBuilder()
            .setMethodDescriptor(listUsersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetUserRequest, User> getUserTransportSettings =
        GrpcCallSettings.<GetUserRequest, User>newBuilder()
            .setMethodDescriptor(getUserMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateUserRequest, User> createUserTransportSettings =
        GrpcCallSettings.<CreateUserRequest, User>newBuilder()
            .setMethodDescriptor(createUserMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateUserRequest, User> updateUserTransportSettings =
        GrpcCallSettings.<UpdateUserRequest, User>newBuilder()
            .setMethodDescriptor(updateUserMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("user.name", String.valueOf(request.getUser().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteUserRequest, Empty> deleteUserTransportSettings =
        GrpcCallSettings.<DeleteUserRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUserMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
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

    this.listClustersCallable =
        callableFactory.createUnaryCallable(
            listClustersTransportSettings, settings.listClustersSettings(), clientContext);
    this.listClustersPagedCallable =
        callableFactory.createPagedCallable(
            listClustersTransportSettings, settings.listClustersSettings(), clientContext);
    this.getClusterCallable =
        callableFactory.createUnaryCallable(
            getClusterTransportSettings, settings.getClusterSettings(), clientContext);
    this.createClusterCallable =
        callableFactory.createUnaryCallable(
            createClusterTransportSettings, settings.createClusterSettings(), clientContext);
    this.createClusterOperationCallable =
        callableFactory.createOperationCallable(
            createClusterTransportSettings,
            settings.createClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.updateClusterCallable =
        callableFactory.createUnaryCallable(
            updateClusterTransportSettings, settings.updateClusterSettings(), clientContext);
    this.updateClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateClusterTransportSettings,
            settings.updateClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.exportClusterCallable =
        callableFactory.createUnaryCallable(
            exportClusterTransportSettings, settings.exportClusterSettings(), clientContext);
    this.exportClusterOperationCallable =
        callableFactory.createOperationCallable(
            exportClusterTransportSettings,
            settings.exportClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.importClusterCallable =
        callableFactory.createUnaryCallable(
            importClusterTransportSettings, settings.importClusterSettings(), clientContext);
    this.importClusterOperationCallable =
        callableFactory.createOperationCallable(
            importClusterTransportSettings,
            settings.importClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.upgradeClusterCallable =
        callableFactory.createUnaryCallable(
            upgradeClusterTransportSettings, settings.upgradeClusterSettings(), clientContext);
    this.upgradeClusterOperationCallable =
        callableFactory.createOperationCallable(
            upgradeClusterTransportSettings,
            settings.upgradeClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteClusterCallable =
        callableFactory.createUnaryCallable(
            deleteClusterTransportSettings, settings.deleteClusterSettings(), clientContext);
    this.deleteClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteClusterTransportSettings,
            settings.deleteClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.promoteClusterCallable =
        callableFactory.createUnaryCallable(
            promoteClusterTransportSettings, settings.promoteClusterSettings(), clientContext);
    this.promoteClusterOperationCallable =
        callableFactory.createOperationCallable(
            promoteClusterTransportSettings,
            settings.promoteClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.switchoverClusterCallable =
        callableFactory.createUnaryCallable(
            switchoverClusterTransportSettings,
            settings.switchoverClusterSettings(),
            clientContext);
    this.switchoverClusterOperationCallable =
        callableFactory.createOperationCallable(
            switchoverClusterTransportSettings,
            settings.switchoverClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.restoreClusterCallable =
        callableFactory.createUnaryCallable(
            restoreClusterTransportSettings, settings.restoreClusterSettings(), clientContext);
    this.restoreClusterOperationCallable =
        callableFactory.createOperationCallable(
            restoreClusterTransportSettings,
            settings.restoreClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.createSecondaryClusterCallable =
        callableFactory.createUnaryCallable(
            createSecondaryClusterTransportSettings,
            settings.createSecondaryClusterSettings(),
            clientContext);
    this.createSecondaryClusterOperationCallable =
        callableFactory.createOperationCallable(
            createSecondaryClusterTransportSettings,
            settings.createSecondaryClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.createInstanceCallable =
        callableFactory.createUnaryCallable(
            createInstanceTransportSettings, settings.createInstanceSettings(), clientContext);
    this.createInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createInstanceTransportSettings,
            settings.createInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.createSecondaryInstanceCallable =
        callableFactory.createUnaryCallable(
            createSecondaryInstanceTransportSettings,
            settings.createSecondaryInstanceSettings(),
            clientContext);
    this.createSecondaryInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createSecondaryInstanceTransportSettings,
            settings.createSecondaryInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.batchCreateInstancesCallable =
        callableFactory.createUnaryCallable(
            batchCreateInstancesTransportSettings,
            settings.batchCreateInstancesSettings(),
            clientContext);
    this.batchCreateInstancesOperationCallable =
        callableFactory.createOperationCallable(
            batchCreateInstancesTransportSettings,
            settings.batchCreateInstancesOperationSettings(),
            clientContext,
            operationsStub);
    this.updateInstanceCallable =
        callableFactory.createUnaryCallable(
            updateInstanceTransportSettings, settings.updateInstanceSettings(), clientContext);
    this.updateInstanceOperationCallable =
        callableFactory.createOperationCallable(
            updateInstanceTransportSettings,
            settings.updateInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.deleteInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstanceTransportSettings,
            settings.deleteInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.failoverInstanceCallable =
        callableFactory.createUnaryCallable(
            failoverInstanceTransportSettings, settings.failoverInstanceSettings(), clientContext);
    this.failoverInstanceOperationCallable =
        callableFactory.createOperationCallable(
            failoverInstanceTransportSettings,
            settings.failoverInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.injectFaultCallable =
        callableFactory.createUnaryCallable(
            injectFaultTransportSettings, settings.injectFaultSettings(), clientContext);
    this.injectFaultOperationCallable =
        callableFactory.createOperationCallable(
            injectFaultTransportSettings,
            settings.injectFaultOperationSettings(),
            clientContext,
            operationsStub);
    this.restartInstanceCallable =
        callableFactory.createUnaryCallable(
            restartInstanceTransportSettings, settings.restartInstanceSettings(), clientContext);
    this.restartInstanceOperationCallable =
        callableFactory.createOperationCallable(
            restartInstanceTransportSettings,
            settings.restartInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.executeSqlCallable =
        callableFactory.createUnaryCallable(
            executeSqlTransportSettings, settings.executeSqlSettings(), clientContext);
    this.listBackupsCallable =
        callableFactory.createUnaryCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.listBackupsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.getBackupCallable =
        callableFactory.createUnaryCallable(
            getBackupTransportSettings, settings.getBackupSettings(), clientContext);
    this.createBackupCallable =
        callableFactory.createUnaryCallable(
            createBackupTransportSettings, settings.createBackupSettings(), clientContext);
    this.createBackupOperationCallable =
        callableFactory.createOperationCallable(
            createBackupTransportSettings,
            settings.createBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.updateBackupCallable =
        callableFactory.createUnaryCallable(
            updateBackupTransportSettings, settings.updateBackupSettings(), clientContext);
    this.updateBackupOperationCallable =
        callableFactory.createOperationCallable(
            updateBackupTransportSettings,
            settings.updateBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteBackupCallable =
        callableFactory.createUnaryCallable(
            deleteBackupTransportSettings, settings.deleteBackupSettings(), clientContext);
    this.deleteBackupOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupTransportSettings,
            settings.deleteBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.listSupportedDatabaseFlagsCallable =
        callableFactory.createUnaryCallable(
            listSupportedDatabaseFlagsTransportSettings,
            settings.listSupportedDatabaseFlagsSettings(),
            clientContext);
    this.listSupportedDatabaseFlagsPagedCallable =
        callableFactory.createPagedCallable(
            listSupportedDatabaseFlagsTransportSettings,
            settings.listSupportedDatabaseFlagsSettings(),
            clientContext);
    this.generateClientCertificateCallable =
        callableFactory.createUnaryCallable(
            generateClientCertificateTransportSettings,
            settings.generateClientCertificateSettings(),
            clientContext);
    this.getConnectionInfoCallable =
        callableFactory.createUnaryCallable(
            getConnectionInfoTransportSettings,
            settings.getConnectionInfoSettings(),
            clientContext);
    this.listUsersCallable =
        callableFactory.createUnaryCallable(
            listUsersTransportSettings, settings.listUsersSettings(), clientContext);
    this.listUsersPagedCallable =
        callableFactory.createPagedCallable(
            listUsersTransportSettings, settings.listUsersSettings(), clientContext);
    this.getUserCallable =
        callableFactory.createUnaryCallable(
            getUserTransportSettings, settings.getUserSettings(), clientContext);
    this.createUserCallable =
        callableFactory.createUnaryCallable(
            createUserTransportSettings, settings.createUserSettings(), clientContext);
    this.updateUserCallable =
        callableFactory.createUnaryCallable(
            updateUserTransportSettings, settings.updateUserSettings(), clientContext);
    this.deleteUserCallable =
        callableFactory.createUnaryCallable(
            deleteUserTransportSettings, settings.deleteUserSettings(), clientContext);
    this.listDatabasesCallable =
        callableFactory.createUnaryCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
    this.listDatabasesPagedCallable =
        callableFactory.createPagedCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
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
  public UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return listClustersCallable;
  }

  @Override
  public UnaryCallable<ListClustersRequest, ListClustersPagedResponse> listClustersPagedCallable() {
    return listClustersPagedCallable;
  }

  @Override
  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return getClusterCallable;
  }

  @Override
  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return createClusterCallable;
  }

  @Override
  public OperationCallable<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationCallable() {
    return createClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return updateClusterCallable;
  }

  @Override
  public OperationCallable<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationCallable() {
    return updateClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ExportClusterRequest, Operation> exportClusterCallable() {
    return exportClusterCallable;
  }

  @Override
  public OperationCallable<ExportClusterRequest, ExportClusterResponse, OperationMetadata>
      exportClusterOperationCallable() {
    return exportClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ImportClusterRequest, Operation> importClusterCallable() {
    return importClusterCallable;
  }

  @Override
  public OperationCallable<ImportClusterRequest, ImportClusterResponse, OperationMetadata>
      importClusterOperationCallable() {
    return importClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpgradeClusterRequest, Operation> upgradeClusterCallable() {
    return upgradeClusterCallable;
  }

  @Override
  public OperationCallable<UpgradeClusterRequest, UpgradeClusterResponse, OperationMetadata>
      upgradeClusterOperationCallable() {
    return upgradeClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return deleteClusterCallable;
  }

  @Override
  public OperationCallable<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationCallable() {
    return deleteClusterOperationCallable;
  }

  @Override
  public UnaryCallable<PromoteClusterRequest, Operation> promoteClusterCallable() {
    return promoteClusterCallable;
  }

  @Override
  public OperationCallable<PromoteClusterRequest, Cluster, OperationMetadata>
      promoteClusterOperationCallable() {
    return promoteClusterOperationCallable;
  }

  @Override
  public UnaryCallable<SwitchoverClusterRequest, Operation> switchoverClusterCallable() {
    return switchoverClusterCallable;
  }

  @Override
  public OperationCallable<SwitchoverClusterRequest, Cluster, OperationMetadata>
      switchoverClusterOperationCallable() {
    return switchoverClusterOperationCallable;
  }

  @Override
  public UnaryCallable<RestoreClusterRequest, Operation> restoreClusterCallable() {
    return restoreClusterCallable;
  }

  @Override
  public OperationCallable<RestoreClusterRequest, Cluster, OperationMetadata>
      restoreClusterOperationCallable() {
    return restoreClusterOperationCallable;
  }

  @Override
  public UnaryCallable<CreateSecondaryClusterRequest, Operation> createSecondaryClusterCallable() {
    return createSecondaryClusterCallable;
  }

  @Override
  public OperationCallable<CreateSecondaryClusterRequest, Cluster, OperationMetadata>
      createSecondaryClusterOperationCallable() {
    return createSecondaryClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  @Override
  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return createInstanceCallable;
  }

  @Override
  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return createInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<CreateSecondaryInstanceRequest, Operation>
      createSecondaryInstanceCallable() {
    return createSecondaryInstanceCallable;
  }

  @Override
  public OperationCallable<CreateSecondaryInstanceRequest, Instance, OperationMetadata>
      createSecondaryInstanceOperationCallable() {
    return createSecondaryInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<BatchCreateInstancesRequest, Operation> batchCreateInstancesCallable() {
    return batchCreateInstancesCallable;
  }

  @Override
  public OperationCallable<
          BatchCreateInstancesRequest, BatchCreateInstancesResponse, OperationMetadata>
      batchCreateInstancesOperationCallable() {
    return batchCreateInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return updateInstanceCallable;
  }

  @Override
  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return updateInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return deleteInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<FailoverInstanceRequest, Operation> failoverInstanceCallable() {
    return failoverInstanceCallable;
  }

  @Override
  public OperationCallable<FailoverInstanceRequest, Instance, OperationMetadata>
      failoverInstanceOperationCallable() {
    return failoverInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<InjectFaultRequest, Operation> injectFaultCallable() {
    return injectFaultCallable;
  }

  @Override
  public OperationCallable<InjectFaultRequest, Instance, OperationMetadata>
      injectFaultOperationCallable() {
    return injectFaultOperationCallable;
  }

  @Override
  public UnaryCallable<RestartInstanceRequest, Operation> restartInstanceCallable() {
    return restartInstanceCallable;
  }

  @Override
  public OperationCallable<RestartInstanceRequest, Instance, OperationMetadata>
      restartInstanceOperationCallable() {
    return restartInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<ExecuteSqlRequest, ExecuteSqlResponse> executeSqlCallable() {
    return executeSqlCallable;
  }

  @Override
  public UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    return listBackupsCallable;
  }

  @Override
  public UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse> listBackupsPagedCallable() {
    return listBackupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return getBackupCallable;
  }

  @Override
  public UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    return createBackupCallable;
  }

  @Override
  public OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable() {
    return createBackupOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable() {
    return updateBackupCallable;
  }

  @Override
  public OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable() {
    return updateBackupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    return deleteBackupCallable;
  }

  @Override
  public OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable() {
    return deleteBackupOperationCallable;
  }

  @Override
  public UnaryCallable<ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsResponse>
      listSupportedDatabaseFlagsCallable() {
    return listSupportedDatabaseFlagsCallable;
  }

  @Override
  public UnaryCallable<ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsPagedResponse>
      listSupportedDatabaseFlagsPagedCallable() {
    return listSupportedDatabaseFlagsPagedCallable;
  }

  @Override
  public UnaryCallable<GenerateClientCertificateRequest, GenerateClientCertificateResponse>
      generateClientCertificateCallable() {
    return generateClientCertificateCallable;
  }

  @Override
  public UnaryCallable<GetConnectionInfoRequest, ConnectionInfo> getConnectionInfoCallable() {
    return getConnectionInfoCallable;
  }

  @Override
  public UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable() {
    return listUsersCallable;
  }

  @Override
  public UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable() {
    return listUsersPagedCallable;
  }

  @Override
  public UnaryCallable<GetUserRequest, User> getUserCallable() {
    return getUserCallable;
  }

  @Override
  public UnaryCallable<CreateUserRequest, User> createUserCallable() {
    return createUserCallable;
  }

  @Override
  public UnaryCallable<UpdateUserRequest, User> updateUserCallable() {
    return updateUserCallable;
  }

  @Override
  public UnaryCallable<DeleteUserRequest, Empty> deleteUserCallable() {
    return deleteUserCallable;
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
