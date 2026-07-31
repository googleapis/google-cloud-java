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

import static com.google.ads.admanager.v1.AdRuleServiceClient.ListAdRulesPagedResponse;

import com.google.ads.admanager.v1.stub.AdRuleServiceStubSettings;
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
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AdRuleServiceClient}.
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
 * of getAdRule:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AdRuleServiceSettings.Builder adRuleServiceSettingsBuilder = AdRuleServiceSettings.newBuilder();
 * adRuleServiceSettingsBuilder
 *     .getAdRuleSettings()
 *     .setRetrySettings(
 *         adRuleServiceSettingsBuilder
 *             .getAdRuleSettings()
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
 * AdRuleServiceSettings adRuleServiceSettings = adRuleServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class AdRuleServiceSettings extends ClientSettings<AdRuleServiceSettings> {

  /** Returns the object with the settings used for calls to getAdRule. */
  public UnaryCallSettings<GetAdRuleRequest, AdRule> getAdRuleSettings() {
    return ((AdRuleServiceStubSettings) getStubSettings()).getAdRuleSettings();
  }

  /** Returns the object with the settings used for calls to listAdRules. */
  public PagedCallSettings<ListAdRulesRequest, ListAdRulesResponse, ListAdRulesPagedResponse>
      listAdRulesSettings() {
    return ((AdRuleServiceStubSettings) getStubSettings()).listAdRulesSettings();
  }

  /** Returns the object with the settings used for calls to createAdRule. */
  public UnaryCallSettings<CreateAdRuleRequest, AdRule> createAdRuleSettings() {
    return ((AdRuleServiceStubSettings) getStubSettings()).createAdRuleSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateAdRules. */
  public UnaryCallSettings<BatchCreateAdRulesRequest, BatchCreateAdRulesResponse>
      batchCreateAdRulesSettings() {
    return ((AdRuleServiceStubSettings) getStubSettings()).batchCreateAdRulesSettings();
  }

  /** Returns the object with the settings used for calls to updateAdRule. */
  public UnaryCallSettings<UpdateAdRuleRequest, AdRule> updateAdRuleSettings() {
    return ((AdRuleServiceStubSettings) getStubSettings()).updateAdRuleSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateAdRules. */
  public UnaryCallSettings<BatchUpdateAdRulesRequest, BatchUpdateAdRulesResponse>
      batchUpdateAdRulesSettings() {
    return ((AdRuleServiceStubSettings) getStubSettings()).batchUpdateAdRulesSettings();
  }

  /** Returns the object with the settings used for calls to batchActivateAdRules. */
  public UnaryCallSettings<BatchActivateAdRulesRequest, BatchActivateAdRulesResponse>
      batchActivateAdRulesSettings() {
    return ((AdRuleServiceStubSettings) getStubSettings()).batchActivateAdRulesSettings();
  }

  /** Returns the object with the settings used for calls to batchDeactivateAdRules. */
  public UnaryCallSettings<BatchDeactivateAdRulesRequest, BatchDeactivateAdRulesResponse>
      batchDeactivateAdRulesSettings() {
    return ((AdRuleServiceStubSettings) getStubSettings()).batchDeactivateAdRulesSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteAdRules. */
  public UnaryCallSettings<BatchDeleteAdRulesRequest, Empty> batchDeleteAdRulesSettings() {
    return ((AdRuleServiceStubSettings) getStubSettings()).batchDeleteAdRulesSettings();
  }

  public static final AdRuleServiceSettings create(AdRuleServiceStubSettings stub)
      throws IOException {
    return new AdRuleServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AdRuleServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AdRuleServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AdRuleServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AdRuleServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AdRuleServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AdRuleServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AdRuleServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AdRuleServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AdRuleServiceSettings. */
  public static class Builder extends ClientSettings.Builder<AdRuleServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(AdRuleServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AdRuleServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AdRuleServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AdRuleServiceStubSettings.newBuilder());
    }

    public AdRuleServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AdRuleServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getAdRule. */
    public UnaryCallSettings.Builder<GetAdRuleRequest, AdRule> getAdRuleSettings() {
      return getStubSettingsBuilder().getAdRuleSettings();
    }

    /** Returns the builder for the settings used for calls to listAdRules. */
    public PagedCallSettings.Builder<
            ListAdRulesRequest, ListAdRulesResponse, ListAdRulesPagedResponse>
        listAdRulesSettings() {
      return getStubSettingsBuilder().listAdRulesSettings();
    }

    /** Returns the builder for the settings used for calls to createAdRule. */
    public UnaryCallSettings.Builder<CreateAdRuleRequest, AdRule> createAdRuleSettings() {
      return getStubSettingsBuilder().createAdRuleSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateAdRules. */
    public UnaryCallSettings.Builder<BatchCreateAdRulesRequest, BatchCreateAdRulesResponse>
        batchCreateAdRulesSettings() {
      return getStubSettingsBuilder().batchCreateAdRulesSettings();
    }

    /** Returns the builder for the settings used for calls to updateAdRule. */
    public UnaryCallSettings.Builder<UpdateAdRuleRequest, AdRule> updateAdRuleSettings() {
      return getStubSettingsBuilder().updateAdRuleSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateAdRules. */
    public UnaryCallSettings.Builder<BatchUpdateAdRulesRequest, BatchUpdateAdRulesResponse>
        batchUpdateAdRulesSettings() {
      return getStubSettingsBuilder().batchUpdateAdRulesSettings();
    }

    /** Returns the builder for the settings used for calls to batchActivateAdRules. */
    public UnaryCallSettings.Builder<BatchActivateAdRulesRequest, BatchActivateAdRulesResponse>
        batchActivateAdRulesSettings() {
      return getStubSettingsBuilder().batchActivateAdRulesSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeactivateAdRules. */
    public UnaryCallSettings.Builder<BatchDeactivateAdRulesRequest, BatchDeactivateAdRulesResponse>
        batchDeactivateAdRulesSettings() {
      return getStubSettingsBuilder().batchDeactivateAdRulesSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteAdRules. */
    public UnaryCallSettings.Builder<BatchDeleteAdRulesRequest, Empty>
        batchDeleteAdRulesSettings() {
      return getStubSettingsBuilder().batchDeleteAdRulesSettings();
    }

    @Override
    public AdRuleServiceSettings build() throws IOException {
      return new AdRuleServiceSettings(this);
    }
  }
}
