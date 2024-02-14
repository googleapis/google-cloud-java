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

package com.google.cloud.dataform.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataform.v1beta1.stub.DataformStub;
import com.google.cloud.dataform.v1beta1.stub.DataformStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Dataform is a service to develop, create, document, test, and update curated
 * tables in BigQuery.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataformClient dataformClient = DataformClient.create()) {
 *   RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
 *   Repository response = dataformClient.getRepository(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataformClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListRepositories</td>
 *      <td><p> Lists Repositories in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRepositories(ListRepositoriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRepositories(LocationName parent)
 *           <li><p> listRepositories(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRepositoriesPagedCallable()
 *           <li><p> listRepositoriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRepository</td>
 *      <td><p> Fetches a single Repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRepository(GetRepositoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRepository(RepositoryName name)
 *           <li><p> getRepository(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRepositoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRepository</td>
 *      <td><p> Creates a new Repository in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRepository(CreateRepositoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createRepository(LocationName parent, Repository repository, String repositoryId)
 *           <li><p> createRepository(String parent, Repository repository, String repositoryId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRepositoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRepository</td>
 *      <td><p> Updates a single Repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRepository(UpdateRepositoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateRepository(Repository repository, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRepositoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRepository</td>
 *      <td><p> Deletes a single Repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRepository(DeleteRepositoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteRepository(RepositoryName name)
 *           <li><p> deleteRepository(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRepositoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CommitRepositoryChanges</td>
 *      <td><p> Applies a Git commit to a Repository. The Repository must not have a value for `git_remote_settings.url`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> commitRepositoryChanges(CommitRepositoryChangesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> commitRepositoryChangesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ReadRepositoryFile</td>
 *      <td><p> Returns the contents of a file (inside a Repository). The Repository must not have a value for `git_remote_settings.url`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> readRepositoryFile(ReadRepositoryFileRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> readRepositoryFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryRepositoryDirectoryContents</td>
 *      <td><p> Returns the contents of a given Repository directory. The Repository must not have a value for `git_remote_settings.url`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryRepositoryDirectoryContents(QueryRepositoryDirectoryContentsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryRepositoryDirectoryContentsPagedCallable()
 *           <li><p> queryRepositoryDirectoryContentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchRepositoryHistory</td>
 *      <td><p> Fetches a Repository's history of commits.  The Repository must not have a value for `git_remote_settings.url`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchRepositoryHistory(FetchRepositoryHistoryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchRepositoryHistoryPagedCallable()
 *           <li><p> fetchRepositoryHistoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ComputeRepositoryAccessTokenStatus</td>
 *      <td><p> Computes a Repository's Git access token status.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> computeRepositoryAccessTokenStatus(ComputeRepositoryAccessTokenStatusRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> computeRepositoryAccessTokenStatusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchRemoteBranches</td>
 *      <td><p> Fetches a Repository's remote branches.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchRemoteBranches(FetchRemoteBranchesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchRemoteBranchesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListWorkspaces</td>
 *      <td><p> Lists Workspaces in a given Repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listWorkspaces(ListWorkspacesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listWorkspaces(RepositoryName parent)
 *           <li><p> listWorkspaces(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listWorkspacesPagedCallable()
 *           <li><p> listWorkspacesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetWorkspace</td>
 *      <td><p> Fetches a single Workspace.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getWorkspace(GetWorkspaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getWorkspace(WorkspaceName name)
 *           <li><p> getWorkspace(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getWorkspaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateWorkspace</td>
 *      <td><p> Creates a new Workspace in a given Repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createWorkspace(CreateWorkspaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createWorkspace(RepositoryName parent, Workspace workspace, String workspaceId)
 *           <li><p> createWorkspace(String parent, Workspace workspace, String workspaceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createWorkspaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteWorkspace</td>
 *      <td><p> Deletes a single Workspace.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteWorkspace(DeleteWorkspaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteWorkspace(WorkspaceName name)
 *           <li><p> deleteWorkspace(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteWorkspaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> InstallNpmPackages</td>
 *      <td><p> Installs dependency NPM packages (inside a Workspace).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> installNpmPackages(InstallNpmPackagesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> installNpmPackagesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PullGitCommits</td>
 *      <td><p> Pulls Git commits from the Repository's remote into a Workspace.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> pullGitCommits(PullGitCommitsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> pullGitCommitsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PushGitCommits</td>
 *      <td><p> Pushes Git commits from a Workspace to the Repository's remote.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> pushGitCommits(PushGitCommitsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> pushGitCommitsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchFileGitStatuses</td>
 *      <td><p> Fetches Git statuses for the files in a Workspace.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchFileGitStatuses(FetchFileGitStatusesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchFileGitStatusesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchGitAheadBehind</td>
 *      <td><p> Fetches Git ahead/behind against a remote branch.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchGitAheadBehind(FetchGitAheadBehindRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchGitAheadBehindCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CommitWorkspaceChanges</td>
 *      <td><p> Applies a Git commit for uncommitted files in a Workspace.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> commitWorkspaceChanges(CommitWorkspaceChangesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> commitWorkspaceChangesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResetWorkspaceChanges</td>
 *      <td><p> Performs a Git reset for uncommitted files in a Workspace.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resetWorkspaceChanges(ResetWorkspaceChangesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resetWorkspaceChangesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchFileDiff</td>
 *      <td><p> Fetches Git diff for an uncommitted file in a Workspace.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchFileDiff(FetchFileDiffRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchFileDiffCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryDirectoryContents</td>
 *      <td><p> Returns the contents of a given Workspace directory.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryDirectoryContents(QueryDirectoryContentsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryDirectoryContentsPagedCallable()
 *           <li><p> queryDirectoryContentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> MakeDirectory</td>
 *      <td><p> Creates a directory inside a Workspace.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> makeDirectory(MakeDirectoryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> makeDirectoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveDirectory</td>
 *      <td><p> Deletes a directory (inside a Workspace) and all of its contents.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeDirectory(RemoveDirectoryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeDirectoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> MoveDirectory</td>
 *      <td><p> Moves a directory (inside a Workspace), and all of its contents, to a new location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> moveDirectory(MoveDirectoryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> moveDirectoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ReadFile</td>
 *      <td><p> Returns the contents of a file (inside a Workspace).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> readFile(ReadFileRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> readFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveFile</td>
 *      <td><p> Deletes a file (inside a Workspace).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeFile(RemoveFileRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> MoveFile</td>
 *      <td><p> Moves a file (inside a Workspace) to a new location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> moveFile(MoveFileRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> moveFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> WriteFile</td>
 *      <td><p> Writes to a file (inside a Workspace).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> writeFile(WriteFileRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> writeFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListReleaseConfigs</td>
 *      <td><p> Lists ReleaseConfigs in a given Repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listReleaseConfigs(ListReleaseConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listReleaseConfigs(RepositoryName parent)
 *           <li><p> listReleaseConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listReleaseConfigsPagedCallable()
 *           <li><p> listReleaseConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetReleaseConfig</td>
 *      <td><p> Fetches a single ReleaseConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getReleaseConfig(GetReleaseConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getReleaseConfig(ReleaseConfigName name)
 *           <li><p> getReleaseConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getReleaseConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateReleaseConfig</td>
 *      <td><p> Creates a new ReleaseConfig in a given Repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createReleaseConfig(CreateReleaseConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createReleaseConfig(RepositoryName parent, ReleaseConfig releaseConfig, String releaseConfigId)
 *           <li><p> createReleaseConfig(String parent, ReleaseConfig releaseConfig, String releaseConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createReleaseConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateReleaseConfig</td>
 *      <td><p> Updates a single ReleaseConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateReleaseConfig(UpdateReleaseConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateReleaseConfig(ReleaseConfig releaseConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateReleaseConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteReleaseConfig</td>
 *      <td><p> Deletes a single ReleaseConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteReleaseConfig(DeleteReleaseConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteReleaseConfig(ReleaseConfigName name)
 *           <li><p> deleteReleaseConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteReleaseConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCompilationResults</td>
 *      <td><p> Lists CompilationResults in a given Repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCompilationResults(ListCompilationResultsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCompilationResults(RepositoryName parent)
 *           <li><p> listCompilationResults(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCompilationResultsPagedCallable()
 *           <li><p> listCompilationResultsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCompilationResult</td>
 *      <td><p> Fetches a single CompilationResult.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCompilationResult(GetCompilationResultRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCompilationResult(CompilationResultName name)
 *           <li><p> getCompilationResult(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCompilationResultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCompilationResult</td>
 *      <td><p> Creates a new CompilationResult in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCompilationResult(CreateCompilationResultRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCompilationResult(RepositoryName parent, CompilationResult compilationResult)
 *           <li><p> createCompilationResult(String parent, CompilationResult compilationResult)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCompilationResultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryCompilationResultActions</td>
 *      <td><p> Returns CompilationResultActions in a given CompilationResult.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryCompilationResultActions(QueryCompilationResultActionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryCompilationResultActionsPagedCallable()
 *           <li><p> queryCompilationResultActionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListWorkflowConfigs</td>
 *      <td><p> Lists WorkflowConfigs in a given Repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listWorkflowConfigs(ListWorkflowConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listWorkflowConfigs(RepositoryName parent)
 *           <li><p> listWorkflowConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listWorkflowConfigsPagedCallable()
 *           <li><p> listWorkflowConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetWorkflowConfig</td>
 *      <td><p> Fetches a single WorkflowConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getWorkflowConfig(GetWorkflowConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getWorkflowConfig(WorkflowConfigName name)
 *           <li><p> getWorkflowConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getWorkflowConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateWorkflowConfig</td>
 *      <td><p> Creates a new WorkflowConfig in a given Repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createWorkflowConfig(CreateWorkflowConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createWorkflowConfig(RepositoryName parent, WorkflowConfig workflowConfig, String workflowConfigId)
 *           <li><p> createWorkflowConfig(String parent, WorkflowConfig workflowConfig, String workflowConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createWorkflowConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateWorkflowConfig</td>
 *      <td><p> Updates a single WorkflowConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateWorkflowConfig(UpdateWorkflowConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateWorkflowConfig(WorkflowConfig workflowConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateWorkflowConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteWorkflowConfig</td>
 *      <td><p> Deletes a single WorkflowConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteWorkflowConfig(DeleteWorkflowConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteWorkflowConfig(WorkflowConfigName name)
 *           <li><p> deleteWorkflowConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteWorkflowConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListWorkflowInvocations</td>
 *      <td><p> Lists WorkflowInvocations in a given Repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listWorkflowInvocations(ListWorkflowInvocationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listWorkflowInvocations(RepositoryName parent)
 *           <li><p> listWorkflowInvocations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listWorkflowInvocationsPagedCallable()
 *           <li><p> listWorkflowInvocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetWorkflowInvocation</td>
 *      <td><p> Fetches a single WorkflowInvocation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getWorkflowInvocation(GetWorkflowInvocationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getWorkflowInvocation(WorkflowInvocationName name)
 *           <li><p> getWorkflowInvocation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getWorkflowInvocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateWorkflowInvocation</td>
 *      <td><p> Creates a new WorkflowInvocation in a given Repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createWorkflowInvocation(CreateWorkflowInvocationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createWorkflowInvocation(RepositoryName parent, WorkflowInvocation workflowInvocation)
 *           <li><p> createWorkflowInvocation(String parent, WorkflowInvocation workflowInvocation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createWorkflowInvocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteWorkflowInvocation</td>
 *      <td><p> Deletes a single WorkflowInvocation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteWorkflowInvocation(DeleteWorkflowInvocationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteWorkflowInvocation(WorkflowInvocationName name)
 *           <li><p> deleteWorkflowInvocation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteWorkflowInvocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CancelWorkflowInvocation</td>
 *      <td><p> Requests cancellation of a running WorkflowInvocation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cancelWorkflowInvocation(CancelWorkflowInvocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cancelWorkflowInvocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryWorkflowInvocationActions</td>
 *      <td><p> Returns WorkflowInvocationActions in a given WorkflowInvocation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryWorkflowInvocationActions(QueryWorkflowInvocationActionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryWorkflowInvocationActionsPagedCallable()
 *           <li><p> queryWorkflowInvocationActionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of DataformSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataformSettings dataformSettings =
 *     DataformSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataformClient dataformClient = DataformClient.create(dataformSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataformSettings dataformSettings =
 *     DataformSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataformClient dataformClient = DataformClient.create(dataformSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataformSettings dataformSettings = DataformSettings.newHttpJsonBuilder().build();
 * DataformClient dataformClient = DataformClient.create(dataformSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataformClient implements BackgroundResource {
  private final DataformSettings settings;
  private final DataformStub stub;

  /** Constructs an instance of DataformClient with default settings. */
  public static final DataformClient create() throws IOException {
    return create(DataformSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataformClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataformClient create(DataformSettings settings) throws IOException {
    return new DataformClient(settings);
  }

  /**
   * Constructs an instance of DataformClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(DataformSettings).
   */
  public static final DataformClient create(DataformStub stub) {
    return new DataformClient(stub);
  }

  /**
   * Constructs an instance of DataformClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected DataformClient(DataformSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataformStubSettings) settings.getStubSettings()).createStub();
  }

  protected DataformClient(DataformStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DataformSettings getSettings() {
    return settings;
  }

  public DataformStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Repositories in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Repository element : dataformClient.listRepositories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location in which to list repositories. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRepositoriesPagedResponse listRepositories(LocationName parent) {
    ListRepositoriesRequest request =
        ListRepositoriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRepositories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Repositories in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Repository element : dataformClient.listRepositories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location in which to list repositories. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRepositoriesPagedResponse listRepositories(String parent) {
    ListRepositoriesRequest request =
        ListRepositoriesRequest.newBuilder().setParent(parent).build();
    return listRepositories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Repositories in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListRepositoriesRequest request =
   *       ListRepositoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Repository element : dataformClient.listRepositories(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRepositoriesPagedResponse listRepositories(ListRepositoriesRequest request) {
    return listRepositoriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Repositories in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListRepositoriesRequest request =
   *       ListRepositoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Repository> future =
   *       dataformClient.listRepositoriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Repository element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRepositoriesRequest, ListRepositoriesPagedResponse>
      listRepositoriesPagedCallable() {
    return stub.listRepositoriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Repositories in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListRepositoriesRequest request =
   *       ListRepositoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListRepositoriesResponse response = dataformClient.listRepositoriesCallable().call(request);
   *     for (Repository element : response.getRepositoriesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesCallable() {
    return stub.listRepositoriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   Repository response = dataformClient.getRepository(name);
   * }
   * }</pre>
   *
   * @param name Required. The repository's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Repository getRepository(RepositoryName name) {
    GetRepositoryRequest request =
        GetRepositoryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRepository(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   Repository response = dataformClient.getRepository(name);
   * }
   * }</pre>
   *
   * @param name Required. The repository's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Repository getRepository(String name) {
    GetRepositoryRequest request = GetRepositoryRequest.newBuilder().setName(name).build();
    return getRepository(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetRepositoryRequest request =
   *       GetRepositoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .build();
   *   Repository response = dataformClient.getRepository(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Repository getRepository(GetRepositoryRequest request) {
    return getRepositoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetRepositoryRequest request =
   *       GetRepositoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .build();
   *   ApiFuture<Repository> future = dataformClient.getRepositoryCallable().futureCall(request);
   *   // Do something.
   *   Repository response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable() {
    return stub.getRepositoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Repository in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Repository repository = Repository.newBuilder().build();
   *   String repositoryId = "repositoryId2113747461";
   *   Repository response = dataformClient.createRepository(parent, repository, repositoryId);
   * }
   * }</pre>
   *
   * @param parent Required. The location in which to create the repository. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param repository Required. The repository to create.
   * @param repositoryId Required. The ID to use for the repository, which will become the final
   *     component of the repository's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Repository createRepository(
      LocationName parent, Repository repository, String repositoryId) {
    CreateRepositoryRequest request =
        CreateRepositoryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRepository(repository)
            .setRepositoryId(repositoryId)
            .build();
    return createRepository(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Repository in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Repository repository = Repository.newBuilder().build();
   *   String repositoryId = "repositoryId2113747461";
   *   Repository response = dataformClient.createRepository(parent, repository, repositoryId);
   * }
   * }</pre>
   *
   * @param parent Required. The location in which to create the repository. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param repository Required. The repository to create.
   * @param repositoryId Required. The ID to use for the repository, which will become the final
   *     component of the repository's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Repository createRepository(
      String parent, Repository repository, String repositoryId) {
    CreateRepositoryRequest request =
        CreateRepositoryRequest.newBuilder()
            .setParent(parent)
            .setRepository(repository)
            .setRepositoryId(repositoryId)
            .build();
    return createRepository(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Repository in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CreateRepositoryRequest request =
   *       CreateRepositoryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRepository(Repository.newBuilder().build())
   *           .setRepositoryId("repositoryId2113747461")
   *           .build();
   *   Repository response = dataformClient.createRepository(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Repository createRepository(CreateRepositoryRequest request) {
    return createRepositoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Repository in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CreateRepositoryRequest request =
   *       CreateRepositoryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRepository(Repository.newBuilder().build())
   *           .setRepositoryId("repositoryId2113747461")
   *           .build();
   *   ApiFuture<Repository> future = dataformClient.createRepositoryCallable().futureCall(request);
   *   // Do something.
   *   Repository response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRepositoryRequest, Repository> createRepositoryCallable() {
    return stub.createRepositoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   Repository repository = Repository.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Repository response = dataformClient.updateRepository(repository, updateMask);
   * }
   * }</pre>
   *
   * @param repository Required. The repository to update.
   * @param updateMask Optional. Specifies the fields to be updated in the repository. If left
   *     unset, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Repository updateRepository(Repository repository, FieldMask updateMask) {
    UpdateRepositoryRequest request =
        UpdateRepositoryRequest.newBuilder()
            .setRepository(repository)
            .setUpdateMask(updateMask)
            .build();
    return updateRepository(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   UpdateRepositoryRequest request =
   *       UpdateRepositoryRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRepository(Repository.newBuilder().build())
   *           .build();
   *   Repository response = dataformClient.updateRepository(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Repository updateRepository(UpdateRepositoryRequest request) {
    return updateRepositoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   UpdateRepositoryRequest request =
   *       UpdateRepositoryRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRepository(Repository.newBuilder().build())
   *           .build();
   *   ApiFuture<Repository> future = dataformClient.updateRepositoryCallable().futureCall(request);
   *   // Do something.
   *   Repository response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRepositoryRequest, Repository> updateRepositoryCallable() {
    return stub.updateRepositoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   dataformClient.deleteRepository(name);
   * }
   * }</pre>
   *
   * @param name Required. The repository's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRepository(RepositoryName name) {
    DeleteRepositoryRequest request =
        DeleteRepositoryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteRepository(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   dataformClient.deleteRepository(name);
   * }
   * }</pre>
   *
   * @param name Required. The repository's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRepository(String name) {
    DeleteRepositoryRequest request = DeleteRepositoryRequest.newBuilder().setName(name).build();
    deleteRepository(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   DeleteRepositoryRequest request =
   *       DeleteRepositoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setForce(true)
   *           .build();
   *   dataformClient.deleteRepository(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRepository(DeleteRepositoryRequest request) {
    deleteRepositoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   DeleteRepositoryRequest request =
   *       DeleteRepositoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = dataformClient.deleteRepositoryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRepositoryRequest, Empty> deleteRepositoryCallable() {
    return stub.deleteRepositoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies a Git commit to a Repository. The Repository must not have a value for
   * `git_remote_settings.url`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CommitRepositoryChangesRequest request =
   *       CommitRepositoryChangesRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setCommitMetadata(CommitMetadata.newBuilder().build())
   *           .setRequiredHeadCommitSha("requiredHeadCommitSha-393901930")
   *           .putAllFileOperations(
   *               new HashMap<String, CommitRepositoryChangesRequest.FileOperation>())
   *           .build();
   *   dataformClient.commitRepositoryChanges(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void commitRepositoryChanges(CommitRepositoryChangesRequest request) {
    commitRepositoryChangesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies a Git commit to a Repository. The Repository must not have a value for
   * `git_remote_settings.url`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CommitRepositoryChangesRequest request =
   *       CommitRepositoryChangesRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setCommitMetadata(CommitMetadata.newBuilder().build())
   *           .setRequiredHeadCommitSha("requiredHeadCommitSha-393901930")
   *           .putAllFileOperations(
   *               new HashMap<String, CommitRepositoryChangesRequest.FileOperation>())
   *           .build();
   *   ApiFuture<Empty> future =
   *       dataformClient.commitRepositoryChangesCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CommitRepositoryChangesRequest, Empty>
      commitRepositoryChangesCallable() {
    return stub.commitRepositoryChangesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a file (inside a Repository). The Repository must not have a value for
   * `git_remote_settings.url`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ReadRepositoryFileRequest request =
   *       ReadRepositoryFileRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setCommitSha("commitSha-1491174411")
   *           .setPath("path3433509")
   *           .build();
   *   ReadRepositoryFileResponse response = dataformClient.readRepositoryFile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadRepositoryFileResponse readRepositoryFile(ReadRepositoryFileRequest request) {
    return readRepositoryFileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a file (inside a Repository). The Repository must not have a value for
   * `git_remote_settings.url`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ReadRepositoryFileRequest request =
   *       ReadRepositoryFileRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setCommitSha("commitSha-1491174411")
   *           .setPath("path3433509")
   *           .build();
   *   ApiFuture<ReadRepositoryFileResponse> future =
   *       dataformClient.readRepositoryFileCallable().futureCall(request);
   *   // Do something.
   *   ReadRepositoryFileResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReadRepositoryFileRequest, ReadRepositoryFileResponse>
      readRepositoryFileCallable() {
    return stub.readRepositoryFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a given Repository directory. The Repository must not have a value for
   * `git_remote_settings.url`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   QueryRepositoryDirectoryContentsRequest request =
   *       QueryRepositoryDirectoryContentsRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setCommitSha("commitSha-1491174411")
   *           .setPath("path3433509")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DirectoryEntry element :
   *       dataformClient.queryRepositoryDirectoryContents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryRepositoryDirectoryContentsPagedResponse queryRepositoryDirectoryContents(
      QueryRepositoryDirectoryContentsRequest request) {
    return queryRepositoryDirectoryContentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a given Repository directory. The Repository must not have a value for
   * `git_remote_settings.url`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   QueryRepositoryDirectoryContentsRequest request =
   *       QueryRepositoryDirectoryContentsRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setCommitSha("commitSha-1491174411")
   *           .setPath("path3433509")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DirectoryEntry> future =
   *       dataformClient.queryRepositoryDirectoryContentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DirectoryEntry element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsPagedResponse>
      queryRepositoryDirectoryContentsPagedCallable() {
    return stub.queryRepositoryDirectoryContentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a given Repository directory. The Repository must not have a value for
   * `git_remote_settings.url`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   QueryRepositoryDirectoryContentsRequest request =
   *       QueryRepositoryDirectoryContentsRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setCommitSha("commitSha-1491174411")
   *           .setPath("path3433509")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     QueryRepositoryDirectoryContentsResponse response =
   *         dataformClient.queryRepositoryDirectoryContentsCallable().call(request);
   *     for (DirectoryEntry element : response.getDirectoryEntriesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          QueryRepositoryDirectoryContentsRequest, QueryRepositoryDirectoryContentsResponse>
      queryRepositoryDirectoryContentsCallable() {
    return stub.queryRepositoryDirectoryContentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a Repository's history of commits. The Repository must not have a value for
   * `git_remote_settings.url`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   FetchRepositoryHistoryRequest request =
   *       FetchRepositoryHistoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (CommitLogEntry element : dataformClient.fetchRepositoryHistory(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchRepositoryHistoryPagedResponse fetchRepositoryHistory(
      FetchRepositoryHistoryRequest request) {
    return fetchRepositoryHistoryPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a Repository's history of commits. The Repository must not have a value for
   * `git_remote_settings.url`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   FetchRepositoryHistoryRequest request =
   *       FetchRepositoryHistoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<CommitLogEntry> future =
   *       dataformClient.fetchRepositoryHistoryPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CommitLogEntry element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchRepositoryHistoryRequest, FetchRepositoryHistoryPagedResponse>
      fetchRepositoryHistoryPagedCallable() {
    return stub.fetchRepositoryHistoryPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a Repository's history of commits. The Repository must not have a value for
   * `git_remote_settings.url`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   FetchRepositoryHistoryRequest request =
   *       FetchRepositoryHistoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FetchRepositoryHistoryResponse response =
   *         dataformClient.fetchRepositoryHistoryCallable().call(request);
   *     for (CommitLogEntry element : response.getCommitsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse>
      fetchRepositoryHistoryCallable() {
    return stub.fetchRepositoryHistoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Computes a Repository's Git access token status.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ComputeRepositoryAccessTokenStatusRequest request =
   *       ComputeRepositoryAccessTokenStatusRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .build();
   *   ComputeRepositoryAccessTokenStatusResponse response =
   *       dataformClient.computeRepositoryAccessTokenStatus(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComputeRepositoryAccessTokenStatusResponse computeRepositoryAccessTokenStatus(
      ComputeRepositoryAccessTokenStatusRequest request) {
    return computeRepositoryAccessTokenStatusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Computes a Repository's Git access token status.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ComputeRepositoryAccessTokenStatusRequest request =
   *       ComputeRepositoryAccessTokenStatusRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .build();
   *   ApiFuture<ComputeRepositoryAccessTokenStatusResponse> future =
   *       dataformClient.computeRepositoryAccessTokenStatusCallable().futureCall(request);
   *   // Do something.
   *   ComputeRepositoryAccessTokenStatusResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ComputeRepositoryAccessTokenStatusRequest, ComputeRepositoryAccessTokenStatusResponse>
      computeRepositoryAccessTokenStatusCallable() {
    return stub.computeRepositoryAccessTokenStatusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a Repository's remote branches.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   FetchRemoteBranchesRequest request =
   *       FetchRemoteBranchesRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .build();
   *   FetchRemoteBranchesResponse response = dataformClient.fetchRemoteBranches(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchRemoteBranchesResponse fetchRemoteBranches(FetchRemoteBranchesRequest request) {
    return fetchRemoteBranchesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a Repository's remote branches.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   FetchRemoteBranchesRequest request =
   *       FetchRemoteBranchesRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .build();
   *   ApiFuture<FetchRemoteBranchesResponse> future =
   *       dataformClient.fetchRemoteBranchesCallable().futureCall(request);
   *   // Do something.
   *   FetchRemoteBranchesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchRemoteBranchesRequest, FetchRemoteBranchesResponse>
      fetchRemoteBranchesCallable() {
    return stub.fetchRemoteBranchesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Workspaces in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (Workspace element : dataformClient.listWorkspaces(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to list workspaces. Must be in the format
   *     `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkspacesPagedResponse listWorkspaces(RepositoryName parent) {
    ListWorkspacesRequest request =
        ListWorkspacesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWorkspaces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Workspaces in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (Workspace element : dataformClient.listWorkspaces(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to list workspaces. Must be in the format
   *     `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkspacesPagedResponse listWorkspaces(String parent) {
    ListWorkspacesRequest request = ListWorkspacesRequest.newBuilder().setParent(parent).build();
    return listWorkspaces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Workspaces in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListWorkspacesRequest request =
   *       ListWorkspacesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Workspace element : dataformClient.listWorkspaces(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkspacesPagedResponse listWorkspaces(ListWorkspacesRequest request) {
    return listWorkspacesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Workspaces in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListWorkspacesRequest request =
   *       ListWorkspacesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Workspace> future =
   *       dataformClient.listWorkspacesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Workspace element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWorkspacesRequest, ListWorkspacesPagedResponse>
      listWorkspacesPagedCallable() {
    return stub.listWorkspacesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Workspaces in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListWorkspacesRequest request =
   *       ListWorkspacesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListWorkspacesResponse response = dataformClient.listWorkspacesCallable().call(request);
   *     for (Workspace element : response.getWorkspacesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWorkspacesRequest, ListWorkspacesResponse>
      listWorkspacesCallable() {
    return stub.listWorkspacesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   WorkspaceName name =
   *       WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]");
   *   Workspace response = dataformClient.getWorkspace(name);
   * }
   * }</pre>
   *
   * @param name Required. The workspace's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workspace getWorkspace(WorkspaceName name) {
    GetWorkspaceRequest request =
        GetWorkspaceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getWorkspace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String name =
   *       WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]").toString();
   *   Workspace response = dataformClient.getWorkspace(name);
   * }
   * }</pre>
   *
   * @param name Required. The workspace's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workspace getWorkspace(String name) {
    GetWorkspaceRequest request = GetWorkspaceRequest.newBuilder().setName(name).build();
    return getWorkspace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetWorkspaceRequest request =
   *       GetWorkspaceRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .build();
   *   Workspace response = dataformClient.getWorkspace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workspace getWorkspace(GetWorkspaceRequest request) {
    return getWorkspaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetWorkspaceRequest request =
   *       GetWorkspaceRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Workspace> future = dataformClient.getWorkspaceCallable().futureCall(request);
   *   // Do something.
   *   Workspace response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWorkspaceRequest, Workspace> getWorkspaceCallable() {
    return stub.getWorkspaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Workspace in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   Workspace workspace = Workspace.newBuilder().build();
   *   String workspaceId = "workspaceId466560144";
   *   Workspace response = dataformClient.createWorkspace(parent, workspace, workspaceId);
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to create the workspace. Must be in the format
   *     `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @param workspace Required. The workspace to create.
   * @param workspaceId Required. The ID to use for the workspace, which will become the final
   *     component of the workspace's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workspace createWorkspace(
      RepositoryName parent, Workspace workspace, String workspaceId) {
    CreateWorkspaceRequest request =
        CreateWorkspaceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWorkspace(workspace)
            .setWorkspaceId(workspaceId)
            .build();
    return createWorkspace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Workspace in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   Workspace workspace = Workspace.newBuilder().build();
   *   String workspaceId = "workspaceId466560144";
   *   Workspace response = dataformClient.createWorkspace(parent, workspace, workspaceId);
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to create the workspace. Must be in the format
   *     `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @param workspace Required. The workspace to create.
   * @param workspaceId Required. The ID to use for the workspace, which will become the final
   *     component of the workspace's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workspace createWorkspace(String parent, Workspace workspace, String workspaceId) {
    CreateWorkspaceRequest request =
        CreateWorkspaceRequest.newBuilder()
            .setParent(parent)
            .setWorkspace(workspace)
            .setWorkspaceId(workspaceId)
            .build();
    return createWorkspace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Workspace in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CreateWorkspaceRequest request =
   *       CreateWorkspaceRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setWorkspace(Workspace.newBuilder().build())
   *           .setWorkspaceId("workspaceId466560144")
   *           .build();
   *   Workspace response = dataformClient.createWorkspace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workspace createWorkspace(CreateWorkspaceRequest request) {
    return createWorkspaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Workspace in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CreateWorkspaceRequest request =
   *       CreateWorkspaceRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setWorkspace(Workspace.newBuilder().build())
   *           .setWorkspaceId("workspaceId466560144")
   *           .build();
   *   ApiFuture<Workspace> future = dataformClient.createWorkspaceCallable().futureCall(request);
   *   // Do something.
   *   Workspace response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWorkspaceRequest, Workspace> createWorkspaceCallable() {
    return stub.createWorkspaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   WorkspaceName name =
   *       WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]");
   *   dataformClient.deleteWorkspace(name);
   * }
   * }</pre>
   *
   * @param name Required. The workspace resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWorkspace(WorkspaceName name) {
    DeleteWorkspaceRequest request =
        DeleteWorkspaceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteWorkspace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String name =
   *       WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]").toString();
   *   dataformClient.deleteWorkspace(name);
   * }
   * }</pre>
   *
   * @param name Required. The workspace resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWorkspace(String name) {
    DeleteWorkspaceRequest request = DeleteWorkspaceRequest.newBuilder().setName(name).build();
    deleteWorkspace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   DeleteWorkspaceRequest request =
   *       DeleteWorkspaceRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .build();
   *   dataformClient.deleteWorkspace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWorkspace(DeleteWorkspaceRequest request) {
    deleteWorkspaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   DeleteWorkspaceRequest request =
   *       DeleteWorkspaceRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = dataformClient.deleteWorkspaceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWorkspaceRequest, Empty> deleteWorkspaceCallable() {
    return stub.deleteWorkspaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Installs dependency NPM packages (inside a Workspace).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   InstallNpmPackagesRequest request =
   *       InstallNpmPackagesRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .build();
   *   InstallNpmPackagesResponse response = dataformClient.installNpmPackages(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstallNpmPackagesResponse installNpmPackages(InstallNpmPackagesRequest request) {
    return installNpmPackagesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Installs dependency NPM packages (inside a Workspace).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   InstallNpmPackagesRequest request =
   *       InstallNpmPackagesRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<InstallNpmPackagesResponse> future =
   *       dataformClient.installNpmPackagesCallable().futureCall(request);
   *   // Do something.
   *   InstallNpmPackagesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InstallNpmPackagesRequest, InstallNpmPackagesResponse>
      installNpmPackagesCallable() {
    return stub.installNpmPackagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pulls Git commits from the Repository's remote into a Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   PullGitCommitsRequest request =
   *       PullGitCommitsRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setRemoteBranch("remoteBranch-533119608")
   *           .setAuthor(CommitAuthor.newBuilder().build())
   *           .build();
   *   dataformClient.pullGitCommits(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void pullGitCommits(PullGitCommitsRequest request) {
    pullGitCommitsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pulls Git commits from the Repository's remote into a Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   PullGitCommitsRequest request =
   *       PullGitCommitsRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setRemoteBranch("remoteBranch-533119608")
   *           .setAuthor(CommitAuthor.newBuilder().build())
   *           .build();
   *   ApiFuture<Empty> future = dataformClient.pullGitCommitsCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PullGitCommitsRequest, Empty> pullGitCommitsCallable() {
    return stub.pullGitCommitsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pushes Git commits from a Workspace to the Repository's remote.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   PushGitCommitsRequest request =
   *       PushGitCommitsRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setRemoteBranch("remoteBranch-533119608")
   *           .build();
   *   dataformClient.pushGitCommits(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void pushGitCommits(PushGitCommitsRequest request) {
    pushGitCommitsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pushes Git commits from a Workspace to the Repository's remote.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   PushGitCommitsRequest request =
   *       PushGitCommitsRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setRemoteBranch("remoteBranch-533119608")
   *           .build();
   *   ApiFuture<Empty> future = dataformClient.pushGitCommitsCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PushGitCommitsRequest, Empty> pushGitCommitsCallable() {
    return stub.pushGitCommitsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches Git statuses for the files in a Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   FetchFileGitStatusesRequest request =
   *       FetchFileGitStatusesRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .build();
   *   FetchFileGitStatusesResponse response = dataformClient.fetchFileGitStatuses(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchFileGitStatusesResponse fetchFileGitStatuses(
      FetchFileGitStatusesRequest request) {
    return fetchFileGitStatusesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches Git statuses for the files in a Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   FetchFileGitStatusesRequest request =
   *       FetchFileGitStatusesRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FetchFileGitStatusesResponse> future =
   *       dataformClient.fetchFileGitStatusesCallable().futureCall(request);
   *   // Do something.
   *   FetchFileGitStatusesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchFileGitStatusesRequest, FetchFileGitStatusesResponse>
      fetchFileGitStatusesCallable() {
    return stub.fetchFileGitStatusesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches Git ahead/behind against a remote branch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   FetchGitAheadBehindRequest request =
   *       FetchGitAheadBehindRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setRemoteBranch("remoteBranch-533119608")
   *           .build();
   *   FetchGitAheadBehindResponse response = dataformClient.fetchGitAheadBehind(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchGitAheadBehindResponse fetchGitAheadBehind(FetchGitAheadBehindRequest request) {
    return fetchGitAheadBehindCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches Git ahead/behind against a remote branch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   FetchGitAheadBehindRequest request =
   *       FetchGitAheadBehindRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setRemoteBranch("remoteBranch-533119608")
   *           .build();
   *   ApiFuture<FetchGitAheadBehindResponse> future =
   *       dataformClient.fetchGitAheadBehindCallable().futureCall(request);
   *   // Do something.
   *   FetchGitAheadBehindResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchGitAheadBehindRequest, FetchGitAheadBehindResponse>
      fetchGitAheadBehindCallable() {
    return stub.fetchGitAheadBehindCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies a Git commit for uncommitted files in a Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CommitWorkspaceChangesRequest request =
   *       CommitWorkspaceChangesRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setAuthor(CommitAuthor.newBuilder().build())
   *           .setCommitMessage("commitMessage2039804624")
   *           .addAllPaths(new ArrayList<String>())
   *           .build();
   *   dataformClient.commitWorkspaceChanges(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void commitWorkspaceChanges(CommitWorkspaceChangesRequest request) {
    commitWorkspaceChangesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies a Git commit for uncommitted files in a Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CommitWorkspaceChangesRequest request =
   *       CommitWorkspaceChangesRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setAuthor(CommitAuthor.newBuilder().build())
   *           .setCommitMessage("commitMessage2039804624")
   *           .addAllPaths(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Empty> future = dataformClient.commitWorkspaceChangesCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CommitWorkspaceChangesRequest, Empty>
      commitWorkspaceChangesCallable() {
    return stub.commitWorkspaceChangesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs a Git reset for uncommitted files in a Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ResetWorkspaceChangesRequest request =
   *       ResetWorkspaceChangesRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .addAllPaths(new ArrayList<String>())
   *           .setClean(true)
   *           .build();
   *   dataformClient.resetWorkspaceChanges(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void resetWorkspaceChanges(ResetWorkspaceChangesRequest request) {
    resetWorkspaceChangesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs a Git reset for uncommitted files in a Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ResetWorkspaceChangesRequest request =
   *       ResetWorkspaceChangesRequest.newBuilder()
   *           .setName(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .addAllPaths(new ArrayList<String>())
   *           .setClean(true)
   *           .build();
   *   ApiFuture<Empty> future = dataformClient.resetWorkspaceChangesCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResetWorkspaceChangesRequest, Empty> resetWorkspaceChangesCallable() {
    return stub.resetWorkspaceChangesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches Git diff for an uncommitted file in a Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   FetchFileDiffRequest request =
   *       FetchFileDiffRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .build();
   *   FetchFileDiffResponse response = dataformClient.fetchFileDiff(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchFileDiffResponse fetchFileDiff(FetchFileDiffRequest request) {
    return fetchFileDiffCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches Git diff for an uncommitted file in a Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   FetchFileDiffRequest request =
   *       FetchFileDiffRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .build();
   *   ApiFuture<FetchFileDiffResponse> future =
   *       dataformClient.fetchFileDiffCallable().futureCall(request);
   *   // Do something.
   *   FetchFileDiffResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchFileDiffRequest, FetchFileDiffResponse> fetchFileDiffCallable() {
    return stub.fetchFileDiffCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a given Workspace directory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   QueryDirectoryContentsRequest request =
   *       QueryDirectoryContentsRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DirectoryEntry element : dataformClient.queryDirectoryContents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryDirectoryContentsPagedResponse queryDirectoryContents(
      QueryDirectoryContentsRequest request) {
    return queryDirectoryContentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a given Workspace directory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   QueryDirectoryContentsRequest request =
   *       QueryDirectoryContentsRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DirectoryEntry> future =
   *       dataformClient.queryDirectoryContentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DirectoryEntry element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryDirectoryContentsRequest, QueryDirectoryContentsPagedResponse>
      queryDirectoryContentsPagedCallable() {
    return stub.queryDirectoryContentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a given Workspace directory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   QueryDirectoryContentsRequest request =
   *       QueryDirectoryContentsRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     QueryDirectoryContentsResponse response =
   *         dataformClient.queryDirectoryContentsCallable().call(request);
   *     for (DirectoryEntry element : response.getDirectoryEntriesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryDirectoryContentsRequest, QueryDirectoryContentsResponse>
      queryDirectoryContentsCallable() {
    return stub.queryDirectoryContentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a directory inside a Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   MakeDirectoryRequest request =
   *       MakeDirectoryRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .build();
   *   MakeDirectoryResponse response = dataformClient.makeDirectory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MakeDirectoryResponse makeDirectory(MakeDirectoryRequest request) {
    return makeDirectoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a directory inside a Workspace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   MakeDirectoryRequest request =
   *       MakeDirectoryRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .build();
   *   ApiFuture<MakeDirectoryResponse> future =
   *       dataformClient.makeDirectoryCallable().futureCall(request);
   *   // Do something.
   *   MakeDirectoryResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MakeDirectoryRequest, MakeDirectoryResponse> makeDirectoryCallable() {
    return stub.makeDirectoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a directory (inside a Workspace) and all of its contents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RemoveDirectoryRequest request =
   *       RemoveDirectoryRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .build();
   *   dataformClient.removeDirectory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void removeDirectory(RemoveDirectoryRequest request) {
    removeDirectoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a directory (inside a Workspace) and all of its contents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RemoveDirectoryRequest request =
   *       RemoveDirectoryRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .build();
   *   ApiFuture<Empty> future = dataformClient.removeDirectoryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveDirectoryRequest, Empty> removeDirectoryCallable() {
    return stub.removeDirectoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a directory (inside a Workspace), and all of its contents, to a new location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   MoveDirectoryRequest request =
   *       MoveDirectoryRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .setNewPath("newPath1845080549")
   *           .build();
   *   MoveDirectoryResponse response = dataformClient.moveDirectory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MoveDirectoryResponse moveDirectory(MoveDirectoryRequest request) {
    return moveDirectoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a directory (inside a Workspace), and all of its contents, to a new location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   MoveDirectoryRequest request =
   *       MoveDirectoryRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .setNewPath("newPath1845080549")
   *           .build();
   *   ApiFuture<MoveDirectoryResponse> future =
   *       dataformClient.moveDirectoryCallable().futureCall(request);
   *   // Do something.
   *   MoveDirectoryResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MoveDirectoryRequest, MoveDirectoryResponse> moveDirectoryCallable() {
    return stub.moveDirectoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a file (inside a Workspace).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ReadFileRequest request =
   *       ReadFileRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .build();
   *   ReadFileResponse response = dataformClient.readFile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadFileResponse readFile(ReadFileRequest request) {
    return readFileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a file (inside a Workspace).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ReadFileRequest request =
   *       ReadFileRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .build();
   *   ApiFuture<ReadFileResponse> future = dataformClient.readFileCallable().futureCall(request);
   *   // Do something.
   *   ReadFileResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReadFileRequest, ReadFileResponse> readFileCallable() {
    return stub.readFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a file (inside a Workspace).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RemoveFileRequest request =
   *       RemoveFileRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .build();
   *   dataformClient.removeFile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void removeFile(RemoveFileRequest request) {
    removeFileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a file (inside a Workspace).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RemoveFileRequest request =
   *       RemoveFileRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .build();
   *   ApiFuture<Empty> future = dataformClient.removeFileCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveFileRequest, Empty> removeFileCallable() {
    return stub.removeFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a file (inside a Workspace) to a new location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   MoveFileRequest request =
   *       MoveFileRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .setNewPath("newPath1845080549")
   *           .build();
   *   MoveFileResponse response = dataformClient.moveFile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MoveFileResponse moveFile(MoveFileRequest request) {
    return moveFileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a file (inside a Workspace) to a new location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   MoveFileRequest request =
   *       MoveFileRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .setNewPath("newPath1845080549")
   *           .build();
   *   ApiFuture<MoveFileResponse> future = dataformClient.moveFileCallable().futureCall(request);
   *   // Do something.
   *   MoveFileResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MoveFileRequest, MoveFileResponse> moveFileCallable() {
    return stub.moveFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes to a file (inside a Workspace).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   WriteFileRequest request =
   *       WriteFileRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .setContents(ByteString.EMPTY)
   *           .build();
   *   WriteFileResponse response = dataformClient.writeFile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteFileResponse writeFile(WriteFileRequest request) {
    return writeFileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes to a file (inside a Workspace).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   WriteFileRequest request =
   *       WriteFileRequest.newBuilder()
   *           .setWorkspace(
   *               WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
   *                   .toString())
   *           .setPath("path3433509")
   *           .setContents(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<WriteFileResponse> future = dataformClient.writeFileCallable().futureCall(request);
   *   // Do something.
   *   WriteFileResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<WriteFileRequest, WriteFileResponse> writeFileCallable() {
    return stub.writeFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReleaseConfigs in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (ReleaseConfig element : dataformClient.listReleaseConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to list release configs. Must be in the format
   *     `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReleaseConfigsPagedResponse listReleaseConfigs(RepositoryName parent) {
    ListReleaseConfigsRequest request =
        ListReleaseConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReleaseConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReleaseConfigs in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (ReleaseConfig element : dataformClient.listReleaseConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to list release configs. Must be in the format
   *     `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReleaseConfigsPagedResponse listReleaseConfigs(String parent) {
    ListReleaseConfigsRequest request =
        ListReleaseConfigsRequest.newBuilder().setParent(parent).build();
    return listReleaseConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReleaseConfigs in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListReleaseConfigsRequest request =
   *       ListReleaseConfigsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ReleaseConfig element : dataformClient.listReleaseConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReleaseConfigsPagedResponse listReleaseConfigs(
      ListReleaseConfigsRequest request) {
    return listReleaseConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReleaseConfigs in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListReleaseConfigsRequest request =
   *       ListReleaseConfigsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ReleaseConfig> future =
   *       dataformClient.listReleaseConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReleaseConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReleaseConfigsRequest, ListReleaseConfigsPagedResponse>
      listReleaseConfigsPagedCallable() {
    return stub.listReleaseConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReleaseConfigs in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListReleaseConfigsRequest request =
   *       ListReleaseConfigsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListReleaseConfigsResponse response =
   *         dataformClient.listReleaseConfigsCallable().call(request);
   *     for (ReleaseConfig element : response.getReleaseConfigsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReleaseConfigsRequest, ListReleaseConfigsResponse>
      listReleaseConfigsCallable() {
    return stub.listReleaseConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single ReleaseConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ReleaseConfigName name =
   *       ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]");
   *   ReleaseConfig response = dataformClient.getReleaseConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The release config's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReleaseConfig getReleaseConfig(ReleaseConfigName name) {
    GetReleaseConfigRequest request =
        GetReleaseConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getReleaseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single ReleaseConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String name =
   *       ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
   *           .toString();
   *   ReleaseConfig response = dataformClient.getReleaseConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The release config's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReleaseConfig getReleaseConfig(String name) {
    GetReleaseConfigRequest request = GetReleaseConfigRequest.newBuilder().setName(name).build();
    return getReleaseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single ReleaseConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetReleaseConfigRequest request =
   *       GetReleaseConfigRequest.newBuilder()
   *           .setName(
   *               ReleaseConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
   *                   .toString())
   *           .build();
   *   ReleaseConfig response = dataformClient.getReleaseConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReleaseConfig getReleaseConfig(GetReleaseConfigRequest request) {
    return getReleaseConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single ReleaseConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetReleaseConfigRequest request =
   *       GetReleaseConfigRequest.newBuilder()
   *           .setName(
   *               ReleaseConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ReleaseConfig> future =
   *       dataformClient.getReleaseConfigCallable().futureCall(request);
   *   // Do something.
   *   ReleaseConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReleaseConfigRequest, ReleaseConfig> getReleaseConfigCallable() {
    return stub.getReleaseConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ReleaseConfig in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   ReleaseConfig releaseConfig = ReleaseConfig.newBuilder().build();
   *   String releaseConfigId = "releaseConfigId1350457636";
   *   ReleaseConfig response =
   *       dataformClient.createReleaseConfig(parent, releaseConfig, releaseConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to create the release config. Must be in the
   *     format `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @param releaseConfig Required. The release config to create.
   * @param releaseConfigId Required. The ID to use for the release config, which will become the
   *     final component of the release config's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReleaseConfig createReleaseConfig(
      RepositoryName parent, ReleaseConfig releaseConfig, String releaseConfigId) {
    CreateReleaseConfigRequest request =
        CreateReleaseConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setReleaseConfig(releaseConfig)
            .setReleaseConfigId(releaseConfigId)
            .build();
    return createReleaseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ReleaseConfig in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   ReleaseConfig releaseConfig = ReleaseConfig.newBuilder().build();
   *   String releaseConfigId = "releaseConfigId1350457636";
   *   ReleaseConfig response =
   *       dataformClient.createReleaseConfig(parent, releaseConfig, releaseConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to create the release config. Must be in the
   *     format `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @param releaseConfig Required. The release config to create.
   * @param releaseConfigId Required. The ID to use for the release config, which will become the
   *     final component of the release config's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReleaseConfig createReleaseConfig(
      String parent, ReleaseConfig releaseConfig, String releaseConfigId) {
    CreateReleaseConfigRequest request =
        CreateReleaseConfigRequest.newBuilder()
            .setParent(parent)
            .setReleaseConfig(releaseConfig)
            .setReleaseConfigId(releaseConfigId)
            .build();
    return createReleaseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ReleaseConfig in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CreateReleaseConfigRequest request =
   *       CreateReleaseConfigRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setReleaseConfig(ReleaseConfig.newBuilder().build())
   *           .setReleaseConfigId("releaseConfigId1350457636")
   *           .build();
   *   ReleaseConfig response = dataformClient.createReleaseConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReleaseConfig createReleaseConfig(CreateReleaseConfigRequest request) {
    return createReleaseConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ReleaseConfig in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CreateReleaseConfigRequest request =
   *       CreateReleaseConfigRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setReleaseConfig(ReleaseConfig.newBuilder().build())
   *           .setReleaseConfigId("releaseConfigId1350457636")
   *           .build();
   *   ApiFuture<ReleaseConfig> future =
   *       dataformClient.createReleaseConfigCallable().futureCall(request);
   *   // Do something.
   *   ReleaseConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReleaseConfigRequest, ReleaseConfig>
      createReleaseConfigCallable() {
    return stub.createReleaseConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single ReleaseConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ReleaseConfig releaseConfig = ReleaseConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ReleaseConfig response = dataformClient.updateReleaseConfig(releaseConfig, updateMask);
   * }
   * }</pre>
   *
   * @param releaseConfig Required. The release config to update.
   * @param updateMask Optional. Specifies the fields to be updated in the release config. If left
   *     unset, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReleaseConfig updateReleaseConfig(
      ReleaseConfig releaseConfig, FieldMask updateMask) {
    UpdateReleaseConfigRequest request =
        UpdateReleaseConfigRequest.newBuilder()
            .setReleaseConfig(releaseConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateReleaseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single ReleaseConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   UpdateReleaseConfigRequest request =
   *       UpdateReleaseConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setReleaseConfig(ReleaseConfig.newBuilder().build())
   *           .build();
   *   ReleaseConfig response = dataformClient.updateReleaseConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReleaseConfig updateReleaseConfig(UpdateReleaseConfigRequest request) {
    return updateReleaseConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single ReleaseConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   UpdateReleaseConfigRequest request =
   *       UpdateReleaseConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setReleaseConfig(ReleaseConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<ReleaseConfig> future =
   *       dataformClient.updateReleaseConfigCallable().futureCall(request);
   *   // Do something.
   *   ReleaseConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateReleaseConfigRequest, ReleaseConfig>
      updateReleaseConfigCallable() {
    return stub.updateReleaseConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ReleaseConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ReleaseConfigName name =
   *       ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]");
   *   dataformClient.deleteReleaseConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The release config's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReleaseConfig(ReleaseConfigName name) {
    DeleteReleaseConfigRequest request =
        DeleteReleaseConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteReleaseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ReleaseConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String name =
   *       ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
   *           .toString();
   *   dataformClient.deleteReleaseConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The release config's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReleaseConfig(String name) {
    DeleteReleaseConfigRequest request =
        DeleteReleaseConfigRequest.newBuilder().setName(name).build();
    deleteReleaseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ReleaseConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   DeleteReleaseConfigRequest request =
   *       DeleteReleaseConfigRequest.newBuilder()
   *           .setName(
   *               ReleaseConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
   *                   .toString())
   *           .build();
   *   dataformClient.deleteReleaseConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReleaseConfig(DeleteReleaseConfigRequest request) {
    deleteReleaseConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ReleaseConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   DeleteReleaseConfigRequest request =
   *       DeleteReleaseConfigRequest.newBuilder()
   *           .setName(
   *               ReleaseConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = dataformClient.deleteReleaseConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteReleaseConfigRequest, Empty> deleteReleaseConfigCallable() {
    return stub.deleteReleaseConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CompilationResults in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (CompilationResult element : dataformClient.listCompilationResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to list compilation results. Must be in the
   *     format `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCompilationResultsPagedResponse listCompilationResults(RepositoryName parent) {
    ListCompilationResultsRequest request =
        ListCompilationResultsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCompilationResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CompilationResults in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (CompilationResult element : dataformClient.listCompilationResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to list compilation results. Must be in the
   *     format `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCompilationResultsPagedResponse listCompilationResults(String parent) {
    ListCompilationResultsRequest request =
        ListCompilationResultsRequest.newBuilder().setParent(parent).build();
    return listCompilationResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CompilationResults in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListCompilationResultsRequest request =
   *       ListCompilationResultsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (CompilationResult element :
   *       dataformClient.listCompilationResults(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCompilationResultsPagedResponse listCompilationResults(
      ListCompilationResultsRequest request) {
    return listCompilationResultsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CompilationResults in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListCompilationResultsRequest request =
   *       ListCompilationResultsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<CompilationResult> future =
   *       dataformClient.listCompilationResultsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CompilationResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCompilationResultsRequest, ListCompilationResultsPagedResponse>
      listCompilationResultsPagedCallable() {
    return stub.listCompilationResultsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CompilationResults in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListCompilationResultsRequest request =
   *       ListCompilationResultsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCompilationResultsResponse response =
   *         dataformClient.listCompilationResultsCallable().call(request);
   *     for (CompilationResult element : response.getCompilationResultsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCompilationResultsRequest, ListCompilationResultsResponse>
      listCompilationResultsCallable() {
    return stub.listCompilationResultsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single CompilationResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CompilationResultName name =
   *       CompilationResultName.of(
   *           "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]");
   *   CompilationResult response = dataformClient.getCompilationResult(name);
   * }
   * }</pre>
   *
   * @param name Required. The compilation result's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompilationResult getCompilationResult(CompilationResultName name) {
    GetCompilationResultRequest request =
        GetCompilationResultRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCompilationResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single CompilationResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String name =
   *       CompilationResultName.of(
   *               "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
   *           .toString();
   *   CompilationResult response = dataformClient.getCompilationResult(name);
   * }
   * }</pre>
   *
   * @param name Required. The compilation result's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompilationResult getCompilationResult(String name) {
    GetCompilationResultRequest request =
        GetCompilationResultRequest.newBuilder().setName(name).build();
    return getCompilationResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single CompilationResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetCompilationResultRequest request =
   *       GetCompilationResultRequest.newBuilder()
   *           .setName(
   *               CompilationResultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
   *                   .toString())
   *           .build();
   *   CompilationResult response = dataformClient.getCompilationResult(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompilationResult getCompilationResult(GetCompilationResultRequest request) {
    return getCompilationResultCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single CompilationResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetCompilationResultRequest request =
   *       GetCompilationResultRequest.newBuilder()
   *           .setName(
   *               CompilationResultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CompilationResult> future =
   *       dataformClient.getCompilationResultCallable().futureCall(request);
   *   // Do something.
   *   CompilationResult response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCompilationResultRequest, CompilationResult>
      getCompilationResultCallable() {
    return stub.getCompilationResultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CompilationResult in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   CompilationResult compilationResult = CompilationResult.newBuilder().build();
   *   CompilationResult response =
   *       dataformClient.createCompilationResult(parent, compilationResult);
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to create the compilation result. Must be in
   *     the format `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @param compilationResult Required. The compilation result to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompilationResult createCompilationResult(
      RepositoryName parent, CompilationResult compilationResult) {
    CreateCompilationResultRequest request =
        CreateCompilationResultRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCompilationResult(compilationResult)
            .build();
    return createCompilationResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CompilationResult in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   CompilationResult compilationResult = CompilationResult.newBuilder().build();
   *   CompilationResult response =
   *       dataformClient.createCompilationResult(parent, compilationResult);
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to create the compilation result. Must be in
   *     the format `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @param compilationResult Required. The compilation result to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompilationResult createCompilationResult(
      String parent, CompilationResult compilationResult) {
    CreateCompilationResultRequest request =
        CreateCompilationResultRequest.newBuilder()
            .setParent(parent)
            .setCompilationResult(compilationResult)
            .build();
    return createCompilationResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CompilationResult in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CreateCompilationResultRequest request =
   *       CreateCompilationResultRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setCompilationResult(CompilationResult.newBuilder().build())
   *           .build();
   *   CompilationResult response = dataformClient.createCompilationResult(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompilationResult createCompilationResult(CreateCompilationResultRequest request) {
    return createCompilationResultCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CompilationResult in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CreateCompilationResultRequest request =
   *       CreateCompilationResultRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setCompilationResult(CompilationResult.newBuilder().build())
   *           .build();
   *   ApiFuture<CompilationResult> future =
   *       dataformClient.createCompilationResultCallable().futureCall(request);
   *   // Do something.
   *   CompilationResult response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCompilationResultRequest, CompilationResult>
      createCompilationResultCallable() {
    return stub.createCompilationResultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns CompilationResultActions in a given CompilationResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   QueryCompilationResultActionsRequest request =
   *       QueryCompilationResultActionsRequest.newBuilder()
   *           .setName(
   *               CompilationResultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (CompilationResultAction element :
   *       dataformClient.queryCompilationResultActions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryCompilationResultActionsPagedResponse queryCompilationResultActions(
      QueryCompilationResultActionsRequest request) {
    return queryCompilationResultActionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns CompilationResultActions in a given CompilationResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   QueryCompilationResultActionsRequest request =
   *       QueryCompilationResultActionsRequest.newBuilder()
   *           .setName(
   *               CompilationResultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<CompilationResultAction> future =
   *       dataformClient.queryCompilationResultActionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CompilationResultAction element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          QueryCompilationResultActionsRequest, QueryCompilationResultActionsPagedResponse>
      queryCompilationResultActionsPagedCallable() {
    return stub.queryCompilationResultActionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns CompilationResultActions in a given CompilationResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   QueryCompilationResultActionsRequest request =
   *       QueryCompilationResultActionsRequest.newBuilder()
   *           .setName(
   *               CompilationResultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     QueryCompilationResultActionsResponse response =
   *         dataformClient.queryCompilationResultActionsCallable().call(request);
   *     for (CompilationResultAction element : response.getCompilationResultActionsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          QueryCompilationResultActionsRequest, QueryCompilationResultActionsResponse>
      queryCompilationResultActionsCallable() {
    return stub.queryCompilationResultActionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists WorkflowConfigs in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (WorkflowConfig element : dataformClient.listWorkflowConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to list workflow configs. Must be in the format
   *     `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkflowConfigsPagedResponse listWorkflowConfigs(RepositoryName parent) {
    ListWorkflowConfigsRequest request =
        ListWorkflowConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWorkflowConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists WorkflowConfigs in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (WorkflowConfig element : dataformClient.listWorkflowConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to list workflow configs. Must be in the format
   *     `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkflowConfigsPagedResponse listWorkflowConfigs(String parent) {
    ListWorkflowConfigsRequest request =
        ListWorkflowConfigsRequest.newBuilder().setParent(parent).build();
    return listWorkflowConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists WorkflowConfigs in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListWorkflowConfigsRequest request =
   *       ListWorkflowConfigsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (WorkflowConfig element : dataformClient.listWorkflowConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkflowConfigsPagedResponse listWorkflowConfigs(
      ListWorkflowConfigsRequest request) {
    return listWorkflowConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists WorkflowConfigs in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListWorkflowConfigsRequest request =
   *       ListWorkflowConfigsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<WorkflowConfig> future =
   *       dataformClient.listWorkflowConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (WorkflowConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWorkflowConfigsRequest, ListWorkflowConfigsPagedResponse>
      listWorkflowConfigsPagedCallable() {
    return stub.listWorkflowConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists WorkflowConfigs in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListWorkflowConfigsRequest request =
   *       ListWorkflowConfigsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListWorkflowConfigsResponse response =
   *         dataformClient.listWorkflowConfigsCallable().call(request);
   *     for (WorkflowConfig element : response.getWorkflowConfigsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse>
      listWorkflowConfigsCallable() {
    return stub.listWorkflowConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single WorkflowConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   WorkflowConfigName name =
   *       WorkflowConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]");
   *   WorkflowConfig response = dataformClient.getWorkflowConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The workflow config's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkflowConfig getWorkflowConfig(WorkflowConfigName name) {
    GetWorkflowConfigRequest request =
        GetWorkflowConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getWorkflowConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single WorkflowConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String name =
   *       WorkflowConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]")
   *           .toString();
   *   WorkflowConfig response = dataformClient.getWorkflowConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The workflow config's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkflowConfig getWorkflowConfig(String name) {
    GetWorkflowConfigRequest request = GetWorkflowConfigRequest.newBuilder().setName(name).build();
    return getWorkflowConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single WorkflowConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetWorkflowConfigRequest request =
   *       GetWorkflowConfigRequest.newBuilder()
   *           .setName(
   *               WorkflowConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]")
   *                   .toString())
   *           .build();
   *   WorkflowConfig response = dataformClient.getWorkflowConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkflowConfig getWorkflowConfig(GetWorkflowConfigRequest request) {
    return getWorkflowConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single WorkflowConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetWorkflowConfigRequest request =
   *       GetWorkflowConfigRequest.newBuilder()
   *           .setName(
   *               WorkflowConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<WorkflowConfig> future =
   *       dataformClient.getWorkflowConfigCallable().futureCall(request);
   *   // Do something.
   *   WorkflowConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWorkflowConfigRequest, WorkflowConfig> getWorkflowConfigCallable() {
    return stub.getWorkflowConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new WorkflowConfig in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   WorkflowConfig workflowConfig = WorkflowConfig.newBuilder().build();
   *   String workflowConfigId = "workflowConfigId-1331048228";
   *   WorkflowConfig response =
   *       dataformClient.createWorkflowConfig(parent, workflowConfig, workflowConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to create the workflow config. Must be in the
   *     format `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @param workflowConfig Required. The workflow config to create.
   * @param workflowConfigId Required. The ID to use for the workflow config, which will become the
   *     final component of the workflow config's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkflowConfig createWorkflowConfig(
      RepositoryName parent, WorkflowConfig workflowConfig, String workflowConfigId) {
    CreateWorkflowConfigRequest request =
        CreateWorkflowConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWorkflowConfig(workflowConfig)
            .setWorkflowConfigId(workflowConfigId)
            .build();
    return createWorkflowConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new WorkflowConfig in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   WorkflowConfig workflowConfig = WorkflowConfig.newBuilder().build();
   *   String workflowConfigId = "workflowConfigId-1331048228";
   *   WorkflowConfig response =
   *       dataformClient.createWorkflowConfig(parent, workflowConfig, workflowConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to create the workflow config. Must be in the
   *     format `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @param workflowConfig Required. The workflow config to create.
   * @param workflowConfigId Required. The ID to use for the workflow config, which will become the
   *     final component of the workflow config's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkflowConfig createWorkflowConfig(
      String parent, WorkflowConfig workflowConfig, String workflowConfigId) {
    CreateWorkflowConfigRequest request =
        CreateWorkflowConfigRequest.newBuilder()
            .setParent(parent)
            .setWorkflowConfig(workflowConfig)
            .setWorkflowConfigId(workflowConfigId)
            .build();
    return createWorkflowConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new WorkflowConfig in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CreateWorkflowConfigRequest request =
   *       CreateWorkflowConfigRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setWorkflowConfig(WorkflowConfig.newBuilder().build())
   *           .setWorkflowConfigId("workflowConfigId-1331048228")
   *           .build();
   *   WorkflowConfig response = dataformClient.createWorkflowConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkflowConfig createWorkflowConfig(CreateWorkflowConfigRequest request) {
    return createWorkflowConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new WorkflowConfig in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CreateWorkflowConfigRequest request =
   *       CreateWorkflowConfigRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setWorkflowConfig(WorkflowConfig.newBuilder().build())
   *           .setWorkflowConfigId("workflowConfigId-1331048228")
   *           .build();
   *   ApiFuture<WorkflowConfig> future =
   *       dataformClient.createWorkflowConfigCallable().futureCall(request);
   *   // Do something.
   *   WorkflowConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWorkflowConfigRequest, WorkflowConfig>
      createWorkflowConfigCallable() {
    return stub.createWorkflowConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single WorkflowConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   WorkflowConfig workflowConfig = WorkflowConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   WorkflowConfig response = dataformClient.updateWorkflowConfig(workflowConfig, updateMask);
   * }
   * }</pre>
   *
   * @param workflowConfig Required. The workflow config to update.
   * @param updateMask Optional. Specifies the fields to be updated in the workflow config. If left
   *     unset, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkflowConfig updateWorkflowConfig(
      WorkflowConfig workflowConfig, FieldMask updateMask) {
    UpdateWorkflowConfigRequest request =
        UpdateWorkflowConfigRequest.newBuilder()
            .setWorkflowConfig(workflowConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateWorkflowConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single WorkflowConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   UpdateWorkflowConfigRequest request =
   *       UpdateWorkflowConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setWorkflowConfig(WorkflowConfig.newBuilder().build())
   *           .build();
   *   WorkflowConfig response = dataformClient.updateWorkflowConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkflowConfig updateWorkflowConfig(UpdateWorkflowConfigRequest request) {
    return updateWorkflowConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single WorkflowConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   UpdateWorkflowConfigRequest request =
   *       UpdateWorkflowConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setWorkflowConfig(WorkflowConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<WorkflowConfig> future =
   *       dataformClient.updateWorkflowConfigCallable().futureCall(request);
   *   // Do something.
   *   WorkflowConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateWorkflowConfigRequest, WorkflowConfig>
      updateWorkflowConfigCallable() {
    return stub.updateWorkflowConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single WorkflowConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   WorkflowConfigName name =
   *       WorkflowConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]");
   *   dataformClient.deleteWorkflowConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The workflow config's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWorkflowConfig(WorkflowConfigName name) {
    DeleteWorkflowConfigRequest request =
        DeleteWorkflowConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteWorkflowConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single WorkflowConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String name =
   *       WorkflowConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]")
   *           .toString();
   *   dataformClient.deleteWorkflowConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The workflow config's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWorkflowConfig(String name) {
    DeleteWorkflowConfigRequest request =
        DeleteWorkflowConfigRequest.newBuilder().setName(name).build();
    deleteWorkflowConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single WorkflowConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   DeleteWorkflowConfigRequest request =
   *       DeleteWorkflowConfigRequest.newBuilder()
   *           .setName(
   *               WorkflowConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]")
   *                   .toString())
   *           .build();
   *   dataformClient.deleteWorkflowConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWorkflowConfig(DeleteWorkflowConfigRequest request) {
    deleteWorkflowConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single WorkflowConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   DeleteWorkflowConfigRequest request =
   *       DeleteWorkflowConfigRequest.newBuilder()
   *           .setName(
   *               WorkflowConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = dataformClient.deleteWorkflowConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWorkflowConfigRequest, Empty> deleteWorkflowConfigCallable() {
    return stub.deleteWorkflowConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists WorkflowInvocations in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (WorkflowInvocation element :
   *       dataformClient.listWorkflowInvocations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the WorkflowInvocation type. Must be in the
   *     format `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkflowInvocationsPagedResponse listWorkflowInvocations(RepositoryName parent) {
    ListWorkflowInvocationsRequest request =
        ListWorkflowInvocationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWorkflowInvocations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists WorkflowInvocations in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (WorkflowInvocation element :
   *       dataformClient.listWorkflowInvocations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the WorkflowInvocation type. Must be in the
   *     format `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkflowInvocationsPagedResponse listWorkflowInvocations(String parent) {
    ListWorkflowInvocationsRequest request =
        ListWorkflowInvocationsRequest.newBuilder().setParent(parent).build();
    return listWorkflowInvocations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists WorkflowInvocations in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListWorkflowInvocationsRequest request =
   *       ListWorkflowInvocationsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (WorkflowInvocation element :
   *       dataformClient.listWorkflowInvocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkflowInvocationsPagedResponse listWorkflowInvocations(
      ListWorkflowInvocationsRequest request) {
    return listWorkflowInvocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists WorkflowInvocations in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListWorkflowInvocationsRequest request =
   *       ListWorkflowInvocationsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<WorkflowInvocation> future =
   *       dataformClient.listWorkflowInvocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (WorkflowInvocation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWorkflowInvocationsRequest, ListWorkflowInvocationsPagedResponse>
      listWorkflowInvocationsPagedCallable() {
    return stub.listWorkflowInvocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists WorkflowInvocations in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListWorkflowInvocationsRequest request =
   *       ListWorkflowInvocationsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListWorkflowInvocationsResponse response =
   *         dataformClient.listWorkflowInvocationsCallable().call(request);
   *     for (WorkflowInvocation element : response.getWorkflowInvocationsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse>
      listWorkflowInvocationsCallable() {
    return stub.listWorkflowInvocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single WorkflowInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   WorkflowInvocationName name =
   *       WorkflowInvocationName.of(
   *           "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]");
   *   WorkflowInvocation response = dataformClient.getWorkflowInvocation(name);
   * }
   * }</pre>
   *
   * @param name Required. The workflow invocation resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkflowInvocation getWorkflowInvocation(WorkflowInvocationName name) {
    GetWorkflowInvocationRequest request =
        GetWorkflowInvocationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getWorkflowInvocation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single WorkflowInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String name =
   *       WorkflowInvocationName.of(
   *               "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
   *           .toString();
   *   WorkflowInvocation response = dataformClient.getWorkflowInvocation(name);
   * }
   * }</pre>
   *
   * @param name Required. The workflow invocation resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkflowInvocation getWorkflowInvocation(String name) {
    GetWorkflowInvocationRequest request =
        GetWorkflowInvocationRequest.newBuilder().setName(name).build();
    return getWorkflowInvocation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single WorkflowInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetWorkflowInvocationRequest request =
   *       GetWorkflowInvocationRequest.newBuilder()
   *           .setName(
   *               WorkflowInvocationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
   *                   .toString())
   *           .build();
   *   WorkflowInvocation response = dataformClient.getWorkflowInvocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkflowInvocation getWorkflowInvocation(GetWorkflowInvocationRequest request) {
    return getWorkflowInvocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a single WorkflowInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetWorkflowInvocationRequest request =
   *       GetWorkflowInvocationRequest.newBuilder()
   *           .setName(
   *               WorkflowInvocationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<WorkflowInvocation> future =
   *       dataformClient.getWorkflowInvocationCallable().futureCall(request);
   *   // Do something.
   *   WorkflowInvocation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWorkflowInvocationRequest, WorkflowInvocation>
      getWorkflowInvocationCallable() {
    return stub.getWorkflowInvocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new WorkflowInvocation in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   WorkflowInvocation workflowInvocation = WorkflowInvocation.newBuilder().build();
   *   WorkflowInvocation response =
   *       dataformClient.createWorkflowInvocation(parent, workflowInvocation);
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to create the workflow invocation. Must be in
   *     the format `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @param workflowInvocation Required. The workflow invocation resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkflowInvocation createWorkflowInvocation(
      RepositoryName parent, WorkflowInvocation workflowInvocation) {
    CreateWorkflowInvocationRequest request =
        CreateWorkflowInvocationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWorkflowInvocation(workflowInvocation)
            .build();
    return createWorkflowInvocation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new WorkflowInvocation in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   WorkflowInvocation workflowInvocation = WorkflowInvocation.newBuilder().build();
   *   WorkflowInvocation response =
   *       dataformClient.createWorkflowInvocation(parent, workflowInvocation);
   * }
   * }</pre>
   *
   * @param parent Required. The repository in which to create the workflow invocation. Must be in
   *     the format `projects/&#42;/locations/&#42;/repositories/&#42;`.
   * @param workflowInvocation Required. The workflow invocation resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkflowInvocation createWorkflowInvocation(
      String parent, WorkflowInvocation workflowInvocation) {
    CreateWorkflowInvocationRequest request =
        CreateWorkflowInvocationRequest.newBuilder()
            .setParent(parent)
            .setWorkflowInvocation(workflowInvocation)
            .build();
    return createWorkflowInvocation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new WorkflowInvocation in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CreateWorkflowInvocationRequest request =
   *       CreateWorkflowInvocationRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setWorkflowInvocation(WorkflowInvocation.newBuilder().build())
   *           .build();
   *   WorkflowInvocation response = dataformClient.createWorkflowInvocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkflowInvocation createWorkflowInvocation(
      CreateWorkflowInvocationRequest request) {
    return createWorkflowInvocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new WorkflowInvocation in a given Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CreateWorkflowInvocationRequest request =
   *       CreateWorkflowInvocationRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setWorkflowInvocation(WorkflowInvocation.newBuilder().build())
   *           .build();
   *   ApiFuture<WorkflowInvocation> future =
   *       dataformClient.createWorkflowInvocationCallable().futureCall(request);
   *   // Do something.
   *   WorkflowInvocation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWorkflowInvocationRequest, WorkflowInvocation>
      createWorkflowInvocationCallable() {
    return stub.createWorkflowInvocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single WorkflowInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   WorkflowInvocationName name =
   *       WorkflowInvocationName.of(
   *           "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]");
   *   dataformClient.deleteWorkflowInvocation(name);
   * }
   * }</pre>
   *
   * @param name Required. The workflow invocation resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWorkflowInvocation(WorkflowInvocationName name) {
    DeleteWorkflowInvocationRequest request =
        DeleteWorkflowInvocationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteWorkflowInvocation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single WorkflowInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   String name =
   *       WorkflowInvocationName.of(
   *               "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
   *           .toString();
   *   dataformClient.deleteWorkflowInvocation(name);
   * }
   * }</pre>
   *
   * @param name Required. The workflow invocation resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWorkflowInvocation(String name) {
    DeleteWorkflowInvocationRequest request =
        DeleteWorkflowInvocationRequest.newBuilder().setName(name).build();
    deleteWorkflowInvocation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single WorkflowInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   DeleteWorkflowInvocationRequest request =
   *       DeleteWorkflowInvocationRequest.newBuilder()
   *           .setName(
   *               WorkflowInvocationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
   *                   .toString())
   *           .build();
   *   dataformClient.deleteWorkflowInvocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWorkflowInvocation(DeleteWorkflowInvocationRequest request) {
    deleteWorkflowInvocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single WorkflowInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   DeleteWorkflowInvocationRequest request =
   *       DeleteWorkflowInvocationRequest.newBuilder()
   *           .setName(
   *               WorkflowInvocationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       dataformClient.deleteWorkflowInvocationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWorkflowInvocationRequest, Empty>
      deleteWorkflowInvocationCallable() {
    return stub.deleteWorkflowInvocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests cancellation of a running WorkflowInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CancelWorkflowInvocationRequest request =
   *       CancelWorkflowInvocationRequest.newBuilder()
   *           .setName(
   *               WorkflowInvocationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
   *                   .toString())
   *           .build();
   *   dataformClient.cancelWorkflowInvocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelWorkflowInvocation(CancelWorkflowInvocationRequest request) {
    cancelWorkflowInvocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests cancellation of a running WorkflowInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   CancelWorkflowInvocationRequest request =
   *       CancelWorkflowInvocationRequest.newBuilder()
   *           .setName(
   *               WorkflowInvocationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       dataformClient.cancelWorkflowInvocationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelWorkflowInvocationRequest, Empty>
      cancelWorkflowInvocationCallable() {
    return stub.cancelWorkflowInvocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns WorkflowInvocationActions in a given WorkflowInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   QueryWorkflowInvocationActionsRequest request =
   *       QueryWorkflowInvocationActionsRequest.newBuilder()
   *           .setName(
   *               WorkflowInvocationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (WorkflowInvocationAction element :
   *       dataformClient.queryWorkflowInvocationActions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryWorkflowInvocationActionsPagedResponse queryWorkflowInvocationActions(
      QueryWorkflowInvocationActionsRequest request) {
    return queryWorkflowInvocationActionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns WorkflowInvocationActions in a given WorkflowInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   QueryWorkflowInvocationActionsRequest request =
   *       QueryWorkflowInvocationActionsRequest.newBuilder()
   *           .setName(
   *               WorkflowInvocationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<WorkflowInvocationAction> future =
   *       dataformClient.queryWorkflowInvocationActionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (WorkflowInvocationAction element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsPagedResponse>
      queryWorkflowInvocationActionsPagedCallable() {
    return stub.queryWorkflowInvocationActionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns WorkflowInvocationActions in a given WorkflowInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   QueryWorkflowInvocationActionsRequest request =
   *       QueryWorkflowInvocationActionsRequest.newBuilder()
   *           .setName(
   *               WorkflowInvocationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     QueryWorkflowInvocationActionsResponse response =
   *         dataformClient.queryWorkflowInvocationActionsCallable().call(request);
   *     for (WorkflowInvocationAction element : response.getWorkflowInvocationActionsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          QueryWorkflowInvocationActionsRequest, QueryWorkflowInvocationActionsResponse>
      queryWorkflowInvocationActionsCallable() {
    return stub.queryWorkflowInvocationActionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : dataformClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = dataformClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = dataformClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = dataformClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = dataformClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = dataformClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = dataformClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = dataformClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = dataformClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = dataformClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataformClient dataformClient = DataformClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       dataformClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListRepositoriesPagedResponse
      extends AbstractPagedListResponse<
          ListRepositoriesRequest,
          ListRepositoriesResponse,
          Repository,
          ListRepositoriesPage,
          ListRepositoriesFixedSizeCollection> {

    public static ApiFuture<ListRepositoriesPagedResponse> createAsync(
        PageContext<ListRepositoriesRequest, ListRepositoriesResponse, Repository> context,
        ApiFuture<ListRepositoriesResponse> futureResponse) {
      ApiFuture<ListRepositoriesPage> futurePage =
          ListRepositoriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRepositoriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRepositoriesPagedResponse(ListRepositoriesPage page) {
      super(page, ListRepositoriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRepositoriesPage
      extends AbstractPage<
          ListRepositoriesRequest, ListRepositoriesResponse, Repository, ListRepositoriesPage> {

    private ListRepositoriesPage(
        PageContext<ListRepositoriesRequest, ListRepositoriesResponse, Repository> context,
        ListRepositoriesResponse response) {
      super(context, response);
    }

    private static ListRepositoriesPage createEmptyPage() {
      return new ListRepositoriesPage(null, null);
    }

    @Override
    protected ListRepositoriesPage createPage(
        PageContext<ListRepositoriesRequest, ListRepositoriesResponse, Repository> context,
        ListRepositoriesResponse response) {
      return new ListRepositoriesPage(context, response);
    }

    @Override
    public ApiFuture<ListRepositoriesPage> createPageAsync(
        PageContext<ListRepositoriesRequest, ListRepositoriesResponse, Repository> context,
        ApiFuture<ListRepositoriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRepositoriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRepositoriesRequest,
          ListRepositoriesResponse,
          Repository,
          ListRepositoriesPage,
          ListRepositoriesFixedSizeCollection> {

    private ListRepositoriesFixedSizeCollection(
        List<ListRepositoriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRepositoriesFixedSizeCollection createEmptyCollection() {
      return new ListRepositoriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRepositoriesFixedSizeCollection createCollection(
        List<ListRepositoriesPage> pages, int collectionSize) {
      return new ListRepositoriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class QueryRepositoryDirectoryContentsPagedResponse
      extends AbstractPagedListResponse<
          QueryRepositoryDirectoryContentsRequest,
          QueryRepositoryDirectoryContentsResponse,
          DirectoryEntry,
          QueryRepositoryDirectoryContentsPage,
          QueryRepositoryDirectoryContentsFixedSizeCollection> {

    public static ApiFuture<QueryRepositoryDirectoryContentsPagedResponse> createAsync(
        PageContext<
                QueryRepositoryDirectoryContentsRequest,
                QueryRepositoryDirectoryContentsResponse,
                DirectoryEntry>
            context,
        ApiFuture<QueryRepositoryDirectoryContentsResponse> futureResponse) {
      ApiFuture<QueryRepositoryDirectoryContentsPage> futurePage =
          QueryRepositoryDirectoryContentsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new QueryRepositoryDirectoryContentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private QueryRepositoryDirectoryContentsPagedResponse(
        QueryRepositoryDirectoryContentsPage page) {
      super(page, QueryRepositoryDirectoryContentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class QueryRepositoryDirectoryContentsPage
      extends AbstractPage<
          QueryRepositoryDirectoryContentsRequest,
          QueryRepositoryDirectoryContentsResponse,
          DirectoryEntry,
          QueryRepositoryDirectoryContentsPage> {

    private QueryRepositoryDirectoryContentsPage(
        PageContext<
                QueryRepositoryDirectoryContentsRequest,
                QueryRepositoryDirectoryContentsResponse,
                DirectoryEntry>
            context,
        QueryRepositoryDirectoryContentsResponse response) {
      super(context, response);
    }

    private static QueryRepositoryDirectoryContentsPage createEmptyPage() {
      return new QueryRepositoryDirectoryContentsPage(null, null);
    }

    @Override
    protected QueryRepositoryDirectoryContentsPage createPage(
        PageContext<
                QueryRepositoryDirectoryContentsRequest,
                QueryRepositoryDirectoryContentsResponse,
                DirectoryEntry>
            context,
        QueryRepositoryDirectoryContentsResponse response) {
      return new QueryRepositoryDirectoryContentsPage(context, response);
    }

    @Override
    public ApiFuture<QueryRepositoryDirectoryContentsPage> createPageAsync(
        PageContext<
                QueryRepositoryDirectoryContentsRequest,
                QueryRepositoryDirectoryContentsResponse,
                DirectoryEntry>
            context,
        ApiFuture<QueryRepositoryDirectoryContentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class QueryRepositoryDirectoryContentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          QueryRepositoryDirectoryContentsRequest,
          QueryRepositoryDirectoryContentsResponse,
          DirectoryEntry,
          QueryRepositoryDirectoryContentsPage,
          QueryRepositoryDirectoryContentsFixedSizeCollection> {

    private QueryRepositoryDirectoryContentsFixedSizeCollection(
        List<QueryRepositoryDirectoryContentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static QueryRepositoryDirectoryContentsFixedSizeCollection createEmptyCollection() {
      return new QueryRepositoryDirectoryContentsFixedSizeCollection(null, 0);
    }

    @Override
    protected QueryRepositoryDirectoryContentsFixedSizeCollection createCollection(
        List<QueryRepositoryDirectoryContentsPage> pages, int collectionSize) {
      return new QueryRepositoryDirectoryContentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchRepositoryHistoryPagedResponse
      extends AbstractPagedListResponse<
          FetchRepositoryHistoryRequest,
          FetchRepositoryHistoryResponse,
          CommitLogEntry,
          FetchRepositoryHistoryPage,
          FetchRepositoryHistoryFixedSizeCollection> {

    public static ApiFuture<FetchRepositoryHistoryPagedResponse> createAsync(
        PageContext<FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse, CommitLogEntry>
            context,
        ApiFuture<FetchRepositoryHistoryResponse> futureResponse) {
      ApiFuture<FetchRepositoryHistoryPage> futurePage =
          FetchRepositoryHistoryPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchRepositoryHistoryPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchRepositoryHistoryPagedResponse(FetchRepositoryHistoryPage page) {
      super(page, FetchRepositoryHistoryFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchRepositoryHistoryPage
      extends AbstractPage<
          FetchRepositoryHistoryRequest,
          FetchRepositoryHistoryResponse,
          CommitLogEntry,
          FetchRepositoryHistoryPage> {

    private FetchRepositoryHistoryPage(
        PageContext<FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse, CommitLogEntry>
            context,
        FetchRepositoryHistoryResponse response) {
      super(context, response);
    }

    private static FetchRepositoryHistoryPage createEmptyPage() {
      return new FetchRepositoryHistoryPage(null, null);
    }

    @Override
    protected FetchRepositoryHistoryPage createPage(
        PageContext<FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse, CommitLogEntry>
            context,
        FetchRepositoryHistoryResponse response) {
      return new FetchRepositoryHistoryPage(context, response);
    }

    @Override
    public ApiFuture<FetchRepositoryHistoryPage> createPageAsync(
        PageContext<FetchRepositoryHistoryRequest, FetchRepositoryHistoryResponse, CommitLogEntry>
            context,
        ApiFuture<FetchRepositoryHistoryResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchRepositoryHistoryFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchRepositoryHistoryRequest,
          FetchRepositoryHistoryResponse,
          CommitLogEntry,
          FetchRepositoryHistoryPage,
          FetchRepositoryHistoryFixedSizeCollection> {

    private FetchRepositoryHistoryFixedSizeCollection(
        List<FetchRepositoryHistoryPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchRepositoryHistoryFixedSizeCollection createEmptyCollection() {
      return new FetchRepositoryHistoryFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchRepositoryHistoryFixedSizeCollection createCollection(
        List<FetchRepositoryHistoryPage> pages, int collectionSize) {
      return new FetchRepositoryHistoryFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListWorkspacesPagedResponse
      extends AbstractPagedListResponse<
          ListWorkspacesRequest,
          ListWorkspacesResponse,
          Workspace,
          ListWorkspacesPage,
          ListWorkspacesFixedSizeCollection> {

    public static ApiFuture<ListWorkspacesPagedResponse> createAsync(
        PageContext<ListWorkspacesRequest, ListWorkspacesResponse, Workspace> context,
        ApiFuture<ListWorkspacesResponse> futureResponse) {
      ApiFuture<ListWorkspacesPage> futurePage =
          ListWorkspacesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWorkspacesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWorkspacesPagedResponse(ListWorkspacesPage page) {
      super(page, ListWorkspacesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWorkspacesPage
      extends AbstractPage<
          ListWorkspacesRequest, ListWorkspacesResponse, Workspace, ListWorkspacesPage> {

    private ListWorkspacesPage(
        PageContext<ListWorkspacesRequest, ListWorkspacesResponse, Workspace> context,
        ListWorkspacesResponse response) {
      super(context, response);
    }

    private static ListWorkspacesPage createEmptyPage() {
      return new ListWorkspacesPage(null, null);
    }

    @Override
    protected ListWorkspacesPage createPage(
        PageContext<ListWorkspacesRequest, ListWorkspacesResponse, Workspace> context,
        ListWorkspacesResponse response) {
      return new ListWorkspacesPage(context, response);
    }

    @Override
    public ApiFuture<ListWorkspacesPage> createPageAsync(
        PageContext<ListWorkspacesRequest, ListWorkspacesResponse, Workspace> context,
        ApiFuture<ListWorkspacesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWorkspacesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWorkspacesRequest,
          ListWorkspacesResponse,
          Workspace,
          ListWorkspacesPage,
          ListWorkspacesFixedSizeCollection> {

    private ListWorkspacesFixedSizeCollection(List<ListWorkspacesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWorkspacesFixedSizeCollection createEmptyCollection() {
      return new ListWorkspacesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWorkspacesFixedSizeCollection createCollection(
        List<ListWorkspacesPage> pages, int collectionSize) {
      return new ListWorkspacesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class QueryDirectoryContentsPagedResponse
      extends AbstractPagedListResponse<
          QueryDirectoryContentsRequest,
          QueryDirectoryContentsResponse,
          DirectoryEntry,
          QueryDirectoryContentsPage,
          QueryDirectoryContentsFixedSizeCollection> {

    public static ApiFuture<QueryDirectoryContentsPagedResponse> createAsync(
        PageContext<QueryDirectoryContentsRequest, QueryDirectoryContentsResponse, DirectoryEntry>
            context,
        ApiFuture<QueryDirectoryContentsResponse> futureResponse) {
      ApiFuture<QueryDirectoryContentsPage> futurePage =
          QueryDirectoryContentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new QueryDirectoryContentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private QueryDirectoryContentsPagedResponse(QueryDirectoryContentsPage page) {
      super(page, QueryDirectoryContentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class QueryDirectoryContentsPage
      extends AbstractPage<
          QueryDirectoryContentsRequest,
          QueryDirectoryContentsResponse,
          DirectoryEntry,
          QueryDirectoryContentsPage> {

    private QueryDirectoryContentsPage(
        PageContext<QueryDirectoryContentsRequest, QueryDirectoryContentsResponse, DirectoryEntry>
            context,
        QueryDirectoryContentsResponse response) {
      super(context, response);
    }

    private static QueryDirectoryContentsPage createEmptyPage() {
      return new QueryDirectoryContentsPage(null, null);
    }

    @Override
    protected QueryDirectoryContentsPage createPage(
        PageContext<QueryDirectoryContentsRequest, QueryDirectoryContentsResponse, DirectoryEntry>
            context,
        QueryDirectoryContentsResponse response) {
      return new QueryDirectoryContentsPage(context, response);
    }

    @Override
    public ApiFuture<QueryDirectoryContentsPage> createPageAsync(
        PageContext<QueryDirectoryContentsRequest, QueryDirectoryContentsResponse, DirectoryEntry>
            context,
        ApiFuture<QueryDirectoryContentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class QueryDirectoryContentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          QueryDirectoryContentsRequest,
          QueryDirectoryContentsResponse,
          DirectoryEntry,
          QueryDirectoryContentsPage,
          QueryDirectoryContentsFixedSizeCollection> {

    private QueryDirectoryContentsFixedSizeCollection(
        List<QueryDirectoryContentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static QueryDirectoryContentsFixedSizeCollection createEmptyCollection() {
      return new QueryDirectoryContentsFixedSizeCollection(null, 0);
    }

    @Override
    protected QueryDirectoryContentsFixedSizeCollection createCollection(
        List<QueryDirectoryContentsPage> pages, int collectionSize) {
      return new QueryDirectoryContentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReleaseConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListReleaseConfigsRequest,
          ListReleaseConfigsResponse,
          ReleaseConfig,
          ListReleaseConfigsPage,
          ListReleaseConfigsFixedSizeCollection> {

    public static ApiFuture<ListReleaseConfigsPagedResponse> createAsync(
        PageContext<ListReleaseConfigsRequest, ListReleaseConfigsResponse, ReleaseConfig> context,
        ApiFuture<ListReleaseConfigsResponse> futureResponse) {
      ApiFuture<ListReleaseConfigsPage> futurePage =
          ListReleaseConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReleaseConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReleaseConfigsPagedResponse(ListReleaseConfigsPage page) {
      super(page, ListReleaseConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReleaseConfigsPage
      extends AbstractPage<
          ListReleaseConfigsRequest,
          ListReleaseConfigsResponse,
          ReleaseConfig,
          ListReleaseConfigsPage> {

    private ListReleaseConfigsPage(
        PageContext<ListReleaseConfigsRequest, ListReleaseConfigsResponse, ReleaseConfig> context,
        ListReleaseConfigsResponse response) {
      super(context, response);
    }

    private static ListReleaseConfigsPage createEmptyPage() {
      return new ListReleaseConfigsPage(null, null);
    }

    @Override
    protected ListReleaseConfigsPage createPage(
        PageContext<ListReleaseConfigsRequest, ListReleaseConfigsResponse, ReleaseConfig> context,
        ListReleaseConfigsResponse response) {
      return new ListReleaseConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListReleaseConfigsPage> createPageAsync(
        PageContext<ListReleaseConfigsRequest, ListReleaseConfigsResponse, ReleaseConfig> context,
        ApiFuture<ListReleaseConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReleaseConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReleaseConfigsRequest,
          ListReleaseConfigsResponse,
          ReleaseConfig,
          ListReleaseConfigsPage,
          ListReleaseConfigsFixedSizeCollection> {

    private ListReleaseConfigsFixedSizeCollection(
        List<ListReleaseConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReleaseConfigsFixedSizeCollection createEmptyCollection() {
      return new ListReleaseConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReleaseConfigsFixedSizeCollection createCollection(
        List<ListReleaseConfigsPage> pages, int collectionSize) {
      return new ListReleaseConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCompilationResultsPagedResponse
      extends AbstractPagedListResponse<
          ListCompilationResultsRequest,
          ListCompilationResultsResponse,
          CompilationResult,
          ListCompilationResultsPage,
          ListCompilationResultsFixedSizeCollection> {

    public static ApiFuture<ListCompilationResultsPagedResponse> createAsync(
        PageContext<
                ListCompilationResultsRequest, ListCompilationResultsResponse, CompilationResult>
            context,
        ApiFuture<ListCompilationResultsResponse> futureResponse) {
      ApiFuture<ListCompilationResultsPage> futurePage =
          ListCompilationResultsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCompilationResultsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCompilationResultsPagedResponse(ListCompilationResultsPage page) {
      super(page, ListCompilationResultsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCompilationResultsPage
      extends AbstractPage<
          ListCompilationResultsRequest,
          ListCompilationResultsResponse,
          CompilationResult,
          ListCompilationResultsPage> {

    private ListCompilationResultsPage(
        PageContext<
                ListCompilationResultsRequest, ListCompilationResultsResponse, CompilationResult>
            context,
        ListCompilationResultsResponse response) {
      super(context, response);
    }

    private static ListCompilationResultsPage createEmptyPage() {
      return new ListCompilationResultsPage(null, null);
    }

    @Override
    protected ListCompilationResultsPage createPage(
        PageContext<
                ListCompilationResultsRequest, ListCompilationResultsResponse, CompilationResult>
            context,
        ListCompilationResultsResponse response) {
      return new ListCompilationResultsPage(context, response);
    }

    @Override
    public ApiFuture<ListCompilationResultsPage> createPageAsync(
        PageContext<
                ListCompilationResultsRequest, ListCompilationResultsResponse, CompilationResult>
            context,
        ApiFuture<ListCompilationResultsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCompilationResultsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCompilationResultsRequest,
          ListCompilationResultsResponse,
          CompilationResult,
          ListCompilationResultsPage,
          ListCompilationResultsFixedSizeCollection> {

    private ListCompilationResultsFixedSizeCollection(
        List<ListCompilationResultsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCompilationResultsFixedSizeCollection createEmptyCollection() {
      return new ListCompilationResultsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCompilationResultsFixedSizeCollection createCollection(
        List<ListCompilationResultsPage> pages, int collectionSize) {
      return new ListCompilationResultsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class QueryCompilationResultActionsPagedResponse
      extends AbstractPagedListResponse<
          QueryCompilationResultActionsRequest,
          QueryCompilationResultActionsResponse,
          CompilationResultAction,
          QueryCompilationResultActionsPage,
          QueryCompilationResultActionsFixedSizeCollection> {

    public static ApiFuture<QueryCompilationResultActionsPagedResponse> createAsync(
        PageContext<
                QueryCompilationResultActionsRequest,
                QueryCompilationResultActionsResponse,
                CompilationResultAction>
            context,
        ApiFuture<QueryCompilationResultActionsResponse> futureResponse) {
      ApiFuture<QueryCompilationResultActionsPage> futurePage =
          QueryCompilationResultActionsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new QueryCompilationResultActionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private QueryCompilationResultActionsPagedResponse(QueryCompilationResultActionsPage page) {
      super(page, QueryCompilationResultActionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class QueryCompilationResultActionsPage
      extends AbstractPage<
          QueryCompilationResultActionsRequest,
          QueryCompilationResultActionsResponse,
          CompilationResultAction,
          QueryCompilationResultActionsPage> {

    private QueryCompilationResultActionsPage(
        PageContext<
                QueryCompilationResultActionsRequest,
                QueryCompilationResultActionsResponse,
                CompilationResultAction>
            context,
        QueryCompilationResultActionsResponse response) {
      super(context, response);
    }

    private static QueryCompilationResultActionsPage createEmptyPage() {
      return new QueryCompilationResultActionsPage(null, null);
    }

    @Override
    protected QueryCompilationResultActionsPage createPage(
        PageContext<
                QueryCompilationResultActionsRequest,
                QueryCompilationResultActionsResponse,
                CompilationResultAction>
            context,
        QueryCompilationResultActionsResponse response) {
      return new QueryCompilationResultActionsPage(context, response);
    }

    @Override
    public ApiFuture<QueryCompilationResultActionsPage> createPageAsync(
        PageContext<
                QueryCompilationResultActionsRequest,
                QueryCompilationResultActionsResponse,
                CompilationResultAction>
            context,
        ApiFuture<QueryCompilationResultActionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class QueryCompilationResultActionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          QueryCompilationResultActionsRequest,
          QueryCompilationResultActionsResponse,
          CompilationResultAction,
          QueryCompilationResultActionsPage,
          QueryCompilationResultActionsFixedSizeCollection> {

    private QueryCompilationResultActionsFixedSizeCollection(
        List<QueryCompilationResultActionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static QueryCompilationResultActionsFixedSizeCollection createEmptyCollection() {
      return new QueryCompilationResultActionsFixedSizeCollection(null, 0);
    }

    @Override
    protected QueryCompilationResultActionsFixedSizeCollection createCollection(
        List<QueryCompilationResultActionsPage> pages, int collectionSize) {
      return new QueryCompilationResultActionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListWorkflowConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListWorkflowConfigsRequest,
          ListWorkflowConfigsResponse,
          WorkflowConfig,
          ListWorkflowConfigsPage,
          ListWorkflowConfigsFixedSizeCollection> {

    public static ApiFuture<ListWorkflowConfigsPagedResponse> createAsync(
        PageContext<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse, WorkflowConfig>
            context,
        ApiFuture<ListWorkflowConfigsResponse> futureResponse) {
      ApiFuture<ListWorkflowConfigsPage> futurePage =
          ListWorkflowConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWorkflowConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWorkflowConfigsPagedResponse(ListWorkflowConfigsPage page) {
      super(page, ListWorkflowConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWorkflowConfigsPage
      extends AbstractPage<
          ListWorkflowConfigsRequest,
          ListWorkflowConfigsResponse,
          WorkflowConfig,
          ListWorkflowConfigsPage> {

    private ListWorkflowConfigsPage(
        PageContext<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse, WorkflowConfig>
            context,
        ListWorkflowConfigsResponse response) {
      super(context, response);
    }

    private static ListWorkflowConfigsPage createEmptyPage() {
      return new ListWorkflowConfigsPage(null, null);
    }

    @Override
    protected ListWorkflowConfigsPage createPage(
        PageContext<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse, WorkflowConfig>
            context,
        ListWorkflowConfigsResponse response) {
      return new ListWorkflowConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListWorkflowConfigsPage> createPageAsync(
        PageContext<ListWorkflowConfigsRequest, ListWorkflowConfigsResponse, WorkflowConfig>
            context,
        ApiFuture<ListWorkflowConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWorkflowConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWorkflowConfigsRequest,
          ListWorkflowConfigsResponse,
          WorkflowConfig,
          ListWorkflowConfigsPage,
          ListWorkflowConfigsFixedSizeCollection> {

    private ListWorkflowConfigsFixedSizeCollection(
        List<ListWorkflowConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWorkflowConfigsFixedSizeCollection createEmptyCollection() {
      return new ListWorkflowConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWorkflowConfigsFixedSizeCollection createCollection(
        List<ListWorkflowConfigsPage> pages, int collectionSize) {
      return new ListWorkflowConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListWorkflowInvocationsPagedResponse
      extends AbstractPagedListResponse<
          ListWorkflowInvocationsRequest,
          ListWorkflowInvocationsResponse,
          WorkflowInvocation,
          ListWorkflowInvocationsPage,
          ListWorkflowInvocationsFixedSizeCollection> {

    public static ApiFuture<ListWorkflowInvocationsPagedResponse> createAsync(
        PageContext<
                ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse, WorkflowInvocation>
            context,
        ApiFuture<ListWorkflowInvocationsResponse> futureResponse) {
      ApiFuture<ListWorkflowInvocationsPage> futurePage =
          ListWorkflowInvocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWorkflowInvocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWorkflowInvocationsPagedResponse(ListWorkflowInvocationsPage page) {
      super(page, ListWorkflowInvocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWorkflowInvocationsPage
      extends AbstractPage<
          ListWorkflowInvocationsRequest,
          ListWorkflowInvocationsResponse,
          WorkflowInvocation,
          ListWorkflowInvocationsPage> {

    private ListWorkflowInvocationsPage(
        PageContext<
                ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse, WorkflowInvocation>
            context,
        ListWorkflowInvocationsResponse response) {
      super(context, response);
    }

    private static ListWorkflowInvocationsPage createEmptyPage() {
      return new ListWorkflowInvocationsPage(null, null);
    }

    @Override
    protected ListWorkflowInvocationsPage createPage(
        PageContext<
                ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse, WorkflowInvocation>
            context,
        ListWorkflowInvocationsResponse response) {
      return new ListWorkflowInvocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListWorkflowInvocationsPage> createPageAsync(
        PageContext<
                ListWorkflowInvocationsRequest, ListWorkflowInvocationsResponse, WorkflowInvocation>
            context,
        ApiFuture<ListWorkflowInvocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWorkflowInvocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWorkflowInvocationsRequest,
          ListWorkflowInvocationsResponse,
          WorkflowInvocation,
          ListWorkflowInvocationsPage,
          ListWorkflowInvocationsFixedSizeCollection> {

    private ListWorkflowInvocationsFixedSizeCollection(
        List<ListWorkflowInvocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWorkflowInvocationsFixedSizeCollection createEmptyCollection() {
      return new ListWorkflowInvocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWorkflowInvocationsFixedSizeCollection createCollection(
        List<ListWorkflowInvocationsPage> pages, int collectionSize) {
      return new ListWorkflowInvocationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class QueryWorkflowInvocationActionsPagedResponse
      extends AbstractPagedListResponse<
          QueryWorkflowInvocationActionsRequest,
          QueryWorkflowInvocationActionsResponse,
          WorkflowInvocationAction,
          QueryWorkflowInvocationActionsPage,
          QueryWorkflowInvocationActionsFixedSizeCollection> {

    public static ApiFuture<QueryWorkflowInvocationActionsPagedResponse> createAsync(
        PageContext<
                QueryWorkflowInvocationActionsRequest,
                QueryWorkflowInvocationActionsResponse,
                WorkflowInvocationAction>
            context,
        ApiFuture<QueryWorkflowInvocationActionsResponse> futureResponse) {
      ApiFuture<QueryWorkflowInvocationActionsPage> futurePage =
          QueryWorkflowInvocationActionsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new QueryWorkflowInvocationActionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private QueryWorkflowInvocationActionsPagedResponse(QueryWorkflowInvocationActionsPage page) {
      super(page, QueryWorkflowInvocationActionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class QueryWorkflowInvocationActionsPage
      extends AbstractPage<
          QueryWorkflowInvocationActionsRequest,
          QueryWorkflowInvocationActionsResponse,
          WorkflowInvocationAction,
          QueryWorkflowInvocationActionsPage> {

    private QueryWorkflowInvocationActionsPage(
        PageContext<
                QueryWorkflowInvocationActionsRequest,
                QueryWorkflowInvocationActionsResponse,
                WorkflowInvocationAction>
            context,
        QueryWorkflowInvocationActionsResponse response) {
      super(context, response);
    }

    private static QueryWorkflowInvocationActionsPage createEmptyPage() {
      return new QueryWorkflowInvocationActionsPage(null, null);
    }

    @Override
    protected QueryWorkflowInvocationActionsPage createPage(
        PageContext<
                QueryWorkflowInvocationActionsRequest,
                QueryWorkflowInvocationActionsResponse,
                WorkflowInvocationAction>
            context,
        QueryWorkflowInvocationActionsResponse response) {
      return new QueryWorkflowInvocationActionsPage(context, response);
    }

    @Override
    public ApiFuture<QueryWorkflowInvocationActionsPage> createPageAsync(
        PageContext<
                QueryWorkflowInvocationActionsRequest,
                QueryWorkflowInvocationActionsResponse,
                WorkflowInvocationAction>
            context,
        ApiFuture<QueryWorkflowInvocationActionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class QueryWorkflowInvocationActionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          QueryWorkflowInvocationActionsRequest,
          QueryWorkflowInvocationActionsResponse,
          WorkflowInvocationAction,
          QueryWorkflowInvocationActionsPage,
          QueryWorkflowInvocationActionsFixedSizeCollection> {

    private QueryWorkflowInvocationActionsFixedSizeCollection(
        List<QueryWorkflowInvocationActionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static QueryWorkflowInvocationActionsFixedSizeCollection createEmptyCollection() {
      return new QueryWorkflowInvocationActionsFixedSizeCollection(null, 0);
    }

    @Override
    protected QueryWorkflowInvocationActionsFixedSizeCollection createCollection(
        List<QueryWorkflowInvocationActionsPage> pages, int collectionSize) {
      return new QueryWorkflowInvocationActionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
