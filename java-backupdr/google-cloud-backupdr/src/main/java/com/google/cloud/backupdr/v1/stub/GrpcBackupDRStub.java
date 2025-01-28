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

package com.google.cloud.backupdr.v1.stub;

import static com.google.cloud.backupdr.v1.BackupDRClient.FetchUsableBackupVaultsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupPlanAssociationsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupPlansPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupVaultsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListDataSourcesPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListLocationsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListManagementServersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.backupdr.v1.Backup;
import com.google.cloud.backupdr.v1.BackupPlan;
import com.google.cloud.backupdr.v1.BackupPlanAssociation;
import com.google.cloud.backupdr.v1.BackupVault;
import com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1.CreateBackupPlanRequest;
import com.google.cloud.backupdr.v1.CreateBackupVaultRequest;
import com.google.cloud.backupdr.v1.CreateManagementServerRequest;
import com.google.cloud.backupdr.v1.DataSource;
import com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1.DeleteBackupPlanRequest;
import com.google.cloud.backupdr.v1.DeleteBackupRequest;
import com.google.cloud.backupdr.v1.DeleteBackupVaultRequest;
import com.google.cloud.backupdr.v1.DeleteManagementServerRequest;
import com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest;
import com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse;
import com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1.GetBackupPlanRequest;
import com.google.cloud.backupdr.v1.GetBackupRequest;
import com.google.cloud.backupdr.v1.GetBackupVaultRequest;
import com.google.cloud.backupdr.v1.GetDataSourceRequest;
import com.google.cloud.backupdr.v1.GetManagementServerRequest;
import com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest;
import com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse;
import com.google.cloud.backupdr.v1.ListBackupPlansRequest;
import com.google.cloud.backupdr.v1.ListBackupPlansResponse;
import com.google.cloud.backupdr.v1.ListBackupVaultsRequest;
import com.google.cloud.backupdr.v1.ListBackupVaultsResponse;
import com.google.cloud.backupdr.v1.ListBackupsRequest;
import com.google.cloud.backupdr.v1.ListBackupsResponse;
import com.google.cloud.backupdr.v1.ListDataSourcesRequest;
import com.google.cloud.backupdr.v1.ListDataSourcesResponse;
import com.google.cloud.backupdr.v1.ListManagementServersRequest;
import com.google.cloud.backupdr.v1.ListManagementServersResponse;
import com.google.cloud.backupdr.v1.ManagementServer;
import com.google.cloud.backupdr.v1.OperationMetadata;
import com.google.cloud.backupdr.v1.RestoreBackupRequest;
import com.google.cloud.backupdr.v1.RestoreBackupResponse;
import com.google.cloud.backupdr.v1.TriggerBackupRequest;
import com.google.cloud.backupdr.v1.UpdateBackupRequest;
import com.google.cloud.backupdr.v1.UpdateBackupVaultRequest;
import com.google.cloud.backupdr.v1.UpdateDataSourceRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * gRPC stub implementation for the BackupDR service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcBackupDRStub extends BackupDRStub {
  private static final MethodDescriptor<ListManagementServersRequest, ListManagementServersResponse>
      listManagementServersMethodDescriptor =
          MethodDescriptor.<ListManagementServersRequest, ListManagementServersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/ListManagementServers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListManagementServersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListManagementServersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetManagementServerRequest, ManagementServer>
      getManagementServerMethodDescriptor =
          MethodDescriptor.<GetManagementServerRequest, ManagementServer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/GetManagementServer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetManagementServerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ManagementServer.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateManagementServerRequest, Operation>
      createManagementServerMethodDescriptor =
          MethodDescriptor.<CreateManagementServerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/CreateManagementServer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateManagementServerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteManagementServerRequest, Operation>
      deleteManagementServerMethodDescriptor =
          MethodDescriptor.<DeleteManagementServerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/DeleteManagementServer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteManagementServerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateBackupVaultRequest, Operation>
      createBackupVaultMethodDescriptor =
          MethodDescriptor.<CreateBackupVaultRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/CreateBackupVault")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBackupVaultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListBackupVaultsRequest, ListBackupVaultsResponse>
      listBackupVaultsMethodDescriptor =
          MethodDescriptor.<ListBackupVaultsRequest, ListBackupVaultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/ListBackupVaults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBackupVaultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupVaultsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>
      fetchUsableBackupVaultsMethodDescriptor =
          MethodDescriptor
              .<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/FetchUsableBackupVaults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchUsableBackupVaultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchUsableBackupVaultsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBackupVaultRequest, BackupVault>
      getBackupVaultMethodDescriptor =
          MethodDescriptor.<GetBackupVaultRequest, BackupVault>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/GetBackupVault")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBackupVaultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BackupVault.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateBackupVaultRequest, Operation>
      updateBackupVaultMethodDescriptor =
          MethodDescriptor.<UpdateBackupVaultRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/UpdateBackupVault")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBackupVaultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBackupVaultRequest, Operation>
      deleteBackupVaultMethodDescriptor =
          MethodDescriptor.<DeleteBackupVaultRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/DeleteBackupVault")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBackupVaultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesMethodDescriptor =
          MethodDescriptor.<ListDataSourcesRequest, ListDataSourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/ListDataSources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataSourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataSourceRequest, DataSource>
      getDataSourceMethodDescriptor =
          MethodDescriptor.<GetDataSourceRequest, DataSource>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/GetDataSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataSource.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDataSourceRequest, Operation>
      updateDataSourceMethodDescriptor =
          MethodDescriptor.<UpdateDataSourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/UpdateDataSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          MethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/ListBackups")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBackupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBackupRequest, Backup> getBackupMethodDescriptor =
      MethodDescriptor.<GetBackupRequest, Backup>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.backupdr.v1.BackupDR/GetBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Backup.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateBackupRequest, Operation>
      updateBackupMethodDescriptor =
          MethodDescriptor.<UpdateBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/UpdateBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBackupRequest, Operation>
      deleteBackupMethodDescriptor =
          MethodDescriptor.<DeleteBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/DeleteBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RestoreBackupRequest, Operation>
      restoreBackupMethodDescriptor =
          MethodDescriptor.<RestoreBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/RestoreBackup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestoreBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateBackupPlanRequest, Operation>
      createBackupPlanMethodDescriptor =
          MethodDescriptor.<CreateBackupPlanRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/CreateBackupPlan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBackupPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBackupPlanRequest, BackupPlan>
      getBackupPlanMethodDescriptor =
          MethodDescriptor.<GetBackupPlanRequest, BackupPlan>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/GetBackupPlan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBackupPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BackupPlan.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListBackupPlansRequest, ListBackupPlansResponse>
      listBackupPlansMethodDescriptor =
          MethodDescriptor.<ListBackupPlansRequest, ListBackupPlansResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/ListBackupPlans")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBackupPlansRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupPlansResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBackupPlanRequest, Operation>
      deleteBackupPlanMethodDescriptor =
          MethodDescriptor.<DeleteBackupPlanRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/DeleteBackupPlan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBackupPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateBackupPlanAssociationRequest, Operation>
      createBackupPlanAssociationMethodDescriptor =
          MethodDescriptor.<CreateBackupPlanAssociationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/CreateBackupPlanAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBackupPlanAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBackupPlanAssociationRequest, BackupPlanAssociation>
      getBackupPlanAssociationMethodDescriptor =
          MethodDescriptor.<GetBackupPlanAssociationRequest, BackupPlanAssociation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/GetBackupPlanAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBackupPlanAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BackupPlanAssociation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>
      listBackupPlanAssociationsMethodDescriptor =
          MethodDescriptor
              .<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/ListBackupPlanAssociations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBackupPlanAssociationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupPlanAssociationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBackupPlanAssociationRequest, Operation>
      deleteBackupPlanAssociationMethodDescriptor =
          MethodDescriptor.<DeleteBackupPlanAssociationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/DeleteBackupPlanAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBackupPlanAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TriggerBackupRequest, Operation>
      triggerBackupMethodDescriptor =
          MethodDescriptor.<TriggerBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/TriggerBackup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TriggerBackupRequest.getDefaultInstance()))
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

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListManagementServersRequest, ListManagementServersResponse>
      listManagementServersCallable;
  private final UnaryCallable<ListManagementServersRequest, ListManagementServersPagedResponse>
      listManagementServersPagedCallable;
  private final UnaryCallable<GetManagementServerRequest, ManagementServer>
      getManagementServerCallable;
  private final UnaryCallable<CreateManagementServerRequest, Operation>
      createManagementServerCallable;
  private final OperationCallable<
          CreateManagementServerRequest, ManagementServer, OperationMetadata>
      createManagementServerOperationCallable;
  private final UnaryCallable<DeleteManagementServerRequest, Operation>
      deleteManagementServerCallable;
  private final OperationCallable<DeleteManagementServerRequest, Empty, OperationMetadata>
      deleteManagementServerOperationCallable;
  private final UnaryCallable<CreateBackupVaultRequest, Operation> createBackupVaultCallable;
  private final OperationCallable<CreateBackupVaultRequest, BackupVault, OperationMetadata>
      createBackupVaultOperationCallable;
  private final UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsResponse>
      listBackupVaultsCallable;
  private final UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsPagedResponse>
      listBackupVaultsPagedCallable;
  private final UnaryCallable<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>
      fetchUsableBackupVaultsCallable;
  private final UnaryCallable<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsPagedResponse>
      fetchUsableBackupVaultsPagedCallable;
  private final UnaryCallable<GetBackupVaultRequest, BackupVault> getBackupVaultCallable;
  private final UnaryCallable<UpdateBackupVaultRequest, Operation> updateBackupVaultCallable;
  private final OperationCallable<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
      updateBackupVaultOperationCallable;
  private final UnaryCallable<DeleteBackupVaultRequest, Operation> deleteBackupVaultCallable;
  private final OperationCallable<DeleteBackupVaultRequest, Empty, OperationMetadata>
      deleteBackupVaultOperationCallable;
  private final UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesCallable;
  private final UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable;
  private final UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable;
  private final UnaryCallable<UpdateDataSourceRequest, Operation> updateDataSourceCallable;
  private final OperationCallable<UpdateDataSourceRequest, DataSource, OperationMetadata>
      updateDataSourceOperationCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable;
  private final OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable;
  private final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable;
  private final OperationCallable<DeleteBackupRequest, Backup, OperationMetadata>
      deleteBackupOperationCallable;
  private final UnaryCallable<RestoreBackupRequest, Operation> restoreBackupCallable;
  private final OperationCallable<RestoreBackupRequest, RestoreBackupResponse, OperationMetadata>
      restoreBackupOperationCallable;
  private final UnaryCallable<CreateBackupPlanRequest, Operation> createBackupPlanCallable;
  private final OperationCallable<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationCallable;
  private final UnaryCallable<GetBackupPlanRequest, BackupPlan> getBackupPlanCallable;
  private final UnaryCallable<ListBackupPlansRequest, ListBackupPlansResponse>
      listBackupPlansCallable;
  private final UnaryCallable<ListBackupPlansRequest, ListBackupPlansPagedResponse>
      listBackupPlansPagedCallable;
  private final UnaryCallable<DeleteBackupPlanRequest, Operation> deleteBackupPlanCallable;
  private final OperationCallable<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationCallable;
  private final UnaryCallable<CreateBackupPlanAssociationRequest, Operation>
      createBackupPlanAssociationCallable;
  private final OperationCallable<
          CreateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
      createBackupPlanAssociationOperationCallable;
  private final UnaryCallable<GetBackupPlanAssociationRequest, BackupPlanAssociation>
      getBackupPlanAssociationCallable;
  private final UnaryCallable<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>
      listBackupPlanAssociationsCallable;
  private final UnaryCallable<
          ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsPagedResponse>
      listBackupPlanAssociationsPagedCallable;
  private final UnaryCallable<DeleteBackupPlanAssociationRequest, Operation>
      deleteBackupPlanAssociationCallable;
  private final OperationCallable<DeleteBackupPlanAssociationRequest, Empty, OperationMetadata>
      deleteBackupPlanAssociationOperationCallable;
  private final UnaryCallable<TriggerBackupRequest, Operation> triggerBackupCallable;
  private final OperationCallable<TriggerBackupRequest, BackupPlanAssociation, OperationMetadata>
      triggerBackupOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBackupDRStub create(BackupDRStubSettings settings) throws IOException {
    return new GrpcBackupDRStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBackupDRStub create(ClientContext clientContext) throws IOException {
    return new GrpcBackupDRStub(BackupDRStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBackupDRStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBackupDRStub(
        BackupDRStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBackupDRStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcBackupDRStub(BackupDRStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcBackupDRCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBackupDRStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcBackupDRStub(
      BackupDRStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListManagementServersRequest, ListManagementServersResponse>
        listManagementServersTransportSettings =
            GrpcCallSettings
                .<ListManagementServersRequest, ListManagementServersResponse>newBuilder()
                .setMethodDescriptor(listManagementServersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetManagementServerRequest, ManagementServer>
        getManagementServerTransportSettings =
            GrpcCallSettings.<GetManagementServerRequest, ManagementServer>newBuilder()
                .setMethodDescriptor(getManagementServerMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateManagementServerRequest, Operation>
        createManagementServerTransportSettings =
            GrpcCallSettings.<CreateManagementServerRequest, Operation>newBuilder()
                .setMethodDescriptor(createManagementServerMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteManagementServerRequest, Operation>
        deleteManagementServerTransportSettings =
            GrpcCallSettings.<DeleteManagementServerRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteManagementServerMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateBackupVaultRequest, Operation> createBackupVaultTransportSettings =
        GrpcCallSettings.<CreateBackupVaultRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupVaultMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListBackupVaultsRequest, ListBackupVaultsResponse>
        listBackupVaultsTransportSettings =
            GrpcCallSettings.<ListBackupVaultsRequest, ListBackupVaultsResponse>newBuilder()
                .setMethodDescriptor(listBackupVaultsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>
        fetchUsableBackupVaultsTransportSettings =
            GrpcCallSettings
                .<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>newBuilder()
                .setMethodDescriptor(fetchUsableBackupVaultsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetBackupVaultRequest, BackupVault> getBackupVaultTransportSettings =
        GrpcCallSettings.<GetBackupVaultRequest, BackupVault>newBuilder()
            .setMethodDescriptor(getBackupVaultMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateBackupVaultRequest, Operation> updateBackupVaultTransportSettings =
        GrpcCallSettings.<UpdateBackupVaultRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBackupVaultMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "backup_vault.name", String.valueOf(request.getBackupVault().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteBackupVaultRequest, Operation> deleteBackupVaultTransportSettings =
        GrpcCallSettings.<DeleteBackupVaultRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupVaultMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDataSourcesRequest, ListDataSourcesResponse>
        listDataSourcesTransportSettings =
            GrpcCallSettings.<ListDataSourcesRequest, ListDataSourcesResponse>newBuilder()
                .setMethodDescriptor(listDataSourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDataSourceRequest, DataSource> getDataSourceTransportSettings =
        GrpcCallSettings.<GetDataSourceRequest, DataSource>newBuilder()
            .setMethodDescriptor(getDataSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDataSourceRequest, Operation> updateDataSourceTransportSettings =
        GrpcCallSettings.<UpdateDataSourceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDataSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_source.name", String.valueOf(request.getDataSource().getName()));
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
    GrpcCallSettings<RestoreBackupRequest, Operation> restoreBackupTransportSettings =
        GrpcCallSettings.<RestoreBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateBackupPlanRequest, Operation> createBackupPlanTransportSettings =
        GrpcCallSettings.<CreateBackupPlanRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupPlanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetBackupPlanRequest, BackupPlan> getBackupPlanTransportSettings =
        GrpcCallSettings.<GetBackupPlanRequest, BackupPlan>newBuilder()
            .setMethodDescriptor(getBackupPlanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListBackupPlansRequest, ListBackupPlansResponse>
        listBackupPlansTransportSettings =
            GrpcCallSettings.<ListBackupPlansRequest, ListBackupPlansResponse>newBuilder()
                .setMethodDescriptor(listBackupPlansMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteBackupPlanRequest, Operation> deleteBackupPlanTransportSettings =
        GrpcCallSettings.<DeleteBackupPlanRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupPlanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateBackupPlanAssociationRequest, Operation>
        createBackupPlanAssociationTransportSettings =
            GrpcCallSettings.<CreateBackupPlanAssociationRequest, Operation>newBuilder()
                .setMethodDescriptor(createBackupPlanAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetBackupPlanAssociationRequest, BackupPlanAssociation>
        getBackupPlanAssociationTransportSettings =
            GrpcCallSettings.<GetBackupPlanAssociationRequest, BackupPlanAssociation>newBuilder()
                .setMethodDescriptor(getBackupPlanAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>
        listBackupPlanAssociationsTransportSettings =
            GrpcCallSettings
                .<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>newBuilder()
                .setMethodDescriptor(listBackupPlanAssociationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteBackupPlanAssociationRequest, Operation>
        deleteBackupPlanAssociationTransportSettings =
            GrpcCallSettings.<DeleteBackupPlanAssociationRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteBackupPlanAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<TriggerBackupRequest, Operation> triggerBackupTransportSettings =
        GrpcCallSettings.<TriggerBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(triggerBackupMethodDescriptor)
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
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.listManagementServersCallable =
        callableFactory.createUnaryCallable(
            listManagementServersTransportSettings,
            settings.listManagementServersSettings(),
            clientContext);
    this.listManagementServersPagedCallable =
        callableFactory.createPagedCallable(
            listManagementServersTransportSettings,
            settings.listManagementServersSettings(),
            clientContext);
    this.getManagementServerCallable =
        callableFactory.createUnaryCallable(
            getManagementServerTransportSettings,
            settings.getManagementServerSettings(),
            clientContext);
    this.createManagementServerCallable =
        callableFactory.createUnaryCallable(
            createManagementServerTransportSettings,
            settings.createManagementServerSettings(),
            clientContext);
    this.createManagementServerOperationCallable =
        callableFactory.createOperationCallable(
            createManagementServerTransportSettings,
            settings.createManagementServerOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteManagementServerCallable =
        callableFactory.createUnaryCallable(
            deleteManagementServerTransportSettings,
            settings.deleteManagementServerSettings(),
            clientContext);
    this.deleteManagementServerOperationCallable =
        callableFactory.createOperationCallable(
            deleteManagementServerTransportSettings,
            settings.deleteManagementServerOperationSettings(),
            clientContext,
            operationsStub);
    this.createBackupVaultCallable =
        callableFactory.createUnaryCallable(
            createBackupVaultTransportSettings,
            settings.createBackupVaultSettings(),
            clientContext);
    this.createBackupVaultOperationCallable =
        callableFactory.createOperationCallable(
            createBackupVaultTransportSettings,
            settings.createBackupVaultOperationSettings(),
            clientContext,
            operationsStub);
    this.listBackupVaultsCallable =
        callableFactory.createUnaryCallable(
            listBackupVaultsTransportSettings, settings.listBackupVaultsSettings(), clientContext);
    this.listBackupVaultsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupVaultsTransportSettings, settings.listBackupVaultsSettings(), clientContext);
    this.fetchUsableBackupVaultsCallable =
        callableFactory.createUnaryCallable(
            fetchUsableBackupVaultsTransportSettings,
            settings.fetchUsableBackupVaultsSettings(),
            clientContext);
    this.fetchUsableBackupVaultsPagedCallable =
        callableFactory.createPagedCallable(
            fetchUsableBackupVaultsTransportSettings,
            settings.fetchUsableBackupVaultsSettings(),
            clientContext);
    this.getBackupVaultCallable =
        callableFactory.createUnaryCallable(
            getBackupVaultTransportSettings, settings.getBackupVaultSettings(), clientContext);
    this.updateBackupVaultCallable =
        callableFactory.createUnaryCallable(
            updateBackupVaultTransportSettings,
            settings.updateBackupVaultSettings(),
            clientContext);
    this.updateBackupVaultOperationCallable =
        callableFactory.createOperationCallable(
            updateBackupVaultTransportSettings,
            settings.updateBackupVaultOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteBackupVaultCallable =
        callableFactory.createUnaryCallable(
            deleteBackupVaultTransportSettings,
            settings.deleteBackupVaultSettings(),
            clientContext);
    this.deleteBackupVaultOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupVaultTransportSettings,
            settings.deleteBackupVaultOperationSettings(),
            clientContext,
            operationsStub);
    this.listDataSourcesCallable =
        callableFactory.createUnaryCallable(
            listDataSourcesTransportSettings, settings.listDataSourcesSettings(), clientContext);
    this.listDataSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listDataSourcesTransportSettings, settings.listDataSourcesSettings(), clientContext);
    this.getDataSourceCallable =
        callableFactory.createUnaryCallable(
            getDataSourceTransportSettings, settings.getDataSourceSettings(), clientContext);
    this.updateDataSourceCallable =
        callableFactory.createUnaryCallable(
            updateDataSourceTransportSettings, settings.updateDataSourceSettings(), clientContext);
    this.updateDataSourceOperationCallable =
        callableFactory.createOperationCallable(
            updateDataSourceTransportSettings,
            settings.updateDataSourceOperationSettings(),
            clientContext,
            operationsStub);
    this.listBackupsCallable =
        callableFactory.createUnaryCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.listBackupsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.getBackupCallable =
        callableFactory.createUnaryCallable(
            getBackupTransportSettings, settings.getBackupSettings(), clientContext);
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
    this.restoreBackupCallable =
        callableFactory.createUnaryCallable(
            restoreBackupTransportSettings, settings.restoreBackupSettings(), clientContext);
    this.restoreBackupOperationCallable =
        callableFactory.createOperationCallable(
            restoreBackupTransportSettings,
            settings.restoreBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.createBackupPlanCallable =
        callableFactory.createUnaryCallable(
            createBackupPlanTransportSettings, settings.createBackupPlanSettings(), clientContext);
    this.createBackupPlanOperationCallable =
        callableFactory.createOperationCallable(
            createBackupPlanTransportSettings,
            settings.createBackupPlanOperationSettings(),
            clientContext,
            operationsStub);
    this.getBackupPlanCallable =
        callableFactory.createUnaryCallable(
            getBackupPlanTransportSettings, settings.getBackupPlanSettings(), clientContext);
    this.listBackupPlansCallable =
        callableFactory.createUnaryCallable(
            listBackupPlansTransportSettings, settings.listBackupPlansSettings(), clientContext);
    this.listBackupPlansPagedCallable =
        callableFactory.createPagedCallable(
            listBackupPlansTransportSettings, settings.listBackupPlansSettings(), clientContext);
    this.deleteBackupPlanCallable =
        callableFactory.createUnaryCallable(
            deleteBackupPlanTransportSettings, settings.deleteBackupPlanSettings(), clientContext);
    this.deleteBackupPlanOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupPlanTransportSettings,
            settings.deleteBackupPlanOperationSettings(),
            clientContext,
            operationsStub);
    this.createBackupPlanAssociationCallable =
        callableFactory.createUnaryCallable(
            createBackupPlanAssociationTransportSettings,
            settings.createBackupPlanAssociationSettings(),
            clientContext);
    this.createBackupPlanAssociationOperationCallable =
        callableFactory.createOperationCallable(
            createBackupPlanAssociationTransportSettings,
            settings.createBackupPlanAssociationOperationSettings(),
            clientContext,
            operationsStub);
    this.getBackupPlanAssociationCallable =
        callableFactory.createUnaryCallable(
            getBackupPlanAssociationTransportSettings,
            settings.getBackupPlanAssociationSettings(),
            clientContext);
    this.listBackupPlanAssociationsCallable =
        callableFactory.createUnaryCallable(
            listBackupPlanAssociationsTransportSettings,
            settings.listBackupPlanAssociationsSettings(),
            clientContext);
    this.listBackupPlanAssociationsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupPlanAssociationsTransportSettings,
            settings.listBackupPlanAssociationsSettings(),
            clientContext);
    this.deleteBackupPlanAssociationCallable =
        callableFactory.createUnaryCallable(
            deleteBackupPlanAssociationTransportSettings,
            settings.deleteBackupPlanAssociationSettings(),
            clientContext);
    this.deleteBackupPlanAssociationOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupPlanAssociationTransportSettings,
            settings.deleteBackupPlanAssociationOperationSettings(),
            clientContext,
            operationsStub);
    this.triggerBackupCallable =
        callableFactory.createUnaryCallable(
            triggerBackupTransportSettings, settings.triggerBackupSettings(), clientContext);
    this.triggerBackupOperationCallable =
        callableFactory.createOperationCallable(
            triggerBackupTransportSettings,
            settings.triggerBackupOperationSettings(),
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
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListManagementServersRequest, ListManagementServersResponse>
      listManagementServersCallable() {
    return listManagementServersCallable;
  }

  @Override
  public UnaryCallable<ListManagementServersRequest, ListManagementServersPagedResponse>
      listManagementServersPagedCallable() {
    return listManagementServersPagedCallable;
  }

  @Override
  public UnaryCallable<GetManagementServerRequest, ManagementServer> getManagementServerCallable() {
    return getManagementServerCallable;
  }

  @Override
  public UnaryCallable<CreateManagementServerRequest, Operation> createManagementServerCallable() {
    return createManagementServerCallable;
  }

  @Override
  public OperationCallable<CreateManagementServerRequest, ManagementServer, OperationMetadata>
      createManagementServerOperationCallable() {
    return createManagementServerOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteManagementServerRequest, Operation> deleteManagementServerCallable() {
    return deleteManagementServerCallable;
  }

  @Override
  public OperationCallable<DeleteManagementServerRequest, Empty, OperationMetadata>
      deleteManagementServerOperationCallable() {
    return deleteManagementServerOperationCallable;
  }

  @Override
  public UnaryCallable<CreateBackupVaultRequest, Operation> createBackupVaultCallable() {
    return createBackupVaultCallable;
  }

  @Override
  public OperationCallable<CreateBackupVaultRequest, BackupVault, OperationMetadata>
      createBackupVaultOperationCallable() {
    return createBackupVaultOperationCallable;
  }

  @Override
  public UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsResponse>
      listBackupVaultsCallable() {
    return listBackupVaultsCallable;
  }

  @Override
  public UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsPagedResponse>
      listBackupVaultsPagedCallable() {
    return listBackupVaultsPagedCallable;
  }

  @Override
  public UnaryCallable<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>
      fetchUsableBackupVaultsCallable() {
    return fetchUsableBackupVaultsCallable;
  }

  @Override
  public UnaryCallable<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsPagedResponse>
      fetchUsableBackupVaultsPagedCallable() {
    return fetchUsableBackupVaultsPagedCallable;
  }

  @Override
  public UnaryCallable<GetBackupVaultRequest, BackupVault> getBackupVaultCallable() {
    return getBackupVaultCallable;
  }

  @Override
  public UnaryCallable<UpdateBackupVaultRequest, Operation> updateBackupVaultCallable() {
    return updateBackupVaultCallable;
  }

  @Override
  public OperationCallable<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
      updateBackupVaultOperationCallable() {
    return updateBackupVaultOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupVaultRequest, Operation> deleteBackupVaultCallable() {
    return deleteBackupVaultCallable;
  }

  @Override
  public OperationCallable<DeleteBackupVaultRequest, Empty, OperationMetadata>
      deleteBackupVaultOperationCallable() {
    return deleteBackupVaultOperationCallable;
  }

  @Override
  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse> listDataSourcesCallable() {
    return listDataSourcesCallable;
  }

  @Override
  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable() {
    return listDataSourcesPagedCallable;
  }

  @Override
  public UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable() {
    return getDataSourceCallable;
  }

  @Override
  public UnaryCallable<UpdateDataSourceRequest, Operation> updateDataSourceCallable() {
    return updateDataSourceCallable;
  }

  @Override
  public OperationCallable<UpdateDataSourceRequest, DataSource, OperationMetadata>
      updateDataSourceOperationCallable() {
    return updateDataSourceOperationCallable;
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
  public OperationCallable<DeleteBackupRequest, Backup, OperationMetadata>
      deleteBackupOperationCallable() {
    return deleteBackupOperationCallable;
  }

  @Override
  public UnaryCallable<RestoreBackupRequest, Operation> restoreBackupCallable() {
    return restoreBackupCallable;
  }

  @Override
  public OperationCallable<RestoreBackupRequest, RestoreBackupResponse, OperationMetadata>
      restoreBackupOperationCallable() {
    return restoreBackupOperationCallable;
  }

  @Override
  public UnaryCallable<CreateBackupPlanRequest, Operation> createBackupPlanCallable() {
    return createBackupPlanCallable;
  }

  @Override
  public OperationCallable<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationCallable() {
    return createBackupPlanOperationCallable;
  }

  @Override
  public UnaryCallable<GetBackupPlanRequest, BackupPlan> getBackupPlanCallable() {
    return getBackupPlanCallable;
  }

  @Override
  public UnaryCallable<ListBackupPlansRequest, ListBackupPlansResponse> listBackupPlansCallable() {
    return listBackupPlansCallable;
  }

  @Override
  public UnaryCallable<ListBackupPlansRequest, ListBackupPlansPagedResponse>
      listBackupPlansPagedCallable() {
    return listBackupPlansPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupPlanRequest, Operation> deleteBackupPlanCallable() {
    return deleteBackupPlanCallable;
  }

  @Override
  public OperationCallable<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationCallable() {
    return deleteBackupPlanOperationCallable;
  }

  @Override
  public UnaryCallable<CreateBackupPlanAssociationRequest, Operation>
      createBackupPlanAssociationCallable() {
    return createBackupPlanAssociationCallable;
  }

  @Override
  public OperationCallable<
          CreateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
      createBackupPlanAssociationOperationCallable() {
    return createBackupPlanAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<GetBackupPlanAssociationRequest, BackupPlanAssociation>
      getBackupPlanAssociationCallable() {
    return getBackupPlanAssociationCallable;
  }

  @Override
  public UnaryCallable<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>
      listBackupPlanAssociationsCallable() {
    return listBackupPlanAssociationsCallable;
  }

  @Override
  public UnaryCallable<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsPagedResponse>
      listBackupPlanAssociationsPagedCallable() {
    return listBackupPlanAssociationsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupPlanAssociationRequest, Operation>
      deleteBackupPlanAssociationCallable() {
    return deleteBackupPlanAssociationCallable;
  }

  @Override
  public OperationCallable<DeleteBackupPlanAssociationRequest, Empty, OperationMetadata>
      deleteBackupPlanAssociationOperationCallable() {
    return deleteBackupPlanAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<TriggerBackupRequest, Operation> triggerBackupCallable() {
    return triggerBackupCallable;
  }

  @Override
  public OperationCallable<TriggerBackupRequest, BackupPlanAssociation, OperationMetadata>
      triggerBackupOperationCallable() {
    return triggerBackupOperationCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
