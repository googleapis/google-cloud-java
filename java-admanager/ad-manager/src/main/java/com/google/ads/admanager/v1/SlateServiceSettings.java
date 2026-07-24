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

import static com.google.ads.admanager.v1.SlateServiceClient.ListSlatesPagedResponse;

import com.google.ads.admanager.v1.stub.SlateServiceStubSettings;
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
 * Settings class to configure an instance of {@link SlateServiceClient}.
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
 * of getSlate:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SlateServiceSettings.Builder slateServiceSettingsBuilder = SlateServiceSettings.newBuilder();
 * slateServiceSettingsBuilder
 *     .getSlateSettings()
 *     .setRetrySettings(
 *         slateServiceSettingsBuilder
 *             .getSlateSettings()
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
 * SlateServiceSettings slateServiceSettings = slateServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class SlateServiceSettings extends ClientSettings<SlateServiceSettings> {

  /** Returns the object with the settings used for calls to getSlate. */
  public UnaryCallSettings<GetSlateRequest, Slate> getSlateSettings() {
    return ((SlateServiceStubSettings) getStubSettings()).getSlateSettings();
  }

  /** Returns the object with the settings used for calls to listSlates. */
  public PagedCallSettings<ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>
      listSlatesSettings() {
    return ((SlateServiceStubSettings) getStubSettings()).listSlatesSettings();
  }

  /** Returns the object with the settings used for calls to createSlate. */
  public UnaryCallSettings<CreateSlateRequest, Slate> createSlateSettings() {
    return ((SlateServiceStubSettings) getStubSettings()).createSlateSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateSlates. */
  public UnaryCallSettings<BatchCreateSlatesRequest, BatchCreateSlatesResponse>
      batchCreateSlatesSettings() {
    return ((SlateServiceStubSettings) getStubSettings()).batchCreateSlatesSettings();
  }

  /** Returns the object with the settings used for calls to updateSlate. */
  public UnaryCallSettings<UpdateSlateRequest, Slate> updateSlateSettings() {
    return ((SlateServiceStubSettings) getStubSettings()).updateSlateSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateSlates. */
  public UnaryCallSettings<BatchUpdateSlatesRequest, BatchUpdateSlatesResponse>
      batchUpdateSlatesSettings() {
    return ((SlateServiceStubSettings) getStubSettings()).batchUpdateSlatesSettings();
  }

  /** Returns the object with the settings used for calls to batchArchiveSlates. */
  public UnaryCallSettings<BatchArchiveSlatesRequest, BatchArchiveSlatesResponse>
      batchArchiveSlatesSettings() {
    return ((SlateServiceStubSettings) getStubSettings()).batchArchiveSlatesSettings();
  }

  /** Returns the object with the settings used for calls to batchUnarchiveSlates. */
  public UnaryCallSettings<BatchUnarchiveSlatesRequest, BatchUnarchiveSlatesResponse>
      batchUnarchiveSlatesSettings() {
    return ((SlateServiceStubSettings) getStubSettings()).batchUnarchiveSlatesSettings();
  }

  public static final SlateServiceSettings create(SlateServiceStubSettings stub)
      throws IOException {
    return new SlateServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SlateServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SlateServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SlateServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SlateServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SlateServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SlateServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SlateServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SlateServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SlateServiceSettings. */
  public static class Builder extends ClientSettings.Builder<SlateServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(SlateServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(SlateServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SlateServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SlateServiceStubSettings.newBuilder());
    }

    public SlateServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((SlateServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getSlate. */
    public UnaryCallSettings.Builder<GetSlateRequest, Slate> getSlateSettings() {
      return getStubSettingsBuilder().getSlateSettings();
    }

    /** Returns the builder for the settings used for calls to listSlates. */
    public PagedCallSettings.Builder<ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>
        listSlatesSettings() {
      return getStubSettingsBuilder().listSlatesSettings();
    }

    /** Returns the builder for the settings used for calls to createSlate. */
    public UnaryCallSettings.Builder<CreateSlateRequest, Slate> createSlateSettings() {
      return getStubSettingsBuilder().createSlateSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateSlates. */
    public UnaryCallSettings.Builder<BatchCreateSlatesRequest, BatchCreateSlatesResponse>
        batchCreateSlatesSettings() {
      return getStubSettingsBuilder().batchCreateSlatesSettings();
    }

    /** Returns the builder for the settings used for calls to updateSlate. */
    public UnaryCallSettings.Builder<UpdateSlateRequest, Slate> updateSlateSettings() {
      return getStubSettingsBuilder().updateSlateSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateSlates. */
    public UnaryCallSettings.Builder<BatchUpdateSlatesRequest, BatchUpdateSlatesResponse>
        batchUpdateSlatesSettings() {
      return getStubSettingsBuilder().batchUpdateSlatesSettings();
    }

    /** Returns the builder for the settings used for calls to batchArchiveSlates. */
    public UnaryCallSettings.Builder<BatchArchiveSlatesRequest, BatchArchiveSlatesResponse>
        batchArchiveSlatesSettings() {
      return getStubSettingsBuilder().batchArchiveSlatesSettings();
    }

    /** Returns the builder for the settings used for calls to batchUnarchiveSlates. */
    public UnaryCallSettings.Builder<BatchUnarchiveSlatesRequest, BatchUnarchiveSlatesResponse>
        batchUnarchiveSlatesSettings() {
      return getStubSettingsBuilder().batchUnarchiveSlatesSettings();
    }

    @Override
    public SlateServiceSettings build() throws IOException {
      return new SlateServiceSettings(this);
    }
  }
}
