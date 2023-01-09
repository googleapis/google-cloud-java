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

import static com.google.cloud.gkemulticloud.v1.AwsClustersClient.ListAwsClustersPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AwsClustersClient.ListAwsNodePoolsPagedResponse;

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
import com.google.cloud.gkemulticloud.v1.stub.AwsClustersStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AwsClustersClient}.
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
 * <p>For example, to set the total timeout of getAwsCluster to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AwsClustersSettings.Builder awsClustersSettingsBuilder = AwsClustersSettings.newBuilder();
 * awsClustersSettingsBuilder
 *     .getAwsClusterSettings()
 *     .setRetrySettings(
 *         awsClustersSettingsBuilder
 *             .getAwsClusterSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AwsClustersSettings awsClustersSettings = awsClustersSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AwsClustersSettings extends ClientSettings<AwsClustersSettings> {

  /** Returns the object with the settings used for calls to createAwsCluster. */
  public UnaryCallSettings<CreateAwsClusterRequest, Operation> createAwsClusterSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).createAwsClusterSettings();
  }

  /** Returns the object with the settings used for calls to createAwsCluster. */
  public OperationCallSettings<CreateAwsClusterRequest, AwsCluster, OperationMetadata>
      createAwsClusterOperationSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).createAwsClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAwsCluster. */
  public UnaryCallSettings<UpdateAwsClusterRequest, Operation> updateAwsClusterSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).updateAwsClusterSettings();
  }

  /** Returns the object with the settings used for calls to updateAwsCluster. */
  public OperationCallSettings<UpdateAwsClusterRequest, AwsCluster, OperationMetadata>
      updateAwsClusterOperationSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).updateAwsClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to getAwsCluster. */
  public UnaryCallSettings<GetAwsClusterRequest, AwsCluster> getAwsClusterSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).getAwsClusterSettings();
  }

  /** Returns the object with the settings used for calls to listAwsClusters. */
  public PagedCallSettings<
          ListAwsClustersRequest, ListAwsClustersResponse, ListAwsClustersPagedResponse>
      listAwsClustersSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).listAwsClustersSettings();
  }

  /** Returns the object with the settings used for calls to deleteAwsCluster. */
  public UnaryCallSettings<DeleteAwsClusterRequest, Operation> deleteAwsClusterSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).deleteAwsClusterSettings();
  }

  /** Returns the object with the settings used for calls to deleteAwsCluster. */
  public OperationCallSettings<DeleteAwsClusterRequest, Empty, OperationMetadata>
      deleteAwsClusterOperationSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).deleteAwsClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateAwsAccessToken. */
  public UnaryCallSettings<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
      generateAwsAccessTokenSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).generateAwsAccessTokenSettings();
  }

  /** Returns the object with the settings used for calls to createAwsNodePool. */
  public UnaryCallSettings<CreateAwsNodePoolRequest, Operation> createAwsNodePoolSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).createAwsNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to createAwsNodePool. */
  public OperationCallSettings<CreateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      createAwsNodePoolOperationSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).createAwsNodePoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAwsNodePool. */
  public UnaryCallSettings<UpdateAwsNodePoolRequest, Operation> updateAwsNodePoolSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).updateAwsNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to updateAwsNodePool. */
  public OperationCallSettings<UpdateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      updateAwsNodePoolOperationSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).updateAwsNodePoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to getAwsNodePool. */
  public UnaryCallSettings<GetAwsNodePoolRequest, AwsNodePool> getAwsNodePoolSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).getAwsNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to listAwsNodePools. */
  public PagedCallSettings<
          ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, ListAwsNodePoolsPagedResponse>
      listAwsNodePoolsSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).listAwsNodePoolsSettings();
  }

  /** Returns the object with the settings used for calls to deleteAwsNodePool. */
  public UnaryCallSettings<DeleteAwsNodePoolRequest, Operation> deleteAwsNodePoolSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).deleteAwsNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to deleteAwsNodePool. */
  public OperationCallSettings<DeleteAwsNodePoolRequest, Empty, OperationMetadata>
      deleteAwsNodePoolOperationSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).deleteAwsNodePoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to getAwsServerConfig. */
  public UnaryCallSettings<GetAwsServerConfigRequest, AwsServerConfig>
      getAwsServerConfigSettings() {
    return ((AwsClustersStubSettings) getStubSettings()).getAwsServerConfigSettings();
  }

  public static final AwsClustersSettings create(AwsClustersStubSettings stub) throws IOException {
    return new AwsClustersSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AwsClustersStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AwsClustersStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AwsClustersStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AwsClustersStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AwsClustersStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AwsClustersStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AwsClustersStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AwsClustersStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AwsClustersSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AwsClustersSettings. */
  public static class Builder extends ClientSettings.Builder<AwsClustersSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AwsClustersStubSettings.newBuilder(clientContext));
    }

    protected Builder(AwsClustersSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AwsClustersStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AwsClustersStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(AwsClustersStubSettings.newHttpJsonBuilder());
    }

    public AwsClustersStubSettings.Builder getStubSettingsBuilder() {
      return ((AwsClustersStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createAwsCluster. */
    public UnaryCallSettings.Builder<CreateAwsClusterRequest, Operation>
        createAwsClusterSettings() {
      return getStubSettingsBuilder().createAwsClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createAwsCluster. */
    public OperationCallSettings.Builder<CreateAwsClusterRequest, AwsCluster, OperationMetadata>
        createAwsClusterOperationSettings() {
      return getStubSettingsBuilder().createAwsClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAwsCluster. */
    public UnaryCallSettings.Builder<UpdateAwsClusterRequest, Operation>
        updateAwsClusterSettings() {
      return getStubSettingsBuilder().updateAwsClusterSettings();
    }

    /** Returns the builder for the settings used for calls to updateAwsCluster. */
    public OperationCallSettings.Builder<UpdateAwsClusterRequest, AwsCluster, OperationMetadata>
        updateAwsClusterOperationSettings() {
      return getStubSettingsBuilder().updateAwsClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getAwsCluster. */
    public UnaryCallSettings.Builder<GetAwsClusterRequest, AwsCluster> getAwsClusterSettings() {
      return getStubSettingsBuilder().getAwsClusterSettings();
    }

    /** Returns the builder for the settings used for calls to listAwsClusters. */
    public PagedCallSettings.Builder<
            ListAwsClustersRequest, ListAwsClustersResponse, ListAwsClustersPagedResponse>
        listAwsClustersSettings() {
      return getStubSettingsBuilder().listAwsClustersSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAwsCluster. */
    public UnaryCallSettings.Builder<DeleteAwsClusterRequest, Operation>
        deleteAwsClusterSettings() {
      return getStubSettingsBuilder().deleteAwsClusterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAwsCluster. */
    public OperationCallSettings.Builder<DeleteAwsClusterRequest, Empty, OperationMetadata>
        deleteAwsClusterOperationSettings() {
      return getStubSettingsBuilder().deleteAwsClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateAwsAccessToken. */
    public UnaryCallSettings.Builder<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
        generateAwsAccessTokenSettings() {
      return getStubSettingsBuilder().generateAwsAccessTokenSettings();
    }

    /** Returns the builder for the settings used for calls to createAwsNodePool. */
    public UnaryCallSettings.Builder<CreateAwsNodePoolRequest, Operation>
        createAwsNodePoolSettings() {
      return getStubSettingsBuilder().createAwsNodePoolSettings();
    }

    /** Returns the builder for the settings used for calls to createAwsNodePool. */
    public OperationCallSettings.Builder<CreateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
        createAwsNodePoolOperationSettings() {
      return getStubSettingsBuilder().createAwsNodePoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAwsNodePool. */
    public UnaryCallSettings.Builder<UpdateAwsNodePoolRequest, Operation>
        updateAwsNodePoolSettings() {
      return getStubSettingsBuilder().updateAwsNodePoolSettings();
    }

    /** Returns the builder for the settings used for calls to updateAwsNodePool. */
    public OperationCallSettings.Builder<UpdateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
        updateAwsNodePoolOperationSettings() {
      return getStubSettingsBuilder().updateAwsNodePoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getAwsNodePool. */
    public UnaryCallSettings.Builder<GetAwsNodePoolRequest, AwsNodePool> getAwsNodePoolSettings() {
      return getStubSettingsBuilder().getAwsNodePoolSettings();
    }

    /** Returns the builder for the settings used for calls to listAwsNodePools. */
    public PagedCallSettings.Builder<
            ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, ListAwsNodePoolsPagedResponse>
        listAwsNodePoolsSettings() {
      return getStubSettingsBuilder().listAwsNodePoolsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAwsNodePool. */
    public UnaryCallSettings.Builder<DeleteAwsNodePoolRequest, Operation>
        deleteAwsNodePoolSettings() {
      return getStubSettingsBuilder().deleteAwsNodePoolSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAwsNodePool. */
    public OperationCallSettings.Builder<DeleteAwsNodePoolRequest, Empty, OperationMetadata>
        deleteAwsNodePoolOperationSettings() {
      return getStubSettingsBuilder().deleteAwsNodePoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getAwsServerConfig. */
    public UnaryCallSettings.Builder<GetAwsServerConfigRequest, AwsServerConfig>
        getAwsServerConfigSettings() {
      return getStubSettingsBuilder().getAwsServerConfigSettings();
    }

    @Override
    public AwsClustersSettings build() throws IOException {
      return new AwsClustersSettings(this);
    }
  }
}
