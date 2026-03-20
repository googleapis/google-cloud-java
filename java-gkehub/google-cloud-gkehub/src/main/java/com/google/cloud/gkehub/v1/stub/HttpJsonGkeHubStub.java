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

import com.google.api.HttpRule;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
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
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the GkeHub service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonGkeHubStub extends GkeHubStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Scope.getDescriptor())
          .add(Fleet.getDescriptor())
          .add(Feature.getDescriptor())
          .add(MembershipBinding.getDescriptor())
          .add(Namespace.getDescriptor())
          .add(Membership.getDescriptor())
          .add(RBACRoleBinding.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsMethodDescriptor =
          ApiMethodDescriptor.<ListMembershipsRequest, ListMembershipsResponse>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListMemberships")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMembershipsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/memberships",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMembershipsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMembershipsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMembershipsResponse>newBuilder()
                      .setDefaultInstance(ListMembershipsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListBoundMembershipsRequest, ListBoundMembershipsResponse>
      listBoundMembershipsMethodDescriptor =
          ApiMethodDescriptor
              .<ListBoundMembershipsRequest, ListBoundMembershipsResponse>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListBoundMemberships")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBoundMembershipsRequest>newBuilder()
                      .setPath(
                          "/v1/{scopeName=projects/*/locations/*/scopes/*}:listMemberships",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBoundMembershipsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "scopeName", request.getScopeName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBoundMembershipsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBoundMembershipsResponse>newBuilder()
                      .setDefaultInstance(ListBoundMembershipsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListFeaturesRequest, ListFeaturesResponse>
      listFeaturesMethodDescriptor =
          ApiMethodDescriptor.<ListFeaturesRequest, ListFeaturesResponse>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListFeatures")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFeaturesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/features",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeaturesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeaturesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "returnPartialSuccess", request.getReturnPartialSuccess());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFeaturesResponse>newBuilder()
                      .setDefaultInstance(ListFeaturesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMembershipRequest, Membership>
      getMembershipMethodDescriptor =
          ApiMethodDescriptor.<GetMembershipRequest, Membership>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetMembership")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMembershipRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/memberships/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Membership>newBuilder()
                      .setDefaultInstance(Membership.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFeatureRequest, Feature> getFeatureMethodDescriptor =
      ApiMethodDescriptor.<GetFeatureRequest, Feature>newBuilder()
          .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetFeature")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetFeatureRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/features/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetFeatureRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetFeatureRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(
                            fields, "returnPartialSuccess", request.getReturnPartialSuccess());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Feature>newBuilder()
                  .setDefaultInstance(Feature.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateMembershipRequest, Operation>
      createMembershipMethodDescriptor =
          ApiMethodDescriptor.<CreateMembershipRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateMembership")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMembershipRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/memberships",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "membershipId", request.getMembershipId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("resource", request.getResource(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateMembershipRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateFeatureRequest, Operation>
      createFeatureMethodDescriptor =
          ApiMethodDescriptor.<CreateFeatureRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateFeature")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFeatureRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/features",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "featureId", request.getFeatureId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("resource", request.getResource(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateFeatureRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteMembershipRequest, Operation>
      deleteMembershipMethodDescriptor =
          ApiMethodDescriptor.<DeleteMembershipRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteMembership")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMembershipRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/memberships/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteMembershipRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteFeatureRequest, Operation>
      deleteFeatureMethodDescriptor =
          ApiMethodDescriptor.<DeleteFeatureRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteFeature")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFeatureRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/features/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteFeatureRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateMembershipRequest, Operation>
      updateMembershipMethodDescriptor =
          ApiMethodDescriptor.<UpdateMembershipRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateMembership")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMembershipRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/memberships/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("resource", request.getResource(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateMembershipRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateFeatureRequest, Operation>
      updateFeatureMethodDescriptor =
          ApiMethodDescriptor.<UpdateFeatureRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateFeature")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFeatureRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/features/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("resource", request.getResource(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateFeatureRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateConnectManifestRequest, GenerateConnectManifestResponse>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GenerateConnectManifest")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateConnectManifestRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/memberships/*}:generateConnectManifest",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateConnectManifestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateConnectManifestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "imagePullSecretContent",
                                request.getImagePullSecretContent());
                            serializer.putQueryParam(fields, "isUpgrade", request.getIsUpgrade());
                            serializer.putQueryParam(fields, "namespace", request.getNamespace());
                            serializer.putQueryParam(fields, "proxy", request.getProxy());
                            serializer.putQueryParam(fields, "registry", request.getRegistry());
                            serializer.putQueryParam(fields, "version", request.getVersion());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateConnectManifestResponse>newBuilder()
                      .setDefaultInstance(GenerateConnectManifestResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateFleetRequest, Operation>
      createFleetMethodDescriptor =
          ApiMethodDescriptor.<CreateFleetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateFleet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFleetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/fleets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFleetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFleetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("fleet", request.getFleet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateFleetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetFleetRequest, Fleet> getFleetMethodDescriptor =
      ApiMethodDescriptor.<GetFleetRequest, Fleet>newBuilder()
          .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetFleet")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetFleetRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/fleets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetFleetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetFleetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Fleet>newBuilder()
                  .setDefaultInstance(Fleet.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateFleetRequest, Operation>
      updateFleetMethodDescriptor =
          ApiMethodDescriptor.<UpdateFleetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateFleet")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFleetRequest>newBuilder()
                      .setPath(
                          "/v1/{fleet.name=projects/*/locations/*/fleets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFleetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "fleet.name", request.getFleet().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFleetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("fleet", request.getFleet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateFleetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteFleetRequest, Operation>
      deleteFleetMethodDescriptor =
          ApiMethodDescriptor.<DeleteFleetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteFleet")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFleetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/fleets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFleetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFleetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteFleetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListFleetsRequest, ListFleetsResponse>
      listFleetsMethodDescriptor =
          ApiMethodDescriptor.<ListFleetsRequest, ListFleetsResponse>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListFleets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFleetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/fleets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFleetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=organizations/*/locations/*}/fleets")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFleetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFleetsResponse>newBuilder()
                      .setDefaultInstance(ListFleetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetScopeNamespaceRequest, Namespace>
      getScopeNamespaceMethodDescriptor =
          ApiMethodDescriptor.<GetScopeNamespaceRequest, Namespace>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetScopeNamespace")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetScopeNamespaceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/scopes/*/namespaces/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetScopeNamespaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetScopeNamespaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Namespace>newBuilder()
                      .setDefaultInstance(Namespace.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateScopeNamespaceRequest, Operation>
      createScopeNamespaceMethodDescriptor =
          ApiMethodDescriptor.<CreateScopeNamespaceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateScopeNamespace")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateScopeNamespaceRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/scopes/*}/namespaces",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateScopeNamespaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateScopeNamespaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "scopeNamespaceId", request.getScopeNamespaceId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("scopeNamespace", request.getScopeNamespace(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateScopeNamespaceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateScopeNamespaceRequest, Operation>
      updateScopeNamespaceMethodDescriptor =
          ApiMethodDescriptor.<UpdateScopeNamespaceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateScopeNamespace")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateScopeNamespaceRequest>newBuilder()
                      .setPath(
                          "/v1/{scopeNamespace.name=projects/*/locations/*/scopes/*/namespaces/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateScopeNamespaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "scopeNamespace.name",
                                request.getScopeNamespace().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateScopeNamespaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("scopeNamespace", request.getScopeNamespace(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateScopeNamespaceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteScopeNamespaceRequest, Operation>
      deleteScopeNamespaceMethodDescriptor =
          ApiMethodDescriptor.<DeleteScopeNamespaceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteScopeNamespace")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteScopeNamespaceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/scopes/*/namespaces/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteScopeNamespaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteScopeNamespaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteScopeNamespaceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListScopeNamespacesRequest, ListScopeNamespacesResponse>
      listScopeNamespacesMethodDescriptor =
          ApiMethodDescriptor.<ListScopeNamespacesRequest, ListScopeNamespacesResponse>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListScopeNamespaces")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListScopeNamespacesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/scopes/*}/namespaces",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListScopeNamespacesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListScopeNamespacesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListScopeNamespacesResponse>newBuilder()
                      .setDefaultInstance(ListScopeNamespacesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetScopeRBACRoleBindingRequest, RBACRoleBinding>
      getScopeRBACRoleBindingMethodDescriptor =
          ApiMethodDescriptor.<GetScopeRBACRoleBindingRequest, RBACRoleBinding>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetScopeRBACRoleBinding")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetScopeRBACRoleBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/scopes/*/rbacrolebindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetScopeRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetScopeRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RBACRoleBinding>newBuilder()
                      .setDefaultInstance(RBACRoleBinding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateScopeRBACRoleBindingRequest, Operation>
      createScopeRBACRoleBindingMethodDescriptor =
          ApiMethodDescriptor.<CreateScopeRBACRoleBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateScopeRBACRoleBinding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateScopeRBACRoleBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/scopes/*}/rbacrolebindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateScopeRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateScopeRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "rbacrolebindingId", request.getRbacrolebindingId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("rbacrolebinding", request.getRbacrolebinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateScopeRBACRoleBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateScopeRBACRoleBindingRequest, Operation>
      updateScopeRBACRoleBindingMethodDescriptor =
          ApiMethodDescriptor.<UpdateScopeRBACRoleBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateScopeRBACRoleBinding")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateScopeRBACRoleBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{rbacrolebinding.name=projects/*/locations/*/scopes/*/rbacrolebindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateScopeRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "rbacrolebinding.name",
                                request.getRbacrolebinding().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateScopeRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("rbacrolebinding", request.getRbacrolebinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateScopeRBACRoleBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteScopeRBACRoleBindingRequest, Operation>
      deleteScopeRBACRoleBindingMethodDescriptor =
          ApiMethodDescriptor.<DeleteScopeRBACRoleBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteScopeRBACRoleBinding")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteScopeRBACRoleBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/scopes/*/rbacrolebindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteScopeRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteScopeRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteScopeRBACRoleBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsResponse>
      listScopeRBACRoleBindingsMethodDescriptor =
          ApiMethodDescriptor
              .<ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsResponse>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListScopeRBACRoleBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListScopeRBACRoleBindingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/scopes/*}/rbacrolebindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListScopeRBACRoleBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListScopeRBACRoleBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListScopeRBACRoleBindingsResponse>newBuilder()
                      .setDefaultInstance(ListScopeRBACRoleBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetScopeRequest, Scope> getScopeMethodDescriptor =
      ApiMethodDescriptor.<GetScopeRequest, Scope>newBuilder()
          .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetScope")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetScopeRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/scopes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetScopeRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetScopeRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Scope>newBuilder()
                  .setDefaultInstance(Scope.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateScopeRequest, Operation>
      createScopeMethodDescriptor =
          ApiMethodDescriptor.<CreateScopeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateScope")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateScopeRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/scopes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "scopeId", request.getScopeId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("scope", request.getScope(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateScopeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateScopeRequest, Operation>
      updateScopeMethodDescriptor =
          ApiMethodDescriptor.<UpdateScopeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateScope")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateScopeRequest>newBuilder()
                      .setPath(
                          "/v1/{scope.name=projects/*/locations/*/scopes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "scope.name", request.getScope().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("scope", request.getScope(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateScopeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteScopeRequest, Operation>
      deleteScopeMethodDescriptor =
          ApiMethodDescriptor.<DeleteScopeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteScope")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteScopeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/scopes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteScopeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListScopesRequest, ListScopesResponse>
      listScopesMethodDescriptor =
          ApiMethodDescriptor.<ListScopesRequest, ListScopesResponse>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListScopes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListScopesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/scopes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListScopesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListScopesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListScopesResponse>newBuilder()
                      .setDefaultInstance(ListScopesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPermittedScopesRequest, ListPermittedScopesResponse>
      listPermittedScopesMethodDescriptor =
          ApiMethodDescriptor.<ListPermittedScopesRequest, ListPermittedScopesResponse>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListPermittedScopes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPermittedScopesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/scopes:listPermitted",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPermittedScopesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPermittedScopesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPermittedScopesResponse>newBuilder()
                      .setDefaultInstance(ListPermittedScopesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMembershipBindingRequest, MembershipBinding>
      getMembershipBindingMethodDescriptor =
          ApiMethodDescriptor.<GetMembershipBindingRequest, MembershipBinding>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetMembershipBinding")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMembershipBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/memberships/*/bindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMembershipBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMembershipBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MembershipBinding>newBuilder()
                      .setDefaultInstance(MembershipBinding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateMembershipBindingRequest, Operation>
      createMembershipBindingMethodDescriptor =
          ApiMethodDescriptor.<CreateMembershipBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateMembershipBinding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMembershipBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/memberships/*}/bindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMembershipBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMembershipBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "membershipBindingId", request.getMembershipBindingId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "membershipBinding", request.getMembershipBinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateMembershipBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateMembershipBindingRequest, Operation>
      updateMembershipBindingMethodDescriptor =
          ApiMethodDescriptor.<UpdateMembershipBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateMembershipBinding")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMembershipBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{membershipBinding.name=projects/*/locations/*/memberships/*/bindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMembershipBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "membershipBinding.name",
                                request.getMembershipBinding().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMembershipBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "membershipBinding", request.getMembershipBinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateMembershipBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteMembershipBindingRequest, Operation>
      deleteMembershipBindingMethodDescriptor =
          ApiMethodDescriptor.<DeleteMembershipBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteMembershipBinding")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMembershipBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/memberships/*/bindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMembershipBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMembershipBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteMembershipBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListMembershipBindingsRequest, ListMembershipBindingsResponse>
      listMembershipBindingsMethodDescriptor =
          ApiMethodDescriptor
              .<ListMembershipBindingsRequest, ListMembershipBindingsResponse>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListMembershipBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMembershipBindingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/memberships/*}/bindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMembershipBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMembershipBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMembershipBindingsResponse>newBuilder()
                      .setDefaultInstance(ListMembershipBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>
      getMembershipRBACRoleBindingMethodDescriptor =
          ApiMethodDescriptor.<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetMembershipRBACRoleBinding")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMembershipRBACRoleBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/memberships/*/rbacrolebindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMembershipRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMembershipRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RBACRoleBinding>newBuilder()
                      .setDefaultInstance(RBACRoleBinding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateMembershipRBACRoleBindingRequest, Operation>
      createMembershipRBACRoleBindingMethodDescriptor =
          ApiMethodDescriptor.<CreateMembershipRBACRoleBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateMembershipRBACRoleBinding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMembershipRBACRoleBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/memberships/*}/rbacrolebindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMembershipRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMembershipRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "rbacrolebindingId", request.getRbacrolebindingId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("rbacrolebinding", request.getRbacrolebinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateMembershipRBACRoleBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateMembershipRBACRoleBindingRequest, Operation>
      updateMembershipRBACRoleBindingMethodDescriptor =
          ApiMethodDescriptor.<UpdateMembershipRBACRoleBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateMembershipRBACRoleBinding")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMembershipRBACRoleBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{rbacrolebinding.name=projects/*/locations/*/memberships/*/rbacrolebindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMembershipRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "rbacrolebinding.name",
                                request.getRbacrolebinding().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMembershipRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("rbacrolebinding", request.getRbacrolebinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateMembershipRBACRoleBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteMembershipRBACRoleBindingRequest, Operation>
      deleteMembershipRBACRoleBindingMethodDescriptor =
          ApiMethodDescriptor.<DeleteMembershipRBACRoleBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteMembershipRBACRoleBinding")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMembershipRBACRoleBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/memberships/*/rbacrolebindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMembershipRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMembershipRBACRoleBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteMembershipRBACRoleBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsResponse>
      listMembershipRBACRoleBindingsMethodDescriptor =
          ApiMethodDescriptor
              .<ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListMembershipRBACRoleBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMembershipRBACRoleBindingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/memberships/*}/rbacrolebindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMembershipRBACRoleBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMembershipRBACRoleBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMembershipRBACRoleBindingsResponse>newBuilder()
                      .setDefaultInstance(
                          ListMembershipRBACRoleBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GenerateMembershipRBACRoleBindingYAMLRequest,
          GenerateMembershipRBACRoleBindingYAMLResponse>
      generateMembershipRBACRoleBindingYAMLMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateMembershipRBACRoleBindingYAMLRequest,
                  GenerateMembershipRBACRoleBindingYAMLResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.gkehub.v1.GkeHub/GenerateMembershipRBACRoleBindingYAML")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GenerateMembershipRBACRoleBindingYAMLRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/memberships/*}/rbacrolebindings:generateMembershipRBACRoleBindingYAML",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateMembershipRBACRoleBindingYAMLRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateMembershipRBACRoleBindingYAMLRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "rbacrolebindingId", request.getRbacrolebindingId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("rbacrolebinding", request.getRbacrolebinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<GenerateMembershipRBACRoleBindingYAMLResponse>newBuilder()
                      .setDefaultInstance(
                          GenerateMembershipRBACRoleBindingYAMLResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGkeHubStub create(GkeHubStubSettings settings) throws IOException {
    return new HttpJsonGkeHubStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGkeHubStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonGkeHubStub(GkeHubStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonGkeHubStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGkeHubStub(
        GkeHubStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGkeHubStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonGkeHubStub(GkeHubStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGkeHubCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGkeHubStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonGkeHubStub(
      GkeHubStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListMembershipsRequest, ListMembershipsResponse>
        listMembershipsTransportSettings =
            HttpJsonCallSettings.<ListMembershipsRequest, ListMembershipsResponse>newBuilder()
                .setMethodDescriptor(listMembershipsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListBoundMembershipsRequest, ListBoundMembershipsResponse>
        listBoundMembershipsTransportSettings =
            HttpJsonCallSettings
                .<ListBoundMembershipsRequest, ListBoundMembershipsResponse>newBuilder()
                .setMethodDescriptor(listBoundMembershipsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("scope_name", String.valueOf(request.getScopeName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListFeaturesRequest, ListFeaturesResponse> listFeaturesTransportSettings =
        HttpJsonCallSettings.<ListFeaturesRequest, ListFeaturesResponse>newBuilder()
            .setMethodDescriptor(listFeaturesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetMembershipRequest, Membership> getMembershipTransportSettings =
        HttpJsonCallSettings.<GetMembershipRequest, Membership>newBuilder()
            .setMethodDescriptor(getMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetFeatureRequest, Feature> getFeatureTransportSettings =
        HttpJsonCallSettings.<GetFeatureRequest, Feature>newBuilder()
            .setMethodDescriptor(getFeatureMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateMembershipRequest, Operation> createMembershipTransportSettings =
        HttpJsonCallSettings.<CreateMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(createMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateFeatureRequest, Operation> createFeatureTransportSettings =
        HttpJsonCallSettings.<CreateFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(createFeatureMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteMembershipRequest, Operation> deleteMembershipTransportSettings =
        HttpJsonCallSettings.<DeleteMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteFeatureRequest, Operation> deleteFeatureTransportSettings =
        HttpJsonCallSettings.<DeleteFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFeatureMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateMembershipRequest, Operation> updateMembershipTransportSettings =
        HttpJsonCallSettings.<UpdateMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateFeatureRequest, Operation> updateFeatureTransportSettings =
        HttpJsonCallSettings.<UpdateFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFeatureMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
        generateConnectManifestTransportSettings =
            HttpJsonCallSettings
                .<GenerateConnectManifestRequest, GenerateConnectManifestResponse>newBuilder()
                .setMethodDescriptor(generateConnectManifestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateFleetRequest, Operation> createFleetTransportSettings =
        HttpJsonCallSettings.<CreateFleetRequest, Operation>newBuilder()
            .setMethodDescriptor(createFleetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetFleetRequest, Fleet> getFleetTransportSettings =
        HttpJsonCallSettings.<GetFleetRequest, Fleet>newBuilder()
            .setMethodDescriptor(getFleetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateFleetRequest, Operation> updateFleetTransportSettings =
        HttpJsonCallSettings.<UpdateFleetRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFleetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("fleet.name", String.valueOf(request.getFleet().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteFleetRequest, Operation> deleteFleetTransportSettings =
        HttpJsonCallSettings.<DeleteFleetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFleetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListFleetsRequest, ListFleetsResponse> listFleetsTransportSettings =
        HttpJsonCallSettings.<ListFleetsRequest, ListFleetsResponse>newBuilder()
            .setMethodDescriptor(listFleetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetScopeNamespaceRequest, Namespace> getScopeNamespaceTransportSettings =
        HttpJsonCallSettings.<GetScopeNamespaceRequest, Namespace>newBuilder()
            .setMethodDescriptor(getScopeNamespaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateScopeNamespaceRequest, Operation>
        createScopeNamespaceTransportSettings =
            HttpJsonCallSettings.<CreateScopeNamespaceRequest, Operation>newBuilder()
                .setMethodDescriptor(createScopeNamespaceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateScopeNamespaceRequest, Operation>
        updateScopeNamespaceTransportSettings =
            HttpJsonCallSettings.<UpdateScopeNamespaceRequest, Operation>newBuilder()
                .setMethodDescriptor(updateScopeNamespaceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "scope_namespace.name",
                          String.valueOf(request.getScopeNamespace().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteScopeNamespaceRequest, Operation>
        deleteScopeNamespaceTransportSettings =
            HttpJsonCallSettings.<DeleteScopeNamespaceRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteScopeNamespaceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListScopeNamespacesRequest, ListScopeNamespacesResponse>
        listScopeNamespacesTransportSettings =
            HttpJsonCallSettings
                .<ListScopeNamespacesRequest, ListScopeNamespacesResponse>newBuilder()
                .setMethodDescriptor(listScopeNamespacesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetScopeRBACRoleBindingRequest, RBACRoleBinding>
        getScopeRBACRoleBindingTransportSettings =
            HttpJsonCallSettings.<GetScopeRBACRoleBindingRequest, RBACRoleBinding>newBuilder()
                .setMethodDescriptor(getScopeRBACRoleBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateScopeRBACRoleBindingRequest, Operation>
        createScopeRBACRoleBindingTransportSettings =
            HttpJsonCallSettings.<CreateScopeRBACRoleBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(createScopeRBACRoleBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateScopeRBACRoleBindingRequest, Operation>
        updateScopeRBACRoleBindingTransportSettings =
            HttpJsonCallSettings.<UpdateScopeRBACRoleBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(updateScopeRBACRoleBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "rbacrolebinding.name",
                          String.valueOf(request.getRbacrolebinding().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteScopeRBACRoleBindingRequest, Operation>
        deleteScopeRBACRoleBindingTransportSettings =
            HttpJsonCallSettings.<DeleteScopeRBACRoleBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteScopeRBACRoleBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsResponse>
        listScopeRBACRoleBindingsTransportSettings =
            HttpJsonCallSettings
                .<ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsResponse>newBuilder()
                .setMethodDescriptor(listScopeRBACRoleBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetScopeRequest, Scope> getScopeTransportSettings =
        HttpJsonCallSettings.<GetScopeRequest, Scope>newBuilder()
            .setMethodDescriptor(getScopeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateScopeRequest, Operation> createScopeTransportSettings =
        HttpJsonCallSettings.<CreateScopeRequest, Operation>newBuilder()
            .setMethodDescriptor(createScopeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateScopeRequest, Operation> updateScopeTransportSettings =
        HttpJsonCallSettings.<UpdateScopeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateScopeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("scope.name", String.valueOf(request.getScope().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteScopeRequest, Operation> deleteScopeTransportSettings =
        HttpJsonCallSettings.<DeleteScopeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteScopeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListScopesRequest, ListScopesResponse> listScopesTransportSettings =
        HttpJsonCallSettings.<ListScopesRequest, ListScopesResponse>newBuilder()
            .setMethodDescriptor(listScopesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListPermittedScopesRequest, ListPermittedScopesResponse>
        listPermittedScopesTransportSettings =
            HttpJsonCallSettings
                .<ListPermittedScopesRequest, ListPermittedScopesResponse>newBuilder()
                .setMethodDescriptor(listPermittedScopesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetMembershipBindingRequest, MembershipBinding>
        getMembershipBindingTransportSettings =
            HttpJsonCallSettings.<GetMembershipBindingRequest, MembershipBinding>newBuilder()
                .setMethodDescriptor(getMembershipBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateMembershipBindingRequest, Operation>
        createMembershipBindingTransportSettings =
            HttpJsonCallSettings.<CreateMembershipBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(createMembershipBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateMembershipBindingRequest, Operation>
        updateMembershipBindingTransportSettings =
            HttpJsonCallSettings.<UpdateMembershipBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(updateMembershipBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "membership_binding.name",
                          String.valueOf(request.getMembershipBinding().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteMembershipBindingRequest, Operation>
        deleteMembershipBindingTransportSettings =
            HttpJsonCallSettings.<DeleteMembershipBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMembershipBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListMembershipBindingsRequest, ListMembershipBindingsResponse>
        listMembershipBindingsTransportSettings =
            HttpJsonCallSettings
                .<ListMembershipBindingsRequest, ListMembershipBindingsResponse>newBuilder()
                .setMethodDescriptor(listMembershipBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>
        getMembershipRBACRoleBindingTransportSettings =
            HttpJsonCallSettings.<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>newBuilder()
                .setMethodDescriptor(getMembershipRBACRoleBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateMembershipRBACRoleBindingRequest, Operation>
        createMembershipRBACRoleBindingTransportSettings =
            HttpJsonCallSettings.<CreateMembershipRBACRoleBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(createMembershipRBACRoleBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateMembershipRBACRoleBindingRequest, Operation>
        updateMembershipRBACRoleBindingTransportSettings =
            HttpJsonCallSettings.<UpdateMembershipRBACRoleBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(updateMembershipRBACRoleBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "rbacrolebinding.name",
                          String.valueOf(request.getRbacrolebinding().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteMembershipRBACRoleBindingRequest, Operation>
        deleteMembershipRBACRoleBindingTransportSettings =
            HttpJsonCallSettings.<DeleteMembershipRBACRoleBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMembershipRBACRoleBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsResponse>
        listMembershipRBACRoleBindingsTransportSettings =
            HttpJsonCallSettings
                .<ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsResponse>
                    newBuilder()
                .setMethodDescriptor(listMembershipRBACRoleBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            GenerateMembershipRBACRoleBindingYAMLRequest,
            GenerateMembershipRBACRoleBindingYAMLResponse>
        generateMembershipRBACRoleBindingYAMLTransportSettings =
            HttpJsonCallSettings
                .<GenerateMembershipRBACRoleBindingYAMLRequest,
                    GenerateMembershipRBACRoleBindingYAMLResponse>
                    newBuilder()
                .setMethodDescriptor(generateMembershipRBACRoleBindingYAMLMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
    this.createFeatureCallable =
        callableFactory.createUnaryCallable(
            createFeatureTransportSettings, settings.createFeatureSettings(), clientContext);
    this.createFeatureOperationCallable =
        callableFactory.createOperationCallable(
            createFeatureTransportSettings,
            settings.createFeatureOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteMembershipCallable =
        callableFactory.createUnaryCallable(
            deleteMembershipTransportSettings, settings.deleteMembershipSettings(), clientContext);
    this.deleteMembershipOperationCallable =
        callableFactory.createOperationCallable(
            deleteMembershipTransportSettings,
            settings.deleteMembershipOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteFeatureCallable =
        callableFactory.createUnaryCallable(
            deleteFeatureTransportSettings, settings.deleteFeatureSettings(), clientContext);
    this.deleteFeatureOperationCallable =
        callableFactory.createOperationCallable(
            deleteFeatureTransportSettings,
            settings.deleteFeatureOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateMembershipCallable =
        callableFactory.createUnaryCallable(
            updateMembershipTransportSettings, settings.updateMembershipSettings(), clientContext);
    this.updateMembershipOperationCallable =
        callableFactory.createOperationCallable(
            updateMembershipTransportSettings,
            settings.updateMembershipOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateFeatureCallable =
        callableFactory.createUnaryCallable(
            updateFeatureTransportSettings, settings.updateFeatureSettings(), clientContext);
    this.updateFeatureOperationCallable =
        callableFactory.createOperationCallable(
            updateFeatureTransportSettings,
            settings.updateFeatureOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.deleteFleetCallable =
        callableFactory.createUnaryCallable(
            deleteFleetTransportSettings, settings.deleteFleetSettings(), clientContext);
    this.deleteFleetOperationCallable =
        callableFactory.createOperationCallable(
            deleteFleetTransportSettings,
            settings.deleteFleetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.updateScopeCallable =
        callableFactory.createUnaryCallable(
            updateScopeTransportSettings, settings.updateScopeSettings(), clientContext);
    this.updateScopeOperationCallable =
        callableFactory.createOperationCallable(
            updateScopeTransportSettings,
            settings.updateScopeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteScopeCallable =
        callableFactory.createUnaryCallable(
            deleteScopeTransportSettings, settings.deleteScopeSettings(), clientContext);
    this.deleteScopeOperationCallable =
        callableFactory.createOperationCallable(
            deleteScopeTransportSettings,
            settings.deleteScopeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listMembershipsMethodDescriptor);
    methodDescriptors.add(listBoundMembershipsMethodDescriptor);
    methodDescriptors.add(listFeaturesMethodDescriptor);
    methodDescriptors.add(getMembershipMethodDescriptor);
    methodDescriptors.add(getFeatureMethodDescriptor);
    methodDescriptors.add(createMembershipMethodDescriptor);
    methodDescriptors.add(createFeatureMethodDescriptor);
    methodDescriptors.add(deleteMembershipMethodDescriptor);
    methodDescriptors.add(deleteFeatureMethodDescriptor);
    methodDescriptors.add(updateMembershipMethodDescriptor);
    methodDescriptors.add(updateFeatureMethodDescriptor);
    methodDescriptors.add(generateConnectManifestMethodDescriptor);
    methodDescriptors.add(createFleetMethodDescriptor);
    methodDescriptors.add(getFleetMethodDescriptor);
    methodDescriptors.add(updateFleetMethodDescriptor);
    methodDescriptors.add(deleteFleetMethodDescriptor);
    methodDescriptors.add(listFleetsMethodDescriptor);
    methodDescriptors.add(getScopeNamespaceMethodDescriptor);
    methodDescriptors.add(createScopeNamespaceMethodDescriptor);
    methodDescriptors.add(updateScopeNamespaceMethodDescriptor);
    methodDescriptors.add(deleteScopeNamespaceMethodDescriptor);
    methodDescriptors.add(listScopeNamespacesMethodDescriptor);
    methodDescriptors.add(getScopeRBACRoleBindingMethodDescriptor);
    methodDescriptors.add(createScopeRBACRoleBindingMethodDescriptor);
    methodDescriptors.add(updateScopeRBACRoleBindingMethodDescriptor);
    methodDescriptors.add(deleteScopeRBACRoleBindingMethodDescriptor);
    methodDescriptors.add(listScopeRBACRoleBindingsMethodDescriptor);
    methodDescriptors.add(getScopeMethodDescriptor);
    methodDescriptors.add(createScopeMethodDescriptor);
    methodDescriptors.add(updateScopeMethodDescriptor);
    methodDescriptors.add(deleteScopeMethodDescriptor);
    methodDescriptors.add(listScopesMethodDescriptor);
    methodDescriptors.add(listPermittedScopesMethodDescriptor);
    methodDescriptors.add(getMembershipBindingMethodDescriptor);
    methodDescriptors.add(createMembershipBindingMethodDescriptor);
    methodDescriptors.add(updateMembershipBindingMethodDescriptor);
    methodDescriptors.add(deleteMembershipBindingMethodDescriptor);
    methodDescriptors.add(listMembershipBindingsMethodDescriptor);
    methodDescriptors.add(getMembershipRBACRoleBindingMethodDescriptor);
    methodDescriptors.add(createMembershipRBACRoleBindingMethodDescriptor);
    methodDescriptors.add(updateMembershipRBACRoleBindingMethodDescriptor);
    methodDescriptors.add(deleteMembershipRBACRoleBindingMethodDescriptor);
    methodDescriptors.add(listMembershipRBACRoleBindingsMethodDescriptor);
    methodDescriptors.add(generateMembershipRBACRoleBindingYAMLMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
