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

package com.google.cloud.networksecurity.v1.stub;

import static com.google.cloud.networksecurity.v1.MirroringClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringDeploymentGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringDeploymentsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringEndpointGroupAssociationsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringEndpointGroupsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1.CreateMirroringDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest;
import com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest;
import com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest;
import com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsRequest;
import com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsResponse;
import com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest;
import com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse;
import com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsRequest;
import com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsResponse;
import com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest;
import com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsResponse;
import com.google.cloud.networksecurity.v1.MirroringDeployment;
import com.google.cloud.networksecurity.v1.MirroringDeploymentGroup;
import com.google.cloud.networksecurity.v1.MirroringEndpointGroup;
import com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest;
import com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupRequest;
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
 * Base stub class for the Mirroring service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class MirroringStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListMirroringEndpointGroupsRequest, ListMirroringEndpointGroupsPagedResponse>
      listMirroringEndpointGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMirroringEndpointGroupsPagedCallable()");
  }

  public UnaryCallable<ListMirroringEndpointGroupsRequest, ListMirroringEndpointGroupsResponse>
      listMirroringEndpointGroupsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMirroringEndpointGroupsCallable()");
  }

  public UnaryCallable<GetMirroringEndpointGroupRequest, MirroringEndpointGroup>
      getMirroringEndpointGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getMirroringEndpointGroupCallable()");
  }

  public OperationCallable<
          CreateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
      createMirroringEndpointGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMirroringEndpointGroupOperationCallable()");
  }

  public UnaryCallable<CreateMirroringEndpointGroupRequest, Operation>
      createMirroringEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMirroringEndpointGroupCallable()");
  }

  public OperationCallable<
          UpdateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
      updateMirroringEndpointGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMirroringEndpointGroupOperationCallable()");
  }

  public UnaryCallable<UpdateMirroringEndpointGroupRequest, Operation>
      updateMirroringEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMirroringEndpointGroupCallable()");
  }

  public OperationCallable<DeleteMirroringEndpointGroupRequest, Empty, OperationMetadata>
      deleteMirroringEndpointGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMirroringEndpointGroupOperationCallable()");
  }

  public UnaryCallable<DeleteMirroringEndpointGroupRequest, Operation>
      deleteMirroringEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMirroringEndpointGroupCallable()");
  }

  public UnaryCallable<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsPagedResponse>
      listMirroringEndpointGroupAssociationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMirroringEndpointGroupAssociationsPagedCallable()");
  }

  public UnaryCallable<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsResponse>
      listMirroringEndpointGroupAssociationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMirroringEndpointGroupAssociationsCallable()");
  }

  public UnaryCallable<
          GetMirroringEndpointGroupAssociationRequest, MirroringEndpointGroupAssociation>
      getMirroringEndpointGroupAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getMirroringEndpointGroupAssociationCallable()");
  }

  public OperationCallable<
          CreateMirroringEndpointGroupAssociationRequest,
          MirroringEndpointGroupAssociation,
          OperationMetadata>
      createMirroringEndpointGroupAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMirroringEndpointGroupAssociationOperationCallable()");
  }

  public UnaryCallable<CreateMirroringEndpointGroupAssociationRequest, Operation>
      createMirroringEndpointGroupAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMirroringEndpointGroupAssociationCallable()");
  }

  public OperationCallable<
          UpdateMirroringEndpointGroupAssociationRequest,
          MirroringEndpointGroupAssociation,
          OperationMetadata>
      updateMirroringEndpointGroupAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMirroringEndpointGroupAssociationOperationCallable()");
  }

  public UnaryCallable<UpdateMirroringEndpointGroupAssociationRequest, Operation>
      updateMirroringEndpointGroupAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMirroringEndpointGroupAssociationCallable()");
  }

  public OperationCallable<DeleteMirroringEndpointGroupAssociationRequest, Empty, OperationMetadata>
      deleteMirroringEndpointGroupAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMirroringEndpointGroupAssociationOperationCallable()");
  }

  public UnaryCallable<DeleteMirroringEndpointGroupAssociationRequest, Operation>
      deleteMirroringEndpointGroupAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMirroringEndpointGroupAssociationCallable()");
  }

  public UnaryCallable<
          ListMirroringDeploymentGroupsRequest, ListMirroringDeploymentGroupsPagedResponse>
      listMirroringDeploymentGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMirroringDeploymentGroupsPagedCallable()");
  }

  public UnaryCallable<ListMirroringDeploymentGroupsRequest, ListMirroringDeploymentGroupsResponse>
      listMirroringDeploymentGroupsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMirroringDeploymentGroupsCallable()");
  }

  public UnaryCallable<GetMirroringDeploymentGroupRequest, MirroringDeploymentGroup>
      getMirroringDeploymentGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getMirroringDeploymentGroupCallable()");
  }

  public OperationCallable<
          CreateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
      createMirroringDeploymentGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMirroringDeploymentGroupOperationCallable()");
  }

  public UnaryCallable<CreateMirroringDeploymentGroupRequest, Operation>
      createMirroringDeploymentGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMirroringDeploymentGroupCallable()");
  }

  public OperationCallable<
          UpdateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
      updateMirroringDeploymentGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMirroringDeploymentGroupOperationCallable()");
  }

  public UnaryCallable<UpdateMirroringDeploymentGroupRequest, Operation>
      updateMirroringDeploymentGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMirroringDeploymentGroupCallable()");
  }

  public OperationCallable<DeleteMirroringDeploymentGroupRequest, Empty, OperationMetadata>
      deleteMirroringDeploymentGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMirroringDeploymentGroupOperationCallable()");
  }

  public UnaryCallable<DeleteMirroringDeploymentGroupRequest, Operation>
      deleteMirroringDeploymentGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMirroringDeploymentGroupCallable()");
  }

  public UnaryCallable<ListMirroringDeploymentsRequest, ListMirroringDeploymentsPagedResponse>
      listMirroringDeploymentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMirroringDeploymentsPagedCallable()");
  }

  public UnaryCallable<ListMirroringDeploymentsRequest, ListMirroringDeploymentsResponse>
      listMirroringDeploymentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMirroringDeploymentsCallable()");
  }

  public UnaryCallable<GetMirroringDeploymentRequest, MirroringDeployment>
      getMirroringDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getMirroringDeploymentCallable()");
  }

  public OperationCallable<CreateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
      createMirroringDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMirroringDeploymentOperationCallable()");
  }

  public UnaryCallable<CreateMirroringDeploymentRequest, Operation>
      createMirroringDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: createMirroringDeploymentCallable()");
  }

  public OperationCallable<UpdateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
      updateMirroringDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMirroringDeploymentOperationCallable()");
  }

  public UnaryCallable<UpdateMirroringDeploymentRequest, Operation>
      updateMirroringDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMirroringDeploymentCallable()");
  }

  public OperationCallable<DeleteMirroringDeploymentRequest, Empty, OperationMetadata>
      deleteMirroringDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMirroringDeploymentOperationCallable()");
  }

  public UnaryCallable<DeleteMirroringDeploymentRequest, Operation>
      deleteMirroringDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMirroringDeploymentCallable()");
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
