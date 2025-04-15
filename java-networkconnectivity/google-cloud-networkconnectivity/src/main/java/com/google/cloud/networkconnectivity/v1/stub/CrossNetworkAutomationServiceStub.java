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

package com.google.cloud.networkconnectivity.v1.stub;

import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceClassesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceConnectionMapsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceConnectionPoliciesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceConnectionTokensPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkconnectivity.v1.CreateServiceConnectionMapRequest;
import com.google.cloud.networkconnectivity.v1.CreateServiceConnectionPolicyRequest;
import com.google.cloud.networkconnectivity.v1.CreateServiceConnectionTokenRequest;
import com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest;
import com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionMapRequest;
import com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionPolicyRequest;
import com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionTokenRequest;
import com.google.cloud.networkconnectivity.v1.GetServiceClassRequest;
import com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest;
import com.google.cloud.networkconnectivity.v1.GetServiceConnectionPolicyRequest;
import com.google.cloud.networkconnectivity.v1.GetServiceConnectionTokenRequest;
import com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest;
import com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsRequest;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsResponse;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesRequest;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesResponse;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensRequest;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensResponse;
import com.google.cloud.networkconnectivity.v1.OperationMetadata;
import com.google.cloud.networkconnectivity.v1.ServiceClass;
import com.google.cloud.networkconnectivity.v1.ServiceConnectionMap;
import com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy;
import com.google.cloud.networkconnectivity.v1.ServiceConnectionToken;
import com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest;
import com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionMapRequest;
import com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionPolicyRequest;
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
 * Base stub class for the CrossNetworkAutomationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CrossNetworkAutomationServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListServiceConnectionMapsRequest, ListServiceConnectionMapsPagedResponse>
      listServiceConnectionMapsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listServiceConnectionMapsPagedCallable()");
  }

  public UnaryCallable<ListServiceConnectionMapsRequest, ListServiceConnectionMapsResponse>
      listServiceConnectionMapsCallable() {
    throw new UnsupportedOperationException("Not implemented: listServiceConnectionMapsCallable()");
  }

  public UnaryCallable<GetServiceConnectionMapRequest, ServiceConnectionMap>
      getServiceConnectionMapCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceConnectionMapCallable()");
  }

  public OperationCallable<
          CreateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
      createServiceConnectionMapOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createServiceConnectionMapOperationCallable()");
  }

  public UnaryCallable<CreateServiceConnectionMapRequest, Operation>
      createServiceConnectionMapCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createServiceConnectionMapCallable()");
  }

  public OperationCallable<
          UpdateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
      updateServiceConnectionMapOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateServiceConnectionMapOperationCallable()");
  }

  public UnaryCallable<UpdateServiceConnectionMapRequest, Operation>
      updateServiceConnectionMapCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateServiceConnectionMapCallable()");
  }

  public OperationCallable<DeleteServiceConnectionMapRequest, Empty, OperationMetadata>
      deleteServiceConnectionMapOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteServiceConnectionMapOperationCallable()");
  }

  public UnaryCallable<DeleteServiceConnectionMapRequest, Operation>
      deleteServiceConnectionMapCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteServiceConnectionMapCallable()");
  }

  public UnaryCallable<
          ListServiceConnectionPoliciesRequest, ListServiceConnectionPoliciesPagedResponse>
      listServiceConnectionPoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listServiceConnectionPoliciesPagedCallable()");
  }

  public UnaryCallable<ListServiceConnectionPoliciesRequest, ListServiceConnectionPoliciesResponse>
      listServiceConnectionPoliciesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listServiceConnectionPoliciesCallable()");
  }

  public UnaryCallable<GetServiceConnectionPolicyRequest, ServiceConnectionPolicy>
      getServiceConnectionPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getServiceConnectionPolicyCallable()");
  }

  public OperationCallable<
          CreateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
      createServiceConnectionPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createServiceConnectionPolicyOperationCallable()");
  }

  public UnaryCallable<CreateServiceConnectionPolicyRequest, Operation>
      createServiceConnectionPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createServiceConnectionPolicyCallable()");
  }

  public OperationCallable<
          UpdateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
      updateServiceConnectionPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateServiceConnectionPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateServiceConnectionPolicyRequest, Operation>
      updateServiceConnectionPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateServiceConnectionPolicyCallable()");
  }

  public OperationCallable<DeleteServiceConnectionPolicyRequest, Empty, OperationMetadata>
      deleteServiceConnectionPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteServiceConnectionPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteServiceConnectionPolicyRequest, Operation>
      deleteServiceConnectionPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteServiceConnectionPolicyCallable()");
  }

  public UnaryCallable<ListServiceClassesRequest, ListServiceClassesPagedResponse>
      listServiceClassesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServiceClassesPagedCallable()");
  }

  public UnaryCallable<ListServiceClassesRequest, ListServiceClassesResponse>
      listServiceClassesCallable() {
    throw new UnsupportedOperationException("Not implemented: listServiceClassesCallable()");
  }

  public UnaryCallable<GetServiceClassRequest, ServiceClass> getServiceClassCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceClassCallable()");
  }

  public OperationCallable<UpdateServiceClassRequest, ServiceClass, OperationMetadata>
      updateServiceClassOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateServiceClassOperationCallable()");
  }

  public UnaryCallable<UpdateServiceClassRequest, Operation> updateServiceClassCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServiceClassCallable()");
  }

  public OperationCallable<DeleteServiceClassRequest, Empty, OperationMetadata>
      deleteServiceClassOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteServiceClassOperationCallable()");
  }

  public UnaryCallable<DeleteServiceClassRequest, Operation> deleteServiceClassCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServiceClassCallable()");
  }

  public UnaryCallable<GetServiceConnectionTokenRequest, ServiceConnectionToken>
      getServiceConnectionTokenCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceConnectionTokenCallable()");
  }

  public UnaryCallable<ListServiceConnectionTokensRequest, ListServiceConnectionTokensPagedResponse>
      listServiceConnectionTokensPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listServiceConnectionTokensPagedCallable()");
  }

  public UnaryCallable<ListServiceConnectionTokensRequest, ListServiceConnectionTokensResponse>
      listServiceConnectionTokensCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listServiceConnectionTokensCallable()");
  }

  public OperationCallable<
          CreateServiceConnectionTokenRequest, ServiceConnectionToken, OperationMetadata>
      createServiceConnectionTokenOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createServiceConnectionTokenOperationCallable()");
  }

  public UnaryCallable<CreateServiceConnectionTokenRequest, Operation>
      createServiceConnectionTokenCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createServiceConnectionTokenCallable()");
  }

  public OperationCallable<DeleteServiceConnectionTokenRequest, Empty, OperationMetadata>
      deleteServiceConnectionTokenOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteServiceConnectionTokenOperationCallable()");
  }

  public UnaryCallable<DeleteServiceConnectionTokenRequest, Operation>
      deleteServiceConnectionTokenCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteServiceConnectionTokenCallable()");
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
