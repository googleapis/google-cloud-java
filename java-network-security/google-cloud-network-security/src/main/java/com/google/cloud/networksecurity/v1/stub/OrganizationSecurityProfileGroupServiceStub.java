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

import static com.google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupServiceClient.ListSecurityProfileGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupServiceClient.ListSecurityProfilesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest;
import com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest;
import com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest;
import com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest;
import com.google.cloud.networksecurity.v1.GetSecurityProfileRequest;
import com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest;
import com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse;
import com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest;
import com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.SecurityProfile;
import com.google.cloud.networksecurity.v1.SecurityProfileGroup;
import com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest;
import com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest;
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
 * Base stub class for the OrganizationSecurityProfileGroupService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class OrganizationSecurityProfileGroupServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListSecurityProfileGroupsRequest, ListSecurityProfileGroupsPagedResponse>
      listSecurityProfileGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSecurityProfileGroupsPagedCallable()");
  }

  public UnaryCallable<ListSecurityProfileGroupsRequest, ListSecurityProfileGroupsResponse>
      listSecurityProfileGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSecurityProfileGroupsCallable()");
  }

  public UnaryCallable<GetSecurityProfileGroupRequest, SecurityProfileGroup>
      getSecurityProfileGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getSecurityProfileGroupCallable()");
  }

  public OperationCallable<
          CreateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
      createSecurityProfileGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSecurityProfileGroupOperationCallable()");
  }

  public UnaryCallable<CreateSecurityProfileGroupRequest, Operation>
      createSecurityProfileGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSecurityProfileGroupCallable()");
  }

  public OperationCallable<
          UpdateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
      updateSecurityProfileGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateSecurityProfileGroupOperationCallable()");
  }

  public UnaryCallable<UpdateSecurityProfileGroupRequest, Operation>
      updateSecurityProfileGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateSecurityProfileGroupCallable()");
  }

  public OperationCallable<DeleteSecurityProfileGroupRequest, Empty, OperationMetadata>
      deleteSecurityProfileGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSecurityProfileGroupOperationCallable()");
  }

  public UnaryCallable<DeleteSecurityProfileGroupRequest, Operation>
      deleteSecurityProfileGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSecurityProfileGroupCallable()");
  }

  public UnaryCallable<ListSecurityProfilesRequest, ListSecurityProfilesPagedResponse>
      listSecurityProfilesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSecurityProfilesPagedCallable()");
  }

  public UnaryCallable<ListSecurityProfilesRequest, ListSecurityProfilesResponse>
      listSecurityProfilesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSecurityProfilesCallable()");
  }

  public UnaryCallable<GetSecurityProfileRequest, SecurityProfile> getSecurityProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: getSecurityProfileCallable()");
  }

  public OperationCallable<CreateSecurityProfileRequest, SecurityProfile, OperationMetadata>
      createSecurityProfileOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSecurityProfileOperationCallable()");
  }

  public UnaryCallable<CreateSecurityProfileRequest, Operation> createSecurityProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: createSecurityProfileCallable()");
  }

  public OperationCallable<UpdateSecurityProfileRequest, SecurityProfile, OperationMetadata>
      updateSecurityProfileOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateSecurityProfileOperationCallable()");
  }

  public UnaryCallable<UpdateSecurityProfileRequest, Operation> updateSecurityProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSecurityProfileCallable()");
  }

  public OperationCallable<DeleteSecurityProfileRequest, Empty, OperationMetadata>
      deleteSecurityProfileOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSecurityProfileOperationCallable()");
  }

  public UnaryCallable<DeleteSecurityProfileRequest, Operation> deleteSecurityProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSecurityProfileCallable()");
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
