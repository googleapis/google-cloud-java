/*
 * Copyright 2026 Google LLC
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

package com.google.storage.control.v2.stub;

import static com.google.storage.control.v2.StorageControlClient.ListAnywhereCachesPagedResponse;
import static com.google.storage.control.v2.StorageControlClient.ListFoldersPagedResponse;
import static com.google.storage.control.v2.StorageControlClient.ListManagedFoldersPagedResponse;

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
import com.google.api.gax.rpc.LibraryMetadata;
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
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.storage.control.v2.AnywhereCache;
import com.google.storage.control.v2.CreateAnywhereCacheMetadata;
import com.google.storage.control.v2.CreateAnywhereCacheRequest;
import com.google.storage.control.v2.CreateFolderRequest;
import com.google.storage.control.v2.CreateManagedFolderRequest;
import com.google.storage.control.v2.DeleteFolderRecursiveMetadata;
import com.google.storage.control.v2.DeleteFolderRecursiveRequest;
import com.google.storage.control.v2.DeleteFolderRequest;
import com.google.storage.control.v2.DeleteManagedFolderRequest;
import com.google.storage.control.v2.DisableAnywhereCacheRequest;
import com.google.storage.control.v2.Folder;
import com.google.storage.control.v2.GetAnywhereCacheRequest;
import com.google.storage.control.v2.GetFolderIntelligenceConfigRequest;
import com.google.storage.control.v2.GetFolderRequest;
import com.google.storage.control.v2.GetManagedFolderRequest;
import com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest;
import com.google.storage.control.v2.GetProjectIntelligenceConfigRequest;
import com.google.storage.control.v2.GetStorageLayoutRequest;
import com.google.storage.control.v2.IntelligenceConfig;
import com.google.storage.control.v2.ListAnywhereCachesRequest;
import com.google.storage.control.v2.ListAnywhereCachesResponse;
import com.google.storage.control.v2.ListFoldersRequest;
import com.google.storage.control.v2.ListFoldersResponse;
import com.google.storage.control.v2.ListManagedFoldersRequest;
import com.google.storage.control.v2.ListManagedFoldersResponse;
import com.google.storage.control.v2.ManagedFolder;
import com.google.storage.control.v2.PauseAnywhereCacheRequest;
import com.google.storage.control.v2.RenameFolderMetadata;
import com.google.storage.control.v2.RenameFolderRequest;
import com.google.storage.control.v2.ResumeAnywhereCacheRequest;
import com.google.storage.control.v2.StorageLayout;
import com.google.storage.control.v2.UpdateAnywhereCacheMetadata;
import com.google.storage.control.v2.UpdateAnywhereCacheRequest;
import com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest;
import com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest;
import com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link StorageControlStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (storage.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createFolder:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StorageControlStubSettings.Builder storageControlSettingsBuilder =
 *     StorageControlStubSettings.newBuilder();
 * storageControlSettingsBuilder
 *     .createFolderSettings()
 *     .setRetrySettings(
 *         storageControlSettingsBuilder
 *             .createFolderSettings()
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
 * StorageControlStubSettings storageControlSettings = storageControlSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for renameFolder:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StorageControlStubSettings.Builder storageControlSettingsBuilder =
 *     StorageControlStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * storageControlSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class StorageControlStubSettings extends StubSettings<StorageControlStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .add("https://www.googleapis.com/auth/devstorage.full_control")
          .add("https://www.googleapis.com/auth/devstorage.read_only")
          .add("https://www.googleapis.com/auth/devstorage.read_write")
          .build();

  private final UnaryCallSettings<CreateFolderRequest, Folder> createFolderSettings;
  private final UnaryCallSettings<DeleteFolderRequest, Empty> deleteFolderSettings;
  private final UnaryCallSettings<GetFolderRequest, Folder> getFolderSettings;
  private final PagedCallSettings<ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
      listFoldersSettings;
  private final UnaryCallSettings<RenameFolderRequest, Operation> renameFolderSettings;
  private final OperationCallSettings<RenameFolderRequest, Folder, RenameFolderMetadata>
      renameFolderOperationSettings;
  private final UnaryCallSettings<DeleteFolderRecursiveRequest, Operation>
      deleteFolderRecursiveSettings;
  private final OperationCallSettings<
          DeleteFolderRecursiveRequest, Empty, DeleteFolderRecursiveMetadata>
      deleteFolderRecursiveOperationSettings;
  private final UnaryCallSettings<GetStorageLayoutRequest, StorageLayout> getStorageLayoutSettings;
  private final UnaryCallSettings<CreateManagedFolderRequest, ManagedFolder>
      createManagedFolderSettings;
  private final UnaryCallSettings<DeleteManagedFolderRequest, Empty> deleteManagedFolderSettings;
  private final UnaryCallSettings<GetManagedFolderRequest, ManagedFolder> getManagedFolderSettings;
  private final PagedCallSettings<
          ListManagedFoldersRequest, ListManagedFoldersResponse, ListManagedFoldersPagedResponse>
      listManagedFoldersSettings;
  private final UnaryCallSettings<CreateAnywhereCacheRequest, Operation>
      createAnywhereCacheSettings;
  private final OperationCallSettings<
          CreateAnywhereCacheRequest, AnywhereCache, CreateAnywhereCacheMetadata>
      createAnywhereCacheOperationSettings;
  private final UnaryCallSettings<UpdateAnywhereCacheRequest, Operation>
      updateAnywhereCacheSettings;
  private final OperationCallSettings<
          UpdateAnywhereCacheRequest, AnywhereCache, UpdateAnywhereCacheMetadata>
      updateAnywhereCacheOperationSettings;
  private final UnaryCallSettings<DisableAnywhereCacheRequest, AnywhereCache>
      disableAnywhereCacheSettings;
  private final UnaryCallSettings<PauseAnywhereCacheRequest, AnywhereCache>
      pauseAnywhereCacheSettings;
  private final UnaryCallSettings<ResumeAnywhereCacheRequest, AnywhereCache>
      resumeAnywhereCacheSettings;
  private final UnaryCallSettings<GetAnywhereCacheRequest, AnywhereCache> getAnywhereCacheSettings;
  private final PagedCallSettings<
          ListAnywhereCachesRequest, ListAnywhereCachesResponse, ListAnywhereCachesPagedResponse>
      listAnywhereCachesSettings;
  private final UnaryCallSettings<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
      getProjectIntelligenceConfigSettings;
  private final UnaryCallSettings<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
      updateProjectIntelligenceConfigSettings;
  private final UnaryCallSettings<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
      getFolderIntelligenceConfigSettings;
  private final UnaryCallSettings<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
      updateFolderIntelligenceConfigSettings;
  private final UnaryCallSettings<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      getOrganizationIntelligenceConfigSettings;
  private final UnaryCallSettings<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      updateOrganizationIntelligenceConfigSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListFoldersRequest, ListFoldersResponse, Folder>
      LIST_FOLDERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListFoldersRequest, ListFoldersResponse, Folder>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFoldersRequest injectToken(ListFoldersRequest payload, String token) {
              return ListFoldersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFoldersRequest injectPageSize(ListFoldersRequest payload, int pageSize) {
              return ListFoldersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFoldersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFoldersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Folder> extractResources(ListFoldersResponse payload) {
              return payload.getFoldersList();
            }
          };

  private static final PagedListDescriptor<
          ListManagedFoldersRequest, ListManagedFoldersResponse, ManagedFolder>
      LIST_MANAGED_FOLDERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListManagedFoldersRequest, ListManagedFoldersResponse, ManagedFolder>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListManagedFoldersRequest injectToken(
                ListManagedFoldersRequest payload, String token) {
              return ListManagedFoldersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListManagedFoldersRequest injectPageSize(
                ListManagedFoldersRequest payload, int pageSize) {
              return ListManagedFoldersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListManagedFoldersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListManagedFoldersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ManagedFolder> extractResources(ListManagedFoldersResponse payload) {
              return payload.getManagedFoldersList();
            }
          };

  private static final PagedListDescriptor<
          ListAnywhereCachesRequest, ListAnywhereCachesResponse, AnywhereCache>
      LIST_ANYWHERE_CACHES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAnywhereCachesRequest, ListAnywhereCachesResponse, AnywhereCache>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAnywhereCachesRequest injectToken(
                ListAnywhereCachesRequest payload, String token) {
              return ListAnywhereCachesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAnywhereCachesRequest injectPageSize(
                ListAnywhereCachesRequest payload, int pageSize) {
              return ListAnywhereCachesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAnywhereCachesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAnywhereCachesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AnywhereCache> extractResources(ListAnywhereCachesResponse payload) {
              return payload.getAnywhereCachesList();
            }
          };

  private static final PagedListResponseFactory<
          ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
      LIST_FOLDERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>() {
            @Override
            public ApiFuture<ListFoldersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFoldersRequest, ListFoldersResponse> callable,
                ListFoldersRequest request,
                ApiCallContext context,
                ApiFuture<ListFoldersResponse> futureResponse) {
              PageContext<ListFoldersRequest, ListFoldersResponse, Folder> pageContext =
                  PageContext.create(callable, LIST_FOLDERS_PAGE_STR_DESC, request, context);
              return ListFoldersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListManagedFoldersRequest, ListManagedFoldersResponse, ListManagedFoldersPagedResponse>
      LIST_MANAGED_FOLDERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListManagedFoldersRequest,
              ListManagedFoldersResponse,
              ListManagedFoldersPagedResponse>() {
            @Override
            public ApiFuture<ListManagedFoldersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListManagedFoldersRequest, ListManagedFoldersResponse> callable,
                ListManagedFoldersRequest request,
                ApiCallContext context,
                ApiFuture<ListManagedFoldersResponse> futureResponse) {
              PageContext<ListManagedFoldersRequest, ListManagedFoldersResponse, ManagedFolder>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MANAGED_FOLDERS_PAGE_STR_DESC, request, context);
              return ListManagedFoldersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAnywhereCachesRequest, ListAnywhereCachesResponse, ListAnywhereCachesPagedResponse>
      LIST_ANYWHERE_CACHES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAnywhereCachesRequest,
              ListAnywhereCachesResponse,
              ListAnywhereCachesPagedResponse>() {
            @Override
            public ApiFuture<ListAnywhereCachesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAnywhereCachesRequest, ListAnywhereCachesResponse> callable,
                ListAnywhereCachesRequest request,
                ApiCallContext context,
                ApiFuture<ListAnywhereCachesResponse> futureResponse) {
              PageContext<ListAnywhereCachesRequest, ListAnywhereCachesResponse, AnywhereCache>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ANYWHERE_CACHES_PAGE_STR_DESC, request, context);
              return ListAnywhereCachesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createFolder. */
  public UnaryCallSettings<CreateFolderRequest, Folder> createFolderSettings() {
    return createFolderSettings;
  }

  /** Returns the object with the settings used for calls to deleteFolder. */
  public UnaryCallSettings<DeleteFolderRequest, Empty> deleteFolderSettings() {
    return deleteFolderSettings;
  }

  /** Returns the object with the settings used for calls to getFolder. */
  public UnaryCallSettings<GetFolderRequest, Folder> getFolderSettings() {
    return getFolderSettings;
  }

  /** Returns the object with the settings used for calls to listFolders. */
  public PagedCallSettings<ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
      listFoldersSettings() {
    return listFoldersSettings;
  }

  /** Returns the object with the settings used for calls to renameFolder. */
  public UnaryCallSettings<RenameFolderRequest, Operation> renameFolderSettings() {
    return renameFolderSettings;
  }

  /** Returns the object with the settings used for calls to renameFolder. */
  public OperationCallSettings<RenameFolderRequest, Folder, RenameFolderMetadata>
      renameFolderOperationSettings() {
    return renameFolderOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFolderRecursive. */
  public UnaryCallSettings<DeleteFolderRecursiveRequest, Operation>
      deleteFolderRecursiveSettings() {
    return deleteFolderRecursiveSettings;
  }

  /** Returns the object with the settings used for calls to deleteFolderRecursive. */
  public OperationCallSettings<DeleteFolderRecursiveRequest, Empty, DeleteFolderRecursiveMetadata>
      deleteFolderRecursiveOperationSettings() {
    return deleteFolderRecursiveOperationSettings;
  }

  /** Returns the object with the settings used for calls to getStorageLayout. */
  public UnaryCallSettings<GetStorageLayoutRequest, StorageLayout> getStorageLayoutSettings() {
    return getStorageLayoutSettings;
  }

  /** Returns the object with the settings used for calls to createManagedFolder. */
  public UnaryCallSettings<CreateManagedFolderRequest, ManagedFolder>
      createManagedFolderSettings() {
    return createManagedFolderSettings;
  }

  /** Returns the object with the settings used for calls to deleteManagedFolder. */
  public UnaryCallSettings<DeleteManagedFolderRequest, Empty> deleteManagedFolderSettings() {
    return deleteManagedFolderSettings;
  }

  /** Returns the object with the settings used for calls to getManagedFolder. */
  public UnaryCallSettings<GetManagedFolderRequest, ManagedFolder> getManagedFolderSettings() {
    return getManagedFolderSettings;
  }

  /** Returns the object with the settings used for calls to listManagedFolders. */
  public PagedCallSettings<
          ListManagedFoldersRequest, ListManagedFoldersResponse, ListManagedFoldersPagedResponse>
      listManagedFoldersSettings() {
    return listManagedFoldersSettings;
  }

  /** Returns the object with the settings used for calls to createAnywhereCache. */
  public UnaryCallSettings<CreateAnywhereCacheRequest, Operation> createAnywhereCacheSettings() {
    return createAnywhereCacheSettings;
  }

  /** Returns the object with the settings used for calls to createAnywhereCache. */
  public OperationCallSettings<
          CreateAnywhereCacheRequest, AnywhereCache, CreateAnywhereCacheMetadata>
      createAnywhereCacheOperationSettings() {
    return createAnywhereCacheOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAnywhereCache. */
  public UnaryCallSettings<UpdateAnywhereCacheRequest, Operation> updateAnywhereCacheSettings() {
    return updateAnywhereCacheSettings;
  }

  /** Returns the object with the settings used for calls to updateAnywhereCache. */
  public OperationCallSettings<
          UpdateAnywhereCacheRequest, AnywhereCache, UpdateAnywhereCacheMetadata>
      updateAnywhereCacheOperationSettings() {
    return updateAnywhereCacheOperationSettings;
  }

  /** Returns the object with the settings used for calls to disableAnywhereCache. */
  public UnaryCallSettings<DisableAnywhereCacheRequest, AnywhereCache>
      disableAnywhereCacheSettings() {
    return disableAnywhereCacheSettings;
  }

  /** Returns the object with the settings used for calls to pauseAnywhereCache. */
  public UnaryCallSettings<PauseAnywhereCacheRequest, AnywhereCache> pauseAnywhereCacheSettings() {
    return pauseAnywhereCacheSettings;
  }

  /** Returns the object with the settings used for calls to resumeAnywhereCache. */
  public UnaryCallSettings<ResumeAnywhereCacheRequest, AnywhereCache>
      resumeAnywhereCacheSettings() {
    return resumeAnywhereCacheSettings;
  }

  /** Returns the object with the settings used for calls to getAnywhereCache. */
  public UnaryCallSettings<GetAnywhereCacheRequest, AnywhereCache> getAnywhereCacheSettings() {
    return getAnywhereCacheSettings;
  }

  /** Returns the object with the settings used for calls to listAnywhereCaches. */
  public PagedCallSettings<
          ListAnywhereCachesRequest, ListAnywhereCachesResponse, ListAnywhereCachesPagedResponse>
      listAnywhereCachesSettings() {
    return listAnywhereCachesSettings;
  }

  /** Returns the object with the settings used for calls to getProjectIntelligenceConfig. */
  public UnaryCallSettings<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
      getProjectIntelligenceConfigSettings() {
    return getProjectIntelligenceConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateProjectIntelligenceConfig. */
  public UnaryCallSettings<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
      updateProjectIntelligenceConfigSettings() {
    return updateProjectIntelligenceConfigSettings;
  }

  /** Returns the object with the settings used for calls to getFolderIntelligenceConfig. */
  public UnaryCallSettings<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
      getFolderIntelligenceConfigSettings() {
    return getFolderIntelligenceConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateFolderIntelligenceConfig. */
  public UnaryCallSettings<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
      updateFolderIntelligenceConfigSettings() {
    return updateFolderIntelligenceConfigSettings;
  }

  /** Returns the object with the settings used for calls to getOrganizationIntelligenceConfig. */
  public UnaryCallSettings<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      getOrganizationIntelligenceConfigSettings() {
    return getOrganizationIntelligenceConfigSettings;
  }

  /**
   * Returns the object with the settings used for calls to updateOrganizationIntelligenceConfig.
   */
  public UnaryCallSettings<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      updateOrganizationIntelligenceConfigSettings() {
    return updateOrganizationIntelligenceConfigSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public StorageControlStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcStorageControlStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonStorageControlStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "storage";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "storage.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "storage.mtls.googleapis.com:443";
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
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(StorageControlStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(StorageControlStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return StorageControlStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected StorageControlStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createFolderSettings = settingsBuilder.createFolderSettings().build();
    deleteFolderSettings = settingsBuilder.deleteFolderSettings().build();
    getFolderSettings = settingsBuilder.getFolderSettings().build();
    listFoldersSettings = settingsBuilder.listFoldersSettings().build();
    renameFolderSettings = settingsBuilder.renameFolderSettings().build();
    renameFolderOperationSettings = settingsBuilder.renameFolderOperationSettings().build();
    deleteFolderRecursiveSettings = settingsBuilder.deleteFolderRecursiveSettings().build();
    deleteFolderRecursiveOperationSettings =
        settingsBuilder.deleteFolderRecursiveOperationSettings().build();
    getStorageLayoutSettings = settingsBuilder.getStorageLayoutSettings().build();
    createManagedFolderSettings = settingsBuilder.createManagedFolderSettings().build();
    deleteManagedFolderSettings = settingsBuilder.deleteManagedFolderSettings().build();
    getManagedFolderSettings = settingsBuilder.getManagedFolderSettings().build();
    listManagedFoldersSettings = settingsBuilder.listManagedFoldersSettings().build();
    createAnywhereCacheSettings = settingsBuilder.createAnywhereCacheSettings().build();
    createAnywhereCacheOperationSettings =
        settingsBuilder.createAnywhereCacheOperationSettings().build();
    updateAnywhereCacheSettings = settingsBuilder.updateAnywhereCacheSettings().build();
    updateAnywhereCacheOperationSettings =
        settingsBuilder.updateAnywhereCacheOperationSettings().build();
    disableAnywhereCacheSettings = settingsBuilder.disableAnywhereCacheSettings().build();
    pauseAnywhereCacheSettings = settingsBuilder.pauseAnywhereCacheSettings().build();
    resumeAnywhereCacheSettings = settingsBuilder.resumeAnywhereCacheSettings().build();
    getAnywhereCacheSettings = settingsBuilder.getAnywhereCacheSettings().build();
    listAnywhereCachesSettings = settingsBuilder.listAnywhereCachesSettings().build();
    getProjectIntelligenceConfigSettings =
        settingsBuilder.getProjectIntelligenceConfigSettings().build();
    updateProjectIntelligenceConfigSettings =
        settingsBuilder.updateProjectIntelligenceConfigSettings().build();
    getFolderIntelligenceConfigSettings =
        settingsBuilder.getFolderIntelligenceConfigSettings().build();
    updateFolderIntelligenceConfigSettings =
        settingsBuilder.updateFolderIntelligenceConfigSettings().build();
    getOrganizationIntelligenceConfigSettings =
        settingsBuilder.getOrganizationIntelligenceConfigSettings().build();
    updateOrganizationIntelligenceConfigSettings =
        settingsBuilder.updateOrganizationIntelligenceConfigSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-storage")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for StorageControlStubSettings. */
  public static class Builder extends StubSettings.Builder<StorageControlStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateFolderRequest, Folder> createFolderSettings;
    private final UnaryCallSettings.Builder<DeleteFolderRequest, Empty> deleteFolderSettings;
    private final UnaryCallSettings.Builder<GetFolderRequest, Folder> getFolderSettings;
    private final PagedCallSettings.Builder<
            ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
        listFoldersSettings;
    private final UnaryCallSettings.Builder<RenameFolderRequest, Operation> renameFolderSettings;
    private final OperationCallSettings.Builder<RenameFolderRequest, Folder, RenameFolderMetadata>
        renameFolderOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFolderRecursiveRequest, Operation>
        deleteFolderRecursiveSettings;
    private final OperationCallSettings.Builder<
            DeleteFolderRecursiveRequest, Empty, DeleteFolderRecursiveMetadata>
        deleteFolderRecursiveOperationSettings;
    private final UnaryCallSettings.Builder<GetStorageLayoutRequest, StorageLayout>
        getStorageLayoutSettings;
    private final UnaryCallSettings.Builder<CreateManagedFolderRequest, ManagedFolder>
        createManagedFolderSettings;
    private final UnaryCallSettings.Builder<DeleteManagedFolderRequest, Empty>
        deleteManagedFolderSettings;
    private final UnaryCallSettings.Builder<GetManagedFolderRequest, ManagedFolder>
        getManagedFolderSettings;
    private final PagedCallSettings.Builder<
            ListManagedFoldersRequest, ListManagedFoldersResponse, ListManagedFoldersPagedResponse>
        listManagedFoldersSettings;
    private final UnaryCallSettings.Builder<CreateAnywhereCacheRequest, Operation>
        createAnywhereCacheSettings;
    private final OperationCallSettings.Builder<
            CreateAnywhereCacheRequest, AnywhereCache, CreateAnywhereCacheMetadata>
        createAnywhereCacheOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAnywhereCacheRequest, Operation>
        updateAnywhereCacheSettings;
    private final OperationCallSettings.Builder<
            UpdateAnywhereCacheRequest, AnywhereCache, UpdateAnywhereCacheMetadata>
        updateAnywhereCacheOperationSettings;
    private final UnaryCallSettings.Builder<DisableAnywhereCacheRequest, AnywhereCache>
        disableAnywhereCacheSettings;
    private final UnaryCallSettings.Builder<PauseAnywhereCacheRequest, AnywhereCache>
        pauseAnywhereCacheSettings;
    private final UnaryCallSettings.Builder<ResumeAnywhereCacheRequest, AnywhereCache>
        resumeAnywhereCacheSettings;
    private final UnaryCallSettings.Builder<GetAnywhereCacheRequest, AnywhereCache>
        getAnywhereCacheSettings;
    private final PagedCallSettings.Builder<
            ListAnywhereCachesRequest, ListAnywhereCachesResponse, ListAnywhereCachesPagedResponse>
        listAnywhereCachesSettings;
    private final UnaryCallSettings.Builder<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
        getProjectIntelligenceConfigSettings;
    private final UnaryCallSettings.Builder<
            UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
        updateProjectIntelligenceConfigSettings;
    private final UnaryCallSettings.Builder<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
        getFolderIntelligenceConfigSettings;
    private final UnaryCallSettings.Builder<
            UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
        updateFolderIntelligenceConfigSettings;
    private final UnaryCallSettings.Builder<
            GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
        getOrganizationIntelligenceConfigSettings;
    private final UnaryCallSettings.Builder<
            UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
        updateOrganizationIntelligenceConfigSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.RESOURCE_EXHAUSTED,
                  StatusCode.Code.UNAVAILABLE,
                  StatusCode.Code.DEADLINE_EXCEEDED,
                  StatusCode.Code.INTERNAL,
                  StatusCode.Code.UNKNOWN)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(2.0)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFoldersSettings = PagedCallSettings.newBuilder(LIST_FOLDERS_PAGE_STR_FACT);
      renameFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      renameFolderOperationSettings = OperationCallSettings.newBuilder();
      deleteFolderRecursiveSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFolderRecursiveOperationSettings = OperationCallSettings.newBuilder();
      getStorageLayoutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createManagedFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteManagedFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getManagedFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listManagedFoldersSettings = PagedCallSettings.newBuilder(LIST_MANAGED_FOLDERS_PAGE_STR_FACT);
      createAnywhereCacheSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAnywhereCacheOperationSettings = OperationCallSettings.newBuilder();
      updateAnywhereCacheSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAnywhereCacheOperationSettings = OperationCallSettings.newBuilder();
      disableAnywhereCacheSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      pauseAnywhereCacheSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resumeAnywhereCacheSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAnywhereCacheSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAnywhereCachesSettings = PagedCallSettings.newBuilder(LIST_ANYWHERE_CACHES_PAGE_STR_FACT);
      getProjectIntelligenceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateProjectIntelligenceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getFolderIntelligenceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFolderIntelligenceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getOrganizationIntelligenceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateOrganizationIntelligenceConfigSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createFolderSettings,
              deleteFolderSettings,
              getFolderSettings,
              listFoldersSettings,
              renameFolderSettings,
              deleteFolderRecursiveSettings,
              getStorageLayoutSettings,
              createManagedFolderSettings,
              deleteManagedFolderSettings,
              getManagedFolderSettings,
              listManagedFoldersSettings,
              createAnywhereCacheSettings,
              updateAnywhereCacheSettings,
              disableAnywhereCacheSettings,
              pauseAnywhereCacheSettings,
              resumeAnywhereCacheSettings,
              getAnywhereCacheSettings,
              listAnywhereCachesSettings,
              getProjectIntelligenceConfigSettings,
              updateProjectIntelligenceConfigSettings,
              getFolderIntelligenceConfigSettings,
              updateFolderIntelligenceConfigSettings,
              getOrganizationIntelligenceConfigSettings,
              updateOrganizationIntelligenceConfigSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(StorageControlStubSettings settings) {
      super(settings);

      createFolderSettings = settings.createFolderSettings.toBuilder();
      deleteFolderSettings = settings.deleteFolderSettings.toBuilder();
      getFolderSettings = settings.getFolderSettings.toBuilder();
      listFoldersSettings = settings.listFoldersSettings.toBuilder();
      renameFolderSettings = settings.renameFolderSettings.toBuilder();
      renameFolderOperationSettings = settings.renameFolderOperationSettings.toBuilder();
      deleteFolderRecursiveSettings = settings.deleteFolderRecursiveSettings.toBuilder();
      deleteFolderRecursiveOperationSettings =
          settings.deleteFolderRecursiveOperationSettings.toBuilder();
      getStorageLayoutSettings = settings.getStorageLayoutSettings.toBuilder();
      createManagedFolderSettings = settings.createManagedFolderSettings.toBuilder();
      deleteManagedFolderSettings = settings.deleteManagedFolderSettings.toBuilder();
      getManagedFolderSettings = settings.getManagedFolderSettings.toBuilder();
      listManagedFoldersSettings = settings.listManagedFoldersSettings.toBuilder();
      createAnywhereCacheSettings = settings.createAnywhereCacheSettings.toBuilder();
      createAnywhereCacheOperationSettings =
          settings.createAnywhereCacheOperationSettings.toBuilder();
      updateAnywhereCacheSettings = settings.updateAnywhereCacheSettings.toBuilder();
      updateAnywhereCacheOperationSettings =
          settings.updateAnywhereCacheOperationSettings.toBuilder();
      disableAnywhereCacheSettings = settings.disableAnywhereCacheSettings.toBuilder();
      pauseAnywhereCacheSettings = settings.pauseAnywhereCacheSettings.toBuilder();
      resumeAnywhereCacheSettings = settings.resumeAnywhereCacheSettings.toBuilder();
      getAnywhereCacheSettings = settings.getAnywhereCacheSettings.toBuilder();
      listAnywhereCachesSettings = settings.listAnywhereCachesSettings.toBuilder();
      getProjectIntelligenceConfigSettings =
          settings.getProjectIntelligenceConfigSettings.toBuilder();
      updateProjectIntelligenceConfigSettings =
          settings.updateProjectIntelligenceConfigSettings.toBuilder();
      getFolderIntelligenceConfigSettings =
          settings.getFolderIntelligenceConfigSettings.toBuilder();
      updateFolderIntelligenceConfigSettings =
          settings.updateFolderIntelligenceConfigSettings.toBuilder();
      getOrganizationIntelligenceConfigSettings =
          settings.getOrganizationIntelligenceConfigSettings.toBuilder();
      updateOrganizationIntelligenceConfigSettings =
          settings.updateOrganizationIntelligenceConfigSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createFolderSettings,
              deleteFolderSettings,
              getFolderSettings,
              listFoldersSettings,
              renameFolderSettings,
              deleteFolderRecursiveSettings,
              getStorageLayoutSettings,
              createManagedFolderSettings,
              deleteManagedFolderSettings,
              getManagedFolderSettings,
              listManagedFoldersSettings,
              createAnywhereCacheSettings,
              updateAnywhereCacheSettings,
              disableAnywhereCacheSettings,
              pauseAnywhereCacheSettings,
              resumeAnywhereCacheSettings,
              getAnywhereCacheSettings,
              listAnywhereCachesSettings,
              getProjectIntelligenceConfigSettings,
              updateProjectIntelligenceConfigSettings,
              getFolderIntelligenceConfigSettings,
              updateFolderIntelligenceConfigSettings,
              getOrganizationIntelligenceConfigSettings,
              updateOrganizationIntelligenceConfigSettings,
              getIamPolicySettings,
              setIamPolicySettings,
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
          .createFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listFoldersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .renameFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteFolderRecursiveSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getStorageLayoutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createManagedFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteManagedFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getManagedFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listManagedFoldersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAnywhereCacheSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAnywhereCacheSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .disableAnywhereCacheSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .pauseAnywhereCacheSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .resumeAnywhereCacheSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAnywhereCacheSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAnywhereCachesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getProjectIntelligenceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateProjectIntelligenceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getFolderIntelligenceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateFolderIntelligenceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getOrganizationIntelligenceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateOrganizationIntelligenceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .renameFolderOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RenameFolderRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Folder.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(RenameFolderMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteFolderRecursiveOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFolderRecursiveRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeleteFolderRecursiveMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createAnywhereCacheOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAnywhereCacheRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AnywhereCache.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateAnywhereCacheMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateAnywhereCacheOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAnywhereCacheRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AnywhereCache.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateAnywhereCacheMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to createFolder. */
    public UnaryCallSettings.Builder<CreateFolderRequest, Folder> createFolderSettings() {
      return createFolderSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFolder. */
    public UnaryCallSettings.Builder<DeleteFolderRequest, Empty> deleteFolderSettings() {
      return deleteFolderSettings;
    }

    /** Returns the builder for the settings used for calls to getFolder. */
    public UnaryCallSettings.Builder<GetFolderRequest, Folder> getFolderSettings() {
      return getFolderSettings;
    }

    /** Returns the builder for the settings used for calls to listFolders. */
    public PagedCallSettings.Builder<
            ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
        listFoldersSettings() {
      return listFoldersSettings;
    }

    /** Returns the builder for the settings used for calls to renameFolder. */
    public UnaryCallSettings.Builder<RenameFolderRequest, Operation> renameFolderSettings() {
      return renameFolderSettings;
    }

    /** Returns the builder for the settings used for calls to renameFolder. */
    public OperationCallSettings.Builder<RenameFolderRequest, Folder, RenameFolderMetadata>
        renameFolderOperationSettings() {
      return renameFolderOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFolderRecursive. */
    public UnaryCallSettings.Builder<DeleteFolderRecursiveRequest, Operation>
        deleteFolderRecursiveSettings() {
      return deleteFolderRecursiveSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFolderRecursive. */
    public OperationCallSettings.Builder<
            DeleteFolderRecursiveRequest, Empty, DeleteFolderRecursiveMetadata>
        deleteFolderRecursiveOperationSettings() {
      return deleteFolderRecursiveOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getStorageLayout. */
    public UnaryCallSettings.Builder<GetStorageLayoutRequest, StorageLayout>
        getStorageLayoutSettings() {
      return getStorageLayoutSettings;
    }

    /** Returns the builder for the settings used for calls to createManagedFolder. */
    public UnaryCallSettings.Builder<CreateManagedFolderRequest, ManagedFolder>
        createManagedFolderSettings() {
      return createManagedFolderSettings;
    }

    /** Returns the builder for the settings used for calls to deleteManagedFolder. */
    public UnaryCallSettings.Builder<DeleteManagedFolderRequest, Empty>
        deleteManagedFolderSettings() {
      return deleteManagedFolderSettings;
    }

    /** Returns the builder for the settings used for calls to getManagedFolder. */
    public UnaryCallSettings.Builder<GetManagedFolderRequest, ManagedFolder>
        getManagedFolderSettings() {
      return getManagedFolderSettings;
    }

    /** Returns the builder for the settings used for calls to listManagedFolders. */
    public PagedCallSettings.Builder<
            ListManagedFoldersRequest, ListManagedFoldersResponse, ListManagedFoldersPagedResponse>
        listManagedFoldersSettings() {
      return listManagedFoldersSettings;
    }

    /** Returns the builder for the settings used for calls to createAnywhereCache. */
    public UnaryCallSettings.Builder<CreateAnywhereCacheRequest, Operation>
        createAnywhereCacheSettings() {
      return createAnywhereCacheSettings;
    }

    /** Returns the builder for the settings used for calls to createAnywhereCache. */
    public OperationCallSettings.Builder<
            CreateAnywhereCacheRequest, AnywhereCache, CreateAnywhereCacheMetadata>
        createAnywhereCacheOperationSettings() {
      return createAnywhereCacheOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAnywhereCache. */
    public UnaryCallSettings.Builder<UpdateAnywhereCacheRequest, Operation>
        updateAnywhereCacheSettings() {
      return updateAnywhereCacheSettings;
    }

    /** Returns the builder for the settings used for calls to updateAnywhereCache. */
    public OperationCallSettings.Builder<
            UpdateAnywhereCacheRequest, AnywhereCache, UpdateAnywhereCacheMetadata>
        updateAnywhereCacheOperationSettings() {
      return updateAnywhereCacheOperationSettings;
    }

    /** Returns the builder for the settings used for calls to disableAnywhereCache. */
    public UnaryCallSettings.Builder<DisableAnywhereCacheRequest, AnywhereCache>
        disableAnywhereCacheSettings() {
      return disableAnywhereCacheSettings;
    }

    /** Returns the builder for the settings used for calls to pauseAnywhereCache. */
    public UnaryCallSettings.Builder<PauseAnywhereCacheRequest, AnywhereCache>
        pauseAnywhereCacheSettings() {
      return pauseAnywhereCacheSettings;
    }

    /** Returns the builder for the settings used for calls to resumeAnywhereCache. */
    public UnaryCallSettings.Builder<ResumeAnywhereCacheRequest, AnywhereCache>
        resumeAnywhereCacheSettings() {
      return resumeAnywhereCacheSettings;
    }

    /** Returns the builder for the settings used for calls to getAnywhereCache. */
    public UnaryCallSettings.Builder<GetAnywhereCacheRequest, AnywhereCache>
        getAnywhereCacheSettings() {
      return getAnywhereCacheSettings;
    }

    /** Returns the builder for the settings used for calls to listAnywhereCaches. */
    public PagedCallSettings.Builder<
            ListAnywhereCachesRequest, ListAnywhereCachesResponse, ListAnywhereCachesPagedResponse>
        listAnywhereCachesSettings() {
      return listAnywhereCachesSettings;
    }

    /** Returns the builder for the settings used for calls to getProjectIntelligenceConfig. */
    public UnaryCallSettings.Builder<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
        getProjectIntelligenceConfigSettings() {
      return getProjectIntelligenceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateProjectIntelligenceConfig. */
    public UnaryCallSettings.Builder<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
        updateProjectIntelligenceConfigSettings() {
      return updateProjectIntelligenceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getFolderIntelligenceConfig. */
    public UnaryCallSettings.Builder<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
        getFolderIntelligenceConfigSettings() {
      return getFolderIntelligenceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateFolderIntelligenceConfig. */
    public UnaryCallSettings.Builder<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
        updateFolderIntelligenceConfigSettings() {
      return updateFolderIntelligenceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getOrganizationIntelligenceConfig. */
    public UnaryCallSettings.Builder<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
        getOrganizationIntelligenceConfigSettings() {
      return getOrganizationIntelligenceConfigSettings;
    }

    /**
     * Returns the builder for the settings used for calls to updateOrganizationIntelligenceConfig.
     */
    public UnaryCallSettings.Builder<
            UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
        updateOrganizationIntelligenceConfigSettings() {
      return updateOrganizationIntelligenceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public StorageControlStubSettings build() throws IOException {
      return new StorageControlStubSettings(this);
    }
  }
}
