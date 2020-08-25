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

import static com.google.cloud.compute.v1.RegionNetworkEndpointGroupClient.ListRegionNetworkEndpointGroupsPagedResponse;

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
import com.google.cloud.compute.v1.stub.RegionNetworkEndpointGroupStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link RegionNetworkEndpointGroupClient}.
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
 * <p>For example, to set the total timeout of deleteRegionNetworkEndpointGroup to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionNetworkEndpointGroupSettings.Builder regionNetworkEndpointGroupSettingsBuilder =
 *     RegionNetworkEndpointGroupSettings.newBuilder();
 * regionNetworkEndpointGroupSettingsBuilder
 *     .deleteRegionNetworkEndpointGroupSettings()
 *     .setRetrySettings(
 *         regionNetworkEndpointGroupSettingsBuilder.deleteRegionNetworkEndpointGroupSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegionNetworkEndpointGroupSettings regionNetworkEndpointGroupSettings = regionNetworkEndpointGroupSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionNetworkEndpointGroupSettings
    extends ClientSettings<RegionNetworkEndpointGroupSettings> {
  /** Returns the object with the settings used for calls to deleteRegionNetworkEndpointGroup. */
  public UnaryCallSettings<DeleteRegionNetworkEndpointGroupHttpRequest, Operation>
      deleteRegionNetworkEndpointGroupSettings() {
    return ((RegionNetworkEndpointGroupStubSettings) getStubSettings())
        .deleteRegionNetworkEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to getRegionNetworkEndpointGroup. */
  public UnaryCallSettings<GetRegionNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getRegionNetworkEndpointGroupSettings() {
    return ((RegionNetworkEndpointGroupStubSettings) getStubSettings())
        .getRegionNetworkEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to insertRegionNetworkEndpointGroup. */
  public UnaryCallSettings<InsertRegionNetworkEndpointGroupHttpRequest, Operation>
      insertRegionNetworkEndpointGroupSettings() {
    return ((RegionNetworkEndpointGroupStubSettings) getStubSettings())
        .insertRegionNetworkEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to listRegionNetworkEndpointGroups. */
  public PagedCallSettings<
          ListRegionNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          ListRegionNetworkEndpointGroupsPagedResponse>
      listRegionNetworkEndpointGroupsSettings() {
    return ((RegionNetworkEndpointGroupStubSettings) getStubSettings())
        .listRegionNetworkEndpointGroupsSettings();
  }

  public static final RegionNetworkEndpointGroupSettings create(
      RegionNetworkEndpointGroupStubSettings stub) throws IOException {
    return new RegionNetworkEndpointGroupSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionNetworkEndpointGroupStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionNetworkEndpointGroupStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return RegionNetworkEndpointGroupStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionNetworkEndpointGroupStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionNetworkEndpointGroupStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionNetworkEndpointGroupStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionNetworkEndpointGroupStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionNetworkEndpointGroupStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionNetworkEndpointGroupSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionNetworkEndpointGroupSettings. */
  public static class Builder
      extends ClientSettings.Builder<RegionNetworkEndpointGroupSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(RegionNetworkEndpointGroupStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(RegionNetworkEndpointGroupStubSettings.newBuilder());
    }

    protected Builder(RegionNetworkEndpointGroupSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionNetworkEndpointGroupStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public RegionNetworkEndpointGroupStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionNetworkEndpointGroupStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteRegionNetworkEndpointGroup. */
    public UnaryCallSettings.Builder<DeleteRegionNetworkEndpointGroupHttpRequest, Operation>
        deleteRegionNetworkEndpointGroupSettings() {
      return getStubSettingsBuilder().deleteRegionNetworkEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to getRegionNetworkEndpointGroup. */
    public UnaryCallSettings.Builder<GetRegionNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
        getRegionNetworkEndpointGroupSettings() {
      return getStubSettingsBuilder().getRegionNetworkEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to insertRegionNetworkEndpointGroup. */
    public UnaryCallSettings.Builder<InsertRegionNetworkEndpointGroupHttpRequest, Operation>
        insertRegionNetworkEndpointGroupSettings() {
      return getStubSettingsBuilder().insertRegionNetworkEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to listRegionNetworkEndpointGroups. */
    public PagedCallSettings.Builder<
            ListRegionNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupList,
            ListRegionNetworkEndpointGroupsPagedResponse>
        listRegionNetworkEndpointGroupsSettings() {
      return getStubSettingsBuilder().listRegionNetworkEndpointGroupsSettings();
    }

    @Override
    public RegionNetworkEndpointGroupSettings build() throws IOException {
      return new RegionNetworkEndpointGroupSettings(this);
    }
  }
}
