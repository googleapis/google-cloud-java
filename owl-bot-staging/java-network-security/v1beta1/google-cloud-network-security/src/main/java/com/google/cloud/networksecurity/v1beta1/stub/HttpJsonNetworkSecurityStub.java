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

package com.google.cloud.networksecurity.v1beta1.stub;

import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListAuthorizationPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListClientTlsPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListServerTlsPoliciesPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1beta1.AuthorizationPolicy;
import com.google.cloud.networksecurity.v1beta1.ClientTlsPolicy;
import com.google.cloud.networksecurity.v1beta1.CreateAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.CreateClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.CreateServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.DeleteAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.DeleteClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.DeleteServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.GetAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.GetClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.GetServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.ListAuthorizationPoliciesRequest;
import com.google.cloud.networksecurity.v1beta1.ListAuthorizationPoliciesResponse;
import com.google.cloud.networksecurity.v1beta1.ListClientTlsPoliciesRequest;
import com.google.cloud.networksecurity.v1beta1.ListClientTlsPoliciesResponse;
import com.google.cloud.networksecurity.v1beta1.ListServerTlsPoliciesRequest;
import com.google.cloud.networksecurity.v1beta1.ListServerTlsPoliciesResponse;
import com.google.cloud.networksecurity.v1beta1.OperationMetadata;
import com.google.cloud.networksecurity.v1beta1.ServerTlsPolicy;
import com.google.cloud.networksecurity.v1beta1.UpdateAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.UpdateClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.UpdateServerTlsPolicyRequest;
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
 * REST stub implementation for the NetworkSecurity service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonNetworkSecurityStub extends NetworkSecurityStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(ServerTlsPolicy.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(AuthorizationPolicy.getDescriptor())
          .add(ClientTlsPolicy.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
      listAuthorizationPoliciesMethodDescriptor =
          ApiMethodDescriptor
              .<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/ListAuthorizationPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAuthorizationPoliciesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/authorizationPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAuthorizationPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAuthorizationPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAuthorizationPoliciesResponse>newBuilder()
                      .setDefaultInstance(ListAuthorizationPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetAuthorizationPolicyRequest, AuthorizationPolicy>newBuilder()
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/GetAuthorizationPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAuthorizationPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/authorizationPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAuthorizationPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAuthorizationPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AuthorizationPolicy>newBuilder()
                      .setDefaultInstance(AuthorizationPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicyMethodDescriptor =
          ApiMethodDescriptor.<CreateAuthorizationPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/CreateAuthorizationPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAuthorizationPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/authorizationPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAuthorizationPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAuthorizationPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "authorizationPolicyId",
                                request.getAuthorizationPolicyId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "authorizationPolicy",
                                      request.getAuthorizationPolicy(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAuthorizationPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicyMethodDescriptor =
          ApiMethodDescriptor.<UpdateAuthorizationPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/UpdateAuthorizationPolicy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAuthorizationPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{authorizationPolicy.name=projects/*/locations/*/authorizationPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAuthorizationPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "authorizationPolicy.name",
                                request.getAuthorizationPolicy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAuthorizationPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "authorizationPolicy",
                                      request.getAuthorizationPolicy(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateAuthorizationPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicyMethodDescriptor =
          ApiMethodDescriptor.<DeleteAuthorizationPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/DeleteAuthorizationPolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAuthorizationPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/authorizationPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAuthorizationPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAuthorizationPolicyRequest> serializer =
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
                  (DeleteAuthorizationPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>
      listServerTlsPoliciesMethodDescriptor =
          ApiMethodDescriptor
              .<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/ListServerTlsPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServerTlsPoliciesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/serverTlsPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListServerTlsPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListServerTlsPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListServerTlsPoliciesResponse>newBuilder()
                      .setDefaultInstance(ListServerTlsPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetServerTlsPolicyRequest, ServerTlsPolicy>
      getServerTlsPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetServerTlsPolicyRequest, ServerTlsPolicy>newBuilder()
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/GetServerTlsPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetServerTlsPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/serverTlsPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetServerTlsPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetServerTlsPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ServerTlsPolicy>newBuilder()
                      .setDefaultInstance(ServerTlsPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateServerTlsPolicyRequest, Operation>
      createServerTlsPolicyMethodDescriptor =
          ApiMethodDescriptor.<CreateServerTlsPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/CreateServerTlsPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateServerTlsPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/serverTlsPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServerTlsPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServerTlsPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "serverTlsPolicyId", request.getServerTlsPolicyId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("serverTlsPolicy", request.getServerTlsPolicy(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateServerTlsPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateServerTlsPolicyRequest, Operation>
      updateServerTlsPolicyMethodDescriptor =
          ApiMethodDescriptor.<UpdateServerTlsPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/UpdateServerTlsPolicy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateServerTlsPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{serverTlsPolicy.name=projects/*/locations/*/serverTlsPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateServerTlsPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "serverTlsPolicy.name",
                                request.getServerTlsPolicy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateServerTlsPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("serverTlsPolicy", request.getServerTlsPolicy(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateServerTlsPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteServerTlsPolicyRequest, Operation>
      deleteServerTlsPolicyMethodDescriptor =
          ApiMethodDescriptor.<DeleteServerTlsPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/DeleteServerTlsPolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteServerTlsPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/serverTlsPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServerTlsPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServerTlsPolicyRequest> serializer =
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
                  (DeleteServerTlsPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>
      listClientTlsPoliciesMethodDescriptor =
          ApiMethodDescriptor
              .<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/ListClientTlsPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListClientTlsPoliciesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/clientTlsPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListClientTlsPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListClientTlsPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListClientTlsPoliciesResponse>newBuilder()
                      .setDefaultInstance(ListClientTlsPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetClientTlsPolicyRequest, ClientTlsPolicy>
      getClientTlsPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetClientTlsPolicyRequest, ClientTlsPolicy>newBuilder()
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/GetClientTlsPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetClientTlsPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/clientTlsPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetClientTlsPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetClientTlsPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ClientTlsPolicy>newBuilder()
                      .setDefaultInstance(ClientTlsPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateClientTlsPolicyRequest, Operation>
      createClientTlsPolicyMethodDescriptor =
          ApiMethodDescriptor.<CreateClientTlsPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/CreateClientTlsPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateClientTlsPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/clientTlsPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateClientTlsPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateClientTlsPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "clientTlsPolicyId", request.getClientTlsPolicyId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("clientTlsPolicy", request.getClientTlsPolicy(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateClientTlsPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateClientTlsPolicyRequest, Operation>
      updateClientTlsPolicyMethodDescriptor =
          ApiMethodDescriptor.<UpdateClientTlsPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/UpdateClientTlsPolicy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateClientTlsPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{clientTlsPolicy.name=projects/*/locations/*/clientTlsPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateClientTlsPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "clientTlsPolicy.name",
                                request.getClientTlsPolicy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateClientTlsPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("clientTlsPolicy", request.getClientTlsPolicy(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateClientTlsPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteClientTlsPolicyRequest, Operation>
      deleteClientTlsPolicyMethodDescriptor =
          ApiMethodDescriptor.<DeleteClientTlsPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/DeleteClientTlsPolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteClientTlsPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/clientTlsPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteClientTlsPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteClientTlsPolicyRequest> serializer =
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
                  (DeleteClientTlsPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
                          "/v1beta1/{resource=projects/*/locations/*/authorizationPolicies/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=projects/*/locations/*/serverTlsPolicies/*}:setIamPolicy",
                          "/v1beta1/{resource=projects/*/locations/*/clientTlsPolicies/*}:setIamPolicy")
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
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/*/authorizationPolicies/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=projects/*/locations/*/serverTlsPolicies/*}:getIamPolicy",
                          "/v1beta1/{resource=projects/*/locations/*/clientTlsPolicies/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
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
                          "/v1beta1/{resource=projects/*/locations/*/authorizationPolicies/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=projects/*/locations/*/serverTlsPolicies/*}:testIamPermissions",
                          "/v1beta1/{resource=projects/*/locations/*/clientTlsPolicies/*}:testIamPermissions")
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

  private final UnaryCallable<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
      listAuthorizationPoliciesCallable;
  private final UnaryCallable<
          ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesPagedResponse>
      listAuthorizationPoliciesPagedCallable;
  private final UnaryCallable<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicyCallable;
  private final UnaryCallable<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicyCallable;
  private final OperationCallable<
          CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyOperationCallable;
  private final UnaryCallable<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicyCallable;
  private final OperationCallable<
          UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      updateAuthorizationPolicyOperationCallable;
  private final UnaryCallable<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicyCallable;
  private final OperationCallable<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
      deleteAuthorizationPolicyOperationCallable;
  private final UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>
      listServerTlsPoliciesCallable;
  private final UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesPagedResponse>
      listServerTlsPoliciesPagedCallable;
  private final UnaryCallable<GetServerTlsPolicyRequest, ServerTlsPolicy>
      getServerTlsPolicyCallable;
  private final UnaryCallable<CreateServerTlsPolicyRequest, Operation>
      createServerTlsPolicyCallable;
  private final OperationCallable<CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      createServerTlsPolicyOperationCallable;
  private final UnaryCallable<UpdateServerTlsPolicyRequest, Operation>
      updateServerTlsPolicyCallable;
  private final OperationCallable<UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      updateServerTlsPolicyOperationCallable;
  private final UnaryCallable<DeleteServerTlsPolicyRequest, Operation>
      deleteServerTlsPolicyCallable;
  private final OperationCallable<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
      deleteServerTlsPolicyOperationCallable;
  private final UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>
      listClientTlsPoliciesCallable;
  private final UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesPagedResponse>
      listClientTlsPoliciesPagedCallable;
  private final UnaryCallable<GetClientTlsPolicyRequest, ClientTlsPolicy>
      getClientTlsPolicyCallable;
  private final UnaryCallable<CreateClientTlsPolicyRequest, Operation>
      createClientTlsPolicyCallable;
  private final OperationCallable<CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      createClientTlsPolicyOperationCallable;
  private final UnaryCallable<UpdateClientTlsPolicyRequest, Operation>
      updateClientTlsPolicyCallable;
  private final OperationCallable<UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      updateClientTlsPolicyOperationCallable;
  private final UnaryCallable<DeleteClientTlsPolicyRequest, Operation>
      deleteClientTlsPolicyCallable;
  private final OperationCallable<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
      deleteClientTlsPolicyOperationCallable;
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

  public static final HttpJsonNetworkSecurityStub create(NetworkSecurityStubSettings settings)
      throws IOException {
    return new HttpJsonNetworkSecurityStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNetworkSecurityStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonNetworkSecurityStub(
        NetworkSecurityStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonNetworkSecurityStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNetworkSecurityStub(
        NetworkSecurityStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNetworkSecurityStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNetworkSecurityStub(
      NetworkSecurityStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonNetworkSecurityCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNetworkSecurityStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNetworkSecurityStub(
      NetworkSecurityStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
        listAuthorizationPoliciesTransportSettings =
            HttpJsonCallSettings
                .<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>newBuilder()
                .setMethodDescriptor(listAuthorizationPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetAuthorizationPolicyRequest, AuthorizationPolicy>
        getAuthorizationPolicyTransportSettings =
            HttpJsonCallSettings.<GetAuthorizationPolicyRequest, AuthorizationPolicy>newBuilder()
                .setMethodDescriptor(getAuthorizationPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateAuthorizationPolicyRequest, Operation>
        createAuthorizationPolicyTransportSettings =
            HttpJsonCallSettings.<CreateAuthorizationPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createAuthorizationPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateAuthorizationPolicyRequest, Operation>
        updateAuthorizationPolicyTransportSettings =
            HttpJsonCallSettings.<UpdateAuthorizationPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateAuthorizationPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteAuthorizationPolicyRequest, Operation>
        deleteAuthorizationPolicyTransportSettings =
            HttpJsonCallSettings.<DeleteAuthorizationPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteAuthorizationPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>
        listServerTlsPoliciesTransportSettings =
            HttpJsonCallSettings
                .<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>newBuilder()
                .setMethodDescriptor(listServerTlsPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetServerTlsPolicyRequest, ServerTlsPolicy>
        getServerTlsPolicyTransportSettings =
            HttpJsonCallSettings.<GetServerTlsPolicyRequest, ServerTlsPolicy>newBuilder()
                .setMethodDescriptor(getServerTlsPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateServerTlsPolicyRequest, Operation>
        createServerTlsPolicyTransportSettings =
            HttpJsonCallSettings.<CreateServerTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createServerTlsPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateServerTlsPolicyRequest, Operation>
        updateServerTlsPolicyTransportSettings =
            HttpJsonCallSettings.<UpdateServerTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateServerTlsPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteServerTlsPolicyRequest, Operation>
        deleteServerTlsPolicyTransportSettings =
            HttpJsonCallSettings.<DeleteServerTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteServerTlsPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>
        listClientTlsPoliciesTransportSettings =
            HttpJsonCallSettings
                .<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>newBuilder()
                .setMethodDescriptor(listClientTlsPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetClientTlsPolicyRequest, ClientTlsPolicy>
        getClientTlsPolicyTransportSettings =
            HttpJsonCallSettings.<GetClientTlsPolicyRequest, ClientTlsPolicy>newBuilder()
                .setMethodDescriptor(getClientTlsPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateClientTlsPolicyRequest, Operation>
        createClientTlsPolicyTransportSettings =
            HttpJsonCallSettings.<CreateClientTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createClientTlsPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateClientTlsPolicyRequest, Operation>
        updateClientTlsPolicyTransportSettings =
            HttpJsonCallSettings.<UpdateClientTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateClientTlsPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteClientTlsPolicyRequest, Operation>
        deleteClientTlsPolicyTransportSettings =
            HttpJsonCallSettings.<DeleteClientTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteClientTlsPolicyMethodDescriptor)
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

    this.listAuthorizationPoliciesCallable =
        callableFactory.createUnaryCallable(
            listAuthorizationPoliciesTransportSettings,
            settings.listAuthorizationPoliciesSettings(),
            clientContext);
    this.listAuthorizationPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listAuthorizationPoliciesTransportSettings,
            settings.listAuthorizationPoliciesSettings(),
            clientContext);
    this.getAuthorizationPolicyCallable =
        callableFactory.createUnaryCallable(
            getAuthorizationPolicyTransportSettings,
            settings.getAuthorizationPolicySettings(),
            clientContext);
    this.createAuthorizationPolicyCallable =
        callableFactory.createUnaryCallable(
            createAuthorizationPolicyTransportSettings,
            settings.createAuthorizationPolicySettings(),
            clientContext);
    this.createAuthorizationPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createAuthorizationPolicyTransportSettings,
            settings.createAuthorizationPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateAuthorizationPolicyCallable =
        callableFactory.createUnaryCallable(
            updateAuthorizationPolicyTransportSettings,
            settings.updateAuthorizationPolicySettings(),
            clientContext);
    this.updateAuthorizationPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateAuthorizationPolicyTransportSettings,
            settings.updateAuthorizationPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteAuthorizationPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteAuthorizationPolicyTransportSettings,
            settings.deleteAuthorizationPolicySettings(),
            clientContext);
    this.deleteAuthorizationPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteAuthorizationPolicyTransportSettings,
            settings.deleteAuthorizationPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listServerTlsPoliciesCallable =
        callableFactory.createUnaryCallable(
            listServerTlsPoliciesTransportSettings,
            settings.listServerTlsPoliciesSettings(),
            clientContext);
    this.listServerTlsPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listServerTlsPoliciesTransportSettings,
            settings.listServerTlsPoliciesSettings(),
            clientContext);
    this.getServerTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            getServerTlsPolicyTransportSettings,
            settings.getServerTlsPolicySettings(),
            clientContext);
    this.createServerTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            createServerTlsPolicyTransportSettings,
            settings.createServerTlsPolicySettings(),
            clientContext);
    this.createServerTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createServerTlsPolicyTransportSettings,
            settings.createServerTlsPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateServerTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            updateServerTlsPolicyTransportSettings,
            settings.updateServerTlsPolicySettings(),
            clientContext);
    this.updateServerTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateServerTlsPolicyTransportSettings,
            settings.updateServerTlsPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteServerTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteServerTlsPolicyTransportSettings,
            settings.deleteServerTlsPolicySettings(),
            clientContext);
    this.deleteServerTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteServerTlsPolicyTransportSettings,
            settings.deleteServerTlsPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listClientTlsPoliciesCallable =
        callableFactory.createUnaryCallable(
            listClientTlsPoliciesTransportSettings,
            settings.listClientTlsPoliciesSettings(),
            clientContext);
    this.listClientTlsPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listClientTlsPoliciesTransportSettings,
            settings.listClientTlsPoliciesSettings(),
            clientContext);
    this.getClientTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            getClientTlsPolicyTransportSettings,
            settings.getClientTlsPolicySettings(),
            clientContext);
    this.createClientTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            createClientTlsPolicyTransportSettings,
            settings.createClientTlsPolicySettings(),
            clientContext);
    this.createClientTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createClientTlsPolicyTransportSettings,
            settings.createClientTlsPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateClientTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            updateClientTlsPolicyTransportSettings,
            settings.updateClientTlsPolicySettings(),
            clientContext);
    this.updateClientTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateClientTlsPolicyTransportSettings,
            settings.updateClientTlsPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteClientTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteClientTlsPolicyTransportSettings,
            settings.deleteClientTlsPolicySettings(),
            clientContext);
    this.deleteClientTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteClientTlsPolicyTransportSettings,
            settings.deleteClientTlsPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    methodDescriptors.add(listAuthorizationPoliciesMethodDescriptor);
    methodDescriptors.add(getAuthorizationPolicyMethodDescriptor);
    methodDescriptors.add(createAuthorizationPolicyMethodDescriptor);
    methodDescriptors.add(updateAuthorizationPolicyMethodDescriptor);
    methodDescriptors.add(deleteAuthorizationPolicyMethodDescriptor);
    methodDescriptors.add(listServerTlsPoliciesMethodDescriptor);
    methodDescriptors.add(getServerTlsPolicyMethodDescriptor);
    methodDescriptors.add(createServerTlsPolicyMethodDescriptor);
    methodDescriptors.add(updateServerTlsPolicyMethodDescriptor);
    methodDescriptors.add(deleteServerTlsPolicyMethodDescriptor);
    methodDescriptors.add(listClientTlsPoliciesMethodDescriptor);
    methodDescriptors.add(getClientTlsPolicyMethodDescriptor);
    methodDescriptors.add(createClientTlsPolicyMethodDescriptor);
    methodDescriptors.add(updateClientTlsPolicyMethodDescriptor);
    methodDescriptors.add(deleteClientTlsPolicyMethodDescriptor);
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
  public UnaryCallable<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
      listAuthorizationPoliciesCallable() {
    return listAuthorizationPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesPagedResponse>
      listAuthorizationPoliciesPagedCallable() {
    return listAuthorizationPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicyCallable() {
    return getAuthorizationPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicyCallable() {
    return createAuthorizationPolicyCallable;
  }

  @Override
  public OperationCallable<CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyOperationCallable() {
    return createAuthorizationPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicyCallable() {
    return updateAuthorizationPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      updateAuthorizationPolicyOperationCallable() {
    return updateAuthorizationPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicyCallable() {
    return deleteAuthorizationPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
      deleteAuthorizationPolicyOperationCallable() {
    return deleteAuthorizationPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>
      listServerTlsPoliciesCallable() {
    return listServerTlsPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesPagedResponse>
      listServerTlsPoliciesPagedCallable() {
    return listServerTlsPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetServerTlsPolicyRequest, ServerTlsPolicy> getServerTlsPolicyCallable() {
    return getServerTlsPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateServerTlsPolicyRequest, Operation> createServerTlsPolicyCallable() {
    return createServerTlsPolicyCallable;
  }

  @Override
  public OperationCallable<CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      createServerTlsPolicyOperationCallable() {
    return createServerTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateServerTlsPolicyRequest, Operation> updateServerTlsPolicyCallable() {
    return updateServerTlsPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      updateServerTlsPolicyOperationCallable() {
    return updateServerTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServerTlsPolicyRequest, Operation> deleteServerTlsPolicyCallable() {
    return deleteServerTlsPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
      deleteServerTlsPolicyOperationCallable() {
    return deleteServerTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>
      listClientTlsPoliciesCallable() {
    return listClientTlsPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesPagedResponse>
      listClientTlsPoliciesPagedCallable() {
    return listClientTlsPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetClientTlsPolicyRequest, ClientTlsPolicy> getClientTlsPolicyCallable() {
    return getClientTlsPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateClientTlsPolicyRequest, Operation> createClientTlsPolicyCallable() {
    return createClientTlsPolicyCallable;
  }

  @Override
  public OperationCallable<CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      createClientTlsPolicyOperationCallable() {
    return createClientTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateClientTlsPolicyRequest, Operation> updateClientTlsPolicyCallable() {
    return updateClientTlsPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      updateClientTlsPolicyOperationCallable() {
    return updateClientTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteClientTlsPolicyRequest, Operation> deleteClientTlsPolicyCallable() {
    return deleteClientTlsPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
      deleteClientTlsPolicyOperationCallable() {
    return deleteClientTlsPolicyOperationCallable;
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
