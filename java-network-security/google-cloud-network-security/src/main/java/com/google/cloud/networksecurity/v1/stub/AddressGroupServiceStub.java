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

package com.google.cloud.networksecurity.v1.stub;

import static com.google.cloud.networksecurity.v1.AddressGroupServiceClient.ListAddressGroupReferencesPagedResponse;
import static com.google.cloud.networksecurity.v1.AddressGroupServiceClient.ListAddressGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.AddressGroupServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest;
import com.google.cloud.networksecurity.v1.AddressGroup;
import com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest;
import com.google.cloud.networksecurity.v1.CreateAddressGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest;
import com.google.cloud.networksecurity.v1.GetAddressGroupRequest;
import com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest;
import com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse;
import com.google.cloud.networksecurity.v1.ListAddressGroupsRequest;
import com.google.cloud.networksecurity.v1.ListAddressGroupsResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest;
import com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest;
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
 * Base stub class for the AddressGroupService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AddressGroupServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListAddressGroupsRequest, ListAddressGroupsPagedResponse>
      listAddressGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAddressGroupsPagedCallable()");
  }

  public UnaryCallable<ListAddressGroupsRequest, ListAddressGroupsResponse>
      listAddressGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAddressGroupsCallable()");
  }

  public UnaryCallable<GetAddressGroupRequest, AddressGroup> getAddressGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getAddressGroupCallable()");
  }

  public OperationCallable<CreateAddressGroupRequest, AddressGroup, OperationMetadata>
      createAddressGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAddressGroupOperationCallable()");
  }

  public UnaryCallable<CreateAddressGroupRequest, Operation> createAddressGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: createAddressGroupCallable()");
  }

  public OperationCallable<UpdateAddressGroupRequest, AddressGroup, OperationMetadata>
      updateAddressGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAddressGroupOperationCallable()");
  }

  public UnaryCallable<UpdateAddressGroupRequest, Operation> updateAddressGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAddressGroupCallable()");
  }

  public OperationCallable<AddAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      addAddressGroupItemsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: addAddressGroupItemsOperationCallable()");
  }

  public UnaryCallable<AddAddressGroupItemsRequest, Operation> addAddressGroupItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: addAddressGroupItemsCallable()");
  }

  public OperationCallable<RemoveAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      removeAddressGroupItemsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeAddressGroupItemsOperationCallable()");
  }

  public UnaryCallable<RemoveAddressGroupItemsRequest, Operation>
      removeAddressGroupItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: removeAddressGroupItemsCallable()");
  }

  public OperationCallable<CloneAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      cloneAddressGroupItemsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: cloneAddressGroupItemsOperationCallable()");
  }

  public UnaryCallable<CloneAddressGroupItemsRequest, Operation> cloneAddressGroupItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: cloneAddressGroupItemsCallable()");
  }

  public OperationCallable<DeleteAddressGroupRequest, Empty, OperationMetadata>
      deleteAddressGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAddressGroupOperationCallable()");
  }

  public UnaryCallable<DeleteAddressGroupRequest, Operation> deleteAddressGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAddressGroupCallable()");
  }

  public UnaryCallable<ListAddressGroupReferencesRequest, ListAddressGroupReferencesPagedResponse>
      listAddressGroupReferencesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAddressGroupReferencesPagedCallable()");
  }

  public UnaryCallable<ListAddressGroupReferencesRequest, ListAddressGroupReferencesResponse>
      listAddressGroupReferencesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAddressGroupReferencesCallable()");
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
