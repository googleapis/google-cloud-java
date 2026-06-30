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

import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptDeploymentGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptDeploymentsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptEndpointGroupAssociationsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptEndpointGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1.CreateInterceptDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest;
import com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest;
import com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest;
import com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.InterceptDeployment;
import com.google.cloud.networksecurity.v1.InterceptDeploymentGroup;
import com.google.cloud.networksecurity.v1.InterceptEndpointGroup;
import com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation;
import com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsRequest;
import com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsResponse;
import com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest;
import com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse;
import com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsRequest;
import com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsResponse;
import com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest;
import com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest;
import com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupRequest;
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
 * Base stub class for the Intercept service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class InterceptStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListInterceptEndpointGroupsRequest, ListInterceptEndpointGroupsPagedResponse>
      listInterceptEndpointGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInterceptEndpointGroupsPagedCallable()");
  }

  public UnaryCallable<ListInterceptEndpointGroupsRequest, ListInterceptEndpointGroupsResponse>
      listInterceptEndpointGroupsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInterceptEndpointGroupsCallable()");
  }

  public UnaryCallable<GetInterceptEndpointGroupRequest, InterceptEndpointGroup>
      getInterceptEndpointGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getInterceptEndpointGroupCallable()");
  }

  public OperationCallable<
          CreateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
      createInterceptEndpointGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createInterceptEndpointGroupOperationCallable()");
  }

  public UnaryCallable<CreateInterceptEndpointGroupRequest, Operation>
      createInterceptEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createInterceptEndpointGroupCallable()");
  }

  public OperationCallable<
          UpdateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
      updateInterceptEndpointGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateInterceptEndpointGroupOperationCallable()");
  }

  public UnaryCallable<UpdateInterceptEndpointGroupRequest, Operation>
      updateInterceptEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateInterceptEndpointGroupCallable()");
  }

  public OperationCallable<DeleteInterceptEndpointGroupRequest, Empty, OperationMetadata>
      deleteInterceptEndpointGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteInterceptEndpointGroupOperationCallable()");
  }

  public UnaryCallable<DeleteInterceptEndpointGroupRequest, Operation>
      deleteInterceptEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteInterceptEndpointGroupCallable()");
  }

  public UnaryCallable<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsPagedResponse>
      listInterceptEndpointGroupAssociationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInterceptEndpointGroupAssociationsPagedCallable()");
  }

  public UnaryCallable<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsResponse>
      listInterceptEndpointGroupAssociationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInterceptEndpointGroupAssociationsCallable()");
  }

  public UnaryCallable<
          GetInterceptEndpointGroupAssociationRequest, InterceptEndpointGroupAssociation>
      getInterceptEndpointGroupAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getInterceptEndpointGroupAssociationCallable()");
  }

  public OperationCallable<
          CreateInterceptEndpointGroupAssociationRequest,
          InterceptEndpointGroupAssociation,
          OperationMetadata>
      createInterceptEndpointGroupAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createInterceptEndpointGroupAssociationOperationCallable()");
  }

  public UnaryCallable<CreateInterceptEndpointGroupAssociationRequest, Operation>
      createInterceptEndpointGroupAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createInterceptEndpointGroupAssociationCallable()");
  }

  public OperationCallable<
          UpdateInterceptEndpointGroupAssociationRequest,
          InterceptEndpointGroupAssociation,
          OperationMetadata>
      updateInterceptEndpointGroupAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateInterceptEndpointGroupAssociationOperationCallable()");
  }

  public UnaryCallable<UpdateInterceptEndpointGroupAssociationRequest, Operation>
      updateInterceptEndpointGroupAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateInterceptEndpointGroupAssociationCallable()");
  }

  public OperationCallable<DeleteInterceptEndpointGroupAssociationRequest, Empty, OperationMetadata>
      deleteInterceptEndpointGroupAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteInterceptEndpointGroupAssociationOperationCallable()");
  }

  public UnaryCallable<DeleteInterceptEndpointGroupAssociationRequest, Operation>
      deleteInterceptEndpointGroupAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteInterceptEndpointGroupAssociationCallable()");
  }

  public UnaryCallable<
          ListInterceptDeploymentGroupsRequest, ListInterceptDeploymentGroupsPagedResponse>
      listInterceptDeploymentGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInterceptDeploymentGroupsPagedCallable()");
  }

  public UnaryCallable<ListInterceptDeploymentGroupsRequest, ListInterceptDeploymentGroupsResponse>
      listInterceptDeploymentGroupsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInterceptDeploymentGroupsCallable()");
  }

  public UnaryCallable<GetInterceptDeploymentGroupRequest, InterceptDeploymentGroup>
      getInterceptDeploymentGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getInterceptDeploymentGroupCallable()");
  }

  public OperationCallable<
          CreateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
      createInterceptDeploymentGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createInterceptDeploymentGroupOperationCallable()");
  }

  public UnaryCallable<CreateInterceptDeploymentGroupRequest, Operation>
      createInterceptDeploymentGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createInterceptDeploymentGroupCallable()");
  }

  public OperationCallable<
          UpdateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
      updateInterceptDeploymentGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateInterceptDeploymentGroupOperationCallable()");
  }

  public UnaryCallable<UpdateInterceptDeploymentGroupRequest, Operation>
      updateInterceptDeploymentGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateInterceptDeploymentGroupCallable()");
  }

  public OperationCallable<DeleteInterceptDeploymentGroupRequest, Empty, OperationMetadata>
      deleteInterceptDeploymentGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteInterceptDeploymentGroupOperationCallable()");
  }

  public UnaryCallable<DeleteInterceptDeploymentGroupRequest, Operation>
      deleteInterceptDeploymentGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteInterceptDeploymentGroupCallable()");
  }

  public UnaryCallable<ListInterceptDeploymentsRequest, ListInterceptDeploymentsPagedResponse>
      listInterceptDeploymentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInterceptDeploymentsPagedCallable()");
  }

  public UnaryCallable<ListInterceptDeploymentsRequest, ListInterceptDeploymentsResponse>
      listInterceptDeploymentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listInterceptDeploymentsCallable()");
  }

  public UnaryCallable<GetInterceptDeploymentRequest, InterceptDeployment>
      getInterceptDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getInterceptDeploymentCallable()");
  }

  public OperationCallable<CreateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
      createInterceptDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createInterceptDeploymentOperationCallable()");
  }

  public UnaryCallable<CreateInterceptDeploymentRequest, Operation>
      createInterceptDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: createInterceptDeploymentCallable()");
  }

  public OperationCallable<UpdateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
      updateInterceptDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateInterceptDeploymentOperationCallable()");
  }

  public UnaryCallable<UpdateInterceptDeploymentRequest, Operation>
      updateInterceptDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInterceptDeploymentCallable()");
  }

  public OperationCallable<DeleteInterceptDeploymentRequest, Empty, OperationMetadata>
      deleteInterceptDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteInterceptDeploymentOperationCallable()");
  }

  public UnaryCallable<DeleteInterceptDeploymentRequest, Operation>
      deleteInterceptDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInterceptDeploymentCallable()");
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
