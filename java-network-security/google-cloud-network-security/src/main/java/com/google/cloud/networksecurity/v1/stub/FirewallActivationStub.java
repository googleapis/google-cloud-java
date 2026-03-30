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

import static com.google.cloud.networksecurity.v1.FirewallActivationClient.ListFirewallEndpointAssociationsPagedResponse;
import static com.google.cloud.networksecurity.v1.FirewallActivationClient.ListFirewallEndpointsPagedResponse;
import static com.google.cloud.networksecurity.v1.FirewallActivationClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1.CreateFirewallEndpointAssociationRequest;
import com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest;
import com.google.cloud.networksecurity.v1.DeleteFirewallEndpointAssociationRequest;
import com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest;
import com.google.cloud.networksecurity.v1.FirewallEndpoint;
import com.google.cloud.networksecurity.v1.FirewallEndpointAssociation;
import com.google.cloud.networksecurity.v1.GetFirewallEndpointAssociationRequest;
import com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest;
import com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsRequest;
import com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsResponse;
import com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest;
import com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.UpdateFirewallEndpointAssociationRequest;
import com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest;
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
 * Base stub class for the FirewallActivation service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class FirewallActivationStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListFirewallEndpointsRequest, ListFirewallEndpointsPagedResponse>
      listFirewallEndpointsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listFirewallEndpointsPagedCallable()");
  }

  public UnaryCallable<ListFirewallEndpointsRequest, ListFirewallEndpointsResponse>
      listFirewallEndpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFirewallEndpointsCallable()");
  }

  public UnaryCallable<GetFirewallEndpointRequest, FirewallEndpoint> getFirewallEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: getFirewallEndpointCallable()");
  }

  public OperationCallable<CreateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
      createFirewallEndpointOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createFirewallEndpointOperationCallable()");
  }

  public UnaryCallable<CreateFirewallEndpointRequest, Operation> createFirewallEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: createFirewallEndpointCallable()");
  }

  public OperationCallable<DeleteFirewallEndpointRequest, Empty, OperationMetadata>
      deleteFirewallEndpointOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteFirewallEndpointOperationCallable()");
  }

  public UnaryCallable<DeleteFirewallEndpointRequest, Operation> deleteFirewallEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFirewallEndpointCallable()");
  }

  public OperationCallable<UpdateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
      updateFirewallEndpointOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateFirewallEndpointOperationCallable()");
  }

  public UnaryCallable<UpdateFirewallEndpointRequest, Operation> updateFirewallEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFirewallEndpointCallable()");
  }

  public UnaryCallable<
          ListFirewallEndpointAssociationsRequest, ListFirewallEndpointAssociationsPagedResponse>
      listFirewallEndpointAssociationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listFirewallEndpointAssociationsPagedCallable()");
  }

  public UnaryCallable<
          ListFirewallEndpointAssociationsRequest, ListFirewallEndpointAssociationsResponse>
      listFirewallEndpointAssociationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listFirewallEndpointAssociationsCallable()");
  }

  public UnaryCallable<GetFirewallEndpointAssociationRequest, FirewallEndpointAssociation>
      getFirewallEndpointAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getFirewallEndpointAssociationCallable()");
  }

  public OperationCallable<
          CreateFirewallEndpointAssociationRequest, FirewallEndpointAssociation, OperationMetadata>
      createFirewallEndpointAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createFirewallEndpointAssociationOperationCallable()");
  }

  public UnaryCallable<CreateFirewallEndpointAssociationRequest, Operation>
      createFirewallEndpointAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createFirewallEndpointAssociationCallable()");
  }

  public OperationCallable<DeleteFirewallEndpointAssociationRequest, Empty, OperationMetadata>
      deleteFirewallEndpointAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteFirewallEndpointAssociationOperationCallable()");
  }

  public UnaryCallable<DeleteFirewallEndpointAssociationRequest, Operation>
      deleteFirewallEndpointAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteFirewallEndpointAssociationCallable()");
  }

  public OperationCallable<
          UpdateFirewallEndpointAssociationRequest, FirewallEndpointAssociation, OperationMetadata>
      updateFirewallEndpointAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateFirewallEndpointAssociationOperationCallable()");
  }

  public UnaryCallable<UpdateFirewallEndpointAssociationRequest, Operation>
      updateFirewallEndpointAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateFirewallEndpointAssociationCallable()");
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
