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

package com.google.cloud.cloudsecuritycompliance.v1;

import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListCloudControlDeploymentsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListFrameworkDeploymentsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListLocationsPagedResponse;

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
import com.google.cloud.cloudsecuritycompliance.v1.stub.DeploymentStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DeploymentClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudsecuritycompliance.googleapis.com) and default port (443)
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
 * of getFrameworkDeployment:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeploymentSettings.Builder deploymentSettingsBuilder = DeploymentSettings.newBuilder();
 * deploymentSettingsBuilder
 *     .getFrameworkDeploymentSettings()
 *     .setRetrySettings(
 *         deploymentSettingsBuilder
 *             .getFrameworkDeploymentSettings()
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
 * DeploymentSettings deploymentSettings = deploymentSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createFrameworkDeployment:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeploymentSettings.Builder deploymentSettingsBuilder = DeploymentSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * deploymentSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DeploymentSettings extends ClientSettings<DeploymentSettings> {

  /** Returns the object with the settings used for calls to createFrameworkDeployment. */
  public UnaryCallSettings<CreateFrameworkDeploymentRequest, Operation>
      createFrameworkDeploymentSettings() {
    return ((DeploymentStubSettings) getStubSettings()).createFrameworkDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to createFrameworkDeployment. */
  public OperationCallSettings<
          CreateFrameworkDeploymentRequest, FrameworkDeployment, OperationMetadata>
      createFrameworkDeploymentOperationSettings() {
    return ((DeploymentStubSettings) getStubSettings())
        .createFrameworkDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFrameworkDeployment. */
  public UnaryCallSettings<DeleteFrameworkDeploymentRequest, Operation>
      deleteFrameworkDeploymentSettings() {
    return ((DeploymentStubSettings) getStubSettings()).deleteFrameworkDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to deleteFrameworkDeployment. */
  public OperationCallSettings<DeleteFrameworkDeploymentRequest, Empty, OperationMetadata>
      deleteFrameworkDeploymentOperationSettings() {
    return ((DeploymentStubSettings) getStubSettings())
        .deleteFrameworkDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to getFrameworkDeployment. */
  public UnaryCallSettings<GetFrameworkDeploymentRequest, FrameworkDeployment>
      getFrameworkDeploymentSettings() {
    return ((DeploymentStubSettings) getStubSettings()).getFrameworkDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to listFrameworkDeployments. */
  public PagedCallSettings<
          ListFrameworkDeploymentsRequest,
          ListFrameworkDeploymentsResponse,
          ListFrameworkDeploymentsPagedResponse>
      listFrameworkDeploymentsSettings() {
    return ((DeploymentStubSettings) getStubSettings()).listFrameworkDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to getCloudControlDeployment. */
  public UnaryCallSettings<GetCloudControlDeploymentRequest, CloudControlDeployment>
      getCloudControlDeploymentSettings() {
    return ((DeploymentStubSettings) getStubSettings()).getCloudControlDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to listCloudControlDeployments. */
  public PagedCallSettings<
          ListCloudControlDeploymentsRequest,
          ListCloudControlDeploymentsResponse,
          ListCloudControlDeploymentsPagedResponse>
      listCloudControlDeploymentsSettings() {
    return ((DeploymentStubSettings) getStubSettings()).listCloudControlDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DeploymentStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DeploymentStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final DeploymentSettings create(DeploymentStubSettings stub) throws IOException {
    return new DeploymentSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DeploymentStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DeploymentStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DeploymentStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DeploymentStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DeploymentStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DeploymentStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DeploymentStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DeploymentStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DeploymentSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DeploymentSettings. */
  public static class Builder extends ClientSettings.Builder<DeploymentSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DeploymentStubSettings.newBuilder(clientContext));
    }

    protected Builder(DeploymentSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DeploymentStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DeploymentStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DeploymentStubSettings.newHttpJsonBuilder());
    }

    public DeploymentStubSettings.Builder getStubSettingsBuilder() {
      return ((DeploymentStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createFrameworkDeployment. */
    public UnaryCallSettings.Builder<CreateFrameworkDeploymentRequest, Operation>
        createFrameworkDeploymentSettings() {
      return getStubSettingsBuilder().createFrameworkDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to createFrameworkDeployment. */
    public OperationCallSettings.Builder<
            CreateFrameworkDeploymentRequest, FrameworkDeployment, OperationMetadata>
        createFrameworkDeploymentOperationSettings() {
      return getStubSettingsBuilder().createFrameworkDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFrameworkDeployment. */
    public UnaryCallSettings.Builder<DeleteFrameworkDeploymentRequest, Operation>
        deleteFrameworkDeploymentSettings() {
      return getStubSettingsBuilder().deleteFrameworkDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFrameworkDeployment. */
    public OperationCallSettings.Builder<DeleteFrameworkDeploymentRequest, Empty, OperationMetadata>
        deleteFrameworkDeploymentOperationSettings() {
      return getStubSettingsBuilder().deleteFrameworkDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getFrameworkDeployment. */
    public UnaryCallSettings.Builder<GetFrameworkDeploymentRequest, FrameworkDeployment>
        getFrameworkDeploymentSettings() {
      return getStubSettingsBuilder().getFrameworkDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to listFrameworkDeployments. */
    public PagedCallSettings.Builder<
            ListFrameworkDeploymentsRequest,
            ListFrameworkDeploymentsResponse,
            ListFrameworkDeploymentsPagedResponse>
        listFrameworkDeploymentsSettings() {
      return getStubSettingsBuilder().listFrameworkDeploymentsSettings();
    }

    /** Returns the builder for the settings used for calls to getCloudControlDeployment. */
    public UnaryCallSettings.Builder<GetCloudControlDeploymentRequest, CloudControlDeployment>
        getCloudControlDeploymentSettings() {
      return getStubSettingsBuilder().getCloudControlDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to listCloudControlDeployments. */
    public PagedCallSettings.Builder<
            ListCloudControlDeploymentsRequest,
            ListCloudControlDeploymentsResponse,
            ListCloudControlDeploymentsPagedResponse>
        listCloudControlDeploymentsSettings() {
      return getStubSettingsBuilder().listCloudControlDeploymentsSettings();
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
    public DeploymentSettings build() throws IOException {
      return new DeploymentSettings(this);
    }
  }
}
