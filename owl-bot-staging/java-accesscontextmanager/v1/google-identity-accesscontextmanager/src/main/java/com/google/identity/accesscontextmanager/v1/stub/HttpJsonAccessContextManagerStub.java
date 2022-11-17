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

package com.google.identity.accesscontextmanager.v1.stub;

import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListAccessLevelsPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListAccessPoliciesPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListGcpUserAccessBindingsPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListServicePerimetersPagedResponse;

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
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.identity.accesscontextmanager.v1.AccessContextManagerOperationMetadata;
import com.google.identity.accesscontextmanager.v1.AccessLevel;
import com.google.identity.accesscontextmanager.v1.AccessPolicy;
import com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest;
import com.google.identity.accesscontextmanager.v1.CommitServicePerimetersResponse;
import com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest;
import com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest;
import com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest;
import com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding;
import com.google.identity.accesscontextmanager.v1.GcpUserAccessBindingOperationMetadata;
import com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest;
import com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest;
import com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest;
import com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse;
import com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest;
import com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse;
import com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest;
import com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse;
import com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest;
import com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse;
import com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest;
import com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsResponse;
import com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest;
import com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersResponse;
import com.google.identity.accesscontextmanager.v1.ServicePerimeter;
import com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest;
import com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest;
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
 * REST stub implementation for the AccessContextManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAccessContextManagerStub extends AccessContextManagerStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(AccessPolicy.getDescriptor())
          .add(GcpUserAccessBinding.getDescriptor())
          .add(ReplaceAccessLevelsResponse.getDescriptor())
          .add(ServicePerimeter.getDescriptor())
          .add(ReplaceServicePerimetersResponse.getDescriptor())
          .add(CommitServicePerimetersResponse.getDescriptor())
          .add(AccessLevel.getDescriptor())
          .add(AccessContextManagerOperationMetadata.getDescriptor())
          .add(GcpUserAccessBindingOperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
      listAccessPoliciesMethodDescriptor =
          ApiMethodDescriptor.<ListAccessPoliciesRequest, ListAccessPoliciesResponse>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/ListAccessPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccessPoliciesRequest>newBuilder()
                      .setPath(
                          "/v1/accessPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccessPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccessPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAccessPoliciesResponse>newBuilder()
                      .setDefaultInstance(ListAccessPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAccessPolicyRequest, AccessPolicy>
      getAccessPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetAccessPolicyRequest, AccessPolicy>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/GetAccessPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAccessPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accessPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccessPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccessPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccessPolicy>newBuilder()
                      .setDefaultInstance(AccessPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AccessPolicy, Operation>
      createAccessPolicyMethodDescriptor =
          ApiMethodDescriptor.<AccessPolicy, Operation>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/CreateAccessPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AccessPolicy>newBuilder()
                      .setPath(
                          "/v1/accessPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AccessPolicy> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AccessPolicy> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AccessPolicy request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateAccessPolicyRequest, Operation>
      updateAccessPolicyMethodDescriptor =
          ApiMethodDescriptor.<UpdateAccessPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/UpdateAccessPolicy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAccessPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{policy.name=accessPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccessPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "policy.name", request.getPolicy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccessPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("policy", request.getPolicy(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateAccessPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteAccessPolicyRequest, Operation>
      deleteAccessPolicyMethodDescriptor =
          ApiMethodDescriptor.<DeleteAccessPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/DeleteAccessPolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAccessPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accessPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccessPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccessPolicyRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteAccessPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListAccessLevelsRequest, ListAccessLevelsResponse>
      listAccessLevelsMethodDescriptor =
          ApiMethodDescriptor.<ListAccessLevelsRequest, ListAccessLevelsResponse>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/ListAccessLevels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccessLevelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accessPolicies/*}/accessLevels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccessLevelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccessLevelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "accessLevelFormat", request.getAccessLevelFormatValue());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAccessLevelsResponse>newBuilder()
                      .setDefaultInstance(ListAccessLevelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAccessLevelRequest, AccessLevel>
      getAccessLevelMethodDescriptor =
          ApiMethodDescriptor.<GetAccessLevelRequest, AccessLevel>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/GetAccessLevel")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAccessLevelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accessPolicies/*/accessLevels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccessLevelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccessLevelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "accessLevelFormat", request.getAccessLevelFormatValue());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccessLevel>newBuilder()
                      .setDefaultInstance(AccessLevel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAccessLevelRequest, Operation>
      createAccessLevelMethodDescriptor =
          ApiMethodDescriptor.<CreateAccessLevelRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/CreateAccessLevel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAccessLevelRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accessPolicies/*}/accessLevels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAccessLevelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAccessLevelRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("accessLevel", request.getAccessLevel(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAccessLevelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateAccessLevelRequest, Operation>
      updateAccessLevelMethodDescriptor =
          ApiMethodDescriptor.<UpdateAccessLevelRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/UpdateAccessLevel")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAccessLevelRequest>newBuilder()
                      .setPath(
                          "/v1/{accessLevel.name=accessPolicies/*/accessLevels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccessLevelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "accessLevel.name", request.getAccessLevel().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccessLevelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("accessLevel", request.getAccessLevel(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateAccessLevelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteAccessLevelRequest, Operation>
      deleteAccessLevelMethodDescriptor =
          ApiMethodDescriptor.<DeleteAccessLevelRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/DeleteAccessLevel")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAccessLevelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accessPolicies/*/accessLevels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccessLevelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccessLevelRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteAccessLevelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ReplaceAccessLevelsRequest, Operation>
      replaceAccessLevelsMethodDescriptor =
          ApiMethodDescriptor.<ReplaceAccessLevelsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/ReplaceAccessLevels")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReplaceAccessLevelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accessPolicies/*}/accessLevels:replaceAll",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReplaceAccessLevelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReplaceAccessLevelsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ReplaceAccessLevelsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListServicePerimetersRequest, ListServicePerimetersResponse>
      listServicePerimetersMethodDescriptor =
          ApiMethodDescriptor
              .<ListServicePerimetersRequest, ListServicePerimetersResponse>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/ListServicePerimeters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServicePerimetersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accessPolicies/*}/servicePerimeters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListServicePerimetersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListServicePerimetersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListServicePerimetersResponse>newBuilder()
                      .setDefaultInstance(ListServicePerimetersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetServicePerimeterRequest, ServicePerimeter>
      getServicePerimeterMethodDescriptor =
          ApiMethodDescriptor.<GetServicePerimeterRequest, ServicePerimeter>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/GetServicePerimeter")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetServicePerimeterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accessPolicies/*/servicePerimeters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetServicePerimeterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetServicePerimeterRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ServicePerimeter>newBuilder()
                      .setDefaultInstance(ServicePerimeter.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateServicePerimeterRequest, Operation>
      createServicePerimeterMethodDescriptor =
          ApiMethodDescriptor.<CreateServicePerimeterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/CreateServicePerimeter")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateServicePerimeterRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accessPolicies/*}/servicePerimeters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServicePerimeterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServicePerimeterRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("servicePerimeter", request.getServicePerimeter(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateServicePerimeterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateServicePerimeterRequest, Operation>
      updateServicePerimeterMethodDescriptor =
          ApiMethodDescriptor.<UpdateServicePerimeterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/UpdateServicePerimeter")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateServicePerimeterRequest>newBuilder()
                      .setPath(
                          "/v1/{servicePerimeter.name=accessPolicies/*/servicePerimeters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateServicePerimeterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "servicePerimeter.name",
                                request.getServicePerimeter().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateServicePerimeterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("servicePerimeter", request.getServicePerimeter(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateServicePerimeterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteServicePerimeterRequest, Operation>
      deleteServicePerimeterMethodDescriptor =
          ApiMethodDescriptor.<DeleteServicePerimeterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/DeleteServicePerimeter")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteServicePerimeterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accessPolicies/*/servicePerimeters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServicePerimeterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServicePerimeterRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteServicePerimeterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ReplaceServicePerimetersRequest, Operation>
      replaceServicePerimetersMethodDescriptor =
          ApiMethodDescriptor.<ReplaceServicePerimetersRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/ReplaceServicePerimeters")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReplaceServicePerimetersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accessPolicies/*}/servicePerimeters:replaceAll",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReplaceServicePerimetersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReplaceServicePerimetersRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ReplaceServicePerimetersRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CommitServicePerimetersRequest, Operation>
      commitServicePerimetersMethodDescriptor =
          ApiMethodDescriptor.<CommitServicePerimetersRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/CommitServicePerimeters")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CommitServicePerimetersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accessPolicies/*}/servicePerimeters:commit",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CommitServicePerimetersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CommitServicePerimetersRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CommitServicePerimetersRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsResponse>
      listGcpUserAccessBindingsMethodDescriptor =
          ApiMethodDescriptor
              .<ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsResponse>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/ListGcpUserAccessBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGcpUserAccessBindingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*}/gcpUserAccessBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGcpUserAccessBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGcpUserAccessBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListGcpUserAccessBindingsResponse>newBuilder()
                      .setDefaultInstance(ListGcpUserAccessBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>
      getGcpUserAccessBindingMethodDescriptor =
          ApiMethodDescriptor.<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/GetGcpUserAccessBinding")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGcpUserAccessBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/gcpUserAccessBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGcpUserAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGcpUserAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GcpUserAccessBinding>newBuilder()
                      .setDefaultInstance(GcpUserAccessBinding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateGcpUserAccessBindingRequest, Operation>
      createGcpUserAccessBindingMethodDescriptor =
          ApiMethodDescriptor.<CreateGcpUserAccessBindingRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/CreateGcpUserAccessBinding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGcpUserAccessBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*}/gcpUserAccessBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGcpUserAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGcpUserAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "gcpUserAccessBinding",
                                      request.getGcpUserAccessBinding(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateGcpUserAccessBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateGcpUserAccessBindingRequest, Operation>
      updateGcpUserAccessBindingMethodDescriptor =
          ApiMethodDescriptor.<UpdateGcpUserAccessBindingRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/UpdateGcpUserAccessBinding")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGcpUserAccessBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{gcpUserAccessBinding.name=organizations/*/gcpUserAccessBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGcpUserAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "gcpUserAccessBinding.name",
                                request.getGcpUserAccessBinding().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGcpUserAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "gcpUserAccessBinding",
                                      request.getGcpUserAccessBinding(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateGcpUserAccessBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteGcpUserAccessBindingRequest, Operation>
      deleteGcpUserAccessBindingMethodDescriptor =
          ApiMethodDescriptor.<DeleteGcpUserAccessBindingRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/DeleteGcpUserAccessBinding")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGcpUserAccessBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/gcpUserAccessBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGcpUserAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGcpUserAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteGcpUserAccessBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=accessPolicies/*}:setIamPolicy",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
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
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=accessPolicies/*}:getIamPolicy",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
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
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=accessPolicies/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=accessPolicies/*/accessLevels/*}:testIamPermissions",
                          "/v1/{resource=accessPolicies/*/servicePerimeters/*}:testIamPermissions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
      listAccessPoliciesCallable;
  private final UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesPagedResponse>
      listAccessPoliciesPagedCallable;
  private final UnaryCallable<GetAccessPolicyRequest, AccessPolicy> getAccessPolicyCallable;
  private final UnaryCallable<AccessPolicy, Operation> createAccessPolicyCallable;
  private final OperationCallable<AccessPolicy, AccessPolicy, AccessContextManagerOperationMetadata>
      createAccessPolicyOperationCallable;
  private final UnaryCallable<UpdateAccessPolicyRequest, Operation> updateAccessPolicyCallable;
  private final OperationCallable<
          UpdateAccessPolicyRequest, AccessPolicy, AccessContextManagerOperationMetadata>
      updateAccessPolicyOperationCallable;
  private final UnaryCallable<DeleteAccessPolicyRequest, Operation> deleteAccessPolicyCallable;
  private final OperationCallable<
          DeleteAccessPolicyRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessPolicyOperationCallable;
  private final UnaryCallable<ListAccessLevelsRequest, ListAccessLevelsResponse>
      listAccessLevelsCallable;
  private final UnaryCallable<ListAccessLevelsRequest, ListAccessLevelsPagedResponse>
      listAccessLevelsPagedCallable;
  private final UnaryCallable<GetAccessLevelRequest, AccessLevel> getAccessLevelCallable;
  private final UnaryCallable<CreateAccessLevelRequest, Operation> createAccessLevelCallable;
  private final OperationCallable<
          CreateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      createAccessLevelOperationCallable;
  private final UnaryCallable<UpdateAccessLevelRequest, Operation> updateAccessLevelCallable;
  private final OperationCallable<
          UpdateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      updateAccessLevelOperationCallable;
  private final UnaryCallable<DeleteAccessLevelRequest, Operation> deleteAccessLevelCallable;
  private final OperationCallable<
          DeleteAccessLevelRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessLevelOperationCallable;
  private final UnaryCallable<ReplaceAccessLevelsRequest, Operation> replaceAccessLevelsCallable;
  private final OperationCallable<
          ReplaceAccessLevelsRequest,
          ReplaceAccessLevelsResponse,
          AccessContextManagerOperationMetadata>
      replaceAccessLevelsOperationCallable;
  private final UnaryCallable<ListServicePerimetersRequest, ListServicePerimetersResponse>
      listServicePerimetersCallable;
  private final UnaryCallable<ListServicePerimetersRequest, ListServicePerimetersPagedResponse>
      listServicePerimetersPagedCallable;
  private final UnaryCallable<GetServicePerimeterRequest, ServicePerimeter>
      getServicePerimeterCallable;
  private final UnaryCallable<CreateServicePerimeterRequest, Operation>
      createServicePerimeterCallable;
  private final OperationCallable<
          CreateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      createServicePerimeterOperationCallable;
  private final UnaryCallable<UpdateServicePerimeterRequest, Operation>
      updateServicePerimeterCallable;
  private final OperationCallable<
          UpdateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      updateServicePerimeterOperationCallable;
  private final UnaryCallable<DeleteServicePerimeterRequest, Operation>
      deleteServicePerimeterCallable;
  private final OperationCallable<
          DeleteServicePerimeterRequest, Empty, AccessContextManagerOperationMetadata>
      deleteServicePerimeterOperationCallable;
  private final UnaryCallable<ReplaceServicePerimetersRequest, Operation>
      replaceServicePerimetersCallable;
  private final OperationCallable<
          ReplaceServicePerimetersRequest,
          ReplaceServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      replaceServicePerimetersOperationCallable;
  private final UnaryCallable<CommitServicePerimetersRequest, Operation>
      commitServicePerimetersCallable;
  private final OperationCallable<
          CommitServicePerimetersRequest,
          CommitServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      commitServicePerimetersOperationCallable;
  private final UnaryCallable<ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsResponse>
      listGcpUserAccessBindingsCallable;
  private final UnaryCallable<
          ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsPagedResponse>
      listGcpUserAccessBindingsPagedCallable;
  private final UnaryCallable<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>
      getGcpUserAccessBindingCallable;
  private final UnaryCallable<CreateGcpUserAccessBindingRequest, Operation>
      createGcpUserAccessBindingCallable;
  private final OperationCallable<
          CreateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      createGcpUserAccessBindingOperationCallable;
  private final UnaryCallable<UpdateGcpUserAccessBindingRequest, Operation>
      updateGcpUserAccessBindingCallable;
  private final OperationCallable<
          UpdateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      updateGcpUserAccessBindingOperationCallable;
  private final UnaryCallable<DeleteGcpUserAccessBindingRequest, Operation>
      deleteGcpUserAccessBindingCallable;
  private final OperationCallable<
          DeleteGcpUserAccessBindingRequest, Empty, GcpUserAccessBindingOperationMetadata>
      deleteGcpUserAccessBindingOperationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAccessContextManagerStub create(
      AccessContextManagerStubSettings settings) throws IOException {
    return new HttpJsonAccessContextManagerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAccessContextManagerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAccessContextManagerStub(
        AccessContextManagerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAccessContextManagerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAccessContextManagerStub(
        AccessContextManagerStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAccessContextManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccessContextManagerStub(
      AccessContextManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAccessContextManagerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAccessContextManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccessContextManagerStub(
      AccessContextManagerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
        listAccessPoliciesTransportSettings =
            HttpJsonCallSettings.<ListAccessPoliciesRequest, ListAccessPoliciesResponse>newBuilder()
                .setMethodDescriptor(listAccessPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetAccessPolicyRequest, AccessPolicy> getAccessPolicyTransportSettings =
        HttpJsonCallSettings.<GetAccessPolicyRequest, AccessPolicy>newBuilder()
            .setMethodDescriptor(getAccessPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<AccessPolicy, Operation> createAccessPolicyTransportSettings =
        HttpJsonCallSettings.<AccessPolicy, Operation>newBuilder()
            .setMethodDescriptor(createAccessPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateAccessPolicyRequest, Operation> updateAccessPolicyTransportSettings =
        HttpJsonCallSettings.<UpdateAccessPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAccessPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteAccessPolicyRequest, Operation> deleteAccessPolicyTransportSettings =
        HttpJsonCallSettings.<DeleteAccessPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAccessPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListAccessLevelsRequest, ListAccessLevelsResponse>
        listAccessLevelsTransportSettings =
            HttpJsonCallSettings.<ListAccessLevelsRequest, ListAccessLevelsResponse>newBuilder()
                .setMethodDescriptor(listAccessLevelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetAccessLevelRequest, AccessLevel> getAccessLevelTransportSettings =
        HttpJsonCallSettings.<GetAccessLevelRequest, AccessLevel>newBuilder()
            .setMethodDescriptor(getAccessLevelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateAccessLevelRequest, Operation> createAccessLevelTransportSettings =
        HttpJsonCallSettings.<CreateAccessLevelRequest, Operation>newBuilder()
            .setMethodDescriptor(createAccessLevelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateAccessLevelRequest, Operation> updateAccessLevelTransportSettings =
        HttpJsonCallSettings.<UpdateAccessLevelRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAccessLevelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteAccessLevelRequest, Operation> deleteAccessLevelTransportSettings =
        HttpJsonCallSettings.<DeleteAccessLevelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAccessLevelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ReplaceAccessLevelsRequest, Operation>
        replaceAccessLevelsTransportSettings =
            HttpJsonCallSettings.<ReplaceAccessLevelsRequest, Operation>newBuilder()
                .setMethodDescriptor(replaceAccessLevelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListServicePerimetersRequest, ListServicePerimetersResponse>
        listServicePerimetersTransportSettings =
            HttpJsonCallSettings
                .<ListServicePerimetersRequest, ListServicePerimetersResponse>newBuilder()
                .setMethodDescriptor(listServicePerimetersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetServicePerimeterRequest, ServicePerimeter>
        getServicePerimeterTransportSettings =
            HttpJsonCallSettings.<GetServicePerimeterRequest, ServicePerimeter>newBuilder()
                .setMethodDescriptor(getServicePerimeterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateServicePerimeterRequest, Operation>
        createServicePerimeterTransportSettings =
            HttpJsonCallSettings.<CreateServicePerimeterRequest, Operation>newBuilder()
                .setMethodDescriptor(createServicePerimeterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateServicePerimeterRequest, Operation>
        updateServicePerimeterTransportSettings =
            HttpJsonCallSettings.<UpdateServicePerimeterRequest, Operation>newBuilder()
                .setMethodDescriptor(updateServicePerimeterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteServicePerimeterRequest, Operation>
        deleteServicePerimeterTransportSettings =
            HttpJsonCallSettings.<DeleteServicePerimeterRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteServicePerimeterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ReplaceServicePerimetersRequest, Operation>
        replaceServicePerimetersTransportSettings =
            HttpJsonCallSettings.<ReplaceServicePerimetersRequest, Operation>newBuilder()
                .setMethodDescriptor(replaceServicePerimetersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CommitServicePerimetersRequest, Operation>
        commitServicePerimetersTransportSettings =
            HttpJsonCallSettings.<CommitServicePerimetersRequest, Operation>newBuilder()
                .setMethodDescriptor(commitServicePerimetersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsResponse>
        listGcpUserAccessBindingsTransportSettings =
            HttpJsonCallSettings
                .<ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsResponse>newBuilder()
                .setMethodDescriptor(listGcpUserAccessBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>
        getGcpUserAccessBindingTransportSettings =
            HttpJsonCallSettings.<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>newBuilder()
                .setMethodDescriptor(getGcpUserAccessBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateGcpUserAccessBindingRequest, Operation>
        createGcpUserAccessBindingTransportSettings =
            HttpJsonCallSettings.<CreateGcpUserAccessBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(createGcpUserAccessBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateGcpUserAccessBindingRequest, Operation>
        updateGcpUserAccessBindingTransportSettings =
            HttpJsonCallSettings.<UpdateGcpUserAccessBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(updateGcpUserAccessBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteGcpUserAccessBindingRequest, Operation>
        deleteGcpUserAccessBindingTransportSettings =
            HttpJsonCallSettings.<DeleteGcpUserAccessBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGcpUserAccessBindingMethodDescriptor)
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

    this.listAccessPoliciesCallable =
        callableFactory.createUnaryCallable(
            listAccessPoliciesTransportSettings,
            settings.listAccessPoliciesSettings(),
            clientContext);
    this.listAccessPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listAccessPoliciesTransportSettings,
            settings.listAccessPoliciesSettings(),
            clientContext);
    this.getAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            getAccessPolicyTransportSettings, settings.getAccessPolicySettings(), clientContext);
    this.createAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            createAccessPolicyTransportSettings,
            settings.createAccessPolicySettings(),
            clientContext);
    this.createAccessPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createAccessPolicyTransportSettings,
            settings.createAccessPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            updateAccessPolicyTransportSettings,
            settings.updateAccessPolicySettings(),
            clientContext);
    this.updateAccessPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateAccessPolicyTransportSettings,
            settings.updateAccessPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteAccessPolicyTransportSettings,
            settings.deleteAccessPolicySettings(),
            clientContext);
    this.deleteAccessPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteAccessPolicyTransportSettings,
            settings.deleteAccessPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listAccessLevelsCallable =
        callableFactory.createUnaryCallable(
            listAccessLevelsTransportSettings, settings.listAccessLevelsSettings(), clientContext);
    this.listAccessLevelsPagedCallable =
        callableFactory.createPagedCallable(
            listAccessLevelsTransportSettings, settings.listAccessLevelsSettings(), clientContext);
    this.getAccessLevelCallable =
        callableFactory.createUnaryCallable(
            getAccessLevelTransportSettings, settings.getAccessLevelSettings(), clientContext);
    this.createAccessLevelCallable =
        callableFactory.createUnaryCallable(
            createAccessLevelTransportSettings,
            settings.createAccessLevelSettings(),
            clientContext);
    this.createAccessLevelOperationCallable =
        callableFactory.createOperationCallable(
            createAccessLevelTransportSettings,
            settings.createAccessLevelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateAccessLevelCallable =
        callableFactory.createUnaryCallable(
            updateAccessLevelTransportSettings,
            settings.updateAccessLevelSettings(),
            clientContext);
    this.updateAccessLevelOperationCallable =
        callableFactory.createOperationCallable(
            updateAccessLevelTransportSettings,
            settings.updateAccessLevelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteAccessLevelCallable =
        callableFactory.createUnaryCallable(
            deleteAccessLevelTransportSettings,
            settings.deleteAccessLevelSettings(),
            clientContext);
    this.deleteAccessLevelOperationCallable =
        callableFactory.createOperationCallable(
            deleteAccessLevelTransportSettings,
            settings.deleteAccessLevelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.replaceAccessLevelsCallable =
        callableFactory.createUnaryCallable(
            replaceAccessLevelsTransportSettings,
            settings.replaceAccessLevelsSettings(),
            clientContext);
    this.replaceAccessLevelsOperationCallable =
        callableFactory.createOperationCallable(
            replaceAccessLevelsTransportSettings,
            settings.replaceAccessLevelsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listServicePerimetersCallable =
        callableFactory.createUnaryCallable(
            listServicePerimetersTransportSettings,
            settings.listServicePerimetersSettings(),
            clientContext);
    this.listServicePerimetersPagedCallable =
        callableFactory.createPagedCallable(
            listServicePerimetersTransportSettings,
            settings.listServicePerimetersSettings(),
            clientContext);
    this.getServicePerimeterCallable =
        callableFactory.createUnaryCallable(
            getServicePerimeterTransportSettings,
            settings.getServicePerimeterSettings(),
            clientContext);
    this.createServicePerimeterCallable =
        callableFactory.createUnaryCallable(
            createServicePerimeterTransportSettings,
            settings.createServicePerimeterSettings(),
            clientContext);
    this.createServicePerimeterOperationCallable =
        callableFactory.createOperationCallable(
            createServicePerimeterTransportSettings,
            settings.createServicePerimeterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateServicePerimeterCallable =
        callableFactory.createUnaryCallable(
            updateServicePerimeterTransportSettings,
            settings.updateServicePerimeterSettings(),
            clientContext);
    this.updateServicePerimeterOperationCallable =
        callableFactory.createOperationCallable(
            updateServicePerimeterTransportSettings,
            settings.updateServicePerimeterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteServicePerimeterCallable =
        callableFactory.createUnaryCallable(
            deleteServicePerimeterTransportSettings,
            settings.deleteServicePerimeterSettings(),
            clientContext);
    this.deleteServicePerimeterOperationCallable =
        callableFactory.createOperationCallable(
            deleteServicePerimeterTransportSettings,
            settings.deleteServicePerimeterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.replaceServicePerimetersCallable =
        callableFactory.createUnaryCallable(
            replaceServicePerimetersTransportSettings,
            settings.replaceServicePerimetersSettings(),
            clientContext);
    this.replaceServicePerimetersOperationCallable =
        callableFactory.createOperationCallable(
            replaceServicePerimetersTransportSettings,
            settings.replaceServicePerimetersOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.commitServicePerimetersCallable =
        callableFactory.createUnaryCallable(
            commitServicePerimetersTransportSettings,
            settings.commitServicePerimetersSettings(),
            clientContext);
    this.commitServicePerimetersOperationCallable =
        callableFactory.createOperationCallable(
            commitServicePerimetersTransportSettings,
            settings.commitServicePerimetersOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listGcpUserAccessBindingsCallable =
        callableFactory.createUnaryCallable(
            listGcpUserAccessBindingsTransportSettings,
            settings.listGcpUserAccessBindingsSettings(),
            clientContext);
    this.listGcpUserAccessBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listGcpUserAccessBindingsTransportSettings,
            settings.listGcpUserAccessBindingsSettings(),
            clientContext);
    this.getGcpUserAccessBindingCallable =
        callableFactory.createUnaryCallable(
            getGcpUserAccessBindingTransportSettings,
            settings.getGcpUserAccessBindingSettings(),
            clientContext);
    this.createGcpUserAccessBindingCallable =
        callableFactory.createUnaryCallable(
            createGcpUserAccessBindingTransportSettings,
            settings.createGcpUserAccessBindingSettings(),
            clientContext);
    this.createGcpUserAccessBindingOperationCallable =
        callableFactory.createOperationCallable(
            createGcpUserAccessBindingTransportSettings,
            settings.createGcpUserAccessBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateGcpUserAccessBindingCallable =
        callableFactory.createUnaryCallable(
            updateGcpUserAccessBindingTransportSettings,
            settings.updateGcpUserAccessBindingSettings(),
            clientContext);
    this.updateGcpUserAccessBindingOperationCallable =
        callableFactory.createOperationCallable(
            updateGcpUserAccessBindingTransportSettings,
            settings.updateGcpUserAccessBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteGcpUserAccessBindingCallable =
        callableFactory.createUnaryCallable(
            deleteGcpUserAccessBindingTransportSettings,
            settings.deleteGcpUserAccessBindingSettings(),
            clientContext);
    this.deleteGcpUserAccessBindingOperationCallable =
        callableFactory.createOperationCallable(
            deleteGcpUserAccessBindingTransportSettings,
            settings.deleteGcpUserAccessBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    methodDescriptors.add(listAccessPoliciesMethodDescriptor);
    methodDescriptors.add(getAccessPolicyMethodDescriptor);
    methodDescriptors.add(createAccessPolicyMethodDescriptor);
    methodDescriptors.add(updateAccessPolicyMethodDescriptor);
    methodDescriptors.add(deleteAccessPolicyMethodDescriptor);
    methodDescriptors.add(listAccessLevelsMethodDescriptor);
    methodDescriptors.add(getAccessLevelMethodDescriptor);
    methodDescriptors.add(createAccessLevelMethodDescriptor);
    methodDescriptors.add(updateAccessLevelMethodDescriptor);
    methodDescriptors.add(deleteAccessLevelMethodDescriptor);
    methodDescriptors.add(replaceAccessLevelsMethodDescriptor);
    methodDescriptors.add(listServicePerimetersMethodDescriptor);
    methodDescriptors.add(getServicePerimeterMethodDescriptor);
    methodDescriptors.add(createServicePerimeterMethodDescriptor);
    methodDescriptors.add(updateServicePerimeterMethodDescriptor);
    methodDescriptors.add(deleteServicePerimeterMethodDescriptor);
    methodDescriptors.add(replaceServicePerimetersMethodDescriptor);
    methodDescriptors.add(commitServicePerimetersMethodDescriptor);
    methodDescriptors.add(listGcpUserAccessBindingsMethodDescriptor);
    methodDescriptors.add(getGcpUserAccessBindingMethodDescriptor);
    methodDescriptors.add(createGcpUserAccessBindingMethodDescriptor);
    methodDescriptors.add(updateGcpUserAccessBindingMethodDescriptor);
    methodDescriptors.add(deleteGcpUserAccessBindingMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
      listAccessPoliciesCallable() {
    return listAccessPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesPagedResponse>
      listAccessPoliciesPagedCallable() {
    return listAccessPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAccessPolicyRequest, AccessPolicy> getAccessPolicyCallable() {
    return getAccessPolicyCallable;
  }

  @Override
  public UnaryCallable<AccessPolicy, Operation> createAccessPolicyCallable() {
    return createAccessPolicyCallable;
  }

  @Override
  public OperationCallable<AccessPolicy, AccessPolicy, AccessContextManagerOperationMetadata>
      createAccessPolicyOperationCallable() {
    return createAccessPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAccessPolicyRequest, Operation> updateAccessPolicyCallable() {
    return updateAccessPolicyCallable;
  }

  @Override
  public OperationCallable<
          UpdateAccessPolicyRequest, AccessPolicy, AccessContextManagerOperationMetadata>
      updateAccessPolicyOperationCallable() {
    return updateAccessPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAccessPolicyRequest, Operation> deleteAccessPolicyCallable() {
    return deleteAccessPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteAccessPolicyRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessPolicyOperationCallable() {
    return deleteAccessPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListAccessLevelsRequest, ListAccessLevelsResponse>
      listAccessLevelsCallable() {
    return listAccessLevelsCallable;
  }

  @Override
  public UnaryCallable<ListAccessLevelsRequest, ListAccessLevelsPagedResponse>
      listAccessLevelsPagedCallable() {
    return listAccessLevelsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAccessLevelRequest, AccessLevel> getAccessLevelCallable() {
    return getAccessLevelCallable;
  }

  @Override
  public UnaryCallable<CreateAccessLevelRequest, Operation> createAccessLevelCallable() {
    return createAccessLevelCallable;
  }

  @Override
  public OperationCallable<
          CreateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      createAccessLevelOperationCallable() {
    return createAccessLevelOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAccessLevelRequest, Operation> updateAccessLevelCallable() {
    return updateAccessLevelCallable;
  }

  @Override
  public OperationCallable<
          UpdateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      updateAccessLevelOperationCallable() {
    return updateAccessLevelOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAccessLevelRequest, Operation> deleteAccessLevelCallable() {
    return deleteAccessLevelCallable;
  }

  @Override
  public OperationCallable<DeleteAccessLevelRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessLevelOperationCallable() {
    return deleteAccessLevelOperationCallable;
  }

  @Override
  public UnaryCallable<ReplaceAccessLevelsRequest, Operation> replaceAccessLevelsCallable() {
    return replaceAccessLevelsCallable;
  }

  @Override
  public OperationCallable<
          ReplaceAccessLevelsRequest,
          ReplaceAccessLevelsResponse,
          AccessContextManagerOperationMetadata>
      replaceAccessLevelsOperationCallable() {
    return replaceAccessLevelsOperationCallable;
  }

  @Override
  public UnaryCallable<ListServicePerimetersRequest, ListServicePerimetersResponse>
      listServicePerimetersCallable() {
    return listServicePerimetersCallable;
  }

  @Override
  public UnaryCallable<ListServicePerimetersRequest, ListServicePerimetersPagedResponse>
      listServicePerimetersPagedCallable() {
    return listServicePerimetersPagedCallable;
  }

  @Override
  public UnaryCallable<GetServicePerimeterRequest, ServicePerimeter> getServicePerimeterCallable() {
    return getServicePerimeterCallable;
  }

  @Override
  public UnaryCallable<CreateServicePerimeterRequest, Operation> createServicePerimeterCallable() {
    return createServicePerimeterCallable;
  }

  @Override
  public OperationCallable<
          CreateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      createServicePerimeterOperationCallable() {
    return createServicePerimeterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateServicePerimeterRequest, Operation> updateServicePerimeterCallable() {
    return updateServicePerimeterCallable;
  }

  @Override
  public OperationCallable<
          UpdateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      updateServicePerimeterOperationCallable() {
    return updateServicePerimeterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServicePerimeterRequest, Operation> deleteServicePerimeterCallable() {
    return deleteServicePerimeterCallable;
  }

  @Override
  public OperationCallable<
          DeleteServicePerimeterRequest, Empty, AccessContextManagerOperationMetadata>
      deleteServicePerimeterOperationCallable() {
    return deleteServicePerimeterOperationCallable;
  }

  @Override
  public UnaryCallable<ReplaceServicePerimetersRequest, Operation>
      replaceServicePerimetersCallable() {
    return replaceServicePerimetersCallable;
  }

  @Override
  public OperationCallable<
          ReplaceServicePerimetersRequest,
          ReplaceServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      replaceServicePerimetersOperationCallable() {
    return replaceServicePerimetersOperationCallable;
  }

  @Override
  public UnaryCallable<CommitServicePerimetersRequest, Operation>
      commitServicePerimetersCallable() {
    return commitServicePerimetersCallable;
  }

  @Override
  public OperationCallable<
          CommitServicePerimetersRequest,
          CommitServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      commitServicePerimetersOperationCallable() {
    return commitServicePerimetersOperationCallable;
  }

  @Override
  public UnaryCallable<ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsResponse>
      listGcpUserAccessBindingsCallable() {
    return listGcpUserAccessBindingsCallable;
  }

  @Override
  public UnaryCallable<ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsPagedResponse>
      listGcpUserAccessBindingsPagedCallable() {
    return listGcpUserAccessBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>
      getGcpUserAccessBindingCallable() {
    return getGcpUserAccessBindingCallable;
  }

  @Override
  public UnaryCallable<CreateGcpUserAccessBindingRequest, Operation>
      createGcpUserAccessBindingCallable() {
    return createGcpUserAccessBindingCallable;
  }

  @Override
  public OperationCallable<
          CreateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      createGcpUserAccessBindingOperationCallable() {
    return createGcpUserAccessBindingOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateGcpUserAccessBindingRequest, Operation>
      updateGcpUserAccessBindingCallable() {
    return updateGcpUserAccessBindingCallable;
  }

  @Override
  public OperationCallable<
          UpdateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      updateGcpUserAccessBindingOperationCallable() {
    return updateGcpUserAccessBindingOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGcpUserAccessBindingRequest, Operation>
      deleteGcpUserAccessBindingCallable() {
    return deleteGcpUserAccessBindingCallable;
  }

  @Override
  public OperationCallable<
          DeleteGcpUserAccessBindingRequest, Empty, GcpUserAccessBindingOperationMetadata>
      deleteGcpUserAccessBindingOperationCallable() {
    return deleteGcpUserAccessBindingOperationCallable;
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
