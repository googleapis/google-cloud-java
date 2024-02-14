/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.kms.inventory.v1;

import static com.google.cloud.kms.inventory.v1.KeyTrackingServiceClient.SearchProtectedResourcesPagedResponse;

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
import com.google.cloud.kms.inventory.v1.stub.KeyTrackingServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link KeyTrackingServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (kmsinventory.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getProtectedResourcesSummary to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * KeyTrackingServiceSettings.Builder keyTrackingServiceSettingsBuilder =
 *     KeyTrackingServiceSettings.newBuilder();
 * keyTrackingServiceSettingsBuilder
 *     .getProtectedResourcesSummarySettings()
 *     .setRetrySettings(
 *         keyTrackingServiceSettingsBuilder
 *             .getProtectedResourcesSummarySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * KeyTrackingServiceSettings keyTrackingServiceSettings =
 *     keyTrackingServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class KeyTrackingServiceSettings extends ClientSettings<KeyTrackingServiceSettings> {

  /** Returns the object with the settings used for calls to getProtectedResourcesSummary. */
  public UnaryCallSettings<GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>
      getProtectedResourcesSummarySettings() {
    return ((KeyTrackingServiceStubSettings) getStubSettings())
        .getProtectedResourcesSummarySettings();
  }

  /** Returns the object with the settings used for calls to searchProtectedResources. */
  public PagedCallSettings<
          SearchProtectedResourcesRequest,
          SearchProtectedResourcesResponse,
          SearchProtectedResourcesPagedResponse>
      searchProtectedResourcesSettings() {
    return ((KeyTrackingServiceStubSettings) getStubSettings()).searchProtectedResourcesSettings();
  }

  public static final KeyTrackingServiceSettings create(KeyTrackingServiceStubSettings stub)
      throws IOException {
    return new KeyTrackingServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return KeyTrackingServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return KeyTrackingServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return KeyTrackingServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return KeyTrackingServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return KeyTrackingServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return KeyTrackingServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return KeyTrackingServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return KeyTrackingServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected KeyTrackingServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for KeyTrackingServiceSettings. */
  public static class Builder extends ClientSettings.Builder<KeyTrackingServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(KeyTrackingServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(KeyTrackingServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(KeyTrackingServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(KeyTrackingServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(KeyTrackingServiceStubSettings.newHttpJsonBuilder());
    }

    public KeyTrackingServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((KeyTrackingServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getProtectedResourcesSummary. */
    public UnaryCallSettings.Builder<GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>
        getProtectedResourcesSummarySettings() {
      return getStubSettingsBuilder().getProtectedResourcesSummarySettings();
    }

    /** Returns the builder for the settings used for calls to searchProtectedResources. */
    public PagedCallSettings.Builder<
            SearchProtectedResourcesRequest,
            SearchProtectedResourcesResponse,
            SearchProtectedResourcesPagedResponse>
        searchProtectedResourcesSettings() {
      return getStubSettingsBuilder().searchProtectedResourcesSettings();
    }

    @Override
    public KeyTrackingServiceSettings build() throws IOException {
      return new KeyTrackingServiceSettings(this);
    }
  }
}
