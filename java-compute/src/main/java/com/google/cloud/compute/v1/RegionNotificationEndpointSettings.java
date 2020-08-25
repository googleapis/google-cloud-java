/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.RegionNotificationEndpointClient.ListRegionNotificationEndpointsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.RegionNotificationEndpointStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link RegionNotificationEndpointClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteRegionNotificationEndpoint to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionNotificationEndpointSettings.Builder regionNotificationEndpointSettingsBuilder =
 *     RegionNotificationEndpointSettings.newBuilder();
 * regionNotificationEndpointSettingsBuilder
 *     .deleteRegionNotificationEndpointSettings()
 *     .setRetrySettings(
 *         regionNotificationEndpointSettingsBuilder.deleteRegionNotificationEndpointSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegionNotificationEndpointSettings regionNotificationEndpointSettings = regionNotificationEndpointSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionNotificationEndpointSettings
    extends ClientSettings<RegionNotificationEndpointSettings> {
  /** Returns the object with the settings used for calls to deleteRegionNotificationEndpoint. */
  public UnaryCallSettings<DeleteRegionNotificationEndpointHttpRequest, Operation>
      deleteRegionNotificationEndpointSettings() {
    return ((RegionNotificationEndpointStubSettings) getStubSettings())
        .deleteRegionNotificationEndpointSettings();
  }

  /** Returns the object with the settings used for calls to getRegionNotificationEndpoint. */
  public UnaryCallSettings<GetRegionNotificationEndpointHttpRequest, NotificationEndpoint>
      getRegionNotificationEndpointSettings() {
    return ((RegionNotificationEndpointStubSettings) getStubSettings())
        .getRegionNotificationEndpointSettings();
  }

  /** Returns the object with the settings used for calls to insertRegionNotificationEndpoint. */
  public UnaryCallSettings<InsertRegionNotificationEndpointHttpRequest, Operation>
      insertRegionNotificationEndpointSettings() {
    return ((RegionNotificationEndpointStubSettings) getStubSettings())
        .insertRegionNotificationEndpointSettings();
  }

  /** Returns the object with the settings used for calls to listRegionNotificationEndpoints. */
  public PagedCallSettings<
          ListRegionNotificationEndpointsHttpRequest,
          NotificationEndpointList,
          ListRegionNotificationEndpointsPagedResponse>
      listRegionNotificationEndpointsSettings() {
    return ((RegionNotificationEndpointStubSettings) getStubSettings())
        .listRegionNotificationEndpointsSettings();
  }

  public static final RegionNotificationEndpointSettings create(
      RegionNotificationEndpointStubSettings stub) throws IOException {
    return new RegionNotificationEndpointSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionNotificationEndpointStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionNotificationEndpointStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return RegionNotificationEndpointStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionNotificationEndpointStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionNotificationEndpointStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionNotificationEndpointStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionNotificationEndpointStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionNotificationEndpointStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionNotificationEndpointSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionNotificationEndpointSettings. */
  public static class Builder
      extends ClientSettings.Builder<RegionNotificationEndpointSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(RegionNotificationEndpointStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(RegionNotificationEndpointStubSettings.newBuilder());
    }

    protected Builder(RegionNotificationEndpointSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionNotificationEndpointStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public RegionNotificationEndpointStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionNotificationEndpointStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to deleteRegionNotificationEndpoint. */
    public UnaryCallSettings.Builder<DeleteRegionNotificationEndpointHttpRequest, Operation>
        deleteRegionNotificationEndpointSettings() {
      return getStubSettingsBuilder().deleteRegionNotificationEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to getRegionNotificationEndpoint. */
    public UnaryCallSettings.Builder<GetRegionNotificationEndpointHttpRequest, NotificationEndpoint>
        getRegionNotificationEndpointSettings() {
      return getStubSettingsBuilder().getRegionNotificationEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to insertRegionNotificationEndpoint. */
    public UnaryCallSettings.Builder<InsertRegionNotificationEndpointHttpRequest, Operation>
        insertRegionNotificationEndpointSettings() {
      return getStubSettingsBuilder().insertRegionNotificationEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to listRegionNotificationEndpoints. */
    public PagedCallSettings.Builder<
            ListRegionNotificationEndpointsHttpRequest,
            NotificationEndpointList,
            ListRegionNotificationEndpointsPagedResponse>
        listRegionNotificationEndpointsSettings() {
      return getStubSettingsBuilder().listRegionNotificationEndpointsSettings();
    }

    @Override
    public RegionNotificationEndpointSettings build() throws IOException {
      return new RegionNotificationEndpointSettings(this);
    }
  }
}
