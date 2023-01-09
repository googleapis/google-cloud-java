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

package com.google.cloud.resourcemanager.v3;

import static com.google.cloud.resourcemanager.v3.FoldersClient.ListFoldersPagedResponse;
import static com.google.cloud.resourcemanager.v3.FoldersClient.SearchFoldersPagedResponse;

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
import com.google.cloud.resourcemanager.v3.stub.FoldersStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FoldersClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudresourcemanager.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getFolder to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FoldersSettings.Builder foldersSettingsBuilder = FoldersSettings.newBuilder();
 * foldersSettingsBuilder
 *     .getFolderSettings()
 *     .setRetrySettings(
 *         foldersSettingsBuilder
 *             .getFolderSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * FoldersSettings foldersSettings = foldersSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class FoldersSettings extends ClientSettings<FoldersSettings> {

  /** Returns the object with the settings used for calls to getFolder. */
  public UnaryCallSettings<GetFolderRequest, Folder> getFolderSettings() {
    return ((FoldersStubSettings) getStubSettings()).getFolderSettings();
  }

  /** Returns the object with the settings used for calls to listFolders. */
  public PagedCallSettings<ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
      listFoldersSettings() {
    return ((FoldersStubSettings) getStubSettings()).listFoldersSettings();
  }

  /** Returns the object with the settings used for calls to searchFolders. */
  public PagedCallSettings<SearchFoldersRequest, SearchFoldersResponse, SearchFoldersPagedResponse>
      searchFoldersSettings() {
    return ((FoldersStubSettings) getStubSettings()).searchFoldersSettings();
  }

  /** Returns the object with the settings used for calls to createFolder. */
  public UnaryCallSettings<CreateFolderRequest, Operation> createFolderSettings() {
    return ((FoldersStubSettings) getStubSettings()).createFolderSettings();
  }

  /** Returns the object with the settings used for calls to createFolder. */
  public OperationCallSettings<CreateFolderRequest, Folder, CreateFolderMetadata>
      createFolderOperationSettings() {
    return ((FoldersStubSettings) getStubSettings()).createFolderOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateFolder. */
  public UnaryCallSettings<UpdateFolderRequest, Operation> updateFolderSettings() {
    return ((FoldersStubSettings) getStubSettings()).updateFolderSettings();
  }

  /** Returns the object with the settings used for calls to updateFolder. */
  public OperationCallSettings<UpdateFolderRequest, Folder, UpdateFolderMetadata>
      updateFolderOperationSettings() {
    return ((FoldersStubSettings) getStubSettings()).updateFolderOperationSettings();
  }

  /** Returns the object with the settings used for calls to moveFolder. */
  public UnaryCallSettings<MoveFolderRequest, Operation> moveFolderSettings() {
    return ((FoldersStubSettings) getStubSettings()).moveFolderSettings();
  }

  /** Returns the object with the settings used for calls to moveFolder. */
  public OperationCallSettings<MoveFolderRequest, Folder, MoveFolderMetadata>
      moveFolderOperationSettings() {
    return ((FoldersStubSettings) getStubSettings()).moveFolderOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFolder. */
  public UnaryCallSettings<DeleteFolderRequest, Operation> deleteFolderSettings() {
    return ((FoldersStubSettings) getStubSettings()).deleteFolderSettings();
  }

  /** Returns the object with the settings used for calls to deleteFolder. */
  public OperationCallSettings<DeleteFolderRequest, Folder, DeleteFolderMetadata>
      deleteFolderOperationSettings() {
    return ((FoldersStubSettings) getStubSettings()).deleteFolderOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeleteFolder. */
  public UnaryCallSettings<UndeleteFolderRequest, Operation> undeleteFolderSettings() {
    return ((FoldersStubSettings) getStubSettings()).undeleteFolderSettings();
  }

  /** Returns the object with the settings used for calls to undeleteFolder. */
  public OperationCallSettings<UndeleteFolderRequest, Folder, UndeleteFolderMetadata>
      undeleteFolderOperationSettings() {
    return ((FoldersStubSettings) getStubSettings()).undeleteFolderOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((FoldersStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((FoldersStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((FoldersStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final FoldersSettings create(FoldersStubSettings stub) throws IOException {
    return new FoldersSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return FoldersStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return FoldersStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return FoldersStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return FoldersStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return FoldersStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return FoldersStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return FoldersStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FoldersStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected FoldersSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for FoldersSettings. */
  public static class Builder extends ClientSettings.Builder<FoldersSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(FoldersStubSettings.newBuilder(clientContext));
    }

    protected Builder(FoldersSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(FoldersStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(FoldersStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(FoldersStubSettings.newHttpJsonBuilder());
    }

    public FoldersStubSettings.Builder getStubSettingsBuilder() {
      return ((FoldersStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to searchFolders. */
    public PagedCallSettings.Builder<
            SearchFoldersRequest, SearchFoldersResponse, SearchFoldersPagedResponse>
        searchFoldersSettings() {
      return getStubSettingsBuilder().searchFoldersSettings();
    }

    /** Returns the builder for the settings used for calls to createFolder. */
    public UnaryCallSettings.Builder<CreateFolderRequest, Operation> createFolderSettings() {
      return getStubSettingsBuilder().createFolderSettings();
    }

    /** Returns the builder for the settings used for calls to createFolder. */
    public OperationCallSettings.Builder<CreateFolderRequest, Folder, CreateFolderMetadata>
        createFolderOperationSettings() {
      return getStubSettingsBuilder().createFolderOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateFolder. */
    public UnaryCallSettings.Builder<UpdateFolderRequest, Operation> updateFolderSettings() {
      return getStubSettingsBuilder().updateFolderSettings();
    }

    /** Returns the builder for the settings used for calls to updateFolder. */
    public OperationCallSettings.Builder<UpdateFolderRequest, Folder, UpdateFolderMetadata>
        updateFolderOperationSettings() {
      return getStubSettingsBuilder().updateFolderOperationSettings();
    }

    /** Returns the builder for the settings used for calls to moveFolder. */
    public UnaryCallSettings.Builder<MoveFolderRequest, Operation> moveFolderSettings() {
      return getStubSettingsBuilder().moveFolderSettings();
    }

    /** Returns the builder for the settings used for calls to moveFolder. */
    public OperationCallSettings.Builder<MoveFolderRequest, Folder, MoveFolderMetadata>
        moveFolderOperationSettings() {
      return getStubSettingsBuilder().moveFolderOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFolder. */
    public UnaryCallSettings.Builder<DeleteFolderRequest, Operation> deleteFolderSettings() {
      return getStubSettingsBuilder().deleteFolderSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFolder. */
    public OperationCallSettings.Builder<DeleteFolderRequest, Folder, DeleteFolderMetadata>
        deleteFolderOperationSettings() {
      return getStubSettingsBuilder().deleteFolderOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteFolder. */
    public UnaryCallSettings.Builder<UndeleteFolderRequest, Operation> undeleteFolderSettings() {
      return getStubSettingsBuilder().undeleteFolderSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteFolder. */
    public OperationCallSettings.Builder<UndeleteFolderRequest, Folder, UndeleteFolderMetadata>
        undeleteFolderOperationSettings() {
      return getStubSettingsBuilder().undeleteFolderOperationSettings();
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
    public FoldersSettings build() throws IOException {
      return new FoldersSettings(this);
    }
  }
}
