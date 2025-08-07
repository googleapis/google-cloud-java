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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1.stub;

import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListLocationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListReleasesPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListSaasPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListTenantsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListUnitKindsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListUnitOperationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListUnitsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateReleaseRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateSaasRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateTenantRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitOperationRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteReleaseRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteSaasRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteTenantRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitOperationRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetReleaseRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitOperationRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateReleaseRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateSaasRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateTenantRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitOperationRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SaasDeployments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SaasDeploymentsStub implements BackgroundResource {

  public UnaryCallable<ListSaasRequest, ListSaasPagedResponse> listSaasPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSaasPagedCallable()");
  }

  public UnaryCallable<ListSaasRequest, ListSaasResponse> listSaasCallable() {
    throw new UnsupportedOperationException("Not implemented: listSaasCallable()");
  }

  public UnaryCallable<GetSaasRequest, Saas> getSaasCallable() {
    throw new UnsupportedOperationException("Not implemented: getSaasCallable()");
  }

  public UnaryCallable<CreateSaasRequest, Saas> createSaasCallable() {
    throw new UnsupportedOperationException("Not implemented: createSaasCallable()");
  }

  public UnaryCallable<UpdateSaasRequest, Saas> updateSaasCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSaasCallable()");
  }

  public UnaryCallable<DeleteSaasRequest, Empty> deleteSaasCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSaasCallable()");
  }

  public UnaryCallable<ListTenantsRequest, ListTenantsPagedResponse> listTenantsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTenantsPagedCallable()");
  }

  public UnaryCallable<ListTenantsRequest, ListTenantsResponse> listTenantsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTenantsCallable()");
  }

  public UnaryCallable<GetTenantRequest, Tenant> getTenantCallable() {
    throw new UnsupportedOperationException("Not implemented: getTenantCallable()");
  }

  public UnaryCallable<CreateTenantRequest, Tenant> createTenantCallable() {
    throw new UnsupportedOperationException("Not implemented: createTenantCallable()");
  }

  public UnaryCallable<UpdateTenantRequest, Tenant> updateTenantCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTenantCallable()");
  }

  public UnaryCallable<DeleteTenantRequest, Empty> deleteTenantCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTenantCallable()");
  }

  public UnaryCallable<ListUnitKindsRequest, ListUnitKindsPagedResponse>
      listUnitKindsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listUnitKindsPagedCallable()");
  }

  public UnaryCallable<ListUnitKindsRequest, ListUnitKindsResponse> listUnitKindsCallable() {
    throw new UnsupportedOperationException("Not implemented: listUnitKindsCallable()");
  }

  public UnaryCallable<GetUnitKindRequest, UnitKind> getUnitKindCallable() {
    throw new UnsupportedOperationException("Not implemented: getUnitKindCallable()");
  }

  public UnaryCallable<CreateUnitKindRequest, UnitKind> createUnitKindCallable() {
    throw new UnsupportedOperationException("Not implemented: createUnitKindCallable()");
  }

  public UnaryCallable<UpdateUnitKindRequest, UnitKind> updateUnitKindCallable() {
    throw new UnsupportedOperationException("Not implemented: updateUnitKindCallable()");
  }

  public UnaryCallable<DeleteUnitKindRequest, Empty> deleteUnitKindCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUnitKindCallable()");
  }

  public UnaryCallable<ListUnitsRequest, ListUnitsPagedResponse> listUnitsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listUnitsPagedCallable()");
  }

  public UnaryCallable<ListUnitsRequest, ListUnitsResponse> listUnitsCallable() {
    throw new UnsupportedOperationException("Not implemented: listUnitsCallable()");
  }

  public UnaryCallable<GetUnitRequest, Unit> getUnitCallable() {
    throw new UnsupportedOperationException("Not implemented: getUnitCallable()");
  }

  public UnaryCallable<CreateUnitRequest, Unit> createUnitCallable() {
    throw new UnsupportedOperationException("Not implemented: createUnitCallable()");
  }

  public UnaryCallable<UpdateUnitRequest, Unit> updateUnitCallable() {
    throw new UnsupportedOperationException("Not implemented: updateUnitCallable()");
  }

  public UnaryCallable<DeleteUnitRequest, Empty> deleteUnitCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUnitCallable()");
  }

  public UnaryCallable<ListUnitOperationsRequest, ListUnitOperationsPagedResponse>
      listUnitOperationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listUnitOperationsPagedCallable()");
  }

  public UnaryCallable<ListUnitOperationsRequest, ListUnitOperationsResponse>
      listUnitOperationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listUnitOperationsCallable()");
  }

  public UnaryCallable<GetUnitOperationRequest, UnitOperation> getUnitOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: getUnitOperationCallable()");
  }

  public UnaryCallable<CreateUnitOperationRequest, UnitOperation> createUnitOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createUnitOperationCallable()");
  }

  public UnaryCallable<UpdateUnitOperationRequest, UnitOperation> updateUnitOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateUnitOperationCallable()");
  }

  public UnaryCallable<DeleteUnitOperationRequest, Empty> deleteUnitOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUnitOperationCallable()");
  }

  public UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse> listReleasesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReleasesPagedCallable()");
  }

  public UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable() {
    throw new UnsupportedOperationException("Not implemented: listReleasesCallable()");
  }

  public UnaryCallable<GetReleaseRequest, Release> getReleaseCallable() {
    throw new UnsupportedOperationException("Not implemented: getReleaseCallable()");
  }

  public UnaryCallable<CreateReleaseRequest, Release> createReleaseCallable() {
    throw new UnsupportedOperationException("Not implemented: createReleaseCallable()");
  }

  public UnaryCallable<UpdateReleaseRequest, Release> updateReleaseCallable() {
    throw new UnsupportedOperationException("Not implemented: updateReleaseCallable()");
  }

  public UnaryCallable<DeleteReleaseRequest, Empty> deleteReleaseCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteReleaseCallable()");
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
