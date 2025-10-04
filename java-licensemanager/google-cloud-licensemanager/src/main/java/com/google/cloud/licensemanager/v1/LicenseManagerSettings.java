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

package com.google.cloud.licensemanager.v1;

import static com.google.cloud.licensemanager.v1.LicenseManagerClient.AggregateUsagePagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListConfigurationsPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListInstancesPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListProductsPagedResponse;

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
import com.google.cloud.licensemanager.v1.stub.LicenseManagerStubSettings;
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
 * Settings class to configure an instance of {@link LicenseManagerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (licensemanager.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getConfiguration:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LicenseManagerSettings.Builder licenseManagerSettingsBuilder =
 *     LicenseManagerSettings.newBuilder();
 * licenseManagerSettingsBuilder
 *     .getConfigurationSettings()
 *     .setRetrySettings(
 *         licenseManagerSettingsBuilder
 *             .getConfigurationSettings()
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
 * LicenseManagerSettings licenseManagerSettings = licenseManagerSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createConfiguration:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LicenseManagerSettings.Builder licenseManagerSettingsBuilder =
 *     LicenseManagerSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * licenseManagerSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class LicenseManagerSettings extends ClientSettings<LicenseManagerSettings> {

  /** Returns the object with the settings used for calls to listConfigurations. */
  public PagedCallSettings<
          ListConfigurationsRequest, ListConfigurationsResponse, ListConfigurationsPagedResponse>
      listConfigurationsSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).listConfigurationsSettings();
  }

  /** Returns the object with the settings used for calls to getConfiguration. */
  public UnaryCallSettings<GetConfigurationRequest, Configuration> getConfigurationSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).getConfigurationSettings();
  }

  /** Returns the object with the settings used for calls to createConfiguration. */
  public UnaryCallSettings<CreateConfigurationRequest, Operation> createConfigurationSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).createConfigurationSettings();
  }

  /** Returns the object with the settings used for calls to createConfiguration. */
  public OperationCallSettings<CreateConfigurationRequest, Configuration, OperationMetadata>
      createConfigurationOperationSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).createConfigurationOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateConfiguration. */
  public UnaryCallSettings<UpdateConfigurationRequest, Operation> updateConfigurationSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).updateConfigurationSettings();
  }

  /** Returns the object with the settings used for calls to updateConfiguration. */
  public OperationCallSettings<UpdateConfigurationRequest, Configuration, OperationMetadata>
      updateConfigurationOperationSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).updateConfigurationOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteConfiguration. */
  public UnaryCallSettings<DeleteConfigurationRequest, Operation> deleteConfigurationSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).deleteConfigurationSettings();
  }

  /** Returns the object with the settings used for calls to deleteConfiguration. */
  public OperationCallSettings<DeleteConfigurationRequest, Empty, OperationMetadata>
      deleteConfigurationOperationSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).deleteConfigurationOperationSettings();
  }

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).listInstancesSettings();
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).getInstanceSettings();
  }

  /** Returns the object with the settings used for calls to deactivateConfiguration. */
  public UnaryCallSettings<DeactivateConfigurationRequest, Operation>
      deactivateConfigurationSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).deactivateConfigurationSettings();
  }

  /** Returns the object with the settings used for calls to deactivateConfiguration. */
  public OperationCallSettings<DeactivateConfigurationRequest, Configuration, OperationMetadata>
      deactivateConfigurationOperationSettings() {
    return ((LicenseManagerStubSettings) getStubSettings())
        .deactivateConfigurationOperationSettings();
  }

  /** Returns the object with the settings used for calls to reactivateConfiguration. */
  public UnaryCallSettings<ReactivateConfigurationRequest, Operation>
      reactivateConfigurationSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).reactivateConfigurationSettings();
  }

  /** Returns the object with the settings used for calls to reactivateConfiguration. */
  public OperationCallSettings<ReactivateConfigurationRequest, Configuration, OperationMetadata>
      reactivateConfigurationOperationSettings() {
    return ((LicenseManagerStubSettings) getStubSettings())
        .reactivateConfigurationOperationSettings();
  }

  /** Returns the object with the settings used for calls to queryConfigurationLicenseUsage. */
  public UnaryCallSettings<
          QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
      queryConfigurationLicenseUsageSettings() {
    return ((LicenseManagerStubSettings) getStubSettings())
        .queryConfigurationLicenseUsageSettings();
  }

  /** Returns the object with the settings used for calls to aggregateUsage. */
  public PagedCallSettings<
          AggregateUsageRequest, AggregateUsageResponse, AggregateUsagePagedResponse>
      aggregateUsageSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).aggregateUsageSettings();
  }

  /** Returns the object with the settings used for calls to listProducts. */
  public PagedCallSettings<ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
      listProductsSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).listProductsSettings();
  }

  /** Returns the object with the settings used for calls to getProduct. */
  public UnaryCallSettings<GetProductRequest, Product> getProductSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).getProductSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((LicenseManagerStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final LicenseManagerSettings create(LicenseManagerStubSettings stub)
      throws IOException {
    return new LicenseManagerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return LicenseManagerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return LicenseManagerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return LicenseManagerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return LicenseManagerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return LicenseManagerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return LicenseManagerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return LicenseManagerStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LicenseManagerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected LicenseManagerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for LicenseManagerSettings. */
  public static class Builder extends ClientSettings.Builder<LicenseManagerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(LicenseManagerStubSettings.newBuilder(clientContext));
    }

    protected Builder(LicenseManagerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(LicenseManagerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(LicenseManagerStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(LicenseManagerStubSettings.newHttpJsonBuilder());
    }

    public LicenseManagerStubSettings.Builder getStubSettingsBuilder() {
      return ((LicenseManagerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listConfigurations. */
    public PagedCallSettings.Builder<
            ListConfigurationsRequest, ListConfigurationsResponse, ListConfigurationsPagedResponse>
        listConfigurationsSettings() {
      return getStubSettingsBuilder().listConfigurationsSettings();
    }

    /** Returns the builder for the settings used for calls to getConfiguration. */
    public UnaryCallSettings.Builder<GetConfigurationRequest, Configuration>
        getConfigurationSettings() {
      return getStubSettingsBuilder().getConfigurationSettings();
    }

    /** Returns the builder for the settings used for calls to createConfiguration. */
    public UnaryCallSettings.Builder<CreateConfigurationRequest, Operation>
        createConfigurationSettings() {
      return getStubSettingsBuilder().createConfigurationSettings();
    }

    /** Returns the builder for the settings used for calls to createConfiguration. */
    public OperationCallSettings.Builder<
            CreateConfigurationRequest, Configuration, OperationMetadata>
        createConfigurationOperationSettings() {
      return getStubSettingsBuilder().createConfigurationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateConfiguration. */
    public UnaryCallSettings.Builder<UpdateConfigurationRequest, Operation>
        updateConfigurationSettings() {
      return getStubSettingsBuilder().updateConfigurationSettings();
    }

    /** Returns the builder for the settings used for calls to updateConfiguration. */
    public OperationCallSettings.Builder<
            UpdateConfigurationRequest, Configuration, OperationMetadata>
        updateConfigurationOperationSettings() {
      return getStubSettingsBuilder().updateConfigurationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConfiguration. */
    public UnaryCallSettings.Builder<DeleteConfigurationRequest, Operation>
        deleteConfigurationSettings() {
      return getStubSettingsBuilder().deleteConfigurationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConfiguration. */
    public OperationCallSettings.Builder<DeleteConfigurationRequest, Empty, OperationMetadata>
        deleteConfigurationOperationSettings() {
      return getStubSettingsBuilder().deleteConfigurationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return getStubSettingsBuilder().listInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getStubSettingsBuilder().getInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to deactivateConfiguration. */
    public UnaryCallSettings.Builder<DeactivateConfigurationRequest, Operation>
        deactivateConfigurationSettings() {
      return getStubSettingsBuilder().deactivateConfigurationSettings();
    }

    /** Returns the builder for the settings used for calls to deactivateConfiguration. */
    public OperationCallSettings.Builder<
            DeactivateConfigurationRequest, Configuration, OperationMetadata>
        deactivateConfigurationOperationSettings() {
      return getStubSettingsBuilder().deactivateConfigurationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to reactivateConfiguration. */
    public UnaryCallSettings.Builder<ReactivateConfigurationRequest, Operation>
        reactivateConfigurationSettings() {
      return getStubSettingsBuilder().reactivateConfigurationSettings();
    }

    /** Returns the builder for the settings used for calls to reactivateConfiguration. */
    public OperationCallSettings.Builder<
            ReactivateConfigurationRequest, Configuration, OperationMetadata>
        reactivateConfigurationOperationSettings() {
      return getStubSettingsBuilder().reactivateConfigurationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to queryConfigurationLicenseUsage. */
    public UnaryCallSettings.Builder<
            QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
        queryConfigurationLicenseUsageSettings() {
      return getStubSettingsBuilder().queryConfigurationLicenseUsageSettings();
    }

    /** Returns the builder for the settings used for calls to aggregateUsage. */
    public PagedCallSettings.Builder<
            AggregateUsageRequest, AggregateUsageResponse, AggregateUsagePagedResponse>
        aggregateUsageSettings() {
      return getStubSettingsBuilder().aggregateUsageSettings();
    }

    /** Returns the builder for the settings used for calls to listProducts. */
    public PagedCallSettings.Builder<
            ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
        listProductsSettings() {
      return getStubSettingsBuilder().listProductsSettings();
    }

    /** Returns the builder for the settings used for calls to getProduct. */
    public UnaryCallSettings.Builder<GetProductRequest, Product> getProductSettings() {
      return getStubSettingsBuilder().getProductSettings();
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
    public LicenseManagerSettings build() throws IOException {
      return new LicenseManagerSettings(this);
    }
  }
}
