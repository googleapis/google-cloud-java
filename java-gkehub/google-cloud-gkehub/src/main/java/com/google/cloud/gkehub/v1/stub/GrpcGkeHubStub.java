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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the GkeHub service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcGkeHubStub extends GkeHubStub {
  private static final MethodDescriptor<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsMethodDescriptor =
          MethodDescriptor.<ListMembershipsRequest, ListMembershipsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListMemberships")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMembershipsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMembershipsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListBoundMembershipsRequest, ListBoundMembershipsResponse>
      listBoundMembershipsMethodDescriptor =
          MethodDescriptor.<ListBoundMembershipsRequest, ListBoundMembershipsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListBoundMemberships")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBoundMembershipsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBoundMembershipsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListFeaturesRequest, ListFeaturesResponse>
      listFeaturesMethodDescriptor =
          MethodDescriptor.<ListFeaturesRequest, ListFeaturesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListFeatures")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFeaturesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFeaturesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMembershipRequest, Membership>
      getMembershipMethodDescriptor =
          MethodDescriptor.<GetMembershipRequest, Membership>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Membership.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetFeatureRequest, Feature> getFeatureMethodDescriptor =
      MethodDescriptor.<GetFeatureRequest, Feature>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetFeature")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFeatureRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Feature.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateMembershipRequest, Operation>
      createMembershipMethodDescriptor =
          MethodDescriptor.<CreateMembershipRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateFeatureRequest, Operation>
      createFeatureMethodDescriptor =
          MethodDescriptor.<CreateFeatureRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateFeature")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteMembershipRequest, Operation>
      deleteMembershipMethodDescriptor =
          MethodDescriptor.<DeleteMembershipRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteFeatureRequest, Operation>
      deleteFeatureMethodDescriptor =
          MethodDescriptor.<DeleteFeatureRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteFeature")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateMembershipRequest, Operation>
      updateMembershipMethodDescriptor =
          MethodDescriptor.<UpdateMembershipRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateFeatureRequest, Operation>
      updateFeatureMethodDescriptor =
          MethodDescriptor.<UpdateFeatureRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateFeature")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestMethodDescriptor =
          MethodDescriptor
              .<GenerateConnectManifestRequest, GenerateConnectManifestResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GenerateConnectManifest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateConnectManifestRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateConnectManifestResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateFleetRequest, Operation> createFleetMethodDescriptor =
      MethodDescriptor.<CreateFleetRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateFleet")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateFleetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetFleetRequest, Fleet> getFleetMethodDescriptor =
      MethodDescriptor.<GetFleetRequest, Fleet>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetFleet")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFleetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Fleet.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateFleetRequest, Operation> updateFleetMethodDescriptor =
      MethodDescriptor.<UpdateFleetRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateFleet")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateFleetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteFleetRequest, Operation> deleteFleetMethodDescriptor =
      MethodDescriptor.<DeleteFleetRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteFleet")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteFleetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListFleetsRequest, ListFleetsResponse>
      listFleetsMethodDescriptor =
          MethodDescriptor.<ListFleetsRequest, ListFleetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListFleets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFleetsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListFleetsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetScopeNamespaceRequest, Namespace>
      getScopeNamespaceMethodDescriptor =
          MethodDescriptor.<GetScopeNamespaceRequest, Namespace>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetScopeNamespace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetScopeNamespaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Namespace.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateScopeNamespaceRequest, Operation>
      createScopeNamespaceMethodDescriptor =
          MethodDescriptor.<CreateScopeNamespaceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateScopeNamespace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateScopeNamespaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateScopeNamespaceRequest, Operation>
      updateScopeNamespaceMethodDescriptor =
          MethodDescriptor.<UpdateScopeNamespaceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateScopeNamespace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateScopeNamespaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteScopeNamespaceRequest, Operation>
      deleteScopeNamespaceMethodDescriptor =
          MethodDescriptor.<DeleteScopeNamespaceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteScopeNamespace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteScopeNamespaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListScopeNamespacesRequest, ListScopeNamespacesResponse>
      listScopeNamespacesMethodDescriptor =
          MethodDescriptor.<ListScopeNamespacesRequest, ListScopeNamespacesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListScopeNamespaces")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListScopeNamespacesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListScopeNamespacesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetScopeRBACRoleBindingRequest, RBACRoleBinding>
      getScopeRBACRoleBindingMethodDescriptor =
          MethodDescriptor.<GetScopeRBACRoleBindingRequest, RBACRoleBinding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetScopeRBACRoleBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetScopeRBACRoleBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RBACRoleBinding.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateScopeRBACRoleBindingRequest, Operation>
      createScopeRBACRoleBindingMethodDescriptor =
          MethodDescriptor.<CreateScopeRBACRoleBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateScopeRBACRoleBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateScopeRBACRoleBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateScopeRBACRoleBindingRequest, Operation>
      updateScopeRBACRoleBindingMethodDescriptor =
          MethodDescriptor.<UpdateScopeRBACRoleBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateScopeRBACRoleBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateScopeRBACRoleBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteScopeRBACRoleBindingRequest, Operation>
      deleteScopeRBACRoleBindingMethodDescriptor =
          MethodDescriptor.<DeleteScopeRBACRoleBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteScopeRBACRoleBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteScopeRBACRoleBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsResponse>
      listScopeRBACRoleBindingsMethodDescriptor =
          MethodDescriptor
              .<ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListScopeRBACRoleBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListScopeRBACRoleBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListScopeRBACRoleBindingsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetScopeRequest, Scope> getScopeMethodDescriptor =
      MethodDescriptor.<GetScopeRequest, Scope>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetScope")
          .setRequestMarshaller(ProtoUtils.marshaller(GetScopeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Scope.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateScopeRequest, Operation> createScopeMethodDescriptor =
      MethodDescriptor.<CreateScopeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateScope")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateScopeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateScopeRequest, Operation> updateScopeMethodDescriptor =
      MethodDescriptor.<UpdateScopeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateScope")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateScopeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteScopeRequest, Operation> deleteScopeMethodDescriptor =
      MethodDescriptor.<DeleteScopeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteScope")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteScopeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListScopesRequest, ListScopesResponse>
      listScopesMethodDescriptor =
          MethodDescriptor.<ListScopesRequest, ListScopesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListScopes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListScopesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListScopesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListPermittedScopesRequest, ListPermittedScopesResponse>
      listPermittedScopesMethodDescriptor =
          MethodDescriptor.<ListPermittedScopesRequest, ListPermittedScopesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListPermittedScopes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPermittedScopesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPermittedScopesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMembershipBindingRequest, MembershipBinding>
      getMembershipBindingMethodDescriptor =
          MethodDescriptor.<GetMembershipBindingRequest, MembershipBinding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetMembershipBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMembershipBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MembershipBinding.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateMembershipBindingRequest, Operation>
      createMembershipBindingMethodDescriptor =
          MethodDescriptor.<CreateMembershipBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateMembershipBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMembershipBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateMembershipBindingRequest, Operation>
      updateMembershipBindingMethodDescriptor =
          MethodDescriptor.<UpdateMembershipBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateMembershipBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMembershipBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteMembershipBindingRequest, Operation>
      deleteMembershipBindingMethodDescriptor =
          MethodDescriptor.<DeleteMembershipBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteMembershipBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMembershipBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListMembershipBindingsRequest, ListMembershipBindingsResponse>
      listMembershipBindingsMethodDescriptor =
          MethodDescriptor
              .<ListMembershipBindingsRequest, ListMembershipBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListMembershipBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMembershipBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMembershipBindingsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>
      getMembershipRBACRoleBindingMethodDescriptor =
          MethodDescriptor.<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetMembershipRBACRoleBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMembershipRBACRoleBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RBACRoleBinding.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateMembershipRBACRoleBindingRequest, Operation>
      createMembershipRBACRoleBindingMethodDescriptor =
          MethodDescriptor.<CreateMembershipRBACRoleBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateMembershipRBACRoleBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateMembershipRBACRoleBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateMembershipRBACRoleBindingRequest, Operation>
      updateMembershipRBACRoleBindingMethodDescriptor =
          MethodDescriptor.<UpdateMembershipRBACRoleBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateMembershipRBACRoleBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateMembershipRBACRoleBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteMembershipRBACRoleBindingRequest, Operation>
      deleteMembershipRBACRoleBindingMethodDescriptor =
          MethodDescriptor.<DeleteMembershipRBACRoleBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteMembershipRBACRoleBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteMembershipRBACRoleBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsResponse>
      listMembershipRBACRoleBindingsMethodDescriptor =
          MethodDescriptor
              .<ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListMembershipRBACRoleBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMembershipRBACRoleBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListMembershipRBACRoleBindingsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GenerateMembershipRBACRoleBindingYAMLRequest,
          GenerateMembershipRBACRoleBindingYAMLResponse>
      generateMembershipRBACRoleBindingYAMLMethodDescriptor =
          MethodDescriptor
              .<GenerateMembershipRBACRoleBindingYAMLRequest,
                  GenerateMembershipRBACRoleBindingYAMLResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkehub.v1.GkeHub/GenerateMembershipRBACRoleBindingYAML")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GenerateMembershipRBACRoleBindingYAMLRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      GenerateMembershipRBACRoleBindingYAMLResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsCallable;
  private final UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable;
  private final UnaryCallable<ListBoundMembershipsRequest, ListBoundMembershipsResponse>
      listBoundMembershipsCallable;
  private final UnaryCallable<ListBoundMembershipsRequest, ListBoundMembershipsPagedResponse>
      listBoundMembershipsPagedCallable;
  private final UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> listFeaturesCallable;
  private final UnaryCallable<ListFeaturesRequest, ListFeaturesPagedResponse>
      listFeaturesPagedCallable;
  private final UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable;
  private final UnaryCallable<GetFeatureRequest, Feature> getFeatureCallable;
  private final UnaryCallable<CreateMembershipRequest, Operation> createMembershipCallable;
  private final OperationCallable<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationCallable;
  private final UnaryCallable<CreateFeatureRequest, Operation> createFeatureCallable;
  private final OperationCallable<CreateFeatureRequest, Feature, OperationMetadata>
      createFeatureOperationCallable;
  private final UnaryCallable<DeleteMembershipRequest, Operation> deleteMembershipCallable;
  private final OperationCallable<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationCallable;
  private final UnaryCallable<DeleteFeatureRequest, Operation> deleteFeatureCallable;
  private final OperationCallable<DeleteFeatureRequest, Empty, OperationMetadata>
      deleteFeatureOperationCallable;
  private final UnaryCallable<UpdateMembershipRequest, Operation> updateMembershipCallable;
  private final OperationCallable<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationCallable;
  private final UnaryCallable<UpdateFeatureRequest, Operation> updateFeatureCallable;
  private final OperationCallable<UpdateFeatureRequest, Feature, OperationMetadata>
      updateFeatureOperationCallable;
  private final UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable;
  private final UnaryCallable<CreateFleetRequest, Operation> createFleetCallable;
  private final OperationCallable<CreateFleetRequest, Fleet, OperationMetadata>
      createFleetOperationCallable;
  private final UnaryCallable<GetFleetRequest, Fleet> getFleetCallable;
  private final UnaryCallable<UpdateFleetRequest, Operation> updateFleetCallable;
  private final OperationCallable<UpdateFleetRequest, Fleet, OperationMetadata>
      updateFleetOperationCallable;
  private final UnaryCallable<DeleteFleetRequest, Operation> deleteFleetCallable;
  private final OperationCallable<DeleteFleetRequest, Empty, OperationMetadata>
      deleteFleetOperationCallable;
  private final UnaryCallable<ListFleetsRequest, ListFleetsResponse> listFleetsCallable;
  private final UnaryCallable<ListFleetsRequest, ListFleetsPagedResponse> listFleetsPagedCallable;
  private final UnaryCallable<GetScopeNamespaceRequest, Namespace> getScopeNamespaceCallable;
  private final UnaryCallable<CreateScopeNamespaceRequest, Operation> createScopeNamespaceCallable;
  private final OperationCallable<CreateScopeNamespaceRequest, Namespace, OperationMetadata>
      createScopeNamespaceOperationCallable;
  private final UnaryCallable<UpdateScopeNamespaceRequest, Operation> updateScopeNamespaceCallable;
  private final OperationCallable<UpdateScopeNamespaceRequest, Namespace, OperationMetadata>
      updateScopeNamespaceOperationCallable;
  private final UnaryCallable<DeleteScopeNamespaceRequest, Operation> deleteScopeNamespaceCallable;
  private final OperationCallable<DeleteScopeNamespaceRequest, Empty, OperationMetadata>
      deleteScopeNamespaceOperationCallable;
  private final UnaryCallable<ListScopeNamespacesRequest, ListScopeNamespacesResponse>
      listScopeNamespacesCallable;
  private final UnaryCallable<ListScopeNamespacesRequest, ListScopeNamespacesPagedResponse>
      listScopeNamespacesPagedCallable;
  private final UnaryCallable<GetScopeRBACRoleBindingRequest, RBACRoleBinding>
      getScopeRBACRoleBindingCallable;
  private final UnaryCallable<CreateScopeRBACRoleBindingRequest, Operation>
      createScopeRBACRoleBindingCallable;
  private final OperationCallable<
          CreateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      createScopeRBACRoleBindingOperationCallable;
  private final UnaryCallable<UpdateScopeRBACRoleBindingRequest, Operation>
      updateScopeRBACRoleBindingCallable;
  private final OperationCallable<
          UpdateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      updateScopeRBACRoleBindingOperationCallable;
  private final UnaryCallable<DeleteScopeRBACRoleBindingRequest, Operation>
      deleteScopeRBACRoleBindingCallable;
  private final OperationCallable<DeleteScopeRBACRoleBindingRequest, Empty, OperationMetadata>
      deleteScopeRBACRoleBindingOperationCallable;
  private final UnaryCallable<ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsResponse>
      listScopeRBACRoleBindingsCallable;
  private final UnaryCallable<
          ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsPagedResponse>
      listScopeRBACRoleBindingsPagedCallable;
  private final UnaryCallable<GetScopeRequest, Scope> getScopeCallable;
  private final UnaryCallable<CreateScopeRequest, Operation> createScopeCallable;
  private final OperationCallable<CreateScopeRequest, Scope, OperationMetadata>
      createScopeOperationCallable;
  private final UnaryCallable<UpdateScopeRequest, Operation> updateScopeCallable;
  private final OperationCallable<UpdateScopeRequest, Scope, OperationMetadata>
      updateScopeOperationCallable;
  private final UnaryCallable<DeleteScopeRequest, Operation> deleteScopeCallable;
  private final OperationCallable<DeleteScopeRequest, Empty, OperationMetadata>
      deleteScopeOperationCallable;
  private final UnaryCallable<ListScopesRequest, ListScopesResponse> listScopesCallable;
  private final UnaryCallable<ListScopesRequest, ListScopesPagedResponse> listScopesPagedCallable;
  private final UnaryCallable<ListPermittedScopesRequest, ListPermittedScopesResponse>
      listPermittedScopesCallable;
  private final UnaryCallable<ListPermittedScopesRequest, ListPermittedScopesPagedResponse>
      listPermittedScopesPagedCallable;
  private final UnaryCallable<GetMembershipBindingRequest, MembershipBinding>
      getMembershipBindingCallable;
  private final UnaryCallable<CreateMembershipBindingRequest, Operation>
      createMembershipBindingCallable;
  private final OperationCallable<
          CreateMembershipBindingRequest, MembershipBinding, OperationMetadata>
      createMembershipBindingOperationCallable;
  private final UnaryCallable<UpdateMembershipBindingRequest, Operation>
      updateMembershipBindingCallable;
  private final OperationCallable<
          UpdateMembershipBindingRequest, MembershipBinding, OperationMetadata>
      updateMembershipBindingOperationCallable;
  private final UnaryCallable<DeleteMembershipBindingRequest, Operation>
      deleteMembershipBindingCallable;
  private final OperationCallable<DeleteMembershipBindingRequest, Empty, OperationMetadata>
      deleteMembershipBindingOperationCallable;
  private final UnaryCallable<ListMembershipBindingsRequest, ListMembershipBindingsResponse>
      listMembershipBindingsCallable;
  private final UnaryCallable<ListMembershipBindingsRequest, ListMembershipBindingsPagedResponse>
      listMembershipBindingsPagedCallable;
  private final UnaryCallable<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>
      getMembershipRBACRoleBindingCallable;
  private final UnaryCallable<CreateMembershipRBACRoleBindingRequest, Operation>
      createMembershipRBACRoleBindingCallable;
  private final OperationCallable<
          CreateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      createMembershipRBACRoleBindingOperationCallable;
  private final UnaryCallable<UpdateMembershipRBACRoleBindingRequest, Operation>
      updateMembershipRBACRoleBindingCallable;
  private final OperationCallable<
          UpdateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      updateMembershipRBACRoleBindingOperationCallable;
  private final UnaryCallable<DeleteMembershipRBACRoleBindingRequest, Operation>
      deleteMembershipRBACRoleBindingCallable;
  private final OperationCallable<DeleteMembershipRBACRoleBindingRequest, Empty, OperationMetadata>
      deleteMembershipRBACRoleBindingOperationCallable;
  private final UnaryCallable<
          ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsResponse>
      listMembershipRBACRoleBindingsCallable;
  private final UnaryCallable<
          ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsPagedResponse>
      listMembershipRBACRoleBindingsPagedCallable;
  private final UnaryCallable<
          GenerateMembershipRBACRoleBindingYAMLRequest,
          GenerateMembershipRBACRoleBindingYAMLResponse>
      generateMembershipRBACRoleBindingYAMLCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGkeHubStub create(GkeHubStubSettings settings) throws IOException {
    return new GrpcGkeHubStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGkeHubStub create(ClientContext clientContext) throws IOException {
    return new GrpcGkeHubStub(GkeHubStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGkeHubStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGkeHubStub(
        GkeHubStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGkeHubStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcGkeHubStub(GkeHubStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcGkeHubCallableFactory());
  }

  /**
   * Constructs an instance of GrpcGkeHubStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcGkeHubStub(
      GkeHubStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListMembershipsRequest, ListMembershipsResponse>
        listMembershipsTransportSettings =
            GrpcCallSettings.<ListMembershipsRequest, ListMembershipsResponse>newBuilder()
                .setMethodDescriptor(listMembershipsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListBoundMembershipsRequest, ListBoundMembershipsResponse>
        listBoundMembershipsTransportSettings =
            GrpcCallSettings.<ListBoundMembershipsRequest, ListBoundMembershipsResponse>newBuilder()
                .setMethodDescriptor(listBoundMembershipsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("scope_name", String.valueOf(request.getScopeName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListFeaturesRequest, ListFeaturesResponse> listFeaturesTransportSettings =
        GrpcCallSettings.<ListFeaturesRequest, ListFeaturesResponse>newBuilder()
            .setMethodDescriptor(listFeaturesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetMembershipRequest, Membership> getMembershipTransportSettings =
        GrpcCallSettings.<GetMembershipRequest, Membership>newBuilder()
            .setMethodDescriptor(getMembershipMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetFeatureRequest, Feature> getFeatureTransportSettings =
        GrpcCallSettings.<GetFeatureRequest, Feature>newBuilder()
            .setMethodDescriptor(getFeatureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateMembershipRequest, Operation> createMembershipTransportSettings =
        GrpcCallSettings.<CreateMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(createMembershipMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateFeatureRequest, Operation> createFeatureTransportSettings =
        GrpcCallSettings.<CreateFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(createFeatureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteMembershipRequest, Operation> deleteMembershipTransportSettings =
        GrpcCallSettings.<DeleteMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMembershipMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteFeatureRequest, Operation> deleteFeatureTransportSettings =
        GrpcCallSettings.<DeleteFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFeatureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateMembershipRequest, Operation> updateMembershipTransportSettings =
        GrpcCallSettings.<UpdateMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMembershipMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateFeatureRequest, Operation> updateFeatureTransportSettings =
        GrpcCallSettings.<UpdateFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFeatureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
        generateConnectManifestTransportSettings =
            GrpcCallSettings
                .<GenerateConnectManifestRequest, GenerateConnectManifestResponse>newBuilder()
                .setMethodDescriptor(generateConnectManifestMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateFleetRequest, Operation> createFleetTransportSettings =
        GrpcCallSettings.<CreateFleetRequest, Operation>newBuilder()
            .setMethodDescriptor(createFleetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetFleetRequest, Fleet> getFleetTransportSettings =
        GrpcCallSettings.<GetFleetRequest, Fleet>newBuilder()
            .setMethodDescriptor(getFleetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateFleetRequest, Operation> updateFleetTransportSettings =
        GrpcCallSettings.<UpdateFleetRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFleetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("fleet.name", String.valueOf(request.getFleet().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteFleetRequest, Operation> deleteFleetTransportSettings =
        GrpcCallSettings.<DeleteFleetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFleetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListFleetsRequest, ListFleetsResponse> listFleetsTransportSettings =
        GrpcCallSettings.<ListFleetsRequest, ListFleetsResponse>newBuilder()
            .setMethodDescriptor(listFleetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetScopeNamespaceRequest, Namespace> getScopeNamespaceTransportSettings =
        GrpcCallSettings.<GetScopeNamespaceRequest, Namespace>newBuilder()
            .setMethodDescriptor(getScopeNamespaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateScopeNamespaceRequest, Operation> createScopeNamespaceTransportSettings =
        GrpcCallSettings.<CreateScopeNamespaceRequest, Operation>newBuilder()
            .setMethodDescriptor(createScopeNamespaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateScopeNamespaceRequest, Operation> updateScopeNamespaceTransportSettings =
        GrpcCallSettings.<UpdateScopeNamespaceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateScopeNamespaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "scope_namespace.name",
                      String.valueOf(request.getScopeNamespace().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteScopeNamespaceRequest, Operation> deleteScopeNamespaceTransportSettings =
        GrpcCallSettings.<DeleteScopeNamespaceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteScopeNamespaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListScopeNamespacesRequest, ListScopeNamespacesResponse>
        listScopeNamespacesTransportSettings =
            GrpcCallSettings.<ListScopeNamespacesRequest, ListScopeNamespacesResponse>newBuilder()
                .setMethodDescriptor(listScopeNamespacesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetScopeRBACRoleBindingRequest, RBACRoleBinding>
        getScopeRBACRoleBindingTransportSettings =
            GrpcCallSettings.<GetScopeRBACRoleBindingRequest, RBACRoleBinding>newBuilder()
                .setMethodDescriptor(getScopeRBACRoleBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateScopeRBACRoleBindingRequest, Operation>
        createScopeRBACRoleBindingTransportSettings =
            GrpcCallSettings.<CreateScopeRBACRoleBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(createScopeRBACRoleBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateScopeRBACRoleBindingRequest, Operation>
        updateScopeRBACRoleBindingTransportSettings =
            GrpcCallSettings.<UpdateScopeRBACRoleBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(updateScopeRBACRoleBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "rbacrolebinding.name",
                          String.valueOf(request.getRbacrolebinding().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteScopeRBACRoleBindingRequest, Operation>
        deleteScopeRBACRoleBindingTransportSettings =
            GrpcCallSettings.<DeleteScopeRBACRoleBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteScopeRBACRoleBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsResponse>
        listScopeRBACRoleBindingsTransportSettings =
            GrpcCallSettings
                .<ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsResponse>newBuilder()
                .setMethodDescriptor(listScopeRBACRoleBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetScopeRequest, Scope> getScopeTransportSettings =
        GrpcCallSettings.<GetScopeRequest, Scope>newBuilder()
            .setMethodDescriptor(getScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateScopeRequest, Operation> createScopeTransportSettings =
        GrpcCallSettings.<CreateScopeRequest, Operation>newBuilder()
            .setMethodDescriptor(createScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateScopeRequest, Operation> updateScopeTransportSettings =
        GrpcCallSettings.<UpdateScopeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("scope.name", String.valueOf(request.getScope().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteScopeRequest, Operation> deleteScopeTransportSettings =
        GrpcCallSettings.<DeleteScopeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListScopesRequest, ListScopesResponse> listScopesTransportSettings =
        GrpcCallSettings.<ListScopesRequest, ListScopesResponse>newBuilder()
            .setMethodDescriptor(listScopesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPermittedScopesRequest, ListPermittedScopesResponse>
        listPermittedScopesTransportSettings =
            GrpcCallSettings.<ListPermittedScopesRequest, ListPermittedScopesResponse>newBuilder()
                .setMethodDescriptor(listPermittedScopesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetMembershipBindingRequest, MembershipBinding>
        getMembershipBindingTransportSettings =
            GrpcCallSettings.<GetMembershipBindingRequest, MembershipBinding>newBuilder()
                .setMethodDescriptor(getMembershipBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateMembershipBindingRequest, Operation>
        createMembershipBindingTransportSettings =
            GrpcCallSettings.<CreateMembershipBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(createMembershipBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateMembershipBindingRequest, Operation>
        updateMembershipBindingTransportSettings =
            GrpcCallSettings.<UpdateMembershipBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(updateMembershipBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "membership_binding.name",
                          String.valueOf(request.getMembershipBinding().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteMembershipBindingRequest, Operation>
        deleteMembershipBindingTransportSettings =
            GrpcCallSettings.<DeleteMembershipBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMembershipBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListMembershipBindingsRequest, ListMembershipBindingsResponse>
        listMembershipBindingsTransportSettings =
            GrpcCallSettings
                .<ListMembershipBindingsRequest, ListMembershipBindingsResponse>newBuilder()
                .setMethodDescriptor(listMembershipBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>
        getMembershipRBACRoleBindingTransportSettings =
            GrpcCallSettings.<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>newBuilder()
                .setMethodDescriptor(getMembershipRBACRoleBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateMembershipRBACRoleBindingRequest, Operation>
        createMembershipRBACRoleBindingTransportSettings =
            GrpcCallSettings.<CreateMembershipRBACRoleBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(createMembershipRBACRoleBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateMembershipRBACRoleBindingRequest, Operation>
        updateMembershipRBACRoleBindingTransportSettings =
            GrpcCallSettings.<UpdateMembershipRBACRoleBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(updateMembershipRBACRoleBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "rbacrolebinding.name",
                          String.valueOf(request.getRbacrolebinding().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteMembershipRBACRoleBindingRequest, Operation>
        deleteMembershipRBACRoleBindingTransportSettings =
            GrpcCallSettings.<DeleteMembershipRBACRoleBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMembershipRBACRoleBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsResponse>
        listMembershipRBACRoleBindingsTransportSettings =
            GrpcCallSettings
                .<ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsResponse>
                    newBuilder()
                .setMethodDescriptor(listMembershipRBACRoleBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            GenerateMembershipRBACRoleBindingYAMLRequest,
            GenerateMembershipRBACRoleBindingYAMLResponse>
        generateMembershipRBACRoleBindingYAMLTransportSettings =
            GrpcCallSettings
                .<GenerateMembershipRBACRoleBindingYAMLRequest,
                    GenerateMembershipRBACRoleBindingYAMLResponse>
                    newBuilder()
                .setMethodDescriptor(generateMembershipRBACRoleBindingYAMLMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.listMembershipsCallable =
        callableFactory.createUnaryCallable(
            listMembershipsTransportSettings, settings.listMembershipsSettings(), clientContext);
    this.listMembershipsPagedCallable =
        callableFactory.createPagedCallable(
            listMembershipsTransportSettings, settings.listMembershipsSettings(), clientContext);
    this.listBoundMembershipsCallable =
        callableFactory.createUnaryCallable(
            listBoundMembershipsTransportSettings,
            settings.listBoundMembershipsSettings(),
            clientContext);
    this.listBoundMembershipsPagedCallable =
        callableFactory.createPagedCallable(
            listBoundMembershipsTransportSettings,
            settings.listBoundMembershipsSettings(),
            clientContext);
    this.listFeaturesCallable =
        callableFactory.createUnaryCallable(
            listFeaturesTransportSettings, settings.listFeaturesSettings(), clientContext);
    this.listFeaturesPagedCallable =
        callableFactory.createPagedCallable(
            listFeaturesTransportSettings, settings.listFeaturesSettings(), clientContext);
    this.getMembershipCallable =
        callableFactory.createUnaryCallable(
            getMembershipTransportSettings, settings.getMembershipSettings(), clientContext);
    this.getFeatureCallable =
        callableFactory.createUnaryCallable(
            getFeatureTransportSettings, settings.getFeatureSettings(), clientContext);
    this.createMembershipCallable =
        callableFactory.createUnaryCallable(
            createMembershipTransportSettings, settings.createMembershipSettings(), clientContext);
    this.createMembershipOperationCallable =
        callableFactory.createOperationCallable(
            createMembershipTransportSettings,
            settings.createMembershipOperationSettings(),
            clientContext,
            operationsStub);
    this.createFeatureCallable =
        callableFactory.createUnaryCallable(
            createFeatureTransportSettings, settings.createFeatureSettings(), clientContext);
    this.createFeatureOperationCallable =
        callableFactory.createOperationCallable(
            createFeatureTransportSettings,
            settings.createFeatureOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMembershipCallable =
        callableFactory.createUnaryCallable(
            deleteMembershipTransportSettings, settings.deleteMembershipSettings(), clientContext);
    this.deleteMembershipOperationCallable =
        callableFactory.createOperationCallable(
            deleteMembershipTransportSettings,
            settings.deleteMembershipOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteFeatureCallable =
        callableFactory.createUnaryCallable(
            deleteFeatureTransportSettings, settings.deleteFeatureSettings(), clientContext);
    this.deleteFeatureOperationCallable =
        callableFactory.createOperationCallable(
            deleteFeatureTransportSettings,
            settings.deleteFeatureOperationSettings(),
            clientContext,
            operationsStub);
    this.updateMembershipCallable =
        callableFactory.createUnaryCallable(
            updateMembershipTransportSettings, settings.updateMembershipSettings(), clientContext);
    this.updateMembershipOperationCallable =
        callableFactory.createOperationCallable(
            updateMembershipTransportSettings,
            settings.updateMembershipOperationSettings(),
            clientContext,
            operationsStub);
    this.updateFeatureCallable =
        callableFactory.createUnaryCallable(
            updateFeatureTransportSettings, settings.updateFeatureSettings(), clientContext);
    this.updateFeatureOperationCallable =
        callableFactory.createOperationCallable(
            updateFeatureTransportSettings,
            settings.updateFeatureOperationSettings(),
            clientContext,
            operationsStub);
    this.generateConnectManifestCallable =
        callableFactory.createUnaryCallable(
            generateConnectManifestTransportSettings,
            settings.generateConnectManifestSettings(),
            clientContext);
    this.createFleetCallable =
        callableFactory.createUnaryCallable(
            createFleetTransportSettings, settings.createFleetSettings(), clientContext);
    this.createFleetOperationCallable =
        callableFactory.createOperationCallable(
            createFleetTransportSettings,
            settings.createFleetOperationSettings(),
            clientContext,
            operationsStub);
    this.getFleetCallable =
        callableFactory.createUnaryCallable(
            getFleetTransportSettings, settings.getFleetSettings(), clientContext);
    this.updateFleetCallable =
        callableFactory.createUnaryCallable(
            updateFleetTransportSettings, settings.updateFleetSettings(), clientContext);
    this.updateFleetOperationCallable =
        callableFactory.createOperationCallable(
            updateFleetTransportSettings,
            settings.updateFleetOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteFleetCallable =
        callableFactory.createUnaryCallable(
            deleteFleetTransportSettings, settings.deleteFleetSettings(), clientContext);
    this.deleteFleetOperationCallable =
        callableFactory.createOperationCallable(
            deleteFleetTransportSettings,
            settings.deleteFleetOperationSettings(),
            clientContext,
            operationsStub);
    this.listFleetsCallable =
        callableFactory.createUnaryCallable(
            listFleetsTransportSettings, settings.listFleetsSettings(), clientContext);
    this.listFleetsPagedCallable =
        callableFactory.createPagedCallable(
            listFleetsTransportSettings, settings.listFleetsSettings(), clientContext);
    this.getScopeNamespaceCallable =
        callableFactory.createUnaryCallable(
            getScopeNamespaceTransportSettings,
            settings.getScopeNamespaceSettings(),
            clientContext);
    this.createScopeNamespaceCallable =
        callableFactory.createUnaryCallable(
            createScopeNamespaceTransportSettings,
            settings.createScopeNamespaceSettings(),
            clientContext);
    this.createScopeNamespaceOperationCallable =
        callableFactory.createOperationCallable(
            createScopeNamespaceTransportSettings,
            settings.createScopeNamespaceOperationSettings(),
            clientContext,
            operationsStub);
    this.updateScopeNamespaceCallable =
        callableFactory.createUnaryCallable(
            updateScopeNamespaceTransportSettings,
            settings.updateScopeNamespaceSettings(),
            clientContext);
    this.updateScopeNamespaceOperationCallable =
        callableFactory.createOperationCallable(
            updateScopeNamespaceTransportSettings,
            settings.updateScopeNamespaceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteScopeNamespaceCallable =
        callableFactory.createUnaryCallable(
            deleteScopeNamespaceTransportSettings,
            settings.deleteScopeNamespaceSettings(),
            clientContext);
    this.deleteScopeNamespaceOperationCallable =
        callableFactory.createOperationCallable(
            deleteScopeNamespaceTransportSettings,
            settings.deleteScopeNamespaceOperationSettings(),
            clientContext,
            operationsStub);
    this.listScopeNamespacesCallable =
        callableFactory.createUnaryCallable(
            listScopeNamespacesTransportSettings,
            settings.listScopeNamespacesSettings(),
            clientContext);
    this.listScopeNamespacesPagedCallable =
        callableFactory.createPagedCallable(
            listScopeNamespacesTransportSettings,
            settings.listScopeNamespacesSettings(),
            clientContext);
    this.getScopeRBACRoleBindingCallable =
        callableFactory.createUnaryCallable(
            getScopeRBACRoleBindingTransportSettings,
            settings.getScopeRBACRoleBindingSettings(),
            clientContext);
    this.createScopeRBACRoleBindingCallable =
        callableFactory.createUnaryCallable(
            createScopeRBACRoleBindingTransportSettings,
            settings.createScopeRBACRoleBindingSettings(),
            clientContext);
    this.createScopeRBACRoleBindingOperationCallable =
        callableFactory.createOperationCallable(
            createScopeRBACRoleBindingTransportSettings,
            settings.createScopeRBACRoleBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.updateScopeRBACRoleBindingCallable =
        callableFactory.createUnaryCallable(
            updateScopeRBACRoleBindingTransportSettings,
            settings.updateScopeRBACRoleBindingSettings(),
            clientContext);
    this.updateScopeRBACRoleBindingOperationCallable =
        callableFactory.createOperationCallable(
            updateScopeRBACRoleBindingTransportSettings,
            settings.updateScopeRBACRoleBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteScopeRBACRoleBindingCallable =
        callableFactory.createUnaryCallable(
            deleteScopeRBACRoleBindingTransportSettings,
            settings.deleteScopeRBACRoleBindingSettings(),
            clientContext);
    this.deleteScopeRBACRoleBindingOperationCallable =
        callableFactory.createOperationCallable(
            deleteScopeRBACRoleBindingTransportSettings,
            settings.deleteScopeRBACRoleBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.listScopeRBACRoleBindingsCallable =
        callableFactory.createUnaryCallable(
            listScopeRBACRoleBindingsTransportSettings,
            settings.listScopeRBACRoleBindingsSettings(),
            clientContext);
    this.listScopeRBACRoleBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listScopeRBACRoleBindingsTransportSettings,
            settings.listScopeRBACRoleBindingsSettings(),
            clientContext);
    this.getScopeCallable =
        callableFactory.createUnaryCallable(
            getScopeTransportSettings, settings.getScopeSettings(), clientContext);
    this.createScopeCallable =
        callableFactory.createUnaryCallable(
            createScopeTransportSettings, settings.createScopeSettings(), clientContext);
    this.createScopeOperationCallable =
        callableFactory.createOperationCallable(
            createScopeTransportSettings,
            settings.createScopeOperationSettings(),
            clientContext,
            operationsStub);
    this.updateScopeCallable =
        callableFactory.createUnaryCallable(
            updateScopeTransportSettings, settings.updateScopeSettings(), clientContext);
    this.updateScopeOperationCallable =
        callableFactory.createOperationCallable(
            updateScopeTransportSettings,
            settings.updateScopeOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteScopeCallable =
        callableFactory.createUnaryCallable(
            deleteScopeTransportSettings, settings.deleteScopeSettings(), clientContext);
    this.deleteScopeOperationCallable =
        callableFactory.createOperationCallable(
            deleteScopeTransportSettings,
            settings.deleteScopeOperationSettings(),
            clientContext,
            operationsStub);
    this.listScopesCallable =
        callableFactory.createUnaryCallable(
            listScopesTransportSettings, settings.listScopesSettings(), clientContext);
    this.listScopesPagedCallable =
        callableFactory.createPagedCallable(
            listScopesTransportSettings, settings.listScopesSettings(), clientContext);
    this.listPermittedScopesCallable =
        callableFactory.createUnaryCallable(
            listPermittedScopesTransportSettings,
            settings.listPermittedScopesSettings(),
            clientContext);
    this.listPermittedScopesPagedCallable =
        callableFactory.createPagedCallable(
            listPermittedScopesTransportSettings,
            settings.listPermittedScopesSettings(),
            clientContext);
    this.getMembershipBindingCallable =
        callableFactory.createUnaryCallable(
            getMembershipBindingTransportSettings,
            settings.getMembershipBindingSettings(),
            clientContext);
    this.createMembershipBindingCallable =
        callableFactory.createUnaryCallable(
            createMembershipBindingTransportSettings,
            settings.createMembershipBindingSettings(),
            clientContext);
    this.createMembershipBindingOperationCallable =
        callableFactory.createOperationCallable(
            createMembershipBindingTransportSettings,
            settings.createMembershipBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.updateMembershipBindingCallable =
        callableFactory.createUnaryCallable(
            updateMembershipBindingTransportSettings,
            settings.updateMembershipBindingSettings(),
            clientContext);
    this.updateMembershipBindingOperationCallable =
        callableFactory.createOperationCallable(
            updateMembershipBindingTransportSettings,
            settings.updateMembershipBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMembershipBindingCallable =
        callableFactory.createUnaryCallable(
            deleteMembershipBindingTransportSettings,
            settings.deleteMembershipBindingSettings(),
            clientContext);
    this.deleteMembershipBindingOperationCallable =
        callableFactory.createOperationCallable(
            deleteMembershipBindingTransportSettings,
            settings.deleteMembershipBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.listMembershipBindingsCallable =
        callableFactory.createUnaryCallable(
            listMembershipBindingsTransportSettings,
            settings.listMembershipBindingsSettings(),
            clientContext);
    this.listMembershipBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listMembershipBindingsTransportSettings,
            settings.listMembershipBindingsSettings(),
            clientContext);
    this.getMembershipRBACRoleBindingCallable =
        callableFactory.createUnaryCallable(
            getMembershipRBACRoleBindingTransportSettings,
            settings.getMembershipRBACRoleBindingSettings(),
            clientContext);
    this.createMembershipRBACRoleBindingCallable =
        callableFactory.createUnaryCallable(
            createMembershipRBACRoleBindingTransportSettings,
            settings.createMembershipRBACRoleBindingSettings(),
            clientContext);
    this.createMembershipRBACRoleBindingOperationCallable =
        callableFactory.createOperationCallable(
            createMembershipRBACRoleBindingTransportSettings,
            settings.createMembershipRBACRoleBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.updateMembershipRBACRoleBindingCallable =
        callableFactory.createUnaryCallable(
            updateMembershipRBACRoleBindingTransportSettings,
            settings.updateMembershipRBACRoleBindingSettings(),
            clientContext);
    this.updateMembershipRBACRoleBindingOperationCallable =
        callableFactory.createOperationCallable(
            updateMembershipRBACRoleBindingTransportSettings,
            settings.updateMembershipRBACRoleBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMembershipRBACRoleBindingCallable =
        callableFactory.createUnaryCallable(
            deleteMembershipRBACRoleBindingTransportSettings,
            settings.deleteMembershipRBACRoleBindingSettings(),
            clientContext);
    this.deleteMembershipRBACRoleBindingOperationCallable =
        callableFactory.createOperationCallable(
            deleteMembershipRBACRoleBindingTransportSettings,
            settings.deleteMembershipRBACRoleBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.listMembershipRBACRoleBindingsCallable =
        callableFactory.createUnaryCallable(
            listMembershipRBACRoleBindingsTransportSettings,
            settings.listMembershipRBACRoleBindingsSettings(),
            clientContext);
    this.listMembershipRBACRoleBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listMembershipRBACRoleBindingsTransportSettings,
            settings.listMembershipRBACRoleBindingsSettings(),
            clientContext);
    this.generateMembershipRBACRoleBindingYAMLCallable =
        callableFactory.createUnaryCallable(
            generateMembershipRBACRoleBindingYAMLTransportSettings,
            settings.generateMembershipRBACRoleBindingYAMLSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListMembershipsRequest, ListMembershipsResponse> listMembershipsCallable() {
    return listMembershipsCallable;
  }

  @Override
  public UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable() {
    return listMembershipsPagedCallable;
  }

  @Override
  public UnaryCallable<ListBoundMembershipsRequest, ListBoundMembershipsResponse>
      listBoundMembershipsCallable() {
    return listBoundMembershipsCallable;
  }

  @Override
  public UnaryCallable<ListBoundMembershipsRequest, ListBoundMembershipsPagedResponse>
      listBoundMembershipsPagedCallable() {
    return listBoundMembershipsPagedCallable;
  }

  @Override
  public UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> listFeaturesCallable() {
    return listFeaturesCallable;
  }

  @Override
  public UnaryCallable<ListFeaturesRequest, ListFeaturesPagedResponse> listFeaturesPagedCallable() {
    return listFeaturesPagedCallable;
  }

  @Override
  public UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable() {
    return getMembershipCallable;
  }

  @Override
  public UnaryCallable<GetFeatureRequest, Feature> getFeatureCallable() {
    return getFeatureCallable;
  }

  @Override
  public UnaryCallable<CreateMembershipRequest, Operation> createMembershipCallable() {
    return createMembershipCallable;
  }

  @Override
  public OperationCallable<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationCallable() {
    return createMembershipOperationCallable;
  }

  @Override
  public UnaryCallable<CreateFeatureRequest, Operation> createFeatureCallable() {
    return createFeatureCallable;
  }

  @Override
  public OperationCallable<CreateFeatureRequest, Feature, OperationMetadata>
      createFeatureOperationCallable() {
    return createFeatureOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMembershipRequest, Operation> deleteMembershipCallable() {
    return deleteMembershipCallable;
  }

  @Override
  public OperationCallable<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationCallable() {
    return deleteMembershipOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFeatureRequest, Operation> deleteFeatureCallable() {
    return deleteFeatureCallable;
  }

  @Override
  public OperationCallable<DeleteFeatureRequest, Empty, OperationMetadata>
      deleteFeatureOperationCallable() {
    return deleteFeatureOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMembershipRequest, Operation> updateMembershipCallable() {
    return updateMembershipCallable;
  }

  @Override
  public OperationCallable<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationCallable() {
    return updateMembershipOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFeatureRequest, Operation> updateFeatureCallable() {
    return updateFeatureCallable;
  }

  @Override
  public OperationCallable<UpdateFeatureRequest, Feature, OperationMetadata>
      updateFeatureOperationCallable() {
    return updateFeatureOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable() {
    return generateConnectManifestCallable;
  }

  @Override
  public UnaryCallable<CreateFleetRequest, Operation> createFleetCallable() {
    return createFleetCallable;
  }

  @Override
  public OperationCallable<CreateFleetRequest, Fleet, OperationMetadata>
      createFleetOperationCallable() {
    return createFleetOperationCallable;
  }

  @Override
  public UnaryCallable<GetFleetRequest, Fleet> getFleetCallable() {
    return getFleetCallable;
  }

  @Override
  public UnaryCallable<UpdateFleetRequest, Operation> updateFleetCallable() {
    return updateFleetCallable;
  }

  @Override
  public OperationCallable<UpdateFleetRequest, Fleet, OperationMetadata>
      updateFleetOperationCallable() {
    return updateFleetOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFleetRequest, Operation> deleteFleetCallable() {
    return deleteFleetCallable;
  }

  @Override
  public OperationCallable<DeleteFleetRequest, Empty, OperationMetadata>
      deleteFleetOperationCallable() {
    return deleteFleetOperationCallable;
  }

  @Override
  public UnaryCallable<ListFleetsRequest, ListFleetsResponse> listFleetsCallable() {
    return listFleetsCallable;
  }

  @Override
  public UnaryCallable<ListFleetsRequest, ListFleetsPagedResponse> listFleetsPagedCallable() {
    return listFleetsPagedCallable;
  }

  @Override
  public UnaryCallable<GetScopeNamespaceRequest, Namespace> getScopeNamespaceCallable() {
    return getScopeNamespaceCallable;
  }

  @Override
  public UnaryCallable<CreateScopeNamespaceRequest, Operation> createScopeNamespaceCallable() {
    return createScopeNamespaceCallable;
  }

  @Override
  public OperationCallable<CreateScopeNamespaceRequest, Namespace, OperationMetadata>
      createScopeNamespaceOperationCallable() {
    return createScopeNamespaceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateScopeNamespaceRequest, Operation> updateScopeNamespaceCallable() {
    return updateScopeNamespaceCallable;
  }

  @Override
  public OperationCallable<UpdateScopeNamespaceRequest, Namespace, OperationMetadata>
      updateScopeNamespaceOperationCallable() {
    return updateScopeNamespaceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteScopeNamespaceRequest, Operation> deleteScopeNamespaceCallable() {
    return deleteScopeNamespaceCallable;
  }

  @Override
  public OperationCallable<DeleteScopeNamespaceRequest, Empty, OperationMetadata>
      deleteScopeNamespaceOperationCallable() {
    return deleteScopeNamespaceOperationCallable;
  }

  @Override
  public UnaryCallable<ListScopeNamespacesRequest, ListScopeNamespacesResponse>
      listScopeNamespacesCallable() {
    return listScopeNamespacesCallable;
  }

  @Override
  public UnaryCallable<ListScopeNamespacesRequest, ListScopeNamespacesPagedResponse>
      listScopeNamespacesPagedCallable() {
    return listScopeNamespacesPagedCallable;
  }

  @Override
  public UnaryCallable<GetScopeRBACRoleBindingRequest, RBACRoleBinding>
      getScopeRBACRoleBindingCallable() {
    return getScopeRBACRoleBindingCallable;
  }

  @Override
  public UnaryCallable<CreateScopeRBACRoleBindingRequest, Operation>
      createScopeRBACRoleBindingCallable() {
    return createScopeRBACRoleBindingCallable;
  }

  @Override
  public OperationCallable<CreateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      createScopeRBACRoleBindingOperationCallable() {
    return createScopeRBACRoleBindingOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateScopeRBACRoleBindingRequest, Operation>
      updateScopeRBACRoleBindingCallable() {
    return updateScopeRBACRoleBindingCallable;
  }

  @Override
  public OperationCallable<UpdateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      updateScopeRBACRoleBindingOperationCallable() {
    return updateScopeRBACRoleBindingOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteScopeRBACRoleBindingRequest, Operation>
      deleteScopeRBACRoleBindingCallable() {
    return deleteScopeRBACRoleBindingCallable;
  }

  @Override
  public OperationCallable<DeleteScopeRBACRoleBindingRequest, Empty, OperationMetadata>
      deleteScopeRBACRoleBindingOperationCallable() {
    return deleteScopeRBACRoleBindingOperationCallable;
  }

  @Override
  public UnaryCallable<ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsResponse>
      listScopeRBACRoleBindingsCallable() {
    return listScopeRBACRoleBindingsCallable;
  }

  @Override
  public UnaryCallable<ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsPagedResponse>
      listScopeRBACRoleBindingsPagedCallable() {
    return listScopeRBACRoleBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetScopeRequest, Scope> getScopeCallable() {
    return getScopeCallable;
  }

  @Override
  public UnaryCallable<CreateScopeRequest, Operation> createScopeCallable() {
    return createScopeCallable;
  }

  @Override
  public OperationCallable<CreateScopeRequest, Scope, OperationMetadata>
      createScopeOperationCallable() {
    return createScopeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateScopeRequest, Operation> updateScopeCallable() {
    return updateScopeCallable;
  }

  @Override
  public OperationCallable<UpdateScopeRequest, Scope, OperationMetadata>
      updateScopeOperationCallable() {
    return updateScopeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteScopeRequest, Operation> deleteScopeCallable() {
    return deleteScopeCallable;
  }

  @Override
  public OperationCallable<DeleteScopeRequest, Empty, OperationMetadata>
      deleteScopeOperationCallable() {
    return deleteScopeOperationCallable;
  }

  @Override
  public UnaryCallable<ListScopesRequest, ListScopesResponse> listScopesCallable() {
    return listScopesCallable;
  }

  @Override
  public UnaryCallable<ListScopesRequest, ListScopesPagedResponse> listScopesPagedCallable() {
    return listScopesPagedCallable;
  }

  @Override
  public UnaryCallable<ListPermittedScopesRequest, ListPermittedScopesResponse>
      listPermittedScopesCallable() {
    return listPermittedScopesCallable;
  }

  @Override
  public UnaryCallable<ListPermittedScopesRequest, ListPermittedScopesPagedResponse>
      listPermittedScopesPagedCallable() {
    return listPermittedScopesPagedCallable;
  }

  @Override
  public UnaryCallable<GetMembershipBindingRequest, MembershipBinding>
      getMembershipBindingCallable() {
    return getMembershipBindingCallable;
  }

  @Override
  public UnaryCallable<CreateMembershipBindingRequest, Operation>
      createMembershipBindingCallable() {
    return createMembershipBindingCallable;
  }

  @Override
  public OperationCallable<CreateMembershipBindingRequest, MembershipBinding, OperationMetadata>
      createMembershipBindingOperationCallable() {
    return createMembershipBindingOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMembershipBindingRequest, Operation>
      updateMembershipBindingCallable() {
    return updateMembershipBindingCallable;
  }

  @Override
  public OperationCallable<UpdateMembershipBindingRequest, MembershipBinding, OperationMetadata>
      updateMembershipBindingOperationCallable() {
    return updateMembershipBindingOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMembershipBindingRequest, Operation>
      deleteMembershipBindingCallable() {
    return deleteMembershipBindingCallable;
  }

  @Override
  public OperationCallable<DeleteMembershipBindingRequest, Empty, OperationMetadata>
      deleteMembershipBindingOperationCallable() {
    return deleteMembershipBindingOperationCallable;
  }

  @Override
  public UnaryCallable<ListMembershipBindingsRequest, ListMembershipBindingsResponse>
      listMembershipBindingsCallable() {
    return listMembershipBindingsCallable;
  }

  @Override
  public UnaryCallable<ListMembershipBindingsRequest, ListMembershipBindingsPagedResponse>
      listMembershipBindingsPagedCallable() {
    return listMembershipBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>
      getMembershipRBACRoleBindingCallable() {
    return getMembershipRBACRoleBindingCallable;
  }

  @Override
  public UnaryCallable<CreateMembershipRBACRoleBindingRequest, Operation>
      createMembershipRBACRoleBindingCallable() {
    return createMembershipRBACRoleBindingCallable;
  }

  @Override
  public OperationCallable<
          CreateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      createMembershipRBACRoleBindingOperationCallable() {
    return createMembershipRBACRoleBindingOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMembershipRBACRoleBindingRequest, Operation>
      updateMembershipRBACRoleBindingCallable() {
    return updateMembershipRBACRoleBindingCallable;
  }

  @Override
  public OperationCallable<
          UpdateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      updateMembershipRBACRoleBindingOperationCallable() {
    return updateMembershipRBACRoleBindingOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMembershipRBACRoleBindingRequest, Operation>
      deleteMembershipRBACRoleBindingCallable() {
    return deleteMembershipRBACRoleBindingCallable;
  }

  @Override
  public OperationCallable<DeleteMembershipRBACRoleBindingRequest, Empty, OperationMetadata>
      deleteMembershipRBACRoleBindingOperationCallable() {
    return deleteMembershipRBACRoleBindingOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsResponse>
      listMembershipRBACRoleBindingsCallable() {
    return listMembershipRBACRoleBindingsCallable;
  }

  @Override
  public UnaryCallable<
          ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsPagedResponse>
      listMembershipRBACRoleBindingsPagedCallable() {
    return listMembershipRBACRoleBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<
          GenerateMembershipRBACRoleBindingYAMLRequest,
          GenerateMembershipRBACRoleBindingYAMLResponse>
      generateMembershipRBACRoleBindingYAMLCallable() {
    return generateMembershipRBACRoleBindingYAMLCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
