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

package com.google.cloud.gkehub.v1.stub;

import static com.google.cloud.gkehub.v1.GkeHubClient.ListBoundMembershipsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListFeaturesPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListFleetsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListMembershipBindingsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListMembershipRBACRoleBindingsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListMembershipsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListPermittedScopesPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListScopeNamespacesPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListScopeRBACRoleBindingsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListScopesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkehub.v1.CreateFeatureRequest;
import com.google.cloud.gkehub.v1.CreateFleetRequest;
import com.google.cloud.gkehub.v1.CreateMembershipBindingRequest;
import com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.CreateMembershipRequest;
import com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest;
import com.google.cloud.gkehub.v1.CreateScopeRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.CreateScopeRequest;
import com.google.cloud.gkehub.v1.DeleteFeatureRequest;
import com.google.cloud.gkehub.v1.DeleteFleetRequest;
import com.google.cloud.gkehub.v1.DeleteMembershipBindingRequest;
import com.google.cloud.gkehub.v1.DeleteMembershipRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.DeleteMembershipRequest;
import com.google.cloud.gkehub.v1.DeleteScopeNamespaceRequest;
import com.google.cloud.gkehub.v1.DeleteScopeRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.DeleteScopeRequest;
import com.google.cloud.gkehub.v1.Feature;
import com.google.cloud.gkehub.v1.Fleet;
import com.google.cloud.gkehub.v1.GenerateConnectManifestRequest;
import com.google.cloud.gkehub.v1.GenerateConnectManifestResponse;
import com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLRequest;
import com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLResponse;
import com.google.cloud.gkehub.v1.GetFeatureRequest;
import com.google.cloud.gkehub.v1.GetFleetRequest;
import com.google.cloud.gkehub.v1.GetMembershipBindingRequest;
import com.google.cloud.gkehub.v1.GetMembershipRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.GetMembershipRequest;
import com.google.cloud.gkehub.v1.GetScopeNamespaceRequest;
import com.google.cloud.gkehub.v1.GetScopeRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.GetScopeRequest;
import com.google.cloud.gkehub.v1.ListBoundMembershipsRequest;
import com.google.cloud.gkehub.v1.ListBoundMembershipsResponse;
import com.google.cloud.gkehub.v1.ListFeaturesRequest;
import com.google.cloud.gkehub.v1.ListFeaturesResponse;
import com.google.cloud.gkehub.v1.ListFleetsRequest;
import com.google.cloud.gkehub.v1.ListFleetsResponse;
import com.google.cloud.gkehub.v1.ListMembershipBindingsRequest;
import com.google.cloud.gkehub.v1.ListMembershipBindingsResponse;
import com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsRequest;
import com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsResponse;
import com.google.cloud.gkehub.v1.ListMembershipsRequest;
import com.google.cloud.gkehub.v1.ListMembershipsResponse;
import com.google.cloud.gkehub.v1.ListPermittedScopesRequest;
import com.google.cloud.gkehub.v1.ListPermittedScopesResponse;
import com.google.cloud.gkehub.v1.ListScopeNamespacesRequest;
import com.google.cloud.gkehub.v1.ListScopeNamespacesResponse;
import com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsRequest;
import com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsResponse;
import com.google.cloud.gkehub.v1.ListScopesRequest;
import com.google.cloud.gkehub.v1.ListScopesResponse;
import com.google.cloud.gkehub.v1.Membership;
import com.google.cloud.gkehub.v1.MembershipBinding;
import com.google.cloud.gkehub.v1.Namespace;
import com.google.cloud.gkehub.v1.OperationMetadata;
import com.google.cloud.gkehub.v1.RBACRoleBinding;
import com.google.cloud.gkehub.v1.Scope;
import com.google.cloud.gkehub.v1.UpdateFeatureRequest;
import com.google.cloud.gkehub.v1.UpdateFleetRequest;
import com.google.cloud.gkehub.v1.UpdateMembershipBindingRequest;
import com.google.cloud.gkehub.v1.UpdateMembershipRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.UpdateMembershipRequest;
import com.google.cloud.gkehub.v1.UpdateScopeNamespaceRequest;
import com.google.cloud.gkehub.v1.UpdateScopeRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.UpdateScopeRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GkeHub service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class GkeHubStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMembershipsPagedCallable()");
  }

  public UnaryCallable<ListMembershipsRequest, ListMembershipsResponse> listMembershipsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMembershipsCallable()");
  }

  public UnaryCallable<ListBoundMembershipsRequest, ListBoundMembershipsPagedResponse>
      listBoundMembershipsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBoundMembershipsPagedCallable()");
  }

  public UnaryCallable<ListBoundMembershipsRequest, ListBoundMembershipsResponse>
      listBoundMembershipsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBoundMembershipsCallable()");
  }

  public UnaryCallable<ListFeaturesRequest, ListFeaturesPagedResponse> listFeaturesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeaturesPagedCallable()");
  }

  public UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> listFeaturesCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeaturesCallable()");
  }

  public UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: getMembershipCallable()");
  }

  public UnaryCallable<GetFeatureRequest, Feature> getFeatureCallable() {
    throw new UnsupportedOperationException("Not implemented: getFeatureCallable()");
  }

  public OperationCallable<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createMembershipOperationCallable()");
  }

  public UnaryCallable<CreateMembershipRequest, Operation> createMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: createMembershipCallable()");
  }

  public OperationCallable<CreateFeatureRequest, Feature, OperationMetadata>
      createFeatureOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createFeatureOperationCallable()");
  }

  public UnaryCallable<CreateFeatureRequest, Operation> createFeatureCallable() {
    throw new UnsupportedOperationException("Not implemented: createFeatureCallable()");
  }

  public OperationCallable<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMembershipOperationCallable()");
  }

  public UnaryCallable<DeleteMembershipRequest, Operation> deleteMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMembershipCallable()");
  }

  public OperationCallable<DeleteFeatureRequest, Empty, OperationMetadata>
      deleteFeatureOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFeatureOperationCallable()");
  }

  public UnaryCallable<DeleteFeatureRequest, Operation> deleteFeatureCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFeatureCallable()");
  }

  public OperationCallable<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMembershipOperationCallable()");
  }

  public UnaryCallable<UpdateMembershipRequest, Operation> updateMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMembershipCallable()");
  }

  public OperationCallable<UpdateFeatureRequest, Feature, OperationMetadata>
      updateFeatureOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFeatureOperationCallable()");
  }

  public UnaryCallable<UpdateFeatureRequest, Operation> updateFeatureCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFeatureCallable()");
  }

  public UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable() {
    throw new UnsupportedOperationException("Not implemented: generateConnectManifestCallable()");
  }

  public OperationCallable<CreateFleetRequest, Fleet, OperationMetadata>
      createFleetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createFleetOperationCallable()");
  }

  public UnaryCallable<CreateFleetRequest, Operation> createFleetCallable() {
    throw new UnsupportedOperationException("Not implemented: createFleetCallable()");
  }

  public UnaryCallable<GetFleetRequest, Fleet> getFleetCallable() {
    throw new UnsupportedOperationException("Not implemented: getFleetCallable()");
  }

  public OperationCallable<UpdateFleetRequest, Fleet, OperationMetadata>
      updateFleetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFleetOperationCallable()");
  }

  public UnaryCallable<UpdateFleetRequest, Operation> updateFleetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFleetCallable()");
  }

  public OperationCallable<DeleteFleetRequest, Empty, OperationMetadata>
      deleteFleetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFleetOperationCallable()");
  }

  public UnaryCallable<DeleteFleetRequest, Operation> deleteFleetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFleetCallable()");
  }

  public UnaryCallable<ListFleetsRequest, ListFleetsPagedResponse> listFleetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFleetsPagedCallable()");
  }

  public UnaryCallable<ListFleetsRequest, ListFleetsResponse> listFleetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFleetsCallable()");
  }

  public UnaryCallable<GetScopeNamespaceRequest, Namespace> getScopeNamespaceCallable() {
    throw new UnsupportedOperationException("Not implemented: getScopeNamespaceCallable()");
  }

  public OperationCallable<CreateScopeNamespaceRequest, Namespace, OperationMetadata>
      createScopeNamespaceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createScopeNamespaceOperationCallable()");
  }

  public UnaryCallable<CreateScopeNamespaceRequest, Operation> createScopeNamespaceCallable() {
    throw new UnsupportedOperationException("Not implemented: createScopeNamespaceCallable()");
  }

  public OperationCallable<UpdateScopeNamespaceRequest, Namespace, OperationMetadata>
      updateScopeNamespaceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateScopeNamespaceOperationCallable()");
  }

  public UnaryCallable<UpdateScopeNamespaceRequest, Operation> updateScopeNamespaceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateScopeNamespaceCallable()");
  }

  public OperationCallable<DeleteScopeNamespaceRequest, Empty, OperationMetadata>
      deleteScopeNamespaceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteScopeNamespaceOperationCallable()");
  }

  public UnaryCallable<DeleteScopeNamespaceRequest, Operation> deleteScopeNamespaceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteScopeNamespaceCallable()");
  }

  public UnaryCallable<ListScopeNamespacesRequest, ListScopeNamespacesPagedResponse>
      listScopeNamespacesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listScopeNamespacesPagedCallable()");
  }

  public UnaryCallable<ListScopeNamespacesRequest, ListScopeNamespacesResponse>
      listScopeNamespacesCallable() {
    throw new UnsupportedOperationException("Not implemented: listScopeNamespacesCallable()");
  }

  public UnaryCallable<GetScopeRBACRoleBindingRequest, RBACRoleBinding>
      getScopeRBACRoleBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: getScopeRBACRoleBindingCallable()");
  }

  public OperationCallable<CreateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      createScopeRBACRoleBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createScopeRBACRoleBindingOperationCallable()");
  }

  public UnaryCallable<CreateScopeRBACRoleBindingRequest, Operation>
      createScopeRBACRoleBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createScopeRBACRoleBindingCallable()");
  }

  public OperationCallable<UpdateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      updateScopeRBACRoleBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateScopeRBACRoleBindingOperationCallable()");
  }

  public UnaryCallable<UpdateScopeRBACRoleBindingRequest, Operation>
      updateScopeRBACRoleBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateScopeRBACRoleBindingCallable()");
  }

  public OperationCallable<DeleteScopeRBACRoleBindingRequest, Empty, OperationMetadata>
      deleteScopeRBACRoleBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteScopeRBACRoleBindingOperationCallable()");
  }

  public UnaryCallable<DeleteScopeRBACRoleBindingRequest, Operation>
      deleteScopeRBACRoleBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteScopeRBACRoleBindingCallable()");
  }

  public UnaryCallable<ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsPagedResponse>
      listScopeRBACRoleBindingsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listScopeRBACRoleBindingsPagedCallable()");
  }

  public UnaryCallable<ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsResponse>
      listScopeRBACRoleBindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listScopeRBACRoleBindingsCallable()");
  }

  public UnaryCallable<GetScopeRequest, Scope> getScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: getScopeCallable()");
  }

  public OperationCallable<CreateScopeRequest, Scope, OperationMetadata>
      createScopeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createScopeOperationCallable()");
  }

  public UnaryCallable<CreateScopeRequest, Operation> createScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: createScopeCallable()");
  }

  public OperationCallable<UpdateScopeRequest, Scope, OperationMetadata>
      updateScopeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateScopeOperationCallable()");
  }

  public UnaryCallable<UpdateScopeRequest, Operation> updateScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateScopeCallable()");
  }

  public OperationCallable<DeleteScopeRequest, Empty, OperationMetadata>
      deleteScopeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteScopeOperationCallable()");
  }

  public UnaryCallable<DeleteScopeRequest, Operation> deleteScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteScopeCallable()");
  }

  public UnaryCallable<ListScopesRequest, ListScopesPagedResponse> listScopesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listScopesPagedCallable()");
  }

  public UnaryCallable<ListScopesRequest, ListScopesResponse> listScopesCallable() {
    throw new UnsupportedOperationException("Not implemented: listScopesCallable()");
  }

  public UnaryCallable<ListPermittedScopesRequest, ListPermittedScopesPagedResponse>
      listPermittedScopesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPermittedScopesPagedCallable()");
  }

  public UnaryCallable<ListPermittedScopesRequest, ListPermittedScopesResponse>
      listPermittedScopesCallable() {
    throw new UnsupportedOperationException("Not implemented: listPermittedScopesCallable()");
  }

  public UnaryCallable<GetMembershipBindingRequest, MembershipBinding>
      getMembershipBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: getMembershipBindingCallable()");
  }

  public OperationCallable<CreateMembershipBindingRequest, MembershipBinding, OperationMetadata>
      createMembershipBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMembershipBindingOperationCallable()");
  }

  public UnaryCallable<CreateMembershipBindingRequest, Operation>
      createMembershipBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: createMembershipBindingCallable()");
  }

  public OperationCallable<UpdateMembershipBindingRequest, MembershipBinding, OperationMetadata>
      updateMembershipBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMembershipBindingOperationCallable()");
  }

  public UnaryCallable<UpdateMembershipBindingRequest, Operation>
      updateMembershipBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMembershipBindingCallable()");
  }

  public OperationCallable<DeleteMembershipBindingRequest, Empty, OperationMetadata>
      deleteMembershipBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMembershipBindingOperationCallable()");
  }

  public UnaryCallable<DeleteMembershipBindingRequest, Operation>
      deleteMembershipBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMembershipBindingCallable()");
  }

  public UnaryCallable<ListMembershipBindingsRequest, ListMembershipBindingsPagedResponse>
      listMembershipBindingsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMembershipBindingsPagedCallable()");
  }

  public UnaryCallable<ListMembershipBindingsRequest, ListMembershipBindingsResponse>
      listMembershipBindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMembershipBindingsCallable()");
  }

  public UnaryCallable<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>
      getMembershipRBACRoleBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getMembershipRBACRoleBindingCallable()");
  }

  public OperationCallable<
          CreateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      createMembershipRBACRoleBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMembershipRBACRoleBindingOperationCallable()");
  }

  public UnaryCallable<CreateMembershipRBACRoleBindingRequest, Operation>
      createMembershipRBACRoleBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMembershipRBACRoleBindingCallable()");
  }

  public OperationCallable<
          UpdateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      updateMembershipRBACRoleBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMembershipRBACRoleBindingOperationCallable()");
  }

  public UnaryCallable<UpdateMembershipRBACRoleBindingRequest, Operation>
      updateMembershipRBACRoleBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMembershipRBACRoleBindingCallable()");
  }

  public OperationCallable<DeleteMembershipRBACRoleBindingRequest, Empty, OperationMetadata>
      deleteMembershipRBACRoleBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMembershipRBACRoleBindingOperationCallable()");
  }

  public UnaryCallable<DeleteMembershipRBACRoleBindingRequest, Operation>
      deleteMembershipRBACRoleBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMembershipRBACRoleBindingCallable()");
  }

  public UnaryCallable<
          ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsPagedResponse>
      listMembershipRBACRoleBindingsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMembershipRBACRoleBindingsPagedCallable()");
  }

  public UnaryCallable<
          ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsResponse>
      listMembershipRBACRoleBindingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMembershipRBACRoleBindingsCallable()");
  }

  public UnaryCallable<
          GenerateMembershipRBACRoleBindingYAMLRequest,
          GenerateMembershipRBACRoleBindingYAMLResponse>
      generateMembershipRBACRoleBindingYAMLCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateMembershipRBACRoleBindingYAMLCallable()");
  }

  @Override
  public abstract void close();
}
