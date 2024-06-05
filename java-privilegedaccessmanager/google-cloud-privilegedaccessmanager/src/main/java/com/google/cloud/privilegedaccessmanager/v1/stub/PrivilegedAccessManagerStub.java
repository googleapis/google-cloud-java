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

package com.google.cloud.privilegedaccessmanager.v1.stub;

import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListEntitlementsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListGrantsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.SearchEntitlementsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.SearchGrantsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.privilegedaccessmanager.v1.ApproveGrantRequest;
import com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusRequest;
import com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusResponse;
import com.google.cloud.privilegedaccessmanager.v1.CreateEntitlementRequest;
import com.google.cloud.privilegedaccessmanager.v1.CreateGrantRequest;
import com.google.cloud.privilegedaccessmanager.v1.DeleteEntitlementRequest;
import com.google.cloud.privilegedaccessmanager.v1.DenyGrantRequest;
import com.google.cloud.privilegedaccessmanager.v1.Entitlement;
import com.google.cloud.privilegedaccessmanager.v1.GetEntitlementRequest;
import com.google.cloud.privilegedaccessmanager.v1.GetGrantRequest;
import com.google.cloud.privilegedaccessmanager.v1.Grant;
import com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsRequest;
import com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsResponse;
import com.google.cloud.privilegedaccessmanager.v1.ListGrantsRequest;
import com.google.cloud.privilegedaccessmanager.v1.ListGrantsResponse;
import com.google.cloud.privilegedaccessmanager.v1.OperationMetadata;
import com.google.cloud.privilegedaccessmanager.v1.RevokeGrantRequest;
import com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest;
import com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsResponse;
import com.google.cloud.privilegedaccessmanager.v1.SearchGrantsRequest;
import com.google.cloud.privilegedaccessmanager.v1.SearchGrantsResponse;
import com.google.cloud.privilegedaccessmanager.v1.UpdateEntitlementRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the PrivilegedAccessManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class PrivilegedAccessManagerStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>
      checkOnboardingStatusCallable() {
    throw new UnsupportedOperationException("Not implemented: checkOnboardingStatusCallable()");
  }

  public UnaryCallable<ListEntitlementsRequest, ListEntitlementsPagedResponse>
      listEntitlementsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntitlementsPagedCallable()");
  }

  public UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntitlementsCallable()");
  }

  public UnaryCallable<SearchEntitlementsRequest, SearchEntitlementsPagedResponse>
      searchEntitlementsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchEntitlementsPagedCallable()");
  }

  public UnaryCallable<SearchEntitlementsRequest, SearchEntitlementsResponse>
      searchEntitlementsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchEntitlementsCallable()");
  }

  public UnaryCallable<GetEntitlementRequest, Entitlement> getEntitlementCallable() {
    throw new UnsupportedOperationException("Not implemented: getEntitlementCallable()");
  }

  public OperationCallable<CreateEntitlementRequest, Entitlement, OperationMetadata>
      createEntitlementOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createEntitlementOperationCallable()");
  }

  public UnaryCallable<CreateEntitlementRequest, Operation> createEntitlementCallable() {
    throw new UnsupportedOperationException("Not implemented: createEntitlementCallable()");
  }

  public OperationCallable<DeleteEntitlementRequest, Entitlement, OperationMetadata>
      deleteEntitlementOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteEntitlementOperationCallable()");
  }

  public UnaryCallable<DeleteEntitlementRequest, Operation> deleteEntitlementCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEntitlementCallable()");
  }

  public OperationCallable<UpdateEntitlementRequest, Entitlement, OperationMetadata>
      updateEntitlementOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateEntitlementOperationCallable()");
  }

  public UnaryCallable<UpdateEntitlementRequest, Operation> updateEntitlementCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEntitlementCallable()");
  }

  public UnaryCallable<ListGrantsRequest, ListGrantsPagedResponse> listGrantsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGrantsPagedCallable()");
  }

  public UnaryCallable<ListGrantsRequest, ListGrantsResponse> listGrantsCallable() {
    throw new UnsupportedOperationException("Not implemented: listGrantsCallable()");
  }

  public UnaryCallable<SearchGrantsRequest, SearchGrantsPagedResponse> searchGrantsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchGrantsPagedCallable()");
  }

  public UnaryCallable<SearchGrantsRequest, SearchGrantsResponse> searchGrantsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchGrantsCallable()");
  }

  public UnaryCallable<GetGrantRequest, Grant> getGrantCallable() {
    throw new UnsupportedOperationException("Not implemented: getGrantCallable()");
  }

  public UnaryCallable<CreateGrantRequest, Grant> createGrantCallable() {
    throw new UnsupportedOperationException("Not implemented: createGrantCallable()");
  }

  public UnaryCallable<ApproveGrantRequest, Grant> approveGrantCallable() {
    throw new UnsupportedOperationException("Not implemented: approveGrantCallable()");
  }

  public UnaryCallable<DenyGrantRequest, Grant> denyGrantCallable() {
    throw new UnsupportedOperationException("Not implemented: denyGrantCallable()");
  }

  public OperationCallable<RevokeGrantRequest, Grant, OperationMetadata>
      revokeGrantOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: revokeGrantOperationCallable()");
  }

  public UnaryCallable<RevokeGrantRequest, Operation> revokeGrantCallable() {
    throw new UnsupportedOperationException("Not implemented: revokeGrantCallable()");
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

  @Override
  public abstract void close();
}
