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

import static com.google.ads.admanager.v1.ViewabilityProviderServiceClient.ListViewabilityProvidersPagedResponse;

import com.google.ads.admanager.v1.stub.ViewabilityProviderServiceStubSettings;
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
 * Settings class to configure an instance of {@link ViewabilityProviderServiceClient}.
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
 * of getViewabilityProvider:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ViewabilityProviderServiceSettings.Builder viewabilityProviderServiceSettingsBuilder =
 *     ViewabilityProviderServiceSettings.newBuilder();
 * viewabilityProviderServiceSettingsBuilder
 *     .getViewabilityProviderSettings()
 *     .setRetrySettings(
 *         viewabilityProviderServiceSettingsBuilder
 *             .getViewabilityProviderSettings()
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
 * ViewabilityProviderServiceSettings viewabilityProviderServiceSettings =
 *     viewabilityProviderServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ViewabilityProviderServiceSettings
    extends ClientSettings<ViewabilityProviderServiceSettings> {

  /** Returns the object with the settings used for calls to getViewabilityProvider. */
  public UnaryCallSettings<GetViewabilityProviderRequest, ViewabilityProvider>
      getViewabilityProviderSettings() {
    return ((ViewabilityProviderServiceStubSettings) getStubSettings())
        .getViewabilityProviderSettings();
  }

  /** Returns the object with the settings used for calls to listViewabilityProviders. */
  public PagedCallSettings<
          ListViewabilityProvidersRequest,
          ListViewabilityProvidersResponse,
          ListViewabilityProvidersPagedResponse>
      listViewabilityProvidersSettings() {
    return ((ViewabilityProviderServiceStubSettings) getStubSettings())
        .listViewabilityProvidersSettings();
  }

  /** Returns the object with the settings used for calls to createViewabilityProvider. */
  public UnaryCallSettings<CreateViewabilityProviderRequest, ViewabilityProvider>
      createViewabilityProviderSettings() {
    return ((ViewabilityProviderServiceStubSettings) getStubSettings())
        .createViewabilityProviderSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateViewabilityProviders. */
  public UnaryCallSettings<
          BatchCreateViewabilityProvidersRequest, BatchCreateViewabilityProvidersResponse>
      batchCreateViewabilityProvidersSettings() {
    return ((ViewabilityProviderServiceStubSettings) getStubSettings())
        .batchCreateViewabilityProvidersSettings();
  }

  /** Returns the object with the settings used for calls to updateViewabilityProvider. */
  public UnaryCallSettings<UpdateViewabilityProviderRequest, ViewabilityProvider>
      updateViewabilityProviderSettings() {
    return ((ViewabilityProviderServiceStubSettings) getStubSettings())
        .updateViewabilityProviderSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateViewabilityProviders. */
  public UnaryCallSettings<
          BatchUpdateViewabilityProvidersRequest, BatchUpdateViewabilityProvidersResponse>
      batchUpdateViewabilityProvidersSettings() {
    return ((ViewabilityProviderServiceStubSettings) getStubSettings())
        .batchUpdateViewabilityProvidersSettings();
  }

  public static final ViewabilityProviderServiceSettings create(
      ViewabilityProviderServiceStubSettings stub) throws IOException {
    return new ViewabilityProviderServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ViewabilityProviderServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ViewabilityProviderServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ViewabilityProviderServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ViewabilityProviderServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ViewabilityProviderServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ViewabilityProviderServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ViewabilityProviderServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ViewabilityProviderServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ViewabilityProviderServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ViewabilityProviderServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(ViewabilityProviderServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ViewabilityProviderServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ViewabilityProviderServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ViewabilityProviderServiceStubSettings.newBuilder());
    }

    public ViewabilityProviderServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ViewabilityProviderServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getViewabilityProvider. */
    public UnaryCallSettings.Builder<GetViewabilityProviderRequest, ViewabilityProvider>
        getViewabilityProviderSettings() {
      return getStubSettingsBuilder().getViewabilityProviderSettings();
    }

    /** Returns the builder for the settings used for calls to listViewabilityProviders. */
    public PagedCallSettings.Builder<
            ListViewabilityProvidersRequest,
            ListViewabilityProvidersResponse,
            ListViewabilityProvidersPagedResponse>
        listViewabilityProvidersSettings() {
      return getStubSettingsBuilder().listViewabilityProvidersSettings();
    }

    /** Returns the builder for the settings used for calls to createViewabilityProvider. */
    public UnaryCallSettings.Builder<CreateViewabilityProviderRequest, ViewabilityProvider>
        createViewabilityProviderSettings() {
      return getStubSettingsBuilder().createViewabilityProviderSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateViewabilityProviders. */
    public UnaryCallSettings.Builder<
            BatchCreateViewabilityProvidersRequest, BatchCreateViewabilityProvidersResponse>
        batchCreateViewabilityProvidersSettings() {
      return getStubSettingsBuilder().batchCreateViewabilityProvidersSettings();
    }

    /** Returns the builder for the settings used for calls to updateViewabilityProvider. */
    public UnaryCallSettings.Builder<UpdateViewabilityProviderRequest, ViewabilityProvider>
        updateViewabilityProviderSettings() {
      return getStubSettingsBuilder().updateViewabilityProviderSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateViewabilityProviders. */
    public UnaryCallSettings.Builder<
            BatchUpdateViewabilityProvidersRequest, BatchUpdateViewabilityProvidersResponse>
        batchUpdateViewabilityProvidersSettings() {
      return getStubSettingsBuilder().batchUpdateViewabilityProvidersSettings();
    }

    @Override
    public ViewabilityProviderServiceSettings build() throws IOException {
      return new ViewabilityProviderServiceSettings(this);
    }
  }
}
