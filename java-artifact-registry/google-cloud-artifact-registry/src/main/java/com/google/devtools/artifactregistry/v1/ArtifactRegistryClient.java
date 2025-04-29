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

package com.google.devtools.artifactregistry.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.devtools.artifactregistry.v1.stub.ArtifactRegistryStub;
import com.google.devtools.artifactregistry.v1.stub.ArtifactRegistryStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Artifact Registry API service.
 *
 * <p>Artifact Registry is an artifact management system for storing artifacts from different
 * package management systems.
 *
 * <p>The resources managed by this API are:
 *
 * <ul>
 *   <li>Repositories, which group packages and their data.
 *   <li>Packages, which group versions and their tags.
 *   <li>Versions, which are specific forms of a package.
 *   <li>Tags, which represent alternative names for versions.
 *   <li>Files, which contain content and are optionally associated with a Package or Version.
 * </ul>
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
 * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
 *   DockerImageName name =
 *       DockerImageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[DOCKER_IMAGE]");
 *   DockerImage response = artifactRegistryClient.getDockerImage(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ArtifactRegistryClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListDockerImages</td>
 *      <td><p> Lists docker images.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDockerImages(ListDockerImagesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDockerImages(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDockerImagesPagedCallable()
 *           <li><p> listDockerImagesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDockerImage</td>
 *      <td><p> Gets a docker image.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDockerImage(GetDockerImageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDockerImage(DockerImageName name)
 *           <li><p> getDockerImage(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDockerImageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMavenArtifacts</td>
 *      <td><p> Lists maven artifacts.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMavenArtifacts(ListMavenArtifactsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMavenArtifacts(RepositoryName parent)
 *           <li><p> listMavenArtifacts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMavenArtifactsPagedCallable()
 *           <li><p> listMavenArtifactsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMavenArtifact</td>
 *      <td><p> Gets a maven artifact.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMavenArtifact(GetMavenArtifactRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMavenArtifact(MavenArtifactName name)
 *           <li><p> getMavenArtifact(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMavenArtifactCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNpmPackages</td>
 *      <td><p> Lists npm packages.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNpmPackages(ListNpmPackagesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNpmPackages(RepositoryName parent)
 *           <li><p> listNpmPackages(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNpmPackagesPagedCallable()
 *           <li><p> listNpmPackagesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNpmPackage</td>
 *      <td><p> Gets a npm package.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNpmPackage(GetNpmPackageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNpmPackage(NpmPackageName name)
 *           <li><p> getNpmPackage(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNpmPackageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPythonPackages</td>
 *      <td><p> Lists python packages.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPythonPackages(ListPythonPackagesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPythonPackages(RepositoryName parent)
 *           <li><p> listPythonPackages(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPythonPackagesPagedCallable()
 *           <li><p> listPythonPackagesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPythonPackage</td>
 *      <td><p> Gets a python package.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPythonPackage(GetPythonPackageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPythonPackage(PythonPackageName name)
 *           <li><p> getPythonPackage(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPythonPackageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportAptArtifacts</td>
 *      <td><p> Imports Apt artifacts. The returned Operation will complete once the resources are imported. Package, Version, and File resources are created based on the imported artifacts. Imported artifacts that conflict with existing resources are ignored.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importAptArtifactsAsync(ImportAptArtifactsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importAptArtifactsOperationCallable()
 *           <li><p> importAptArtifactsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportYumArtifacts</td>
 *      <td><p> Imports Yum (RPM) artifacts. The returned Operation will complete once the resources are imported. Package, Version, and File resources are created based on the imported artifacts. Imported artifacts that conflict with existing resources are ignored.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importYumArtifactsAsync(ImportYumArtifactsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importYumArtifactsOperationCallable()
 *           <li><p> importYumArtifactsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRepositories</td>
 *      <td><p> Lists repositories.</td>
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
 *      <td><p> Gets a repository.</td>
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
 *      <td><p> Creates a repository. The returned Operation will finish once the repository has been created. Its response will be the created Repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRepositoryAsync(CreateRepositoryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createRepositoryAsync(LocationName parent, Repository repository, String repositoryId)
 *           <li><p> createRepositoryAsync(String parent, Repository repository, String repositoryId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRepositoryOperationCallable()
 *           <li><p> createRepositoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRepository</td>
 *      <td><p> Updates a repository.</td>
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
 *      <td><p> Deletes a repository and all of its contents. The returned Operation will finish once the repository has been deleted. It will not have any Operation metadata and will return a google.protobuf.Empty response.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRepositoryAsync(DeleteRepositoryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteRepositoryAsync(RepositoryName name)
 *           <li><p> deleteRepositoryAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRepositoryOperationCallable()
 *           <li><p> deleteRepositoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPackages</td>
 *      <td><p> Lists packages.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPackages(ListPackagesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPackages(RepositoryName parent)
 *           <li><p> listPackages(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPackagesPagedCallable()
 *           <li><p> listPackagesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPackage</td>
 *      <td><p> Gets a package.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPackage(GetPackageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPackage(PackageName name)
 *           <li><p> getPackage(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPackageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePackage</td>
 *      <td><p> Deletes a package and all of its versions and tags. The returned operation will complete once the package has been deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePackageAsync(DeletePackageRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deletePackageAsync(PackageName name)
 *           <li><p> deletePackageAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePackageOperationCallable()
 *           <li><p> deletePackageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListVersions</td>
 *      <td><p> Lists versions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listVersions(ListVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listVersionsPagedCallable()
 *           <li><p> listVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVersion</td>
 *      <td><p> Gets a version</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVersion(GetVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteVersion</td>
 *      <td><p> Deletes a version and all of its content. The returned operation will complete once the version has been deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteVersionAsync(DeleteVersionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteVersionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteVersionOperationCallable()
 *           <li><p> deleteVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeleteVersions</td>
 *      <td><p> Deletes multiple versions across a repository. The returned operation will complete once the versions have been deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeleteVersionsAsync(BatchDeleteVersionsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> batchDeleteVersionsAsync(PackageName parent, List&lt;String&gt; names)
 *           <li><p> batchDeleteVersionsAsync(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeleteVersionsOperationCallable()
 *           <li><p> batchDeleteVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateVersion</td>
 *      <td><p> Updates a version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateVersion(UpdateVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateVersion(Version version, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFiles</td>
 *      <td><p> Lists files.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFiles(ListFilesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFiles(RepositoryName parent)
 *           <li><p> listFiles(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFilesPagedCallable()
 *           <li><p> listFilesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFile</td>
 *      <td><p> Gets a file.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFile(GetFileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFile(FileName name)
 *           <li><p> getFile(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteFile</td>
 *      <td><p> Deletes a file and all of its content. It is only allowed on generic repositories. The returned operation will complete once the file has been deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteFileAsync(DeleteFileRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteFileAsync(FileName name)
 *           <li><p> deleteFileAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteFileOperationCallable()
 *           <li><p> deleteFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateFile</td>
 *      <td><p> Updates a file.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFile(UpdateFileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateFile(File file, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTags</td>
 *      <td><p> Lists tags.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTags(ListTagsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTags(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTagsPagedCallable()
 *           <li><p> listTagsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTag</td>
 *      <td><p> Gets a tag.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTag(GetTagRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTag(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTagCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTag</td>
 *      <td><p> Creates a tag.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTag(CreateTagRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTag(String parent, Tag tag, String tagId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTagCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTag</td>
 *      <td><p> Updates a tag.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTag(UpdateTagRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTag(Tag tag, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTagCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTag</td>
 *      <td><p> Deletes a tag.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTag(DeleteTagRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteTag(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTagCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRule</td>
 *      <td><p> Creates a rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRule(CreateRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createRule(RepositoryName parent, Rule rule, String ruleId)
 *           <li><p> createRule(String parent, Rule rule, String ruleId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRules</td>
 *      <td><p> Lists rules.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRules(ListRulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRules(RepositoryName parent)
 *           <li><p> listRules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRulesPagedCallable()
 *           <li><p> listRulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRule</td>
 *      <td><p> Gets a rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRule(GetRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRule(RuleName name)
 *           <li><p> getRule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRule</td>
 *      <td><p> Updates a rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRule(UpdateRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateRule(Rule rule, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRule</td>
 *      <td><p> Deletes a rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRule(DeleteRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteRule(RuleName name)
 *           <li><p> deleteRule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Updates the IAM policy for a given resource.</td>
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
 *      <td><p> Gets the IAM policy for a given resource.</td>
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
 *      <td><p> Tests if the caller has a list of permissions on a resource.</td>
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
 *    <tr>
 *      <td><p> GetProjectSettings</td>
 *      <td><p> Retrieves the Settings for the Project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProjectSettings(GetProjectSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProjectSettings(ProjectSettingsName name)
 *           <li><p> getProjectSettings(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProjectSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateProjectSettings</td>
 *      <td><p> Updates the Settings for the Project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateProjectSettings(UpdateProjectSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateProjectSettings(ProjectSettings projectSettings, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateProjectSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVPCSCConfig</td>
 *      <td><p> Retrieves the VPCSC Config for the Project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVPCSCConfig(GetVPCSCConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getVPCSCConfig(VpcscConfigName name)
 *           <li><p> getVPCSCConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVPCSCConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateVPCSCConfig</td>
 *      <td><p> Updates the VPCSC Config for the Project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateVPCSCConfig(UpdateVPCSCConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateVPCSCConfig(VPCSCConfig vpcscConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateVPCSCConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePackage</td>
 *      <td><p> Updates a package.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePackage(UpdatePackageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updatePackage(Package package_, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePackageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAttachments</td>
 *      <td><p> Lists attachments.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAttachments(ListAttachmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAttachments(RepositoryName parent)
 *           <li><p> listAttachments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAttachmentsPagedCallable()
 *           <li><p> listAttachmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAttachment</td>
 *      <td><p> Gets an attachment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAttachment(GetAttachmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAttachment(AttachmentName name)
 *           <li><p> getAttachment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAttachment</td>
 *      <td><p> Creates an attachment. The returned Operation will finish once the attachment has been created. Its response will be the created attachment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAttachmentAsync(CreateAttachmentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAttachmentAsync(RepositoryName parent, Attachment attachment, String attachmentId)
 *           <li><p> createAttachmentAsync(String parent, Attachment attachment, String attachmentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAttachmentOperationCallable()
 *           <li><p> createAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAttachment</td>
 *      <td><p> Deletes an attachment. The returned Operation will finish once the attachments has been deleted. It will not have any Operation metadata and will return a `google.protobuf.Empty` response.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAttachmentAsync(DeleteAttachmentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAttachmentAsync(AttachmentName name)
 *           <li><p> deleteAttachmentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAttachmentOperationCallable()
 *           <li><p> deleteAttachmentCallable()
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
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of ArtifactRegistrySettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ArtifactRegistrySettings artifactRegistrySettings =
 *     ArtifactRegistrySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ArtifactRegistryClient artifactRegistryClient =
 *     ArtifactRegistryClient.create(artifactRegistrySettings);
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
 * ArtifactRegistrySettings artifactRegistrySettings =
 *     ArtifactRegistrySettings.newBuilder().setEndpoint(myEndpoint).build();
 * ArtifactRegistryClient artifactRegistryClient =
 *     ArtifactRegistryClient.create(artifactRegistrySettings);
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
 * ArtifactRegistrySettings artifactRegistrySettings =
 *     ArtifactRegistrySettings.newHttpJsonBuilder().build();
 * ArtifactRegistryClient artifactRegistryClient =
 *     ArtifactRegistryClient.create(artifactRegistrySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ArtifactRegistryClient implements BackgroundResource {
  private final ArtifactRegistrySettings settings;
  private final ArtifactRegistryStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ArtifactRegistryClient with default settings. */
  public static final ArtifactRegistryClient create() throws IOException {
    return create(ArtifactRegistrySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ArtifactRegistryClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ArtifactRegistryClient create(ArtifactRegistrySettings settings)
      throws IOException {
    return new ArtifactRegistryClient(settings);
  }

  /**
   * Constructs an instance of ArtifactRegistryClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ArtifactRegistrySettings).
   */
  public static final ArtifactRegistryClient create(ArtifactRegistryStub stub) {
    return new ArtifactRegistryClient(stub);
  }

  /**
   * Constructs an instance of ArtifactRegistryClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ArtifactRegistryClient(ArtifactRegistrySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ArtifactRegistryStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ArtifactRegistryClient(ArtifactRegistryStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ArtifactRegistrySettings getSettings() {
    return settings;
  }

  public ArtifactRegistryStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists docker images.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = "parent-995424086";
   *   for (DockerImage element : artifactRegistryClient.listDockerImages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource whose docker images will be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDockerImagesPagedResponse listDockerImages(String parent) {
    ListDockerImagesRequest request =
        ListDockerImagesRequest.newBuilder().setParent(parent).build();
    return listDockerImages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists docker images.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListDockerImagesRequest request =
   *       ListDockerImagesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DockerImage element : artifactRegistryClient.listDockerImages(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDockerImagesPagedResponse listDockerImages(ListDockerImagesRequest request) {
    return listDockerImagesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists docker images.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListDockerImagesRequest request =
   *       ListDockerImagesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DockerImage> future =
   *       artifactRegistryClient.listDockerImagesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DockerImage element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDockerImagesRequest, ListDockerImagesPagedResponse>
      listDockerImagesPagedCallable() {
    return stub.listDockerImagesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists docker images.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListDockerImagesRequest request =
   *       ListDockerImagesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDockerImagesResponse response =
   *         artifactRegistryClient.listDockerImagesCallable().call(request);
   *     for (DockerImage element : response.getDockerImagesList()) {
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
  public final UnaryCallable<ListDockerImagesRequest, ListDockerImagesResponse>
      listDockerImagesCallable() {
    return stub.listDockerImagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a docker image.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DockerImageName name =
   *       DockerImageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[DOCKER_IMAGE]");
   *   DockerImage response = artifactRegistryClient.getDockerImage(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the docker images.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DockerImage getDockerImage(DockerImageName name) {
    GetDockerImageRequest request =
        GetDockerImageRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDockerImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a docker image.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name =
   *       DockerImageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[DOCKER_IMAGE]")
   *           .toString();
   *   DockerImage response = artifactRegistryClient.getDockerImage(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the docker images.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DockerImage getDockerImage(String name) {
    GetDockerImageRequest request = GetDockerImageRequest.newBuilder().setName(name).build();
    return getDockerImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a docker image.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetDockerImageRequest request =
   *       GetDockerImageRequest.newBuilder()
   *           .setName(
   *               DockerImageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[DOCKER_IMAGE]")
   *                   .toString())
   *           .build();
   *   DockerImage response = artifactRegistryClient.getDockerImage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DockerImage getDockerImage(GetDockerImageRequest request) {
    return getDockerImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a docker image.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetDockerImageRequest request =
   *       GetDockerImageRequest.newBuilder()
   *           .setName(
   *               DockerImageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[DOCKER_IMAGE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DockerImage> future =
   *       artifactRegistryClient.getDockerImageCallable().futureCall(request);
   *   // Do something.
   *   DockerImage response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDockerImageRequest, DockerImage> getDockerImageCallable() {
    return stub.getDockerImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists maven artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (MavenArtifact element : artifactRegistryClient.listMavenArtifacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource whose maven artifacts will be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMavenArtifactsPagedResponse listMavenArtifacts(RepositoryName parent) {
    ListMavenArtifactsRequest request =
        ListMavenArtifactsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMavenArtifacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists maven artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (MavenArtifact element : artifactRegistryClient.listMavenArtifacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource whose maven artifacts will be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMavenArtifactsPagedResponse listMavenArtifacts(String parent) {
    ListMavenArtifactsRequest request =
        ListMavenArtifactsRequest.newBuilder().setParent(parent).build();
    return listMavenArtifacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists maven artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListMavenArtifactsRequest request =
   *       ListMavenArtifactsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (MavenArtifact element :
   *       artifactRegistryClient.listMavenArtifacts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMavenArtifactsPagedResponse listMavenArtifacts(
      ListMavenArtifactsRequest request) {
    return listMavenArtifactsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists maven artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListMavenArtifactsRequest request =
   *       ListMavenArtifactsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<MavenArtifact> future =
   *       artifactRegistryClient.listMavenArtifactsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MavenArtifact element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMavenArtifactsRequest, ListMavenArtifactsPagedResponse>
      listMavenArtifactsPagedCallable() {
    return stub.listMavenArtifactsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists maven artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListMavenArtifactsRequest request =
   *       ListMavenArtifactsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMavenArtifactsResponse response =
   *         artifactRegistryClient.listMavenArtifactsCallable().call(request);
   *     for (MavenArtifact element : response.getMavenArtifactsList()) {
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
  public final UnaryCallable<ListMavenArtifactsRequest, ListMavenArtifactsResponse>
      listMavenArtifactsCallable() {
    return stub.listMavenArtifactsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a maven artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   MavenArtifactName name =
   *       MavenArtifactName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[MAVEN_ARTIFACT]");
   *   MavenArtifact response = artifactRegistryClient.getMavenArtifact(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the maven artifact.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MavenArtifact getMavenArtifact(MavenArtifactName name) {
    GetMavenArtifactRequest request =
        GetMavenArtifactRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMavenArtifact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a maven artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name =
   *       MavenArtifactName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[MAVEN_ARTIFACT]")
   *           .toString();
   *   MavenArtifact response = artifactRegistryClient.getMavenArtifact(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the maven artifact.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MavenArtifact getMavenArtifact(String name) {
    GetMavenArtifactRequest request = GetMavenArtifactRequest.newBuilder().setName(name).build();
    return getMavenArtifact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a maven artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetMavenArtifactRequest request =
   *       GetMavenArtifactRequest.newBuilder()
   *           .setName(
   *               MavenArtifactName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[MAVEN_ARTIFACT]")
   *                   .toString())
   *           .build();
   *   MavenArtifact response = artifactRegistryClient.getMavenArtifact(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MavenArtifact getMavenArtifact(GetMavenArtifactRequest request) {
    return getMavenArtifactCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a maven artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetMavenArtifactRequest request =
   *       GetMavenArtifactRequest.newBuilder()
   *           .setName(
   *               MavenArtifactName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[MAVEN_ARTIFACT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<MavenArtifact> future =
   *       artifactRegistryClient.getMavenArtifactCallable().futureCall(request);
   *   // Do something.
   *   MavenArtifact response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMavenArtifactRequest, MavenArtifact> getMavenArtifactCallable() {
    return stub.getMavenArtifactCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists npm packages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (NpmPackage element : artifactRegistryClient.listNpmPackages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource whose npm packages will be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNpmPackagesPagedResponse listNpmPackages(RepositoryName parent) {
    ListNpmPackagesRequest request =
        ListNpmPackagesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNpmPackages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists npm packages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (NpmPackage element : artifactRegistryClient.listNpmPackages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource whose npm packages will be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNpmPackagesPagedResponse listNpmPackages(String parent) {
    ListNpmPackagesRequest request = ListNpmPackagesRequest.newBuilder().setParent(parent).build();
    return listNpmPackages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists npm packages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListNpmPackagesRequest request =
   *       ListNpmPackagesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (NpmPackage element : artifactRegistryClient.listNpmPackages(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNpmPackagesPagedResponse listNpmPackages(ListNpmPackagesRequest request) {
    return listNpmPackagesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists npm packages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListNpmPackagesRequest request =
   *       ListNpmPackagesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<NpmPackage> future =
   *       artifactRegistryClient.listNpmPackagesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NpmPackage element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNpmPackagesRequest, ListNpmPackagesPagedResponse>
      listNpmPackagesPagedCallable() {
    return stub.listNpmPackagesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists npm packages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListNpmPackagesRequest request =
   *       ListNpmPackagesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListNpmPackagesResponse response =
   *         artifactRegistryClient.listNpmPackagesCallable().call(request);
   *     for (NpmPackage element : response.getNpmPackagesList()) {
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
  public final UnaryCallable<ListNpmPackagesRequest, ListNpmPackagesResponse>
      listNpmPackagesCallable() {
    return stub.listNpmPackagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a npm package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   NpmPackageName name =
   *       NpmPackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[NPM_PACKAGE]");
   *   NpmPackage response = artifactRegistryClient.getNpmPackage(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the npm package.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NpmPackage getNpmPackage(NpmPackageName name) {
    GetNpmPackageRequest request =
        GetNpmPackageRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNpmPackage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a npm package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name =
   *       NpmPackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[NPM_PACKAGE]").toString();
   *   NpmPackage response = artifactRegistryClient.getNpmPackage(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the npm package.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NpmPackage getNpmPackage(String name) {
    GetNpmPackageRequest request = GetNpmPackageRequest.newBuilder().setName(name).build();
    return getNpmPackage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a npm package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetNpmPackageRequest request =
   *       GetNpmPackageRequest.newBuilder()
   *           .setName(
   *               NpmPackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[NPM_PACKAGE]")
   *                   .toString())
   *           .build();
   *   NpmPackage response = artifactRegistryClient.getNpmPackage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NpmPackage getNpmPackage(GetNpmPackageRequest request) {
    return getNpmPackageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a npm package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetNpmPackageRequest request =
   *       GetNpmPackageRequest.newBuilder()
   *           .setName(
   *               NpmPackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[NPM_PACKAGE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<NpmPackage> future =
   *       artifactRegistryClient.getNpmPackageCallable().futureCall(request);
   *   // Do something.
   *   NpmPackage response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNpmPackageRequest, NpmPackage> getNpmPackageCallable() {
    return stub.getNpmPackageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists python packages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (PythonPackage element : artifactRegistryClient.listPythonPackages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource whose python packages will be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPythonPackagesPagedResponse listPythonPackages(RepositoryName parent) {
    ListPythonPackagesRequest request =
        ListPythonPackagesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPythonPackages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists python packages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (PythonPackage element : artifactRegistryClient.listPythonPackages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource whose python packages will be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPythonPackagesPagedResponse listPythonPackages(String parent) {
    ListPythonPackagesRequest request =
        ListPythonPackagesRequest.newBuilder().setParent(parent).build();
    return listPythonPackages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists python packages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListPythonPackagesRequest request =
   *       ListPythonPackagesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PythonPackage element :
   *       artifactRegistryClient.listPythonPackages(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPythonPackagesPagedResponse listPythonPackages(
      ListPythonPackagesRequest request) {
    return listPythonPackagesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists python packages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListPythonPackagesRequest request =
   *       ListPythonPackagesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PythonPackage> future =
   *       artifactRegistryClient.listPythonPackagesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PythonPackage element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPythonPackagesRequest, ListPythonPackagesPagedResponse>
      listPythonPackagesPagedCallable() {
    return stub.listPythonPackagesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists python packages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListPythonPackagesRequest request =
   *       ListPythonPackagesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPythonPackagesResponse response =
   *         artifactRegistryClient.listPythonPackagesCallable().call(request);
   *     for (PythonPackage element : response.getPythonPackagesList()) {
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
  public final UnaryCallable<ListPythonPackagesRequest, ListPythonPackagesResponse>
      listPythonPackagesCallable() {
    return stub.listPythonPackagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a python package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   PythonPackageName name =
   *       PythonPackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PYTHON_PACKAGE]");
   *   PythonPackage response = artifactRegistryClient.getPythonPackage(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the python package.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PythonPackage getPythonPackage(PythonPackageName name) {
    GetPythonPackageRequest request =
        GetPythonPackageRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPythonPackage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a python package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name =
   *       PythonPackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PYTHON_PACKAGE]")
   *           .toString();
   *   PythonPackage response = artifactRegistryClient.getPythonPackage(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the python package.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PythonPackage getPythonPackage(String name) {
    GetPythonPackageRequest request = GetPythonPackageRequest.newBuilder().setName(name).build();
    return getPythonPackage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a python package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetPythonPackageRequest request =
   *       GetPythonPackageRequest.newBuilder()
   *           .setName(
   *               PythonPackageName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PYTHON_PACKAGE]")
   *                   .toString())
   *           .build();
   *   PythonPackage response = artifactRegistryClient.getPythonPackage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PythonPackage getPythonPackage(GetPythonPackageRequest request) {
    return getPythonPackageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a python package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetPythonPackageRequest request =
   *       GetPythonPackageRequest.newBuilder()
   *           .setName(
   *               PythonPackageName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PYTHON_PACKAGE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PythonPackage> future =
   *       artifactRegistryClient.getPythonPackageCallable().futureCall(request);
   *   // Do something.
   *   PythonPackage response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPythonPackageRequest, PythonPackage> getPythonPackageCallable() {
    return stub.getPythonPackageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports Apt artifacts. The returned Operation will complete once the resources are imported.
   * Package, Version, and File resources are created based on the imported artifacts. Imported
   * artifacts that conflict with existing resources are ignored.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ImportAptArtifactsRequest request =
   *       ImportAptArtifactsRequest.newBuilder().setParent("parent-995424086").build();
   *   ImportAptArtifactsResponse response =
   *       artifactRegistryClient.importAptArtifactsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportAptArtifactsResponse, ImportAptArtifactsMetadata>
      importAptArtifactsAsync(ImportAptArtifactsRequest request) {
    return importAptArtifactsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports Apt artifacts. The returned Operation will complete once the resources are imported.
   * Package, Version, and File resources are created based on the imported artifacts. Imported
   * artifacts that conflict with existing resources are ignored.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ImportAptArtifactsRequest request =
   *       ImportAptArtifactsRequest.newBuilder().setParent("parent-995424086").build();
   *   OperationFuture<ImportAptArtifactsResponse, ImportAptArtifactsMetadata> future =
   *       artifactRegistryClient.importAptArtifactsOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportAptArtifactsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportAptArtifactsRequest, ImportAptArtifactsResponse, ImportAptArtifactsMetadata>
      importAptArtifactsOperationCallable() {
    return stub.importAptArtifactsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports Apt artifacts. The returned Operation will complete once the resources are imported.
   * Package, Version, and File resources are created based on the imported artifacts. Imported
   * artifacts that conflict with existing resources are ignored.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ImportAptArtifactsRequest request =
   *       ImportAptArtifactsRequest.newBuilder().setParent("parent-995424086").build();
   *   ApiFuture<Operation> future =
   *       artifactRegistryClient.importAptArtifactsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportAptArtifactsRequest, Operation> importAptArtifactsCallable() {
    return stub.importAptArtifactsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports Yum (RPM) artifacts. The returned Operation will complete once the resources are
   * imported. Package, Version, and File resources are created based on the imported artifacts.
   * Imported artifacts that conflict with existing resources are ignored.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ImportYumArtifactsRequest request =
   *       ImportYumArtifactsRequest.newBuilder().setParent("parent-995424086").build();
   *   ImportYumArtifactsResponse response =
   *       artifactRegistryClient.importYumArtifactsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportYumArtifactsResponse, ImportYumArtifactsMetadata>
      importYumArtifactsAsync(ImportYumArtifactsRequest request) {
    return importYumArtifactsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports Yum (RPM) artifacts. The returned Operation will complete once the resources are
   * imported. Package, Version, and File resources are created based on the imported artifacts.
   * Imported artifacts that conflict with existing resources are ignored.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ImportYumArtifactsRequest request =
   *       ImportYumArtifactsRequest.newBuilder().setParent("parent-995424086").build();
   *   OperationFuture<ImportYumArtifactsResponse, ImportYumArtifactsMetadata> future =
   *       artifactRegistryClient.importYumArtifactsOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportYumArtifactsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportYumArtifactsRequest, ImportYumArtifactsResponse, ImportYumArtifactsMetadata>
      importYumArtifactsOperationCallable() {
    return stub.importYumArtifactsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports Yum (RPM) artifacts. The returned Operation will complete once the resources are
   * imported. Package, Version, and File resources are created based on the imported artifacts.
   * Imported artifacts that conflict with existing resources are ignored.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ImportYumArtifactsRequest request =
   *       ImportYumArtifactsRequest.newBuilder().setParent("parent-995424086").build();
   *   ApiFuture<Operation> future =
   *       artifactRegistryClient.importYumArtifactsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportYumArtifactsRequest, Operation> importYumArtifactsCallable() {
    return stub.importYumArtifactsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists repositories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Repository element : artifactRegistryClient.listRepositories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource whose repositories will be listed.
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
   * Lists repositories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Repository element : artifactRegistryClient.listRepositories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource whose repositories will be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRepositoriesPagedResponse listRepositories(String parent) {
    ListRepositoriesRequest request =
        ListRepositoriesRequest.newBuilder().setParent(parent).build();
    return listRepositories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists repositories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListRepositoriesRequest request =
   *       ListRepositoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Repository element : artifactRegistryClient.listRepositories(request).iterateAll()) {
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
   * Lists repositories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListRepositoriesRequest request =
   *       ListRepositoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Repository> future =
   *       artifactRegistryClient.listRepositoriesPagedCallable().futureCall(request);
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
   * Lists repositories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListRepositoriesRequest request =
   *       ListRepositoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRepositoriesResponse response =
   *         artifactRegistryClient.listRepositoriesCallable().call(request);
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
   * Gets a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   Repository response = artifactRegistryClient.getRepository(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the repository to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Repository getRepository(RepositoryName name) {
    GetRepositoryRequest request =
        GetRepositoryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRepository(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   Repository response = artifactRegistryClient.getRepository(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the repository to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Repository getRepository(String name) {
    GetRepositoryRequest request = GetRepositoryRequest.newBuilder().setName(name).build();
    return getRepository(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetRepositoryRequest request =
   *       GetRepositoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .build();
   *   Repository response = artifactRegistryClient.getRepository(request);
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
   * Gets a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetRepositoryRequest request =
   *       GetRepositoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .build();
   *   ApiFuture<Repository> future =
   *       artifactRegistryClient.getRepositoryCallable().futureCall(request);
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
   * Creates a repository. The returned Operation will finish once the repository has been created.
   * Its response will be the created Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Repository repository = Repository.newBuilder().build();
   *   String repositoryId = "repositoryId2113747461";
   *   Repository response =
   *       artifactRegistryClient.createRepositoryAsync(parent, repository, repositoryId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource where the repository will be created.
   * @param repository Required. The repository to be created.
   * @param repositoryId Required. The repository id to use for this repository.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Repository, OperationMetadata> createRepositoryAsync(
      LocationName parent, Repository repository, String repositoryId) {
    CreateRepositoryRequest request =
        CreateRepositoryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRepository(repository)
            .setRepositoryId(repositoryId)
            .build();
    return createRepositoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a repository. The returned Operation will finish once the repository has been created.
   * Its response will be the created Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Repository repository = Repository.newBuilder().build();
   *   String repositoryId = "repositoryId2113747461";
   *   Repository response =
   *       artifactRegistryClient.createRepositoryAsync(parent, repository, repositoryId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource where the repository will be created.
   * @param repository Required. The repository to be created.
   * @param repositoryId Required. The repository id to use for this repository.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Repository, OperationMetadata> createRepositoryAsync(
      String parent, Repository repository, String repositoryId) {
    CreateRepositoryRequest request =
        CreateRepositoryRequest.newBuilder()
            .setParent(parent)
            .setRepository(repository)
            .setRepositoryId(repositoryId)
            .build();
    return createRepositoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a repository. The returned Operation will finish once the repository has been created.
   * Its response will be the created Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   CreateRepositoryRequest request =
   *       CreateRepositoryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRepositoryId("repositoryId2113747461")
   *           .setRepository(Repository.newBuilder().build())
   *           .build();
   *   Repository response = artifactRegistryClient.createRepositoryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Repository, OperationMetadata> createRepositoryAsync(
      CreateRepositoryRequest request) {
    return createRepositoryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a repository. The returned Operation will finish once the repository has been created.
   * Its response will be the created Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   CreateRepositoryRequest request =
   *       CreateRepositoryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRepositoryId("repositoryId2113747461")
   *           .setRepository(Repository.newBuilder().build())
   *           .build();
   *   OperationFuture<Repository, OperationMetadata> future =
   *       artifactRegistryClient.createRepositoryOperationCallable().futureCall(request);
   *   // Do something.
   *   Repository response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationCallable() {
    return stub.createRepositoryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a repository. The returned Operation will finish once the repository has been created.
   * Its response will be the created Repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   CreateRepositoryRequest request =
   *       CreateRepositoryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRepositoryId("repositoryId2113747461")
   *           .setRepository(Repository.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       artifactRegistryClient.createRepositoryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRepositoryRequest, Operation> createRepositoryCallable() {
    return stub.createRepositoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   Repository repository = Repository.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Repository response = artifactRegistryClient.updateRepository(repository, updateMask);
   * }
   * }</pre>
   *
   * @param repository The repository that replaces the resource on the server.
   * @param updateMask The update mask applies to the resource. For the `FieldMask` definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask
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
   * Updates a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdateRepositoryRequest request =
   *       UpdateRepositoryRequest.newBuilder()
   *           .setRepository(Repository.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Repository response = artifactRegistryClient.updateRepository(request);
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
   * Updates a repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdateRepositoryRequest request =
   *       UpdateRepositoryRequest.newBuilder()
   *           .setRepository(Repository.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Repository> future =
   *       artifactRegistryClient.updateRepositoryCallable().futureCall(request);
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
   * Deletes a repository and all of its contents. The returned Operation will finish once the
   * repository has been deleted. It will not have any Operation metadata and will return a
   * google.protobuf.Empty response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   artifactRegistryClient.deleteRepositoryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the repository to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRepositoryAsync(
      RepositoryName name) {
    DeleteRepositoryRequest request =
        DeleteRepositoryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRepositoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a repository and all of its contents. The returned Operation will finish once the
   * repository has been deleted. It will not have any Operation metadata and will return a
   * google.protobuf.Empty response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   artifactRegistryClient.deleteRepositoryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the repository to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRepositoryAsync(String name) {
    DeleteRepositoryRequest request = DeleteRepositoryRequest.newBuilder().setName(name).build();
    return deleteRepositoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a repository and all of its contents. The returned Operation will finish once the
   * repository has been deleted. It will not have any Operation metadata and will return a
   * google.protobuf.Empty response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteRepositoryRequest request =
   *       DeleteRepositoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .build();
   *   artifactRegistryClient.deleteRepositoryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRepositoryAsync(
      DeleteRepositoryRequest request) {
    return deleteRepositoryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a repository and all of its contents. The returned Operation will finish once the
   * repository has been deleted. It will not have any Operation metadata and will return a
   * google.protobuf.Empty response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteRepositoryRequest request =
   *       DeleteRepositoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       artifactRegistryClient.deleteRepositoryOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationCallable() {
    return stub.deleteRepositoryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a repository and all of its contents. The returned Operation will finish once the
   * repository has been deleted. It will not have any Operation metadata and will return a
   * google.protobuf.Empty response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteRepositoryRequest request =
   *       DeleteRepositoryRequest.newBuilder()
   *           .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       artifactRegistryClient.deleteRepositoryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRepositoryRequest, Operation> deleteRepositoryCallable() {
    return stub.deleteRepositoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists packages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (Package element : artifactRegistryClient.listPackages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource whose packages will be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPackagesPagedResponse listPackages(RepositoryName parent) {
    ListPackagesRequest request =
        ListPackagesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPackages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists packages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (Package element : artifactRegistryClient.listPackages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource whose packages will be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPackagesPagedResponse listPackages(String parent) {
    ListPackagesRequest request = ListPackagesRequest.newBuilder().setParent(parent).build();
    return listPackages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists packages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListPackagesRequest request =
   *       ListPackagesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Package element : artifactRegistryClient.listPackages(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPackagesPagedResponse listPackages(ListPackagesRequest request) {
    return listPackagesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists packages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListPackagesRequest request =
   *       ListPackagesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Package> future =
   *       artifactRegistryClient.listPackagesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Package element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPackagesRequest, ListPackagesPagedResponse>
      listPackagesPagedCallable() {
    return stub.listPackagesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists packages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListPackagesRequest request =
   *       ListPackagesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListPackagesResponse response = artifactRegistryClient.listPackagesCallable().call(request);
   *     for (Package element : response.getPackagesList()) {
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
  public final UnaryCallable<ListPackagesRequest, ListPackagesResponse> listPackagesCallable() {
    return stub.listPackagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   PackageName name = PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]");
   *   Package response = artifactRegistryClient.getPackage(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the package to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Package getPackage(PackageName name) {
    GetPackageRequest request =
        GetPackageRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPackage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name =
   *       PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]").toString();
   *   Package response = artifactRegistryClient.getPackage(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the package to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Package getPackage(String name) {
    GetPackageRequest request = GetPackageRequest.newBuilder().setName(name).build();
    return getPackage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetPackageRequest request =
   *       GetPackageRequest.newBuilder()
   *           .setName(
   *               PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]").toString())
   *           .build();
   *   Package response = artifactRegistryClient.getPackage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Package getPackage(GetPackageRequest request) {
    return getPackageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetPackageRequest request =
   *       GetPackageRequest.newBuilder()
   *           .setName(
   *               PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]").toString())
   *           .build();
   *   ApiFuture<Package> future = artifactRegistryClient.getPackageCallable().futureCall(request);
   *   // Do something.
   *   Package response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPackageRequest, Package> getPackageCallable() {
    return stub.getPackageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a package and all of its versions and tags. The returned operation will complete once
   * the package has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   PackageName name = PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]");
   *   artifactRegistryClient.deletePackageAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the package to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePackageAsync(PackageName name) {
    DeletePackageRequest request =
        DeletePackageRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deletePackageAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a package and all of its versions and tags. The returned operation will complete once
   * the package has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name =
   *       PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]").toString();
   *   artifactRegistryClient.deletePackageAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the package to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePackageAsync(String name) {
    DeletePackageRequest request = DeletePackageRequest.newBuilder().setName(name).build();
    return deletePackageAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a package and all of its versions and tags. The returned operation will complete once
   * the package has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeletePackageRequest request =
   *       DeletePackageRequest.newBuilder()
   *           .setName(
   *               PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]").toString())
   *           .build();
   *   artifactRegistryClient.deletePackageAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePackageAsync(
      DeletePackageRequest request) {
    return deletePackageOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a package and all of its versions and tags. The returned operation will complete once
   * the package has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeletePackageRequest request =
   *       DeletePackageRequest.newBuilder()
   *           .setName(
   *               PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       artifactRegistryClient.deletePackageOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePackageRequest, Empty, OperationMetadata>
      deletePackageOperationCallable() {
    return stub.deletePackageOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a package and all of its versions and tags. The returned operation will complete once
   * the package has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeletePackageRequest request =
   *       DeletePackageRequest.newBuilder()
   *           .setName(
   *               PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       artifactRegistryClient.deletePackageCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePackageRequest, Operation> deletePackageCallable() {
    return stub.deletePackageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Version element : artifactRegistryClient.listVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The name of the parent resource whose versions will be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVersionsPagedResponse listVersions(String parent) {
    ListVersionsRequest request = ListVersionsRequest.newBuilder().setParent(parent).build();
    return listVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListVersionsRequest request =
   *       ListVersionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(VersionView.forNumber(0))
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Version element : artifactRegistryClient.listVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVersionsPagedResponse listVersions(ListVersionsRequest request) {
    return listVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListVersionsRequest request =
   *       ListVersionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(VersionView.forNumber(0))
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Version> future =
   *       artifactRegistryClient.listVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Version element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVersionsRequest, ListVersionsPagedResponse>
      listVersionsPagedCallable() {
    return stub.listVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListVersionsRequest request =
   *       ListVersionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(VersionView.forNumber(0))
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListVersionsResponse response = artifactRegistryClient.listVersionsCallable().call(request);
   *     for (Version element : response.getVersionsList()) {
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
  public final UnaryCallable<ListVersionsRequest, ListVersionsResponse> listVersionsCallable() {
    return stub.listVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a version
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = "name3373707";
   *   Version response = artifactRegistryClient.getVersion(name);
   * }
   * }</pre>
   *
   * @param name The name of the version to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Version getVersion(String name) {
    GetVersionRequest request = GetVersionRequest.newBuilder().setName(name).build();
    return getVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a version
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetVersionRequest request =
   *       GetVersionRequest.newBuilder()
   *           .setName("name3373707")
   *           .setView(VersionView.forNumber(0))
   *           .build();
   *   Version response = artifactRegistryClient.getVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Version getVersion(GetVersionRequest request) {
    return getVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a version
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetVersionRequest request =
   *       GetVersionRequest.newBuilder()
   *           .setName("name3373707")
   *           .setView(VersionView.forNumber(0))
   *           .build();
   *   ApiFuture<Version> future = artifactRegistryClient.getVersionCallable().futureCall(request);
   *   // Do something.
   *   Version response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVersionRequest, Version> getVersionCallable() {
    return stub.getVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a version and all of its content. The returned operation will complete once the version
   * has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = "name3373707";
   *   artifactRegistryClient.deleteVersionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name The name of the version to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVersionAsync(String name) {
    DeleteVersionRequest request = DeleteVersionRequest.newBuilder().setName(name).build();
    return deleteVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a version and all of its content. The returned operation will complete once the version
   * has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteVersionRequest request =
   *       DeleteVersionRequest.newBuilder().setName("name3373707").setForce(true).build();
   *   artifactRegistryClient.deleteVersionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVersionAsync(
      DeleteVersionRequest request) {
    return deleteVersionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a version and all of its content. The returned operation will complete once the version
   * has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteVersionRequest request =
   *       DeleteVersionRequest.newBuilder().setName("name3373707").setForce(true).build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       artifactRegistryClient.deleteVersionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteVersionRequest, Empty, OperationMetadata>
      deleteVersionOperationCallable() {
    return stub.deleteVersionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a version and all of its content. The returned operation will complete once the version
   * has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteVersionRequest request =
   *       DeleteVersionRequest.newBuilder().setName("name3373707").setForce(true).build();
   *   ApiFuture<Operation> future =
   *       artifactRegistryClient.deleteVersionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteVersionRequest, Operation> deleteVersionCallable() {
    return stub.deleteVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes multiple versions across a repository. The returned operation will complete once the
   * versions have been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   PackageName parent = PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]");
   *   List<String> names = new ArrayList<>();
   *   artifactRegistryClient.batchDeleteVersionsAsync(parent, names).get();
   * }
   * }</pre>
   *
   * @param parent The name of the repository holding all requested versions.
   * @param names Required. The names of the versions to delete. The maximum number of versions
   *     deleted per batch is determined by the service and is dependent on the available resources
   *     in the region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, BatchDeleteVersionsMetadata> batchDeleteVersionsAsync(
      PackageName parent, List<String> names) {
    BatchDeleteVersionsRequest request =
        BatchDeleteVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDeleteVersionsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes multiple versions across a repository. The returned operation will complete once the
   * versions have been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent =
   *       PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]").toString();
   *   List<String> names = new ArrayList<>();
   *   artifactRegistryClient.batchDeleteVersionsAsync(parent, names).get();
   * }
   * }</pre>
   *
   * @param parent The name of the repository holding all requested versions.
   * @param names Required. The names of the versions to delete. The maximum number of versions
   *     deleted per batch is determined by the service and is dependent on the available resources
   *     in the region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, BatchDeleteVersionsMetadata> batchDeleteVersionsAsync(
      String parent, List<String> names) {
    BatchDeleteVersionsRequest request =
        BatchDeleteVersionsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchDeleteVersionsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes multiple versions across a repository. The returned operation will complete once the
   * versions have been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   BatchDeleteVersionsRequest request =
   *       BatchDeleteVersionsRequest.newBuilder()
   *           .setParent(
   *               PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setValidateOnly(true)
   *           .build();
   *   artifactRegistryClient.batchDeleteVersionsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, BatchDeleteVersionsMetadata> batchDeleteVersionsAsync(
      BatchDeleteVersionsRequest request) {
    return batchDeleteVersionsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes multiple versions across a repository. The returned operation will complete once the
   * versions have been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   BatchDeleteVersionsRequest request =
   *       BatchDeleteVersionsRequest.newBuilder()
   *           .setParent(
   *               PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Empty, BatchDeleteVersionsMetadata> future =
   *       artifactRegistryClient.batchDeleteVersionsOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<BatchDeleteVersionsRequest, Empty, BatchDeleteVersionsMetadata>
      batchDeleteVersionsOperationCallable() {
    return stub.batchDeleteVersionsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes multiple versions across a repository. The returned operation will complete once the
   * versions have been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   BatchDeleteVersionsRequest request =
   *       BatchDeleteVersionsRequest.newBuilder()
   *           .setParent(
   *               PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       artifactRegistryClient.batchDeleteVersionsCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteVersionsRequest, Operation> batchDeleteVersionsCallable() {
    return stub.batchDeleteVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   Version version = Version.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Version response = artifactRegistryClient.updateVersion(version, updateMask);
   * }
   * }</pre>
   *
   * @param version Required. The Version that replaces the resource on the server.
   * @param updateMask The update mask applies to the resource. For the `FieldMask` definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Version updateVersion(Version version, FieldMask updateMask) {
    UpdateVersionRequest request =
        UpdateVersionRequest.newBuilder().setVersion(version).setUpdateMask(updateMask).build();
    return updateVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdateVersionRequest request =
   *       UpdateVersionRequest.newBuilder()
   *           .setVersion(Version.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Version response = artifactRegistryClient.updateVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Version updateVersion(UpdateVersionRequest request) {
    return updateVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdateVersionRequest request =
   *       UpdateVersionRequest.newBuilder()
   *           .setVersion(Version.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Version> future =
   *       artifactRegistryClient.updateVersionCallable().futureCall(request);
   *   // Do something.
   *   Version response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateVersionRequest, Version> updateVersionCallable() {
    return stub.updateVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists files.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (File element : artifactRegistryClient.listFiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the repository whose files will be listed. For example:
   *     "projects/p1/locations/us-central1/repositories/repo1
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFilesPagedResponse listFiles(RepositoryName parent) {
    ListFilesRequest request =
        ListFilesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listFiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists files.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (File element : artifactRegistryClient.listFiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the repository whose files will be listed. For example:
   *     "projects/p1/locations/us-central1/repositories/repo1
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFilesPagedResponse listFiles(String parent) {
    ListFilesRequest request = ListFilesRequest.newBuilder().setParent(parent).build();
    return listFiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists files.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListFilesRequest request =
   *       ListFilesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (File element : artifactRegistryClient.listFiles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFilesPagedResponse listFiles(ListFilesRequest request) {
    return listFilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists files.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListFilesRequest request =
   *       ListFilesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<File> future = artifactRegistryClient.listFilesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (File element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFilesRequest, ListFilesPagedResponse> listFilesPagedCallable() {
    return stub.listFilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists files.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListFilesRequest request =
   *       ListFilesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListFilesResponse response = artifactRegistryClient.listFilesCallable().call(request);
   *     for (File element : response.getFilesList()) {
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
  public final UnaryCallable<ListFilesRequest, ListFilesResponse> listFilesCallable() {
    return stub.listFilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   FileName name = FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]");
   *   File response = artifactRegistryClient.getFile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the file to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final File getFile(FileName name) {
    GetFileRequest request =
        GetFileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]").toString();
   *   File response = artifactRegistryClient.getFile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the file to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final File getFile(String name) {
    GetFileRequest request = GetFileRequest.newBuilder().setName(name).build();
    return getFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetFileRequest request =
   *       GetFileRequest.newBuilder()
   *           .setName(FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]").toString())
   *           .build();
   *   File response = artifactRegistryClient.getFile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final File getFile(GetFileRequest request) {
    return getFileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetFileRequest request =
   *       GetFileRequest.newBuilder()
   *           .setName(FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]").toString())
   *           .build();
   *   ApiFuture<File> future = artifactRegistryClient.getFileCallable().futureCall(request);
   *   // Do something.
   *   File response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFileRequest, File> getFileCallable() {
    return stub.getFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a file and all of its content. It is only allowed on generic repositories. The returned
   * operation will complete once the file has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   FileName name = FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]");
   *   artifactRegistryClient.deleteFileAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the file to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFileAsync(FileName name) {
    DeleteFileRequest request =
        DeleteFileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteFileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a file and all of its content. It is only allowed on generic repositories. The returned
   * operation will complete once the file has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]").toString();
   *   artifactRegistryClient.deleteFileAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the file to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFileAsync(String name) {
    DeleteFileRequest request = DeleteFileRequest.newBuilder().setName(name).build();
    return deleteFileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a file and all of its content. It is only allowed on generic repositories. The returned
   * operation will complete once the file has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteFileRequest request =
   *       DeleteFileRequest.newBuilder()
   *           .setName(FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]").toString())
   *           .build();
   *   artifactRegistryClient.deleteFileAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFileAsync(
      DeleteFileRequest request) {
    return deleteFileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a file and all of its content. It is only allowed on generic repositories. The returned
   * operation will complete once the file has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteFileRequest request =
   *       DeleteFileRequest.newBuilder()
   *           .setName(FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       artifactRegistryClient.deleteFileOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteFileRequest, Empty, OperationMetadata>
      deleteFileOperationCallable() {
    return stub.deleteFileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a file and all of its content. It is only allowed on generic repositories. The returned
   * operation will complete once the file has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteFileRequest request =
   *       DeleteFileRequest.newBuilder()
   *           .setName(FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]").toString())
   *           .build();
   *   ApiFuture<Operation> future = artifactRegistryClient.deleteFileCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFileRequest, Operation> deleteFileCallable() {
    return stub.deleteFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   File file = File.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   File response = artifactRegistryClient.updateFile(file, updateMask);
   * }
   * }</pre>
   *
   * @param file Required. The File that replaces the resource on the server.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final File updateFile(File file, FieldMask updateMask) {
    UpdateFileRequest request =
        UpdateFileRequest.newBuilder().setFile(file).setUpdateMask(updateMask).build();
    return updateFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdateFileRequest request =
   *       UpdateFileRequest.newBuilder()
   *           .setFile(File.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   File response = artifactRegistryClient.updateFile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final File updateFile(UpdateFileRequest request) {
    return updateFileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdateFileRequest request =
   *       UpdateFileRequest.newBuilder()
   *           .setFile(File.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<File> future = artifactRegistryClient.updateFileCallable().futureCall(request);
   *   // Do something.
   *   File response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFileRequest, File> updateFileCallable() {
    return stub.updateFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tags.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Tag element : artifactRegistryClient.listTags(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The name of the parent package whose tags will be listed. For example:
   *     `projects/p1/locations/us-central1/repositories/repo1/packages/pkg1`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagsPagedResponse listTags(String parent) {
    ListTagsRequest request = ListTagsRequest.newBuilder().setParent(parent).build();
    return listTags(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tags.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListTagsRequest request =
   *       ListTagsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Tag element : artifactRegistryClient.listTags(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagsPagedResponse listTags(ListTagsRequest request) {
    return listTagsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tags.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListTagsRequest request =
   *       ListTagsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Tag> future = artifactRegistryClient.listTagsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Tag element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTagsRequest, ListTagsPagedResponse> listTagsPagedCallable() {
    return stub.listTagsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tags.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListTagsRequest request =
   *       ListTagsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTagsResponse response = artifactRegistryClient.listTagsCallable().call(request);
   *     for (Tag element : response.getTagsList()) {
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
  public final UnaryCallable<ListTagsRequest, ListTagsResponse> listTagsCallable() {
    return stub.listTagsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = "name3373707";
   *   Tag response = artifactRegistryClient.getTag(name);
   * }
   * }</pre>
   *
   * @param name The name of the tag to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag getTag(String name) {
    GetTagRequest request = GetTagRequest.newBuilder().setName(name).build();
    return getTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetTagRequest request = GetTagRequest.newBuilder().setName("name3373707").build();
   *   Tag response = artifactRegistryClient.getTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag getTag(GetTagRequest request) {
    return getTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetTagRequest request = GetTagRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Tag> future = artifactRegistryClient.getTagCallable().futureCall(request);
   *   // Do something.
   *   Tag response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTagRequest, Tag> getTagCallable() {
    return stub.getTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = "parent-995424086";
   *   Tag tag = Tag.newBuilder().build();
   *   String tagId = "tagId110119509";
   *   Tag response = artifactRegistryClient.createTag(parent, tag, tagId);
   * }
   * }</pre>
   *
   * @param parent The name of the parent resource where the tag will be created.
   * @param tag The tag to be created.
   * @param tagId The tag id to use for this repository.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag createTag(String parent, Tag tag, String tagId) {
    CreateTagRequest request =
        CreateTagRequest.newBuilder().setParent(parent).setTag(tag).setTagId(tagId).build();
    return createTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   CreateTagRequest request =
   *       CreateTagRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setTagId("tagId110119509")
   *           .setTag(Tag.newBuilder().build())
   *           .build();
   *   Tag response = artifactRegistryClient.createTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag createTag(CreateTagRequest request) {
    return createTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   CreateTagRequest request =
   *       CreateTagRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setTagId("tagId110119509")
   *           .setTag(Tag.newBuilder().build())
   *           .build();
   *   ApiFuture<Tag> future = artifactRegistryClient.createTagCallable().futureCall(request);
   *   // Do something.
   *   Tag response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTagRequest, Tag> createTagCallable() {
    return stub.createTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   Tag tag = Tag.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Tag response = artifactRegistryClient.updateTag(tag, updateMask);
   * }
   * }</pre>
   *
   * @param tag The tag that replaces the resource on the server.
   * @param updateMask The update mask applies to the resource. For the `FieldMask` definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag updateTag(Tag tag, FieldMask updateMask) {
    UpdateTagRequest request =
        UpdateTagRequest.newBuilder().setTag(tag).setUpdateMask(updateMask).build();
    return updateTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdateTagRequest request =
   *       UpdateTagRequest.newBuilder()
   *           .setTag(Tag.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Tag response = artifactRegistryClient.updateTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag updateTag(UpdateTagRequest request) {
    return updateTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdateTagRequest request =
   *       UpdateTagRequest.newBuilder()
   *           .setTag(Tag.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Tag> future = artifactRegistryClient.updateTagCallable().futureCall(request);
   *   // Do something.
   *   Tag response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTagRequest, Tag> updateTagCallable() {
    return stub.updateTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = "name3373707";
   *   artifactRegistryClient.deleteTag(name);
   * }
   * }</pre>
   *
   * @param name The name of the tag to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTag(String name) {
    DeleteTagRequest request = DeleteTagRequest.newBuilder().setName(name).build();
    deleteTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteTagRequest request = DeleteTagRequest.newBuilder().setName("name3373707").build();
   *   artifactRegistryClient.deleteTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTag(DeleteTagRequest request) {
    deleteTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteTagRequest request = DeleteTagRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Empty> future = artifactRegistryClient.deleteTagCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTagRequest, Empty> deleteTagCallable() {
    return stub.deleteTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   Rule rule = Rule.newBuilder().build();
   *   String ruleId = "ruleId-919875273";
   *   Rule response = artifactRegistryClient.createRule(parent, rule, ruleId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource where the rule will be created.
   * @param rule The rule to be created.
   * @param ruleId The rule id to use for this repository.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule createRule(RepositoryName parent, Rule rule, String ruleId) {
    CreateRuleRequest request =
        CreateRuleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRule(rule)
            .setRuleId(ruleId)
            .build();
    return createRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   Rule rule = Rule.newBuilder().build();
   *   String ruleId = "ruleId-919875273";
   *   Rule response = artifactRegistryClient.createRule(parent, rule, ruleId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource where the rule will be created.
   * @param rule The rule to be created.
   * @param ruleId The rule id to use for this repository.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule createRule(String parent, Rule rule, String ruleId) {
    CreateRuleRequest request =
        CreateRuleRequest.newBuilder().setParent(parent).setRule(rule).setRuleId(ruleId).build();
    return createRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   CreateRuleRequest request =
   *       CreateRuleRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setRuleId("ruleId-919875273")
   *           .setRule(Rule.newBuilder().build())
   *           .build();
   *   Rule response = artifactRegistryClient.createRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule createRule(CreateRuleRequest request) {
    return createRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   CreateRuleRequest request =
   *       CreateRuleRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setRuleId("ruleId-919875273")
   *           .setRule(Rule.newBuilder().build())
   *           .build();
   *   ApiFuture<Rule> future = artifactRegistryClient.createRuleCallable().futureCall(request);
   *   // Do something.
   *   Rule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRuleRequest, Rule> createRuleCallable() {
    return stub.createRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (Rule element : artifactRegistryClient.listRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent repository whose rules will be listed. For
   *     example: `projects/p1/locations/us-central1/repositories/repo1`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRulesPagedResponse listRules(RepositoryName parent) {
    ListRulesRequest request =
        ListRulesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (Rule element : artifactRegistryClient.listRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent repository whose rules will be listed. For
   *     example: `projects/p1/locations/us-central1/repositories/repo1`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRulesPagedResponse listRules(String parent) {
    ListRulesRequest request = ListRulesRequest.newBuilder().setParent(parent).build();
    return listRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListRulesRequest request =
   *       ListRulesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Rule element : artifactRegistryClient.listRules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRulesPagedResponse listRules(ListRulesRequest request) {
    return listRulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListRulesRequest request =
   *       ListRulesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Rule> future = artifactRegistryClient.listRulesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Rule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRulesRequest, ListRulesPagedResponse> listRulesPagedCallable() {
    return stub.listRulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListRulesRequest request =
   *       ListRulesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListRulesResponse response = artifactRegistryClient.listRulesCallable().call(request);
   *     for (Rule element : response.getRulesList()) {
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
  public final UnaryCallable<ListRulesRequest, ListRulesResponse> listRulesCallable() {
    return stub.listRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]");
   *   Rule response = artifactRegistryClient.getRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule getRule(RuleName name) {
    GetRuleRequest request =
        GetRuleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]").toString();
   *   Rule response = artifactRegistryClient.getRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule getRule(String name) {
    GetRuleRequest request = GetRuleRequest.newBuilder().setName(name).build();
    return getRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetRuleRequest request =
   *       GetRuleRequest.newBuilder()
   *           .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]").toString())
   *           .build();
   *   Rule response = artifactRegistryClient.getRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule getRule(GetRuleRequest request) {
    return getRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetRuleRequest request =
   *       GetRuleRequest.newBuilder()
   *           .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]").toString())
   *           .build();
   *   ApiFuture<Rule> future = artifactRegistryClient.getRuleCallable().futureCall(request);
   *   // Do something.
   *   Rule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRuleRequest, Rule> getRuleCallable() {
    return stub.getRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   Rule rule = Rule.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Rule response = artifactRegistryClient.updateRule(rule, updateMask);
   * }
   * }</pre>
   *
   * @param rule The rule that replaces the resource on the server.
   * @param updateMask The update mask applies to the resource. For the `FieldMask` definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule updateRule(Rule rule, FieldMask updateMask) {
    UpdateRuleRequest request =
        UpdateRuleRequest.newBuilder().setRule(rule).setUpdateMask(updateMask).build();
    return updateRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdateRuleRequest request =
   *       UpdateRuleRequest.newBuilder()
   *           .setRule(Rule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Rule response = artifactRegistryClient.updateRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule updateRule(UpdateRuleRequest request) {
    return updateRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdateRuleRequest request =
   *       UpdateRuleRequest.newBuilder()
   *           .setRule(Rule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Rule> future = artifactRegistryClient.updateRuleCallable().futureCall(request);
   *   // Do something.
   *   Rule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRuleRequest, Rule> updateRuleCallable() {
    return stub.updateRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]");
   *   artifactRegistryClient.deleteRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRule(RuleName name) {
    DeleteRuleRequest request =
        DeleteRuleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]").toString();
   *   artifactRegistryClient.deleteRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRule(String name) {
    DeleteRuleRequest request = DeleteRuleRequest.newBuilder().setName(name).build();
    deleteRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteRuleRequest request =
   *       DeleteRuleRequest.newBuilder()
   *           .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]").toString())
   *           .build();
   *   artifactRegistryClient.deleteRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRule(DeleteRuleRequest request) {
    deleteRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteRuleRequest request =
   *       DeleteRuleRequest.newBuilder()
   *           .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]").toString())
   *           .build();
   *   ApiFuture<Empty> future = artifactRegistryClient.deleteRuleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRuleRequest, Empty> deleteRuleCallable() {
    return stub.deleteRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the IAM policy for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = artifactRegistryClient.setIamPolicy(request);
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
   * Updates the IAM policy for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = artifactRegistryClient.setIamPolicyCallable().futureCall(request);
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
   * Gets the IAM policy for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = artifactRegistryClient.getIamPolicy(request);
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
   * Gets the IAM policy for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = artifactRegistryClient.getIamPolicyCallable().futureCall(request);
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
   * Tests if the caller has a list of permissions on a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = artifactRegistryClient.testIamPermissions(request);
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
   * Tests if the caller has a list of permissions on a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       artifactRegistryClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the Settings for the Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ProjectSettingsName name = ProjectSettingsName.of("[PROJECT]");
   *   ProjectSettings response = artifactRegistryClient.getProjectSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the projectSettings resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProjectSettings getProjectSettings(ProjectSettingsName name) {
    GetProjectSettingsRequest request =
        GetProjectSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getProjectSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the Settings for the Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = ProjectSettingsName.of("[PROJECT]").toString();
   *   ProjectSettings response = artifactRegistryClient.getProjectSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the projectSettings resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProjectSettings getProjectSettings(String name) {
    GetProjectSettingsRequest request =
        GetProjectSettingsRequest.newBuilder().setName(name).build();
    return getProjectSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the Settings for the Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetProjectSettingsRequest request =
   *       GetProjectSettingsRequest.newBuilder()
   *           .setName(ProjectSettingsName.of("[PROJECT]").toString())
   *           .build();
   *   ProjectSettings response = artifactRegistryClient.getProjectSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProjectSettings getProjectSettings(GetProjectSettingsRequest request) {
    return getProjectSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the Settings for the Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetProjectSettingsRequest request =
   *       GetProjectSettingsRequest.newBuilder()
   *           .setName(ProjectSettingsName.of("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<ProjectSettings> future =
   *       artifactRegistryClient.getProjectSettingsCallable().futureCall(request);
   *   // Do something.
   *   ProjectSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProjectSettingsRequest, ProjectSettings>
      getProjectSettingsCallable() {
    return stub.getProjectSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Settings for the Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ProjectSettings projectSettings = ProjectSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ProjectSettings response =
   *       artifactRegistryClient.updateProjectSettings(projectSettings, updateMask);
   * }
   * }</pre>
   *
   * @param projectSettings The project settings.
   * @param updateMask Field mask to support partial updates.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProjectSettings updateProjectSettings(
      ProjectSettings projectSettings, FieldMask updateMask) {
    UpdateProjectSettingsRequest request =
        UpdateProjectSettingsRequest.newBuilder()
            .setProjectSettings(projectSettings)
            .setUpdateMask(updateMask)
            .build();
    return updateProjectSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Settings for the Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdateProjectSettingsRequest request =
   *       UpdateProjectSettingsRequest.newBuilder()
   *           .setProjectSettings(ProjectSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ProjectSettings response = artifactRegistryClient.updateProjectSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProjectSettings updateProjectSettings(UpdateProjectSettingsRequest request) {
    return updateProjectSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Settings for the Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdateProjectSettingsRequest request =
   *       UpdateProjectSettingsRequest.newBuilder()
   *           .setProjectSettings(ProjectSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ProjectSettings> future =
   *       artifactRegistryClient.updateProjectSettingsCallable().futureCall(request);
   *   // Do something.
   *   ProjectSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateProjectSettingsRequest, ProjectSettings>
      updateProjectSettingsCallable() {
    return stub.updateProjectSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the VPCSC Config for the Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   VpcscConfigName name = VpcscConfigName.of("[PROJECT]", "[LOCATION]");
   *   VPCSCConfig response = artifactRegistryClient.getVPCSCConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the VPCSCConfig resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VPCSCConfig getVPCSCConfig(VpcscConfigName name) {
    GetVPCSCConfigRequest request =
        GetVPCSCConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getVPCSCConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the VPCSC Config for the Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = VpcscConfigName.of("[PROJECT]", "[LOCATION]").toString();
   *   VPCSCConfig response = artifactRegistryClient.getVPCSCConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the VPCSCConfig resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VPCSCConfig getVPCSCConfig(String name) {
    GetVPCSCConfigRequest request = GetVPCSCConfigRequest.newBuilder().setName(name).build();
    return getVPCSCConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the VPCSC Config for the Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetVPCSCConfigRequest request =
   *       GetVPCSCConfigRequest.newBuilder()
   *           .setName(VpcscConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   VPCSCConfig response = artifactRegistryClient.getVPCSCConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VPCSCConfig getVPCSCConfig(GetVPCSCConfigRequest request) {
    return getVPCSCConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the VPCSC Config for the Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetVPCSCConfigRequest request =
   *       GetVPCSCConfigRequest.newBuilder()
   *           .setName(VpcscConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<VPCSCConfig> future =
   *       artifactRegistryClient.getVPCSCConfigCallable().futureCall(request);
   *   // Do something.
   *   VPCSCConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVPCSCConfigRequest, VPCSCConfig> getVPCSCConfigCallable() {
    return stub.getVPCSCConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the VPCSC Config for the Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   VPCSCConfig vpcscConfig = VPCSCConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   VPCSCConfig response = artifactRegistryClient.updateVPCSCConfig(vpcscConfig, updateMask);
   * }
   * }</pre>
   *
   * @param vpcscConfig The project config.
   * @param updateMask Field mask to support partial updates.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VPCSCConfig updateVPCSCConfig(VPCSCConfig vpcscConfig, FieldMask updateMask) {
    UpdateVPCSCConfigRequest request =
        UpdateVPCSCConfigRequest.newBuilder()
            .setVpcscConfig(vpcscConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateVPCSCConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the VPCSC Config for the Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdateVPCSCConfigRequest request =
   *       UpdateVPCSCConfigRequest.newBuilder()
   *           .setVpcscConfig(VPCSCConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   VPCSCConfig response = artifactRegistryClient.updateVPCSCConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VPCSCConfig updateVPCSCConfig(UpdateVPCSCConfigRequest request) {
    return updateVPCSCConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the VPCSC Config for the Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdateVPCSCConfigRequest request =
   *       UpdateVPCSCConfigRequest.newBuilder()
   *           .setVpcscConfig(VPCSCConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<VPCSCConfig> future =
   *       artifactRegistryClient.updateVPCSCConfigCallable().futureCall(request);
   *   // Do something.
   *   VPCSCConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateVPCSCConfigRequest, VPCSCConfig> updateVPCSCConfigCallable() {
    return stub.updateVPCSCConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   Package package_ = Package.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Package response = artifactRegistryClient.updatePackage(package_, updateMask);
   * }
   * }</pre>
   *
   * @param package_ The package that replaces the resource on the server.
   * @param updateMask The update mask applies to the resource. For the `FieldMask` definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Package updatePackage(Package package_, FieldMask updateMask) {
    UpdatePackageRequest request =
        UpdatePackageRequest.newBuilder().setPackage(package_).setUpdateMask(updateMask).build();
    return updatePackage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdatePackageRequest request =
   *       UpdatePackageRequest.newBuilder()
   *           .setPackage(Package.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Package response = artifactRegistryClient.updatePackage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Package updatePackage(UpdatePackageRequest request) {
    return updatePackageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   UpdatePackageRequest request =
   *       UpdatePackageRequest.newBuilder()
   *           .setPackage(Package.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Package> future =
   *       artifactRegistryClient.updatePackageCallable().futureCall(request);
   *   // Do something.
   *   Package response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePackageRequest, Package> updatePackageCallable() {
    return stub.updatePackageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists attachments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   for (Attachment element : artifactRegistryClient.listAttachments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource whose attachments will be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttachmentsPagedResponse listAttachments(RepositoryName parent) {
    ListAttachmentsRequest request =
        ListAttachmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists attachments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   for (Attachment element : artifactRegistryClient.listAttachments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource whose attachments will be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttachmentsPagedResponse listAttachments(String parent) {
    ListAttachmentsRequest request = ListAttachmentsRequest.newBuilder().setParent(parent).build();
    return listAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists attachments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListAttachmentsRequest request =
   *       ListAttachmentsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Attachment element : artifactRegistryClient.listAttachments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttachmentsPagedResponse listAttachments(ListAttachmentsRequest request) {
    return listAttachmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists attachments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListAttachmentsRequest request =
   *       ListAttachmentsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Attachment> future =
   *       artifactRegistryClient.listAttachmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Attachment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAttachmentsRequest, ListAttachmentsPagedResponse>
      listAttachmentsPagedCallable() {
    return stub.listAttachmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists attachments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListAttachmentsRequest request =
   *       ListAttachmentsRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAttachmentsResponse response =
   *         artifactRegistryClient.listAttachmentsCallable().call(request);
   *     for (Attachment element : response.getAttachmentsList()) {
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
  public final UnaryCallable<ListAttachmentsRequest, ListAttachmentsResponse>
      listAttachmentsCallable() {
    return stub.listAttachmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   AttachmentName name =
   *       AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]");
   *   Attachment response = artifactRegistryClient.getAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the attachment to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Attachment getAttachment(AttachmentName name) {
    GetAttachmentRequest request =
        GetAttachmentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name =
   *       AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]").toString();
   *   Attachment response = artifactRegistryClient.getAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the attachment to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Attachment getAttachment(String name) {
    GetAttachmentRequest request = GetAttachmentRequest.newBuilder().setName(name).build();
    return getAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetAttachmentRequest request =
   *       GetAttachmentRequest.newBuilder()
   *           .setName(
   *               AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]")
   *                   .toString())
   *           .build();
   *   Attachment response = artifactRegistryClient.getAttachment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Attachment getAttachment(GetAttachmentRequest request) {
    return getAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetAttachmentRequest request =
   *       GetAttachmentRequest.newBuilder()
   *           .setName(
   *               AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Attachment> future =
   *       artifactRegistryClient.getAttachmentCallable().futureCall(request);
   *   // Do something.
   *   Attachment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAttachmentRequest, Attachment> getAttachmentCallable() {
    return stub.getAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an attachment. The returned Operation will finish once the attachment has been created.
   * Its response will be the created attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
   *   Attachment attachment = Attachment.newBuilder().build();
   *   String attachmentId = "attachmentId-1434081890";
   *   Attachment response =
   *       artifactRegistryClient.createAttachmentAsync(parent, attachment, attachmentId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource where the attachment will be created.
   * @param attachment Required. The attachment to be created.
   * @param attachmentId Required. The attachment id to use for this attachment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Attachment, OperationMetadata> createAttachmentAsync(
      RepositoryName parent, Attachment attachment, String attachmentId) {
    CreateAttachmentRequest request =
        CreateAttachmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAttachment(attachment)
            .setAttachmentId(attachmentId)
            .build();
    return createAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an attachment. The returned Operation will finish once the attachment has been created.
   * Its response will be the created attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
   *   Attachment attachment = Attachment.newBuilder().build();
   *   String attachmentId = "attachmentId-1434081890";
   *   Attachment response =
   *       artifactRegistryClient.createAttachmentAsync(parent, attachment, attachmentId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource where the attachment will be created.
   * @param attachment Required. The attachment to be created.
   * @param attachmentId Required. The attachment id to use for this attachment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Attachment, OperationMetadata> createAttachmentAsync(
      String parent, Attachment attachment, String attachmentId) {
    CreateAttachmentRequest request =
        CreateAttachmentRequest.newBuilder()
            .setParent(parent)
            .setAttachment(attachment)
            .setAttachmentId(attachmentId)
            .build();
    return createAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an attachment. The returned Operation will finish once the attachment has been created.
   * Its response will be the created attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   CreateAttachmentRequest request =
   *       CreateAttachmentRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setAttachmentId("attachmentId-1434081890")
   *           .setAttachment(Attachment.newBuilder().build())
   *           .build();
   *   Attachment response = artifactRegistryClient.createAttachmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Attachment, OperationMetadata> createAttachmentAsync(
      CreateAttachmentRequest request) {
    return createAttachmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an attachment. The returned Operation will finish once the attachment has been created.
   * Its response will be the created attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   CreateAttachmentRequest request =
   *       CreateAttachmentRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setAttachmentId("attachmentId-1434081890")
   *           .setAttachment(Attachment.newBuilder().build())
   *           .build();
   *   OperationFuture<Attachment, OperationMetadata> future =
   *       artifactRegistryClient.createAttachmentOperationCallable().futureCall(request);
   *   // Do something.
   *   Attachment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAttachmentRequest, Attachment, OperationMetadata>
      createAttachmentOperationCallable() {
    return stub.createAttachmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an attachment. The returned Operation will finish once the attachment has been created.
   * Its response will be the created attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   CreateAttachmentRequest request =
   *       CreateAttachmentRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setAttachmentId("attachmentId-1434081890")
   *           .setAttachment(Attachment.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       artifactRegistryClient.createAttachmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAttachmentRequest, Operation> createAttachmentCallable() {
    return stub.createAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an attachment. The returned Operation will finish once the attachments has been
   * deleted. It will not have any Operation metadata and will return a `google.protobuf.Empty`
   * response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   AttachmentName name =
   *       AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]");
   *   artifactRegistryClient.deleteAttachmentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the attachment to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAttachmentAsync(
      AttachmentName name) {
    DeleteAttachmentRequest request =
        DeleteAttachmentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an attachment. The returned Operation will finish once the attachments has been
   * deleted. It will not have any Operation metadata and will return a `google.protobuf.Empty`
   * response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name =
   *       AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]").toString();
   *   artifactRegistryClient.deleteAttachmentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the attachment to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAttachmentAsync(String name) {
    DeleteAttachmentRequest request = DeleteAttachmentRequest.newBuilder().setName(name).build();
    return deleteAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an attachment. The returned Operation will finish once the attachments has been
   * deleted. It will not have any Operation metadata and will return a `google.protobuf.Empty`
   * response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteAttachmentRequest request =
   *       DeleteAttachmentRequest.newBuilder()
   *           .setName(
   *               AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]")
   *                   .toString())
   *           .build();
   *   artifactRegistryClient.deleteAttachmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAttachmentAsync(
      DeleteAttachmentRequest request) {
    return deleteAttachmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an attachment. The returned Operation will finish once the attachments has been
   * deleted. It will not have any Operation metadata and will return a `google.protobuf.Empty`
   * response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteAttachmentRequest request =
   *       DeleteAttachmentRequest.newBuilder()
   *           .setName(
   *               AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       artifactRegistryClient.deleteAttachmentOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAttachmentRequest, Empty, OperationMetadata>
      deleteAttachmentOperationCallable() {
    return stub.deleteAttachmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an attachment. The returned Operation will finish once the attachments has been
   * deleted. It will not have any Operation metadata and will return a `google.protobuf.Empty`
   * response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteAttachmentRequest request =
   *       DeleteAttachmentRequest.newBuilder()
   *           .setName(
   *               AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       artifactRegistryClient.deleteAttachmentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAttachmentRequest, Operation> deleteAttachmentCallable() {
    return stub.deleteAttachmentCallable();
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : artifactRegistryClient.listLocations(request).iterateAll()) {
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       artifactRegistryClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         artifactRegistryClient.listLocationsCallable().call(request);
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = artifactRegistryClient.getLocation(request);
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = artifactRegistryClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListDockerImagesPagedResponse
      extends AbstractPagedListResponse<
          ListDockerImagesRequest,
          ListDockerImagesResponse,
          DockerImage,
          ListDockerImagesPage,
          ListDockerImagesFixedSizeCollection> {

    public static ApiFuture<ListDockerImagesPagedResponse> createAsync(
        PageContext<ListDockerImagesRequest, ListDockerImagesResponse, DockerImage> context,
        ApiFuture<ListDockerImagesResponse> futureResponse) {
      ApiFuture<ListDockerImagesPage> futurePage =
          ListDockerImagesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDockerImagesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDockerImagesPagedResponse(ListDockerImagesPage page) {
      super(page, ListDockerImagesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDockerImagesPage
      extends AbstractPage<
          ListDockerImagesRequest, ListDockerImagesResponse, DockerImage, ListDockerImagesPage> {

    private ListDockerImagesPage(
        PageContext<ListDockerImagesRequest, ListDockerImagesResponse, DockerImage> context,
        ListDockerImagesResponse response) {
      super(context, response);
    }

    private static ListDockerImagesPage createEmptyPage() {
      return new ListDockerImagesPage(null, null);
    }

    @Override
    protected ListDockerImagesPage createPage(
        PageContext<ListDockerImagesRequest, ListDockerImagesResponse, DockerImage> context,
        ListDockerImagesResponse response) {
      return new ListDockerImagesPage(context, response);
    }

    @Override
    public ApiFuture<ListDockerImagesPage> createPageAsync(
        PageContext<ListDockerImagesRequest, ListDockerImagesResponse, DockerImage> context,
        ApiFuture<ListDockerImagesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDockerImagesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDockerImagesRequest,
          ListDockerImagesResponse,
          DockerImage,
          ListDockerImagesPage,
          ListDockerImagesFixedSizeCollection> {

    private ListDockerImagesFixedSizeCollection(
        List<ListDockerImagesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDockerImagesFixedSizeCollection createEmptyCollection() {
      return new ListDockerImagesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDockerImagesFixedSizeCollection createCollection(
        List<ListDockerImagesPage> pages, int collectionSize) {
      return new ListDockerImagesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMavenArtifactsPagedResponse
      extends AbstractPagedListResponse<
          ListMavenArtifactsRequest,
          ListMavenArtifactsResponse,
          MavenArtifact,
          ListMavenArtifactsPage,
          ListMavenArtifactsFixedSizeCollection> {

    public static ApiFuture<ListMavenArtifactsPagedResponse> createAsync(
        PageContext<ListMavenArtifactsRequest, ListMavenArtifactsResponse, MavenArtifact> context,
        ApiFuture<ListMavenArtifactsResponse> futureResponse) {
      ApiFuture<ListMavenArtifactsPage> futurePage =
          ListMavenArtifactsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMavenArtifactsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMavenArtifactsPagedResponse(ListMavenArtifactsPage page) {
      super(page, ListMavenArtifactsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMavenArtifactsPage
      extends AbstractPage<
          ListMavenArtifactsRequest,
          ListMavenArtifactsResponse,
          MavenArtifact,
          ListMavenArtifactsPage> {

    private ListMavenArtifactsPage(
        PageContext<ListMavenArtifactsRequest, ListMavenArtifactsResponse, MavenArtifact> context,
        ListMavenArtifactsResponse response) {
      super(context, response);
    }

    private static ListMavenArtifactsPage createEmptyPage() {
      return new ListMavenArtifactsPage(null, null);
    }

    @Override
    protected ListMavenArtifactsPage createPage(
        PageContext<ListMavenArtifactsRequest, ListMavenArtifactsResponse, MavenArtifact> context,
        ListMavenArtifactsResponse response) {
      return new ListMavenArtifactsPage(context, response);
    }

    @Override
    public ApiFuture<ListMavenArtifactsPage> createPageAsync(
        PageContext<ListMavenArtifactsRequest, ListMavenArtifactsResponse, MavenArtifact> context,
        ApiFuture<ListMavenArtifactsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMavenArtifactsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMavenArtifactsRequest,
          ListMavenArtifactsResponse,
          MavenArtifact,
          ListMavenArtifactsPage,
          ListMavenArtifactsFixedSizeCollection> {

    private ListMavenArtifactsFixedSizeCollection(
        List<ListMavenArtifactsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMavenArtifactsFixedSizeCollection createEmptyCollection() {
      return new ListMavenArtifactsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMavenArtifactsFixedSizeCollection createCollection(
        List<ListMavenArtifactsPage> pages, int collectionSize) {
      return new ListMavenArtifactsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNpmPackagesPagedResponse
      extends AbstractPagedListResponse<
          ListNpmPackagesRequest,
          ListNpmPackagesResponse,
          NpmPackage,
          ListNpmPackagesPage,
          ListNpmPackagesFixedSizeCollection> {

    public static ApiFuture<ListNpmPackagesPagedResponse> createAsync(
        PageContext<ListNpmPackagesRequest, ListNpmPackagesResponse, NpmPackage> context,
        ApiFuture<ListNpmPackagesResponse> futureResponse) {
      ApiFuture<ListNpmPackagesPage> futurePage =
          ListNpmPackagesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNpmPackagesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNpmPackagesPagedResponse(ListNpmPackagesPage page) {
      super(page, ListNpmPackagesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNpmPackagesPage
      extends AbstractPage<
          ListNpmPackagesRequest, ListNpmPackagesResponse, NpmPackage, ListNpmPackagesPage> {

    private ListNpmPackagesPage(
        PageContext<ListNpmPackagesRequest, ListNpmPackagesResponse, NpmPackage> context,
        ListNpmPackagesResponse response) {
      super(context, response);
    }

    private static ListNpmPackagesPage createEmptyPage() {
      return new ListNpmPackagesPage(null, null);
    }

    @Override
    protected ListNpmPackagesPage createPage(
        PageContext<ListNpmPackagesRequest, ListNpmPackagesResponse, NpmPackage> context,
        ListNpmPackagesResponse response) {
      return new ListNpmPackagesPage(context, response);
    }

    @Override
    public ApiFuture<ListNpmPackagesPage> createPageAsync(
        PageContext<ListNpmPackagesRequest, ListNpmPackagesResponse, NpmPackage> context,
        ApiFuture<ListNpmPackagesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNpmPackagesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNpmPackagesRequest,
          ListNpmPackagesResponse,
          NpmPackage,
          ListNpmPackagesPage,
          ListNpmPackagesFixedSizeCollection> {

    private ListNpmPackagesFixedSizeCollection(
        List<ListNpmPackagesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNpmPackagesFixedSizeCollection createEmptyCollection() {
      return new ListNpmPackagesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNpmPackagesFixedSizeCollection createCollection(
        List<ListNpmPackagesPage> pages, int collectionSize) {
      return new ListNpmPackagesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPythonPackagesPagedResponse
      extends AbstractPagedListResponse<
          ListPythonPackagesRequest,
          ListPythonPackagesResponse,
          PythonPackage,
          ListPythonPackagesPage,
          ListPythonPackagesFixedSizeCollection> {

    public static ApiFuture<ListPythonPackagesPagedResponse> createAsync(
        PageContext<ListPythonPackagesRequest, ListPythonPackagesResponse, PythonPackage> context,
        ApiFuture<ListPythonPackagesResponse> futureResponse) {
      ApiFuture<ListPythonPackagesPage> futurePage =
          ListPythonPackagesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPythonPackagesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPythonPackagesPagedResponse(ListPythonPackagesPage page) {
      super(page, ListPythonPackagesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPythonPackagesPage
      extends AbstractPage<
          ListPythonPackagesRequest,
          ListPythonPackagesResponse,
          PythonPackage,
          ListPythonPackagesPage> {

    private ListPythonPackagesPage(
        PageContext<ListPythonPackagesRequest, ListPythonPackagesResponse, PythonPackage> context,
        ListPythonPackagesResponse response) {
      super(context, response);
    }

    private static ListPythonPackagesPage createEmptyPage() {
      return new ListPythonPackagesPage(null, null);
    }

    @Override
    protected ListPythonPackagesPage createPage(
        PageContext<ListPythonPackagesRequest, ListPythonPackagesResponse, PythonPackage> context,
        ListPythonPackagesResponse response) {
      return new ListPythonPackagesPage(context, response);
    }

    @Override
    public ApiFuture<ListPythonPackagesPage> createPageAsync(
        PageContext<ListPythonPackagesRequest, ListPythonPackagesResponse, PythonPackage> context,
        ApiFuture<ListPythonPackagesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPythonPackagesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPythonPackagesRequest,
          ListPythonPackagesResponse,
          PythonPackage,
          ListPythonPackagesPage,
          ListPythonPackagesFixedSizeCollection> {

    private ListPythonPackagesFixedSizeCollection(
        List<ListPythonPackagesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPythonPackagesFixedSizeCollection createEmptyCollection() {
      return new ListPythonPackagesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPythonPackagesFixedSizeCollection createCollection(
        List<ListPythonPackagesPage> pages, int collectionSize) {
      return new ListPythonPackagesFixedSizeCollection(pages, collectionSize);
    }
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

  public static class ListPackagesPagedResponse
      extends AbstractPagedListResponse<
          ListPackagesRequest,
          ListPackagesResponse,
          Package,
          ListPackagesPage,
          ListPackagesFixedSizeCollection> {

    public static ApiFuture<ListPackagesPagedResponse> createAsync(
        PageContext<ListPackagesRequest, ListPackagesResponse, Package> context,
        ApiFuture<ListPackagesResponse> futureResponse) {
      ApiFuture<ListPackagesPage> futurePage =
          ListPackagesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPackagesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPackagesPagedResponse(ListPackagesPage page) {
      super(page, ListPackagesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPackagesPage
      extends AbstractPage<ListPackagesRequest, ListPackagesResponse, Package, ListPackagesPage> {

    private ListPackagesPage(
        PageContext<ListPackagesRequest, ListPackagesResponse, Package> context,
        ListPackagesResponse response) {
      super(context, response);
    }

    private static ListPackagesPage createEmptyPage() {
      return new ListPackagesPage(null, null);
    }

    @Override
    protected ListPackagesPage createPage(
        PageContext<ListPackagesRequest, ListPackagesResponse, Package> context,
        ListPackagesResponse response) {
      return new ListPackagesPage(context, response);
    }

    @Override
    public ApiFuture<ListPackagesPage> createPageAsync(
        PageContext<ListPackagesRequest, ListPackagesResponse, Package> context,
        ApiFuture<ListPackagesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPackagesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPackagesRequest,
          ListPackagesResponse,
          Package,
          ListPackagesPage,
          ListPackagesFixedSizeCollection> {

    private ListPackagesFixedSizeCollection(List<ListPackagesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPackagesFixedSizeCollection createEmptyCollection() {
      return new ListPackagesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPackagesFixedSizeCollection createCollection(
        List<ListPackagesPage> pages, int collectionSize) {
      return new ListPackagesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListVersionsRequest,
          ListVersionsResponse,
          Version,
          ListVersionsPage,
          ListVersionsFixedSizeCollection> {

    public static ApiFuture<ListVersionsPagedResponse> createAsync(
        PageContext<ListVersionsRequest, ListVersionsResponse, Version> context,
        ApiFuture<ListVersionsResponse> futureResponse) {
      ApiFuture<ListVersionsPage> futurePage =
          ListVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVersionsPagedResponse(ListVersionsPage page) {
      super(page, ListVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVersionsPage
      extends AbstractPage<ListVersionsRequest, ListVersionsResponse, Version, ListVersionsPage> {

    private ListVersionsPage(
        PageContext<ListVersionsRequest, ListVersionsResponse, Version> context,
        ListVersionsResponse response) {
      super(context, response);
    }

    private static ListVersionsPage createEmptyPage() {
      return new ListVersionsPage(null, null);
    }

    @Override
    protected ListVersionsPage createPage(
        PageContext<ListVersionsRequest, ListVersionsResponse, Version> context,
        ListVersionsResponse response) {
      return new ListVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListVersionsPage> createPageAsync(
        PageContext<ListVersionsRequest, ListVersionsResponse, Version> context,
        ApiFuture<ListVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVersionsRequest,
          ListVersionsResponse,
          Version,
          ListVersionsPage,
          ListVersionsFixedSizeCollection> {

    private ListVersionsFixedSizeCollection(List<ListVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVersionsFixedSizeCollection createEmptyCollection() {
      return new ListVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVersionsFixedSizeCollection createCollection(
        List<ListVersionsPage> pages, int collectionSize) {
      return new ListVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFilesPagedResponse
      extends AbstractPagedListResponse<
          ListFilesRequest, ListFilesResponse, File, ListFilesPage, ListFilesFixedSizeCollection> {

    public static ApiFuture<ListFilesPagedResponse> createAsync(
        PageContext<ListFilesRequest, ListFilesResponse, File> context,
        ApiFuture<ListFilesResponse> futureResponse) {
      ApiFuture<ListFilesPage> futurePage =
          ListFilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListFilesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListFilesPagedResponse(ListFilesPage page) {
      super(page, ListFilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFilesPage
      extends AbstractPage<ListFilesRequest, ListFilesResponse, File, ListFilesPage> {

    private ListFilesPage(
        PageContext<ListFilesRequest, ListFilesResponse, File> context,
        ListFilesResponse response) {
      super(context, response);
    }

    private static ListFilesPage createEmptyPage() {
      return new ListFilesPage(null, null);
    }

    @Override
    protected ListFilesPage createPage(
        PageContext<ListFilesRequest, ListFilesResponse, File> context,
        ListFilesResponse response) {
      return new ListFilesPage(context, response);
    }

    @Override
    public ApiFuture<ListFilesPage> createPageAsync(
        PageContext<ListFilesRequest, ListFilesResponse, File> context,
        ApiFuture<ListFilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFilesRequest, ListFilesResponse, File, ListFilesPage, ListFilesFixedSizeCollection> {

    private ListFilesFixedSizeCollection(List<ListFilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFilesFixedSizeCollection createEmptyCollection() {
      return new ListFilesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFilesFixedSizeCollection createCollection(
        List<ListFilesPage> pages, int collectionSize) {
      return new ListFilesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTagsPagedResponse
      extends AbstractPagedListResponse<
          ListTagsRequest, ListTagsResponse, Tag, ListTagsPage, ListTagsFixedSizeCollection> {

    public static ApiFuture<ListTagsPagedResponse> createAsync(
        PageContext<ListTagsRequest, ListTagsResponse, Tag> context,
        ApiFuture<ListTagsResponse> futureResponse) {
      ApiFuture<ListTagsPage> futurePage =
          ListTagsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListTagsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListTagsPagedResponse(ListTagsPage page) {
      super(page, ListTagsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTagsPage
      extends AbstractPage<ListTagsRequest, ListTagsResponse, Tag, ListTagsPage> {

    private ListTagsPage(
        PageContext<ListTagsRequest, ListTagsResponse, Tag> context, ListTagsResponse response) {
      super(context, response);
    }

    private static ListTagsPage createEmptyPage() {
      return new ListTagsPage(null, null);
    }

    @Override
    protected ListTagsPage createPage(
        PageContext<ListTagsRequest, ListTagsResponse, Tag> context, ListTagsResponse response) {
      return new ListTagsPage(context, response);
    }

    @Override
    public ApiFuture<ListTagsPage> createPageAsync(
        PageContext<ListTagsRequest, ListTagsResponse, Tag> context,
        ApiFuture<ListTagsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTagsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTagsRequest, ListTagsResponse, Tag, ListTagsPage, ListTagsFixedSizeCollection> {

    private ListTagsFixedSizeCollection(List<ListTagsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTagsFixedSizeCollection createEmptyCollection() {
      return new ListTagsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTagsFixedSizeCollection createCollection(
        List<ListTagsPage> pages, int collectionSize) {
      return new ListTagsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRulesPagedResponse
      extends AbstractPagedListResponse<
          ListRulesRequest, ListRulesResponse, Rule, ListRulesPage, ListRulesFixedSizeCollection> {

    public static ApiFuture<ListRulesPagedResponse> createAsync(
        PageContext<ListRulesRequest, ListRulesResponse, Rule> context,
        ApiFuture<ListRulesResponse> futureResponse) {
      ApiFuture<ListRulesPage> futurePage =
          ListRulesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListRulesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListRulesPagedResponse(ListRulesPage page) {
      super(page, ListRulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRulesPage
      extends AbstractPage<ListRulesRequest, ListRulesResponse, Rule, ListRulesPage> {

    private ListRulesPage(
        PageContext<ListRulesRequest, ListRulesResponse, Rule> context,
        ListRulesResponse response) {
      super(context, response);
    }

    private static ListRulesPage createEmptyPage() {
      return new ListRulesPage(null, null);
    }

    @Override
    protected ListRulesPage createPage(
        PageContext<ListRulesRequest, ListRulesResponse, Rule> context,
        ListRulesResponse response) {
      return new ListRulesPage(context, response);
    }

    @Override
    public ApiFuture<ListRulesPage> createPageAsync(
        PageContext<ListRulesRequest, ListRulesResponse, Rule> context,
        ApiFuture<ListRulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRulesRequest, ListRulesResponse, Rule, ListRulesPage, ListRulesFixedSizeCollection> {

    private ListRulesFixedSizeCollection(List<ListRulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRulesFixedSizeCollection createEmptyCollection() {
      return new ListRulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRulesFixedSizeCollection createCollection(
        List<ListRulesPage> pages, int collectionSize) {
      return new ListRulesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAttachmentsPagedResponse
      extends AbstractPagedListResponse<
          ListAttachmentsRequest,
          ListAttachmentsResponse,
          Attachment,
          ListAttachmentsPage,
          ListAttachmentsFixedSizeCollection> {

    public static ApiFuture<ListAttachmentsPagedResponse> createAsync(
        PageContext<ListAttachmentsRequest, ListAttachmentsResponse, Attachment> context,
        ApiFuture<ListAttachmentsResponse> futureResponse) {
      ApiFuture<ListAttachmentsPage> futurePage =
          ListAttachmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAttachmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAttachmentsPagedResponse(ListAttachmentsPage page) {
      super(page, ListAttachmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAttachmentsPage
      extends AbstractPage<
          ListAttachmentsRequest, ListAttachmentsResponse, Attachment, ListAttachmentsPage> {

    private ListAttachmentsPage(
        PageContext<ListAttachmentsRequest, ListAttachmentsResponse, Attachment> context,
        ListAttachmentsResponse response) {
      super(context, response);
    }

    private static ListAttachmentsPage createEmptyPage() {
      return new ListAttachmentsPage(null, null);
    }

    @Override
    protected ListAttachmentsPage createPage(
        PageContext<ListAttachmentsRequest, ListAttachmentsResponse, Attachment> context,
        ListAttachmentsResponse response) {
      return new ListAttachmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListAttachmentsPage> createPageAsync(
        PageContext<ListAttachmentsRequest, ListAttachmentsResponse, Attachment> context,
        ApiFuture<ListAttachmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAttachmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAttachmentsRequest,
          ListAttachmentsResponse,
          Attachment,
          ListAttachmentsPage,
          ListAttachmentsFixedSizeCollection> {

    private ListAttachmentsFixedSizeCollection(
        List<ListAttachmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAttachmentsFixedSizeCollection createEmptyCollection() {
      return new ListAttachmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAttachmentsFixedSizeCollection createCollection(
        List<ListAttachmentsPage> pages, int collectionSize) {
      return new ListAttachmentsFixedSizeCollection(pages, collectionSize);
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
