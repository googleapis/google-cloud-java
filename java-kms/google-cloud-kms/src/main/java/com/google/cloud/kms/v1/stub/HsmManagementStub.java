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

package com.google.cloud.kms.v1.stub;

import static com.google.cloud.kms.v1.HsmManagementClient.ListLocationsPagedResponse;
import static com.google.cloud.kms.v1.HsmManagementClient.ListSingleTenantHsmInstanceProposalsPagedResponse;
import static com.google.cloud.kms.v1.HsmManagementClient.ListSingleTenantHsmInstancesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse;
import com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceMetadata;
import com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalMetadata;
import com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest;
import com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalMetadata;
import com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalResponse;
import com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest;
import com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest;
import com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse;
import com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest;
import com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse;
import com.google.cloud.kms.v1.SingleTenantHsmInstance;
import com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the HsmManagement service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class HsmManagementStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<
          ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesPagedResponse>
      listSingleTenantHsmInstancesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSingleTenantHsmInstancesPagedCallable()");
  }

  public UnaryCallable<ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesResponse>
      listSingleTenantHsmInstancesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSingleTenantHsmInstancesCallable()");
  }

  public UnaryCallable<GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>
      getSingleTenantHsmInstanceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getSingleTenantHsmInstanceCallable()");
  }

  public OperationCallable<
          CreateSingleTenantHsmInstanceRequest,
          SingleTenantHsmInstance,
          CreateSingleTenantHsmInstanceMetadata>
      createSingleTenantHsmInstanceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSingleTenantHsmInstanceOperationCallable()");
  }

  public UnaryCallable<CreateSingleTenantHsmInstanceRequest, Operation>
      createSingleTenantHsmInstanceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSingleTenantHsmInstanceCallable()");
  }

  public OperationCallable<
          CreateSingleTenantHsmInstanceProposalRequest,
          SingleTenantHsmInstanceProposal,
          CreateSingleTenantHsmInstanceProposalMetadata>
      createSingleTenantHsmInstanceProposalOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSingleTenantHsmInstanceProposalOperationCallable()");
  }

  public UnaryCallable<CreateSingleTenantHsmInstanceProposalRequest, Operation>
      createSingleTenantHsmInstanceProposalCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSingleTenantHsmInstanceProposalCallable()");
  }

  public UnaryCallable<
          ApproveSingleTenantHsmInstanceProposalRequest,
          ApproveSingleTenantHsmInstanceProposalResponse>
      approveSingleTenantHsmInstanceProposalCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: approveSingleTenantHsmInstanceProposalCallable()");
  }

  public OperationCallable<
          ExecuteSingleTenantHsmInstanceProposalRequest,
          ExecuteSingleTenantHsmInstanceProposalResponse,
          ExecuteSingleTenantHsmInstanceProposalMetadata>
      executeSingleTenantHsmInstanceProposalOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: executeSingleTenantHsmInstanceProposalOperationCallable()");
  }

  public UnaryCallable<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>
      executeSingleTenantHsmInstanceProposalCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: executeSingleTenantHsmInstanceProposalCallable()");
  }

  public UnaryCallable<GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
      getSingleTenantHsmInstanceProposalCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getSingleTenantHsmInstanceProposalCallable()");
  }

  public UnaryCallable<
          ListSingleTenantHsmInstanceProposalsRequest,
          ListSingleTenantHsmInstanceProposalsPagedResponse>
      listSingleTenantHsmInstanceProposalsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSingleTenantHsmInstanceProposalsPagedCallable()");
  }

  public UnaryCallable<
          ListSingleTenantHsmInstanceProposalsRequest, ListSingleTenantHsmInstanceProposalsResponse>
      listSingleTenantHsmInstanceProposalsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSingleTenantHsmInstanceProposalsCallable()");
  }

  public UnaryCallable<DeleteSingleTenantHsmInstanceProposalRequest, Empty>
      deleteSingleTenantHsmInstanceProposalCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSingleTenantHsmInstanceProposalCallable()");
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
