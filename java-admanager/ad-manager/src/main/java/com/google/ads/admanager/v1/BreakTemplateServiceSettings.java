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

import static com.google.ads.admanager.v1.BreakTemplateServiceClient.ListBreakTemplatesPagedResponse;

import com.google.ads.admanager.v1.stub.BreakTemplateServiceStubSettings;
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
 * Settings class to configure an instance of {@link BreakTemplateServiceClient}.
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
 * of getBreakTemplate:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BreakTemplateServiceSettings.Builder breakTemplateServiceSettingsBuilder =
 *     BreakTemplateServiceSettings.newBuilder();
 * breakTemplateServiceSettingsBuilder
 *     .getBreakTemplateSettings()
 *     .setRetrySettings(
 *         breakTemplateServiceSettingsBuilder
 *             .getBreakTemplateSettings()
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
 * BreakTemplateServiceSettings breakTemplateServiceSettings =
 *     breakTemplateServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class BreakTemplateServiceSettings extends ClientSettings<BreakTemplateServiceSettings> {

  /** Returns the object with the settings used for calls to getBreakTemplate. */
  public UnaryCallSettings<GetBreakTemplateRequest, BreakTemplate> getBreakTemplateSettings() {
    return ((BreakTemplateServiceStubSettings) getStubSettings()).getBreakTemplateSettings();
  }

  /** Returns the object with the settings used for calls to listBreakTemplates. */
  public PagedCallSettings<
          ListBreakTemplatesRequest, ListBreakTemplatesResponse, ListBreakTemplatesPagedResponse>
      listBreakTemplatesSettings() {
    return ((BreakTemplateServiceStubSettings) getStubSettings()).listBreakTemplatesSettings();
  }

  /** Returns the object with the settings used for calls to createBreakTemplate. */
  public UnaryCallSettings<CreateBreakTemplateRequest, BreakTemplate>
      createBreakTemplateSettings() {
    return ((BreakTemplateServiceStubSettings) getStubSettings()).createBreakTemplateSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateBreakTemplates. */
  public UnaryCallSettings<BatchCreateBreakTemplatesRequest, BatchCreateBreakTemplatesResponse>
      batchCreateBreakTemplatesSettings() {
    return ((BreakTemplateServiceStubSettings) getStubSettings())
        .batchCreateBreakTemplatesSettings();
  }

  /** Returns the object with the settings used for calls to updateBreakTemplate. */
  public UnaryCallSettings<UpdateBreakTemplateRequest, BreakTemplate>
      updateBreakTemplateSettings() {
    return ((BreakTemplateServiceStubSettings) getStubSettings()).updateBreakTemplateSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateBreakTemplates. */
  public UnaryCallSettings<BatchUpdateBreakTemplatesRequest, BatchUpdateBreakTemplatesResponse>
      batchUpdateBreakTemplatesSettings() {
    return ((BreakTemplateServiceStubSettings) getStubSettings())
        .batchUpdateBreakTemplatesSettings();
  }

  public static final BreakTemplateServiceSettings create(BreakTemplateServiceStubSettings stub)
      throws IOException {
    return new BreakTemplateServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BreakTemplateServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BreakTemplateServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BreakTemplateServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BreakTemplateServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return BreakTemplateServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BreakTemplateServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BreakTemplateServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BreakTemplateServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BreakTemplateServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<BreakTemplateServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(BreakTemplateServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(BreakTemplateServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BreakTemplateServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(BreakTemplateServiceStubSettings.newBuilder());
    }

    public BreakTemplateServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((BreakTemplateServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getBreakTemplate. */
    public UnaryCallSettings.Builder<GetBreakTemplateRequest, BreakTemplate>
        getBreakTemplateSettings() {
      return getStubSettingsBuilder().getBreakTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to listBreakTemplates. */
    public PagedCallSettings.Builder<
            ListBreakTemplatesRequest, ListBreakTemplatesResponse, ListBreakTemplatesPagedResponse>
        listBreakTemplatesSettings() {
      return getStubSettingsBuilder().listBreakTemplatesSettings();
    }

    /** Returns the builder for the settings used for calls to createBreakTemplate. */
    public UnaryCallSettings.Builder<CreateBreakTemplateRequest, BreakTemplate>
        createBreakTemplateSettings() {
      return getStubSettingsBuilder().createBreakTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateBreakTemplates. */
    public UnaryCallSettings.Builder<
            BatchCreateBreakTemplatesRequest, BatchCreateBreakTemplatesResponse>
        batchCreateBreakTemplatesSettings() {
      return getStubSettingsBuilder().batchCreateBreakTemplatesSettings();
    }

    /** Returns the builder for the settings used for calls to updateBreakTemplate. */
    public UnaryCallSettings.Builder<UpdateBreakTemplateRequest, BreakTemplate>
        updateBreakTemplateSettings() {
      return getStubSettingsBuilder().updateBreakTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateBreakTemplates. */
    public UnaryCallSettings.Builder<
            BatchUpdateBreakTemplatesRequest, BatchUpdateBreakTemplatesResponse>
        batchUpdateBreakTemplatesSettings() {
      return getStubSettingsBuilder().batchUpdateBreakTemplatesSettings();
    }

    @Override
    public BreakTemplateServiceSettings build() throws IOException {
      return new BreakTemplateServiceSettings(this);
    }
  }
}
