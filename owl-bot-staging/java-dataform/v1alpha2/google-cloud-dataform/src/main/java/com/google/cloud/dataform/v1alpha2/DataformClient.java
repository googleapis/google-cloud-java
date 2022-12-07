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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataform.v1alpha2.stub.DataformStub;
import com.google.cloud.dataform.v1alpha2.stub.DataformStubSettings;
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
   *   for (QueryDirectoryContentsResponse.DirectoryEntry element :
   *       dataformClient.queryDirectoryContents(request).iterateAll()) {
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
   *   ApiFuture<QueryDirectoryContentsResponse.DirectoryEntry> future =
   *       dataformClient.queryDirectoryContentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (QueryDirectoryContentsResponse.DirectoryEntry element : future.get().iterateAll()) {
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
   *     for (QueryDirectoryContentsResponse.DirectoryEntry element :
   *         response.getDirectoryEntriesList()) {
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
   * @param parent Required. The parent resource of the WorkflowInvocation type.
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
   * @param parent Required. The parent resource of the WorkflowInvocation type.
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
   *           .setResource(
   *               CompilationResultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
   *                   .toString())
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
   *           .setResource(
   *               CompilationResultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
   *                   .toString())
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
          QueryDirectoryContentsResponse.DirectoryEntry,
          QueryDirectoryContentsPage,
          QueryDirectoryContentsFixedSizeCollection> {

    public static ApiFuture<QueryDirectoryContentsPagedResponse> createAsync(
        PageContext<
                QueryDirectoryContentsRequest,
                QueryDirectoryContentsResponse,
                QueryDirectoryContentsResponse.DirectoryEntry>
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
          QueryDirectoryContentsResponse.DirectoryEntry,
          QueryDirectoryContentsPage> {

    private QueryDirectoryContentsPage(
        PageContext<
                QueryDirectoryContentsRequest,
                QueryDirectoryContentsResponse,
                QueryDirectoryContentsResponse.DirectoryEntry>
            context,
        QueryDirectoryContentsResponse response) {
      super(context, response);
    }

    private static QueryDirectoryContentsPage createEmptyPage() {
      return new QueryDirectoryContentsPage(null, null);
    }

    @Override
    protected QueryDirectoryContentsPage createPage(
        PageContext<
                QueryDirectoryContentsRequest,
                QueryDirectoryContentsResponse,
                QueryDirectoryContentsResponse.DirectoryEntry>
            context,
        QueryDirectoryContentsResponse response) {
      return new QueryDirectoryContentsPage(context, response);
    }

    @Override
    public ApiFuture<QueryDirectoryContentsPage> createPageAsync(
        PageContext<
                QueryDirectoryContentsRequest,
                QueryDirectoryContentsResponse,
                QueryDirectoryContentsResponse.DirectoryEntry>
            context,
        ApiFuture<QueryDirectoryContentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class QueryDirectoryContentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          QueryDirectoryContentsRequest,
          QueryDirectoryContentsResponse,
          QueryDirectoryContentsResponse.DirectoryEntry,
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
