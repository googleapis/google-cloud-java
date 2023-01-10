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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.dataform.v1alpha2.CancelWorkflowInvocationRequest;
import com.google.cloud.dataform.v1alpha2.CommitWorkspaceChangesRequest;
import com.google.cloud.dataform.v1alpha2.CompilationResult;
import com.google.cloud.dataform.v1alpha2.CompilationResultAction;
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
import com.google.cloud.dataform.v1alpha2.WorkflowInvocationAction;
import com.google.cloud.dataform.v1alpha2.Workspace;
import com.google.cloud.dataform.v1alpha2.WriteFileRequest;
import com.google.cloud.dataform.v1alpha2.WriteFileResponse;
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
 * <p>For example, to set the total timeout of getRepository to 30 seconds:
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
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataformStubSettings dataformSettings = dataformSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataformStubSettings extends StubSettings<DataformStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
      listRepositoriesSettings;
  private final UnaryCallSettings<GetRepositoryRequest, Repository> getRepositorySettings;
  private final UnaryCallSettings<CreateRepositoryRequest, Repository> createRepositorySettings;
  private final UnaryCallSettings<UpdateRepositoryRequest, Repository> updateRepositorySettings;
  private final UnaryCallSettings<DeleteRepositoryRequest, Empty> deleteRepositorySettings;
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
  private final UnaryCallSettings<PullGitCommitsRequest, Empty> pullGitCommitsSettings;
  private final UnaryCallSettings<PushGitCommitsRequest, Empty> pushGitCommitsSettings;
  private final UnaryCallSettings<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
      fetchFileGitStatusesSettings;
  private final UnaryCallSettings<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
      fetchGitAheadBehindSettings;
  private final UnaryCallSettings<CommitWorkspaceChangesRequest, Empty>
      commitWorkspaceChangesSettings;
  private final UnaryCallSettings<ResetWorkspaceChangesRequest, Empty>
      resetWorkspaceChangesSettings;
  private final UnaryCallSettings<FetchFileDiffRequest, FetchFileDiffResponse>
      fetchFileDiffSettings;
  private final PagedCallSettings<
          QueryDirectoryContentsRequest,
          QueryDirectoryContentsResponse,
          QueryDirectoryContentsPagedResponse>
      queryDirectoryContentsSettings;
  private final UnaryCallSettings<MakeDirectoryRequest, MakeDirectoryResponse>
      makeDirectorySettings;
  private final UnaryCallSettings<RemoveDirectoryRequest, Empty> removeDirectorySettings;
  private final UnaryCallSettings<MoveDirectoryRequest, MoveDirectoryResponse>
      moveDirectorySettings;
  private final UnaryCallSettings<ReadFileRequest, ReadFileResponse> readFileSettings;
  private final UnaryCallSettings<RemoveFileRequest, Empty> removeFileSettings;
  private final UnaryCallSettings<MoveFileRequest, MoveFileResponse> moveFileSettings;
  private final UnaryCallSettings<WriteFileRequest, WriteFileResponse> writeFileSettings;
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
  private final UnaryCallSettings<CancelWorkflowInvocationRequest, Empty>
      cancelWorkflowInvocationSettings;
  private final PagedCallSettings<
          QueryWorkflowInvocationActionsRequest,
          QueryWorkflowInvocationActionsResponse,
          QueryWorkflowInvocationActionsPagedResponse>
      queryWorkflowInvocationActionsSettings;
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
              return payload.getRepositoriesList() == null
                  ? ImmutableList.<Repository>of()
                  : payload.getRepositoriesList();
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
              return payload.getWorkspacesList() == null
                  ? ImmutableList.<Workspace>of()
                  : payload.getWorkspacesList();
            }
          };

  private static final PagedListDescriptor<
          QueryDirectoryContentsRequest,
          QueryDirectoryContentsResponse,
          QueryDirectoryContentsResponse.DirectoryEntry>
      QUERY_DIRECTORY_CONTENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              QueryDirectoryContentsRequest,
              QueryDirectoryContentsResponse,
              QueryDirectoryContentsResponse.DirectoryEntry>() {
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
            public Iterable<QueryDirectoryContentsResponse.DirectoryEntry> extractResources(
                QueryDirectoryContentsResponse payload) {
              return payload.getDirectoryEntriesList() == null
                  ? ImmutableList.<QueryDirectoryContentsResponse.DirectoryEntry>of()
                  : payload.getDirectoryEntriesList();
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
              return payload.getCompilationResultsList() == null
                  ? ImmutableList.<CompilationResult>of()
                  : payload.getCompilationResultsList();
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
              return payload.getCompilationResultActionsList() == null
                  ? ImmutableList.<CompilationResultAction>of()
                  : payload.getCompilationResultActionsList();
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
              return payload.getWorkflowInvocationsList() == null
                  ? ImmutableList.<WorkflowInvocation>of()
                  : payload.getWorkflowInvocationsList();
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
              return payload.getWorkflowInvocationActionsList() == null
                  ? ImmutableList.<WorkflowInvocationAction>of()
                  : payload.getWorkflowInvocationActionsList();
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
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
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
                      QueryDirectoryContentsRequest,
                      QueryDirectoryContentsResponse,
                      QueryDirectoryContentsResponse.DirectoryEntry>
                  pageContext =
                      PageContext.create(
                          callable, QUERY_DIRECTORY_CONTENTS_PAGE_STR_DESC, request, context);
              return QueryDirectoryContentsPagedResponse.createAsync(pageContext, futureResponse);
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
  public UnaryCallSettings<PullGitCommitsRequest, Empty> pullGitCommitsSettings() {
    return pullGitCommitsSettings;
  }

  /** Returns the object with the settings used for calls to pushGitCommits. */
  public UnaryCallSettings<PushGitCommitsRequest, Empty> pushGitCommitsSettings() {
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
  public UnaryCallSettings<CommitWorkspaceChangesRequest, Empty> commitWorkspaceChangesSettings() {
    return commitWorkspaceChangesSettings;
  }

  /** Returns the object with the settings used for calls to resetWorkspaceChanges. */
  public UnaryCallSettings<ResetWorkspaceChangesRequest, Empty> resetWorkspaceChangesSettings() {
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

  /** Returns the object with the settings used for calls to makeDirectory. */
  public UnaryCallSettings<MakeDirectoryRequest, MakeDirectoryResponse> makeDirectorySettings() {
    return makeDirectorySettings;
  }

  /** Returns the object with the settings used for calls to removeDirectory. */
  public UnaryCallSettings<RemoveDirectoryRequest, Empty> removeDirectorySettings() {
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
  public UnaryCallSettings<RemoveFileRequest, Empty> removeFileSettings() {
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
  public UnaryCallSettings<CancelWorkflowInvocationRequest, Empty>
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

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(DataformStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
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
    makeDirectorySettings = settingsBuilder.makeDirectorySettings().build();
    removeDirectorySettings = settingsBuilder.removeDirectorySettings().build();
    moveDirectorySettings = settingsBuilder.moveDirectorySettings().build();
    readFileSettings = settingsBuilder.readFileSettings().build();
    removeFileSettings = settingsBuilder.removeFileSettings().build();
    moveFileSettings = settingsBuilder.moveFileSettings().build();
    writeFileSettings = settingsBuilder.writeFileSettings().build();
    listCompilationResultsSettings = settingsBuilder.listCompilationResultsSettings().build();
    getCompilationResultSettings = settingsBuilder.getCompilationResultSettings().build();
    createCompilationResultSettings = settingsBuilder.createCompilationResultSettings().build();
    queryCompilationResultActionsSettings =
        settingsBuilder.queryCompilationResultActionsSettings().build();
    listWorkflowInvocationsSettings = settingsBuilder.listWorkflowInvocationsSettings().build();
    getWorkflowInvocationSettings = settingsBuilder.getWorkflowInvocationSettings().build();
    createWorkflowInvocationSettings = settingsBuilder.createWorkflowInvocationSettings().build();
    deleteWorkflowInvocationSettings = settingsBuilder.deleteWorkflowInvocationSettings().build();
    cancelWorkflowInvocationSettings = settingsBuilder.cancelWorkflowInvocationSettings().build();
    queryWorkflowInvocationActionsSettings =
        settingsBuilder.queryWorkflowInvocationActionsSettings().build();
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
    private final UnaryCallSettings.Builder<PullGitCommitsRequest, Empty> pullGitCommitsSettings;
    private final UnaryCallSettings.Builder<PushGitCommitsRequest, Empty> pushGitCommitsSettings;
    private final UnaryCallSettings.Builder<
            FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
        fetchFileGitStatusesSettings;
    private final UnaryCallSettings.Builder<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
        fetchGitAheadBehindSettings;
    private final UnaryCallSettings.Builder<CommitWorkspaceChangesRequest, Empty>
        commitWorkspaceChangesSettings;
    private final UnaryCallSettings.Builder<ResetWorkspaceChangesRequest, Empty>
        resetWorkspaceChangesSettings;
    private final UnaryCallSettings.Builder<FetchFileDiffRequest, FetchFileDiffResponse>
        fetchFileDiffSettings;
    private final PagedCallSettings.Builder<
            QueryDirectoryContentsRequest,
            QueryDirectoryContentsResponse,
            QueryDirectoryContentsPagedResponse>
        queryDirectoryContentsSettings;
    private final UnaryCallSettings.Builder<MakeDirectoryRequest, MakeDirectoryResponse>
        makeDirectorySettings;
    private final UnaryCallSettings.Builder<RemoveDirectoryRequest, Empty> removeDirectorySettings;
    private final UnaryCallSettings.Builder<MoveDirectoryRequest, MoveDirectoryResponse>
        moveDirectorySettings;
    private final UnaryCallSettings.Builder<ReadFileRequest, ReadFileResponse> readFileSettings;
    private final UnaryCallSettings.Builder<RemoveFileRequest, Empty> removeFileSettings;
    private final UnaryCallSettings.Builder<MoveFileRequest, MoveFileResponse> moveFileSettings;
    private final UnaryCallSettings.Builder<WriteFileRequest, WriteFileResponse> writeFileSettings;
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
    private final UnaryCallSettings.Builder<CancelWorkflowInvocationRequest, Empty>
        cancelWorkflowInvocationSettings;
    private final PagedCallSettings.Builder<
            QueryWorkflowInvocationActionsRequest,
            QueryWorkflowInvocationActionsResponse,
            QueryWorkflowInvocationActionsPagedResponse>
        queryWorkflowInvocationActionsSettings;
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
      makeDirectorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeDirectorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      moveDirectorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      readFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      moveFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      writeFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCompilationResultsSettings =
          PagedCallSettings.newBuilder(LIST_COMPILATION_RESULTS_PAGE_STR_FACT);
      getCompilationResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCompilationResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryCompilationResultActionsSettings =
          PagedCallSettings.newBuilder(QUERY_COMPILATION_RESULT_ACTIONS_PAGE_STR_FACT);
      listWorkflowInvocationsSettings =
          PagedCallSettings.newBuilder(LIST_WORKFLOW_INVOCATIONS_PAGE_STR_FACT);
      getWorkflowInvocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkflowInvocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWorkflowInvocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelWorkflowInvocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryWorkflowInvocationActionsSettings =
          PagedCallSettings.newBuilder(QUERY_WORKFLOW_INVOCATION_ACTIONS_PAGE_STR_FACT);
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
              makeDirectorySettings,
              removeDirectorySettings,
              moveDirectorySettings,
              readFileSettings,
              removeFileSettings,
              moveFileSettings,
              writeFileSettings,
              listCompilationResultsSettings,
              getCompilationResultSettings,
              createCompilationResultSettings,
              queryCompilationResultActionsSettings,
              listWorkflowInvocationsSettings,
              getWorkflowInvocationSettings,
              createWorkflowInvocationSettings,
              deleteWorkflowInvocationSettings,
              cancelWorkflowInvocationSettings,
              queryWorkflowInvocationActionsSettings,
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
      makeDirectorySettings = settings.makeDirectorySettings.toBuilder();
      removeDirectorySettings = settings.removeDirectorySettings.toBuilder();
      moveDirectorySettings = settings.moveDirectorySettings.toBuilder();
      readFileSettings = settings.readFileSettings.toBuilder();
      removeFileSettings = settings.removeFileSettings.toBuilder();
      moveFileSettings = settings.moveFileSettings.toBuilder();
      writeFileSettings = settings.writeFileSettings.toBuilder();
      listCompilationResultsSettings = settings.listCompilationResultsSettings.toBuilder();
      getCompilationResultSettings = settings.getCompilationResultSettings.toBuilder();
      createCompilationResultSettings = settings.createCompilationResultSettings.toBuilder();
      queryCompilationResultActionsSettings =
          settings.queryCompilationResultActionsSettings.toBuilder();
      listWorkflowInvocationsSettings = settings.listWorkflowInvocationsSettings.toBuilder();
      getWorkflowInvocationSettings = settings.getWorkflowInvocationSettings.toBuilder();
      createWorkflowInvocationSettings = settings.createWorkflowInvocationSettings.toBuilder();
      deleteWorkflowInvocationSettings = settings.deleteWorkflowInvocationSettings.toBuilder();
      cancelWorkflowInvocationSettings = settings.cancelWorkflowInvocationSettings.toBuilder();
      queryWorkflowInvocationActionsSettings =
          settings.queryWorkflowInvocationActionsSettings.toBuilder();
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
              makeDirectorySettings,
              removeDirectorySettings,
              moveDirectorySettings,
              readFileSettings,
              removeFileSettings,
              moveFileSettings,
              writeFileSettings,
              listCompilationResultsSettings,
              getCompilationResultSettings,
              createCompilationResultSettings,
              queryCompilationResultActionsSettings,
              listWorkflowInvocationsSettings,
              getWorkflowInvocationSettings,
              createWorkflowInvocationSettings,
              deleteWorkflowInvocationSettings,
              cancelWorkflowInvocationSettings,
              queryWorkflowInvocationActionsSettings,
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
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
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
    public UnaryCallSettings.Builder<PullGitCommitsRequest, Empty> pullGitCommitsSettings() {
      return pullGitCommitsSettings;
    }

    /** Returns the builder for the settings used for calls to pushGitCommits. */
    public UnaryCallSettings.Builder<PushGitCommitsRequest, Empty> pushGitCommitsSettings() {
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
    public UnaryCallSettings.Builder<CommitWorkspaceChangesRequest, Empty>
        commitWorkspaceChangesSettings() {
      return commitWorkspaceChangesSettings;
    }

    /** Returns the builder for the settings used for calls to resetWorkspaceChanges. */
    public UnaryCallSettings.Builder<ResetWorkspaceChangesRequest, Empty>
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

    /** Returns the builder for the settings used for calls to makeDirectory. */
    public UnaryCallSettings.Builder<MakeDirectoryRequest, MakeDirectoryResponse>
        makeDirectorySettings() {
      return makeDirectorySettings;
    }

    /** Returns the builder for the settings used for calls to removeDirectory. */
    public UnaryCallSettings.Builder<RemoveDirectoryRequest, Empty> removeDirectorySettings() {
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
    public UnaryCallSettings.Builder<RemoveFileRequest, Empty> removeFileSettings() {
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
    public UnaryCallSettings.Builder<CancelWorkflowInvocationRequest, Empty>
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
