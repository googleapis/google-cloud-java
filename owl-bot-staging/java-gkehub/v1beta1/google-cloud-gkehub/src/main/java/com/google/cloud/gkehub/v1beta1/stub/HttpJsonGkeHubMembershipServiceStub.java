/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.gkehub.v1beta1.stub;

import static com.google.cloud.gkehub.v1beta1.GkeHubMembershipServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.gkehub.v1beta1.GkeHubMembershipServiceClient.ListMembershipsPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkehub.v1beta1.CreateMembershipRequest;
import com.google.cloud.gkehub.v1beta1.DeleteMembershipRequest;
import com.google.cloud.gkehub.v1beta1.GenerateConnectManifestRequest;
import com.google.cloud.gkehub.v1beta1.GenerateConnectManifestResponse;
import com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestRequest;
import com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestResponse;
import com.google.cloud.gkehub.v1beta1.GetMembershipRequest;
import com.google.cloud.gkehub.v1beta1.ListMembershipsRequest;
import com.google.cloud.gkehub.v1beta1.ListMembershipsResponse;
import com.google.cloud.gkehub.v1beta1.Membership;
import com.google.cloud.gkehub.v1beta1.OperationMetadata;
import com.google.cloud.gkehub.v1beta1.UpdateMembershipRequest;
import com.google.cloud.gkehub.v1beta1.ValidateExclusivityRequest;
import com.google.cloud.gkehub.v1beta1.ValidateExclusivityResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * REST stub implementation for the GkeHubMembershipService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonGkeHubMembershipServiceStub extends GkeHubMembershipServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Membership.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsMethodDescriptor =
          ApiMethodDescriptor.<ListMembershipsRequest, ListMembershipsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/ListMemberships")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMembershipsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/memberships",
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

  private static final ApiMethodDescriptor<GetMembershipRequest, Membership>
      getMembershipMethodDescriptor =
          ApiMethodDescriptor.<GetMembershipRequest, Membership>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/GetMembership")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMembershipRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/memberships/*}",
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

  private static final ApiMethodDescriptor<CreateMembershipRequest, Operation>
      createMembershipMethodDescriptor =
          ApiMethodDescriptor.<CreateMembershipRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/CreateMembership")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMembershipRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/memberships",
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

  private static final ApiMethodDescriptor<DeleteMembershipRequest, Operation>
      deleteMembershipMethodDescriptor =
          ApiMethodDescriptor.<DeleteMembershipRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/DeleteMembership")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMembershipRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/memberships/*}",
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

  private static final ApiMethodDescriptor<UpdateMembershipRequest, Operation>
      updateMembershipMethodDescriptor =
          ApiMethodDescriptor.<UpdateMembershipRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/UpdateMembership")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMembershipRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/memberships/*}",
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

  private static final ApiMethodDescriptor<
          GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateConnectManifestRequest, GenerateConnectManifestResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/GenerateConnectManifest")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateConnectManifestRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/memberships/*}:generateConnectManifest",
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
                                fields, "connectAgent", request.getConnectAgent());
                            serializer.putQueryParam(
                                fields,
                                "imagePullSecretContent",
                                request.getImagePullSecretContent());
                            serializer.putQueryParam(fields, "isUpgrade", request.getIsUpgrade());
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

  private static final ApiMethodDescriptor<ValidateExclusivityRequest, ValidateExclusivityResponse>
      validateExclusivityMethodDescriptor =
          ApiMethodDescriptor.<ValidateExclusivityRequest, ValidateExclusivityResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/ValidateExclusivity")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ValidateExclusivityRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/memberships:validateExclusivity",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ValidateExclusivityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ValidateExclusivityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "crManifest", request.getCrManifest());
                            serializer.putQueryParam(
                                fields, "intendedMembership", request.getIntendedMembership());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ValidateExclusivityResponse>newBuilder()
                      .setDefaultInstance(ValidateExclusivityResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
      generateExclusivityManifestMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/GenerateExclusivityManifest")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateExclusivityManifestRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/memberships/*}:generateExclusivityManifest",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateExclusivityManifestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateExclusivityManifestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "crManifest", request.getCrManifest());
                            serializer.putQueryParam(
                                fields, "crdManifest", request.getCrdManifest());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateExclusivityManifestResponse>newBuilder()
                      .setDefaultInstance(GenerateExclusivityManifestResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/*/memberships/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/*/memberships/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/*/memberships/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsCallable;
  private final UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable;
  private final UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable;
  private final UnaryCallable<CreateMembershipRequest, Operation> createMembershipCallable;
  private final OperationCallable<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationCallable;
  private final UnaryCallable<DeleteMembershipRequest, Operation> deleteMembershipCallable;
  private final OperationCallable<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationCallable;
  private final UnaryCallable<UpdateMembershipRequest, Operation> updateMembershipCallable;
  private final OperationCallable<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationCallable;
  private final UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable;
  private final UnaryCallable<ValidateExclusivityRequest, ValidateExclusivityResponse>
      validateExclusivityCallable;
  private final UnaryCallable<
          GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
      generateExclusivityManifestCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGkeHubMembershipServiceStub create(
      GkeHubMembershipServiceStubSettings settings) throws IOException {
    return new HttpJsonGkeHubMembershipServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGkeHubMembershipServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGkeHubMembershipServiceStub(
        GkeHubMembershipServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonGkeHubMembershipServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGkeHubMembershipServiceStub(
        GkeHubMembershipServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGkeHubMembershipServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGkeHubMembershipServiceStub(
      GkeHubMembershipServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGkeHubMembershipServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGkeHubMembershipServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGkeHubMembershipServiceStub(
      GkeHubMembershipServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListMembershipsRequest, ListMembershipsResponse>
        listMembershipsTransportSettings =
            HttpJsonCallSettings.<ListMembershipsRequest, ListMembershipsResponse>newBuilder()
                .setMethodDescriptor(listMembershipsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetMembershipRequest, Membership> getMembershipTransportSettings =
        HttpJsonCallSettings.<GetMembershipRequest, Membership>newBuilder()
            .setMethodDescriptor(getMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateMembershipRequest, Operation> createMembershipTransportSettings =
        HttpJsonCallSettings.<CreateMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(createMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteMembershipRequest, Operation> deleteMembershipTransportSettings =
        HttpJsonCallSettings.<DeleteMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateMembershipRequest, Operation> updateMembershipTransportSettings =
        HttpJsonCallSettings.<UpdateMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
        generateConnectManifestTransportSettings =
            HttpJsonCallSettings
                .<GenerateConnectManifestRequest, GenerateConnectManifestResponse>newBuilder()
                .setMethodDescriptor(generateConnectManifestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ValidateExclusivityRequest, ValidateExclusivityResponse>
        validateExclusivityTransportSettings =
            HttpJsonCallSettings
                .<ValidateExclusivityRequest, ValidateExclusivityResponse>newBuilder()
                .setMethodDescriptor(validateExclusivityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
        generateExclusivityManifestTransportSettings =
            HttpJsonCallSettings
                .<GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
                    newBuilder()
                .setMethodDescriptor(generateExclusivityManifestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listMembershipsCallable =
        callableFactory.createUnaryCallable(
            listMembershipsTransportSettings, settings.listMembershipsSettings(), clientContext);
    this.listMembershipsPagedCallable =
        callableFactory.createPagedCallable(
            listMembershipsTransportSettings, settings.listMembershipsSettings(), clientContext);
    this.getMembershipCallable =
        callableFactory.createUnaryCallable(
            getMembershipTransportSettings, settings.getMembershipSettings(), clientContext);
    this.createMembershipCallable =
        callableFactory.createUnaryCallable(
            createMembershipTransportSettings, settings.createMembershipSettings(), clientContext);
    this.createMembershipOperationCallable =
        callableFactory.createOperationCallable(
            createMembershipTransportSettings,
            settings.createMembershipOperationSettings(),
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
    this.updateMembershipCallable =
        callableFactory.createUnaryCallable(
            updateMembershipTransportSettings, settings.updateMembershipSettings(), clientContext);
    this.updateMembershipOperationCallable =
        callableFactory.createOperationCallable(
            updateMembershipTransportSettings,
            settings.updateMembershipOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateConnectManifestCallable =
        callableFactory.createUnaryCallable(
            generateConnectManifestTransportSettings,
            settings.generateConnectManifestSettings(),
            clientContext);
    this.validateExclusivityCallable =
        callableFactory.createUnaryCallable(
            validateExclusivityTransportSettings,
            settings.validateExclusivitySettings(),
            clientContext);
    this.generateExclusivityManifestCallable =
        callableFactory.createUnaryCallable(
            generateExclusivityManifestTransportSettings,
            settings.generateExclusivityManifestSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listMembershipsMethodDescriptor);
    methodDescriptors.add(getMembershipMethodDescriptor);
    methodDescriptors.add(createMembershipMethodDescriptor);
    methodDescriptors.add(deleteMembershipMethodDescriptor);
    methodDescriptors.add(updateMembershipMethodDescriptor);
    methodDescriptors.add(generateConnectManifestMethodDescriptor);
    methodDescriptors.add(validateExclusivityMethodDescriptor);
    methodDescriptors.add(generateExclusivityManifestMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
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
  public UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable() {
    return getMembershipCallable;
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
  public UnaryCallable<DeleteMembershipRequest, Operation> deleteMembershipCallable() {
    return deleteMembershipCallable;
  }

  @Override
  public OperationCallable<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationCallable() {
    return deleteMembershipOperationCallable;
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
  public UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable() {
    return generateConnectManifestCallable;
  }

  @Override
  public UnaryCallable<ValidateExclusivityRequest, ValidateExclusivityResponse>
      validateExclusivityCallable() {
    return validateExclusivityCallable;
  }

  @Override
  public UnaryCallable<GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
      generateExclusivityManifestCallable() {
    return generateExclusivityManifestCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
