/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.osconfig.v1alpha.stub;

import static com.google.cloud.osconfig.v1alpha.OsConfigZonalServiceClient.ListInstanceOSPoliciesCompliancesPagedResponse;
import static com.google.cloud.osconfig.v1alpha.OsConfigZonalServiceClient.ListInventoriesPagedResponse;
import static com.google.cloud.osconfig.v1alpha.OsConfigZonalServiceClient.ListOSPolicyAssignmentReportsPagedResponse;
import static com.google.cloud.osconfig.v1alpha.OsConfigZonalServiceClient.ListOSPolicyAssignmentRevisionsPagedResponse;
import static com.google.cloud.osconfig.v1alpha.OsConfigZonalServiceClient.ListOSPolicyAssignmentsPagedResponse;
import static com.google.cloud.osconfig.v1alpha.OsConfigZonalServiceClient.ListVulnerabilityReportsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.osconfig.v1alpha.CreateOSPolicyAssignmentRequest;
import com.google.cloud.osconfig.v1alpha.DeleteOSPolicyAssignmentRequest;
import com.google.cloud.osconfig.v1alpha.GetInstanceOSPoliciesComplianceRequest;
import com.google.cloud.osconfig.v1alpha.GetInventoryRequest;
import com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentReportRequest;
import com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentRequest;
import com.google.cloud.osconfig.v1alpha.GetVulnerabilityReportRequest;
import com.google.cloud.osconfig.v1alpha.InstanceOSPoliciesCompliance;
import com.google.cloud.osconfig.v1alpha.Inventory;
import com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesRequest;
import com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesResponse;
import com.google.cloud.osconfig.v1alpha.ListInventoriesRequest;
import com.google.cloud.osconfig.v1alpha.ListInventoriesResponse;
import com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsRequest;
import com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsResponse;
import com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsRequest;
import com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsResponse;
import com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsRequest;
import com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsResponse;
import com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsRequest;
import com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsResponse;
import com.google.cloud.osconfig.v1alpha.OSPolicyAssignment;
import com.google.cloud.osconfig.v1alpha.OSPolicyAssignmentOperationMetadata;
import com.google.cloud.osconfig.v1alpha.OSPolicyAssignmentReport;
import com.google.cloud.osconfig.v1alpha.UpdateOSPolicyAssignmentRequest;
import com.google.cloud.osconfig.v1alpha.VulnerabilityReport;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the OsConfigZonalService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class OsConfigZonalServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<
          CreateOSPolicyAssignmentRequest, OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      createOSPolicyAssignmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createOSPolicyAssignmentOperationCallable()");
  }

  public UnaryCallable<CreateOSPolicyAssignmentRequest, Operation>
      createOSPolicyAssignmentCallable() {
    throw new UnsupportedOperationException("Not implemented: createOSPolicyAssignmentCallable()");
  }

  public OperationCallable<
          UpdateOSPolicyAssignmentRequest, OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      updateOSPolicyAssignmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateOSPolicyAssignmentOperationCallable()");
  }

  public UnaryCallable<UpdateOSPolicyAssignmentRequest, Operation>
      updateOSPolicyAssignmentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOSPolicyAssignmentCallable()");
  }

  public UnaryCallable<GetOSPolicyAssignmentRequest, OSPolicyAssignment>
      getOSPolicyAssignmentCallable() {
    throw new UnsupportedOperationException("Not implemented: getOSPolicyAssignmentCallable()");
  }

  public UnaryCallable<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsPagedResponse>
      listOSPolicyAssignmentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listOSPolicyAssignmentsPagedCallable()");
  }

  public UnaryCallable<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse>
      listOSPolicyAssignmentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listOSPolicyAssignmentsCallable()");
  }

  public UnaryCallable<
          ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsPagedResponse>
      listOSPolicyAssignmentRevisionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listOSPolicyAssignmentRevisionsPagedCallable()");
  }

  public UnaryCallable<
          ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsResponse>
      listOSPolicyAssignmentRevisionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listOSPolicyAssignmentRevisionsCallable()");
  }

  public OperationCallable<
          DeleteOSPolicyAssignmentRequest, Empty, OSPolicyAssignmentOperationMetadata>
      deleteOSPolicyAssignmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteOSPolicyAssignmentOperationCallable()");
  }

  public UnaryCallable<DeleteOSPolicyAssignmentRequest, Operation>
      deleteOSPolicyAssignmentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOSPolicyAssignmentCallable()");
  }

  @Deprecated
  public UnaryCallable<GetInstanceOSPoliciesComplianceRequest, InstanceOSPoliciesCompliance>
      getInstanceOSPoliciesComplianceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getInstanceOSPoliciesComplianceCallable()");
  }

  @Deprecated
  public UnaryCallable<
          ListInstanceOSPoliciesCompliancesRequest, ListInstanceOSPoliciesCompliancesPagedResponse>
      listInstanceOSPoliciesCompliancesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInstanceOSPoliciesCompliancesPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<
          ListInstanceOSPoliciesCompliancesRequest, ListInstanceOSPoliciesCompliancesResponse>
      listInstanceOSPoliciesCompliancesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInstanceOSPoliciesCompliancesCallable()");
  }

  public UnaryCallable<GetOSPolicyAssignmentReportRequest, OSPolicyAssignmentReport>
      getOSPolicyAssignmentReportCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getOSPolicyAssignmentReportCallable()");
  }

  public UnaryCallable<
          ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsPagedResponse>
      listOSPolicyAssignmentReportsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listOSPolicyAssignmentReportsPagedCallable()");
  }

  public UnaryCallable<ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsResponse>
      listOSPolicyAssignmentReportsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listOSPolicyAssignmentReportsCallable()");
  }

  public UnaryCallable<GetInventoryRequest, Inventory> getInventoryCallable() {
    throw new UnsupportedOperationException("Not implemented: getInventoryCallable()");
  }

  public UnaryCallable<ListInventoriesRequest, ListInventoriesPagedResponse>
      listInventoriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInventoriesPagedCallable()");
  }

  public UnaryCallable<ListInventoriesRequest, ListInventoriesResponse> listInventoriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInventoriesCallable()");
  }

  public UnaryCallable<GetVulnerabilityReportRequest, VulnerabilityReport>
      getVulnerabilityReportCallable() {
    throw new UnsupportedOperationException("Not implemented: getVulnerabilityReportCallable()");
  }

  public UnaryCallable<ListVulnerabilityReportsRequest, ListVulnerabilityReportsPagedResponse>
      listVulnerabilityReportsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listVulnerabilityReportsPagedCallable()");
  }

  public UnaryCallable<ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>
      listVulnerabilityReportsCallable() {
    throw new UnsupportedOperationException("Not implemented: listVulnerabilityReportsCallable()");
  }

  @Override
  public abstract void close();
}
