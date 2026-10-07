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

import static com.google.ads.admanager.v1.NativeStyleServiceClient.ListNativeStylesPagedResponse;

import com.google.ads.admanager.v1.stub.NativeStyleServiceStubSettings;
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
 * Settings class to configure an instance of {@link NativeStyleServiceClient}.
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
 * of getNativeStyle:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NativeStyleServiceSettings.Builder nativeStyleServiceSettingsBuilder =
 *     NativeStyleServiceSettings.newBuilder();
 * nativeStyleServiceSettingsBuilder
 *     .getNativeStyleSettings()
 *     .setRetrySettings(
 *         nativeStyleServiceSettingsBuilder
 *             .getNativeStyleSettings()
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
 * NativeStyleServiceSettings nativeStyleServiceSettings =
 *     nativeStyleServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class NativeStyleServiceSettings extends ClientSettings<NativeStyleServiceSettings> {

  /** Returns the object with the settings used for calls to getNativeStyle. */
  public UnaryCallSettings<GetNativeStyleRequest, NativeStyle> getNativeStyleSettings() {
    return ((NativeStyleServiceStubSettings) getStubSettings()).getNativeStyleSettings();
  }

  /** Returns the object with the settings used for calls to listNativeStyles. */
  public PagedCallSettings<
          ListNativeStylesRequest, ListNativeStylesResponse, ListNativeStylesPagedResponse>
      listNativeStylesSettings() {
    return ((NativeStyleServiceStubSettings) getStubSettings()).listNativeStylesSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateNativeStyles. */
  public UnaryCallSettings<BatchCreateNativeStylesRequest, BatchCreateNativeStylesResponse>
      batchCreateNativeStylesSettings() {
    return ((NativeStyleServiceStubSettings) getStubSettings()).batchCreateNativeStylesSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateNativeStyles. */
  public UnaryCallSettings<BatchUpdateNativeStylesRequest, BatchUpdateNativeStylesResponse>
      batchUpdateNativeStylesSettings() {
    return ((NativeStyleServiceStubSettings) getStubSettings()).batchUpdateNativeStylesSettings();
  }

  /** Returns the object with the settings used for calls to batchActivateNativeStyles. */
  public UnaryCallSettings<BatchActivateNativeStylesRequest, BatchActivateNativeStylesResponse>
      batchActivateNativeStylesSettings() {
    return ((NativeStyleServiceStubSettings) getStubSettings()).batchActivateNativeStylesSettings();
  }

  /** Returns the object with the settings used for calls to batchDeactivateNativeStyles. */
  public UnaryCallSettings<BatchDeactivateNativeStylesRequest, BatchDeactivateNativeStylesResponse>
      batchDeactivateNativeStylesSettings() {
    return ((NativeStyleServiceStubSettings) getStubSettings())
        .batchDeactivateNativeStylesSettings();
  }

  /** Returns the object with the settings used for calls to batchArchiveNativeStyles. */
  public UnaryCallSettings<BatchArchiveNativeStylesRequest, BatchArchiveNativeStylesResponse>
      batchArchiveNativeStylesSettings() {
    return ((NativeStyleServiceStubSettings) getStubSettings()).batchArchiveNativeStylesSettings();
  }

  public static final NativeStyleServiceSettings create(NativeStyleServiceStubSettings stub)
      throws IOException {
    return new NativeStyleServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NativeStyleServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NativeStyleServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NativeStyleServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NativeStyleServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return NativeStyleServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NativeStyleServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NativeStyleServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NativeStyleServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NativeStyleServiceSettings. */
  public static class Builder extends ClientSettings.Builder<NativeStyleServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(NativeStyleServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(NativeStyleServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NativeStyleServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(NativeStyleServiceStubSettings.newBuilder());
    }

    public NativeStyleServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((NativeStyleServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getNativeStyle. */
    public UnaryCallSettings.Builder<GetNativeStyleRequest, NativeStyle> getNativeStyleSettings() {
      return getStubSettingsBuilder().getNativeStyleSettings();
    }

    /** Returns the builder for the settings used for calls to listNativeStyles. */
    public PagedCallSettings.Builder<
            ListNativeStylesRequest, ListNativeStylesResponse, ListNativeStylesPagedResponse>
        listNativeStylesSettings() {
      return getStubSettingsBuilder().listNativeStylesSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateNativeStyles. */
    public UnaryCallSettings.Builder<
            BatchCreateNativeStylesRequest, BatchCreateNativeStylesResponse>
        batchCreateNativeStylesSettings() {
      return getStubSettingsBuilder().batchCreateNativeStylesSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateNativeStyles. */
    public UnaryCallSettings.Builder<
            BatchUpdateNativeStylesRequest, BatchUpdateNativeStylesResponse>
        batchUpdateNativeStylesSettings() {
      return getStubSettingsBuilder().batchUpdateNativeStylesSettings();
    }

    /** Returns the builder for the settings used for calls to batchActivateNativeStyles. */
    public UnaryCallSettings.Builder<
            BatchActivateNativeStylesRequest, BatchActivateNativeStylesResponse>
        batchActivateNativeStylesSettings() {
      return getStubSettingsBuilder().batchActivateNativeStylesSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeactivateNativeStyles. */
    public UnaryCallSettings.Builder<
            BatchDeactivateNativeStylesRequest, BatchDeactivateNativeStylesResponse>
        batchDeactivateNativeStylesSettings() {
      return getStubSettingsBuilder().batchDeactivateNativeStylesSettings();
    }

    /** Returns the builder for the settings used for calls to batchArchiveNativeStyles. */
    public UnaryCallSettings.Builder<
            BatchArchiveNativeStylesRequest, BatchArchiveNativeStylesResponse>
        batchArchiveNativeStylesSettings() {
      return getStubSettingsBuilder().batchArchiveNativeStylesSettings();
    }

    @Override
    public NativeStyleServiceSettings build() throws IOException {
      return new NativeStyleServiceSettings(this);
    }
  }
}
