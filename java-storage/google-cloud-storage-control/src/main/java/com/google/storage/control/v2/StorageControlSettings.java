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

package com.google.storage.control.v2;

import static com.google.storage.control.v2.StorageControlClient.ListAnywhereCachesPagedResponse;
import static com.google.storage.control.v2.StorageControlClient.ListFoldersPagedResponse;
import static com.google.storage.control.v2.StorageControlClient.ListManagedFoldersPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.storage.control.v2.stub.StorageControlStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link StorageControlClient}.
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
 * StorageControlSettings.Builder storageControlSettingsBuilder =
 *     StorageControlSettings.newBuilder();
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
 * StorageControlSettings storageControlSettings = storageControlSettingsBuilder.build();
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
 * StorageControlSettings.Builder storageControlSettingsBuilder =
 *     StorageControlSettings.newBuilder();
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
public class StorageControlSettings extends ClientSettings<StorageControlSettings> {

  /** Returns the object with the settings used for calls to createFolder. */
  public UnaryCallSettings<CreateFolderRequest, Folder> createFolderSettings() {
    return ((StorageControlStubSettings) getStubSettings()).createFolderSettings();
  }

  /** Returns the object with the settings used for calls to deleteFolder. */
  public UnaryCallSettings<DeleteFolderRequest, Empty> deleteFolderSettings() {
    return ((StorageControlStubSettings) getStubSettings()).deleteFolderSettings();
  }

  /** Returns the object with the settings used for calls to getFolder. */
  public UnaryCallSettings<GetFolderRequest, Folder> getFolderSettings() {
    return ((StorageControlStubSettings) getStubSettings()).getFolderSettings();
  }

  /** Returns the object with the settings used for calls to listFolders. */
  public PagedCallSettings<ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
      listFoldersSettings() {
    return ((StorageControlStubSettings) getStubSettings()).listFoldersSettings();
  }

  /** Returns the object with the settings used for calls to renameFolder. */
  public UnaryCallSettings<RenameFolderRequest, Operation> renameFolderSettings() {
    return ((StorageControlStubSettings) getStubSettings()).renameFolderSettings();
  }

