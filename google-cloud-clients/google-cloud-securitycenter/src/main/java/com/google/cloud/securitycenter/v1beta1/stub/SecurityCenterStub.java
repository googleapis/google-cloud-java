/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.securitycenter.v1beta1.stub;

import static com.google.cloud.securitycenter.v1beta1.SecurityCenterClient.GroupAssetsPagedResponse;
import static com.google.cloud.securitycenter.v1beta1.SecurityCenterClient.GroupFindingsPagedResponse;
import static com.google.cloud.securitycenter.v1beta1.SecurityCenterClient.ListAssetsPagedResponse;
import static com.google.cloud.securitycenter.v1beta1.SecurityCenterClient.ListFindingsPagedResponse;
import static com.google.cloud.securitycenter.v1beta1.SecurityCenterClient.ListSourcesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.securitycenter.v1beta1.Finding.Finding;
import com.google.cloud.securitycenter.v1beta1.OrganizationSettings.OrganizationSettings;
import com.google.cloud.securitycenter.v1beta1.SecurityMarks.SecurityMarks;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.CreateFindingRequest;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.CreateSourceRequest;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.GetOrganizationSettingsRequest;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.GetSourceRequest;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.GroupAssetsRequest;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.GroupAssetsResponse;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.GroupFindingsRequest;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.GroupFindingsResponse;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.ListAssetsRequest;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.ListAssetsResponse;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.ListFindingsRequest;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.ListFindingsResponse;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.ListSourcesRequest;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.ListSourcesResponse;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.RunAssetDiscoveryRequest;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.SetFindingStateRequest;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.UpdateFindingRequest;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.UpdateOrganizationSettingsRequest;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.UpdateSecurityMarksRequest;
import com.google.cloud.securitycenter.v1beta1.SecuritycenterService.UpdateSourceRequest;
import com.google.cloud.securitycenter.v1beta1.Source.Source;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Cloud Security Command Center API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class SecurityCenterStub implements BackgroundResource {

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<CreateSourceRequest, Source> createSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: createSourceCallable()");
  }

  public UnaryCallable<CreateFindingRequest, Finding> createFindingCallable() {
    throw new UnsupportedOperationException("Not implemented: createFindingCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<GetOrganizationSettingsRequest, OrganizationSettings>
      getOrganizationSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getOrganizationSettingsCallable()");
  }

  public UnaryCallable<GetSourceRequest, Source> getSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: getSourceCallable()");
  }

  public UnaryCallable<GroupAssetsRequest, GroupAssetsPagedResponse> groupAssetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: groupAssetsPagedCallable()");
  }

  public UnaryCallable<GroupAssetsRequest, GroupAssetsResponse> groupAssetsCallable() {
    throw new UnsupportedOperationException("Not implemented: groupAssetsCallable()");
  }

  public UnaryCallable<GroupFindingsRequest, GroupFindingsPagedResponse>
      groupFindingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: groupFindingsPagedCallable()");
  }

  public UnaryCallable<GroupFindingsRequest, GroupFindingsResponse> groupFindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: groupFindingsCallable()");
  }

  public UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssetsPagedCallable()");
  }

  public UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssetsCallable()");
  }

  public UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse> listFindingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFindingsPagedCallable()");
  }

  public UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFindingsCallable()");
  }

  public UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse> listSourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSourcesPagedCallable()");
  }

  public UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSourcesCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<RunAssetDiscoveryRequest, Empty, Empty>
      runAssetDiscoveryOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: runAssetDiscoveryOperationCallable()");
  }

  public UnaryCallable<RunAssetDiscoveryRequest, Operation> runAssetDiscoveryCallable() {
    throw new UnsupportedOperationException("Not implemented: runAssetDiscoveryCallable()");
  }

  public UnaryCallable<SetFindingStateRequest, Finding> setFindingStateCallable() {
    throw new UnsupportedOperationException("Not implemented: setFindingStateCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  public UnaryCallable<UpdateFindingRequest, Finding> updateFindingCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFindingCallable()");
  }

  public UnaryCallable<UpdateOrganizationSettingsRequest, OrganizationSettings>
      updateOrganizationSettingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateOrganizationSettingsCallable()");
  }

  public UnaryCallable<UpdateSourceRequest, Source> updateSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSourceCallable()");
  }

  public UnaryCallable<UpdateSecurityMarksRequest, SecurityMarks> updateSecurityMarksCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSecurityMarksCallable()");
  }

  @Override
  public abstract void close();
}
