/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.managedkafka.v1;

import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListConnectClustersPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListConnectorsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListLocationsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.managedkafka.v1.stub.ManagedKafkaConnectStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ManagedKafkaConnectClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (managedkafka.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getConnectCluster:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ManagedKafkaConnectSettings.Builder managedKafkaConnectSettingsBuilder =
 *     ManagedKafkaConnectSettings.newBuilder();
 * managedKafkaConnectSettingsBuilder
 *     .getConnectClusterSettings()
 *     .setRetrySettings(
 *         managedKafkaConnectSettingsBuilder
 *             .getConnectClusterSettings()
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
 * ManagedKafkaConnectSettings managedKafkaConnectSettings =
 *     managedKafkaConnectSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createConnectCluster:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ManagedKafkaConnectSettings.Builder managedKafkaConnectSettingsBuilder =
 *     ManagedKafkaConnectSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * managedKafkaConnectSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ManagedKafkaConnectSettings extends ClientSettings<ManagedKafkaConnectSettings> {

  /** Returns the object with the settings used for calls to listConnectClusters. */
  public PagedCallSettings<
          ListConnectClustersRequest, ListConnectClustersResponse, ListConnectClustersPagedResponse>
      listConnectClustersSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).listConnectClustersSettings();
  }

  /** Returns the object with the settings used for calls to getConnectCluster. */
  public UnaryCallSettings<GetConnectClusterRequest, ConnectCluster> getConnectClusterSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).getConnectClusterSettings();
  }

  /** Returns the object with the settings used for calls to createConnectCluster. */
  public UnaryCallSettings<CreateConnectClusterRequest, Operation> createConnectClusterSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).createConnectClusterSettings();
  }

  /** Returns the object with the settings used for calls to createConnectCluster. */
  public OperationCallSettings<CreateConnectClusterRequest, ConnectCluster, OperationMetadata>
      createConnectClusterOperationSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings())
        .createConnectClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateConnectCluster. */
  public UnaryCallSettings<UpdateConnectClusterRequest, Operation> updateConnectClusterSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).updateConnectClusterSettings();
  }

  /** Returns the object with the settings used for calls to updateConnectCluster. */
  public OperationCallSettings<UpdateConnectClusterRequest, ConnectCluster, OperationMetadata>
      updateConnectClusterOperationSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings())
        .updateConnectClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnectCluster. */
  public UnaryCallSettings<DeleteConnectClusterRequest, Operation> deleteConnectClusterSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).deleteConnectClusterSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnectCluster. */
  public OperationCallSettings<DeleteConnectClusterRequest, Empty, OperationMetadata>
      deleteConnectClusterOperationSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings())
        .deleteConnectClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to listConnectors. */
  public PagedCallSettings<
          ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>
      listConnectorsSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).listConnectorsSettings();
  }

  /** Returns the object with the settings used for calls to getConnector. */
  public UnaryCallSettings<GetConnectorRequest, Connector> getConnectorSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).getConnectorSettings();
  }

  /** Returns the object with the settings used for calls to createConnector. */
  public UnaryCallSettings<CreateConnectorRequest, Connector> createConnectorSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).createConnectorSettings();
  }

  /** Returns the object with the settings used for calls to updateConnector. */
  public UnaryCallSettings<UpdateConnectorRequest, Connector> updateConnectorSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).updateConnectorSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnector. */
  public UnaryCallSettings<DeleteConnectorRequest, Empty> deleteConnectorSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).deleteConnectorSettings();
  }

  /** Returns the object with the settings used for calls to pauseConnector. */
  public UnaryCallSettings<PauseConnectorRequest, PauseConnectorResponse> pauseConnectorSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).pauseConnectorSettings();
  }

  /** Returns the object with the settings used for calls to resumeConnector. */
  public UnaryCallSettings<ResumeConnectorRequest, ResumeConnectorResponse>
      resumeConnectorSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).resumeConnectorSettings();
  }

  /** Returns the object with the settings used for calls to restartConnector. */
  public UnaryCallSettings<RestartConnectorRequest, RestartConnectorResponse>
      restartConnectorSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).restartConnectorSettings();
  }

  /** Returns the object with the settings used for calls to stopConnector. */
  public UnaryCallSettings<StopConnectorRequest, StopConnectorResponse> stopConnectorSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).stopConnectorSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ManagedKafkaConnectStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final ManagedKafkaConnectSettings create(ManagedKafkaConnectStubSettings stub)
      throws IOException {
    return new ManagedKafkaConnectSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ManagedKafkaConnectStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ManagedKafkaConnectStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ManagedKafkaConnectStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ManagedKafkaConnectStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ManagedKafkaConnectStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ManagedKafkaConnectStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ManagedKafkaConnectStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ManagedKafkaConnectStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ManagedKafkaConnectSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ManagedKafkaConnectSettings. */
  public static class Builder extends ClientSettings.Builder<ManagedKafkaConnectSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ManagedKafkaConnectStubSettings.newBuilder(clientContext));
    }

    protected Builder(ManagedKafkaConnectSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ManagedKafkaConnectStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ManagedKafkaConnectStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(ManagedKafkaConnectStubSettings.newHttpJsonBuilder());
    }

    public ManagedKafkaConnectStubSettings.Builder getStubSettingsBuilder() {
      return ((ManagedKafkaConnectStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listConnectClusters. */
    public PagedCallSettings.Builder<
            ListConnectClustersRequest,
            ListConnectClustersResponse,
            ListConnectClustersPagedResponse>
        listConnectClustersSettings() {
      return getStubSettingsBuilder().listConnectClustersSettings();
    }

    /** Returns the builder for the settings used for calls to getConnectCluster. */
    public UnaryCallSettings.Builder<GetConnectClusterRequest, ConnectCluster>
        getConnectClusterSettings() {
      return getStubSettingsBuilder().getConnectClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createConnectCluster. */
    public UnaryCallSettings.Builder<CreateConnectClusterRequest, Operation>
        createConnectClusterSettings() {
      return getStubSettingsBuilder().createConnectClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createConnectCluster. */
    public OperationCallSettings.Builder<
            CreateConnectClusterRequest, ConnectCluster, OperationMetadata>
        createConnectClusterOperationSettings() {
      return getStubSettingsBuilder().createConnectClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateConnectCluster. */
    public UnaryCallSettings.Builder<UpdateConnectClusterRequest, Operation>
        updateConnectClusterSettings() {
      return getStubSettingsBuilder().updateConnectClusterSettings();
    }

    /** Returns the builder for the settings used for calls to updateConnectCluster. */
    public OperationCallSettings.Builder<
            UpdateConnectClusterRequest, ConnectCluster, OperationMetadata>
        updateConnectClusterOperationSettings() {
      return getStubSettingsBuilder().updateConnectClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnectCluster. */
    public UnaryCallSettings.Builder<DeleteConnectClusterRequest, Operation>
        deleteConnectClusterSettings() {
      return getStubSettingsBuilder().deleteConnectClusterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnectCluster. */
    public OperationCallSettings.Builder<DeleteConnectClusterRequest, Empty, OperationMetadata>
        deleteConnectClusterOperationSettings() {
      return getStubSettingsBuilder().deleteConnectClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listConnectors. */
    public PagedCallSettings.Builder<
            ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>
        listConnectorsSettings() {
      return getStubSettingsBuilder().listConnectorsSettings();
    }

    /** Returns the builder for the settings used for calls to getConnector. */
    public UnaryCallSettings.Builder<GetConnectorRequest, Connector> getConnectorSettings() {
      return getStubSettingsBuilder().getConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to createConnector. */
    public UnaryCallSettings.Builder<CreateConnectorRequest, Connector> createConnectorSettings() {
      return getStubSettingsBuilder().createConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to updateConnector. */
    public UnaryCallSettings.Builder<UpdateConnectorRequest, Connector> updateConnectorSettings() {
      return getStubSettingsBuilder().updateConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnector. */
    public UnaryCallSettings.Builder<DeleteConnectorRequest, Empty> deleteConnectorSettings() {
      return getStubSettingsBuilder().deleteConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to pauseConnector. */
    public UnaryCallSettings.Builder<PauseConnectorRequest, PauseConnectorResponse>
        pauseConnectorSettings() {
      return getStubSettingsBuilder().pauseConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to resumeConnector. */
    public UnaryCallSettings.Builder<ResumeConnectorRequest, ResumeConnectorResponse>
        resumeConnectorSettings() {
      return getStubSettingsBuilder().resumeConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to restartConnector. */
    public UnaryCallSettings.Builder<RestartConnectorRequest, RestartConnectorResponse>
        restartConnectorSettings() {
      return getStubSettingsBuilder().restartConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to stopConnector. */
    public UnaryCallSettings.Builder<StopConnectorRequest, StopConnectorResponse>
        stopConnectorSettings() {
      return getStubSettingsBuilder().stopConnectorSettings();
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
    public ManagedKafkaConnectSettings build() throws IOException {
      return new ManagedKafkaConnectSettings(this);
    }
  }
}
