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

package com.google.cloud.backupdr.v1beta.stub;

import static com.google.cloud.backupdr.v1beta.BackupDRClient.FetchBackupPlanAssociationsForResourceTypePagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.FetchBackupsForResourceTypePagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.FetchDataSourceReferencesForResourceTypePagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.FetchUsableBackupVaultsPagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.ListAppliedAutoProtectionPoliciesPagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.ListAutoProtectionPoliciesPagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.ListAutoProtectionPolicyBindingsPagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.ListBackupPlanAssociationsPagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.ListBackupPlanRevisionsPagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.ListBackupPlansPagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.ListBackupVaultsPagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.ListBackupsPagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.ListBindingMatchingResourcesPagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.ListDataSourceReferencesPagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.ListDataSourcesPagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.ListLocationsPagedResponse;
import static com.google.cloud.backupdr.v1beta.BackupDRClient.ListManagementServersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.backupdr.v1beta.AutoProtectionPolicy;
import com.google.cloud.backupdr.v1beta.AutoProtectionPolicyBinding;
import com.google.cloud.backupdr.v1beta.Backup;
import com.google.cloud.backupdr.v1beta.BackupPlan;
import com.google.cloud.backupdr.v1beta.BackupPlanAssociation;
import com.google.cloud.backupdr.v1beta.BackupPlanRevision;
import com.google.cloud.backupdr.v1beta.BackupVault;
import com.google.cloud.backupdr.v1beta.BindingMatchingResource;
import com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyBindingRequest;
import com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyRequest;
import com.google.cloud.backupdr.v1beta.CreateBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1beta.CreateBackupPlanRequest;
import com.google.cloud.backupdr.v1beta.CreateBackupVaultRequest;
import com.google.cloud.backupdr.v1beta.CreateManagementServerRequest;
import com.google.cloud.backupdr.v1beta.DataSource;
import com.google.cloud.backupdr.v1beta.DataSourceReference;
import com.google.cloud.backupdr.v1beta.DeleteAutoProtectionPolicyRequest;
import com.google.cloud.backupdr.v1beta.DeleteBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1beta.DeleteBackupPlanRequest;
import com.google.cloud.backupdr.v1beta.DeleteBackupRequest;
import com.google.cloud.backupdr.v1beta.DeleteBackupVaultRequest;
import com.google.cloud.backupdr.v1beta.DeleteManagementServerRequest;
import com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeRequest;
import com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeResponse;
import com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeRequest;
import com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeResponse;
import com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeRequest;
import com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeResponse;
import com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsRequest;
import com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsResponse;
import com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyBindingRequest;
import com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyRequest;
import com.google.cloud.backupdr.v1beta.GetBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1beta.GetBackupPlanRequest;
import com.google.cloud.backupdr.v1beta.GetBackupPlanRevisionRequest;
import com.google.cloud.backupdr.v1beta.GetBackupRequest;
import com.google.cloud.backupdr.v1beta.GetBackupVaultRequest;
import com.google.cloud.backupdr.v1beta.GetBindingMatchingResourceRequest;
import com.google.cloud.backupdr.v1beta.GetDataSourceReferenceRequest;
import com.google.cloud.backupdr.v1beta.GetDataSourceRequest;
import com.google.cloud.backupdr.v1beta.GetManagementServerRequest;
import com.google.cloud.backupdr.v1beta.InitializeServiceRequest;
import com.google.cloud.backupdr.v1beta.InitializeServiceResponse;
import com.google.cloud.backupdr.v1beta.InitiateDeleteAutoProtectionPolicyBindingRequest;
import com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesRequest;
import com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesResponse;
import com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesRequest;
import com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesResponse;
import com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsRequest;
import com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsResponse;
import com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsRequest;
import com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsResponse;
import com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsRequest;
import com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsResponse;
import com.google.cloud.backupdr.v1beta.ListBackupPlansRequest;
import com.google.cloud.backupdr.v1beta.ListBackupPlansResponse;
import com.google.cloud.backupdr.v1beta.ListBackupVaultsRequest;
import com.google.cloud.backupdr.v1beta.ListBackupVaultsResponse;
import com.google.cloud.backupdr.v1beta.ListBackupsRequest;
import com.google.cloud.backupdr.v1beta.ListBackupsResponse;
import com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesRequest;
import com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesResponse;
import com.google.cloud.backupdr.v1beta.ListDataSourceReferencesRequest;
import com.google.cloud.backupdr.v1beta.ListDataSourceReferencesResponse;
import com.google.cloud.backupdr.v1beta.ListDataSourcesRequest;
import com.google.cloud.backupdr.v1beta.ListDataSourcesResponse;
import com.google.cloud.backupdr.v1beta.ListManagementServersRequest;
import com.google.cloud.backupdr.v1beta.ListManagementServersResponse;
import com.google.cloud.backupdr.v1beta.ManagementServer;
import com.google.cloud.backupdr.v1beta.OperationMetadata;
import com.google.cloud.backupdr.v1beta.RestoreBackupRequest;
import com.google.cloud.backupdr.v1beta.RestoreBackupResponse;
import com.google.cloud.backupdr.v1beta.TriggerBackupRequest;
import com.google.cloud.backupdr.v1beta.UpdateAutoProtectionPolicyRequest;
import com.google.cloud.backupdr.v1beta.UpdateBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1beta.UpdateBackupPlanRequest;
import com.google.cloud.backupdr.v1beta.UpdateBackupRequest;
import com.google.cloud.backupdr.v1beta.UpdateBackupVaultRequest;
import com.google.cloud.backupdr.v1beta.UpdateDataSourceRequest;
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
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the BackupDR service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcBackupDRStub extends BackupDRStub {
  private static final MethodDescriptor<ListManagementServersRequest, ListManagementServersResponse>
      listManagementServersMethodDescriptor =
          MethodDescriptor.<ListManagementServersRequest, ListManagementServersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/ListManagementServers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListManagementServersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListManagementServersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetManagementServerRequest, ManagementServer>
      getManagementServerMethodDescriptor =
          MethodDescriptor.<GetManagementServerRequest, ManagementServer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/GetManagementServer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetManagementServerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ManagementServer.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateManagementServerRequest, Operation>
      createManagementServerMethodDescriptor =
          MethodDescriptor.<CreateManagementServerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/CreateManagementServer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateManagementServerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteManagementServerRequest, Operation>
      deleteManagementServerMethodDescriptor =
          MethodDescriptor.<DeleteManagementServerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/DeleteManagementServer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteManagementServerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateBackupVaultRequest, Operation>
      createBackupVaultMethodDescriptor =
          MethodDescriptor.<CreateBackupVaultRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/CreateBackupVault")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBackupVaultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListBackupVaultsRequest, ListBackupVaultsResponse>
      listBackupVaultsMethodDescriptor =
          MethodDescriptor.<ListBackupVaultsRequest, ListBackupVaultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/ListBackupVaults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBackupVaultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupVaultsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>
      fetchUsableBackupVaultsMethodDescriptor =
          MethodDescriptor
              .<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/FetchUsableBackupVaults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchUsableBackupVaultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchUsableBackupVaultsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBackupVaultRequest, BackupVault>
      getBackupVaultMethodDescriptor =
          MethodDescriptor.<GetBackupVaultRequest, BackupVault>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/GetBackupVault")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBackupVaultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BackupVault.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBackupVaultRequest, Operation>
      updateBackupVaultMethodDescriptor =
          MethodDescriptor.<UpdateBackupVaultRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/UpdateBackupVault")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBackupVaultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteBackupVaultRequest, Operation>
      deleteBackupVaultMethodDescriptor =
          MethodDescriptor.<DeleteBackupVaultRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/DeleteBackupVault")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBackupVaultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesMethodDescriptor =
          MethodDescriptor.<ListDataSourcesRequest, ListDataSourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/ListDataSources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataSourcesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDataSourceRequest, DataSource>
      getDataSourceMethodDescriptor =
          MethodDescriptor.<GetDataSourceRequest, DataSource>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/GetDataSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataSource.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDataSourceRequest, Operation>
      updateDataSourceMethodDescriptor =
          MethodDescriptor.<UpdateDataSourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/UpdateDataSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          MethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/ListBackups")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBackupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          FetchBackupsForResourceTypeRequest, FetchBackupsForResourceTypeResponse>
      fetchBackupsForResourceTypeMethodDescriptor =
          MethodDescriptor
              .<FetchBackupsForResourceTypeRequest, FetchBackupsForResourceTypeResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.backupdr.v1beta.BackupDR/FetchBackupsForResourceType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchBackupsForResourceTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchBackupsForResourceTypeResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBackupRequest, Backup> getBackupMethodDescriptor =
      MethodDescriptor.<GetBackupRequest, Backup>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/GetBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Backup.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateBackupRequest, Operation>
      updateBackupMethodDescriptor =
          MethodDescriptor.<UpdateBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/UpdateBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteBackupRequest, Operation>
      deleteBackupMethodDescriptor =
          MethodDescriptor.<DeleteBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/DeleteBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RestoreBackupRequest, Operation>
      restoreBackupMethodDescriptor =
          MethodDescriptor.<RestoreBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/RestoreBackup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestoreBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateBackupPlanRequest, Operation>
      createBackupPlanMethodDescriptor =
          MethodDescriptor.<CreateBackupPlanRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/CreateBackupPlan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBackupPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBackupPlanRequest, Operation>
      updateBackupPlanMethodDescriptor =
          MethodDescriptor.<UpdateBackupPlanRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/UpdateBackupPlan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBackupPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBackupPlanRequest, BackupPlan>
      getBackupPlanMethodDescriptor =
          MethodDescriptor.<GetBackupPlanRequest, BackupPlan>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/GetBackupPlan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBackupPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BackupPlan.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListBackupPlansRequest, ListBackupPlansResponse>
      listBackupPlansMethodDescriptor =
          MethodDescriptor.<ListBackupPlansRequest, ListBackupPlansResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/ListBackupPlans")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBackupPlansRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupPlansResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteBackupPlanRequest, Operation>
      deleteBackupPlanMethodDescriptor =
          MethodDescriptor.<DeleteBackupPlanRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/DeleteBackupPlan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBackupPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBackupPlanRevisionRequest, BackupPlanRevision>
      getBackupPlanRevisionMethodDescriptor =
          MethodDescriptor.<GetBackupPlanRevisionRequest, BackupPlanRevision>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/GetBackupPlanRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBackupPlanRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BackupPlanRevision.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsResponse>
      listBackupPlanRevisionsMethodDescriptor =
          MethodDescriptor
              .<ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/ListBackupPlanRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBackupPlanRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupPlanRevisionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateBackupPlanAssociationRequest, Operation>
      createBackupPlanAssociationMethodDescriptor =
          MethodDescriptor.<CreateBackupPlanAssociationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.backupdr.v1beta.BackupDR/CreateBackupPlanAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBackupPlanAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBackupPlanAssociationRequest, Operation>
      updateBackupPlanAssociationMethodDescriptor =
          MethodDescriptor.<UpdateBackupPlanAssociationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.backupdr.v1beta.BackupDR/UpdateBackupPlanAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBackupPlanAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBackupPlanAssociationRequest, BackupPlanAssociation>
      getBackupPlanAssociationMethodDescriptor =
          MethodDescriptor.<GetBackupPlanAssociationRequest, BackupPlanAssociation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/GetBackupPlanAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBackupPlanAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BackupPlanAssociation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>
      listBackupPlanAssociationsMethodDescriptor =
          MethodDescriptor
              .<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/ListBackupPlanAssociations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBackupPlanAssociationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupPlanAssociationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          FetchBackupPlanAssociationsForResourceTypeRequest,
          FetchBackupPlanAssociationsForResourceTypeResponse>
      fetchBackupPlanAssociationsForResourceTypeMethodDescriptor =
          MethodDescriptor
              .<FetchBackupPlanAssociationsForResourceTypeRequest,
                  FetchBackupPlanAssociationsForResourceTypeResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.backupdr.v1beta.BackupDR/FetchBackupPlanAssociationsForResourceType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      FetchBackupPlanAssociationsForResourceTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      FetchBackupPlanAssociationsForResourceTypeResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteBackupPlanAssociationRequest, Operation>
      deleteBackupPlanAssociationMethodDescriptor =
          MethodDescriptor.<DeleteBackupPlanAssociationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.backupdr.v1beta.BackupDR/DeleteBackupPlanAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBackupPlanAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<TriggerBackupRequest, Operation>
      triggerBackupMethodDescriptor =
          MethodDescriptor.<TriggerBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/TriggerBackup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TriggerBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDataSourceReferenceRequest, DataSourceReference>
      getDataSourceReferenceMethodDescriptor =
          MethodDescriptor.<GetDataSourceReferenceRequest, DataSourceReference>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/GetDataSourceReference")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataSourceReferenceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DataSourceReference.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListDataSourceReferencesRequest, ListDataSourceReferencesResponse>
      listDataSourceReferencesMethodDescriptor =
          MethodDescriptor
              .<ListDataSourceReferencesRequest, ListDataSourceReferencesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/ListDataSourceReferences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataSourceReferencesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataSourceReferencesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          FetchDataSourceReferencesForResourceTypeRequest,
          FetchDataSourceReferencesForResourceTypeResponse>
      fetchDataSourceReferencesForResourceTypeMethodDescriptor =
          MethodDescriptor
              .<FetchDataSourceReferencesForResourceTypeRequest,
                  FetchDataSourceReferencesForResourceTypeResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.backupdr.v1beta.BackupDR/FetchDataSourceReferencesForResourceType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      FetchDataSourceReferencesForResourceTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      FetchDataSourceReferencesForResourceTypeResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<InitializeServiceRequest, Operation>
      initializeServiceMethodDescriptor =
          MethodDescriptor.<InitializeServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/InitializeService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InitializeServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAutoProtectionPolicyRequest, Operation>
      createAutoProtectionPolicyMethodDescriptor =
          MethodDescriptor.<CreateAutoProtectionPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/CreateAutoProtectionPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAutoProtectionPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAutoProtectionPoliciesRequest, ListAutoProtectionPoliciesResponse>
      listAutoProtectionPoliciesMethodDescriptor =
          MethodDescriptor
              .<ListAutoProtectionPoliciesRequest, ListAutoProtectionPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/ListAutoProtectionPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAutoProtectionPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAutoProtectionPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAutoProtectionPolicyRequest, AutoProtectionPolicy>
      getAutoProtectionPolicyMethodDescriptor =
          MethodDescriptor.<GetAutoProtectionPolicyRequest, AutoProtectionPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/GetAutoProtectionPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAutoProtectionPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AutoProtectionPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateAutoProtectionPolicyRequest, Operation>
      updateAutoProtectionPolicyMethodDescriptor =
          MethodDescriptor.<UpdateAutoProtectionPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/UpdateAutoProtectionPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAutoProtectionPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAutoProtectionPolicyRequest, Operation>
      deleteAutoProtectionPolicyMethodDescriptor =
          MethodDescriptor.<DeleteAutoProtectionPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/DeleteAutoProtectionPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAutoProtectionPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAutoProtectionPolicyBindingRequest, Operation>
      createAutoProtectionPolicyBindingMethodDescriptor =
          MethodDescriptor.<CreateAutoProtectionPolicyBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.backupdr.v1beta.BackupDR/CreateAutoProtectionPolicyBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateAutoProtectionPolicyBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetAutoProtectionPolicyBindingRequest, AutoProtectionPolicyBinding>
      getAutoProtectionPolicyBindingMethodDescriptor =
          MethodDescriptor
              .<GetAutoProtectionPolicyBindingRequest, AutoProtectionPolicyBinding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.backupdr.v1beta.BackupDR/GetAutoProtectionPolicyBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAutoProtectionPolicyBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AutoProtectionPolicyBinding.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAutoProtectionPolicyBindingsRequest, ListAutoProtectionPolicyBindingsResponse>
      listAutoProtectionPolicyBindingsMethodDescriptor =
          MethodDescriptor
              .<ListAutoProtectionPolicyBindingsRequest, ListAutoProtectionPolicyBindingsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.backupdr.v1beta.BackupDR/ListAutoProtectionPolicyBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListAutoProtectionPolicyBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListAutoProtectionPolicyBindingsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAppliedAutoProtectionPoliciesRequest, ListAppliedAutoProtectionPoliciesResponse>
      listAppliedAutoProtectionPoliciesMethodDescriptor =
          MethodDescriptor
              .<ListAppliedAutoProtectionPoliciesRequest, ListAppliedAutoProtectionPoliciesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.backupdr.v1beta.BackupDR/ListAppliedAutoProtectionPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListAppliedAutoProtectionPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListAppliedAutoProtectionPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<InitiateDeleteAutoProtectionPolicyBindingRequest, Operation>
      initiateDeleteAutoProtectionPolicyBindingMethodDescriptor =
          MethodDescriptor.<InitiateDeleteAutoProtectionPolicyBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.backupdr.v1beta.BackupDR/InitiateDeleteAutoProtectionPolicyBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      InitiateDeleteAutoProtectionPolicyBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBindingMatchingResourceRequest, BindingMatchingResource>
      getBindingMatchingResourceMethodDescriptor =
          MethodDescriptor.<GetBindingMatchingResourceRequest, BindingMatchingResource>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1beta.BackupDR/GetBindingMatchingResource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBindingMatchingResourceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BindingMatchingResource.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListBindingMatchingResourcesRequest, ListBindingMatchingResourcesResponse>
      listBindingMatchingResourcesMethodDescriptor =
          MethodDescriptor
              .<ListBindingMatchingResourcesRequest, ListBindingMatchingResourcesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.backupdr.v1beta.BackupDR/ListBindingMatchingResources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBindingMatchingResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBindingMatchingResourcesResponse.getDefaultInstance()))
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

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
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
  private final UnaryCallable<
          FetchBackupsForResourceTypeRequest, FetchBackupsForResourceTypeResponse>
      fetchBackupsForResourceTypeCallable;
  private final UnaryCallable<
          FetchBackupsForResourceTypeRequest, FetchBackupsForResourceTypePagedResponse>
      fetchBackupsForResourceTypePagedCallable;
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
  private final UnaryCallable<UpdateBackupPlanRequest, Operation> updateBackupPlanCallable;
  private final OperationCallable<UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
      updateBackupPlanOperationCallable;
  private final UnaryCallable<GetBackupPlanRequest, BackupPlan> getBackupPlanCallable;
  private final UnaryCallable<ListBackupPlansRequest, ListBackupPlansResponse>
      listBackupPlansCallable;
  private final UnaryCallable<ListBackupPlansRequest, ListBackupPlansPagedResponse>
      listBackupPlansPagedCallable;
  private final UnaryCallable<DeleteBackupPlanRequest, Operation> deleteBackupPlanCallable;
  private final OperationCallable<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationCallable;
  private final UnaryCallable<GetBackupPlanRevisionRequest, BackupPlanRevision>
      getBackupPlanRevisionCallable;
  private final UnaryCallable<ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsResponse>
      listBackupPlanRevisionsCallable;
  private final UnaryCallable<ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsPagedResponse>
      listBackupPlanRevisionsPagedCallable;
  private final UnaryCallable<CreateBackupPlanAssociationRequest, Operation>
      createBackupPlanAssociationCallable;
  private final OperationCallable<
          CreateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
      createBackupPlanAssociationOperationCallable;
  private final UnaryCallable<UpdateBackupPlanAssociationRequest, Operation>
      updateBackupPlanAssociationCallable;
  private final OperationCallable<
          UpdateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
      updateBackupPlanAssociationOperationCallable;
  private final UnaryCallable<GetBackupPlanAssociationRequest, BackupPlanAssociation>
      getBackupPlanAssociationCallable;
  private final UnaryCallable<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>
      listBackupPlanAssociationsCallable;
  private final UnaryCallable<
          ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsPagedResponse>
      listBackupPlanAssociationsPagedCallable;
  private final UnaryCallable<
          FetchBackupPlanAssociationsForResourceTypeRequest,
          FetchBackupPlanAssociationsForResourceTypeResponse>
      fetchBackupPlanAssociationsForResourceTypeCallable;
  private final UnaryCallable<
          FetchBackupPlanAssociationsForResourceTypeRequest,
          FetchBackupPlanAssociationsForResourceTypePagedResponse>
      fetchBackupPlanAssociationsForResourceTypePagedCallable;
  private final UnaryCallable<DeleteBackupPlanAssociationRequest, Operation>
      deleteBackupPlanAssociationCallable;
  private final OperationCallable<DeleteBackupPlanAssociationRequest, Empty, OperationMetadata>
      deleteBackupPlanAssociationOperationCallable;
  private final UnaryCallable<TriggerBackupRequest, Operation> triggerBackupCallable;
  private final OperationCallable<TriggerBackupRequest, BackupPlanAssociation, OperationMetadata>
      triggerBackupOperationCallable;
  private final UnaryCallable<GetDataSourceReferenceRequest, DataSourceReference>
      getDataSourceReferenceCallable;
  private final UnaryCallable<ListDataSourceReferencesRequest, ListDataSourceReferencesResponse>
      listDataSourceReferencesCallable;
  private final UnaryCallable<
          ListDataSourceReferencesRequest, ListDataSourceReferencesPagedResponse>
      listDataSourceReferencesPagedCallable;
  private final UnaryCallable<
          FetchDataSourceReferencesForResourceTypeRequest,
          FetchDataSourceReferencesForResourceTypeResponse>
      fetchDataSourceReferencesForResourceTypeCallable;
  private final UnaryCallable<
          FetchDataSourceReferencesForResourceTypeRequest,
          FetchDataSourceReferencesForResourceTypePagedResponse>
      fetchDataSourceReferencesForResourceTypePagedCallable;
  private final UnaryCallable<InitializeServiceRequest, Operation> initializeServiceCallable;
  private final OperationCallable<
          InitializeServiceRequest, InitializeServiceResponse, OperationMetadata>
      initializeServiceOperationCallable;
  private final UnaryCallable<CreateAutoProtectionPolicyRequest, Operation>
      createAutoProtectionPolicyCallable;
  private final OperationCallable<
          CreateAutoProtectionPolicyRequest, AutoProtectionPolicy, OperationMetadata>
      createAutoProtectionPolicyOperationCallable;
  private final UnaryCallable<ListAutoProtectionPoliciesRequest, ListAutoProtectionPoliciesResponse>
      listAutoProtectionPoliciesCallable;
  private final UnaryCallable<
          ListAutoProtectionPoliciesRequest, ListAutoProtectionPoliciesPagedResponse>
      listAutoProtectionPoliciesPagedCallable;
  private final UnaryCallable<GetAutoProtectionPolicyRequest, AutoProtectionPolicy>
      getAutoProtectionPolicyCallable;
  private final UnaryCallable<UpdateAutoProtectionPolicyRequest, Operation>
      updateAutoProtectionPolicyCallable;
  private final OperationCallable<
          UpdateAutoProtectionPolicyRequest, AutoProtectionPolicy, OperationMetadata>
      updateAutoProtectionPolicyOperationCallable;
  private final UnaryCallable<DeleteAutoProtectionPolicyRequest, Operation>
      deleteAutoProtectionPolicyCallable;
  private final OperationCallable<DeleteAutoProtectionPolicyRequest, Empty, OperationMetadata>
      deleteAutoProtectionPolicyOperationCallable;
  private final UnaryCallable<CreateAutoProtectionPolicyBindingRequest, Operation>
      createAutoProtectionPolicyBindingCallable;
  private final OperationCallable<
          CreateAutoProtectionPolicyBindingRequest, AutoProtectionPolicyBinding, OperationMetadata>
      createAutoProtectionPolicyBindingOperationCallable;
  private final UnaryCallable<GetAutoProtectionPolicyBindingRequest, AutoProtectionPolicyBinding>
      getAutoProtectionPolicyBindingCallable;
  private final UnaryCallable<
          ListAutoProtectionPolicyBindingsRequest, ListAutoProtectionPolicyBindingsResponse>
      listAutoProtectionPolicyBindingsCallable;
  private final UnaryCallable<
          ListAutoProtectionPolicyBindingsRequest, ListAutoProtectionPolicyBindingsPagedResponse>
      listAutoProtectionPolicyBindingsPagedCallable;
  private final UnaryCallable<
          ListAppliedAutoProtectionPoliciesRequest, ListAppliedAutoProtectionPoliciesResponse>
      listAppliedAutoProtectionPoliciesCallable;
  private final UnaryCallable<
          ListAppliedAutoProtectionPoliciesRequest, ListAppliedAutoProtectionPoliciesPagedResponse>
      listAppliedAutoProtectionPoliciesPagedCallable;
  private final UnaryCallable<InitiateDeleteAutoProtectionPolicyBindingRequest, Operation>
      initiateDeleteAutoProtectionPolicyBindingCallable;
  private final OperationCallable<
          InitiateDeleteAutoProtectionPolicyBindingRequest,
          AutoProtectionPolicyBinding,
          OperationMetadata>
      initiateDeleteAutoProtectionPolicyBindingOperationCallable;
  private final UnaryCallable<GetBindingMatchingResourceRequest, BindingMatchingResource>
      getBindingMatchingResourceCallable;
  private final UnaryCallable<
          ListBindingMatchingResourcesRequest, ListBindingMatchingResourcesResponse>
      listBindingMatchingResourcesCallable;
  private final UnaryCallable<
          ListBindingMatchingResourcesRequest, ListBindingMatchingResourcesPagedResponse>
      listBindingMatchingResourcesPagedCallable;
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
                .setResourceNameExtractor(request -> request.getParent())
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
                .setResourceNameExtractor(request -> request.getName())
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
                .setResourceNameExtractor(request -> request.getParent())
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
                .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getParent())
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
                .setResourceNameExtractor(request -> request.getParent())
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
                .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getName())
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
                .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<FetchBackupsForResourceTypeRequest, FetchBackupsForResourceTypeResponse>
        fetchBackupsForResourceTypeTransportSettings =
            GrpcCallSettings
                .<FetchBackupsForResourceTypeRequest, FetchBackupsForResourceTypeResponse>
                    newBuilder()
                .setMethodDescriptor(fetchBackupsForResourceTypeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateBackupPlanRequest, Operation> updateBackupPlanTransportSettings =
        GrpcCallSettings.<UpdateBackupPlanRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBackupPlanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "backup_plan.name", String.valueOf(request.getBackupPlan().getName()));
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
            .setResourceNameExtractor(request -> request.getName())
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
                .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetBackupPlanRevisionRequest, BackupPlanRevision>
        getBackupPlanRevisionTransportSettings =
            GrpcCallSettings.<GetBackupPlanRevisionRequest, BackupPlanRevision>newBuilder()
                .setMethodDescriptor(getBackupPlanRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsResponse>
        listBackupPlanRevisionsTransportSettings =
            GrpcCallSettings
                .<ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsResponse>newBuilder()
                .setMethodDescriptor(listBackupPlanRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
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
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateBackupPlanAssociationRequest, Operation>
        updateBackupPlanAssociationTransportSettings =
            GrpcCallSettings.<UpdateBackupPlanAssociationRequest, Operation>newBuilder()
                .setMethodDescriptor(updateBackupPlanAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "backup_plan_association.name",
                          String.valueOf(request.getBackupPlanAssociation().getName()));
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
                .setResourceNameExtractor(request -> request.getName())
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
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<
            FetchBackupPlanAssociationsForResourceTypeRequest,
            FetchBackupPlanAssociationsForResourceTypeResponse>
        fetchBackupPlanAssociationsForResourceTypeTransportSettings =
            GrpcCallSettings
                .<FetchBackupPlanAssociationsForResourceTypeRequest,
                    FetchBackupPlanAssociationsForResourceTypeResponse>
                    newBuilder()
                .setMethodDescriptor(fetchBackupPlanAssociationsForResourceTypeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
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
                .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetDataSourceReferenceRequest, DataSourceReference>
        getDataSourceReferenceTransportSettings =
            GrpcCallSettings.<GetDataSourceReferenceRequest, DataSourceReference>newBuilder()
                .setMethodDescriptor(getDataSourceReferenceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListDataSourceReferencesRequest, ListDataSourceReferencesResponse>
        listDataSourceReferencesTransportSettings =
            GrpcCallSettings
                .<ListDataSourceReferencesRequest, ListDataSourceReferencesResponse>newBuilder()
                .setMethodDescriptor(listDataSourceReferencesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<
            FetchDataSourceReferencesForResourceTypeRequest,
            FetchDataSourceReferencesForResourceTypeResponse>
        fetchDataSourceReferencesForResourceTypeTransportSettings =
            GrpcCallSettings
                .<FetchDataSourceReferencesForResourceTypeRequest,
                    FetchDataSourceReferencesForResourceTypeResponse>
                    newBuilder()
                .setMethodDescriptor(fetchDataSourceReferencesForResourceTypeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<InitializeServiceRequest, Operation> initializeServiceTransportSettings =
        GrpcCallSettings.<InitializeServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(initializeServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateAutoProtectionPolicyRequest, Operation>
        createAutoProtectionPolicyTransportSettings =
            GrpcCallSettings.<CreateAutoProtectionPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createAutoProtectionPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<ListAutoProtectionPoliciesRequest, ListAutoProtectionPoliciesResponse>
        listAutoProtectionPoliciesTransportSettings =
            GrpcCallSettings
                .<ListAutoProtectionPoliciesRequest, ListAutoProtectionPoliciesResponse>newBuilder()
                .setMethodDescriptor(listAutoProtectionPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetAutoProtectionPolicyRequest, AutoProtectionPolicy>
        getAutoProtectionPolicyTransportSettings =
            GrpcCallSettings.<GetAutoProtectionPolicyRequest, AutoProtectionPolicy>newBuilder()
                .setMethodDescriptor(getAutoProtectionPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<UpdateAutoProtectionPolicyRequest, Operation>
        updateAutoProtectionPolicyTransportSettings =
            GrpcCallSettings.<UpdateAutoProtectionPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateAutoProtectionPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "auto_protection_policy.name",
                          String.valueOf(request.getAutoProtectionPolicy().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteAutoProtectionPolicyRequest, Operation>
        deleteAutoProtectionPolicyTransportSettings =
            GrpcCallSettings.<DeleteAutoProtectionPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteAutoProtectionPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateAutoProtectionPolicyBindingRequest, Operation>
        createAutoProtectionPolicyBindingTransportSettings =
            GrpcCallSettings.<CreateAutoProtectionPolicyBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(createAutoProtectionPolicyBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetAutoProtectionPolicyBindingRequest, AutoProtectionPolicyBinding>
        getAutoProtectionPolicyBindingTransportSettings =
            GrpcCallSettings
                .<GetAutoProtectionPolicyBindingRequest, AutoProtectionPolicyBinding>newBuilder()
                .setMethodDescriptor(getAutoProtectionPolicyBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<
            ListAutoProtectionPolicyBindingsRequest, ListAutoProtectionPolicyBindingsResponse>
        listAutoProtectionPolicyBindingsTransportSettings =
            GrpcCallSettings
                .<ListAutoProtectionPolicyBindingsRequest, ListAutoProtectionPolicyBindingsResponse>
                    newBuilder()
                .setMethodDescriptor(listAutoProtectionPolicyBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<
            ListAppliedAutoProtectionPoliciesRequest, ListAppliedAutoProtectionPoliciesResponse>
        listAppliedAutoProtectionPoliciesTransportSettings =
            GrpcCallSettings
                .<ListAppliedAutoProtectionPoliciesRequest,
                    ListAppliedAutoProtectionPoliciesResponse>
                    newBuilder()
                .setMethodDescriptor(listAppliedAutoProtectionPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<InitiateDeleteAutoProtectionPolicyBindingRequest, Operation>
        initiateDeleteAutoProtectionPolicyBindingTransportSettings =
            GrpcCallSettings
                .<InitiateDeleteAutoProtectionPolicyBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(initiateDeleteAutoProtectionPolicyBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<GetBindingMatchingResourceRequest, BindingMatchingResource>
        getBindingMatchingResourceTransportSettings =
            GrpcCallSettings
                .<GetBindingMatchingResourceRequest, BindingMatchingResource>newBuilder()
                .setMethodDescriptor(getBindingMatchingResourceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListBindingMatchingResourcesRequest, ListBindingMatchingResourcesResponse>
        listBindingMatchingResourcesTransportSettings =
            GrpcCallSettings
                .<ListBindingMatchingResourcesRequest, ListBindingMatchingResourcesResponse>
                    newBuilder()
                .setMethodDescriptor(listBindingMatchingResourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getResource())
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
            .setResourceNameExtractor(request -> request.getResource())
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
                .setResourceNameExtractor(request -> request.getResource())
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
    this.fetchBackupsForResourceTypeCallable =
        callableFactory.createUnaryCallable(
            fetchBackupsForResourceTypeTransportSettings,
            settings.fetchBackupsForResourceTypeSettings(),
            clientContext);
    this.fetchBackupsForResourceTypePagedCallable =
        callableFactory.createPagedCallable(
            fetchBackupsForResourceTypeTransportSettings,
            settings.fetchBackupsForResourceTypeSettings(),
            clientContext);
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
    this.updateBackupPlanCallable =
        callableFactory.createUnaryCallable(
            updateBackupPlanTransportSettings, settings.updateBackupPlanSettings(), clientContext);
    this.updateBackupPlanOperationCallable =
        callableFactory.createOperationCallable(
            updateBackupPlanTransportSettings,
            settings.updateBackupPlanOperationSettings(),
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
    this.getBackupPlanRevisionCallable =
        callableFactory.createUnaryCallable(
            getBackupPlanRevisionTransportSettings,
            settings.getBackupPlanRevisionSettings(),
            clientContext);
    this.listBackupPlanRevisionsCallable =
        callableFactory.createUnaryCallable(
            listBackupPlanRevisionsTransportSettings,
            settings.listBackupPlanRevisionsSettings(),
            clientContext);
    this.listBackupPlanRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupPlanRevisionsTransportSettings,
            settings.listBackupPlanRevisionsSettings(),
            clientContext);
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
    this.updateBackupPlanAssociationCallable =
        callableFactory.createUnaryCallable(
            updateBackupPlanAssociationTransportSettings,
            settings.updateBackupPlanAssociationSettings(),
            clientContext);
    this.updateBackupPlanAssociationOperationCallable =
        callableFactory.createOperationCallable(
            updateBackupPlanAssociationTransportSettings,
            settings.updateBackupPlanAssociationOperationSettings(),
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
    this.fetchBackupPlanAssociationsForResourceTypeCallable =
        callableFactory.createUnaryCallable(
            fetchBackupPlanAssociationsForResourceTypeTransportSettings,
            settings.fetchBackupPlanAssociationsForResourceTypeSettings(),
            clientContext);
    this.fetchBackupPlanAssociationsForResourceTypePagedCallable =
        callableFactory.createPagedCallable(
            fetchBackupPlanAssociationsForResourceTypeTransportSettings,
            settings.fetchBackupPlanAssociationsForResourceTypeSettings(),
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
    this.getDataSourceReferenceCallable =
        callableFactory.createUnaryCallable(
            getDataSourceReferenceTransportSettings,
            settings.getDataSourceReferenceSettings(),
            clientContext);
    this.listDataSourceReferencesCallable =
        callableFactory.createUnaryCallable(
            listDataSourceReferencesTransportSettings,
            settings.listDataSourceReferencesSettings(),
            clientContext);
    this.listDataSourceReferencesPagedCallable =
        callableFactory.createPagedCallable(
            listDataSourceReferencesTransportSettings,
            settings.listDataSourceReferencesSettings(),
            clientContext);
    this.fetchDataSourceReferencesForResourceTypeCallable =
        callableFactory.createUnaryCallable(
            fetchDataSourceReferencesForResourceTypeTransportSettings,
            settings.fetchDataSourceReferencesForResourceTypeSettings(),
            clientContext);
    this.fetchDataSourceReferencesForResourceTypePagedCallable =
        callableFactory.createPagedCallable(
            fetchDataSourceReferencesForResourceTypeTransportSettings,
            settings.fetchDataSourceReferencesForResourceTypeSettings(),
            clientContext);
    this.initializeServiceCallable =
        callableFactory.createUnaryCallable(
            initializeServiceTransportSettings,
            settings.initializeServiceSettings(),
            clientContext);
    this.initializeServiceOperationCallable =
        callableFactory.createOperationCallable(
            initializeServiceTransportSettings,
            settings.initializeServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.createAutoProtectionPolicyCallable =
        callableFactory.createUnaryCallable(
            createAutoProtectionPolicyTransportSettings,
            settings.createAutoProtectionPolicySettings(),
            clientContext);
    this.createAutoProtectionPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createAutoProtectionPolicyTransportSettings,
            settings.createAutoProtectionPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.listAutoProtectionPoliciesCallable =
        callableFactory.createUnaryCallable(
            listAutoProtectionPoliciesTransportSettings,
            settings.listAutoProtectionPoliciesSettings(),
            clientContext);
    this.listAutoProtectionPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listAutoProtectionPoliciesTransportSettings,
            settings.listAutoProtectionPoliciesSettings(),
            clientContext);
    this.getAutoProtectionPolicyCallable =
        callableFactory.createUnaryCallable(
            getAutoProtectionPolicyTransportSettings,
            settings.getAutoProtectionPolicySettings(),
            clientContext);
    this.updateAutoProtectionPolicyCallable =
        callableFactory.createUnaryCallable(
            updateAutoProtectionPolicyTransportSettings,
            settings.updateAutoProtectionPolicySettings(),
            clientContext);
    this.updateAutoProtectionPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateAutoProtectionPolicyTransportSettings,
            settings.updateAutoProtectionPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAutoProtectionPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteAutoProtectionPolicyTransportSettings,
            settings.deleteAutoProtectionPolicySettings(),
            clientContext);
    this.deleteAutoProtectionPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteAutoProtectionPolicyTransportSettings,
            settings.deleteAutoProtectionPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.createAutoProtectionPolicyBindingCallable =
        callableFactory.createUnaryCallable(
            createAutoProtectionPolicyBindingTransportSettings,
            settings.createAutoProtectionPolicyBindingSettings(),
            clientContext);
    this.createAutoProtectionPolicyBindingOperationCallable =
        callableFactory.createOperationCallable(
            createAutoProtectionPolicyBindingTransportSettings,
            settings.createAutoProtectionPolicyBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.getAutoProtectionPolicyBindingCallable =
        callableFactory.createUnaryCallable(
            getAutoProtectionPolicyBindingTransportSettings,
            settings.getAutoProtectionPolicyBindingSettings(),
            clientContext);
    this.listAutoProtectionPolicyBindingsCallable =
        callableFactory.createUnaryCallable(
            listAutoProtectionPolicyBindingsTransportSettings,
            settings.listAutoProtectionPolicyBindingsSettings(),
            clientContext);
    this.listAutoProtectionPolicyBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listAutoProtectionPolicyBindingsTransportSettings,
            settings.listAutoProtectionPolicyBindingsSettings(),
            clientContext);
    this.listAppliedAutoProtectionPoliciesCallable =
        callableFactory.createUnaryCallable(
            listAppliedAutoProtectionPoliciesTransportSettings,
            settings.listAppliedAutoProtectionPoliciesSettings(),
            clientContext);
    this.listAppliedAutoProtectionPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listAppliedAutoProtectionPoliciesTransportSettings,
            settings.listAppliedAutoProtectionPoliciesSettings(),
            clientContext);
    this.initiateDeleteAutoProtectionPolicyBindingCallable =
        callableFactory.createUnaryCallable(
            initiateDeleteAutoProtectionPolicyBindingTransportSettings,
            settings.initiateDeleteAutoProtectionPolicyBindingSettings(),
            clientContext);
    this.initiateDeleteAutoProtectionPolicyBindingOperationCallable =
        callableFactory.createOperationCallable(
            initiateDeleteAutoProtectionPolicyBindingTransportSettings,
            settings.initiateDeleteAutoProtectionPolicyBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.getBindingMatchingResourceCallable =
        callableFactory.createUnaryCallable(
            getBindingMatchingResourceTransportSettings,
            settings.getBindingMatchingResourceSettings(),
            clientContext);
    this.listBindingMatchingResourcesCallable =
        callableFactory.createUnaryCallable(
            listBindingMatchingResourcesTransportSettings,
            settings.listBindingMatchingResourcesSettings(),
            clientContext);
    this.listBindingMatchingResourcesPagedCallable =
        callableFactory.createPagedCallable(
            listBindingMatchingResourcesTransportSettings,
            settings.listBindingMatchingResourcesSettings(),
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
  public UnaryCallable<FetchBackupsForResourceTypeRequest, FetchBackupsForResourceTypeResponse>
      fetchBackupsForResourceTypeCallable() {
    return fetchBackupsForResourceTypeCallable;
  }

  @Override
  public UnaryCallable<FetchBackupsForResourceTypeRequest, FetchBackupsForResourceTypePagedResponse>
      fetchBackupsForResourceTypePagedCallable() {
    return fetchBackupsForResourceTypePagedCallable;
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
  public UnaryCallable<UpdateBackupPlanRequest, Operation> updateBackupPlanCallable() {
    return updateBackupPlanCallable;
  }

  @Override
  public OperationCallable<UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
      updateBackupPlanOperationCallable() {
    return updateBackupPlanOperationCallable;
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
  public UnaryCallable<GetBackupPlanRevisionRequest, BackupPlanRevision>
      getBackupPlanRevisionCallable() {
    return getBackupPlanRevisionCallable;
  }

  @Override
  public UnaryCallable<ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsResponse>
      listBackupPlanRevisionsCallable() {
    return listBackupPlanRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsPagedResponse>
      listBackupPlanRevisionsPagedCallable() {
    return listBackupPlanRevisionsPagedCallable;
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
  public UnaryCallable<UpdateBackupPlanAssociationRequest, Operation>
      updateBackupPlanAssociationCallable() {
    return updateBackupPlanAssociationCallable;
  }

  @Override
  public OperationCallable<
          UpdateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
      updateBackupPlanAssociationOperationCallable() {
    return updateBackupPlanAssociationOperationCallable;
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
  public UnaryCallable<
          FetchBackupPlanAssociationsForResourceTypeRequest,
          FetchBackupPlanAssociationsForResourceTypeResponse>
      fetchBackupPlanAssociationsForResourceTypeCallable() {
    return fetchBackupPlanAssociationsForResourceTypeCallable;
  }

  @Override
  public UnaryCallable<
          FetchBackupPlanAssociationsForResourceTypeRequest,
          FetchBackupPlanAssociationsForResourceTypePagedResponse>
      fetchBackupPlanAssociationsForResourceTypePagedCallable() {
    return fetchBackupPlanAssociationsForResourceTypePagedCallable;
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
  public UnaryCallable<GetDataSourceReferenceRequest, DataSourceReference>
      getDataSourceReferenceCallable() {
    return getDataSourceReferenceCallable;
  }

  @Override
  public UnaryCallable<ListDataSourceReferencesRequest, ListDataSourceReferencesResponse>
      listDataSourceReferencesCallable() {
    return listDataSourceReferencesCallable;
  }

  @Override
  public UnaryCallable<ListDataSourceReferencesRequest, ListDataSourceReferencesPagedResponse>
      listDataSourceReferencesPagedCallable() {
    return listDataSourceReferencesPagedCallable;
  }

  @Override
  public UnaryCallable<
          FetchDataSourceReferencesForResourceTypeRequest,
          FetchDataSourceReferencesForResourceTypeResponse>
      fetchDataSourceReferencesForResourceTypeCallable() {
    return fetchDataSourceReferencesForResourceTypeCallable;
  }

  @Override
  public UnaryCallable<
          FetchDataSourceReferencesForResourceTypeRequest,
          FetchDataSourceReferencesForResourceTypePagedResponse>
      fetchDataSourceReferencesForResourceTypePagedCallable() {
    return fetchDataSourceReferencesForResourceTypePagedCallable;
  }

  @Override
  public UnaryCallable<InitializeServiceRequest, Operation> initializeServiceCallable() {
    return initializeServiceCallable;
  }

  @Override
  public OperationCallable<InitializeServiceRequest, InitializeServiceResponse, OperationMetadata>
      initializeServiceOperationCallable() {
    return initializeServiceOperationCallable;
  }

  @Override
  public UnaryCallable<CreateAutoProtectionPolicyRequest, Operation>
      createAutoProtectionPolicyCallable() {
    return createAutoProtectionPolicyCallable;
  }

  @Override
  public OperationCallable<
          CreateAutoProtectionPolicyRequest, AutoProtectionPolicy, OperationMetadata>
      createAutoProtectionPolicyOperationCallable() {
    return createAutoProtectionPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListAutoProtectionPoliciesRequest, ListAutoProtectionPoliciesResponse>
      listAutoProtectionPoliciesCallable() {
    return listAutoProtectionPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListAutoProtectionPoliciesRequest, ListAutoProtectionPoliciesPagedResponse>
      listAutoProtectionPoliciesPagedCallable() {
    return listAutoProtectionPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAutoProtectionPolicyRequest, AutoProtectionPolicy>
      getAutoProtectionPolicyCallable() {
    return getAutoProtectionPolicyCallable;
  }

  @Override
  public UnaryCallable<UpdateAutoProtectionPolicyRequest, Operation>
      updateAutoProtectionPolicyCallable() {
    return updateAutoProtectionPolicyCallable;
  }

  @Override
  public OperationCallable<
          UpdateAutoProtectionPolicyRequest, AutoProtectionPolicy, OperationMetadata>
      updateAutoProtectionPolicyOperationCallable() {
    return updateAutoProtectionPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAutoProtectionPolicyRequest, Operation>
      deleteAutoProtectionPolicyCallable() {
    return deleteAutoProtectionPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteAutoProtectionPolicyRequest, Empty, OperationMetadata>
      deleteAutoProtectionPolicyOperationCallable() {
    return deleteAutoProtectionPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<CreateAutoProtectionPolicyBindingRequest, Operation>
      createAutoProtectionPolicyBindingCallable() {
    return createAutoProtectionPolicyBindingCallable;
  }

  @Override
  public OperationCallable<
          CreateAutoProtectionPolicyBindingRequest, AutoProtectionPolicyBinding, OperationMetadata>
      createAutoProtectionPolicyBindingOperationCallable() {
    return createAutoProtectionPolicyBindingOperationCallable;
  }

  @Override
  public UnaryCallable<GetAutoProtectionPolicyBindingRequest, AutoProtectionPolicyBinding>
      getAutoProtectionPolicyBindingCallable() {
    return getAutoProtectionPolicyBindingCallable;
  }

  @Override
  public UnaryCallable<
          ListAutoProtectionPolicyBindingsRequest, ListAutoProtectionPolicyBindingsResponse>
      listAutoProtectionPolicyBindingsCallable() {
    return listAutoProtectionPolicyBindingsCallable;
  }

  @Override
  public UnaryCallable<
          ListAutoProtectionPolicyBindingsRequest, ListAutoProtectionPolicyBindingsPagedResponse>
      listAutoProtectionPolicyBindingsPagedCallable() {
    return listAutoProtectionPolicyBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListAppliedAutoProtectionPoliciesRequest, ListAppliedAutoProtectionPoliciesResponse>
      listAppliedAutoProtectionPoliciesCallable() {
    return listAppliedAutoProtectionPoliciesCallable;
  }

  @Override
  public UnaryCallable<
          ListAppliedAutoProtectionPoliciesRequest, ListAppliedAutoProtectionPoliciesPagedResponse>
      listAppliedAutoProtectionPoliciesPagedCallable() {
    return listAppliedAutoProtectionPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<InitiateDeleteAutoProtectionPolicyBindingRequest, Operation>
      initiateDeleteAutoProtectionPolicyBindingCallable() {
    return initiateDeleteAutoProtectionPolicyBindingCallable;
  }

  @Override
  public OperationCallable<
          InitiateDeleteAutoProtectionPolicyBindingRequest,
          AutoProtectionPolicyBinding,
          OperationMetadata>
      initiateDeleteAutoProtectionPolicyBindingOperationCallable() {
    return initiateDeleteAutoProtectionPolicyBindingOperationCallable;
  }

  @Override
  public UnaryCallable<GetBindingMatchingResourceRequest, BindingMatchingResource>
      getBindingMatchingResourceCallable() {
    return getBindingMatchingResourceCallable;
  }

  @Override
  public UnaryCallable<ListBindingMatchingResourcesRequest, ListBindingMatchingResourcesResponse>
      listBindingMatchingResourcesCallable() {
    return listBindingMatchingResourcesCallable;
  }

  @Override
  public UnaryCallable<
          ListBindingMatchingResourcesRequest, ListBindingMatchingResourcesPagedResponse>
      listBindingMatchingResourcesPagedCallable() {
    return listBindingMatchingResourcesPagedCallable;
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
