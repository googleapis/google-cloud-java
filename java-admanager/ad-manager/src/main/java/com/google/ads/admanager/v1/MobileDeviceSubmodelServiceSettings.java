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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.MobileDeviceSubmodelServiceClient.ListMobileDeviceSubmodelsPagedResponse;

import com.google.ads.admanager.v1.stub.MobileDeviceSubmodelServiceStubSettings;
import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MobileDeviceSubmodelServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getMobileDeviceSubmodel:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MobileDeviceSubmodelServiceSettings.Builder mobileDeviceSubmodelServiceSettingsBuilder =
 *     MobileDeviceSubmodelServiceSettings.newBuilder();
 * mobileDeviceSubmodelServiceSettingsBuilder
 *     .getMobileDeviceSubmodelSettings()
 *     .setRetrySettings(
 *         mobileDeviceSubmodelServiceSettingsBuilder
 *             .getMobileDeviceSubmodelSettings()
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
 * MobileDeviceSubmodelServiceSettings mobileDeviceSubmodelServiceSettings =
 *     mobileDeviceSubmodelServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
public class MobileDeviceSubmodelServiceSettings
    extends ClientSettings<MobileDeviceSubmodelServiceSettings> {

  /** Returns the object with the settings used for calls to getMobileDeviceSubmodel. */
  public UnaryCallSettings<GetMobileDeviceSubmodelRequest, MobileDeviceSubmodel>
      getMobileDeviceSubmodelSettings() {
    return ((MobileDeviceSubmodelServiceStubSettings) getStubSettings())
        .getMobileDeviceSubmodelSettings();
  }

  /** Returns the object with the settings used for calls to listMobileDeviceSubmodels. */
  public PagedCallSettings<
          ListMobileDeviceSubmodelsRequest,
          ListMobileDeviceSubmodelsResponse,
          ListMobileDeviceSubmodelsPagedResponse>
      listMobileDeviceSubmodelsSettings() {
    return ((MobileDeviceSubmodelServiceStubSettings) getStubSettings())
        .listMobileDeviceSubmodelsSettings();
  }

  public static final MobileDeviceSubmodelServiceSettings create(
      MobileDeviceSubmodelServiceStubSettings stub) throws IOException {
    return new MobileDeviceSubmodelServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MobileDeviceSubmodelServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MobileDeviceSubmodelServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MobileDeviceSubmodelServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MobileDeviceSubmodelServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return MobileDeviceSubmodelServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MobileDeviceSubmodelServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MobileDeviceSubmodelServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MobileDeviceSubmodelServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MobileDeviceSubmodelServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<MobileDeviceSubmodelServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MobileDeviceSubmodelServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(MobileDeviceSubmodelServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MobileDeviceSubmodelServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MobileDeviceSubmodelServiceStubSettings.newBuilder());
    }

    public MobileDeviceSubmodelServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((MobileDeviceSubmodelServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getMobileDeviceSubmodel. */
    public UnaryCallSettings.Builder<GetMobileDeviceSubmodelRequest, MobileDeviceSubmodel>
        getMobileDeviceSubmodelSettings() {
      return getStubSettingsBuilder().getMobileDeviceSubmodelSettings();
    }

    /** Returns the builder for the settings used for calls to listMobileDeviceSubmodels. */
    public PagedCallSettings.Builder<
            ListMobileDeviceSubmodelsRequest,
            ListMobileDeviceSubmodelsResponse,
            ListMobileDeviceSubmodelsPagedResponse>
        listMobileDeviceSubmodelsSettings() {
      return getStubSettingsBuilder().listMobileDeviceSubmodelsSettings();
    }

    @Override
    public MobileDeviceSubmodelServiceSettings build() throws IOException {
      return new MobileDeviceSubmodelServiceSettings(this);
    }
  }
}
