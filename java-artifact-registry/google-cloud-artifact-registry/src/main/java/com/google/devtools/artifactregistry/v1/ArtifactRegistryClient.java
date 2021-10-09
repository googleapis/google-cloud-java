/*
 * Copyright 2021 Google LLC
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
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.devtools.artifactregistry.v1.stub.ArtifactRegistryStub;
import com.google.devtools.artifactregistry.v1.stub.ArtifactRegistryStubSettings;
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
 *   LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");
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
@Generated("by gapic-generator-java")
public class ArtifactRegistryClient implements BackgroundResource {
  private final ArtifactRegistrySettings settings;
  private final ArtifactRegistryStub stub;

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
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ArtifactRegistryClient(ArtifactRegistryStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ArtifactRegistrySettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ArtifactRegistryStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists docker images.
   *
   * <p>Sample code:
   *
   * <pre>{@code
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListDockerImagesRequest request =
   *       ListDockerImagesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListDockerImagesRequest request =
   *       ListDockerImagesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListDockerImagesRequest request =
   *       ListDockerImagesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDockerImagesResponse response =
   *         artifactRegistryClient.listDockerImagesCallable().call(request);
   *     for (DockerImage element : response.getResponsesList()) {
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
   * Lists repositories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   String parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString();
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
   * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
   *   ListRepositoriesRequest request =
   *       ListRepositoriesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
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
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
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
   *   ListRepositoriesRequest request =
   *       ListRepositoriesRequest.newBuilder()
   *           .setParent(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
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
   *   LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Repository response = artifactRegistryClient.getRepository(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the repository to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Repository getRepository(LocationName name) {
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
}