  /** Returns the object with the settings used for calls to renameFolder. */
  public OperationCallSettings<RenameFolderRequest, Folder, RenameFolderMetadata>
      renameFolderOperationSettings() {
    return ((StorageControlStubSettings) getStubSettings()).renameFolderOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFolderRecursive. */
  public UnaryCallSettings<DeleteFolderRecursiveRequest, Operation>
      deleteFolderRecursiveSettings() {
    return ((StorageControlStubSettings) getStubSettings()).deleteFolderRecursiveSettings();
  }

  /** Returns the object with the settings used for calls to deleteFolderRecursive. */
  public OperationCallSettings<DeleteFolderRecursiveRequest, Empty, DeleteFolderRecursiveMetadata>
      deleteFolderRecursiveOperationSettings() {
    return ((StorageControlStubSettings) getStubSettings())
        .deleteFolderRecursiveOperationSettings();
  }

  /** Returns the object with the settings used for calls to getStorageLayout. */
  public UnaryCallSettings<GetStorageLayoutRequest, StorageLayout> getStorageLayoutSettings() {
    return ((StorageControlStubSettings) getStubSettings()).getStorageLayoutSettings();
  }

  /** Returns the object with the settings used for calls to createManagedFolder. */
  public UnaryCallSettings<CreateManagedFolderRequest, ManagedFolder>
      createManagedFolderSettings() {
    return ((StorageControlStubSettings) getStubSettings()).createManagedFolderSettings();
  }

  /** Returns the object with the settings used for calls to deleteManagedFolder. */
  public UnaryCallSettings<DeleteManagedFolderRequest, Empty> deleteManagedFolderSettings() {
    return ((StorageControlStubSettings) getStubSettings()).deleteManagedFolderSettings();
  }

  /** Returns the object with the settings used for calls to getManagedFolder. */
  public UnaryCallSettings<GetManagedFolderRequest, ManagedFolder> getManagedFolderSettings() {
    return ((StorageControlStubSettings) getStubSettings()).getManagedFolderSettings();
  }

  /** Returns the object with the settings used for calls to listManagedFolders. */
  public PagedCallSettings<
          ListManagedFoldersRequest, ListManagedFoldersResponse, ListManagedFoldersPagedResponse>
      listManagedFoldersSettings() {
    return ((StorageControlStubSettings) getStubSettings()).listManagedFoldersSettings();
  }

  /** Returns the object with the settings used for calls to createAnywhereCache. */
  public UnaryCallSettings<CreateAnywhereCacheRequest, Operation> createAnywhereCacheSettings() {
    return ((StorageControlStubSettings) getStubSettings()).createAnywhereCacheSettings();
  }

  /** Returns the object with the settings used for calls to createAnywhereCache. */
  public OperationCallSettings<
          CreateAnywhereCacheRequest, AnywhereCache, CreateAnywhereCacheMetadata>
      createAnywhereCacheOperationSettings() {
    return ((StorageControlStubSettings) getStubSettings()).createAnywhereCacheOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAnywhereCache. */
  public UnaryCallSettings<UpdateAnywhereCacheRequest, Operation> updateAnywhereCacheSettings() {
    return ((StorageControlStubSettings) getStubSettings()).updateAnywhereCacheSettings();
  }

  /** Returns the object with the settings used for calls to updateAnywhereCache. */
  public OperationCallSettings<
          UpdateAnywhereCacheRequest, AnywhereCache, UpdateAnywhereCacheMetadata>
      updateAnywhereCacheOperationSettings() {
    return ((StorageControlStubSettings) getStubSettings()).updateAnywhereCacheOperationSettings();
  }

  /** Returns the object with the settings used for calls to disableAnywhereCache. */
  public UnaryCallSettings<DisableAnywhereCacheRequest, AnywhereCache>
      disableAnywhereCacheSettings() {
    return ((StorageControlStubSettings) getStubSettings()).disableAnywhereCacheSettings();
  }

  /** Returns the object with the settings used for calls to pauseAnywhereCache. */
  public UnaryCallSettings<PauseAnywhereCacheRequest, AnywhereCache> pauseAnywhereCacheSettings() {
    return ((StorageControlStubSettings) getStubSettings()).pauseAnywhereCacheSettings();
  }

  /** Returns the object with the settings used for calls to resumeAnywhereCache. */
  public UnaryCallSettings<ResumeAnywhereCacheRequest, AnywhereCache>
      resumeAnywhereCacheSettings() {
    return ((StorageControlStubSettings) getStubSettings()).resumeAnywhereCacheSettings();
  }

  /** Returns the object with the settings used for calls to getAnywhereCache. */
  public UnaryCallSettings<GetAnywhereCacheRequest, AnywhereCache> getAnywhereCacheSettings() {
    return ((StorageControlStubSettings) getStubSettings()).getAnywhereCacheSettings();
  }

  /** Returns the object with the settings used for calls to listAnywhereCaches. */
  public PagedCallSettings<
          ListAnywhereCachesRequest, ListAnywhereCachesResponse, ListAnywhereCachesPagedResponse>
      listAnywhereCachesSettings() {
    return ((StorageControlStubSettings) getStubSettings()).listAnywhereCachesSettings();
  }

  /** Returns the object with the settings used for calls to getProjectIntelligenceConfig. */
  public UnaryCallSettings<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
      getProjectIntelligenceConfigSettings() {
    return ((StorageControlStubSettings) getStubSettings()).getProjectIntelligenceConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateProjectIntelligenceConfig. */
  public UnaryCallSettings<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
      updateProjectIntelligenceConfigSettings() {
    return ((StorageControlStubSettings) getStubSettings())
        .updateProjectIntelligenceConfigSettings();
  }

  /** Returns the object with the settings used for calls to getFolderIntelligenceConfig. */
  public UnaryCallSettings<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
      getFolderIntelligenceConfigSettings() {
    return ((StorageControlStubSettings) getStubSettings()).getFolderIntelligenceConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateFolderIntelligenceConfig. */
  public UnaryCallSettings<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
      updateFolderIntelligenceConfigSettings() {
    return ((StorageControlStubSettings) getStubSettings())
        .updateFolderIntelligenceConfigSettings();
  }

  /** Returns the object with the settings used for calls to getOrganizationIntelligenceConfig. */
  public UnaryCallSettings<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      getOrganizationIntelligenceConfigSettings() {
    return ((StorageControlStubSettings) getStubSettings())
        .getOrganizationIntelligenceConfigSettings();
  }

  /**
   * Returns the object with the settings used for calls to updateOrganizationIntelligenceConfig.
   */
  public UnaryCallSettings<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      updateOrganizationIntelligenceConfigSettings() {
    return ((StorageControlStubSettings) getStubSettings())
        .updateOrganizationIntelligenceConfigSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((StorageControlStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((StorageControlStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((StorageControlStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final StorageControlSettings create(StorageControlStubSettings stub)
      throws IOException {
    return new StorageControlSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return StorageControlStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return StorageControlStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return StorageControlStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return StorageControlStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return StorageControlStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return StorageControlStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return StorageControlStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return StorageControlStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected StorageControlSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for StorageControlSettings. */
  public static class Builder extends ClientSettings.Builder<StorageControlSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(StorageControlStubSettings.newBuilder(clientContext));
    }

    protected Builder(StorageControlSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(StorageControlStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(StorageControlStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(StorageControlStubSettings.newHttpJsonBuilder());
    }

    public StorageControlStubSettings.Builder getStubSettingsBuilder() {
      return ((StorageControlStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createFolder. */
    public UnaryCallSettings.Builder<CreateFolderRequest, Folder> createFolderSettings() {
      return getStubSettingsBuilder().createFolderSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFolder. */
    public UnaryCallSettings.Builder<DeleteFolderRequest, Empty> deleteFolderSettings() {
      return getStubSettingsBuilder().deleteFolderSettings();
    }

    /** Returns the builder for the settings used for calls to getFolder. */
    public UnaryCallSettings.Builder<GetFolderRequest, Folder> getFolderSettings() {
      return getStubSettingsBuilder().getFolderSettings();
    }

    /** Returns the builder for the settings used for calls to listFolders. */
    public PagedCallSettings.Builder<
            ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
        listFoldersSettings() {
      return getStubSettingsBuilder().listFoldersSettings();
    }

    /** Returns the builder for the settings used for calls to renameFolder. */
    public UnaryCallSettings.Builder<RenameFolderRequest, Operation> renameFolderSettings() {
      return getStubSettingsBuilder().renameFolderSettings();
    }

    /** Returns the builder for the settings used for calls to renameFolder. */
    public OperationCallSettings.Builder<RenameFolderRequest, Folder, RenameFolderMetadata>
        renameFolderOperationSettings() {
      return getStubSettingsBuilder().renameFolderOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFolderRecursive. */
    public UnaryCallSettings.Builder<DeleteFolderRecursiveRequest, Operation>
        deleteFolderRecursiveSettings() {
      return getStubSettingsBuilder().deleteFolderRecursiveSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFolderRecursive. */
    public OperationCallSettings.Builder<
            DeleteFolderRecursiveRequest, Empty, DeleteFolderRecursiveMetadata>
        deleteFolderRecursiveOperationSettings() {
      return getStubSettingsBuilder().deleteFolderRecursiveOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getStorageLayout. */
    public UnaryCallSettings.Builder<GetStorageLayoutRequest, StorageLayout>
        getStorageLayoutSettings() {
      return getStubSettingsBuilder().getStorageLayoutSettings();
    }

    /** Returns the builder for the settings used for calls to createManagedFolder. */
    public UnaryCallSettings.Builder<CreateManagedFolderRequest, ManagedFolder>
        createManagedFolderSettings() {
      return getStubSettingsBuilder().createManagedFolderSettings();
    }

    /** Returns the builder for the settings used for calls to deleteManagedFolder. */
    public UnaryCallSettings.Builder<DeleteManagedFolderRequest, Empty>
        deleteManagedFolderSettings() {
      return getStubSettingsBuilder().deleteManagedFolderSettings();
    }

    /** Returns the builder for the settings used for calls to getManagedFolder. */
    public UnaryCallSettings.Builder<GetManagedFolderRequest, ManagedFolder>
        getManagedFolderSettings() {
      return getStubSettingsBuilder().getManagedFolderSettings();
    }

    /** Returns the builder for the settings used for calls to listManagedFolders. */
    public PagedCallSettings.Builder<
            ListManagedFoldersRequest, ListManagedFoldersResponse, ListManagedFoldersPagedResponse>
        listManagedFoldersSettings() {
      return getStubSettingsBuilder().listManagedFoldersSettings();
    }

    /** Returns the builder for the settings used for calls to createAnywhereCache. */
    public UnaryCallSettings.Builder<CreateAnywhereCacheRequest, Operation>
        createAnywhereCacheSettings() {
      return getStubSettingsBuilder().createAnywhereCacheSettings();
    }

    /** Returns the builder for the settings used for calls to createAnywhereCache. */
    public OperationCallSettings.Builder<
            CreateAnywhereCacheRequest, AnywhereCache, CreateAnywhereCacheMetadata>
        createAnywhereCacheOperationSettings() {
      return getStubSettingsBuilder().createAnywhereCacheOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAnywhereCache. */
    public UnaryCallSettings.Builder<UpdateAnywhereCacheRequest, Operation>
        updateAnywhereCacheSettings() {
      return getStubSettingsBuilder().updateAnywhereCacheSettings();
    }

    /** Returns the builder for the settings used for calls to updateAnywhereCache. */
    public OperationCallSettings.Builder<
            UpdateAnywhereCacheRequest, AnywhereCache, UpdateAnywhereCacheMetadata>
        updateAnywhereCacheOperationSettings() {
      return getStubSettingsBuilder().updateAnywhereCacheOperationSettings();
    }

    /** Returns the builder for the settings used for calls to disableAnywhereCache. */
    public UnaryCallSettings.Builder<DisableAnywhereCacheRequest, AnywhereCache>
        disableAnywhereCacheSettings() {
      return getStubSettingsBuilder().disableAnywhereCacheSettings();
    }

    /** Returns the builder for the settings used for calls to pauseAnywhereCache. */
    public UnaryCallSettings.Builder<PauseAnywhereCacheRequest, AnywhereCache>
        pauseAnywhereCacheSettings() {
      return getStubSettingsBuilder().pauseAnywhereCacheSettings();
    }

    /** Returns the builder for the settings used for calls to resumeAnywhereCache. */
    public UnaryCallSettings.Builder<ResumeAnywhereCacheRequest, AnywhereCache>
        resumeAnywhereCacheSettings() {
      return getStubSettingsBuilder().resumeAnywhereCacheSettings();
    }

    /** Returns the builder for the settings used for calls to getAnywhereCache. */
    public UnaryCallSettings.Builder<GetAnywhereCacheRequest, AnywhereCache>
        getAnywhereCacheSettings() {
      return getStubSettingsBuilder().getAnywhereCacheSettings();
    }

    /** Returns the builder for the settings used for calls to listAnywhereCaches. */
    public PagedCallSettings.Builder<
            ListAnywhereCachesRequest, ListAnywhereCachesResponse, ListAnywhereCachesPagedResponse>
        listAnywhereCachesSettings() {
      return getStubSettingsBuilder().listAnywhereCachesSettings();
    }

    /** Returns the builder for the settings used for calls to getProjectIntelligenceConfig. */
    public UnaryCallSettings.Builder<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
        getProjectIntelligenceConfigSettings() {
      return getStubSettingsBuilder().getProjectIntelligenceConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateProjectIntelligenceConfig. */
    public UnaryCallSettings.Builder<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
        updateProjectIntelligenceConfigSettings() {
      return getStubSettingsBuilder().updateProjectIntelligenceConfigSettings();
    }

    /** Returns the builder for the settings used for calls to getFolderIntelligenceConfig. */
    public UnaryCallSettings.Builder<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
        getFolderIntelligenceConfigSettings() {
      return getStubSettingsBuilder().getFolderIntelligenceConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateFolderIntelligenceConfig. */
    public UnaryCallSettings.Builder<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
        updateFolderIntelligenceConfigSettings() {
      return getStubSettingsBuilder().updateFolderIntelligenceConfigSettings();
    }

    /** Returns the builder for the settings used for calls to getOrganizationIntelligenceConfig. */
    public UnaryCallSettings.Builder<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
        getOrganizationIntelligenceConfigSettings() {
      return getStubSettingsBuilder().getOrganizationIntelligenceConfigSettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateOrganizationIntelligenceConfig.
     */
    public UnaryCallSettings.Builder<
            UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
        updateOrganizationIntelligenceConfigSettings() {
      return getStubSettingsBuilder().updateOrganizationIntelligenceConfigSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public StorageControlSettings build() throws IOException {
      return new StorageControlSettings(this);
    }
  }
}
