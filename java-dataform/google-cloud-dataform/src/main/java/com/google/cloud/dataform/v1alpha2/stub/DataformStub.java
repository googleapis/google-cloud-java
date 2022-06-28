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

package com.google.cloud.dataform.v1alpha2.stub;

import static com.google.cloud.dataform.v1alpha2.DataformClient.ListCompilationResultsPagedResponse;
import static com.google.cloud.dataform.v1alpha2.DataformClient.ListLocationsPagedResponse;
import static com.google.cloud.dataform.v1alpha2.DataformClient.ListRepositoriesPagedResponse;
import static com.google.cloud.dataform.v1alpha2.DataformClient.ListWorkflowInvocationsPagedResponse;
import static com.google.cloud.dataform.v1alpha2.DataformClient.ListWorkspacesPagedResponse;
import static com.google.cloud.dataform.v1alpha2.DataformClient.QueryCompilationResultActionsPagedResponse;
import static com.google.cloud.dataform.v1alpha2.DataformClient.QueryDirectoryContentsPagedResponse;
import static com.google.cloud.dataform.v1alpha2.DataformClient.QueryWorkflowInvocationActionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataform.v1alpha2.CancelWorkflowInvocationRequest;
import com.google.cloud.dataform.v1alpha2.CommitWorkspaceChangesRequest;
import com.google.cloud.dataform.v1alpha2.CompilationResult;
import com.google.cloud.dataform.v1alpha2.CreateCompilationResultRequest;
import com.google.cloud.dataform.v1alpha2.CreateRepositoryRequest;
import com.google.cloud.dataform.v1alpha2.CreateWorkflowInvocationRequest;
import com.google.cloud.dataform.v1alpha2.CreateWorkspaceRequest;
import com.google.cloud.dataform.v1alpha2.DeleteRepositoryRequest;
import com.google.cloud.dataform.v1alpha2.DeleteWorkflowInvocationRequest;
import com.google.cloud.dataform.v1alpha2.DeleteWorkspaceRequest;
import com.google.cloud.dataform.v1alpha2.FetchFileDiffRequest;
import com.google.cloud.dataform.v1alpha2.FetchFileDiffResponse;
import com.google.cloud.dataform.v1alpha2.FetchFileGitStatusesRequest;
import com.google.cloud.dataform.v1alpha2.FetchFileGitStatusesResponse;
import com.google.cloud.dataform.v1alpha2.FetchGitAheadBehindRequest;
import com.google.cloud.dataform.v1alpha2.FetchGitAheadBehindResponse;
import com.google.cloud.dataform.v1alpha2.FetchRemoteBranchesRequest;
import com.google.cloud.dataform.v1alpha2.FetchRemoteBranchesResponse;
import com.google.cloud.dataform.v1alpha2.GetCompilationResultRequest;
import com.google.cloud.dataform.v1alpha2.GetRepositoryRequest;
import com.google.cloud.dataform.v1alpha2.GetWorkflowInvocationRequest;
import com.google.cloud.dataform.v1alpha2.GetWorkspaceRequest;
import com.google.cloud.dataform.v1alpha2.InstallNpmPackagesRequest;
import com.google.cloud.dataform.v1alpha2.InstallNpmPackagesResponse;
import com.google.cloud.dataform.v1alpha2.ListCompilationResultsRequest;
import com.google.cloud.dataform.v1alpha2.ListCompilationResultsResponse;
import com.google.cloud.dataform.v1alpha2.ListRepositoriesRequest;
import com.google.cloud.dataform.v1alpha2.ListRepositoriesResponse;
import com.google.cloud.dataform.v1alpha2.ListWorkflowInvocationsRequest;
import com.google.cloud.dataform.v1alpha2.ListWorkflowInvocationsResponse;
import com.google.cloud.dataform.v1alpha2.ListWorkspacesRequest;
import com.google.cloud.dataform.v1alpha2.ListWorkspacesResponse;
import com.google.cloud.dataform.v1alpha2.MakeDirectoryRequest;
import com.google.cloud.dataform.v1alpha2.MakeDirectoryResponse;
import com.google.cloud.dataform.v1alpha2.MoveDirectoryRequest;
import com.google.cloud.dataform.v1alpha2.MoveDirectoryResponse;
import com.google.cloud.dataform.v1alpha2.MoveFileRequest;
import com.google.cloud.dataform.v1alpha2.MoveFileResponse;
import com.google.cloud.dataform.v1alpha2.PullGitCommitsRequest;
import com.google.cloud.dataform.v1alpha2.PushGitCommitsRequest;
import com.google.cloud.dataform.v1alpha2.QueryCompilationResultActionsRequest;
import com.google.cloud.dataform.v1alpha2.QueryCompilationResultActionsResponse;
import com.google.cloud.dataform.v1alpha2.QueryDirectoryContentsRequest;
import com.google.cloud.dataform.v1alpha2.QueryDirectoryContentsResponse;
import com.google.cloud.dataform.v1alpha2.QueryWorkflowInvocationActionsRequest;
import com.google.cloud.dataform.v1alpha2.QueryWorkflowInvocationActionsResponse;
import com.google.cloud.dataform.v1alpha2.ReadFileRequest;
import com.google.cloud.dataform.v1alpha2.ReadFileResponse;
import com.google.cloud.dataform.v1alpha2.RemoveDirectoryRequest;
import com.google.cloud.dataform.v1alpha2.RemoveFileRequest;
import com.google.cloud.dataform.v1alpha2.Repository;
import com.google.cloud.dataform.v1alpha2.ResetWorkspaceChangesRequest;
import com.google.cloud.dataform.v1alpha2.UpdateRepositoryRequest;
import com.google.cloud.dataform.v1alpha2.WorkflowInvocation;
import com.google.cloud.dataform.v1alpha2.Workspace;
import com.google.cloud.dataform.v1alpha2.WriteFileRequest;
import com.google.cloud.dataform.v1alpha2.WriteFileResponse;
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
@BetaApi
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

  public UnaryCallable<PullGitCommitsRequest, Empty> pullGitCommitsCallable() {
    throw new UnsupportedOperationException("Not implemented: pullGitCommitsCallable()");
  }

  public UnaryCallable<PushGitCommitsRequest, Empty> pushGitCommitsCallable() {
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

  public UnaryCallable<CommitWorkspaceChangesRequest, Empty> commitWorkspaceChangesCallable() {
    throw new UnsupportedOperationException("Not implemented: commitWorkspaceChangesCallable()");
  }

  public UnaryCallable<ResetWorkspaceChangesRequest, Empty> resetWorkspaceChangesCallable() {
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

  public UnaryCallable<MakeDirectoryRequest, MakeDirectoryResponse> makeDirectoryCallable() {
    throw new UnsupportedOperationException("Not implemented: makeDirectoryCallable()");
  }

  public UnaryCallable<RemoveDirectoryRequest, Empty> removeDirectoryCallable() {
    throw new UnsupportedOperationException("Not implemented: removeDirectoryCallable()");
  }

  public UnaryCallable<MoveDirectoryRequest, MoveDirectoryResponse> moveDirectoryCallable() {
    throw new UnsupportedOperationException("Not implemented: moveDirectoryCallable()");
  }

  public UnaryCallable<ReadFileRequest, ReadFileResponse> readFileCallable() {
    throw new UnsupportedOperationException("Not implemented: readFileCallable()");
  }

  public UnaryCallable<RemoveFileRequest, Empty> removeFileCallable() {
    throw new UnsupportedOperationException("Not implemented: removeFileCallable()");
  }

  public UnaryCallable<MoveFileRequest, MoveFileResponse> moveFileCallable() {
    throw new UnsupportedOperationException("Not implemented: moveFileCallable()");
  }

  public UnaryCallable<WriteFileRequest, WriteFileResponse> writeFileCallable() {
    throw new UnsupportedOperationException("Not implemented: writeFileCallable()");
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

  public UnaryCallable<CancelWorkflowInvocationRequest, Empty> cancelWorkflowInvocationCallable() {
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
