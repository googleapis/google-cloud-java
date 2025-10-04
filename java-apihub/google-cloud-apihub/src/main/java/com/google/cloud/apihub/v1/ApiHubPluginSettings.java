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

package com.google.cloud.apihub.v1;

import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListPluginInstancesPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListPluginsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.apihub.v1.stub.ApiHubPluginStubSettings;
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
 * Settings class to configure an instance of {@link ApiHubPluginClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (apihub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getPlugin:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiHubPluginSettings.Builder apiHubPluginSettingsBuilder = ApiHubPluginSettings.newBuilder();
 * apiHubPluginSettingsBuilder
 *     .getPluginSettings()
 *     .setRetrySettings(
 *         apiHubPluginSettingsBuilder
 *             .getPluginSettings()
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
 * ApiHubPluginSettings apiHubPluginSettings = apiHubPluginSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for deletePlugin:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiHubPluginSettings.Builder apiHubPluginSettingsBuilder = ApiHubPluginSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * apiHubPluginSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ApiHubPluginSettings extends ClientSettings<ApiHubPluginSettings> {

  /** Returns the object with the settings used for calls to getPlugin. */
  public UnaryCallSettings<GetPluginRequest, Plugin> getPluginSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).getPluginSettings();
  }

  /** Returns the object with the settings used for calls to enablePlugin. */
  public UnaryCallSettings<EnablePluginRequest, Plugin> enablePluginSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).enablePluginSettings();
  }

  /** Returns the object with the settings used for calls to disablePlugin. */
  public UnaryCallSettings<DisablePluginRequest, Plugin> disablePluginSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).disablePluginSettings();
  }

  /** Returns the object with the settings used for calls to createPlugin. */
  public UnaryCallSettings<CreatePluginRequest, Plugin> createPluginSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).createPluginSettings();
  }

  /** Returns the object with the settings used for calls to listPlugins. */
  public PagedCallSettings<ListPluginsRequest, ListPluginsResponse, ListPluginsPagedResponse>
      listPluginsSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).listPluginsSettings();
  }

  /** Returns the object with the settings used for calls to deletePlugin. */
  public UnaryCallSettings<DeletePluginRequest, Operation> deletePluginSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).deletePluginSettings();
  }

  /** Returns the object with the settings used for calls to deletePlugin. */
  public OperationCallSettings<DeletePluginRequest, Empty, OperationMetadata>
      deletePluginOperationSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).deletePluginOperationSettings();
  }

  /** Returns the object with the settings used for calls to createPluginInstance. */
  public UnaryCallSettings<CreatePluginInstanceRequest, Operation> createPluginInstanceSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).createPluginInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createPluginInstance. */
  public OperationCallSettings<CreatePluginInstanceRequest, PluginInstance, OperationMetadata>
      createPluginInstanceOperationSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).createPluginInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to executePluginInstanceAction. */
  public UnaryCallSettings<ExecutePluginInstanceActionRequest, Operation>
      executePluginInstanceActionSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).executePluginInstanceActionSettings();
  }

  /** Returns the object with the settings used for calls to executePluginInstanceAction. */
  public OperationCallSettings<
          ExecutePluginInstanceActionRequest,
          ExecutePluginInstanceActionResponse,
          OperationMetadata>
      executePluginInstanceActionOperationSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings())
        .executePluginInstanceActionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getPluginInstance. */
  public UnaryCallSettings<GetPluginInstanceRequest, PluginInstance> getPluginInstanceSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).getPluginInstanceSettings();
  }

  /** Returns the object with the settings used for calls to listPluginInstances. */
  public PagedCallSettings<
          ListPluginInstancesRequest, ListPluginInstancesResponse, ListPluginInstancesPagedResponse>
      listPluginInstancesSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).listPluginInstancesSettings();
  }

  /** Returns the object with the settings used for calls to enablePluginInstanceAction. */
  public UnaryCallSettings<EnablePluginInstanceActionRequest, Operation>
      enablePluginInstanceActionSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).enablePluginInstanceActionSettings();
  }

  /** Returns the object with the settings used for calls to enablePluginInstanceAction. */
  public OperationCallSettings<
          EnablePluginInstanceActionRequest, EnablePluginInstanceActionResponse, OperationMetadata>
      enablePluginInstanceActionOperationSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings())
        .enablePluginInstanceActionOperationSettings();
  }

  /** Returns the object with the settings used for calls to disablePluginInstanceAction. */
  public UnaryCallSettings<DisablePluginInstanceActionRequest, Operation>
      disablePluginInstanceActionSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).disablePluginInstanceActionSettings();
  }

  /** Returns the object with the settings used for calls to disablePluginInstanceAction. */
  public OperationCallSettings<
          DisablePluginInstanceActionRequest,
          DisablePluginInstanceActionResponse,
          OperationMetadata>
      disablePluginInstanceActionOperationSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings())
        .disablePluginInstanceActionOperationSettings();
  }

  /** Returns the object with the settings used for calls to updatePluginInstance. */
  public UnaryCallSettings<UpdatePluginInstanceRequest, PluginInstance>
      updatePluginInstanceSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).updatePluginInstanceSettings();
  }

  /** Returns the object with the settings used for calls to deletePluginInstance. */
  public UnaryCallSettings<DeletePluginInstanceRequest, Operation> deletePluginInstanceSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).deletePluginInstanceSettings();
  }

  /** Returns the object with the settings used for calls to deletePluginInstance. */
  public OperationCallSettings<DeletePluginInstanceRequest, Empty, OperationMetadata>
      deletePluginInstanceOperationSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).deletePluginInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ApiHubPluginStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final ApiHubPluginSettings create(ApiHubPluginStubSettings stub)
      throws IOException {
    return new ApiHubPluginSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ApiHubPluginStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ApiHubPluginStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ApiHubPluginStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ApiHubPluginStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ApiHubPluginStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ApiHubPluginStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiHubPluginStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ApiHubPluginSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ApiHubPluginSettings. */
  public static class Builder extends ClientSettings.Builder<ApiHubPluginSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ApiHubPluginStubSettings.newBuilder(clientContext));
    }

    protected Builder(ApiHubPluginSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ApiHubPluginStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ApiHubPluginStubSettings.newBuilder());
    }

    public ApiHubPluginStubSettings.Builder getStubSettingsBuilder() {
      return ((ApiHubPluginStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getPlugin. */
    public UnaryCallSettings.Builder<GetPluginRequest, Plugin> getPluginSettings() {
      return getStubSettingsBuilder().getPluginSettings();
    }

    /** Returns the builder for the settings used for calls to enablePlugin. */
    public UnaryCallSettings.Builder<EnablePluginRequest, Plugin> enablePluginSettings() {
      return getStubSettingsBuilder().enablePluginSettings();
    }

    /** Returns the builder for the settings used for calls to disablePlugin. */
    public UnaryCallSettings.Builder<DisablePluginRequest, Plugin> disablePluginSettings() {
      return getStubSettingsBuilder().disablePluginSettings();
    }

    /** Returns the builder for the settings used for calls to createPlugin. */
    public UnaryCallSettings.Builder<CreatePluginRequest, Plugin> createPluginSettings() {
      return getStubSettingsBuilder().createPluginSettings();
    }

    /** Returns the builder for the settings used for calls to listPlugins. */
    public PagedCallSettings.Builder<
            ListPluginsRequest, ListPluginsResponse, ListPluginsPagedResponse>
        listPluginsSettings() {
      return getStubSettingsBuilder().listPluginsSettings();
    }

    /** Returns the builder for the settings used for calls to deletePlugin. */
    public UnaryCallSettings.Builder<DeletePluginRequest, Operation> deletePluginSettings() {
      return getStubSettingsBuilder().deletePluginSettings();
    }

    /** Returns the builder for the settings used for calls to deletePlugin. */
    public OperationCallSettings.Builder<DeletePluginRequest, Empty, OperationMetadata>
        deletePluginOperationSettings() {
      return getStubSettingsBuilder().deletePluginOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createPluginInstance. */
    public UnaryCallSettings.Builder<CreatePluginInstanceRequest, Operation>
        createPluginInstanceSettings() {
      return getStubSettingsBuilder().createPluginInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createPluginInstance. */
    public OperationCallSettings.Builder<
            CreatePluginInstanceRequest, PluginInstance, OperationMetadata>
        createPluginInstanceOperationSettings() {
      return getStubSettingsBuilder().createPluginInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to executePluginInstanceAction. */
    public UnaryCallSettings.Builder<ExecutePluginInstanceActionRequest, Operation>
        executePluginInstanceActionSettings() {
      return getStubSettingsBuilder().executePluginInstanceActionSettings();
    }

    /** Returns the builder for the settings used for calls to executePluginInstanceAction. */
    public OperationCallSettings.Builder<
            ExecutePluginInstanceActionRequest,
            ExecutePluginInstanceActionResponse,
            OperationMetadata>
        executePluginInstanceActionOperationSettings() {
      return getStubSettingsBuilder().executePluginInstanceActionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getPluginInstance. */
    public UnaryCallSettings.Builder<GetPluginInstanceRequest, PluginInstance>
        getPluginInstanceSettings() {
      return getStubSettingsBuilder().getPluginInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to listPluginInstances. */
    public PagedCallSettings.Builder<
            ListPluginInstancesRequest,
            ListPluginInstancesResponse,
            ListPluginInstancesPagedResponse>
        listPluginInstancesSettings() {
      return getStubSettingsBuilder().listPluginInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to enablePluginInstanceAction. */
    public UnaryCallSettings.Builder<EnablePluginInstanceActionRequest, Operation>
        enablePluginInstanceActionSettings() {
      return getStubSettingsBuilder().enablePluginInstanceActionSettings();
    }

    /** Returns the builder for the settings used for calls to enablePluginInstanceAction. */
    public OperationCallSettings.Builder<
            EnablePluginInstanceActionRequest,
            EnablePluginInstanceActionResponse,
            OperationMetadata>
        enablePluginInstanceActionOperationSettings() {
      return getStubSettingsBuilder().enablePluginInstanceActionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to disablePluginInstanceAction. */
    public UnaryCallSettings.Builder<DisablePluginInstanceActionRequest, Operation>
        disablePluginInstanceActionSettings() {
      return getStubSettingsBuilder().disablePluginInstanceActionSettings();
    }

    /** Returns the builder for the settings used for calls to disablePluginInstanceAction. */
    public OperationCallSettings.Builder<
            DisablePluginInstanceActionRequest,
            DisablePluginInstanceActionResponse,
            OperationMetadata>
        disablePluginInstanceActionOperationSettings() {
      return getStubSettingsBuilder().disablePluginInstanceActionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updatePluginInstance. */
    public UnaryCallSettings.Builder<UpdatePluginInstanceRequest, PluginInstance>
        updatePluginInstanceSettings() {
      return getStubSettingsBuilder().updatePluginInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to deletePluginInstance. */
    public UnaryCallSettings.Builder<DeletePluginInstanceRequest, Operation>
        deletePluginInstanceSettings() {
      return getStubSettingsBuilder().deletePluginInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to deletePluginInstance. */
    public OperationCallSettings.Builder<DeletePluginInstanceRequest, Empty, OperationMetadata>
        deletePluginInstanceOperationSettings() {
      return getStubSettingsBuilder().deletePluginInstanceOperationSettings();
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
    public ApiHubPluginSettings build() throws IOException {
      return new ApiHubPluginSettings(this);
    }
  }
}
