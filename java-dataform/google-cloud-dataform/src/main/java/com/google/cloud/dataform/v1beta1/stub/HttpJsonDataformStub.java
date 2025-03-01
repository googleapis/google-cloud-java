/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.dataform.v1beta1.stub;

import static com.google.cloud.dataform.v1beta1.DataformClient.FetchRepositoryHistoryPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListCompilationResultsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListLocationsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListReleaseConfigsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListRepositoriesPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListWorkflowConfigsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListWorkflowInvocationsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListWorkspacesPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.QueryCompilationResultActionsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.QueryDirectoryContentsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.QueryRepositoryDirectoryContentsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.QueryWorkflowInvocationActionsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.SearchFilesPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.cloud.dataform.v1beta1.CancelWorkflowInvocationRequest;
import com.google.cloud.dataform.v1beta1.CancelWorkflowInvocationResponse;
import com.google.cloud.dataform.v1beta1.CommitRepositoryChangesRequest;
import com.google.cloud.dataform.v1beta1.CommitRepositoryChangesResponse;
import com.google.cloud.dataform.v1beta1.CommitWorkspaceChangesRequest;
import com.google.cloud.dataform.v1beta1.CommitWorkspaceChangesResponse;
import com.google.cloud.dataform.v1beta1.CompilationResult;
import com.google.cloud.dataform.v1beta1.ComputeRepositoryAccessTokenStatusRequest;
import com.google.cloud.dataform.v1beta1.ComputeRepositoryAccessTokenStatusResponse;
import com.google.cloud.dataform.v1beta1.Config;
import com.google.cloud.dataform.v1beta1.CreateCompilationResultRequest;
import com.google.cloud.dataform.v1beta1.CreateReleaseConfigRequest;
import com.google.cloud.dataform.v1beta1.CreateRepositoryRequest;
import com.google.cloud.dataform.v1beta1.CreateWorkflowConfigRequest;
import com.google.cloud.dataform.v1beta1.CreateWorkflowInvocationRequest;
import com.google.cloud.dataform.v1beta1.CreateWorkspaceRequest;
import com.google.cloud.dataform.v1beta1.DeleteReleaseConfigRequest;
import com.google.cloud.dataform.v1beta1.DeleteRepositoryRequest;
import com.google.cloud.dataform.v1beta1.DeleteWorkflowConfigRequest;
import com.google.cloud.dataform.v1beta1.DeleteWorkflowInvocationRequest;
import com.google.cloud.dataform.v1beta1.DeleteWorkspaceRequest;
import com.google.cloud.dataform.v1beta1.FetchFileDiffRequest;
import com.google.cloud.dataform.v1beta1.FetchFileDiffResponse;
import com.google.cloud.dataform.v1beta1.FetchFileGitStatusesRequest;
import com.google.cloud.dataform.v1beta1.FetchFileGitStatusesResponse;
import com.google.cloud.dataform.v1beta1.FetchGitAheadBehindRequest;
import com.google.cloud.dataform.v1beta1.FetchGitAheadBehindResponse;
import com.google.cloud.dataform.v1beta1.FetchRemoteBranchesRequest;
import com.google.cloud.dataform.v1beta1.FetchRemoteBranchesResponse;
import com.google.cloud.dataform.v1beta1.FetchRepositoryHistoryRequest;
import com.google.cloud.dataform.v1beta1.FetchRepositoryHistoryResponse;
import com.google.cloud.dataform.v1beta1.GetCompilationResultRequest;
import com.google.cloud.dataform.v1beta1.GetConfigRequest;
import com.google.cloud.dataform.v1beta1.GetReleaseConfigRequest;
import com.google.cloud.dataform.v1beta1.GetRepositoryRequest;
import com.google.cloud.dataform.v1beta1.GetWorkflowConfigRequest;
import com.google.cloud.dataform.v1beta1.GetWorkflowInvocationRequest;
import com.google.cloud.dataform.v1beta1.GetWorkspaceRequest;
import com.google.cloud.dataform.v1beta1.InstallNpmPackagesRequest;
import com.google.cloud.dataform.v1beta1.InstallNpmPackagesResponse;
import com.google.cloud.dataform.v1beta1.ListCompilationResultsRequest;
import com.google.cloud.dataform.v1beta1.ListCompilationResultsResponse;
import com.google.cloud.dataform.v1beta1.ListReleaseConfigsRequest;
import com.google.cloud.dataform.v1beta1.ListReleaseConfigsResponse;
import com.google.cloud.dataform.v1beta1.ListRepositoriesRequest;
import com.google.cloud.dataform.v1beta1.ListRepositoriesResponse;
import com.google.cloud.dataform.v1beta1.ListWorkflowConfigsRequest;
import com.google.cloud.dataform.v1beta1.ListWorkflowConfigsResponse;
import com.google.cloud.dataform.v1beta1.ListWorkflowInvocationsRequest;
import com.google.cloud.dataform.v1beta1.ListWorkflowInvocationsResponse;
import com.google.cloud.dataform.v1beta1.ListWorkspacesRequest;
import com.google.cloud.dataform.v1beta1.ListWorkspacesResponse;
import com.google.cloud.dataform.v1beta1.MakeDirectoryRequest;
import com.google.cloud.dataform.v1beta1.MakeDirectoryResponse;
import com.google.cloud.dataform.v1beta1.MoveDirectoryRequest;
import com.google.cloud.dataform.v1beta1.MoveDirectoryResponse;
import com.google.cloud.dataform.v1beta1.MoveFileRequest;
import com.google.cloud.dataform.v1beta1.MoveFileResponse;
import com.google.cloud.dataform.v1beta1.PullGitCommitsRequest;
import com.google.cloud.dataform.v1beta1.PullGitCommitsResponse;
import com.google.cloud.dataform.v1beta1.PushGitCommitsRequest;
import com.google.cloud.dataform.v1beta1.PushGitCommitsResponse;
import com.google.cloud.dataform.v1beta1.QueryCompilationResultActionsRequest;
import com.google.cloud.dataform.v1beta1.QueryCompilationResultActionsResponse;
import com.google.cloud.dataform.v1beta1.QueryDirectoryContentsRequest;
import com.google.cloud.dataform.v1beta1.QueryDirectoryContentsResponse;
import com.google.cloud.dataform.v1beta1.QueryRepositoryDirectoryContentsRequest;
import com.google.cloud.dataform.v1beta1.QueryRepositoryDirectoryContentsResponse;
import com.google.cloud.dataform.v1beta1.QueryWorkflowInvocationActionsRequest;
import com.google.cloud.dataform.v1beta1.QueryWorkflowInvocationActionsResponse;
import com.google.cloud.dataform.v1beta1.ReadFileRequest;
import com.google.cloud.dataform.v1beta1.ReadFileResponse;
import com.google.cloud.dataform.v1beta1.ReadRepositoryFileRequest;
import com.google.cloud.dataform.v1beta1.ReadRepositoryFileResponse;
import com.google.cloud.dataform.v1beta1.ReleaseConfig;
import com.google.cloud.dataform.v1beta1.RemoveDirectoryRequest;
import com.google.cloud.dataform.v1beta1.RemoveDirectoryResponse;
import com.google.cloud.dataform.v1beta1.RemoveFileRequest;
import com.google.cloud.dataform.v1beta1.RemoveFileResponse;
import com.google.cloud.dataform.v1beta1.Repository;
import com.google.cloud.dataform.v1beta1.ResetWorkspaceChangesRequest;
import com.google.cloud.dataform.v1beta1.ResetWorkspaceChangesResponse;
import com.google.cloud.dataform.v1beta1.SearchFilesRequest;
import com.google.cloud.dataform.v1beta1.SearchFilesResponse;
import com.google.cloud.dataform.v1beta1.UpdateConfigRequest;
import com.google.cloud.dataform.v1beta1.UpdateReleaseConfigRequest;
import com.google.cloud.dataform.v1beta1.UpdateRepositoryRequest;
import com.google.cloud.dataform.v1beta1.UpdateWorkflowConfigRequest;
import com.google.cloud.dataform.v1beta1.WorkflowConfig;
import com.google.cloud.dataform.v1beta1.WorkflowInvocation;
import com.google.cloud.dataform.v1beta1.Workspace;
import com.google.cloud.dataform.v1beta1.WriteFileRequest;
import com.google.cloud.dataform.v1beta1.WriteFileResponse;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Dataform service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonDataformStub extends DataformStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesMethodDescriptor =
          ApiMethodDescriptor.<ListRepositoriesRequest, ListRepositoriesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ListRepositories")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRepositoriesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/repositories",
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
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
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

  private static final ApiMethodDescriptor<GetRepositoryRequest, Repository>
      getRepositoryMethodDescriptor =
          ApiMethodDescriptor.<GetRepositoryRequest, Repository>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/GetRepository")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRepositoryRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*}",
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

  private static final ApiMethodDescriptor<CreateRepositoryRequest, Repository>
      createRepositoryMethodDescriptor =
          ApiMethodDescriptor.<CreateRepositoryRequest, Repository>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CreateRepository")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRepositoryRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/repositories",
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
                  ProtoMessageResponseParser.<Repository>newBuilder()
                      .setDefaultInstance(Repository.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateRepositoryRequest, Repository>
      updateRepositoryMethodDescriptor =
          ApiMethodDescriptor.<UpdateRepositoryRequest, Repository>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/UpdateRepository")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRepositoryRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{repository.name=projects/*/locations/*/repositories/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "repository.name", request.getRepository().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("repository", request.getRepository(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Repository>newBuilder()
                      .setDefaultInstance(Repository.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRepositoryRequest, Empty>
      deleteRepositoryMethodDescriptor =
          ApiMethodDescriptor.<DeleteRepositoryRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/DeleteRepository")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRepositoryRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*}",
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
                            serializer.putQueryParam(fields, "force", request.getForce());
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

  private static final ApiMethodDescriptor<
          CommitRepositoryChangesRequest, CommitRepositoryChangesResponse>
      commitRepositoryChangesMethodDescriptor =
          ApiMethodDescriptor
              .<CommitRepositoryChangesRequest, CommitRepositoryChangesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CommitRepositoryChanges")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CommitRepositoryChangesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*}:commit",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CommitRepositoryChangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CommitRepositoryChangesRequest> serializer =
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
                  ProtoMessageResponseParser.<CommitRepositoryChangesResponse>newBuilder()
                      .setDefaultInstance(CommitRepositoryChangesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ReadRepositoryFileRequest, ReadRepositoryFileResponse>
      readRepositoryFileMethodDescriptor =
          ApiMethodDescriptor.<ReadRepositoryFileRequest, ReadRepositoryFileResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ReadRepositoryFile")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReadRepositoryFileRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*}:readFile",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReadRepositoryFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReadRepositoryFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "commitSha", request.getCommitSha());
                            serializer.putQueryParam(fields, "path", request.getPath());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReadRepositoryFileResponse>newBuilder()
                      .setDefaultInstance(ReadRepositoryFileResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsResponse>
      queryRepositoryDirectoryContentsMethodDescriptor =
          ApiMethodDescriptor
              .<QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.dataform.v1beta1.Dataform/QueryRepositoryDirectoryContents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryRepositoryDirectoryContentsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*}:queryDirectoryContents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryRepositoryDirectoryContentsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryRepositoryDirectoryContentsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "commitSha", request.getCommitSha());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "path", request.getPath());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QueryRepositoryDirectoryContentsResponse>newBuilder()
                      .setDefaultInstance(
                          QueryRepositoryDirectoryContentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse>
      fetchRepositoryHistoryMethodDescriptor =
          ApiMethodDescriptor
              .<FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/FetchRepositoryHistory")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchRepositoryHistoryRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*}:fetchHistory",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchRepositoryHistoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchRepositoryHistoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchRepositoryHistoryResponse>newBuilder()
                      .setDefaultInstance(FetchRepositoryHistoryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ComputeRepositoryAccessTokenStatusRequest, ComputeRepositoryAccessTokenStatusResponse>
      computeRepositoryAccessTokenStatusMethodDescriptor =
          ApiMethodDescriptor
              .<ComputeRepositoryAccessTokenStatusRequest,
                  ComputeRepositoryAccessTokenStatusResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.dataform.v1beta1.Dataform/ComputeRepositoryAccessTokenStatus")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ComputeRepositoryAccessTokenStatusRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*}:computeAccessTokenStatus",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeRepositoryAccessTokenStatusRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeRepositoryAccessTokenStatusRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ComputeRepositoryAccessTokenStatusResponse>newBuilder()
                      .setDefaultInstance(
                          ComputeRepositoryAccessTokenStatusResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>
      fetchRemoteBranchesMethodDescriptor =
          ApiMethodDescriptor.<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/FetchRemoteBranches")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchRemoteBranchesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*}:fetchRemoteBranches",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchRemoteBranchesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchRemoteBranchesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchRemoteBranchesResponse>newBuilder()
                      .setDefaultInstance(FetchRemoteBranchesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListWorkspacesRequest, ListWorkspacesResponse>
      listWorkspacesMethodDescriptor =
          ApiMethodDescriptor.<ListWorkspacesRequest, ListWorkspacesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ListWorkspaces")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWorkspacesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/repositories/*}/workspaces",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkspacesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkspacesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListWorkspacesResponse>newBuilder()
                      .setDefaultInstance(ListWorkspacesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetWorkspaceRequest, Workspace>
      getWorkspaceMethodDescriptor =
          ApiMethodDescriptor.<GetWorkspaceRequest, Workspace>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/GetWorkspace")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetWorkspaceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/workspaces/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkspaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkspaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Workspace>newBuilder()
                      .setDefaultInstance(Workspace.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateWorkspaceRequest, Workspace>
      createWorkspaceMethodDescriptor =
          ApiMethodDescriptor.<CreateWorkspaceRequest, Workspace>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CreateWorkspace")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateWorkspaceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/repositories/*}/workspaces",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkspaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkspaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "workspaceId", request.getWorkspaceId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("workspace", request.getWorkspace(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Workspace>newBuilder()
                      .setDefaultInstance(Workspace.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteWorkspaceRequest, Empty>
      deleteWorkspaceMethodDescriptor =
          ApiMethodDescriptor.<DeleteWorkspaceRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/DeleteWorkspace")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteWorkspaceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/workspaces/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkspaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkspaceRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<InstallNpmPackagesRequest, InstallNpmPackagesResponse>
      installNpmPackagesMethodDescriptor =
          ApiMethodDescriptor.<InstallNpmPackagesRequest, InstallNpmPackagesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/InstallNpmPackages")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InstallNpmPackagesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{workspace=projects/*/locations/*/repositories/*/workspaces/*}:installNpmPackages",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InstallNpmPackagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "workspace", request.getWorkspace());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InstallNpmPackagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearWorkspace().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstallNpmPackagesResponse>newBuilder()
                      .setDefaultInstance(InstallNpmPackagesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PullGitCommitsRequest, PullGitCommitsResponse>
      pullGitCommitsMethodDescriptor =
          ApiMethodDescriptor.<PullGitCommitsRequest, PullGitCommitsResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/PullGitCommits")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PullGitCommitsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/workspaces/*}:pull",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PullGitCommitsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PullGitCommitsRequest> serializer =
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
                  ProtoMessageResponseParser.<PullGitCommitsResponse>newBuilder()
                      .setDefaultInstance(PullGitCommitsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PushGitCommitsRequest, PushGitCommitsResponse>
      pushGitCommitsMethodDescriptor =
          ApiMethodDescriptor.<PushGitCommitsRequest, PushGitCommitsResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/PushGitCommits")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PushGitCommitsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/workspaces/*}:push",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PushGitCommitsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PushGitCommitsRequest> serializer =
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
                  ProtoMessageResponseParser.<PushGitCommitsResponse>newBuilder()
                      .setDefaultInstance(PushGitCommitsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
      fetchFileGitStatusesMethodDescriptor =
          ApiMethodDescriptor
              .<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/FetchFileGitStatuses")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchFileGitStatusesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/workspaces/*}:fetchFileGitStatuses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchFileGitStatusesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchFileGitStatusesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchFileGitStatusesResponse>newBuilder()
                      .setDefaultInstance(FetchFileGitStatusesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
      fetchGitAheadBehindMethodDescriptor =
          ApiMethodDescriptor.<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/FetchGitAheadBehind")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchGitAheadBehindRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/workspaces/*}:fetchGitAheadBehind",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchGitAheadBehindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchGitAheadBehindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "remoteBranch", request.getRemoteBranch());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchGitAheadBehindResponse>newBuilder()
                      .setDefaultInstance(FetchGitAheadBehindResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CommitWorkspaceChangesRequest, CommitWorkspaceChangesResponse>
      commitWorkspaceChangesMethodDescriptor =
          ApiMethodDescriptor
              .<CommitWorkspaceChangesRequest, CommitWorkspaceChangesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CommitWorkspaceChanges")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CommitWorkspaceChangesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/workspaces/*}:commit",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CommitWorkspaceChangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CommitWorkspaceChangesRequest> serializer =
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
                  ProtoMessageResponseParser.<CommitWorkspaceChangesResponse>newBuilder()
                      .setDefaultInstance(CommitWorkspaceChangesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ResetWorkspaceChangesRequest, ResetWorkspaceChangesResponse>
      resetWorkspaceChangesMethodDescriptor =
          ApiMethodDescriptor
              .<ResetWorkspaceChangesRequest, ResetWorkspaceChangesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ResetWorkspaceChanges")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResetWorkspaceChangesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/workspaces/*}:reset",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResetWorkspaceChangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResetWorkspaceChangesRequest> serializer =
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
                  ProtoMessageResponseParser.<ResetWorkspaceChangesResponse>newBuilder()
                      .setDefaultInstance(ResetWorkspaceChangesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FetchFileDiffRequest, FetchFileDiffResponse>
      fetchFileDiffMethodDescriptor =
          ApiMethodDescriptor.<FetchFileDiffRequest, FetchFileDiffResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/FetchFileDiff")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchFileDiffRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{workspace=projects/*/locations/*/repositories/*/workspaces/*}:fetchFileDiff",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchFileDiffRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "workspace", request.getWorkspace());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchFileDiffRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "path", request.getPath());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchFileDiffResponse>newBuilder()
                      .setDefaultInstance(FetchFileDiffResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          QueryDirectoryContentsRequest, QueryDirectoryContentsResponse>
      queryDirectoryContentsMethodDescriptor =
          ApiMethodDescriptor
              .<QueryDirectoryContentsRequest, QueryDirectoryContentsResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/QueryDirectoryContents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryDirectoryContentsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{workspace=projects/*/locations/*/repositories/*/workspaces/*}:queryDirectoryContents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryDirectoryContentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "workspace", request.getWorkspace());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryDirectoryContentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "path", request.getPath());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QueryDirectoryContentsResponse>newBuilder()
                      .setDefaultInstance(QueryDirectoryContentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchFilesRequest, SearchFilesResponse>
      searchFilesMethodDescriptor =
          ApiMethodDescriptor.<SearchFilesRequest, SearchFilesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/SearchFiles")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchFilesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{workspace=projects/*/locations/*/repositories/*/workspaces/*}:searchFiles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchFilesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "workspace", request.getWorkspace());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchFilesRequest> serializer =
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
                  ProtoMessageResponseParser.<SearchFilesResponse>newBuilder()
                      .setDefaultInstance(SearchFilesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<MakeDirectoryRequest, MakeDirectoryResponse>
      makeDirectoryMethodDescriptor =
          ApiMethodDescriptor.<MakeDirectoryRequest, MakeDirectoryResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/MakeDirectory")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MakeDirectoryRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{workspace=projects/*/locations/*/repositories/*/workspaces/*}:makeDirectory",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MakeDirectoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "workspace", request.getWorkspace());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MakeDirectoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearWorkspace().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MakeDirectoryResponse>newBuilder()
                      .setDefaultInstance(MakeDirectoryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RemoveDirectoryRequest, RemoveDirectoryResponse>
      removeDirectoryMethodDescriptor =
          ApiMethodDescriptor.<RemoveDirectoryRequest, RemoveDirectoryResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/RemoveDirectory")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveDirectoryRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{workspace=projects/*/locations/*/repositories/*/workspaces/*}:removeDirectory",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveDirectoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "workspace", request.getWorkspace());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveDirectoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearWorkspace().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RemoveDirectoryResponse>newBuilder()
                      .setDefaultInstance(RemoveDirectoryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<MoveDirectoryRequest, MoveDirectoryResponse>
      moveDirectoryMethodDescriptor =
          ApiMethodDescriptor.<MoveDirectoryRequest, MoveDirectoryResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/MoveDirectory")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MoveDirectoryRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{workspace=projects/*/locations/*/repositories/*/workspaces/*}:moveDirectory",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MoveDirectoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "workspace", request.getWorkspace());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MoveDirectoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearWorkspace().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MoveDirectoryResponse>newBuilder()
                      .setDefaultInstance(MoveDirectoryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ReadFileRequest, ReadFileResponse>
      readFileMethodDescriptor =
          ApiMethodDescriptor.<ReadFileRequest, ReadFileResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ReadFile")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReadFileRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{workspace=projects/*/locations/*/repositories/*/workspaces/*}:readFile",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReadFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "workspace", request.getWorkspace());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReadFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "path", request.getPath());
                            serializer.putQueryParam(fields, "revision", request.getRevision());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReadFileResponse>newBuilder()
                      .setDefaultInstance(ReadFileResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RemoveFileRequest, RemoveFileResponse>
      removeFileMethodDescriptor =
          ApiMethodDescriptor.<RemoveFileRequest, RemoveFileResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/RemoveFile")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveFileRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{workspace=projects/*/locations/*/repositories/*/workspaces/*}:removeFile",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "workspace", request.getWorkspace());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearWorkspace().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RemoveFileResponse>newBuilder()
                      .setDefaultInstance(RemoveFileResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<MoveFileRequest, MoveFileResponse>
      moveFileMethodDescriptor =
          ApiMethodDescriptor.<MoveFileRequest, MoveFileResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/MoveFile")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MoveFileRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{workspace=projects/*/locations/*/repositories/*/workspaces/*}:moveFile",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MoveFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "workspace", request.getWorkspace());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MoveFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearWorkspace().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MoveFileResponse>newBuilder()
                      .setDefaultInstance(MoveFileResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<WriteFileRequest, WriteFileResponse>
      writeFileMethodDescriptor =
          ApiMethodDescriptor.<WriteFileRequest, WriteFileResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/WriteFile")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<WriteFileRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{workspace=projects/*/locations/*/repositories/*/workspaces/*}:writeFile",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<WriteFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "workspace", request.getWorkspace());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<WriteFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearWorkspace().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<WriteFileResponse>newBuilder()
                      .setDefaultInstance(WriteFileResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListReleaseConfigsRequest, ListReleaseConfigsResponse>
      listReleaseConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListReleaseConfigsRequest, ListReleaseConfigsResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ListReleaseConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReleaseConfigsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/repositories/*}/releaseConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReleaseConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReleaseConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListReleaseConfigsResponse>newBuilder()
                      .setDefaultInstance(ListReleaseConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetReleaseConfigRequest, ReleaseConfig>
      getReleaseConfigMethodDescriptor =
          ApiMethodDescriptor.<GetReleaseConfigRequest, ReleaseConfig>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/GetReleaseConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReleaseConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/releaseConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReleaseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReleaseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReleaseConfig>newBuilder()
                      .setDefaultInstance(ReleaseConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateReleaseConfigRequest, ReleaseConfig>
      createReleaseConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateReleaseConfigRequest, ReleaseConfig>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CreateReleaseConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReleaseConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/repositories/*}/releaseConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReleaseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReleaseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "releaseConfigId", request.getReleaseConfigId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("releaseConfig", request.getReleaseConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReleaseConfig>newBuilder()
                      .setDefaultInstance(ReleaseConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateReleaseConfigRequest, ReleaseConfig>
      updateReleaseConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateReleaseConfigRequest, ReleaseConfig>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/UpdateReleaseConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateReleaseConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{releaseConfig.name=projects/*/locations/*/repositories/*/releaseConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReleaseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "releaseConfig.name", request.getReleaseConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReleaseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("releaseConfig", request.getReleaseConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReleaseConfig>newBuilder()
                      .setDefaultInstance(ReleaseConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteReleaseConfigRequest, Empty>
      deleteReleaseConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteReleaseConfigRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/DeleteReleaseConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteReleaseConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/releaseConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReleaseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReleaseConfigRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<
          ListCompilationResultsRequest, ListCompilationResultsResponse>
      listCompilationResultsMethodDescriptor =
          ApiMethodDescriptor
              .<ListCompilationResultsRequest, ListCompilationResultsResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ListCompilationResults")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCompilationResultsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/repositories/*}/compilationResults",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCompilationResultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCompilationResultsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCompilationResultsResponse>newBuilder()
                      .setDefaultInstance(ListCompilationResultsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCompilationResultRequest, CompilationResult>
      getCompilationResultMethodDescriptor =
          ApiMethodDescriptor.<GetCompilationResultRequest, CompilationResult>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/GetCompilationResult")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCompilationResultRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/compilationResults/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCompilationResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCompilationResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CompilationResult>newBuilder()
                      .setDefaultInstance(CompilationResult.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCompilationResultRequest, CompilationResult>
      createCompilationResultMethodDescriptor =
          ApiMethodDescriptor.<CreateCompilationResultRequest, CompilationResult>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CreateCompilationResult")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCompilationResultRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/repositories/*}/compilationResults",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCompilationResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCompilationResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "compilationResult", request.getCompilationResult(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CompilationResult>newBuilder()
                      .setDefaultInstance(CompilationResult.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          QueryCompilationResultActionsRequest, QueryCompilationResultActionsResponse>
      queryCompilationResultActionsMethodDescriptor =
          ApiMethodDescriptor
              .<QueryCompilationResultActionsRequest, QueryCompilationResultActionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.dataform.v1beta1.Dataform/QueryCompilationResultActions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryCompilationResultActionsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/compilationResults/*}:query",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryCompilationResultActionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryCompilationResultActionsRequest> serializer =
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
                  ProtoMessageResponseParser.<QueryCompilationResultActionsResponse>newBuilder()
                      .setDefaultInstance(
                          QueryCompilationResultActionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse>
      listWorkflowConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ListWorkflowConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWorkflowConfigsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/repositories/*}/workflowConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkflowConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkflowConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListWorkflowConfigsResponse>newBuilder()
                      .setDefaultInstance(ListWorkflowConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetWorkflowConfigRequest, WorkflowConfig>
      getWorkflowConfigMethodDescriptor =
          ApiMethodDescriptor.<GetWorkflowConfigRequest, WorkflowConfig>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/GetWorkflowConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetWorkflowConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/workflowConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkflowConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkflowConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<WorkflowConfig>newBuilder()
                      .setDefaultInstance(WorkflowConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateWorkflowConfigRequest, WorkflowConfig>
      createWorkflowConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateWorkflowConfigRequest, WorkflowConfig>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CreateWorkflowConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateWorkflowConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/repositories/*}/workflowConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkflowConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkflowConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "workflowConfigId", request.getWorkflowConfigId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("workflowConfig", request.getWorkflowConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<WorkflowConfig>newBuilder()
                      .setDefaultInstance(WorkflowConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateWorkflowConfigRequest, WorkflowConfig>
      updateWorkflowConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateWorkflowConfigRequest, WorkflowConfig>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/UpdateWorkflowConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateWorkflowConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{workflowConfig.name=projects/*/locations/*/repositories/*/workflowConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkflowConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "workflowConfig.name",
                                request.getWorkflowConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkflowConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("workflowConfig", request.getWorkflowConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<WorkflowConfig>newBuilder()
                      .setDefaultInstance(WorkflowConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteWorkflowConfigRequest, Empty>
      deleteWorkflowConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteWorkflowConfigRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/DeleteWorkflowConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteWorkflowConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/workflowConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkflowConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkflowConfigRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<
          ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse>
      listWorkflowInvocationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ListWorkflowInvocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWorkflowInvocationsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/repositories/*}/workflowInvocations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkflowInvocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkflowInvocationsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListWorkflowInvocationsResponse>newBuilder()
                      .setDefaultInstance(ListWorkflowInvocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetWorkflowInvocationRequest, WorkflowInvocation>
      getWorkflowInvocationMethodDescriptor =
          ApiMethodDescriptor.<GetWorkflowInvocationRequest, WorkflowInvocation>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/GetWorkflowInvocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetWorkflowInvocationRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/workflowInvocations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkflowInvocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkflowInvocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<WorkflowInvocation>newBuilder()
                      .setDefaultInstance(WorkflowInvocation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateWorkflowInvocationRequest, WorkflowInvocation>
      createWorkflowInvocationMethodDescriptor =
          ApiMethodDescriptor.<CreateWorkflowInvocationRequest, WorkflowInvocation>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CreateWorkflowInvocation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateWorkflowInvocationRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/repositories/*}/workflowInvocations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkflowInvocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkflowInvocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "workflowInvocation", request.getWorkflowInvocation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<WorkflowInvocation>newBuilder()
                      .setDefaultInstance(WorkflowInvocation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteWorkflowInvocationRequest, Empty>
      deleteWorkflowInvocationMethodDescriptor =
          ApiMethodDescriptor.<DeleteWorkflowInvocationRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/DeleteWorkflowInvocation")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteWorkflowInvocationRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/workflowInvocations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkflowInvocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkflowInvocationRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<
          CancelWorkflowInvocationRequest, CancelWorkflowInvocationResponse>
      cancelWorkflowInvocationMethodDescriptor =
          ApiMethodDescriptor
              .<CancelWorkflowInvocationRequest, CancelWorkflowInvocationResponse>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CancelWorkflowInvocation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CancelWorkflowInvocationRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/workflowInvocations/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelWorkflowInvocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelWorkflowInvocationRequest> serializer =
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
                  ProtoMessageResponseParser.<CancelWorkflowInvocationResponse>newBuilder()
                      .setDefaultInstance(CancelWorkflowInvocationResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsResponse>
      queryWorkflowInvocationActionsMethodDescriptor =
          ApiMethodDescriptor
              .<QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.dataform.v1beta1.Dataform/QueryWorkflowInvocationActions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryWorkflowInvocationActionsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/repositories/*/workflowInvocations/*}:query",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryWorkflowInvocationActionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryWorkflowInvocationActionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QueryWorkflowInvocationActionsResponse>newBuilder()
                      .setDefaultInstance(
                          QueryWorkflowInvocationActionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConfigRequest, Config> getConfigMethodDescriptor =
      ApiMethodDescriptor.<GetConfigRequest, Config>newBuilder()
          .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/GetConfig")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetConfigRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/locations/*/config}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetConfigRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetConfigRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Config>newBuilder()
                  .setDefaultInstance(Config.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateConfigRequest, Config>
      updateConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateConfigRequest, Config>newBuilder()
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/UpdateConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{config.name=projects/*/locations/*/config}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "config.name", request.getConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("config", request.getConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Config>newBuilder()
                      .setDefaultInstance(Config.getDefaultInstance())
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
                          "/v1beta1/{resource=projects/*/locations/*/repositories/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=projects/*/locations/*/repositories/*/workspaces/*}:setIamPolicy")
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
                          "/v1beta1/{resource=projects/*/locations/*/repositories/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=projects/*/locations/*/repositories/*/workspaces/*}:getIamPolicy")
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
                          "/v1beta1/{resource=projects/*/locations/*/repositories/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=projects/*/locations/*/repositories/*/workspaces/*}:testIamPermissions")
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

  private final UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesCallable;
  private final UnaryCallable<ListRepositoriesRequest, ListRepositoriesPagedResponse>
      listRepositoriesPagedCallable;
  private final UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable;
  private final UnaryCallable<CreateRepositoryRequest, Repository> createRepositoryCallable;
  private final UnaryCallable<UpdateRepositoryRequest, Repository> updateRepositoryCallable;
  private final UnaryCallable<DeleteRepositoryRequest, Empty> deleteRepositoryCallable;
  private final UnaryCallable<CommitRepositoryChangesRequest, CommitRepositoryChangesResponse>
      commitRepositoryChangesCallable;
  private final UnaryCallable<ReadRepositoryFileRequest, ReadRepositoryFileResponse>
      readRepositoryFileCallable;
  private final UnaryCallable<
          QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsResponse>
      queryRepositoryDirectoryContentsCallable;
  private final UnaryCallable<
          QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsPagedResponse>
      queryRepositoryDirectoryContentsPagedCallable;
  private final UnaryCallable<FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse>
      fetchRepositoryHistoryCallable;
  private final UnaryCallable<FetchRepositoryHistoryRequest, FetchRepositoryHistoryPagedResponse>
      fetchRepositoryHistoryPagedCallable;
  private final UnaryCallable<
          ComputeRepositoryAccessTokenStatusRequest, ComputeRepositoryAccessTokenStatusResponse>
      computeRepositoryAccessTokenStatusCallable;
  private final UnaryCallable<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>
      fetchRemoteBranchesCallable;
  private final UnaryCallable<ListWorkspacesRequest, ListWorkspacesResponse> listWorkspacesCallable;
  private final UnaryCallable<ListWorkspacesRequest, ListWorkspacesPagedResponse>
      listWorkspacesPagedCallable;
  private final UnaryCallable<GetWorkspaceRequest, Workspace> getWorkspaceCallable;
  private final UnaryCallable<CreateWorkspaceRequest, Workspace> createWorkspaceCallable;
  private final UnaryCallable<DeleteWorkspaceRequest, Empty> deleteWorkspaceCallable;
  private final UnaryCallable<InstallNpmPackagesRequest, InstallNpmPackagesResponse>
      installNpmPackagesCallable;
  private final UnaryCallable<PullGitCommitsRequest, PullGitCommitsResponse> pullGitCommitsCallable;
  private final UnaryCallable<PushGitCommitsRequest, PushGitCommitsResponse> pushGitCommitsCallable;
  private final UnaryCallable<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
      fetchFileGitStatusesCallable;
  private final UnaryCallable<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
      fetchGitAheadBehindCallable;
  private final UnaryCallable<CommitWorkspaceChangesRequest, CommitWorkspaceChangesResponse>
      commitWorkspaceChangesCallable;
  private final UnaryCallable<ResetWorkspaceChangesRequest, ResetWorkspaceChangesResponse>
      resetWorkspaceChangesCallable;
  private final UnaryCallable<FetchFileDiffRequest, FetchFileDiffResponse> fetchFileDiffCallable;
  private final UnaryCallable<QueryDirectoryContentsRequest, QueryDirectoryContentsResponse>
      queryDirectoryContentsCallable;
  private final UnaryCallable<QueryDirectoryContentsRequest, QueryDirectoryContentsPagedResponse>
      queryDirectoryContentsPagedCallable;
  private final UnaryCallable<SearchFilesRequest, SearchFilesResponse> searchFilesCallable;
  private final UnaryCallable<SearchFilesRequest, SearchFilesPagedResponse>
      searchFilesPagedCallable;
  private final UnaryCallable<MakeDirectoryRequest, MakeDirectoryResponse> makeDirectoryCallable;
  private final UnaryCallable<RemoveDirectoryRequest, RemoveDirectoryResponse>
      removeDirectoryCallable;
  private final UnaryCallable<MoveDirectoryRequest, MoveDirectoryResponse> moveDirectoryCallable;
  private final UnaryCallable<ReadFileRequest, ReadFileResponse> readFileCallable;
  private final UnaryCallable<RemoveFileRequest, RemoveFileResponse> removeFileCallable;
  private final UnaryCallable<MoveFileRequest, MoveFileResponse> moveFileCallable;
  private final UnaryCallable<WriteFileRequest, WriteFileResponse> writeFileCallable;
  private final UnaryCallable<ListReleaseConfigsRequest, ListReleaseConfigsResponse>
      listReleaseConfigsCallable;
  private final UnaryCallable<ListReleaseConfigsRequest, ListReleaseConfigsPagedResponse>
      listReleaseConfigsPagedCallable;
  private final UnaryCallable<GetReleaseConfigRequest, ReleaseConfig> getReleaseConfigCallable;
  private final UnaryCallable<CreateReleaseConfigRequest, ReleaseConfig>
      createReleaseConfigCallable;
  private final UnaryCallable<UpdateReleaseConfigRequest, ReleaseConfig>
      updateReleaseConfigCallable;
  private final UnaryCallable<DeleteReleaseConfigRequest, Empty> deleteReleaseConfigCallable;
  private final UnaryCallable<ListCompilationResultsRequest, ListCompilationResultsResponse>
      listCompilationResultsCallable;
  private final UnaryCallable<ListCompilationResultsRequest, ListCompilationResultsPagedResponse>
      listCompilationResultsPagedCallable;
  private final UnaryCallable<GetCompilationResultRequest, CompilationResult>
      getCompilationResultCallable;
  private final UnaryCallable<CreateCompilationResultRequest, CompilationResult>
      createCompilationResultCallable;
  private final UnaryCallable<
          QueryCompilationResultActionsRequest, QueryCompilationResultActionsResponse>
      queryCompilationResultActionsCallable;
  private final UnaryCallable<
          QueryCompilationResultActionsRequest, QueryCompilationResultActionsPagedResponse>
      queryCompilationResultActionsPagedCallable;
  private final UnaryCallable<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse>
      listWorkflowConfigsCallable;
  private final UnaryCallable<ListWorkflowConfigsRequest, ListWorkflowConfigsPagedResponse>
      listWorkflowConfigsPagedCallable;
  private final UnaryCallable<GetWorkflowConfigRequest, WorkflowConfig> getWorkflowConfigCallable;
  private final UnaryCallable<CreateWorkflowConfigRequest, WorkflowConfig>
      createWorkflowConfigCallable;
  private final UnaryCallable<UpdateWorkflowConfigRequest, WorkflowConfig>
      updateWorkflowConfigCallable;
  private final UnaryCallable<DeleteWorkflowConfigRequest, Empty> deleteWorkflowConfigCallable;
  private final UnaryCallable<ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse>
      listWorkflowInvocationsCallable;
  private final UnaryCallable<ListWorkflowInvocationsRequest, ListWorkflowInvocationsPagedResponse>
      listWorkflowInvocationsPagedCallable;
  private final UnaryCallable<GetWorkflowInvocationRequest, WorkflowInvocation>
      getWorkflowInvocationCallable;
  private final UnaryCallable<CreateWorkflowInvocationRequest, WorkflowInvocation>
      createWorkflowInvocationCallable;
  private final UnaryCallable<DeleteWorkflowInvocationRequest, Empty>
      deleteWorkflowInvocationCallable;
  private final UnaryCallable<CancelWorkflowInvocationRequest, CancelWorkflowInvocationResponse>
      cancelWorkflowInvocationCallable;
  private final UnaryCallable<
          QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsResponse>
      queryWorkflowInvocationActionsCallable;
  private final UnaryCallable<
          QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsPagedResponse>
      queryWorkflowInvocationActionsPagedCallable;
  private final UnaryCallable<GetConfigRequest, Config> getConfigCallable;
  private final UnaryCallable<UpdateConfigRequest, Config> updateConfigCallable;
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

  public static final HttpJsonDataformStub create(DataformStubSettings settings)
      throws IOException {
    return new HttpJsonDataformStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataformStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonDataformStub(
        DataformStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataformStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataformStub(
        DataformStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataformStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDataformStub(DataformStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDataformCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataformStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDataformStub(
      DataformStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

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
    HttpJsonCallSettings<CreateRepositoryRequest, Repository> createRepositoryTransportSettings =
        HttpJsonCallSettings.<CreateRepositoryRequest, Repository>newBuilder()
            .setMethodDescriptor(createRepositoryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateRepositoryRequest, Repository> updateRepositoryTransportSettings =
        HttpJsonCallSettings.<UpdateRepositoryRequest, Repository>newBuilder()
            .setMethodDescriptor(updateRepositoryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("repository.name", String.valueOf(request.getRepository().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteRepositoryRequest, Empty> deleteRepositoryTransportSettings =
        HttpJsonCallSettings.<DeleteRepositoryRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteRepositoryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CommitRepositoryChangesRequest, CommitRepositoryChangesResponse>
        commitRepositoryChangesTransportSettings =
            HttpJsonCallSettings
                .<CommitRepositoryChangesRequest, CommitRepositoryChangesResponse>newBuilder()
                .setMethodDescriptor(commitRepositoryChangesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ReadRepositoryFileRequest, ReadRepositoryFileResponse>
        readRepositoryFileTransportSettings =
            HttpJsonCallSettings.<ReadRepositoryFileRequest, ReadRepositoryFileResponse>newBuilder()
                .setMethodDescriptor(readRepositoryFileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsResponse>
        queryRepositoryDirectoryContentsTransportSettings =
            HttpJsonCallSettings
                .<QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsResponse>
                    newBuilder()
                .setMethodDescriptor(queryRepositoryDirectoryContentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse>
        fetchRepositoryHistoryTransportSettings =
            HttpJsonCallSettings
                .<FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse>newBuilder()
                .setMethodDescriptor(fetchRepositoryHistoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ComputeRepositoryAccessTokenStatusRequest, ComputeRepositoryAccessTokenStatusResponse>
        computeRepositoryAccessTokenStatusTransportSettings =
            HttpJsonCallSettings
                .<ComputeRepositoryAccessTokenStatusRequest,
                    ComputeRepositoryAccessTokenStatusResponse>
                    newBuilder()
                .setMethodDescriptor(computeRepositoryAccessTokenStatusMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>
        fetchRemoteBranchesTransportSettings =
            HttpJsonCallSettings
                .<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>newBuilder()
                .setMethodDescriptor(fetchRemoteBranchesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListWorkspacesRequest, ListWorkspacesResponse>
        listWorkspacesTransportSettings =
            HttpJsonCallSettings.<ListWorkspacesRequest, ListWorkspacesResponse>newBuilder()
                .setMethodDescriptor(listWorkspacesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetWorkspaceRequest, Workspace> getWorkspaceTransportSettings =
        HttpJsonCallSettings.<GetWorkspaceRequest, Workspace>newBuilder()
            .setMethodDescriptor(getWorkspaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateWorkspaceRequest, Workspace> createWorkspaceTransportSettings =
        HttpJsonCallSettings.<CreateWorkspaceRequest, Workspace>newBuilder()
            .setMethodDescriptor(createWorkspaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteWorkspaceRequest, Empty> deleteWorkspaceTransportSettings =
        HttpJsonCallSettings.<DeleteWorkspaceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteWorkspaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<InstallNpmPackagesRequest, InstallNpmPackagesResponse>
        installNpmPackagesTransportSettings =
            HttpJsonCallSettings.<InstallNpmPackagesRequest, InstallNpmPackagesResponse>newBuilder()
                .setMethodDescriptor(installNpmPackagesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("workspace", String.valueOf(request.getWorkspace()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<PullGitCommitsRequest, PullGitCommitsResponse>
        pullGitCommitsTransportSettings =
            HttpJsonCallSettings.<PullGitCommitsRequest, PullGitCommitsResponse>newBuilder()
                .setMethodDescriptor(pullGitCommitsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<PushGitCommitsRequest, PushGitCommitsResponse>
        pushGitCommitsTransportSettings =
            HttpJsonCallSettings.<PushGitCommitsRequest, PushGitCommitsResponse>newBuilder()
                .setMethodDescriptor(pushGitCommitsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
        fetchFileGitStatusesTransportSettings =
            HttpJsonCallSettings
                .<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>newBuilder()
                .setMethodDescriptor(fetchFileGitStatusesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
        fetchGitAheadBehindTransportSettings =
            HttpJsonCallSettings
                .<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>newBuilder()
                .setMethodDescriptor(fetchGitAheadBehindMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CommitWorkspaceChangesRequest, CommitWorkspaceChangesResponse>
        commitWorkspaceChangesTransportSettings =
            HttpJsonCallSettings
                .<CommitWorkspaceChangesRequest, CommitWorkspaceChangesResponse>newBuilder()
                .setMethodDescriptor(commitWorkspaceChangesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ResetWorkspaceChangesRequest, ResetWorkspaceChangesResponse>
        resetWorkspaceChangesTransportSettings =
            HttpJsonCallSettings
                .<ResetWorkspaceChangesRequest, ResetWorkspaceChangesResponse>newBuilder()
                .setMethodDescriptor(resetWorkspaceChangesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FetchFileDiffRequest, FetchFileDiffResponse>
        fetchFileDiffTransportSettings =
            HttpJsonCallSettings.<FetchFileDiffRequest, FetchFileDiffResponse>newBuilder()
                .setMethodDescriptor(fetchFileDiffMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("workspace", String.valueOf(request.getWorkspace()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<QueryDirectoryContentsRequest, QueryDirectoryContentsResponse>
        queryDirectoryContentsTransportSettings =
            HttpJsonCallSettings
                .<QueryDirectoryContentsRequest, QueryDirectoryContentsResponse>newBuilder()
                .setMethodDescriptor(queryDirectoryContentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("workspace", String.valueOf(request.getWorkspace()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SearchFilesRequest, SearchFilesResponse> searchFilesTransportSettings =
        HttpJsonCallSettings.<SearchFilesRequest, SearchFilesResponse>newBuilder()
            .setMethodDescriptor(searchFilesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("workspace", String.valueOf(request.getWorkspace()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<MakeDirectoryRequest, MakeDirectoryResponse>
        makeDirectoryTransportSettings =
            HttpJsonCallSettings.<MakeDirectoryRequest, MakeDirectoryResponse>newBuilder()
                .setMethodDescriptor(makeDirectoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("workspace", String.valueOf(request.getWorkspace()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RemoveDirectoryRequest, RemoveDirectoryResponse>
        removeDirectoryTransportSettings =
            HttpJsonCallSettings.<RemoveDirectoryRequest, RemoveDirectoryResponse>newBuilder()
                .setMethodDescriptor(removeDirectoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("workspace", String.valueOf(request.getWorkspace()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<MoveDirectoryRequest, MoveDirectoryResponse>
        moveDirectoryTransportSettings =
            HttpJsonCallSettings.<MoveDirectoryRequest, MoveDirectoryResponse>newBuilder()
                .setMethodDescriptor(moveDirectoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("workspace", String.valueOf(request.getWorkspace()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ReadFileRequest, ReadFileResponse> readFileTransportSettings =
        HttpJsonCallSettings.<ReadFileRequest, ReadFileResponse>newBuilder()
            .setMethodDescriptor(readFileMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("workspace", String.valueOf(request.getWorkspace()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RemoveFileRequest, RemoveFileResponse> removeFileTransportSettings =
        HttpJsonCallSettings.<RemoveFileRequest, RemoveFileResponse>newBuilder()
            .setMethodDescriptor(removeFileMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("workspace", String.valueOf(request.getWorkspace()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<MoveFileRequest, MoveFileResponse> moveFileTransportSettings =
        HttpJsonCallSettings.<MoveFileRequest, MoveFileResponse>newBuilder()
            .setMethodDescriptor(moveFileMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("workspace", String.valueOf(request.getWorkspace()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<WriteFileRequest, WriteFileResponse> writeFileTransportSettings =
        HttpJsonCallSettings.<WriteFileRequest, WriteFileResponse>newBuilder()
            .setMethodDescriptor(writeFileMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("workspace", String.valueOf(request.getWorkspace()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListReleaseConfigsRequest, ListReleaseConfigsResponse>
        listReleaseConfigsTransportSettings =
            HttpJsonCallSettings.<ListReleaseConfigsRequest, ListReleaseConfigsResponse>newBuilder()
                .setMethodDescriptor(listReleaseConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetReleaseConfigRequest, ReleaseConfig> getReleaseConfigTransportSettings =
        HttpJsonCallSettings.<GetReleaseConfigRequest, ReleaseConfig>newBuilder()
            .setMethodDescriptor(getReleaseConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateReleaseConfigRequest, ReleaseConfig>
        createReleaseConfigTransportSettings =
            HttpJsonCallSettings.<CreateReleaseConfigRequest, ReleaseConfig>newBuilder()
                .setMethodDescriptor(createReleaseConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateReleaseConfigRequest, ReleaseConfig>
        updateReleaseConfigTransportSettings =
            HttpJsonCallSettings.<UpdateReleaseConfigRequest, ReleaseConfig>newBuilder()
                .setMethodDescriptor(updateReleaseConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "release_config.name",
                          String.valueOf(request.getReleaseConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteReleaseConfigRequest, Empty> deleteReleaseConfigTransportSettings =
        HttpJsonCallSettings.<DeleteReleaseConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReleaseConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCompilationResultsRequest, ListCompilationResultsResponse>
        listCompilationResultsTransportSettings =
            HttpJsonCallSettings
                .<ListCompilationResultsRequest, ListCompilationResultsResponse>newBuilder()
                .setMethodDescriptor(listCompilationResultsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetCompilationResultRequest, CompilationResult>
        getCompilationResultTransportSettings =
            HttpJsonCallSettings.<GetCompilationResultRequest, CompilationResult>newBuilder()
                .setMethodDescriptor(getCompilationResultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateCompilationResultRequest, CompilationResult>
        createCompilationResultTransportSettings =
            HttpJsonCallSettings.<CreateCompilationResultRequest, CompilationResult>newBuilder()
                .setMethodDescriptor(createCompilationResultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            QueryCompilationResultActionsRequest, QueryCompilationResultActionsResponse>
        queryCompilationResultActionsTransportSettings =
            HttpJsonCallSettings
                .<QueryCompilationResultActionsRequest, QueryCompilationResultActionsResponse>
                    newBuilder()
                .setMethodDescriptor(queryCompilationResultActionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse>
        listWorkflowConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse>newBuilder()
                .setMethodDescriptor(listWorkflowConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetWorkflowConfigRequest, WorkflowConfig>
        getWorkflowConfigTransportSettings =
            HttpJsonCallSettings.<GetWorkflowConfigRequest, WorkflowConfig>newBuilder()
                .setMethodDescriptor(getWorkflowConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateWorkflowConfigRequest, WorkflowConfig>
        createWorkflowConfigTransportSettings =
            HttpJsonCallSettings.<CreateWorkflowConfigRequest, WorkflowConfig>newBuilder()
                .setMethodDescriptor(createWorkflowConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateWorkflowConfigRequest, WorkflowConfig>
        updateWorkflowConfigTransportSettings =
            HttpJsonCallSettings.<UpdateWorkflowConfigRequest, WorkflowConfig>newBuilder()
                .setMethodDescriptor(updateWorkflowConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "workflow_config.name",
                          String.valueOf(request.getWorkflowConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteWorkflowConfigRequest, Empty> deleteWorkflowConfigTransportSettings =
        HttpJsonCallSettings.<DeleteWorkflowConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteWorkflowConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse>
        listWorkflowInvocationsTransportSettings =
            HttpJsonCallSettings
                .<ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse>newBuilder()
                .setMethodDescriptor(listWorkflowInvocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetWorkflowInvocationRequest, WorkflowInvocation>
        getWorkflowInvocationTransportSettings =
            HttpJsonCallSettings.<GetWorkflowInvocationRequest, WorkflowInvocation>newBuilder()
                .setMethodDescriptor(getWorkflowInvocationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateWorkflowInvocationRequest, WorkflowInvocation>
        createWorkflowInvocationTransportSettings =
            HttpJsonCallSettings.<CreateWorkflowInvocationRequest, WorkflowInvocation>newBuilder()
                .setMethodDescriptor(createWorkflowInvocationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteWorkflowInvocationRequest, Empty>
        deleteWorkflowInvocationTransportSettings =
            HttpJsonCallSettings.<DeleteWorkflowInvocationRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteWorkflowInvocationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CancelWorkflowInvocationRequest, CancelWorkflowInvocationResponse>
        cancelWorkflowInvocationTransportSettings =
            HttpJsonCallSettings
                .<CancelWorkflowInvocationRequest, CancelWorkflowInvocationResponse>newBuilder()
                .setMethodDescriptor(cancelWorkflowInvocationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsResponse>
        queryWorkflowInvocationActionsTransportSettings =
            HttpJsonCallSettings
                .<QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsResponse>
                    newBuilder()
                .setMethodDescriptor(queryWorkflowInvocationActionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetConfigRequest, Config> getConfigTransportSettings =
        HttpJsonCallSettings.<GetConfigRequest, Config>newBuilder()
            .setMethodDescriptor(getConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateConfigRequest, Config> updateConfigTransportSettings =
        HttpJsonCallSettings.<UpdateConfigRequest, Config>newBuilder()
            .setMethodDescriptor(updateConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("config.name", String.valueOf(request.getConfig().getName()));
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

    this.listRepositoriesCallable =
        callableFactory.createUnaryCallable(
            listRepositoriesTransportSettings, settings.listRepositoriesSettings(), clientContext);
    this.listRepositoriesPagedCallable =
        callableFactory.createPagedCallable(
            listRepositoriesTransportSettings, settings.listRepositoriesSettings(), clientContext);
    this.getRepositoryCallable =
        callableFactory.createUnaryCallable(
            getRepositoryTransportSettings, settings.getRepositorySettings(), clientContext);
    this.createRepositoryCallable =
        callableFactory.createUnaryCallable(
            createRepositoryTransportSettings, settings.createRepositorySettings(), clientContext);
    this.updateRepositoryCallable =
        callableFactory.createUnaryCallable(
            updateRepositoryTransportSettings, settings.updateRepositorySettings(), clientContext);
    this.deleteRepositoryCallable =
        callableFactory.createUnaryCallable(
            deleteRepositoryTransportSettings, settings.deleteRepositorySettings(), clientContext);
    this.commitRepositoryChangesCallable =
        callableFactory.createUnaryCallable(
            commitRepositoryChangesTransportSettings,
            settings.commitRepositoryChangesSettings(),
            clientContext);
    this.readRepositoryFileCallable =
        callableFactory.createUnaryCallable(
            readRepositoryFileTransportSettings,
            settings.readRepositoryFileSettings(),
            clientContext);
    this.queryRepositoryDirectoryContentsCallable =
        callableFactory.createUnaryCallable(
            queryRepositoryDirectoryContentsTransportSettings,
            settings.queryRepositoryDirectoryContentsSettings(),
            clientContext);
    this.queryRepositoryDirectoryContentsPagedCallable =
        callableFactory.createPagedCallable(
            queryRepositoryDirectoryContentsTransportSettings,
            settings.queryRepositoryDirectoryContentsSettings(),
            clientContext);
    this.fetchRepositoryHistoryCallable =
        callableFactory.createUnaryCallable(
            fetchRepositoryHistoryTransportSettings,
            settings.fetchRepositoryHistorySettings(),
            clientContext);
    this.fetchRepositoryHistoryPagedCallable =
        callableFactory.createPagedCallable(
            fetchRepositoryHistoryTransportSettings,
            settings.fetchRepositoryHistorySettings(),
            clientContext);
    this.computeRepositoryAccessTokenStatusCallable =
        callableFactory.createUnaryCallable(
            computeRepositoryAccessTokenStatusTransportSettings,
            settings.computeRepositoryAccessTokenStatusSettings(),
            clientContext);
    this.fetchRemoteBranchesCallable =
        callableFactory.createUnaryCallable(
            fetchRemoteBranchesTransportSettings,
            settings.fetchRemoteBranchesSettings(),
            clientContext);
    this.listWorkspacesCallable =
        callableFactory.createUnaryCallable(
            listWorkspacesTransportSettings, settings.listWorkspacesSettings(), clientContext);
    this.listWorkspacesPagedCallable =
        callableFactory.createPagedCallable(
            listWorkspacesTransportSettings, settings.listWorkspacesSettings(), clientContext);
    this.getWorkspaceCallable =
        callableFactory.createUnaryCallable(
            getWorkspaceTransportSettings, settings.getWorkspaceSettings(), clientContext);
    this.createWorkspaceCallable =
        callableFactory.createUnaryCallable(
            createWorkspaceTransportSettings, settings.createWorkspaceSettings(), clientContext);
    this.deleteWorkspaceCallable =
        callableFactory.createUnaryCallable(
            deleteWorkspaceTransportSettings, settings.deleteWorkspaceSettings(), clientContext);
    this.installNpmPackagesCallable =
        callableFactory.createUnaryCallable(
            installNpmPackagesTransportSettings,
            settings.installNpmPackagesSettings(),
            clientContext);
    this.pullGitCommitsCallable =
        callableFactory.createUnaryCallable(
            pullGitCommitsTransportSettings, settings.pullGitCommitsSettings(), clientContext);
    this.pushGitCommitsCallable =
        callableFactory.createUnaryCallable(
            pushGitCommitsTransportSettings, settings.pushGitCommitsSettings(), clientContext);
    this.fetchFileGitStatusesCallable =
        callableFactory.createUnaryCallable(
            fetchFileGitStatusesTransportSettings,
            settings.fetchFileGitStatusesSettings(),
            clientContext);
    this.fetchGitAheadBehindCallable =
        callableFactory.createUnaryCallable(
            fetchGitAheadBehindTransportSettings,
            settings.fetchGitAheadBehindSettings(),
            clientContext);
    this.commitWorkspaceChangesCallable =
        callableFactory.createUnaryCallable(
            commitWorkspaceChangesTransportSettings,
            settings.commitWorkspaceChangesSettings(),
            clientContext);
    this.resetWorkspaceChangesCallable =
        callableFactory.createUnaryCallable(
            resetWorkspaceChangesTransportSettings,
            settings.resetWorkspaceChangesSettings(),
            clientContext);
    this.fetchFileDiffCallable =
        callableFactory.createUnaryCallable(
            fetchFileDiffTransportSettings, settings.fetchFileDiffSettings(), clientContext);
    this.queryDirectoryContentsCallable =
        callableFactory.createUnaryCallable(
            queryDirectoryContentsTransportSettings,
            settings.queryDirectoryContentsSettings(),
            clientContext);
    this.queryDirectoryContentsPagedCallable =
        callableFactory.createPagedCallable(
            queryDirectoryContentsTransportSettings,
            settings.queryDirectoryContentsSettings(),
            clientContext);
    this.searchFilesCallable =
        callableFactory.createUnaryCallable(
            searchFilesTransportSettings, settings.searchFilesSettings(), clientContext);
    this.searchFilesPagedCallable =
        callableFactory.createPagedCallable(
            searchFilesTransportSettings, settings.searchFilesSettings(), clientContext);
    this.makeDirectoryCallable =
        callableFactory.createUnaryCallable(
            makeDirectoryTransportSettings, settings.makeDirectorySettings(), clientContext);
    this.removeDirectoryCallable =
        callableFactory.createUnaryCallable(
            removeDirectoryTransportSettings, settings.removeDirectorySettings(), clientContext);
    this.moveDirectoryCallable =
        callableFactory.createUnaryCallable(
            moveDirectoryTransportSettings, settings.moveDirectorySettings(), clientContext);
    this.readFileCallable =
        callableFactory.createUnaryCallable(
            readFileTransportSettings, settings.readFileSettings(), clientContext);
    this.removeFileCallable =
        callableFactory.createUnaryCallable(
            removeFileTransportSettings, settings.removeFileSettings(), clientContext);
    this.moveFileCallable =
        callableFactory.createUnaryCallable(
            moveFileTransportSettings, settings.moveFileSettings(), clientContext);
    this.writeFileCallable =
        callableFactory.createUnaryCallable(
            writeFileTransportSettings, settings.writeFileSettings(), clientContext);
    this.listReleaseConfigsCallable =
        callableFactory.createUnaryCallable(
            listReleaseConfigsTransportSettings,
            settings.listReleaseConfigsSettings(),
            clientContext);
    this.listReleaseConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listReleaseConfigsTransportSettings,
            settings.listReleaseConfigsSettings(),
            clientContext);
    this.getReleaseConfigCallable =
        callableFactory.createUnaryCallable(
            getReleaseConfigTransportSettings, settings.getReleaseConfigSettings(), clientContext);
    this.createReleaseConfigCallable =
        callableFactory.createUnaryCallable(
            createReleaseConfigTransportSettings,
            settings.createReleaseConfigSettings(),
            clientContext);
    this.updateReleaseConfigCallable =
        callableFactory.createUnaryCallable(
            updateReleaseConfigTransportSettings,
            settings.updateReleaseConfigSettings(),
            clientContext);
    this.deleteReleaseConfigCallable =
        callableFactory.createUnaryCallable(
            deleteReleaseConfigTransportSettings,
            settings.deleteReleaseConfigSettings(),
            clientContext);
    this.listCompilationResultsCallable =
        callableFactory.createUnaryCallable(
            listCompilationResultsTransportSettings,
            settings.listCompilationResultsSettings(),
            clientContext);
    this.listCompilationResultsPagedCallable =
        callableFactory.createPagedCallable(
            listCompilationResultsTransportSettings,
            settings.listCompilationResultsSettings(),
            clientContext);
    this.getCompilationResultCallable =
        callableFactory.createUnaryCallable(
            getCompilationResultTransportSettings,
            settings.getCompilationResultSettings(),
            clientContext);
    this.createCompilationResultCallable =
        callableFactory.createUnaryCallable(
            createCompilationResultTransportSettings,
            settings.createCompilationResultSettings(),
            clientContext);
    this.queryCompilationResultActionsCallable =
        callableFactory.createUnaryCallable(
            queryCompilationResultActionsTransportSettings,
            settings.queryCompilationResultActionsSettings(),
            clientContext);
    this.queryCompilationResultActionsPagedCallable =
        callableFactory.createPagedCallable(
            queryCompilationResultActionsTransportSettings,
            settings.queryCompilationResultActionsSettings(),
            clientContext);
    this.listWorkflowConfigsCallable =
        callableFactory.createUnaryCallable(
            listWorkflowConfigsTransportSettings,
            settings.listWorkflowConfigsSettings(),
            clientContext);
    this.listWorkflowConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkflowConfigsTransportSettings,
            settings.listWorkflowConfigsSettings(),
            clientContext);
    this.getWorkflowConfigCallable =
        callableFactory.createUnaryCallable(
            getWorkflowConfigTransportSettings,
            settings.getWorkflowConfigSettings(),
            clientContext);
    this.createWorkflowConfigCallable =
        callableFactory.createUnaryCallable(
            createWorkflowConfigTransportSettings,
            settings.createWorkflowConfigSettings(),
            clientContext);
    this.updateWorkflowConfigCallable =
        callableFactory.createUnaryCallable(
            updateWorkflowConfigTransportSettings,
            settings.updateWorkflowConfigSettings(),
            clientContext);
    this.deleteWorkflowConfigCallable =
        callableFactory.createUnaryCallable(
            deleteWorkflowConfigTransportSettings,
            settings.deleteWorkflowConfigSettings(),
            clientContext);
    this.listWorkflowInvocationsCallable =
        callableFactory.createUnaryCallable(
            listWorkflowInvocationsTransportSettings,
            settings.listWorkflowInvocationsSettings(),
            clientContext);
    this.listWorkflowInvocationsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkflowInvocationsTransportSettings,
            settings.listWorkflowInvocationsSettings(),
            clientContext);
    this.getWorkflowInvocationCallable =
        callableFactory.createUnaryCallable(
            getWorkflowInvocationTransportSettings,
            settings.getWorkflowInvocationSettings(),
            clientContext);
    this.createWorkflowInvocationCallable =
        callableFactory.createUnaryCallable(
            createWorkflowInvocationTransportSettings,
            settings.createWorkflowInvocationSettings(),
            clientContext);
    this.deleteWorkflowInvocationCallable =
        callableFactory.createUnaryCallable(
            deleteWorkflowInvocationTransportSettings,
            settings.deleteWorkflowInvocationSettings(),
            clientContext);
    this.cancelWorkflowInvocationCallable =
        callableFactory.createUnaryCallable(
            cancelWorkflowInvocationTransportSettings,
            settings.cancelWorkflowInvocationSettings(),
            clientContext);
    this.queryWorkflowInvocationActionsCallable =
        callableFactory.createUnaryCallable(
            queryWorkflowInvocationActionsTransportSettings,
            settings.queryWorkflowInvocationActionsSettings(),
            clientContext);
    this.queryWorkflowInvocationActionsPagedCallable =
        callableFactory.createPagedCallable(
            queryWorkflowInvocationActionsTransportSettings,
            settings.queryWorkflowInvocationActionsSettings(),
            clientContext);
    this.getConfigCallable =
        callableFactory.createUnaryCallable(
            getConfigTransportSettings, settings.getConfigSettings(), clientContext);
    this.updateConfigCallable =
        callableFactory.createUnaryCallable(
            updateConfigTransportSettings, settings.updateConfigSettings(), clientContext);
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
    methodDescriptors.add(listRepositoriesMethodDescriptor);
    methodDescriptors.add(getRepositoryMethodDescriptor);
    methodDescriptors.add(createRepositoryMethodDescriptor);
    methodDescriptors.add(updateRepositoryMethodDescriptor);
    methodDescriptors.add(deleteRepositoryMethodDescriptor);
    methodDescriptors.add(commitRepositoryChangesMethodDescriptor);
    methodDescriptors.add(readRepositoryFileMethodDescriptor);
    methodDescriptors.add(queryRepositoryDirectoryContentsMethodDescriptor);
    methodDescriptors.add(fetchRepositoryHistoryMethodDescriptor);
    methodDescriptors.add(computeRepositoryAccessTokenStatusMethodDescriptor);
    methodDescriptors.add(fetchRemoteBranchesMethodDescriptor);
    methodDescriptors.add(listWorkspacesMethodDescriptor);
    methodDescriptors.add(getWorkspaceMethodDescriptor);
    methodDescriptors.add(createWorkspaceMethodDescriptor);
    methodDescriptors.add(deleteWorkspaceMethodDescriptor);
    methodDescriptors.add(installNpmPackagesMethodDescriptor);
    methodDescriptors.add(pullGitCommitsMethodDescriptor);
    methodDescriptors.add(pushGitCommitsMethodDescriptor);
    methodDescriptors.add(fetchFileGitStatusesMethodDescriptor);
    methodDescriptors.add(fetchGitAheadBehindMethodDescriptor);
    methodDescriptors.add(commitWorkspaceChangesMethodDescriptor);
    methodDescriptors.add(resetWorkspaceChangesMethodDescriptor);
    methodDescriptors.add(fetchFileDiffMethodDescriptor);
    methodDescriptors.add(queryDirectoryContentsMethodDescriptor);
    methodDescriptors.add(searchFilesMethodDescriptor);
    methodDescriptors.add(makeDirectoryMethodDescriptor);
    methodDescriptors.add(removeDirectoryMethodDescriptor);
    methodDescriptors.add(moveDirectoryMethodDescriptor);
    methodDescriptors.add(readFileMethodDescriptor);
    methodDescriptors.add(removeFileMethodDescriptor);
    methodDescriptors.add(moveFileMethodDescriptor);
    methodDescriptors.add(writeFileMethodDescriptor);
    methodDescriptors.add(listReleaseConfigsMethodDescriptor);
    methodDescriptors.add(getReleaseConfigMethodDescriptor);
    methodDescriptors.add(createReleaseConfigMethodDescriptor);
    methodDescriptors.add(updateReleaseConfigMethodDescriptor);
    methodDescriptors.add(deleteReleaseConfigMethodDescriptor);
    methodDescriptors.add(listCompilationResultsMethodDescriptor);
    methodDescriptors.add(getCompilationResultMethodDescriptor);
    methodDescriptors.add(createCompilationResultMethodDescriptor);
    methodDescriptors.add(queryCompilationResultActionsMethodDescriptor);
    methodDescriptors.add(listWorkflowConfigsMethodDescriptor);
    methodDescriptors.add(getWorkflowConfigMethodDescriptor);
    methodDescriptors.add(createWorkflowConfigMethodDescriptor);
    methodDescriptors.add(updateWorkflowConfigMethodDescriptor);
    methodDescriptors.add(deleteWorkflowConfigMethodDescriptor);
    methodDescriptors.add(listWorkflowInvocationsMethodDescriptor);
    methodDescriptors.add(getWorkflowInvocationMethodDescriptor);
    methodDescriptors.add(createWorkflowInvocationMethodDescriptor);
    methodDescriptors.add(deleteWorkflowInvocationMethodDescriptor);
    methodDescriptors.add(cancelWorkflowInvocationMethodDescriptor);
    methodDescriptors.add(queryWorkflowInvocationActionsMethodDescriptor);
    methodDescriptors.add(getConfigMethodDescriptor);
    methodDescriptors.add(updateConfigMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
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
  public UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable() {
    return getRepositoryCallable;
  }

  @Override
  public UnaryCallable<CreateRepositoryRequest, Repository> createRepositoryCallable() {
    return createRepositoryCallable;
  }

  @Override
  public UnaryCallable<UpdateRepositoryRequest, Repository> updateRepositoryCallable() {
    return updateRepositoryCallable;
  }

  @Override
  public UnaryCallable<DeleteRepositoryRequest, Empty> deleteRepositoryCallable() {
    return deleteRepositoryCallable;
  }

  @Override
  public UnaryCallable<CommitRepositoryChangesRequest, CommitRepositoryChangesResponse>
      commitRepositoryChangesCallable() {
    return commitRepositoryChangesCallable;
  }

  @Override
  public UnaryCallable<ReadRepositoryFileRequest, ReadRepositoryFileResponse>
      readRepositoryFileCallable() {
    return readRepositoryFileCallable;
  }

  @Override
  public UnaryCallable<
          QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsResponse>
      queryRepositoryDirectoryContentsCallable() {
    return queryRepositoryDirectoryContentsCallable;
  }

  @Override
  public UnaryCallable<
          QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsPagedResponse>
      queryRepositoryDirectoryContentsPagedCallable() {
    return queryRepositoryDirectoryContentsPagedCallable;
  }

  @Override
  public UnaryCallable<FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse>
      fetchRepositoryHistoryCallable() {
    return fetchRepositoryHistoryCallable;
  }

  @Override
  public UnaryCallable<FetchRepositoryHistoryRequest, FetchRepositoryHistoryPagedResponse>
      fetchRepositoryHistoryPagedCallable() {
    return fetchRepositoryHistoryPagedCallable;
  }

  @Override
  public UnaryCallable<
          ComputeRepositoryAccessTokenStatusRequest, ComputeRepositoryAccessTokenStatusResponse>
      computeRepositoryAccessTokenStatusCallable() {
    return computeRepositoryAccessTokenStatusCallable;
  }

  @Override
  public UnaryCallable<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>
      fetchRemoteBranchesCallable() {
    return fetchRemoteBranchesCallable;
  }

  @Override
  public UnaryCallable<ListWorkspacesRequest, ListWorkspacesResponse> listWorkspacesCallable() {
    return listWorkspacesCallable;
  }

  @Override
  public UnaryCallable<ListWorkspacesRequest, ListWorkspacesPagedResponse>
      listWorkspacesPagedCallable() {
    return listWorkspacesPagedCallable;
  }

  @Override
  public UnaryCallable<GetWorkspaceRequest, Workspace> getWorkspaceCallable() {
    return getWorkspaceCallable;
  }

  @Override
  public UnaryCallable<CreateWorkspaceRequest, Workspace> createWorkspaceCallable() {
    return createWorkspaceCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkspaceRequest, Empty> deleteWorkspaceCallable() {
    return deleteWorkspaceCallable;
  }

  @Override
  public UnaryCallable<InstallNpmPackagesRequest, InstallNpmPackagesResponse>
      installNpmPackagesCallable() {
    return installNpmPackagesCallable;
  }

  @Override
  public UnaryCallable<PullGitCommitsRequest, PullGitCommitsResponse> pullGitCommitsCallable() {
    return pullGitCommitsCallable;
  }

  @Override
  public UnaryCallable<PushGitCommitsRequest, PushGitCommitsResponse> pushGitCommitsCallable() {
    return pushGitCommitsCallable;
  }

  @Override
  public UnaryCallable<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
      fetchFileGitStatusesCallable() {
    return fetchFileGitStatusesCallable;
  }

  @Override
  public UnaryCallable<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
      fetchGitAheadBehindCallable() {
    return fetchGitAheadBehindCallable;
  }

  @Override
  public UnaryCallable<CommitWorkspaceChangesRequest, CommitWorkspaceChangesResponse>
      commitWorkspaceChangesCallable() {
    return commitWorkspaceChangesCallable;
  }

  @Override
  public UnaryCallable<ResetWorkspaceChangesRequest, ResetWorkspaceChangesResponse>
      resetWorkspaceChangesCallable() {
    return resetWorkspaceChangesCallable;
  }

  @Override
  public UnaryCallable<FetchFileDiffRequest, FetchFileDiffResponse> fetchFileDiffCallable() {
    return fetchFileDiffCallable;
  }

  @Override
  public UnaryCallable<QueryDirectoryContentsRequest, QueryDirectoryContentsResponse>
      queryDirectoryContentsCallable() {
    return queryDirectoryContentsCallable;
  }

  @Override
  public UnaryCallable<QueryDirectoryContentsRequest, QueryDirectoryContentsPagedResponse>
      queryDirectoryContentsPagedCallable() {
    return queryDirectoryContentsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchFilesRequest, SearchFilesResponse> searchFilesCallable() {
    return searchFilesCallable;
  }

  @Override
  public UnaryCallable<SearchFilesRequest, SearchFilesPagedResponse> searchFilesPagedCallable() {
    return searchFilesPagedCallable;
  }

  @Override
  public UnaryCallable<MakeDirectoryRequest, MakeDirectoryResponse> makeDirectoryCallable() {
    return makeDirectoryCallable;
  }

  @Override
  public UnaryCallable<RemoveDirectoryRequest, RemoveDirectoryResponse> removeDirectoryCallable() {
    return removeDirectoryCallable;
  }

  @Override
  public UnaryCallable<MoveDirectoryRequest, MoveDirectoryResponse> moveDirectoryCallable() {
    return moveDirectoryCallable;
  }

  @Override
  public UnaryCallable<ReadFileRequest, ReadFileResponse> readFileCallable() {
    return readFileCallable;
  }

  @Override
  public UnaryCallable<RemoveFileRequest, RemoveFileResponse> removeFileCallable() {
    return removeFileCallable;
  }

  @Override
  public UnaryCallable<MoveFileRequest, MoveFileResponse> moveFileCallable() {
    return moveFileCallable;
  }

  @Override
  public UnaryCallable<WriteFileRequest, WriteFileResponse> writeFileCallable() {
    return writeFileCallable;
  }

  @Override
  public UnaryCallable<ListReleaseConfigsRequest, ListReleaseConfigsResponse>
      listReleaseConfigsCallable() {
    return listReleaseConfigsCallable;
  }

  @Override
  public UnaryCallable<ListReleaseConfigsRequest, ListReleaseConfigsPagedResponse>
      listReleaseConfigsPagedCallable() {
    return listReleaseConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetReleaseConfigRequest, ReleaseConfig> getReleaseConfigCallable() {
    return getReleaseConfigCallable;
  }

  @Override
  public UnaryCallable<CreateReleaseConfigRequest, ReleaseConfig> createReleaseConfigCallable() {
    return createReleaseConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateReleaseConfigRequest, ReleaseConfig> updateReleaseConfigCallable() {
    return updateReleaseConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteReleaseConfigRequest, Empty> deleteReleaseConfigCallable() {
    return deleteReleaseConfigCallable;
  }

  @Override
  public UnaryCallable<ListCompilationResultsRequest, ListCompilationResultsResponse>
      listCompilationResultsCallable() {
    return listCompilationResultsCallable;
  }

  @Override
  public UnaryCallable<ListCompilationResultsRequest, ListCompilationResultsPagedResponse>
      listCompilationResultsPagedCallable() {
    return listCompilationResultsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCompilationResultRequest, CompilationResult>
      getCompilationResultCallable() {
    return getCompilationResultCallable;
  }

  @Override
  public UnaryCallable<CreateCompilationResultRequest, CompilationResult>
      createCompilationResultCallable() {
    return createCompilationResultCallable;
  }

  @Override
  public UnaryCallable<QueryCompilationResultActionsRequest, QueryCompilationResultActionsResponse>
      queryCompilationResultActionsCallable() {
    return queryCompilationResultActionsCallable;
  }

  @Override
  public UnaryCallable<
          QueryCompilationResultActionsRequest, QueryCompilationResultActionsPagedResponse>
      queryCompilationResultActionsPagedCallable() {
    return queryCompilationResultActionsPagedCallable;
  }

  @Override
  public UnaryCallable<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse>
      listWorkflowConfigsCallable() {
    return listWorkflowConfigsCallable;
  }

  @Override
  public UnaryCallable<ListWorkflowConfigsRequest, ListWorkflowConfigsPagedResponse>
      listWorkflowConfigsPagedCallable() {
    return listWorkflowConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetWorkflowConfigRequest, WorkflowConfig> getWorkflowConfigCallable() {
    return getWorkflowConfigCallable;
  }

  @Override
  public UnaryCallable<CreateWorkflowConfigRequest, WorkflowConfig> createWorkflowConfigCallable() {
    return createWorkflowConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkflowConfigRequest, WorkflowConfig> updateWorkflowConfigCallable() {
    return updateWorkflowConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkflowConfigRequest, Empty> deleteWorkflowConfigCallable() {
    return deleteWorkflowConfigCallable;
  }

  @Override
  public UnaryCallable<ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse>
      listWorkflowInvocationsCallable() {
    return listWorkflowInvocationsCallable;
  }

  @Override
  public UnaryCallable<ListWorkflowInvocationsRequest, ListWorkflowInvocationsPagedResponse>
      listWorkflowInvocationsPagedCallable() {
    return listWorkflowInvocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetWorkflowInvocationRequest, WorkflowInvocation>
      getWorkflowInvocationCallable() {
    return getWorkflowInvocationCallable;
  }

  @Override
  public UnaryCallable<CreateWorkflowInvocationRequest, WorkflowInvocation>
      createWorkflowInvocationCallable() {
    return createWorkflowInvocationCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkflowInvocationRequest, Empty> deleteWorkflowInvocationCallable() {
    return deleteWorkflowInvocationCallable;
  }

  @Override
  public UnaryCallable<CancelWorkflowInvocationRequest, CancelWorkflowInvocationResponse>
      cancelWorkflowInvocationCallable() {
    return cancelWorkflowInvocationCallable;
  }

  @Override
  public UnaryCallable<
          QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsResponse>
      queryWorkflowInvocationActionsCallable() {
    return queryWorkflowInvocationActionsCallable;
  }

  @Override
  public UnaryCallable<
          QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsPagedResponse>
      queryWorkflowInvocationActionsPagedCallable() {
    return queryWorkflowInvocationActionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetConfigRequest, Config> getConfigCallable() {
    return getConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateConfigRequest, Config> updateConfigCallable() {
    return updateConfigCallable;
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
