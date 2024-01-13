/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.config.v1;

import static com.google.cloud.config.v1.ConfigClient.ListDeploymentsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListLocationsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListPreviewsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListResourcesPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListRevisionsPagedResponse;

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
import com.google.cloud.config.v1.stub.ConfigStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link ConfigClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (config.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDeployment to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConfigSettings.Builder configSettingsBuilder = ConfigSettings.newBuilder();
 * configSettingsBuilder
 *     .getDeploymentSettings()
 *     .setRetrySettings(
 *         configSettingsBuilder
 *             .getDeploymentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConfigSettings configSettings = configSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ConfigSettings extends ClientSettings<ConfigSettings> {

  /** Returns the object with the settings used for calls to listDeployments. */
  public PagedCallSettings<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      listDeploymentsSettings() {
    return ((ConfigStubSettings) getStubSettings()).listDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to getDeployment. */
  public UnaryCallSettings<GetDeploymentRequest, Deployment> getDeploymentSettings() {
    return ((ConfigStubSettings) getStubSettings()).getDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to createDeployment. */
  public UnaryCallSettings<CreateDeploymentRequest, Operation> createDeploymentSettings() {
    return ((ConfigStubSettings) getStubSettings()).createDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to createDeployment. */
  public OperationCallSettings<CreateDeploymentRequest, Deployment, OperationMetadata>
      createDeploymentOperationSettings() {
    return ((ConfigStubSettings) getStubSettings()).createDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDeployment. */
  public UnaryCallSettings<UpdateDeploymentRequest, Operation> updateDeploymentSettings() {
    return ((ConfigStubSettings) getStubSettings()).updateDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to updateDeployment. */
  public OperationCallSettings<UpdateDeploymentRequest, Deployment, OperationMetadata>
      updateDeploymentOperationSettings() {
    return ((ConfigStubSettings) getStubSettings()).updateDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDeployment. */
  public UnaryCallSettings<DeleteDeploymentRequest, Operation> deleteDeploymentSettings() {
    return ((ConfigStubSettings) getStubSettings()).deleteDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to deleteDeployment. */
  public OperationCallSettings<DeleteDeploymentRequest, Deployment, OperationMetadata>
      deleteDeploymentOperationSettings() {
    return ((ConfigStubSettings) getStubSettings()).deleteDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to listRevisions. */
  public PagedCallSettings<ListRevisionsRequest, ListRevisionsResponse, ListRevisionsPagedResponse>
      listRevisionsSettings() {
    return ((ConfigStubSettings) getStubSettings()).listRevisionsSettings();
  }

  /** Returns the object with the settings used for calls to getRevision. */
  public UnaryCallSettings<GetRevisionRequest, Revision> getRevisionSettings() {
    return ((ConfigStubSettings) getStubSettings()).getRevisionSettings();
  }

  /** Returns the object with the settings used for calls to getResource. */
  public UnaryCallSettings<GetResourceRequest, Resource> getResourceSettings() {
    return ((ConfigStubSettings) getStubSettings()).getResourceSettings();
  }

  /** Returns the object with the settings used for calls to listResources. */
  public PagedCallSettings<ListResourcesRequest, ListResourcesResponse, ListResourcesPagedResponse>
      listResourcesSettings() {
    return ((ConfigStubSettings) getStubSettings()).listResourcesSettings();
  }

  /** Returns the object with the settings used for calls to exportDeploymentStatefile. */
  public UnaryCallSettings<ExportDeploymentStatefileRequest, Statefile>
      exportDeploymentStatefileSettings() {
    return ((ConfigStubSettings) getStubSettings()).exportDeploymentStatefileSettings();
  }

  /** Returns the object with the settings used for calls to exportRevisionStatefile. */
  public UnaryCallSettings<ExportRevisionStatefileRequest, Statefile>
      exportRevisionStatefileSettings() {
    return ((ConfigStubSettings) getStubSettings()).exportRevisionStatefileSettings();
  }

  /** Returns the object with the settings used for calls to importStatefile. */
  public UnaryCallSettings<ImportStatefileRequest, Statefile> importStatefileSettings() {
    return ((ConfigStubSettings) getStubSettings()).importStatefileSettings();
  }

  /** Returns the object with the settings used for calls to deleteStatefile. */
  public UnaryCallSettings<DeleteStatefileRequest, Empty> deleteStatefileSettings() {
    return ((ConfigStubSettings) getStubSettings()).deleteStatefileSettings();
  }

  /** Returns the object with the settings used for calls to lockDeployment. */
  public UnaryCallSettings<LockDeploymentRequest, Operation> lockDeploymentSettings() {
    return ((ConfigStubSettings) getStubSettings()).lockDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to lockDeployment. */
  public OperationCallSettings<LockDeploymentRequest, Deployment, OperationMetadata>
      lockDeploymentOperationSettings() {
    return ((ConfigStubSettings) getStubSettings()).lockDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to unlockDeployment. */
  public UnaryCallSettings<UnlockDeploymentRequest, Operation> unlockDeploymentSettings() {
    return ((ConfigStubSettings) getStubSettings()).unlockDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to unlockDeployment. */
  public OperationCallSettings<UnlockDeploymentRequest, Deployment, OperationMetadata>
      unlockDeploymentOperationSettings() {
    return ((ConfigStubSettings) getStubSettings()).unlockDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportLockInfo. */
  public UnaryCallSettings<ExportLockInfoRequest, LockInfo> exportLockInfoSettings() {
    return ((ConfigStubSettings) getStubSettings()).exportLockInfoSettings();
  }

  /** Returns the object with the settings used for calls to createPreview. */
  public UnaryCallSettings<CreatePreviewRequest, Operation> createPreviewSettings() {
    return ((ConfigStubSettings) getStubSettings()).createPreviewSettings();
  }

  /** Returns the object with the settings used for calls to createPreview. */
  public OperationCallSettings<CreatePreviewRequest, Preview, OperationMetadata>
      createPreviewOperationSettings() {
    return ((ConfigStubSettings) getStubSettings()).createPreviewOperationSettings();
  }

  /** Returns the object with the settings used for calls to getPreview. */
  public UnaryCallSettings<GetPreviewRequest, Preview> getPreviewSettings() {
    return ((ConfigStubSettings) getStubSettings()).getPreviewSettings();
  }

  /** Returns the object with the settings used for calls to listPreviews. */
  public PagedCallSettings<ListPreviewsRequest, ListPreviewsResponse, ListPreviewsPagedResponse>
      listPreviewsSettings() {
    return ((ConfigStubSettings) getStubSettings()).listPreviewsSettings();
  }

  /** Returns the object with the settings used for calls to deletePreview. */
  public UnaryCallSettings<DeletePreviewRequest, Operation> deletePreviewSettings() {
    return ((ConfigStubSettings) getStubSettings()).deletePreviewSettings();
  }

  /** Returns the object with the settings used for calls to deletePreview. */
  public OperationCallSettings<DeletePreviewRequest, Preview, OperationMetadata>
      deletePreviewOperationSettings() {
    return ((ConfigStubSettings) getStubSettings()).deletePreviewOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportPreviewResult. */
  public UnaryCallSettings<ExportPreviewResultRequest, ExportPreviewResultResponse>
      exportPreviewResultSettings() {
    return ((ConfigStubSettings) getStubSettings()).exportPreviewResultSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ConfigStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ConfigStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ConfigStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ConfigStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ConfigStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final ConfigSettings create(ConfigStubSettings stub) throws IOException {
    return new ConfigSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ConfigStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ConfigStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ConfigStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ConfigStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ConfigStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ConfigStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ConfigStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConfigStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ConfigSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ConfigSettings. */
  public static class Builder extends ClientSettings.Builder<ConfigSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ConfigStubSettings.newBuilder(clientContext));
    }

    protected Builder(ConfigSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ConfigStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ConfigStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ConfigStubSettings.newHttpJsonBuilder());
    }

    public ConfigStubSettings.Builder getStubSettingsBuilder() {
      return ((ConfigStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listDeployments. */
    public PagedCallSettings.Builder<
            ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
        listDeploymentsSettings() {
      return getStubSettingsBuilder().listDeploymentsSettings();
    }

    /** Returns the builder for the settings used for calls to getDeployment. */
    public UnaryCallSettings.Builder<GetDeploymentRequest, Deployment> getDeploymentSettings() {
      return getStubSettingsBuilder().getDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to createDeployment. */
    public UnaryCallSettings.Builder<CreateDeploymentRequest, Operation>
        createDeploymentSettings() {
      return getStubSettingsBuilder().createDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to createDeployment. */
    public OperationCallSettings.Builder<CreateDeploymentRequest, Deployment, OperationMetadata>
        createDeploymentOperationSettings() {
      return getStubSettingsBuilder().createDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDeployment. */
    public UnaryCallSettings.Builder<UpdateDeploymentRequest, Operation>
        updateDeploymentSettings() {
      return getStubSettingsBuilder().updateDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to updateDeployment. */
    public OperationCallSettings.Builder<UpdateDeploymentRequest, Deployment, OperationMetadata>
        updateDeploymentOperationSettings() {
      return getStubSettingsBuilder().updateDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDeployment. */
    public UnaryCallSettings.Builder<DeleteDeploymentRequest, Operation>
        deleteDeploymentSettings() {
      return getStubSettingsBuilder().deleteDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDeployment. */
    public OperationCallSettings.Builder<DeleteDeploymentRequest, Deployment, OperationMetadata>
        deleteDeploymentOperationSettings() {
      return getStubSettingsBuilder().deleteDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listRevisions. */
    public PagedCallSettings.Builder<
            ListRevisionsRequest, ListRevisionsResponse, ListRevisionsPagedResponse>
        listRevisionsSettings() {
      return getStubSettingsBuilder().listRevisionsSettings();
    }

    /** Returns the builder for the settings used for calls to getRevision. */
    public UnaryCallSettings.Builder<GetRevisionRequest, Revision> getRevisionSettings() {
      return getStubSettingsBuilder().getRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to getResource. */
    public UnaryCallSettings.Builder<GetResourceRequest, Resource> getResourceSettings() {
      return getStubSettingsBuilder().getResourceSettings();
    }

    /** Returns the builder for the settings used for calls to listResources. */
    public PagedCallSettings.Builder<
            ListResourcesRequest, ListResourcesResponse, ListResourcesPagedResponse>
        listResourcesSettings() {
      return getStubSettingsBuilder().listResourcesSettings();
    }

    /** Returns the builder for the settings used for calls to exportDeploymentStatefile. */
    public UnaryCallSettings.Builder<ExportDeploymentStatefileRequest, Statefile>
        exportDeploymentStatefileSettings() {
      return getStubSettingsBuilder().exportDeploymentStatefileSettings();
    }

    /** Returns the builder for the settings used for calls to exportRevisionStatefile. */
    public UnaryCallSettings.Builder<ExportRevisionStatefileRequest, Statefile>
        exportRevisionStatefileSettings() {
      return getStubSettingsBuilder().exportRevisionStatefileSettings();
    }

    /** Returns the builder for the settings used for calls to importStatefile. */
    public UnaryCallSettings.Builder<ImportStatefileRequest, Statefile> importStatefileSettings() {
      return getStubSettingsBuilder().importStatefileSettings();
    }

    /** Returns the builder for the settings used for calls to deleteStatefile. */
    public UnaryCallSettings.Builder<DeleteStatefileRequest, Empty> deleteStatefileSettings() {
      return getStubSettingsBuilder().deleteStatefileSettings();
    }

    /** Returns the builder for the settings used for calls to lockDeployment. */
    public UnaryCallSettings.Builder<LockDeploymentRequest, Operation> lockDeploymentSettings() {
      return getStubSettingsBuilder().lockDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to lockDeployment. */
    public OperationCallSettings.Builder<LockDeploymentRequest, Deployment, OperationMetadata>
        lockDeploymentOperationSettings() {
      return getStubSettingsBuilder().lockDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to unlockDeployment. */
    public UnaryCallSettings.Builder<UnlockDeploymentRequest, Operation>
        unlockDeploymentSettings() {
      return getStubSettingsBuilder().unlockDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to unlockDeployment. */
    public OperationCallSettings.Builder<UnlockDeploymentRequest, Deployment, OperationMetadata>
        unlockDeploymentOperationSettings() {
      return getStubSettingsBuilder().unlockDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportLockInfo. */
    public UnaryCallSettings.Builder<ExportLockInfoRequest, LockInfo> exportLockInfoSettings() {
      return getStubSettingsBuilder().exportLockInfoSettings();
    }

    /** Returns the builder for the settings used for calls to createPreview. */
    public UnaryCallSettings.Builder<CreatePreviewRequest, Operation> createPreviewSettings() {
      return getStubSettingsBuilder().createPreviewSettings();
    }

    /** Returns the builder for the settings used for calls to createPreview. */
    public OperationCallSettings.Builder<CreatePreviewRequest, Preview, OperationMetadata>
        createPreviewOperationSettings() {
      return getStubSettingsBuilder().createPreviewOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getPreview. */
    public UnaryCallSettings.Builder<GetPreviewRequest, Preview> getPreviewSettings() {
      return getStubSettingsBuilder().getPreviewSettings();
    }

    /** Returns the builder for the settings used for calls to listPreviews. */
    public PagedCallSettings.Builder<
            ListPreviewsRequest, ListPreviewsResponse, ListPreviewsPagedResponse>
        listPreviewsSettings() {
      return getStubSettingsBuilder().listPreviewsSettings();
    }

    /** Returns the builder for the settings used for calls to deletePreview. */
    public UnaryCallSettings.Builder<DeletePreviewRequest, Operation> deletePreviewSettings() {
      return getStubSettingsBuilder().deletePreviewSettings();
    }

    /** Returns the builder for the settings used for calls to deletePreview. */
    public OperationCallSettings.Builder<DeletePreviewRequest, Preview, OperationMetadata>
        deletePreviewOperationSettings() {
      return getStubSettingsBuilder().deletePreviewOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportPreviewResult. */
    public UnaryCallSettings.Builder<ExportPreviewResultRequest, ExportPreviewResultResponse>
        exportPreviewResultSettings() {
      return getStubSettingsBuilder().exportPreviewResultSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
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

    @Override
    public ConfigSettings build() throws IOException {
      return new ConfigSettings(this);
    }
  }
}
