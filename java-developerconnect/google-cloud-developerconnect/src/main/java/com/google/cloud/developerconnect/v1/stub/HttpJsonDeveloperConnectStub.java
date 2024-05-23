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

package com.google.cloud.developerconnect.v1.stub;

import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.FetchGitRefsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.FetchLinkableGitRepositoriesPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListConnectionsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListGitRepositoryLinksPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListLocationsPagedResponse;

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
import com.google.cloud.developerconnect.v1.Connection;
import com.google.cloud.developerconnect.v1.CreateConnectionRequest;
import com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest;
import com.google.cloud.developerconnect.v1.DeleteConnectionRequest;
import com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest;
import com.google.cloud.developerconnect.v1.FetchGitHubInstallationsRequest;
import com.google.cloud.developerconnect.v1.FetchGitHubInstallationsResponse;
import com.google.cloud.developerconnect.v1.FetchGitRefsRequest;
import com.google.cloud.developerconnect.v1.FetchGitRefsResponse;
import com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesRequest;
import com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesResponse;
import com.google.cloud.developerconnect.v1.FetchReadTokenRequest;
import com.google.cloud.developerconnect.v1.FetchReadTokenResponse;
import com.google.cloud.developerconnect.v1.FetchReadWriteTokenRequest;
import com.google.cloud.developerconnect.v1.FetchReadWriteTokenResponse;
import com.google.cloud.developerconnect.v1.GetConnectionRequest;
import com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest;
import com.google.cloud.developerconnect.v1.GitRepositoryLink;
import com.google.cloud.developerconnect.v1.ListConnectionsRequest;
import com.google.cloud.developerconnect.v1.ListConnectionsResponse;
import com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest;
import com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse;
import com.google.cloud.developerconnect.v1.OperationMetadata;
import com.google.cloud.developerconnect.v1.UpdateConnectionRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the DeveloperConnect service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDeveloperConnectStub extends DeveloperConnectStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(Connection.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(GitRepositoryLink.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsMethodDescriptor =
          ApiMethodDescriptor.<ListConnectionsRequest, ListConnectionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/ListConnections")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConnectionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/connections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListConnectionsResponse>newBuilder()
                      .setDefaultInstance(ListConnectionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConnectionRequest, Connection>
      getConnectionMethodDescriptor =
          ApiMethodDescriptor.<GetConnectionRequest, Connection>newBuilder()
              .setFullMethodName("google.cloud.developerconnect.v1.DeveloperConnect/GetConnection")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/connections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Connection>newBuilder()
                      .setDefaultInstance(Connection.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateConnectionRequest, Operation>
      createConnectionMethodDescriptor =
          ApiMethodDescriptor.<CreateConnectionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/CreateConnection")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/connections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "connectionId", request.getConnectionId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("connection", request.getConnection(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateConnectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateConnectionRequest, Operation>
      updateConnectionMethodDescriptor =
          ApiMethodDescriptor.<UpdateConnectionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/UpdateConnection")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{connection.name=projects/*/locations/*/connections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "connection.name", request.getConnection().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("connection", request.getConnection(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateConnectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteConnectionRequest, Operation>
      deleteConnectionMethodDescriptor =
          ApiMethodDescriptor.<DeleteConnectionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/DeleteConnection")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/connections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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
                  (DeleteConnectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateGitRepositoryLinkRequest, Operation>
      createGitRepositoryLinkMethodDescriptor =
          ApiMethodDescriptor.<CreateGitRepositoryLinkRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/CreateGitRepositoryLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGitRepositoryLinkRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/connections/*}/gitRepositoryLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGitRepositoryLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGitRepositoryLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "gitRepositoryLinkId", request.getGitRepositoryLinkId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "gitRepositoryLink", request.getGitRepositoryLink(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateGitRepositoryLinkRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteGitRepositoryLinkRequest, Operation>
      deleteGitRepositoryLinkMethodDescriptor =
          ApiMethodDescriptor.<DeleteGitRepositoryLinkRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/DeleteGitRepositoryLink")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGitRepositoryLinkRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/connections/*/gitRepositoryLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGitRepositoryLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGitRepositoryLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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
                  (DeleteGitRepositoryLinkRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse>
      listGitRepositoryLinksMethodDescriptor =
          ApiMethodDescriptor
              .<ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/ListGitRepositoryLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGitRepositoryLinksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/connections/*}/gitRepositoryLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGitRepositoryLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGitRepositoryLinksRequest> serializer =
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
                  ProtoMessageResponseParser.<ListGitRepositoryLinksResponse>newBuilder()
                      .setDefaultInstance(ListGitRepositoryLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGitRepositoryLinkRequest, GitRepositoryLink>
      getGitRepositoryLinkMethodDescriptor =
          ApiMethodDescriptor.<GetGitRepositoryLinkRequest, GitRepositoryLink>newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/GetGitRepositoryLink")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGitRepositoryLinkRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/connections/*/gitRepositoryLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGitRepositoryLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGitRepositoryLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GitRepositoryLink>newBuilder()
                      .setDefaultInstance(GitRepositoryLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
      fetchReadWriteTokenMethodDescriptor =
          ApiMethodDescriptor.<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/FetchReadWriteToken")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchReadWriteTokenRequest>newBuilder()
                      .setPath(
                          "/v1/{gitRepositoryLink=projects/*/locations/*/connections/*/gitRepositoryLinks/*}:fetchReadWriteToken",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchReadWriteTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "gitRepositoryLink", request.getGitRepositoryLink());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchReadWriteTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearGitRepositoryLink().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchReadWriteTokenResponse>newBuilder()
                      .setDefaultInstance(FetchReadWriteTokenResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FetchReadTokenRequest, FetchReadTokenResponse>
      fetchReadTokenMethodDescriptor =
          ApiMethodDescriptor.<FetchReadTokenRequest, FetchReadTokenResponse>newBuilder()
              .setFullMethodName("google.cloud.developerconnect.v1.DeveloperConnect/FetchReadToken")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchReadTokenRequest>newBuilder()
                      .setPath(
                          "/v1/{gitRepositoryLink=projects/*/locations/*/connections/*/gitRepositoryLinks/*}:fetchReadToken",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchReadTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "gitRepositoryLink", request.getGitRepositoryLink());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchReadTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearGitRepositoryLink().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchReadTokenResponse>newBuilder()
                      .setDefaultInstance(FetchReadTokenResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesResponse>
      fetchLinkableGitRepositoriesMethodDescriptor =
          ApiMethodDescriptor
              .<FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/FetchLinkableGitRepositories")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchLinkableGitRepositoriesRequest>newBuilder()
                      .setPath(
                          "/v1/{connection=projects/*/locations/*/connections/*}:fetchLinkableGitRepositories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchLinkableGitRepositoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "connection", request.getConnection());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchLinkableGitRepositoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchLinkableGitRepositoriesResponse>newBuilder()
                      .setDefaultInstance(FetchLinkableGitRepositoriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
      fetchGitHubInstallationsMethodDescriptor =
          ApiMethodDescriptor
              .<FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/FetchGitHubInstallations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchGitHubInstallationsRequest>newBuilder()
                      .setPath(
                          "/v1/{connection=projects/*/locations/*/connections/*}:fetchGitHubInstallations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchGitHubInstallationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "connection", request.getConnection());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchGitHubInstallationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchGitHubInstallationsResponse>newBuilder()
                      .setDefaultInstance(FetchGitHubInstallationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FetchGitRefsRequest, FetchGitRefsResponse>
      fetchGitRefsMethodDescriptor =
          ApiMethodDescriptor.<FetchGitRefsRequest, FetchGitRefsResponse>newBuilder()
              .setFullMethodName("google.cloud.developerconnect.v1.DeveloperConnect/FetchGitRefs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchGitRefsRequest>newBuilder()
                      .setPath(
                          "/v1/{gitRepositoryLink=projects/*/locations/*/connections/*/gitRepositoryLinks/*}:fetchGitRefs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchGitRefsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "gitRepositoryLink", request.getGitRepositoryLink());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchGitRefsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "refType", request.getRefTypeValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchGitRefsResponse>newBuilder()
                      .setDefaultInstance(FetchGitRefsResponse.getDefaultInstance())
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

  private final UnaryCallable<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsCallable;
  private final UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable;
  private final UnaryCallable<GetConnectionRequest, Connection> getConnectionCallable;
  private final UnaryCallable<CreateConnectionRequest, Operation> createConnectionCallable;
  private final OperationCallable<CreateConnectionRequest, Connection, OperationMetadata>
      createConnectionOperationCallable;
  private final UnaryCallable<UpdateConnectionRequest, Operation> updateConnectionCallable;
  private final OperationCallable<UpdateConnectionRequest, Connection, OperationMetadata>
      updateConnectionOperationCallable;
  private final UnaryCallable<DeleteConnectionRequest, Operation> deleteConnectionCallable;
  private final OperationCallable<DeleteConnectionRequest, Empty, OperationMetadata>
      deleteConnectionOperationCallable;
  private final UnaryCallable<CreateGitRepositoryLinkRequest, Operation>
      createGitRepositoryLinkCallable;
  private final OperationCallable<
          CreateGitRepositoryLinkRequest, GitRepositoryLink, OperationMetadata>
      createGitRepositoryLinkOperationCallable;
  private final UnaryCallable<DeleteGitRepositoryLinkRequest, Operation>
      deleteGitRepositoryLinkCallable;
  private final OperationCallable<DeleteGitRepositoryLinkRequest, Empty, OperationMetadata>
      deleteGitRepositoryLinkOperationCallable;
  private final UnaryCallable<ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse>
      listGitRepositoryLinksCallable;
  private final UnaryCallable<ListGitRepositoryLinksRequest, ListGitRepositoryLinksPagedResponse>
      listGitRepositoryLinksPagedCallable;
  private final UnaryCallable<GetGitRepositoryLinkRequest, GitRepositoryLink>
      getGitRepositoryLinkCallable;
  private final UnaryCallable<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
      fetchReadWriteTokenCallable;
  private final UnaryCallable<FetchReadTokenRequest, FetchReadTokenResponse> fetchReadTokenCallable;
  private final UnaryCallable<
          FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesResponse>
      fetchLinkableGitRepositoriesCallable;
  private final UnaryCallable<
          FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesPagedResponse>
      fetchLinkableGitRepositoriesPagedCallable;
  private final UnaryCallable<FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
      fetchGitHubInstallationsCallable;
  private final UnaryCallable<FetchGitRefsRequest, FetchGitRefsResponse> fetchGitRefsCallable;
  private final UnaryCallable<FetchGitRefsRequest, FetchGitRefsPagedResponse>
      fetchGitRefsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDeveloperConnectStub create(DeveloperConnectStubSettings settings)
      throws IOException {
    return new HttpJsonDeveloperConnectStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDeveloperConnectStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDeveloperConnectStub(
        DeveloperConnectStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDeveloperConnectStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDeveloperConnectStub(
        DeveloperConnectStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDeveloperConnectStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDeveloperConnectStub(
      DeveloperConnectStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDeveloperConnectCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDeveloperConnectStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDeveloperConnectStub(
      DeveloperConnectStubSettings settings,
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

    HttpJsonCallSettings<ListConnectionsRequest, ListConnectionsResponse>
        listConnectionsTransportSettings =
            HttpJsonCallSettings.<ListConnectionsRequest, ListConnectionsResponse>newBuilder()
                .setMethodDescriptor(listConnectionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetConnectionRequest, Connection> getConnectionTransportSettings =
        HttpJsonCallSettings.<GetConnectionRequest, Connection>newBuilder()
            .setMethodDescriptor(getConnectionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateConnectionRequest, Operation> createConnectionTransportSettings =
        HttpJsonCallSettings.<CreateConnectionRequest, Operation>newBuilder()
            .setMethodDescriptor(createConnectionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateConnectionRequest, Operation> updateConnectionTransportSettings =
        HttpJsonCallSettings.<UpdateConnectionRequest, Operation>newBuilder()
            .setMethodDescriptor(updateConnectionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("connection.name", String.valueOf(request.getConnection().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteConnectionRequest, Operation> deleteConnectionTransportSettings =
        HttpJsonCallSettings.<DeleteConnectionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteConnectionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateGitRepositoryLinkRequest, Operation>
        createGitRepositoryLinkTransportSettings =
            HttpJsonCallSettings.<CreateGitRepositoryLinkRequest, Operation>newBuilder()
                .setMethodDescriptor(createGitRepositoryLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteGitRepositoryLinkRequest, Operation>
        deleteGitRepositoryLinkTransportSettings =
            HttpJsonCallSettings.<DeleteGitRepositoryLinkRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGitRepositoryLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse>
        listGitRepositoryLinksTransportSettings =
            HttpJsonCallSettings
                .<ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse>newBuilder()
                .setMethodDescriptor(listGitRepositoryLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetGitRepositoryLinkRequest, GitRepositoryLink>
        getGitRepositoryLinkTransportSettings =
            HttpJsonCallSettings.<GetGitRepositoryLinkRequest, GitRepositoryLink>newBuilder()
                .setMethodDescriptor(getGitRepositoryLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
        fetchReadWriteTokenTransportSettings =
            HttpJsonCallSettings
                .<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>newBuilder()
                .setMethodDescriptor(fetchReadWriteTokenMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "git_repository_link", String.valueOf(request.getGitRepositoryLink()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FetchReadTokenRequest, FetchReadTokenResponse>
        fetchReadTokenTransportSettings =
            HttpJsonCallSettings.<FetchReadTokenRequest, FetchReadTokenResponse>newBuilder()
                .setMethodDescriptor(fetchReadTokenMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "git_repository_link", String.valueOf(request.getGitRepositoryLink()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesResponse>
        fetchLinkableGitRepositoriesTransportSettings =
            HttpJsonCallSettings
                .<FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesResponse>
                    newBuilder()
                .setMethodDescriptor(fetchLinkableGitRepositoriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("connection", String.valueOf(request.getConnection()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
        fetchGitHubInstallationsTransportSettings =
            HttpJsonCallSettings
                .<FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>newBuilder()
                .setMethodDescriptor(fetchGitHubInstallationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("connection", String.valueOf(request.getConnection()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FetchGitRefsRequest, FetchGitRefsResponse> fetchGitRefsTransportSettings =
        HttpJsonCallSettings.<FetchGitRefsRequest, FetchGitRefsResponse>newBuilder()
            .setMethodDescriptor(fetchGitRefsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "git_repository_link", String.valueOf(request.getGitRepositoryLink()));
                  return builder.build();
                })
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

    this.listConnectionsCallable =
        callableFactory.createUnaryCallable(
            listConnectionsTransportSettings, settings.listConnectionsSettings(), clientContext);
    this.listConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listConnectionsTransportSettings, settings.listConnectionsSettings(), clientContext);
    this.getConnectionCallable =
        callableFactory.createUnaryCallable(
            getConnectionTransportSettings, settings.getConnectionSettings(), clientContext);
    this.createConnectionCallable =
        callableFactory.createUnaryCallable(
            createConnectionTransportSettings, settings.createConnectionSettings(), clientContext);
    this.createConnectionOperationCallable =
        callableFactory.createOperationCallable(
            createConnectionTransportSettings,
            settings.createConnectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateConnectionCallable =
        callableFactory.createUnaryCallable(
            updateConnectionTransportSettings, settings.updateConnectionSettings(), clientContext);
    this.updateConnectionOperationCallable =
        callableFactory.createOperationCallable(
            updateConnectionTransportSettings,
            settings.updateConnectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteConnectionCallable =
        callableFactory.createUnaryCallable(
            deleteConnectionTransportSettings, settings.deleteConnectionSettings(), clientContext);
    this.deleteConnectionOperationCallable =
        callableFactory.createOperationCallable(
            deleteConnectionTransportSettings,
            settings.deleteConnectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createGitRepositoryLinkCallable =
        callableFactory.createUnaryCallable(
            createGitRepositoryLinkTransportSettings,
            settings.createGitRepositoryLinkSettings(),
            clientContext);
    this.createGitRepositoryLinkOperationCallable =
        callableFactory.createOperationCallable(
            createGitRepositoryLinkTransportSettings,
            settings.createGitRepositoryLinkOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteGitRepositoryLinkCallable =
        callableFactory.createUnaryCallable(
            deleteGitRepositoryLinkTransportSettings,
            settings.deleteGitRepositoryLinkSettings(),
            clientContext);
    this.deleteGitRepositoryLinkOperationCallable =
        callableFactory.createOperationCallable(
            deleteGitRepositoryLinkTransportSettings,
            settings.deleteGitRepositoryLinkOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listGitRepositoryLinksCallable =
        callableFactory.createUnaryCallable(
            listGitRepositoryLinksTransportSettings,
            settings.listGitRepositoryLinksSettings(),
            clientContext);
    this.listGitRepositoryLinksPagedCallable =
        callableFactory.createPagedCallable(
            listGitRepositoryLinksTransportSettings,
            settings.listGitRepositoryLinksSettings(),
            clientContext);
    this.getGitRepositoryLinkCallable =
        callableFactory.createUnaryCallable(
            getGitRepositoryLinkTransportSettings,
            settings.getGitRepositoryLinkSettings(),
            clientContext);
    this.fetchReadWriteTokenCallable =
        callableFactory.createUnaryCallable(
            fetchReadWriteTokenTransportSettings,
            settings.fetchReadWriteTokenSettings(),
            clientContext);
    this.fetchReadTokenCallable =
        callableFactory.createUnaryCallable(
            fetchReadTokenTransportSettings, settings.fetchReadTokenSettings(), clientContext);
    this.fetchLinkableGitRepositoriesCallable =
        callableFactory.createUnaryCallable(
            fetchLinkableGitRepositoriesTransportSettings,
            settings.fetchLinkableGitRepositoriesSettings(),
            clientContext);
    this.fetchLinkableGitRepositoriesPagedCallable =
        callableFactory.createPagedCallable(
            fetchLinkableGitRepositoriesTransportSettings,
            settings.fetchLinkableGitRepositoriesSettings(),
            clientContext);
    this.fetchGitHubInstallationsCallable =
        callableFactory.createUnaryCallable(
            fetchGitHubInstallationsTransportSettings,
            settings.fetchGitHubInstallationsSettings(),
            clientContext);
    this.fetchGitRefsCallable =
        callableFactory.createUnaryCallable(
            fetchGitRefsTransportSettings, settings.fetchGitRefsSettings(), clientContext);
    this.fetchGitRefsPagedCallable =
        callableFactory.createPagedCallable(
            fetchGitRefsTransportSettings, settings.fetchGitRefsSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listConnectionsMethodDescriptor);
    methodDescriptors.add(getConnectionMethodDescriptor);
    methodDescriptors.add(createConnectionMethodDescriptor);
    methodDescriptors.add(updateConnectionMethodDescriptor);
    methodDescriptors.add(deleteConnectionMethodDescriptor);
    methodDescriptors.add(createGitRepositoryLinkMethodDescriptor);
    methodDescriptors.add(deleteGitRepositoryLinkMethodDescriptor);
    methodDescriptors.add(listGitRepositoryLinksMethodDescriptor);
    methodDescriptors.add(getGitRepositoryLinkMethodDescriptor);
    methodDescriptors.add(fetchReadWriteTokenMethodDescriptor);
    methodDescriptors.add(fetchReadTokenMethodDescriptor);
    methodDescriptors.add(fetchLinkableGitRepositoriesMethodDescriptor);
    methodDescriptors.add(fetchGitHubInstallationsMethodDescriptor);
    methodDescriptors.add(fetchGitRefsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListConnectionsRequest, ListConnectionsResponse> listConnectionsCallable() {
    return listConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable() {
    return listConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetConnectionRequest, Connection> getConnectionCallable() {
    return getConnectionCallable;
  }

  @Override
  public UnaryCallable<CreateConnectionRequest, Operation> createConnectionCallable() {
    return createConnectionCallable;
  }

  @Override
  public OperationCallable<CreateConnectionRequest, Connection, OperationMetadata>
      createConnectionOperationCallable() {
    return createConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConnectionRequest, Operation> updateConnectionCallable() {
    return updateConnectionCallable;
  }

  @Override
  public OperationCallable<UpdateConnectionRequest, Connection, OperationMetadata>
      updateConnectionOperationCallable() {
    return updateConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectionRequest, Operation> deleteConnectionCallable() {
    return deleteConnectionCallable;
  }

  @Override
  public OperationCallable<DeleteConnectionRequest, Empty, OperationMetadata>
      deleteConnectionOperationCallable() {
    return deleteConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<CreateGitRepositoryLinkRequest, Operation>
      createGitRepositoryLinkCallable() {
    return createGitRepositoryLinkCallable;
  }

  @Override
  public OperationCallable<CreateGitRepositoryLinkRequest, GitRepositoryLink, OperationMetadata>
      createGitRepositoryLinkOperationCallable() {
    return createGitRepositoryLinkOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGitRepositoryLinkRequest, Operation>
      deleteGitRepositoryLinkCallable() {
    return deleteGitRepositoryLinkCallable;
  }

  @Override
  public OperationCallable<DeleteGitRepositoryLinkRequest, Empty, OperationMetadata>
      deleteGitRepositoryLinkOperationCallable() {
    return deleteGitRepositoryLinkOperationCallable;
  }

  @Override
  public UnaryCallable<ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse>
      listGitRepositoryLinksCallable() {
    return listGitRepositoryLinksCallable;
  }

  @Override
  public UnaryCallable<ListGitRepositoryLinksRequest, ListGitRepositoryLinksPagedResponse>
      listGitRepositoryLinksPagedCallable() {
    return listGitRepositoryLinksPagedCallable;
  }

  @Override
  public UnaryCallable<GetGitRepositoryLinkRequest, GitRepositoryLink>
      getGitRepositoryLinkCallable() {
    return getGitRepositoryLinkCallable;
  }

  @Override
  public UnaryCallable<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
      fetchReadWriteTokenCallable() {
    return fetchReadWriteTokenCallable;
  }

  @Override
  public UnaryCallable<FetchReadTokenRequest, FetchReadTokenResponse> fetchReadTokenCallable() {
    return fetchReadTokenCallable;
  }

  @Override
  public UnaryCallable<FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesResponse>
      fetchLinkableGitRepositoriesCallable() {
    return fetchLinkableGitRepositoriesCallable;
  }

  @Override
  public UnaryCallable<
          FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesPagedResponse>
      fetchLinkableGitRepositoriesPagedCallable() {
    return fetchLinkableGitRepositoriesPagedCallable;
  }

  @Override
  public UnaryCallable<FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
      fetchGitHubInstallationsCallable() {
    return fetchGitHubInstallationsCallable;
  }

  @Override
  public UnaryCallable<FetchGitRefsRequest, FetchGitRefsResponse> fetchGitRefsCallable() {
    return fetchGitRefsCallable;
  }

  @Override
  public UnaryCallable<FetchGitRefsRequest, FetchGitRefsPagedResponse> fetchGitRefsPagedCallable() {
    return fetchGitRefsPagedCallable;
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
