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
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Dataform service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDataformStub extends DataformStub {
  private static final MethodDescriptor<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesMethodDescriptor =
          MethodDescriptor.<ListRepositoriesRequest, ListRepositoriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ListRepositories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRepositoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRepositoriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRepositoryRequest, Repository>
      getRepositoryMethodDescriptor =
          MethodDescriptor.<GetRepositoryRequest, Repository>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/GetRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Repository.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateRepositoryRequest, Repository>
      createRepositoryMethodDescriptor =
          MethodDescriptor.<CreateRepositoryRequest, Repository>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CreateRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Repository.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateRepositoryRequest, Repository>
      updateRepositoryMethodDescriptor =
          MethodDescriptor.<UpdateRepositoryRequest, Repository>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/UpdateRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Repository.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRepositoryRequest, Empty>
      deleteRepositoryMethodDescriptor =
          MethodDescriptor.<DeleteRepositoryRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/DeleteRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CommitRepositoryChangesRequest, CommitRepositoryChangesResponse>
      commitRepositoryChangesMethodDescriptor =
          MethodDescriptor
              .<CommitRepositoryChangesRequest, CommitRepositoryChangesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CommitRepositoryChanges")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CommitRepositoryChangesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CommitRepositoryChangesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReadRepositoryFileRequest, ReadRepositoryFileResponse>
      readRepositoryFileMethodDescriptor =
          MethodDescriptor.<ReadRepositoryFileRequest, ReadRepositoryFileResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ReadRepositoryFile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReadRepositoryFileRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReadRepositoryFileResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsResponse>
      queryRepositoryDirectoryContentsMethodDescriptor =
          MethodDescriptor
              .<QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataform.v1beta1.Dataform/QueryRepositoryDirectoryContents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      QueryRepositoryDirectoryContentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      QueryRepositoryDirectoryContentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse>
      fetchRepositoryHistoryMethodDescriptor =
          MethodDescriptor
              .<FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/FetchRepositoryHistory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchRepositoryHistoryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchRepositoryHistoryResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ComputeRepositoryAccessTokenStatusRequest, ComputeRepositoryAccessTokenStatusResponse>
      computeRepositoryAccessTokenStatusMethodDescriptor =
          MethodDescriptor
              .<ComputeRepositoryAccessTokenStatusRequest,
                  ComputeRepositoryAccessTokenStatusResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataform.v1beta1.Dataform/ComputeRepositoryAccessTokenStatus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ComputeRepositoryAccessTokenStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ComputeRepositoryAccessTokenStatusResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>
      fetchRemoteBranchesMethodDescriptor =
          MethodDescriptor.<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/FetchRemoteBranches")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchRemoteBranchesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchRemoteBranchesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListWorkspacesRequest, ListWorkspacesResponse>
      listWorkspacesMethodDescriptor =
          MethodDescriptor.<ListWorkspacesRequest, ListWorkspacesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ListWorkspaces")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkspacesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkspacesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetWorkspaceRequest, Workspace>
      getWorkspaceMethodDescriptor =
          MethodDescriptor.<GetWorkspaceRequest, Workspace>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/GetWorkspace")
              .setRequestMarshaller(ProtoUtils.marshaller(GetWorkspaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Workspace.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateWorkspaceRequest, Workspace>
      createWorkspaceMethodDescriptor =
          MethodDescriptor.<CreateWorkspaceRequest, Workspace>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CreateWorkspace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWorkspaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Workspace.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteWorkspaceRequest, Empty>
      deleteWorkspaceMethodDescriptor =
          MethodDescriptor.<DeleteWorkspaceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/DeleteWorkspace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWorkspaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<InstallNpmPackagesRequest, InstallNpmPackagesResponse>
      installNpmPackagesMethodDescriptor =
          MethodDescriptor.<InstallNpmPackagesRequest, InstallNpmPackagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/InstallNpmPackages")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InstallNpmPackagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(InstallNpmPackagesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PullGitCommitsRequest, PullGitCommitsResponse>
      pullGitCommitsMethodDescriptor =
          MethodDescriptor.<PullGitCommitsRequest, PullGitCommitsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/PullGitCommits")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PullGitCommitsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PullGitCommitsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PushGitCommitsRequest, PushGitCommitsResponse>
      pushGitCommitsMethodDescriptor =
          MethodDescriptor.<PushGitCommitsRequest, PushGitCommitsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/PushGitCommits")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PushGitCommitsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PushGitCommitsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
      fetchFileGitStatusesMethodDescriptor =
          MethodDescriptor.<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/FetchFileGitStatuses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchFileGitStatusesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchFileGitStatusesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
      fetchGitAheadBehindMethodDescriptor =
          MethodDescriptor.<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/FetchGitAheadBehind")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchGitAheadBehindRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchGitAheadBehindResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CommitWorkspaceChangesRequest, CommitWorkspaceChangesResponse>
      commitWorkspaceChangesMethodDescriptor =
          MethodDescriptor
              .<CommitWorkspaceChangesRequest, CommitWorkspaceChangesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CommitWorkspaceChanges")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CommitWorkspaceChangesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CommitWorkspaceChangesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResetWorkspaceChangesRequest, ResetWorkspaceChangesResponse>
      resetWorkspaceChangesMethodDescriptor =
          MethodDescriptor.<ResetWorkspaceChangesRequest, ResetWorkspaceChangesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ResetWorkspaceChanges")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResetWorkspaceChangesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ResetWorkspaceChangesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FetchFileDiffRequest, FetchFileDiffResponse>
      fetchFileDiffMethodDescriptor =
          MethodDescriptor.<FetchFileDiffRequest, FetchFileDiffResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/FetchFileDiff")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchFileDiffRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchFileDiffResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          QueryDirectoryContentsRequest, QueryDirectoryContentsResponse>
      queryDirectoryContentsMethodDescriptor =
          MethodDescriptor
              .<QueryDirectoryContentsRequest, QueryDirectoryContentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/QueryDirectoryContents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryDirectoryContentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryDirectoryContentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchFilesRequest, SearchFilesResponse>
      searchFilesMethodDescriptor =
          MethodDescriptor.<SearchFilesRequest, SearchFilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/SearchFiles")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchFilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchFilesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<MakeDirectoryRequest, MakeDirectoryResponse>
      makeDirectoryMethodDescriptor =
          MethodDescriptor.<MakeDirectoryRequest, MakeDirectoryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/MakeDirectory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(MakeDirectoryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(MakeDirectoryResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RemoveDirectoryRequest, RemoveDirectoryResponse>
      removeDirectoryMethodDescriptor =
          MethodDescriptor.<RemoveDirectoryRequest, RemoveDirectoryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/RemoveDirectory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveDirectoryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RemoveDirectoryResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<MoveDirectoryRequest, MoveDirectoryResponse>
      moveDirectoryMethodDescriptor =
          MethodDescriptor.<MoveDirectoryRequest, MoveDirectoryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/MoveDirectory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(MoveDirectoryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(MoveDirectoryResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReadFileRequest, ReadFileResponse>
      readFileMethodDescriptor =
          MethodDescriptor.<ReadFileRequest, ReadFileResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ReadFile")
              .setRequestMarshaller(ProtoUtils.marshaller(ReadFileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReadFileResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RemoveFileRequest, RemoveFileResponse>
      removeFileMethodDescriptor =
          MethodDescriptor.<RemoveFileRequest, RemoveFileResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/RemoveFile")
              .setRequestMarshaller(ProtoUtils.marshaller(RemoveFileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RemoveFileResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<MoveFileRequest, MoveFileResponse>
      moveFileMethodDescriptor =
          MethodDescriptor.<MoveFileRequest, MoveFileResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/MoveFile")
              .setRequestMarshaller(ProtoUtils.marshaller(MoveFileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MoveFileResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<WriteFileRequest, WriteFileResponse>
      writeFileMethodDescriptor =
          MethodDescriptor.<WriteFileRequest, WriteFileResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/WriteFile")
              .setRequestMarshaller(ProtoUtils.marshaller(WriteFileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WriteFileResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListReleaseConfigsRequest, ListReleaseConfigsResponse>
      listReleaseConfigsMethodDescriptor =
          MethodDescriptor.<ListReleaseConfigsRequest, ListReleaseConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ListReleaseConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListReleaseConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReleaseConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetReleaseConfigRequest, ReleaseConfig>
      getReleaseConfigMethodDescriptor =
          MethodDescriptor.<GetReleaseConfigRequest, ReleaseConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/GetReleaseConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetReleaseConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReleaseConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateReleaseConfigRequest, ReleaseConfig>
      createReleaseConfigMethodDescriptor =
          MethodDescriptor.<CreateReleaseConfigRequest, ReleaseConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CreateReleaseConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateReleaseConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReleaseConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateReleaseConfigRequest, ReleaseConfig>
      updateReleaseConfigMethodDescriptor =
          MethodDescriptor.<UpdateReleaseConfigRequest, ReleaseConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/UpdateReleaseConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateReleaseConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReleaseConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteReleaseConfigRequest, Empty>
      deleteReleaseConfigMethodDescriptor =
          MethodDescriptor.<DeleteReleaseConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/DeleteReleaseConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteReleaseConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListCompilationResultsRequest, ListCompilationResultsResponse>
      listCompilationResultsMethodDescriptor =
          MethodDescriptor
              .<ListCompilationResultsRequest, ListCompilationResultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ListCompilationResults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCompilationResultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCompilationResultsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCompilationResultRequest, CompilationResult>
      getCompilationResultMethodDescriptor =
          MethodDescriptor.<GetCompilationResultRequest, CompilationResult>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/GetCompilationResult")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCompilationResultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CompilationResult.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCompilationResultRequest, CompilationResult>
      createCompilationResultMethodDescriptor =
          MethodDescriptor.<CreateCompilationResultRequest, CompilationResult>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CreateCompilationResult")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCompilationResultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CompilationResult.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          QueryCompilationResultActionsRequest, QueryCompilationResultActionsResponse>
      queryCompilationResultActionsMethodDescriptor =
          MethodDescriptor
              .<QueryCompilationResultActionsRequest, QueryCompilationResultActionsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataform.v1beta1.Dataform/QueryCompilationResultActions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryCompilationResultActionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryCompilationResultActionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse>
      listWorkflowConfigsMethodDescriptor =
          MethodDescriptor.<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ListWorkflowConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkflowConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkflowConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetWorkflowConfigRequest, WorkflowConfig>
      getWorkflowConfigMethodDescriptor =
          MethodDescriptor.<GetWorkflowConfigRequest, WorkflowConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/GetWorkflowConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetWorkflowConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WorkflowConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateWorkflowConfigRequest, WorkflowConfig>
      createWorkflowConfigMethodDescriptor =
          MethodDescriptor.<CreateWorkflowConfigRequest, WorkflowConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CreateWorkflowConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWorkflowConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WorkflowConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateWorkflowConfigRequest, WorkflowConfig>
      updateWorkflowConfigMethodDescriptor =
          MethodDescriptor.<UpdateWorkflowConfigRequest, WorkflowConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/UpdateWorkflowConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateWorkflowConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WorkflowConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteWorkflowConfigRequest, Empty>
      deleteWorkflowConfigMethodDescriptor =
          MethodDescriptor.<DeleteWorkflowConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/DeleteWorkflowConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWorkflowConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse>
      listWorkflowInvocationsMethodDescriptor =
          MethodDescriptor
              .<ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/ListWorkflowInvocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkflowInvocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkflowInvocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetWorkflowInvocationRequest, WorkflowInvocation>
      getWorkflowInvocationMethodDescriptor =
          MethodDescriptor.<GetWorkflowInvocationRequest, WorkflowInvocation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/GetWorkflowInvocation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetWorkflowInvocationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WorkflowInvocation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateWorkflowInvocationRequest, WorkflowInvocation>
      createWorkflowInvocationMethodDescriptor =
          MethodDescriptor.<CreateWorkflowInvocationRequest, WorkflowInvocation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CreateWorkflowInvocation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWorkflowInvocationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WorkflowInvocation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteWorkflowInvocationRequest, Empty>
      deleteWorkflowInvocationMethodDescriptor =
          MethodDescriptor.<DeleteWorkflowInvocationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/DeleteWorkflowInvocation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWorkflowInvocationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CancelWorkflowInvocationRequest, CancelWorkflowInvocationResponse>
      cancelWorkflowInvocationMethodDescriptor =
          MethodDescriptor
              .<CancelWorkflowInvocationRequest, CancelWorkflowInvocationResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/CancelWorkflowInvocation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelWorkflowInvocationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CancelWorkflowInvocationResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsResponse>
      queryWorkflowInvocationActionsMethodDescriptor =
          MethodDescriptor
              .<QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataform.v1beta1.Dataform/QueryWorkflowInvocationActions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryWorkflowInvocationActionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      QueryWorkflowInvocationActionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConfigRequest, Config> getConfigMethodDescriptor =
      MethodDescriptor.<GetConfigRequest, Config>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/GetConfig")
          .setRequestMarshaller(ProtoUtils.marshaller(GetConfigRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Config.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateConfigRequest, Config> updateConfigMethodDescriptor =
      MethodDescriptor.<UpdateConfigRequest, Config>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataform.v1beta1.Dataform/UpdateConfig")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateConfigRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Config.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataformStub create(DataformStubSettings settings) throws IOException {
    return new GrpcDataformStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataformStub create(ClientContext clientContext) throws IOException {
    return new GrpcDataformStub(DataformStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataformStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataformStub(
        DataformStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataformStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcDataformStub(DataformStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDataformCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataformStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcDataformStub(
      DataformStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListRepositoriesRequest, ListRepositoriesResponse>
        listRepositoriesTransportSettings =
            GrpcCallSettings.<ListRepositoriesRequest, ListRepositoriesResponse>newBuilder()
                .setMethodDescriptor(listRepositoriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetRepositoryRequest, Repository> getRepositoryTransportSettings =
        GrpcCallSettings.<GetRepositoryRequest, Repository>newBuilder()
            .setMethodDescriptor(getRepositoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateRepositoryRequest, Repository> createRepositoryTransportSettings =
        GrpcCallSettings.<CreateRepositoryRequest, Repository>newBuilder()
            .setMethodDescriptor(createRepositoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateRepositoryRequest, Repository> updateRepositoryTransportSettings =
        GrpcCallSettings.<UpdateRepositoryRequest, Repository>newBuilder()
            .setMethodDescriptor(updateRepositoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("repository.name", String.valueOf(request.getRepository().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteRepositoryRequest, Empty> deleteRepositoryTransportSettings =
        GrpcCallSettings.<DeleteRepositoryRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteRepositoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CommitRepositoryChangesRequest, CommitRepositoryChangesResponse>
        commitRepositoryChangesTransportSettings =
            GrpcCallSettings
                .<CommitRepositoryChangesRequest, CommitRepositoryChangesResponse>newBuilder()
                .setMethodDescriptor(commitRepositoryChangesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ReadRepositoryFileRequest, ReadRepositoryFileResponse>
        readRepositoryFileTransportSettings =
            GrpcCallSettings.<ReadRepositoryFileRequest, ReadRepositoryFileResponse>newBuilder()
                .setMethodDescriptor(readRepositoryFileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsResponse>
        queryRepositoryDirectoryContentsTransportSettings =
            GrpcCallSettings
                .<QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsResponse>
                    newBuilder()
                .setMethodDescriptor(queryRepositoryDirectoryContentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse>
        fetchRepositoryHistoryTransportSettings =
            GrpcCallSettings
                .<FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse>newBuilder()
                .setMethodDescriptor(fetchRepositoryHistoryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ComputeRepositoryAccessTokenStatusRequest, ComputeRepositoryAccessTokenStatusResponse>
        computeRepositoryAccessTokenStatusTransportSettings =
            GrpcCallSettings
                .<ComputeRepositoryAccessTokenStatusRequest,
                    ComputeRepositoryAccessTokenStatusResponse>
                    newBuilder()
                .setMethodDescriptor(computeRepositoryAccessTokenStatusMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>
        fetchRemoteBranchesTransportSettings =
            GrpcCallSettings.<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>newBuilder()
                .setMethodDescriptor(fetchRemoteBranchesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListWorkspacesRequest, ListWorkspacesResponse>
        listWorkspacesTransportSettings =
            GrpcCallSettings.<ListWorkspacesRequest, ListWorkspacesResponse>newBuilder()
                .setMethodDescriptor(listWorkspacesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetWorkspaceRequest, Workspace> getWorkspaceTransportSettings =
        GrpcCallSettings.<GetWorkspaceRequest, Workspace>newBuilder()
            .setMethodDescriptor(getWorkspaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateWorkspaceRequest, Workspace> createWorkspaceTransportSettings =
        GrpcCallSettings.<CreateWorkspaceRequest, Workspace>newBuilder()
            .setMethodDescriptor(createWorkspaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteWorkspaceRequest, Empty> deleteWorkspaceTransportSettings =
        GrpcCallSettings.<DeleteWorkspaceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteWorkspaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<InstallNpmPackagesRequest, InstallNpmPackagesResponse>
        installNpmPackagesTransportSettings =
            GrpcCallSettings.<InstallNpmPackagesRequest, InstallNpmPackagesResponse>newBuilder()
                .setMethodDescriptor(installNpmPackagesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("workspace", String.valueOf(request.getWorkspace()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<PullGitCommitsRequest, PullGitCommitsResponse>
        pullGitCommitsTransportSettings =
            GrpcCallSettings.<PullGitCommitsRequest, PullGitCommitsResponse>newBuilder()
                .setMethodDescriptor(pullGitCommitsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<PushGitCommitsRequest, PushGitCommitsResponse>
        pushGitCommitsTransportSettings =
            GrpcCallSettings.<PushGitCommitsRequest, PushGitCommitsResponse>newBuilder()
                .setMethodDescriptor(pushGitCommitsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
        fetchFileGitStatusesTransportSettings =
            GrpcCallSettings.<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>newBuilder()
                .setMethodDescriptor(fetchFileGitStatusesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
        fetchGitAheadBehindTransportSettings =
            GrpcCallSettings.<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>newBuilder()
                .setMethodDescriptor(fetchGitAheadBehindMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CommitWorkspaceChangesRequest, CommitWorkspaceChangesResponse>
        commitWorkspaceChangesTransportSettings =
            GrpcCallSettings
                .<CommitWorkspaceChangesRequest, CommitWorkspaceChangesResponse>newBuilder()
                .setMethodDescriptor(commitWorkspaceChangesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ResetWorkspaceChangesRequest, ResetWorkspaceChangesResponse>
        resetWorkspaceChangesTransportSettings =
            GrpcCallSettings
                .<ResetWorkspaceChangesRequest, ResetWorkspaceChangesResponse>newBuilder()
                .setMethodDescriptor(resetWorkspaceChangesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FetchFileDiffRequest, FetchFileDiffResponse> fetchFileDiffTransportSettings =
        GrpcCallSettings.<FetchFileDiffRequest, FetchFileDiffResponse>newBuilder()
            .setMethodDescriptor(fetchFileDiffMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("workspace", String.valueOf(request.getWorkspace()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<QueryDirectoryContentsRequest, QueryDirectoryContentsResponse>
        queryDirectoryContentsTransportSettings =
            GrpcCallSettings
                .<QueryDirectoryContentsRequest, QueryDirectoryContentsResponse>newBuilder()
                .setMethodDescriptor(queryDirectoryContentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("workspace", String.valueOf(request.getWorkspace()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchFilesRequest, SearchFilesResponse> searchFilesTransportSettings =
        GrpcCallSettings.<SearchFilesRequest, SearchFilesResponse>newBuilder()
            .setMethodDescriptor(searchFilesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("workspace", String.valueOf(request.getWorkspace()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<MakeDirectoryRequest, MakeDirectoryResponse> makeDirectoryTransportSettings =
        GrpcCallSettings.<MakeDirectoryRequest, MakeDirectoryResponse>newBuilder()
            .setMethodDescriptor(makeDirectoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("workspace", String.valueOf(request.getWorkspace()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RemoveDirectoryRequest, RemoveDirectoryResponse>
        removeDirectoryTransportSettings =
            GrpcCallSettings.<RemoveDirectoryRequest, RemoveDirectoryResponse>newBuilder()
                .setMethodDescriptor(removeDirectoryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("workspace", String.valueOf(request.getWorkspace()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<MoveDirectoryRequest, MoveDirectoryResponse> moveDirectoryTransportSettings =
        GrpcCallSettings.<MoveDirectoryRequest, MoveDirectoryResponse>newBuilder()
            .setMethodDescriptor(moveDirectoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("workspace", String.valueOf(request.getWorkspace()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ReadFileRequest, ReadFileResponse> readFileTransportSettings =
        GrpcCallSettings.<ReadFileRequest, ReadFileResponse>newBuilder()
            .setMethodDescriptor(readFileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("workspace", String.valueOf(request.getWorkspace()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RemoveFileRequest, RemoveFileResponse> removeFileTransportSettings =
        GrpcCallSettings.<RemoveFileRequest, RemoveFileResponse>newBuilder()
            .setMethodDescriptor(removeFileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("workspace", String.valueOf(request.getWorkspace()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<MoveFileRequest, MoveFileResponse> moveFileTransportSettings =
        GrpcCallSettings.<MoveFileRequest, MoveFileResponse>newBuilder()
            .setMethodDescriptor(moveFileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("workspace", String.valueOf(request.getWorkspace()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<WriteFileRequest, WriteFileResponse> writeFileTransportSettings =
        GrpcCallSettings.<WriteFileRequest, WriteFileResponse>newBuilder()
            .setMethodDescriptor(writeFileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("workspace", String.valueOf(request.getWorkspace()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListReleaseConfigsRequest, ListReleaseConfigsResponse>
        listReleaseConfigsTransportSettings =
            GrpcCallSettings.<ListReleaseConfigsRequest, ListReleaseConfigsResponse>newBuilder()
                .setMethodDescriptor(listReleaseConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetReleaseConfigRequest, ReleaseConfig> getReleaseConfigTransportSettings =
        GrpcCallSettings.<GetReleaseConfigRequest, ReleaseConfig>newBuilder()
            .setMethodDescriptor(getReleaseConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateReleaseConfigRequest, ReleaseConfig>
        createReleaseConfigTransportSettings =
            GrpcCallSettings.<CreateReleaseConfigRequest, ReleaseConfig>newBuilder()
                .setMethodDescriptor(createReleaseConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateReleaseConfigRequest, ReleaseConfig>
        updateReleaseConfigTransportSettings =
            GrpcCallSettings.<UpdateReleaseConfigRequest, ReleaseConfig>newBuilder()
                .setMethodDescriptor(updateReleaseConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "release_config.name",
                          String.valueOf(request.getReleaseConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteReleaseConfigRequest, Empty> deleteReleaseConfigTransportSettings =
        GrpcCallSettings.<DeleteReleaseConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReleaseConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListCompilationResultsRequest, ListCompilationResultsResponse>
        listCompilationResultsTransportSettings =
            GrpcCallSettings
                .<ListCompilationResultsRequest, ListCompilationResultsResponse>newBuilder()
                .setMethodDescriptor(listCompilationResultsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetCompilationResultRequest, CompilationResult>
        getCompilationResultTransportSettings =
            GrpcCallSettings.<GetCompilationResultRequest, CompilationResult>newBuilder()
                .setMethodDescriptor(getCompilationResultMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateCompilationResultRequest, CompilationResult>
        createCompilationResultTransportSettings =
            GrpcCallSettings.<CreateCompilationResultRequest, CompilationResult>newBuilder()
                .setMethodDescriptor(createCompilationResultMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<QueryCompilationResultActionsRequest, QueryCompilationResultActionsResponse>
        queryCompilationResultActionsTransportSettings =
            GrpcCallSettings
                .<QueryCompilationResultActionsRequest, QueryCompilationResultActionsResponse>
                    newBuilder()
                .setMethodDescriptor(queryCompilationResultActionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse>
        listWorkflowConfigsTransportSettings =
            GrpcCallSettings.<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse>newBuilder()
                .setMethodDescriptor(listWorkflowConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetWorkflowConfigRequest, WorkflowConfig> getWorkflowConfigTransportSettings =
        GrpcCallSettings.<GetWorkflowConfigRequest, WorkflowConfig>newBuilder()
            .setMethodDescriptor(getWorkflowConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateWorkflowConfigRequest, WorkflowConfig>
        createWorkflowConfigTransportSettings =
            GrpcCallSettings.<CreateWorkflowConfigRequest, WorkflowConfig>newBuilder()
                .setMethodDescriptor(createWorkflowConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateWorkflowConfigRequest, WorkflowConfig>
        updateWorkflowConfigTransportSettings =
            GrpcCallSettings.<UpdateWorkflowConfigRequest, WorkflowConfig>newBuilder()
                .setMethodDescriptor(updateWorkflowConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "workflow_config.name",
                          String.valueOf(request.getWorkflowConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteWorkflowConfigRequest, Empty> deleteWorkflowConfigTransportSettings =
        GrpcCallSettings.<DeleteWorkflowConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteWorkflowConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse>
        listWorkflowInvocationsTransportSettings =
            GrpcCallSettings
                .<ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse>newBuilder()
                .setMethodDescriptor(listWorkflowInvocationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetWorkflowInvocationRequest, WorkflowInvocation>
        getWorkflowInvocationTransportSettings =
            GrpcCallSettings.<GetWorkflowInvocationRequest, WorkflowInvocation>newBuilder()
                .setMethodDescriptor(getWorkflowInvocationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateWorkflowInvocationRequest, WorkflowInvocation>
        createWorkflowInvocationTransportSettings =
            GrpcCallSettings.<CreateWorkflowInvocationRequest, WorkflowInvocation>newBuilder()
                .setMethodDescriptor(createWorkflowInvocationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteWorkflowInvocationRequest, Empty>
        deleteWorkflowInvocationTransportSettings =
            GrpcCallSettings.<DeleteWorkflowInvocationRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteWorkflowInvocationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CancelWorkflowInvocationRequest, CancelWorkflowInvocationResponse>
        cancelWorkflowInvocationTransportSettings =
            GrpcCallSettings
                .<CancelWorkflowInvocationRequest, CancelWorkflowInvocationResponse>newBuilder()
                .setMethodDescriptor(cancelWorkflowInvocationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsResponse>
        queryWorkflowInvocationActionsTransportSettings =
            GrpcCallSettings
                .<QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsResponse>
                    newBuilder()
                .setMethodDescriptor(queryWorkflowInvocationActionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetConfigRequest, Config> getConfigTransportSettings =
        GrpcCallSettings.<GetConfigRequest, Config>newBuilder()
            .setMethodDescriptor(getConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateConfigRequest, Config> updateConfigTransportSettings =
        GrpcCallSettings.<UpdateConfigRequest, Config>newBuilder()
            .setMethodDescriptor(updateConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("config.name", String.valueOf(request.getConfig().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
