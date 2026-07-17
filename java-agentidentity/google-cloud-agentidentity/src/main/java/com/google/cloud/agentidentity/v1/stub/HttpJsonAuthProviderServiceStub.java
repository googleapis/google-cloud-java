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

package com.google.cloud.agentidentity.v1.stub;

import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListAccessSummariesPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListAuthProvidersPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListAuthorizationsPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.QueryAuthProvidersPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.QueryWorkloadsPagedResponse;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.agentidentity.v1.AccessSummary;
import com.google.cloud.agentidentity.v1.AuthProvider;
import com.google.cloud.agentidentity.v1.Authorization;
import com.google.cloud.agentidentity.v1.CreateAuthProviderRequest;
import com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest;
import com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest;
import com.google.cloud.agentidentity.v1.DisableAuthProviderRequest;
import com.google.cloud.agentidentity.v1.EnableAuthProviderRequest;
import com.google.cloud.agentidentity.v1.GetAccessSummaryRequest;
import com.google.cloud.agentidentity.v1.GetAuthProviderRequest;
import com.google.cloud.agentidentity.v1.GetAuthorizationRequest;
import com.google.cloud.agentidentity.v1.ListAccessSummariesRequest;
import com.google.cloud.agentidentity.v1.ListAccessSummariesResponse;
import com.google.cloud.agentidentity.v1.ListAuthProvidersRequest;
import com.google.cloud.agentidentity.v1.ListAuthProvidersResponse;
import com.google.cloud.agentidentity.v1.ListAuthorizationsRequest;
import com.google.cloud.agentidentity.v1.ListAuthorizationsResponse;
import com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest;
import com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse;
import com.google.cloud.agentidentity.v1.QueryWorkloadsRequest;
import com.google.cloud.agentidentity.v1.QueryWorkloadsResponse;
import com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest;
import com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse;
import com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest;
import com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AuthProviderService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonAuthProviderServiceStub extends AuthProviderServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListAuthProvidersRequest, ListAuthProvidersResponse>
      listAuthProvidersMethodDescriptor =
          ApiMethodDescriptor.<ListAuthProvidersRequest, ListAuthProvidersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/ListAuthProviders")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAuthProvidersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/authProviders",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAuthProvidersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAuthProvidersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAuthProvidersResponse>newBuilder()
                      .setDefaultInstance(ListAuthProvidersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAuthProviderRequest, AuthProvider>
      getAuthProviderMethodDescriptor =
          ApiMethodDescriptor.<GetAuthProviderRequest, AuthProvider>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/GetAuthProvider")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAuthProviderRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/authProviders/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAuthProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAuthProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AuthProvider>newBuilder()
                      .setDefaultInstance(AuthProvider.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAuthProviderRequest, AuthProvider>
      createAuthProviderMethodDescriptor =
          ApiMethodDescriptor.<CreateAuthProviderRequest, AuthProvider>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/CreateAuthProvider")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAuthProviderRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/authProviders",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAuthProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAuthProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "authProviderId", request.getAuthProviderId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("authProvider", request.getAuthProvider(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AuthProvider>newBuilder()
                      .setDefaultInstance(AuthProvider.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAuthProviderRequest, AuthProvider>
      updateAuthProviderMethodDescriptor =
          ApiMethodDescriptor.<UpdateAuthProviderRequest, AuthProvider>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/UpdateAuthProvider")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAuthProviderRequest>newBuilder()
                      .setPath(
                          "/v1/{authProvider.name=projects/*/locations/*/authProviders/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAuthProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "authProvider.name", request.getAuthProvider().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAuthProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("authProvider", request.getAuthProvider(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AuthProvider>newBuilder()
                      .setDefaultInstance(AuthProvider.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAuthProviderRequest, Empty>
      deleteAuthProviderMethodDescriptor =
          ApiMethodDescriptor.<DeleteAuthProviderRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/DeleteAuthProvider")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAuthProviderRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/authProviders/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAuthProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAuthProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UndeleteAuthProviderRequest, AuthProvider>
      undeleteAuthProviderMethodDescriptor =
          ApiMethodDescriptor.<UndeleteAuthProviderRequest, AuthProvider>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/UndeleteAuthProvider")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeleteAuthProviderRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/authProviders/*}:undelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteAuthProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteAuthProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AuthProvider>newBuilder()
                      .setDefaultInstance(AuthProvider.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<QueryAuthProvidersRequest, QueryAuthProvidersResponse>
      queryAuthProvidersMethodDescriptor =
          ApiMethodDescriptor.<QueryAuthProvidersRequest, QueryAuthProvidersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/QueryAuthProviders")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryAuthProvidersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/authProviders:query",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryAuthProvidersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryAuthProvidersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "workloadId", request.getWorkloadId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QueryAuthProvidersResponse>newBuilder()
                      .setDefaultInstance(QueryAuthProvidersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<QueryWorkloadsRequest, QueryWorkloadsResponse>
      queryWorkloadsMethodDescriptor =
          ApiMethodDescriptor.<QueryWorkloadsRequest, QueryWorkloadsResponse>newBuilder()
              .setFullMethodName("google.cloud.agentidentity.v1.AuthProviderService/QueryWorkloads")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryWorkloadsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/authProviders/*}:queryWorkloads",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryWorkloadsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryWorkloadsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QueryWorkloadsResponse>newBuilder()
                      .setDefaultInstance(QueryWorkloadsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAuthorizationsRequest, ListAuthorizationsResponse>
      listAuthorizationsMethodDescriptor =
          ApiMethodDescriptor.<ListAuthorizationsRequest, ListAuthorizationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/ListAuthorizations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAuthorizationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/authProviders/*}/authorizations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAuthorizationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAuthorizationsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAuthorizationsResponse>newBuilder()
                      .setDefaultInstance(ListAuthorizationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAuthorizationRequest, Authorization>
      getAuthorizationMethodDescriptor =
          ApiMethodDescriptor.<GetAuthorizationRequest, Authorization>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/GetAuthorization")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAuthorizationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/authProviders/*/authorizations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAuthorizationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAuthorizationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Authorization>newBuilder()
                      .setDefaultInstance(Authorization.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAuthorizationRequest, Empty>
      deleteAuthorizationMethodDescriptor =
          ApiMethodDescriptor.<DeleteAuthorizationRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/DeleteAuthorization")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAuthorizationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/authProviders/*/authorizations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAuthorizationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAuthorizationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAccessSummariesRequest, ListAccessSummariesResponse>
      listAccessSummariesMethodDescriptor =
          ApiMethodDescriptor.<ListAccessSummariesRequest, ListAccessSummariesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/ListAccessSummaries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccessSummariesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/accessSummaries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccessSummariesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccessSummariesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAccessSummariesResponse>newBuilder()
                      .setDefaultInstance(ListAccessSummariesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAccessSummaryRequest, AccessSummary>
      getAccessSummaryMethodDescriptor =
          ApiMethodDescriptor.<GetAccessSummaryRequest, AccessSummary>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/GetAccessSummary")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAccessSummaryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/accessSummaries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccessSummaryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccessSummaryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccessSummary>newBuilder()
                      .setDefaultInstance(AccessSummary.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
      revokeAuthorizationMethodDescriptor =
          ApiMethodDescriptor.<RevokeAuthorizationRequest, RevokeAuthorizationResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/RevokeAuthorization")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RevokeAuthorizationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/authProviders/*}:revokeAuthorization",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RevokeAuthorizationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RevokeAuthorizationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RevokeAuthorizationResponse>newBuilder()
                      .setDefaultInstance(RevokeAuthorizationResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<EnableAuthProviderRequest, AuthProvider>
      enableAuthProviderMethodDescriptor =
          ApiMethodDescriptor.<EnableAuthProviderRequest, AuthProvider>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/EnableAuthProvider")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnableAuthProviderRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/authProviders/*}:enable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EnableAuthProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EnableAuthProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AuthProvider>newBuilder()
                      .setDefaultInstance(AuthProvider.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DisableAuthProviderRequest, AuthProvider>
      disableAuthProviderMethodDescriptor =
          ApiMethodDescriptor.<DisableAuthProviderRequest, AuthProvider>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/DisableAuthProvider")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DisableAuthProviderRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/authProviders/*}:disable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DisableAuthProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DisableAuthProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AuthProvider>newBuilder()
                      .setDefaultInstance(AuthProvider.getDefaultInstance())
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
                          "/v1/{name=projects/*}/locations",
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
                          "/v1/{name=projects/*/locations/*}",
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
                          "/v1/{resource=projects/*/locations/*/authProviders/*}:setIamPolicy",
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
                          "/v1/{resource=projects/*/locations/*/authProviders/*}:getIamPolicy",
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
                          "/v1/{resource=projects/*/locations/*/authProviders/*}:testIamPermissions",
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

  private final UnaryCallable<ListAuthProvidersRequest, ListAuthProvidersResponse>
      listAuthProvidersCallable;
  private final UnaryCallable<ListAuthProvidersRequest, ListAuthProvidersPagedResponse>
      listAuthProvidersPagedCallable;
  private final UnaryCallable<GetAuthProviderRequest, AuthProvider> getAuthProviderCallable;
  private final UnaryCallable<CreateAuthProviderRequest, AuthProvider> createAuthProviderCallable;
  private final UnaryCallable<UpdateAuthProviderRequest, AuthProvider> updateAuthProviderCallable;
  private final UnaryCallable<DeleteAuthProviderRequest, Empty> deleteAuthProviderCallable;
  private final UnaryCallable<UndeleteAuthProviderRequest, AuthProvider>
      undeleteAuthProviderCallable;
  private final UnaryCallable<QueryAuthProvidersRequest, QueryAuthProvidersResponse>
      queryAuthProvidersCallable;
  private final UnaryCallable<QueryAuthProvidersRequest, QueryAuthProvidersPagedResponse>
      queryAuthProvidersPagedCallable;
  private final UnaryCallable<QueryWorkloadsRequest, QueryWorkloadsResponse> queryWorkloadsCallable;
  private final UnaryCallable<QueryWorkloadsRequest, QueryWorkloadsPagedResponse>
      queryWorkloadsPagedCallable;
  private final UnaryCallable<ListAuthorizationsRequest, ListAuthorizationsResponse>
      listAuthorizationsCallable;
  private final UnaryCallable<ListAuthorizationsRequest, ListAuthorizationsPagedResponse>
      listAuthorizationsPagedCallable;
  private final UnaryCallable<GetAuthorizationRequest, Authorization> getAuthorizationCallable;
  private final UnaryCallable<DeleteAuthorizationRequest, Empty> deleteAuthorizationCallable;
  private final UnaryCallable<ListAccessSummariesRequest, ListAccessSummariesResponse>
      listAccessSummariesCallable;
  private final UnaryCallable<ListAccessSummariesRequest, ListAccessSummariesPagedResponse>
      listAccessSummariesPagedCallable;
  private final UnaryCallable<GetAccessSummaryRequest, AccessSummary> getAccessSummaryCallable;
  private final UnaryCallable<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
      revokeAuthorizationCallable;
  private final UnaryCallable<EnableAuthProviderRequest, AuthProvider> enableAuthProviderCallable;
  private final UnaryCallable<DisableAuthProviderRequest, AuthProvider> disableAuthProviderCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAuthProviderServiceStub create(
      AuthProviderServiceStubSettings settings) throws IOException {
    return new HttpJsonAuthProviderServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAuthProviderServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAuthProviderServiceStub(
        AuthProviderServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAuthProviderServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAuthProviderServiceStub(
        AuthProviderServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAuthProviderServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAuthProviderServiceStub(
      AuthProviderServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAuthProviderServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAuthProviderServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAuthProviderServiceStub(
      AuthProviderServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListAuthProvidersRequest, ListAuthProvidersResponse>
        listAuthProvidersTransportSettings =
            HttpJsonCallSettings.<ListAuthProvidersRequest, ListAuthProvidersResponse>newBuilder()
                .setMethodDescriptor(listAuthProvidersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetAuthProviderRequest, AuthProvider> getAuthProviderTransportSettings =
        HttpJsonCallSettings.<GetAuthProviderRequest, AuthProvider>newBuilder()
            .setMethodDescriptor(getAuthProviderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<CreateAuthProviderRequest, AuthProvider>
        createAuthProviderTransportSettings =
            HttpJsonCallSettings.<CreateAuthProviderRequest, AuthProvider>newBuilder()
                .setMethodDescriptor(createAuthProviderMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateAuthProviderRequest, AuthProvider>
        updateAuthProviderTransportSettings =
            HttpJsonCallSettings.<UpdateAuthProviderRequest, AuthProvider>newBuilder()
                .setMethodDescriptor(updateAuthProviderMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "auth_provider.name",
                          String.valueOf(request.getAuthProvider().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteAuthProviderRequest, Empty> deleteAuthProviderTransportSettings =
        HttpJsonCallSettings.<DeleteAuthProviderRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAuthProviderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<UndeleteAuthProviderRequest, AuthProvider>
        undeleteAuthProviderTransportSettings =
            HttpJsonCallSettings.<UndeleteAuthProviderRequest, AuthProvider>newBuilder()
                .setMethodDescriptor(undeleteAuthProviderMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<QueryAuthProvidersRequest, QueryAuthProvidersResponse>
        queryAuthProvidersTransportSettings =
            HttpJsonCallSettings.<QueryAuthProvidersRequest, QueryAuthProvidersResponse>newBuilder()
                .setMethodDescriptor(queryAuthProvidersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<QueryWorkloadsRequest, QueryWorkloadsResponse>
        queryWorkloadsTransportSettings =
            HttpJsonCallSettings.<QueryWorkloadsRequest, QueryWorkloadsResponse>newBuilder()
                .setMethodDescriptor(queryWorkloadsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListAuthorizationsRequest, ListAuthorizationsResponse>
        listAuthorizationsTransportSettings =
            HttpJsonCallSettings.<ListAuthorizationsRequest, ListAuthorizationsResponse>newBuilder()
                .setMethodDescriptor(listAuthorizationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetAuthorizationRequest, Authorization> getAuthorizationTransportSettings =
        HttpJsonCallSettings.<GetAuthorizationRequest, Authorization>newBuilder()
            .setMethodDescriptor(getAuthorizationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<DeleteAuthorizationRequest, Empty> deleteAuthorizationTransportSettings =
        HttpJsonCallSettings.<DeleteAuthorizationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAuthorizationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListAccessSummariesRequest, ListAccessSummariesResponse>
        listAccessSummariesTransportSettings =
            HttpJsonCallSettings
                .<ListAccessSummariesRequest, ListAccessSummariesResponse>newBuilder()
                .setMethodDescriptor(listAccessSummariesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetAccessSummaryRequest, AccessSummary> getAccessSummaryTransportSettings =
        HttpJsonCallSettings.<GetAccessSummaryRequest, AccessSummary>newBuilder()
            .setMethodDescriptor(getAccessSummaryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
        revokeAuthorizationTransportSettings =
            HttpJsonCallSettings
                .<RevokeAuthorizationRequest, RevokeAuthorizationResponse>newBuilder()
                .setMethodDescriptor(revokeAuthorizationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<EnableAuthProviderRequest, AuthProvider>
        enableAuthProviderTransportSettings =
            HttpJsonCallSettings.<EnableAuthProviderRequest, AuthProvider>newBuilder()
                .setMethodDescriptor(enableAuthProviderMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<DisableAuthProviderRequest, AuthProvider>
        disableAuthProviderTransportSettings =
            HttpJsonCallSettings.<DisableAuthProviderRequest, AuthProvider>newBuilder()
                .setMethodDescriptor(disableAuthProviderMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getResource())
                .build();

    this.listAuthProvidersCallable =
        callableFactory.createUnaryCallable(
            listAuthProvidersTransportSettings,
            settings.listAuthProvidersSettings(),
            clientContext);
    this.listAuthProvidersPagedCallable =
        callableFactory.createPagedCallable(
            listAuthProvidersTransportSettings,
            settings.listAuthProvidersSettings(),
            clientContext);
    this.getAuthProviderCallable =
        callableFactory.createUnaryCallable(
            getAuthProviderTransportSettings, settings.getAuthProviderSettings(), clientContext);
    this.createAuthProviderCallable =
        callableFactory.createUnaryCallable(
            createAuthProviderTransportSettings,
            settings.createAuthProviderSettings(),
            clientContext);
    this.updateAuthProviderCallable =
        callableFactory.createUnaryCallable(
            updateAuthProviderTransportSettings,
            settings.updateAuthProviderSettings(),
            clientContext);
    this.deleteAuthProviderCallable =
        callableFactory.createUnaryCallable(
            deleteAuthProviderTransportSettings,
            settings.deleteAuthProviderSettings(),
            clientContext);
    this.undeleteAuthProviderCallable =
        callableFactory.createUnaryCallable(
            undeleteAuthProviderTransportSettings,
            settings.undeleteAuthProviderSettings(),
            clientContext);
    this.queryAuthProvidersCallable =
        callableFactory.createUnaryCallable(
            queryAuthProvidersTransportSettings,
            settings.queryAuthProvidersSettings(),
            clientContext);
    this.queryAuthProvidersPagedCallable =
        callableFactory.createPagedCallable(
            queryAuthProvidersTransportSettings,
            settings.queryAuthProvidersSettings(),
            clientContext);
    this.queryWorkloadsCallable =
        callableFactory.createUnaryCallable(
            queryWorkloadsTransportSettings, settings.queryWorkloadsSettings(), clientContext);
    this.queryWorkloadsPagedCallable =
        callableFactory.createPagedCallable(
            queryWorkloadsTransportSettings, settings.queryWorkloadsSettings(), clientContext);
    this.listAuthorizationsCallable =
        callableFactory.createUnaryCallable(
            listAuthorizationsTransportSettings,
            settings.listAuthorizationsSettings(),
            clientContext);
    this.listAuthorizationsPagedCallable =
        callableFactory.createPagedCallable(
            listAuthorizationsTransportSettings,
            settings.listAuthorizationsSettings(),
            clientContext);
    this.getAuthorizationCallable =
        callableFactory.createUnaryCallable(
            getAuthorizationTransportSettings, settings.getAuthorizationSettings(), clientContext);
    this.deleteAuthorizationCallable =
        callableFactory.createUnaryCallable(
            deleteAuthorizationTransportSettings,
            settings.deleteAuthorizationSettings(),
            clientContext);
    this.listAccessSummariesCallable =
        callableFactory.createUnaryCallable(
            listAccessSummariesTransportSettings,
            settings.listAccessSummariesSettings(),
            clientContext);
    this.listAccessSummariesPagedCallable =
        callableFactory.createPagedCallable(
            listAccessSummariesTransportSettings,
            settings.listAccessSummariesSettings(),
            clientContext);
    this.getAccessSummaryCallable =
        callableFactory.createUnaryCallable(
            getAccessSummaryTransportSettings, settings.getAccessSummarySettings(), clientContext);
    this.revokeAuthorizationCallable =
        callableFactory.createUnaryCallable(
            revokeAuthorizationTransportSettings,
            settings.revokeAuthorizationSettings(),
            clientContext);
    this.enableAuthProviderCallable =
        callableFactory.createUnaryCallable(
            enableAuthProviderTransportSettings,
            settings.enableAuthProviderSettings(),
            clientContext);
    this.disableAuthProviderCallable =
        callableFactory.createUnaryCallable(
            disableAuthProviderTransportSettings,
            settings.disableAuthProviderSettings(),
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
    methodDescriptors.add(listAuthProvidersMethodDescriptor);
    methodDescriptors.add(getAuthProviderMethodDescriptor);
    methodDescriptors.add(createAuthProviderMethodDescriptor);
    methodDescriptors.add(updateAuthProviderMethodDescriptor);
    methodDescriptors.add(deleteAuthProviderMethodDescriptor);
    methodDescriptors.add(undeleteAuthProviderMethodDescriptor);
    methodDescriptors.add(queryAuthProvidersMethodDescriptor);
    methodDescriptors.add(queryWorkloadsMethodDescriptor);
    methodDescriptors.add(listAuthorizationsMethodDescriptor);
    methodDescriptors.add(getAuthorizationMethodDescriptor);
    methodDescriptors.add(deleteAuthorizationMethodDescriptor);
    methodDescriptors.add(listAccessSummariesMethodDescriptor);
    methodDescriptors.add(getAccessSummaryMethodDescriptor);
    methodDescriptors.add(revokeAuthorizationMethodDescriptor);
    methodDescriptors.add(enableAuthProviderMethodDescriptor);
    methodDescriptors.add(disableAuthProviderMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListAuthProvidersRequest, ListAuthProvidersResponse>
      listAuthProvidersCallable() {
    return listAuthProvidersCallable;
  }

  @Override
  public UnaryCallable<ListAuthProvidersRequest, ListAuthProvidersPagedResponse>
      listAuthProvidersPagedCallable() {
    return listAuthProvidersPagedCallable;
  }

  @Override
  public UnaryCallable<GetAuthProviderRequest, AuthProvider> getAuthProviderCallable() {
    return getAuthProviderCallable;
  }

  @Override
  public UnaryCallable<CreateAuthProviderRequest, AuthProvider> createAuthProviderCallable() {
    return createAuthProviderCallable;
  }

  @Override
  public UnaryCallable<UpdateAuthProviderRequest, AuthProvider> updateAuthProviderCallable() {
    return updateAuthProviderCallable;
  }

  @Override
  public UnaryCallable<DeleteAuthProviderRequest, Empty> deleteAuthProviderCallable() {
    return deleteAuthProviderCallable;
  }

  @Override
  public UnaryCallable<UndeleteAuthProviderRequest, AuthProvider> undeleteAuthProviderCallable() {
    return undeleteAuthProviderCallable;
  }

  @Override
  public UnaryCallable<QueryAuthProvidersRequest, QueryAuthProvidersResponse>
      queryAuthProvidersCallable() {
    return queryAuthProvidersCallable;
  }

  @Override
  public UnaryCallable<QueryAuthProvidersRequest, QueryAuthProvidersPagedResponse>
      queryAuthProvidersPagedCallable() {
    return queryAuthProvidersPagedCallable;
  }

  @Override
  public UnaryCallable<QueryWorkloadsRequest, QueryWorkloadsResponse> queryWorkloadsCallable() {
    return queryWorkloadsCallable;
  }

  @Override
  public UnaryCallable<QueryWorkloadsRequest, QueryWorkloadsPagedResponse>
      queryWorkloadsPagedCallable() {
    return queryWorkloadsPagedCallable;
  }

  @Override
  public UnaryCallable<ListAuthorizationsRequest, ListAuthorizationsResponse>
      listAuthorizationsCallable() {
    return listAuthorizationsCallable;
  }

  @Override
  public UnaryCallable<ListAuthorizationsRequest, ListAuthorizationsPagedResponse>
      listAuthorizationsPagedCallable() {
    return listAuthorizationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAuthorizationRequest, Authorization> getAuthorizationCallable() {
    return getAuthorizationCallable;
  }

  @Override
  public UnaryCallable<DeleteAuthorizationRequest, Empty> deleteAuthorizationCallable() {
    return deleteAuthorizationCallable;
  }

  @Override
  public UnaryCallable<ListAccessSummariesRequest, ListAccessSummariesResponse>
      listAccessSummariesCallable() {
    return listAccessSummariesCallable;
  }

  @Override
  public UnaryCallable<ListAccessSummariesRequest, ListAccessSummariesPagedResponse>
      listAccessSummariesPagedCallable() {
    return listAccessSummariesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAccessSummaryRequest, AccessSummary> getAccessSummaryCallable() {
    return getAccessSummaryCallable;
  }

  @Override
  public UnaryCallable<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
      revokeAuthorizationCallable() {
    return revokeAuthorizationCallable;
  }

  @Override
  public UnaryCallable<EnableAuthProviderRequest, AuthProvider> enableAuthProviderCallable() {
    return enableAuthProviderCallable;
  }

  @Override
  public UnaryCallable<DisableAuthProviderRequest, AuthProvider> disableAuthProviderCallable() {
    return disableAuthProviderCallable;
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
