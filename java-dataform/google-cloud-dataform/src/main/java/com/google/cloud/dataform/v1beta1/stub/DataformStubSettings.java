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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataform.v1beta1.CancelWorkflowInvocationRequest;
import com.google.cloud.dataform.v1beta1.CancelWorkflowInvocationResponse;
import com.google.cloud.dataform.v1beta1.CommitLogEntry;
import com.google.cloud.dataform.v1beta1.CommitRepositoryChangesRequest;
import com.google.cloud.dataform.v1beta1.CommitRepositoryChangesResponse;
import com.google.cloud.dataform.v1beta1.CommitWorkspaceChangesRequest;
import com.google.cloud.dataform.v1beta1.CommitWorkspaceChangesResponse;
import com.google.cloud.dataform.v1beta1.CompilationResult;
import com.google.cloud.dataform.v1beta1.CompilationResultAction;
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
import com.google.cloud.dataform.v1beta1.DirectoryEntry;
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
import com.google.cloud.dataform.v1beta1.SearchResult;
import com.google.cloud.dataform.v1beta1.UpdateConfigRequest;
import com.google.cloud.dataform.v1beta1.UpdateReleaseConfigRequest;
import com.google.cloud.dataform.v1beta1.UpdateRepositoryRequest;
import com.google.cloud.dataform.v1beta1.UpdateWorkflowConfigRequest;
import com.google.cloud.dataform.v1beta1.WorkflowConfig;
import com.google.cloud.dataform.v1beta1.WorkflowInvocation;
import com.google.cloud.dataform.v1beta1.WorkflowInvocationAction;
import com.google.cloud.dataform.v1beta1.Workspace;
import com.google.cloud.dataform.v1beta1.WriteFileRequest;
import com.google.cloud.dataform.v1beta1.WriteFileResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataformStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getRepository:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataformStubSettings.Builder dataformSettingsBuilder = DataformStubSettings.newBuilder();
 * dataformSettingsBuilder
 *     .getRepositorySettings()
 *     .setRetrySettings(
 *         dataformSettingsBuilder
 *             .getRepositorySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * DataformStubSettings dataformSettings = dataformSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataformStubSettings extends StubSettings<DataformStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigquery")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final PagedCallSettings<
          ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
      listRepositoriesSettings;
  private final UnaryCallSettings<GetRepositoryRequest, Repository> getRepositorySettings;
  private final UnaryCallSettings<CreateRepositoryRequest, Repository> createRepositorySettings;
  private final UnaryCallSettings<UpdateRepositoryRequest, Repository> updateRepositorySettings;
  private final UnaryCallSettings<DeleteRepositoryRequest, Empty> deleteRepositorySettings;
  private final UnaryCallSettings<CommitRepositoryChangesRequest, CommitRepositoryChangesResponse>
      commitRepositoryChangesSettings;
  private final UnaryCallSettings<ReadRepositoryFileRequest, ReadRepositoryFileResponse>
      readRepositoryFileSettings;
  private final PagedCallSettings<
          QueryRepositoryDirectoryContentsRequest,
          QueryRepositoryDirectoryContentsResponse,
          QueryRepositoryDirectoryContentsPagedResponse>
      queryRepositoryDirectoryContentsSettings;
  private final PagedCallSettings<
          FetchRepositoryHistoryRequest,
          FetchRepositoryHistoryResponse,
          FetchRepositoryHistoryPagedResponse>
      fetchRepositoryHistorySettings;
  private final UnaryCallSettings<
          ComputeRepositoryAccessTokenStatusRequest, ComputeRepositoryAccessTokenStatusResponse>
      computeRepositoryAccessTokenStatusSettings;
  private final UnaryCallSettings<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>
      fetchRemoteBranchesSettings;
  private final PagedCallSettings<
          ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>
      listWorkspacesSettings;
  private final UnaryCallSettings<GetWorkspaceRequest, Workspace> getWorkspaceSettings;
  private final UnaryCallSettings<CreateWorkspaceRequest, Workspace> createWorkspaceSettings;
  private final UnaryCallSettings<DeleteWorkspaceRequest, Empty> deleteWorkspaceSettings;
  private final UnaryCallSettings<InstallNpmPackagesRequest, InstallNpmPackagesResponse>
      installNpmPackagesSettings;
  private final UnaryCallSettings<PullGitCommitsRequest, PullGitCommitsResponse>
      pullGitCommitsSettings;
  private final UnaryCallSettings<PushGitCommitsRequest, PushGitCommitsResponse>
      pushGitCommitsSettings;
  private final UnaryCallSettings<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
      fetchFileGitStatusesSettings;
  private final UnaryCallSettings<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
      fetchGitAheadBehindSettings;
  private final UnaryCallSettings<CommitWorkspaceChangesRequest, CommitWorkspaceChangesResponse>
      commitWorkspaceChangesSettings;
  private final UnaryCallSettings<ResetWorkspaceChangesRequest, ResetWorkspaceChangesResponse>
      resetWorkspaceChangesSettings;
  private final UnaryCallSettings<FetchFileDiffRequest, FetchFileDiffResponse>
      fetchFileDiffSettings;
  private final PagedCallSettings<
          QueryDirectoryContentsRequest,
          QueryDirectoryContentsResponse,
          QueryDirectoryContentsPagedResponse>
      queryDirectoryContentsSettings;
  private final PagedCallSettings<SearchFilesRequest, SearchFilesResponse, SearchFilesPagedResponse>
      searchFilesSettings;
  private final UnaryCallSettings<MakeDirectoryRequest, MakeDirectoryResponse>
      makeDirectorySettings;
  private final UnaryCallSettings<RemoveDirectoryRequest, RemoveDirectoryResponse>
      removeDirectorySettings;
  private final UnaryCallSettings<MoveDirectoryRequest, MoveDirectoryResponse>
      moveDirectorySettings;
  private final UnaryCallSettings<ReadFileRequest, ReadFileResponse> readFileSettings;
  private final UnaryCallSettings<RemoveFileRequest, RemoveFileResponse> removeFileSettings;
  private final UnaryCallSettings<MoveFileRequest, MoveFileResponse> moveFileSettings;
  private final UnaryCallSettings<WriteFileRequest, WriteFileResponse> writeFileSettings;
  private final PagedCallSettings<
          ListReleaseConfigsRequest, ListReleaseConfigsResponse, ListReleaseConfigsPagedResponse>
      listReleaseConfigsSettings;
  private final UnaryCallSettings<GetReleaseConfigRequest, ReleaseConfig> getReleaseConfigSettings;
  private final UnaryCallSettings<CreateReleaseConfigRequest, ReleaseConfig>
      createReleaseConfigSettings;
  private final UnaryCallSettings<UpdateReleaseConfigRequest, ReleaseConfig>
      updateReleaseConfigSettings;
  private final UnaryCallSettings<DeleteReleaseConfigRequest, Empty> deleteReleaseConfigSettings;
  private final PagedCallSettings<
          ListCompilationResultsRequest,
          ListCompilationResultsResponse,
          ListCompilationResultsPagedResponse>
      listCompilationResultsSettings;
  private final UnaryCallSettings<GetCompilationResultRequest, CompilationResult>
      getCompilationResultSettings;
  private final UnaryCallSettings<CreateCompilationResultRequest, CompilationResult>
      createCompilationResultSettings;
  private final PagedCallSettings<
          QueryCompilationResultActionsRequest,
          QueryCompilationResultActionsResponse,
          QueryCompilationResultActionsPagedResponse>
      queryCompilationResultActionsSettings;
  private final PagedCallSettings<
          ListWorkflowConfigsRequest, ListWorkflowConfigsResponse, ListWorkflowConfigsPagedResponse>
      listWorkflowConfigsSettings;
  private final UnaryCallSettings<GetWorkflowConfigRequest, WorkflowConfig>
      getWorkflowConfigSettings;
  private final UnaryCallSettings<CreateWorkflowConfigRequest, WorkflowConfig>
      createWorkflowConfigSettings;
  private final UnaryCallSettings<UpdateWorkflowConfigRequest, WorkflowConfig>
      updateWorkflowConfigSettings;
  private final UnaryCallSettings<DeleteWorkflowConfigRequest, Empty> deleteWorkflowConfigSettings;
  private final PagedCallSettings<
          ListWorkflowInvocationsRequest,
          ListWorkflowInvocationsResponse,
          ListWorkflowInvocationsPagedResponse>
      listWorkflowInvocationsSettings;
  private final UnaryCallSettings<GetWorkflowInvocationRequest, WorkflowInvocation>
      getWorkflowInvocationSettings;
  private final UnaryCallSettings<CreateWorkflowInvocationRequest, WorkflowInvocation>
      createWorkflowInvocationSettings;
  private final UnaryCallSettings<DeleteWorkflowInvocationRequest, Empty>
      deleteWorkflowInvocationSettings;
  private final UnaryCallSettings<CancelWorkflowInvocationRequest, CancelWorkflowInvocationResponse>
      cancelWorkflowInvocationSettings;
  private final PagedCallSettings<
          QueryWorkflowInvocationActionsRequest,
          QueryWorkflowInvocationActionsResponse,
          QueryWorkflowInvocationActionsPagedResponse>
      queryWorkflowInvocationActionsSettings;
  private final UnaryCallSettings<GetConfigRequest, Config> getConfigSettings;
  private final UnaryCallSettings<UpdateConfigRequest, Config> updateConfigSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListRepositoriesRequest, ListRepositoriesResponse, Repository>
      LIST_REPOSITORIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListRepositoriesRequest, ListRepositoriesResponse, Repository>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRepositoriesRequest injectToken(
                ListRepositoriesRequest payload, String token) {
              return ListRepositoriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRepositoriesRequest injectPageSize(
                ListRepositoriesRequest payload, int pageSize) {
              return ListRepositoriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRepositoriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRepositoriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Repository> extractResources(ListRepositoriesResponse payload) {
              return payload.getRepositoriesList();
            }
          };

  private static final PagedListDescriptor<
          QueryRepositoryDirectoryContentsRequest,
          QueryRepositoryDirectoryContentsResponse,
          DirectoryEntry>
      QUERY_REPOSITORY_DIRECTORY_CONTENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              QueryRepositoryDirectoryContentsRequest,
              QueryRepositoryDirectoryContentsResponse,
              DirectoryEntry>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public QueryRepositoryDirectoryContentsRequest injectToken(
                QueryRepositoryDirectoryContentsRequest payload, String token) {
              return QueryRepositoryDirectoryContentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public QueryRepositoryDirectoryContentsRequest injectPageSize(
                QueryRepositoryDirectoryContentsRequest payload, int pageSize) {
              return QueryRepositoryDirectoryContentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(QueryRepositoryDirectoryContentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(QueryRepositoryDirectoryContentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DirectoryEntry> extractResources(
                QueryRepositoryDirectoryContentsResponse payload) {
              return payload.getDirectoryEntriesList();
            }
          };

  private static final PagedListDescriptor<
          FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse, CommitLogEntry>
      FETCH_REPOSITORY_HISTORY_PAGE_STR_DESC =
          new PagedListDescriptor<
              FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse, CommitLogEntry>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchRepositoryHistoryRequest injectToken(
                FetchRepositoryHistoryRequest payload, String token) {
              return FetchRepositoryHistoryRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public FetchRepositoryHistoryRequest injectPageSize(
                FetchRepositoryHistoryRequest payload, int pageSize) {
              return FetchRepositoryHistoryRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(FetchRepositoryHistoryRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchRepositoryHistoryResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CommitLogEntry> extractResources(
                FetchRepositoryHistoryResponse payload) {
              return payload.getCommitsList();
            }
          };

  private static final PagedListDescriptor<ListWorkspacesRequest, ListWorkspacesResponse, Workspace>
      LIST_WORKSPACES_PAGE_STR_DESC =
          new PagedListDescriptor<ListWorkspacesRequest, ListWorkspacesResponse, Workspace>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkspacesRequest injectToken(ListWorkspacesRequest payload, String token) {
              return ListWorkspacesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWorkspacesRequest injectPageSize(
                ListWorkspacesRequest payload, int pageSize) {
              return ListWorkspacesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListWorkspacesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkspacesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Workspace> extractResources(ListWorkspacesResponse payload) {
              return payload.getWorkspacesList();
            }
          };

  private static final PagedListDescriptor<
          QueryDirectoryContentsRequest, QueryDirectoryContentsResponse, DirectoryEntry>
      QUERY_DIRECTORY_CONTENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              QueryDirectoryContentsRequest, QueryDirectoryContentsResponse, DirectoryEntry>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public QueryDirectoryContentsRequest injectToken(
                QueryDirectoryContentsRequest payload, String token) {
              return QueryDirectoryContentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public QueryDirectoryContentsRequest injectPageSize(
                QueryDirectoryContentsRequest payload, int pageSize) {
              return QueryDirectoryContentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(QueryDirectoryContentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(QueryDirectoryContentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DirectoryEntry> extractResources(
                QueryDirectoryContentsResponse payload) {
              return payload.getDirectoryEntriesList();
            }
          };

  private static final PagedListDescriptor<SearchFilesRequest, SearchFilesResponse, SearchResult>
      SEARCH_FILES_PAGE_STR_DESC =
          new PagedListDescriptor<SearchFilesRequest, SearchFilesResponse, SearchResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchFilesRequest injectToken(SearchFilesRequest payload, String token) {
              return SearchFilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchFilesRequest injectPageSize(SearchFilesRequest payload, int pageSize) {
              return SearchFilesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchFilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchFilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SearchResult> extractResources(SearchFilesResponse payload) {
              return payload.getSearchResultsList();
            }
          };

  private static final PagedListDescriptor<
          ListReleaseConfigsRequest, ListReleaseConfigsResponse, ReleaseConfig>
      LIST_RELEASE_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListReleaseConfigsRequest, ListReleaseConfigsResponse, ReleaseConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReleaseConfigsRequest injectToken(
                ListReleaseConfigsRequest payload, String token) {
              return ListReleaseConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReleaseConfigsRequest injectPageSize(
                ListReleaseConfigsRequest payload, int pageSize) {
              return ListReleaseConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReleaseConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReleaseConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ReleaseConfig> extractResources(ListReleaseConfigsResponse payload) {
              return payload.getReleaseConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListCompilationResultsRequest, ListCompilationResultsResponse, CompilationResult>
      LIST_COMPILATION_RESULTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCompilationResultsRequest, ListCompilationResultsResponse, CompilationResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCompilationResultsRequest injectToken(
                ListCompilationResultsRequest payload, String token) {
              return ListCompilationResultsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCompilationResultsRequest injectPageSize(
                ListCompilationResultsRequest payload, int pageSize) {
              return ListCompilationResultsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListCompilationResultsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCompilationResultsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CompilationResult> extractResources(
                ListCompilationResultsResponse payload) {
              return payload.getCompilationResultsList();
            }
          };

  private static final PagedListDescriptor<
          QueryCompilationResultActionsRequest,
          QueryCompilationResultActionsResponse,
          CompilationResultAction>
      QUERY_COMPILATION_RESULT_ACTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              QueryCompilationResultActionsRequest,
              QueryCompilationResultActionsResponse,
              CompilationResultAction>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public QueryCompilationResultActionsRequest injectToken(
                QueryCompilationResultActionsRequest payload, String token) {
              return QueryCompilationResultActionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public QueryCompilationResultActionsRequest injectPageSize(
                QueryCompilationResultActionsRequest payload, int pageSize) {
              return QueryCompilationResultActionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(QueryCompilationResultActionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(QueryCompilationResultActionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CompilationResultAction> extractResources(
                QueryCompilationResultActionsResponse payload) {
              return payload.getCompilationResultActionsList();
            }
          };

  private static final PagedListDescriptor<
          ListWorkflowConfigsRequest, ListWorkflowConfigsResponse, WorkflowConfig>
      LIST_WORKFLOW_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListWorkflowConfigsRequest, ListWorkflowConfigsResponse, WorkflowConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkflowConfigsRequest injectToken(
                ListWorkflowConfigsRequest payload, String token) {
              return ListWorkflowConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWorkflowConfigsRequest injectPageSize(
                ListWorkflowConfigsRequest payload, int pageSize) {
              return ListWorkflowConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListWorkflowConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkflowConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<WorkflowConfig> extractResources(ListWorkflowConfigsResponse payload) {
              return payload.getWorkflowConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse, WorkflowInvocation>
      LIST_WORKFLOW_INVOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListWorkflowInvocationsRequest,
              ListWorkflowInvocationsResponse,
              WorkflowInvocation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkflowInvocationsRequest injectToken(
                ListWorkflowInvocationsRequest payload, String token) {
              return ListWorkflowInvocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWorkflowInvocationsRequest injectPageSize(
                ListWorkflowInvocationsRequest payload, int pageSize) {
              return ListWorkflowInvocationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListWorkflowInvocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkflowInvocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<WorkflowInvocation> extractResources(
                ListWorkflowInvocationsResponse payload) {
              return payload.getWorkflowInvocationsList();
            }
          };

  private static final PagedListDescriptor<
          QueryWorkflowInvocationActionsRequest,
          QueryWorkflowInvocationActionsResponse,
          WorkflowInvocationAction>
      QUERY_WORKFLOW_INVOCATION_ACTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              QueryWorkflowInvocationActionsRequest,
              QueryWorkflowInvocationActionsResponse,
              WorkflowInvocationAction>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public QueryWorkflowInvocationActionsRequest injectToken(
                QueryWorkflowInvocationActionsRequest payload, String token) {
              return QueryWorkflowInvocationActionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public QueryWorkflowInvocationActionsRequest injectPageSize(
                QueryWorkflowInvocationActionsRequest payload, int pageSize) {
              return QueryWorkflowInvocationActionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(QueryWorkflowInvocationActionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(QueryWorkflowInvocationActionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<WorkflowInvocationAction> extractResources(
                QueryWorkflowInvocationActionsResponse payload) {
              return payload.getWorkflowInvocationActionsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
      LIST_REPOSITORIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>() {
            @Override
            public ApiFuture<ListRepositoriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse> callable,
                ListRepositoriesRequest request,
                ApiCallContext context,
                ApiFuture<ListRepositoriesResponse> futureResponse) {
              PageContext<ListRepositoriesRequest, ListRepositoriesResponse, Repository>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REPOSITORIES_PAGE_STR_DESC, request, context);
              return ListRepositoriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          QueryRepositoryDirectoryContentsRequest,
          QueryRepositoryDirectoryContentsResponse,
          QueryRepositoryDirectoryContentsPagedResponse>
      QUERY_REPOSITORY_DIRECTORY_CONTENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              QueryRepositoryDirectoryContentsRequest,
              QueryRepositoryDirectoryContentsResponse,
              QueryRepositoryDirectoryContentsPagedResponse>() {
            @Override
            public ApiFuture<QueryRepositoryDirectoryContentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        QueryRepositoryDirectoryContentsRequest,
                        QueryRepositoryDirectoryContentsResponse>
                    callable,
                QueryRepositoryDirectoryContentsRequest request,
                ApiCallContext context,
                ApiFuture<QueryRepositoryDirectoryContentsResponse> futureResponse) {
              PageContext<
                      QueryRepositoryDirectoryContentsRequest,
                      QueryRepositoryDirectoryContentsResponse,
                      DirectoryEntry>
                  pageContext =
                      PageContext.create(
                          callable,
                          QUERY_REPOSITORY_DIRECTORY_CONTENTS_PAGE_STR_DESC,
                          request,
                          context);
              return QueryRepositoryDirectoryContentsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchRepositoryHistoryRequest,
          FetchRepositoryHistoryResponse,
          FetchRepositoryHistoryPagedResponse>
      FETCH_REPOSITORY_HISTORY_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchRepositoryHistoryRequest,
              FetchRepositoryHistoryResponse,
              FetchRepositoryHistoryPagedResponse>() {
            @Override
            public ApiFuture<FetchRepositoryHistoryPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse>
                    callable,
                FetchRepositoryHistoryRequest request,
                ApiCallContext context,
                ApiFuture<FetchRepositoryHistoryResponse> futureResponse) {
              PageContext<
                      FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse, CommitLogEntry>
                  pageContext =
                      PageContext.create(
                          callable, FETCH_REPOSITORY_HISTORY_PAGE_STR_DESC, request, context);
              return FetchRepositoryHistoryPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>
      LIST_WORKSPACES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>() {
            @Override
            public ApiFuture<ListWorkspacesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkspacesRequest, ListWorkspacesResponse> callable,
                ListWorkspacesRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkspacesResponse> futureResponse) {
              PageContext<ListWorkspacesRequest, ListWorkspacesResponse, Workspace> pageContext =
                  PageContext.create(callable, LIST_WORKSPACES_PAGE_STR_DESC, request, context);
              return ListWorkspacesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          QueryDirectoryContentsRequest,
          QueryDirectoryContentsResponse,
          QueryDirectoryContentsPagedResponse>
      QUERY_DIRECTORY_CONTENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              QueryDirectoryContentsRequest,
              QueryDirectoryContentsResponse,
              QueryDirectoryContentsPagedResponse>() {
            @Override
            public ApiFuture<QueryDirectoryContentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<QueryDirectoryContentsRequest, QueryDirectoryContentsResponse>
                    callable,
                QueryDirectoryContentsRequest request,
                ApiCallContext context,
                ApiFuture<QueryDirectoryContentsResponse> futureResponse) {
              PageContext<
                      QueryDirectoryContentsRequest, QueryDirectoryContentsResponse, DirectoryEntry>
                  pageContext =
                      PageContext.create(
                          callable, QUERY_DIRECTORY_CONTENTS_PAGE_STR_DESC, request, context);
              return QueryDirectoryContentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchFilesRequest, SearchFilesResponse, SearchFilesPagedResponse>
      SEARCH_FILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchFilesRequest, SearchFilesResponse, SearchFilesPagedResponse>() {
            @Override
            public ApiFuture<SearchFilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchFilesRequest, SearchFilesResponse> callable,
                SearchFilesRequest request,
                ApiCallContext context,
                ApiFuture<SearchFilesResponse> futureResponse) {
              PageContext<SearchFilesRequest, SearchFilesResponse, SearchResult> pageContext =
                  PageContext.create(callable, SEARCH_FILES_PAGE_STR_DESC, request, context);
              return SearchFilesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListReleaseConfigsRequest, ListReleaseConfigsResponse, ListReleaseConfigsPagedResponse>
      LIST_RELEASE_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReleaseConfigsRequest,
              ListReleaseConfigsResponse,
              ListReleaseConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListReleaseConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReleaseConfigsRequest, ListReleaseConfigsResponse> callable,
                ListReleaseConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListReleaseConfigsResponse> futureResponse) {
              PageContext<ListReleaseConfigsRequest, ListReleaseConfigsResponse, ReleaseConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_RELEASE_CONFIGS_PAGE_STR_DESC, request, context);
              return ListReleaseConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCompilationResultsRequest,
          ListCompilationResultsResponse,
          ListCompilationResultsPagedResponse>
      LIST_COMPILATION_RESULTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCompilationResultsRequest,
              ListCompilationResultsResponse,
              ListCompilationResultsPagedResponse>() {
            @Override
            public ApiFuture<ListCompilationResultsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCompilationResultsRequest, ListCompilationResultsResponse>
                    callable,
                ListCompilationResultsRequest request,
                ApiCallContext context,
                ApiFuture<ListCompilationResultsResponse> futureResponse) {
              PageContext<
                      ListCompilationResultsRequest,
                      ListCompilationResultsResponse,
                      CompilationResult>
                  pageContext =
                      PageContext.create(
                          callable, LIST_COMPILATION_RESULTS_PAGE_STR_DESC, request, context);
              return ListCompilationResultsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          QueryCompilationResultActionsRequest,
          QueryCompilationResultActionsResponse,
          QueryCompilationResultActionsPagedResponse>
      QUERY_COMPILATION_RESULT_ACTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              QueryCompilationResultActionsRequest,
              QueryCompilationResultActionsResponse,
              QueryCompilationResultActionsPagedResponse>() {
            @Override
            public ApiFuture<QueryCompilationResultActionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        QueryCompilationResultActionsRequest, QueryCompilationResultActionsResponse>
                    callable,
                QueryCompilationResultActionsRequest request,
                ApiCallContext context,
                ApiFuture<QueryCompilationResultActionsResponse> futureResponse) {
              PageContext<
                      QueryCompilationResultActionsRequest,
                      QueryCompilationResultActionsResponse,
                      CompilationResultAction>
                  pageContext =
                      PageContext.create(
                          callable,
                          QUERY_COMPILATION_RESULT_ACTIONS_PAGE_STR_DESC,
                          request,
                          context);
              return QueryCompilationResultActionsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListWorkflowConfigsRequest, ListWorkflowConfigsResponse, ListWorkflowConfigsPagedResponse>
      LIST_WORKFLOW_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkflowConfigsRequest,
              ListWorkflowConfigsResponse,
              ListWorkflowConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListWorkflowConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse> callable,
                ListWorkflowConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkflowConfigsResponse> futureResponse) {
              PageContext<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse, WorkflowConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_WORKFLOW_CONFIGS_PAGE_STR_DESC, request, context);
              return ListWorkflowConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListWorkflowInvocationsRequest,
          ListWorkflowInvocationsResponse,
          ListWorkflowInvocationsPagedResponse>
      LIST_WORKFLOW_INVOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkflowInvocationsRequest,
              ListWorkflowInvocationsResponse,
              ListWorkflowInvocationsPagedResponse>() {
            @Override
            public ApiFuture<ListWorkflowInvocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse>
                    callable,
                ListWorkflowInvocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkflowInvocationsResponse> futureResponse) {
              PageContext<
                      ListWorkflowInvocationsRequest,
                      ListWorkflowInvocationsResponse,
                      WorkflowInvocation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_WORKFLOW_INVOCATIONS_PAGE_STR_DESC, request, context);
              return ListWorkflowInvocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          QueryWorkflowInvocationActionsRequest,
          QueryWorkflowInvocationActionsResponse,
          QueryWorkflowInvocationActionsPagedResponse>
      QUERY_WORKFLOW_INVOCATION_ACTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              QueryWorkflowInvocationActionsRequest,
              QueryWorkflowInvocationActionsResponse,
              QueryWorkflowInvocationActionsPagedResponse>() {
            @Override
            public ApiFuture<QueryWorkflowInvocationActionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        QueryWorkflowInvocationActionsRequest,
                        QueryWorkflowInvocationActionsResponse>
                    callable,
                QueryWorkflowInvocationActionsRequest request,
                ApiCallContext context,
                ApiFuture<QueryWorkflowInvocationActionsResponse> futureResponse) {
              PageContext<
                      QueryWorkflowInvocationActionsRequest,
                      QueryWorkflowInvocationActionsResponse,
                      WorkflowInvocationAction>
                  pageContext =
                      PageContext.create(
                          callable,
                          QUERY_WORKFLOW_INVOCATION_ACTIONS_PAGE_STR_DESC,
                          request,
                          context);
              return QueryWorkflowInvocationActionsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listRepositories. */
  public PagedCallSettings<
          ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
      listRepositoriesSettings() {
    return listRepositoriesSettings;
  }

  /** Returns the object with the settings used for calls to getRepository. */
  public UnaryCallSettings<GetRepositoryRequest, Repository> getRepositorySettings() {
    return getRepositorySettings;
  }

  /** Returns the object with the settings used for calls to createRepository. */
  public UnaryCallSettings<CreateRepositoryRequest, Repository> createRepositorySettings() {
    return createRepositorySettings;
  }

  /** Returns the object with the settings used for calls to updateRepository. */
  public UnaryCallSettings<UpdateRepositoryRequest, Repository> updateRepositorySettings() {
    return updateRepositorySettings;
  }

  /** Returns the object with the settings used for calls to deleteRepository. */
  public UnaryCallSettings<DeleteRepositoryRequest, Empty> deleteRepositorySettings() {
    return deleteRepositorySettings;
  }

  /** Returns the object with the settings used for calls to commitRepositoryChanges. */
  public UnaryCallSettings<CommitRepositoryChangesRequest, CommitRepositoryChangesResponse>
      commitRepositoryChangesSettings() {
    return commitRepositoryChangesSettings;
  }

  /** Returns the object with the settings used for calls to readRepositoryFile. */
  public UnaryCallSettings<ReadRepositoryFileRequest, ReadRepositoryFileResponse>
      readRepositoryFileSettings() {
    return readRepositoryFileSettings;
  }

  /** Returns the object with the settings used for calls to queryRepositoryDirectoryContents. */
  public PagedCallSettings<
          QueryRepositoryDirectoryContentsRequest,
          QueryRepositoryDirectoryContentsResponse,
          QueryRepositoryDirectoryContentsPagedResponse>
      queryRepositoryDirectoryContentsSettings() {
    return queryRepositoryDirectoryContentsSettings;
  }

  /** Returns the object with the settings used for calls to fetchRepositoryHistory. */
  public PagedCallSettings<
          FetchRepositoryHistoryRequest,
          FetchRepositoryHistoryResponse,
          FetchRepositoryHistoryPagedResponse>
      fetchRepositoryHistorySettings() {
    return fetchRepositoryHistorySettings;
  }

  /** Returns the object with the settings used for calls to computeRepositoryAccessTokenStatus. */
  public UnaryCallSettings<
          ComputeRepositoryAccessTokenStatusRequest, ComputeRepositoryAccessTokenStatusResponse>
      computeRepositoryAccessTokenStatusSettings() {
    return computeRepositoryAccessTokenStatusSettings;
  }

  /** Returns the object with the settings used for calls to fetchRemoteBranches. */
  public UnaryCallSettings<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>
      fetchRemoteBranchesSettings() {
    return fetchRemoteBranchesSettings;
  }

  /** Returns the object with the settings used for calls to listWorkspaces. */
  public PagedCallSettings<
          ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>
      listWorkspacesSettings() {
    return listWorkspacesSettings;
  }

  /** Returns the object with the settings used for calls to getWorkspace. */
  public UnaryCallSettings<GetWorkspaceRequest, Workspace> getWorkspaceSettings() {
    return getWorkspaceSettings;
  }

  /** Returns the object with the settings used for calls to createWorkspace. */
  public UnaryCallSettings<CreateWorkspaceRequest, Workspace> createWorkspaceSettings() {
    return createWorkspaceSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkspace. */
  public UnaryCallSettings<DeleteWorkspaceRequest, Empty> deleteWorkspaceSettings() {
    return deleteWorkspaceSettings;
  }

  /** Returns the object with the settings used for calls to installNpmPackages. */
  public UnaryCallSettings<InstallNpmPackagesRequest, InstallNpmPackagesResponse>
      installNpmPackagesSettings() {
    return installNpmPackagesSettings;
  }

  /** Returns the object with the settings used for calls to pullGitCommits. */
  public UnaryCallSettings<PullGitCommitsRequest, PullGitCommitsResponse> pullGitCommitsSettings() {
    return pullGitCommitsSettings;
  }

  /** Returns the object with the settings used for calls to pushGitCommits. */
  public UnaryCallSettings<PushGitCommitsRequest, PushGitCommitsResponse> pushGitCommitsSettings() {
    return pushGitCommitsSettings;
  }

  /** Returns the object with the settings used for calls to fetchFileGitStatuses. */
  public UnaryCallSettings<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
      fetchFileGitStatusesSettings() {
    return fetchFileGitStatusesSettings;
  }

  /** Returns the object with the settings used for calls to fetchGitAheadBehind. */
  public UnaryCallSettings<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
      fetchGitAheadBehindSettings() {
    return fetchGitAheadBehindSettings;
  }

  /** Returns the object with the settings used for calls to commitWorkspaceChanges. */
  public UnaryCallSettings<CommitWorkspaceChangesRequest, CommitWorkspaceChangesResponse>
      commitWorkspaceChangesSettings() {
    return commitWorkspaceChangesSettings;
  }

  /** Returns the object with the settings used for calls to resetWorkspaceChanges. */
  public UnaryCallSettings<ResetWorkspaceChangesRequest, ResetWorkspaceChangesResponse>
      resetWorkspaceChangesSettings() {
    return resetWorkspaceChangesSettings;
  }

  /** Returns the object with the settings used for calls to fetchFileDiff. */
  public UnaryCallSettings<FetchFileDiffRequest, FetchFileDiffResponse> fetchFileDiffSettings() {
    return fetchFileDiffSettings;
  }

  /** Returns the object with the settings used for calls to queryDirectoryContents. */
  public PagedCallSettings<
          QueryDirectoryContentsRequest,
          QueryDirectoryContentsResponse,
          QueryDirectoryContentsPagedResponse>
      queryDirectoryContentsSettings() {
    return queryDirectoryContentsSettings;
  }

  /** Returns the object with the settings used for calls to searchFiles. */
  public PagedCallSettings<SearchFilesRequest, SearchFilesResponse, SearchFilesPagedResponse>
      searchFilesSettings() {
    return searchFilesSettings;
  }

  /** Returns the object with the settings used for calls to makeDirectory. */
  public UnaryCallSettings<MakeDirectoryRequest, MakeDirectoryResponse> makeDirectorySettings() {
    return makeDirectorySettings;
  }

  /** Returns the object with the settings used for calls to removeDirectory. */
  public UnaryCallSettings<RemoveDirectoryRequest, RemoveDirectoryResponse>
      removeDirectorySettings() {
    return removeDirectorySettings;
  }

  /** Returns the object with the settings used for calls to moveDirectory. */
  public UnaryCallSettings<MoveDirectoryRequest, MoveDirectoryResponse> moveDirectorySettings() {
    return moveDirectorySettings;
  }

  /** Returns the object with the settings used for calls to readFile. */
  public UnaryCallSettings<ReadFileRequest, ReadFileResponse> readFileSettings() {
    return readFileSettings;
  }

  /** Returns the object with the settings used for calls to removeFile. */
  public UnaryCallSettings<RemoveFileRequest, RemoveFileResponse> removeFileSettings() {
    return removeFileSettings;
  }

  /** Returns the object with the settings used for calls to moveFile. */
  public UnaryCallSettings<MoveFileRequest, MoveFileResponse> moveFileSettings() {
    return moveFileSettings;
  }

  /** Returns the object with the settings used for calls to writeFile. */
  public UnaryCallSettings<WriteFileRequest, WriteFileResponse> writeFileSettings() {
    return writeFileSettings;
  }

  /** Returns the object with the settings used for calls to listReleaseConfigs. */
  public PagedCallSettings<
          ListReleaseConfigsRequest, ListReleaseConfigsResponse, ListReleaseConfigsPagedResponse>
      listReleaseConfigsSettings() {
    return listReleaseConfigsSettings;
  }

  /** Returns the object with the settings used for calls to getReleaseConfig. */
  public UnaryCallSettings<GetReleaseConfigRequest, ReleaseConfig> getReleaseConfigSettings() {
    return getReleaseConfigSettings;
  }

  /** Returns the object with the settings used for calls to createReleaseConfig. */
  public UnaryCallSettings<CreateReleaseConfigRequest, ReleaseConfig>
      createReleaseConfigSettings() {
    return createReleaseConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateReleaseConfig. */
  public UnaryCallSettings<UpdateReleaseConfigRequest, ReleaseConfig>
      updateReleaseConfigSettings() {
    return updateReleaseConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteReleaseConfig. */
  public UnaryCallSettings<DeleteReleaseConfigRequest, Empty> deleteReleaseConfigSettings() {
    return deleteReleaseConfigSettings;
  }

  /** Returns the object with the settings used for calls to listCompilationResults. */
  public PagedCallSettings<
          ListCompilationResultsRequest,
          ListCompilationResultsResponse,
          ListCompilationResultsPagedResponse>
      listCompilationResultsSettings() {
    return listCompilationResultsSettings;
  }

  /** Returns the object with the settings used for calls to getCompilationResult. */
  public UnaryCallSettings<GetCompilationResultRequest, CompilationResult>
      getCompilationResultSettings() {
    return getCompilationResultSettings;
  }

  /** Returns the object with the settings used for calls to createCompilationResult. */
  public UnaryCallSettings<CreateCompilationResultRequest, CompilationResult>
      createCompilationResultSettings() {
    return createCompilationResultSettings;
  }

  /** Returns the object with the settings used for calls to queryCompilationResultActions. */
  public PagedCallSettings<
          QueryCompilationResultActionsRequest,
          QueryCompilationResultActionsResponse,
          QueryCompilationResultActionsPagedResponse>
      queryCompilationResultActionsSettings() {
    return queryCompilationResultActionsSettings;
  }

  /** Returns the object with the settings used for calls to listWorkflowConfigs. */
  public PagedCallSettings<
          ListWorkflowConfigsRequest, ListWorkflowConfigsResponse, ListWorkflowConfigsPagedResponse>
      listWorkflowConfigsSettings() {
    return listWorkflowConfigsSettings;
  }

  /** Returns the object with the settings used for calls to getWorkflowConfig. */
  public UnaryCallSettings<GetWorkflowConfigRequest, WorkflowConfig> getWorkflowConfigSettings() {
    return getWorkflowConfigSettings;
  }

  /** Returns the object with the settings used for calls to createWorkflowConfig. */
  public UnaryCallSettings<CreateWorkflowConfigRequest, WorkflowConfig>
      createWorkflowConfigSettings() {
    return createWorkflowConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkflowConfig. */
  public UnaryCallSettings<UpdateWorkflowConfigRequest, WorkflowConfig>
      updateWorkflowConfigSettings() {
    return updateWorkflowConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkflowConfig. */
  public UnaryCallSettings<DeleteWorkflowConfigRequest, Empty> deleteWorkflowConfigSettings() {
    return deleteWorkflowConfigSettings;
  }

  /** Returns the object with the settings used for calls to listWorkflowInvocations. */
  public PagedCallSettings<
          ListWorkflowInvocationsRequest,
          ListWorkflowInvocationsResponse,
          ListWorkflowInvocationsPagedResponse>
      listWorkflowInvocationsSettings() {
    return listWorkflowInvocationsSettings;
  }

  /** Returns the object with the settings used for calls to getWorkflowInvocation. */
  public UnaryCallSettings<GetWorkflowInvocationRequest, WorkflowInvocation>
      getWorkflowInvocationSettings() {
    return getWorkflowInvocationSettings;
  }

  /** Returns the object with the settings used for calls to createWorkflowInvocation. */
  public UnaryCallSettings<CreateWorkflowInvocationRequest, WorkflowInvocation>
      createWorkflowInvocationSettings() {
    return createWorkflowInvocationSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkflowInvocation. */
  public UnaryCallSettings<DeleteWorkflowInvocationRequest, Empty>
      deleteWorkflowInvocationSettings() {
    return deleteWorkflowInvocationSettings;
  }

  /** Returns the object with the settings used for calls to cancelWorkflowInvocation. */
  public UnaryCallSettings<CancelWorkflowInvocationRequest, CancelWorkflowInvocationResponse>
      cancelWorkflowInvocationSettings() {
    return cancelWorkflowInvocationSettings;
  }

  /** Returns the object with the settings used for calls to queryWorkflowInvocationActions. */
  public PagedCallSettings<
          QueryWorkflowInvocationActionsRequest,
          QueryWorkflowInvocationActionsResponse,
          QueryWorkflowInvocationActionsPagedResponse>
      queryWorkflowInvocationActionsSettings() {
    return queryWorkflowInvocationActionsSettings;
  }

  /** Returns the object with the settings used for calls to getConfig. */
  public UnaryCallSettings<GetConfigRequest, Config> getConfigSettings() {
    return getConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateConfig. */
  public UnaryCallSettings<UpdateConfigRequest, Config> updateConfigSettings() {
    return updateConfigSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public DataformStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataformStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataformStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "dataform";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "dataform.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dataform.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(DataformStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(DataformStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataformStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected DataformStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listRepositoriesSettings = settingsBuilder.listRepositoriesSettings().build();
    getRepositorySettings = settingsBuilder.getRepositorySettings().build();
    createRepositorySettings = settingsBuilder.createRepositorySettings().build();
    updateRepositorySettings = settingsBuilder.updateRepositorySettings().build();
    deleteRepositorySettings = settingsBuilder.deleteRepositorySettings().build();
    commitRepositoryChangesSettings = settingsBuilder.commitRepositoryChangesSettings().build();
    readRepositoryFileSettings = settingsBuilder.readRepositoryFileSettings().build();
    queryRepositoryDirectoryContentsSettings =
        settingsBuilder.queryRepositoryDirectoryContentsSettings().build();
    fetchRepositoryHistorySettings = settingsBuilder.fetchRepositoryHistorySettings().build();
    computeRepositoryAccessTokenStatusSettings =
        settingsBuilder.computeRepositoryAccessTokenStatusSettings().build();
    fetchRemoteBranchesSettings = settingsBuilder.fetchRemoteBranchesSettings().build();
    listWorkspacesSettings = settingsBuilder.listWorkspacesSettings().build();
    getWorkspaceSettings = settingsBuilder.getWorkspaceSettings().build();
    createWorkspaceSettings = settingsBuilder.createWorkspaceSettings().build();
    deleteWorkspaceSettings = settingsBuilder.deleteWorkspaceSettings().build();
    installNpmPackagesSettings = settingsBuilder.installNpmPackagesSettings().build();
    pullGitCommitsSettings = settingsBuilder.pullGitCommitsSettings().build();
    pushGitCommitsSettings = settingsBuilder.pushGitCommitsSettings().build();
    fetchFileGitStatusesSettings = settingsBuilder.fetchFileGitStatusesSettings().build();
    fetchGitAheadBehindSettings = settingsBuilder.fetchGitAheadBehindSettings().build();
    commitWorkspaceChangesSettings = settingsBuilder.commitWorkspaceChangesSettings().build();
    resetWorkspaceChangesSettings = settingsBuilder.resetWorkspaceChangesSettings().build();
    fetchFileDiffSettings = settingsBuilder.fetchFileDiffSettings().build();
    queryDirectoryContentsSettings = settingsBuilder.queryDirectoryContentsSettings().build();
    searchFilesSettings = settingsBuilder.searchFilesSettings().build();
    makeDirectorySettings = settingsBuilder.makeDirectorySettings().build();
    removeDirectorySettings = settingsBuilder.removeDirectorySettings().build();
    moveDirectorySettings = settingsBuilder.moveDirectorySettings().build();
    readFileSettings = settingsBuilder.readFileSettings().build();
    removeFileSettings = settingsBuilder.removeFileSettings().build();
    moveFileSettings = settingsBuilder.moveFileSettings().build();
    writeFileSettings = settingsBuilder.writeFileSettings().build();
    listReleaseConfigsSettings = settingsBuilder.listReleaseConfigsSettings().build();
    getReleaseConfigSettings = settingsBuilder.getReleaseConfigSettings().build();
    createReleaseConfigSettings = settingsBuilder.createReleaseConfigSettings().build();
    updateReleaseConfigSettings = settingsBuilder.updateReleaseConfigSettings().build();
    deleteReleaseConfigSettings = settingsBuilder.deleteReleaseConfigSettings().build();
    listCompilationResultsSettings = settingsBuilder.listCompilationResultsSettings().build();
    getCompilationResultSettings = settingsBuilder.getCompilationResultSettings().build();
    createCompilationResultSettings = settingsBuilder.createCompilationResultSettings().build();
    queryCompilationResultActionsSettings =
        settingsBuilder.queryCompilationResultActionsSettings().build();
    listWorkflowConfigsSettings = settingsBuilder.listWorkflowConfigsSettings().build();
    getWorkflowConfigSettings = settingsBuilder.getWorkflowConfigSettings().build();
    createWorkflowConfigSettings = settingsBuilder.createWorkflowConfigSettings().build();
    updateWorkflowConfigSettings = settingsBuilder.updateWorkflowConfigSettings().build();
    deleteWorkflowConfigSettings = settingsBuilder.deleteWorkflowConfigSettings().build();
    listWorkflowInvocationsSettings = settingsBuilder.listWorkflowInvocationsSettings().build();
    getWorkflowInvocationSettings = settingsBuilder.getWorkflowInvocationSettings().build();
    createWorkflowInvocationSettings = settingsBuilder.createWorkflowInvocationSettings().build();
    deleteWorkflowInvocationSettings = settingsBuilder.deleteWorkflowInvocationSettings().build();
    cancelWorkflowInvocationSettings = settingsBuilder.cancelWorkflowInvocationSettings().build();
    queryWorkflowInvocationActionsSettings =
        settingsBuilder.queryWorkflowInvocationActionsSettings().build();
    getConfigSettings = settingsBuilder.getConfigSettings().build();
    updateConfigSettings = settingsBuilder.updateConfigSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for DataformStubSettings. */
  public static class Builder extends StubSettings.Builder<DataformStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
        listRepositoriesSettings;
    private final UnaryCallSettings.Builder<GetRepositoryRequest, Repository> getRepositorySettings;
    private final UnaryCallSettings.Builder<CreateRepositoryRequest, Repository>
        createRepositorySettings;
    private final UnaryCallSettings.Builder<UpdateRepositoryRequest, Repository>
        updateRepositorySettings;
    private final UnaryCallSettings.Builder<DeleteRepositoryRequest, Empty>
        deleteRepositorySettings;
    private final UnaryCallSettings.Builder<
            CommitRepositoryChangesRequest, CommitRepositoryChangesResponse>
        commitRepositoryChangesSettings;
    private final UnaryCallSettings.Builder<ReadRepositoryFileRequest, ReadRepositoryFileResponse>
        readRepositoryFileSettings;
    private final PagedCallSettings.Builder<
            QueryRepositoryDirectoryContentsRequest,
            QueryRepositoryDirectoryContentsResponse,
            QueryRepositoryDirectoryContentsPagedResponse>
        queryRepositoryDirectoryContentsSettings;
    private final PagedCallSettings.Builder<
            FetchRepositoryHistoryRequest,
            FetchRepositoryHistoryResponse,
            FetchRepositoryHistoryPagedResponse>
        fetchRepositoryHistorySettings;
    private final UnaryCallSettings.Builder<
            ComputeRepositoryAccessTokenStatusRequest, ComputeRepositoryAccessTokenStatusResponse>
        computeRepositoryAccessTokenStatusSettings;
    private final UnaryCallSettings.Builder<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>
        fetchRemoteBranchesSettings;
    private final PagedCallSettings.Builder<
            ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>
        listWorkspacesSettings;
    private final UnaryCallSettings.Builder<GetWorkspaceRequest, Workspace> getWorkspaceSettings;
    private final UnaryCallSettings.Builder<CreateWorkspaceRequest, Workspace>
        createWorkspaceSettings;
    private final UnaryCallSettings.Builder<DeleteWorkspaceRequest, Empty> deleteWorkspaceSettings;
    private final UnaryCallSettings.Builder<InstallNpmPackagesRequest, InstallNpmPackagesResponse>
        installNpmPackagesSettings;
    private final UnaryCallSettings.Builder<PullGitCommitsRequest, PullGitCommitsResponse>
        pullGitCommitsSettings;
    private final UnaryCallSettings.Builder<PushGitCommitsRequest, PushGitCommitsResponse>
        pushGitCommitsSettings;
    private final UnaryCallSettings.Builder<
            FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
        fetchFileGitStatusesSettings;
    private final UnaryCallSettings.Builder<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
        fetchGitAheadBehindSettings;
    private final UnaryCallSettings.Builder<
            CommitWorkspaceChangesRequest, CommitWorkspaceChangesResponse>
        commitWorkspaceChangesSettings;
    private final UnaryCallSettings.Builder<
            ResetWorkspaceChangesRequest, ResetWorkspaceChangesResponse>
        resetWorkspaceChangesSettings;
    private final UnaryCallSettings.Builder<FetchFileDiffRequest, FetchFileDiffResponse>
        fetchFileDiffSettings;
    private final PagedCallSettings.Builder<
            QueryDirectoryContentsRequest,
            QueryDirectoryContentsResponse,
            QueryDirectoryContentsPagedResponse>
        queryDirectoryContentsSettings;
    private final PagedCallSettings.Builder<
            SearchFilesRequest, SearchFilesResponse, SearchFilesPagedResponse>
        searchFilesSettings;
    private final UnaryCallSettings.Builder<MakeDirectoryRequest, MakeDirectoryResponse>
        makeDirectorySettings;
    private final UnaryCallSettings.Builder<RemoveDirectoryRequest, RemoveDirectoryResponse>
        removeDirectorySettings;
    private final UnaryCallSettings.Builder<MoveDirectoryRequest, MoveDirectoryResponse>
        moveDirectorySettings;
    private final UnaryCallSettings.Builder<ReadFileRequest, ReadFileResponse> readFileSettings;
    private final UnaryCallSettings.Builder<RemoveFileRequest, RemoveFileResponse>
        removeFileSettings;
    private final UnaryCallSettings.Builder<MoveFileRequest, MoveFileResponse> moveFileSettings;
    private final UnaryCallSettings.Builder<WriteFileRequest, WriteFileResponse> writeFileSettings;
    private final PagedCallSettings.Builder<
            ListReleaseConfigsRequest, ListReleaseConfigsResponse, ListReleaseConfigsPagedResponse>
        listReleaseConfigsSettings;
    private final UnaryCallSettings.Builder<GetReleaseConfigRequest, ReleaseConfig>
        getReleaseConfigSettings;
    private final UnaryCallSettings.Builder<CreateReleaseConfigRequest, ReleaseConfig>
        createReleaseConfigSettings;
    private final UnaryCallSettings.Builder<UpdateReleaseConfigRequest, ReleaseConfig>
        updateReleaseConfigSettings;
    private final UnaryCallSettings.Builder<DeleteReleaseConfigRequest, Empty>
        deleteReleaseConfigSettings;
    private final PagedCallSettings.Builder<
            ListCompilationResultsRequest,
            ListCompilationResultsResponse,
            ListCompilationResultsPagedResponse>
        listCompilationResultsSettings;
    private final UnaryCallSettings.Builder<GetCompilationResultRequest, CompilationResult>
        getCompilationResultSettings;
    private final UnaryCallSettings.Builder<CreateCompilationResultRequest, CompilationResult>
        createCompilationResultSettings;
    private final PagedCallSettings.Builder<
            QueryCompilationResultActionsRequest,
            QueryCompilationResultActionsResponse,
            QueryCompilationResultActionsPagedResponse>
        queryCompilationResultActionsSettings;
    private final PagedCallSettings.Builder<
            ListWorkflowConfigsRequest,
            ListWorkflowConfigsResponse,
            ListWorkflowConfigsPagedResponse>
        listWorkflowConfigsSettings;
    private final UnaryCallSettings.Builder<GetWorkflowConfigRequest, WorkflowConfig>
        getWorkflowConfigSettings;
    private final UnaryCallSettings.Builder<CreateWorkflowConfigRequest, WorkflowConfig>
        createWorkflowConfigSettings;
    private final UnaryCallSettings.Builder<UpdateWorkflowConfigRequest, WorkflowConfig>
        updateWorkflowConfigSettings;
    private final UnaryCallSettings.Builder<DeleteWorkflowConfigRequest, Empty>
        deleteWorkflowConfigSettings;
    private final PagedCallSettings.Builder<
            ListWorkflowInvocationsRequest,
            ListWorkflowInvocationsResponse,
            ListWorkflowInvocationsPagedResponse>
        listWorkflowInvocationsSettings;
    private final UnaryCallSettings.Builder<GetWorkflowInvocationRequest, WorkflowInvocation>
        getWorkflowInvocationSettings;
    private final UnaryCallSettings.Builder<CreateWorkflowInvocationRequest, WorkflowInvocation>
        createWorkflowInvocationSettings;
    private final UnaryCallSettings.Builder<DeleteWorkflowInvocationRequest, Empty>
        deleteWorkflowInvocationSettings;
    private final UnaryCallSettings.Builder<
            CancelWorkflowInvocationRequest, CancelWorkflowInvocationResponse>
        cancelWorkflowInvocationSettings;
    private final PagedCallSettings.Builder<
            QueryWorkflowInvocationActionsRequest,
            QueryWorkflowInvocationActionsResponse,
            QueryWorkflowInvocationActionsPagedResponse>
        queryWorkflowInvocationActionsSettings;
    private final UnaryCallSettings.Builder<GetConfigRequest, Config> getConfigSettings;
    private final UnaryCallSettings.Builder<UpdateConfigRequest, Config> updateConfigSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listRepositoriesSettings = PagedCallSettings.newBuilder(LIST_REPOSITORIES_PAGE_STR_FACT);
      getRepositorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRepositorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRepositorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRepositorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      commitRepositoryChangesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      readRepositoryFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryRepositoryDirectoryContentsSettings =
          PagedCallSettings.newBuilder(QUERY_REPOSITORY_DIRECTORY_CONTENTS_PAGE_STR_FACT);
      fetchRepositoryHistorySettings =
          PagedCallSettings.newBuilder(FETCH_REPOSITORY_HISTORY_PAGE_STR_FACT);
      computeRepositoryAccessTokenStatusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchRemoteBranchesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listWorkspacesSettings = PagedCallSettings.newBuilder(LIST_WORKSPACES_PAGE_STR_FACT);
      getWorkspaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkspaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWorkspaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      installNpmPackagesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      pullGitCommitsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      pushGitCommitsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchFileGitStatusesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchGitAheadBehindSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      commitWorkspaceChangesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetWorkspaceChangesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchFileDiffSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryDirectoryContentsSettings =
          PagedCallSettings.newBuilder(QUERY_DIRECTORY_CONTENTS_PAGE_STR_FACT);
      searchFilesSettings = PagedCallSettings.newBuilder(SEARCH_FILES_PAGE_STR_FACT);
      makeDirectorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeDirectorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      moveDirectorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      readFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      moveFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      writeFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listReleaseConfigsSettings = PagedCallSettings.newBuilder(LIST_RELEASE_CONFIGS_PAGE_STR_FACT);
      getReleaseConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReleaseConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateReleaseConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteReleaseConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCompilationResultsSettings =
          PagedCallSettings.newBuilder(LIST_COMPILATION_RESULTS_PAGE_STR_FACT);
      getCompilationResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCompilationResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryCompilationResultActionsSettings =
          PagedCallSettings.newBuilder(QUERY_COMPILATION_RESULT_ACTIONS_PAGE_STR_FACT);
      listWorkflowConfigsSettings =
          PagedCallSettings.newBuilder(LIST_WORKFLOW_CONFIGS_PAGE_STR_FACT);
      getWorkflowConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkflowConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateWorkflowConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWorkflowConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listWorkflowInvocationsSettings =
          PagedCallSettings.newBuilder(LIST_WORKFLOW_INVOCATIONS_PAGE_STR_FACT);
      getWorkflowInvocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkflowInvocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWorkflowInvocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelWorkflowInvocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryWorkflowInvocationActionsSettings =
          PagedCallSettings.newBuilder(QUERY_WORKFLOW_INVOCATION_ACTIONS_PAGE_STR_FACT);
      getConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listRepositoriesSettings,
              getRepositorySettings,
              createRepositorySettings,
              updateRepositorySettings,
              deleteRepositorySettings,
              commitRepositoryChangesSettings,
              readRepositoryFileSettings,
              queryRepositoryDirectoryContentsSettings,
              fetchRepositoryHistorySettings,
              computeRepositoryAccessTokenStatusSettings,
              fetchRemoteBranchesSettings,
              listWorkspacesSettings,
              getWorkspaceSettings,
              createWorkspaceSettings,
              deleteWorkspaceSettings,
              installNpmPackagesSettings,
              pullGitCommitsSettings,
              pushGitCommitsSettings,
              fetchFileGitStatusesSettings,
              fetchGitAheadBehindSettings,
              commitWorkspaceChangesSettings,
              resetWorkspaceChangesSettings,
              fetchFileDiffSettings,
              queryDirectoryContentsSettings,
              searchFilesSettings,
              makeDirectorySettings,
              removeDirectorySettings,
              moveDirectorySettings,
              readFileSettings,
              removeFileSettings,
              moveFileSettings,
              writeFileSettings,
              listReleaseConfigsSettings,
              getReleaseConfigSettings,
              createReleaseConfigSettings,
              updateReleaseConfigSettings,
              deleteReleaseConfigSettings,
              listCompilationResultsSettings,
              getCompilationResultSettings,
              createCompilationResultSettings,
              queryCompilationResultActionsSettings,
              listWorkflowConfigsSettings,
              getWorkflowConfigSettings,
              createWorkflowConfigSettings,
              updateWorkflowConfigSettings,
              deleteWorkflowConfigSettings,
              listWorkflowInvocationsSettings,
              getWorkflowInvocationSettings,
              createWorkflowInvocationSettings,
              deleteWorkflowInvocationSettings,
              cancelWorkflowInvocationSettings,
              queryWorkflowInvocationActionsSettings,
              getConfigSettings,
              updateConfigSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(DataformStubSettings settings) {
      super(settings);

      listRepositoriesSettings = settings.listRepositoriesSettings.toBuilder();
      getRepositorySettings = settings.getRepositorySettings.toBuilder();
      createRepositorySettings = settings.createRepositorySettings.toBuilder();
      updateRepositorySettings = settings.updateRepositorySettings.toBuilder();
      deleteRepositorySettings = settings.deleteRepositorySettings.toBuilder();
      commitRepositoryChangesSettings = settings.commitRepositoryChangesSettings.toBuilder();
      readRepositoryFileSettings = settings.readRepositoryFileSettings.toBuilder();
      queryRepositoryDirectoryContentsSettings =
          settings.queryRepositoryDirectoryContentsSettings.toBuilder();
      fetchRepositoryHistorySettings = settings.fetchRepositoryHistorySettings.toBuilder();
      computeRepositoryAccessTokenStatusSettings =
          settings.computeRepositoryAccessTokenStatusSettings.toBuilder();
      fetchRemoteBranchesSettings = settings.fetchRemoteBranchesSettings.toBuilder();
      listWorkspacesSettings = settings.listWorkspacesSettings.toBuilder();
      getWorkspaceSettings = settings.getWorkspaceSettings.toBuilder();
      createWorkspaceSettings = settings.createWorkspaceSettings.toBuilder();
      deleteWorkspaceSettings = settings.deleteWorkspaceSettings.toBuilder();
      installNpmPackagesSettings = settings.installNpmPackagesSettings.toBuilder();
      pullGitCommitsSettings = settings.pullGitCommitsSettings.toBuilder();
      pushGitCommitsSettings = settings.pushGitCommitsSettings.toBuilder();
      fetchFileGitStatusesSettings = settings.fetchFileGitStatusesSettings.toBuilder();
      fetchGitAheadBehindSettings = settings.fetchGitAheadBehindSettings.toBuilder();
      commitWorkspaceChangesSettings = settings.commitWorkspaceChangesSettings.toBuilder();
      resetWorkspaceChangesSettings = settings.resetWorkspaceChangesSettings.toBuilder();
      fetchFileDiffSettings = settings.fetchFileDiffSettings.toBuilder();
      queryDirectoryContentsSettings = settings.queryDirectoryContentsSettings.toBuilder();
      searchFilesSettings = settings.searchFilesSettings.toBuilder();
      makeDirectorySettings = settings.makeDirectorySettings.toBuilder();
      removeDirectorySettings = settings.removeDirectorySettings.toBuilder();
      moveDirectorySettings = settings.moveDirectorySettings.toBuilder();
      readFileSettings = settings.readFileSettings.toBuilder();
      removeFileSettings = settings.removeFileSettings.toBuilder();
      moveFileSettings = settings.moveFileSettings.toBuilder();
      writeFileSettings = settings.writeFileSettings.toBuilder();
      listReleaseConfigsSettings = settings.listReleaseConfigsSettings.toBuilder();
      getReleaseConfigSettings = settings.getReleaseConfigSettings.toBuilder();
      createReleaseConfigSettings = settings.createReleaseConfigSettings.toBuilder();
      updateReleaseConfigSettings = settings.updateReleaseConfigSettings.toBuilder();
      deleteReleaseConfigSettings = settings.deleteReleaseConfigSettings.toBuilder();
      listCompilationResultsSettings = settings.listCompilationResultsSettings.toBuilder();
      getCompilationResultSettings = settings.getCompilationResultSettings.toBuilder();
      createCompilationResultSettings = settings.createCompilationResultSettings.toBuilder();
      queryCompilationResultActionsSettings =
          settings.queryCompilationResultActionsSettings.toBuilder();
      listWorkflowConfigsSettings = settings.listWorkflowConfigsSettings.toBuilder();
      getWorkflowConfigSettings = settings.getWorkflowConfigSettings.toBuilder();
      createWorkflowConfigSettings = settings.createWorkflowConfigSettings.toBuilder();
      updateWorkflowConfigSettings = settings.updateWorkflowConfigSettings.toBuilder();
      deleteWorkflowConfigSettings = settings.deleteWorkflowConfigSettings.toBuilder();
      listWorkflowInvocationsSettings = settings.listWorkflowInvocationsSettings.toBuilder();
      getWorkflowInvocationSettings = settings.getWorkflowInvocationSettings.toBuilder();
      createWorkflowInvocationSettings = settings.createWorkflowInvocationSettings.toBuilder();
      deleteWorkflowInvocationSettings = settings.deleteWorkflowInvocationSettings.toBuilder();
      cancelWorkflowInvocationSettings = settings.cancelWorkflowInvocationSettings.toBuilder();
      queryWorkflowInvocationActionsSettings =
          settings.queryWorkflowInvocationActionsSettings.toBuilder();
      getConfigSettings = settings.getConfigSettings.toBuilder();
      updateConfigSettings = settings.updateConfigSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listRepositoriesSettings,
              getRepositorySettings,
              createRepositorySettings,
              updateRepositorySettings,
              deleteRepositorySettings,
              commitRepositoryChangesSettings,
              readRepositoryFileSettings,
              queryRepositoryDirectoryContentsSettings,
              fetchRepositoryHistorySettings,
              computeRepositoryAccessTokenStatusSettings,
              fetchRemoteBranchesSettings,
              listWorkspacesSettings,
              getWorkspaceSettings,
              createWorkspaceSettings,
              deleteWorkspaceSettings,
              installNpmPackagesSettings,
              pullGitCommitsSettings,
              pushGitCommitsSettings,
              fetchFileGitStatusesSettings,
              fetchGitAheadBehindSettings,
              commitWorkspaceChangesSettings,
              resetWorkspaceChangesSettings,
              fetchFileDiffSettings,
              queryDirectoryContentsSettings,
              searchFilesSettings,
              makeDirectorySettings,
              removeDirectorySettings,
              moveDirectorySettings,
              readFileSettings,
              removeFileSettings,
              moveFileSettings,
              writeFileSettings,
              listReleaseConfigsSettings,
              getReleaseConfigSettings,
              createReleaseConfigSettings,
              updateReleaseConfigSettings,
              deleteReleaseConfigSettings,
              listCompilationResultsSettings,
              getCompilationResultSettings,
              createCompilationResultSettings,
              queryCompilationResultActionsSettings,
              listWorkflowConfigsSettings,
              getWorkflowConfigSettings,
              createWorkflowConfigSettings,
              updateWorkflowConfigSettings,
              deleteWorkflowConfigSettings,
              listWorkflowInvocationsSettings,
              getWorkflowInvocationSettings,
              createWorkflowInvocationSettings,
              deleteWorkflowInvocationSettings,
              cancelWorkflowInvocationSettings,
              queryWorkflowInvocationActionsSettings,
              getConfigSettings,
              updateConfigSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listRepositoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getRepositorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createRepositorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateRepositorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteRepositorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .commitRepositoryChangesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .readRepositoryFileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .queryRepositoryDirectoryContentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .fetchRepositoryHistorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .computeRepositoryAccessTokenStatusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .fetchRemoteBranchesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listWorkspacesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getWorkspaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createWorkspaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteWorkspaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .installNpmPackagesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .pullGitCommitsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .pushGitCommitsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .fetchFileGitStatusesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .fetchGitAheadBehindSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .commitWorkspaceChangesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .resetWorkspaceChangesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .fetchFileDiffSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .queryDirectoryContentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchFilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .makeDirectorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .removeDirectorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .moveDirectorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .readFileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .removeFileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .moveFileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .writeFileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listReleaseConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getReleaseConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createReleaseConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateReleaseConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteReleaseConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listCompilationResultsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getCompilationResultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createCompilationResultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .queryCompilationResultActionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listWorkflowConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getWorkflowConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createWorkflowConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateWorkflowConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteWorkflowConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listWorkflowInvocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getWorkflowInvocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createWorkflowInvocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteWorkflowInvocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .cancelWorkflowInvocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .queryWorkflowInvocationActionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listRepositories. */
    public PagedCallSettings.Builder<
            ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
        listRepositoriesSettings() {
      return listRepositoriesSettings;
    }

    /** Returns the builder for the settings used for calls to getRepository. */
    public UnaryCallSettings.Builder<GetRepositoryRequest, Repository> getRepositorySettings() {
      return getRepositorySettings;
    }

    /** Returns the builder for the settings used for calls to createRepository. */
    public UnaryCallSettings.Builder<CreateRepositoryRequest, Repository>
        createRepositorySettings() {
      return createRepositorySettings;
    }

    /** Returns the builder for the settings used for calls to updateRepository. */
    public UnaryCallSettings.Builder<UpdateRepositoryRequest, Repository>
        updateRepositorySettings() {
      return updateRepositorySettings;
    }

    /** Returns the builder for the settings used for calls to deleteRepository. */
    public UnaryCallSettings.Builder<DeleteRepositoryRequest, Empty> deleteRepositorySettings() {
      return deleteRepositorySettings;
    }

    /** Returns the builder for the settings used for calls to commitRepositoryChanges. */
    public UnaryCallSettings.Builder<
            CommitRepositoryChangesRequest, CommitRepositoryChangesResponse>
        commitRepositoryChangesSettings() {
      return commitRepositoryChangesSettings;
    }

    /** Returns the builder for the settings used for calls to readRepositoryFile. */
    public UnaryCallSettings.Builder<ReadRepositoryFileRequest, ReadRepositoryFileResponse>
        readRepositoryFileSettings() {
      return readRepositoryFileSettings;
    }

    /** Returns the builder for the settings used for calls to queryRepositoryDirectoryContents. */
    public PagedCallSettings.Builder<
            QueryRepositoryDirectoryContentsRequest,
            QueryRepositoryDirectoryContentsResponse,
            QueryRepositoryDirectoryContentsPagedResponse>
        queryRepositoryDirectoryContentsSettings() {
      return queryRepositoryDirectoryContentsSettings;
    }

    /** Returns the builder for the settings used for calls to fetchRepositoryHistory. */
    public PagedCallSettings.Builder<
            FetchRepositoryHistoryRequest,
            FetchRepositoryHistoryResponse,
            FetchRepositoryHistoryPagedResponse>
        fetchRepositoryHistorySettings() {
      return fetchRepositoryHistorySettings;
    }

    /**
     * Returns the builder for the settings used for calls to computeRepositoryAccessTokenStatus.
     */
    public UnaryCallSettings.Builder<
            ComputeRepositoryAccessTokenStatusRequest, ComputeRepositoryAccessTokenStatusResponse>
        computeRepositoryAccessTokenStatusSettings() {
      return computeRepositoryAccessTokenStatusSettings;
    }

    /** Returns the builder for the settings used for calls to fetchRemoteBranches. */
    public UnaryCallSettings.Builder<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>
        fetchRemoteBranchesSettings() {
      return fetchRemoteBranchesSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkspaces. */
    public PagedCallSettings.Builder<
            ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>
        listWorkspacesSettings() {
      return listWorkspacesSettings;
    }

    /** Returns the builder for the settings used for calls to getWorkspace. */
    public UnaryCallSettings.Builder<GetWorkspaceRequest, Workspace> getWorkspaceSettings() {
      return getWorkspaceSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkspace. */
    public UnaryCallSettings.Builder<CreateWorkspaceRequest, Workspace> createWorkspaceSettings() {
      return createWorkspaceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkspace. */
    public UnaryCallSettings.Builder<DeleteWorkspaceRequest, Empty> deleteWorkspaceSettings() {
      return deleteWorkspaceSettings;
    }

    /** Returns the builder for the settings used for calls to installNpmPackages. */
    public UnaryCallSettings.Builder<InstallNpmPackagesRequest, InstallNpmPackagesResponse>
        installNpmPackagesSettings() {
      return installNpmPackagesSettings;
    }

    /** Returns the builder for the settings used for calls to pullGitCommits. */
    public UnaryCallSettings.Builder<PullGitCommitsRequest, PullGitCommitsResponse>
        pullGitCommitsSettings() {
      return pullGitCommitsSettings;
    }

    /** Returns the builder for the settings used for calls to pushGitCommits. */
    public UnaryCallSettings.Builder<PushGitCommitsRequest, PushGitCommitsResponse>
        pushGitCommitsSettings() {
      return pushGitCommitsSettings;
    }

    /** Returns the builder for the settings used for calls to fetchFileGitStatuses. */
    public UnaryCallSettings.Builder<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
        fetchFileGitStatusesSettings() {
      return fetchFileGitStatusesSettings;
    }

    /** Returns the builder for the settings used for calls to fetchGitAheadBehind. */
    public UnaryCallSettings.Builder<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
        fetchGitAheadBehindSettings() {
      return fetchGitAheadBehindSettings;
    }

    /** Returns the builder for the settings used for calls to commitWorkspaceChanges. */
    public UnaryCallSettings.Builder<CommitWorkspaceChangesRequest, CommitWorkspaceChangesResponse>
        commitWorkspaceChangesSettings() {
      return commitWorkspaceChangesSettings;
    }

    /** Returns the builder for the settings used for calls to resetWorkspaceChanges. */
    public UnaryCallSettings.Builder<ResetWorkspaceChangesRequest, ResetWorkspaceChangesResponse>
        resetWorkspaceChangesSettings() {
      return resetWorkspaceChangesSettings;
    }

    /** Returns the builder for the settings used for calls to fetchFileDiff. */
    public UnaryCallSettings.Builder<FetchFileDiffRequest, FetchFileDiffResponse>
        fetchFileDiffSettings() {
      return fetchFileDiffSettings;
    }

    /** Returns the builder for the settings used for calls to queryDirectoryContents. */
    public PagedCallSettings.Builder<
            QueryDirectoryContentsRequest,
            QueryDirectoryContentsResponse,
            QueryDirectoryContentsPagedResponse>
        queryDirectoryContentsSettings() {
      return queryDirectoryContentsSettings;
    }

    /** Returns the builder for the settings used for calls to searchFiles. */
    public PagedCallSettings.Builder<
            SearchFilesRequest, SearchFilesResponse, SearchFilesPagedResponse>
        searchFilesSettings() {
      return searchFilesSettings;
    }

    /** Returns the builder for the settings used for calls to makeDirectory. */
    public UnaryCallSettings.Builder<MakeDirectoryRequest, MakeDirectoryResponse>
        makeDirectorySettings() {
      return makeDirectorySettings;
    }

    /** Returns the builder for the settings used for calls to removeDirectory. */
    public UnaryCallSettings.Builder<RemoveDirectoryRequest, RemoveDirectoryResponse>
        removeDirectorySettings() {
      return removeDirectorySettings;
    }

    /** Returns the builder for the settings used for calls to moveDirectory. */
    public UnaryCallSettings.Builder<MoveDirectoryRequest, MoveDirectoryResponse>
        moveDirectorySettings() {
      return moveDirectorySettings;
    }

    /** Returns the builder for the settings used for calls to readFile. */
    public UnaryCallSettings.Builder<ReadFileRequest, ReadFileResponse> readFileSettings() {
      return readFileSettings;
    }

    /** Returns the builder for the settings used for calls to removeFile. */
    public UnaryCallSettings.Builder<RemoveFileRequest, RemoveFileResponse> removeFileSettings() {
      return removeFileSettings;
    }

    /** Returns the builder for the settings used for calls to moveFile. */
    public UnaryCallSettings.Builder<MoveFileRequest, MoveFileResponse> moveFileSettings() {
      return moveFileSettings;
    }

    /** Returns the builder for the settings used for calls to writeFile. */
    public UnaryCallSettings.Builder<WriteFileRequest, WriteFileResponse> writeFileSettings() {
      return writeFileSettings;
    }

    /** Returns the builder for the settings used for calls to listReleaseConfigs. */
    public PagedCallSettings.Builder<
            ListReleaseConfigsRequest, ListReleaseConfigsResponse, ListReleaseConfigsPagedResponse>
        listReleaseConfigsSettings() {
      return listReleaseConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to getReleaseConfig. */
    public UnaryCallSettings.Builder<GetReleaseConfigRequest, ReleaseConfig>
        getReleaseConfigSettings() {
      return getReleaseConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createReleaseConfig. */
    public UnaryCallSettings.Builder<CreateReleaseConfigRequest, ReleaseConfig>
        createReleaseConfigSettings() {
      return createReleaseConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateReleaseConfig. */
    public UnaryCallSettings.Builder<UpdateReleaseConfigRequest, ReleaseConfig>
        updateReleaseConfigSettings() {
      return updateReleaseConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteReleaseConfig. */
    public UnaryCallSettings.Builder<DeleteReleaseConfigRequest, Empty>
        deleteReleaseConfigSettings() {
      return deleteReleaseConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listCompilationResults. */
    public PagedCallSettings.Builder<
            ListCompilationResultsRequest,
            ListCompilationResultsResponse,
            ListCompilationResultsPagedResponse>
        listCompilationResultsSettings() {
      return listCompilationResultsSettings;
    }

    /** Returns the builder for the settings used for calls to getCompilationResult. */
    public UnaryCallSettings.Builder<GetCompilationResultRequest, CompilationResult>
        getCompilationResultSettings() {
      return getCompilationResultSettings;
    }

    /** Returns the builder for the settings used for calls to createCompilationResult. */
    public UnaryCallSettings.Builder<CreateCompilationResultRequest, CompilationResult>
        createCompilationResultSettings() {
      return createCompilationResultSettings;
    }

    /** Returns the builder for the settings used for calls to queryCompilationResultActions. */
    public PagedCallSettings.Builder<
            QueryCompilationResultActionsRequest,
            QueryCompilationResultActionsResponse,
            QueryCompilationResultActionsPagedResponse>
        queryCompilationResultActionsSettings() {
      return queryCompilationResultActionsSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkflowConfigs. */
    public PagedCallSettings.Builder<
            ListWorkflowConfigsRequest,
            ListWorkflowConfigsResponse,
            ListWorkflowConfigsPagedResponse>
        listWorkflowConfigsSettings() {
      return listWorkflowConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to getWorkflowConfig. */
    public UnaryCallSettings.Builder<GetWorkflowConfigRequest, WorkflowConfig>
        getWorkflowConfigSettings() {
      return getWorkflowConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkflowConfig. */
    public UnaryCallSettings.Builder<CreateWorkflowConfigRequest, WorkflowConfig>
        createWorkflowConfigSettings() {
      return createWorkflowConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkflowConfig. */
    public UnaryCallSettings.Builder<UpdateWorkflowConfigRequest, WorkflowConfig>
        updateWorkflowConfigSettings() {
      return updateWorkflowConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkflowConfig. */
    public UnaryCallSettings.Builder<DeleteWorkflowConfigRequest, Empty>
        deleteWorkflowConfigSettings() {
      return deleteWorkflowConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkflowInvocations. */
    public PagedCallSettings.Builder<
            ListWorkflowInvocationsRequest,
            ListWorkflowInvocationsResponse,
            ListWorkflowInvocationsPagedResponse>
        listWorkflowInvocationsSettings() {
      return listWorkflowInvocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getWorkflowInvocation. */
    public UnaryCallSettings.Builder<GetWorkflowInvocationRequest, WorkflowInvocation>
        getWorkflowInvocationSettings() {
      return getWorkflowInvocationSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkflowInvocation. */
    public UnaryCallSettings.Builder<CreateWorkflowInvocationRequest, WorkflowInvocation>
        createWorkflowInvocationSettings() {
      return createWorkflowInvocationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkflowInvocation. */
    public UnaryCallSettings.Builder<DeleteWorkflowInvocationRequest, Empty>
        deleteWorkflowInvocationSettings() {
      return deleteWorkflowInvocationSettings;
    }

    /** Returns the builder for the settings used for calls to cancelWorkflowInvocation. */
    public UnaryCallSettings.Builder<
            CancelWorkflowInvocationRequest, CancelWorkflowInvocationResponse>
        cancelWorkflowInvocationSettings() {
      return cancelWorkflowInvocationSettings;
    }

    /** Returns the builder for the settings used for calls to queryWorkflowInvocationActions. */
    public PagedCallSettings.Builder<
            QueryWorkflowInvocationActionsRequest,
            QueryWorkflowInvocationActionsResponse,
            QueryWorkflowInvocationActionsPagedResponse>
        queryWorkflowInvocationActionsSettings() {
      return queryWorkflowInvocationActionsSettings;
    }

    /** Returns the builder for the settings used for calls to getConfig. */
    public UnaryCallSettings.Builder<GetConfigRequest, Config> getConfigSettings() {
      return getConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateConfig. */
    public UnaryCallSettings.Builder<UpdateConfigRequest, Config> updateConfigSettings() {
      return updateConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public DataformStubSettings build() throws IOException {
      return new DataformStubSettings(this);
    }
  }
}
