/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.securitycenter.v2.stub;

import static com.google.cloud.securitycenter.v2.SecurityCenterClient.GroupFindingsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListAttackPathsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListBigQueryExportsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListFindingsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListMuteConfigsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListNotificationConfigsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListResourceValueConfigsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListSourcesPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListValuedResourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsRequest;
import com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsResponse;
import com.google.cloud.securitycenter.v2.BigQueryExport;
import com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest;
import com.google.cloud.securitycenter.v2.BulkMuteFindingsResponse;
import com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.CreateFindingRequest;
import com.google.cloud.securitycenter.v2.CreateMuteConfigRequest;
import com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.CreateSourceRequest;
import com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest;
import com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest;
import com.google.cloud.securitycenter.v2.ExternalSystem;
import com.google.cloud.securitycenter.v2.Finding;
import com.google.cloud.securitycenter.v2.GetBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.GetMuteConfigRequest;
import com.google.cloud.securitycenter.v2.GetNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest;
import com.google.cloud.securitycenter.v2.GetSimulationRequest;
import com.google.cloud.securitycenter.v2.GetSourceRequest;
import com.google.cloud.securitycenter.v2.GetValuedResourceRequest;
import com.google.cloud.securitycenter.v2.GroupFindingsRequest;
import com.google.cloud.securitycenter.v2.GroupFindingsResponse;
import com.google.cloud.securitycenter.v2.ListAttackPathsRequest;
import com.google.cloud.securitycenter.v2.ListAttackPathsResponse;
import com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest;
import com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse;
import com.google.cloud.securitycenter.v2.ListFindingsRequest;
import com.google.cloud.securitycenter.v2.ListFindingsResponse;
import com.google.cloud.securitycenter.v2.ListMuteConfigsRequest;
import com.google.cloud.securitycenter.v2.ListMuteConfigsResponse;
import com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest;
import com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse;
import com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest;
import com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse;
import com.google.cloud.securitycenter.v2.ListSourcesRequest;
import com.google.cloud.securitycenter.v2.ListSourcesResponse;
import com.google.cloud.securitycenter.v2.ListValuedResourcesRequest;
import com.google.cloud.securitycenter.v2.ListValuedResourcesResponse;
import com.google.cloud.securitycenter.v2.MuteConfig;
import com.google.cloud.securitycenter.v2.NotificationConfig;
import com.google.cloud.securitycenter.v2.ResourceValueConfig;
import com.google.cloud.securitycenter.v2.SecurityMarks;
import com.google.cloud.securitycenter.v2.SetFindingStateRequest;
import com.google.cloud.securitycenter.v2.SetMuteRequest;
import com.google.cloud.securitycenter.v2.Simulation;
import com.google.cloud.securitycenter.v2.Source;
import com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest;
import com.google.cloud.securitycenter.v2.UpdateFindingRequest;
import com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest;
import com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest;
import com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest;
import com.google.cloud.securitycenter.v2.UpdateSourceRequest;
import com.google.cloud.securitycenter.v2.ValuedResource;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SecurityCenter service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SecurityCenterStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<
          BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
      batchCreateResourceValueConfigsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateResourceValueConfigsCallable()");
  }

  public OperationCallable<BulkMuteFindingsRequest, BulkMuteFindingsResponse, Empty>
      bulkMuteFindingsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: bulkMuteFindingsOperationCallable()");
  }

  public UnaryCallable<BulkMuteFindingsRequest, Operation> bulkMuteFindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: bulkMuteFindingsCallable()");
  }

  public UnaryCallable<CreateBigQueryExportRequest, BigQueryExport> createBigQueryExportCallable() {
    throw new UnsupportedOperationException("Not implemented: createBigQueryExportCallable()");
  }

  public UnaryCallable<CreateFindingRequest, Finding> createFindingCallable() {
    throw new UnsupportedOperationException("Not implemented: createFindingCallable()");
  }

  public UnaryCallable<CreateMuteConfigRequest, MuteConfig> createMuteConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createMuteConfigCallable()");
  }

  public UnaryCallable<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createNotificationConfigCallable()");
  }

  public UnaryCallable<CreateSourceRequest, Source> createSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: createSourceCallable()");
  }

  public UnaryCallable<DeleteBigQueryExportRequest, Empty> deleteBigQueryExportCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBigQueryExportCallable()");
  }

  public UnaryCallable<DeleteMuteConfigRequest, Empty> deleteMuteConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMuteConfigCallable()");
  }

  public UnaryCallable<DeleteNotificationConfigRequest, Empty> deleteNotificationConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNotificationConfigCallable()");
  }

  public UnaryCallable<DeleteResourceValueConfigRequest, Empty>
      deleteResourceValueConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteResourceValueConfigCallable()");
  }

  public UnaryCallable<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportCallable() {
    throw new UnsupportedOperationException("Not implemented: getBigQueryExportCallable()");
  }

  public UnaryCallable<GetSimulationRequest, Simulation> getSimulationCallable() {
    throw new UnsupportedOperationException("Not implemented: getSimulationCallable()");
  }

  public UnaryCallable<GetValuedResourceRequest, ValuedResource> getValuedResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: getValuedResourceCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<GetMuteConfigRequest, MuteConfig> getMuteConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getMuteConfigCallable()");
  }

  public UnaryCallable<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getNotificationConfigCallable()");
  }

  public UnaryCallable<GetResourceValueConfigRequest, ResourceValueConfig>
      getResourceValueConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getResourceValueConfigCallable()");
  }

  public UnaryCallable<GetSourceRequest, Source> getSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: getSourceCallable()");
  }

  public UnaryCallable<GroupFindingsRequest, GroupFindingsPagedResponse>
      groupFindingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: groupFindingsPagedCallable()");
  }

  public UnaryCallable<GroupFindingsRequest, GroupFindingsResponse> groupFindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: groupFindingsCallable()");
  }

  public UnaryCallable<ListAttackPathsRequest, ListAttackPathsPagedResponse>
      listAttackPathsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAttackPathsPagedCallable()");
  }

  public UnaryCallable<ListAttackPathsRequest, ListAttackPathsResponse> listAttackPathsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAttackPathsCallable()");
  }

  public UnaryCallable<ListBigQueryExportsRequest, ListBigQueryExportsPagedResponse>
      listBigQueryExportsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBigQueryExportsPagedCallable()");
  }

  public UnaryCallable<ListBigQueryExportsRequest, ListBigQueryExportsResponse>
      listBigQueryExportsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBigQueryExportsCallable()");
  }

  public UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse> listFindingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFindingsPagedCallable()");
  }

  public UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFindingsCallable()");
  }

  public UnaryCallable<ListMuteConfigsRequest, ListMuteConfigsPagedResponse>
      listMuteConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMuteConfigsPagedCallable()");
  }

  public UnaryCallable<ListMuteConfigsRequest, ListMuteConfigsResponse> listMuteConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMuteConfigsCallable()");
  }

  public UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsPagedResponse>
      listNotificationConfigsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listNotificationConfigsPagedCallable()");
  }

  public UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsResponse>
      listNotificationConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listNotificationConfigsCallable()");
  }

  public UnaryCallable<ListResourceValueConfigsRequest, ListResourceValueConfigsPagedResponse>
      listResourceValueConfigsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listResourceValueConfigsPagedCallable()");
  }

  public UnaryCallable<ListResourceValueConfigsRequest, ListResourceValueConfigsResponse>
      listResourceValueConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listResourceValueConfigsCallable()");
  }

  public UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse> listSourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSourcesPagedCallable()");
  }

  public UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSourcesCallable()");
  }

  public UnaryCallable<ListValuedResourcesRequest, ListValuedResourcesPagedResponse>
      listValuedResourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listValuedResourcesPagedCallable()");
  }

  public UnaryCallable<ListValuedResourcesRequest, ListValuedResourcesResponse>
      listValuedResourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listValuedResourcesCallable()");
  }

  public UnaryCallable<SetFindingStateRequest, Finding> setFindingStateCallable() {
    throw new UnsupportedOperationException("Not implemented: setFindingStateCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<SetMuteRequest, Finding> setMuteCallable() {
    throw new UnsupportedOperationException("Not implemented: setMuteCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  public UnaryCallable<UpdateBigQueryExportRequest, BigQueryExport> updateBigQueryExportCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBigQueryExportCallable()");
  }

  public UnaryCallable<UpdateExternalSystemRequest, ExternalSystem> updateExternalSystemCallable() {
    throw new UnsupportedOperationException("Not implemented: updateExternalSystemCallable()");
  }

  public UnaryCallable<UpdateFindingRequest, Finding> updateFindingCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFindingCallable()");
  }

  public UnaryCallable<UpdateMuteConfigRequest, MuteConfig> updateMuteConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMuteConfigCallable()");
  }

  public UnaryCallable<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNotificationConfigCallable()");
  }

  public UnaryCallable<UpdateResourceValueConfigRequest, ResourceValueConfig>
      updateResourceValueConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateResourceValueConfigCallable()");
  }

  public UnaryCallable<UpdateSecurityMarksRequest, SecurityMarks> updateSecurityMarksCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSecurityMarksCallable()");
  }

  public UnaryCallable<UpdateSourceRequest, Source> updateSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSourceCallable()");
  }

  @Override
  public abstract void close();
}
