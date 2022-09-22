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

package com.google.devtools.artifactregistry.v1.stub;

import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListDockerImagesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListFilesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListPackagesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListRepositoriesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListTagsPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListVersionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.devtools.artifactregistry.v1.CreateRepositoryRequest;
import com.google.devtools.artifactregistry.v1.CreateTagRequest;
import com.google.devtools.artifactregistry.v1.DeletePackageRequest;
import com.google.devtools.artifactregistry.v1.DeleteRepositoryRequest;
import com.google.devtools.artifactregistry.v1.DeleteTagRequest;
import com.google.devtools.artifactregistry.v1.DeleteVersionRequest;
import com.google.devtools.artifactregistry.v1.DockerImage;
import com.google.devtools.artifactregistry.v1.File;
import com.google.devtools.artifactregistry.v1.GetDockerImageRequest;
import com.google.devtools.artifactregistry.v1.GetFileRequest;
import com.google.devtools.artifactregistry.v1.GetPackageRequest;
import com.google.devtools.artifactregistry.v1.GetProjectSettingsRequest;
import com.google.devtools.artifactregistry.v1.GetRepositoryRequest;
import com.google.devtools.artifactregistry.v1.GetTagRequest;
import com.google.devtools.artifactregistry.v1.GetVersionRequest;
import com.google.devtools.artifactregistry.v1.ImportAptArtifactsMetadata;
import com.google.devtools.artifactregistry.v1.ImportAptArtifactsRequest;
import com.google.devtools.artifactregistry.v1.ImportAptArtifactsResponse;
import com.google.devtools.artifactregistry.v1.ImportYumArtifactsMetadata;
import com.google.devtools.artifactregistry.v1.ImportYumArtifactsRequest;
import com.google.devtools.artifactregistry.v1.ImportYumArtifactsResponse;
import com.google.devtools.artifactregistry.v1.ListDockerImagesRequest;
import com.google.devtools.artifactregistry.v1.ListDockerImagesResponse;
import com.google.devtools.artifactregistry.v1.ListFilesRequest;
import com.google.devtools.artifactregistry.v1.ListFilesResponse;
import com.google.devtools.artifactregistry.v1.ListPackagesRequest;
import com.google.devtools.artifactregistry.v1.ListPackagesResponse;
import com.google.devtools.artifactregistry.v1.ListRepositoriesRequest;
import com.google.devtools.artifactregistry.v1.ListRepositoriesResponse;
import com.google.devtools.artifactregistry.v1.ListTagsRequest;
import com.google.devtools.artifactregistry.v1.ListTagsResponse;
import com.google.devtools.artifactregistry.v1.ListVersionsRequest;
import com.google.devtools.artifactregistry.v1.ListVersionsResponse;
import com.google.devtools.artifactregistry.v1.OperationMetadata;
import com.google.devtools.artifactregistry.v1.Package;
import com.google.devtools.artifactregistry.v1.ProjectSettings;
import com.google.devtools.artifactregistry.v1.Repository;
import com.google.devtools.artifactregistry.v1.Tag;
import com.google.devtools.artifactregistry.v1.UpdateProjectSettingsRequest;
import com.google.devtools.artifactregistry.v1.UpdateRepositoryRequest;
import com.google.devtools.artifactregistry.v1.UpdateTagRequest;
import com.google.devtools.artifactregistry.v1.Version;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ArtifactRegistryStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (artifactregistry.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDockerImage to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ArtifactRegistryStubSettings.Builder artifactRegistrySettingsBuilder =
 *     ArtifactRegistryStubSettings.newBuilder();
 * artifactRegistrySettingsBuilder
 *     .getDockerImageSettings()
 *     .setRetrySettings(
 *         artifactRegistrySettingsBuilder.getDockerImageSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ArtifactRegistryStubSettings artifactRegistrySettings = artifactRegistrySettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ArtifactRegistryStubSettings extends StubSettings<ArtifactRegistryStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final PagedCallSettings<
          ListDockerImagesRequest, ListDockerImagesResponse, ListDockerImagesPagedResponse>
      listDockerImagesSettings;
  private final UnaryCallSettings<GetDockerImageRequest, DockerImage> getDockerImageSettings;
  private final UnaryCallSettings<ImportAptArtifactsRequest, Operation> importAptArtifactsSettings;
  private final OperationCallSettings<
          ImportAptArtifactsRequest, ImportAptArtifactsResponse, ImportAptArtifactsMetadata>
      importAptArtifactsOperationSettings;
  private final UnaryCallSettings<ImportYumArtifactsRequest, Operation> importYumArtifactsSettings;
  private final OperationCallSettings<
          ImportYumArtifactsRequest, ImportYumArtifactsResponse, ImportYumArtifactsMetadata>
      importYumArtifactsOperationSettings;
  private final PagedCallSettings<
          ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
      listRepositoriesSettings;
  private final UnaryCallSettings<GetRepositoryRequest, Repository> getRepositorySettings;
  private final UnaryCallSettings<CreateRepositoryRequest, Operation> createRepositorySettings;
  private final OperationCallSettings<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationSettings;
  private final UnaryCallSettings<UpdateRepositoryRequest, Repository> updateRepositorySettings;
  private final UnaryCallSettings<DeleteRepositoryRequest, Operation> deleteRepositorySettings;
  private final OperationCallSettings<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationSettings;
  private final PagedCallSettings<
          ListPackagesRequest, ListPackagesResponse, ListPackagesPagedResponse>
      listPackagesSettings;
  private final UnaryCallSettings<GetPackageRequest, Package> getPackageSettings;
  private final UnaryCallSettings<DeletePackageRequest, Operation> deletePackageSettings;
  private final OperationCallSettings<DeletePackageRequest, Empty, OperationMetadata>
      deletePackageOperationSettings;
  private final PagedCallSettings<
          ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
      listVersionsSettings;
  private final UnaryCallSettings<GetVersionRequest, Version> getVersionSettings;
  private final UnaryCallSettings<DeleteVersionRequest, Operation> deleteVersionSettings;
  private final OperationCallSettings<DeleteVersionRequest, Empty, OperationMetadata>
      deleteVersionOperationSettings;
  private final PagedCallSettings<ListFilesRequest, ListFilesResponse, ListFilesPagedResponse>
      listFilesSettings;
  private final UnaryCallSettings<GetFileRequest, File> getFileSettings;
  private final PagedCallSettings<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
      listTagsSettings;
  private final UnaryCallSettings<GetTagRequest, Tag> getTagSettings;
  private final UnaryCallSettings<CreateTagRequest, Tag> createTagSettings;
  private final UnaryCallSettings<UpdateTagRequest, Tag> updateTagSettings;
  private final UnaryCallSettings<DeleteTagRequest, Empty> deleteTagSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;
  private final UnaryCallSettings<GetProjectSettingsRequest, ProjectSettings>
      getProjectSettingsSettings;
  private final UnaryCallSettings<UpdateProjectSettingsRequest, ProjectSettings>
      updateProjectSettingsSettings;

  private static final PagedListDescriptor<
          ListDockerImagesRequest, ListDockerImagesResponse, DockerImage>
      LIST_DOCKER_IMAGES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDockerImagesRequest, ListDockerImagesResponse, DockerImage>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDockerImagesRequest injectToken(
                ListDockerImagesRequest payload, String token) {
              return ListDockerImagesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDockerImagesRequest injectPageSize(
                ListDockerImagesRequest payload, int pageSize) {
              return ListDockerImagesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDockerImagesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDockerImagesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DockerImage> extractResources(ListDockerImagesResponse payload) {
              return payload.getDockerImagesList() == null
                  ? ImmutableList.<DockerImage>of()
                  : payload.getDockerImagesList();
            }
          };

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

  private static final PagedListDescriptor<ListPackagesRequest, ListPackagesResponse, Package>
      LIST_PACKAGES_PAGE_STR_DESC =
          new PagedListDescriptor<ListPackagesRequest, ListPackagesResponse, Package>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPackagesRequest injectToken(ListPackagesRequest payload, String token) {
              return ListPackagesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPackagesRequest injectPageSize(ListPackagesRequest payload, int pageSize) {
              return ListPackagesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPackagesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPackagesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Package> extractResources(ListPackagesResponse payload) {
              return payload.getPackagesList() == null
                  ? ImmutableList.<Package>of()
                  : payload.getPackagesList();
            }
          };

  private static final PagedListDescriptor<ListVersionsRequest, ListVersionsResponse, Version>
      LIST_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListVersionsRequest, ListVersionsResponse, Version>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVersionsRequest injectToken(ListVersionsRequest payload, String token) {
              return ListVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVersionsRequest injectPageSize(ListVersionsRequest payload, int pageSize) {
              return ListVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Version> extractResources(ListVersionsResponse payload) {
              return payload.getVersionsList() == null
                  ? ImmutableList.<Version>of()
                  : payload.getVersionsList();
            }
          };

  private static final PagedListDescriptor<ListFilesRequest, ListFilesResponse, File>
      LIST_FILES_PAGE_STR_DESC =
          new PagedListDescriptor<ListFilesRequest, ListFilesResponse, File>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFilesRequest injectToken(ListFilesRequest payload, String token) {
              return ListFilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFilesRequest injectPageSize(ListFilesRequest payload, int pageSize) {
              return ListFilesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<File> extractResources(ListFilesResponse payload) {
              return payload.getFilesList() == null
                  ? ImmutableList.<File>of()
                  : payload.getFilesList();
            }
          };

  private static final PagedListDescriptor<ListTagsRequest, ListTagsResponse, Tag>
      LIST_TAGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTagsRequest, ListTagsResponse, Tag>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTagsRequest injectToken(ListTagsRequest payload, String token) {
              return ListTagsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTagsRequest injectPageSize(ListTagsRequest payload, int pageSize) {
              return ListTagsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTagsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTagsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Tag> extractResources(ListTagsResponse payload) {
              return payload.getTagsList() == null
                  ? ImmutableList.<Tag>of()
                  : payload.getTagsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDockerImagesRequest, ListDockerImagesResponse, ListDockerImagesPagedResponse>
      LIST_DOCKER_IMAGES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDockerImagesRequest, ListDockerImagesResponse, ListDockerImagesPagedResponse>() {
            @Override
            public ApiFuture<ListDockerImagesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDockerImagesRequest, ListDockerImagesResponse> callable,
                ListDockerImagesRequest request,
                ApiCallContext context,
                ApiFuture<ListDockerImagesResponse> futureResponse) {
              PageContext<ListDockerImagesRequest, ListDockerImagesResponse, DockerImage>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DOCKER_IMAGES_PAGE_STR_DESC, request, context);
              return ListDockerImagesPagedResponse.createAsync(pageContext, futureResponse);
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
          ListPackagesRequest, ListPackagesResponse, ListPackagesPagedResponse>
      LIST_PACKAGES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPackagesRequest, ListPackagesResponse, ListPackagesPagedResponse>() {
            @Override
            public ApiFuture<ListPackagesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPackagesRequest, ListPackagesResponse> callable,
                ListPackagesRequest request,
                ApiCallContext context,
                ApiFuture<ListPackagesResponse> futureResponse) {
              PageContext<ListPackagesRequest, ListPackagesResponse, Package> pageContext =
                  PageContext.create(callable, LIST_PACKAGES_PAGE_STR_DESC, request, context);
              return ListPackagesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
      LIST_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVersionsRequest, ListVersionsResponse> callable,
                ListVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListVersionsResponse> futureResponse) {
              PageContext<ListVersionsRequest, ListVersionsResponse, Version> pageContext =
                  PageContext.create(callable, LIST_VERSIONS_PAGE_STR_DESC, request, context);
              return ListVersionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFilesRequest, ListFilesResponse, ListFilesPagedResponse>
      LIST_FILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFilesRequest, ListFilesResponse, ListFilesPagedResponse>() {
            @Override
            public ApiFuture<ListFilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFilesRequest, ListFilesResponse> callable,
                ListFilesRequest request,
                ApiCallContext context,
                ApiFuture<ListFilesResponse> futureResponse) {
              PageContext<ListFilesRequest, ListFilesResponse, File> pageContext =
                  PageContext.create(callable, LIST_FILES_PAGE_STR_DESC, request, context);
              return ListFilesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
      LIST_TAGS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>() {
            @Override
            public ApiFuture<ListTagsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTagsRequest, ListTagsResponse> callable,
                ListTagsRequest request,
                ApiCallContext context,
                ApiFuture<ListTagsResponse> futureResponse) {
              PageContext<ListTagsRequest, ListTagsResponse, Tag> pageContext =
                  PageContext.create(callable, LIST_TAGS_PAGE_STR_DESC, request, context);
              return ListTagsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listDockerImages. */
  public PagedCallSettings<
          ListDockerImagesRequest, ListDockerImagesResponse, ListDockerImagesPagedResponse>
      listDockerImagesSettings() {
    return listDockerImagesSettings;
  }

  /** Returns the object with the settings used for calls to getDockerImage. */
  public UnaryCallSettings<GetDockerImageRequest, DockerImage> getDockerImageSettings() {
    return getDockerImageSettings;
  }

  /** Returns the object with the settings used for calls to importAptArtifacts. */
  public UnaryCallSettings<ImportAptArtifactsRequest, Operation> importAptArtifactsSettings() {
    return importAptArtifactsSettings;
  }

  /** Returns the object with the settings used for calls to importAptArtifacts. */
  public OperationCallSettings<
          ImportAptArtifactsRequest, ImportAptArtifactsResponse, ImportAptArtifactsMetadata>
      importAptArtifactsOperationSettings() {
    return importAptArtifactsOperationSettings;
  }

  /** Returns the object with the settings used for calls to importYumArtifacts. */
  public UnaryCallSettings<ImportYumArtifactsRequest, Operation> importYumArtifactsSettings() {
    return importYumArtifactsSettings;
  }

  /** Returns the object with the settings used for calls to importYumArtifacts. */
  public OperationCallSettings<
          ImportYumArtifactsRequest, ImportYumArtifactsResponse, ImportYumArtifactsMetadata>
      importYumArtifactsOperationSettings() {
    return importYumArtifactsOperationSettings;
  }

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
  public UnaryCallSettings<CreateRepositoryRequest, Operation> createRepositorySettings() {
    return createRepositorySettings;
  }

  /** Returns the object with the settings used for calls to createRepository. */
  public OperationCallSettings<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationSettings() {
    return createRepositoryOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateRepository. */
  public UnaryCallSettings<UpdateRepositoryRequest, Repository> updateRepositorySettings() {
    return updateRepositorySettings;
  }

  /** Returns the object with the settings used for calls to deleteRepository. */
  public UnaryCallSettings<DeleteRepositoryRequest, Operation> deleteRepositorySettings() {
    return deleteRepositorySettings;
  }

  /** Returns the object with the settings used for calls to deleteRepository. */
  public OperationCallSettings<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationSettings() {
    return deleteRepositoryOperationSettings;
  }

  /** Returns the object with the settings used for calls to listPackages. */
  public PagedCallSettings<ListPackagesRequest, ListPackagesResponse, ListPackagesPagedResponse>
      listPackagesSettings() {
    return listPackagesSettings;
  }

  /** Returns the object with the settings used for calls to getPackage. */
  public UnaryCallSettings<GetPackageRequest, Package> getPackageSettings() {
    return getPackageSettings;
  }

  /** Returns the object with the settings used for calls to deletePackage. */
  public UnaryCallSettings<DeletePackageRequest, Operation> deletePackageSettings() {
    return deletePackageSettings;
  }

  /** Returns the object with the settings used for calls to deletePackage. */
  public OperationCallSettings<DeletePackageRequest, Empty, OperationMetadata>
      deletePackageOperationSettings() {
    return deletePackageOperationSettings;
  }

  /** Returns the object with the settings used for calls to listVersions. */
  public PagedCallSettings<ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
      listVersionsSettings() {
    return listVersionsSettings;
  }

  /** Returns the object with the settings used for calls to getVersion. */
  public UnaryCallSettings<GetVersionRequest, Version> getVersionSettings() {
    return getVersionSettings;
  }

  /** Returns the object with the settings used for calls to deleteVersion. */
  public UnaryCallSettings<DeleteVersionRequest, Operation> deleteVersionSettings() {
    return deleteVersionSettings;
  }

  /** Returns the object with the settings used for calls to deleteVersion. */
  public OperationCallSettings<DeleteVersionRequest, Empty, OperationMetadata>
      deleteVersionOperationSettings() {
    return deleteVersionOperationSettings;
  }

  /** Returns the object with the settings used for calls to listFiles. */
  public PagedCallSettings<ListFilesRequest, ListFilesResponse, ListFilesPagedResponse>
      listFilesSettings() {
    return listFilesSettings;
  }

  /** Returns the object with the settings used for calls to getFile. */
  public UnaryCallSettings<GetFileRequest, File> getFileSettings() {
    return getFileSettings;
  }

  /** Returns the object with the settings used for calls to listTags. */
  public PagedCallSettings<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
      listTagsSettings() {
    return listTagsSettings;
  }

  /** Returns the object with the settings used for calls to getTag. */
  public UnaryCallSettings<GetTagRequest, Tag> getTagSettings() {
    return getTagSettings;
  }

  /** Returns the object with the settings used for calls to createTag. */
  public UnaryCallSettings<CreateTagRequest, Tag> createTagSettings() {
    return createTagSettings;
  }

  /** Returns the object with the settings used for calls to updateTag. */
  public UnaryCallSettings<UpdateTagRequest, Tag> updateTagSettings() {
    return updateTagSettings;
  }

  /** Returns the object with the settings used for calls to deleteTag. */
  public UnaryCallSettings<DeleteTagRequest, Empty> deleteTagSettings() {
    return deleteTagSettings;
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

  /** Returns the object with the settings used for calls to getProjectSettings. */
  public UnaryCallSettings<GetProjectSettingsRequest, ProjectSettings>
      getProjectSettingsSettings() {
    return getProjectSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateProjectSettings. */
  public UnaryCallSettings<UpdateProjectSettingsRequest, ProjectSettings>
      updateProjectSettingsSettings() {
    return updateProjectSettingsSettings;
  }

  public ArtifactRegistryStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcArtifactRegistryStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonArtifactRegistryStub.create(this);
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
    return "artifactregistry.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "artifactregistry.mtls.googleapis.com:443";
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
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ArtifactRegistryStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ArtifactRegistryStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ArtifactRegistryStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ArtifactRegistryStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listDockerImagesSettings = settingsBuilder.listDockerImagesSettings().build();
    getDockerImageSettings = settingsBuilder.getDockerImageSettings().build();
    importAptArtifactsSettings = settingsBuilder.importAptArtifactsSettings().build();
    importAptArtifactsOperationSettings =
        settingsBuilder.importAptArtifactsOperationSettings().build();
    importYumArtifactsSettings = settingsBuilder.importYumArtifactsSettings().build();
    importYumArtifactsOperationSettings =
        settingsBuilder.importYumArtifactsOperationSettings().build();
    listRepositoriesSettings = settingsBuilder.listRepositoriesSettings().build();
    getRepositorySettings = settingsBuilder.getRepositorySettings().build();
    createRepositorySettings = settingsBuilder.createRepositorySettings().build();
    createRepositoryOperationSettings = settingsBuilder.createRepositoryOperationSettings().build();
    updateRepositorySettings = settingsBuilder.updateRepositorySettings().build();
    deleteRepositorySettings = settingsBuilder.deleteRepositorySettings().build();
    deleteRepositoryOperationSettings = settingsBuilder.deleteRepositoryOperationSettings().build();
    listPackagesSettings = settingsBuilder.listPackagesSettings().build();
    getPackageSettings = settingsBuilder.getPackageSettings().build();
    deletePackageSettings = settingsBuilder.deletePackageSettings().build();
    deletePackageOperationSettings = settingsBuilder.deletePackageOperationSettings().build();
    listVersionsSettings = settingsBuilder.listVersionsSettings().build();
    getVersionSettings = settingsBuilder.getVersionSettings().build();
    deleteVersionSettings = settingsBuilder.deleteVersionSettings().build();
    deleteVersionOperationSettings = settingsBuilder.deleteVersionOperationSettings().build();
    listFilesSettings = settingsBuilder.listFilesSettings().build();
    getFileSettings = settingsBuilder.getFileSettings().build();
    listTagsSettings = settingsBuilder.listTagsSettings().build();
    getTagSettings = settingsBuilder.getTagSettings().build();
    createTagSettings = settingsBuilder.createTagSettings().build();
    updateTagSettings = settingsBuilder.updateTagSettings().build();
    deleteTagSettings = settingsBuilder.deleteTagSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    getProjectSettingsSettings = settingsBuilder.getProjectSettingsSettings().build();
    updateProjectSettingsSettings = settingsBuilder.updateProjectSettingsSettings().build();
  }

  /** Builder for ArtifactRegistryStubSettings. */
  public static class Builder extends StubSettings.Builder<ArtifactRegistryStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListDockerImagesRequest, ListDockerImagesResponse, ListDockerImagesPagedResponse>
        listDockerImagesSettings;
    private final UnaryCallSettings.Builder<GetDockerImageRequest, DockerImage>
        getDockerImageSettings;
    private final UnaryCallSettings.Builder<ImportAptArtifactsRequest, Operation>
        importAptArtifactsSettings;
    private final OperationCallSettings.Builder<
            ImportAptArtifactsRequest, ImportAptArtifactsResponse, ImportAptArtifactsMetadata>
        importAptArtifactsOperationSettings;
    private final UnaryCallSettings.Builder<ImportYumArtifactsRequest, Operation>
        importYumArtifactsSettings;
    private final OperationCallSettings.Builder<
            ImportYumArtifactsRequest, ImportYumArtifactsResponse, ImportYumArtifactsMetadata>
        importYumArtifactsOperationSettings;
    private final PagedCallSettings.Builder<
            ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
        listRepositoriesSettings;
    private final UnaryCallSettings.Builder<GetRepositoryRequest, Repository> getRepositorySettings;
    private final UnaryCallSettings.Builder<CreateRepositoryRequest, Operation>
        createRepositorySettings;
    private final OperationCallSettings.Builder<
            CreateRepositoryRequest, Repository, OperationMetadata>
        createRepositoryOperationSettings;
    private final UnaryCallSettings.Builder<UpdateRepositoryRequest, Repository>
        updateRepositorySettings;
    private final UnaryCallSettings.Builder<DeleteRepositoryRequest, Operation>
        deleteRepositorySettings;
    private final OperationCallSettings.Builder<DeleteRepositoryRequest, Empty, OperationMetadata>
        deleteRepositoryOperationSettings;
    private final PagedCallSettings.Builder<
            ListPackagesRequest, ListPackagesResponse, ListPackagesPagedResponse>
        listPackagesSettings;
    private final UnaryCallSettings.Builder<GetPackageRequest, Package> getPackageSettings;
    private final UnaryCallSettings.Builder<DeletePackageRequest, Operation> deletePackageSettings;
    private final OperationCallSettings.Builder<DeletePackageRequest, Empty, OperationMetadata>
        deletePackageOperationSettings;
    private final PagedCallSettings.Builder<
            ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
        listVersionsSettings;
    private final UnaryCallSettings.Builder<GetVersionRequest, Version> getVersionSettings;
    private final UnaryCallSettings.Builder<DeleteVersionRequest, Operation> deleteVersionSettings;
    private final OperationCallSettings.Builder<DeleteVersionRequest, Empty, OperationMetadata>
        deleteVersionOperationSettings;
    private final PagedCallSettings.Builder<
            ListFilesRequest, ListFilesResponse, ListFilesPagedResponse>
        listFilesSettings;
    private final UnaryCallSettings.Builder<GetFileRequest, File> getFileSettings;
    private final PagedCallSettings.Builder<
            ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
        listTagsSettings;
    private final UnaryCallSettings.Builder<GetTagRequest, Tag> getTagSettings;
    private final UnaryCallSettings.Builder<CreateTagRequest, Tag> createTagSettings;
    private final UnaryCallSettings.Builder<UpdateTagRequest, Tag> updateTagSettings;
    private final UnaryCallSettings.Builder<DeleteTagRequest, Empty> deleteTagSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private final UnaryCallSettings.Builder<GetProjectSettingsRequest, ProjectSettings>
        getProjectSettingsSettings;
    private final UnaryCallSettings.Builder<UpdateProjectSettingsRequest, ProjectSettings>
        updateProjectSettingsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listDockerImagesSettings = PagedCallSettings.newBuilder(LIST_DOCKER_IMAGES_PAGE_STR_FACT);
      getDockerImageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importAptArtifactsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importAptArtifactsOperationSettings = OperationCallSettings.newBuilder();
      importYumArtifactsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importYumArtifactsOperationSettings = OperationCallSettings.newBuilder();
      listRepositoriesSettings = PagedCallSettings.newBuilder(LIST_REPOSITORIES_PAGE_STR_FACT);
      getRepositorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRepositorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRepositoryOperationSettings = OperationCallSettings.newBuilder();
      updateRepositorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRepositorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRepositoryOperationSettings = OperationCallSettings.newBuilder();
      listPackagesSettings = PagedCallSettings.newBuilder(LIST_PACKAGES_PAGE_STR_FACT);
      getPackageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePackageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePackageOperationSettings = OperationCallSettings.newBuilder();
      listVersionsSettings = PagedCallSettings.newBuilder(LIST_VERSIONS_PAGE_STR_FACT);
      getVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteVersionOperationSettings = OperationCallSettings.newBuilder();
      listFilesSettings = PagedCallSettings.newBuilder(LIST_FILES_PAGE_STR_FACT);
      getFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTagsSettings = PagedCallSettings.newBuilder(LIST_TAGS_PAGE_STR_FACT);
      getTagSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTagSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTagSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTagSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getProjectSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateProjectSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDockerImagesSettings,
              getDockerImageSettings,
              importAptArtifactsSettings,
              importYumArtifactsSettings,
              listRepositoriesSettings,
              getRepositorySettings,
              createRepositorySettings,
              updateRepositorySettings,
              deleteRepositorySettings,
              listPackagesSettings,
              getPackageSettings,
              deletePackageSettings,
              listVersionsSettings,
              getVersionSettings,
              deleteVersionSettings,
              listFilesSettings,
              getFileSettings,
              listTagsSettings,
              getTagSettings,
              createTagSettings,
              updateTagSettings,
              deleteTagSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings,
              getProjectSettingsSettings,
              updateProjectSettingsSettings);
      initDefaults(this);
    }

    protected Builder(ArtifactRegistryStubSettings settings) {
      super(settings);

      listDockerImagesSettings = settings.listDockerImagesSettings.toBuilder();
      getDockerImageSettings = settings.getDockerImageSettings.toBuilder();
      importAptArtifactsSettings = settings.importAptArtifactsSettings.toBuilder();
      importAptArtifactsOperationSettings =
          settings.importAptArtifactsOperationSettings.toBuilder();
      importYumArtifactsSettings = settings.importYumArtifactsSettings.toBuilder();
      importYumArtifactsOperationSettings =
          settings.importYumArtifactsOperationSettings.toBuilder();
      listRepositoriesSettings = settings.listRepositoriesSettings.toBuilder();
      getRepositorySettings = settings.getRepositorySettings.toBuilder();
      createRepositorySettings = settings.createRepositorySettings.toBuilder();
      createRepositoryOperationSettings = settings.createRepositoryOperationSettings.toBuilder();
      updateRepositorySettings = settings.updateRepositorySettings.toBuilder();
      deleteRepositorySettings = settings.deleteRepositorySettings.toBuilder();
      deleteRepositoryOperationSettings = settings.deleteRepositoryOperationSettings.toBuilder();
      listPackagesSettings = settings.listPackagesSettings.toBuilder();
      getPackageSettings = settings.getPackageSettings.toBuilder();
      deletePackageSettings = settings.deletePackageSettings.toBuilder();
      deletePackageOperationSettings = settings.deletePackageOperationSettings.toBuilder();
      listVersionsSettings = settings.listVersionsSettings.toBuilder();
      getVersionSettings = settings.getVersionSettings.toBuilder();
      deleteVersionSettings = settings.deleteVersionSettings.toBuilder();
      deleteVersionOperationSettings = settings.deleteVersionOperationSettings.toBuilder();
      listFilesSettings = settings.listFilesSettings.toBuilder();
      getFileSettings = settings.getFileSettings.toBuilder();
      listTagsSettings = settings.listTagsSettings.toBuilder();
      getTagSettings = settings.getTagSettings.toBuilder();
      createTagSettings = settings.createTagSettings.toBuilder();
      updateTagSettings = settings.updateTagSettings.toBuilder();
      deleteTagSettings = settings.deleteTagSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      getProjectSettingsSettings = settings.getProjectSettingsSettings.toBuilder();
      updateProjectSettingsSettings = settings.updateProjectSettingsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDockerImagesSettings,
              getDockerImageSettings,
              importAptArtifactsSettings,
              importYumArtifactsSettings,
              listRepositoriesSettings,
              getRepositorySettings,
              createRepositorySettings,
              updateRepositorySettings,
              deleteRepositorySettings,
              listPackagesSettings,
              getPackageSettings,
              deletePackageSettings,
              listVersionsSettings,
              getVersionSettings,
              deleteVersionSettings,
              listFilesSettings,
              getFileSettings,
              listTagsSettings,
              getTagSettings,
              createTagSettings,
              updateTagSettings,
              deleteTagSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings,
              getProjectSettingsSettings,
              updateProjectSettingsSettings);
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
          .listDockerImagesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getDockerImageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .importAptArtifactsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .importYumArtifactsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listRepositoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getRepositorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createRepositorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateRepositorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteRepositorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listPackagesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getPackageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deletePackageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listFilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getFileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listTagsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getTagSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createTagSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateTagSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteTagSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getProjectSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateProjectSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .importAptArtifactsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportAptArtifactsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ImportAptArtifactsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ImportAptArtifactsMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .importYumArtifactsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportYumArtifactsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ImportYumArtifactsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ImportYumArtifactsMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createRepositoryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateRepositoryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Repository.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteRepositoryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRepositoryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deletePackageOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePackageRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteVersionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteVersionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to listDockerImages. */
    public PagedCallSettings.Builder<
            ListDockerImagesRequest, ListDockerImagesResponse, ListDockerImagesPagedResponse>
        listDockerImagesSettings() {
      return listDockerImagesSettings;
    }

    /** Returns the builder for the settings used for calls to getDockerImage. */
    public UnaryCallSettings.Builder<GetDockerImageRequest, DockerImage> getDockerImageSettings() {
      return getDockerImageSettings;
    }

    /** Returns the builder for the settings used for calls to importAptArtifacts. */
    public UnaryCallSettings.Builder<ImportAptArtifactsRequest, Operation>
        importAptArtifactsSettings() {
      return importAptArtifactsSettings;
    }

    /** Returns the builder for the settings used for calls to importAptArtifacts. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ImportAptArtifactsRequest, ImportAptArtifactsResponse, ImportAptArtifactsMetadata>
        importAptArtifactsOperationSettings() {
      return importAptArtifactsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importYumArtifacts. */
    public UnaryCallSettings.Builder<ImportYumArtifactsRequest, Operation>
        importYumArtifactsSettings() {
      return importYumArtifactsSettings;
    }

    /** Returns the builder for the settings used for calls to importYumArtifacts. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ImportYumArtifactsRequest, ImportYumArtifactsResponse, ImportYumArtifactsMetadata>
        importYumArtifactsOperationSettings() {
      return importYumArtifactsOperationSettings;
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
    public UnaryCallSettings.Builder<CreateRepositoryRequest, Operation>
        createRepositorySettings() {
      return createRepositorySettings;
    }

    /** Returns the builder for the settings used for calls to createRepository. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateRepositoryRequest, Repository, OperationMetadata>
        createRepositoryOperationSettings() {
      return createRepositoryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateRepository. */
    public UnaryCallSettings.Builder<UpdateRepositoryRequest, Repository>
        updateRepositorySettings() {
      return updateRepositorySettings;
    }

    /** Returns the builder for the settings used for calls to deleteRepository. */
    public UnaryCallSettings.Builder<DeleteRepositoryRequest, Operation>
        deleteRepositorySettings() {
      return deleteRepositorySettings;
    }

    /** Returns the builder for the settings used for calls to deleteRepository. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteRepositoryRequest, Empty, OperationMetadata>
        deleteRepositoryOperationSettings() {
      return deleteRepositoryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listPackages. */
    public PagedCallSettings.Builder<
            ListPackagesRequest, ListPackagesResponse, ListPackagesPagedResponse>
        listPackagesSettings() {
      return listPackagesSettings;
    }

    /** Returns the builder for the settings used for calls to getPackage. */
    public UnaryCallSettings.Builder<GetPackageRequest, Package> getPackageSettings() {
      return getPackageSettings;
    }

    /** Returns the builder for the settings used for calls to deletePackage. */
    public UnaryCallSettings.Builder<DeletePackageRequest, Operation> deletePackageSettings() {
      return deletePackageSettings;
    }

    /** Returns the builder for the settings used for calls to deletePackage. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeletePackageRequest, Empty, OperationMetadata>
        deletePackageOperationSettings() {
      return deletePackageOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listVersions. */
    public PagedCallSettings.Builder<
            ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
        listVersionsSettings() {
      return listVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to getVersion. */
    public UnaryCallSettings.Builder<GetVersionRequest, Version> getVersionSettings() {
      return getVersionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVersion. */
    public UnaryCallSettings.Builder<DeleteVersionRequest, Operation> deleteVersionSettings() {
      return deleteVersionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVersion. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteVersionRequest, Empty, OperationMetadata>
        deleteVersionOperationSettings() {
      return deleteVersionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listFiles. */
    public PagedCallSettings.Builder<ListFilesRequest, ListFilesResponse, ListFilesPagedResponse>
        listFilesSettings() {
      return listFilesSettings;
    }

    /** Returns the builder for the settings used for calls to getFile. */
    public UnaryCallSettings.Builder<GetFileRequest, File> getFileSettings() {
      return getFileSettings;
    }

    /** Returns the builder for the settings used for calls to listTags. */
    public PagedCallSettings.Builder<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
        listTagsSettings() {
      return listTagsSettings;
    }

    /** Returns the builder for the settings used for calls to getTag. */
    public UnaryCallSettings.Builder<GetTagRequest, Tag> getTagSettings() {
      return getTagSettings;
    }

    /** Returns the builder for the settings used for calls to createTag. */
    public UnaryCallSettings.Builder<CreateTagRequest, Tag> createTagSettings() {
      return createTagSettings;
    }

    /** Returns the builder for the settings used for calls to updateTag. */
    public UnaryCallSettings.Builder<UpdateTagRequest, Tag> updateTagSettings() {
      return updateTagSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTag. */
    public UnaryCallSettings.Builder<DeleteTagRequest, Empty> deleteTagSettings() {
      return deleteTagSettings;
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

    /** Returns the builder for the settings used for calls to getProjectSettings. */
    public UnaryCallSettings.Builder<GetProjectSettingsRequest, ProjectSettings>
        getProjectSettingsSettings() {
      return getProjectSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateProjectSettings. */
    public UnaryCallSettings.Builder<UpdateProjectSettingsRequest, ProjectSettings>
        updateProjectSettingsSettings() {
      return updateProjectSettingsSettings;
    }

    @Override
    public ArtifactRegistryStubSettings build() throws IOException {
      return new ArtifactRegistryStubSettings(this);
    }
  }
}
