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

import static com.google.ads.admanager.v1.CreativeSetServiceClient.ListCreativeSetsPagedResponse;

import com.google.ads.admanager.v1.stub.CreativeSetServiceStubSettings;
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
 * Settings class to configure an instance of {@link CreativeSetServiceClient}.
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
 * of getCreativeSet:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CreativeSetServiceSettings.Builder creativeSetServiceSettingsBuilder =
 *     CreativeSetServiceSettings.newBuilder();
 * creativeSetServiceSettingsBuilder
 *     .getCreativeSetSettings()
 *     .setRetrySettings(
 *         creativeSetServiceSettingsBuilder
 *             .getCreativeSetSettings()
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
 * CreativeSetServiceSettings creativeSetServiceSettings =
 *     creativeSetServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class CreativeSetServiceSettings extends ClientSettings<CreativeSetServiceSettings> {

  /** Returns the object with the settings used for calls to getCreativeSet. */
  public UnaryCallSettings<GetCreativeSetRequest, CreativeSet> getCreativeSetSettings() {
    return ((CreativeSetServiceStubSettings) getStubSettings()).getCreativeSetSettings();
  }

  /** Returns the object with the settings used for calls to listCreativeSets. */
  public PagedCallSettings<
          ListCreativeSetsRequest, ListCreativeSetsResponse, ListCreativeSetsPagedResponse>
      listCreativeSetsSettings() {
    return ((CreativeSetServiceStubSettings) getStubSettings()).listCreativeSetsSettings();
  }

  /** Returns the object with the settings used for calls to createCreativeSet. */
  public UnaryCallSettings<CreateCreativeSetRequest, CreativeSet> createCreativeSetSettings() {
    return ((CreativeSetServiceStubSettings) getStubSettings()).createCreativeSetSettings();
  }

  /** Returns the object with the settings used for calls to updateCreativeSet. */
  public UnaryCallSettings<UpdateCreativeSetRequest, CreativeSet> updateCreativeSetSettings() {
    return ((CreativeSetServiceStubSettings) getStubSettings()).updateCreativeSetSettings();
  }

  public static final CreativeSetServiceSettings create(CreativeSetServiceStubSettings stub)
      throws IOException {
    return new CreativeSetServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CreativeSetServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CreativeSetServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CreativeSetServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CreativeSetServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CreativeSetServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CreativeSetServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CreativeSetServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CreativeSetServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CreativeSetServiceSettings. */
  public static class Builder extends ClientSettings.Builder<CreativeSetServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(CreativeSetServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(CreativeSetServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CreativeSetServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CreativeSetServiceStubSettings.newBuilder());
    }

    public CreativeSetServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((CreativeSetServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getCreativeSet. */
    public UnaryCallSettings.Builder<GetCreativeSetRequest, CreativeSet> getCreativeSetSettings() {
      return getStubSettingsBuilder().getCreativeSetSettings();
    }

    /** Returns the builder for the settings used for calls to listCreativeSets. */
    public PagedCallSettings.Builder<
            ListCreativeSetsRequest, ListCreativeSetsResponse, ListCreativeSetsPagedResponse>
        listCreativeSetsSettings() {
      return getStubSettingsBuilder().listCreativeSetsSettings();
    }

    /** Returns the builder for the settings used for calls to createCreativeSet. */
    public UnaryCallSettings.Builder<CreateCreativeSetRequest, CreativeSet>
        createCreativeSetSettings() {
      return getStubSettingsBuilder().createCreativeSetSettings();
    }

    /** Returns the builder for the settings used for calls to updateCreativeSet. */
    public UnaryCallSettings.Builder<UpdateCreativeSetRequest, CreativeSet>
        updateCreativeSetSettings() {
      return getStubSettingsBuilder().updateCreativeSetSettings();
    }

    @Override
    public CreativeSetServiceSettings build() throws IOException {
      return new CreativeSetServiceSettings(this);
    }
  }
}
