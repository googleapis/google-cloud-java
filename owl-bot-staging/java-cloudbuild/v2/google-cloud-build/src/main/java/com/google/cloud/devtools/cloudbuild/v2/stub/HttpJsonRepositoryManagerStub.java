/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.devtools.cloudbuild.v2.stub;

import static com.google.cloud.devtools.cloudbuild.v2.RepositoryManagerClient.FetchLinkableRepositoriesPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v2.RepositoryManagerClient.ListConnectionsPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v2.RepositoryManagerClient.ListRepositoriesPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloudbuild.v2.BatchCreateRepositoriesRequest;
import com.google.cloudbuild.v2.BatchCreateRepositoriesResponse;
import com.google.cloudbuild.v2.Connection;
import com.google.cloudbuild.v2.CreateConnectionRequest;
import com.google.cloudbuild.v2.CreateRepositoryRequest;
import com.google.cloudbuild.v2.DeleteConnectionRequest;
import com.google.cloudbuild.v2.DeleteRepositoryRequest;
import com.google.cloudbuild.v2.FetchGitRefsRequest;
import com.google.cloudbuild.v2.FetchGitRefsResponse;
import com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest;
import com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse;
import com.google.cloudbuild.v2.FetchReadTokenRequest;
import com.google.cloudbuild.v2.FetchReadTokenResponse;
import com.google.cloudbuild.v2.FetchReadWriteTokenRequest;
import com.google.cloudbuild.v2.FetchReadWriteTokenResponse;
import com.google.cloudbuild.v2.GetConnectionRequest;
import com.google.cloudbuild.v2.GetRepositoryRequest;
import com.google.cloudbuild.v2.ListConnectionsRequest;
import com.google.cloudbuild.v2.ListConnectionsResponse;
import com.google.cloudbuild.v2.ListRepositoriesRequest;
import com.google.cloudbuild.v2.ListRepositoriesResponse;
import com.google.cloudbuild.v2.OperationMetadata;
import com.google.cloudbuild.v2.Repository;
import com.google.cloudbuild.v2.UpdateConnectionRequest;
import com.google.common.collect.ImmutableMap;
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
 * REST stub implementation for the RepositoryManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRepositoryManagerStub extends RepositoryManagerStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(Connection.getDescriptor())
          .add(BatchCreateRepositoriesResponse.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Repository.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateConnectionRequest, Operation>
      createConnectionMethodDescriptor =
          ApiMethodDescriptor.<CreateConnectionRequest, Operation>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v2.RepositoryManager/CreateConnection")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConnectionRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/connections",
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

  private static final ApiMethodDescriptor<GetConnectionRequest, Connection>
      getConnectionMethodDescriptor =
          ApiMethodDescriptor.<GetConnectionRequest, Connection>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v2.RepositoryManager/GetConnection")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConnectionRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/connections/*}",
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

  private static final ApiMethodDescriptor<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsMethodDescriptor =
          ApiMethodDescriptor.<ListConnectionsRequest, ListConnectionsResponse>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v2.RepositoryManager/ListConnections")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConnectionsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/connections",
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

  private static final ApiMethodDescriptor<UpdateConnectionRequest, Operation>
      updateConnectionMethodDescriptor =
          ApiMethodDescriptor.<UpdateConnectionRequest, Operation>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v2.RepositoryManager/UpdateConnection")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConnectionRequest>newBuilder()
                      .setPath(
                          "/v2/{connection.name=projects/*/locations/*/connections/*}",
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
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
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
              .setFullMethodName("google.devtools.cloudbuild.v2.RepositoryManager/DeleteConnection")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConnectionRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/connections/*}",
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

  private static final ApiMethodDescriptor<CreateRepositoryRequest, Operation>
      createRepositoryMethodDescriptor =
          ApiMethodDescriptor.<CreateRepositoryRequest, Operation>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v2.RepositoryManager/CreateRepository")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRepositoryRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/connections/*}/repositories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "repositoryId", request.getRepositoryId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("repository", request.getRepository(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateRepositoryRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<BatchCreateRepositoriesRequest, Operation>
      batchCreateRepositoriesMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateRepositoriesRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.devtools.cloudbuild.v2.RepositoryManager/BatchCreateRepositories")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateRepositoriesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/connections/*}/repositories:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateRepositoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateRepositoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchCreateRepositoriesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetRepositoryRequest, Repository>
      getRepositoryMethodDescriptor =
          ApiMethodDescriptor.<GetRepositoryRequest, Repository>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v2.RepositoryManager/GetRepository")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRepositoryRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/connections/*/repositories/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Repository>newBuilder()
                      .setDefaultInstance(Repository.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesMethodDescriptor =
          ApiMethodDescriptor.<ListRepositoriesRequest, ListRepositoriesResponse>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v2.RepositoryManager/ListRepositories")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRepositoriesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/connections/*}/repositories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRepositoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRepositoriesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListRepositoriesResponse>newBuilder()
                      .setDefaultInstance(ListRepositoriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRepositoryRequest, Operation>
      deleteRepositoryMethodDescriptor =
          ApiMethodDescriptor.<DeleteRepositoryRequest, Operation>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v2.RepositoryManager/DeleteRepository")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRepositoryRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/connections/*/repositories/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
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
                  (DeleteRepositoryRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
      fetchReadWriteTokenMethodDescriptor =
          ApiMethodDescriptor.<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>newBuilder()
              .setFullMethodName(
                  "google.devtools.cloudbuild.v2.RepositoryManager/FetchReadWriteToken")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchReadWriteTokenRequest>newBuilder()
                      .setPath(
                          "/v2/{repository=projects/*/locations/*/connections/*/repositories/*}:accessReadWriteToken",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchReadWriteTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "repository", request.getRepository());
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
                                  .toBody("*", request.toBuilder().clearRepository().build(), true))
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
              .setFullMethodName("google.devtools.cloudbuild.v2.RepositoryManager/FetchReadToken")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchReadTokenRequest>newBuilder()
                      .setPath(
                          "/v2/{repository=projects/*/locations/*/connections/*/repositories/*}:accessReadToken",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchReadTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "repository", request.getRepository());
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
                                  .toBody("*", request.toBuilder().clearRepository().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchReadTokenResponse>newBuilder()
                      .setDefaultInstance(FetchReadTokenResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FetchLinkableRepositoriesRequest, FetchLinkableRepositoriesResponse>
      fetchLinkableRepositoriesMethodDescriptor =
          ApiMethodDescriptor
              .<FetchLinkableRepositoriesRequest, FetchLinkableRepositoriesResponse>newBuilder()
              .setFullMethodName(
                  "google.devtools.cloudbuild.v2.RepositoryManager/FetchLinkableRepositories")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchLinkableRepositoriesRequest>newBuilder()
                      .setPath(
                          "/v2/{connection=projects/*/locations/*/connections/*}:fetchLinkableRepositories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchLinkableRepositoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "connection", request.getConnection());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchLinkableRepositoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchLinkableRepositoriesResponse>newBuilder()
                      .setDefaultInstance(FetchLinkableRepositoriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FetchGitRefsRequest, FetchGitRefsResponse>
      fetchGitRefsMethodDescriptor =
          ApiMethodDescriptor.<FetchGitRefsRequest, FetchGitRefsResponse>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v2.RepositoryManager/FetchGitRefs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchGitRefsRequest>newBuilder()
                      .setPath(
                          "/v2/{repository=projects/*/locations/*/connections/*/repositories/*}:fetchGitRefs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchGitRefsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "repository", request.getRepository());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchGitRefsRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v2/{resource=projects/*/locations/*/connections/*}:setIamPolicy",
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
                          "/v2/{resource=projects/*/locations/*/connections/*}:getIamPolicy",
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
                          "/v2/{resource=projects/*/locations/*/connections/*}:testIamPermissions",
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

  private final UnaryCallable<CreateConnectionRequest, Operation> createConnectionCallable;
  private final OperationCallable<CreateConnectionRequest, Connection, OperationMetadata>
      createConnectionOperationCallable;
  private final UnaryCallable<GetConnectionRequest, Connection> getConnectionCallable;
  private final UnaryCallable<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsCallable;
  private final UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable;
  private final UnaryCallable<UpdateConnectionRequest, Operation> updateConnectionCallable;
  private final OperationCallable<UpdateConnectionRequest, Connection, OperationMetadata>
      updateConnectionOperationCallable;
  private final UnaryCallable<DeleteConnectionRequest, Operation> deleteConnectionCallable;
  private final OperationCallable<DeleteConnectionRequest, Empty, OperationMetadata>
      deleteConnectionOperationCallable;
  private final UnaryCallable<CreateRepositoryRequest, Operation> createRepositoryCallable;
  private final OperationCallable<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationCallable;
  private final UnaryCallable<BatchCreateRepositoriesRequest, Operation>
      batchCreateRepositoriesCallable;
  private final OperationCallable<
          BatchCreateRepositoriesRequest, BatchCreateRepositoriesResponse, OperationMetadata>
      batchCreateRepositoriesOperationCallable;
  private final UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable;
  private final UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesCallable;
  private final UnaryCallable<ListRepositoriesRequest, ListRepositoriesPagedResponse>
      listRepositoriesPagedCallable;
  private final UnaryCallable<DeleteRepositoryRequest, Operation> deleteRepositoryCallable;
  private final OperationCallable<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationCallable;
  private final UnaryCallable<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
      fetchReadWriteTokenCallable;
  private final UnaryCallable<FetchReadTokenRequest, FetchReadTokenResponse> fetchReadTokenCallable;
  private final UnaryCallable<FetchLinkableRepositoriesRequest, FetchLinkableRepositoriesResponse>
      fetchLinkableRepositoriesCallable;
  private final UnaryCallable<
          FetchLinkableRepositoriesRequest, FetchLinkableRepositoriesPagedResponse>
      fetchLinkableRepositoriesPagedCallable;
  private final UnaryCallable<FetchGitRefsRequest, FetchGitRefsResponse> fetchGitRefsCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRepositoryManagerStub create(RepositoryManagerStubSettings settings)
      throws IOException {
    return new HttpJsonRepositoryManagerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRepositoryManagerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRepositoryManagerStub(
        RepositoryManagerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRepositoryManagerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRepositoryManagerStub(
        RepositoryManagerStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRepositoryManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRepositoryManagerStub(
      RepositoryManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRepositoryManagerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRepositoryManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRepositoryManagerStub(
      RepositoryManagerStubSettings settings,
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
                        .setPost("/v2/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v2/{name=projects/*/locations/*/operations/*}")
                        .build())
                .build());

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
    HttpJsonCallSettings<CreateRepositoryRequest, Operation> createRepositoryTransportSettings =
        HttpJsonCallSettings.<CreateRepositoryRequest, Operation>newBuilder()
            .setMethodDescriptor(createRepositoryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchCreateRepositoriesRequest, Operation>
        batchCreateRepositoriesTransportSettings =
            HttpJsonCallSettings.<BatchCreateRepositoriesRequest, Operation>newBuilder()
                .setMethodDescriptor(batchCreateRepositoriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetRepositoryRequest, Repository> getRepositoryTransportSettings =
        HttpJsonCallSettings.<GetRepositoryRequest, Repository>newBuilder()
            .setMethodDescriptor(getRepositoryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListRepositoriesRequest, ListRepositoriesResponse>
        listRepositoriesTransportSettings =
            HttpJsonCallSettings.<ListRepositoriesRequest, ListRepositoriesResponse>newBuilder()
                .setMethodDescriptor(listRepositoriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteRepositoryRequest, Operation> deleteRepositoryTransportSettings =
        HttpJsonCallSettings.<DeleteRepositoryRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRepositoryMethodDescriptor)
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
                      builder.add("repository", String.valueOf(request.getRepository()));
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
                      builder.add("repository", String.valueOf(request.getRepository()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FetchLinkableRepositoriesRequest, FetchLinkableRepositoriesResponse>
        fetchLinkableRepositoriesTransportSettings =
            HttpJsonCallSettings
                .<FetchLinkableRepositoriesRequest, FetchLinkableRepositoriesResponse>newBuilder()
                .setMethodDescriptor(fetchLinkableRepositoriesMethodDescriptor)
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
                  builder.add("repository", String.valueOf(request.getRepository()));
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
                .build();

    this.createConnectionCallable =
        callableFactory.createUnaryCallable(
            createConnectionTransportSettings, settings.createConnectionSettings(), clientContext);
    this.createConnectionOperationCallable =
        callableFactory.createOperationCallable(
            createConnectionTransportSettings,
            settings.createConnectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getConnectionCallable =
        callableFactory.createUnaryCallable(
            getConnectionTransportSettings, settings.getConnectionSettings(), clientContext);
    this.listConnectionsCallable =
        callableFactory.createUnaryCallable(
            listConnectionsTransportSettings, settings.listConnectionsSettings(), clientContext);
    this.listConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listConnectionsTransportSettings, settings.listConnectionsSettings(), clientContext);
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
    this.createRepositoryCallable =
        callableFactory.createUnaryCallable(
            createRepositoryTransportSettings, settings.createRepositorySettings(), clientContext);
    this.createRepositoryOperationCallable =
        callableFactory.createOperationCallable(
            createRepositoryTransportSettings,
            settings.createRepositoryOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.batchCreateRepositoriesCallable =
        callableFactory.createUnaryCallable(
            batchCreateRepositoriesTransportSettings,
            settings.batchCreateRepositoriesSettings(),
            clientContext);
    this.batchCreateRepositoriesOperationCallable =
        callableFactory.createOperationCallable(
            batchCreateRepositoriesTransportSettings,
            settings.batchCreateRepositoriesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getRepositoryCallable =
        callableFactory.createUnaryCallable(
            getRepositoryTransportSettings, settings.getRepositorySettings(), clientContext);
    this.listRepositoriesCallable =
        callableFactory.createUnaryCallable(
            listRepositoriesTransportSettings, settings.listRepositoriesSettings(), clientContext);
    this.listRepositoriesPagedCallable =
        callableFactory.createPagedCallable(
            listRepositoriesTransportSettings, settings.listRepositoriesSettings(), clientContext);
    this.deleteRepositoryCallable =
        callableFactory.createUnaryCallable(
            deleteRepositoryTransportSettings, settings.deleteRepositorySettings(), clientContext);
    this.deleteRepositoryOperationCallable =
        callableFactory.createOperationCallable(
            deleteRepositoryTransportSettings,
            settings.deleteRepositoryOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.fetchReadWriteTokenCallable =
        callableFactory.createUnaryCallable(
            fetchReadWriteTokenTransportSettings,
            settings.fetchReadWriteTokenSettings(),
            clientContext);
    this.fetchReadTokenCallable =
        callableFactory.createUnaryCallable(
            fetchReadTokenTransportSettings, settings.fetchReadTokenSettings(), clientContext);
    this.fetchLinkableRepositoriesCallable =
        callableFactory.createUnaryCallable(
            fetchLinkableRepositoriesTransportSettings,
            settings.fetchLinkableRepositoriesSettings(),
            clientContext);
    this.fetchLinkableRepositoriesPagedCallable =
        callableFactory.createPagedCallable(
            fetchLinkableRepositoriesTransportSettings,
            settings.fetchLinkableRepositoriesSettings(),
            clientContext);
    this.fetchGitRefsCallable =
        callableFactory.createUnaryCallable(
            fetchGitRefsTransportSettings, settings.fetchGitRefsSettings(), clientContext);
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
    methodDescriptors.add(createConnectionMethodDescriptor);
    methodDescriptors.add(getConnectionMethodDescriptor);
    methodDescriptors.add(listConnectionsMethodDescriptor);
    methodDescriptors.add(updateConnectionMethodDescriptor);
    methodDescriptors.add(deleteConnectionMethodDescriptor);
    methodDescriptors.add(createRepositoryMethodDescriptor);
    methodDescriptors.add(batchCreateRepositoriesMethodDescriptor);
    methodDescriptors.add(getRepositoryMethodDescriptor);
    methodDescriptors.add(listRepositoriesMethodDescriptor);
    methodDescriptors.add(deleteRepositoryMethodDescriptor);
    methodDescriptors.add(fetchReadWriteTokenMethodDescriptor);
    methodDescriptors.add(fetchReadTokenMethodDescriptor);
    methodDescriptors.add(fetchLinkableRepositoriesMethodDescriptor);
    methodDescriptors.add(fetchGitRefsMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
  public UnaryCallable<GetConnectionRequest, Connection> getConnectionCallable() {
    return getConnectionCallable;
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
  public UnaryCallable<CreateRepositoryRequest, Operation> createRepositoryCallable() {
    return createRepositoryCallable;
  }

  @Override
  public OperationCallable<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationCallable() {
    return createRepositoryOperationCallable;
  }

  @Override
  public UnaryCallable<BatchCreateRepositoriesRequest, Operation>
      batchCreateRepositoriesCallable() {
    return batchCreateRepositoriesCallable;
  }

  @Override
  public OperationCallable<
          BatchCreateRepositoriesRequest, BatchCreateRepositoriesResponse, OperationMetadata>
      batchCreateRepositoriesOperationCallable() {
    return batchCreateRepositoriesOperationCallable;
  }

  @Override
  public UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable() {
    return getRepositoryCallable;
  }

  @Override
  public UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesCallable() {
    return listRepositoriesCallable;
  }

  @Override
  public UnaryCallable<ListRepositoriesRequest, ListRepositoriesPagedResponse>
      listRepositoriesPagedCallable() {
    return listRepositoriesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteRepositoryRequest, Operation> deleteRepositoryCallable() {
    return deleteRepositoryCallable;
  }

  @Override
  public OperationCallable<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationCallable() {
    return deleteRepositoryOperationCallable;
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
  public UnaryCallable<FetchLinkableRepositoriesRequest, FetchLinkableRepositoriesResponse>
      fetchLinkableRepositoriesCallable() {
    return fetchLinkableRepositoriesCallable;
  }

  @Override
  public UnaryCallable<FetchLinkableRepositoriesRequest, FetchLinkableRepositoriesPagedResponse>
      fetchLinkableRepositoriesPagedCallable() {
    return fetchLinkableRepositoriesPagedCallable;
  }

  @Override
  public UnaryCallable<FetchGitRefsRequest, FetchGitRefsResponse> fetchGitRefsCallable() {
    return fetchGitRefsCallable;
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
