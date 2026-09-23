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
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BackupDR service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public abstract class BackupDRStub implements BackgroundResource {

  public @Nullable OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.@Nullable OperationsStub
      getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListManagementServersRequest, ListManagementServersPagedResponse>
      listManagementServersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listManagementServersPagedCallable()");
  }

  public UnaryCallable<ListManagementServersRequest, ListManagementServersResponse>
      listManagementServersCallable() {
    throw new UnsupportedOperationException("Not implemented: listManagementServersCallable()");
  }

  public UnaryCallable<GetManagementServerRequest, ManagementServer> getManagementServerCallable() {
    throw new UnsupportedOperationException("Not implemented: getManagementServerCallable()");
  }

  public OperationCallable<CreateManagementServerRequest, ManagementServer, OperationMetadata>
      createManagementServerOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createManagementServerOperationCallable()");
  }

  public UnaryCallable<CreateManagementServerRequest, Operation> createManagementServerCallable() {
    throw new UnsupportedOperationException("Not implemented: createManagementServerCallable()");
  }

  public OperationCallable<DeleteManagementServerRequest, Empty, OperationMetadata>
      deleteManagementServerOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteManagementServerOperationCallable()");
  }

  public UnaryCallable<DeleteManagementServerRequest, Operation> deleteManagementServerCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteManagementServerCallable()");
  }

  public OperationCallable<CreateBackupVaultRequest, BackupVault, OperationMetadata>
      createBackupVaultOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createBackupVaultOperationCallable()");
  }

  public UnaryCallable<CreateBackupVaultRequest, Operation> createBackupVaultCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupVaultCallable()");
  }

  public UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsPagedResponse>
      listBackupVaultsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupVaultsPagedCallable()");
  }

  public UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsResponse>
      listBackupVaultsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupVaultsCallable()");
  }

  public UnaryCallable<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsPagedResponse>
      fetchUsableBackupVaultsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchUsableBackupVaultsPagedCallable()");
  }

  public UnaryCallable<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>
      fetchUsableBackupVaultsCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchUsableBackupVaultsCallable()");
  }

  public UnaryCallable<GetBackupVaultRequest, BackupVault> getBackupVaultCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackupVaultCallable()");
  }

  public OperationCallable<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
      updateBackupVaultOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateBackupVaultOperationCallable()");
  }

  public UnaryCallable<UpdateBackupVaultRequest, Operation> updateBackupVaultCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackupVaultCallable()");
  }

  public OperationCallable<DeleteBackupVaultRequest, Empty, OperationMetadata>
      deleteBackupVaultOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteBackupVaultOperationCallable()");
  }

  public UnaryCallable<DeleteBackupVaultRequest, Operation> deleteBackupVaultCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupVaultCallable()");
  }

  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataSourcesPagedCallable()");
  }

  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse> listDataSourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataSourcesCallable()");
  }

  public UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataSourceCallable()");
  }

  public OperationCallable<UpdateDataSourceRequest, DataSource, OperationMetadata>
      updateDataSourceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataSourceOperationCallable()");
  }

  public UnaryCallable<UpdateDataSourceRequest, Operation> updateDataSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataSourceCallable()");
  }

  public UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse> listBackupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupsPagedCallable()");
  }

  public UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupsCallable()");
  }

  public UnaryCallable<FetchBackupsForResourceTypeRequest, FetchBackupsForResourceTypePagedResponse>
      fetchBackupsForResourceTypePagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchBackupsForResourceTypePagedCallable()");
  }

  public UnaryCallable<FetchBackupsForResourceTypeRequest, FetchBackupsForResourceTypeResponse>
      fetchBackupsForResourceTypeCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchBackupsForResourceTypeCallable()");
  }

  public UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackupCallable()");
  }

  public OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackupOperationCallable()");
  }

  public UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackupCallable()");
  }

  public OperationCallable<DeleteBackupRequest, Backup, OperationMetadata>
      deleteBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupOperationCallable()");
  }

  public UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupCallable()");
  }

  public OperationCallable<RestoreBackupRequest, RestoreBackupResponse, OperationMetadata>
      restoreBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreBackupOperationCallable()");
  }

  public UnaryCallable<RestoreBackupRequest, Operation> restoreBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreBackupCallable()");
  }

  public OperationCallable<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupPlanOperationCallable()");
  }

  public UnaryCallable<CreateBackupPlanRequest, Operation> createBackupPlanCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupPlanCallable()");
  }

  public OperationCallable<UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
      updateBackupPlanOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackupPlanOperationCallable()");
  }

  public UnaryCallable<UpdateBackupPlanRequest, Operation> updateBackupPlanCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackupPlanCallable()");
  }

  public UnaryCallable<GetBackupPlanRequest, BackupPlan> getBackupPlanCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackupPlanCallable()");
  }

  public UnaryCallable<ListBackupPlansRequest, ListBackupPlansPagedResponse>
      listBackupPlansPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupPlansPagedCallable()");
  }

  public UnaryCallable<ListBackupPlansRequest, ListBackupPlansResponse> listBackupPlansCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupPlansCallable()");
  }

  public OperationCallable<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupPlanOperationCallable()");
  }

  public UnaryCallable<DeleteBackupPlanRequest, Operation> deleteBackupPlanCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupPlanCallable()");
  }

  public UnaryCallable<GetBackupPlanRevisionRequest, BackupPlanRevision>
      getBackupPlanRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackupPlanRevisionCallable()");
  }

  public UnaryCallable<ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsPagedResponse>
      listBackupPlanRevisionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listBackupPlanRevisionsPagedCallable()");
  }

  public UnaryCallable<ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsResponse>
      listBackupPlanRevisionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupPlanRevisionsCallable()");
  }

  public OperationCallable<
          CreateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
      createBackupPlanAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createBackupPlanAssociationOperationCallable()");
  }

  public UnaryCallable<CreateBackupPlanAssociationRequest, Operation>
      createBackupPlanAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createBackupPlanAssociationCallable()");
  }

  public OperationCallable<
          UpdateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
      updateBackupPlanAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateBackupPlanAssociationOperationCallable()");
  }

  public UnaryCallable<UpdateBackupPlanAssociationRequest, Operation>
      updateBackupPlanAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateBackupPlanAssociationCallable()");
  }

  public UnaryCallable<GetBackupPlanAssociationRequest, BackupPlanAssociation>
      getBackupPlanAssociationCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackupPlanAssociationCallable()");
  }

  public UnaryCallable<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsPagedResponse>
      listBackupPlanAssociationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listBackupPlanAssociationsPagedCallable()");
  }

  public UnaryCallable<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>
      listBackupPlanAssociationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listBackupPlanAssociationsCallable()");
  }

  public UnaryCallable<
          FetchBackupPlanAssociationsForResourceTypeRequest,
          FetchBackupPlanAssociationsForResourceTypePagedResponse>
      fetchBackupPlanAssociationsForResourceTypePagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchBackupPlanAssociationsForResourceTypePagedCallable()");
  }

  public UnaryCallable<
          FetchBackupPlanAssociationsForResourceTypeRequest,
          FetchBackupPlanAssociationsForResourceTypeResponse>
      fetchBackupPlanAssociationsForResourceTypeCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchBackupPlanAssociationsForResourceTypeCallable()");
  }

  public OperationCallable<DeleteBackupPlanAssociationRequest, Empty, OperationMetadata>
      deleteBackupPlanAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteBackupPlanAssociationOperationCallable()");
  }

  public UnaryCallable<DeleteBackupPlanAssociationRequest, Operation>
      deleteBackupPlanAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteBackupPlanAssociationCallable()");
  }

  public OperationCallable<TriggerBackupRequest, BackupPlanAssociation, OperationMetadata>
      triggerBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: triggerBackupOperationCallable()");
  }

  public UnaryCallable<TriggerBackupRequest, Operation> triggerBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: triggerBackupCallable()");
  }

  public UnaryCallable<GetDataSourceReferenceRequest, DataSourceReference>
      getDataSourceReferenceCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataSourceReferenceCallable()");
  }

  public UnaryCallable<ListDataSourceReferencesRequest, ListDataSourceReferencesPagedResponse>
      listDataSourceReferencesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDataSourceReferencesPagedCallable()");
  }

  public UnaryCallable<ListDataSourceReferencesRequest, ListDataSourceReferencesResponse>
      listDataSourceReferencesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataSourceReferencesCallable()");
  }

  public UnaryCallable<
          FetchDataSourceReferencesForResourceTypeRequest,
          FetchDataSourceReferencesForResourceTypePagedResponse>
      fetchDataSourceReferencesForResourceTypePagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchDataSourceReferencesForResourceTypePagedCallable()");
  }

  public UnaryCallable<
          FetchDataSourceReferencesForResourceTypeRequest,
          FetchDataSourceReferencesForResourceTypeResponse>
      fetchDataSourceReferencesForResourceTypeCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchDataSourceReferencesForResourceTypeCallable()");
  }

  public OperationCallable<InitializeServiceRequest, InitializeServiceResponse, OperationMetadata>
      initializeServiceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: initializeServiceOperationCallable()");
  }

  public UnaryCallable<InitializeServiceRequest, Operation> initializeServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: initializeServiceCallable()");
  }

  public OperationCallable<
          CreateAutoProtectionPolicyRequest, AutoProtectionPolicy, OperationMetadata>
      createAutoProtectionPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAutoProtectionPolicyOperationCallable()");
  }

  public UnaryCallable<CreateAutoProtectionPolicyRequest, Operation>
      createAutoProtectionPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAutoProtectionPolicyCallable()");
  }

  public UnaryCallable<ListAutoProtectionPoliciesRequest, ListAutoProtectionPoliciesPagedResponse>
      listAutoProtectionPoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAutoProtectionPoliciesPagedCallable()");
  }

  public UnaryCallable<ListAutoProtectionPoliciesRequest, ListAutoProtectionPoliciesResponse>
      listAutoProtectionPoliciesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAutoProtectionPoliciesCallable()");
  }

  public UnaryCallable<GetAutoProtectionPolicyRequest, AutoProtectionPolicy>
      getAutoProtectionPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getAutoProtectionPolicyCallable()");
  }

  public OperationCallable<
          UpdateAutoProtectionPolicyRequest, AutoProtectionPolicy, OperationMetadata>
      updateAutoProtectionPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAutoProtectionPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateAutoProtectionPolicyRequest, Operation>
      updateAutoProtectionPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAutoProtectionPolicyCallable()");
  }

  public OperationCallable<DeleteAutoProtectionPolicyRequest, Empty, OperationMetadata>
      deleteAutoProtectionPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAutoProtectionPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteAutoProtectionPolicyRequest, Operation>
      deleteAutoProtectionPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAutoProtectionPolicyCallable()");
  }

  public OperationCallable<
          CreateAutoProtectionPolicyBindingRequest, AutoProtectionPolicyBinding, OperationMetadata>
      createAutoProtectionPolicyBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAutoProtectionPolicyBindingOperationCallable()");
  }

  public UnaryCallable<CreateAutoProtectionPolicyBindingRequest, Operation>
      createAutoProtectionPolicyBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAutoProtectionPolicyBindingCallable()");
  }

  public UnaryCallable<GetAutoProtectionPolicyBindingRequest, AutoProtectionPolicyBinding>
      getAutoProtectionPolicyBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getAutoProtectionPolicyBindingCallable()");
  }

  public UnaryCallable<
          ListAutoProtectionPolicyBindingsRequest, ListAutoProtectionPolicyBindingsPagedResponse>
      listAutoProtectionPolicyBindingsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAutoProtectionPolicyBindingsPagedCallable()");
  }

  public UnaryCallable<
          ListAutoProtectionPolicyBindingsRequest, ListAutoProtectionPolicyBindingsResponse>
      listAutoProtectionPolicyBindingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAutoProtectionPolicyBindingsCallable()");
  }

  public UnaryCallable<
          ListAppliedAutoProtectionPoliciesRequest, ListAppliedAutoProtectionPoliciesPagedResponse>
      listAppliedAutoProtectionPoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAppliedAutoProtectionPoliciesPagedCallable()");
  }

  public UnaryCallable<
          ListAppliedAutoProtectionPoliciesRequest, ListAppliedAutoProtectionPoliciesResponse>
      listAppliedAutoProtectionPoliciesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAppliedAutoProtectionPoliciesCallable()");
  }

  public OperationCallable<
          InitiateDeleteAutoProtectionPolicyBindingRequest,
          AutoProtectionPolicyBinding,
          OperationMetadata>
      initiateDeleteAutoProtectionPolicyBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: initiateDeleteAutoProtectionPolicyBindingOperationCallable()");
  }

  public UnaryCallable<InitiateDeleteAutoProtectionPolicyBindingRequest, Operation>
      initiateDeleteAutoProtectionPolicyBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: initiateDeleteAutoProtectionPolicyBindingCallable()");
  }

  public UnaryCallable<GetBindingMatchingResourceRequest, BindingMatchingResource>
      getBindingMatchingResourceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getBindingMatchingResourceCallable()");
  }

  public UnaryCallable<
          ListBindingMatchingResourcesRequest, ListBindingMatchingResourcesPagedResponse>
      listBindingMatchingResourcesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listBindingMatchingResourcesPagedCallable()");
  }

  public UnaryCallable<ListBindingMatchingResourcesRequest, ListBindingMatchingResourcesResponse>
      listBindingMatchingResourcesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listBindingMatchingResourcesCallable()");
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

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
