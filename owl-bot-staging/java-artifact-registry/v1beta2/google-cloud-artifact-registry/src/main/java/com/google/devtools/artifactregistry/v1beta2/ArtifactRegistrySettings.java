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

package com.google.devtools.artifactregistry.v1beta2;

import static com.google.devtools.artifactregistry.v1beta2.ArtifactRegistryClient.ListFilesPagedResponse;
import static com.google.devtools.artifactregistry.v1beta2.ArtifactRegistryClient.ListPackagesPagedResponse;
import static com.google.devtools.artifactregistry.v1beta2.ArtifactRegistryClient.ListRepositoriesPagedResponse;
import static com.google.devtools.artifactregistry.v1beta2.ArtifactRegistryClient.ListTagsPagedResponse;
import static com.google.devtools.artifactregistry.v1beta2.ArtifactRegistryClient.ListVersionsPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.devtools.artifactregistry.v1beta2.stub.ArtifactRegistryStubSettings;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ArtifactRegistryClient}.
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
 * <p>For example, to set the total timeout of getRepository to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ArtifactRegistrySettings.Builder artifactRegistrySettingsBuilder =
 *     ArtifactRegistrySettings.newBuilder();
 * artifactRegistrySettingsBuilder
 *     .getRepositorySettings()
 *     .setRetrySettings(
 *         artifactRegistrySettingsBuilder.getRepositorySettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ArtifactRegistrySettings artifactRegistrySettings = artifactRegistrySettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ArtifactRegistrySettings extends ClientSettings<ArtifactRegistrySettings> {

  /** Returns the object with the settings used for calls to importAptArtifacts. */
  public UnaryCallSettings<ImportAptArtifactsRequest, Operation> importAptArtifactsSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).importAptArtifactsSettings();
  }

  /** Returns the object with the settings used for calls to importAptArtifacts. */
  public OperationCallSettings<
          ImportAptArtifactsRequest, ImportAptArtifactsResponse, ImportAptArtifactsMetadata>
      importAptArtifactsOperationSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).importAptArtifactsOperationSettings();
  }

  /** Returns the object with the settings used for calls to importYumArtifacts. */
  public UnaryCallSettings<ImportYumArtifactsRequest, Operation> importYumArtifactsSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).importYumArtifactsSettings();
  }

  /** Returns the object with the settings used for calls to importYumArtifacts. */
  public OperationCallSettings<
          ImportYumArtifactsRequest, ImportYumArtifactsResponse, ImportYumArtifactsMetadata>
      importYumArtifactsOperationSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).importYumArtifactsOperationSettings();
  }

  /** Returns the object with the settings used for calls to listRepositories. */
  public PagedCallSettings<
          ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
      listRepositoriesSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).listRepositoriesSettings();
  }

  /** Returns the object with the settings used for calls to getRepository. */
  public UnaryCallSettings<GetRepositoryRequest, Repository> getRepositorySettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).getRepositorySettings();
  }

  /** Returns the object with the settings used for calls to createRepository. */
  public UnaryCallSettings<CreateRepositoryRequest, Operation> createRepositorySettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).createRepositorySettings();
  }

  /** Returns the object with the settings used for calls to createRepository. */
  public OperationCallSettings<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).createRepositoryOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateRepository. */
  public UnaryCallSettings<UpdateRepositoryRequest, Repository> updateRepositorySettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).updateRepositorySettings();
  }

  /** Returns the object with the settings used for calls to deleteRepository. */
  public UnaryCallSettings<DeleteRepositoryRequest, Operation> deleteRepositorySettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).deleteRepositorySettings();
  }

  /** Returns the object with the settings used for calls to deleteRepository. */
  public OperationCallSettings<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).deleteRepositoryOperationSettings();
  }

  /** Returns the object with the settings used for calls to listPackages. */
  public PagedCallSettings<ListPackagesRequest, ListPackagesResponse, ListPackagesPagedResponse>
      listPackagesSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).listPackagesSettings();
  }

  /** Returns the object with the settings used for calls to getPackage. */
  public UnaryCallSettings<GetPackageRequest, Package> getPackageSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).getPackageSettings();
  }

  /** Returns the object with the settings used for calls to deletePackage. */
  public UnaryCallSettings<DeletePackageRequest, Operation> deletePackageSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).deletePackageSettings();
  }

  /** Returns the object with the settings used for calls to deletePackage. */
  public OperationCallSettings<DeletePackageRequest, Empty, OperationMetadata>
      deletePackageOperationSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).deletePackageOperationSettings();
  }

  /** Returns the object with the settings used for calls to listVersions. */
  public PagedCallSettings<ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
      listVersionsSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).listVersionsSettings();
  }

  /** Returns the object with the settings used for calls to getVersion. */
  public UnaryCallSettings<GetVersionRequest, Version> getVersionSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).getVersionSettings();
  }

  /** Returns the object with the settings used for calls to deleteVersion. */
  public UnaryCallSettings<DeleteVersionRequest, Operation> deleteVersionSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).deleteVersionSettings();
  }

  /** Returns the object with the settings used for calls to deleteVersion. */
  public OperationCallSettings<DeleteVersionRequest, Empty, OperationMetadata>
      deleteVersionOperationSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).deleteVersionOperationSettings();
  }

  /** Returns the object with the settings used for calls to listFiles. */
  public PagedCallSettings<ListFilesRequest, ListFilesResponse, ListFilesPagedResponse>
      listFilesSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).listFilesSettings();
  }

  /** Returns the object with the settings used for calls to getFile. */
  public UnaryCallSettings<GetFileRequest, File> getFileSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).getFileSettings();
  }

  /** Returns the object with the settings used for calls to listTags. */
  public PagedCallSettings<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
      listTagsSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).listTagsSettings();
  }

  /** Returns the object with the settings used for calls to getTag. */
  public UnaryCallSettings<GetTagRequest, Tag> getTagSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).getTagSettings();
  }

  /** Returns the object with the settings used for calls to createTag. */
  public UnaryCallSettings<CreateTagRequest, Tag> createTagSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).createTagSettings();
  }

  /** Returns the object with the settings used for calls to updateTag. */
  public UnaryCallSettings<UpdateTagRequest, Tag> updateTagSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).updateTagSettings();
  }

  /** Returns the object with the settings used for calls to deleteTag. */
  public UnaryCallSettings<DeleteTagRequest, Empty> deleteTagSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).deleteTagSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  /** Returns the object with the settings used for calls to getProjectSettings. */
  public UnaryCallSettings<GetProjectSettingsRequest, ProjectSettings>
      getProjectSettingsSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).getProjectSettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateProjectSettings. */
  public UnaryCallSettings<UpdateProjectSettingsRequest, ProjectSettings>
      updateProjectSettingsSettings() {
    return ((ArtifactRegistryStubSettings) getStubSettings()).updateProjectSettingsSettings();
  }

  public static final ArtifactRegistrySettings create(ArtifactRegistryStubSettings stub)
      throws IOException {
    return new ArtifactRegistrySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ArtifactRegistryStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ArtifactRegistryStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ArtifactRegistryStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ArtifactRegistryStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ArtifactRegistryStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ArtifactRegistryStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ArtifactRegistryStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ArtifactRegistryStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ArtifactRegistrySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ArtifactRegistrySettings. */
  public static class Builder extends ClientSettings.Builder<ArtifactRegistrySettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ArtifactRegistryStubSettings.newBuilder(clientContext));
    }

    protected Builder(ArtifactRegistrySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ArtifactRegistryStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ArtifactRegistryStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ArtifactRegistryStubSettings.newHttpJsonBuilder());
    }

    public ArtifactRegistryStubSettings.Builder getStubSettingsBuilder() {
      return ((ArtifactRegistryStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to importAptArtifacts. */
    public UnaryCallSettings.Builder<ImportAptArtifactsRequest, Operation>
        importAptArtifactsSettings() {
      return getStubSettingsBuilder().importAptArtifactsSettings();
    }

    /** Returns the builder for the settings used for calls to importAptArtifacts. */
    public OperationCallSettings.Builder<
            ImportAptArtifactsRequest, ImportAptArtifactsResponse, ImportAptArtifactsMetadata>
        importAptArtifactsOperationSettings() {
      return getStubSettingsBuilder().importAptArtifactsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importYumArtifacts. */
    public UnaryCallSettings.Builder<ImportYumArtifactsRequest, Operation>
        importYumArtifactsSettings() {
      return getStubSettingsBuilder().importYumArtifactsSettings();
    }

    /** Returns the builder for the settings used for calls to importYumArtifacts. */
    public OperationCallSettings.Builder<
            ImportYumArtifactsRequest, ImportYumArtifactsResponse, ImportYumArtifactsMetadata>
        importYumArtifactsOperationSettings() {
      return getStubSettingsBuilder().importYumArtifactsOperationSettings();
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
    public UnaryCallSettings.Builder<CreateRepositoryRequest, Operation>
        createRepositorySettings() {
      return getStubSettingsBuilder().createRepositorySettings();
    }

    /** Returns the builder for the settings used for calls to createRepository. */
    public OperationCallSettings.Builder<CreateRepositoryRequest, Repository, OperationMetadata>
        createRepositoryOperationSettings() {
      return getStubSettingsBuilder().createRepositoryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateRepository. */
    public UnaryCallSettings.Builder<UpdateRepositoryRequest, Repository>
        updateRepositorySettings() {
      return getStubSettingsBuilder().updateRepositorySettings();
    }

    /** Returns the builder for the settings used for calls to deleteRepository. */
    public UnaryCallSettings.Builder<DeleteRepositoryRequest, Operation>
        deleteRepositorySettings() {
      return getStubSettingsBuilder().deleteRepositorySettings();
    }

    /** Returns the builder for the settings used for calls to deleteRepository. */
    public OperationCallSettings.Builder<DeleteRepositoryRequest, Empty, OperationMetadata>
        deleteRepositoryOperationSettings() {
      return getStubSettingsBuilder().deleteRepositoryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listPackages. */
    public PagedCallSettings.Builder<
            ListPackagesRequest, ListPackagesResponse, ListPackagesPagedResponse>
        listPackagesSettings() {
      return getStubSettingsBuilder().listPackagesSettings();
    }

    /** Returns the builder for the settings used for calls to getPackage. */
    public UnaryCallSettings.Builder<GetPackageRequest, Package> getPackageSettings() {
      return getStubSettingsBuilder().getPackageSettings();
    }

    /** Returns the builder for the settings used for calls to deletePackage. */
    public UnaryCallSettings.Builder<DeletePackageRequest, Operation> deletePackageSettings() {
      return getStubSettingsBuilder().deletePackageSettings();
    }

    /** Returns the builder for the settings used for calls to deletePackage. */
    public OperationCallSettings.Builder<DeletePackageRequest, Empty, OperationMetadata>
        deletePackageOperationSettings() {
      return getStubSettingsBuilder().deletePackageOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listVersions. */
    public PagedCallSettings.Builder<
            ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
        listVersionsSettings() {
      return getStubSettingsBuilder().listVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to getVersion. */
    public UnaryCallSettings.Builder<GetVersionRequest, Version> getVersionSettings() {
      return getStubSettingsBuilder().getVersionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVersion. */
    public UnaryCallSettings.Builder<DeleteVersionRequest, Operation> deleteVersionSettings() {
      return getStubSettingsBuilder().deleteVersionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVersion. */
    public OperationCallSettings.Builder<DeleteVersionRequest, Empty, OperationMetadata>
        deleteVersionOperationSettings() {
      return getStubSettingsBuilder().deleteVersionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listFiles. */
    public PagedCallSettings.Builder<ListFilesRequest, ListFilesResponse, ListFilesPagedResponse>
        listFilesSettings() {
      return getStubSettingsBuilder().listFilesSettings();
    }

    /** Returns the builder for the settings used for calls to getFile. */
    public UnaryCallSettings.Builder<GetFileRequest, File> getFileSettings() {
      return getStubSettingsBuilder().getFileSettings();
    }

    /** Returns the builder for the settings used for calls to listTags. */
    public PagedCallSettings.Builder<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
        listTagsSettings() {
      return getStubSettingsBuilder().listTagsSettings();
    }

    /** Returns the builder for the settings used for calls to getTag. */
    public UnaryCallSettings.Builder<GetTagRequest, Tag> getTagSettings() {
      return getStubSettingsBuilder().getTagSettings();
    }

    /** Returns the builder for the settings used for calls to createTag. */
    public UnaryCallSettings.Builder<CreateTagRequest, Tag> createTagSettings() {
      return getStubSettingsBuilder().createTagSettings();
    }

    /** Returns the builder for the settings used for calls to updateTag. */
    public UnaryCallSettings.Builder<UpdateTagRequest, Tag> updateTagSettings() {
      return getStubSettingsBuilder().updateTagSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTag. */
    public UnaryCallSettings.Builder<DeleteTagRequest, Empty> deleteTagSettings() {
      return getStubSettingsBuilder().deleteTagSettings();
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

    /** Returns the builder for the settings used for calls to getProjectSettings. */
    public UnaryCallSettings.Builder<GetProjectSettingsRequest, ProjectSettings>
        getProjectSettingsSettings() {
      return getStubSettingsBuilder().getProjectSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateProjectSettings. */
    public UnaryCallSettings.Builder<UpdateProjectSettingsRequest, ProjectSettings>
        updateProjectSettingsSettings() {
      return getStubSettingsBuilder().updateProjectSettingsSettings();
    }

    @Override
    public ArtifactRegistrySettings build() throws IOException {
      return new ArtifactRegistrySettings(this);
    }
  }
}
