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

package com.google.cloud.maintenance.api.v1beta;

import static com.google.cloud.maintenance.api.v1beta.MaintenanceClient.ListLocationsPagedResponse;
import static com.google.cloud.maintenance.api.v1beta.MaintenanceClient.ListResourceMaintenancesPagedResponse;
import static com.google.cloud.maintenance.api.v1beta.MaintenanceClient.SummarizeMaintenancesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.maintenance.api.v1beta.stub.MaintenanceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MaintenanceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (maintenance.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getResourceMaintenance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MaintenanceSettings.Builder maintenanceSettingsBuilder = MaintenanceSettings.newBuilder();
 * maintenanceSettingsBuilder
 *     .getResourceMaintenanceSettings()
 *     .setRetrySettings(
 *         maintenanceSettingsBuilder
 *             .getResourceMaintenanceSettings()
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
 * MaintenanceSettings maintenanceSettings = maintenanceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MaintenanceSettings extends ClientSettings<MaintenanceSettings> {

  /** Returns the object with the settings used for calls to summarizeMaintenances. */
  public PagedCallSettings<
          SummarizeMaintenancesRequest,
          SummarizeMaintenancesResponse,
          SummarizeMaintenancesPagedResponse>
      summarizeMaintenancesSettings() {
    return ((MaintenanceStubSettings) getStubSettings()).summarizeMaintenancesSettings();
  }

  /** Returns the object with the settings used for calls to listResourceMaintenances. */
  public PagedCallSettings<
          ListResourceMaintenancesRequest,
          ListResourceMaintenancesResponse,
          ListResourceMaintenancesPagedResponse>
      listResourceMaintenancesSettings() {
    return ((MaintenanceStubSettings) getStubSettings()).listResourceMaintenancesSettings();
  }

  /** Returns the object with the settings used for calls to getResourceMaintenance. */
  public UnaryCallSettings<GetResourceMaintenanceRequest, ResourceMaintenance>
      getResourceMaintenanceSettings() {
    return ((MaintenanceStubSettings) getStubSettings()).getResourceMaintenanceSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((MaintenanceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((MaintenanceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final MaintenanceSettings create(MaintenanceStubSettings stub) throws IOException {
    return new MaintenanceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MaintenanceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MaintenanceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MaintenanceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MaintenanceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MaintenanceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return MaintenanceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MaintenanceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MaintenanceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MaintenanceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MaintenanceSettings. */
  public static class Builder extends ClientSettings.Builder<MaintenanceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MaintenanceStubSettings.newBuilder(clientContext));
    }

    protected Builder(MaintenanceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MaintenanceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MaintenanceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(MaintenanceStubSettings.newHttpJsonBuilder());
    }

    public MaintenanceStubSettings.Builder getStubSettingsBuilder() {
      return ((MaintenanceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to summarizeMaintenances. */
    public PagedCallSettings.Builder<
            SummarizeMaintenancesRequest,
            SummarizeMaintenancesResponse,
            SummarizeMaintenancesPagedResponse>
        summarizeMaintenancesSettings() {
      return getStubSettingsBuilder().summarizeMaintenancesSettings();
    }

    /** Returns the builder for the settings used for calls to listResourceMaintenances. */
    public PagedCallSettings.Builder<
            ListResourceMaintenancesRequest,
            ListResourceMaintenancesResponse,
            ListResourceMaintenancesPagedResponse>
        listResourceMaintenancesSettings() {
      return getStubSettingsBuilder().listResourceMaintenancesSettings();
    }

    /** Returns the builder for the settings used for calls to getResourceMaintenance. */
    public UnaryCallSettings.Builder<GetResourceMaintenanceRequest, ResourceMaintenance>
        getResourceMaintenanceSettings() {
      return getStubSettingsBuilder().getResourceMaintenanceSettings();
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
    public MaintenanceSettings build() throws IOException {
      return new MaintenanceSettings(this);
    }
  }
}
