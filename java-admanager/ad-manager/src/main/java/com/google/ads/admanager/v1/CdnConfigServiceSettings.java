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

import static com.google.ads.admanager.v1.CdnConfigServiceClient.ListCdnConfigsPagedResponse;

import com.google.ads.admanager.v1.stub.CdnConfigServiceStubSettings;
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CdnConfigServiceClient}.
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
 * of getCdnConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CdnConfigServiceSettings.Builder cdnConfigServiceSettingsBuilder =
 *     CdnConfigServiceSettings.newBuilder();
 * cdnConfigServiceSettingsBuilder
 *     .getCdnConfigSettings()
 *     .setRetrySettings(
 *         cdnConfigServiceSettingsBuilder
 *             .getCdnConfigSettings()
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
 * CdnConfigServiceSettings cdnConfigServiceSettings = cdnConfigServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class CdnConfigServiceSettings extends ClientSettings<CdnConfigServiceSettings> {

  /** Returns the object with the settings used for calls to getCdnConfig. */
  public UnaryCallSettings<GetCdnConfigRequest, CdnConfig> getCdnConfigSettings() {
    return ((CdnConfigServiceStubSettings) getStubSettings()).getCdnConfigSettings();
  }

  /** Returns the object with the settings used for calls to listCdnConfigs. */
  public PagedCallSettings<
          ListCdnConfigsRequest, ListCdnConfigsResponse, ListCdnConfigsPagedResponse>
      listCdnConfigsSettings() {
    return ((CdnConfigServiceStubSettings) getStubSettings()).listCdnConfigsSettings();
  }

  /** Returns the object with the settings used for calls to createCdnConfig. */
  public UnaryCallSettings<CreateCdnConfigRequest, CdnConfig> createCdnConfigSettings() {
    return ((CdnConfigServiceStubSettings) getStubSettings()).createCdnConfigSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateCdnConfigs. */
  public UnaryCallSettings<BatchCreateCdnConfigsRequest, BatchCreateCdnConfigsResponse>
      batchCreateCdnConfigsSettings() {
    return ((CdnConfigServiceStubSettings) getStubSettings()).batchCreateCdnConfigsSettings();
  }

  /** Returns the object with the settings used for calls to updateCdnConfig. */
  public UnaryCallSettings<UpdateCdnConfigRequest, CdnConfig> updateCdnConfigSettings() {
    return ((CdnConfigServiceStubSettings) getStubSettings()).updateCdnConfigSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateCdnConfigs. */
  public UnaryCallSettings<BatchUpdateCdnConfigsRequest, BatchUpdateCdnConfigsResponse>
      batchUpdateCdnConfigsSettings() {
    return ((CdnConfigServiceStubSettings) getStubSettings()).batchUpdateCdnConfigsSettings();
  }

  /** Returns the object with the settings used for calls to batchActivateCdnConfigs. */
  public UnaryCallSettings<BatchActivateCdnConfigsRequest, BatchActivateCdnConfigsResponse>
      batchActivateCdnConfigsSettings() {
    return ((CdnConfigServiceStubSettings) getStubSettings()).batchActivateCdnConfigsSettings();
  }

  /** Returns the object with the settings used for calls to batchArchiveCdnConfigs. */
  public UnaryCallSettings<BatchArchiveCdnConfigsRequest, BatchArchiveCdnConfigsResponse>
      batchArchiveCdnConfigsSettings() {
    return ((CdnConfigServiceStubSettings) getStubSettings()).batchArchiveCdnConfigsSettings();
  }

  public static final CdnConfigServiceSettings create(CdnConfigServiceStubSettings stub)
      throws IOException {
    return new CdnConfigServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CdnConfigServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CdnConfigServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CdnConfigServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CdnConfigServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CdnConfigServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CdnConfigServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CdnConfigServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected CdnConfigServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CdnConfigServiceSettings. */
  public static class Builder extends ClientSettings.Builder<CdnConfigServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(CdnConfigServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(CdnConfigServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CdnConfigServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CdnConfigServiceStubSettings.newBuilder());
    }

    public CdnConfigServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((CdnConfigServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getCdnConfig. */
    public UnaryCallSettings.Builder<GetCdnConfigRequest, CdnConfig> getCdnConfigSettings() {
      return getStubSettingsBuilder().getCdnConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listCdnConfigs. */
    public PagedCallSettings.Builder<
            ListCdnConfigsRequest, ListCdnConfigsResponse, ListCdnConfigsPagedResponse>
        listCdnConfigsSettings() {
      return getStubSettingsBuilder().listCdnConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to createCdnConfig. */
    public UnaryCallSettings.Builder<CreateCdnConfigRequest, CdnConfig> createCdnConfigSettings() {
      return getStubSettingsBuilder().createCdnConfigSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateCdnConfigs. */
    public UnaryCallSettings.Builder<BatchCreateCdnConfigsRequest, BatchCreateCdnConfigsResponse>
        batchCreateCdnConfigsSettings() {
      return getStubSettingsBuilder().batchCreateCdnConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to updateCdnConfig. */
    public UnaryCallSettings.Builder<UpdateCdnConfigRequest, CdnConfig> updateCdnConfigSettings() {
      return getStubSettingsBuilder().updateCdnConfigSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateCdnConfigs. */
    public UnaryCallSettings.Builder<BatchUpdateCdnConfigsRequest, BatchUpdateCdnConfigsResponse>
        batchUpdateCdnConfigsSettings() {
      return getStubSettingsBuilder().batchUpdateCdnConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to batchActivateCdnConfigs. */
    public UnaryCallSettings.Builder<
            BatchActivateCdnConfigsRequest, BatchActivateCdnConfigsResponse>
        batchActivateCdnConfigsSettings() {
      return getStubSettingsBuilder().batchActivateCdnConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to batchArchiveCdnConfigs. */
    public UnaryCallSettings.Builder<BatchArchiveCdnConfigsRequest, BatchArchiveCdnConfigsResponse>
        batchArchiveCdnConfigsSettings() {
      return getStubSettingsBuilder().batchArchiveCdnConfigsSettings();
    }

    @Override
    public CdnConfigServiceSettings build() throws IOException {
      return new CdnConfigServiceSettings(this);
    }
  }
}
