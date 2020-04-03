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

import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupClient.ListGlobalNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupClient.ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse;

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
import com.google.cloud.compute.v1.stub.GlobalNetworkEndpointGroupStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link GlobalNetworkEndpointGroupClient}.
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
 * <p>For example, to set the total timeout of attachNetworkEndpointsGlobalNetworkEndpointGroup to
 * 30 seconds:
 *
 * <pre>
 * <code>
 * GlobalNetworkEndpointGroupSettings.Builder globalNetworkEndpointGroupSettingsBuilder =
 *     GlobalNetworkEndpointGroupSettings.newBuilder();
 * globalNetworkEndpointGroupSettingsBuilder
 *     .attachNetworkEndpointsGlobalNetworkEndpointGroupSettings()
 *     .setRetrySettings(
 *         globalNetworkEndpointGroupSettingsBuilder.attachNetworkEndpointsGlobalNetworkEndpointGroupSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GlobalNetworkEndpointGroupSettings globalNetworkEndpointGroupSettings = globalNetworkEndpointGroupSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class GlobalNetworkEndpointGroupSettings
    extends ClientSettings<GlobalNetworkEndpointGroupSettings> {
  /**
   * Returns the object with the settings used for calls to
   * attachNetworkEndpointsGlobalNetworkEndpointGroup.
   */
  public UnaryCallSettings<AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsGlobalNetworkEndpointGroupSettings() {
    return ((GlobalNetworkEndpointGroupStubSettings) getStubSettings())
        .attachNetworkEndpointsGlobalNetworkEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteGlobalNetworkEndpointGroup. */
  public UnaryCallSettings<DeleteGlobalNetworkEndpointGroupHttpRequest, Operation>
      deleteGlobalNetworkEndpointGroupSettings() {
    return ((GlobalNetworkEndpointGroupStubSettings) getStubSettings())
        .deleteGlobalNetworkEndpointGroupSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * detachNetworkEndpointsGlobalNetworkEndpointGroup.
   */
  public UnaryCallSettings<DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsGlobalNetworkEndpointGroupSettings() {
    return ((GlobalNetworkEndpointGroupStubSettings) getStubSettings())
        .detachNetworkEndpointsGlobalNetworkEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to getGlobalNetworkEndpointGroup. */
  public UnaryCallSettings<GetGlobalNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getGlobalNetworkEndpointGroupSettings() {
    return ((GlobalNetworkEndpointGroupStubSettings) getStubSettings())
        .getGlobalNetworkEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to insertGlobalNetworkEndpointGroup. */
  public UnaryCallSettings<InsertGlobalNetworkEndpointGroupHttpRequest, Operation>
      insertGlobalNetworkEndpointGroupSettings() {
    return ((GlobalNetworkEndpointGroupStubSettings) getStubSettings())
        .insertGlobalNetworkEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to listGlobalNetworkEndpointGroups. */
  public PagedCallSettings<
          ListGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          ListGlobalNetworkEndpointGroupsPagedResponse>
      listGlobalNetworkEndpointGroupsSettings() {
    return ((GlobalNetworkEndpointGroupStubSettings) getStubSettings())
        .listGlobalNetworkEndpointGroupsSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * listNetworkEndpointsGlobalNetworkEndpointGroups.
   */
  public PagedCallSettings<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointsGlobalNetworkEndpointGroupsSettings() {
    return ((GlobalNetworkEndpointGroupStubSettings) getStubSettings())
        .listNetworkEndpointsGlobalNetworkEndpointGroupsSettings();
  }

  public static final GlobalNetworkEndpointGroupSettings create(
      GlobalNetworkEndpointGroupStubSettings stub) throws IOException {
    return new GlobalNetworkEndpointGroupSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GlobalNetworkEndpointGroupStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GlobalNetworkEndpointGroupStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return GlobalNetworkEndpointGroupStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GlobalNetworkEndpointGroupStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GlobalNetworkEndpointGroupStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return GlobalNetworkEndpointGroupStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GlobalNetworkEndpointGroupStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GlobalNetworkEndpointGroupStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected GlobalNetworkEndpointGroupSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GlobalNetworkEndpointGroupSettings. */
  public static class Builder
      extends ClientSettings.Builder<GlobalNetworkEndpointGroupSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(GlobalNetworkEndpointGroupStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(GlobalNetworkEndpointGroupStubSettings.newBuilder());
    }

    protected Builder(GlobalNetworkEndpointGroupSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GlobalNetworkEndpointGroupStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public GlobalNetworkEndpointGroupStubSettings.Builder getStubSettingsBuilder() {
      return ((GlobalNetworkEndpointGroupStubSettings.Builder) getStubSettings());
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

    /**
     * Returns the builder for the settings used for calls to
     * attachNetworkEndpointsGlobalNetworkEndpointGroup.
     */
    public UnaryCallSettings.Builder<
            AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
        attachNetworkEndpointsGlobalNetworkEndpointGroupSettings() {
      return getStubSettingsBuilder().attachNetworkEndpointsGlobalNetworkEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGlobalNetworkEndpointGroup. */
    public UnaryCallSettings.Builder<DeleteGlobalNetworkEndpointGroupHttpRequest, Operation>
        deleteGlobalNetworkEndpointGroupSettings() {
      return getStubSettingsBuilder().deleteGlobalNetworkEndpointGroupSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * detachNetworkEndpointsGlobalNetworkEndpointGroup.
     */
    public UnaryCallSettings.Builder<
            DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
        detachNetworkEndpointsGlobalNetworkEndpointGroupSettings() {
      return getStubSettingsBuilder().detachNetworkEndpointsGlobalNetworkEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to getGlobalNetworkEndpointGroup. */
    public UnaryCallSettings.Builder<GetGlobalNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
        getGlobalNetworkEndpointGroupSettings() {
      return getStubSettingsBuilder().getGlobalNetworkEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to insertGlobalNetworkEndpointGroup. */
    public UnaryCallSettings.Builder<InsertGlobalNetworkEndpointGroupHttpRequest, Operation>
        insertGlobalNetworkEndpointGroupSettings() {
      return getStubSettingsBuilder().insertGlobalNetworkEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to listGlobalNetworkEndpointGroups. */
    public PagedCallSettings.Builder<
            ListGlobalNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupList,
            ListGlobalNetworkEndpointGroupsPagedResponse>
        listGlobalNetworkEndpointGroupsSettings() {
      return getStubSettingsBuilder().listGlobalNetworkEndpointGroupsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * listNetworkEndpointsGlobalNetworkEndpointGroups.
     */
    public PagedCallSettings.Builder<
            ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupsListNetworkEndpoints,
            ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse>
        listNetworkEndpointsGlobalNetworkEndpointGroupsSettings() {
      return getStubSettingsBuilder().listNetworkEndpointsGlobalNetworkEndpointGroupsSettings();
    }

    @Override
    public GlobalNetworkEndpointGroupSettings build() throws IOException {
      return new GlobalNetworkEndpointGroupSettings(this);
    }
  }
}
