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

package com.google.cloud.numberregistry.v1alpha.stub;

import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListCustomRangesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListDiscoveredRangesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListIpamAdminScopesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListRealmsPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListRegistryBooksPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.SearchIpResourcesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesRequest;
import com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesResponse;
import com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest;
import com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.CreateRealmRequest;
import com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest;
import com.google.cloud.numberregistry.v1alpha.CustomRange;
import com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest;
import com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest;
import com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest;
import com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.DiscoveredRange;
import com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesRequest;
import com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesResponse;
import com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesRequest;
import com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesResponse;
import com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest;
import com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest;
import com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.GetRealmRequest;
import com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest;
import com.google.cloud.numberregistry.v1alpha.IpamAdminScope;
import com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest;
import com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse;
import com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest;
import com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse;
import com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest;
import com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse;
import com.google.cloud.numberregistry.v1alpha.ListRealmsRequest;
import com.google.cloud.numberregistry.v1alpha.ListRealmsResponse;
import com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest;
import com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse;
import com.google.cloud.numberregistry.v1alpha.OperationMetadata;
import com.google.cloud.numberregistry.v1alpha.Realm;
import com.google.cloud.numberregistry.v1alpha.RegistryBook;
import com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest;
import com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse;
import com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationRequest;
import com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationResponse;
import com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationRequest;
import com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationResponse;
import com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest;
import com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest;
import com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudNumberRegistry service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class CloudNumberRegistryStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListIpamAdminScopesRequest, ListIpamAdminScopesPagedResponse>
      listIpamAdminScopesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIpamAdminScopesPagedCallable()");
  }

  public UnaryCallable<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse>
      listIpamAdminScopesCallable() {
    throw new UnsupportedOperationException("Not implemented: listIpamAdminScopesCallable()");
  }

  public UnaryCallable<GetIpamAdminScopeRequest, IpamAdminScope> getIpamAdminScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: getIpamAdminScopeCallable()");
  }

  public UnaryCallable<
          CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
      checkAvailabilityIpamAdminScopesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: checkAvailabilityIpamAdminScopesCallable()");
  }

  public OperationCallable<CreateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      createIpamAdminScopeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createIpamAdminScopeOperationCallable()");
  }

  public UnaryCallable<CreateIpamAdminScopeRequest, Operation> createIpamAdminScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: createIpamAdminScopeCallable()");
  }

  public OperationCallable<UpdateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      updateIpamAdminScopeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateIpamAdminScopeOperationCallable()");
  }

  public UnaryCallable<UpdateIpamAdminScopeRequest, Operation> updateIpamAdminScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIpamAdminScopeCallable()");
  }

  public OperationCallable<DeleteIpamAdminScopeRequest, Empty, OperationMetadata>
      deleteIpamAdminScopeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteIpamAdminScopeOperationCallable()");
  }

  public UnaryCallable<DeleteIpamAdminScopeRequest, Operation> deleteIpamAdminScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIpamAdminScopeCallable()");
  }

  public OperationCallable<DisableIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      disableIpamAdminScopeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: disableIpamAdminScopeOperationCallable()");
  }

  public UnaryCallable<DisableIpamAdminScopeRequest, Operation> disableIpamAdminScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: disableIpamAdminScopeCallable()");
  }

  public OperationCallable<CleanupIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      cleanupIpamAdminScopeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: cleanupIpamAdminScopeOperationCallable()");
  }

  public UnaryCallable<CleanupIpamAdminScopeRequest, Operation> cleanupIpamAdminScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: cleanupIpamAdminScopeCallable()");
  }

  public UnaryCallable<ListRegistryBooksRequest, ListRegistryBooksPagedResponse>
      listRegistryBooksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegistryBooksPagedCallable()");
  }

  public UnaryCallable<ListRegistryBooksRequest, ListRegistryBooksResponse>
      listRegistryBooksCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegistryBooksCallable()");
  }

  public UnaryCallable<GetRegistryBookRequest, RegistryBook> getRegistryBookCallable() {
    throw new UnsupportedOperationException("Not implemented: getRegistryBookCallable()");
  }

  public UnaryCallable<SearchIpResourcesRequest, SearchIpResourcesPagedResponse>
      searchIpResourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchIpResourcesPagedCallable()");
  }

  public UnaryCallable<SearchIpResourcesRequest, SearchIpResourcesResponse>
      searchIpResourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchIpResourcesCallable()");
  }

  public OperationCallable<CreateRegistryBookRequest, RegistryBook, OperationMetadata>
      createRegistryBookOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createRegistryBookOperationCallable()");
  }

  public UnaryCallable<CreateRegistryBookRequest, Operation> createRegistryBookCallable() {
    throw new UnsupportedOperationException("Not implemented: createRegistryBookCallable()");
  }

  public OperationCallable<UpdateRegistryBookRequest, RegistryBook, OperationMetadata>
      updateRegistryBookOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateRegistryBookOperationCallable()");
  }

  public UnaryCallable<UpdateRegistryBookRequest, Operation> updateRegistryBookCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRegistryBookCallable()");
  }

  public OperationCallable<DeleteRegistryBookRequest, Empty, OperationMetadata>
      deleteRegistryBookOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteRegistryBookOperationCallable()");
  }

  public UnaryCallable<DeleteRegistryBookRequest, Operation> deleteRegistryBookCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRegistryBookCallable()");
  }

  public UnaryCallable<ListRealmsRequest, ListRealmsPagedResponse> listRealmsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRealmsPagedCallable()");
  }

  public UnaryCallable<ListRealmsRequest, ListRealmsResponse> listRealmsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRealmsCallable()");
  }

  public UnaryCallable<GetRealmRequest, Realm> getRealmCallable() {
    throw new UnsupportedOperationException("Not implemented: getRealmCallable()");
  }

  public OperationCallable<CreateRealmRequest, Realm, OperationMetadata>
      createRealmOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createRealmOperationCallable()");
  }

  public UnaryCallable<CreateRealmRequest, Operation> createRealmCallable() {
    throw new UnsupportedOperationException("Not implemented: createRealmCallable()");
  }

  public OperationCallable<UpdateRealmRequest, Realm, OperationMetadata>
      updateRealmOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRealmOperationCallable()");
  }

  public UnaryCallable<UpdateRealmRequest, Operation> updateRealmCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRealmCallable()");
  }

  public OperationCallable<DeleteRealmRequest, Empty, OperationMetadata>
      deleteRealmOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRealmOperationCallable()");
  }

  public UnaryCallable<DeleteRealmRequest, Operation> deleteRealmCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRealmCallable()");
  }

  public UnaryCallable<ListDiscoveredRangesRequest, ListDiscoveredRangesPagedResponse>
      listDiscoveredRangesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDiscoveredRangesPagedCallable()");
  }

  public UnaryCallable<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse>
      listDiscoveredRangesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDiscoveredRangesCallable()");
  }

  public UnaryCallable<GetDiscoveredRangeRequest, DiscoveredRange> getDiscoveredRangeCallable() {
    throw new UnsupportedOperationException("Not implemented: getDiscoveredRangeCallable()");
  }

  public UnaryCallable<
          FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
      findDiscoveredRangeFreeIpRangesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: findDiscoveredRangeFreeIpRangesCallable()");
  }

  public UnaryCallable<ListCustomRangesRequest, ListCustomRangesPagedResponse>
      listCustomRangesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomRangesPagedCallable()");
  }

  public UnaryCallable<ListCustomRangesRequest, ListCustomRangesResponse>
      listCustomRangesCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomRangesCallable()");
  }

  public UnaryCallable<GetCustomRangeRequest, CustomRange> getCustomRangeCallable() {
    throw new UnsupportedOperationException("Not implemented: getCustomRangeCallable()");
  }

  public UnaryCallable<ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>
      showCustomRangeUtilizationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: showCustomRangeUtilizationCallable()");
  }

  public UnaryCallable<
          ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
      showDiscoveredRangeUtilizationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: showDiscoveredRangeUtilizationCallable()");
  }

  public UnaryCallable<FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
      findCustomRangeFreeIpRangesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: findCustomRangeFreeIpRangesCallable()");
  }

  public OperationCallable<CreateCustomRangeRequest, CustomRange, OperationMetadata>
      createCustomRangeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createCustomRangeOperationCallable()");
  }

  public UnaryCallable<CreateCustomRangeRequest, Operation> createCustomRangeCallable() {
    throw new UnsupportedOperationException("Not implemented: createCustomRangeCallable()");
  }

  public OperationCallable<UpdateCustomRangeRequest, CustomRange, OperationMetadata>
      updateCustomRangeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateCustomRangeOperationCallable()");
  }

  public UnaryCallable<UpdateCustomRangeRequest, Operation> updateCustomRangeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCustomRangeCallable()");
  }

  public OperationCallable<DeleteCustomRangeRequest, Empty, OperationMetadata>
      deleteCustomRangeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteCustomRangeOperationCallable()");
  }

  public UnaryCallable<DeleteCustomRangeRequest, Operation> deleteCustomRangeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCustomRangeCallable()");
  }

  @Override
  public abstract void close();
}
