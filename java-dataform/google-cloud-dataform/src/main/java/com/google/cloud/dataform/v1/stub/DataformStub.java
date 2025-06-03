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

package com.google.cloud.dataform.v1.stub;

import static com.google.cloud.dataform.v1.DataformClient.FetchRepositoryHistoryPagedResponse;
import static com.google.cloud.dataform.v1.DataformClient.ListCompilationResultsPagedResponse;
import static com.google.cloud.dataform.v1.DataformClient.ListLocationsPagedResponse;
import static com.google.cloud.dataform.v1.DataformClient.ListReleaseConfigsPagedResponse;
import static com.google.cloud.dataform.v1.DataformClient.ListRepositoriesPagedResponse;
import static com.google.cloud.dataform.v1.DataformClient.ListWorkflowConfigsPagedResponse;
import static com.google.cloud.dataform.v1.DataformClient.ListWorkflowInvocationsPagedResponse;
import static com.google.cloud.dataform.v1.DataformClient.ListWorkspacesPagedResponse;
import static com.google.cloud.dataform.v1.DataformClient.QueryCompilationResultActionsPagedResponse;
import static com.google.cloud.dataform.v1.DataformClient.QueryDirectoryContentsPagedResponse;
import static com.google.cloud.dataform.v1.DataformClient.QueryRepositoryDirectoryContentsPagedResponse;
import static com.google.cloud.dataform.v1.DataformClient.QueryWorkflowInvocationActionsPagedResponse;
import static com.google.cloud.dataform.v1.DataformClient.SearchFilesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataform.v1.CancelWorkflowInvocationRequest;
import com.google.cloud.dataform.v1.CancelWorkflowInvocationResponse;
import com.google.cloud.dataform.v1.CommitRepositoryChangesRequest;
import com.google.cloud.dataform.v1.CommitRepositoryChangesResponse;
import com.google.cloud.dataform.v1.CommitWorkspaceChangesRequest;
import com.google.cloud.dataform.v1.CommitWorkspaceChangesResponse;
import com.google.cloud.dataform.v1.CompilationResult;
import com.google.cloud.dataform.v1.ComputeRepositoryAccessTokenStatusRequest;
import com.google.cloud.dataform.v1.ComputeRepositoryAccessTokenStatusResponse;
import com.google.cloud.dataform.v1.Config;
import com.google.cloud.dataform.v1.CreateCompilationResultRequest;
import com.google.cloud.dataform.v1.CreateReleaseConfigRequest;
import com.google.cloud.dataform.v1.CreateRepositoryRequest;
import com.google.cloud.dataform.v1.CreateWorkflowConfigRequest;
import com.google.cloud.dataform.v1.CreateWorkflowInvocationRequest;
import com.google.cloud.dataform.v1.CreateWorkspaceRequest;
import com.google.cloud.dataform.v1.DeleteReleaseConfigRequest;
import com.google.cloud.dataform.v1.DeleteRepositoryRequest;
import com.google.cloud.dataform.v1.DeleteWorkflowConfigRequest;
import com.google.cloud.dataform.v1.DeleteWorkflowInvocationRequest;
import com.google.cloud.dataform.v1.DeleteWorkspaceRequest;
import com.google.cloud.dataform.v1.FetchFileDiffRequest;
import com.google.cloud.dataform.v1.FetchFileDiffResponse;
import com.google.cloud.dataform.v1.FetchFileGitStatusesRequest;
import com.google.cloud.dataform.v1.FetchFileGitStatusesResponse;
import com.google.cloud.dataform.v1.FetchGitAheadBehindRequest;
import com.google.cloud.dataform.v1.FetchGitAheadBehindResponse;
import com.google.cloud.dataform.v1.FetchRemoteBranchesRequest;
import com.google.cloud.dataform.v1.FetchRemoteBranchesResponse;
import com.google.cloud.dataform.v1.FetchRepositoryHistoryRequest;
import com.google.cloud.dataform.v1.FetchRepositoryHistoryResponse;
import com.google.cloud.dataform.v1.GetCompilationResultRequest;
import com.google.cloud.dataform.v1.GetConfigRequest;
import com.google.cloud.dataform.v1.GetReleaseConfigRequest;
import com.google.cloud.dataform.v1.GetRepositoryRequest;
import com.google.cloud.dataform.v1.GetWorkflowConfigRequest;
import com.google.cloud.dataform.v1.GetWorkflowInvocationRequest;
import com.google.cloud.dataform.v1.GetWorkspaceRequest;
import com.google.cloud.dataform.v1.InstallNpmPackagesRequest;
import com.google.cloud.dataform.v1.InstallNpmPackagesResponse;
import com.google.cloud.dataform.v1.ListCompilationResultsRequest;
import com.google.cloud.dataform.v1.ListCompilationResultsResponse;
import com.google.cloud.dataform.v1.ListReleaseConfigsRequest;
import com.google.cloud.dataform.v1.ListReleaseConfigsResponse;
import com.google.cloud.dataform.v1.ListRepositoriesRequest;
import com.google.cloud.dataform.v1.ListRepositoriesResponse;
import com.google.cloud.dataform.v1.ListWorkflowConfigsRequest;
import com.google.cloud.dataform.v1.ListWorkflowConfigsResponse;
import com.google.cloud.dataform.v1.ListWorkflowInvocationsRequest;
import com.google.cloud.dataform.v1.ListWorkflowInvocationsResponse;
import com.google.cloud.dataform.v1.ListWorkspacesRequest;
import com.google.cloud.dataform.v1.ListWorkspacesResponse;
import com.google.cloud.dataform.v1.MakeDirectoryRequest;
import com.google.cloud.dataform.v1.MakeDirectoryResponse;
import com.google.cloud.dataform.v1.MoveDirectoryRequest;
import com.google.cloud.dataform.v1.MoveDirectoryResponse;
import com.google.cloud.dataform.v1.MoveFileRequest;
import com.google.cloud.dataform.v1.MoveFileResponse;
import com.google.cloud.dataform.v1.PullGitCommitsRequest;
import com.google.cloud.dataform.v1.PullGitCommitsResponse;
import com.google.cloud.dataform.v1.PushGitCommitsRequest;
import com.google.cloud.dataform.v1.PushGitCommitsResponse;
import com.google.cloud.dataform.v1.QueryCompilationResultActionsRequest;
import com.google.cloud.dataform.v1.QueryCompilationResultActionsResponse;
import com.google.cloud.dataform.v1.QueryDirectoryContentsRequest;
import com.google.cloud.dataform.v1.QueryDirectoryContentsResponse;
import com.google.cloud.dataform.v1.QueryRepositoryDirectoryContentsRequest;
import com.google.cloud.dataform.v1.QueryRepositoryDirectoryContentsResponse;
import com.google.cloud.dataform.v1.QueryWorkflowInvocationActionsRequest;
import com.google.cloud.dataform.v1.QueryWorkflowInvocationActionsResponse;
import com.google.cloud.dataform.v1.ReadFileRequest;
import com.google.cloud.dataform.v1.ReadFileResponse;
import com.google.cloud.dataform.v1.ReadRepositoryFileRequest;
import com.google.cloud.dataform.v1.ReadRepositoryFileResponse;
import com.google.cloud.dataform.v1.ReleaseConfig;
import com.google.cloud.dataform.v1.RemoveDirectoryRequest;
import com.google.cloud.dataform.v1.RemoveDirectoryResponse;
import com.google.cloud.dataform.v1.RemoveFileRequest;
import com.google.cloud.dataform.v1.RemoveFileResponse;
import com.google.cloud.dataform.v1.Repository;
import com.google.cloud.dataform.v1.ResetWorkspaceChangesRequest;
import com.google.cloud.dataform.v1.ResetWorkspaceChangesResponse;
import com.google.cloud.dataform.v1.SearchFilesRequest;
import com.google.cloud.dataform.v1.SearchFilesResponse;
import com.google.cloud.dataform.v1.UpdateConfigRequest;
import com.google.cloud.dataform.v1.UpdateReleaseConfigRequest;
import com.google.cloud.dataform.v1.UpdateRepositoryRequest;
import com.google.cloud.dataform.v1.UpdateWorkflowConfigRequest;
import com.google.cloud.dataform.v1.WorkflowConfig;
import com.google.cloud.dataform.v1.WorkflowInvocation;
import com.google.cloud.dataform.v1.Workspace;
import com.google.cloud.dataform.v1.WriteFileRequest;
import com.google.cloud.dataform.v1.WriteFileResponse;
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
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Dataform service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DataformStub implements BackgroundResource {

  public UnaryCallable<ListRepositoriesRequest, ListRepositoriesPagedResponse>
      listRepositoriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRepositoriesPagedCallable()");
  }

  public UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRepositoriesCallable()");
  }

  public UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable() {
    throw new UnsupportedOperationException("Not implemented: getRepositoryCallable()");
  }

  public UnaryCallable<CreateRepositoryRequest, Repository> createRepositoryCallable() {
    throw new UnsupportedOperationException("Not implemented: createRepositoryCallable()");
  }

  public UnaryCallable<UpdateRepositoryRequest, Repository> updateRepositoryCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRepositoryCallable()");
  }

  public UnaryCallable<DeleteRepositoryRequest, Empty> deleteRepositoryCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRepositoryCallable()");
  }

  public UnaryCallable<CommitRepositoryChangesRequest, CommitRepositoryChangesResponse>
      commitRepositoryChangesCallable() {
    throw new UnsupportedOperationException("Not implemented: commitRepositoryChangesCallable()");
  }

  public UnaryCallable<ReadRepositoryFileRequest, ReadRepositoryFileResponse>
      readRepositoryFileCallable() {
    throw new UnsupportedOperationException("Not implemented: readRepositoryFileCallable()");
  }

  public UnaryCallable<
          QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsPagedResponse>
      queryRepositoryDirectoryContentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryRepositoryDirectoryContentsPagedCallable()");
  }

  public UnaryCallable<
          QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsResponse>
      queryRepositoryDirectoryContentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryRepositoryDirectoryContentsCallable()");
  }

  public UnaryCallable<FetchRepositoryHistoryRequest, FetchRepositoryHistoryPagedResponse>
      fetchRepositoryHistoryPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchRepositoryHistoryPagedCallable()");
  }

  public UnaryCallable<FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse>
      fetchRepositoryHistoryCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchRepositoryHistoryCallable()");
  }

  public UnaryCallable<
          ComputeRepositoryAccessTokenStatusRequest, ComputeRepositoryAccessTokenStatusResponse>
      computeRepositoryAccessTokenStatusCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: computeRepositoryAccessTokenStatusCallable()");
  }

  public UnaryCallable<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>
      fetchRemoteBranchesCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchRemoteBranchesCallable()");
  }

  public UnaryCallable<ListWorkspacesRequest, ListWorkspacesPagedResponse>
      listWorkspacesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkspacesPagedCallable()");
  }

  public UnaryCallable<ListWorkspacesRequest, ListWorkspacesResponse> listWorkspacesCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkspacesCallable()");
  }

  public UnaryCallable<GetWorkspaceRequest, Workspace> getWorkspaceCallable() {
    throw new UnsupportedOperationException("Not implemented: getWorkspaceCallable()");
  }

  public UnaryCallable<CreateWorkspaceRequest, Workspace> createWorkspaceCallable() {
    throw new UnsupportedOperationException("Not implemented: createWorkspaceCallable()");
  }

  public UnaryCallable<DeleteWorkspaceRequest, Empty> deleteWorkspaceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWorkspaceCallable()");
  }

  public UnaryCallable<InstallNpmPackagesRequest, InstallNpmPackagesResponse>
      installNpmPackagesCallable() {
    throw new UnsupportedOperationException("Not implemented: installNpmPackagesCallable()");
  }

  public UnaryCallable<PullGitCommitsRequest, PullGitCommitsResponse> pullGitCommitsCallable() {
    throw new UnsupportedOperationException("Not implemented: pullGitCommitsCallable()");
  }

  public UnaryCallable<PushGitCommitsRequest, PushGitCommitsResponse> pushGitCommitsCallable() {
    throw new UnsupportedOperationException("Not implemented: pushGitCommitsCallable()");
  }

  public UnaryCallable<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
      fetchFileGitStatusesCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchFileGitStatusesCallable()");
  }

  public UnaryCallable<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
      fetchGitAheadBehindCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchGitAheadBehindCallable()");
  }

  public UnaryCallable<CommitWorkspaceChangesRequest, CommitWorkspaceChangesResponse>
      commitWorkspaceChangesCallable() {
    throw new UnsupportedOperationException("Not implemented: commitWorkspaceChangesCallable()");
  }

  public UnaryCallable<ResetWorkspaceChangesRequest, ResetWorkspaceChangesResponse>
      resetWorkspaceChangesCallable() {
    throw new UnsupportedOperationException("Not implemented: resetWorkspaceChangesCallable()");
  }

  public UnaryCallable<FetchFileDiffRequest, FetchFileDiffResponse> fetchFileDiffCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchFileDiffCallable()");
  }

  public UnaryCallable<QueryDirectoryContentsRequest, QueryDirectoryContentsPagedResponse>
      queryDirectoryContentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryDirectoryContentsPagedCallable()");
  }

  public UnaryCallable<QueryDirectoryContentsRequest, QueryDirectoryContentsResponse>
      queryDirectoryContentsCallable() {
    throw new UnsupportedOperationException("Not implemented: queryDirectoryContentsCallable()");
  }

  public UnaryCallable<SearchFilesRequest, SearchFilesPagedResponse> searchFilesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchFilesPagedCallable()");
  }

  public UnaryCallable<SearchFilesRequest, SearchFilesResponse> searchFilesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchFilesCallable()");
  }

  public UnaryCallable<MakeDirectoryRequest, MakeDirectoryResponse> makeDirectoryCallable() {
    throw new UnsupportedOperationException("Not implemented: makeDirectoryCallable()");
  }

  public UnaryCallable<RemoveDirectoryRequest, RemoveDirectoryResponse> removeDirectoryCallable() {
    throw new UnsupportedOperationException("Not implemented: removeDirectoryCallable()");
  }

  public UnaryCallable<MoveDirectoryRequest, MoveDirectoryResponse> moveDirectoryCallable() {
    throw new UnsupportedOperationException("Not implemented: moveDirectoryCallable()");
  }

  public UnaryCallable<ReadFileRequest, ReadFileResponse> readFileCallable() {
    throw new UnsupportedOperationException("Not implemented: readFileCallable()");
  }

  public UnaryCallable<RemoveFileRequest, RemoveFileResponse> removeFileCallable() {
    throw new UnsupportedOperationException("Not implemented: removeFileCallable()");
  }

  public UnaryCallable<MoveFileRequest, MoveFileResponse> moveFileCallable() {
    throw new UnsupportedOperationException("Not implemented: moveFileCallable()");
  }

  public UnaryCallable<WriteFileRequest, WriteFileResponse> writeFileCallable() {
    throw new UnsupportedOperationException("Not implemented: writeFileCallable()");
  }

  public UnaryCallable<ListReleaseConfigsRequest, ListReleaseConfigsPagedResponse>
      listReleaseConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReleaseConfigsPagedCallable()");
  }

  public UnaryCallable<ListReleaseConfigsRequest, ListReleaseConfigsResponse>
      listReleaseConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listReleaseConfigsCallable()");
  }

  public UnaryCallable<GetReleaseConfigRequest, ReleaseConfig> getReleaseConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getReleaseConfigCallable()");
  }

  public UnaryCallable<CreateReleaseConfigRequest, ReleaseConfig> createReleaseConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createReleaseConfigCallable()");
  }

  public UnaryCallable<UpdateReleaseConfigRequest, ReleaseConfig> updateReleaseConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateReleaseConfigCallable()");
  }

  public UnaryCallable<DeleteReleaseConfigRequest, Empty> deleteReleaseConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteReleaseConfigCallable()");
  }

  public UnaryCallable<ListCompilationResultsRequest, ListCompilationResultsPagedResponse>
      listCompilationResultsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCompilationResultsPagedCallable()");
  }

  public UnaryCallable<ListCompilationResultsRequest, ListCompilationResultsResponse>
      listCompilationResultsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCompilationResultsCallable()");
  }

  public UnaryCallable<GetCompilationResultRequest, CompilationResult>
      getCompilationResultCallable() {
    throw new UnsupportedOperationException("Not implemented: getCompilationResultCallable()");
  }

  public UnaryCallable<CreateCompilationResultRequest, CompilationResult>
      createCompilationResultCallable() {
    throw new UnsupportedOperationException("Not implemented: createCompilationResultCallable()");
  }

  public UnaryCallable<
          QueryCompilationResultActionsRequest, QueryCompilationResultActionsPagedResponse>
      queryCompilationResultActionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryCompilationResultActionsPagedCallable()");
  }

  public UnaryCallable<QueryCompilationResultActionsRequest, QueryCompilationResultActionsResponse>
      queryCompilationResultActionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryCompilationResultActionsCallable()");
  }

  public UnaryCallable<ListWorkflowConfigsRequest, ListWorkflowConfigsPagedResponse>
      listWorkflowConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkflowConfigsPagedCallable()");
  }

  public UnaryCallable<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse>
      listWorkflowConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkflowConfigsCallable()");
  }

  public UnaryCallable<GetWorkflowConfigRequest, WorkflowConfig> getWorkflowConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getWorkflowConfigCallable()");
  }

  public UnaryCallable<CreateWorkflowConfigRequest, WorkflowConfig> createWorkflowConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createWorkflowConfigCallable()");
  }

  public UnaryCallable<UpdateWorkflowConfigRequest, WorkflowConfig> updateWorkflowConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWorkflowConfigCallable()");
  }

  public UnaryCallable<DeleteWorkflowConfigRequest, Empty> deleteWorkflowConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWorkflowConfigCallable()");
  }

  public UnaryCallable<ListWorkflowInvocationsRequest, ListWorkflowInvocationsPagedResponse>
      listWorkflowInvocationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listWorkflowInvocationsPagedCallable()");
  }

  public UnaryCallable<ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse>
      listWorkflowInvocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkflowInvocationsCallable()");
  }

  public UnaryCallable<GetWorkflowInvocationRequest, WorkflowInvocation>
      getWorkflowInvocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getWorkflowInvocationCallable()");
  }

  public UnaryCallable<CreateWorkflowInvocationRequest, WorkflowInvocation>
      createWorkflowInvocationCallable() {
    throw new UnsupportedOperationException("Not implemented: createWorkflowInvocationCallable()");
  }

  public UnaryCallable<DeleteWorkflowInvocationRequest, Empty> deleteWorkflowInvocationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWorkflowInvocationCallable()");
  }

  public UnaryCallable<CancelWorkflowInvocationRequest, CancelWorkflowInvocationResponse>
      cancelWorkflowInvocationCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelWorkflowInvocationCallable()");
  }

  public UnaryCallable<
          QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsPagedResponse>
      queryWorkflowInvocationActionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryWorkflowInvocationActionsPagedCallable()");
  }

  public UnaryCallable<
          QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsResponse>
      queryWorkflowInvocationActionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryWorkflowInvocationActionsCallable()");
  }

  public UnaryCallable<GetConfigRequest, Config> getConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getConfigCallable()");
  }

  public UnaryCallable<UpdateConfigRequest, Config> updateConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConfigCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
