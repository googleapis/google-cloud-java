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

package com.google.cloud.discoveryengine.v1beta;

import static com.google.cloud.discoveryengine.v1beta.LicenseConfigServiceClient.ListLicenseConfigsPagedResponse;

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
import com.google.cloud.discoveryengine.v1beta.stub.LicenseConfigServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LicenseConfigServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (discoveryengine.googleapis.com) and default port (443) are
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
 * of createLicenseConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LicenseConfigServiceSettings.Builder licenseConfigServiceSettingsBuilder =
 *     LicenseConfigServiceSettings.newBuilder();
 * licenseConfigServiceSettingsBuilder
 *     .createLicenseConfigSettings()
 *     .setRetrySettings(
 *         licenseConfigServiceSettingsBuilder
 *             .createLicenseConfigSettings()
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
 * LicenseConfigServiceSettings licenseConfigServiceSettings =
 *     licenseConfigServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class LicenseConfigServiceSettings extends ClientSettings<LicenseConfigServiceSettings> {

  /** Returns the object with the settings used for calls to createLicenseConfig. */
  public UnaryCallSettings<CreateLicenseConfigRequest, LicenseConfig>
      createLicenseConfigSettings() {
    return ((LicenseConfigServiceStubSettings) getStubSettings()).createLicenseConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateLicenseConfig. */
  public UnaryCallSettings<UpdateLicenseConfigRequest, LicenseConfig>
      updateLicenseConfigSettings() {
    return ((LicenseConfigServiceStubSettings) getStubSettings()).updateLicenseConfigSettings();
  }

  /** Returns the object with the settings used for calls to getLicenseConfig. */
  public UnaryCallSettings<GetLicenseConfigRequest, LicenseConfig> getLicenseConfigSettings() {
    return ((LicenseConfigServiceStubSettings) getStubSettings()).getLicenseConfigSettings();
  }

  /** Returns the object with the settings used for calls to listLicenseConfigs. */
  public PagedCallSettings<
          ListLicenseConfigsRequest, ListLicenseConfigsResponse, ListLicenseConfigsPagedResponse>
      listLicenseConfigsSettings() {
    return ((LicenseConfigServiceStubSettings) getStubSettings()).listLicenseConfigsSettings();
  }

  /** Returns the object with the settings used for calls to distributeLicenseConfig. */
  public UnaryCallSettings<DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>
      distributeLicenseConfigSettings() {
    return ((LicenseConfigServiceStubSettings) getStubSettings()).distributeLicenseConfigSettings();
  }

  /** Returns the object with the settings used for calls to retractLicenseConfig. */
  public UnaryCallSettings<RetractLicenseConfigRequest, RetractLicenseConfigResponse>
      retractLicenseConfigSettings() {
    return ((LicenseConfigServiceStubSettings) getStubSettings()).retractLicenseConfigSettings();
  }

  public static final LicenseConfigServiceSettings create(LicenseConfigServiceStubSettings stub)
      throws IOException {
    return new LicenseConfigServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return LicenseConfigServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return LicenseConfigServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return LicenseConfigServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return LicenseConfigServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return LicenseConfigServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return LicenseConfigServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return LicenseConfigServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LicenseConfigServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected LicenseConfigServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for LicenseConfigServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<LicenseConfigServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(LicenseConfigServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(LicenseConfigServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(LicenseConfigServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(LicenseConfigServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(LicenseConfigServiceStubSettings.newHttpJsonBuilder());
    }

    public LicenseConfigServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((LicenseConfigServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createLicenseConfig. */
    public UnaryCallSettings.Builder<CreateLicenseConfigRequest, LicenseConfig>
        createLicenseConfigSettings() {
      return getStubSettingsBuilder().createLicenseConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateLicenseConfig. */
    public UnaryCallSettings.Builder<UpdateLicenseConfigRequest, LicenseConfig>
        updateLicenseConfigSettings() {
      return getStubSettingsBuilder().updateLicenseConfigSettings();
    }

    /** Returns the builder for the settings used for calls to getLicenseConfig. */
    public UnaryCallSettings.Builder<GetLicenseConfigRequest, LicenseConfig>
        getLicenseConfigSettings() {
      return getStubSettingsBuilder().getLicenseConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listLicenseConfigs. */
    public PagedCallSettings.Builder<
            ListLicenseConfigsRequest, ListLicenseConfigsResponse, ListLicenseConfigsPagedResponse>
        listLicenseConfigsSettings() {
      return getStubSettingsBuilder().listLicenseConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to distributeLicenseConfig. */
    public UnaryCallSettings.Builder<
            DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>
        distributeLicenseConfigSettings() {
      return getStubSettingsBuilder().distributeLicenseConfigSettings();
    }

    /** Returns the builder for the settings used for calls to retractLicenseConfig. */
    public UnaryCallSettings.Builder<RetractLicenseConfigRequest, RetractLicenseConfigResponse>
        retractLicenseConfigSettings() {
      return getStubSettingsBuilder().retractLicenseConfigSettings();
    }

    @Override
    public LicenseConfigServiceSettings build() throws IOException {
      return new LicenseConfigServiceSettings(this);
    }
  }
}
