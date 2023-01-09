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

package com.google.cloud.gkemulticloud.v1;

import static com.google.cloud.gkemulticloud.v1.AttachedClustersClient.ListAttachedClustersPagedResponse;

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
import com.google.cloud.gkemulticloud.v1.stub.AttachedClustersStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AttachedClustersClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gkemulticloud.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAttachedCluster to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AttachedClustersSettings.Builder attachedClustersSettingsBuilder =
 *     AttachedClustersSettings.newBuilder();
 * attachedClustersSettingsBuilder
 *     .getAttachedClusterSettings()
 *     .setRetrySettings(
 *         attachedClustersSettingsBuilder
 *             .getAttachedClusterSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AttachedClustersSettings attachedClustersSettings = attachedClustersSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AttachedClustersSettings extends ClientSettings<AttachedClustersSettings> {

  /** Returns the object with the settings used for calls to createAttachedCluster. */
  public UnaryCallSettings<CreateAttachedClusterRequest, Operation>
      createAttachedClusterSettings() {
    return ((AttachedClustersStubSettings) getStubSettings()).createAttachedClusterSettings();
  }

  /** Returns the object with the settings used for calls to createAttachedCluster. */
  public OperationCallSettings<CreateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      createAttachedClusterOperationSettings() {
    return ((AttachedClustersStubSettings) getStubSettings())
        .createAttachedClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAttachedCluster. */
  public UnaryCallSettings<UpdateAttachedClusterRequest, Operation>
      updateAttachedClusterSettings() {
    return ((AttachedClustersStubSettings) getStubSettings()).updateAttachedClusterSettings();
  }

  /** Returns the object with the settings used for calls to updateAttachedCluster. */
  public OperationCallSettings<UpdateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      updateAttachedClusterOperationSettings() {
    return ((AttachedClustersStubSettings) getStubSettings())
        .updateAttachedClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to importAttachedCluster. */
  public UnaryCallSettings<ImportAttachedClusterRequest, Operation>
      importAttachedClusterSettings() {
    return ((AttachedClustersStubSettings) getStubSettings()).importAttachedClusterSettings();
  }

  /** Returns the object with the settings used for calls to importAttachedCluster. */
  public OperationCallSettings<ImportAttachedClusterRequest, AttachedCluster, OperationMetadata>
      importAttachedClusterOperationSettings() {
    return ((AttachedClustersStubSettings) getStubSettings())
        .importAttachedClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to getAttachedCluster. */
  public UnaryCallSettings<GetAttachedClusterRequest, AttachedCluster>
      getAttachedClusterSettings() {
    return ((AttachedClustersStubSettings) getStubSettings()).getAttachedClusterSettings();
  }

  /** Returns the object with the settings used for calls to listAttachedClusters. */
  public PagedCallSettings<
          ListAttachedClustersRequest,
          ListAttachedClustersResponse,
          ListAttachedClustersPagedResponse>
      listAttachedClustersSettings() {
    return ((AttachedClustersStubSettings) getStubSettings()).listAttachedClustersSettings();
  }

  /** Returns the object with the settings used for calls to deleteAttachedCluster. */
  public UnaryCallSettings<DeleteAttachedClusterRequest, Operation>
      deleteAttachedClusterSettings() {
    return ((AttachedClustersStubSettings) getStubSettings()).deleteAttachedClusterSettings();
  }

  /** Returns the object with the settings used for calls to deleteAttachedCluster. */
  public OperationCallSettings<DeleteAttachedClusterRequest, Empty, OperationMetadata>
      deleteAttachedClusterOperationSettings() {
    return ((AttachedClustersStubSettings) getStubSettings())
        .deleteAttachedClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to getAttachedServerConfig. */
  public UnaryCallSettings<GetAttachedServerConfigRequest, AttachedServerConfig>
      getAttachedServerConfigSettings() {
    return ((AttachedClustersStubSettings) getStubSettings()).getAttachedServerConfigSettings();
  }

  /**
   * Returns the object with the settings used for calls to generateAttachedClusterInstallManifest.
   */
  public UnaryCallSettings<
          GenerateAttachedClusterInstallManifestRequest,
          GenerateAttachedClusterInstallManifestResponse>
      generateAttachedClusterInstallManifestSettings() {
    return ((AttachedClustersStubSettings) getStubSettings())
        .generateAttachedClusterInstallManifestSettings();
  }

  public static final AttachedClustersSettings create(AttachedClustersStubSettings stub)
      throws IOException {
    return new AttachedClustersSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AttachedClustersStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AttachedClustersStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AttachedClustersStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AttachedClustersStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AttachedClustersStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AttachedClustersStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AttachedClustersStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AttachedClustersStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AttachedClustersSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AttachedClustersSettings. */
  public static class Builder extends ClientSettings.Builder<AttachedClustersSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AttachedClustersStubSettings.newBuilder(clientContext));
    }

    protected Builder(AttachedClustersSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AttachedClustersStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AttachedClustersStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(AttachedClustersStubSettings.newHttpJsonBuilder());
    }

    public AttachedClustersStubSettings.Builder getStubSettingsBuilder() {
      return ((AttachedClustersStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createAttachedCluster. */
    public UnaryCallSettings.Builder<CreateAttachedClusterRequest, Operation>
        createAttachedClusterSettings() {
      return getStubSettingsBuilder().createAttachedClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createAttachedCluster. */
    public OperationCallSettings.Builder<
            CreateAttachedClusterRequest, AttachedCluster, OperationMetadata>
        createAttachedClusterOperationSettings() {
      return getStubSettingsBuilder().createAttachedClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAttachedCluster. */
    public UnaryCallSettings.Builder<UpdateAttachedClusterRequest, Operation>
        updateAttachedClusterSettings() {
      return getStubSettingsBuilder().updateAttachedClusterSettings();
    }

    /** Returns the builder for the settings used for calls to updateAttachedCluster. */
    public OperationCallSettings.Builder<
            UpdateAttachedClusterRequest, AttachedCluster, OperationMetadata>
        updateAttachedClusterOperationSettings() {
      return getStubSettingsBuilder().updateAttachedClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importAttachedCluster. */
    public UnaryCallSettings.Builder<ImportAttachedClusterRequest, Operation>
        importAttachedClusterSettings() {
      return getStubSettingsBuilder().importAttachedClusterSettings();
    }

    /** Returns the builder for the settings used for calls to importAttachedCluster. */
    public OperationCallSettings.Builder<
            ImportAttachedClusterRequest, AttachedCluster, OperationMetadata>
        importAttachedClusterOperationSettings() {
      return getStubSettingsBuilder().importAttachedClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getAttachedCluster. */
    public UnaryCallSettings.Builder<GetAttachedClusterRequest, AttachedCluster>
        getAttachedClusterSettings() {
      return getStubSettingsBuilder().getAttachedClusterSettings();
    }

    /** Returns the builder for the settings used for calls to listAttachedClusters. */
    public PagedCallSettings.Builder<
            ListAttachedClustersRequest,
            ListAttachedClustersResponse,
            ListAttachedClustersPagedResponse>
        listAttachedClustersSettings() {
      return getStubSettingsBuilder().listAttachedClustersSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAttachedCluster. */
    public UnaryCallSettings.Builder<DeleteAttachedClusterRequest, Operation>
        deleteAttachedClusterSettings() {
      return getStubSettingsBuilder().deleteAttachedClusterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAttachedCluster. */
    public OperationCallSettings.Builder<DeleteAttachedClusterRequest, Empty, OperationMetadata>
        deleteAttachedClusterOperationSettings() {
      return getStubSettingsBuilder().deleteAttachedClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getAttachedServerConfig. */
    public UnaryCallSettings.Builder<GetAttachedServerConfigRequest, AttachedServerConfig>
        getAttachedServerConfigSettings() {
      return getStubSettingsBuilder().getAttachedServerConfigSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * generateAttachedClusterInstallManifest.
     */
    public UnaryCallSettings.Builder<
            GenerateAttachedClusterInstallManifestRequest,
            GenerateAttachedClusterInstallManifestResponse>
        generateAttachedClusterInstallManifestSettings() {
      return getStubSettingsBuilder().generateAttachedClusterInstallManifestSettings();
    }

    @Override
    public AttachedClustersSettings build() throws IOException {
      return new AttachedClustersSettings(this);
    }
  }
}
