/*
 * Copyright 2020 Google LLC
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

package com.google.devtools.artifactregistry.v1beta2;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.devtools.artifactregistry.v1beta2.stub.ArtifactRegistryStub;
import com.google.devtools.artifactregistry.v1beta2.stub.ArtifactRegistryStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
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
 * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
 *   String name = "name3373707";
 *   Repository response = artifactRegistryClient.getRepository(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ArtifactRegistryClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
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
 * ArtifactRegistrySettings artifactRegistrySettings =
 *     ArtifactRegistrySettings.newBuilder().setEndpoint(myEndpoint).build();
 * ArtifactRegistryClient artifactRegistryClient =
 *     ArtifactRegistryClient.create(artifactRegistrySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ArtifactRegistryClient implements BackgroundResource {
  private final ArtifactRegistrySettings settings;
  private final ArtifactRegistryStub stub;
  private final OperationsClient operationsClient;

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
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ArtifactRegistryClient(ArtifactRegistryStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ArtifactRegistrySettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ArtifactRegistryStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists repositories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Repository element : artifactRegistryClient.listRepositories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The name of the parent resource whose repositories will be listed.
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListRepositoriesRequest request =
   *       ListRepositoriesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListRepositoriesRequest request =
   *       ListRepositoriesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   while (true) {
   *     ListRepositoriesResponse response =
   *         artifactRegistryClient.listRepositoriesCallable().call(request);
   *     for (Repository element : response.getResponsesList()) {
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = "name3373707";
   *   Repository response = artifactRegistryClient.getRepository(name);
   * }
   * }</pre>
   *
   * @param name The name of the repository to retrieve.
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetRepositoryRequest request =
   *       GetRepositoryRequest.newBuilder().setName("name3373707").build();
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetRepositoryRequest request =
   *       GetRepositoryRequest.newBuilder().setName("name3373707").build();
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = "parent-995424086";
   *   Repository repository = Repository.newBuilder().build();
   *   String repositoryId = "repositoryId2113747461";
   *   Repository response =
   *       artifactRegistryClient.createRepositoryAsync(parent, repository, repositoryId).get();
   * }
   * }</pre>
   *
   * @param parent The name of the parent resource where the repository will be created.
   * @param repository The repository to be created.
   * @param repositoryId The repository id to use for this repository.
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   CreateRepositoryRequest request =
   *       CreateRepositoryRequest.newBuilder()
   *           .setParent("parent-995424086")
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   CreateRepositoryRequest request =
   *       CreateRepositoryRequest.newBuilder()
   *           .setParent("parent-995424086")
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   CreateRepositoryRequest request =
   *       CreateRepositoryRequest.newBuilder()
   *           .setParent("parent-995424086")
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = "name3373707";
   *   artifactRegistryClient.deleteRepositoryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name The name of the repository to delete.
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteRepositoryRequest request =
   *       DeleteRepositoryRequest.newBuilder().setName("name3373707").build();
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteRepositoryRequest request =
   *       DeleteRepositoryRequest.newBuilder().setName("name3373707").build();
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeleteRepositoryRequest request =
   *       DeleteRepositoryRequest.newBuilder().setName("name3373707").build();
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Package element : artifactRegistryClient.listPackages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The name of the parent resource whose packages will be listed.
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListPackagesRequest request =
   *       ListPackagesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListPackagesRequest request =
   *       ListPackagesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   while (true) {
   *     ListPackagesResponse response = artifactRegistryClient.listPackagesCallable().call(request);
   *     for (Package element : response.getResponsesList()) {
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = "name3373707";
   *   Package response = artifactRegistryClient.getPackage(name);
   * }
   * }</pre>
   *
   * @param name The name of the package to retrieve.
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetPackageRequest request = GetPackageRequest.newBuilder().setName("name3373707").build();
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetPackageRequest request = GetPackageRequest.newBuilder().setName("name3373707").build();
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = "name3373707";
   *   artifactRegistryClient.deletePackageAsync(name).get();
   * }
   * }</pre>
   *
   * @param name The name of the package to delete.
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeletePackageRequest request =
   *       DeletePackageRequest.newBuilder().setName("name3373707").build();
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeletePackageRequest request =
   *       DeletePackageRequest.newBuilder().setName("name3373707").build();
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   DeletePackageRequest request =
   *       DeletePackageRequest.newBuilder().setName("name3373707").build();
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListVersionsRequest request =
   *       ListVersionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListVersionsRequest request =
   *       ListVersionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   while (true) {
   *     ListVersionsResponse response = artifactRegistryClient.listVersionsCallable().call(request);
   *     for (Version element : response.getResponsesList()) {
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetVersionRequest request = GetVersionRequest.newBuilder().setName("name3373707").build();
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetVersionRequest request = GetVersionRequest.newBuilder().setName("name3373707").build();
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
   * Lists files.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = "parent-995424086";
   *   for (File element : artifactRegistryClient.listFiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The name of the parent resource whose files will be listed.
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListFilesRequest request =
   *       ListFilesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListFilesRequest request =
   *       ListFilesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   while (true) {
   *     ListFilesResponse response = artifactRegistryClient.listFilesCallable().call(request);
   *     for (File element : response.getResponsesList()) {
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String name = "name3373707";
   *   File response = artifactRegistryClient.getFile(name);
   * }
   * }</pre>
   *
   * @param name The name of the file to retrieve.
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetFileRequest request = GetFileRequest.newBuilder().setName("name3373707").build();
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   GetFileRequest request = GetFileRequest.newBuilder().setName("name3373707").build();
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
   * Lists tags.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Tag element : artifactRegistryClient.listTags(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The name of the parent resource whose tags will be listed.
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   while (true) {
   *     ListTagsResponse response = artifactRegistryClient.listTagsCallable().call(request);
   *     for (Tag element : response.getResponsesList()) {
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
   * Updates the IAM policy for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
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
          new ApiFunction<ListRepositoriesPage, ListRepositoriesPagedResponse>() {
            @Override
            public ListRepositoriesPagedResponse apply(ListRepositoriesPage input) {
              return new ListRepositoriesPagedResponse(input);
            }
          },
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
          new ApiFunction<ListPackagesPage, ListPackagesPagedResponse>() {
            @Override
            public ListPackagesPagedResponse apply(ListPackagesPage input) {
              return new ListPackagesPagedResponse(input);
            }
          },
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
          new ApiFunction<ListVersionsPage, ListVersionsPagedResponse>() {
            @Override
            public ListVersionsPagedResponse apply(ListVersionsPage input) {
              return new ListVersionsPagedResponse(input);
            }
          },
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
          futurePage,
          new ApiFunction<ListFilesPage, ListFilesPagedResponse>() {
            @Override
            public ListFilesPagedResponse apply(ListFilesPage input) {
              return new ListFilesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
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
          futurePage,
          new ApiFunction<ListTagsPage, ListTagsPagedResponse>() {
            @Override
            public ListTagsPagedResponse apply(ListTagsPage input) {
              return new ListTagsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
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
}
