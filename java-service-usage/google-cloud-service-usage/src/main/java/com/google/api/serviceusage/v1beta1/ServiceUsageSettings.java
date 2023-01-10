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

package com.google.api.serviceusage.v1beta1;

import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListAdminOverridesPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListConsumerOverridesPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListConsumerQuotaMetricsPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListServicesPagedResponse;

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
import com.google.api.serviceusage.v1beta1.stub.ServiceUsageStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ServiceUsageClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (serviceusage.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getService to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ServiceUsageSettings.Builder serviceUsageSettingsBuilder = ServiceUsageSettings.newBuilder();
 * serviceUsageSettingsBuilder
 *     .getServiceSettings()
 *     .setRetrySettings(
 *         serviceUsageSettingsBuilder
 *             .getServiceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ServiceUsageSettings serviceUsageSettings = serviceUsageSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ServiceUsageSettings extends ClientSettings<ServiceUsageSettings> {

  /**
   * Returns the object with the settings used for calls to enableService.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<EnableServiceRequest, Operation> enableServiceSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).enableServiceSettings();
  }

  /**
   * Returns the object with the settings used for calls to enableService.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public OperationCallSettings<EnableServiceRequest, Empty, OperationMetadata>
      enableServiceOperationSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).enableServiceOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to disableService.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<DisableServiceRequest, Operation> disableServiceSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).disableServiceSettings();
  }

  /**
   * Returns the object with the settings used for calls to disableService.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public OperationCallSettings<DisableServiceRequest, Empty, OperationMetadata>
      disableServiceOperationSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).disableServiceOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to getService.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<GetServiceRequest, Service> getServiceSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).getServiceSettings();
  }

  /**
   * Returns the object with the settings used for calls to listServices.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).listServicesSettings();
  }

  /**
   * Returns the object with the settings used for calls to batchEnableServices.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<BatchEnableServicesRequest, Operation> batchEnableServicesSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).batchEnableServicesSettings();
  }

  /**
   * Returns the object with the settings used for calls to batchEnableServices.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public OperationCallSettings<BatchEnableServicesRequest, Empty, OperationMetadata>
      batchEnableServicesOperationSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).batchEnableServicesOperationSettings();
  }

  /** Returns the object with the settings used for calls to listConsumerQuotaMetrics. */
  public PagedCallSettings<
          ListConsumerQuotaMetricsRequest,
          ListConsumerQuotaMetricsResponse,
          ListConsumerQuotaMetricsPagedResponse>
      listConsumerQuotaMetricsSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).listConsumerQuotaMetricsSettings();
  }

  /** Returns the object with the settings used for calls to getConsumerQuotaMetric. */
  public UnaryCallSettings<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
      getConsumerQuotaMetricSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).getConsumerQuotaMetricSettings();
  }

  /** Returns the object with the settings used for calls to getConsumerQuotaLimit. */
  public UnaryCallSettings<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
      getConsumerQuotaLimitSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).getConsumerQuotaLimitSettings();
  }

  /** Returns the object with the settings used for calls to createAdminOverride. */
  public UnaryCallSettings<CreateAdminOverrideRequest, Operation> createAdminOverrideSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).createAdminOverrideSettings();
  }

  /** Returns the object with the settings used for calls to createAdminOverride. */
  public OperationCallSettings<CreateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      createAdminOverrideOperationSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).createAdminOverrideOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAdminOverride. */
  public UnaryCallSettings<UpdateAdminOverrideRequest, Operation> updateAdminOverrideSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).updateAdminOverrideSettings();
  }

  /** Returns the object with the settings used for calls to updateAdminOverride. */
  public OperationCallSettings<UpdateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      updateAdminOverrideOperationSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).updateAdminOverrideOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAdminOverride. */
  public UnaryCallSettings<DeleteAdminOverrideRequest, Operation> deleteAdminOverrideSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).deleteAdminOverrideSettings();
  }

  /** Returns the object with the settings used for calls to deleteAdminOverride. */
  public OperationCallSettings<DeleteAdminOverrideRequest, Empty, OperationMetadata>
      deleteAdminOverrideOperationSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).deleteAdminOverrideOperationSettings();
  }

  /** Returns the object with the settings used for calls to listAdminOverrides. */
  public PagedCallSettings<
          ListAdminOverridesRequest, ListAdminOverridesResponse, ListAdminOverridesPagedResponse>
      listAdminOverridesSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).listAdminOverridesSettings();
  }

  /** Returns the object with the settings used for calls to importAdminOverrides. */
  public UnaryCallSettings<ImportAdminOverridesRequest, Operation> importAdminOverridesSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).importAdminOverridesSettings();
  }

  /** Returns the object with the settings used for calls to importAdminOverrides. */
  public OperationCallSettings<
          ImportAdminOverridesRequest, ImportAdminOverridesResponse, ImportAdminOverridesMetadata>
      importAdminOverridesOperationSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).importAdminOverridesOperationSettings();
  }

  /** Returns the object with the settings used for calls to createConsumerOverride. */
  public UnaryCallSettings<CreateConsumerOverrideRequest, Operation>
      createConsumerOverrideSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).createConsumerOverrideSettings();
  }

  /** Returns the object with the settings used for calls to createConsumerOverride. */
  public OperationCallSettings<CreateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      createConsumerOverrideOperationSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).createConsumerOverrideOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateConsumerOverride. */
  public UnaryCallSettings<UpdateConsumerOverrideRequest, Operation>
      updateConsumerOverrideSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).updateConsumerOverrideSettings();
  }

  /** Returns the object with the settings used for calls to updateConsumerOverride. */
  public OperationCallSettings<UpdateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      updateConsumerOverrideOperationSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).updateConsumerOverrideOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteConsumerOverride. */
  public UnaryCallSettings<DeleteConsumerOverrideRequest, Operation>
      deleteConsumerOverrideSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).deleteConsumerOverrideSettings();
  }

  /** Returns the object with the settings used for calls to deleteConsumerOverride. */
  public OperationCallSettings<DeleteConsumerOverrideRequest, Empty, OperationMetadata>
      deleteConsumerOverrideOperationSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).deleteConsumerOverrideOperationSettings();
  }

  /** Returns the object with the settings used for calls to listConsumerOverrides. */
  public PagedCallSettings<
          ListConsumerOverridesRequest,
          ListConsumerOverridesResponse,
          ListConsumerOverridesPagedResponse>
      listConsumerOverridesSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).listConsumerOverridesSettings();
  }

  /** Returns the object with the settings used for calls to importConsumerOverrides. */
  public UnaryCallSettings<ImportConsumerOverridesRequest, Operation>
      importConsumerOverridesSettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).importConsumerOverridesSettings();
  }

  /** Returns the object with the settings used for calls to importConsumerOverrides. */
  public OperationCallSettings<
          ImportConsumerOverridesRequest,
          ImportConsumerOverridesResponse,
          ImportConsumerOverridesMetadata>
      importConsumerOverridesOperationSettings() {
    return ((ServiceUsageStubSettings) getStubSettings())
        .importConsumerOverridesOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateServiceIdentity. */
  public UnaryCallSettings<GenerateServiceIdentityRequest, Operation>
      generateServiceIdentitySettings() {
    return ((ServiceUsageStubSettings) getStubSettings()).generateServiceIdentitySettings();
  }

  /** Returns the object with the settings used for calls to generateServiceIdentity. */
  public OperationCallSettings<GenerateServiceIdentityRequest, ServiceIdentity, Empty>
      generateServiceIdentityOperationSettings() {
    return ((ServiceUsageStubSettings) getStubSettings())
        .generateServiceIdentityOperationSettings();
  }

  public static final ServiceUsageSettings create(ServiceUsageStubSettings stub)
      throws IOException {
    return new ServiceUsageSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ServiceUsageStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ServiceUsageStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ServiceUsageStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ServiceUsageStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ServiceUsageStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ServiceUsageStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ServiceUsageStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ServiceUsageStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ServiceUsageSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ServiceUsageSettings. */
  public static class Builder extends ClientSettings.Builder<ServiceUsageSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ServiceUsageStubSettings.newBuilder(clientContext));
    }

    protected Builder(ServiceUsageSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ServiceUsageStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ServiceUsageStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ServiceUsageStubSettings.newHttpJsonBuilder());
    }

    public ServiceUsageStubSettings.Builder getStubSettingsBuilder() {
      return ((ServiceUsageStubSettings.Builder) getStubSettings());
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

    /**
     * Returns the builder for the settings used for calls to enableService.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<EnableServiceRequest, Operation> enableServiceSettings() {
      return getStubSettingsBuilder().enableServiceSettings();
    }

    /**
     * Returns the builder for the settings used for calls to enableService.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public OperationCallSettings.Builder<EnableServiceRequest, Empty, OperationMetadata>
        enableServiceOperationSettings() {
      return getStubSettingsBuilder().enableServiceOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to disableService.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<DisableServiceRequest, Operation> disableServiceSettings() {
      return getStubSettingsBuilder().disableServiceSettings();
    }

    /**
     * Returns the builder for the settings used for calls to disableService.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public OperationCallSettings.Builder<DisableServiceRequest, Empty, OperationMetadata>
        disableServiceOperationSettings() {
      return getStubSettingsBuilder().disableServiceOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to getService.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings() {
      return getStubSettingsBuilder().getServiceSettings();
    }

    /**
     * Returns the builder for the settings used for calls to listServices.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return getStubSettingsBuilder().listServicesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to batchEnableServices.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<BatchEnableServicesRequest, Operation>
        batchEnableServicesSettings() {
      return getStubSettingsBuilder().batchEnableServicesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to batchEnableServices.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public OperationCallSettings.Builder<BatchEnableServicesRequest, Empty, OperationMetadata>
        batchEnableServicesOperationSettings() {
      return getStubSettingsBuilder().batchEnableServicesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listConsumerQuotaMetrics. */
    public PagedCallSettings.Builder<
            ListConsumerQuotaMetricsRequest,
            ListConsumerQuotaMetricsResponse,
            ListConsumerQuotaMetricsPagedResponse>
        listConsumerQuotaMetricsSettings() {
      return getStubSettingsBuilder().listConsumerQuotaMetricsSettings();
    }

    /** Returns the builder for the settings used for calls to getConsumerQuotaMetric. */
    public UnaryCallSettings.Builder<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
        getConsumerQuotaMetricSettings() {
      return getStubSettingsBuilder().getConsumerQuotaMetricSettings();
    }

    /** Returns the builder for the settings used for calls to getConsumerQuotaLimit. */
    public UnaryCallSettings.Builder<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
        getConsumerQuotaLimitSettings() {
      return getStubSettingsBuilder().getConsumerQuotaLimitSettings();
    }

    /** Returns the builder for the settings used for calls to createAdminOverride. */
    public UnaryCallSettings.Builder<CreateAdminOverrideRequest, Operation>
        createAdminOverrideSettings() {
      return getStubSettingsBuilder().createAdminOverrideSettings();
    }

    /** Returns the builder for the settings used for calls to createAdminOverride. */
    public OperationCallSettings.Builder<
            CreateAdminOverrideRequest, QuotaOverride, OperationMetadata>
        createAdminOverrideOperationSettings() {
      return getStubSettingsBuilder().createAdminOverrideOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAdminOverride. */
    public UnaryCallSettings.Builder<UpdateAdminOverrideRequest, Operation>
        updateAdminOverrideSettings() {
      return getStubSettingsBuilder().updateAdminOverrideSettings();
    }

    /** Returns the builder for the settings used for calls to updateAdminOverride. */
    public OperationCallSettings.Builder<
            UpdateAdminOverrideRequest, QuotaOverride, OperationMetadata>
        updateAdminOverrideOperationSettings() {
      return getStubSettingsBuilder().updateAdminOverrideOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAdminOverride. */
    public UnaryCallSettings.Builder<DeleteAdminOverrideRequest, Operation>
        deleteAdminOverrideSettings() {
      return getStubSettingsBuilder().deleteAdminOverrideSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAdminOverride. */
    public OperationCallSettings.Builder<DeleteAdminOverrideRequest, Empty, OperationMetadata>
        deleteAdminOverrideOperationSettings() {
      return getStubSettingsBuilder().deleteAdminOverrideOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listAdminOverrides. */
    public PagedCallSettings.Builder<
            ListAdminOverridesRequest, ListAdminOverridesResponse, ListAdminOverridesPagedResponse>
        listAdminOverridesSettings() {
      return getStubSettingsBuilder().listAdminOverridesSettings();
    }

    /** Returns the builder for the settings used for calls to importAdminOverrides. */
    public UnaryCallSettings.Builder<ImportAdminOverridesRequest, Operation>
        importAdminOverridesSettings() {
      return getStubSettingsBuilder().importAdminOverridesSettings();
    }

    /** Returns the builder for the settings used for calls to importAdminOverrides. */
    public OperationCallSettings.Builder<
            ImportAdminOverridesRequest, ImportAdminOverridesResponse, ImportAdminOverridesMetadata>
        importAdminOverridesOperationSettings() {
      return getStubSettingsBuilder().importAdminOverridesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createConsumerOverride. */
    public UnaryCallSettings.Builder<CreateConsumerOverrideRequest, Operation>
        createConsumerOverrideSettings() {
      return getStubSettingsBuilder().createConsumerOverrideSettings();
    }

    /** Returns the builder for the settings used for calls to createConsumerOverride. */
    public OperationCallSettings.Builder<
            CreateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
        createConsumerOverrideOperationSettings() {
      return getStubSettingsBuilder().createConsumerOverrideOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateConsumerOverride. */
    public UnaryCallSettings.Builder<UpdateConsumerOverrideRequest, Operation>
        updateConsumerOverrideSettings() {
      return getStubSettingsBuilder().updateConsumerOverrideSettings();
    }

    /** Returns the builder for the settings used for calls to updateConsumerOverride. */
    public OperationCallSettings.Builder<
            UpdateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
        updateConsumerOverrideOperationSettings() {
      return getStubSettingsBuilder().updateConsumerOverrideOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConsumerOverride. */
    public UnaryCallSettings.Builder<DeleteConsumerOverrideRequest, Operation>
        deleteConsumerOverrideSettings() {
      return getStubSettingsBuilder().deleteConsumerOverrideSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConsumerOverride. */
    public OperationCallSettings.Builder<DeleteConsumerOverrideRequest, Empty, OperationMetadata>
        deleteConsumerOverrideOperationSettings() {
      return getStubSettingsBuilder().deleteConsumerOverrideOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listConsumerOverrides. */
    public PagedCallSettings.Builder<
            ListConsumerOverridesRequest,
            ListConsumerOverridesResponse,
            ListConsumerOverridesPagedResponse>
        listConsumerOverridesSettings() {
      return getStubSettingsBuilder().listConsumerOverridesSettings();
    }

    /** Returns the builder for the settings used for calls to importConsumerOverrides. */
    public UnaryCallSettings.Builder<ImportConsumerOverridesRequest, Operation>
        importConsumerOverridesSettings() {
      return getStubSettingsBuilder().importConsumerOverridesSettings();
    }

    /** Returns the builder for the settings used for calls to importConsumerOverrides. */
    public OperationCallSettings.Builder<
            ImportConsumerOverridesRequest,
            ImportConsumerOverridesResponse,
            ImportConsumerOverridesMetadata>
        importConsumerOverridesOperationSettings() {
      return getStubSettingsBuilder().importConsumerOverridesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateServiceIdentity. */
    public UnaryCallSettings.Builder<GenerateServiceIdentityRequest, Operation>
        generateServiceIdentitySettings() {
      return getStubSettingsBuilder().generateServiceIdentitySettings();
    }

    /** Returns the builder for the settings used for calls to generateServiceIdentity. */
    public OperationCallSettings.Builder<GenerateServiceIdentityRequest, ServiceIdentity, Empty>
        generateServiceIdentityOperationSettings() {
      return getStubSettingsBuilder().generateServiceIdentityOperationSettings();
    }

    @Override
    public ServiceUsageSettings build() throws IOException {
      return new ServiceUsageSettings(this);
    }
  }
}
