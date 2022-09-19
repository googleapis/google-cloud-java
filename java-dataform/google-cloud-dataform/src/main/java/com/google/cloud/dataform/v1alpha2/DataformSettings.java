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

package com.google.cloud.dataform.v1alpha2;

import static com.google.cloud.dataform.v1alpha2.DataformClient.ListCompilationResultsPagedResponse;
import static com.google.cloud.dataform.v1alpha2.DataformClient.ListLocationsPagedResponse;
import static com.google.cloud.dataform.v1alpha2.DataformClient.ListRepositoriesPagedResponse;
import static com.google.cloud.dataform.v1alpha2.DataformClient.ListWorkflowInvocationsPagedResponse;
import static com.google.cloud.dataform.v1alpha2.DataformClient.ListWorkspacesPagedResponse;
import static com.google.cloud.dataform.v1alpha2.DataformClient.QueryCompilationResultActionsPagedResponse;
import static com.google.cloud.dataform.v1alpha2.DataformClient.QueryDirectoryContentsPagedResponse;
import static com.google.cloud.dataform.v1alpha2.DataformClient.QueryWorkflowInvocationActionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dataform.v1alpha2.stub.DataformStubSettings;
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
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataformClient}.
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
 * DataformSettings.Builder dataformSettingsBuilder = DataformSettings.newBuilder();
 * dataformSettingsBuilder
 *     .getRepositorySettings()
 *     .setRetrySettings(
 *         dataformSettingsBuilder.getRepositorySettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataformSettings dataformSettings = dataformSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataformSettings extends ClientSettings<DataformSettings> {

  /** Returns the object with the settings used for calls to listRepositories. */
  public PagedCallSettings<
          ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
      listRepositoriesSettings() {
    return ((DataformStubSettings) getStubSettings()).listRepositoriesSettings();
  }

  /** Returns the object with the settings used for calls to getRepository. */
  public UnaryCallSettings<GetRepositoryRequest, Repository> getRepositorySettings() {
    return ((DataformStubSettings) getStubSettings()).getRepositorySettings();
  }

  /** Returns the object with the settings used for calls to createRepository. */
  public UnaryCallSettings<CreateRepositoryRequest, Repository> createRepositorySettings() {
    return ((DataformStubSettings) getStubSettings()).createRepositorySettings();
  }

  /** Returns the object with the settings used for calls to updateRepository. */
  public UnaryCallSettings<UpdateRepositoryRequest, Repository> updateRepositorySettings() {
    return ((DataformStubSettings) getStubSettings()).updateRepositorySettings();
  }

  /** Returns the object with the settings used for calls to deleteRepository. */
  public UnaryCallSettings<DeleteRepositoryRequest, Empty> deleteRepositorySettings() {
    return ((DataformStubSettings) getStubSettings()).deleteRepositorySettings();
  }

  /** Returns the object with the settings used for calls to fetchRemoteBranches. */
  public UnaryCallSettings<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>
      fetchRemoteBranchesSettings() {
    return ((DataformStubSettings) getStubSettings()).fetchRemoteBranchesSettings();
  }

  /** Returns the object with the settings used for calls to listWorkspaces. */
  public PagedCallSettings<
          ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>
      listWorkspacesSettings() {
    return ((DataformStubSettings) getStubSettings()).listWorkspacesSettings();
  }

  /** Returns the object with the settings used for calls to getWorkspace. */
  public UnaryCallSettings<GetWorkspaceRequest, Workspace> getWorkspaceSettings() {
    return ((DataformStubSettings) getStubSettings()).getWorkspaceSettings();
  }

  /** Returns the object with the settings used for calls to createWorkspace. */
  public UnaryCallSettings<CreateWorkspaceRequest, Workspace> createWorkspaceSettings() {
    return ((DataformStubSettings) getStubSettings()).createWorkspaceSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkspace. */
  public UnaryCallSettings<DeleteWorkspaceRequest, Empty> deleteWorkspaceSettings() {
    return ((DataformStubSettings) getStubSettings()).deleteWorkspaceSettings();
  }

  /** Returns the object with the settings used for calls to installNpmPackages. */
  public UnaryCallSettings<InstallNpmPackagesRequest, InstallNpmPackagesResponse>
      installNpmPackagesSettings() {
    return ((DataformStubSettings) getStubSettings()).installNpmPackagesSettings();
  }

  /** Returns the object with the settings used for calls to pullGitCommits. */
  public UnaryCallSettings<PullGitCommitsRequest, Empty> pullGitCommitsSettings() {
    return ((DataformStubSettings) getStubSettings()).pullGitCommitsSettings();
  }

  /** Returns the object with the settings used for calls to pushGitCommits. */
  public UnaryCallSettings<PushGitCommitsRequest, Empty> pushGitCommitsSettings() {
    return ((DataformStubSettings) getStubSettings()).pushGitCommitsSettings();
  }

  /** Returns the object with the settings used for calls to fetchFileGitStatuses. */
  public UnaryCallSettings<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
      fetchFileGitStatusesSettings() {
    return ((DataformStubSettings) getStubSettings()).fetchFileGitStatusesSettings();
  }

  /** Returns the object with the settings used for calls to fetchGitAheadBehind. */
  public UnaryCallSettings<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
      fetchGitAheadBehindSettings() {
    return ((DataformStubSettings) getStubSettings()).fetchGitAheadBehindSettings();
  }

  /** Returns the object with the settings used for calls to commitWorkspaceChanges. */
  public UnaryCallSettings<CommitWorkspaceChangesRequest, Empty> commitWorkspaceChangesSettings() {
    return ((DataformStubSettings) getStubSettings()).commitWorkspaceChangesSettings();
  }

  /** Returns the object with the settings used for calls to resetWorkspaceChanges. */
  public UnaryCallSettings<ResetWorkspaceChangesRequest, Empty> resetWorkspaceChangesSettings() {
    return ((DataformStubSettings) getStubSettings()).resetWorkspaceChangesSettings();
  }

  /** Returns the object with the settings used for calls to fetchFileDiff. */
  public UnaryCallSettings<FetchFileDiffRequest, FetchFileDiffResponse> fetchFileDiffSettings() {
    return ((DataformStubSettings) getStubSettings()).fetchFileDiffSettings();
  }

  /** Returns the object with the settings used for calls to queryDirectoryContents. */
  public PagedCallSettings<
          QueryDirectoryContentsRequest,
          QueryDirectoryContentsResponse,
          QueryDirectoryContentsPagedResponse>
      queryDirectoryContentsSettings() {
    return ((DataformStubSettings) getStubSettings()).queryDirectoryContentsSettings();
  }

  /** Returns the object with the settings used for calls to makeDirectory. */
  public UnaryCallSettings<MakeDirectoryRequest, MakeDirectoryResponse> makeDirectorySettings() {
    return ((DataformStubSettings) getStubSettings()).makeDirectorySettings();
  }

  /** Returns the object with the settings used for calls to removeDirectory. */
  public UnaryCallSettings<RemoveDirectoryRequest, Empty> removeDirectorySettings() {
    return ((DataformStubSettings) getStubSettings()).removeDirectorySettings();
  }

  /** Returns the object with the settings used for calls to moveDirectory. */
  public UnaryCallSettings<MoveDirectoryRequest, MoveDirectoryResponse> moveDirectorySettings() {
    return ((DataformStubSettings) getStubSettings()).moveDirectorySettings();
  }

  /** Returns the object with the settings used for calls to readFile. */
  public UnaryCallSettings<ReadFileRequest, ReadFileResponse> readFileSettings() {
    return ((DataformStubSettings) getStubSettings()).readFileSettings();
  }

  /** Returns the object with the settings used for calls to removeFile. */
  public UnaryCallSettings<RemoveFileRequest, Empty> removeFileSettings() {
    return ((DataformStubSettings) getStubSettings()).removeFileSettings();
  }

  /** Returns the object with the settings used for calls to moveFile. */
  public UnaryCallSettings<MoveFileRequest, MoveFileResponse> moveFileSettings() {
    return ((DataformStubSettings) getStubSettings()).moveFileSettings();
  }

  /** Returns the object with the settings used for calls to writeFile. */
  public UnaryCallSettings<WriteFileRequest, WriteFileResponse> writeFileSettings() {
    return ((DataformStubSettings) getStubSettings()).writeFileSettings();
  }

  /** Returns the object with the settings used for calls to listCompilationResults. */
  public PagedCallSettings<
          ListCompilationResultsRequest,
          ListCompilationResultsResponse,
          ListCompilationResultsPagedResponse>
      listCompilationResultsSettings() {
    return ((DataformStubSettings) getStubSettings()).listCompilationResultsSettings();
  }

  /** Returns the object with the settings used for calls to getCompilationResult. */
  public UnaryCallSettings<GetCompilationResultRequest, CompilationResult>
      getCompilationResultSettings() {
    return ((DataformStubSettings) getStubSettings()).getCompilationResultSettings();
  }

  /** Returns the object with the settings used for calls to createCompilationResult. */
  public UnaryCallSettings<CreateCompilationResultRequest, CompilationResult>
      createCompilationResultSettings() {
    return ((DataformStubSettings) getStubSettings()).createCompilationResultSettings();
  }

  /** Returns the object with the settings used for calls to queryCompilationResultActions. */
  public PagedCallSettings<
          QueryCompilationResultActionsRequest,
          QueryCompilationResultActionsResponse,
          QueryCompilationResultActionsPagedResponse>
      queryCompilationResultActionsSettings() {
    return ((DataformStubSettings) getStubSettings()).queryCompilationResultActionsSettings();
  }

  /** Returns the object with the settings used for calls to listWorkflowInvocations. */
  public PagedCallSettings<
          ListWorkflowInvocationsRequest,
          ListWorkflowInvocationsResponse,
          ListWorkflowInvocationsPagedResponse>
      listWorkflowInvocationsSettings() {
    return ((DataformStubSettings) getStubSettings()).listWorkflowInvocationsSettings();
  }

  /** Returns the object with the settings used for calls to getWorkflowInvocation. */
  public UnaryCallSettings<GetWorkflowInvocationRequest, WorkflowInvocation>
      getWorkflowInvocationSettings() {
    return ((DataformStubSettings) getStubSettings()).getWorkflowInvocationSettings();
  }

  /** Returns the object with the settings used for calls to createWorkflowInvocation. */
  public UnaryCallSettings<CreateWorkflowInvocationRequest, WorkflowInvocation>
      createWorkflowInvocationSettings() {
    return ((DataformStubSettings) getStubSettings()).createWorkflowInvocationSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkflowInvocation. */
  public UnaryCallSettings<DeleteWorkflowInvocationRequest, Empty>
      deleteWorkflowInvocationSettings() {
    return ((DataformStubSettings) getStubSettings()).deleteWorkflowInvocationSettings();
  }

  /** Returns the object with the settings used for calls to cancelWorkflowInvocation. */
  public UnaryCallSettings<CancelWorkflowInvocationRequest, Empty>
      cancelWorkflowInvocationSettings() {
    return ((DataformStubSettings) getStubSettings()).cancelWorkflowInvocationSettings();
  }

  /** Returns the object with the settings used for calls to queryWorkflowInvocationActions. */
  public PagedCallSettings<
          QueryWorkflowInvocationActionsRequest,
          QueryWorkflowInvocationActionsResponse,
          QueryWorkflowInvocationActionsPagedResponse>
      queryWorkflowInvocationActionsSettings() {
    return ((DataformStubSettings) getStubSettings()).queryWorkflowInvocationActionsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DataformStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DataformStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((DataformStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((DataformStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((DataformStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final DataformSettings create(DataformStubSettings stub) throws IOException {
    return new DataformSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataformStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataformStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataformStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataformStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataformStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataformStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataformStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataformStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected DataformSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataformSettings. */
  public static class Builder extends ClientSettings.Builder<DataformSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataformStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataformSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataformStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataformStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DataformStubSettings.newHttpJsonBuilder());
    }

    public DataformStubSettings.Builder getStubSettingsBuilder() {
      return ((DataformStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listRepositories. */
    public PagedCallSettings.Builder<
            ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
        listRepositoriesSettings() {
      return getStubSettingsBuilder().listRepositoriesSettings();
    }

    /** Returns the builder for the settings used for calls to getRepository. */
    public UnaryCallSettings.Builder<GetRepositoryRequest, Repository> getRepositorySettings() {
      return getStubSettingsBuilder().getRepositorySettings();
    }

    /** Returns the builder for the settings used for calls to createRepository. */
    public UnaryCallSettings.Builder<CreateRepositoryRequest, Repository>
        createRepositorySettings() {
      return getStubSettingsBuilder().createRepositorySettings();
    }

    /** Returns the builder for the settings used for calls to updateRepository. */
    public UnaryCallSettings.Builder<UpdateRepositoryRequest, Repository>
        updateRepositorySettings() {
      return getStubSettingsBuilder().updateRepositorySettings();
    }

    /** Returns the builder for the settings used for calls to deleteRepository. */
    public UnaryCallSettings.Builder<DeleteRepositoryRequest, Empty> deleteRepositorySettings() {
      return getStubSettingsBuilder().deleteRepositorySettings();
    }

    /** Returns the builder for the settings used for calls to fetchRemoteBranches. */
    public UnaryCallSettings.Builder<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>
        fetchRemoteBranchesSettings() {
      return getStubSettingsBuilder().fetchRemoteBranchesSettings();
    }

    /** Returns the builder for the settings used for calls to listWorkspaces. */
    public PagedCallSettings.Builder<
            ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>
        listWorkspacesSettings() {
      return getStubSettingsBuilder().listWorkspacesSettings();
    }

    /** Returns the builder for the settings used for calls to getWorkspace. */
    public UnaryCallSettings.Builder<GetWorkspaceRequest, Workspace> getWorkspaceSettings() {
      return getStubSettingsBuilder().getWorkspaceSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkspace. */
    public UnaryCallSettings.Builder<CreateWorkspaceRequest, Workspace> createWorkspaceSettings() {
      return getStubSettingsBuilder().createWorkspaceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkspace. */
    public UnaryCallSettings.Builder<DeleteWorkspaceRequest, Empty> deleteWorkspaceSettings() {
      return getStubSettingsBuilder().deleteWorkspaceSettings();
    }

    /** Returns the builder for the settings used for calls to installNpmPackages. */
    public UnaryCallSettings.Builder<InstallNpmPackagesRequest, InstallNpmPackagesResponse>
        installNpmPackagesSettings() {
      return getStubSettingsBuilder().installNpmPackagesSettings();
    }

    /** Returns the builder for the settings used for calls to pullGitCommits. */
    public UnaryCallSettings.Builder<PullGitCommitsRequest, Empty> pullGitCommitsSettings() {
      return getStubSettingsBuilder().pullGitCommitsSettings();
    }

    /** Returns the builder for the settings used for calls to pushGitCommits. */
    public UnaryCallSettings.Builder<PushGitCommitsRequest, Empty> pushGitCommitsSettings() {
      return getStubSettingsBuilder().pushGitCommitsSettings();
    }

    /** Returns the builder for the settings used for calls to fetchFileGitStatuses. */
    public UnaryCallSettings.Builder<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
        fetchFileGitStatusesSettings() {
      return getStubSettingsBuilder().fetchFileGitStatusesSettings();
    }

    /** Returns the builder for the settings used for calls to fetchGitAheadBehind. */
    public UnaryCallSettings.Builder<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
        fetchGitAheadBehindSettings() {
      return getStubSettingsBuilder().fetchGitAheadBehindSettings();
    }

    /** Returns the builder for the settings used for calls to commitWorkspaceChanges. */
    public UnaryCallSettings.Builder<CommitWorkspaceChangesRequest, Empty>
        commitWorkspaceChangesSettings() {
      return getStubSettingsBuilder().commitWorkspaceChangesSettings();
    }

    /** Returns the builder for the settings used for calls to resetWorkspaceChanges. */
    public UnaryCallSettings.Builder<ResetWorkspaceChangesRequest, Empty>
        resetWorkspaceChangesSettings() {
      return getStubSettingsBuilder().resetWorkspaceChangesSettings();
    }

    /** Returns the builder for the settings used for calls to fetchFileDiff. */
    public UnaryCallSettings.Builder<FetchFileDiffRequest, FetchFileDiffResponse>
        fetchFileDiffSettings() {
      return getStubSettingsBuilder().fetchFileDiffSettings();
    }

    /** Returns the builder for the settings used for calls to queryDirectoryContents. */
    public PagedCallSettings.Builder<
            QueryDirectoryContentsRequest,
            QueryDirectoryContentsResponse,
            QueryDirectoryContentsPagedResponse>
        queryDirectoryContentsSettings() {
      return getStubSettingsBuilder().queryDirectoryContentsSettings();
    }

    /** Returns the builder for the settings used for calls to makeDirectory. */
    public UnaryCallSettings.Builder<MakeDirectoryRequest, MakeDirectoryResponse>
        makeDirectorySettings() {
      return getStubSettingsBuilder().makeDirectorySettings();
    }

    /** Returns the builder for the settings used for calls to removeDirectory. */
    public UnaryCallSettings.Builder<RemoveDirectoryRequest, Empty> removeDirectorySettings() {
      return getStubSettingsBuilder().removeDirectorySettings();
    }

    /** Returns the builder for the settings used for calls to moveDirectory. */
    public UnaryCallSettings.Builder<MoveDirectoryRequest, MoveDirectoryResponse>
        moveDirectorySettings() {
      return getStubSettingsBuilder().moveDirectorySettings();
    }

    /** Returns the builder for the settings used for calls to readFile. */
    public UnaryCallSettings.Builder<ReadFileRequest, ReadFileResponse> readFileSettings() {
      return getStubSettingsBuilder().readFileSettings();
    }

    /** Returns the builder for the settings used for calls to removeFile. */
    public UnaryCallSettings.Builder<RemoveFileRequest, Empty> removeFileSettings() {
      return getStubSettingsBuilder().removeFileSettings();
    }

    /** Returns the builder for the settings used for calls to moveFile. */
    public UnaryCallSettings.Builder<MoveFileRequest, MoveFileResponse> moveFileSettings() {
      return getStubSettingsBuilder().moveFileSettings();
    }

    /** Returns the builder for the settings used for calls to writeFile. */
    public UnaryCallSettings.Builder<WriteFileRequest, WriteFileResponse> writeFileSettings() {
      return getStubSettingsBuilder().writeFileSettings();
    }

    /** Returns the builder for the settings used for calls to listCompilationResults. */
    public PagedCallSettings.Builder<
            ListCompilationResultsRequest,
            ListCompilationResultsResponse,
            ListCompilationResultsPagedResponse>
        listCompilationResultsSettings() {
      return getStubSettingsBuilder().listCompilationResultsSettings();
    }

    /** Returns the builder for the settings used for calls to getCompilationResult. */
    public UnaryCallSettings.Builder<GetCompilationResultRequest, CompilationResult>
        getCompilationResultSettings() {
      return getStubSettingsBuilder().getCompilationResultSettings();
    }

    /** Returns the builder for the settings used for calls to createCompilationResult. */
    public UnaryCallSettings.Builder<CreateCompilationResultRequest, CompilationResult>
        createCompilationResultSettings() {
      return getStubSettingsBuilder().createCompilationResultSettings();
    }

    /** Returns the builder for the settings used for calls to queryCompilationResultActions. */
    public PagedCallSettings.Builder<
            QueryCompilationResultActionsRequest,
            QueryCompilationResultActionsResponse,
            QueryCompilationResultActionsPagedResponse>
        queryCompilationResultActionsSettings() {
      return getStubSettingsBuilder().queryCompilationResultActionsSettings();
    }

    /** Returns the builder for the settings used for calls to listWorkflowInvocations. */
    public PagedCallSettings.Builder<
            ListWorkflowInvocationsRequest,
            ListWorkflowInvocationsResponse,
            ListWorkflowInvocationsPagedResponse>
        listWorkflowInvocationsSettings() {
      return getStubSettingsBuilder().listWorkflowInvocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getWorkflowInvocation. */
    public UnaryCallSettings.Builder<GetWorkflowInvocationRequest, WorkflowInvocation>
        getWorkflowInvocationSettings() {
      return getStubSettingsBuilder().getWorkflowInvocationSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkflowInvocation. */
    public UnaryCallSettings.Builder<CreateWorkflowInvocationRequest, WorkflowInvocation>
        createWorkflowInvocationSettings() {
      return getStubSettingsBuilder().createWorkflowInvocationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkflowInvocation. */
    public UnaryCallSettings.Builder<DeleteWorkflowInvocationRequest, Empty>
        deleteWorkflowInvocationSettings() {
      return getStubSettingsBuilder().deleteWorkflowInvocationSettings();
    }

    /** Returns the builder for the settings used for calls to cancelWorkflowInvocation. */
    public UnaryCallSettings.Builder<CancelWorkflowInvocationRequest, Empty>
        cancelWorkflowInvocationSettings() {
      return getStubSettingsBuilder().cancelWorkflowInvocationSettings();
    }

    /** Returns the builder for the settings used for calls to queryWorkflowInvocationActions. */
    public PagedCallSettings.Builder<
            QueryWorkflowInvocationActionsRequest,
            QueryWorkflowInvocationActionsResponse,
            QueryWorkflowInvocationActionsPagedResponse>
        queryWorkflowInvocationActionsSettings() {
      return getStubSettingsBuilder().queryWorkflowInvocationActionsSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public DataformSettings build() throws IOException {
      return new DataformSettings(this);
    }
  }
}
