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

package com.google.cloud.blockchainnodeengine.v1;

import static com.google.cloud.blockchainnodeengine.v1.BlockchainNodeEngineClient.ListBlockchainNodesPagedResponse;
import static com.google.cloud.blockchainnodeengine.v1.BlockchainNodeEngineClient.ListLocationsPagedResponse;

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
import com.google.cloud.blockchainnodeengine.v1.stub.BlockchainNodeEngineStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BlockchainNodeEngineClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (blockchainnodeengine.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getBlockchainNode:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BlockchainNodeEngineSettings.Builder blockchainNodeEngineSettingsBuilder =
 *     BlockchainNodeEngineSettings.newBuilder();
 * blockchainNodeEngineSettingsBuilder
 *     .getBlockchainNodeSettings()
 *     .setRetrySettings(
 *         blockchainNodeEngineSettingsBuilder
 *             .getBlockchainNodeSettings()
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
 * BlockchainNodeEngineSettings blockchainNodeEngineSettings =
 *     blockchainNodeEngineSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createBlockchainNode:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BlockchainNodeEngineSettings.Builder blockchainNodeEngineSettingsBuilder =
 *     BlockchainNodeEngineSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * blockchainNodeEngineSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@NullMarked
@Generated("by gapic-generator-java")
public class BlockchainNodeEngineSettings extends ClientSettings<BlockchainNodeEngineSettings> {

  /** Returns the object with the settings used for calls to listBlockchainNodes. */
  public PagedCallSettings<
          ListBlockchainNodesRequest, ListBlockchainNodesResponse, ListBlockchainNodesPagedResponse>
      listBlockchainNodesSettings() {
    return ((BlockchainNodeEngineStubSettings) getStubSettings()).listBlockchainNodesSettings();
  }

  /** Returns the object with the settings used for calls to getBlockchainNode. */
  public UnaryCallSettings<GetBlockchainNodeRequest, BlockchainNode> getBlockchainNodeSettings() {
    return ((BlockchainNodeEngineStubSettings) getStubSettings()).getBlockchainNodeSettings();
  }

  /** Returns the object with the settings used for calls to createBlockchainNode. */
  public UnaryCallSettings<CreateBlockchainNodeRequest, Operation> createBlockchainNodeSettings() {
    return ((BlockchainNodeEngineStubSettings) getStubSettings()).createBlockchainNodeSettings();
  }

  /** Returns the object with the settings used for calls to createBlockchainNode. */
  public OperationCallSettings<CreateBlockchainNodeRequest, BlockchainNode, OperationMetadata>
      createBlockchainNodeOperationSettings() {
    return ((BlockchainNodeEngineStubSettings) getStubSettings())
        .createBlockchainNodeOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateBlockchainNode. */
  public UnaryCallSettings<UpdateBlockchainNodeRequest, Operation> updateBlockchainNodeSettings() {
    return ((BlockchainNodeEngineStubSettings) getStubSettings()).updateBlockchainNodeSettings();
  }

  /** Returns the object with the settings used for calls to updateBlockchainNode. */
  public OperationCallSettings<UpdateBlockchainNodeRequest, BlockchainNode, OperationMetadata>
      updateBlockchainNodeOperationSettings() {
    return ((BlockchainNodeEngineStubSettings) getStubSettings())
        .updateBlockchainNodeOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteBlockchainNode. */
  public UnaryCallSettings<DeleteBlockchainNodeRequest, Operation> deleteBlockchainNodeSettings() {
    return ((BlockchainNodeEngineStubSettings) getStubSettings()).deleteBlockchainNodeSettings();
  }

  /** Returns the object with the settings used for calls to deleteBlockchainNode. */
  public OperationCallSettings<DeleteBlockchainNodeRequest, Empty, OperationMetadata>
      deleteBlockchainNodeOperationSettings() {
    return ((BlockchainNodeEngineStubSettings) getStubSettings())
        .deleteBlockchainNodeOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((BlockchainNodeEngineStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((BlockchainNodeEngineStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final BlockchainNodeEngineSettings create(BlockchainNodeEngineStubSettings stub)
      throws IOException {
    return new BlockchainNodeEngineSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BlockchainNodeEngineStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BlockchainNodeEngineStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BlockchainNodeEngineStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BlockchainNodeEngineStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BlockchainNodeEngineStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return BlockchainNodeEngineStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BlockchainNodeEngineStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BlockchainNodeEngineStubSettings.defaultApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected BlockchainNodeEngineSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BlockchainNodeEngineSettings. */
  public static class Builder
      extends ClientSettings.Builder<BlockchainNodeEngineSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(BlockchainNodeEngineStubSettings.newBuilder(clientContext));
    }

    protected Builder(BlockchainNodeEngineSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BlockchainNodeEngineStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(BlockchainNodeEngineStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(BlockchainNodeEngineStubSettings.newHttpJsonBuilder());
    }

    public BlockchainNodeEngineStubSettings.Builder getStubSettingsBuilder() {
      return ((BlockchainNodeEngineStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listBlockchainNodes. */
    public PagedCallSettings.Builder<
            ListBlockchainNodesRequest,
            ListBlockchainNodesResponse,
            ListBlockchainNodesPagedResponse>
        listBlockchainNodesSettings() {
      return getStubSettingsBuilder().listBlockchainNodesSettings();
    }

    /** Returns the builder for the settings used for calls to getBlockchainNode. */
    public UnaryCallSettings.Builder<GetBlockchainNodeRequest, BlockchainNode>
        getBlockchainNodeSettings() {
      return getStubSettingsBuilder().getBlockchainNodeSettings();
    }

    /** Returns the builder for the settings used for calls to createBlockchainNode. */
    public UnaryCallSettings.Builder<CreateBlockchainNodeRequest, Operation>
        createBlockchainNodeSettings() {
      return getStubSettingsBuilder().createBlockchainNodeSettings();
    }

    /** Returns the builder for the settings used for calls to createBlockchainNode. */
    public OperationCallSettings.Builder<
            CreateBlockchainNodeRequest, BlockchainNode, OperationMetadata>
        createBlockchainNodeOperationSettings() {
      return getStubSettingsBuilder().createBlockchainNodeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateBlockchainNode. */
    public UnaryCallSettings.Builder<UpdateBlockchainNodeRequest, Operation>
        updateBlockchainNodeSettings() {
      return getStubSettingsBuilder().updateBlockchainNodeSettings();
    }

    /** Returns the builder for the settings used for calls to updateBlockchainNode. */
    public OperationCallSettings.Builder<
            UpdateBlockchainNodeRequest, BlockchainNode, OperationMetadata>
        updateBlockchainNodeOperationSettings() {
      return getStubSettingsBuilder().updateBlockchainNodeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBlockchainNode. */
    public UnaryCallSettings.Builder<DeleteBlockchainNodeRequest, Operation>
        deleteBlockchainNodeSettings() {
      return getStubSettingsBuilder().deleteBlockchainNodeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBlockchainNode. */
    public OperationCallSettings.Builder<DeleteBlockchainNodeRequest, Empty, OperationMetadata>
        deleteBlockchainNodeOperationSettings() {
      return getStubSettingsBuilder().deleteBlockchainNodeOperationSettings();
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

    @Override
    public BlockchainNodeEngineSettings build() throws IOException {
      return new BlockchainNodeEngineSettings(this);
    }
  }
}
